package com.bumptech.glide.d;

import com.bumptech.glide.load.l;
import java.util.ArrayList;
import java.util.List;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f6502a = new ArrayList();

    public final synchronized <Z> void a(Class<Z> cls, l<Z> lVar) {
        this.f6502a.add(new a(cls, lVar));
    }

    public final synchronized <Z> l<Z> a(Class<Z> cls) {
        int size = this.f6502a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f6502a.get(i2);
            if (aVar.f6503a.isAssignableFrom(cls)) {
                return aVar.f6504b;
            }
        }
        return null;
    }

    static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final Class<T> f6503a;

        /* renamed from: b  reason: collision with root package name */
        final l<T> f6504b;

        a(Class<T> cls, l<T> lVar) {
            this.f6503a = cls;
            this.f6504b = lVar;
        }
    }
}
