package net.one97.paytm.addmoney.common.model;

public enum DebitCardViewType {
    NO_VIEW(0),
    NEW_CARD_NUMBER(1),
    NEW_CVV(2),
    NEW_EXPIRY(3),
    NEW_CARD_IMAGE(4),
    RADIO_OTP_NEW_CARD(5),
    RADIO_ATM_NEW_CARD(6);
    
    private int numVal;

    private DebitCardViewType(int i2) {
        this.numVal = i2;
    }

    public final int getNumVal() {
        return this.numVal;
    }
}
