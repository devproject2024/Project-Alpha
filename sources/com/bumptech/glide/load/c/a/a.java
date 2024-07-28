package com.bumptech.glide.load.c.a;

import com.bumptech.glide.load.a.j;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import java.io.InputStream;

public final class a implements n<g, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public static final h<Integer> f6981a = h.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: b  reason: collision with root package name */
    private final m<g, g> f6982b;

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        g gVar = (g) obj;
        m<g, g> mVar = this.f6982b;
        if (mVar != null) {
            g a2 = mVar.a(gVar);
            if (a2 == null) {
                m<g, g> mVar2 = this.f6982b;
                mVar2.f7047a.b(m.a.a(gVar), gVar);
            } else {
                gVar = a2;
            }
        }
        return new n.a(gVar, new j(gVar, ((Integer) iVar.a(f6981a)).intValue()));
    }

    public a() {
        this((m<g, g>) null);
    }

    public a(m<g, g> mVar) {
        this.f6982b = mVar;
    }

    /* renamed from: com.bumptech.glide.load.c.a.a$a  reason: collision with other inner class name */
    public static class C0097a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f6983a = new m<>(500);

        public final n<g, InputStream> a(r rVar) {
            return new a(this.f6983a);
        }
    }
}
