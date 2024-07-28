package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.g.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class v implements g {

    /* renamed from: b  reason: collision with root package name */
    int f31268b = -1;

    /* renamed from: c  reason: collision with root package name */
    float f31269c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    float f31270d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    int f31271e = -1;

    /* renamed from: f  reason: collision with root package name */
    boolean f31272f;

    /* renamed from: g  reason: collision with root package name */
    long f31273g;

    /* renamed from: h  reason: collision with root package name */
    long f31274h;

    /* renamed from: i  reason: collision with root package name */
    private int f31275i = -1;
    private int j = -1;
    private u k;
    private ByteBuffer l = f31187a;
    private ShortBuffer m = this.l.asShortBuffer();
    private ByteBuffer n = f31187a;
    private boolean o;

    public final int c() {
        return 2;
    }

    public final boolean a(int i2, int i3, int i4) throws g.a {
        if (i4 == 2) {
            int i5 = this.j;
            if (i5 == -1) {
                i5 = i2;
            }
            if (this.f31268b == i2 && this.f31275i == i3 && this.f31271e == i5) {
                return false;
            }
            this.f31268b = i2;
            this.f31275i = i3;
            this.f31271e = i5;
            this.f31272f = true;
            return true;
        }
        throw new g.a(i2, i3, i4);
    }

    public final boolean a() {
        if (this.f31268b != -1) {
            return Math.abs(this.f31269c - 1.0f) >= 0.01f || Math.abs(this.f31270d - 1.0f) >= 0.01f || this.f31271e != this.f31268b;
        }
        return false;
    }

    public final int b() {
        return this.f31275i;
    }

    public final int d() {
        return this.f31271e;
    }

    public final void a(ByteBuffer byteBuffer) {
        u uVar = (u) a.a(this.k);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f31273g += (long) remaining;
            int remaining2 = asShortBuffer.remaining() / uVar.f31259a;
            uVar.f31264f = uVar.a(uVar.f31264f, uVar.f31265g, remaining2);
            asShortBuffer.get(uVar.f31264f, uVar.f31265g * uVar.f31259a, ((uVar.f31259a * remaining2) * 2) / 2);
            uVar.f31265g += remaining2;
            uVar.b();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int a2 = uVar.a();
        if (a2 > 0) {
            if (this.l.capacity() < a2) {
                this.l = ByteBuffer.allocateDirect(a2).order(ByteOrder.nativeOrder());
                this.m = this.l.asShortBuffer();
            } else {
                this.l.clear();
                this.m.clear();
            }
            ShortBuffer shortBuffer = this.m;
            int min = Math.min(shortBuffer.remaining() / uVar.f31259a, uVar.f31267i);
            shortBuffer.put(uVar.f31266h, 0, uVar.f31259a * min);
            uVar.f31267i -= min;
            System.arraycopy(uVar.f31266h, min * uVar.f31259a, uVar.f31266h, 0, uVar.f31267i * uVar.f31259a);
            this.f31274h += (long) a2;
            this.l.limit(a2);
            this.n = this.l;
        }
    }

    public final void e() {
        u uVar = this.k;
        if (uVar != null) {
            int i2 = uVar.f31265g;
            int i3 = uVar.f31267i + ((int) ((((((float) i2) / (uVar.f31260b / uVar.f31261c)) + ((float) uVar.j)) / (uVar.f31262d * uVar.f31261c)) + 0.5f));
            uVar.f31264f = uVar.a(uVar.f31264f, uVar.f31265g, (uVar.f31263e * 2) + i2);
            for (int i4 = 0; i4 < uVar.f31263e * 2 * uVar.f31259a; i4++) {
                uVar.f31264f[(uVar.f31259a * i2) + i4] = 0;
            }
            uVar.f31265g += uVar.f31263e * 2;
            uVar.b();
            if (uVar.f31267i > i3) {
                uVar.f31267i = i3;
            }
            uVar.f31265g = 0;
            uVar.m = 0;
            uVar.j = 0;
        }
        this.o = true;
    }

    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.n;
        this.n = f31187a;
        return byteBuffer;
    }

    public final boolean g() {
        if (!this.o) {
            return false;
        }
        u uVar = this.k;
        return uVar == null || uVar.a() == 0;
    }

    public final void h() {
        if (a()) {
            if (this.f31272f) {
                this.k = new u(this.f31268b, this.f31275i, this.f31269c, this.f31270d, this.f31271e);
            } else {
                u uVar = this.k;
                if (uVar != null) {
                    uVar.f31265g = 0;
                    uVar.f31267i = 0;
                    uVar.j = 0;
                    uVar.k = 0;
                    uVar.l = 0;
                    uVar.m = 0;
                    uVar.n = 0;
                    uVar.o = 0;
                    uVar.p = 0;
                    uVar.q = 0;
                }
            }
        }
        this.n = f31187a;
        this.f31273g = 0;
        this.f31274h = 0;
        this.o = false;
    }

    public final void i() {
        this.f31269c = 1.0f;
        this.f31270d = 1.0f;
        this.f31275i = -1;
        this.f31268b = -1;
        this.f31271e = -1;
        this.l = f31187a;
        this.m = this.l.asShortBuffer();
        this.n = f31187a;
        this.j = -1;
        this.f31272f = false;
        this.k = null;
        this.f31273g = 0;
        this.f31274h = 0;
        this.o = false;
    }
}
