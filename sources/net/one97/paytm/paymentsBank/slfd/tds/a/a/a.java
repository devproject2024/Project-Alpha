package net.one97.paytm.paymentsBank.slfd.tds.a.a;

public enum a {
    TDS_CERTIFICATE(3),
    INTEREST_CERTIFICATE(1);
    
    private int numberOfEditText;

    private a(int i2) {
        this.numberOfEditText = i2;
    }

    public final int getNumberOfEditText() {
        return this.numberOfEditText;
    }

    public final void setNumberOfEditText(int i2) {
        this.numberOfEditText = i2;
    }
}
