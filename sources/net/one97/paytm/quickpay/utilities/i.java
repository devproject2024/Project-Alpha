package net.one97.paytm.quickpay.utilities;

public enum i {
    ACTIVATE("ACTIVE"),
    DEACTIVATE("DEACTIVATED");
    
    private String status;

    private i(String str) {
        this.status = str;
    }

    public final String getStatus() {
        return this.status;
    }
}
