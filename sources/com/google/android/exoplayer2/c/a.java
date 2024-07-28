package com.google.android.exoplayer2.c;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f31289a;

    public void a() {
        this.f31289a = 0;
    }

    public final boolean j_() {
        return b(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return b(4);
    }

    public final boolean d() {
        return b(1);
    }

    public final void a(int i2) {
        this.f31289a = i2 | this.f31289a;
    }

    /* access modifiers changed from: protected */
    public final boolean b(int i2) {
        return (this.f31289a & i2) == i2;
    }
}
