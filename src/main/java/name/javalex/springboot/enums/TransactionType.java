package name.javalex.springboot.enums;

public enum TransactionType {
    BALANCE(1),
    WITHDRAWAL(2),
    INCOME(3),
    OTHER(4);

    private final int code;

    private TransactionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
