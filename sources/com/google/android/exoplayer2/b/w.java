package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.g.ae;
import java.nio.ByteBuffer;

final class w extends m {

    /* renamed from: f  reason: collision with root package name */
    int f31276f;

    /* renamed from: g  reason: collision with root package name */
    int f31277g;

    /* renamed from: h  reason: collision with root package name */
    long f31278h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31279i;
    private int j;
    private boolean k;
    private int l;
    private byte[] m = ae.f32504f;
    private int n;

    public final boolean a(int i2, int i3, int i4) throws g.a {
        if (i4 == 2) {
            int i5 = this.n;
            if (i5 > 0) {
                this.f31278h += (long) (i5 / this.j);
            }
            this.j = ae.b(2, i3);
            int i6 = this.f31277g;
            int i7 = this.j;
            this.m = new byte[(i6 * i7)];
            this.n = 0;
            int i8 = this.f31276f;
            this.l = i7 * i8;
            boolean z = this.f31279i;
            this.f31279i = (i8 == 0 && i6 == 0) ? false : true;
            this.k = false;
            b(i2, i3, i4);
            if (z != this.f31279i) {
                return true;
            }
            return false;
        }
        throw new g.a(i2, i3, i4);
    }

    public final boolean a() {
        return this.f31279i;
    }

    public final void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        if (i2 != 0) {
            this.k = true;
            int min = Math.min(i2, this.l);
            this.f31278h += (long) (min / this.j);
            this.l -= min;
            byteBuffer.position(position + min);
            if (this.l <= 0) {
                int i3 = i2 - min;
                int length = (this.n + i3) - this.m.length;
                ByteBuffer a2 = a(length);
                int a3 = ae.a(length, 0, this.n);
                a2.put(this.m, 0, a3);
                int a4 = ae.a(length - a3, 0, i3);
                byteBuffer.limit(byteBuffer.position() + a4);
                a2.put(byteBuffer);
                byteBuffer.limit(limit);
                int i4 = i3 - a4;
                this.n -= a3;
                byte[] bArr = this.m;
                System.arraycopy(bArr, a3, bArr, 0, this.n);
                byteBuffer.get(this.m, this.n, i4);
                this.n += i4;
                a2.flip();
            }
        }
    }

    public final ByteBuffer f() {
        int i2;
        if (super.g() && (i2 = this.n) > 0) {
            a(i2).put(this.m, 0, this.n).flip();
            this.n = 0;
        }
        return super.f();
    }

    public final boolean g() {
        return super.g() && this.n == 0;
    }

    /* access modifiers changed from: protected */
    public final void k() {
        if (this.k) {
            this.l = 0;
        }
        this.n = 0;
    }

    /* access modifiers changed from: protected */
    public final void l() {
        this.m = ae.f32504f;
    }
}
