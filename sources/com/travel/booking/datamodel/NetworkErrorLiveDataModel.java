package com.travel.booking.datamodel;

import com.paytm.network.model.NetworkCustomError;

public final class NetworkErrorLiveDataModel {
    private NetworkCustomError error;
    private int errorCode;

    public NetworkErrorLiveDataModel(int i2, NetworkCustomError networkCustomError) {
        this.errorCode = i2;
        this.error = networkCustomError;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public final NetworkCustomError getError() {
        return this.error;
    }

    public final void setError(NetworkCustomError networkCustomError) {
        this.error = networkCustomError;
    }
}
