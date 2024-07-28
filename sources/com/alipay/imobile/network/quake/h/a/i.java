package com.alipay.imobile.network.quake.h.a;

import com.alipay.imobile.network.quake.e.b;
import com.alipay.imobile.network.quake.h.a.e;
import com.alipay.imobile.network.quake.h.a.f;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public final class i extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a f14879c;

    /* renamed from: d  reason: collision with root package name */
    private final SSLSocketFactory f14880d;

    public interface a {
        String a();
    }

    public i() {
        this.f14879c = null;
        this.f14880d = null;
    }

    public i(SSLSocketFactory sSLSocketFactory) {
        this.f14879c = null;
        this.f14880d = sSLSocketFactory;
    }

    private static g b(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        return new g(httpURLConnection.getContentType(), (long) httpURLConnection.getContentLength(), httpURLConnection.getContentEncoding(), errorStream);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b4, code lost:
        r0.setRequestMethod(r1);
        a(r0, (com.alipay.imobile.network.quake.e) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bd, code lost:
        r0.setRequestMethod(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.alipay.imobile.network.quake.h.a.f a(com.alipay.imobile.network.quake.e r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException, com.alipay.mobile.b.b.a {
        /*
            r6 = this;
            java.lang.String r0 = r7.d()
            com.alipay.imobile.network.quake.h.a.i$a r1 = r6.f14879c
            if (r1 == 0) goto L_0x0020
            java.lang.String r1 = r1.a()
            if (r1 == 0) goto L_0x0010
            r0 = r1
            goto L_0x0020
        L_0x0010:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = java.lang.String.valueOf(r0)
            java.lang.String r0 = "URL blocked by rewriter: "
            java.lang.String r8 = r0.concat(r8)
            r7.<init>(r8)
            throw r7
        L_0x0020:
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0142 }
            r1.<init>(r0)     // Catch:{ MalformedURLException -> 0x0142 }
            java.net.URLConnection r0 = r1.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            int r2 = r7.e()
            java.lang.String r3 = com.alipay.imobile.network.quake.h.c.c.a()
            java.lang.String r4 = "User-Agent"
            r0.setRequestProperty(r4, r3)
            r0.setConnectTimeout(r2)
            r0.setReadTimeout(r2)
            r2 = 0
            r0.setUseCaches(r2)
            r2 = 1
            r0.setDoInput(r2)
            java.lang.String r1 = r1.getProtocol()
            java.lang.String r3 = "https"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x005c
            javax.net.ssl.SSLSocketFactory r1 = r6.f14880d
            if (r1 == 0) goto L_0x005c
            r3 = r0
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3
            r3.setSSLSocketFactory(r1)
        L_0x005c:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.t
            r1.putAll(r8)
            r1.putAll(r3)
            java.util.Set r8 = r1.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0071:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x008d
            java.lang.Object r1 = r8.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r1.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r0.addRequestProperty(r3, r1)
            goto L_0x0071
        L_0x008d:
            boolean r8 = r7 instanceof com.alipay.imobile.network.quake.f.a
            java.lang.String r1 = "POST"
            if (r8 == 0) goto L_0x00ea
            r8 = r7
            com.alipay.imobile.network.quake.f.a r8 = (com.alipay.imobile.network.quake.f.a) r8
            int r3 = r8.w
            switch(r3) {
                case -1: goto L_0x00c1;
                case 0: goto L_0x00bb;
                case 1: goto L_0x00b4;
                case 2: goto L_0x00b2;
                case 3: goto L_0x00af;
                case 4: goto L_0x00ac;
                case 5: goto L_0x00a9;
                case 6: goto L_0x00a6;
                case 7: goto L_0x00a3;
                default: goto L_0x009b;
            }
        L_0x009b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Unknown method type."
            r7.<init>(r8)
            throw r7
        L_0x00a3:
            java.lang.String r1 = "PATCH"
            goto L_0x00b4
        L_0x00a6:
            java.lang.String r8 = "TRACE"
            goto L_0x00bd
        L_0x00a9:
            java.lang.String r8 = "OPTIONS"
            goto L_0x00bd
        L_0x00ac:
            java.lang.String r8 = "HEAD"
            goto L_0x00bd
        L_0x00af:
            java.lang.String r8 = "DELETE"
            goto L_0x00bd
        L_0x00b2:
            java.lang.String r1 = "PUT"
        L_0x00b4:
            r0.setRequestMethod(r1)
            a((java.net.HttpURLConnection) r0, (com.alipay.imobile.network.quake.e) r8)
            goto L_0x00f0
        L_0x00bb:
            java.lang.String r8 = "GET"
        L_0x00bd:
            r0.setRequestMethod(r8)
            goto L_0x00f0
        L_0x00c1:
            com.alipay.imobile.network.quake.e.b r3 = r8.b()
            byte[] r8 = r3.a(r8)
            if (r8 == 0) goto L_0x00f0
            r0.setDoOutput(r2)
            r0.setRequestMethod(r1)
            java.lang.String r1 = r3.a()
            java.lang.String r2 = "Content-Type"
            r0.addRequestProperty(r2, r1)
            java.io.DataOutputStream r1 = new java.io.DataOutputStream
            java.io.OutputStream r2 = r0.getOutputStream()
            r1.<init>(r2)
            r1.write(r8)
            r1.close()
            goto L_0x00f0
        L_0x00ea:
            r0.setRequestMethod(r1)
            a((java.net.HttpURLConnection) r0, (com.alipay.imobile.network.quake.e) r7)
        L_0x00f0:
            long r1 = android.os.SystemClock.elapsedRealtime()
            r0.connect()
            boolean r8 = r0 instanceof javax.net.ssl.HttpsURLConnection
            if (r8 == 0) goto L_0x0108
            com.alipay.imobile.network.quake.a r8 = com.alipay.imobile.network.quake.c.g()
            com.alipay.imobile.network.a.a.a r8 = r8.f()
            if (r8 == 0) goto L_0x0108
            com.alipay.imobile.network.quake.c.g()
        L_0x0108:
            int r8 = r0.getResponseCode()
            java.util.HashMap r3 = new java.util.HashMap
            r4 = 4
            r3.<init>(r4)
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r4 = r4 - r1
            java.lang.String r1 = java.lang.String.valueOf(r4)
            java.lang.String r2 = "duration"
            r3.put(r2, r1)
            java.lang.String r1 = r7.a()
            java.lang.String r2 = "operation_type"
            r3.put(r2, r1)
            r7.b((java.util.Map<java.lang.String, java.lang.String>) r3)
            r7.a((java.util.Map<java.lang.String, java.lang.String>) r3)
            com.alipay.iap.android.common.b.d.a()
            r7 = -1
            if (r8 == r7) goto L_0x013a
            com.alipay.imobile.network.quake.h.a.f r7 = a(r0)
            return r7
        L_0x013a:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "Could not retrieve response code from HttpUrlConnection."
            r7.<init>(r8)
            throw r7
        L_0x0142:
            r7 = move-exception
            com.alipay.imobile.network.quake.c.c r8 = new com.alipay.imobile.network.quake.c.c
            r0 = 3002(0xbba, float:4.207E-42)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Illegal url config: "
            r1.<init>(r2)
            java.lang.String r7 = r7.getMessage()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r8.<init>((java.lang.Integer) r0, (java.lang.String) r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.h.a.i.a(com.alipay.imobile.network.quake.e, java.util.Map):com.alipay.imobile.network.quake.h.a.f");
    }

    private static f a(HttpURLConnection httpURLConnection) throws IOException {
        List<String> list;
        int responseCode = httpURLConnection.getResponseCode();
        f.a aVar = new f.a();
        aVar.f14869a = "HTTP/1.1";
        aVar.f14870b = responseCode;
        aVar.f14871c = httpURLConnection.getResponseMessage();
        if ((responseCode < 200 || responseCode == 204 || responseCode == 304) ? false : true) {
            aVar.f14873e = b(httpURLConnection);
        }
        for (Map.Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
            if (!(entry.getKey() == null || (list = (List) entry.getValue()) == null || list.isEmpty())) {
                for (String str : list) {
                    String str2 = (String) entry.getKey();
                    e.a aVar2 = aVar.f14872d;
                    if (str2 == null) {
                        throw new IllegalArgumentException("name == null");
                    } else if (!str2.isEmpty()) {
                        int length = str2.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            char charAt = str2.charAt(i2);
                            if (charAt <= 31 || charAt >= 127) {
                                throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(charAt), Integer.valueOf(i2), str2}));
                            }
                        }
                        if (str != null) {
                            int length2 = str.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                char charAt2 = str.charAt(i3);
                                if (charAt2 <= 31 || charAt2 >= 127) {
                                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(charAt2), Integer.valueOf(i3), str2, str}));
                                }
                            }
                            aVar2.f14863a.add(str2);
                            aVar2.f14863a.add(str.trim());
                        } else {
                            throw new IllegalArgumentException("value == null");
                        }
                    } else {
                        throw new IllegalArgumentException("name is empty");
                    }
                }
                continue;
            }
        }
        if (aVar.f14870b >= 0) {
            return new f(aVar, (byte) 0);
        }
        throw new IllegalStateException("code < 0: " + aVar.f14870b);
    }

    private static void a(HttpURLConnection httpURLConnection, com.alipay.imobile.network.quake.e eVar) throws IOException, com.alipay.mobile.b.b.a {
        b b2 = eVar.b();
        byte[] a2 = b2.a(eVar);
        if (a2 != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", b2.a());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            if (eVar.k) {
                try {
                    byte[] a3 = a(a2);
                    if (a3 != null) {
                        httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                        a2 = a3;
                    }
                } catch (IOException unused) {
                    throw new com.alipay.imobile.network.quake.c.a((Integer) 9, "gzip body failed");
                }
            }
            dataOutputStream.write(a2);
            dataOutputStream.close();
        }
    }
}
