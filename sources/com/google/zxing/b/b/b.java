package com.google.zxing.b.b;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final int[] f39902a;

    /* renamed from: b  reason: collision with root package name */
    private final a f39903b;

    b(a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f39903b = aVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f39902a = iArr;
                return;
            }
            int i2 = 1;
            while (i2 < length && iArr[i2] == 0) {
                i2++;
            }
            if (i2 == length) {
                this.f39902a = new int[]{0};
                return;
            }
            this.f39902a = new int[(length - i2)];
            int[] iArr2 = this.f39902a;
            System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.f39902a[0] == 0;
    }

    /* access modifiers changed from: package-private */
    public final int a(int i2) {
        int[] iArr = this.f39902a;
        return iArr[(iArr.length - 1) - i2];
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2) {
        if (i2 == 0) {
            return a(0);
        }
        if (i2 == 1) {
            int i3 = 0;
            for (int b2 : this.f39902a) {
                i3 = a.b(i3, b2);
            }
            return i3;
        }
        int[] iArr = this.f39902a;
        int i4 = iArr[0];
        int length = iArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            i4 = a.b(this.f39903b.c(i2, i4), this.f39902a[i5]);
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public final b a(b bVar) {
        if (!this.f39903b.equals(bVar.f39903b)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (a()) {
            return bVar;
        } else {
            if (bVar.a()) {
                return this;
            }
            int[] iArr = this.f39902a;
            int[] iArr2 = bVar.f39902a;
            if (iArr.length > iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            for (int i2 = length; i2 < iArr2.length; i2++) {
                iArr4[i2] = a.b(iArr[i2 - length], iArr2[i2]);
            }
            return new b(this.f39903b, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    public final b b(b bVar) {
        if (!this.f39903b.equals(bVar.f39903b)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (a() || bVar.a()) {
            return this.f39903b.j;
        } else {
            int[] iArr = this.f39902a;
            int length = iArr.length;
            int[] iArr2 = bVar.f39902a;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = iArr[i2];
                for (int i4 = 0; i4 < length2; i4++) {
                    int i5 = i2 + i4;
                    iArr3[i5] = a.b(iArr3[i5], this.f39903b.c(i3, iArr2[i4]));
                }
            }
            return new b(this.f39903b, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public final b c(int i2) {
        if (i2 == 0) {
            return this.f39903b.j;
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f39902a.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f39903b.c(this.f39902a[i3], i2);
        }
        return new b(this.f39903b, iArr);
    }

    /* access modifiers changed from: package-private */
    public final b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.f39903b.j;
        } else {
            int length = this.f39902a.length;
            int[] iArr = new int[(i2 + length)];
            for (int i4 = 0; i4 < length; i4++) {
                iArr[i4] = this.f39903b.c(this.f39902a[i4], i3);
            }
            return new b(this.f39903b, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final b[] c(b bVar) {
        if (!this.f39903b.equals(bVar.f39903b)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (!bVar.a()) {
            b bVar2 = this.f39903b.j;
            int b2 = this.f39903b.b(bVar.a(bVar.f39902a.length - 1));
            b bVar3 = bVar2;
            b bVar4 = this;
            while (bVar4.f39902a.length - 1 >= bVar.f39902a.length - 1 && !bVar4.a()) {
                int[] iArr = bVar4.f39902a;
                int length = (iArr.length - 1) - (bVar.f39902a.length - 1);
                int c2 = this.f39903b.c(bVar4.a(iArr.length - 1), b2);
                b a2 = bVar.a(length, c2);
                bVar3 = bVar3.a(this.f39903b.a(length, c2));
                bVar4 = bVar4.a(a2);
            }
            return new b[]{bVar3, bVar4};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f39902a.length - 1) * 8);
        for (int length = this.f39902a.length - 1; length >= 0; length--) {
            int a2 = a(length);
            if (a2 != 0) {
                if (a2 < 0) {
                    sb.append(" - ");
                    a2 = -a2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (length == 0 || a2 != 1) {
                    int a3 = this.f39903b.a(a2);
                    if (a3 == 0) {
                        sb.append('1');
                    } else if (a3 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(a3);
                    }
                }
                if (length != 0) {
                    if (length == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(length);
                    }
                }
            }
        }
        return sb.toString();
    }
}
