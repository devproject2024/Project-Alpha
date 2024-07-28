package net.one97.paytm.payments.visascp.security;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
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
import java.security.SecureRandom;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import net.one97.paytm.payments.visascp.storage.SecureSharedPref;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class Encrypter {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f639 = 1;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f640;

    /* renamed from: ˎ  reason: contains not printable characters */
    private KeyStore f641;

    public Encrypter() {
        try {
            this.f641 = KeyStore.getInstance(VisaSCPConstants.ANDROID_KEY_STORE);
            this.f641.load((KeyStore.LoadStoreParameter) null);
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

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fe A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String createJWTTokenForVisaCertificate(java.lang.String r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "\\"
            java.lang.String r2 = "."
            r3 = 0
            r4 = 0
            r5 = 1
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r6.<init>()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_ALGO     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_TOKEN_TYPE     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.VALUE_JWT     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r6 = r6.replace(r1, r0)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            byte[] r6 = r6.getBytes()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r7 = 11
            java.lang.String r6 = android.util.Base64.encodeToString(r6, r7)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r8.<init>()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_PACKAGE_NAME     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r8.put(r9, r14)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r14 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_TIME_STAMP     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r11 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 / r11
            r8.put(r14, r9)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r14 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_CUST_ID     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r8.put(r14, r15)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r14 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_ALGORITHM     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r15 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_PAYLOAD     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r8.put(r14, r15)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r14 = r8.toString()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r14 = r14.replace(r1, r0)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            byte[] r14 = r14.getBytes()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r14 = android.util.Base64.encodeToString(r14, r7)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r15.<init>()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r15.append(r6)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r15.append(r2)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r15.append(r14)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r15 = r15.toString()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            byte[] r15 = r13.signWithStaticPrivateKey(r15)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            if (r15 == 0) goto L_0x007c
            r0 = 0
            goto L_0x007d
        L_0x007c:
            r0 = 1
        L_0x007d:
            if (r0 == 0) goto L_0x00a4
            int r14 = f639
            r15 = r14 & -86
            int r0 = ~r14
            r0 = r0 & 85
            r15 = r15 | r0
            r14 = r14 & 85
            int r14 = r14 << r5
            int r15 = r15 + r14
            int r14 = r15 % 128
            f640 = r14
            int r15 = r15 % 2
            int r14 = f640
            r15 = r14 & 96
            r14 = r14 | 96
            int r15 = r15 + r14
            r14 = r15 | -1
            int r14 = r14 << r5
            int r15 = ~r15
            int r14 = r14 - r15
            int r15 = r14 % 128
            f639 = r15
            int r14 = r14 % 2
            return r4
        L_0x00a4:
            java.lang.String r15 = android.util.Base64.encodeToString(r15, r7)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r0.<init>()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r0.append(r6)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r0.append(r2)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r0.append(r14)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r0.append(r2)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            r0.append(r15)     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r14 = r0.toString()     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            java.lang.String r15 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ JSONException -> 0x00dc, Exception -> 0x00d7 }
            int r15 = f639
            int r15 = r15 + 93
            int r15 = r15 - r5
            r0 = r15 | -1
            int r0 = r0 << r5
            int r15 = ~r15
            int r0 = r0 - r15
            int r15 = r0 % 128
            f640 = r15
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r3 = 1
        L_0x00d6:
            return r14
        L_0x00d7:
            java.lang.String r14 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r14 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00e0
        L_0x00dc:
            java.lang.String r14 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r14 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x00e0:
            int r14 = f639
            r15 = r14 & 93
            r14 = r14 ^ 93
            r14 = r14 | r15
            int r14 = -r14
            int r14 = -r14
            r0 = r15 & r14
            r14 = r14 | r15
            int r0 = r0 + r14
            int r14 = r0 % 128
            f640 = r14
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x00f6
            r3 = 1
        L_0x00f6:
            if (r3 == r5) goto L_0x00fe
            super.hashCode()     // Catch:{ all -> 0x00fc }
            return r4
        L_0x00fc:
            r14 = move-exception
            throw r14
        L_0x00fe:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.security.Encrypter.createJWTTokenForVisaCertificate(java.lang.String, java.lang.String):java.lang.String");
    }

    public byte[] signData(String str, String str2) {
        byte[] bArr = null;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(VisaSCPConstants.KEY_ALGO, VisaSCPConstants.ALGORITHM);
            String encodeToString = Base64.encodeToString(jSONObject.toString().replace("\\", "").getBytes(), 2);
            String encodeToString2 = Base64.encodeToString(str2.getBytes(), 2);
            StringBuilder sb = new StringBuilder();
            sb.append(encodeToString);
            sb.append(AppUtility.CENTER_DOT);
            sb.append(encodeToString2);
            byte[] sign = sign(str, sb.toString());
            if ((sign != null ? 'H' : 'X') != 'H') {
                int i2 = (f640 + 101) - 1;
                int i3 = (~i2) + ((i2 & -1) << 1);
                f639 = i3 % 128;
                int i4 = i3 % 2;
                int i5 = (f640 + 25) - 1;
                int i6 = ((i5 | -1) << 1) - (~i5);
                f639 = i6 % 128;
                if ((i6 % 2 != 0 ? 'W' : 'A') != 'A') {
                    return bArr;
                }
                super.hashCode();
                return bArr;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(encodeToString);
            sb2.append(AppUtility.CENTER_DOT);
            sb2.append(encodeToString2);
            sb2.append(AppUtility.CENTER_DOT);
            sb2.append(Base64.encodeToString(sign, 2));
            byte[] bytes = sb2.toString().getBytes();
            int i7 = f640;
            int i8 = i7 & 121;
            int i9 = ((i7 ^ 121) | i8) << 1;
            int i10 = -((i7 | 121) & (~i8));
            int i11 = (i9 ^ i10) + ((i10 & i9) << 1);
            f639 = i11 % 128;
            int i12 = i11 % 2;
            return bytes;
        } catch (JSONException unused) {
            String str3 = VisaSCPConstants.LOG_TAG;
            String str4 = VisaSCPConstants.EXCEPTION_MESSAGE;
            int i13 = f639;
            int i14 = (i13 ^ 11) + ((i13 & 11) << 1);
            f640 = i14 % 128;
            int i15 = i14 % 2;
            return bArr;
        } catch (Exception unused2) {
            String str5 = VisaSCPConstants.LOG_TAG;
            String str6 = VisaSCPConstants.EXCEPTION_MESSAGE;
            int i132 = f639;
            int i142 = (i132 ^ 11) + ((i132 & 11) << 1);
            f640 = i142 % 128;
            int i152 = i142 % 2;
            return bArr;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        if ((r3 == null ? '[' : 'T') != '[') goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] signWithStaticPrivateKey(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = f639
            r1 = r0 & 11
            int r2 = ~r1
            r0 = r0 | 11
            r0 = r0 & r2
            r2 = 1
            int r1 = r1 << r2
            int r0 = r0 + r1
            int r1 = r0 % 128
            f640 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            r1 = 0
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_SHA_RSA     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            java.security.Signature r0 = java.security.Signature.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            java.security.PrivateKey r3 = m714()     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            r4 = 32
            if (r3 != 0) goto L_0x0029
            r5 = 4
            goto L_0x002b
        L_0x0029:
            r5 = 32
        L_0x002b:
            if (r5 == r4) goto L_0x0046
            goto L_0x0083
        L_0x002e:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_SHA_RSA     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            java.security.Signature r0 = java.security.Signature.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            java.security.PrivateKey r3 = m714()     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            super.hashCode()     // Catch:{ all -> 0x0097 }
            r4 = 91
            if (r3 != 0) goto L_0x0042
            r5 = 91
            goto L_0x0044
        L_0x0042:
            r5 = 84
        L_0x0044:
            if (r5 == r4) goto L_0x0083
        L_0x0046:
            int r4 = f640
            r5 = r4 ^ 51
            r4 = r4 & 51
            r4 = r4 | r5
            int r4 = r4 << r2
            int r5 = -r5
            r6 = r4 | r5
            int r6 = r6 << r2
            r4 = r4 ^ r5
            int r6 = r6 - r4
            int r4 = r6 % 128
            f639 = r4
            int r6 = r6 % 2
            r4 = 22
            if (r6 == 0) goto L_0x0061
            r5 = 15
            goto L_0x0063
        L_0x0061:
            r5 = 22
        L_0x0063:
            if (r5 == r4) goto L_0x0074
            r0.initSign(r3)     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            byte[] r8 = r8.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            r0.update(r8)     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            byte[] r1 = r0.sign()     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            goto L_0x0083
        L_0x0074:
            r0.initSign(r3)     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            byte[] r8 = r8.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            r0.update(r8)     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            byte[] r8 = r0.sign()     // Catch:{ NoSuchAlgorithmException -> 0x00a8, SignatureException -> 0x00a3, InvalidKeyException -> 0x009e, Exception -> 0x0099 }
            r1 = r8
        L_0x0083:
            int r8 = f639
            int r8 = r8 + 41
            int r0 = r8 % 128
            f640 = r0
            int r8 = r8 % 2
            r0 = 76
            if (r8 != 0) goto L_0x0094
            r8 = 95
            goto L_0x00ac
        L_0x0094:
            r8 = 76
            goto L_0x00ac
        L_0x0097:
            r8 = move-exception
            throw r8
        L_0x0099:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00ac
        L_0x009e:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00ac
        L_0x00a3:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00ac
        L_0x00a8:
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x00ac:
            int r8 = f639
            r0 = r8 & 109(0x6d, float:1.53E-43)
            r8 = r8 | 109(0x6d, float:1.53E-43)
            r3 = r0 ^ r8
            r8 = r8 & r0
            int r8 = r8 << r2
            int r3 = r3 + r8
            int r8 = r3 % 128
            f640 = r8
            int r3 = r3 % 2
            r8 = 44
            if (r3 != 0) goto L_0x00c4
            r0 = 44
            goto L_0x00c6
        L_0x00c4:
            r0 = 57
        L_0x00c6:
            if (r0 == r8) goto L_0x00c8
        L_0x00c8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.security.Encrypter.signWithStaticPrivateKey(java.lang.String):byte[]");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] sign(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            int r0 = f639
            r1 = r0 & -90
            int r2 = ~r0
            r2 = r2 & 89
            r1 = r1 | r2
            r0 = r0 & 89
            r2 = 1
            int r0 = r0 << r2
            int r0 = -r0
            int r0 = -r0
            r3 = r1 | r0
            int r3 = r3 << r2
            r0 = r0 ^ r1
            int r3 = r3 - r0
            int r0 = r3 % 128
            f640 = r0
            int r3 = r3 % 2
            r0 = 0
            r1 = 0
            java.lang.String r3 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_SHA_RSA     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            java.security.Signature r3 = java.security.Signature.getInstance(r3)     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            java.security.PrivateKey r8 = r7.m717(r8)     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            r4 = 38
            if (r8 != 0) goto L_0x002c
            r5 = 38
            goto L_0x002e
        L_0x002c:
            r5 = 25
        L_0x002e:
            if (r5 == r4) goto L_0x0074
            int r4 = f640
            r5 = r4 ^ 111(0x6f, float:1.56E-43)
            r6 = r4 & 111(0x6f, float:1.56E-43)
            r5 = r5 | r6
            int r5 = r5 << r2
            int r6 = ~r6
            r4 = r4 | 111(0x6f, float:1.56E-43)
            r4 = r4 & r6
            int r4 = -r4
            int r4 = ~r4
            int r5 = r5 - r4
            int r5 = r5 - r2
            int r4 = r5 % 128
            f639 = r4
            int r5 = r5 % 2
            r4 = 30
            if (r5 == 0) goto L_0x004d
            r5 = 83
            goto L_0x004f
        L_0x004d:
            r5 = 30
        L_0x004f:
            if (r5 == r4) goto L_0x0060
            r3.initSign(r8)     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            byte[] r8 = r9.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            r3.update(r8)     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            byte[] r1 = r3.sign()     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            goto L_0x0074
        L_0x0060:
            r3.initSign(r8)     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            byte[] r8 = r9.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            r3.update(r8)     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            byte[] r8 = r3.sign()     // Catch:{ NoSuchAlgorithmException -> 0x00a2, SignatureException -> 0x009c, InvalidKeyException -> 0x0096, Exception -> 0x0090 }
            super.hashCode()     // Catch:{ NoSuchAlgorithmException -> 0x00a3, SignatureException -> 0x009d, InvalidKeyException -> 0x0097, Exception -> 0x0091, all -> 0x0072 }
            goto L_0x0075
        L_0x0072:
            r8 = move-exception
            throw r8
        L_0x0074:
            r8 = r1
        L_0x0075:
            int r9 = f640
            r1 = r9 ^ 107(0x6b, float:1.5E-43)
            r3 = r9 & 107(0x6b, float:1.5E-43)
            r1 = r1 | r3
            int r1 = r1 << r2
            r3 = r9 & -108(0xffffffffffffff94, float:NaN)
            int r9 = ~r9
            r9 = r9 & 107(0x6b, float:1.5E-43)
            r9 = r9 | r3
            int r1 = r1 - r9
            int r9 = r1 % 128
            f639 = r9
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x008e
            r9 = 1
            goto L_0x00a7
        L_0x008e:
            r9 = 0
            goto L_0x00a7
        L_0x0090:
            r8 = r1
        L_0x0091:
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00a7
        L_0x0096:
            r8 = r1
        L_0x0097:
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00a7
        L_0x009c:
            r8 = r1
        L_0x009d:
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00a7
        L_0x00a2:
            r8 = r1
        L_0x00a3:
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r9 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x00a7:
            int r9 = f640
            r1 = r9 ^ 17
            r3 = r9 & 17
            r1 = r1 | r3
            int r1 = r1 << r2
            int r3 = ~r3
            r9 = r9 | 17
            r9 = r9 & r3
            int r9 = -r9
            int r9 = ~r9
            int r1 = r1 - r9
            int r1 = r1 - r2
            int r9 = r1 % 128
            f639 = r9
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r0 = 1
        L_0x00c1:
            if (r0 == 0) goto L_0x00c3
        L_0x00c3:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.security.Encrypter.sign(java.lang.String, java.lang.String):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        if ((r1.length <= 0) != false) goto L_0x0054;
     */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String encryptWithVisaStaticPublicKey(byte[] r22) {
        /*
            r21 = this;
            r1 = r22
            java.lang.String r6 = "."
            int r0 = f640
            r2 = r0 & 90
            r0 = r0 | 90
            int r2 = r2 + r0
            int r0 = ~r2
            r2 = r2 & -1
            r7 = 1
            int r2 = r2 << r7
            int r0 = r0 + r2
            int r2 = r0 % 128
            f639 = r2
            r8 = 2
            int r0 = r0 % r8
            r0 = 24
            if (r1 != 0) goto L_0x001e
            r2 = 13
            goto L_0x0020
        L_0x001e:
            r2 = 24
        L_0x0020:
            r3 = 52
            r9 = 0
            if (r2 == r0) goto L_0x0026
            goto L_0x0054
        L_0x0026:
            int r0 = f640
            int r0 = r0 + 5
            int r0 = r0 - r7
            int r2 = ~r0
            r0 = r0 & -1
            int r0 = r0 << r7
            int r2 = r2 + r0
            int r0 = r2 % 128
            f639 = r0
            int r2 = r2 % r8
            r10 = 0
            if (r2 == 0) goto L_0x003a
            r0 = 0
            goto L_0x003b
        L_0x003a:
            r0 = 1
        L_0x003b:
            r11 = 23
            if (r0 == 0) goto L_0x004c
            int r0 = r1.length     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2 = 51
            if (r0 <= 0) goto L_0x0047
            r0 = 51
            goto L_0x0049
        L_0x0047:
            r0 = 50
        L_0x0049:
            if (r0 == r2) goto L_0x0075
            goto L_0x0054
        L_0x004c:
            int r0 = r1.length     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            if (r0 <= 0) goto L_0x0051
            r0 = 0
            goto L_0x0052
        L_0x0051:
            r0 = 1
        L_0x0052:
            if (r0 == 0) goto L_0x0075
        L_0x0054:
            int r0 = f640
            r1 = r0 ^ 73
            r2 = r0 & 73
            r1 = r1 | r2
            int r1 = r1 << r7
            r2 = r0 & -74
            int r0 = ~r0
            r0 = r0 & 73
            r0 = r0 | r2
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 - r7
            int r0 = r1 % 128
            f639 = r0
            int r1 = r1 % r8
            r0 = 25
            if (r1 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r3 = 25
        L_0x0072:
            if (r3 == r0) goto L_0x0074
        L_0x0074:
            return r9
        L_0x0075:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_SK_PAYLOAD     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            javax.crypto.KeyGenerator r0 = javax.crypto.KeyGenerator.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_SIZE_ENCRYPT     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r0.init(r2)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            javax.crypto.SecretKey r12 = r0.generateKey()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r0 = 12
            byte[] r0 = new byte[r0]     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.security.SecureRandom r2 = new java.security.SecureRandom     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2.nextBytes(r0)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r13 = android.util.Base64.encodeToString(r0, r8)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            if (r4 < r11) goto L_0x009f
            r4 = 1
            goto L_0x00a0
        L_0x009f:
            r4 = 0
        L_0x00a0:
            if (r4 == r7) goto L_0x00d5
            int r4 = f639
            r5 = r4 ^ 123(0x7b, float:1.72E-43)
            r14 = r4 & 123(0x7b, float:1.72E-43)
            r5 = r5 | r14
            int r5 = r5 << r7
            r14 = r4 & -124(0xffffffffffffff84, float:NaN)
            int r4 = ~r4
            r4 = r4 & 123(0x7b, float:1.72E-43)
            r4 = r4 | r14
            int r4 = -r4
            r14 = r5 ^ r4
            r4 = r4 & r5
            int r4 = r4 << r7
            int r14 = r14 + r4
            int r4 = r14 % 128
            f640 = r4
            int r14 = r14 % r8
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_ALGO     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_ENCRYPT_RSA_1_5     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2.put(r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r4 = f639
            r5 = r4 ^ 63
            r4 = r4 & 63
            int r4 = r4 << r7
            int r5 = r5 + r4
            int r4 = r5 % 128
            f640 = r4
            int r5 = r5 % r8
            if (r5 != 0) goto L_0x00d3
            r4 = 1
            goto L_0x00ed
        L_0x00d3:
            r4 = 0
            goto L_0x00ed
        L_0x00d5:
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_ALGO     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_ENCRYPT_VS_PK     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2.put(r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r4 = f640
            r5 = r4 ^ 111(0x6f, float:1.56E-43)
            r4 = r4 & 111(0x6f, float:1.56E-43)
            int r4 = r4 << r7
            r14 = r5 ^ r4
            r4 = r4 & r5
            int r4 = r4 << r7
            int r14 = r14 + r4
            int r4 = r14 % 128
            f639 = r4
            int r14 = r14 % r8
        L_0x00ed:
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_ENCODING     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_JWE_HEADER     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2.put(r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r2 = r2.toString()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r4 = "\\"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.replace(r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            byte[] r2 = r2.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r14 = android.util.Base64.encodeToString(r2, r8)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_PAYLOAD     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            javax.crypto.Cipher r15 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r4 = 19
            r5 = 11
            if (r2 > r4) goto L_0x012a
            javax.crypto.spec.IvParameterSpec r2 = new javax.crypto.spec.IvParameterSpec     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2.<init>(r0)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r0 = f640
            r3 = r0 & 76
            r0 = r0 | 76
            int r3 = r3 + r0
            int r3 = r3 - r10
            int r3 = r3 - r7
            int r0 = r3 % 128
            f639 = r0
            int r3 = r3 % r8
            goto L_0x0146
        L_0x012a:
            javax.crypto.spec.GCMParameterSpec r2 = new javax.crypto.spec.GCMParameterSpec     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r4 = 128(0x80, float:1.794E-43)
            r2.<init>(r4, r0)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r0 = f639
            r4 = r0 & 11
            r0 = r0 ^ r5
            r0 = r0 | r4
            int r0 = ~r0
            int r4 = r4 - r0
            int r4 = r4 - r7
            int r0 = r4 % 128
            f640 = r0
            int r4 = r4 % r8
            if (r4 != 0) goto L_0x0142
            goto L_0x0144
        L_0x0142:
            r3 = 29
        L_0x0144:
            r0 = 29
        L_0x0146:
            r15.init(r7, r12, r2)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2 = 83
            if (r0 == 0) goto L_0x0154
            r0 = 28
            goto L_0x0156
        L_0x0154:
            r0 = 83
        L_0x0156:
            r3 = 28
            if (r0 == r3) goto L_0x019a
            int r0 = f639
            r3 = r0 & 83
            r0 = r0 | r2
            int r0 = -r0
            int r0 = -r0
            r2 = r3 & r0
            r0 = r0 | r3
            int r2 = r2 + r0
            int r0 = r2 % 128
            f640 = r0
            int r2 = r2 % r8
            if (r2 != 0) goto L_0x016f
            r0 = 34
            goto L_0x0171
        L_0x016f:
            r0 = 18
        L_0x0171:
            r2 = 34
            if (r0 == r2) goto L_0x017d
            byte[] r0 = r14.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r15.updateAAD(r0)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            goto L_0x0184
        L_0x017d:
            byte[] r0 = r14.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r15.updateAAD(r0)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
        L_0x0184:
            int r0 = f639
            r2 = r0 & 103(0x67, float:1.44E-43)
            int r3 = ~r2
            r0 = r0 | 103(0x67, float:1.44E-43)
            r0 = r0 & r3
            int r2 = r2 << r7
            int r0 = r0 + r2
            int r2 = r0 % 128
            f640 = r2
            int r0 = r0 % r8
            if (r0 != 0) goto L_0x0198
            r0 = 11
            goto L_0x019a
        L_0x0198:
            r0 = 76
        L_0x019a:
            int r0 = r1.length     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r0 = r15.getOutputSize(r0)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            byte[] r5 = new byte[r0]     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2 = 0
            int r3 = r1.length     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r16 = 0
            r0 = r15
            r1 = r22
            r4 = r5
            r22 = r5
            r5 = r16
            int r0 = r0.update(r1, r2, r3, r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r20 = r0 + 0
            byte[] r0 = new byte[r10]     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r17 = 0
            r18 = 0
            r16 = r0
            r19 = r22
            r15.doFinal(r16, r17, r18, r19, r20)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r0 = r22
            int r1 = r0.length     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2 = r1 | -16
            int r3 = r2 << 1
            r1 = r1 & -16
            int r1 = ~r1     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r1 = r1 & r2
            int r1 = -r1
            r2 = r3 & r1
            r1 = r1 | r3
            int r2 = r2 + r1
            byte[] r1 = java.util.Arrays.copyOfRange(r0, r10, r2)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r8)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r3 = r0.length     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            byte[] r0 = java.util.Arrays.copyOfRange(r0, r2, r3)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r8)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            if (r2 < r11) goto L_0x01e8
            r2 = 10
            goto L_0x01ea
        L_0x01e8:
            r2 = 35
        L_0x01ea:
            r3 = 35
            if (r2 == r3) goto L_0x021b
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_PARES     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            javax.crypto.spec.OAEPParameterSpec r3 = new javax.crypto.spec.OAEPParameterSpec     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_MD     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_MGF     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.security.spec.AlgorithmParameterSpec r15 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGO_PRM_SPEC     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            javax.crypto.spec.PSource$PSpecified r9 = javax.crypto.spec.PSource.PSpecified.DEFAULT     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.<init>(r4, r5, r15, r9)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.security.PublicKey r4 = m713()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2.init(r7, r4, r3)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r3 = f640
            r4 = r3 & 101(0x65, float:1.42E-43)
            r3 = r3 ^ 101(0x65, float:1.42E-43)
            r3 = r3 | r4
            int r4 = r4 + r3
            int r3 = r4 % 128
            f639 = r3
            int r4 = r4 % r8
            if (r4 == 0) goto L_0x0219
            r3 = 1
            goto L_0x024b
        L_0x0219:
            r3 = 0
            goto L_0x024b
        L_0x021b:
            int r2 = f639
            int r2 = r2 + 70
            r3 = r2 & -1
            r2 = r2 | -1
            int r3 = r3 + r2
            int r2 = r3 % 128
            f640 = r2
            int r3 = r3 % r8
            if (r3 != 0) goto L_0x022d
            r2 = 0
            goto L_0x022e
        L_0x022d:
            r2 = 1
        L_0x022e:
            if (r2 == r7) goto L_0x023e
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_RSA_ECB_PKCS1     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.security.PublicKey r3 = m713()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2.init(r7, r3)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            goto L_0x024b
        L_0x023e:
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_RSA_ECB_PKCS1     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.security.PublicKey r3 = m713()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r2.init(r10, r3)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
        L_0x024b:
            byte[] r3 = r12.getEncoded()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            byte[] r2 = r2.doFinal(r3)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r8)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.append(r14)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.append(r6)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.append(r2)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.append(r6)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.append(r13)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.append(r6)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.append(r1)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.append(r6)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            r3.append(r0)     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            java.lang.String r9 = r3.toString()     // Catch:{ NoSuchAlgorithmException -> 0x02b7, NoSuchPaddingException -> 0x02b2, BadPaddingException -> 0x02ad, IllegalBlockSizeException -> 0x02a8, InvalidKeyException -> 0x02a3, InvalidAlgorithmParameterException -> 0x029e, JSONException -> 0x0299, ShortBufferException -> 0x0294, Exception -> 0x028f }
            int r0 = f640
            r1 = r0 & 103(0x67, float:1.44E-43)
            int r2 = ~r1
            r0 = r0 | 103(0x67, float:1.44E-43)
            r0 = r0 & r2
            int r1 = r1 << r7
            int r1 = ~r1
            int r0 = r0 - r1
            int r0 = r0 - r7
            int r1 = r0 % 128
            f639 = r1
            int r0 = r0 % r8
            r16 = r9
            goto L_0x02bd
        L_0x028f:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x02bb
        L_0x0294:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x02bb
        L_0x0299:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x02bb
        L_0x029e:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x02bb
        L_0x02a3:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x02bb
        L_0x02a8:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x02bb
        L_0x02ad:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x02bb
        L_0x02b2:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x02bb
        L_0x02b7:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x02bb:
            r16 = 0
        L_0x02bd:
            int r0 = f639
            r1 = r0 | 23
            int r1 = r1 << r7
            r0 = r0 ^ r11
            int r1 = r1 - r0
            int r0 = r1 % 128
            f640 = r0
            int r1 = r1 % r8
            if (r1 != 0) goto L_0x02cc
            goto L_0x02cd
        L_0x02cc:
            r7 = 0
        L_0x02cd:
            if (r7 == 0) goto L_0x02cf
        L_0x02cf:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.security.Encrypter.encryptWithVisaStaticPublicKey(byte[]):java.lang.String");
    }

    public byte[] encryptStorageData(Context context, String str, String str2) {
        byte[] doFinal;
        int i2 = f640;
        int i3 = i2 & 121;
        int i4 = i3 + ((i2 ^ 121) | i3);
        f639 = i4 % 128;
        byte[] bArr = null;
        if ((i4 % 2 != 0 ? '2' : '#') != '2') {
            try {
                Cipher instance = Cipher.getInstance(VisaSCPConstants.RSA_ALGORITHM);
                instance.init(1, m715(str));
                doFinal = instance.doFinal(str2.getBytes());
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
            } catch (Exception unused6) {
                String str13 = VisaSCPConstants.LOG_TAG;
                String str14 = VisaSCPConstants.EXCEPTION_MESSAGE;
            }
        } else {
            Cipher instance2 = Cipher.getInstance(VisaSCPConstants.RSA_ALGORITHM);
            instance2.init(1, m715(str));
            doFinal = instance2.doFinal(str2.getBytes());
        }
        bArr = doFinal;
        int i5 = f640;
        int i6 = (i5 & -90) | ((~i5) & 89);
        int i7 = (i5 & 89) << 1;
        int i8 = ((i6 | i7) << 1) - (i7 ^ i6);
        f639 = i8 % 128;
        int i9 = i8 % 2;
        int i10 = f640 + 106;
        int i11 = ((i10 | -1) << 1) - (~i10);
        f639 = i11 % 128;
        int i12 = i11 % 2;
        return bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        if ((!r5) != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        if ((!net.one97.paytm.payments.visascp.VisaSDK.isStaging()) != true) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r3 != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.VISA_STAGING_PUBLIC_KEY;
        r3 = f639;
        r5 = r3 & 53;
        r5 = r5 + ((r3 ^ 53) | r5);
        f640 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r1 = java.security.KeyFactory.getInstance(net.one97.paytm.payments.visascp.util.VisaSCPConstants.RSA_ALGORITHM).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(r1.getBytes(), 2)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0075, code lost:
        r3 = f639;
        r4 = ((((r3 ^ 27) | (r3 & 27)) << 1) - (~(-(((~r3) & 27) | (r3 & -28))))) - 1;
        f640 = r4 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
        if ((r4 % 2) != 0) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        r2 = 'B';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r2 = ':';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0095, code lost:
        if (r2 == 'B') goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0098, code lost:
        r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a2, code lost:
        r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG;
        r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a6, code lost:
        r1 = f639;
        r2 = ((r1 | 35) << 1) - (r1 ^ 35);
        f640 = r2 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b6, code lost:
        if ((r2 % 2) == 0) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b8, code lost:
        r1 = '@';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bb, code lost:
        r1 = 'K';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bd, code lost:
        if (r1 != 'K') goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bf, code lost:
        return r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bb  */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.PublicKey m713() {
        /*
            int r0 = f639
            r1 = r0 | 13
            int r2 = r1 << 1
            r0 = r0 & 13
            int r0 = ~r0
            r0 = r0 & r1
            int r0 = -r0
            r1 = r2 ^ r0
            r0 = r0 & r2
            r2 = 1
            int r0 = r0 << r2
            int r1 = r1 + r0
            int r0 = r1 % 128
            f640 = r0
            r0 = 2
            int r1 = r1 % r0
            r3 = 0
            if (r1 != 0) goto L_0x001c
            r1 = 0
            goto L_0x001d
        L_0x001c:
            r1 = 1
        L_0x001d:
            r4 = 0
            if (r1 == 0) goto L_0x0033
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.VISA_PROD_PUBLIC_KEY
            boolean r5 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()
            super.hashCode()     // Catch:{ all -> 0x0031 }
            if (r5 == 0) goto L_0x002d
            r5 = 0
            goto L_0x002e
        L_0x002d:
            r5 = 1
        L_0x002e:
            if (r5 == 0) goto L_0x004f
            goto L_0x0041
        L_0x0031:
            r0 = move-exception
            throw r0
        L_0x0033:
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.VISA_PROD_PUBLIC_KEY
            boolean r5 = net.one97.paytm.payments.visascp.VisaSDK.isStaging()
            if (r5 == 0) goto L_0x003d
            r5 = 0
            goto L_0x003e
        L_0x003d:
            r5 = 1
        L_0x003e:
            if (r5 == r2) goto L_0x0041
            goto L_0x004f
        L_0x0041:
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.BUILD_TYPE_STAGING
            java.lang.String r6 = "release"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 != 0) goto L_0x004c
            r3 = 1
        L_0x004c:
            if (r3 == 0) goto L_0x004f
            goto L_0x005e
        L_0x004f:
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.VISA_STAGING_PUBLIC_KEY
            int r3 = f639
            r5 = r3 & 53
            r3 = r3 ^ 53
            r3 = r3 | r5
            int r5 = r5 + r3
            int r3 = r5 % 128
            f640 = r3
            int r5 = r5 % r0
        L_0x005e:
            byte[] r1 = r1.getBytes()
            byte[] r1 = android.util.Base64.decode(r1, r0)
            java.security.spec.X509EncodedKeySpec r3 = new java.security.spec.X509EncodedKeySpec
            r3.<init>(r1)
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.RSA_ALGORITHM     // Catch:{ NoSuchAlgorithmException -> 0x00a2, InvalidKeySpecException -> 0x009d, Exception -> 0x0098 }
            java.security.KeyFactory r1 = java.security.KeyFactory.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x00a2, InvalidKeySpecException -> 0x009d, Exception -> 0x0098 }
            java.security.PublicKey r1 = r1.generatePublic(r3)     // Catch:{ NoSuchAlgorithmException -> 0x00a2, InvalidKeySpecException -> 0x009d, Exception -> 0x0098 }
            int r3 = f639
            r4 = r3 ^ 27
            r5 = r3 & 27
            r4 = r4 | r5
            int r4 = r4 << r2
            r5 = r3 & -28
            int r3 = ~r3
            r3 = r3 & 27
            r3 = r3 | r5
            int r3 = -r3
            int r3 = ~r3
            int r4 = r4 - r3
            int r4 = r4 - r2
            int r2 = r4 % 128
            f640 = r2
            int r4 = r4 % r0
            r0 = 66
            if (r4 != 0) goto L_0x0093
            r2 = 66
            goto L_0x0095
        L_0x0093:
            r2 = 58
        L_0x0095:
            if (r2 == r0) goto L_0x0097
        L_0x0097:
            return r1
        L_0x0098:
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00a6
        L_0x009d:
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x00a6
        L_0x00a2:
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x00a6:
            int r1 = f639
            r3 = r1 | 35
            int r2 = r3 << 1
            r1 = r1 ^ 35
            int r2 = r2 - r1
            int r1 = r2 % 128
            f640 = r1
            int r2 = r2 % r0
            r0 = 75
            if (r2 != 0) goto L_0x00bb
            r1 = 64
            goto L_0x00bd
        L_0x00bb:
            r1 = 75
        L_0x00bd:
            if (r1 == r0) goto L_0x00bf
        L_0x00bf:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.security.Encrypter.m713():java.security.PublicKey");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private PublicKey m715(String str) {
        int i2 = (f639 + 52) - 1;
        f640 = i2 % 128;
        int i3 = i2 % 2;
        try {
            if (!(this.f641 == null)) {
                int i4 = f639;
                int i5 = ((i4 & 73) - (~(i4 | 73))) - 1;
                f640 = i5 % 128;
                int i6 = i5 % 2;
                PublicKey publicKey = this.f641.getCertificate(str).getPublicKey();
                int i7 = ((f640 + 43) - 1) - 1;
                f639 = i7 % 128;
                int i8 = i7 % 2;
                return publicKey;
            }
            int i9 = f640 + 87;
            f639 = i9 % 128;
            if (i9 % 2 != 0) {
            }
            int i10 = f640;
            int i11 = ((i10 & 97) - (~(-(-(i10 | 97))))) - 1;
            f639 = i11 % 128;
            if (i11 % 2 == 0) {
            }
            return null;
        } catch (Exception unused) {
            String str2 = VisaSCPConstants.LOG_TAG;
            String str3 = VisaSCPConstants.EXCEPTION_MESSAGE;
        }
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [java.security.PrivateKey, java.lang.Object, char[]] */
    /* renamed from: ॱ  reason: contains not printable characters */
    private PrivateKey m717(String str) {
        int i2 = f640;
        int i3 = i2 & 119;
        int i4 = ((i2 ^ 119) | i3) << 1;
        int i5 = -((i2 | 119) & (~i3));
        int i6 = (i4 ^ i5) + ((i5 & i4) << 1);
        f639 = i6 % 128;
        int i7 = i6 % 2;
        ? r0 = 0;
        try {
            boolean z = false;
            if ((this.f641 == null ? 22 : '\\') != '\\') {
                int i8 = f639;
                int i9 = (i8 & -58) | ((~i8) & 57);
                int i10 = (i8 & 57) << 1;
                int i11 = (i9 & i10) + (i10 | i9);
                f640 = i11 % 128;
                if (i11 % 2 == 0) {
                }
                int i12 = f640 + 103;
                f639 = i12 % 128;
                if ((i12 % 2 != 0 ? 'E' : 30) != 30) {
                    return r0;
                }
                super.hashCode();
                return r0;
            }
            int i13 = f640;
            int i14 = i13 & 95;
            int i15 = (i13 | 95) & (~i14);
            int i16 = i14 << 1;
            int i17 = (i15 ^ i16) + ((i15 & i16) << 1);
            f639 = i17 % 128;
            if (i17 % 2 == 0) {
                z = true;
            }
            return !z ? (PrivateKey) this.f641.getKey(str, r0) : (PrivateKey) this.f641.getKey(str, r0);
        } catch (KeyStoreException unused) {
            String str2 = VisaSCPConstants.LOG_TAG;
            String str3 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (NoSuchAlgorithmException unused2) {
            String str4 = VisaSCPConstants.LOG_TAG;
            String str5 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (UnrecoverableEntryException unused3) {
            String str6 = VisaSCPConstants.LOG_TAG;
            String str7 = VisaSCPConstants.EXCEPTION_MESSAGE;
        } catch (Exception unused4) {
            String str8 = VisaSCPConstants.LOG_TAG;
            String str9 = VisaSCPConstants.EXCEPTION_MESSAGE;
        }
    }

    public String getDeviceIdJws(String str, String str2) {
        byte[] bArr;
        int i2 = f640;
        int i3 = i2 ^ 105;
        int i4 = ((i2 & 105) | i3) << 1;
        int i5 = -i3;
        int i6 = (i4 ^ i5) + ((i4 & i5) << 1);
        f639 = i6 % 128;
        if ((i6 % 2 != 0 ? '.' : 'b') == 'b' ? (bArr = signData(str, str2)) != null : (bArr = signData(str, str2)) != null) {
            String str3 = new String(bArr);
            int i7 = f639;
            int i8 = ((((i7 ^ 29) | (i7 & 29)) << 1) - (~(-(((~i7) & 29) | (i7 & -30))))) - 1;
            f640 = i8 % 128;
            if (!(i8 % 2 == 0)) {
            }
            return str3;
        }
        int i9 = ((f639 + 55) - 1) - 1;
        f640 = i9 % 128;
        int i10 = i9 % 2;
        return "";
    }

    public String getAuthCodeJwe(Context context, String str, String str2) {
        String str3;
        AlgorithmParameterSpec algorithmParameterSpec;
        Cipher cipher;
        String str4;
        try {
            byte[] signData = signData(str, str2);
            KeyGenerator instance = KeyGenerator.getInstance(VisaSCPConstants.ALGORITHM_SK_PAYLOAD);
            instance.init(VisaSCPConstants.KEY_SIZE_ENCRYPT);
            SecretKey generateKey = instance.generateKey();
            byte[] bArr = new byte[12];
            new SecureRandom().nextBytes(bArr);
            String encodeToString = Base64.encodeToString(bArr, 2);
            JSONObject jSONObject = new JSONObject();
            boolean z = false;
            if (!(Build.VERSION.SDK_INT < 23)) {
                jSONObject.put(VisaSCPConstants.KEY_ALGO, VisaSCPConstants.ALGORITHM_ENCRYPT_VS_PK);
                int i2 = f639;
                int i3 = (((i2 & -50) | ((~i2) & 49)) - (~(-(-((i2 & 49) << 1))))) - 1;
                f640 = i3 % 128;
                int i4 = i3 % 2;
            } else {
                int i5 = f640;
                int i6 = i5 & 51;
                int i7 = (i5 | 51) & (~i6);
                int i8 = i6 << 1;
                int i9 = (i7 ^ i8) + ((i7 & i8) << 1);
                f639 = i9 % 128;
                if ((i9 % 2 != 0 ? 'X' : '&') != 'X') {
                    str4 = VisaSCPConstants.KEY_ALGO;
                } else {
                    str4 = VisaSCPConstants.KEY_ALGO;
                }
                jSONObject.put(str4, VisaSCPConstants.ALGORITHM_ENCRYPT_RSA_1_5);
                int i10 = f639;
                int i11 = (((i10 | 53) << 1) - (~(-(i10 ^ 53)))) - 1;
                f640 = i11 % 128;
                if (i11 % 2 == 0) {
                }
            }
            jSONObject.put(VisaSCPConstants.KEY_ENCODING, VisaSCPConstants.ALGORITHM_JWE_HEADER);
            String encodeToString2 = Base64.encodeToString(jSONObject.toString().replace("\\", "").getBytes(), 2);
            Cipher instance2 = Cipher.getInstance(VisaSCPConstants.ALGORITHM_PAYLOAD);
            if (Build.VERSION.SDK_INT <= 19) {
                algorithmParameterSpec = new IvParameterSpec(bArr);
                int i12 = f639;
                int i13 = ((i12 & -52) | ((~i12) & 51)) + ((i12 & 51) << 1);
                f640 = i13 % 128;
                int i14 = i13 % 2;
            } else {
                algorithmParameterSpec = new GCMParameterSpec(128, bArr);
                int i15 = f639;
                int i16 = ((i15 & -112) | ((~i15) & 111)) + ((i15 & 111) << 1);
                f640 = i16 % 128;
                if (i16 % 2 == 0) {
                }
            }
            instance2.init(1, generateKey, algorithmParameterSpec);
            if ((TextUtils.isEmpty(encodeToString2) ? '.' : '@') == '@') {
                int i17 = f639;
                int i18 = i17 & 123;
                int i19 = ((i17 ^ 123) | i18) << 1;
                int i20 = -((i17 | 123) & (~i18));
                int i21 = (i19 & i20) + (i20 | i19);
                f640 = i21 % 128;
                if (!(i21 % 2 == 0)) {
                    instance2.updateAAD(encodeToString2.getBytes());
                } else {
                    instance2.updateAAD(encodeToString2.getBytes());
                }
                int i22 = f639;
                int i23 = i22 & 71;
                int i24 = i23 + ((i22 ^ 71) | i23);
                f640 = i24 % 128;
                int i25 = i24 % 2;
            }
            byte[] bArr2 = new byte[instance2.getOutputSize(signData.length)];
            byte[] bArr3 = bArr2;
            int i26 = -(-instance2.update(signData, 0, signData.length, bArr2, 0));
            int i27 = -((i26 | -1) & (~(i26 & -1)));
            int i28 = (i27 ^ 0) + ((i27 & 0) << 1);
            instance2.doFinal(new byte[0], 0, 0, bArr3, (i28 & -1) + (i28 | -1));
            byte[] bArr4 = bArr3;
            int length = bArr4.length;
            int i29 = length & -16;
            int i30 = (((length ^ -16) | i29) << 1) - ((length | -16) & (~i29));
            String encodeToString3 = Base64.encodeToString(Arrays.copyOfRange(bArr4, 0, i30), 2);
            String encodeToString4 = Base64.encodeToString(Arrays.copyOfRange(bArr4, i30, bArr4.length), 2);
            if (Build.VERSION.SDK_INT < 23) {
                int i31 = f640;
                int i32 = (i31 | 99) << 1;
                int i33 = -(((~i31) & 99) | (i31 & -100));
                int i34 = ((i32 | i33) << 1) - (i33 ^ i32);
                f639 = i34 % 128;
                if (i34 % 2 != 0) {
                    z = true;
                }
                if (!z) {
                    cipher = Cipher.getInstance(VisaSCPConstants.ALGORITHM_RSA_ECB_PKCS1);
                } else {
                    cipher = Cipher.getInstance(VisaSCPConstants.ALGORITHM_RSA_ECB_PKCS1);
                }
                cipher.init(1, m716(context, str));
                int i35 = f639;
                int i36 = ((i35 | 101) << 1) - (i35 ^ 101);
                f640 = i36 % 128;
                int i37 = i36 % 2;
            } else {
                cipher = Cipher.getInstance(VisaSCPConstants.ALGORITHM_PARES);
                cipher.init(1, m716(context, str), new OAEPParameterSpec(VisaSCPConstants.ALGORITHM_MD, VisaSCPConstants.ALGORITHM_MGF, VisaSCPConstants.ALGO_PRM_SPEC, PSource.PSpecified.DEFAULT));
                int i38 = f640;
                int i39 = i38 & 115;
                int i40 = (i39 - (~((i38 ^ 115) | i39))) - 1;
                f639 = i40 % 128;
                int i41 = i40 % 2;
            }
            String encodeToString5 = Base64.encodeToString(cipher.doFinal(generateKey.getEncoded()), 2);
            StringBuilder sb = new StringBuilder();
            sb.append(encodeToString2);
            sb.append(AppUtility.CENTER_DOT);
            sb.append(encodeToString5);
            sb.append(AppUtility.CENTER_DOT);
            sb.append(encodeToString);
            sb.append(AppUtility.CENTER_DOT);
            sb.append(encodeToString3);
            sb.append(AppUtility.CENTER_DOT);
            sb.append(encodeToString4);
            str3 = sb.toString();
            int i42 = f639;
            int i43 = i42 & 61;
            int i44 = -(-(i42 | 61));
            int i45 = (i43 & i44) + (i44 | i43);
            f640 = i45 % 128;
            if (i45 % 2 == 0) {
            }
        } catch (NoSuchAlgorithmException unused) {
            String str5 = VisaSCPConstants.LOG_TAG;
            String str6 = VisaSCPConstants.EXCEPTION_MESSAGE;
            str3 = null;
            int i46 = f639;
            int i47 = (i46 & -84) | ((~i46) & 83);
            int i48 = -(-((i46 & 83) << 1));
            int i49 = (i47 & i48) + (i48 | i47);
            f640 = i49 % 128;
            int i50 = i49 % 2;
            return str3;
        } catch (NoSuchPaddingException unused2) {
            String str7 = VisaSCPConstants.LOG_TAG;
            String str8 = VisaSCPConstants.EXCEPTION_MESSAGE;
            str3 = null;
            int i462 = f639;
            int i472 = (i462 & -84) | ((~i462) & 83);
            int i482 = -(-((i462 & 83) << 1));
            int i492 = (i472 & i482) + (i482 | i472);
            f640 = i492 % 128;
            int i502 = i492 % 2;
            return str3;
        } catch (BadPaddingException unused3) {
            String str9 = VisaSCPConstants.LOG_TAG;
            String str10 = VisaSCPConstants.EXCEPTION_MESSAGE;
            str3 = null;
            int i4622 = f639;
            int i4722 = (i4622 & -84) | ((~i4622) & 83);
            int i4822 = -(-((i4622 & 83) << 1));
            int i4922 = (i4722 & i4822) + (i4822 | i4722);
            f640 = i4922 % 128;
            int i5022 = i4922 % 2;
            return str3;
        } catch (IllegalBlockSizeException unused4) {
            String str11 = VisaSCPConstants.LOG_TAG;
            String str12 = VisaSCPConstants.EXCEPTION_MESSAGE;
            str3 = null;
            int i46222 = f639;
            int i47222 = (i46222 & -84) | ((~i46222) & 83);
            int i48222 = -(-((i46222 & 83) << 1));
            int i49222 = (i47222 & i48222) + (i48222 | i47222);
            f640 = i49222 % 128;
            int i50222 = i49222 % 2;
            return str3;
        } catch (InvalidKeyException unused5) {
            String str13 = VisaSCPConstants.LOG_TAG;
            String str14 = VisaSCPConstants.EXCEPTION_MESSAGE;
            str3 = null;
            int i462222 = f639;
            int i472222 = (i462222 & -84) | ((~i462222) & 83);
            int i482222 = -(-((i462222 & 83) << 1));
            int i492222 = (i472222 & i482222) + (i482222 | i472222);
            f640 = i492222 % 128;
            int i502222 = i492222 % 2;
            return str3;
        } catch (InvalidAlgorithmParameterException unused6) {
            String str15 = VisaSCPConstants.LOG_TAG;
            String str16 = VisaSCPConstants.EXCEPTION_MESSAGE;
            str3 = null;
            int i4622222 = f639;
            int i4722222 = (i4622222 & -84) | ((~i4622222) & 83);
            int i4822222 = -(-((i4622222 & 83) << 1));
            int i4922222 = (i4722222 & i4822222) + (i4822222 | i4722222);
            f640 = i4922222 % 128;
            int i5022222 = i4922222 % 2;
            return str3;
        } catch (JSONException unused7) {
            String str17 = VisaSCPConstants.LOG_TAG;
            String str18 = VisaSCPConstants.EXCEPTION_MESSAGE;
            str3 = null;
            int i46222222 = f639;
            int i47222222 = (i46222222 & -84) | ((~i46222222) & 83);
            int i48222222 = -(-((i46222222 & 83) << 1));
            int i49222222 = (i47222222 & i48222222) + (i48222222 | i47222222);
            f640 = i49222222 % 128;
            int i50222222 = i49222222 % 2;
            return str3;
        } catch (ShortBufferException unused8) {
            String str19 = VisaSCPConstants.LOG_TAG;
            String str20 = VisaSCPConstants.EXCEPTION_MESSAGE;
            str3 = null;
            int i462222222 = f639;
            int i472222222 = (i462222222 & -84) | ((~i462222222) & 83);
            int i482222222 = -(-((i462222222 & 83) << 1));
            int i492222222 = (i472222222 & i482222222) + (i482222222 | i472222222);
            f640 = i492222222 % 128;
            int i502222222 = i492222222 % 2;
            return str3;
        } catch (Exception unused9) {
            String str21 = VisaSCPConstants.LOG_TAG;
            String str22 = VisaSCPConstants.EXCEPTION_MESSAGE;
            str3 = null;
            int i4622222222 = f639;
            int i4722222222 = (i4622222222 & -84) | ((~i4622222222) & 83);
            int i4822222222 = -(-((i4622222222 & 83) << 1));
            int i4922222222 = (i4722222222 & i4822222222) + (i4822222222 | i4722222222);
            f640 = i4922222222 % 128;
            int i5022222222 = i4922222222 % 2;
            return str3;
        }
        int i46222222222 = f639;
        int i47222222222 = (i46222222222 & -84) | ((~i46222222222) & 83);
        int i48222222222 = -(-((i46222222222 & 83) << 1));
        int i49222222222 = (i47222222222 & i48222222222) + (i48222222222 | i47222222222);
        f640 = i49222222222 % 128;
        int i50222222222 = i49222222222 % 2;
        return str3;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static PublicKey m716(Context context, String str) {
        SecureSharedPref instance = SecureSharedPref.getInstance(context);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(VisaSCPConstants.VPUB);
        try {
            PublicKey generatePublic = KeyFactory.getInstance(VisaSCPConstants.RSA_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(instance.getData(context, sb.toString()).getBytes(), 2)));
            int i2 = (f639 + 78) - 1;
            f640 = i2 % 128;
            int i3 = i2 % 2;
            return generatePublic;
        } catch (Exception unused) {
            String str2 = VisaSCPConstants.LOG_TAG;
            String str3 = VisaSCPConstants.EXCEPTION_MESSAGE;
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        if ((r1.length > 0) != true) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String encryptWithVisaPublicKey(android.content.Context r22, java.lang.String r23, byte[] r24) {
        /*
            r21 = this;
            r1 = r24
            java.lang.String r6 = "."
            int r0 = f640
            r2 = r0 | 96
            r7 = 1
            int r2 = r2 << r7
            r0 = r0 ^ 96
            int r2 = r2 - r0
            int r2 = r2 - r7
            int r0 = r2 % 128
            f639 = r0
            r8 = 2
            int r2 = r2 % r8
            r9 = 0
            if (r1 != 0) goto L_0x0019
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            r2 = 95
            r10 = 0
            if (r0 == r7) goto L_0x0020
            goto L_0x0047
        L_0x0020:
            int r0 = f640
            int r0 = r0 + 51
            int r0 = r0 - r7
            r3 = r0 & -1
            r0 = r0 | -1
            int r3 = r3 + r0
            int r0 = r3 % 128
            f639 = r0
            int r3 = r3 % r8
            if (r3 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            if (r0 == r7) goto L_0x003f
            int r0 = r1.length     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            if (r0 <= 0) goto L_0x003b
            r0 = 1
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            if (r0 == r7) goto L_0x0054
            goto L_0x0047
        L_0x003f:
            int r0 = r1.length     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            if (r0 <= 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            if (r0 == r7) goto L_0x0054
        L_0x0047:
            int r0 = f639
            r1 = r0 | 95
            int r1 = r1 << r7
            r0 = r0 ^ r2
            int r1 = r1 - r0
            int r0 = r1 % 128
            f640 = r0
            int r1 = r1 % r8
            return r10
        L_0x0054:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_SK_PAYLOAD     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            javax.crypto.KeyGenerator r0 = javax.crypto.KeyGenerator.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r3 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_SIZE_ENCRYPT     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r0.init(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            javax.crypto.SecretKey r11 = r0.generateKey()     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r0 = 12
            byte[] r0 = new byte[r0]     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.nextBytes(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r12 = android.util.Base64.encodeToString(r0, r8)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r13 = 23
            if (r4 < r13) goto L_0x0080
            r4 = 0
            goto L_0x0081
        L_0x0080:
            r4 = 1
        L_0x0081:
            if (r4 == r7) goto L_0x009a
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_ALGO     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_ENCRYPT_VS_PK     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.put(r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r4 = f639
            r5 = r4 & 105(0x69, float:1.47E-43)
            r4 = r4 ^ 105(0x69, float:1.47E-43)
            r4 = r4 | r5
            int r4 = ~r4
            int r5 = r5 - r4
            int r5 = r5 - r7
            int r4 = r5 % 128
            f640 = r4
            int r5 = r5 % r8
            goto L_0x00ba
        L_0x009a:
            int r4 = f640
            int r4 = r4 + 30
            int r4 = r4 - r7
            int r5 = r4 % 128
            f639 = r5
            int r4 = r4 % r8
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_ALGO     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_ENCRYPT_RSA_1_5     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.put(r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r4 = f640
            int r4 = r4 + 94
            int r4 = r4 - r7
            int r5 = r4 % 128
            f639 = r5
            int r4 = r4 % r8
            if (r4 == 0) goto L_0x00b9
            r4 = 0
            goto L_0x00ba
        L_0x00b9:
            r4 = 1
        L_0x00ba:
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_ENCODING     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_JWE_HEADER     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.put(r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r3 = r3.toString()     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r4 = "\\"
            java.lang.String r5 = ""
            java.lang.String r3 = r3.replace(r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            byte[] r3 = r3.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r14 = android.util.Base64.encodeToString(r3, r8)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r3 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_PAYLOAD     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            javax.crypto.Cipher r15 = javax.crypto.Cipher.getInstance(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r4 = 19
            if (r3 > r4) goto L_0x00f4
            javax.crypto.spec.IvParameterSpec r3 = new javax.crypto.spec.IvParameterSpec     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.<init>(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r0 = f639
            r4 = r0 ^ 39
            r0 = r0 & 39
            int r0 = r0 << r7
            int r4 = r4 + r0
            int r0 = r4 % 128
            f640 = r0
            int r4 = r4 % r8
            goto L_0x0110
        L_0x00f4:
            javax.crypto.spec.GCMParameterSpec r3 = new javax.crypto.spec.GCMParameterSpec     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r4 = 128(0x80, float:1.794E-43)
            r3.<init>(r4, r0)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r0 = f639
            r4 = r0 & 91
            r0 = r0 | 91
            int r4 = r4 + r0
            int r0 = r4 % 128
            f640 = r0
            int r4 = r4 % r8
            r0 = 42
            if (r4 != 0) goto L_0x010e
            r4 = 42
            goto L_0x0110
        L_0x010e:
            r4 = 82
        L_0x0110:
            r15.init(r7, r11, r3)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3 = 21
            if (r0 == 0) goto L_0x011d
            r2 = 21
        L_0x011d:
            if (r2 == r3) goto L_0x015b
            int r0 = f639
            int r0 = r0 + 9
            int r0 = r0 - r7
            r2 = r0 & -1
            r0 = r0 | -1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f640 = r0
            int r2 = r2 % r8
            if (r2 != 0) goto L_0x0133
            r0 = 57
            goto L_0x0135
        L_0x0133:
            r0 = 46
        L_0x0135:
            r2 = 57
            if (r0 == r2) goto L_0x0141
            byte[] r0 = r14.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r15.updateAAD(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            goto L_0x0148
        L_0x0141:
            byte[] r0 = r14.getBytes()     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r15.updateAAD(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
        L_0x0148:
            int r0 = f640
            int r0 = r0 + 56
            int r0 = r0 - r7
            int r2 = r0 % 128
            f639 = r2
            int r0 = r0 % r8
            if (r0 == 0) goto L_0x0157
            r0 = 32
            goto L_0x0159
        L_0x0157:
            r0 = 80
        L_0x0159:
            r2 = 80
        L_0x015b:
            int r0 = r1.length     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r0 = r15.getOutputSize(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            byte[] r5 = new byte[r0]     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r2 = 0
            int r3 = r1.length     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r16 = 0
            r0 = r15
            r1 = r24
            r4 = r5
            r24 = r5
            r5 = r16
            int r0 = r0.update(r1, r2, r3, r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r0 = -r0
            int r0 = -r0
            int r1 = ~r0     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r1 = r1 & r9
            r2 = r0 & -1
            r1 = r1 | r2
            r0 = r0 & r9
            int r0 = r0 << r7
            int r0 = -r0
            int r0 = -r0
            r2 = r1 | r0
            int r2 = r2 << r7
            r0 = r0 ^ r1
            int r20 = r2 - r0
            byte[] r0 = new byte[r9]     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r17 = 0
            r18 = 0
            r16 = r0
            r19 = r24
            r15.doFinal(r16, r17, r18, r19, r20)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r0 = r24
            int r1 = r0.length     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r2 = r1 ^ -15
            r1 = r1 & -15
            int r1 = r1 << r7
            int r2 = r2 + r1
            int r2 = r2 - r9
            int r2 = r2 - r7
            byte[] r1 = java.util.Arrays.copyOfRange(r0, r9, r2)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r8)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r3 = r0.length     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            byte[] r0 = java.util.Arrays.copyOfRange(r0, r2, r3)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r8)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            if (r2 < r13) goto L_0x01b2
            r2 = 0
            goto L_0x01b3
        L_0x01b2:
            r2 = 1
        L_0x01b3:
            if (r2 == r7) goto L_0x01e7
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_PARES     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            javax.crypto.spec.OAEPParameterSpec r3 = new javax.crypto.spec.OAEPParameterSpec     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_MD     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_MGF     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.security.spec.AlgorithmParameterSpec r13 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGO_PRM_SPEC     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            javax.crypto.spec.PSource$PSpecified r15 = javax.crypto.spec.PSource.PSpecified.DEFAULT     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.<init>(r4, r5, r13, r15)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.security.PublicKey r4 = m716(r22, r23)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r2.init(r7, r4, r3)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r3 = f640
            r4 = r3 ^ 125(0x7d, float:1.75E-43)
            r5 = r3 & 125(0x7d, float:1.75E-43)
            r4 = r4 | r5
            int r4 = r4 << r7
            int r5 = ~r5
            r3 = r3 | 125(0x7d, float:1.75E-43)
            r3 = r3 & r5
            int r3 = -r3
            r5 = r4 | r3
            int r5 = r5 << r7
            r3 = r3 ^ r4
            int r5 = r5 - r3
            int r3 = r5 % 128
            f639 = r3
            int r5 = r5 % r8
            goto L_0x0211
        L_0x01e7:
            int r2 = f640
            r3 = r2 & 39
            int r4 = ~r3
            r2 = r2 | 39
            r2 = r2 & r4
            int r3 = r3 << r7
            int r2 = r2 + r3
            int r3 = r2 % 128
            f639 = r3
            int r2 = r2 % r8
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ALGORITHM_RSA_ECB_PKCS1     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.security.PublicKey r3 = m716(r22, r23)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r2.init(r7, r3)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r3 = f639
            r4 = r3 ^ 100
            r3 = r3 & 100
            int r3 = r3 << r7
            int r4 = r4 + r3
            int r4 = r4 - r7
            int r3 = r4 % 128
            f640 = r3
            int r4 = r4 % r8
        L_0x0211:
            byte[] r3 = r11.getEncoded()     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            byte[] r2 = r2.doFinal(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r8)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.append(r14)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.append(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.append(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.append(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.append(r12)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.append(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.append(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.append(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            r3.append(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            java.lang.String r10 = r3.toString()     // Catch:{ NoSuchAlgorithmException -> 0x0277, NoSuchPaddingException -> 0x0272, BadPaddingException -> 0x026d, IllegalBlockSizeException -> 0x0268, InvalidKeyException -> 0x0263, InvalidAlgorithmParameterException -> 0x025e, JSONException -> 0x0259, ShortBufferException -> 0x0254, Exception -> 0x024f }
            int r0 = f640
            r1 = r0 | 55
            int r1 = r1 << r7
            r0 = r0 ^ 55
            int r1 = r1 - r0
            int r0 = r1 % 128
            f639 = r0
            int r1 = r1 % r8
            goto L_0x027b
        L_0x024f:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x027b
        L_0x0254:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x027b
        L_0x0259:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x027b
        L_0x025e:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x027b
        L_0x0263:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x027b
        L_0x0268:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x027b
        L_0x026d:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x027b
        L_0x0272:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            goto L_0x027b
        L_0x0277:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x027b:
            int r0 = f639
            r1 = r0 & 31
            r0 = r0 | 31
            int r1 = r1 + r0
            int r0 = r1 % 128
            f640 = r0
            int r1 = r1 % r8
            if (r1 != 0) goto L_0x028a
            goto L_0x028b
        L_0x028a:
            r7 = 0
        L_0x028b:
            if (r7 == 0) goto L_0x028d
        L_0x028d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.security.Encrypter.encryptWithVisaPublicKey(android.content.Context, java.lang.String, byte[]):java.lang.String");
    }

    public String getDevicePublicKeyString(String str) {
        String str2;
        int i2 = f639;
        int i3 = i2 & 11;
        int i4 = (i2 ^ 11) | i3;
        int i5 = (i3 & i4) + (i4 | i3);
        f640 = i5 % 128;
        if ((i5 % 2 == 0 ? 'a' : 'S') != 'a') {
            try {
                str2 = Base64.encodeToString(m715(str).getEncoded(), 3);
            } catch (Exception unused) {
                String str3 = VisaSCPConstants.LOG_TAG;
                String str4 = VisaSCPConstants.EXCEPTION_MESSAGE;
                return null;
            }
        } else {
            str2 = Base64.encodeToString(m715(str).getEncoded(), 2);
        }
        int i6 = f639;
        int i7 = (i6 & -86) | ((~i6) & 85);
        int i8 = -(-((i6 & 85) << 1));
        int i9 = (i7 & i8) + (i8 | i7);
        f640 = i9 % 128;
        int i10 = i9 % 2;
        return str2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static PrivateKey m714() {
        try {
            PrivateKey generatePrivate = KeyFactory.getInstance(VisaSCPConstants.RSA_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(VisaSCPConstants.PRIVATE_KEY_GET_VISA_CERTIFICATE, 0)));
            int i2 = f640;
            int i3 = ((i2 | 26) << 1) - (i2 ^ 26);
            int i4 = (i3 & -1) + (i3 | -1);
            f639 = i4 % 128;
            if (i4 % 2 != 0) {
            }
            return generatePrivate;
        } catch (Exception unused) {
            String str = VisaSCPConstants.LOG_TAG;
            String str2 = VisaSCPConstants.EXCEPTION_MESSAGE;
            return null;
        }
    }
}
