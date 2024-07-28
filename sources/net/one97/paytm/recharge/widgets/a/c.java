package net.one97.paytm.recharge.widgets.a;

import androidx.lifecycle.z;
import kotlin.g.b.k;

public final class c<T> implements z<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f64962a;

    /* renamed from: b  reason: collision with root package name */
    private final net.one97.paytm.recharge.widgets.b.c<T> f64963b;

    public c(String str, net.one97.paytm.recharge.widgets.b.c<T> cVar) {
        k.c(str, "tag");
        k.c(cVar, "listener");
        this.f64962a = str;
        this.f64963b = cVar;
    }

    public final void onChanged(T t) {
        this.f64963b.a(this.f64962a, t);
    }
}
