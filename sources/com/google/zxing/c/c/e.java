package com.google.zxing.c.c;

import java.util.Arrays;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f39970a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f39971b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f39972c;

    /* renamed from: d  reason: collision with root package name */
    private final int f39973d;

    public e(CharSequence charSequence, int i2, int i3) {
        this.f39972c = charSequence;
        this.f39970a = i2;
        this.f39973d = i3;
        this.f39971b = new byte[(i2 * i3)];
        Arrays.fill(this.f39971b, (byte) -1);
    }

    private void a(int i2, int i3, boolean z) {
        this.f39971b[(i3 * this.f39970a) + i2] = z ? (byte) 1 : 0;
    }

    private boolean a(int i2, int i3) {
        return this.f39971b[(i3 * this.f39970a) + i2] >= 0;
    }

    public final void a() {
        int i2;
        int i3;
        int i4 = 4;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = this.f39973d;
            if (i4 == i7 && i5 == 0) {
                a(i7 - 1, 0, i6, 1);
                a(this.f39973d - 1, 1, i6, 2);
                a(this.f39973d - 1, 2, i6, 3);
                a(0, this.f39970a - 2, i6, 4);
                a(0, this.f39970a - 1, i6, 5);
                a(1, this.f39970a - 1, i6, 6);
                a(2, this.f39970a - 1, i6, 7);
                a(3, this.f39970a - 1, i6, 8);
                i6++;
            }
            int i8 = this.f39973d;
            if (i4 == i8 - 2 && i5 == 0 && this.f39970a % 4 != 0) {
                a(i8 - 3, 0, i6, 1);
                a(this.f39973d - 2, 0, i6, 2);
                a(this.f39973d - 1, 0, i6, 3);
                a(0, this.f39970a - 4, i6, 4);
                a(0, this.f39970a - 3, i6, 5);
                a(0, this.f39970a - 2, i6, 6);
                a(0, this.f39970a - 1, i6, 7);
                a(1, this.f39970a - 1, i6, 8);
                i6++;
            }
            int i9 = this.f39973d;
            if (i4 == i9 - 2 && i5 == 0 && this.f39970a % 8 == 4) {
                a(i9 - 3, 0, i6, 1);
                a(this.f39973d - 2, 0, i6, 2);
                a(this.f39973d - 1, 0, i6, 3);
                a(0, this.f39970a - 2, i6, 4);
                a(0, this.f39970a - 1, i6, 5);
                a(1, this.f39970a - 1, i6, 6);
                a(2, this.f39970a - 1, i6, 7);
                a(3, this.f39970a - 1, i6, 8);
                i6++;
            }
            int i10 = this.f39973d;
            if (i4 == i10 + 4 && i5 == 2 && this.f39970a % 8 == 0) {
                a(i10 - 1, 0, i6, 1);
                a(this.f39973d - 1, this.f39970a - 1, i6, 2);
                a(0, this.f39970a - 3, i6, 3);
                a(0, this.f39970a - 2, i6, 4);
                a(0, this.f39970a - 1, i6, 5);
                a(1, this.f39970a - 3, i6, 6);
                a(1, this.f39970a - 2, i6, 7);
                a(1, this.f39970a - 1, i6, 8);
                i6++;
            }
            do {
                if (i4 < this.f39973d && i5 >= 0 && !a(i5, i4)) {
                    a(i4, i5, i6);
                    i6++;
                }
                i4 -= 2;
                i5 += 2;
                if (i4 < 0 || i5 >= this.f39970a) {
                    int i11 = i4 + 1;
                    int i12 = i5 + 3;
                }
                a(i4, i5, i6);
                i6++;
                i4 -= 2;
                i5 += 2;
                break;
            } while (i5 >= this.f39970a);
            int i112 = i4 + 1;
            int i122 = i5 + 3;
            do {
                if (i112 >= 0 && i122 < this.f39970a && !a(i122, i112)) {
                    a(i112, i122, i6);
                    i6++;
                }
                i112 += 2;
                i122 -= 2;
                if (i112 >= this.f39973d) {
                    break;
                }
            } while (i122 >= 0);
            i4 = i112 + 3;
            i5 = i122 + 1;
            i2 = this.f39973d;
            if (i4 >= i2 && i5 >= (i3 = this.f39970a)) {
                break;
            }
        }
        if (!a(i3 - 1, i2 - 1)) {
            a(this.f39970a - 1, this.f39973d - 1, true);
            a(this.f39970a - 2, this.f39973d - 2, true);
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            int i6 = this.f39973d;
            i2 += i6;
            i3 += 4 - ((i6 + 4) % 8);
        }
        if (i3 < 0) {
            int i7 = this.f39970a;
            i3 += i7;
            i2 += 4 - ((i7 + 4) % 8);
        }
        boolean z = true;
        if ((this.f39972c.charAt(i4) & (1 << (8 - i5))) == 0) {
            z = false;
        }
        a(i3, i2, z);
    }

    private void a(int i2, int i3, int i4) {
        int i5 = i2 - 2;
        int i6 = i3 - 2;
        a(i5, i6, i4, 1);
        int i7 = i3 - 1;
        a(i5, i7, i4, 2);
        int i8 = i2 - 1;
        a(i8, i6, i4, 3);
        a(i8, i7, i4, 4);
        a(i8, i3, i4, 5);
        a(i2, i6, i4, 6);
        a(i2, i7, i4, 7);
        a(i2, i3, i4, 8);
    }
}
