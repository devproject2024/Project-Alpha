package net.one97.paytm.addmoney.common.model;

public enum SourceCardType {
    NO_CARD(0),
    BHIM_UPI(1),
    DEBIT_CARD(2),
    WALLET(3),
    FD(4),
    OTHER_BANKS(5),
    GOLD(6),
    NET_BANKING(7),
    CREDIT_CARD(8),
    PPB(9),
    PAYMENT_ITEM_TYPE_UPI(10),
    PAYMENT_ITEM_TYPE_DC(11),
    PAYMENT_ITEM_TYPE_CC(12);
    
    private int numVal;

    private SourceCardType(int i2) {
        this.numVal = i2;
    }

    public final int getNumVal() {
        return this.numVal;
    }
}
