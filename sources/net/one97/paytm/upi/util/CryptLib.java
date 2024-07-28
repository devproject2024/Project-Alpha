package net.one97.paytm.upi.util;

import android.util.Base64;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptLib {
    public byte[] SHA256(String str) throws Exception {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(str.getBytes(AppConstants.UTF_8));
        return instance.digest();
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }

    public PrivateKey readPrivateKeyFromString(String str) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 2)));
    }

    public String decryptData(String str, PrivateKey privateKey) {
        try {
            byte[] decode = Base64.decode(str, 2);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, privateKey);
            return new String(instance.doFinal(decode));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public byte[] decodeUsingBase64(String str) {
        try {
            return Base64.decode(str, 2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public byte[] hexStringToByteArray(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }
}
