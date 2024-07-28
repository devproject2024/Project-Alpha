package com.squareup.a;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

final class c {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Input bytes must not be null.");
        } else if (bArr.length < 1610612733) {
            int length = bArr.length / 3;
            if (bArr.length % 3 != 0) {
                length++;
            }
            char[] cArr = new char[(length << 2)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < bArr.length) {
                int i4 = (bArr[i2] & 255) << 16;
                int i5 = i2 + 1;
                if (i5 < bArr.length) {
                    i4 |= (bArr[i5] & 255) << 8;
                }
                int i6 = i2 + 2;
                if (i6 < bArr.length) {
                    i4 |= bArr[i6] & 255;
                }
                cArr[i3] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt((i4 >> 18) & 63);
                cArr[i3 + 1] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt((i4 >> 12) & 63);
                cArr[i3 + 2] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt((i4 >> 6) & 63);
                cArr[i3 + 3] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i4 & 63);
                i2 += 3;
                i3 += 4;
            }
            for (int length2 = cArr.length - ((length * 3) - bArr.length); length2 < cArr.length; length2++) {
                cArr[length2] = '=';
            }
            return String.valueOf(cArr);
        } else {
            throw new IllegalArgumentException("Input bytes length must not exceed 1610612733");
        }
    }

    private static void a(StringBuilder sb) {
        if (sb != null) {
            int length = 16 - (sb.length() % 16);
            if (length < 16) {
                while (length > 0) {
                    sb.append('{');
                    length--;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Builder input must not be empty.");
    }

    static String a(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Input string must not be blank.");
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | TarHeader.LF_OLDNORM).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    static byte[] a(StringBuilder sb, String str) {
        try {
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(new SecretKeySpec(str.getBytes(), "HmacSHA1"));
            return instance.doFinal(sb.toString().getBytes());
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    static byte[] b(StringBuilder sb, String str) {
        String str2;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (str.length() >= 16) {
                        str2 = str.substring(0, 16);
                    } else {
                        StringBuilder sb2 = new StringBuilder(str);
                        while (sb2.length() < 16) {
                            sb2.append(str);
                        }
                        str2 = sb2.substring(0, 16);
                    }
                    a(sb);
                    Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
                    instance.init(1, new SecretKeySpec(str2.getBytes(), "AES"));
                    return instance.doFinal(sb.toString().getBytes());
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("Must supply a non-null, non-empty string.");
    }
}
