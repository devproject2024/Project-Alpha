package net.one97.paytm.recharge.common.utils;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.g;

public final class as extends NetworkCustomError {
    private final boolean isFrontEndError;

    public as() {
        this(false, 1, (g) null);
    }

    public as(boolean z) {
        this.isFrontEndError = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ as(boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? false : z);
    }

    public final boolean isFrontEndError() {
        return this.isFrontEndError;
    }
}
