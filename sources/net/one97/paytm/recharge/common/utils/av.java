package net.one97.paytm.recharge.common.utils;

import kotlin.g.b.g;

public final class av extends c {
    private final boolean isFrontEndError;

    public av() {
        this(false, 1, (g) null);
    }

    public av(boolean z) {
        this.isFrontEndError = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ av(boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? false : z);
    }

    public final boolean isFrontEndError() {
        return this.isFrontEndError;
    }
}
