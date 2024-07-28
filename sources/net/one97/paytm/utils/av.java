package net.one97.paytm.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class av {
    public static byte[] a(String str, String str2) throws SignatureException, UnsupportedEncodingException, NoSuchProviderException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "HmacSHA256");
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            return instance.doFinal(str.getBytes(Charset.forName("US-ASCII")));
        } catch (NoSuchAlgorithmException unused) {
            throw new SignatureException("error building signature, no such algorithm in device HmacSHA256");
        } catch (InvalidKeyException unused2) {
            throw new SignatureException("error building signature, invalid key HmacSHA256");
        }
    }
}
