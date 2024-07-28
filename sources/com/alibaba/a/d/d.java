package com.alibaba.a.d;

import net.one97.paytm.upi.util.UpiConstants;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f6359a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    public static final boolean[] f6360b = new boolean[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];

    /* renamed from: c  reason: collision with root package name */
    public static final boolean[] f6361c = new boolean[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f6362d = new byte[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f6363e = new byte[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];

    /* renamed from: f  reason: collision with root package name */
    public static final char[] f6364f = new char[128];

    /* renamed from: g  reason: collision with root package name */
    public static final char[] f6365g = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};

    /* renamed from: h  reason: collision with root package name */
    static final char[] f6366h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: i  reason: collision with root package name */
    static final char[] f6367i = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final int[] k = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};

    public static int a(long j2) {
        long j3 = 10;
        for (int i2 = 1; i2 < 19; i2++) {
            if (j2 < j3) {
                return i2;
            }
            j3 *= 10;
        }
        return 19;
    }

    static {
        char c2 = 0;
        while (true) {
            boolean[] zArr = f6360b;
            if (c2 >= zArr.length) {
                break;
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                zArr[c2] = true;
            } else if (c2 >= 'a' && c2 <= 'z') {
                f6360b[c2] = true;
            } else if (c2 == '_') {
                f6360b[c2] = true;
            }
            c2 = (char) (c2 + 1);
        }
        char c3 = 0;
        while (true) {
            boolean[] zArr2 = f6361c;
            if (c3 >= zArr2.length) {
                break;
            }
            if (c3 >= 'A' && c3 <= 'Z') {
                zArr2[c3] = true;
            } else if (c3 >= 'a' && c3 <= 'z') {
                f6361c[c3] = true;
            } else if (c3 == '_') {
                f6361c[c3] = true;
            } else if (c3 >= '0' && c3 <= '9') {
                f6361c[c3] = true;
            }
            c3 = (char) (c3 + 1);
        }
        byte[] bArr = f6362d;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        byte[] bArr2 = f6363e;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i2 = 14; i2 <= 31; i2++) {
            f6362d[i2] = 4;
            f6363e[i2] = 4;
        }
        for (int i3 = 127; i3 <= 160; i3++) {
            f6362d[i3] = 4;
            f6363e[i3] = 4;
        }
        char[] cArr = f6364f;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
    }

    public static void a(long j2, int i2, char[] cArr) {
        char c2;
        if (j2 < 0) {
            c2 = '-';
            j2 = -j2;
        } else {
            c2 = 0;
        }
        while (j2 > 2147483647L) {
            long j3 = j2 / 100;
            int i3 = (int) (j2 - (((j3 << 6) + (j3 << 5)) + (j3 << 2)));
            int i4 = i2 - 1;
            cArr[i4] = j[i3];
            i2 = i4 - 1;
            cArr[i2] = f6367i[i3];
            j2 = j3;
        }
        int i5 = (int) j2;
        while (i5 >= 65536) {
            int i6 = i5 / 100;
            int i7 = i5 - (((i6 << 6) + (i6 << 5)) + (i6 << 2));
            int i8 = i2 - 1;
            cArr[i8] = j[i7];
            i2 = i8 - 1;
            cArr[i2] = f6367i[i7];
            i5 = i6;
        }
        while (true) {
            int i9 = (52429 * i5) >>> 19;
            i2--;
            cArr[i2] = f6366h[i5 - ((i9 << 3) + (i9 << 1))];
            if (i9 == 0) {
                break;
            }
            i5 = i9;
        }
        if (c2 != 0) {
            cArr[i2 - 1] = c2;
        }
    }

    public static int a(int i2) {
        int i3 = 0;
        while (i2 > k[i3]) {
            i3++;
        }
        return i3 + 1;
    }
}
