package net.one97.paytm.quickpay.utilities;

public enum f {
    UPI("vpa"),
    IMPS("bank_account"),
    WALLET("wallet");
    
    private String payMode;

    private f(String str) {
        this.payMode = str;
    }

    public final String getPayMode() {
        return this.payMode;
    }
}
