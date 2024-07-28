package com.google.android.gms.internal.firebase_ml;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class ib {

    /* renamed from: a  reason: collision with root package name */
    private static final ib f9981a = new ib();

    /* renamed from: b  reason: collision with root package name */
    private final ij f9982b = new he();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, ig<?>> f9983c = new ConcurrentHashMap();

    public static ib a() {
        return f9981a;
    }

    public final <T> ig<T> a(Class<T> cls) {
        gk.a(cls, "messageType");
        ig<T> igVar = (ig) this.f9983c.get(cls);
        if (igVar != null) {
            return igVar;
        }
        ig<T> a2 = this.f9982b.a(cls);
        gk.a(cls, "messageType");
        gk.a(a2, "schema");
        ig<T> putIfAbsent = this.f9983c.putIfAbsent(cls, a2);
        return putIfAbsent != null ? putIfAbsent : a2;
    }

    public final <T> ig<T> a(T t) {
        return a(t.getClass());
    }

    private ib() {
    }
}
