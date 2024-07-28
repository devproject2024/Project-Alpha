package com.google.android.exoplayer2.extractor.d;

import com.google.android.exoplayer2.extractor.d.c;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;

final class e implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final long f31777a;

    /* renamed from: b  reason: collision with root package name */
    private final int f31778b;

    /* renamed from: c  reason: collision with root package name */
    private final long f31779c;

    /* renamed from: d  reason: collision with root package name */
    private final long f31780d;

    /* renamed from: e  reason: collision with root package name */
    private final long f31781e;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f31782f;

    e(long j, int i2, long j2) {
        this(j, i2, j2, -1, (long[]) null);
    }

    e(long j, int i2, long j2, long j3, long[] jArr) {
        this.f31777a = j;
        this.f31778b = i2;
        this.f31779c = j2;
        this.f31782f = jArr;
        this.f31780d = j3;
        this.f31781e = j3 != -1 ? j + j3 : -1;
    }

    public final boolean h_() {
        return this.f31782f != null;
    }

    public final o.a a(long j) {
        double d2;
        if (!h_()) {
            return new o.a(new p(0, this.f31777a + ((long) this.f31778b)));
        }
        long a2 = ae.a(j, 0, this.f31779c);
        double d3 = (((double) a2) * 100.0d) / ((double) this.f31779c);
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i2 = (int) d3;
                long[] jArr = (long[]) a.a(this.f31782f);
                double d5 = (double) jArr[i2];
                if (i2 == 99) {
                    d2 = 256.0d;
                } else {
                    d2 = (double) jArr[i2 + 1];
                }
                d4 = d5 + ((d3 - ((double) i2)) * (d2 - d5));
            }
        }
        return new o.a(new p(a2, this.f31777a + ae.a(Math.round((d4 / 256.0d) * ((double) this.f31780d)), (long) this.f31778b, this.f31780d - 1)));
    }

    public final long c(long j) {
        long j2;
        long j3 = j - this.f31777a;
        if (!h_() || j3 <= ((long) this.f31778b)) {
            return 0;
        }
        long[] jArr = (long[]) a.a(this.f31782f);
        double d2 = (((double) j3) * 256.0d) / ((double) this.f31780d);
        int a2 = ae.a(jArr, (long) d2, true);
        long a3 = a(a2);
        long j4 = jArr[a2];
        int i2 = a2 + 1;
        long a4 = a(i2);
        if (a2 == 99) {
            j2 = 256;
        } else {
            j2 = jArr[i2];
        }
        return a3 + Math.round((j4 == j2 ? 0.0d : (d2 - ((double) j4)) / ((double) (j2 - j4))) * ((double) (a4 - a3)));
    }

    public final long b() {
        return this.f31779c;
    }

    public final long c() {
        return this.f31781e;
    }

    private long a(int i2) {
        return (this.f31779c * ((long) i2)) / 100;
    }
}
