package model.receive;

import java.math.BigDecimal;

public class DefaultReceiveModel {

    private String clientAccount = null;
    private int serviceId = 0;
    private BigDecimal amount;

    public DefaultReceiveModel(String clientAccount, int serviceId, BigDecimal amount) {
        this.clientAccount = clientAccount;
        this.serviceId = serviceId;
        this.amount = amount;
    }

    private boolean isFull;

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isFull() {
        return clientAccount != null && serviceId != 0;
    }

}
