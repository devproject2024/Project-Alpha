package com.google.a.a.a.a;

import com.google.a.a.a.r;
import com.google.a.a.a.s;
import com.google.a.a.b.a.a.a.a.c;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

final class a extends r {

    /* renamed from: e  reason: collision with root package name */
    private final HttpURLConnection f7462e;

    a(HttpURLConnection httpURLConnection) {
        this.f7462e = httpURLConnection;
        httpURLConnection.setInstanceFollowRedirects(false);
    }

    public final void a(String str, String str2) {
        this.f7462e.addRequestProperty(str, str2);
    }

    public final void a(int i2, int i3) {
        this.f7462e.setReadTimeout(i3);
        this.f7462e.setConnectTimeout(i2);
    }

    public final s a() throws IOException {
        HttpURLConnection httpURLConnection = this.f7462e;
        if (this.f7532d != null) {
            String str = this.f7531c;
            if (str != null) {
                a("Content-Type", str);
            }
            String str2 = this.f7530b;
            if (str2 != null) {
                a("Content-Encoding", str2);
            }
            long j = this.f7529a;
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 >= 0) {
                a("Content-Length", Long.toString(j));
            }
            String requestMethod = httpURLConnection.getRequestMethod();
            if ("POST".equals(requestMethod) || "PUT".equals(requestMethod)) {
                httpURLConnection.setDoOutput(true);
                if (i2 < 0 || j > 2147483647L) {
                    httpURLConnection.setChunkedStreamingMode(0);
                } else {
                    httpURLConnection.setFixedLengthStreamingMode((int) j);
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    this.f7532d.a(outputStream);
                } finally {
                    outputStream.close();
                }
            } else {
                c.a(i2 == 0, "%s with non-zero content length is not supported", requestMethod);
            }
        }
        try {
            httpURLConnection.connect();
            return new b(httpURLConnection);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
