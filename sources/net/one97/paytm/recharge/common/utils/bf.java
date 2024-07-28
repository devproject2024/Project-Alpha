package net.one97.paytm.recharge.common.utils;

import kotlin.g.a.b;
import kotlin.g.b.k;

public class bf<T, A> {

    /* renamed from: a  reason: collision with root package name */
    private b<? super A, ? extends T> f61592a;

    /* renamed from: b  reason: collision with root package name */
    private volatile T f61593b;

    public bf(b<? super A, ? extends T> bVar) {
        k.c(bVar, "creator");
        this.f61592a = bVar;
    }

    public final T a(A a2) {
        T t;
        T t2 = this.f61593b;
        if (t2 != null) {
            return t2;
        }
        synchronized (this) {
            t = this.f61593b;
            if (t == null) {
                b bVar = this.f61592a;
                if (bVar == null) {
                    k.a();
                }
                t = bVar.invoke(a2);
                this.f61593b = t;
                this.f61592a = null;
            }
        }
        return t;
    }
}
