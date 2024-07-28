package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.g.ae;

public class c implements o {

    /* renamed from: a  reason: collision with root package name */
    private final long f31708a;

    /* renamed from: b  reason: collision with root package name */
    private final long f31709b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31710c;

    /* renamed from: d  reason: collision with root package name */
    private final long f31711d;

    /* renamed from: e  reason: collision with root package name */
    private final int f31712e;

    /* renamed from: f  reason: collision with root package name */
    private final long f31713f;

    public c(long j, long j2, int i2, int i3) {
        this.f31708a = j;
        this.f31709b = j2;
        this.f31710c = i3 == -1 ? 1 : i3;
        this.f31712e = i2;
        if (j == -1) {
            this.f31711d = -1;
            this.f31713f = -9223372036854775807L;
            return;
        }
        this.f31711d = j - j2;
        this.f31713f = a(j, j2, i2);
    }

    public final boolean h_() {
        return this.f31711d != -1;
    }

    public final o.a a(long j) {
        long j2 = this.f31711d;
        if (j2 == -1) {
            return new o.a(new p(0, this.f31709b));
        }
        int i2 = this.f31710c;
        long a2 = this.f31709b + ae.a((((((long) this.f31712e) * j) / 8000000) / ((long) i2)) * ((long) i2), 0, j2 - ((long) i2));
        long b2 = b(a2);
        p pVar = new p(b2, a2);
        if (b2 < j) {
            int i3 = this.f31710c;
            if (((long) i3) + a2 < this.f31708a) {
                long j3 = a2 + ((long) i3);
                return new o.a(pVar, new p(b(j3), j3));
            }
        }
        return new o.a(pVar);
    }

    public final long b() {
        return this.f31713f;
    }

    public final long b(long j) {
        return a(j, this.f31709b, this.f31712e);
    }

    private static long a(long j, long j2, int i2) {
        return ((Math.max(0, j - j2) * 8) * 1000000) / ((long) i2);
    }
}
