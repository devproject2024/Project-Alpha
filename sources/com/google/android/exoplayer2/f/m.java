package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class m implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32404a;

    /* renamed from: b  reason: collision with root package name */
    private final int f32405b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f32406c;

    /* renamed from: d  reason: collision with root package name */
    private final a[] f32407d;

    /* renamed from: e  reason: collision with root package name */
    private int f32408e;

    /* renamed from: f  reason: collision with root package name */
    private int f32409f;

    /* renamed from: g  reason: collision with root package name */
    private int f32410g;

    /* renamed from: h  reason: collision with root package name */
    private a[] f32411h;

    public m() {
        this((byte) 0);
    }

    private m(byte b2) {
        a.a(true);
        a.a(true);
        this.f32404a = true;
        this.f32405b = 65536;
        this.f32410g = 0;
        this.f32411h = new a[100];
        this.f32406c = null;
        this.f32407d = new a[1];
    }

    public final synchronized void d() {
        if (this.f32404a) {
            a(0);
        }
    }

    public final synchronized void a(int i2) {
        boolean z = i2 < this.f32408e;
        this.f32408e = i2;
        if (z) {
            b();
        }
    }

    public final synchronized a a() {
        a aVar;
        this.f32409f++;
        if (this.f32410g > 0) {
            a[] aVarArr = this.f32411h;
            int i2 = this.f32410g - 1;
            this.f32410g = i2;
            aVar = aVarArr[i2];
            this.f32411h[this.f32410g] = null;
        } else {
            aVar = new a(new byte[this.f32405b]);
        }
        return aVar;
    }

    public final synchronized void a(a aVar) {
        this.f32407d[0] = aVar;
        a(this.f32407d);
    }

    public final synchronized void a(a[] aVarArr) {
        if (this.f32410g + aVarArr.length >= this.f32411h.length) {
            this.f32411h = (a[]) Arrays.copyOf(this.f32411h, Math.max(this.f32411h.length * 2, this.f32410g + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            a[] aVarArr2 = this.f32411h;
            int i2 = this.f32410g;
            this.f32410g = i2 + 1;
            aVarArr2[i2] = aVar;
        }
        this.f32409f -= aVarArr.length;
        notifyAll();
    }

    public final synchronized void b() {
        int i2 = 0;
        int max = Math.max(0, ae.a(this.f32408e, this.f32405b) - this.f32409f);
        if (max < this.f32410g) {
            if (this.f32406c != null) {
                int i3 = this.f32410g - 1;
                while (i2 <= i3) {
                    a aVar = this.f32411h[i2];
                    if (aVar.f32309a == this.f32406c) {
                        i2++;
                    } else {
                        a aVar2 = this.f32411h[i3];
                        if (aVar2.f32309a != this.f32406c) {
                            i3--;
                        } else {
                            this.f32411h[i2] = aVar2;
                            this.f32411h[i3] = aVar;
                            i3--;
                            i2++;
                        }
                    }
                }
                max = Math.max(max, i2);
                if (max >= this.f32410g) {
                    return;
                }
            }
            Arrays.fill(this.f32411h, max, this.f32410g, (Object) null);
            this.f32410g = max;
        }
    }

    public final synchronized int e() {
        return this.f32409f * this.f32405b;
    }

    public final int c() {
        return this.f32405b;
    }
}
