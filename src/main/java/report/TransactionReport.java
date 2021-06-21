package report;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class TransactionReport {

    public static void getTransactionReport() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet workbookSheet = workbook.createSheet("pdp bootcamp9");

        String arr[] = {"id", "account", "amount", "amount_in_currency", "state_id", "gateway", "merchant", "created_date", "transaction_date"};

        HSSFRow row = workbookSheet.createRow(0);
        for (int i = 0; i < arr.length; i++) {
            row.createCell(i).setCellValue(arr[i]);
        }

        try {
            File file = new File("./report");
            file.mkdirs();
            File file1 = new File(file,"transactions.xls");
            file1.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream("./report/transactions.xls");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
