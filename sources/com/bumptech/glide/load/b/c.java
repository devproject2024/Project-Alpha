package com.bumptech.glide.load.b;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.f;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import java.io.File;
import java.util.List;

final class c implements d.a<Object>, f {

    /* renamed from: a  reason: collision with root package name */
    private final List<g> f6808a;

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f6809b;

    /* renamed from: c  reason: collision with root package name */
    private final f.a f6810c;

    /* renamed from: d  reason: collision with root package name */
    private int f6811d;

    /* renamed from: e  reason: collision with root package name */
    private g f6812e;

    /* renamed from: f  reason: collision with root package name */
    private List<n<File, ?>> f6813f;

    /* renamed from: g  reason: collision with root package name */
    private int f6814g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f6815h;

    /* renamed from: i  reason: collision with root package name */
    private File f6816i;

    c(g<?> gVar, f.a aVar) {
        this(gVar.d(), gVar, aVar);
    }

    c(List<g> list, g<?> gVar, f.a aVar) {
        this.f6811d = -1;
        this.f6808a = list;
        this.f6809b = gVar;
        this.f6810c = aVar;
    }

    public final boolean a() {
        while (true) {
            boolean z = false;
            if (this.f6813f == null || !c()) {
                this.f6811d++;
                if (this.f6811d >= this.f6808a.size()) {
                    return false;
                }
                g gVar = this.f6808a.get(this.f6811d);
                this.f6816i = this.f6809b.b().a(new d(gVar, this.f6809b.j));
                File file = this.f6816i;
                if (file != null) {
                    this.f6812e = gVar;
                    this.f6813f = this.f6809b.a(file);
                    this.f6814g = 0;
                }
            } else {
                this.f6815h = null;
                while (!z && c()) {
                    List<n<File, ?>> list = this.f6813f;
                    int i2 = this.f6814g;
                    this.f6814g = i2 + 1;
                    this.f6815h = list.get(i2).a(this.f6816i, this.f6809b.f6843c, this.f6809b.f6844d, this.f6809b.f6847g);
                    if (this.f6815h != null && this.f6809b.a((Class<?>) this.f6815h.f7055c.a())) {
                        this.f6815h.f7055c.a(this.f6809b.k, this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    private boolean c() {
        return this.f6814g < this.f6813f.size();
    }

    public final void b() {
        n.a<?> aVar = this.f6815h;
        if (aVar != null) {
            aVar.f7055c.c();
        }
    }

    public final void a(Object obj) {
        this.f6810c.a(this.f6812e, obj, this.f6815h.f7055c, a.DATA_DISK_CACHE, this.f6812e);
    }

    public final void a(Exception exc) {
        this.f6810c.a(this.f6812e, exc, this.f6815h.f7055c, a.DATA_DISK_CACHE);
    }
}
