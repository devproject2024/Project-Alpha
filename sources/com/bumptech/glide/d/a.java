package com.bumptech.glide.d;

import com.bumptech.glide.load.d;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0087a<?>> f6488a = new ArrayList();

    public final synchronized <T> d<T> a(Class<T> cls) {
        for (C0087a next : this.f6488a) {
            if (next.f6489a.isAssignableFrom(cls)) {
                return next.f6490b;
            }
        }
        return null;
    }

    public final synchronized <T> void a(Class<T> cls, d<T> dVar) {
        this.f6488a.add(new C0087a(cls, dVar));
    }

    /* renamed from: com.bumptech.glide.d.a$a  reason: collision with other inner class name */
    static final class C0087a<T> {

        /* renamed from: a  reason: collision with root package name */
        final Class<T> f6489a;

        /* renamed from: b  reason: collision with root package name */
        final d<T> f6490b;

        C0087a(Class<T> cls, d<T> dVar) {
            this.f6489a = cls;
            this.f6490b = dVar;
        }
    }
}
