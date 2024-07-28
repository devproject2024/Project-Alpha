package net.one97.paytm.upi.mandate.utils;

public enum v {
    PAUSE("PAUSE"),
    RESUME("UNPAUSE"),
    CANCEL("REVOKE"),
    UPDATE("UPDATE");
    
    private final String value;

    private v(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
