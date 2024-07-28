package com.alipay.mobile.nebula.util.tar;

import com.alipay.mobile.nebula.util.H5IOUtils;

public class Octal {
    public static long parseOctal(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        boolean z = true;
        long j = 0;
        while (i2 < i4 && bArr[i2] != 0) {
            if (bArr[i2] == 32 || bArr[i2] == 48) {
                if (!z) {
                    if (bArr[i2] == 32) {
                        break;
                    }
                } else {
                    continue;
                    i2++;
                }
            }
            z = false;
            j = (j << 3) + ((long) (bArr[i2] - TarHeader.LF_NORMAL));
            i2++;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getOctalBytes(long r8, byte[] r10, int r11, int r12) {
        /*
            int r0 = r12 + -1
            int r1 = r11 + r0
            r2 = 0
            r10[r1] = r2
            int r0 = r0 + -1
            int r1 = r11 + r0
            r2 = 32
            r10[r1] = r2
            int r0 = r0 + -1
            r1 = 48
            r3 = 0
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0020
            int r8 = r11 + r0
            r10[r8] = r1
        L_0x001d:
            int r0 = r0 + -1
            goto L_0x0036
        L_0x0020:
            if (r0 < 0) goto L_0x0036
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0036
            int r5 = r11 + r0
            r6 = 7
            long r6 = r6 & r8
            int r7 = (int) r6
            byte r6 = (byte) r7
            int r6 = r6 + r1
            byte r6 = (byte) r6
            r10[r5] = r6
            r5 = 3
            long r8 = r8 >> r5
            int r0 = r0 + -1
            goto L_0x0020
        L_0x0036:
            if (r0 < 0) goto L_0x003d
            int r8 = r11 + r0
            r10[r8] = r2
            goto L_0x001d
        L_0x003d:
            int r11 = r11 + r12
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.tar.Octal.getOctalBytes(long, byte[], int, int):int");
    }

    public static int getCheckSumOctalBytes(long j, byte[] bArr, int i2, int i3) {
        getOctalBytes(j, bArr, i2, i3);
        int i4 = i2 + i3;
        bArr[i4 - 1] = 32;
        bArr[i4 - 2] = 0;
        return i4;
    }

    public static int getLongOctalBytes(long j, byte[] bArr, int i2, int i3) {
        int i4 = i3 + 1;
        byte[] buf = H5IOUtils.getBuf(i4);
        getOctalBytes(j, buf, 0, i4);
        System.arraycopy(buf, 0, bArr, i2, i3);
        H5IOUtils.returnBuf(buf);
        return i2 + i3;
    }
}
