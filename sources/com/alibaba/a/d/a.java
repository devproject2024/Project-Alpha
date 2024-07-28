package com.alibaba.a.d;

import java.util.Arrays;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f6343a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f6344b;

    static {
        int[] iArr = new int[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];
        f6344b = iArr;
        Arrays.fill(iArr, -1);
        int length = f6343a.length;
        for (int i2 = 0; i2 < length; i2++) {
            f6344b[f6343a[i2]] = i2;
        }
        f6344b[61] = 0;
    }

    public static final byte[] a(String str, int i2, int i3) {
        int i4;
        int i5 = 0;
        if (i3 == 0) {
            return new byte[0];
        }
        int i6 = (i2 + i3) - 1;
        while (i2 < i6 && f6344b[str.charAt(i2)] < 0) {
            i2++;
        }
        while (i6 > 0 && f6344b[str.charAt(i6)] < 0) {
            i6--;
        }
        int i7 = str.charAt(i6) == '=' ? str.charAt(i6 + -1) == '=' ? 2 : 1 : 0;
        int i8 = (i6 - i2) + 1;
        if (i3 > 76) {
            i4 = (str.charAt(76) == 13 ? i8 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i9 = (((i8 - i4) * 6) >> 3) - i7;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = i2;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = i11 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            int i18 = (f6344b[str.charAt(i11)] << 18) | (f6344b[str.charAt(i14)] << 12) | (f6344b[str.charAt(i15)] << 6) | f6344b[str.charAt(i16)];
            int i19 = i12 + 1;
            bArr[i12] = (byte) (i18 >> 16);
            int i20 = i19 + 1;
            bArr[i19] = (byte) (i18 >> 8);
            int i21 = i20 + 1;
            bArr[i20] = (byte) i18;
            if (i4 <= 0 || (i13 = i13 + 1) != 19) {
                i11 = i17;
            } else {
                i11 = i17 + 2;
                i13 = 0;
            }
            i12 = i21;
        }
        if (i12 < i9) {
            int i22 = 0;
            while (i11 <= i6 - i7) {
                i5 |= f6344b[str.charAt(i11)] << (18 - (i22 * 6));
                i22++;
                i11++;
            }
            int i23 = 16;
            while (i12 < i9) {
                bArr[i12] = (byte) (i5 >> i23);
                i23 -= 8;
                i12++;
            }
        }
        return bArr;
    }

    public static final byte[] a(String str) {
        int i2;
        int length = str.length();
        int i3 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i4 = length - 1;
        int i5 = 0;
        while (i5 < i4 && f6344b[str.charAt(i5) & 255] < 0) {
            i5++;
        }
        while (i4 > 0 && f6344b[str.charAt(i4) & 255] < 0) {
            i4--;
        }
        int i6 = str.charAt(i4) == '=' ? str.charAt(i4 + -1) == '=' ? 2 : 1 : 0;
        int i7 = (i4 - i5) + 1;
        if (length > 76) {
            i2 = (str.charAt(76) == 13 ? i7 / 78 : 0) << 1;
        } else {
            i2 = 0;
        }
        int i8 = (((i7 - i2) * 6) >> 3) - i6;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = i5;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i9) {
            int i13 = i10 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = (f6344b[str.charAt(i10)] << 18) | (f6344b[str.charAt(i13)] << 12) | (f6344b[str.charAt(i14)] << 6) | f6344b[str.charAt(i15)];
            int i18 = i11 + 1;
            bArr[i11] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            int i20 = i19 + 1;
            bArr[i19] = (byte) i17;
            if (i2 <= 0 || (i12 = i12 + 1) != 19) {
                i10 = i16;
            } else {
                i10 = i16 + 2;
                i12 = 0;
            }
            i11 = i20;
        }
        if (i11 < i8) {
            int i21 = 0;
            while (i10 <= i4 - i6) {
                i3 |= f6344b[str.charAt(i10)] << (18 - (i21 * 6));
                i21++;
                i10++;
            }
            int i22 = 16;
            while (i11 < i8) {
                bArr[i11] = (byte) (i3 >> i22);
                i22 -= 8;
                i11++;
            }
        }
        return bArr;
    }
}
