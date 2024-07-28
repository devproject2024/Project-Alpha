package com.appsflyer.internal;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.security.MessageDigest;
import java.util.Formatter;

public final class z {
    z() {
    }

    /* renamed from: Ι  reason: contains not printable characters */
    public static String m213(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.reset();
            instance.update(str.getBytes(AppConstants.UTF_8));
            return m214(instance.digest());
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA1");
            AFLogger.afErrorLog(sb.toString(), e2);
            return null;
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static String m211(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes(AppConstants.UTF_8));
            return m214(instance.digest());
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to MD5");
            AFLogger.afErrorLog(sb.toString(), e2);
            return null;
        }
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public static String m212(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toString((b2 & 255) + TarHeader.LF_OLDNORM, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("Error turning ");
            sb2.append(str.substring(0, 6));
            sb2.append(".. to SHA-256");
            AFLogger.afErrorLog(sb2.toString(), e2);
            return null;
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static String m214(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i2])});
        }
        String obj = formatter.toString();
        formatter.close();
        return obj;
    }

    /* renamed from: ι  reason: contains not printable characters */
    public static String m215(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        sb.append(j);
        return m213(sb.toString());
    }
}
