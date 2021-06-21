package model.receive;

import java.util.UUID;

public class DefaultPayReceiveModel {

    private UUID transactionId;

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public boolean isFull(){
        return transactionId != null;
    }
}
