package com.google.zxing.g.b;

import com.google.zxing.t;

public final class d extends t {

    /* renamed from: c  reason: collision with root package name */
    public final float f40535c;

    /* renamed from: d  reason: collision with root package name */
    public final int f40536d;

    d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    private d(float f2, float f3, float f4, int i2) {
        super(f2, f3);
        this.f40535c = f4;
        this.f40536d = i2;
    }

    /* access modifiers changed from: package-private */
    public final d b(float f2, float f3, float f4) {
        int i2 = this.f40536d;
        int i3 = i2 + 1;
        float f5 = (((float) i2) * this.f40584a) + f3;
        float f6 = (float) i3;
        return new d(f5 / f6, ((((float) this.f40536d) * this.f40585b) + f2) / f6, ((((float) this.f40536d) * this.f40535c) + f4) / f6, i3);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - this.f40585b) > f2 || Math.abs(f4 - this.f40584a) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.f40535c);
        if (abs <= 1.0f || abs <= this.f40535c) {
            return true;
        }
        return false;
    }
}
