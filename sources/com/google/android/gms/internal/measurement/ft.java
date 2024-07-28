package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.dv;

final class ft implements fd {

    /* renamed from: a  reason: collision with root package name */
    final ff f10664a;

    /* renamed from: b  reason: collision with root package name */
    final String f10665b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f10666c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10667d;

    ft(ff ffVar, String str, Object[] objArr) {
        this.f10664a = ffVar;
        this.f10665b = str;
        this.f10666c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f10667d = charAt;
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
                this.f10667d = c2 | (charAt2 << i2);
                return;
            }
        }
    }

    public final ff c() {
        return this.f10664a;
    }

    public final int a() {
        return (this.f10667d & 1) == 1 ? dv.d.f10603h : dv.d.f10604i;
    }

    public final boolean b() {
        return (this.f10667d & 2) == 2;
    }
}
