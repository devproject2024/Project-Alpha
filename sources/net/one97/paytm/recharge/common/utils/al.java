package net.one97.paytm.recharge.common.utils;

import com.paytm.network.model.NetworkCustomError;

public final class al extends NetworkCustomError {
    private final NetworkCustomError error;

    public al(NetworkCustomError networkCustomError) {
        this.error = networkCustomError;
    }

    public final NetworkCustomError getError() {
        return this.error;
    }
}
