package com.google.android.gms.internal.vision;

import com.alipay.mobile.nebula.util.tar.TarHeader;

final class hl {
    static /* synthetic */ boolean a(byte b2) {
        return b2 < -32;
    }

    static /* synthetic */ boolean b(byte b2) {
        return b2 < -16;
    }

    private static boolean c(byte b2) {
        return b2 > -65;
    }

    static /* synthetic */ void a(byte b2, byte b3, char[] cArr, int i2) throws eu {
        if (b2 < -62 || c(b3)) {
            throw eu.zzgt();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    static /* synthetic */ void a(byte b2, byte b3, byte b4, char[] cArr, int i2) throws eu {
        if (c(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || c(b4)))) {
            throw eu.zzgt();
        }
        cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    static /* synthetic */ void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws eu {
        if (c(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || c(b4) || c(b5)) {
            throw eu.zzgt();
        }
        byte b6 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
        cArr[i2] = (char) ((b6 >>> 10) + 55232);
        cArr[i2 + 1] = (char) ((b6 & 1023) + TarHeader.LF_OLDNORM);
    }
}
