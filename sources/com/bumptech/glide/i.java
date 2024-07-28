package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.b.c;
import com.bumptech.glide.b.d;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.n;
import com.bumptech.glide.b.p;
import com.bumptech.glide.e.g;
import com.bumptech.glide.e.h;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.j;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i implements ComponentCallbacks2, com.bumptech.glide.b.i {

    /* renamed from: e  reason: collision with root package name */
    private static final h f6662e;

    /* renamed from: f  reason: collision with root package name */
    private static final h f6663f;

    /* renamed from: g  reason: collision with root package name */
    private static final h f6664g = ((h) ((h) h.b(j.f6877c).a(f.LOW)).a(true));

    /* renamed from: a  reason: collision with root package name */
    protected final b f6665a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f6666b;

    /* renamed from: c  reason: collision with root package name */
    final com.bumptech.glide.b.h f6667c;

    /* renamed from: d  reason: collision with root package name */
    final CopyOnWriteArrayList<g<Object>> f6668d;

    /* renamed from: h  reason: collision with root package name */
    private final n f6669h;

    /* renamed from: i  reason: collision with root package name */
    private final m f6670i;
    private final p j;
    private final Runnable k;
    private final Handler l;
    private final c m;
    private h n;
    private boolean o;

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    static {
        h a2 = h.a(Bitmap.class);
        a2.v = true;
        f6662e = a2;
        h a3 = h.a(com.bumptech.glide.load.d.e.c.class);
        a3.v = true;
        f6663f = a3;
    }

    public i(b bVar, com.bumptech.glide.b.h hVar, m mVar, Context context) {
        this(bVar, hVar, mVar, new n(), bVar.f6430f, context);
    }

    private i(b bVar, com.bumptech.glide.b.h hVar, m mVar, n nVar, d dVar, Context context) {
        this.j = new p();
        this.k = new Runnable() {
            public final void run() {
                i.this.f6667c.a(i.this);
            }
        };
        this.l = new Handler(Looper.getMainLooper());
        this.f6665a = bVar;
        this.f6667c = hVar;
        this.f6670i = mVar;
        this.f6669h = nVar;
        this.f6666b = context;
        this.m = dVar.a(context.getApplicationContext(), new a(nVar));
        if (k.d()) {
            this.l.post(this.k);
        } else {
            hVar.a(this);
        }
        hVar.a(this.m);
        this.f6668d = new CopyOnWriteArrayList<>(bVar.f6426b.f6482d);
        b(bVar.f6426b.a());
        synchronized (bVar.f6431g) {
            if (!bVar.f6431g.contains(this)) {
                bVar.f6431g.add(this);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    private synchronized void b(h hVar) {
        h hVar2 = (h) hVar.clone();
        if (hVar2.v) {
            if (!hVar2.x) {
                throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            }
        }
        hVar2.x = true;
        hVar2.v = true;
        this.n = hVar2;
    }

    public final synchronized i a(h hVar) {
        b(hVar);
        return this;
    }

    private synchronized void h() {
        n nVar = this.f6669h;
        nVar.f6459c = true;
        for (T t : k.a(nVar.f6457a)) {
            if (t.d()) {
                t.c();
                nVar.f6458b.add(t);
            }
        }
    }

    private synchronized void i() {
        n nVar = this.f6669h;
        nVar.f6459c = true;
        for (T t : k.a(nVar.f6457a)) {
            if (t.d() || t.e()) {
                t.b();
                nVar.f6458b.add(t);
            }
        }
    }

    private synchronized void j() {
        i();
        for (i i2 : this.f6670i.a()) {
            i2.i();
        }
    }

    private synchronized void k() {
        n nVar = this.f6669h;
        nVar.f6459c = false;
        for (T t : k.a(nVar.f6457a)) {
            if (!t.e() && !t.d()) {
                t.a();
            }
        }
        nVar.f6458b.clear();
    }

    public final synchronized void a() {
        k();
        this.j.a();
    }

    public final synchronized void b() {
        h();
        this.j.b();
    }

    public final synchronized void c() {
        this.j.c();
        for (T a2 : k.a(this.j.f6467a)) {
            a((com.bumptech.glide.e.a.j<?>) a2);
        }
        this.j.f6467a.clear();
        n nVar = this.f6669h;
        for (T a3 : k.a(nVar.f6457a)) {
            nVar.a(a3);
        }
        nVar.f6458b.clear();
        this.f6667c.b(this);
        this.f6667c.b(this.m);
        this.l.removeCallbacks(this.k);
        b bVar = this.f6665a;
        synchronized (bVar.f6431g) {
            if (bVar.f6431g.contains(this)) {
                bVar.f6431g.remove(this);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public final h<Bitmap> d() {
        return b(Bitmap.class).b((com.bumptech.glide.e.a<?>) f6662e);
    }

    public final h<com.bumptech.glide.load.d.e.c> e() {
        return b(com.bumptech.glide.load.d.e.c.class).b((com.bumptech.glide.e.a<?>) f6663f);
    }

    public final h<Drawable> f() {
        return b(Drawable.class);
    }

    private <ResourceType> h<ResourceType> b(Class<ResourceType> cls) {
        return new h<>(this.f6665a, this, cls, this.f6666b);
    }

    public final void a(com.bumptech.glide.e.a.j<?> jVar) {
        if (jVar != null) {
            c(jVar);
        }
    }

    private void c(com.bumptech.glide.e.a.j<?> jVar) {
        boolean b2 = b(jVar);
        com.bumptech.glide.e.d d2 = jVar.d();
        if (!b2 && !this.f6665a.a(jVar) && d2 != null) {
            jVar.a((com.bumptech.glide.e.d) null);
            d2.b();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean b(com.bumptech.glide.e.a.j<?> jVar) {
        com.bumptech.glide.e.d d2 = jVar.d();
        if (d2 == null) {
            return true;
        }
        if (!this.f6669h.a(d2)) {
            return false;
        }
        this.j.f6467a.remove(jVar);
        jVar.a((com.bumptech.glide.e.d) null);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(com.bumptech.glide.e.a.j<?> jVar, com.bumptech.glide.e.d dVar) {
        this.j.f6467a.add(jVar);
        n nVar = this.f6669h;
        nVar.f6457a.add(dVar);
        if (!nVar.f6459c) {
            dVar.a();
            return;
        }
        dVar.b();
        Log.isLoggable("RequestTracker", 2);
        nVar.f6458b.add(dVar);
    }

    /* access modifiers changed from: package-private */
    public final synchronized h g() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public final <T> j<?, T> a(Class<T> cls) {
        d dVar = this.f6665a.f6426b;
        j<?, T> jVar = dVar.f6483e.get(cls);
        if (jVar == null) {
            for (Map.Entry next : dVar.f6483e.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    jVar = (j) next.getValue();
                }
            }
        }
        return jVar == null ? d.f6479a : jVar;
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f6669h + ", treeNode=" + this.f6670i + "}";
    }

    public final void onTrimMemory(int i2) {
        if (i2 == 60 && this.o) {
            j();
        }
    }

    class a implements c.a {

        /* renamed from: b  reason: collision with root package name */
        private final n f6673b;

        a(n nVar) {
            this.f6673b = nVar;
        }

        public final void a(boolean z) {
            if (z) {
                synchronized (i.this) {
                    n nVar = this.f6673b;
                    for (T t : k.a(nVar.f6457a)) {
                        if (!t.e() && !t.f()) {
                            t.b();
                            if (!nVar.f6459c) {
                                t.a();
                            } else {
                                nVar.f6458b.add(t);
                            }
                        }
                    }
                }
            }
        }
    }

    public final h<Drawable> a(Drawable drawable) {
        return b(Drawable.class).a(drawable);
    }

    public final h<Drawable> a(String str) {
        return b(Drawable.class).b((Object) str);
    }

    public final h<Drawable> a(Uri uri) {
        return b(Drawable.class).b((Object) uri);
    }

    public final h<Drawable> a(Integer num) {
        return b(Drawable.class).a(num);
    }

    public final h<Drawable> a(Object obj) {
        return b(Drawable.class).b(obj);
    }
}
