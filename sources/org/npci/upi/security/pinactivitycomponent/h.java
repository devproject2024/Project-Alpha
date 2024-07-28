package org.npci.upi.security.pinactivitycomponent;

import android.util.Base64;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.security.MessageDigest;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class h {

    /* renamed from: a  reason: collision with root package name */
    Cipher f72988a = Cipher.getInstance("AES/CBC/PKCS5Padding");

    /* renamed from: b  reason: collision with root package name */
    byte[] f72989b = new byte[32];

    /* renamed from: c  reason: collision with root package name */
    byte[] f72990c = new byte[16];

    public String a(String str, PublicKey publicKey) {
        byte[] bArr;
        byte[] bytes = str.getBytes();
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            bArr = instance.doFinal(bytes);
        } catch (Exception e2) {
            e2.printStackTrace();
            bArr = null;
        }
        return Base64.encodeToString(bArr, 2);
    }

    public String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i2] & 255)}));
        }
        return sb.toString();
    }

    public byte[] a(String str) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(str.getBytes(AppConstants.UTF_8));
        return instance.digest();
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }

    public byte[] b(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }
}
