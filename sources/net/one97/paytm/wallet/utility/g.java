package net.one97.paytm.wallet.utility;

public enum g {
    PAY_METHOD_NOT_CALLED(-1),
    PAY_METHOD_SUCCESS(1),
    PAY_METHOD_FAIL(0),
    PAY_METHOD_NOT_CALLED_ADD_PAY(-1),
    PAY_METHOD_SUCCESS_ADD_PAY(1),
    PAY_METHOD_FAIL_ADD_PAY(0);
    
    int value;

    private g(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
