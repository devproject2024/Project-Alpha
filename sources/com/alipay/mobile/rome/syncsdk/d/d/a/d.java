package com.alipay.mobile.rome.syncsdk.d.d.a;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.SocketFactory;

public class d extends SocketFactory {

    /* renamed from: b  reason: collision with root package name */
    private static final String f15064b = d.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    int f15065a = 15;

    /* renamed from: c  reason: collision with root package name */
    private final a f15066c;

    public d(a aVar) {
        this.f15066c = aVar;
    }

    public Socket createSocket(String str, int i2) {
        return a(str, i2, this.f15065a);
    }

    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) {
        return a(str, i2, this.f15065a);
    }

    public Socket createSocket(InetAddress inetAddress, int i2) {
        return a(inetAddress.getHostAddress(), i2, this.f15065a);
    }

    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) {
        return a(inetAddress.getHostAddress(), i2, this.f15065a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.net.Socket a(java.lang.String r9, int r10, int r11) {
        /*
            r8 = this;
            java.lang.String r0 = ":"
            com.alipay.mobile.rome.syncsdk.d.d.a.a r1 = r8.f15066c
            java.lang.String r1 = r1.f15059a
            com.alipay.mobile.rome.syncsdk.d.d.a.a r2 = r8.f15066c
            int r2 = r2.f15060b
            java.lang.String r3 = f15064b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "socketOverHttpProxy: [ proxyHost="
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r5 = " ][ proxyPort="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = " ]"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.alipay.mobile.rome.syncsdk.e.h.a(r3, r4)
            r3 = 0
            java.net.Socket r4 = new java.net.Socket     // Catch:{ IOException -> 0x00e7 }
            java.net.Proxy r6 = java.net.Proxy.NO_PROXY     // Catch:{ IOException -> 0x00e7 }
            r4.<init>(r6)     // Catch:{ IOException -> 0x00e7 }
            r6 = 1
            r4.setTcpNoDelay(r6)     // Catch:{ IOException -> 0x00e5 }
            r4.setKeepAlive(r6)     // Catch:{ IOException -> 0x00e5 }
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress     // Catch:{ IOException -> 0x00e5 }
            r6.<init>(r1, r2)     // Catch:{ IOException -> 0x00e5 }
            int r11 = r11 * 1000
            r4.connect(r6, r11)     // Catch:{ IOException -> 0x00e5 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00e5 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00e5 }
            java.io.InputStream r6 = r4.getInputStream()     // Catch:{ IOException -> 0x00e5 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x00e5 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x00e5 }
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x00e5 }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x00e5 }
            java.io.OutputStream r7 = r4.getOutputStream()     // Catch:{ IOException -> 0x00e5 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x00e5 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x00e5 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e5 }
            java.lang.String r7 = "CONNECT "
            r6.<init>(r7)     // Catch:{ IOException -> 0x00e5 }
            r6.append(r9)     // Catch:{ IOException -> 0x00e5 }
            r6.append(r0)     // Catch:{ IOException -> 0x00e5 }
            r6.append(r10)     // Catch:{ IOException -> 0x00e5 }
            java.lang.String r7 = " HTTP/1.1\r\nHost: "
            r6.append(r7)     // Catch:{ IOException -> 0x00e5 }
            r6.append(r9)     // Catch:{ IOException -> 0x00e5 }
            r6.append(r0)     // Catch:{ IOException -> 0x00e5 }
            r6.append(r10)     // Catch:{ IOException -> 0x00e5 }
            java.lang.String r9 = "\r\nProxy-Connection: Keep-Alive\r\n\r\n"
            r6.append(r9)     // Catch:{ IOException -> 0x00e5 }
            java.lang.String r9 = r6.toString()     // Catch:{ IOException -> 0x00e5 }
            r2.write(r9)     // Catch:{ IOException -> 0x00e5 }
            r2.flush()     // Catch:{ IOException -> 0x00e5 }
            r4.setSoTimeout(r11)     // Catch:{ IOException -> 0x00e5 }
            java.lang.String r9 = r1.readLine()     // Catch:{ IOException -> 0x00e5 }
        L_0x0093:
            java.lang.String r10 = r1.readLine()     // Catch:{ IOException -> 0x00e5 }
            if (r10 == 0) goto L_0x00a5
            java.lang.String r10 = r10.trim()     // Catch:{ IOException -> 0x00e5 }
            java.lang.String r11 = ""
            boolean r10 = r10.equals(r11)     // Catch:{ IOException -> 0x00e5 }
            if (r10 == 0) goto L_0x0093
        L_0x00a5:
            r10 = 0
            r4.setSoTimeout(r10)     // Catch:{ IOException -> 0x00e5 }
            if (r9 == 0) goto L_0x00cb
            java.lang.String r10 = "200"
            boolean r10 = r9.contains(r10)     // Catch:{ IOException -> 0x00e5 }
            if (r10 == 0) goto L_0x00cb
            java.lang.String r10 = f15064b     // Catch:{ IOException -> 0x00e5 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e5 }
            java.lang.String r0 = "socketOverHttpProxy: connect success [ result="
            r11.<init>(r0)     // Catch:{ IOException -> 0x00e5 }
            r11.append(r9)     // Catch:{ IOException -> 0x00e5 }
            r11.append(r5)     // Catch:{ IOException -> 0x00e5 }
            java.lang.String r9 = r11.toString()     // Catch:{ IOException -> 0x00e5 }
            com.alipay.mobile.rome.syncsdk.e.h.a(r10, r9)     // Catch:{ IOException -> 0x00e5 }
            r3 = r4
            goto L_0x00e4
        L_0x00cb:
            java.lang.String r10 = f15064b     // Catch:{ IOException -> 0x00e5 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e5 }
            java.lang.String r0 = "socketOverHttpProxy: connect failed [ result="
            r11.<init>(r0)     // Catch:{ IOException -> 0x00e5 }
            r11.append(r9)     // Catch:{ IOException -> 0x00e5 }
            r11.append(r5)     // Catch:{ IOException -> 0x00e5 }
            java.lang.String r9 = r11.toString()     // Catch:{ IOException -> 0x00e5 }
            com.alipay.mobile.rome.syncsdk.e.h.c(r10, r9)     // Catch:{ IOException -> 0x00e5 }
            r4.close()     // Catch:{ IOException -> 0x00e5 }
        L_0x00e4:
            return r3
        L_0x00e5:
            r9 = move-exception
            goto L_0x00e9
        L_0x00e7:
            r9 = move-exception
            r4 = r3
        L_0x00e9:
            if (r4 == 0) goto L_0x00ee
            r4.close()
        L_0x00ee:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncsdk.d.d.a.d.a(java.lang.String, int, int):java.net.Socket");
    }
}
