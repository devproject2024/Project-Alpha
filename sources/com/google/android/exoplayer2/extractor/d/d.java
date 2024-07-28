package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.extractor.d.c;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;

final class d implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f31773a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f31774b;

    /* renamed from: c  reason: collision with root package name */
    private final long f31775c;

    /* renamed from: d  reason: collision with root package name */
    private final long f31776d;

    public final boolean h_() {
        return true;
    }

    public static d a(long j, long j2, m mVar, r rVar) {
        int i2;
        long j3 = j;
        m mVar2 = mVar;
        r rVar2 = rVar;
        rVar2.d(10);
        int i3 = rVar.i();
        if (i3 <= 0) {
            return null;
        }
        int i4 = mVar2.f32151d;
        long b2 = ae.b((long) i3, 1000000 * ((long) (i4 >= 32000 ? 1152 : 576)), (long) i4);
        int d2 = rVar.d();
        int d3 = rVar.d();
        int d4 = rVar.d();
        rVar2.d(2);
        long j4 = j2 + ((long) mVar2.f32150c);
        long[] jArr = new long[d2];
        long[] jArr2 = new long[d2];
        int i5 = 0;
        long j5 = j2;
        while (i5 < d2) {
            int i6 = d3;
            jArr[i5] = (((long) i5) * b2) / ((long) d2);
            long j6 = j4;
            jArr2[i5] = Math.max(j5, j6);
            if (d4 == 1) {
                i2 = rVar.c();
            } else if (d4 == 2) {
                i2 = rVar.d();
            } else if (d4 == 3) {
                i2 = rVar.f();
            } else if (d4 != 4) {
                return null;
            } else {
                i2 = rVar.n();
            }
            j5 += (long) (i2 * i6);
            i5++;
            j4 = j6;
            d3 = i6;
        }
        if (!(j3 == -1 || j3 == j5)) {
            StringBuilder sb = new StringBuilder("VBRI data size mismatch: ");
            sb.append(j3);
            sb.append(", ");
            sb.append(j5);
            l.c();
        }
        return new d(jArr, jArr2, b2, j5);
    }

    private d(long[] jArr, long[] jArr2, long j, long j2) {
        this.f31773a = jArr;
        this.f31774b = jArr2;
        this.f31775c = j;
        this.f31776d = j2;
    }

    public final o.a a(long j) {
        int a2 = ae.a(this.f31773a, j, true);
        p pVar = new p(this.f31773a[a2], this.f31774b[a2]);
        if (pVar.f32294b < j) {
            long[] jArr = this.f31773a;
            if (a2 != jArr.length - 1) {
                int i2 = a2 + 1;
                return new o.a(pVar, new p(jArr[i2], this.f31774b[i2]));
            }
        }
        return new o.a(pVar);
    }

    public final long c(long j) {
        return this.f31773a[ae.a(this.f31774b, j, true)];
    }

    public final long b() {
        return this.f31775c;
    }

    public final long c() {
        return this.f31776d;
    }
}
