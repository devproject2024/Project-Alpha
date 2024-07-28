package net.one97.paytm.upi.mandate.utils;

public enum m {
    RECURRING("SUBSCRIPTION"),
    ONE_TIME("OTM"),
    ASBA("ASBA");
    
    private final String bankFilterType;

    private m(String str) {
        this.bankFilterType = str;
    }

    public final String getBankFilterType() {
        return this.bankFilterType;
    }
}
