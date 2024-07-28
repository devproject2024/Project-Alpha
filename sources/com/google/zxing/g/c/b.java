package com.google.zxing.g.c;

import java.lang.reflect.Array;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final byte[][] f40547a;

    /* renamed from: b  reason: collision with root package name */
    public final int f40548b;

    /* renamed from: c  reason: collision with root package name */
    public final int f40549c;

    public b(int i2, int i3) {
        this.f40547a = (byte[][]) Array.newInstance(byte.class, new int[]{i3, i2});
        this.f40548b = i2;
        this.f40549c = i3;
    }

    public final byte a(int i2, int i3) {
        return this.f40547a[i3][i2];
    }

    public final void a(int i2, int i3, int i4) {
        this.f40547a[i3][i2] = (byte) i4;
    }

    public final void a(int i2, int i3, boolean z) {
        this.f40547a[i3][i2] = z ? (byte) 1 : 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f40548b * 2 * this.f40549c) + 2);
        for (int i2 = 0; i2 < this.f40549c; i2++) {
            byte[] bArr = this.f40547a[i2];
            for (int i3 = 0; i3 < this.f40548b; i3++) {
                byte b2 = bArr[i3];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
