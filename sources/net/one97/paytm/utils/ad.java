package net.one97.paytm.utils;

public enum ad {
    AMOUNT_NOT_ENTERED(1),
    EMI_OUT_OF_RANGE(2),
    EMI_AVAILABLE(3);
    

    /* renamed from: i  reason: collision with root package name */
    private int f69601i;

    private ad(int i2) {
        this.f69601i = i2;
    }

    public final int getEMIAvailability() {
        return this.f69601i;
    }
}
