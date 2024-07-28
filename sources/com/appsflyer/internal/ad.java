package com.appsflyer.internal;

import com.appsflyer.internal.model.event.BackgroundEvent;

public final class ad implements Runnable {

    /* renamed from: Ι  reason: contains not printable characters */
    private final BackgroundEvent f167;

    public ad(BackgroundEvent backgroundEvent) {
        this.f167 = (BackgroundEvent) backgroundEvent.weakContext();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v11, types: [java.net.URLConnection] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01aa  */
    /* renamed from: ɩ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.HttpURLConnection m125() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = ""
            com.appsflyer.internal.model.event.BackgroundEvent r0 = r1.f167
            java.lang.String r3 = r0.urlString()
            com.appsflyer.internal.model.event.BackgroundEvent r0 = r1.f167
            java.lang.String r0 = r0.body()
            com.appsflyer.internal.model.event.BackgroundEvent r4 = r1.f167
            boolean r4 = r4.trackingStopped()
            com.appsflyer.internal.model.event.BackgroundEvent r5 = r1.f167
            boolean r5 = r5.readResponse()
            com.appsflyer.internal.model.event.BackgroundEvent r6 = r1.f167
            boolean r6 = r6.proxyMode()
            com.appsflyer.internal.model.event.BackgroundEvent r7 = r1.f167
            boolean r7 = r7.isEncrypt()
            byte[] r8 = r0.getBytes()
            r9 = 0
            if (r4 == 0) goto L_0x0030
            return r9
        L_0x0030:
            r4 = 0
            r10 = 1
            java.net.URL r11 = new java.net.URL     // Catch:{ all -> 0x018f }
            r11.<init>(r3)     // Catch:{ all -> 0x018f }
            if (r6 == 0) goto L_0x0089
            com.appsflyer.internal.ai r12 = com.appsflyer.internal.ai.f183     // Catch:{ all -> 0x018f }
            if (r12 != 0) goto L_0x0044
            com.appsflyer.internal.ai r12 = new com.appsflyer.internal.ai     // Catch:{ all -> 0x018f }
            r12.<init>()     // Catch:{ all -> 0x018f }
            com.appsflyer.internal.ai.f183 = r12     // Catch:{ all -> 0x018f }
        L_0x0044:
            com.appsflyer.internal.ai r12 = com.appsflyer.internal.ai.f183     // Catch:{ all -> 0x018f }
            java.lang.String r13 = r11.toString()     // Catch:{ all -> 0x018f }
            java.lang.String r14 = "server_request"
            java.lang.String[] r15 = new java.lang.String[r10]     // Catch:{ all -> 0x018f }
            r15[r4] = r0     // Catch:{ all -> 0x018f }
            r12.m144(r14, r13, r15)     // Catch:{ all -> 0x018f }
            java.lang.String r12 = "UTF-8"
            byte[] r12 = r0.getBytes(r12)     // Catch:{ all -> 0x018f }
            int r12 = r12.length     // Catch:{ all -> 0x018f }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
            java.lang.String r14 = "call = "
            r13.<init>(r14)     // Catch:{ all -> 0x018f }
            r13.append(r11)     // Catch:{ all -> 0x018f }
            java.lang.String r14 = "; size = "
            r13.append(r14)     // Catch:{ all -> 0x018f }
            r13.append(r12)     // Catch:{ all -> 0x018f }
            java.lang.String r14 = " byte"
            r13.append(r14)     // Catch:{ all -> 0x018f }
            if (r12 <= r10) goto L_0x0076
            java.lang.String r12 = "s"
            goto L_0x0077
        L_0x0076:
            r12 = r2
        L_0x0077:
            r13.append(r12)     // Catch:{ all -> 0x018f }
            java.lang.String r12 = "; body = "
            r13.append(r12)     // Catch:{ all -> 0x018f }
            r13.append(r0)     // Catch:{ all -> 0x018f }
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x018f }
            com.appsflyer.internal.ah.m137(r0)     // Catch:{ all -> 0x018f }
        L_0x0089:
            java.lang.String r0 = "AppsFlyer"
            int r0 = r0.hashCode()     // Catch:{ all -> 0x018f }
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ all -> 0x018f }
            java.net.URLConnection r0 = r11.openConnection()     // Catch:{ all -> 0x018f }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ all -> 0x018f }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ all -> 0x018f }
            r12 = r0
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x018f }
            r0 = 30000(0x7530, float:4.2039E-41)
            r12.setReadTimeout(r0)     // Catch:{ all -> 0x018d }
            r12.setConnectTimeout(r0)     // Catch:{ all -> 0x018d }
            java.lang.String r0 = "POST"
            r12.setRequestMethod(r0)     // Catch:{ all -> 0x018d }
            r12.setDoInput(r10)     // Catch:{ all -> 0x018d }
            r12.setDoOutput(r10)     // Catch:{ all -> 0x018d }
            java.lang.String r0 = "Content-Type"
            if (r7 == 0) goto L_0x00b9
            java.lang.String r13 = "application/octet-stream"
            goto L_0x00bb
        L_0x00b9:
            java.lang.String r13 = "application/json"
        L_0x00bb:
            r12.setRequestProperty(r0, r13)     // Catch:{ all -> 0x018d }
            java.io.OutputStream r0 = r12.getOutputStream()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x011a
            com.appsflyer.internal.model.event.BackgroundEvent r7 = r1.f167     // Catch:{ all -> 0x018d }
            java.lang.String r7 = r7.key()     // Catch:{ all -> 0x018d }
            java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch:{ all -> 0x0111 }
            r13[r4] = r7     // Catch:{ all -> 0x0111 }
            r7 = 24
            java.lang.Object r14 = com.appsflyer.internal.d.m179(r7, r4, r7)     // Catch:{ all -> 0x0111 }
            java.lang.Class r14 = (java.lang.Class) r14     // Catch:{ all -> 0x0111 }
            java.lang.String r15 = "ǃ"
            java.lang.Class[] r7 = new java.lang.Class[r10]     // Catch:{ all -> 0x0111 }
            java.lang.Class<java.lang.String> r16 = java.lang.String.class
            r7[r4] = r16     // Catch:{ all -> 0x0111 }
            java.lang.reflect.Method r7 = r14.getMethod(r15, r7)     // Catch:{ all -> 0x0111 }
            java.lang.Object r7 = r7.invoke(r9, r13)     // Catch:{ all -> 0x0111 }
            java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ all -> 0x0108 }
            r9[r4] = r8     // Catch:{ all -> 0x0108 }
            r8 = 24
            java.lang.Object r8 = com.appsflyer.internal.d.m179(r8, r4, r8)     // Catch:{ all -> 0x0108 }
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x0108 }
            java.lang.String r13 = "ı"
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x0108 }
            java.lang.Class<byte[]> r15 = byte[].class
            r14[r4] = r15     // Catch:{ all -> 0x0108 }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r13, r14)     // Catch:{ all -> 0x0108 }
            java.lang.Object r7 = r8.invoke(r7, r9)     // Catch:{ all -> 0x0108 }
            r8 = r7
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x0108 }
            goto L_0x011a
        L_0x0108:
            r0 = move-exception
            java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x018d }
            if (r4 == 0) goto L_0x0110
            throw r4     // Catch:{ all -> 0x018d }
        L_0x0110:
            throw r0     // Catch:{ all -> 0x018d }
        L_0x0111:
            r0 = move-exception
            java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x018d }
            if (r4 == 0) goto L_0x0119
            throw r4     // Catch:{ all -> 0x018d }
        L_0x0119:
            throw r0     // Catch:{ all -> 0x018d }
        L_0x011a:
            r0.write(r8)     // Catch:{ all -> 0x018d }
            r0.close()     // Catch:{ all -> 0x018d }
            r12.connect()     // Catch:{ all -> 0x018d }
            int r0 = r12.getResponseCode()     // Catch:{ all -> 0x018d }
            if (r5 == 0) goto L_0x0131
            com.appsflyer.AppsFlyerLibCore r5 = com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ all -> 0x018d }
            java.lang.String r2 = r5.m99((java.net.HttpURLConnection) r12)     // Catch:{ all -> 0x018d }
        L_0x0131:
            if (r6 == 0) goto L_0x0154
            com.appsflyer.internal.ai r5 = com.appsflyer.internal.ai.f183     // Catch:{ all -> 0x018d }
            if (r5 != 0) goto L_0x013e
            com.appsflyer.internal.ai r5 = new com.appsflyer.internal.ai     // Catch:{ all -> 0x018d }
            r5.<init>()     // Catch:{ all -> 0x018d }
            com.appsflyer.internal.ai.f183 = r5     // Catch:{ all -> 0x018d }
        L_0x013e:
            com.appsflyer.internal.ai r5 = com.appsflyer.internal.ai.f183     // Catch:{ all -> 0x018d }
            java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x018d }
            java.lang.String r7 = "server_response"
            r8 = 2
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ all -> 0x018d }
            java.lang.String r9 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x018d }
            r8[r4] = r9     // Catch:{ all -> 0x018d }
            r8[r10] = r2     // Catch:{ all -> 0x018d }
            r5.m144(r7, r6, r8)     // Catch:{ all -> 0x018d }
        L_0x0154:
            r5 = 200(0xc8, float:2.8E-43)
            if (r0 != r5) goto L_0x019e
            java.lang.String r0 = "Status 200 ok"
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x018d }
            com.appsflyer.internal.model.event.BackgroundEvent r0 = r1.f167     // Catch:{ all -> 0x018d }
            android.content.Context r0 = r0.context()     // Catch:{ all -> 0x018d }
            java.lang.String r5 = r11.toString()     // Catch:{ all -> 0x018d }
            java.lang.String r6 = com.appsflyer.AppsFlyerLibCore.REGISTER_URL     // Catch:{ all -> 0x018d }
            java.lang.String r6 = com.appsflyer.ServerConfigHandler.getUrl(r6)     // Catch:{ all -> 0x018d }
            boolean r5 = r5.startsWith(r6)     // Catch:{ all -> 0x018d }
            if (r5 == 0) goto L_0x018b
            if (r0 == 0) goto L_0x018b
            android.content.SharedPreferences r0 = com.appsflyer.AppsFlyerLibCore.getSharedPreferences(r0)     // Catch:{ all -> 0x018d }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x018d }
            java.lang.String r5 = "sentRegisterRequestToAF"
            android.content.SharedPreferences$Editor r0 = r0.putBoolean(r5, r10)     // Catch:{ all -> 0x018d }
            r0.apply()     // Catch:{ all -> 0x018d }
            java.lang.String r0 = "Successfully registered for Uninstall Tracking"
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x018d }
        L_0x018b:
            r10 = 0
            goto L_0x019e
        L_0x018d:
            r0 = move-exception
            goto L_0x0191
        L_0x018f:
            r0 = move-exception
            r12 = r9
        L_0x0191:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Error while calling "
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.afErrorLog(r3, r0)
        L_0x019e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Connection "
            r0.<init>(r3)
            if (r10 == 0) goto L_0x01aa
            java.lang.String r3 = "error"
            goto L_0x01ac
        L_0x01aa:
            java.lang.String r3 = "call succeeded"
        L_0x01ac:
            r0.append(r3)
            java.lang.String r3 = ": "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ad.m125():java.net.HttpURLConnection");
    }

    public final void run() {
        m125();
    }
}
