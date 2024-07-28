package com.bumptech.glide.d;

import androidx.a.a;
import androidx.core.g.e;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.b.t;
import com.bumptech.glide.load.d.f.g;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final t<?, ?, ?> f6492a = new t(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), (e.a<List<Throwable>>) null)), (e.a<List<Throwable>>) null);

    /* renamed from: b  reason: collision with root package name */
    public final a<com.bumptech.glide.g.i, t<?, ?, ?>> f6493b = new a<>();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<com.bumptech.glide.g.i> f6494c = new AtomicReference<>();

    public static boolean a(t<?, ?, ?> tVar) {
        return f6492a.equals(tVar);
    }

    public final <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        t<Data, TResource, Transcode> tVar;
        com.bumptech.glide.g.i andSet = this.f6494c.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.g.i();
        }
        andSet.a(cls, cls2, cls3);
        synchronized (this.f6493b) {
            tVar = this.f6493b.get(andSet);
        }
        this.f6494c.set(andSet);
        return tVar;
    }
}
