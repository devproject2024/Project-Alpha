package com.google.android.exoplayer2.extractor.d;

import android.util.Pair;
import com.google.android.exoplayer2.extractor.d.c;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.ae;

final class b implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f31761a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f31762b;

    /* renamed from: c  reason: collision with root package name */
    private final long f31763c;

    public final long c() {
        return -1;
    }

    public final boolean h_() {
        return true;
    }

    b(long[] jArr, long[] jArr2) {
        this.f31761a = jArr;
        this.f31762b = jArr2;
        this.f31763c = com.google.android.exoplayer2.c.b(jArr2[jArr2.length - 1]);
    }

    public final o.a a(long j) {
        Pair<Long, Long> a2 = a(com.google.android.exoplayer2.c.a(ae.a(j, 0, this.f31763c)), this.f31762b, this.f31761a);
        return new o.a(new p(com.google.android.exoplayer2.c.b(((Long) a2.first).longValue()), ((Long) a2.second).longValue()));
    }

    public final long c(long j) {
        return com.google.android.exoplayer2.c.b(((Long) a(j, this.f31761a, this.f31762b).second).longValue());
    }

    public final long b() {
        return this.f31763c;
    }

    private static Pair<Long, Long> a(long j, long[] jArr, long[] jArr2) {
        int a2 = ae.a(jArr, j, true);
        long j2 = jArr[a2];
        long j3 = jArr2[a2];
        int i2 = a2 + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i2];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? 0.0d : (((double) j) - ((double) j2)) / ((double) (j4 - j2))) * ((double) (jArr2[i2] - j3)))) + j3));
    }
}
