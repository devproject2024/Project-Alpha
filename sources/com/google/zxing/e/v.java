package com.google.zxing.e;

import com.google.zxing.b.a;
import com.google.zxing.m;
import com.google.zxing.r;
import com.google.zxing.s;
import com.google.zxing.t;
import java.util.EnumMap;

final class v {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f40394a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f40395b = new StringBuilder();

    v() {
    }

    /* access modifiers changed from: package-private */
    public final r a(int i2, a aVar, int[] iArr) throws m {
        EnumMap enumMap;
        a aVar2 = aVar;
        StringBuilder sb = this.f40395b;
        sb.setLength(0);
        int[] iArr2 = this.f40394a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i3 = aVar2.f39881b;
        int i4 = iArr[1];
        int i5 = 0;
        int i6 = 0;
        while (i5 < 2 && i4 < i3) {
            int a2 = y.a(aVar2, iArr2, i4, y.f40406f);
            sb.append((char) ((a2 % 10) + 48));
            int i7 = i4;
            for (int i8 : iArr2) {
                i7 += i8;
            }
            if (a2 >= 10) {
                i6 = (1 << (1 - i5)) | i6;
            }
            i4 = i5 != 1 ? aVar2.d(aVar2.c(i7)) : i7;
            i5++;
        }
        if (sb.length() != 2) {
            throw m.getNotFoundInstance();
        } else if (Integer.parseInt(sb.toString()) % 4 == i6) {
            String sb2 = sb.toString();
            if (sb2.length() != 2) {
                enumMap = null;
            } else {
                enumMap = new EnumMap(s.class);
                enumMap.put(s.ISSUE_NUMBER, Integer.valueOf(sb2));
            }
            float f2 = (float) i2;
            r rVar = new r(sb2, (byte[]) null, new t[]{new t(((float) (iArr[0] + iArr[1])) / 2.0f, f2), new t((float) i4, f2)}, com.google.zxing.a.UPC_EAN_EXTENSION);
            if (enumMap != null) {
                rVar.a(enumMap);
            }
            return rVar;
        } else {
            throw m.getNotFoundInstance();
        }
    }
}
