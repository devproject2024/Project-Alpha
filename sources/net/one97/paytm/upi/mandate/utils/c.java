package net.one97.paytm.upi.mandate.utils;

public enum c {
    PENDING("PENDING"),
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE");
    
    private final String type;

    private c(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
