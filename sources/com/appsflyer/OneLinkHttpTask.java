package com.appsflyer;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;

public abstract class OneLinkHttpTask implements Runnable {
    static final String BASE_URL = "https://%sonelink.%s/shortlink-sdk/v1";
    static final String NO_CONNECTION_ERROR_MSG = "Can't get one link data";
    private static final int WAIT_TIMEOUT = 3000;
    private AppsFlyerLibCore afLib;
    private HttpsUrlConnectionProvider connectionProvider;
    public String oneLinkId;

    /* access modifiers changed from: protected */
    public abstract String getOneLinkUrl();

    /* access modifiers changed from: protected */
    public abstract void handleResponse(String str);

    /* access modifiers changed from: protected */
    public abstract void initRequest(HttpsURLConnection httpsURLConnection) throws JSONException, IOException;

    /* access modifiers changed from: protected */
    public abstract void onErrorResponse();

    public OneLinkHttpTask(AppsFlyerLibCore appsFlyerLibCore) {
        this.afLib = appsFlyerLibCore;
    }

    public void setConnProvider(HttpsUrlConnectionProvider httpsUrlConnectionProvider) {
        this.connectionProvider = httpsUrlConnectionProvider;
    }

    public void run() {
        doRequest();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doRequest() {
        /*
            r7 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            java.lang.String r3 = r7.getOneLinkUrl()
            java.lang.String r4 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "oneLinkUrl: "
            java.lang.String r4 = r5.concat(r4)
            com.appsflyer.AFLogger.afRDLog(r4)
            com.appsflyer.OneLinkHttpTask$HttpsUrlConnectionProvider r4 = r7.connectionProvider     // Catch:{ all -> 0x0072 }
            javax.net.ssl.HttpsURLConnection r4 = r4.m113(r3)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = "content-type"
            java.lang.String r6 = "application/json"
            r4.addRequestProperty(r5, r6)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = "authorization"
            java.lang.String r6 = com.appsflyer.internal.z.m215(r1)     // Catch:{ all -> 0x0072 }
            r4.addRequestProperty(r5, r6)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = "af-timestamp"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0072 }
            r4.addRequestProperty(r5, r1)     // Catch:{ all -> 0x0072 }
            r1 = 3000(0xbb8, float:4.204E-42)
            r4.setReadTimeout(r1)     // Catch:{ all -> 0x0072 }
            r4.setConnectTimeout(r1)     // Catch:{ all -> 0x0072 }
            r7.initRequest(r4)     // Catch:{ all -> 0x0072 }
            int r1 = r4.getResponseCode()     // Catch:{ all -> 0x0072 }
            com.appsflyer.AppsFlyerLibCore r2 = r7.afLib     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = r2.m99((java.net.HttpURLConnection) r4)     // Catch:{ all -> 0x0072 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r1 != r4) goto L_0x0058
            java.lang.String r1 = "Status 200 ok"
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ all -> 0x006f }
            goto L_0x0099
        L_0x0058:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            java.lang.String r4 = "Response code = "
            r0.<init>(r4)     // Catch:{ all -> 0x006f }
            r0.append(r1)     // Catch:{ all -> 0x006f }
            java.lang.String r1 = " content = "
            r0.append(r1)     // Catch:{ all -> 0x006f }
            r0.append(r2)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006f }
            goto L_0x0099
        L_0x006f:
            r0 = move-exception
            r1 = r0
            goto L_0x0074
        L_0x0072:
            r1 = move-exception
            r2 = r0
        L_0x0074:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Error while calling "
            java.lang.String r0 = r4.concat(r0)
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            r0.append(r3)
            java.lang.String r3 = " stacktrace: "
            r0.append(r3)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0099:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x00b0
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Connection call succeeded: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.afInfoLog(r0)
            r7.handleResponse(r2)
            return
        L_0x00b0:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Connection error: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.afWarnLog(r0)
            r7.onErrorResponse()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.OneLinkHttpTask.doRequest():void");
    }

    public static class HttpsUrlConnectionProvider {
        /* access modifiers changed from: package-private */
        /* renamed from: ǃ  reason: contains not printable characters */
        public final HttpsURLConnection m113(String str) throws IOException {
            return (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        }
    }
}
