package com.google.zxing.b;

import com.business.merchant_payments.utility.StringUtility;
import java.util.Arrays;

public final class b implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public final int f39889a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39890b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39891c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f39892d;

    public b(int i2) {
        this(i2, i2);
    }

    public b(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f39889a = i2;
        this.f39890b = i3;
        this.f39891c = (i2 + 31) / 32;
        this.f39892d = new int[(this.f39891c * i3)];
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.f39889a = i2;
        this.f39890b = i3;
        this.f39891c = i4;
        this.f39892d = iArr;
    }

    public final boolean a(int i2, int i3) {
        return ((this.f39892d[(i3 * this.f39891c) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public final void b(int i2, int i3) {
        int i4 = (i3 * this.f39891c) + (i2 / 32);
        int[] iArr = this.f39892d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public final void c(int i2, int i3) {
        int i4 = (i3 * this.f39891c) + (i2 / 32);
        int[] iArr = this.f39892d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public final void a() {
        int length = this.f39892d.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f39892d[i2] = 0;
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i5 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.f39890b || i6 > this.f39889a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.f39891c * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.f39892d;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
        }
    }

    public final int[] b() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f39892d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                int[] iArr2 = this.f39892d;
            } else {
                i2++;
            }
        }
        int[] iArr22 = this.f39892d;
        if (i2 == iArr22.length) {
            return null;
        }
        int i3 = this.f39891c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        int i6 = iArr22[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    public final int[] c() {
        int length = this.f39892d.length - 1;
        while (length >= 0 && this.f39892d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.f39891c;
        int i3 = length / i2;
        int i4 = (length % i2) << 5;
        int i5 = 31;
        while ((this.f39892d[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f39889a == bVar.f39889a && this.f39890b == bVar.f39890b && this.f39891c == bVar.f39891c && Arrays.equals(this.f39892d, bVar.f39892d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f39889a;
        return (((((((i2 * 31) + i2) * 31) + this.f39890b) * 31) + this.f39891c) * 31) + Arrays.hashCode(this.f39892d);
    }

    /* renamed from: d */
    public final b clone() {
        return new b(this.f39889a, this.f39890b, this.f39891c, (int[]) this.f39892d.clone());
    }

    public final a a(int i2, a aVar) {
        if (aVar == null || aVar.f39881b < this.f39889a) {
            aVar = new a(this.f39889a);
        } else {
            aVar.b();
        }
        int i3 = i2 * this.f39891c;
        for (int i4 = 0; i4 < this.f39891c; i4++) {
            aVar.f39880a[(i4 << 5) / 32] = this.f39892d[i3 + i4];
        }
        return aVar;
    }

    public final void b(int i2, a aVar) {
        int[] iArr = aVar.f39880a;
        int[] iArr2 = this.f39892d;
        int i3 = this.f39891c;
        System.arraycopy(iArr, 0, iArr2, i2 * i3, i3);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.f39890b * (this.f39889a + 1));
        for (int i2 = 0; i2 < this.f39890b; i2++) {
            for (int i3 = 0; i3 < this.f39889a; i3++) {
                sb.append(a(i3, i2) ? "X " : "  ");
            }
            sb.append(StringUtility.NEW_LINE);
        }
        return sb.toString();
    }
}
