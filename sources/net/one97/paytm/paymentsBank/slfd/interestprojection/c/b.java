package net.one97.paytm.paymentsBank.slfd.interestprojection.c;

public enum b {
    STATUS_SUCCESS(1182),
    STATUS_PENDING(1183),
    STATUS_FAILED(1184),
    STATUS_SUCCESS_FAILED(1186),
    STATUS_SUCCESS_PENDING(1185);
    
    int code;

    private b(int i2) {
        this.code = i2;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i2) {
        this.code = i2;
    }
}
