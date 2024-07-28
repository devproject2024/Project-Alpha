package com.google.zxing.e.a;

import com.google.zxing.t;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f40351a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f40352b;

    /* renamed from: c  reason: collision with root package name */
    public final t[] f40353c;

    public c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.f40351a = i2;
        this.f40352b = iArr;
        float f2 = (float) i5;
        this.f40353c = new t[]{new t((float) i3, f2), new t((float) i4, f2)};
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof c) && this.f40351a == ((c) obj).f40351a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f40351a;
    }
}
