package com.google.android.exoplayer2.g;

import java.util.Arrays;

public final class aa<V> {

    /* renamed from: a  reason: collision with root package name */
    private long[] f32492a;

    /* renamed from: b  reason: collision with root package name */
    private V[] f32493b;

    /* renamed from: c  reason: collision with root package name */
    private int f32494c;

    /* renamed from: d  reason: collision with root package name */
    private int f32495d;

    public aa() {
        this((byte) 0);
    }

    private aa(byte b2) {
        this.f32492a = new long[10];
        this.f32493b = (Object[]) new Object[10];
    }

    public final synchronized void a() {
        this.f32494c = 0;
        this.f32495d = 0;
        Arrays.fill(this.f32493b, (Object) null);
    }

    public final synchronized V a(long j) {
        return a(j, true);
    }

    public final synchronized V b(long j) {
        return a(j, false);
    }

    private V a(long j, boolean z) {
        long j2 = Long.MAX_VALUE;
        V v = null;
        while (this.f32495d > 0) {
            long j3 = j - this.f32492a[this.f32494c];
            if (j3 < 0 && (z || (-j3) >= j2)) {
                break;
            }
            V[] vArr = this.f32493b;
            int i2 = this.f32494c;
            v = vArr[i2];
            vArr[i2] = null;
            this.f32494c = (i2 + 1) % vArr.length;
            this.f32495d--;
            j2 = j3;
        }
        return v;
    }

    public final synchronized void a(long j, V v) {
        if (this.f32495d > 0) {
            if (j <= this.f32492a[((this.f32494c + this.f32495d) - 1) % this.f32493b.length]) {
                a();
            }
        }
        int length = this.f32493b.length;
        if (this.f32495d >= length) {
            int i2 = length * 2;
            long[] jArr = new long[i2];
            V[] vArr = (Object[]) new Object[i2];
            int i3 = length - this.f32494c;
            System.arraycopy(this.f32492a, this.f32494c, jArr, 0, i3);
            System.arraycopy(this.f32493b, this.f32494c, vArr, 0, i3);
            if (this.f32494c > 0) {
                System.arraycopy(this.f32492a, 0, jArr, i3, this.f32494c);
                System.arraycopy(this.f32493b, 0, vArr, i3, this.f32494c);
            }
            this.f32492a = jArr;
            this.f32493b = vArr;
            this.f32494c = 0;
        }
        int length2 = (this.f32494c + this.f32495d) % this.f32493b.length;
        this.f32492a[length2] = j;
        this.f32493b[length2] = v;
        this.f32495d++;
    }
}
