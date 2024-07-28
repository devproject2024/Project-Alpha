package net.one97.paytm.common.entity.paymentsbank;

public enum AccountStatus {
    DEFAULT(0),
    NOT_APPLIED(1),
    PROCESSING(2),
    ISSUED(3);
    
    private int numVal;

    private AccountStatus(int i2) {
        this.numVal = i2;
    }

    public final int getNumVal() {
        return this.numVal;
    }
}
