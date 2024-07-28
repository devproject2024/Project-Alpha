package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.fm  reason: invalid package */
final class fm implements ev {

    /* renamed from: a  reason: collision with root package name */
    final ex f9631a;

    /* renamed from: b  reason: collision with root package name */
    final String f9632b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f9633c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9634d;

    fm(ex exVar, String str, Object[] objArr) {
        this.f9631a = exVar;
        this.f9632b = str;
        this.f9633c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f9634d = charAt;
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
                this.f9634d = c2 | (charAt2 << i2);
                return;
            }
        }
    }

    public final ex c() {
        return this.f9631a;
    }

    public final int a() {
        return (this.f9634d & 1) == 1 ? dq.d.f9576h : dq.d.f9577i;
    }

    public final boolean b() {
        return (this.f9634d & 2) == 2;
    }
}
