package com.appsflyer;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

class AFKeystoreWrapper {

    /* renamed from: ı  reason: contains not printable characters */
    final Object f31 = new Object();

    /* renamed from: ǃ  reason: contains not printable characters */
    private Context f32;

    /* renamed from: ɩ  reason: contains not printable characters */
    int f33;

    /* renamed from: Ι  reason: contains not printable characters */
    KeyStore f34;

    /* renamed from: ι  reason: contains not printable characters */
    String f35;

    public AFKeystoreWrapper(Context context) {
        this.f32 = context;
        this.f35 = "";
        this.f33 = 0;
        AFLogger.afInfoLog("Initialising KeyStore..");
        try {
            this.f34 = KeyStore.getInstance("AndroidKeyStore");
            this.f34.load((KeyStore.LoadStoreParameter) null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            AFLogger.afErrorLog("Couldn't load keystore instance of type: AndroidKeyStore", e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        r1 = r4.split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r1.length != 3) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        com.appsflyer.AFLogger.afInfoLog("Found a matching AF key with alias:\n".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = r1[1].trim().split("=");
        r1 = r1[2].trim().split("=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (r3.length != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r1.length != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        r7.f35 = r3[1].trim();
        r7.f33 = java.lang.Integer.parseInt(r1[1].trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006e, code lost:
        r1 = th;
     */
    /* renamed from: ǃ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m13() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f31
            monitor-enter(r0)
            java.security.KeyStore r1 = r7.f34     // Catch:{ all -> 0x008f }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x008c
            java.security.KeyStore r1 = r7.f34     // Catch:{ all -> 0x0070 }
            java.util.Enumeration r1 = r1.aliases()     // Catch:{ all -> 0x0070 }
        L_0x000f:
            boolean r4 = r1.hasMoreElements()     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r1.nextElement()     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x000f
            boolean r5 = m11(r4)     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x000f
            java.lang.String r1 = ","
            java.lang.String[] r1 = r4.split(r1)     // Catch:{ all -> 0x0070 }
            int r5 = r1.length     // Catch:{ all -> 0x0070 }
            r6 = 3
            if (r5 != r6) goto L_0x008c
            java.lang.String r5 = "Found a matching AF key with alias:\n"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = r5.concat(r4)     // Catch:{ all -> 0x0070 }
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ all -> 0x0070 }
            r3 = r1[r2]     // Catch:{ all -> 0x006e }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x006e }
            java.lang.String r4 = "="
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x006e }
            r4 = 2
            r1 = r1[r4]     // Catch:{ all -> 0x006e }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x006e }
            java.lang.String r5 = "="
            java.lang.String[] r1 = r1.split(r5)     // Catch:{ all -> 0x006e }
            int r5 = r3.length     // Catch:{ all -> 0x006e }
            if (r5 != r4) goto L_0x008d
            int r5 = r1.length     // Catch:{ all -> 0x006e }
            if (r5 != r4) goto L_0x008d
            r3 = r3[r2]     // Catch:{ all -> 0x006e }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x006e }
            r7.f35 = r3     // Catch:{ all -> 0x006e }
            r1 = r1[r2]     // Catch:{ all -> 0x006e }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x006e }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x006e }
            r7.f33 = r1     // Catch:{ all -> 0x006e }
            goto L_0x008d
        L_0x006e:
            r1 = move-exception
            goto L_0x0072
        L_0x0070:
            r1 = move-exception
            r2 = 0
        L_0x0072:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r4 = "Couldn't list KeyStore Aliases: "
            r3.<init>(r4)     // Catch:{ all -> 0x008f }
            java.lang.Class r4 = r1.getClass()     // Catch:{ all -> 0x008f }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x008f }
            r3.append(r4)     // Catch:{ all -> 0x008f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008f }
            com.appsflyer.AFLogger.afErrorLog(r3, r1)     // Catch:{ all -> 0x008f }
            goto L_0x008d
        L_0x008c:
            r2 = 0
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            return r2
        L_0x008f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AFKeystoreWrapper.m13():boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public final void m15(String str) {
        AFLogger.afInfoLog("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 5);
            AlgorithmParameterSpec algorithmParameterSpec = null;
            synchronized (this.f31) {
                if (!this.f34.containsAlias(str)) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        algorithmParameterSpec = new KeyGenParameterSpec.Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
                    } else if (Build.VERSION.SDK_INT >= 18 && !AndroidUtils.m33()) {
                        algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(this.f32).setAlias(str).setSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                    }
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance3.initialize(algorithmParameterSpec);
                    instance3.generateKeyPair();
                } else {
                    AFLogger.afInfoLog("Alias already exists: ".concat(String.valueOf(str)));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Exception ");
            sb.append(th.getMessage());
            sb.append(" occurred");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static boolean m11(String str) {
        return str.startsWith("com.appsflyer");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public final String m14() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.appsflyer,");
        synchronized (this.f31) {
            sb.append("KSAppsFlyerId=");
            sb.append(this.f35);
            sb.append(AppConstants.COMMA);
            sb.append("KSAppsFlyerRICounter=");
            sb.append(this.f33);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ı  reason: contains not printable characters */
    public final String m12() {
        String str;
        synchronized (this.f31) {
            str = this.f35;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Ι  reason: contains not printable characters */
    public final int m16() {
        int i2;
        synchronized (this.f31) {
            i2 = this.f33;
        }
        return i2;
    }
}
