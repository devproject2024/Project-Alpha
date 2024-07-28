package net.one97.paytm.wallet.rateMerchant.a;

public enum b {
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
