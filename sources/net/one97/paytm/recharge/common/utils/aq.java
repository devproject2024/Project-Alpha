package net.one97.paytm.recharge.common.utils;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class aq extends NetworkCustomError {
    private final NetworkCustomError error;
    private final String mobileNumber;

    public aq(NetworkCustomError networkCustomError, String str) {
        k.c(str, "mobileNumber");
        this.error = networkCustomError;
        this.mobileNumber = str;
    }

    public final NetworkCustomError getError() {
        return this.error;
    }

    public final String getMobileNumber() {
        return this.mobileNumber;
    }
}
