package com.paytm.pai.network;

public final class b {
    public static String a(byte[] bArr) {
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2] & 255;
            int i3 = i2 * 2;
            cArr[i3] = charArray[b2 >>> 4];
            cArr[i3 + 1] = charArray[b2 & 15];
        }
        return new String(cArr);
    }
}
