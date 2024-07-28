package com.google.zxing.e.a.a.a;

final class m {

    /* renamed from: a  reason: collision with root package name */
    int f40322a = 0;

    /* renamed from: b  reason: collision with root package name */
    a f40323b = a.NUMERIC;

    enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    m() {
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.f40322a += i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.f40323b == a.ALPHA;
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.f40323b == a.ISO_IEC_646;
    }
}
