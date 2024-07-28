package com.google.android.gms.internal.icing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class dq {

    /* renamed from: a  reason: collision with root package name */
    private static final dq f10170a = new dq();

    /* renamed from: b  reason: collision with root package name */
    private final du f10171b = new ct();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, dr<?>> f10172c = new ConcurrentHashMap();

    public static dq a() {
        return f10170a;
    }

    public final <T> dr<T> a(Class<T> cls) {
        bx.a(cls, "messageType");
        dr<T> drVar = (dr) this.f10172c.get(cls);
        if (drVar != null) {
            return drVar;
        }
        dr<T> a2 = this.f10171b.a(cls);
        bx.a(cls, "messageType");
        bx.a(a2, "schema");
        dr<T> putIfAbsent = this.f10172c.putIfAbsent(cls, a2);
        return putIfAbsent != null ? putIfAbsent : a2;
    }

    public final <T> dr<T> a(T t) {
        return a(t.getClass());
    }

    private dq() {
    }
}
