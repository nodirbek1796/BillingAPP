package response;

import model.transaction.Transaction;
import model.transaction.TransactionState;

import java.util.Date;

public class CheckResponse implements BaseCheckResponse{

    @Override
    public boolean success(Transaction transaction) {
        transaction.setStatedId(TransactionState.CHECKED.getValue());
        transaction.setTransactionDate(new Date());
        System.out.println("TRANSACTION IS CHECKED");


        return true;
    }

    @Override
    public boolean error(Transaction transaction) {
        transaction.setStatedId(TransactionState.CHECK_ERROR.getValue());
        transaction.setTransactionDate(new Date());
        System.out.println("TRANSACTION IS NOT CHECKED");
        return false;
    }
}
