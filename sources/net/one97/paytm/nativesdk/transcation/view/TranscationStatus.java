package net.one97.paytm.nativesdk.transcation.view;

public enum TranscationStatus {
    TXN_SUCCESS(1),
    TXN_FAILURE(2),
    PENDING(3),
    UNKNOWN(4);
    
    private int status;

    private TranscationStatus(int i2) {
        this.status = i2;
    }

    public final int getStatus() {
        return this.status;
    }
}
