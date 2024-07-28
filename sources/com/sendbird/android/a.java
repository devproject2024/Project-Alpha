package com.sendbird.android;

import android.text.TextUtils;
import android.util.Base64;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f44698a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    static String a(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        Key a2 = a(str);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, a2, new IvParameterSpec(f44698a));
        return Base64.encodeToString(instance.doFinal(str2.getBytes(AppConstants.UTF_8)), 2);
    }

    static String b(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        Key a2 = a(str);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, a2, new IvParameterSpec(f44698a));
        return new String(instance.doFinal(Base64.decode(str2, 2)), AppConstants.UTF_8);
    }

    private static Key a(String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = 16;
        byte[] bArr = new byte[16];
        byte[] bytes = str.getBytes(AppConstants.UTF_8);
        int length = bytes.length;
        if (length <= 16) {
            i2 = length;
        }
        System.arraycopy(bytes, 0, bArr, 0, i2);
        return new SecretKeySpec(bArr, "AES");
    }
}
