package com.alipay.mobile.nebula.util;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class H5RsaUtil {
    private static final String ALGORITHM = "RSA";
    public static final String TAG = "RsaUtil";

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean verify(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "RsaUtil"
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = com.alipay.mobile.nebula.util.H5IOUtils.getBuf(r1)
            r2 = 2
            r3 = 0
            r4 = 0
            byte[] r5 = android.util.Base64.decode(r12, r2)     // Catch:{ all -> 0x004a }
            java.security.spec.X509EncodedKeySpec r6 = new java.security.spec.X509EncodedKeySpec     // Catch:{ all -> 0x004a }
            r6.<init>(r5)     // Catch:{ all -> 0x004a }
            java.lang.String r5 = "RSA"
            java.security.KeyFactory r5 = java.security.KeyFactory.getInstance(r5)     // Catch:{ all -> 0x004a }
            java.security.PublicKey r5 = r5.generatePublic(r6)     // Catch:{ all -> 0x004a }
            byte[] r2 = android.util.Base64.decode(r13, r2)     // Catch:{ all -> 0x004a }
            java.lang.String r6 = "SHA1withRSA"
            java.security.Signature r6 = java.security.Signature.getInstance(r6)     // Catch:{ all -> 0x004a }
            r6.initVerify(r5)     // Catch:{ all -> 0x004a }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ all -> 0x004a }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x004a }
            r7.<init>(r11)     // Catch:{ all -> 0x004a }
            r5.<init>(r7)     // Catch:{ all -> 0x004a }
        L_0x0035:
            int r7 = r5.available()     // Catch:{ all -> 0x0048 }
            if (r7 == 0) goto L_0x0043
            int r7 = r5.read(r1)     // Catch:{ all -> 0x0048 }
            r6.update(r1, r4, r7)     // Catch:{ all -> 0x0048 }
            goto L_0x0035
        L_0x0043:
            boolean r4 = r6.verify(r2)     // Catch:{ all -> 0x0048 }
            goto L_0x0053
        L_0x0048:
            r2 = move-exception
            goto L_0x004c
        L_0x004a:
            r2 = move-exception
            r5 = r3
        L_0x004c:
            r3 = r2
            java.lang.String r2 = "verify exception"
            com.alipay.mobile.nebula.util.H5Log.e(r0, r2, r3)     // Catch:{ all -> 0x007e }
        L_0x0053:
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r1)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r5)
            r6 = r3
            if (r4 != 0) goto L_0x006f
            java.lang.String r1 = "IO"
            java.util.concurrent.ThreadPoolExecutor r1 = com.alipay.mobile.nebula.util.H5Utils.getExecutor(r1)
            com.alipay.mobile.nebula.util.H5RsaUtil$1 r2 = new com.alipay.mobile.nebula.util.H5RsaUtil$1
            r5 = r2
            r7 = r11
            r8 = r11
            r9 = r13
            r10 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            r1.execute(r2)
        L_0x006f:
            java.lang.String r11 = java.lang.String.valueOf(r4)
            java.lang.String r12 = "signature verify result "
            java.lang.String r11 = r12.concat(r11)
            com.alipay.mobile.nebula.util.H5Log.d(r0, r11)
            return r4
        L_0x007e:
            r11 = move-exception
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r1)
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r5)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5RsaUtil.verify(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private static PublicKey getPublicKeyFromX509(String str, String str2) throws Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(H5Base64.decode(str2)));
    }

    public static String encrypt(String str, String str2) {
        try {
            PublicKey publicKeyFromX509 = getPublicKeyFromX509(ALGORITHM, str2);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKeyFromX509);
            return H5Base64.encode(instance.doFinal(str.getBytes(AppConstants.UTF_8)));
        } catch (Exception e2) {
            H5Log.e(TAG, "exception detail", e2);
            return null;
        }
    }

    public static PrivateKey getPrivateKey(String str, String str2) throws Exception {
        return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(H5Base64.decode(str2)));
    }

    public static String decrypt(String str, String str2) {
        try {
            PrivateKey privateKey = getPrivateKey(ALGORITHM, str2);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, privateKey);
            return new String(instance.doFinal(H5Base64.decode(str)));
        } catch (Exception e2) {
            H5Log.e(TAG, "exception detail", e2);
            return null;
        }
    }
}
