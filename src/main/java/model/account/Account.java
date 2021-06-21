package model.account;

import model.base.BaseModel;

import java.math.BigDecimal;
import java.util.UUID;

public class Account extends BaseModel {

    private BigDecimal balance;
    private Integer gatewayId;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(Integer gatewayId) {
        this.gatewayId = gatewayId;
    }
}
