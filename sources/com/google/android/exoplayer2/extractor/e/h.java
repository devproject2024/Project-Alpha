package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;
import java.util.Arrays;

abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private final d f31830a = new d();

    /* renamed from: b  reason: collision with root package name */
    long f31831b;

    /* renamed from: c  reason: collision with root package name */
    int f31832c;

    /* renamed from: d  reason: collision with root package name */
    private q f31833d;

    /* renamed from: e  reason: collision with root package name */
    private i f31834e;

    /* renamed from: f  reason: collision with root package name */
    private f f31835f;

    /* renamed from: g  reason: collision with root package name */
    private long f31836g;

    /* renamed from: h  reason: collision with root package name */
    private long f31837h;

    /* renamed from: i  reason: collision with root package name */
    private int f31838i;
    private a j;
    private long k;
    private boolean l;
    private boolean m;

    /* access modifiers changed from: protected */
    public abstract boolean a(r rVar, long j2, a aVar) throws IOException, InterruptedException;

    /* access modifiers changed from: protected */
    public abstract long b(r rVar);

    static class a {

        /* renamed from: a  reason: collision with root package name */
        Format f31839a;

        /* renamed from: b  reason: collision with root package name */
        f f31840b;

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(i iVar, q qVar) {
        this.f31834e = iVar;
        this.f31833d = qVar;
        a(true);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        if (z) {
            this.j = new a();
            this.f31831b = 0;
            this.f31832c = 0;
        } else {
            this.f31832c = 1;
        }
        this.f31836g = -1;
        this.f31837h = 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2, long j3) {
        d dVar = this.f31830a;
        dVar.f31813a.a();
        dVar.f31814b.a();
        dVar.f31815c = -1;
        dVar.f31816d = false;
        if (j2 == 0) {
            a(!this.l);
        } else if (this.f31832c != 0) {
            this.f31836g = b(j3);
            this.f31835f.a_(this.f31836g);
            this.f31832c = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(com.google.android.exoplayer2.extractor.h hVar) throws IOException, InterruptedException {
        boolean z = true;
        while (z) {
            if (!this.f31830a.a(hVar)) {
                this.f31832c = 3;
                return -1;
            }
            this.k = hVar.c() - this.f31831b;
            z = a(this.f31830a.f31814b, this.f31831b, this.j);
            if (z) {
                this.f31831b = hVar.c();
            }
        }
        com.google.android.exoplayer2.extractor.h hVar2 = hVar;
        this.f31838i = this.j.f31839a.w;
        if (!this.m) {
            this.f31833d.a(this.j.f31839a);
            this.m = true;
        }
        if (this.j.f31840b != null) {
            this.f31835f = this.j.f31840b;
        } else if (hVar.d() == -1) {
            this.f31835f = new b((byte) 0);
        } else {
            e eVar = this.f31830a.f31813a;
            this.f31835f = new a(this, this.f31831b, hVar.d(), (long) (eVar.f31825h + eVar.f31826i), eVar.f31820c, (eVar.f31819b & 4) != 0);
        }
        this.j = null;
        this.f31832c = 2;
        d dVar = this.f31830a;
        if (dVar.f31814b.f32566a.length != 65025) {
            dVar.f31814b.f32566a = Arrays.copyOf(dVar.f31814b.f32566a, Math.max(65025, dVar.f31814b.f32568c));
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int a(com.google.android.exoplayer2.extractor.h hVar, n nVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.extractor.h hVar2 = hVar;
        long a2 = this.f31835f.a(hVar2);
        if (a2 >= 0) {
            nVar.f32288a = a2;
            return 1;
        }
        if (a2 < -1) {
            c(-(a2 + 2));
        }
        if (!this.l) {
            this.f31834e.a(this.f31835f.a());
            this.l = true;
        }
        if (this.k > 0 || this.f31830a.a(hVar2)) {
            this.k = 0;
            r rVar = this.f31830a.f31814b;
            long b2 = b(rVar);
            if (b2 >= 0) {
                long j2 = this.f31837h;
                if (j2 + b2 >= this.f31836g) {
                    long a3 = a(j2);
                    this.f31833d.a(rVar, rVar.f32568c);
                    this.f31833d.a(a3, 1, rVar.f32568c, 0, (q.a) null);
                    this.f31836g = -1;
                }
            }
            this.f31837h += b2;
            return 0;
        }
        this.f31832c = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public final long a(long j2) {
        return (j2 * 1000000) / ((long) this.f31838i);
    }

    /* access modifiers changed from: protected */
    public final long b(long j2) {
        return (((long) this.f31838i) * j2) / 1000000;
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
        this.f31837h = j2;
    }

    static final class b implements f {
        public final long a(com.google.android.exoplayer2.extractor.h hVar) {
            return -1;
        }

        public final void a_(long j) {
        }

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final o a() {
            return new o.b(-9223372036854775807L);
        }
    }
}
