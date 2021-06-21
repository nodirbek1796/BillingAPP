package response;

import model.transaction.Transaction;

public class PayResponse implements BasePayResponse{

    @Override
    public boolean success(Transaction transaction) {
        System.out.println("Transaction is success");
        return true;
    }

    @Override
    public boolean error(Transaction transaction) {
        System.out.println("Transaction is not success");
        return false;
    }
}
