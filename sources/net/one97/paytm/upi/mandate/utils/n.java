package net.one97.paytm.upi.mandate.utils;

public enum n {
    RECURRING(0),
    ONE_TIME(1);
    
    private final int index;

    private n(int i2) {
        this.index = i2;
    }

    public final int getIndex() {
        return this.index;
    }
}
