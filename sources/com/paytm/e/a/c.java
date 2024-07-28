package com.paytm.e.a;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.q;
import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f42685a = {1, 10, 100, 1000, AppConstants.START_OTP_FLOW, 100000, 1000000, 10000000, 100000000};

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(bArr, "RAW"));
            return instance.doFinal(bArr2);
        } catch (GeneralSecurityException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    private static byte[] a(String str) {
        byte[] byteArray = new BigInteger("10".concat(String.valueOf(str)), 16).toByteArray();
        byte[] bArr = new byte[(byteArray.length - 1)];
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = i2 + 1;
            bArr[i2] = byteArray[i3];
            i2 = i3;
        }
        return bArr;
    }

    private static String a(String str, String str2, String str3, String str4) {
        int intValue = Integer.decode(str3).intValue();
        while (str2.length() < 16) {
            str2 = "0".concat(String.valueOf(str2));
        }
        byte[] a2 = a(str4, a(str), a(str2));
        byte b2 = a2[a2.length - 1] & 15;
        String num = Integer.toString(((a2[b2 + 3] & 255) | ((((a2[b2] & Byte.MAX_VALUE) << 24) | ((a2[b2 + 1] & 255) << 16)) | ((a2[b2 + 2] & 255) << 8))) % f42685a[intValue]);
        while (num.length() < intValue) {
            num = "0".concat(String.valueOf(num));
        }
        return num;
    }

    private static String b(String str) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(str.getBytes());
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : digest) {
            stringBuffer.append(Integer.toString((b2 & 255) + TarHeader.LF_OLDNORM, 16).substring(1));
        }
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, long j, int i2) throws NullPointerException {
        if (str != null) {
            try {
                String b2 = b(str);
                Calendar instance = Calendar.getInstance();
                instance.add(12, i2);
                return a(b2, Long.toHexString(instance.getTimeInMillis() / TimeUnit.SECONDS.toMillis(j)).toUpperCase(), str2, "HmacSHA256");
            } catch (NoSuchAlgorithmException e2) {
                q.b(e2.getMessage());
                return "0";
            }
        } else {
            throw new NullPointerException("Token can't be null");
        }
    }
}
