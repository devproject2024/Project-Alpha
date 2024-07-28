package com.google.firebase.perf.network;

import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.gms.internal.p001firebaseperf.t;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.security.Permission;
import java.util.List;
import java.util.Map;

final class f {

    /* renamed from: a  reason: collision with root package name */
    final HttpURLConnection f39296a;

    /* renamed from: b  reason: collision with root package name */
    private final t f39297b;

    /* renamed from: c  reason: collision with root package name */
    private long f39298c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f39299d = -1;

    /* renamed from: e  reason: collision with root package name */
    private final zzbg f39300e;

    public f(HttpURLConnection httpURLConnection, zzbg zzbg, t tVar) {
        this.f39296a = httpURLConnection;
        this.f39297b = tVar;
        this.f39300e = zzbg;
        this.f39297b.a(this.f39296a.getURL().toString());
    }

    public final void a() throws IOException {
        if (this.f39298c == -1) {
            this.f39300e.a();
            this.f39298c = this.f39300e.f9736a;
            this.f39297b.b(this.f39298c);
        }
        try {
            this.f39296a.connect();
        } catch (IOException e2) {
            this.f39297b.d(this.f39300e.b());
            g.a(this.f39297b);
            throw e2;
        }
    }

    public final void b() {
        this.f39297b.d(this.f39300e.b());
        this.f39297b.b();
        this.f39296a.disconnect();
    }

    public final Object c() throws IOException {
        r();
        this.f39297b.a(this.f39296a.getResponseCode());
        try {
            Object content = this.f39296a.getContent();
            if (content instanceof InputStream) {
                this.f39297b.c(this.f39296a.getContentType());
                return new b((InputStream) content, this.f39297b, this.f39300e);
            }
            this.f39297b.c(this.f39296a.getContentType());
            this.f39297b.e((long) this.f39296a.getContentLength());
            this.f39297b.d(this.f39300e.b());
            this.f39297b.b();
            return content;
        } catch (IOException e2) {
            this.f39297b.d(this.f39300e.b());
            g.a(this.f39297b);
            throw e2;
        }
    }

    public final Object a(Class[] clsArr) throws IOException {
        r();
        this.f39297b.a(this.f39296a.getResponseCode());
        try {
            Object content = this.f39296a.getContent(clsArr);
            if (content instanceof InputStream) {
                this.f39297b.c(this.f39296a.getContentType());
                return new b((InputStream) content, this.f39297b, this.f39300e);
            }
            this.f39297b.c(this.f39296a.getContentType());
            this.f39297b.e((long) this.f39296a.getContentLength());
            this.f39297b.d(this.f39300e.b());
            this.f39297b.b();
            return content;
        } catch (IOException e2) {
            this.f39297b.d(this.f39300e.b());
            g.a(this.f39297b);
            throw e2;
        }
    }

    public final InputStream d() throws IOException {
        r();
        this.f39297b.a(this.f39296a.getResponseCode());
        this.f39297b.c(this.f39296a.getContentType());
        try {
            return new b(this.f39296a.getInputStream(), this.f39297b, this.f39300e);
        } catch (IOException e2) {
            this.f39297b.d(this.f39300e.b());
            g.a(this.f39297b);
            throw e2;
        }
    }

    public final long e() {
        r();
        return this.f39296a.getLastModified();
    }

    public final OutputStream f() throws IOException {
        try {
            return new a(this.f39296a.getOutputStream(), this.f39297b, this.f39300e);
        } catch (IOException e2) {
            this.f39297b.d(this.f39300e.b());
            g.a(this.f39297b);
            throw e2;
        }
    }

    public final Permission g() throws IOException {
        try {
            return this.f39296a.getPermission();
        } catch (IOException e2) {
            this.f39297b.d(this.f39300e.b());
            g.a(this.f39297b);
            throw e2;
        }
    }

    public final int h() throws IOException {
        r();
        if (this.f39299d == -1) {
            this.f39299d = this.f39300e.b();
            this.f39297b.c(this.f39299d);
        }
        try {
            int responseCode = this.f39296a.getResponseCode();
            this.f39297b.a(responseCode);
            return responseCode;
        } catch (IOException e2) {
            this.f39297b.d(this.f39300e.b());
            g.a(this.f39297b);
            throw e2;
        }
    }

