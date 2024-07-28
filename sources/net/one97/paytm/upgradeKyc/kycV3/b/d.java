package net.one97.paytm.upgradeKyc.kycV3.b;

public enum d {
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
