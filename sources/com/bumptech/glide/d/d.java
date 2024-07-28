package com.bumptech.glide.d;

import androidx.a.a;
import com.bumptech.glide.g.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final a<i, List<Class<?>>> f6495a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<i> f6496b = new AtomicReference<>();

    public final List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.f6496b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f6495a) {
            list = this.f6495a.get(andSet);
        }
        this.f6496b.set(andSet);
        return list;
    }
}
