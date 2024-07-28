package com.bumptech.glide.b;

import com.bumptech.glide.e.a.j;
import com.bumptech.glide.g.k;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class p implements i {

    /* renamed from: a  reason: collision with root package name */
    public final Set<j<?>> f6467a = Collections.newSetFromMap(new WeakHashMap());

    public final void a() {
        for (T a2 : k.a(this.f6467a)) {
            a2.a();
        }
    }

    public final void b() {
        for (T b2 : k.a(this.f6467a)) {
            b2.b();
        }
    }

    public final void c() {
        for (T c2 : k.a(this.f6467a)) {
            c2.c();
        }
    }
}
