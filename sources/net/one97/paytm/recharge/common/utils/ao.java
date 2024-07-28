package net.one97.paytm.recharge.common.utils;

import com.paytm.network.model.NetworkCustomError;

public final class ao extends NetworkCustomError {
    private final NetworkCustomError error;

    public ao(NetworkCustomError networkCustomError) {
        this.error = networkCustomError;
    }

    public final NetworkCustomError getError() {
        return this.error;
    }
}
