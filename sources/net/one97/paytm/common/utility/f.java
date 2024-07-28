package net.one97.paytm.common.utility;

import android.util.Base64;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.b;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class f {
    public static String a(String str, String str2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b.h(str)));
        Cipher instance = Cipher.getInstance("RSA/ECB/OAEPPadding");
        instance.init(1, generatePublic);
        return Base64.encodeToString(instance.doFinal(str2.getBytes()), 0).replaceAll(StringUtility.NEW_LINE, "").replaceAll("\r", "");
    }

    public static String a(String str, String str2, String str3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(b.i(str));
        SecretKeySpec secretKeySpec = new SecretKeySpec(b.i(str2), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return new String(Base64.encode(instance.doFinal(str3.getBytes()), 0));
    }

    public static String b(String str, String str2, String str3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(b.i(str));
        SecretKeySpec secretKeySpec = new SecretKeySpec(b.i(str2), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return new String(instance.doFinal(Base64.decode(str3, 0)));
    }
}
