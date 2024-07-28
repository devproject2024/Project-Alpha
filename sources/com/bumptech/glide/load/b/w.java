package com.bumptech.glide.load.b;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.f;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import java.io.File;
import java.util.List;

final class w implements d.a<Object>, f {

    /* renamed from: a  reason: collision with root package name */
    private final f.a f6950a;

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f6951b;

    /* renamed from: c  reason: collision with root package name */
    private int f6952c;

    /* renamed from: d  reason: collision with root package name */
    private int f6953d = -1;

    /* renamed from: e  reason: collision with root package name */
    private g f6954e;

    /* renamed from: f  reason: collision with root package name */
    private List<n<File, ?>> f6955f;

    /* renamed from: g  reason: collision with root package name */
    private int f6956g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f6957h;

    /* renamed from: i  reason: collision with root package name */
    private File f6958i;
    private x j;

    w(g<?> gVar, f.a aVar) {
        this.f6951b = gVar;
        this.f6950a = aVar;
    }

    public final boolean a() {
        List<g> d2 = this.f6951b.d();
        boolean z = false;
        if (d2.isEmpty()) {
            return false;
        }
        g<?> gVar = this.f6951b;
        List<Class<?>> b2 = gVar.f6841a.f6481c.b(gVar.f6842b.getClass(), gVar.f6845e, gVar.f6849i);
        if (!b2.isEmpty()) {
            while (true) {
                if (this.f6955f == null || !c()) {
                    this.f6953d++;
                    if (this.f6953d >= b2.size()) {
                        this.f6952c++;
                        if (this.f6952c >= d2.size()) {
                            return false;
                        }
                        this.f6953d = 0;
                    }
                    g gVar2 = d2.get(this.f6952c);
                    Class cls = b2.get(this.f6953d);
                    this.j = new x(this.f6951b.f6841a.f6480b, gVar2, this.f6951b.j, this.f6951b.f6843c, this.f6951b.f6844d, this.f6951b.c(cls), cls, this.f6951b.f6847g);
                    this.f6958i = this.f6951b.b().a(this.j);
                    File file = this.f6958i;
                    if (file != null) {
                        this.f6954e = gVar2;
                        this.f6955f = this.f6951b.a(file);
                        this.f6956g = 0;
                    }
                } else {
                    this.f6957h = null;
                    while (!z && c()) {
                        List<n<File, ?>> list = this.f6955f;
                        int i2 = this.f6956g;
                        this.f6956g = i2 + 1;
                        this.f6957h = list.get(i2).a(this.f6958i, this.f6951b.f6843c, this.f6951b.f6844d, this.f6951b.f6847g);
                        if (this.f6957h != null && this.f6951b.a((Class<?>) this.f6957h.f7055c.a())) {
                            this.f6957h.f7055c.a(this.f6951b.k, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
        } else if (File.class.equals(this.f6951b.f6849i)) {
            return false;
        } else {
            throw new IllegalStateException("Failed to find any load path from " + this.f6951b.f6842b.getClass() + " to " + this.f6951b.f6849i);
        }
    }

    private boolean c() {
        return this.f6956g < this.f6955f.size();
    }

    public final void b() {
        n.a<?> aVar = this.f6957h;
        if (aVar != null) {
            aVar.f7055c.c();
        }
    }

    public final void a(Object obj) {
        this.f6950a.a(this.f6954e, obj, this.f6957h.f7055c, a.RESOURCE_DISK_CACHE, this.j);
    }

    public final void a(Exception exc) {
        this.f6950a.a(this.j, exc, this.f6957h.f7055c, a.RESOURCE_DISK_CACHE);
    }
}
