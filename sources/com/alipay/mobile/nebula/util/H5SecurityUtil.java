package com.alipay.mobile.nebula.util;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.Locale;

public class H5SecurityUtil {
    public static final String TAG = "SecurityUtil";

    public static String getMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i2 = 0; i2 < charArray.length; i2++) {
                bArr[i2] = (byte) charArray[i2];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                byte b3 = b2 & 255;
                if (b3 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b3));
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            H5Log.e(TAG, "exception detail", e2);
            return null;
        }
    }

    public static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                str = str + "0" + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str.toLowerCase(Locale.ENGLISH);
    }

    public static String getSHA1(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes(), 0, str.length());
            return bytes2Hex(instance.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean pathSecurityCheck(String str) {
        return !str.contains("..") && !str.contains("/") && !str.contains("\\") && !str.contains("%");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileMd5(java.lang.String r8) {
        /*
            java.lang.String r0 = "get file md5 failed"
            java.lang.String r1 = java.lang.String.valueOf(r8)
            java.lang.String r2 = "get file md5 start: "
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r2 = "SecurityUtil"
            com.alipay.mobile.nebula.util.H5Log.d(r2, r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r8)
            boolean r8 = r1.exists()
            java.lang.String r3 = ""
            if (r8 != 0) goto L_0x0024
            java.lang.String r8 = "file not exist, return empty String"
            com.alipay.mobile.nebula.util.H5Log.w(r2, r8)
            return r3
        L_0x0024:
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r8 = com.alipay.mobile.nebula.util.H5IOUtils.getBuf(r8)
            r4 = 0
            java.lang.String r5 = "MD5"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0061, IOException -> 0x005b, all -> 0x0058 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0061, IOException -> 0x005b, all -> 0x0058 }
            r6.<init>(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0061, IOException -> 0x005b, all -> 0x0058 }
        L_0x0036:
            int r1 = r6.read(r8)     // Catch:{ NoSuchAlgorithmException -> 0x0056, IOException -> 0x0054 }
            r7 = -1
            if (r1 == r7) goto L_0x0042
            r7 = 0
            r5.update(r8, r7, r1)     // Catch:{ NoSuchAlgorithmException -> 0x0056, IOException -> 0x0054 }
            goto L_0x0036
        L_0x0042:
            byte[] r1 = r5.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0056, IOException -> 0x0054 }
            java.math.BigInteger r5 = new java.math.BigInteger     // Catch:{ NoSuchAlgorithmException -> 0x0056, IOException -> 0x0054 }
            r7 = 1
            r5.<init>(r7, r1)     // Catch:{ NoSuchAlgorithmException -> 0x0056, IOException -> 0x0054 }
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r8)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r6)
            r4 = r5
            goto L_0x006c
        L_0x0054:
            r1 = move-exception
            goto L_0x005d
        L_0x0056:
            r1 = move-exception
            goto L_0x0063
        L_0x0058:
            r0 = move-exception
            r6 = r4
            goto L_0x0077
        L_0x005b:
            r1 = move-exception
            r6 = r4
        L_0x005d:
            com.alipay.mobile.nebula.util.H5Log.e(r2, r0, r1)     // Catch:{ all -> 0x0076 }
            goto L_0x0066
        L_0x0061:
            r1 = move-exception
            r6 = r4
        L_0x0063:
            com.alipay.mobile.nebula.util.H5Log.e(r2, r0, r1)     // Catch:{ all -> 0x0076 }
        L_0x0066:
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r8)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r6)
        L_0x006c:
            if (r4 != 0) goto L_0x006f
            return r3
        L_0x006f:
            r8 = 16
            java.lang.String r8 = r4.toString(r8)
            return r8
        L_0x0076:
            r0 = move-exception
        L_0x0077:
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r8)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5SecurityUtil.getFileMd5(java.lang.String):java.lang.String");
    }
}
