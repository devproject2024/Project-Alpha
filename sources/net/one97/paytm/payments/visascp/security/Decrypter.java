package net.one97.paytm.payments.visascp.security;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.business.merchant_payments.common.utility.AppUtility;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import net.one97.paytm.payments.visascp.storage.SecureSharedPref;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;

public class Decrypter {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f636 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f637;

    /* renamed from: ॱ  reason: contains not printable characters */
    private KeyStore f638;

    public Decrypter() {
        try {
            this.f638 = KeyStore.getInstance(VisaSCPConstants.ANDROID_KEY_STORE);
            this.f638.load((KeyStore.LoadStoreParameter) null);
        } catch (KeyStoreException unused) {
            String str = VisaSCPConstants.LOG_TAG;
            String str2 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (CertificateException unused2) {
            String str3 = VisaSCPConstants.LOG_TAG;
            String str4 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (NoSuchAlgorithmException unused3) {
            String str5 = VisaSCPConstants.LOG_TAG;
            String str6 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (IOException unused4) {
            String str7 = VisaSCPConstants.LOG_TAG;
            String str8 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (Exception unused5) {
            String str9 = VisaSCPConstants.LOG_TAG;
            String str10 = VisaSCPConstants.EXCEPTION_MESSAGE;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m712(String str, String str2, String str3, String str4) {
        int i2 = f637;
        int i3 = (i2 & 86) + (i2 | 86);
        int i4 = ((i3 | -1) << 1) - (~i3);
        f636 = i4 % 128;
        int i5 = i4 % 2;
        try {
            Signature instance = Signature.getInstance(VisaSCPConstants.ALGORITHM_SHA_RSA);
            PublicKey r6 = m710(str4);
            if (r6 != null) {
                instance.initVerify(r6);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(AppUtility.CENTER_DOT);
                sb.append(str2);
                instance.update(sb.toString().getBytes());
                boolean verify = instance.verify(Base64.decode(str3, 8));
                int i6 = f636;
                int i7 = (i6 & -50) | ((~i6) & 49);
                int i8 = (i6 & 49) << 1;
                int i9 = ((i7 | i8) << 1) - (i8 ^ i7);
                f637 = i9 % 128;
                if (i9 % 2 == 0) {
                }
                return verify;
            }
            int i10 = f636;
            int i11 = ((i10 & -68) | ((~i10) & 67)) + ((i10 & 67) << 1);
            f637 = i11 % 128;
            if (i11 % 2 == 0) {
            }
            int i12 = f636;
            int i13 = (i12 ^ 21) + ((i12 & 21) << 1);
            f637 = i13 % 128;
            int i14 = i13 % 2;
            return false;
        } catch (NoSuchAlgorithmException unused) {
            String str5 = VisaSCPConstants.LOG_TAG;
            String str6 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (SignatureException unused2) {
            String str7 = VisaSCPConstants.LOG_TAG;
            String str8 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (InvalidKeyException unused3) {
            String str9 = VisaSCPConstants.LOG_TAG;
            String str10 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (Exception unused4) {
            String str11 = VisaSCPConstants.LOG_TAG;
            String str12 = VisaSCPConstants.EXCEPTION_MESSAGE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if ((r10 == null ? '=' : '&') != '=') goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] decryptCek(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            int r0 = f637
            r1 = r0 ^ 16
            r0 = r0 & 16
            r2 = 1
            int r0 = r0 << r2
            int r1 = r1 + r0
            r0 = 0
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r3 = r1 % 128
            f636 = r3
            r3 = 2
            int r1 = r1 % r3
            r4 = 50
            if (r1 == 0) goto L_0x0019
            r1 = 13
            goto L_0x001b
        L_0x0019:
            r1 = 50
        L_0x001b:
            if (r1 == r4) goto L_0x002a
            java.security.PrivateKey r10 = r9.m711(r10)     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            if (r10 != 0) goto L_0x0025
            r1 = 0
            goto L_0x0026
        L_0x0025:
            r1 = 1
        L_0x0026:
            if (r1 == r2) goto L_0x0039
            goto L_0x00bf
        L_0x002a:
            java.security.PrivateKey r10 = r9.m711(r10)     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            r1 = 61
            if (r10 != 0) goto L_0x0035
            r4 = 61
            goto L_0x0037
        L_0x0035:
            r4 = 38
        L_0x0037:
            if (r4 == r1) goto L_0x00bf
        L_0x0039:
            int r1 = f637
            r4 = r1 ^ 96
            r1 = r1 & 96
            int r1 = r1 << r2
            int r4 = r4 + r1
            r1 = r4 & -1
            r4 = r4 | -1
            int r1 = r1 + r4
            int r4 = r1 % 128
            f636 = r4
            int r1 = r1 % r3
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            r4 = 23
            r5 = 88
            if (r1 < r4) goto L_0x0055
            r1 = 4
            goto L_0x0057
        L_0x0055:
            r1 = 88
        L_0x0057:
            if (r1 == r5) goto L_0x007a
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_PARES     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            javax.crypto.spec.OAEPParameterSpec r4 = new javax.crypto.spec.OAEPParameterSpec     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_MD     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            java.lang.String r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_MGF     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            java.security.spec.AlgorithmParameterSpec r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGO_PRM_SPEC     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            javax.crypto.spec.PSource$PSpecified r8 = javax.crypto.spec.PSource.PSpecified.DEFAULT     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            r4.<init>(r5, r6, r7, r8)     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            r1.init(r3, r10, r4)     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            int r10 = f636
            int r10 = r10 + 114
            int r10 = r10 - r2
            int r4 = r10 % 128
            f637 = r4
            int r10 = r10 % r3
            goto L_0x00a2
        L_0x007a:
            int r1 = f637
            r4 = r1 & 18
            r1 = r1 | 18
            int r4 = r4 + r1
            int r4 = r4 - r0
            int r4 = r4 - r2
            int r1 = r4 % 128
            f636 = r1
            int r4 = r4 % r3
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_RSA_ECB_PKCS1     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            r1.init(r3, r10)     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            int r10 = f637
            r4 = r10 & 109(0x6d, float:1.53E-43)
            r10 = r10 ^ 109(0x6d, float:1.53E-43)
            r10 = r10 | r4
            r5 = r4 | r10
            int r5 = r5 << r2
            r10 = r10 ^ r4
            int r5 = r5 - r10
            int r10 = r5 % 128
            f636 = r10
            int r5 = r5 % r3
        L_0x00a2:
            r10 = 8
            byte[] r10 = android.util.Base64.decode(r11, r10)     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            byte[] r10 = r1.doFinal(r10)     // Catch:{ NoSuchAlgorithmException -> 0x00f7, NoSuchPaddingException -> 0x00f2, BadPaddingException -> 0x00ed, IllegalBlockSizeException -> 0x00e8, InvalidKeyException -> 0x00e3, InvalidAlgorithmParameterException -> 0x00de, Exception -> 0x00d9 }
            int r11 = f637
            r0 = r11 & 111(0x6f, float:1.56E-43)
            r11 = r11 | 111(0x6f, float:1.56E-43)
            int r11 = -r11
            int r11 = -r11
            r1 = r0 | r11
            int r1 = r1 << r2
            r11 = r11 ^ r0
            int r1 = r1 - r11
            int r11 = r1 % 128
            f636 = r11
            int r1 = r1 % r3
            return r10
        L_0x00bf:
            int r10 = f637
            r11 = r10 & 31
            r10 = r10 ^ 31
            r10 = r10 | r11
            r1 = r11 & r10
            r10 = r10 | r11
            int r1 = r1 + r10
            int r10 = r1 % 128
            f636 = r10
            int r1 = r1 % r3
            r10 = 58
            if (r1 == 0) goto L_0x00d6
            r11 = 59
            goto L_0x00fb
        L_0x00d6:
            r11 = 58
            goto L_0x00fb
        L_0x00d9:
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00fb
        L_0x00de:
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00fb
        L_0x00e3:
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00fb
        L_0x00e8:
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00fb
        L_0x00ed:
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00fb
        L_0x00f2:
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00fb
        L_0x00f7:
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x00fb:
            r10 = 0
            int r11 = f637
            r1 = r11 ^ 35
            r4 = r11 & 35
            r1 = r1 | r4
            int r1 = r1 << r2
            int r4 = ~r4
            r11 = r11 | 35
            r11 = r11 & r4
            int r11 = -r11
            r4 = r1 ^ r11
            r11 = r11 & r1
            int r11 = r11 << r2
            int r4 = r4 + r11
            int r11 = r4 % 128
            f636 = r11
            int r4 = r4 % r3
            if (r4 == 0) goto L_0x0116
            goto L_0x0117
        L_0x0116:
            r0 = 1
        L_0x0117:
            if (r0 == 0) goto L_0x0119
        L_0x0119:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.security.Decrypter.decryptCek(java.lang.String, java.lang.String):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String decryptPayload(java.lang.String r7, java.lang.String r8, java.lang.String r9, byte[] r10, java.lang.String r11, byte[] r12) {
        /*
            r6 = this;
            r7 = 2
            r0 = 0
            r1 = 1
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_PAYLOAD     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            javax.crypto.spec.SecretKeySpec r3 = new javax.crypto.spec.SecretKeySpec     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_SK_PAYLOAD     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            r3.<init>(r10, r4)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            r4 = 19
            if (r10 > r4) goto L_0x0028
            javax.crypto.spec.IvParameterSpec r10 = new javax.crypto.spec.IvParameterSpec     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            r10.<init>(r12)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            int r12 = f637
            r4 = r12 & 61
            r12 = r12 | 61
            int r4 = r4 + r12
            int r12 = r4 % 128
            f636 = r12
            int r4 = r4 % r7
            goto L_0x004b
        L_0x0028:
            javax.crypto.spec.GCMParameterSpec r10 = new javax.crypto.spec.GCMParameterSpec     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            r4 = 128(0x80, float:1.794E-43)
            r10.<init>(r4, r12)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            int r12 = f637
            r4 = r12 & 7
            int r5 = ~r4
            r12 = r12 | 7
            r12 = r12 & r5
            int r4 = r4 << r1
            r5 = r12 | r4
            int r5 = r5 << r1
            r12 = r12 ^ r4
            int r5 = r5 - r12
            int r12 = r5 % 128
            f636 = r12
            int r5 = r5 % r7
            r12 = 81
            if (r5 == 0) goto L_0x0049
            r4 = 21
            goto L_0x004b
        L_0x0049:
            r4 = 81
        L_0x004b:
            r2.init(r7, r3, r10)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            r12 = 98
            if (r10 == 0) goto L_0x0059
            r10 = 79
            goto L_0x005b
        L_0x0059:
            r10 = 98
        L_0x005b:
            if (r10 == r12) goto L_0x005e
            goto L_0x0086
        L_0x005e:
            int r10 = f637
            int r10 = r10 + 122
            int r10 = r10 - r1
            int r12 = r10 % 128
            f636 = r12
            int r10 = r10 % r7
            byte[] r8 = r8.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            r2.updateAAD(r8)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            int r8 = f636
            r10 = r8 ^ 76
            r8 = r8 & 76
            int r8 = r8 << r1
            int r10 = r10 + r8
            r8 = r10 & -1
            r10 = r10 | -1
            int r8 = r8 + r10
            int r10 = r8 % 128
            f637 = r10
            int r8 = r8 % r7
            if (r8 != 0) goto L_0x0085
            r8 = 1
            goto L_0x0086
        L_0x0085:
            r8 = 0
        L_0x0086:
            r8 = 8
            byte[] r10 = android.util.Base64.decode(r11, r8)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            byte[] r8 = android.util.Base64.decode(r9, r8)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            int r9 = r10.length     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            int r11 = r8.length     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            r12 = r9 ^ r11
            r9 = r9 & r11
            int r9 = r9 << r1
            r11 = r12 | r9
            int r11 = r11 << r1
            r9 = r9 ^ r12
            int r11 = r11 - r9
            byte[] r9 = new byte[r11]     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            int r11 = r10.length     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            java.lang.System.arraycopy(r10, r0, r9, r0, r11)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            int r10 = r10.length     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            int r11 = r8.length     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            java.lang.System.arraycopy(r8, r0, r9, r10, r11)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            byte[] r8 = r2.doFinal(r9)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            java.lang.String r9 = new java.lang.String     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            r9.<init>(r8)     // Catch:{ NoSuchAlgorithmException -> 0x00e0, NoSuchPaddingException -> 0x00db, BadPaddingException -> 0x00d6, IllegalBlockSizeException -> 0x00d1, InvalidKeyException -> 0x00cc, InvalidAlgorithmParameterException -> 0x00c7, Exception -> 0x00c2 }
            int r8 = f637
            r10 = r8 | 53
            int r10 = r10 << r1
            r8 = r8 ^ 53
            int r10 = r10 - r8
            int r8 = r10 % 128
            f636 = r8
            int r10 = r10 % r7
            if (r10 == 0) goto L_0x00c0
            r8 = 0
            goto L_0x00e5
        L_0x00c0:
            r8 = 1
            goto L_0x00e5
        L_0x00c2:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00e4
        L_0x00c7:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00e4
        L_0x00cc:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00e4
        L_0x00d1:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00e4
        L_0x00d6:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00e4
        L_0x00db:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00e4
        L_0x00e0:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x00e4:
            r9 = 0
        L_0x00e5:
            int r8 = f637
            r10 = r8 & 56
            r8 = r8 | 56
            int r10 = r10 + r8
            int r10 = r10 - r0
            int r10 = r10 - r1
            int r8 = r10 % 128
            f636 = r8
            int r10 = r10 % r7
            if (r10 == 0) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r0 = 1
        L_0x00f7:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.security.Decrypter.decryptPayload(java.lang.String, java.lang.String, java.lang.String, byte[], java.lang.String, byte[]):java.lang.String");
    }

    public String decryptStorageData(String str, byte[] bArr) {
        int i2 = f636;
        int i3 = (i2 & -118) | ((~i2) & 117);
        int i4 = -(-((i2 & 117) << 1));
        int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
        f637 = i5 % 128;
        int i6 = i5 % 2;
        String str2 = null;
        try {
            Cipher instance = Cipher.getInstance(VisaSCPConstants.RSA_ALGORITHM);
            PrivateKey r5 = m711(str);
            if (r5 != null) {
                instance.init(2, r5);
                String str3 = new String(instance.doFinal(bArr));
                int i7 = f637 + 64;
                int i8 = (i7 & -1) + (i7 | -1);
                f636 = i8 % 128;
                if (i8 % 2 != 0) {
                }
                str2 = str3;
            }
            int i9 = f637;
            int i10 = i9 & 15;
            int i11 = i10 + ((i9 ^ 15) | i10);
            f636 = i11 % 128;
            if (i11 % 2 != 0) {
            }
        } catch (NoSuchAlgorithmException unused) {
            String str4 = VisaSCPConstants.LOG_TAG;
            String str5 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (NoSuchPaddingException unused2) {
            String str6 = VisaSCPConstants.LOG_TAG;
            String str7 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (BadPaddingException unused3) {
            String str8 = VisaSCPConstants.LOG_TAG;
            String str9 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (IllegalBlockSizeException unused4) {
            String str10 = VisaSCPConstants.LOG_TAG;
            String str11 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (InvalidKeyException unused5) {
            String str12 = VisaSCPConstants.LOG_TAG;
            String str13 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (Exception unused6) {
            String str14 = VisaSCPConstants.LOG_TAG;
            String str15 = VisaSCPConstants.EXCEPTION_MESSAGE;
        }
        int i12 = f636;
        int i13 = (i12 ^ 13) + ((i12 & 13) << 1);
        f637 = i13 % 128;
        if (i13 % 2 == 0) {
        }
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        if ((r4.f638 == null ? '+' : 'N') != 'N') goto L_0x0037;
     */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.security.PrivateKey m711(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = f637
            int r0 = r0 + 112
            r1 = r0 | -1
            int r1 = r1 << 1
            int r0 = ~r0
            int r1 = r1 - r0
            int r0 = r1 % 128
            f636 = r0
            r0 = 2
            int r1 = r1 % r0
            r2 = 32
            if (r1 == 0) goto L_0x0017
            r1 = 32
            goto L_0x0019
        L_0x0017:
            r1 = 49
        L_0x0019:
            r3 = 0
            if (r1 == r2) goto L_0x002a
            java.security.KeyStore r1 = r4.f638     // Catch:{ KeyStoreException -> 0x0077, NoSuchAlgorithmException -> 0x0072, UnrecoverableEntryException -> 0x006d, Exception -> 0x0068 }
            r2 = 21
            if (r1 != 0) goto L_0x0025
            r1 = 21
            goto L_0x0027
        L_0x0025:
            r1 = 52
        L_0x0027:
            if (r1 == r2) goto L_0x0037
            goto L_0x004a
        L_0x002a:
            java.security.KeyStore r1 = r4.f638     // Catch:{ KeyStoreException -> 0x0077, NoSuchAlgorithmException -> 0x0072, UnrecoverableEntryException -> 0x006d, Exception -> 0x0068 }
            r2 = 78
            if (r1 != 0) goto L_0x0033
            r1 = 43
            goto L_0x0035
        L_0x0033:
            r1 = 78
        L_0x0035:
            if (r1 == r2) goto L_0x004a
        L_0x0037:
            int r5 = f636
            r1 = r5 & 123(0x7b, float:1.72E-43)
            r5 = r5 | 123(0x7b, float:1.72E-43)
            int r1 = r1 + r5
            int r5 = r1 % 128
            f637 = r5
            int r1 = r1 % r0
            if (r1 != 0) goto L_0x0048
            r5 = 57
            goto L_0x007b
        L_0x0048:
            r5 = 2
            goto L_0x007b
        L_0x004a:
            java.security.KeyStore r1 = r4.f638     // Catch:{ KeyStoreException -> 0x0077, NoSuchAlgorithmException -> 0x0072, UnrecoverableEntryException -> 0x006d, Exception -> 0x0068 }
            java.security.Key r5 = r1.getKey(r5, r3)     // Catch:{ KeyStoreException -> 0x0077, NoSuchAlgorithmException -> 0x0072, UnrecoverableEntryException -> 0x006d, Exception -> 0x0068 }
            java.security.PrivateKey r5 = (java.security.PrivateKey) r5     // Catch:{ KeyStoreException -> 0x0077, NoSuchAlgorithmException -> 0x0072, UnrecoverableEntryException -> 0x006d, Exception -> 0x0068 }
            int r1 = f636
            r2 = r1 & -86
            int r3 = ~r1
            r3 = r3 & 85
            r2 = r2 | r3
            r1 = r1 & 85
            int r1 = r1 << 1
            int r1 = ~r1
            int r2 = r2 - r1
            int r2 = r2 + -1
            int r1 = r2 % 128
            f637 = r1
            int r2 = r2 % r0
            return r5
        L_0x0068:
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x007b
        L_0x006d:
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x007b
        L_0x0072:
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x007b
        L_0x0077:
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x007b:
            int r5 = f637
            r1 = r5 ^ 72
            r5 = r5 & 72
            int r5 = r5 << 1
            int r1 = r1 + r5
            r5 = r1 & -1
            r1 = r1 | -1
            int r5 = r5 + r1
            int r1 = r5 % 128
            f636 = r1
            int r5 = r5 % r0
            r0 = 18
            if (r5 == 0) goto L_0x0095
            r5 = 18
            goto L_0x0097
        L_0x0095:
            r5 = 28
        L_0x0097:
            if (r5 == r0) goto L_0x0099
        L_0x0099:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.security.Decrypter.m711(java.lang.String):java.security.PrivateKey");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static PublicKey m710(String str) {
        PublicKey publicKey = null;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(VisaSCPConstants.RSA_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 2)));
            int i2 = f637;
            int i3 = ((((i2 ^ 61) | (i2 & 61)) << 1) - (~(-(((~i2) & 61) | (i2 & -62))))) - 1;
            f636 = i3 % 128;
            if ((i3 % 2 != 0 ? 2 : 'Y') == 2) {
                return generatePublic;
            }
            super.hashCode();
            return generatePublic;
        } catch (Exception unused) {
            String str2 = VisaSCPConstants.LOG_TAG;
            String str3 = VisaSCPConstants.EXCEPTION_MESSAGE;
            return publicKey;
        }
    }

    public String parseIdTokenJws(Context context, String str, String str2) {
        int i2;
        int i3 = f637;
        int i4 = ((i3 ^ 1) | (i3 & 1)) << 1;
        int i5 = -(((~i3) & 1) | (i3 & -2));
        int i6 = ((i4 | i5) << 1) - (i5 ^ i4);
        f636 = i6 % 128;
        int i7 = i6 % 2;
        boolean z = false;
        String str3 = null;
        if (str != null) {
            String[] split = str.split("\\.");
            if ((split == null ? '/' : '&') != '/') {
                int i8 = f636;
                int i9 = (i8 ^ 123) + ((i8 & 123) << 1);
                f637 = i9 % 128;
                int i10 = i9 % 2;
                if ((split.length == 3 ? 'L' : 29) == 'L') {
                    String str4 = split[0];
                    Base64.decode(str4, 8);
                    String str5 = split[1];
                    String str6 = new String(Base64.decode(str5, 8));
                    String str7 = split[2];
                    SecureSharedPref instance = SecureSharedPref.getInstance(context);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(VisaSCPConstants.VPUB);
                    if (m712(str4, str5, str7, instance.getData(context, sb.toString()))) {
                        z = true;
                    }
                    if (z) {
                        int i11 = f637;
                        int i12 = ((i11 & 20) + (i11 | 20)) - 1;
                        f636 = i12 % 128;
                        int i13 = i12 % 2;
                        int i14 = f637;
                        int i15 = (i14 | 53) << 1;
                        int i16 = -(((~i14) & 53) | (i14 & -54));
                        int i17 = (i15 & i16) + (i16 | i15);
                        f636 = i17 % 128;
                        int i18 = i17 % 2;
                        return str6;
                    }
                    int i19 = f636;
                    int i20 = i19 & 89;
                    i2 = (((i19 ^ 89) | i20) << 1) - ((i19 | 89) & (~i20));
                    f637 = i2 % 128;
                    int i21 = i2 % 2;
                    return str3;
                }
            }
            int i22 = f637;
            i2 = ((i22 & -20) | ((~i22) & 19)) + ((i22 & 19) << 1);
            f636 = i2 % 128;
            int i212 = i2 % 2;
            return str3;
        }
        int i23 = (f636 + 68) - 1;
        f637 = i23 % 128;
        int i24 = i23 % 2;
        int i25 = f637;
        int i26 = (((i25 ^ 37) | (i25 & 37)) << 1) - (((~i25) & 37) | (i25 & -38));
        f636 = i26 % 128;
        if (i26 % 2 != 0) {
            z = true;
        }
        if (z) {
            return str3;
        }
        super.hashCode();
        return str3;
    }

    public String parseTokenJwe(String str, String str2) {
        int i2 = f637;
        int i3 = i2 & 105;
        int i4 = i3 + ((i2 ^ 105) | i3);
        f636 = i4 % 128;
        int i5 = i4 % 2;
        String[] split = str.split("\\.");
        if (split != null) {
            int i6 = f637;
            int i7 = ((i6 | 47) << 1) - (i6 ^ 47);
            f636 = i7 % 128;
            int i8 = i7 % 2;
            if (!(split.length != 5)) {
                String str3 = split[0];
                Base64.decode(str3, 2);
                String decryptPayload = decryptPayload(str2, str3, split[4], decryptCek(str2, split[1]), split[3], Base64.decode(split[2], 8));
                int i9 = (f636 + 110) - 1;
                f637 = i9 % 128;
                int i10 = i9 % 2;
                return decryptPayload;
            }
        }
        int i11 = f637;
        int i12 = i11 & 65;
        int i13 = (i12 - (~(-(-((i11 ^ 65) | i12))))) - 1;
        f636 = i13 % 128;
        int i14 = i13 % 2;
        return null;
    }

    public String decryptPares(String str, byte[] bArr) {
        Cipher cipher;
        int i2 = f637;
        int i3 = i2 | 67;
        int i4 = i3 << 1;
        int i5 = -((~(i2 & 67)) & i3);
        int i6 = (i4 & i5) + (i5 | i4);
        f636 = i6 % 128;
        int i7 = i6 % 2;
        char c2 = 5;
        try {
            PrivateKey r11 = m711(str);
            char c3 = 0;
            if (r11 == null) {
                int i8 = f637;
                int i9 = (i8 & 99) + (i8 | 99);
                f636 = i9 % 128;
                if (i9 % 2 != 0) {
                }
                int i10 = f637;
                int i11 = i10 & 85;
                int i12 = (i11 - (~((i10 ^ 85) | i11))) - 1;
                f636 = i12 % 128;
                if (i12 % 2 != 0) {
                    c2 = '*';
                }
                if (c2 != '*') {
                }
                return null;
            }
            int i13 = f637 + 54;
            int i14 = (~i13) + ((i13 & -1) << 1);
            f636 = i14 % 128;
            int i15 = i14 % 2;
            if ((Build.VERSION.SDK_INT >= 23 ? '!' : 'A') != '!') {
                int i16 = f637 + 23;
                f636 = i16 % 128;
                if ((i16 % 2 != 0 ? '%' : 11) != 11) {
                    cipher = Cipher.getInstance(VisaSCPConstants.ALGORITHM_RSA_ECB_PKCS1);
                    cipher.init(2, r11);
                } else {
                    cipher = Cipher.getInstance(VisaSCPConstants.ALGORITHM_RSA_ECB_PKCS1);
                    cipher.init(5, r11);
                }
            } else {
                cipher = Cipher.getInstance(VisaSCPConstants.ALGORITHM_PARES);
                cipher.init(2, r11, new OAEPParameterSpec(VisaSCPConstants.ALGORITHM_MD, VisaSCPConstants.ALGORITHM_MGF, VisaSCPConstants.ALGO_PRM_SPEC, PSource.PSpecified.DEFAULT));
                int i17 = f636;
                int i18 = i17 & 103;
                int i19 = ((i17 ^ 103) | i18) << 1;
                int i20 = -((i17 | 103) & (~i18));
                int i21 = ((i19 | i20) << 1) - (i20 ^ i19);
                f637 = i21 % 128;
                if (i21 % 2 == 0) {
                }
            }
            String str2 = new String(cipher.doFinal(bArr));
            int i22 = f636;
            int i23 = (i22 & -46) | ((~i22) & 45);
            int i24 = (i22 & 45) << 1;
            int i25 = (i23 ^ i24) + ((i24 & i23) << 1);
            f637 = i25 % 128;
            if (i25 % 2 != 0) {
                c3 = 'Y';
            }
            if (c3 != 0) {
            }
            return str2;
        } catch (NoSuchAlgorithmException unused) {
            String str3 = VisaSCPConstants.LOG_TAG;
            String str4 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (NoSuchPaddingException unused2) {
            String str5 = VisaSCPConstants.LOG_TAG;
            String str6 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (BadPaddingException unused3) {
            String str7 = VisaSCPConstants.LOG_TAG;
            String str8 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (IllegalBlockSizeException unused4) {
            String str9 = VisaSCPConstants.LOG_TAG;
            String str10 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (InvalidKeyException unused5) {
            String str11 = VisaSCPConstants.LOG_TAG;
            String str12 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (InvalidAlgorithmParameterException unused6) {
            String str13 = VisaSCPConstants.LOG_TAG;
            String str14 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (Exception unused7) {
            String str15 = VisaSCPConstants.LOG_TAG;
            String str16 = VisaSCPConstants.EXCEPTION_MESSAGE;
        }
    }

    public String decryptVisaCertificateResponse(String str, String str2) {
        String str3;
        try {
            Cipher instance = Cipher.getInstance(VisaSCPConstants.ALGORITHM_PAYLOAD);
            instance.init(2, new SecretKeySpec(str2.getBytes(), VisaSCPConstants.ALGORITHM_SK_PAYLOAD), new IvParameterSpec(VisaSCPConstants.IV_FOR_GET_VISA_CERTIFICATE));
            str3 = new String(instance.doFinal(Base64.decode(str.getBytes(), 0)));
            try {
                String str4 = VisaSCPConstants.LOG_TAG;
                int i2 = f637;
                int i3 = i2 & 99;
                int i4 = i2 | 99;
                int i5 = ((i3 | i4) << 1) - (i4 ^ i3);
                f636 = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception unused) {
                String str5 = VisaSCPConstants.LOG_TAG;
                String str6 = VisaSCPConstants.EXCEPTION_MESSAGE;
                int i7 = f636;
                int i8 = (i7 & 121) + (i7 | 121);
                f637 = i8 % 128;
                int i9 = i8 % 2;
                return str3;
            }
        } catch (Exception unused2) {
            str3 = null;
            String str52 = VisaSCPConstants.LOG_TAG;
            String str62 = VisaSCPConstants.EXCEPTION_MESSAGE;
            int i72 = f636;
            int i82 = (i72 & 121) + (i72 | 121);
            f637 = i82 % 128;
            int i92 = i82 % 2;
            return str3;
        }
        int i722 = f636;
        int i822 = (i722 & 121) + (i722 | 121);
        f637 = i822 % 128;
        int i922 = i822 % 2;
        return str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if ((r0 != null) != true) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if ((r0 == null ? (char) 17 : 27) != 27) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
        if ((r0.length == 3 ? (char) 31 : 26) != 26) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0065, code lost:
        if ((r0.length == 5) != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d6, code lost:
        if ((r1.length == 2 ? '\'' : 18) != 18) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00df, code lost:
        if ((r1.length == 3) != false) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0171, code lost:
        r0 = f636;
        r3 = r0 & 75;
        r1 = ((r0 ^ 75) | r3) << 1;
        r0 = -((r0 | 75) & (~r3));
        r3 = ((r1 | r0) << 1) - (r0 ^ r1);
        f637 = r3 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0188, code lost:
        if ((r3 % 2) != 0) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x018a, code lost:
        r0 = 31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x018d, code lost:
        r0 = '@';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x018f, code lost:
        if (r0 == 31) goto L_0x0191;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0191, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.one97.paytm.payments.visascp.network.model.AuthCodeJwsResponseModel decryptAuthCodeResponse(java.lang.String r18, java.lang.String r19) {
        /*
            r17 = this;
            r0 = r19
            int r1 = f636
            int r1 = r1 + 97
            int r2 = r1 % 128
            f637 = r2
            r2 = 2
            int r1 = r1 % r2
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            r5 = 17
            r6 = 31
            java.lang.String r7 = "\\."
            r8 = 0
            if (r1 == r4) goto L_0x002f
            java.lang.String[] r0 = r0.split(r7)
            super.hashCode()     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x0027
            r1 = 0
            goto L_0x0028
        L_0x0027:
            r1 = 1
        L_0x0028:
            if (r1 == r4) goto L_0x0040
            goto L_0x0171
        L_0x002c:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x002f:
            java.lang.String[] r0 = r0.split(r7)
            r1 = 27
            if (r0 != 0) goto L_0x003a
            r9 = 17
            goto L_0x003c
        L_0x003a:
            r9 = 27
        L_0x003c:
            if (r9 == r1) goto L_0x0040
            goto L_0x0171
        L_0x0040:
            int r1 = f637
            int r1 = r1 + 91
            int r9 = r1 % 128
            f636 = r9
            int r1 = r1 % r2
            if (r1 == 0) goto L_0x004d
            r1 = 0
            goto L_0x004e
        L_0x004d:
            r1 = 1
        L_0x004e:
            r9 = 3
            if (r1 == 0) goto L_0x005e
            int r1 = r0.length
            r10 = 26
            if (r1 != r9) goto L_0x0059
            r1 = 31
            goto L_0x005b
        L_0x0059:
            r1 = 26
        L_0x005b:
            if (r1 == r10) goto L_0x0171
            goto L_0x0067
        L_0x005e:
            int r1 = r0.length
            r10 = 5
            if (r1 != r10) goto L_0x0064
            r1 = 1
            goto L_0x0065
        L_0x0064:
            r1 = 0
        L_0x0065:
            if (r1 == 0) goto L_0x0171
        L_0x0067:
            r12 = r0[r3]
            android.util.Base64.decode(r12, r2)
            r1 = r0[r4]
            r6 = r17
            r11 = r18
            byte[] r14 = r6.decryptCek(r11, r1)
            r1 = r0[r2]
            r15 = 8
            byte[] r16 = android.util.Base64.decode(r1, r15)
            r1 = r0[r9]
            r10 = 4
            r13 = r0[r10]
            r10 = r17
            r0 = 8
            r15 = r1
            java.lang.String r1 = r10.decryptPayload(r11, r12, r13, r14, r15, r16)
            r10 = 94
            if (r1 != 0) goto L_0x0092
            r5 = 94
        L_0x0092:
            r11 = 20
            if (r5 == r10) goto L_0x0160
            int r5 = f637
            int r5 = r5 + 43
            int r10 = r5 % 128
            f636 = r10
            int r5 = r5 % r2
            java.lang.String[] r1 = r1.split(r7)
            if (r1 != 0) goto L_0x00a8
            r5 = 28
            goto L_0x00aa
        L_0x00a8:
            r5 = 69
        L_0x00aa:
            r7 = 28
            if (r5 == r7) goto L_0x0148
            int r5 = f636
            r7 = r5 & 11
            r5 = r5 ^ 11
            r5 = r5 | r7
            int r5 = -r5
            int r5 = -r5
            r10 = r7 | r5
            int r10 = r10 << r4
            r5 = r5 ^ r7
            int r10 = r10 - r5
            int r5 = r10 % 128
            f637 = r5
            int r10 = r10 % r2
            r5 = 57
            if (r10 != 0) goto L_0x00c8
            r7 = 57
            goto L_0x00ca
        L_0x00c8:
            r7 = 46
        L_0x00ca:
            if (r7 == r5) goto L_0x00d9
            int r7 = r1.length
            if (r7 != r2) goto L_0x00d2
            r7 = 39
            goto L_0x00d4
        L_0x00d2:
            r7 = 18
        L_0x00d4:
            r9 = 18
            if (r7 == r9) goto L_0x0148
            goto L_0x00e1
        L_0x00d9:
            int r7 = r1.length
            if (r7 != r9) goto L_0x00de
            r7 = 1
            goto L_0x00df
        L_0x00de:
            r7 = 0
        L_0x00df:
            if (r7 == 0) goto L_0x0148
        L_0x00e1:
            r7 = r1[r3]
            android.util.Base64.decode(r7, r0)
            r9 = r1[r4]
            java.lang.String r10 = new java.lang.String
            byte[] r0 = android.util.Base64.decode(r9, r0)
            r10.<init>(r0)
            com.google.gson.f r0 = new com.google.gson.f
            r0.<init>()
            java.lang.Class<net.one97.paytm.payments.visascp.network.model.AuthCodeJwsResponseModel> r12 = net.one97.paytm.payments.visascp.network.model.AuthCodeJwsResponseModel.class
            java.lang.Object r0 = r0.a((java.lang.String) r10, r12)
            net.one97.paytm.payments.visascp.network.model.AuthCodeJwsResponseModel r0 = (net.one97.paytm.payments.visascp.network.model.AuthCodeJwsResponseModel) r0
            r1 = r1[r2]
            net.one97.paytm.payments.visascp.network.model.PublicKeyObject r10 = r0.getPublicKey()
            java.lang.String r10 = r10.getPublicKey()
            boolean r1 = m712(r7, r9, r1, r10)
            if (r1 != 0) goto L_0x0111
            r1 = 20
            goto L_0x0113
        L_0x0111:
            r1 = 67
        L_0x0113:
            r7 = 67
            if (r1 == r7) goto L_0x0118
            goto L_0x0160
        L_0x0118:
            int r1 = f636
            r3 = r1 | 57
            int r3 = r3 << r4
            r1 = r1 ^ r5
            int r3 = r3 - r1
            int r1 = r3 % 128
            f637 = r1
            int r3 = r3 % r2
            int r1 = f637
            r3 = r1 ^ 103(0x67, float:1.44E-43)
            r5 = r1 & 103(0x67, float:1.44E-43)
            r3 = r3 | r5
            int r3 = r3 << r4
            int r5 = ~r5
            r1 = r1 | 103(0x67, float:1.44E-43)
            r1 = r1 & r5
            int r1 = -r1
            r5 = r3 | r1
            int r4 = r5 << 1
            r1 = r1 ^ r3
            int r4 = r4 - r1
            int r1 = r4 % 128
            f636 = r1
            int r4 = r4 % r2
            if (r4 == 0) goto L_0x0141
            r1 = 63
            goto L_0x0143
        L_0x0141:
            r1 = 80
        L_0x0143:
            r2 = 63
            if (r1 == r2) goto L_0x0147
        L_0x0147:
            return r0
        L_0x0148:
            int r0 = f637
            r1 = r0 ^ 53
            r0 = r0 & 53
            int r0 = r0 << r4
            int r0 = -r0
            int r0 = -r0
            r5 = r1 & r0
            r0 = r0 | r1
            int r5 = r5 + r0
            int r0 = r5 % 128
            f636 = r0
            int r5 = r5 % r2
            if (r5 == 0) goto L_0x015d
            r3 = 1
        L_0x015d:
            if (r3 == r4) goto L_0x015f
        L_0x015f:
            return r8
        L_0x0160:
            int r0 = f637
            r1 = r0 & 20
            r0 = r0 | r11
            int r1 = r1 + r0
            int r1 = r1 - r4
            int r0 = r1 % 128
            f636 = r0
            int r1 = r1 % r2
            if (r1 == 0) goto L_0x016f
            goto L_0x0170
        L_0x016f:
            r3 = 1
        L_0x0170:
            return r8
        L_0x0171:
            int r0 = f636
            r1 = r0 ^ 75
            r3 = r0 & 75
            r1 = r1 | r3
            int r1 = r1 << r4
            int r3 = ~r3
            r0 = r0 | 75
            r0 = r0 & r3
            int r0 = -r0
            r3 = r1 | r0
            int r3 = r3 << r4
            r0 = r0 ^ r1
            int r3 = r3 - r0
            int r0 = r3 % 128
            f637 = r0
            int r3 = r3 % r2
            if (r3 != 0) goto L_0x018d
            r0 = 31
            goto L_0x018f
        L_0x018d:
            r0 = 64
        L_0x018f:
            if (r0 == r6) goto L_0x0191
        L_0x0191:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.security.Decrypter.decryptAuthCodeResponse(java.lang.String, java.lang.String):net.one97.paytm.payments.visascp.network.model.AuthCodeJwsResponseModel");
    }
}
