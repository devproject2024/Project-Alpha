package net.one97.paytm.utils;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f69776a = {121, 101, 115, 114, 111, 98, 111, 115, 101, 99, 114, 101, 116, 107, 101, 121};

    public static String a(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(f69776a, "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(Base64.decode(str, 8)));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
