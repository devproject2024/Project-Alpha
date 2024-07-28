package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.g.a;
import java.util.Arrays;

final class q {

    /* renamed from: a  reason: collision with root package name */
    boolean f32071a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f32072b = new byte[131];

    /* renamed from: c  reason: collision with root package name */
    public int f32073c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32074d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32075e;

    public q(int i2) {
        this.f32074d = i2;
        this.f32072b[2] = 1;
    }

    public final void a() {
        this.f32075e = false;
        this.f32071a = false;
    }

    public final void a(int i2) {
        boolean z = true;
        a.b(!this.f32075e);
        if (i2 != this.f32074d) {
            z = false;
        }
        this.f32075e = z;
        if (this.f32075e) {
            this.f32073c = 3;
            this.f32071a = false;
        }
    }

    public final void a(byte[] bArr, int i2, int i3) {
        if (this.f32075e) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f32072b;
            int length = bArr2.length;
            int i5 = this.f32073c;
            if (length < i5 + i4) {
                this.f32072b = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.f32072b, this.f32073c, i4);
            this.f32073c += i4;
        }
    }

    public final boolean b(int i2) {
        if (!this.f32075e) {
            return false;
        }
        this.f32073c -= i2;
        this.f32075e = false;
        this.f32071a = true;
        return true;
    }
}
