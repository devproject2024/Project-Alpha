package com.google.android.gms.measurement.internal;

import java.net.URL;
import java.util.List;
import java.util.Map;

final class he implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final hf f12094a;

    /* renamed from: b  reason: collision with root package name */
    final String f12095b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f12096c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f12097d = null;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f12098e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ hb f12099f;

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.measurement.internal.hf, byte[], java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public he(com.google.android.gms.measurement.internal.hb r1, java.lang.String r2, java.net.URL r3, byte[] r4) {
        /*
            r0 = this;
            r0.f12099f = r1
            r0.<init>()
            com.google.android.gms.common.internal.s.a((java.lang.String) r2)
            com.google.android.gms.common.internal.s.a(r3)
            com.google.android.gms.common.internal.s.a(r4)
            r0.f12096c = r3
            r1 = 0
            r0.f12097d = r1
            r0.f12094a = r4
            r0.f12095b = r2
            r0.f12098e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.<init>(com.google.android.gms.measurement.internal.hb, java.lang.String, java.net.URL, com.google.android.gms.measurement.internal.hf):void");
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b8  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.hb r0 = r7.f12099f
            r0.g()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.hb r2 = r7.f12099f     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            java.net.URL r3 = r7.f12096c     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            boolean r4 = r3 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            if (r4 == 0) goto L_0x009d
            javax.net.ssl.SSLSocketFactory r4 = r2.f12091a     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            if (r4 == 0) goto L_0x0023
            boolean r4 = r3 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            if (r4 == 0) goto L_0x0023
            r4 = r3
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            javax.net.ssl.SSLSocketFactory r2 = r2.f12091a     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            r4.setSSLSocketFactory(r2)     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
        L_0x0023:
            r2 = r3
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            r2.setDefaultUseCaches(r0)     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            r3 = 60000(0xea60, float:8.4078E-41)
            r2.setConnectTimeout(r3)     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            r3 = 61000(0xee48, float:8.5479E-41)
            r2.setReadTimeout(r3)     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            r2.setInstanceFollowRedirects(r0)     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            r3 = 1
            r2.setDoInput(r3)     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.f12098e     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            if (r3 == 0) goto L_0x0066
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.f12098e     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            java.util.Set r3 = r3.entrySet()     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
        L_0x004a:
            boolean r4 = r3.hasNext()     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            if (r4 == 0) goto L_0x0066
            java.lang.Object r4 = r3.next()     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            r2.addRequestProperty(r5, r4)     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            goto L_0x004a
        L_0x0066:
            int r0 = r2.getResponseCode()     // Catch:{ IOException -> 0x0097, all -> 0x0091 }
            java.util.Map r3 = r2.getHeaderFields()     // Catch:{ IOException -> 0x008c, all -> 0x0087 }
            byte[] r4 = com.google.android.gms.measurement.internal.hb.a(r2)     // Catch:{ IOException -> 0x0081, all -> 0x007b }
            if (r2 == 0) goto L_0x0077
            r2.disconnect()
        L_0x0077:
            r7.a(r0, r1, r4, r3)
            return
        L_0x007b:
            r4 = move-exception
            r6 = r4
            r4 = r0
            r0 = r2
            r2 = r6
            goto L_0x00a9
        L_0x0081:
            r4 = move-exception
            r6 = r4
            r4 = r0
            r0 = r2
            r2 = r6
            goto L_0x00b6
        L_0x0087:
            r3 = move-exception
            r4 = r0
            r0 = r2
            r2 = r3
            goto L_0x0095
        L_0x008c:
            r3 = move-exception
            r4 = r0
            r0 = r2
            r2 = r3
            goto L_0x009b
        L_0x0091:
            r3 = move-exception
            r0 = r2
            r2 = r3
            r4 = 0
        L_0x0095:
            r3 = r1
            goto L_0x00a9
        L_0x0097:
            r3 = move-exception
            r0 = r2
            r2 = r3
            r4 = 0
        L_0x009b:
            r3 = r1
            goto L_0x00b6
        L_0x009d:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            java.lang.String r3 = "Failed to obtain HTTP connection"
            r2.<init>(r3)     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
            throw r2     // Catch:{ IOException -> 0x00b2, all -> 0x00a5 }
        L_0x00a5:
            r2 = move-exception
            r0 = r1
            r3 = r0
            r4 = 0
        L_0x00a9:
            if (r0 == 0) goto L_0x00ae
            r0.disconnect()
        L_0x00ae:
            r7.a(r4, r1, r1, r3)
            throw r2
        L_0x00b2:
            r2 = move-exception
            r0 = r1
            r3 = r0
            r4 = 0
        L_0x00b6:
            if (r0 == 0) goto L_0x00bb
            r0.disconnect()
        L_0x00bb:
            r7.a(r4, r2, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.run():void");
    }

    private final void a(int i2, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.f12099f.K_().a((Runnable) new hh(this, i2, exc, bArr, map));
    }
}
