package com.paytm.b.a;

import android.util.Base64;
import com.paytm.b.a;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.g.b.k;
import kotlin.m.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f42651a = "PreferenceCryptoHelper";

    /* renamed from: b  reason: collision with root package name */
    private final int f42652b = 10;

    /* renamed from: c  reason: collision with root package name */
    private final int f42653c = 128;

    public final String a(String str) throws Exception {
        k.c(str, "textToEncrypt");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            k.a((Object) instance, "Cipher.getInstance(BuildConfig.CYPHER_INSTANCE)");
            byte[] bytes = "A1232B23X834Z8F2".getBytes(d.f47971a);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            instance.init(1, secretKeySpec, new IvParameterSpec(bytes));
            byte[] bytes2 = str.getBytes(d.f47971a);
            k.a((Object) bytes2, "(this as java.lang.String).getBytes(charset)");
            byte[] doFinal = instance.doFinal(bytes2);
            k.a((Object) doFinal, "cipher.doFinal(textToEncrypt.toByteArray())");
            return Base64.encodeToString(doFinal, 0);
        } catch (NoSuchAlgorithmException e2) {
            String.valueOf(e2.getMessage());
            return null;
        } catch (IllegalBlockSizeException e3) {
            String.valueOf(e3.getMessage());
            return null;
        } catch (NoSuchPaddingException e4) {
            String.valueOf(e4.getMessage());
            return null;
        } catch (InvalidAlgorithmParameterException e5) {
            String.valueOf(e5.getMessage());
            return null;
        } catch (BadPaddingException e6) {
            String.valueOf(e6.getMessage());
            return null;
        }
    }

    public final String a(String str, String str2, a aVar) throws Exception {
        k.c(str, "textToDecrypt");
        k.c(str2, "key");
        k.c(aVar, "cjrPreferenceManager");
        try {
            byte[] decode = Base64.decode(str, 0);
            k.a((Object) decode, "Base64.decode(textToDecrypt, Base64.DEFAULT)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            k.a((Object) instance, "Cipher.getInstance(BuildConfig.CYPHER_INSTANCE)");
            byte[] bytes = "A1232B23X834Z8F2".getBytes(d.f47971a);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            instance.init(2, secretKeySpec, new IvParameterSpec(bytes));
            byte[] doFinal = instance.doFinal(decode);
            k.a((Object) doFinal, "cipher.doFinal(encryptedBytes)");
            return new String(doFinal, d.f47971a);
        } catch (NoSuchAlgorithmException e2) {
            aVar.a((Exception) e2, str2, str);
            String.valueOf(e2.getMessage());
            return null;
        } catch (IllegalBlockSizeException e3) {
            aVar.a((Exception) e3, str2, str);
            String.valueOf(e3.getMessage());
            return null;
        } catch (NoSuchPaddingException e4) {
            aVar.a((Exception) e4, str2, str);
            String.valueOf(e4.getMessage());
            return null;
        } catch (InvalidAlgorithmParameterException e5) {
            aVar.a((Exception) e5, str2, str);
            String.valueOf(e5.getMessage());
            return null;
        } catch (BadPaddingException e6) {
            aVar.a((Exception) e6, str2, str);
            String.valueOf(e6.getMessage());
            return null;
        }
    }

    private final byte[] a() throws Exception {
        try {
            SecretKeyFactory instance = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            k.a((Object) instance, "SecretKeyFactory.getInst…nfig.SECRET_KEY_INSTANCE)");
            char[] charArray = "sampleText".toCharArray();
            k.a((Object) charArray, "(this as java.lang.String).toCharArray()");
            byte[] bytes = "exampleSalt".getBytes(d.f47971a);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            SecretKey generateSecret = instance.generateSecret(new PBEKeySpec(charArray, bytes, this.f42652b, this.f42653c));
            k.a((Object) generateSecret, "factory.generateSecret(spec)");
            byte[] encoded = generateSecret.getEncoded();
            k.a((Object) encoded, "factory.generateSecret(spec).encoded");
            return encoded;
        } catch (InvalidKeySpecException e2) {
            String.valueOf(e2.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e3) {
            String.valueOf(e3.getMessage());
            return new byte[0];
        }
    }
}
