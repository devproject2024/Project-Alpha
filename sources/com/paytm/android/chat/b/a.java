package com.paytm.android.chat.b;

import kotlin.g.b.k;
import kotlin.m.p;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public c f41773a = new c(true, true, true);

    /* renamed from: b  reason: collision with root package name */
    public final String f41774b;

    public a(String str) {
        k.c(str, "variant");
        this.f41774b = str;
        if (p.a(this.f41774b, "P4B", true)) {
            this.f41773a = new c(false, false, false);
        } else {
            this.f41773a = new c(true, true, true);
        }
    }
}
