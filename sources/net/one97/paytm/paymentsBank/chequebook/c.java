package net.one97.paytm.paymentsBank.chequebook;

public enum c {
    SUCCESS,
    ERROR,
    LOADING;

    public final boolean isSuccessful() {
        return this == SUCCESS;
    }

    public final boolean isLoading() {
        return this == LOADING;
    }
}
