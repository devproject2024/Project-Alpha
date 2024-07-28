package net.one97.paytm.utils;

public enum a {
    DEFAULT(0),
    NOT_APPLIED(1),
    PROCESSING(2),
    ISSUED(3);
    
    private int numVal;

    private a(int i2) {
        this.numVal = i2;
    }

    public final int getNumVal() {
        return this.numVal;
    }
}
