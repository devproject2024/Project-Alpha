package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.ej;

final class gg implements fr {

    /* renamed from: a  reason: collision with root package name */
    final ft f11172a;

    /* renamed from: b  reason: collision with root package name */
    final String f11173b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f11174c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11175d;

    gg(ft ftVar, String str, Object[] objArr) {
        this.f11172a = ftVar;
        this.f11173b = str;
        this.f11174c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f11175d = charAt;
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
                this.f11175d = c2 | (charAt2 << i2);
                return;
            }
        }
    }

    public final ft c() {
        return this.f11172a;
    }

    public final int a() {
        return (this.f11175d & 1) == 1 ? ej.e.f11107h : ej.e.f11108i;
    }

    public final boolean b() {
        return (this.f11175d & 2) == 2;
    }
}
