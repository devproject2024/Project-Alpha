package com.bumptech.glide.load.c.a;

import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.i;
import java.io.InputStream;
import java.net.URL;

public final class f implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f7007a;

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        return this.f7007a.a(new g((URL) obj), i2, i3, iVar);
    }

    public f(n<g, InputStream> nVar) {
        this.f7007a = nVar;
    }

    public static class a implements o<URL, InputStream> {
        public final n<URL, InputStream> a(r rVar) {
            return new f(rVar.a(g.class, InputStream.class));
        }
    }
}
