package net.one97.paytm.recharge.automatic.b.a;

public enum b {
    ENABLED(1),
    DISABLED(0),
    DELETE(-1),
    PROCESSING(6);
    
    private final int status;

    private b(int i2) {
        this.status = i2;
    }

    public final int getStatus() {
        return this.status;
    }
}
