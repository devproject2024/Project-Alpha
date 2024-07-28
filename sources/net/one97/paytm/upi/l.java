package net.one97.paytm.upi;

public enum l {
    SUCCESS,
    ERROR,
    LOADING,
    AUTHENTICATION_FAILURE,
    ABORTED;

    public final boolean isSuccessful() {
        return this == SUCCESS;
    }

    public final boolean isLoading() {
        return this == LOADING;
    }
}
