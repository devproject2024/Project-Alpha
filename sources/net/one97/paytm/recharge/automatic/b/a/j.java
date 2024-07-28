package net.one97.paytm.recharge.automatic.b.a;

public enum j {
    ENABLED(1),
    DISABLED(0),
    DELETED(-1);
    
    private final int status;

    private j(int i2) {
        this.status = i2;
    }

    public final int getStatus() {
        return this.status;
    }
}
