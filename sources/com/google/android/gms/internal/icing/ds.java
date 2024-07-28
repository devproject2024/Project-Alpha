package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.bv;

final class ds implements db {

    /* renamed from: a  reason: collision with root package name */
    final dd f10173a;

    /* renamed from: b  reason: collision with root package name */
    final String f10174b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f10175c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10176d;

    ds(dd ddVar, String str, Object[] objArr) {
        this.f10173a = ddVar;
        this.f10174b = str;
        this.f10175c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f10176d = charAt;
            return;
        }
        char c2 = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 >= 55296) {
                c2 |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            } else {
                this.f10176d = c2 | (charAt2 << i2);
                return;
            }
        }
    }

    public final dd c() {
        return this.f10173a;
    }

    public final int a() {
        return (this.f10176d & 1) == 1 ? bv.c.f10116h : bv.c.f10117i;
    }

    public final boolean b() {
        return (this.f10176d & 2) == 2;
    }
}
