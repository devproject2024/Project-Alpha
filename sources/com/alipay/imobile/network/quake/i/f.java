package com.alipay.imobile.network.quake.i;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f14902a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};

    public static String a(long j) {
        int pow = (int) Math.pow(2.0d, 6.0d);
        char[] cArr = new char[pow];
        long j2 = j;
        int i2 = pow;
        do {
            i2--;
            cArr[i2] = f14902a[(int) (63 & j2)];
            j2 >>>= 6;
        } while (j2 != 0);
        return new String(cArr, i2, pow - i2);
    }
}
