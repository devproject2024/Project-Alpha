package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class b implements o {

    /* renamed from: a  reason: collision with root package name */
    public final int f31681a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f31682b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f31683c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f31684d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f31685e;

    /* renamed from: f  reason: collision with root package name */
    private final long f31686f;

    public final boolean h_() {
        return true;
    }

    public b(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f31682b = iArr;
        this.f31683c = jArr;
        this.f31684d = jArr2;
        this.f31685e = jArr3;
        this.f31681a = iArr.length;
        int i2 = this.f31681a;
        if (i2 > 0) {
            this.f31686f = jArr2[i2 - 1] + jArr3[i2 - 1];
        } else {
            this.f31686f = 0;
        }
    }

    public final int b(long j) {
        return ae.a(this.f31685e, j, true);
    }

    public final long b() {
        return this.f31686f;
    }

    public final o.a a(long j) {
        int b2 = b(j);
        p pVar = new p(this.f31685e[b2], this.f31683c[b2]);
        if (pVar.f32294b >= j || b2 == this.f31681a - 1) {
            return new o.a(pVar);
        }
        int i2 = b2 + 1;
        return new o.a(pVar, new p(this.f31685e[i2], this.f31683c[i2]));
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.f31681a + ", sizes=" + Arrays.toString(this.f31682b) + ", offsets=" + Arrays.toString(this.f31683c) + ", timeUs=" + Arrays.toString(this.f31685e) + ", durationsUs=" + Arrays.toString(this.f31684d) + ")";
    }
}
