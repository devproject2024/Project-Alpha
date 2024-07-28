package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.g.r;

public final class ad {
    public static int a(byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] != 71) {
            i2++;
        }
        return i2;
    }

    public static long a(r rVar, int i2, int i3) {
        rVar.c(i2);
        if (rVar.b() < 5) {
            return -9223372036854775807L;
        }
        int i4 = rVar.i();
        if ((8388608 & i4) != 0 || ((2096896 & i4) >> 8) != i3) {
            return -9223372036854775807L;
        }
        boolean z = true;
        if (((i4 & 32) != 0) && rVar.c() >= 7 && rVar.b() >= 7) {
            if ((rVar.c() & 16) != 16) {
                z = false;
            }
            if (z) {
                byte[] bArr = new byte[6];
                rVar.a(bArr, 0, 6);
                return a(bArr);
            }
        }
        return -9223372036854775807L;
    }

    private static long a(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
