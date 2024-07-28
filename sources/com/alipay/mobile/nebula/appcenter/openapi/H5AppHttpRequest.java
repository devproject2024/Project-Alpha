package com.alipay.mobile.nebula.appcenter.openapi;

import java.util.HashMap;

public class H5AppHttpRequest {
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_CONNECTION = "Connection";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_UA = "User-Agent";
    private static final String TAG = "H5AppHttpRequest";
    /* access modifiers changed from: private */
    public final String body;
    /* access modifiers changed from: private */
    public final HashMap<String, String> headers;
    /* access modifiers changed from: private */
    public final String method;
    /* access modifiers changed from: private */
    public final String url;

    private H5AppHttpRequest(Builder builder) {
        this.url = builder.url;
        this.body = builder.body;
        this.method = builder.method;
        this.headers = builder.headers;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005d, code lost:
        if (r14.headers.containsKey("Accept") == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        if (r14.headers.containsKey("Connection") == false) goto L_0x0072;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f0 A[Catch:{ all -> 0x010e, all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0105 A[SYNTHETIC, Splitter:B:45:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010a A[Catch:{ all -> 0x00bf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String execute() {
        /*
            r14 = this;
            java.lang.String r0 = "request post error in finally "
            java.lang.String r1 = "H5AppHttpRequest"
            java.lang.String r2 = ""
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ all -> 0x00d2 }
            java.lang.String r5 = r14.url     // Catch:{ all -> 0x00d2 }
            r4.<init>(r5)     // Catch:{ all -> 0x00d2 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            java.lang.String r6 = "sendPost "
            r5.<init>(r6)     // Catch:{ all -> 0x00d2 }
            java.lang.String r6 = r14.url     // Catch:{ all -> 0x00d2 }
            r5.append(r6)     // Catch:{ all -> 0x00d2 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00d2 }
            com.alipay.mobile.nebula.util.H5Log.d(r1, r5)     // Catch:{ all -> 0x00d2 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ all -> 0x00d2 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x00d2 }
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r14.headers     // Catch:{ all -> 0x00d2 }
            if (r5 == 0) goto L_0x0051
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r14.headers     // Catch:{ all -> 0x00d2 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x00d2 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00d2 }
        L_0x0035:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x00d2 }
            if (r6 == 0) goto L_0x0051
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x00d2 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x00d2 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ all -> 0x00d2 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00d2 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x00d2 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00d2 }
            r4.setRequestProperty(r7, r6)     // Catch:{ all -> 0x00d2 }
            goto L_0x0035
        L_0x0051:
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r14.headers     // Catch:{ all -> 0x00d2 }
            java.lang.String r6 = "Accept"
            if (r5 == 0) goto L_0x005f
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r14.headers     // Catch:{ all -> 0x00d2 }
            boolean r5 = r5.containsKey(r6)     // Catch:{ all -> 0x00d2 }
            if (r5 != 0) goto L_0x0064
        L_0x005f:
            java.lang.String r5 = "*/*"
            r4.setRequestProperty(r6, r5)     // Catch:{ all -> 0x00d2 }
        L_0x0064:
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r14.headers     // Catch:{ all -> 0x00d2 }
            java.lang.String r6 = "Connection"
            if (r5 == 0) goto L_0x0072
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r14.headers     // Catch:{ all -> 0x00d2 }
            boolean r5 = r5.containsKey(r6)     // Catch:{ all -> 0x00d2 }
            if (r5 != 0) goto L_0x0077
        L_0x0072:
            java.lang.String r5 = "Keep-Alive"
            r4.setRequestProperty(r6, r5)     // Catch:{ all -> 0x00d2 }
        L_0x0077:
            java.lang.String r5 = r14.method     // Catch:{ all -> 0x00d2 }
            r4.setRequestMethod(r5)     // Catch:{ all -> 0x00d2 }
            r5 = 1
            r4.setDoOutput(r5)     // Catch:{ all -> 0x00d2 }
            r4.setDoInput(r5)     // Catch:{ all -> 0x00d2 }
            java.io.PrintWriter r5 = new java.io.PrintWriter     // Catch:{ all -> 0x00d2 }
            java.io.OutputStream r6 = r4.getOutputStream()     // Catch:{ all -> 0x00d2 }
            r5.<init>(r6)     // Catch:{ all -> 0x00d2 }
            java.lang.String r6 = r14.body     // Catch:{ all -> 0x00ce }
            r5.print(r6)     // Catch:{ all -> 0x00ce }
            r5.flush()     // Catch:{ all -> 0x00ce }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x00ce }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ all -> 0x00ce }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x00ce }
            r7.<init>(r4)     // Catch:{ all -> 0x00ce }
            r6.<init>(r7)     // Catch:{ all -> 0x00ce }
        L_0x00a2:
            java.lang.String r3 = r6.readLine()     // Catch:{ all -> 0x00cc }
            if (r3 == 0) goto L_0x00b8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cc }
            r4.<init>()     // Catch:{ all -> 0x00cc }
            r4.append(r2)     // Catch:{ all -> 0x00cc }
            r4.append(r3)     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x00cc }
            goto L_0x00a2
        L_0x00b8:
            r5.close()     // Catch:{ all -> 0x00bf }
            r6.close()     // Catch:{ all -> 0x00bf }
            goto L_0x010d
        L_0x00bf:
            r3 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r0 = r0.concat(r3)
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.String) r0)
            goto L_0x010d
        L_0x00cc:
            r4 = move-exception
            goto L_0x00d0
        L_0x00ce:
            r4 = move-exception
            r6 = r3
        L_0x00d0:
            r3 = r5
            goto L_0x00d4
        L_0x00d2:
            r4 = move-exception
            r6 = r3
        L_0x00d4:
            java.lang.String r5 = "request post error"
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x010e }
            java.lang.String r5 = r5.concat(r7)     // Catch:{ all -> 0x010e }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ all -> 0x010e }
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r5 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x010e }
            java.lang.Object r5 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r5)     // Catch:{ all -> 0x010e }
            r7 = r5
            com.alipay.mobile.nebula.provider.H5LogProvider r7 = (com.alipay.mobile.nebula.provider.H5LogProvider) r7     // Catch:{ all -> 0x010e }
            if (r7 == 0) goto L_0x0103
            java.lang.String r5 = "H5AppHttpRequest^sendPostException="
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x010e }
            java.lang.String r13 = r5.concat(r4)     // Catch:{ all -> 0x010e }
            java.lang.String r8 = "H5AppHttpRequest"
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r7.log(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x010e }
        L_0x0103:
            if (r3 == 0) goto L_0x0108
            r3.close()     // Catch:{ all -> 0x00bf }
        L_0x0108:
            if (r6 == 0) goto L_0x010d
            r6.close()     // Catch:{ all -> 0x00bf }
        L_0x010d:
            return r2
        L_0x010e:
            r2 = move-exception
            if (r3 == 0) goto L_0x0117
            r3.close()     // Catch:{ all -> 0x0115 }
            goto L_0x0117
        L_0x0115:
            r3 = move-exception
            goto L_0x011d
        L_0x0117:
            if (r6 == 0) goto L_0x0128
            r6.close()     // Catch:{ all -> 0x0115 }
            goto L_0x0128
        L_0x011d:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r0 = r0.concat(r3)
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.String) r0)
        L_0x0128:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.appcenter.openapi.H5AppHttpRequest.execute():java.lang.String");
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String body;
        /* access modifiers changed from: private */
        public HashMap<String, String> headers;
        /* access modifiers changed from: private */
        public String method;
        /* access modifiers changed from: private */
        public String url;

        public Builder() {
            this.headers = null;
            this.method = "POST";
            this.headers = new HashMap<>();
        }

        Builder(H5AppHttpRequest h5AppHttpRequest) {
            this.headers = null;
            this.url = h5AppHttpRequest.url;
            this.method = h5AppHttpRequest.method;
            this.body = h5AppHttpRequest.body;
            this.headers = h5AppHttpRequest.headers;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder body(String str) {
            this.body = str;
            return this;
        }

        public Builder method(String str) {
            this.method = str;
            return this;
        }

        public Builder addHeader(String str, String str2) {
            if (this.headers == null) {
                this.headers = new HashMap<>();
            }
            this.headers.put(str, str2);
            return this;
        }

        public H5AppHttpRequest build() {
            return new H5AppHttpRequest(this);
        }
    }
}
