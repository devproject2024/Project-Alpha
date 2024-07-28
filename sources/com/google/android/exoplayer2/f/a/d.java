package com.google.android.exoplayer2.f.a;

import android.net.Uri;
import com.google.android.exoplayer2.f.a.a;
import com.google.android.exoplayer2.f.ac;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.j;
import com.google.android.exoplayer2.f.l;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class d implements i {

    /* renamed from: a  reason: collision with root package name */
    private final a f32323a;

    /* renamed from: b  reason: collision with root package name */
    private final i f32324b;

    /* renamed from: c  reason: collision with root package name */
    private final i f32325c;

    /* renamed from: d  reason: collision with root package name */
    private final i f32326d;

    /* renamed from: e  reason: collision with root package name */
    private final f f32327e;

    /* renamed from: f  reason: collision with root package name */
    private final a f32328f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f32329g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f32330h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f32331i;
    private i j;
    private boolean k;
    private Uri l;
    private Uri m;
    private int n;
    private int o;
    private String p;
    private long q;
    private long r;
    private g s;
    private boolean t;
    private boolean u;
    private long v;
    private long w;

    public interface a {
    }

    public d(a aVar, i iVar, i iVar2, h hVar, int i2, a aVar2, f fVar) {
        this.f32323a = aVar;
        this.f32324b = iVar2;
        this.f32327e = fVar == null ? h.f32344a : fVar;
        boolean z = false;
        this.f32329g = (i2 & 1) != 0;
        this.f32330h = (i2 & 2) != 0;
        this.f32331i = (i2 & 4) != 0 ? true : z;
        this.f32326d = iVar;
        if (hVar != null) {
            this.f32325c = new ac(iVar, hVar);
        } else {
            this.f32325c = null;
        }
        this.f32328f = aVar2;
    }

    public final void a(ad adVar) {
        this.f32324b.a(adVar);
        this.f32326d.a(adVar);
    }

    public final long a(l lVar) throws IOException {
        Uri uri;
        char c2;
        try {
            this.p = this.f32327e.buildCacheKey(lVar);
            this.l = lVar.f32395a;
            a aVar = this.f32323a;
            Uri uri2 = this.l;
            String a2 = aVar.d().a();
            if (a2 == null) {
                uri = null;
            } else {
                uri = Uri.parse(a2);
            }
            if (uri == null) {
                uri = uri2;
            }
            this.m = uri;
            this.n = lVar.f32396b;
            this.o = lVar.f32403i;
            this.q = lVar.f32400f;
            boolean z = true;
            if (!this.f32330h || !this.t) {
                c2 = (!this.f32331i || lVar.f32401g != -1) ? (char) 65535 : 1;
            } else {
                c2 = 0;
            }
            if (c2 == 65535) {
                z = false;
            }
            this.u = z;
            if (lVar.f32401g == -1) {
                if (!this.u) {
                    this.r = this.f32323a.d().b();
                    if (this.r != -1) {
                        this.r -= lVar.f32400f;
                        if (this.r <= 0) {
                            throw new j(0);
                        }
                    }
                    a(false);
                    return this.r;
                }
            }
            this.r = lVar.f32401g;
            a(false);
            return this.r;
        } catch (Throwable th) {
            a(th);
            throw th;
        }
    }

    public final int a(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        if (this.r == 0) {
            return -1;
        }
        try {
            if (this.q >= this.w) {
                a(true);
            }
            int a2 = this.j.a(bArr, i2, i3);
            if (a2 != -1) {
                if (g()) {
                    this.v += (long) a2;
                }
                long j2 = (long) a2;
                this.q += j2;
                if (this.r != -1) {
                    this.r -= j2;
                }
            } else if (this.k) {
                d();
            } else {
                if (this.r <= 0) {
                    if (this.r == -1) {
                    }
                }
                i();
                a(false);
                return a(bArr, i2, i3);
            }
            return a2;
        } catch (IOException e2) {
            if (!this.k || !h.a(e2)) {
                a((Throwable) e2);
                throw e2;
            }
            d();
            return -1;
        } catch (Throwable th) {
            a(th);
            throw th;
        }
    }

    public final Uri a() {
        return this.m;
    }

    public final Map<String, List<String>> b() {
        if (e()) {
            return this.f32326d.b();
        }
        return Collections.emptyMap();
    }

    public final void c() throws IOException {
        this.l = null;
        this.m = null;
        this.n = 1;
        if (this.f32328f != null && this.v > 0) {
            this.v = 0;
        }
        try {
            i();
        } catch (Throwable th) {
            a(th);
            throw th;
        }
    }

    private void a(boolean z) throws IOException {
        g gVar;
        i iVar;
        l lVar;
        long j2;
        Uri uri = null;
        if (this.u) {
            gVar = null;
        } else if (this.f32329g) {
            try {
                gVar = this.f32323a.a();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            gVar = this.f32323a.b();
        }
        if (gVar == null) {
            i iVar2 = this.f32326d;
            Uri uri2 = this.l;
            int i2 = this.n;
            long j3 = this.q;
            iVar = iVar2;
            lVar = new l(uri2, i2, (byte[]) null, j3, j3, this.r, this.p, this.o);
        } else if (gVar.f32342d) {
            Uri fromFile = Uri.fromFile(gVar.f32343e);
            long j4 = this.q - gVar.f32340b;
            long j5 = gVar.f32341c - j4;
            long j6 = this.r;
            if (j6 != -1) {
                j5 = Math.min(j5, j6);
            }
            lVar = new l(fromFile, this.q, j4, j5, this.p, this.o);
            iVar = this.f32324b;
        } else {
            if (gVar.a()) {
                j2 = this.r;
            } else {
                j2 = gVar.f32341c;
                long j7 = this.r;
                if (j7 != -1) {
                    j2 = Math.min(j2, j7);
                }
            }
            Uri uri3 = this.l;
            int i3 = this.n;
            long j8 = this.q;
            lVar = new l(uri3, i3, (byte[]) null, j8, j8, j2, this.p, this.o);
            iVar = this.f32325c;
            if (iVar == null) {
                iVar = this.f32326d;
                gVar = null;
            }
        }
        this.w = (this.u || iVar != this.f32326d) ? Long.MAX_VALUE : this.q + 102400;
        if (z) {
            com.google.android.exoplayer2.g.a.b(f());
            if (iVar != this.f32326d) {
                try {
                    i();
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                return;
            }
        }
        if (gVar != null && gVar.b()) {
            this.s = gVar;
        }
        this.j = iVar;
        this.k = lVar.f32401g == -1;
        long a2 = iVar.a(lVar);
        j jVar = new j();
        if (this.k && a2 != -1) {
            this.r = a2;
            jVar.a("exo_len", this.q + this.r);
        }
        if (e()) {
            this.m = this.j.a();
            if (true ^ this.l.equals(this.m)) {
                uri = this.m;
            }
            j.a(jVar, uri);
        }
    }

    private void d() throws IOException {
        this.r = 0;
        if (h()) {
            new j().a("exo_len", this.q);
        }
    }

    private boolean e() {
        return !g();
    }

    private boolean f() {
        return this.j == this.f32326d;
    }

    private boolean g() {
        return this.j == this.f32324b;
    }

    private boolean h() {
        return this.j == this.f32325c;
    }

    private void i() throws IOException {
        i iVar = this.j;
        if (iVar != null) {
            try {
                iVar.c();
            } finally {
                this.j = null;
                this.k = false;
                if (this.s != null) {
                    this.s = null;
                }
            }
        }
    }

    private void a(Throwable th) {
        if (g() || (th instanceof a.C0544a)) {
            this.t = true;
        }
    }
}
