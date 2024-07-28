package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.gg;

final class id implements hl {

    /* renamed from: a  reason: collision with root package name */
    final hn f9984a;

    /* renamed from: b  reason: collision with root package name */
    final String f9985b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f9986c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9987d;

    id(hn hnVar, String str, Object[] objArr) {
        this.f9984a = hnVar;
        this.f9985b = str;
        this.f9986c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f9987d = charAt;
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
                this.f9987d = c2 | (charAt2 << i2);
                return;
            }
        }
    }

    public final hn c() {
        return this.f9984a;
    }

    public final int a() {
        return (this.f9987d & 1) == 1 ? gg.e.f9929h : gg.e.f9930i;
    }

    public final boolean b() {
        return (this.f9987d & 2) == 2;
    }
}
