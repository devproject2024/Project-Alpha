package net.one97.paytm.upi.util;

import android.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CJRQRCryptoUtils {
    private static final String ALGORITHM = "AES/ECB/PKCS7Padding";

    public static String encrypt(String str, String str2) throws Exception {
        Key generateKey = generateKey(str2);
        Cipher instance = Cipher.getInstance(ALGORITHM, "BC");
        instance.init(1, generateKey);
        return Base64.encodeToString(instance.doFinal(str.getBytes("UTF8")), 0);
    }

    public static String decrypt(String str, String str2) throws Exception {
        Key generateKey = generateKey(str2);
        Cipher instance = Cipher.getInstance(ALGORITHM, "BC");
        instance.init(2, generateKey);
        return new String(instance.doFinal(Base64.decode(str, 0)));
    }

    private static Key generateKey(String str) throws Exception {
        return new SecretKeySpec(str.getBytes(), ALGORITHM);
    }
}
