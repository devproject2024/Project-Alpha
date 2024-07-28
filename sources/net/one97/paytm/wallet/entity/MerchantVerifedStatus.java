package net.one97.paytm.wallet.entity;

public enum MerchantVerifedStatus {
    MERCHANT_VERIFED(1),
    MERCHANT_UNVERIFED(2),
    MERCHANT_NO_STATUS(3);
    
    private int status;

    private MerchantVerifedStatus(int i2) {
        this.status = i2;
    }
}
