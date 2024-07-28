package com.google.zxing.f.a;

final class d {

    /* renamed from: a  reason: collision with root package name */
    final int f40439a;

    /* renamed from: b  reason: collision with root package name */
    final int f40440b;

    /* renamed from: c  reason: collision with root package name */
    final int f40441c;

    /* renamed from: d  reason: collision with root package name */
    final int f40442d;

    /* renamed from: e  reason: collision with root package name */
    int f40443e = -1;

    d(int i2, int i3, int i4, int i5) {
        this.f40439a = i2;
        this.f40440b = i3;
        this.f40441c = i4;
        this.f40442d = i5;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return a(this.f40443e);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2) {
        return i2 != -1 && this.f40441c == (i2 % 3) * 3;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f40443e = ((this.f40442d / 30) * 3) + (this.f40441c / 3);
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return this.f40440b - this.f40439a;
    }

    public final String toString() {
        return this.f40443e + "|" + this.f40442d;
    }
}
