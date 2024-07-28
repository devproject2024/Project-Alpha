package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.a;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f33726a = new x();

    /* renamed from: b  reason: collision with root package name */
    public final float f33727b;

    /* renamed from: c  reason: collision with root package name */
    public final float f33728c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f33729d;

    /* renamed from: e  reason: collision with root package name */
    public final int f33730e;

    private x() {
        this(1.0f, 1.0f, false);
    }

    public x(float f2, float f3, boolean z) {
        boolean z2 = true;
        a.a(f2 > 0.0f);
        a.a(f3 <= 0.0f ? false : z2);
        this.f33727b = f2;
        this.f33728c = f3;
        this.f33729d = z;
        this.f33730e = Math.round(f2 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            x xVar = (x) obj;
            return this.f33727b == xVar.f33727b && this.f33728c == xVar.f33728c && this.f33729d == xVar.f33729d;
        }
    }

    public final int hashCode() {
        return ((((Float.floatToRawIntBits(this.f33727b) + 527) * 31) + Float.floatToRawIntBits(this.f33728c)) * 31) + (this.f33729d ? 1 : 0);
    }
}
