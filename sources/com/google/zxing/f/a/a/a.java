package com.google.zxing.f.a.a;

import com.google.zxing.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f40420a = b.f40421a;

    public final int[] a(c cVar) throws d {
        int length = cVar.f40428b.length - 1;
        int[] iArr = new int[length];
        int i2 = 0;
        for (int i3 = 1; i3 < this.f40420a.f40426f && i2 < length; i3++) {
            if (cVar.b(i3) == 0) {
                iArr[i2] = this.f40420a.a(i3);
                i2++;
            }
        }
        if (i2 == length) {
            return iArr;
        }
        throw d.getChecksumInstance();
    }

    public final int[] a(c cVar, c cVar2, int[] iArr) {
        int length = cVar2.f40428b.length - 1;
        int[] iArr2 = new int[length];
        for (int i2 = 1; i2 <= length; i2++) {
            iArr2[length - i2] = this.f40420a.d(i2, cVar2.a(i2));
        }
        c cVar3 = new c(this.f40420a, iArr2);
        int length2 = iArr.length;
        int[] iArr3 = new int[length2];
        for (int i3 = 0; i3 < length2; i3++) {
            int a2 = this.f40420a.a(iArr[i3]);
            iArr3[i3] = this.f40420a.d(this.f40420a.c(0, cVar.b(a2)), this.f40420a.a(cVar3.b(a2)));
        }
        return iArr3;
    }
}
