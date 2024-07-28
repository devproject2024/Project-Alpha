package net.one97.paytm.upi.mandate.utils;

public enum d {
    APPROVE("APPROVE"),
    DECLINE("DECLINE");
    
    private final String type;

    private d(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
