package model.merchant;

import java.math.BigDecimal;

public class Merchant {

    private int id;
    private String name;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private Boolean isInActive;

    public Merchant(){

    }

    public Merchant(int id, String name, BigDecimal minAmount, BigDecimal maxAmount, Boolean isInActive) {
        this.id = id;
        this.name = name;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.isInActive = isInActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Boolean getInActive() {
        return isInActive;
    }

    public void setInActive(Boolean inActive) {
        isInActive = inActive;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                ", isInActive=" + isInActive +
                '}';
    }
}
