package com.google.android.exoplayer2.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class m implements g {

    /* renamed from: b  reason: collision with root package name */
    protected int f31212b = -1;

    /* renamed from: c  reason: collision with root package name */
    protected int f31213c = -1;

    /* renamed from: d  reason: collision with root package name */
    protected int f31214d = -1;

    /* renamed from: e  reason: collision with root package name */
    ByteBuffer f31215e = f31187a;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f31216f = f31187a;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31217g;

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    public boolean a() {
        return this.f31212b != -1;
    }

    public int b() {
        return this.f31213c;
    }

    public int c() {
        return this.f31214d;
    }

    public final int d() {
        return this.f31212b;
    }

    public final void e() {
        this.f31217g = true;
        j();
    }

    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f31215e;
        this.f31215e = f31187a;
        return byteBuffer;
    }

    public boolean g() {
        return this.f31217g && this.f31215e == f31187a;
    }

    public final void h() {
        this.f31215e = f31187a;
        this.f31217g = false;
        k();
    }

    public final void i() {
        h();
        this.f31216f = f31187a;
        this.f31212b = -1;
        this.f31213c = -1;
        this.f31214d = -1;
        l();
    }

    /* access modifiers changed from: protected */
    public final boolean b(int i2, int i3, int i4) {
        if (i2 == this.f31212b && i3 == this.f31213c && i4 == this.f31214d) {
            return false;
        }
        this.f31212b = i2;
        this.f31213c = i3;
        this.f31214d = i4;
        return true;
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer a(int i2) {
        if (this.f31216f.capacity() < i2) {
            this.f31216f = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f31216f.clear();
        }
        ByteBuffer byteBuffer = this.f31216f;
        this.f31215e = byteBuffer;
        return byteBuffer;
    }
}
