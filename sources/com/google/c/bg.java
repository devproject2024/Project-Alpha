package com.google.c;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class bg {

    /* renamed from: a  reason: collision with root package name */
    private static final bg f37750a = new bg();

    /* renamed from: b  reason: collision with root package name */
    private final bn f37751b = new al();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, bm<?>> f37752c = new ConcurrentHashMap();

    public static bg a() {
        return f37750a;
    }

    public final <T> bm<T> a(Class<T> cls) {
        ac.a(cls, "messageType");
        bm<T> bmVar = (bm) this.f37752c.get(cls);
        if (bmVar != null) {
            return bmVar;
        }
        bm<T> a2 = this.f37751b.a(cls);
        bm<?> a3 = a(cls, a2);
        return a3 != null ? a3 : a2;
    }

    public final <T> bm<T> a(T t) {
        return a(t.getClass());
    }

    private bm<?> a(Class<?> cls, bm<?> bmVar) {
        ac.a(cls, "messageType");
        ac.a(bmVar, "schema");
        return this.f37752c.putIfAbsent(cls, bmVar);
    }

    private bg() {
    }
}
