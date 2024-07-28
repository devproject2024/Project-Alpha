package io.branch.referral.a;

import android.content.Context;
import io.branch.referral.a.a;
import io.branch.referral.q;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private q f46419a;

    public b(Context context) {
        this.f46419a = q.a(context);
    }

    public final a.b a(String str) throws a.C0780a {
        return a(str, 0);
    }

    public final a.b a(String str, JSONObject jSONObject) throws a.C0780a {
        return a(str, jSONObject, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c0, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ed, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:54:0x00c3, B:60:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e4 A[SYNTHETIC, Splitter:B:60:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fd A[SYNTHETIC, Splitter:B:69:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.branch.referral.a.a.b a(java.lang.String r9, int r10) throws io.branch.referral.a.a.C0780a {
        /*
            r8 = this;
            java.lang.String r0 = "?"
            java.lang.String r1 = "bnc_retry_count"
            r2 = -113(0xffffffffffffff8f, float:NaN)
            r3 = 3
            r4 = 0
            int r5 = io.branch.referral.q.c()     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            if (r5 > 0) goto L_0x0010
            r5 = 3000(0xbb8, float:4.204E-42)
        L_0x0010:
            boolean r6 = r9.contains(r0)     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            if (r6 == 0) goto L_0x0018
            java.lang.String r0 = "&"
        L_0x0018:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            r6.<init>()     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            r6.append(r9)     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            r6.append(r0)     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            java.lang.String r0 = "retryNumber="
            r6.append(r0)     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            r6.append(r10)     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            java.lang.String r0 = r6.toString()     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            java.net.URL r6 = new java.net.URL     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            r6.<init>(r0)     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            java.net.URLConnection r0 = r6.openConnection()     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ SocketException -> 0x0105, SocketTimeoutException -> 0x00de, IOException -> 0x00c2 }
            r0.setConnectTimeout(r5)     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
            r0.setReadTimeout(r5)     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
            int r5 = r0.getResponseCode()     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
            r6 = 500(0x1f4, float:7.0E-43)
            if (r5 < r6) goto L_0x006d
            int r6 = io.branch.referral.q.b(r1, r3)     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
            if (r10 >= r6) goto L_0x006d
            int r4 = io.branch.referral.q.d()     // Catch:{ InterruptedException -> 0x005d }
            long r4 = (long) r4     // Catch:{ InterruptedException -> 0x005d }
            java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
        L_0x0061:
            int r10 = r10 + 1
            io.branch.referral.a.a$b r9 = r8.a((java.lang.String) r9, (int) r10)     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
            if (r0 == 0) goto L_0x006c
            r0.disconnect()
        L_0x006c:
            return r9
        L_0x006d:
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 == r6) goto L_0x008a
            java.io.InputStream r6 = r0.getErrorStream()     // Catch:{ FileNotFoundException -> 0x009d }
            if (r6 == 0) goto L_0x008a
            io.branch.referral.a.a$b r6 = new io.branch.referral.a.a$b     // Catch:{ FileNotFoundException -> 0x009d }
            java.io.InputStream r7 = r0.getErrorStream()     // Catch:{ FileNotFoundException -> 0x009d }
            java.lang.String r7 = a((java.io.InputStream) r7)     // Catch:{ FileNotFoundException -> 0x009d }
            r6.<init>(r7, r5)     // Catch:{ FileNotFoundException -> 0x009d }
            if (r0 == 0) goto L_0x0089
            r0.disconnect()
        L_0x0089:
            return r6
        L_0x008a:
            io.branch.referral.a.a$b r6 = new io.branch.referral.a.a$b     // Catch:{ FileNotFoundException -> 0x009d }
            java.io.InputStream r7 = r0.getInputStream()     // Catch:{ FileNotFoundException -> 0x009d }
            java.lang.String r7 = a((java.io.InputStream) r7)     // Catch:{ FileNotFoundException -> 0x009d }
            r6.<init>(r7, r5)     // Catch:{ FileNotFoundException -> 0x009d }
            if (r0 == 0) goto L_0x009c
            r0.disconnect()
        L_0x009c:
            return r6
        L_0x009d:
            java.lang.String r6 = "A resource conflict occurred with this request "
            java.lang.String r7 = java.lang.String.valueOf(r9)     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r6 = r6.concat(r7)     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
            io.branch.referral.q.h(r6)     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
            io.branch.referral.a.a$b r6 = new io.branch.referral.a.a$b     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
            r6.<init>(r4, r5)     // Catch:{ SocketException -> 0x00bd, SocketTimeoutException -> 0x00bb, IOException -> 0x00b8, all -> 0x00b5 }
            if (r0 == 0) goto L_0x00b4
            r0.disconnect()
        L_0x00b4:
            return r6
        L_0x00b5:
            r9 = move-exception
            r4 = r0
            goto L_0x0121
        L_0x00b8:
            r9 = move-exception
            r4 = r0
            goto L_0x00c3
        L_0x00bb:
            r4 = r0
            goto L_0x00de
        L_0x00bd:
            r9 = move-exception
            r4 = r0
            goto L_0x0106
        L_0x00c0:
            r9 = move-exception
            goto L_0x0121
        L_0x00c2:
            r9 = move-exception
        L_0x00c3:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = "Branch connect exception: "
            r10.<init>(r0)     // Catch:{ all -> 0x00c0 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00c0 }
            r10.append(r9)     // Catch:{ all -> 0x00c0 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x00c0 }
            io.branch.referral.q.h(r9)     // Catch:{ all -> 0x00c0 }
            io.branch.referral.a.a$a r9 = new io.branch.referral.a.a$a     // Catch:{ all -> 0x00c0 }
            r9.<init>(r2)     // Catch:{ all -> 0x00c0 }
            throw r9     // Catch:{ all -> 0x00c0 }
        L_0x00de:
            int r0 = io.branch.referral.q.b(r1, r3)     // Catch:{ all -> 0x00c0 }
            if (r10 >= r0) goto L_0x00fd
            int r0 = io.branch.referral.q.d()     // Catch:{ InterruptedException -> 0x00ed }
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00ed }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00ed }
            goto L_0x00f1
        L_0x00ed:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00c0 }
        L_0x00f1:
            int r10 = r10 + 1
            io.branch.referral.a.a$b r9 = r8.a((java.lang.String) r9, (int) r10)     // Catch:{ all -> 0x00c0 }
            if (r4 == 0) goto L_0x00fc
            r4.disconnect()
        L_0x00fc:
            return r9
        L_0x00fd:
            io.branch.referral.a.a$a r9 = new io.branch.referral.a.a$a     // Catch:{ all -> 0x00c0 }
            r10 = -111(0xffffffffffffff91, float:NaN)
            r9.<init>(r10)     // Catch:{ all -> 0x00c0 }
            throw r9     // Catch:{ all -> 0x00c0 }
        L_0x0105:
            r9 = move-exception
        L_0x0106:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = "Http connect exception: "
            r10.<init>(r0)     // Catch:{ all -> 0x00c0 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00c0 }
            r10.append(r9)     // Catch:{ all -> 0x00c0 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x00c0 }
            io.branch.referral.q.h(r9)     // Catch:{ all -> 0x00c0 }
            io.branch.referral.a.a$a r9 = new io.branch.referral.a.a$a     // Catch:{ all -> 0x00c0 }
            r9.<init>(r2)     // Catch:{ all -> 0x00c0 }
            throw r9     // Catch:{ all -> 0x00c0 }
        L_0x0121:
            if (r4 == 0) goto L_0x0126
            r4.disconnect()
        L_0x0126:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.a.b.a(java.lang.String, int):io.branch.referral.a.a$b");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00aa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d6, code lost:
        r7.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r2.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e6, code lost:
        r11 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00eb, code lost:
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ed, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ee, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0151, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:91:0x0125, B:97:0x0148] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0160 A[SYNTHETIC, Splitter:B:106:0x0160] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a6 A[SYNTHETIC, Splitter:B:37:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cc A[SYNTHETIC, Splitter:B:54:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00dd A[SYNTHETIC, Splitter:B:64:0x00dd] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e6 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:13:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:13:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0148 A[SYNTHETIC, Splitter:B:97:0x0148] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.branch.referral.a.a.b a(java.lang.String r11, org.json.JSONObject r12, int r13) throws io.branch.referral.a.a.C0780a {
        /*
            r10 = this;
            java.lang.String r0 = "application/json"
            java.lang.String r1 = "bnc_retry_count"
            int r2 = io.branch.referral.q.c()
            if (r2 > 0) goto L_0x000c
            r2 = 3000(0xbb8, float:4.204E-42)
        L_0x000c:
            java.lang.String r3 = "retryNumber"
            r12.put(r3, r13)     // Catch:{ JSONException -> 0x0011 }
        L_0x0011:
            r3 = 500(0x1f4, float:7.0E-43)
            r4 = 3
            r5 = 1
            r6 = 0
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ SocketTimeoutException -> 0x0142, IOException -> 0x0124, Exception -> 0x00f1 }
            r8 = 26
            if (r7 < r8) goto L_0x0021
            r7 = 102(0x66, float:1.43E-43)
            android.net.TrafficStats.setThreadStatsTag(r7)     // Catch:{ SocketTimeoutException -> 0x0142, IOException -> 0x0124, Exception -> 0x00f1 }
        L_0x0021:
            java.net.URL r7 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x0142, IOException -> 0x0124, Exception -> 0x00f1 }
            r7.<init>(r11)     // Catch:{ SocketTimeoutException -> 0x0142, IOException -> 0x0124, Exception -> 0x00f1 }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ SocketTimeoutException -> 0x0142, IOException -> 0x0124, Exception -> 0x00f1 }
            java.lang.Object r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r7)     // Catch:{ SocketTimeoutException -> 0x0142, IOException -> 0x0124, Exception -> 0x00f1 }
            java.net.URLConnection r7 = (java.net.URLConnection) r7     // Catch:{ SocketTimeoutException -> 0x0142, IOException -> 0x0124, Exception -> 0x00f1 }
            javax.net.ssl.HttpsURLConnection r7 = (javax.net.ssl.HttpsURLConnection) r7     // Catch:{ SocketTimeoutException -> 0x0142, IOException -> 0x0124, Exception -> 0x00f1 }
            r7.setConnectTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            r7.setReadTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            r7.setDoInput(r5)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            r7.setDoOutput(r5)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            java.lang.String r2 = "Content-Type"
            r7.setRequestProperty(r2, r0)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            java.lang.String r2 = "Accept"
            r7.setRequestProperty(r2, r0)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            java.lang.String r0 = "POST"
            r7.setRequestMethod(r0)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            java.io.OutputStream r2 = r7.getOutputStream()     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            r0.<init>(r2)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            java.lang.String r2 = r12.toString()     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            r0.write(r2)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            r0.flush()     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            r0.close()     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            int r0 = r7.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            if (r0 < r3) goto L_0x0088
            int r2 = io.branch.referral.q.b(r1, r4)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            if (r13 >= r2) goto L_0x0088
            int r0 = io.branch.referral.q.d()     // Catch:{ InterruptedException -> 0x0078 }
            long r8 = (long) r0     // Catch:{ InterruptedException -> 0x0078 }
            java.lang.Thread.sleep(r8)     // Catch:{ InterruptedException -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
        L_0x007c:
            int r13 = r13 + 1
            io.branch.referral.a.a$b r11 = r10.a(r11, r12, r13)     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
            if (r7 == 0) goto L_0x0087
            r7.disconnect()
        L_0x0087:
            return r11
        L_0x0088:
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 == r2) goto L_0x0097
            java.io.InputStream r2 = r7.getErrorStream()     // Catch:{ FileNotFoundException -> 0x00b7, all -> 0x00b4 }
            if (r2 == 0) goto L_0x0097
            java.io.InputStream r2 = r7.getErrorStream()     // Catch:{ FileNotFoundException -> 0x00b7, all -> 0x00b4 }
            goto L_0x009b
        L_0x0097:
            java.io.InputStream r2 = r7.getInputStream()     // Catch:{ FileNotFoundException -> 0x00b7, all -> 0x00b4 }
        L_0x009b:
            io.branch.referral.a.a$b r8 = new io.branch.referral.a.a$b     // Catch:{ FileNotFoundException -> 0x00b8 }
            java.lang.String r9 = a((java.io.InputStream) r2)     // Catch:{ FileNotFoundException -> 0x00b8 }
            r8.<init>(r9, r0)     // Catch:{ FileNotFoundException -> 0x00b8 }
            if (r2 == 0) goto L_0x00ae
            r2.close()     // Catch:{ IOException -> 0x00aa, SocketTimeoutException -> 0x00eb, Exception -> 0x00e6 }
            goto L_0x00ae
        L_0x00aa:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
        L_0x00ae:
            if (r7 == 0) goto L_0x00b3
            r7.disconnect()
        L_0x00b3:
            return r8
        L_0x00b4:
            r0 = move-exception
            r2 = r6
            goto L_0x00db
        L_0x00b7:
            r2 = r6
        L_0x00b8:
            java.lang.String r8 = "A resource conflict occurred with this request "
            java.lang.String r9 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x00da }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ all -> 0x00da }
            io.branch.referral.q.h(r8)     // Catch:{ all -> 0x00da }
            io.branch.referral.a.a$b r8 = new io.branch.referral.a.a$b     // Catch:{ all -> 0x00da }
            r8.<init>(r6, r0)     // Catch:{ all -> 0x00da }
            if (r2 == 0) goto L_0x00d4
            r2.close()     // Catch:{ IOException -> 0x00d0, SocketTimeoutException -> 0x00eb, Exception -> 0x00e6 }
            goto L_0x00d4
        L_0x00d0:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
        L_0x00d4:
            if (r7 == 0) goto L_0x00d9
            r7.disconnect()
        L_0x00d9:
            return r8
        L_0x00da:
            r0 = move-exception
        L_0x00db:
            if (r2 == 0) goto L_0x00e5
            r2.close()     // Catch:{ IOException -> 0x00e1, SocketTimeoutException -> 0x00eb, Exception -> 0x00e6 }
            goto L_0x00e5
        L_0x00e1:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
        L_0x00e5:
            throw r0     // Catch:{ SocketTimeoutException -> 0x00eb, IOException -> 0x00e8, Exception -> 0x00e6 }
        L_0x00e6:
            r11 = move-exception
            goto L_0x00f3
        L_0x00e8:
            r11 = move-exception
            r6 = r7
            goto L_0x0125
        L_0x00eb:
            r6 = r7
            goto L_0x0142
        L_0x00ed:
            r11 = move-exception
            r7 = r6
            goto L_0x0168
        L_0x00f1:
            r11 = move-exception
            r7 = r6
        L_0x00f3:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0122 }
            java.lang.String r13 = "Exception: "
            r12.<init>(r13)     // Catch:{ all -> 0x0122 }
            java.lang.String r13 = r11.getMessage()     // Catch:{ all -> 0x0122 }
            r12.append(r13)     // Catch:{ all -> 0x0122 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0122 }
            io.branch.referral.q.h(r12)     // Catch:{ all -> 0x0122 }
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0122 }
            r13 = 11
            if (r12 < r13) goto L_0x0117
            boolean r11 = r11 instanceof android.os.NetworkOnMainThreadException     // Catch:{ all -> 0x0122 }
            if (r11 == 0) goto L_0x0117
            java.lang.String r11 = "Branch Error: Don't call our synchronous methods on the main thread!!!"
            io.branch.referral.q.h(r11)     // Catch:{ all -> 0x0122 }
        L_0x0117:
            io.branch.referral.a.a$b r11 = new io.branch.referral.a.a$b     // Catch:{ all -> 0x0122 }
            r11.<init>(r6, r3)     // Catch:{ all -> 0x0122 }
            if (r7 == 0) goto L_0x0121
            r7.disconnect()
        L_0x0121:
            return r11
        L_0x0122:
            r11 = move-exception
            goto L_0x0168
        L_0x0124:
            r11 = move-exception
        L_0x0125:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ed }
            java.lang.String r13 = "Http connect exception: "
            r12.<init>(r13)     // Catch:{ all -> 0x00ed }
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x00ed }
            r12.append(r11)     // Catch:{ all -> 0x00ed }
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x00ed }
            io.branch.referral.q.h(r11)     // Catch:{ all -> 0x00ed }
            io.branch.referral.a.a$a r11 = new io.branch.referral.a.a$a     // Catch:{ all -> 0x00ed }
            r12 = -113(0xffffffffffffff8f, float:NaN)
            r11.<init>(r12)     // Catch:{ all -> 0x00ed }
            throw r11     // Catch:{ all -> 0x00ed }
        L_0x0142:
            int r0 = io.branch.referral.q.b(r1, r4)     // Catch:{ all -> 0x00ed }
            if (r13 >= r0) goto L_0x0160
            int r0 = io.branch.referral.q.d()     // Catch:{ InterruptedException -> 0x0151 }
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0151 }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0151 }
            goto L_0x0155
        L_0x0151:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00ed }
        L_0x0155:
            int r13 = r13 + r5
            io.branch.referral.a.a$b r11 = r10.a(r11, r12, r13)     // Catch:{ all -> 0x00ed }
            if (r6 == 0) goto L_0x015f
            r6.disconnect()
        L_0x015f:
            return r11
        L_0x0160:
            io.branch.referral.a.a$a r11 = new io.branch.referral.a.a$a     // Catch:{ all -> 0x00ed }
            r12 = -111(0xffffffffffffff91, float:NaN)
            r11.<init>(r12)     // Catch:{ all -> 0x00ed }
            throw r11     // Catch:{ all -> 0x00ed }
        L_0x0168:
            if (r7 == 0) goto L_0x016d
            r7.disconnect()
        L_0x016d:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.a.b.a(java.lang.String, org.json.JSONObject, int):io.branch.referral.a.a$b");
    }

    private static String a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return new BufferedReader(new InputStreamReader(inputStream)).readLine();
            } catch (IOException unused) {
            }
        }
        return null;
    }
}
