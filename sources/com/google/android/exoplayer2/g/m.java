package com.google.android.exoplayer2.g;

import java.util.Arrays;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public int f32540a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f32541b;

    public m() {
        this((byte) 0);
    }

    private m(byte b2) {
        this.f32541b = new long[32];
    }

    public final void a(long j) {
        int i2 = this.f32540a;
        long[] jArr = this.f32541b;
        if (i2 == jArr.length) {
            this.f32541b = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.f32541b;
        int i3 = this.f32540a;
        this.f32540a = i3 + 1;
        jArr2[i3] = j;
    }

    public final long a(int i2) {
        if (i2 >= 0 && i2 < this.f32540a) {
            return this.f32541b[i2];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + this.f32540a);
    }

    public final long[] a() {
        return Arrays.copyOf(this.f32541b, this.f32540a);
    }
}
