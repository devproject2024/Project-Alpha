package com.google.zxing.e;

import com.google.zxing.b.a;
import com.google.zxing.h;
import com.google.zxing.m;

public final class aa extends y {

    /* renamed from: a  reason: collision with root package name */
    static final int[][] f40359a = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f40360g = {1, 1, 1, 1, 1, 1};

    /* renamed from: h  reason: collision with root package name */
    private final int[] f40361h = new int[4];

    /* access modifiers changed from: protected */
    public final int a(a aVar, int[] iArr, StringBuilder sb) throws m {
        int[] iArr2 = this.f40361h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = aVar.f39881b;
        int i3 = iArr[1];
        int i4 = 0;
        int i5 = 0;
        while (i4 < 6 && i3 < i2) {
            int a2 = a(aVar, iArr2, i3, f40406f);
            sb.append((char) ((a2 % 10) + 48));
            int i6 = i3;
            for (int i7 : iArr2) {
                i6 += i7;
            }
            if (a2 >= 10) {
                i5 = (1 << (5 - i4)) | i5;
            }
            i4++;
            i3 = i6;
        }
        for (int i8 = 0; i8 <= 1; i8++) {
            for (int i9 = 0; i9 < 10; i9++) {
                if (i5 == f40359a[i8][i9]) {
                    sb.insert(0, (char) (i8 + 48));
                    sb.append((char) (i9 + 48));
                    return i3;
                }
            }
        }
        throw m.getNotFoundInstance();
    }

    /* access modifiers changed from: protected */
    public final int[] a(a aVar, int i2) throws m {
        return a(aVar, i2, true, f40360g);
    }

    /* access modifiers changed from: protected */
    public final boolean a(String str) throws h {
        return super.a(b(str));
    }

    /* access modifiers changed from: package-private */
    public final com.google.zxing.a b() {
        return com.google.zxing.a.UPC_E;
    }

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }
}
