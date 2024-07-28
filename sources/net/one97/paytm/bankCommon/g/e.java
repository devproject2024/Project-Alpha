package net.one97.paytm.bankCommon.g;

import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import kotlin.g.b.k;

public final class e extends NetworkCustomError {
    private NetworkCustomError networkCustomError;
    private g.a okListener;

    public e(NetworkCustomError networkCustomError2) {
        k.c(networkCustomError2, "networkCustomError");
        this.networkCustomError = networkCustomError2;
    }

    public final NetworkCustomError getNetworkCustomError() {
        return this.networkCustomError;
    }

    public final void setNetworkCustomError(NetworkCustomError networkCustomError2) {
        k.c(networkCustomError2, "<set-?>");
        this.networkCustomError = networkCustomError2;
    }

    public final g.a getOkListener() {
        return this.okListener;
    }

    public final void setOkListener(g.a aVar) {
        this.okListener = aVar;
    }
}
