package com.google.android.gms.internal.p001firebaseperf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.fk  reason: invalid package */
final class fk {

    /* renamed from: a  reason: collision with root package name */
    private static final fk f9628a = new fk();

    /* renamed from: b  reason: collision with root package name */
    private final fo f9629b = new eo();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, fp<?>> f9630c = new ConcurrentHashMap();

    public static fk a() {
        return f9628a;
    }

    public final <T> fp<T> a(Class<T> cls) {
        dt.a(cls, "messageType");
        fp<T> fpVar = (fp) this.f9630c.get(cls);
        if (fpVar != null) {
            return fpVar;
        }
        fp<T> a2 = this.f9629b.a(cls);
        dt.a(cls, "messageType");
        dt.a(a2, "schema");
        fp<T> putIfAbsent = this.f9630c.putIfAbsent(cls, a2);
        return putIfAbsent != null ? putIfAbsent : a2;
    }

    public final <T> fp<T> a(T t) {
        return a(t.getClass());
    }

    private fk() {
    }
}
