package com.paytm.notification.data.a;

import kotlin.g.b.k;

public final class a extends Exception {
    public a() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Throwable th) {
        super(th);
        k.c(th, "cause");
    }
}
