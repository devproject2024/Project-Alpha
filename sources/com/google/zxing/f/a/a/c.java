package com.google.zxing.f.a.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final b f40427a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f40428b;

    public c(b bVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f40427a = bVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f40428b = iArr;
                return;
            }
            int i2 = 1;
            while (i2 < length && iArr[i2] == 0) {
                i2++;
            }
            if (i2 == length) {
                this.f40428b = new int[]{0};
                return;
            }
            this.f40428b = new int[(length - i2)];
            int[] iArr2 = this.f40428b;
            System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    public final boolean a() {
        return this.f40428b[0] == 0;
    }

    public final int a(int i2) {
        int[] iArr = this.f40428b;
        return iArr[(iArr.length - 1) - i2];
    }

    public final int b(int i2) {
        if (i2 == 0) {
            return a(0);
        }
        if (i2 == 1) {
            int i3 = 0;
            for (int b2 : this.f40428b) {
                i3 = this.f40427a.b(i3, b2);
            }
            return i3;
        }
        int[] iArr = this.f40428b;
        int i4 = iArr[0];
        int length = iArr.length;
        for (int i5 = 1; i5 < length; i5++) {
            b bVar = this.f40427a;
            i4 = bVar.b(bVar.d(i2, i4), this.f40428b[i5]);
        }
        return i4;
    }

    public final c a(c cVar) {
        if (!this.f40427a.equals(cVar.f40427a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (a()) {
            return cVar;
        } else {
            if (cVar.a()) {
                return this;
            }
            int[] iArr = this.f40428b;
            int[] iArr2 = cVar.f40428b;
            if (iArr.length > iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            for (int i2 = length; i2 < iArr2.length; i2++) {
                iArr4[i2] = this.f40427a.b(iArr[i2 - length], iArr2[i2]);
            }
            return new c(this.f40427a, iArr4);
        }
    }

    public final c b(c cVar) {
        if (!this.f40427a.equals(cVar.f40427a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (cVar.a()) {
            return this;
        } else {
            return a(cVar.b());
        }
    }

    public final c c(c cVar) {
        if (!this.f40427a.equals(cVar.f40427a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (a() || cVar.a()) {
            return this.f40427a.f40424d;
        } else {
            int[] iArr = this.f40428b;
            int length = iArr.length;
            int[] iArr2 = cVar.f40428b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = iArr[i2];
                for (int i4 = 0; i4 < length2; i4++) {
                    int i5 = i2 + i4;
                    b bVar = this.f40427a;
                    iArr3[i5] = bVar.b(iArr3[i5], bVar.d(i3, iArr2[i4]));
                }
            }
            return new c(this.f40427a, iArr3);
        }
    }

    public final c b() {
        int length = this.f40428b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f40427a.c(0, this.f40428b[i2]);
        }
        return new c(this.f40427a, iArr);
    }

    public final c c(int i2) {
        if (i2 == 0) {
            return this.f40427a.f40424d;
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f40428b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f40427a.d(this.f40428b[i3], i2);
        }
        return new c(this.f40427a, iArr);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f40428b.length - 1) * 8);
        for (int length = this.f40428b.length - 1; length >= 0; length--) {
            int a2 = a(length);
            if (a2 != 0) {
                if (a2 < 0) {
                    sb.append(" - ");
                    a2 = -a2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (length == 0 || a2 != 1) {
                    sb.append(a2);
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
