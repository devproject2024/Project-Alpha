package com.bumptech.glide.load.b;

import com.bumptech.glide.d;
import com.bumptech.glide.f;
import com.bumptech.glide.g;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.h;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.d.c;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class g<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    d f6841a;

    /* renamed from: b  reason: collision with root package name */
    Object f6842b;

    /* renamed from: c  reason: collision with root package name */
    int f6843c;

    /* renamed from: d  reason: collision with root package name */
    int f6844d;

    /* renamed from: e  reason: collision with root package name */
    Class<?> f6845e;

    /* renamed from: f  reason: collision with root package name */
    h.d f6846f;

    /* renamed from: g  reason: collision with root package name */
    i f6847g;

    /* renamed from: h  reason: collision with root package name */
    Map<Class<?>, m<?>> f6848h;

    /* renamed from: i  reason: collision with root package name */
    Class<Transcode> f6849i;
    com.bumptech.glide.load.g j;
    f k;
    j l;
    boolean m;
    boolean n;
    private final List<n.a<?>> o = new ArrayList();
    private final List<com.bumptech.glide.load.g> p = new ArrayList();
    private boolean q;
    private boolean r;

    g() {
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f6841a = null;
        this.f6842b = null;
        this.j = null;
        this.f6845e = null;
        this.f6849i = null;
        this.f6847g = null;
        this.k = null;
        this.f6848h = null;
        this.l = null;
        this.o.clear();
        this.q = false;
        this.p.clear();
        this.r = false;
    }

    /* access modifiers changed from: package-private */
    public final a b() {
        return this.f6846f.a();
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Class<?> cls) {
        return b(cls) != null;
    }

    /* access modifiers changed from: package-private */
    public final <Data> t<Data, ?, Transcode> b(Class<Data> cls) {
        return this.f6841a.f6481c.a(cls, this.f6845e, this.f6849i);
    }

    /* access modifiers changed from: package-private */
    public final <Z> m<Z> c(Class<Z> cls) {
        m<Z> mVar = this.f6848h.get(cls);
        if (mVar == null) {
            Iterator<Map.Entry<Class<?>, m<?>>> it2 = this.f6848h.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    mVar = (m) next.getValue();
                    break;
                }
            }
        }
        if (mVar != null) {
            return mVar;
        }
        if (!this.f6848h.isEmpty() || !this.m) {
            return c.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    public final List<n<File, ?>> a(File file) throws g.c {
        return this.f6841a.f6481c.a(file);
    }

    /* access modifiers changed from: package-private */
    public final List<n.a<?>> c() {
        if (!this.q) {
            this.q = true;
            this.o.clear();
            List a2 = this.f6841a.f6481c.a(this.f6842b);
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a a3 = ((n) a2.get(i2)).a(this.f6842b, this.f6843c, this.f6844d, this.f6847g);
                if (a3 != null) {
                    this.o.add(a3);
                }
            }
        }
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public final List<com.bumptech.glide.load.g> d() {
        if (!this.r) {
            this.r = true;
            this.p.clear();
            List<n.a<?>> c2 = c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a aVar = c2.get(i2);
                if (!this.p.contains(aVar.f7053a)) {
                    this.p.add(aVar.f7053a);
                }
                for (int i3 = 0; i3 < aVar.f7054b.size(); i3++) {
                    if (!this.p.contains(aVar.f7054b.get(i3))) {
                        this.p.add(aVar.f7054b.get(i3));
                    }
                }
            }
        }
        return this.p;
    }
}
