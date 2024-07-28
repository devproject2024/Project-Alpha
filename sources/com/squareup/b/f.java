package com.squareup.b;

import java.util.LinkedHashMap;
import java.util.Map;

final class f {

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<? extends c>, Map<Integer, d<?, ?>>> f16055a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<Class<? extends c>, Map<String, d<?, ?>>> f16056b = new LinkedHashMap();

    f() {
    }

    public final <T extends c<?>, E> d<T, E> a(Class<T> cls, int i2) {
        Map map = this.f16055a.get(cls);
        if (map == null) {
            return null;
        }
        return (d) map.get(Integer.valueOf(i2));
    }
}
