package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.extractor.mp4.j;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.b.d;
import com.google.android.exoplayer2.source.b.e;
import com.google.android.exoplayer2.source.b.l;
import com.google.android.exoplayer2.source.b.m;
import com.google.android.exoplayer2.source.c;
import com.google.android.exoplayer2.source.smoothstreaming.a.a;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.trackselection.f;
import java.io.IOException;
import java.util.List;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final y f33321a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33322b;

    /* renamed from: c  reason: collision with root package name */
    private final e[] f33323c;

    /* renamed from: d  reason: collision with root package name */
    private final i f33324d;

    /* renamed from: e  reason: collision with root package name */
    private f f33325e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.exoplayer2.source.smoothstreaming.a.a f33326f;

    /* renamed from: g  reason: collision with root package name */
    private int f33327g;

    /* renamed from: h  reason: collision with root package name */
    private IOException f33328h;

    public final void a(d dVar) {
    }

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a  reason: collision with other inner class name */
    public static final class C0550a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final i.a f33329a;

        public C0550a(i.a aVar) {
            this.f33329a = aVar;
        }

        public final b a(y yVar, com.google.android.exoplayer2.source.smoothstreaming.a.a aVar, int i2, f fVar, ad adVar) {
            i a2 = this.f33329a.a();
            if (adVar != null) {
                a2.a(adVar);
            }
            return new a(yVar, aVar, i2, fVar, a2);
        }
    }

    public a(y yVar, com.google.android.exoplayer2.source.smoothstreaming.a.a aVar, int i2, f fVar, i iVar) {
        com.google.android.exoplayer2.source.smoothstreaming.a.a aVar2 = aVar;
        int i3 = i2;
        f fVar2 = fVar;
        this.f33321a = yVar;
        this.f33326f = aVar2;
        this.f33322b = i3;
        this.f33325e = fVar2;
        this.f33324d = iVar;
        a.b bVar = aVar2.f33335f[i3];
        this.f33323c = new e[fVar.f()];
        int i4 = 0;
        while (i4 < this.f33323c.length) {
            int b2 = fVar2.b(i4);
            Format format = bVar.j[b2];
            int i5 = i4;
            j jVar = r7;
            j jVar2 = new j(b2, bVar.f33341a, bVar.f33343c, -9223372036854775807L, aVar2.f33336g, format, 0, format.l != null ? aVar2.f33334e.f33340c : null, bVar.f33341a == 2 ? 4 : 0, (long[]) null, (long[]) null);
            this.f33323c[i5] = new e(new com.google.android.exoplayer2.extractor.mp4.e(3, jVar), bVar.f33341a, format);
            i4 = i5 + 1;
        }
    }

    public final long a(long j, af afVar) {
        long j2;
        a.b bVar = this.f33326f.f33335f[this.f33322b];
        int a2 = bVar.a(j);
        long j3 = bVar.o[a2];
        if (j3 >= j || a2 >= bVar.k - 1) {
            j2 = j3;
        } else {
            j2 = bVar.o[a2 + 1];
        }
        return ae.a(j, afVar, j3, j2);
    }

    public final void a(com.google.android.exoplayer2.source.smoothstreaming.a.a aVar) {
        a.b bVar = this.f33326f.f33335f[this.f33322b];
        int i2 = bVar.k;
        a.b bVar2 = aVar.f33335f[this.f33322b];
        if (i2 == 0 || bVar2.k == 0) {
            this.f33327g += i2;
        } else {
            int i3 = i2 - 1;
            long a2 = bVar.o[i3] + bVar.a(i3);
            long j = bVar2.o[0];
            if (a2 <= j) {
                this.f33327g += i2;
            } else {
                this.f33327g += bVar.a(j);
            }
        }
        this.f33326f = aVar;
    }

    public final void a(f fVar) {
        this.f33325e = fVar;
    }

    public final void a() throws IOException {
        IOException iOException = this.f33328h;
        if (iOException == null) {
            this.f33321a.a();
            return;
        }
        throw iOException;
    }

    public final int a(long j, List<? extends l> list) {
        if (this.f33328h != null || this.f33325e.f() < 2) {
            return list.size();
        }
        return this.f33325e.a(j, list);
    }

    public final void a(long j, long j2, List<? extends l> list, com.google.android.exoplayer2.source.b.f fVar) {
        int i2;
        long j3;
        long j4 = j2;
        com.google.android.exoplayer2.source.b.f fVar2 = fVar;
        if (this.f33328h == null) {
            a.b bVar = this.f33326f.f33335f[this.f33322b];
            if (bVar.k == 0) {
                fVar2.f32836b = !this.f33326f.f33333d;
                return;
            }
            if (list.isEmpty()) {
                i2 = bVar.a(j4);
                List<? extends l> list2 = list;
            } else {
                i2 = (int) (((l) list.get(list.size() - 1)).f() - ((long) this.f33327g));
                if (i2 < 0) {
                    this.f33328h = new c();
                    return;
                }
            }
            if (i2 >= bVar.k) {
                fVar2.f32836b = !this.f33326f.f33333d;
                return;
            }
            long j5 = j4 - j;
            if (!this.f33326f.f33333d) {
                j3 = -9223372036854775807L;
            } else {
                a.b bVar2 = this.f33326f.f33335f[this.f33322b];
                int i3 = bVar2.k - 1;
                j3 = (bVar2.o[i3] + bVar2.a(i3)) - j;
            }
            m[] mVarArr = new m[this.f33325e.f()];
            boolean z = false;
            for (int i4 = 0; i4 < mVarArr.length; i4++) {
                mVarArr[i4] = new b(bVar, this.f33325e.b(i4), i2);
            }
            this.f33325e.a(j5, j3, list, mVarArr);
            long j6 = bVar.o[i2];
            long a2 = j6 + bVar.a(i2);
            long j7 = list.isEmpty() ? j4 : -9223372036854775807L;
            int i5 = this.f33327g + i2;
            int a3 = this.f33325e.a();
            e eVar = this.f33323c[a3];
            int b2 = this.f33325e.b(a3);
            com.google.android.exoplayer2.g.a.b(bVar.j != null);
            com.google.android.exoplayer2.g.a.b(bVar.n != null);
            if (i2 < bVar.n.size()) {
                z = true;
            }
            com.google.android.exoplayer2.g.a.b(z);
            String num = Integer.toString(bVar.j[b2].f31065e);
            String l = bVar.n.get(i2).toString();
            Uri a4 = com.google.android.exoplayer2.g.ad.a(bVar.l, bVar.m.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
            Format g2 = this.f33325e.g();
            i iVar = this.f33324d;
            int b3 = this.f33325e.b();
            Object c2 = this.f33325e.c();
            com.google.android.exoplayer2.f.l lVar = r5;
            com.google.android.exoplayer2.f.l lVar2 = new com.google.android.exoplayer2.f.l(a4, 0, -1, (String) null);
            fVar2.f32835a = new com.google.android.exoplayer2.source.b.i(iVar, lVar, g2, b3, c2, j6, a2, j7, -9223372036854775807L, (long) i5, 1, j6, eVar);
        }
    }

    public final boolean a(d dVar, boolean z, Exception exc, long j) {
        if (!z || j == -9223372036854775807L) {
            return false;
        }
        f fVar = this.f33325e;
        return fVar.a(fVar.a(dVar.f32816g), j);
    }

    static final class b extends com.google.android.exoplayer2.source.b.b {

        /* renamed from: b  reason: collision with root package name */
        private final a.b f33351b;

        /* renamed from: c  reason: collision with root package name */
        private final int f33352c;

        public b(a.b bVar, int i2, int i3) {
            super((long) i3, (long) (bVar.k - 1));
            this.f33351b = bVar;
            this.f33352c = i2;
        }
    }
}
