package net.one97.paytm.addmoney.utils;

public enum o {
    P2P("p2p"),
    P2B("p2b"),
    P2M("p2m"),
    LOGIN("login");
    
    private String value;

    private o(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
