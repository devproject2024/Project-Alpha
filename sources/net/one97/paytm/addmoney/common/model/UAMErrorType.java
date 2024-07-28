package net.one97.paytm.addmoney.common.model;

public enum UAMErrorType {
    NO_ERROR(0),
    AMOUNTNULL(1),
    VALID_AMOUNT(2),
    MORE_THAN_AVAILABLE(3),
    INVALID_AMOUNT(4),
    PLEASE_WAIT(5),
    INSUFFICIENT_BALANCE(6),
    WALLET_LIMIT_BREACH(7);
    
    private int numVal;

    private UAMErrorType(int i2) {
        this.numVal = i2;
    }

    public final int getNumVal() {
        return this.numVal;
    }
}
