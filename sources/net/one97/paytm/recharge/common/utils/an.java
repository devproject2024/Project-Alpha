package net.one97.paytm.recharge.common.utils;

import com.paytm.network.model.NetworkCustomError;

public final class an extends NetworkCustomError {
    private final NetworkCustomError error;

    public an(NetworkCustomError networkCustomError) {
        this.error = networkCustomError;
    }

    public final NetworkCustomError getError() {
        return this.error;
    }
}
