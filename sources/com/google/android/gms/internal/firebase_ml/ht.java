package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class ht<T> implements ig<T> {

    /* renamed from: a  reason: collision with root package name */
    private final hn f9972a;

    /* renamed from: b  reason: collision with root package name */
    private final ix<?, ?> f9973b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9974c;

    /* renamed from: d  reason: collision with root package name */
    private final fy<?> f9975d;

    private ht(ix<?, ?> ixVar, fy<?> fyVar, hn hnVar) {
        this.f9973b = ixVar;
        this.f9974c = fyVar.a(hnVar);
        this.f9975d = fyVar;
        this.f9972a = hnVar;
    }

    static <T> ht<T> a(ix<?, ?> ixVar, fy<?> fyVar, hn hnVar) {
        return new ht<>(ixVar, fyVar, hnVar);
    }

    public final boolean a(T t, T t2) {
        if (!this.f9973b.a(t).equals(this.f9973b.a(t2))) {
            return false;
        }
        if (this.f9974c) {
            return this.f9975d.a((Object) t).equals(this.f9975d.a((Object) t2));
        }
        return true;
    }

    public final int a(T t) {
        int hashCode = this.f9973b.a(t).hashCode();
        return this.f9974c ? (hashCode * 53) + this.f9975d.a((Object) t).hashCode() : hashCode;
    }

    public final void b(T t, T t2) {
        ii.a(this.f9973b, t, t2);
        if (this.f9974c) {
            ii.a(this.f9975d, t, t2);
        }
    }

    public final void a(T t, s sVar) throws IOException {
        Iterator<Map.Entry<?, Object>> c2 = this.f9975d.a((Object) t).c();
        while (c2.hasNext()) {
            Map.Entry next = c2.next();
            gb gbVar = (gb) next.getKey();
            if (gbVar.c() != q.MESSAGE || gbVar.d() || gbVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof gv) {
                sVar.a(gbVar.a(), (Object) ((gv) next).f9941a.getValue().c());
            } else {
                sVar.a(gbVar.a(), next.getValue());
            }
        }
        ix<?, ?> ixVar = this.f9973b;
        ixVar.b(ixVar.a(t), sVar);
    }

    public final void c(T t) {
        this.f9973b.b(t);
        this.f9975d.c(t);
    }

    public final boolean d(T t) {
        return this.f9975d.a((Object) t).d();
    }

    public final int b(T t) {
        ix<?, ?> ixVar = this.f9973b;
        int c2 = ixVar.c(ixVar.a(t)) + 0;
        if (!this.f9974c) {
            return c2;
        }
        fz<?> a2 = this.f9975d.a((Object) t);
        int i2 = 0;
        for (int i3 = 0; i3 < a2.f9908a.b(); i3++) {
            i2 += fz.b(a2.f9908a.b(i3));
        }
        for (Map.Entry<T, Object> b2 : a2.f9908a.c()) {
            i2 += fz.b(b2);
        }
        return c2 + i2;
    }
}
