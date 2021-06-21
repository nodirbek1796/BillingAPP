package model.payment;

import model.base.BaseModel;

import java.math.BigDecimal;
import java.util.UUID;

public class Payment extends BaseModel {

    private UUID sourceCardId;
    private BigDecimal transferAmount;
    private String transactionAccount;


    public Payment() {
    }

    public Payment(String name, UUID sourceCardId, BigDecimal transferAmount, String transactionAccount) {
        super(name);
        this.sourceCardId = sourceCardId;
        this.transferAmount = transferAmount;
        this.transactionAccount = transactionAccount;
    }

    public UUID getSourceCardId() {
        return sourceCardId;
    }

    public void setSourceCardId(UUID sourceCardId) {
        this.sourceCardId = sourceCardId;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getTransactionAccount() {
        return transactionAccount;
    }

    public void setTransactionAccount(String transactionAccount) {
        this.transactionAccount = transactionAccount;
    }
}
