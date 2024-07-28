package net.one97.paytm.common.utility;

public enum j {
    GENERIC("LINK_BASED_PAYMENT"),
    FIXED("LINK_BASED_PAYMENT"),
    INVOICE("LINK_BASED_PAYMENT_INVOICE");
    
    private String linkType;

    private j(String str) {
        this.linkType = str;
    }

    public final String getLinkType() {
        return this.linkType;
    }
}
