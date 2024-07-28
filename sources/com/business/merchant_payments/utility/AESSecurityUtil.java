package com.business.merchant_payments.utility;

import android.provider.Settings;
import android.util.Base64;
import com.business.merchant_payments.PaymentsConfig;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import net.one97.paytm.upi.util.UpiContract;

public class AESSecurityUtil {
    public static String encrypt(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(generateSecretKey(), "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(1, secretKeySpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes()), 8);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String decrypt(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(generateSecretKey(), "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(Base64.decode(str, 8)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static byte[] generateSecretKey() {
        String string = Settings.Secure.getString(PaymentsConfig.getInstance().getAppContext().getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
        int length = string.length();
        if (length > 16) {
            string = string.substring(0, 16);
        } else if (length < 16) {
            for (int i2 = 16 - length; i2 > 0; i2--) {
                string = "0".concat(String.valueOf(string));
            }
        }
        char[] cArr = {'p', '@', 'y', '!', 'm', 'k', 'e', 'Y', '4', 'o', 'n', 'E', '9', '7', 'p', 'r'};
        char[] charArray = string.toCharArray();
        char[] cArr2 = new char[16];
        for (int i3 = 0; i3 < 16; i3++) {
            cArr2[i3] = (char) (cArr[i3] ^ charArray[i3]);
        }
        return new String(cArr2).getBytes();
    }
}
