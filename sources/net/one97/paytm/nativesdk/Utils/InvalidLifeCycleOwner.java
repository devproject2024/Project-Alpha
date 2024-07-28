package net.one97.paytm.nativesdk.Utils;

import kotlin.g.b.k;

public final class InvalidLifeCycleOwner extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidLifeCycleOwner(String str) {
        super(str);
        k.c(str, "message");
    }
}
