package com.paytm.e.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final long f42696a;

    /* renamed from: b  reason: collision with root package name */
    private final long f42697b;

    public f(long j) {
        this(j, (byte) 0);
    }

    private f(long j, byte b2) {
        if (j >= 1) {
            c(0);
            this.f42696a = j;
            this.f42697b = 0;
            return;
        }
        throw new IllegalArgumentException("Time step must be positive: ".concat(String.valueOf(j)));
    }

    public final long a(long j) {
        c(j);
        long j2 = j - this.f42697b;
        if (j2 >= 0) {
            return j2 / this.f42696a;
        }
        long j3 = this.f42696a;
        return (j2 - (j3 - 1)) / j3;
    }

    public final long b(long j) {
        return this.f42697b + (j * this.f42696a);
    }

    private static void c(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Negative time: ".concat(String.valueOf(j)));
        }
    }
}
