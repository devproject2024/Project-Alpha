package net.one97.paytm.upi.common;

public enum QuickPayModeEnum {
    UPI("vpa"),
    IMPS("bank_account"),
    WALLET("wallet");
    
    private String payMode;

    private QuickPayModeEnum(String str) {
        this.payMode = str;
    }

    public final String getPayMode() {
        return this.payMode;
    }
}
