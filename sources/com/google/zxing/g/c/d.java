package com.google.zxing.g.c;

final class d {
    static boolean a(byte[] bArr, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean a(byte[][] bArr, int i2, int i3, int i4) {
        int min = Math.min(i4, bArr.length);
        for (int max = Math.max(i3, 0); max < min; max++) {
            if (bArr[max][i2] == 1) {
                return false;
            }
        }
        return true;
    }

    static int a(b bVar, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = bVar.f40549c;
        } else {
            i2 = bVar.f40548b;
        }
        if (z) {
            i3 = bVar.f40548b;
        } else {
            i3 = bVar.f40549c;
        }
        byte[][] bArr = bVar.f40547a;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i4;
            int i7 = 0;
            byte b2 = -1;
            for (int i8 = 0; i8 < i3; i8++) {
                byte b3 = z ? bArr[i5][i8] : bArr[i8][i5];
                if (b3 == b2) {
                    i7++;
                } else {
                    if (i7 >= 5) {
                        i6 += (i7 - 5) + 3;
                    }
                    i7 = 1;
                    b2 = b3;
                }
            }
            if (i7 >= 5) {
                i6 += (i7 - 5) + 3;
            }
            i4 = i6;
        }
        return i4;
    }
}
