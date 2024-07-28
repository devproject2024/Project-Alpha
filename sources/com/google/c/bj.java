package com.google.c;

final class bj implements ar {

    /* renamed from: a  reason: collision with root package name */
    final at f37756a;

    /* renamed from: b  reason: collision with root package name */
    final String f37757b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f37758c;

    /* renamed from: d  reason: collision with root package name */
    private final int f37759d;

    bj(at atVar, String str, Object[] objArr) {
        this.f37756a = atVar;
        this.f37757b = str;
        this.f37758c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f37759d = charAt;
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
                this.f37759d = c2 | (charAt2 << i2);
                return;
            }
        }
    }

    public final at c() {
        return this.f37756a;
    }

    public final bf a() {
        return (this.f37759d & 1) == 1 ? bf.PROTO2 : bf.PROTO3;
    }

    public final boolean b() {
        return (this.f37759d & 2) == 2;
    }
}
