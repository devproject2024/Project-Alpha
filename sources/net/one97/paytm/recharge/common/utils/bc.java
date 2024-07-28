package net.one97.paytm.recharge.common.utils;

import com.paytm.network.model.NetworkCustomError;

public class bc extends NetworkCustomError {
    private final NetworkCustomError error;

    public bc(NetworkCustomError networkCustomError) {
        this.error = networkCustomError;
    }

    public final NetworkCustomError getError() {
        return this.error;
    }
}
