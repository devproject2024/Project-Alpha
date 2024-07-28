package com.google.android.exoplayer2.g;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    public long f32496a;

    /* renamed from: b  reason: collision with root package name */
    public long f32497b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f32498c = -9223372036854775807L;

    public ab(long j) {
        a(j);
    }

    public final synchronized void a(long j) {
        a.b(this.f32498c == -9223372036854775807L);
        this.f32496a = j;
    }

    public final long a() {
        if (this.f32496a == Long.MAX_VALUE) {
            return 0;
        }
        if (this.f32498c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f32497b;
    }

    public final long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f32498c != -9223372036854775807L) {
            long e2 = e(this.f32498c);
            long j2 = (4294967296L + e2) / 8589934592L;
            long j3 = ((j2 - 1) * 8589934592L) + j;
            j += j2 * 8589934592L;
            if (Math.abs(j3 - e2) < Math.abs(j - e2)) {
                j = j3;
            }
        }
        return c(d(j));
    }

    public final long c(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f32498c != -9223372036854775807L) {
            this.f32498c = j;
        } else {
            long j2 = this.f32496a;
            if (j2 != Long.MAX_VALUE) {
                this.f32497b = j2 - j;
            }
            synchronized (this) {
                this.f32498c = j;
                notifyAll();
            }
        }
        return j + this.f32497b;
    }

    public final synchronized void b() throws InterruptedException {
        while (this.f32498c == -9223372036854775807L) {
            wait();
        }
    }

    public static long d(long j) {
        return (j * 1000000) / 90000;
    }

    public static long e(long j) {
        return (j * 90000) / 1000000;
    }
}
