package com.google.android.exoplayer2.source;

public final class f implements v {

    /* renamed from: a  reason: collision with root package name */
    protected final v[] f33044a;

    public f(v[] vVarArr) {
        this.f33044a = vVarArr;
    }

    public final long d() {
        long j = Long.MAX_VALUE;
        for (v d2 : this.f33044a) {
            long d3 = d2.d();
            if (d3 != Long.MIN_VALUE) {
                j = Math.min(j, d3);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long e() {
        long j = Long.MAX_VALUE;
        for (v e2 : this.f33044a) {
            long e3 = e2.e();
            if (e3 != Long.MIN_VALUE) {
                j = Math.min(j, e3);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final void a(long j) {
        for (v a2 : this.f33044a) {
            a2.a(j);
        }
    }

    public final boolean c(long j) {
        long j2 = j;
        boolean z = false;
        while (true) {
            long e2 = e();
            if (e2 == Long.MIN_VALUE) {
                break;
            }
            boolean z2 = false;
            for (v vVar : this.f33044a) {
                long e3 = vVar.e();
                boolean z3 = e3 != Long.MIN_VALUE && e3 <= j2;
                if (e3 == e2 || z3) {
                    z2 |= vVar.c(j2);
                }
            }
            z |= z2;
            if (!z2) {
                break;
            }
        }
        return z;
    }
}
