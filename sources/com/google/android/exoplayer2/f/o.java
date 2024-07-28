package com.google.android.exoplayer2.f;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class o implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Context f32429a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ad> f32430b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final i f32431c;

    /* renamed from: d  reason: collision with root package name */
    private i f32432d;

    /* renamed from: e  reason: collision with root package name */
    private i f32433e;

    /* renamed from: f  reason: collision with root package name */
    private i f32434f;

    /* renamed from: g  reason: collision with root package name */
    private i f32435g;

    /* renamed from: h  reason: collision with root package name */
    private i f32436h;

    /* renamed from: i  reason: collision with root package name */
    private i f32437i;
    private i j;
    private i k;

    public o(Context context, i iVar) {
        this.f32429a = context.getApplicationContext();
        this.f32431c = (i) a.a(iVar);
    }

    public final void a(ad adVar) {
        this.f32431c.a(adVar);
        this.f32430b.add(adVar);
        a(this.f32432d, adVar);
        a(this.f32433e, adVar);
        a(this.f32434f, adVar);
        a(this.f32435g, adVar);
        a(this.f32436h, adVar);
        a(this.f32437i, adVar);
        a(this.j, adVar);
    }

    public final long a(l lVar) throws IOException {
        a.b(this.k == null);
        String scheme = lVar.f32395a.getScheme();
        if (ae.a(lVar.f32395a)) {
            String path = lVar.f32395a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.f32432d == null) {
                    this.f32432d = new t();
                    a(this.f32432d);
                }
                this.k = this.f32432d;
            } else {
                this.k = d();
            }
        } else if ("asset".equals(scheme)) {
            this.k = d();
        } else if ("content".equals(scheme)) {
            if (this.f32434f == null) {
                this.f32434f = new f(this.f32429a);
                a(this.f32434f);
            }
            this.k = this.f32434f;
        } else if ("rtmp".equals(scheme)) {
            this.k = e();
        } else if ("udp".equals(scheme)) {
            if (this.f32436h == null) {
                this.f32436h = new ae();
                a(this.f32436h);
            }
            this.k = this.f32436h;
        } else if ("data".equals(scheme)) {
            if (this.f32437i == null) {
                this.f32437i = new g();
                a(this.f32437i);
            }
            this.k = this.f32437i;
        } else if ("rawresource".equals(scheme)) {
            if (this.j == null) {
                this.j = new aa(this.f32429a);
                a(this.j);
            }
            this.k = this.j;
        } else {
            this.k = this.f32431c;
        }
        return this.k.a(lVar);
    }

    public final int a(byte[] bArr, int i2, int i3) throws IOException {
        return ((i) a.a(this.k)).a(bArr, i2, i3);
    }

    public final Uri a() {
        i iVar = this.k;
        if (iVar == null) {
            return null;
        }
        return iVar.a();
    }

    public final Map<String, List<String>> b() {
        i iVar = this.k;
        return iVar == null ? Collections.emptyMap() : iVar.b();
    }

    public final void c() throws IOException {
        i iVar = this.k;
        if (iVar != null) {
            try {
                iVar.c();
            } finally {
                this.k = null;
            }
        }
    }

    private i d() {
        if (this.f32433e == null) {
            this.f32433e = new c(this.f32429a);
            a(this.f32433e);
        }
        return this.f32433e;
    }

    private i e() {
        if (this.f32435g == null) {
            try {
                this.f32435g = (i) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                a(this.f32435g);
            } catch (ClassNotFoundException unused) {
                l.c();
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f32435g == null) {
                this.f32435g = this.f32431c;
            }
        }
        return this.f32435g;
    }

    private void a(i iVar) {
        for (int i2 = 0; i2 < this.f32430b.size(); i2++) {
            iVar.a(this.f32430b.get(i2));
        }
    }

    private static void a(i iVar, ad adVar) {
        if (iVar != null) {
            iVar.a(adVar);
        }
    }
}
