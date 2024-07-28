package com.paytm.e.a;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class b {
    public static String a(String str, String str2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        KeyFactory instance = KeyFactory.getInstance("RSA");
        byte[] byteArray = new BigInteger(str, 36).toByteArray();
        PublicKey generatePublic = instance.generatePublic(new X509EncodedKeySpec(Arrays.copyOfRange(byteArray, 1, byteArray.length)));
        Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance2.init(1, generatePublic);
        byte[] doFinal = instance2.doFinal(str2.getBytes());
        byte[] bArr = new byte[(doFinal.length + 1)];
        bArr[0] = 1;
        System.arraycopy(doFinal, 0, bArr, 1, doFinal.length);
        return new BigInteger(bArr).toString(36);
    }
}
