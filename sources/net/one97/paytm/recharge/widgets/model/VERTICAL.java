package net.one97.paytm.recharge.widgets.model;

public enum VERTICAL {
    RECHARGES("rechargeAndUtilities"),
    UTILITIES("rechargeAndUtilities");
    
    private final String value;

    private VERTICAL(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
