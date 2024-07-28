package com.google.android.gms.internal.clearcut;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class cz {

    /* renamed from: a  reason: collision with root package name */
    private static final cz f9262a = new cz();

    /* renamed from: b  reason: collision with root package name */
    private final df f9263b;

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, de<?>> f9264c = new ConcurrentHashMap();

    private cz() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        df dfVar = null;
        for (int i2 = 0; i2 <= 0; i2++) {
            dfVar = a(strArr[0]);
            if (dfVar != null) {
                break;
            }
        }
        this.f9263b = dfVar == null ? new cb() : dfVar;
    }

    public static cz a() {
        return f9262a;
    }

    private static df a(String str) {
        try {
            return (df) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> de<T> a(Class<T> cls) {
        bh.a(cls, "messageType");
        de<T> deVar = (de) this.f9264c.get(cls);
        if (deVar != null) {
            return deVar;
        }
        de<T> a2 = this.f9263b.a(cls);
        bh.a(cls, "messageType");
        bh.a(a2, "schema");
        de<T> putIfAbsent = this.f9264c.putIfAbsent(cls, a2);
        return putIfAbsent != null ? putIfAbsent : a2;
    }

    public final <T> de<T> a(T t) {
        return a(t.getClass());
    }
}
