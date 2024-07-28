package org.apache.xml.security.c14n.implementations;

import java.io.OutputStream;
import java.util.Map;

public class UtfHelpper {
    static final void a(char c2, OutputStream outputStream) {
        char c3;
        char c4;
        if (c2 < 128) {
            outputStream.write(c2);
        } else if ((c2 < 55296 || c2 > 56319) && (c2 < 56320 || c2 > 57343)) {
            if (c2 > 2047) {
                char c5 = (char) (c2 >>> 12);
                char c6 = 224;
                if (c5 > 0) {
                    c6 = 224 | (c5 & 15);
                }
                outputStream.write(c6);
                c4 = 128;
                c3 = '?';
            } else {
                c4 = 192;
                c3 = 31;
            }
            char c7 = (char) (c2 >>> 6);
            if (c7 > 0) {
                c4 |= c3 & c7;
            }
            outputStream.write(c4);
            outputStream.write((c2 & '?') | 128);
        } else {
            outputStream.write(63);
        }
    }

    static final void a(String str, OutputStream outputStream) {
        char c2;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt >= 128) {
                char c3 = '?';
                if ((charAt < 55296 || charAt > 56319) && (charAt < 56320 || charAt > 57343)) {
                    if (charAt > 2047) {
                        char c4 = (char) (charAt >>> 12);
                        char c5 = 224;
                        if (c4 > 0) {
                            c5 = 224 | (c4 & 15);
                        }
                        outputStream.write(c5);
                        c2 = 128;
                    } else {
                        c2 = 192;
                        c3 = 31;
                    }
                    char c6 = (char) (charAt >>> 6);
                    if (c6 > 0) {
                        c2 |= c3 & c6;
                    }
                    outputStream.write(c2);
                    charAt = (charAt & '?') | 128;
                } else {
                    outputStream.write(63);
                    i2 = i3;
                }
            }
            outputStream.write(charAt);
            i2 = i3;
        }
    }

    static final void a(String str, OutputStream outputStream, Map map) {
        byte[] bArr = (byte[]) map.get(str);
        if (bArr == null) {
            bArr = a(str);
            map.put(str, bArr);
        }
        outputStream.write(bArr);
    }

    public static final byte[] a(String str) {
        int i2;
        byte b2;
        int length = str.length();
        byte[] bArr = new byte[length];
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                bArr[i4] = (byte) charAt;
                i3 = i5;
                i4++;
            } else {
                char c2 = '?';
                if ((charAt < 55296 || charAt > 56319) && (charAt < 56320 || charAt > 57343)) {
                    if (!z) {
                        byte[] bArr2 = new byte[(length * 3)];
                        System.arraycopy(bArr, 0, bArr2, 0, i4);
                        bArr = bArr2;
                        z = true;
                    }
                    if (charAt > 2047) {
                        char c3 = (char) (charAt >>> 12);
                        byte b3 = -32;
                        if (c3 > 0) {
                            b3 = (byte) ((c3 & 15) | 65504);
                        }
                        i2 = i4 + 1;
                        bArr[i4] = b3;
                        b2 = Byte.MIN_VALUE;
                    } else {
                        c2 = 31;
                        i2 = i4;
                        b2 = -64;
                    }
                    char c4 = (char) (charAt >>> 6);
                    if (c4 > 0) {
                        b2 = (byte) (b2 | (c2 & c4));
                    }
                    int i6 = i2 + 1;
                    bArr[i2] = b2;
                    i4 = i6 + 1;
                    bArr[i6] = (byte) ((charAt & '?') | 128);
                } else {
                    bArr[i4] = 63;
                    i4++;
                }
                i3 = i5;
            }
        }
        if (!z) {
            return bArr;
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr, 0, bArr3, 0, i4);
        return bArr3;
    }
}
