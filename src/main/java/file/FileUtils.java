package file;

import com.google.gson.Gson;
import model.authorization.User;
import model.card.Card;
import model.receive.DefaultReceiveModel;
import model.transaction.Transaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH");
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void save(
            Card card
    ){
        try{
            Gson gson = new Gson();
            Date date = new Date();
            String directUrl = "./" + simpleDateFormat.format(date);
            String fileUrl = "/" + simpleDateFormat1.format(date) + ".log";

            File file = new File(directUrl);
            file.mkdirs();

            File file1 = new File(file, fileUrl);
            file1.createNewFile();

            FileWriter fileWriter = new FileWriter((directUrl + fileUrl),true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(gson.toJson(card) + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (Exception e){
            System.out.println("File bilan ishlashda muammo!");
        }
    }

    public static void save(
            Transaction transaction
    ){
        try{
            Gson gson = new Gson();
            Date date = new Date();
            String directUrl = "./transaction" + simpleDateFormat.format(date);
            String fileUrl = simpleDateFormat1.format(date) + ".log";

            File file = new File(directUrl);
            file.mkdirs();

            File file1 = new File(file, fileUrl);
            file1.createNewFile();

            FileWriter fileWriter = new FileWriter((directUrl + fileUrl),true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(gson.toJson(transaction) + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (Exception e){
            System.out.println("File bilan ishlashda muammo!");
        }
    }
}
