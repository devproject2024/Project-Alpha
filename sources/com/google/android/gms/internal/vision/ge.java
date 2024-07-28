package com.google.android.gms.internal.vision;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class ge {

    /* renamed from: a  reason: collision with root package name */
    private static final ge f11169a = new ge();

    /* renamed from: b  reason: collision with root package name */
    private final gl f11170b = new ff();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, gi<?>> f11171c = new ConcurrentHashMap();

    public static ge a() {
        return f11169a;
    }

    public final <T> gi<T> a(Class<T> cls) {
        ek.a(cls, "messageType");
        gi<T> giVar = (gi) this.f11171c.get(cls);
        if (giVar != null) {
            return giVar;
        }
        gi<T> a2 = this.f11170b.a(cls);
        ek.a(cls, "messageType");
        ek.a(a2, "schema");
        gi<T> putIfAbsent = this.f11171c.putIfAbsent(cls, a2);
        return putIfAbsent != null ? putIfAbsent : a2;
    }

    public final <T> gi<T> a(T t) {
        return a(t.getClass());
    }

    private ge() {
    }
}
