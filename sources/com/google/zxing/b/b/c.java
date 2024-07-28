package com.google.zxing.b.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f39904a;

    public c(a aVar) {
        this.f39904a = aVar;
    }

    public final void a(int[] iArr, int i2) throws e {
        b bVar = new b(this.f39904a, iArr);
        int[] iArr2 = new int[i2];
        int i3 = 0;
        boolean z = true;
        for (int i4 = 0; i4 < i2; i4++) {
            a aVar = this.f39904a;
            int b2 = bVar.b(aVar.f39901i[aVar.m + i4]);
            iArr2[(i2 - 1) - i4] = b2;
            if (b2 != 0) {
                z = false;
            }
        }
        if (!z) {
            b[] a2 = a(this.f39904a.a(i2, 1), new b(this.f39904a, iArr2), i2);
            b bVar2 = a2[0];
            b bVar3 = a2[1];
            int[] a3 = a(bVar2);
            int[] a4 = a(bVar3, a3);
            while (i3 < a3.length) {
                int length = (iArr.length - 1) - this.f39904a.a(a3[i3]);
                if (length >= 0) {
                    iArr[length] = a.b(iArr[length], a4[i3]);
                    i3++;
                } else {
                    throw new e("Bad error location");
                }
            }
        }
    }

    private int[] a(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int b2 = this.f39904a.b(iArr[i2]);
            int i3 = 1;
            for (int i4 = 0; i4 < length; i4++) {
                if (i2 != i4) {
                    int c2 = this.f39904a.c(iArr[i4], b2);
                    i3 = this.f39904a.c(i3, (c2 & 1) == 0 ? c2 | 1 : c2 & -2);
                }
            }
            iArr2[i2] = this.f39904a.c(bVar.b(b2), this.f39904a.b(i3));
            if (this.f39904a.m != 0) {
                iArr2[i2] = this.f39904a.c(iArr2[i2], b2);
            }
        }
        return iArr2;
    }

    private b[] a(b bVar, b bVar2, int i2) throws e {
        if (bVar.f39902a.length - 1 < bVar2.f39902a.length - 1) {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
        }
        b bVar4 = this.f39904a.j;
        b bVar5 = this.f39904a.k;
        do {
            b bVar6 = r12;
            r12 = bVar;
            bVar = bVar6;
            b bVar7 = bVar5;
            b bVar8 = bVar4;
            bVar4 = bVar7;
            if (bVar.f39902a.length - 1 < i2 / 2) {
                int a2 = bVar4.a(0);
                if (a2 != 0) {
                    int b2 = this.f39904a.b(a2);
                    return new b[]{bVar4.c(b2), bVar.c(b2)};
                }
                throw new e("sigmaTilde(0) was zero");
            } else if (!bVar.a()) {
                b bVar9 = this.f39904a.j;
                int b3 = this.f39904a.b(bVar.a(bVar.f39902a.length - 1));
                while (r12.f39902a.length - 1 >= bVar.f39902a.length - 1 && !r12.a()) {
                    int length = (r12.f39902a.length - 1) - (bVar.f39902a.length - 1);
                    int c2 = this.f39904a.c(r12.a(r12.f39902a.length - 1), b3);
                    bVar9 = bVar9.a(this.f39904a.a(length, c2));
                    r12 = r12.a(bVar.a(length, c2));
                }
                bVar5 = bVar9.b(bVar4).a(bVar8);
            } else {
                throw new e("r_{i-1} was zero");
            }
        } while (r12.f39902a.length - 1 < bVar.f39902a.length - 1);
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    private int[] a(b bVar) throws e {
        int length = bVar.f39902a.length - 1;
        int i2 = 0;
        if (length == 1) {
            return new int[]{bVar.a(1)};
        }
        int[] iArr = new int[length];
        for (int i3 = 1; i3 < this.f39904a.l && i2 < length; i3++) {
            if (bVar.b(i3) == 0) {
                iArr[i2] = this.f39904a.b(i3);
                i2++;
            }
        }
        if (i2 == length) {
            return iArr;
        }
        throw new e("Error locator degree does not match number of roots");
    }
}
