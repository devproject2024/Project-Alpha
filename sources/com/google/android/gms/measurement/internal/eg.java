package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;
import java.net.URL;
import java.util.Map;

final class eg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final URL f11852a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f11853b;

    /* renamed from: c  reason: collision with root package name */
    private final ee f11854c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11855d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f11856e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ ec f11857f;

    public eg(ec ecVar, String str, URL url, byte[] bArr, Map<String, String> map, ee eeVar) {
        this.f11857f = ecVar;
        s.a(str);
        s.a(url);
        s.a(eeVar);
        this.f11852a = url;
        this.f11853b = bArr;
        this.f11854c = eeVar;
        this.f11855d = str;
        this.f11856e = map;
    }

    /* JADX WARNING: type inference failed for: r4v6, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ff A[SYNTHETIC, Splitter:B:57:0x00ff] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0138 A[SYNTHETIC, Splitter:B:68:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0150  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.ec r1 = r13.f11857f
            r1.g()
            r1 = 0
            r2 = 0
            com.google.android.gms.measurement.internal.ec r3 = r13.f11857f     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            java.net.URL r4 = r13.f11852a     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            boolean r5 = r4 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            if (r5 == 0) goto L_0x00f0
            javax.net.ssl.SSLSocketFactory r5 = r3.f11841a     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            if (r5 == 0) goto L_0x0025
            boolean r5 = r4 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            if (r5 == 0) goto L_0x0025
            r5 = r4
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            javax.net.ssl.SSLSocketFactory r3 = r3.f11841a     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            r5.setSSLSocketFactory(r3)     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
        L_0x0025:
            r3 = r4
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            r3.setDefaultUseCaches(r1)     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            r4 = 60000(0xea60, float:8.4078E-41)
            r3.setConnectTimeout(r4)     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            r4 = 61000(0xee48, float:8.5479E-41)
            r3.setReadTimeout(r4)     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            r3.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            r4 = 1
            r3.setDoInput(r4)     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            java.util.Map<java.lang.String, java.lang.String> r5 = r13.f11856e     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            if (r5 == 0) goto L_0x0068
            java.util.Map<java.lang.String, java.lang.String> r5 = r13.f11856e     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
        L_0x004c:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            if (r6 == 0) goto L_0x0068
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            r3.addRequestProperty(r7, r6)     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            goto L_0x004c
        L_0x0068:
            byte[] r5 = r13.f11853b     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            if (r5 == 0) goto L_0x00b0
            com.google.android.gms.measurement.internal.ec r5 = r13.f11857f     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            com.google.android.gms.measurement.internal.jn r5 = r5.G_()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            byte[] r6 = r13.f11853b     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            byte[] r5 = r5.c(r6)     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            com.google.android.gms.measurement.internal.ec r6 = r13.f11857f     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            com.google.android.gms.measurement.internal.dy r6 = r6.J_()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            com.google.android.gms.measurement.internal.ea r6 = r6.k     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.lang.String r7 = "Uploading data. size"
            int r8 = r5.length     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            r6.a(r7, r8)     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            r3.setDoOutput(r4)     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.lang.String r4 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r3.addRequestProperty(r4, r6)     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            int r4 = r5.length     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            r3.setFixedLengthStreamingMode(r4)     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            r3.connect()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            r4.write(r5)     // Catch:{ IOException -> 0x00ab, all -> 0x00a6 }
            r4.close()     // Catch:{ IOException -> 0x00ab, all -> 0x00a6 }
            goto L_0x00b0
        L_0x00a6:
            r5 = move-exception
            r11 = r2
            r2 = r4
            r4 = r5
            goto L_0x00e9
        L_0x00ab:
            r5 = move-exception
            r10 = r2
            r2 = r4
            r8 = r5
            goto L_0x00ee
        L_0x00b0:
            int r8 = r3.getResponseCode()     // Catch:{ IOException -> 0x00eb, all -> 0x00e7 }
            java.util.Map r11 = r3.getHeaderFields()     // Catch:{ IOException -> 0x00e2, all -> 0x00de }
            byte[] r10 = com.google.android.gms.measurement.internal.ec.a(r3)     // Catch:{ IOException -> 0x00da, all -> 0x00d7 }
            if (r3 == 0) goto L_0x00c1
            r3.disconnect()
        L_0x00c1:
            com.google.android.gms.measurement.internal.ec r0 = r13.f11857f
            com.google.android.gms.measurement.internal.eu r0 = r0.K_()
            com.google.android.gms.measurement.internal.ed r1 = new com.google.android.gms.measurement.internal.ed
            java.lang.String r6 = r13.f11855d
            com.google.android.gms.measurement.internal.ee r7 = r13.f11854c
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            r0.a((java.lang.Runnable) r1)
            return
        L_0x00d7:
            r1 = move-exception
            r4 = r1
            goto L_0x00fd
        L_0x00da:
            r1 = move-exception
            r7 = r8
            r10 = r11
            goto L_0x00e5
        L_0x00de:
            r1 = move-exception
            r4 = r1
            r11 = r2
            goto L_0x00fd
        L_0x00e2:
            r1 = move-exception
            r10 = r2
            r7 = r8
        L_0x00e5:
            r8 = r1
            goto L_0x0136
        L_0x00e7:
            r4 = move-exception
            r11 = r2
        L_0x00e9:
            r8 = 0
            goto L_0x00fd
        L_0x00eb:
            r4 = move-exception
            r10 = r2
            r8 = r4
        L_0x00ee:
            r7 = 0
            goto L_0x0136
        L_0x00f0:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r3.<init>(r4)     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
            throw r3     // Catch:{ IOException -> 0x0131, all -> 0x00f8 }
        L_0x00f8:
            r3 = move-exception
            r11 = r2
            r4 = r3
            r8 = 0
            r3 = r11
        L_0x00fd:
            if (r2 == 0) goto L_0x0115
            r2.close()     // Catch:{ IOException -> 0x0103 }
            goto L_0x0115
        L_0x0103:
            r1 = move-exception
            com.google.android.gms.measurement.internal.ec r2 = r13.f11857f
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c
            java.lang.String r5 = r13.f11855d
            java.lang.Object r5 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r5)
            r2.a(r0, r5, r1)
        L_0x0115:
            if (r3 == 0) goto L_0x011a
            r3.disconnect()
        L_0x011a:
            com.google.android.gms.measurement.internal.ec r0 = r13.f11857f
            com.google.android.gms.measurement.internal.eu r0 = r0.K_()
            com.google.android.gms.measurement.internal.ed r1 = new com.google.android.gms.measurement.internal.ed
            java.lang.String r6 = r13.f11855d
            com.google.android.gms.measurement.internal.ee r7 = r13.f11854c
            r9 = 0
            r10 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            r0.a((java.lang.Runnable) r1)
            throw r4
        L_0x0131:
            r3 = move-exception
            r10 = r2
            r8 = r3
            r7 = 0
            r3 = r10
        L_0x0136:
            if (r2 == 0) goto L_0x014e
            r2.close()     // Catch:{ IOException -> 0x013c }
            goto L_0x014e
        L_0x013c:
            r1 = move-exception
            com.google.android.gms.measurement.internal.ec r2 = r13.f11857f
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c
            java.lang.String r4 = r13.f11855d
            java.lang.Object r4 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r4)
            r2.a(r0, r4, r1)
        L_0x014e:
            if (r3 == 0) goto L_0x0153
            r3.disconnect()
        L_0x0153:
            com.google.android.gms.measurement.internal.ec r0 = r13.f11857f
            com.google.android.gms.measurement.internal.eu r0 = r0.K_()
            com.google.android.gms.measurement.internal.ed r1 = new com.google.android.gms.measurement.internal.ed
            java.lang.String r5 = r13.f11855d
            com.google.android.gms.measurement.internal.ee r6 = r13.f11854c
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r0.a((java.lang.Runnable) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.eg.run():void");
    }
}
