package net.one97.paytm.upi.mandate.utils;

public enum p {
    MONTHLY(0, "MONTHLY"),
    DAILY(1, "DAILY"),
    WEEKLY(2, "WEEKLY"),
    FORTNIGHTLY(3, "FORTNIGHTLY"),
    BIMONTHLY(4, "BIMONTHLY"),
    QUARTERLY(5, "QUARTERLY"),
    HALF_YEARLY(6, "HALFYEARLY"),
    YEARLY(7, "YEARLY");
    
    private final int index;
    private final String value;

    private p(int i2, String str) {
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
