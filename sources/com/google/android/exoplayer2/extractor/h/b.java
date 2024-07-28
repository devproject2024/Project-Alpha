package com.google.android.exoplayer2.extractor.h;

import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.ae;

final class b implements o {

    /* renamed from: a  reason: collision with root package name */
    final int f32132a;

    /* renamed from: b  reason: collision with root package name */
    final int f32133b;

    /* renamed from: c  reason: collision with root package name */
    final int f32134c;

    /* renamed from: d  reason: collision with root package name */
    final int f32135d;

    /* renamed from: e  reason: collision with root package name */
    final int f32136e;

    /* renamed from: f  reason: collision with root package name */
    int f32137f = -1;

    /* renamed from: g  reason: collision with root package name */
    long f32138g = -1;

    /* renamed from: h  reason: collision with root package name */
    private final int f32139h;

    public final boolean h_() {
        return true;
    }

    public b(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f32132a = i2;
        this.f32133b = i3;
        this.f32139h = i4;
        this.f32134c = i5;
        this.f32135d = i6;
        this.f32136e = i7;
    }

    public final long b() {
        return (((this.f32138g - ((long) this.f32137f)) / ((long) this.f32134c)) * 1000000) / ((long) this.f32133b);
    }

    public final o.a a(long j) {
        long j2 = this.f32138g - ((long) this.f32137f);
        int i2 = this.f32134c;
        long a2 = ae.a((((((long) this.f32139h) * j) / 1000000) / ((long) i2)) * ((long) i2), 0, j2 - ((long) i2));
        long j3 = ((long) this.f32137f) + a2;
        long b2 = b(j3);
        p pVar = new p(b2, j3);
        if (b2 < j) {
            int i3 = this.f32134c;
            if (a2 != j2 - ((long) i3)) {
                long j4 = j3 + ((long) i3);
                return new o.a(pVar, new p(b(j4), j4));
            }
        }
        return new o.a(pVar);
    }

    public final long b(long j) {
        return (Math.max(0, j - ((long) this.f32137f)) * 1000000) / ((long) this.f32139h);
    }
}
