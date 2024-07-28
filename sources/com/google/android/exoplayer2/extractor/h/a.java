package com.google.android.exoplayer2.extractor.h;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.x;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.h.c;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.util.List;

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f32126a = $$Lambda$a$MoNBf9RQRHGN3hoyVOMNoZnN8fg.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private i f32127b;

    /* renamed from: c  reason: collision with root package name */
    private q f32128c;

    /* renamed from: d  reason: collision with root package name */
    private b f32129d;

    /* renamed from: e  reason: collision with root package name */
    private int f32130e;

    /* renamed from: f  reason: collision with root package name */
    private int f32131f;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new a()};
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        return c.a(hVar) != null;
    }

    public final void a(i iVar) {
        this.f32127b = iVar;
        this.f32128c = iVar.a(0, 1);
        this.f32129d = null;
        iVar.a();
    }

    public final void a(long j, long j2) {
        this.f32131f = 0;
    }

    public final int a(h hVar, n nVar) throws IOException, InterruptedException {
        h hVar2 = hVar;
        if (this.f32129d == null) {
            this.f32129d = c.a(hVar);
            b bVar = this.f32129d;
            if (bVar != null) {
                this.f32128c.a(Format.a((String) null, "audio/raw", bVar.f32133b * bVar.f32135d * bVar.f32132a, 32768, this.f32129d.f32132a, this.f32129d.f32133b, this.f32129d.f32136e, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.f32130e = this.f32129d.f32134c;
            } else {
                throw new v("Unsupported or unrecognized wav header.");
            }
        }
        if (!(this.f32129d.f32137f != -1)) {
            b bVar2 = this.f32129d;
            com.google.android.exoplayer2.g.a.a(hVar);
            com.google.android.exoplayer2.g.a.a(bVar2);
            hVar.a();
            r rVar = new r(8);
            c.a a2 = c.a.a(hVar2, rVar);
            while (a2.f32140a != x.f31283d) {
                if (!(a2.f32140a == x.f31280a || a2.f32140a == x.f31282c)) {
                    new StringBuilder("Ignoring unknown WAV chunk: ").append(a2.f32140a);
                    l.c();
                }
                long j = a2.f32141b + 8;
                if (a2.f32140a == x.f31280a) {
                    j = 12;
                }
                if (j <= 2147483647L) {
                    hVar2.b((int) j);
                    a2 = c.a.a(hVar2, rVar);
                } else {
                    throw new v("Chunk is too large (~2GB+) to skip; id: " + a2.f32140a);
                }
            }
            hVar2.b(8);
            int c2 = (int) hVar.c();
            long j2 = ((long) c2) + a2.f32141b;
            long d2 = hVar.d();
            if (d2 != -1 && j2 > d2) {
                StringBuilder sb = new StringBuilder("Data exceeds input length: ");
                sb.append(j2);
                sb.append(", ");
                sb.append(d2);
                l.c();
                j2 = d2;
            }
            bVar2.f32137f = c2;
            bVar2.f32138g = j2;
            this.f32127b.a(this.f32129d);
        } else if (hVar.c() == 0) {
            hVar2.b(this.f32129d.f32137f);
        }
        long j3 = this.f32129d.f32138g;
        com.google.android.exoplayer2.g.a.b(j3 != -1);
        long c3 = j3 - hVar.c();
        if (c3 <= 0) {
            return -1;
        }
        int a3 = this.f32128c.a(hVar2, (int) Math.min((long) (32768 - this.f32131f), c3), true);
        if (a3 != -1) {
            this.f32131f += a3;
        }
        int i2 = this.f32131f / this.f32130e;
        if (i2 > 0) {
            long b2 = this.f32129d.b(hVar.c() - ((long) this.f32131f));
            int i3 = i2 * this.f32130e;
            this.f32131f -= i3;
            this.f32128c.a(b2, 1, i3, this.f32131f, (q.a) null);
        }
        if (a3 == -1) {
            return -1;
        }
        return 0;
    }
}