    public final String i() throws IOException {
        r();
        if (this.f39299d == -1) {
            this.f39299d = this.f39300e.b();
            this.f39297b.c(this.f39299d);
        }
        try {
            String responseMessage = this.f39296a.getResponseMessage();
            this.f39297b.a(this.f39296a.getResponseCode());
            return responseMessage;
        } catch (IOException e2) {
            this.f39297b.d(this.f39300e.b());
            g.a(this.f39297b);
            throw e2;
        }
    }

    public final long j() {
        r();
        return this.f39296a.getExpiration();
    }

    public final String a(int i2) {
        r();
        return this.f39296a.getHeaderField(i2);
    }

    public final String a(String str) {
        r();
        return this.f39296a.getHeaderField(str);
    }

    public final long a(String str, long j) {
        r();
        return this.f39296a.getHeaderFieldDate(str, j);
    }

    public final int a(String str, int i2) {
        r();
        return this.f39296a.getHeaderFieldInt(str, i2);
    }

    public final long b(String str, long j) {
        r();
        return this.f39296a.getHeaderFieldLong(str, j);
    }

    public final String b(int i2) {
        r();
        return this.f39296a.getHeaderFieldKey(i2);
    }

    public final Map<String, List<String>> k() {
        r();
        return this.f39296a.getHeaderFields();
    }

    public final String l() {
        r();
        return this.f39296a.getContentEncoding();
    }

    public final int m() {
        r();
        return this.f39296a.getContentLength();
    }

    public final long n() {
        r();
        return this.f39296a.getContentLengthLong();
    }

    public final String o() {
        r();
        return this.f39296a.getContentType();
    }

    public final long p() {
        r();
        return this.f39296a.getDate();
    }

    public final void a(String str, String str2) {
        this.f39296a.addRequestProperty(str, str2);
    }

    public final boolean equals(Object obj) {
        return this.f39296a.equals(obj);
    }

    public final InputStream q() {
        r();
        try {
            this.f39297b.a(this.f39296a.getResponseCode());
        } catch (IOException unused) {
        }
        InputStream errorStream = this.f39296a.getErrorStream();
        return errorStream != null ? new b(errorStream, this.f39297b, this.f39300e) : errorStream;
    }

    public final String b(String str) {
        return this.f39296a.getRequestProperty(str);
    }

    public final int hashCode() {
        return this.f39296a.hashCode();
    }

    public final void a(boolean z) {
        this.f39296a.setAllowUserInteraction(z);
    }

    public final void c(int i2) {
        this.f39296a.setChunkedStreamingMode(i2);
    }

    public final void d(int i2) {
        this.f39296a.setConnectTimeout(i2);
    }

    public final void b(boolean z) {
        this.f39296a.setDefaultUseCaches(z);
    }

    public final void c(boolean z) {
        this.f39296a.setDoInput(z);
    }

    public final void d(boolean z) {
        this.f39296a.setDoOutput(z);
    }

    public final void e(int i2) {
        this.f39296a.setFixedLengthStreamingMode(i2);
    }

    public final void a(long j) {
        this.f39296a.setFixedLengthStreamingMode(j);
    }

    public final void b(long j) {
        this.f39296a.setIfModifiedSince(j);
    }

    public final void e(boolean z) {
        this.f39296a.setInstanceFollowRedirects(z);
    }

    public final void f(int i2) {
        this.f39296a.setReadTimeout(i2);
    }

    public final void c(String str) throws ProtocolException {
        this.f39296a.setRequestMethod(str);
    }

    public final void b(String str, String str2) {
        this.f39296a.setRequestProperty(str, str2);
    }

    public final void f(boolean z) {
        this.f39296a.setUseCaches(z);
    }

    public final String toString() {
        return this.f39296a.toString();
    }

    private final void r() {
        if (this.f39298c == -1) {
            this.f39300e.a();
            this.f39298c = this.f39300e.f9736a;
            this.f39297b.b(this.f39298c);
        }
        String requestMethod = this.f39296a.getRequestMethod();
        if (requestMethod != null) {
            this.f39297b.b(requestMethod);
        } else if (this.f39296a.getDoOutput()) {
            this.f39297b.b("POST");
        } else {
            this.f39297b.b(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD);
        }
    }
}
