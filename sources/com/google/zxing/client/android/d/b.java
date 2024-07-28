package com.google.zxing.client.android.d;

import android.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class b {
    public static String a(String str, String str2) throws Exception {
        Key a2 = a(str2);
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        instance.init(1, a2);
        return Base64.encodeToString(instance.doFinal(str.getBytes("UTF8")), 0);
    }

    public static String b(String str, String str2) throws Exception {
        Key a2 = a(str2);
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        instance.init(2, a2);
        return new String(instance.doFinal(Base64.decode(str, 0)));
    }

    private static Key a(String str) throws Exception {
        return new SecretKeySpec(str.getBytes(), "AES/ECB/PKCS7Padding");
    }
}
