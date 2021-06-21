package model.gateway;

import model.base.BaseModel;
import model.merchant.Merchant;

import java.math.BigDecimal;

public class Gateway{

    private int id;
    private String name;
    private Currency currency;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private BigDecimal comissionUp;
    private BigDecimal comissionDowmn;
    private int merchantId;

    private Boolean isUcell;
    private Boolean isBeeline;
    private Boolean isWebmoney;
    private Boolean isQiwi;

    public BigDecimal getComissionUp() {
        return comissionUp;
    }

    public void setComissionUp(BigDecimal comissionUp) {
        this.comissionUp = comissionUp;
    }

    public BigDecimal getComissionDowmn() {
        return comissionDowmn;
    }

    public void setComissionDowmn(BigDecimal comissionDowmn) {
        this.comissionDowmn = comissionDowmn;
    }

    public Gateway(int id, String name, Currency currency, BigDecimal minAmount, BigDecimal maxAmount) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public Gateway(int id, String name, Currency currency, BigDecimal minAmount, BigDecimal maxAmount, BigDecimal comissionUp, BigDecimal comissionDowmn, int merchantId) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.comissionUp = comissionUp;
        this.comissionDowmn = comissionDowmn;
        this.merchantId = merchantId;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public Boolean getUcell() {
        return this.id == 1000;
    }

    public Boolean getBeeline() {
        return this.id == 100;
    }

    public Boolean getWebmoney() {
        return this.id == 95;
    }

    public Boolean getQiwi() {
        return this.id == 96;
    }
}
