package net.one97.paytm.payments.visascp.keygen;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;

public class KeyGenerator {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f569 = 1;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f570;

    /* JADX WARNING: type inference failed for: r3v0, types: [java.security.KeyStore$LoadStoreParameter, java.lang.Object, char[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if ((r4 == null) != false) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isKeyPairAlreadyGenerated(java.lang.String r5) {
        /*
            int r0 = f569
            int r0 = r0 + 61
            int r1 = r0 % 128
            f570 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            r3 = 0
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ANDROID_KEY_STORE     // Catch:{ Exception -> 0x00a8 }
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch:{ Exception -> 0x00a8 }
            r0.load(r3)     // Catch:{ Exception -> 0x00a8 }
            java.security.Key r3 = r0.getKey(r5, r3)     // Catch:{ Exception -> 0x00a8 }
            r4 = 90
            if (r3 != 0) goto L_0x0028
            r3 = 22
            goto L_0x002a
        L_0x0028:
            r3 = 90
        L_0x002a:
            if (r3 == r4) goto L_0x0045
            goto L_0x0092
        L_0x002d:
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ANDROID_KEY_STORE     // Catch:{ Exception -> 0x00a8 }
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch:{ Exception -> 0x00a8 }
            r0.load(r3)     // Catch:{ Exception -> 0x00a8 }
            java.security.Key r4 = r0.getKey(r5, r3)     // Catch:{ Exception -> 0x00a8 }
            super.hashCode()     // Catch:{ all -> 0x00a6 }
            if (r4 != 0) goto L_0x0041
            r3 = 1
            goto L_0x0042
        L_0x0041:
            r3 = 0
        L_0x0042:
            if (r3 == 0) goto L_0x0045
            goto L_0x0092
        L_0x0045:
            java.security.cert.Certificate r5 = r0.getCertificate(r5)     // Catch:{ Exception -> 0x00a8 }
            java.security.PublicKey r5 = r5.getPublicKey()     // Catch:{ Exception -> 0x00a8 }
            r0 = 27
            if (r5 != 0) goto L_0x0054
            r5 = 27
            goto L_0x0056
        L_0x0054:
            r5 = 44
        L_0x0056:
            if (r5 == r0) goto L_0x0092
            int r5 = f570
            r0 = r5 & -100
            int r1 = ~r5
            r1 = r1 & 99
            r0 = r0 | r1
            r5 = r5 & 99
            int r5 = r5 << r2
            int r5 = ~r5
            int r0 = r0 - r5
            int r0 = r0 - r2
            int r5 = r0 % 128
            f569 = r5
            int r0 = r0 % 2
            int r5 = f569
            r0 = r5 ^ 121(0x79, float:1.7E-43)
            r1 = r5 & 121(0x79, float:1.7E-43)
            r0 = r0 | r1
            int r0 = r0 << r2
            r1 = r5 & -122(0xffffffffffffff86, float:NaN)
            int r5 = ~r5
            r5 = r5 & 121(0x79, float:1.7E-43)
            r5 = r5 | r1
            int r5 = -r5
            r1 = r0 | r5
            int r1 = r1 << r2
            r5 = r5 ^ r0
            int r1 = r1 - r5
            int r5 = r1 % 128
            f570 = r5
            int r1 = r1 % 2
            r5 = 51
            if (r1 != 0) goto L_0x008d
            r0 = 51
            goto L_0x008f
        L_0x008d:
            r0 = 34
        L_0x008f:
            if (r0 == r5) goto L_0x0091
        L_0x0091:
            return r2
        L_0x0092:
            int r5 = f570
            r0 = r5 ^ 89
            r5 = r5 & 89
            int r5 = r5 << r2
            int r0 = r0 + r5
            int r5 = r0 % 128
            f569 = r5
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x00a4
            r5 = 1
            goto L_0x00ac
        L_0x00a4:
            r5 = 0
            goto L_0x00ac
        L_0x00a6:
            r5 = move-exception
            throw r5
        L_0x00a8:
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
        L_0x00ac:
            int r5 = f569
            r0 = r5 & 31
            r5 = r5 ^ 31
            r5 = r5 | r0
            int r5 = -r5
            int r5 = -r5
            r3 = r0 | r5
            int r3 = r3 << r2
            r5 = r5 ^ r0
            int r3 = r3 - r5
            int r5 = r3 % 128
            f570 = r5
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x00c4
            r5 = 0
            goto L_0x00c5
        L_0x00c4:
            r5 = 1
        L_0x00c5:
            if (r5 == r2) goto L_0x00c7
        L_0x00c7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.keygen.KeyGenerator.isKeyPairAlreadyGenerated(java.lang.String):boolean");
    }

    public boolean generateKeyPair(Context context, String str) {
        AlgorithmParameterSpec algorithmParameterSpec;
        int i2 = f570;
        int i3 = i2 & 105;
        int i4 = i3 + ((i2 ^ 105) | i3);
        f569 = i4 % 128;
        int i5 = i4 % 2;
        boolean z = false;
        if (isKeyPairAlreadyGenerated(str)) {
            int i6 = ((f569 + 83) - 1) - 1;
            f570 = i6 % 128;
            if (i6 % 2 != 0) {
            }
            int i7 = f569;
            int i8 = (i7 ^ 87) + ((i7 & 87) << 1);
            f570 = i8 % 128;
            if ((i8 % 2 == 0 ? (char) 13 : 1) != 13) {
            }
            return true;
        }
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(VisaSCPConstants.RSA_ALGORITHM, VisaSCPConstants.ANDROID_KEY_STORE);
            if (Build.VERSION.SDK_INT < 23) {
                Calendar instance2 = Calendar.getInstance();
                Calendar.getInstance().add(1, 30);
                algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new X500Principal(VisaSCPConstants.PR_NAME)).setSerialNumber(BigInteger.TEN).setStartDate(instance2.getTime()).setEndDate(instance2.getTime()).setAlgorithmParameterSpec(new RSAKeyGenParameterSpec(VisaSCPConstants.ALGORITHM_KEY_SIZE, VisaSCPConstants.F4)).build();
                int i9 = f570;
                int i10 = (i9 & 42) + (i9 | 42);
                int i11 = (i10 & -1) + (i10 | -1);
                f569 = i11 % 128;
                if (i11 % 2 != 0) {
                }
            } else {
                int i12 = VisaSCPConstants.PURPOSE1;
                int i13 = VisaSCPConstants.PURPOSE2;
                int i14 = ((~i13) & i12) | ((~i12) & i13);
                int i15 = i12 & i13;
                int i16 = (i15 & i14) | (i14 ^ i15);
                int i17 = VisaSCPConstants.PURPOSE3;
                algorithmParameterSpec = new KeyGenParameterSpec.Builder(str, (i16 & i17) | ((~i17) & i16) | ((~i16) & i17) | VisaSCPConstants.PURPOSE4).setAlgorithmParameterSpec(new RSAKeyGenParameterSpec(VisaSCPConstants.ALGORITHM_KEY_SIZE, VisaSCPConstants.F4)).setBlockModes(new String[]{VisaSCPConstants.MODE_G, VisaSCPConstants.MODE_E}).setEncryptionPaddings(new String[]{VisaSCPConstants.PADDING1, VisaSCPConstants.PADDING2}).setSignaturePaddings(new String[]{VisaSCPConstants.SIGN_PADDING}).setDigests(new String[]{VisaSCPConstants.DIGEST1, VisaSCPConstants.DIGEST2, VisaSCPConstants.DIGEST3}).setUserAuthenticationRequired(false).build();
                int i18 = f570;
                int i19 = ((i18 | 101) << 1) - (((~i18) & 101) | (i18 & -102));
                f569 = i19 % 128;
                if (i19 % 2 != 0) {
                }
            }
            instance.initialize(algorithmParameterSpec);
            instance.generateKeyPair();
            int i20 = f569;
            int i21 = (i20 & -38) | ((~i20) & 37);
            int i22 = -(-((i20 & 37) << 1));
            int i23 = (i21 ^ i22) + ((i22 & i21) << 1);
            f570 = i23 % 128;
            if (i23 % 2 == 0) {
                z = true;
            }
            if (z) {
            }
            return true;
        } catch (Exception unused) {
            String str2 = VisaSCPConstants.LOG_TAG;
            String str3 = VisaSCPConstants.EXCEPTION_MESSAGE;
            return false;
        }
    }
}
