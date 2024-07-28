package com.google.zxing.e.a.a.a;

import com.google.zxing.h;

final class p extends q {

    /* renamed from: a  reason: collision with root package name */
    final int f40328a;

    /* renamed from: b  reason: collision with root package name */
    final int f40329b;

    p(int i2, int i3, int i4) throws h {
        super(i2);
        if (i3 < 0 || i3 > 10 || i4 < 0 || i4 > 10) {
            throw h.getFormatInstance();
        }
        this.f40328a = i3;
        this.f40329b = i4;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.f40328a == 10;
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.f40329b == 10;
    }
}
