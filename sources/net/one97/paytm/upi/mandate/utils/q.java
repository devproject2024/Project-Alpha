package net.one97.paytm.upi.mandate.utils;

public enum q {
    ON(0, "ON"),
    BEFORE(1, "BEFORE"),
    AFTER(2, "AFTER");
    
    private final int index;
    private final String value;

    private q(int i2, String str) {
        this.index = i2;
        this.value = str;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getValue() {
        return this.value;
    }
}
