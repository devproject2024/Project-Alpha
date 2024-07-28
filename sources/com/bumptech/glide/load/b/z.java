package com.bumptech.glide.load.b;

import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.f;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.d;
import java.util.Collections;
import java.util.List;

final class z implements f, f.a {

    /* renamed from: a  reason: collision with root package name */
    final g<?> f6969a;

    /* renamed from: b  reason: collision with root package name */
    final f.a f6970b;

    /* renamed from: c  reason: collision with root package name */
    Object f6971c;

    /* renamed from: d  reason: collision with root package name */
    d f6972d;

    /* renamed from: e  reason: collision with root package name */
    private int f6973e;

    /* renamed from: f  reason: collision with root package name */
    private c f6974f;

    /* renamed from: g  reason: collision with root package name */
    private volatile n.a<?> f6975g;

    z(g<?> gVar, f.a aVar) {
        this.f6969a = gVar;
        this.f6970b = aVar;
    }

    /* JADX INFO: finally extract failed */
    public final boolean a() {
        Object obj = this.f6971c;
        if (obj != null) {
            this.f6971c = null;
            long a2 = com.bumptech.glide.g.f.a();
            try {
                d<?> a3 = this.f6969a.f6841a.f6481c.f6586a.a(obj.getClass());
                if (a3 != null) {
                    e eVar = new e(a3, obj, this.f6969a.f6847g);
                    this.f6972d = new d(this.f6975g.f7053a, this.f6969a.j);
                    this.f6969a.b().a(this.f6972d, eVar);
                    if (Log.isLoggable("SourceGenerator", 2)) {
                        StringBuilder sb = new StringBuilder("Finished encoding source to cache, key: ");
                        sb.append(this.f6972d);
                        sb.append(", data: ");
                        sb.append(obj);
                        sb.append(", encoder: ");
                        sb.append(a3);
                        sb.append(", duration: ");
                        sb.append(com.bumptech.glide.g.f.a(a2));
                    }
                    this.f6975g.f7055c.b();
                    this.f6974f = new c(Collections.singletonList(this.f6975g.f7053a), this.f6969a, this);
                } else {
                    throw new g.e(obj.getClass());
                }
            } catch (Throwable th) {
                this.f6975g.f7055c.b();
                throw th;
            }
        }
        c cVar = this.f6974f;
        if (cVar != null && cVar.a()) {
            return true;
        }
        this.f6974f = null;
        this.f6975g = null;
        boolean z = false;
        while (!z) {
            if (!(this.f6973e < this.f6969a.c().size())) {
                break;
            }
            List<n.a<?>> c2 = this.f6969a.c();
            int i2 = this.f6973e;
            this.f6973e = i2 + 1;
            this.f6975g = c2.get(i2);
            if (this.f6975g != null && (this.f6969a.l.a(this.f6975g.f7055c.d()) || this.f6969a.a((Class<?>) this.f6975g.f7055c.a()))) {
                final n.a<?> aVar = this.f6975g;
                this.f6975g.f7055c.a(this.f6969a.k, new d.a<Object>() {
                    public final void a(Object obj) {
                        if (z.this.a(aVar)) {
                            z zVar = z.this;
                            n.a aVar = aVar;
                            j jVar = zVar.f6969a.l;
                            if (obj == null || !jVar.a(aVar.f7055c.d())) {
                                zVar.f6970b.a(aVar.f7053a, obj, aVar.f7055c, aVar.f7055c.d(), zVar.f6972d);
                                return;
                            }
                            zVar.f6971c = obj;
                            zVar.f6970b.c();
                        }
                    }

                    public final void a(Exception exc) {
                        if (z.this.a(aVar)) {
                            z zVar = z.this;
                            n.a aVar = aVar;
                            zVar.f6970b.a(zVar.f6972d, exc, aVar.f7055c, aVar.f7055c.d());
                        }
                    }
                });
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(n.a<?> aVar) {
        n.a<?> aVar2 = this.f6975g;
        return aVar2 != null && aVar2 == aVar;
    }

    public final void b() {
        n.a<?> aVar = this.f6975g;
        if (aVar != null) {
            aVar.f7055c.c();
        }
    }

    public final void c() {
        throw new UnsupportedOperationException();
    }

    public final void a(com.bumptech.glide.load.g gVar, Object obj, com.bumptech.glide.load.a.d<?> dVar, a aVar, com.bumptech.glide.load.g gVar2) {
        this.f6970b.a(gVar, obj, dVar, this.f6975g.f7055c.d(), gVar);
    }

    public final void a(com.bumptech.glide.load.g gVar, Exception exc, com.bumptech.glide.load.a.d<?> dVar, a aVar) {
        this.f6970b.a(gVar, exc, dVar, this.f6975g.f7055c.d());
    }
}
