package net.one97.paytm.recharge.common.utils;

import com.paytm.network.model.NetworkCustomError;

public final class bd extends bc {
    private final NetworkCustomError walletError;

    public bd(NetworkCustomError networkCustomError) {
        super(networkCustomError);
        this.walletError = networkCustomError;
    }

    public final NetworkCustomError getWalletError() {
        return this.walletError;
    }
}
