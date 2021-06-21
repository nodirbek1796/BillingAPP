package model.gateway;

public enum Currency {

    RUB("RUBL", 643),
    EURO("EUR",978),
    SUM("SUM",860),
    USD("USD",840);


    Currency(String code, Integer number) {
        this.code = code;
        this.number = number;
    }

    private String code;
    private Integer number;

    public String getCode() {
        return code;
    }

    public Integer getNumber() {
        return number;
    }
}
