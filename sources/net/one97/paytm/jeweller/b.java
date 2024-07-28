package net.one97.paytm.jeweller;

public enum b {
    JEWELLER_NOT_CALLED(-1),
    JEWELLER_SUCCESS(1),
    JEWELLER_FAIL(0),
    JEWELLER_DISPLAYED(2);
    
    int value;

    private b(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
