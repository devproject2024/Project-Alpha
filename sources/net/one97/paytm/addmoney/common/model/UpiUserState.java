package net.one97.paytm.addmoney.common.model;

public enum UpiUserState {
    DEFAULT(0),
    NO_UPI_USER(1),
    NO_ACCOUNT_LINKED(2),
    VALID_UPI_USER(3);
    
    private int numVal;

    private UpiUserState(int i2) {
        this.numVal = i2;
    }

    public final int getNumVal() {
        return this.numVal;
    }
}
