package com.bumptech.glide.load.d.f;

import java.util.ArrayList;
import java.util.List;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f7251a = new ArrayList();

    public final synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f7251a.add(new a(cls, cls2, eVar));
    }

    public final synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a next : this.f7251a) {
            if (next.a(cls, cls2)) {
                return next.f7252a;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public final synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> a2 : this.f7251a) {
            if (a2.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        final e<Z, R> f7252a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<Z> f7253b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<R> f7254c;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f7253b = cls;
            this.f7254c = cls2;
            this.f7252a = eVar;
        }

        public final boolean a(Class<?> cls, Class<?> cls2) {
            return this.f7253b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f7254c);
        }
    }
}
