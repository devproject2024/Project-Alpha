package com.google.zxing.b;

import java.util.Arrays;

public final class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public int[] f39880a;

    /* renamed from: b  reason: collision with root package name */
    public int f39881b;

    public a() {
        this.f39881b = 0;
        this.f39880a = new int[1];
    }

    public a(int i2) {
        this.f39881b = i2;
        this.f39880a = f(i2);
    }

    private a(int[] iArr, int i2) {
        this.f39880a = iArr;
        this.f39881b = i2;
    }

    public final int a() {
        return (this.f39881b + 7) / 8;
    }

    private void e(int i2) {
        if (i2 > (this.f39880a.length << 5)) {
            int[] f2 = f(i2);
            int[] iArr = this.f39880a;
            System.arraycopy(iArr, 0, f2, 0, iArr.length);
            this.f39880a = f2;
        }
    }

    public final boolean a(int i2) {
        return ((1 << (i2 & 31)) & this.f39880a[i2 / 32]) != 0;
    }

    public final void b(int i2) {
        int[] iArr = this.f39880a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public final int c(int i2) {
        int i3 = this.f39881b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & this.f39880a[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f39880a;
            if (i4 == iArr.length) {
                return this.f39881b;
            }
            i5 = iArr[i4];
        }
        int numberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f39881b;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    public final int d(int i2) {
        int i3 = this.f39881b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & (~this.f39880a[i4]);
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f39880a;
            if (i4 == iArr.length) {
                return this.f39881b;
            }
            i5 = ~iArr[i4];
        }
        int numberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f39881b;
        return numberOfTrailingZeros > i6 ? i6 : numberOfTrailingZeros;
    }

    public final void b() {
        int length = this.f39880a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f39880a[i2] = 0;
        }
    }

    public final boolean a(int i2, int i3) {
        if (i3 < i2 || i2 < 0 || i3 > this.f39881b) {
            throw new IllegalArgumentException();
        } else if (i3 == i2) {
            return true;
        } else {
            int i4 = i3 - 1;
            int i5 = i2 / 32;
            int i6 = i4 / 32;
            int i7 = i5;
            while (i7 <= i6) {
                int i8 = 31;
                int i9 = i7 > i5 ? 0 : i2 & 31;
                if (i7 >= i6) {
                    i8 = 31 & i4;
                }
                if ((((2 << i8) - (1 << i9)) & this.f39880a[i7]) != 0) {
                    return false;
                }
                i7++;
            }
            return true;
        }
    }

    public final void a(boolean z) {
        e(this.f39881b + 1);
        if (z) {
            int[] iArr = this.f39880a;
            int i2 = this.f39881b;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.f39881b++;
    }

    public final void b(int i2, int i3) {
        if (i3 < 0 || i3 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        e(this.f39881b + i3);
        while (i3 > 0) {
            boolean z = true;
            if (((i2 >> (i3 - 1)) & 1) != 1) {
                z = false;
            }
            a(z);
            i3--;
        }
    }

    public final void a(a aVar) {
        int i2 = aVar.f39881b;
        e(this.f39881b + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a(aVar.a(i3));
        }
    }

    public final void a(int i2, byte[] bArr, int i3) {
        int i4 = i2;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = i4;
            int i7 = 0;
            for (int i8 = 0; i8 < 8; i8++) {
                if (a(i6)) {
                    i7 |= 1 << (7 - i8);
                }
                i6++;
            }
            bArr[i5 + 0] = (byte) i7;
            i5++;
            i4 = i6;
        }
    }

    public final void c() {
        int[] iArr = new int[this.f39880a.length];
        int i2 = (this.f39881b - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j = (long) this.f39880a[i4];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i5 = this.f39881b;
        int i6 = i3 << 5;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = iArr[0] >>> i7;
            for (int i9 = 1; i9 < i3; i9++) {
                int i10 = iArr[i9];
                iArr[i9 - 1] = i8 | (i10 << (32 - i7));
                i8 = i10 >>> i7;
            }
            iArr[i3 - 1] = i8;
        }
        this.f39880a = iArr;
    }

    private static int[] f(int i2) {
        return new int[((i2 + 31) / 32)];
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f39881b != aVar.f39881b || !Arrays.equals(this.f39880a, aVar.f39880a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.f39881b * 31) + Arrays.hashCode(this.f39880a);
    }

    public final String toString() {
        int i2 = this.f39881b;
        StringBuilder sb = new StringBuilder(i2 + (i2 / 8) + 1);
        for (int i3 = 0; i3 < this.f39881b; i3++) {
            if ((i3 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i3) ? 'X' : '.');
        }
        return sb.toString();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new a((int[]) this.f39880a.clone(), this.f39881b);
    }
}
