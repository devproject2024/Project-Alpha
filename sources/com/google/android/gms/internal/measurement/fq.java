package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class fq {

    /* renamed from: a  reason: collision with root package name */
    private static final fq f10658a = new fq();

    /* renamed from: b  reason: collision with root package name */
    private final fy f10659b = new es();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, fv<?>> f10660c = new ConcurrentHashMap();

    public static fq a() {
        return f10658a;
    }

    public final <T> fv<T> a(Class<T> cls) {
        dx.a(cls, "messageType");
        fv<T> fvVar = (fv) this.f10660c.get(cls);
        if (fvVar != null) {
            return fvVar;
        }
        fv<T> a2 = this.f10659b.a(cls);
        dx.a(cls, "messageType");
        dx.a(a2, "schema");
        fv<T> putIfAbsent = this.f10660c.putIfAbsent(cls, a2);
        return putIfAbsent != null ? putIfAbsent : a2;
    }

    public final <T> fv<T> a(T t) {
        return a(t.getClass());
    }

    private fq() {
    }
}
