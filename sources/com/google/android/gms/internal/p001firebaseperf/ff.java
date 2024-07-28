package com.google.android.gms.internal.p001firebaseperf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.ff  reason: invalid package */
final class ff<T> implements fp<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ex f9622a;

    /* renamed from: b  reason: collision with root package name */
    private final gg<?, ?> f9623b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9624c;

    /* renamed from: d  reason: collision with root package name */
    private final dh<?> f9625d;

    private ff(gg<?, ?> ggVar, dh<?> dhVar, ex exVar) {
        this.f9623b = ggVar;
        this.f9624c = dhVar.a(exVar);
        this.f9625d = dhVar;
        this.f9622a = exVar;
    }

    static <T> ff<T> a(gg<?, ?> ggVar, dh<?> dhVar, ex exVar) {
        return new ff<>(ggVar, dhVar, exVar);
    }

    public final boolean a(T t, T t2) {
        if (!this.f9623b.a(t).equals(this.f9623b.a(t2))) {
            return false;
        }
        if (this.f9624c) {
            return this.f9625d.a((Object) t).equals(this.f9625d.a((Object) t2));
        }
        return true;
    }

    public final int a(T t) {
        int hashCode = this.f9623b.a(t).hashCode();
        return this.f9624c ? (hashCode * 53) + this.f9625d.a((Object) t).hashCode() : hashCode;
    }

    public final void b(T t, T t2) {
        fr.a(this.f9623b, t, t2);
        if (this.f9624c) {
            fr.a(this.f9625d, t, t2);
        }
    }

    public final void a(T t, ha haVar) throws IOException {
        Iterator<Map.Entry<?, Object>> c2 = this.f9625d.a((Object) t).c();
        while (c2.hasNext()) {
            Map.Entry next = c2.next();
            dk dkVar = (dk) next.getKey();
            if (dkVar.c() != gx.MESSAGE || dkVar.d() || dkVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof ef) {
                haVar.a(dkVar.a(), (Object) ((ef) next).f9587a.getValue().c());
            } else {
                haVar.a(dkVar.a(), next.getValue());
            }
        }
        gg<?, ?> ggVar = this.f9623b;
        ggVar.b(ggVar.a(t), haVar);
    }

    public final void c(T t) {
        this.f9623b.b(t);
        this.f9625d.c(t);
    }

    public final boolean d(T t) {
        return this.f9625d.a((Object) t).d();
    }

    public final int b(T t) {
        gg<?, ?> ggVar = this.f9623b;
        int c2 = ggVar.c(ggVar.a(t)) + 0;
        if (!this.f9624c) {
            return c2;
        }
        di<?> a2 = this.f9625d.a((Object) t);
        int i2 = 0;
        for (int i3 = 0; i3 < a2.f9555a.b(); i3++) {
            i2 += di.b(a2.f9555a.b(i3));
        }
        for (Map.Entry<FieldDescriptorType, Object> b2 : a2.f9555a.c()) {
            i2 += di.b(b2);
        }
        return c2 + i2;
    }
}
