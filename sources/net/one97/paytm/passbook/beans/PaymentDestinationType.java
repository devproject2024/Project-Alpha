package net.one97.paytm.passbook.beans;

public enum PaymentDestinationType {
    NO_CARD(0),
    TO_PAYTM_BANK(1),
    TO_WALLET(2),
    TO_GIFT_VOUCHER(3);
    
    private int numVal;

    private PaymentDestinationType(int i2) {
        this.numVal = i2;
    }

    public final int getNumVal() {
        return this.numVal;
    }
}
