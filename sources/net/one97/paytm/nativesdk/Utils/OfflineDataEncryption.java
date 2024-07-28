package net.one97.paytm.nativesdk.Utils;

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

public class OfflineDataEncryption {
    public static String encrypt(String str, String str2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(stringToBytes(str)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePublic);
        return bytesToString(instance.doFinal(str2.getBytes()));
    }

    private static String bytesToString(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 1)];
        bArr2[0] = 1;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        return new BigInteger(bArr2).toString(36);
    }

    private static byte[] stringToBytes(String str) {
        byte[] byteArray = new BigInteger(str, 36).toByteArray();
        return Arrays.copyOfRange(byteArray, 1, byteArray.length);
    }
}
