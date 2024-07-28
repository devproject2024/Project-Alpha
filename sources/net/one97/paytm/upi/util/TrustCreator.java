package net.one97.paytm.upi.util;

import android.util.Base64;

public class TrustCreator {
    public static String createTrust(String str, String str2) {
        try {
            CryptLib cryptLib = new CryptLib();
            return Base64.encodeToString(cryptLib.encrypt(cryptLib.SHA256(str), cryptLib.decodeUsingBase64(str2)), 2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
