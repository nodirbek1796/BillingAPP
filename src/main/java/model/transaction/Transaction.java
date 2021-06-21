package model.transaction;

import model.base.BaseModel;
import model.gateway.Currency;
import model.gateway.Gateway;
import model.merchant.Merchant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.UUID;

public class Transaction extends BaseModel {

    private String transactionAccount;
    private BigDecimal transactionAmount;
    private BigDecimal transactionAmountCurrency;
    private int statedId;
    private Gateway gateway;
    private Merchant merchant;
    private Date createdDate;
    private Date transactionDate;

    private boolean isChecked = false;
    private boolean isSuccess = false;
    private boolean isInprocessing = false;

    public Transaction() {
    }

    public Transaction(
            String name,
            String transactionAccount,
            BigDecimal transactionAmount,
            BigDecimal transactionAmountCurrency,
            int statedId,
            Gateway gateway,
            Merchant merchant,
            Date createdDate,
            Date transactionDate,
            TransactionState transactionState
    ) {
        super(name);
        this.transactionAccount = transactionAccount;
        this.transactionAmount = transactionAmount;
        this.transactionAmountCurrency = transactionAmountCurrency;
        this.statedId = statedId;
        this.gateway = gateway;
        this.merchant = merchant;
        this.createdDate = createdDate;
        this.transactionDate = transactionDate;
    }

    public String getTransactionAccount() {
        return transactionAccount;
    }

    public void setTransactionAccount(String transactionAccount) {
        this.transactionAccount = transactionAccount;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getTransactionAmountCurrency() {
        return transactionAmountCurrency;
    }

    public void setTransactionAmountCurrency(BigDecimal transactionAmountCurrency) {
        this.transactionAmountCurrency = transactionAmountCurrency;
    }

    public int getStatedId() {
        return statedId;
    }

    public void setStatedId(int statedId) {
        this.statedId = statedId;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isChecked() {
        return statedId == TransactionState.CHECKED.getValue();
    }

    public boolean isSuccess() {
        return statedId == TransactionState.SUCCESS.getValue();
    }

    public boolean isInprocessing() {
        return statedId == TransactionState.IN_PROCESS.getValue();
    }

    public void getAmountCurrency(Gateway gateway){
        BigDecimal amountInCurrency = this.transactionAmount.subtract(transactionAmount.multiply(gateway.getComissionDowmn().divide(BigDecimal.valueOf(100)))).setScale(2,RoundingMode.HALF_DOWN);
        switch (gateway.getCurrency().getCode()){
            case "USD": amountInCurrency = amountInCurrency.divide(BigDecimal.valueOf(10500.00)).setScale(2, RoundingMode.HALF_DOWN); break;
            case "RUBL": amountInCurrency = amountInCurrency.divide(BigDecimal.valueOf(141.00),2,RoundingMode.HALF_DOWN); break;
            case "SUM": amountInCurrency = amountInCurrency.setScale(2,RoundingMode.HALF_DOWN); break;

        }
        this.transactionAmountCurrency = amountInCurrency;
    }

    public String getState(){
        String responseText = "";
        switch (statedId){
            case 1: responseText = "created"; break;
            case 2: responseText = "checked"; break;
            case 3: responseText = "check_error"; break;
            case 4: responseText = "paying"; break;
            case 5: responseText = "in_process"; break;
            case 6: responseText = "pay_success"; break;
            default: return "";
        }
        return responseText;
    }
}
