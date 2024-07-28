package com.google.android.play.core.b;

import android.content.Context;
import android.content.pm.Signature;
import com.google.android.play.core.splitcompat.e;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    final e f37327a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f37328b;

    /* renamed from: c  reason: collision with root package name */
    private final r f37329c;

    public p(Context context, e eVar, r rVar) {
        this.f37327a = eVar;
        this.f37329c = rVar;
        this.f37328b = context;
    }

    private static X509Certificate a(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r7).length() + 32);
        r4.append("Downloaded split ");
        r4.append(r7);
        r4.append(" is not signed.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r13 = this;
            java.lang.String r0 = " is not signed."
            java.lang.String r1 = "Downloaded split "
            r2 = 0
            com.google.android.play.core.splitcompat.e r3 = r13.f37327a     // Catch:{ IOException -> 0x00d7 }
            java.io.File r3 = r3.b()     // Catch:{ IOException -> 0x00d7 }
            r4 = 0
            android.content.Context r5 = r13.f37328b     // Catch:{ NameNotFoundException -> 0x0021 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0021 }
            android.content.Context r6 = r13.f37328b     // Catch:{ NameNotFoundException -> 0x0021 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x0021 }
            r7 = 64
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r7)     // Catch:{ NameNotFoundException -> 0x0021 }
            android.content.pm.Signature[] r5 = r5.signatures     // Catch:{ NameNotFoundException -> 0x0021 }
            goto L_0x0022
        L_0x0021:
            r5 = r4
        L_0x0022:
            if (r5 == 0) goto L_0x003c
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r6 = r5.length
            r7 = 0
        L_0x002b:
            if (r7 >= r6) goto L_0x003c
            r8 = r5[r7]
            java.security.cert.X509Certificate r8 = a(r8)
            if (r8 != 0) goto L_0x0036
            goto L_0x0039
        L_0x0036:
            r4.add(r8)
        L_0x0039:
            int r7 = r7 + 1
            goto L_0x002b
        L_0x003c:
            if (r4 != 0) goto L_0x0040
            goto L_0x00d7
        L_0x0040:
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x00d7
            java.io.File[] r3 = r3.listFiles()
            java.util.Arrays.sort(r3)
            int r5 = r3.length
        L_0x004e:
            int r5 = r5 + -1
            if (r5 < 0) goto L_0x00d5
            r6 = r3[r5]
            java.lang.String r7 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00d4 }
            java.security.cert.X509Certificate[][] r8 = com.google.android.play.core.b.bq.a((java.lang.String) r7)     // Catch:{ Exception -> 0x00bc }
            if (r8 != 0) goto L_0x005f
            goto L_0x00a3
        L_0x005f:
            int r9 = r8.length     // Catch:{ Exception -> 0x00d4 }
            if (r9 == 0) goto L_0x00a3
            r9 = r8[r2]     // Catch:{ Exception -> 0x00d4 }
            int r9 = r9.length     // Catch:{ Exception -> 0x00d4 }
            if (r9 == 0) goto L_0x00a3
            boolean r7 = r4.isEmpty()     // Catch:{ Exception -> 0x00d4 }
            if (r7 == 0) goto L_0x006e
            goto L_0x00d4
        L_0x006e:
            java.util.Iterator r7 = r4.iterator()     // Catch:{ Exception -> 0x00d4 }
        L_0x0072:
            boolean r9 = r7.hasNext()     // Catch:{ Exception -> 0x00d4 }
            if (r9 == 0) goto L_0x0090
            java.lang.Object r9 = r7.next()     // Catch:{ Exception -> 0x00d4 }
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9     // Catch:{ Exception -> 0x00d4 }
            int r10 = r8.length     // Catch:{ Exception -> 0x00d4 }
            r11 = 0
        L_0x0080:
            if (r11 < r10) goto L_0x0083
            goto L_0x00d4
        L_0x0083:
            r12 = r8[r11]     // Catch:{ Exception -> 0x00d4 }
            r12 = r12[r2]     // Catch:{ Exception -> 0x00d4 }
            boolean r12 = r12.equals(r9)     // Catch:{ Exception -> 0x00d4 }
            if (r12 != 0) goto L_0x0072
            int r11 = r11 + 1
            goto L_0x0080
        L_0x0090:
            com.google.android.play.core.splitcompat.e r7 = r13.f37327a     // Catch:{ IOException -> 0x00a2 }
            java.io.File r7 = r7.c()     // Catch:{ IOException -> 0x00a2 }
            java.lang.String r8 = r6.getName()     // Catch:{ IOException -> 0x00a2 }
            java.io.File r7 = com.google.android.play.core.splitcompat.e.a(r7, r8)     // Catch:{ IOException -> 0x00a2 }
            r6.renameTo(r7)     // Catch:{ IOException -> 0x00a2 }
            goto L_0x004e
        L_0x00a2:
            return r2
        L_0x00a3:
            java.lang.String r3 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00d4 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x00d4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
            int r3 = r3 + 32
            r4.<init>(r3)     // Catch:{ Exception -> 0x00d4 }
            r4.append(r1)     // Catch:{ Exception -> 0x00d4 }
            r4.append(r7)     // Catch:{ Exception -> 0x00d4 }
            r4.append(r0)     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00d4
        L_0x00bc:
            java.lang.String r3 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x00d4 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x00d4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
            int r3 = r3 + 32
            r4.<init>(r3)     // Catch:{ Exception -> 0x00d4 }
            r4.append(r1)     // Catch:{ Exception -> 0x00d4 }
            r4.append(r7)     // Catch:{ Exception -> 0x00d4 }
            r4.append(r0)     // Catch:{ Exception -> 0x00d4 }
        L_0x00d4:
            return r2
        L_0x00d5:
            r0 = 1
            return r0
        L_0x00d7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.b.p.a():boolean");
    }
}
