package com.squareup.b;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    final f f16089a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<? extends g>, h<? extends g>> f16090b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<? extends Object>, Object<? extends Object>> f16091c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<? extends j>, b<? extends j>> f16092d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<? extends g>, a<? extends g>> f16093e;

    public n(Class<?>... clsArr) {
        this((List<Class<?>>) Arrays.asList(clsArr));
    }

    private n(List<Class<?>> list) {
        this.f16090b = new LinkedHashMap();
        this.f16091c = new LinkedHashMap();
        this.f16092d = new LinkedHashMap();
        this.f16093e = new LinkedHashMap();
        this.f16089a = new f();
        for (Class<?> declaredFields : list) {
            for (Field field : declaredFields.getDeclaredFields()) {
                if (field.getType().equals(d.class)) {
                    try {
                        d dVar = (d) field.get((Object) null);
                        f fVar = this.f16089a;
                        Class<T> cls = dVar.f16046a;
                        Map map = fVar.f16055a.get(cls);
                        Map map2 = fVar.f16056b.get(cls);
                        if (map == null) {
                            map = new LinkedHashMap();
                            map2 = new LinkedHashMap();
                            fVar.f16055a.put(cls, map);
                            fVar.f16056b.put(cls, map2);
                        }
                        map.put(Integer.valueOf(dVar.f16050e), dVar);
                        map2.put(dVar.f16049d, dVar);
                    } catch (IllegalAccessException e2) {
                        throw new AssertionError(e2);
                    }
                }
            }
        }
    }

    public final synchronized <M extends g> h<M> a(Class<M> cls) {
        h<M> hVar;
        hVar = this.f16090b.get(cls);
        if (hVar == null) {
            hVar = new h<>(this, cls);
            this.f16090b.put(cls, hVar);
        }
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized <T extends g> a<T> b(Class<T> cls) {
        a<T> aVar;
        aVar = this.f16093e.get(cls);
        if (aVar == null) {
            aVar = new a<>(cls);
            this.f16093e.put(cls, aVar);
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized <E extends j> b<E> c(Class<E> cls) {
        b<E> bVar;
        bVar = this.f16092d.get(cls);
        if (bVar == null) {
            bVar = new b<>(cls);
            this.f16092d.put(cls, bVar);
        }
        return bVar;
    }
}
