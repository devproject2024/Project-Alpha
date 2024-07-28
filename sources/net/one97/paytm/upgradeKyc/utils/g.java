package net.one97.paytm.upgradeKyc.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class g {
    public static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.reset();
        return instance.digest(bArr);
    }
}
