package net.one97.paytm.addmoney.utils;

public enum m {
    NEARBY_CASH_POINT(0),
    NEARBY_BANKING_POINT(1);
    
    private final int identifier;

    private m(int i2) {
        this.identifier = i2;
    }

    public final int getIdentifier() {
        return this.identifier;
    }
}
