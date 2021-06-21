package model.transaction;

public enum TransactionState {

    CREATED(1),
    CHECKED(2),
    CHECK_ERROR(3),
    PAYING(4),
    IN_PROCESS(5),
    SUCCESS(6),
    PAY_ERROR(7);

    TransactionState(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
