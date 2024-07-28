package com.paytm.notification.a.a;

import kotlin.g.b.k;

public final class a extends IllegalStateException {
    public a() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super(str);
        k.c(str, "message");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Throwable th) {
        super(th);
        k.c(th, "cause");
    }
}
