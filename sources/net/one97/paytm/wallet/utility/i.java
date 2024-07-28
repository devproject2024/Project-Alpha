package net.one97.paytm.wallet.utility;

public enum i {
    UPI_NOT_CALLED(-1),
    UPI_SUCCESS(1),
    UPI_FAIL(0),
    UPI_SUCCESS_NO_RESULT(2),
    UPI_ALREADY_PRESENT(3),
    UPI_NOT_PRESENT_IN_DEVICE(4);
    
    int value;

    private i(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
