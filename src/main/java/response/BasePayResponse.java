package response;

import model.transaction.Transaction;

import java.text.SimpleDateFormat;

public interface BasePayResponse{
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSS");

    default void payResponse(
            Transaction transaction,
            Boolean transactionError
    ){
        if (transactionError)
            error(transaction);
        else
            success(transaction);
    }

    boolean success(Transaction transaction);

    boolean error(Transaction transaction);
}
