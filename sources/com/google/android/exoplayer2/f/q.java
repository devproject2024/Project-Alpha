package com.google.android.exoplayer2.f;

import android.net.Uri;
import com.google.android.exoplayer2.f.v;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class q extends e implements v {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f32441b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReference<byte[]> f32442c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32443d;

    /* renamed from: e  reason: collision with root package name */
    private final int f32444e;

    /* renamed from: f  reason: collision with root package name */
    private final int f32445f;

    /* renamed from: g  reason: collision with root package name */
    private final String f32446g;

    /* renamed from: h  reason: collision with root package name */
    private final t<String> f32447h = null;

    /* renamed from: i  reason: collision with root package name */
    private final v.f f32448i;
    private final v.f j = new v.f();
    private l k;
    private HttpURLConnection l;
    private InputStream m;
    private boolean n;
    private int o;
    private long p;
    private long q;
    private long r;
    private long s;

    public q(String str, int i2, int i3, boolean z, v.f fVar) {
        super(true);
        this.f32446g = a.a(str);
        this.f32444e = i2;
        this.f32445f = i3;
        this.f32443d = z;
        this.f32448i = fVar;
    }

    public final Uri a() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final Map<String, List<String>> b() {
        HttpURLConnection httpURLConnection = this.l;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    public final long a(l lVar) throws v.c {
        long j2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection a2;
        l lVar2 = lVar;
        this.k = lVar2;
        this.s = 0;
        this.r = 0;
        d();
        try {
            URL url = new URL(lVar2.f32395a.toString());
            int i2 = lVar2.f32396b;
            byte[] bArr = lVar2.f32397c;
            long j3 = lVar2.f32400f;
            long j4 = lVar2.f32401g;
            boolean a3 = lVar2.a(1);
            boolean a4 = lVar2.a(2);
            if (!this.f32443d) {
                j2 = 0;
                httpURLConnection = a(url, i2, bArr, j3, j4, a3, a4, true);
            } else {
                long j5 = j4;
                j2 = 0;
                URL url2 = url;
                int i3 = i2;
                byte[] bArr2 = bArr;
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 <= 20) {
                        long j6 = j3;
                        int i6 = i3;
                        boolean z = a3;
                        URL url3 = url2;
                        a2 = a(url2, i3, bArr2, j3, j5, a3, a4, false);
                        int responseCode = a2.getResponseCode();
                        String headerField = a2.getHeaderField("Location");
                        if (i6 != 1) {
                            if (i6 == 3) {
                            }
                            if (i6 != 2 || !(responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303)) {
                                httpURLConnection = a2;
                            } else {
                                a2.disconnect();
                                bArr2 = null;
                                url2 = a(url3, headerField);
                                i4 = i5;
                                j3 = j6;
                                a3 = z;
                                i3 = 1;
                            }
                        }
                        if (!(responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307)) {
                            if (responseCode == 308) {
                            }
                            if (i6 != 2) {
                                break;
                            }
                            break;
                        }
                        a2.disconnect();
                        url2 = a(url3, headerField);
                        i3 = i6;
                        i4 = i5;
                        j3 = j6;
                        a3 = z;
                    } else {
                        throw new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i5)));
                    }
                }
                httpURLConnection = a2;
            }
            this.l = httpURLConnection;
            try {
                this.o = this.l.getResponseCode();
                String responseMessage = this.l.getResponseMessage();
                int i7 = this.o;
                if (i7 < 200 || i7 > 299) {
                    Map headerFields = this.l.getHeaderFields();
                    f();
                    v.e eVar = new v.e(this.o, responseMessage, headerFields, lVar2);
                    if (this.o == 416) {
                        eVar.initCause(new j(0));
                    }
                    throw eVar;
                }
                String contentType = this.l.getContentType();
                t<String> tVar = this.f32447h;
                if (tVar == null || tVar.evaluate(contentType)) {
                    this.p = (this.o != 200 || lVar2.f32400f == j2) ? j2 : lVar2.f32400f;
                    if (!lVar2.a(1)) {
                        long j7 = -1;
                        if (lVar2.f32401g != -1) {
                            this.q = lVar2.f32401g;
                        } else {
                            long a5 = a(this.l);
                            if (a5 != -1) {
                                j7 = a5 - this.p;
                            }
                            this.q = j7;
                        }
                    } else {
                        this.q = lVar2.f32401g;
                    }
                    try {
                        this.m = this.l.getInputStream();
                        this.n = true;
                        b(lVar);
                        return this.q;
                    } catch (IOException e2) {
                        f();
                        throw new v.c(e2, lVar2, 1);
                    }
                } else {
                    f();
                    throw new v.d(contentType, lVar2);
                }
            } catch (IOException e3) {
                f();
                throw new v.c("Unable to connect to " + lVar2.f32395a.toString(), e3, lVar2, 1);
            }
        } catch (IOException e4) {
            throw new v.c("Unable to connect to " + lVar2.f32395a.toString(), e4, lVar2, 1);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(1:19)|21|(1:25))|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r3 > 2048) goto L_0x003a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() throws com.google.android.exoplayer2.f.v.c {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.m     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007c
            java.net.HttpURLConnection r2 = r9.l     // Catch:{ all -> 0x008b }
            long r3 = r9.q     // Catch:{ all -> 0x008b }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0013
            long r3 = r9.q     // Catch:{ all -> 0x008b }
            goto L_0x0018
        L_0x0013:
            long r3 = r9.q     // Catch:{ all -> 0x008b }
            long r7 = r9.s     // Catch:{ all -> 0x008b }
            long r3 = r3 - r7
        L_0x0018:
            int r7 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ all -> 0x008b }
            r8 = 19
            if (r7 == r8) goto L_0x0024
            int r7 = com.google.android.exoplayer2.g.ae.f32499a     // Catch:{ all -> 0x008b }
            r8 = 20
            if (r7 != r8) goto L_0x006c
        L_0x0024:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x006c }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0034
            int r3 = r2.read()     // Catch:{ Exception -> 0x006c }
            r4 = -1
            if (r3 != r4) goto L_0x003a
            goto L_0x006c
        L_0x0034:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x006c
        L_0x003a:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006c }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x006c }
            if (r4 != 0) goto L_0x0052
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r4.equals(r3)     // Catch:{ Exception -> 0x006c }
            if (r3 == 0) goto L_0x006c
        L_0x0052:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006c }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006c }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x006c }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x006c }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006c }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x006c }
        L_0x006c:
            java.io.InputStream r2 = r9.m     // Catch:{ IOException -> 0x0072 }
            r2.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x007c
        L_0x0072:
            r2 = move-exception
            com.google.android.exoplayer2.f.v$c r3 = new com.google.android.exoplayer2.f.v$c     // Catch:{ all -> 0x008b }
            com.google.android.exoplayer2.f.l r4 = r9.k     // Catch:{ all -> 0x008b }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.exoplayer2.f.l) r4, (int) r5)     // Catch:{ all -> 0x008b }
            throw r3     // Catch:{ all -> 0x008b }
        L_0x007c:
            r9.m = r0
            r9.f()
            boolean r0 = r9.n
            if (r0 == 0) goto L_0x008a
            r9.n = r1
            r9.e()
        L_0x008a:
            return
        L_0x008b:
            r2 = move-exception
            r9.m = r0
            r9.f()
            boolean r0 = r9.n
            if (r0 == 0) goto L_0x009a
            r9.n = r1
            r9.e()
        L_0x009a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.q.c():void");
    }

    private HttpURLConnection a(URL url, int i2, byte[] bArr, long j2, long j3, boolean z, boolean z2, boolean z3) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f32444e);
        httpURLConnection.setReadTimeout(this.f32445f);
        v.f fVar = this.f32448i;
        if (fVar != null) {
            for (Map.Entry next : fVar.a().entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        for (Map.Entry next2 : this.j.a().entrySet()) {
            httpURLConnection.setRequestProperty((String) next2.getKey(), (String) next2.getValue());
        }
        if (!(j2 == 0 && j3 == -1)) {
            String str = "bytes=" + j2 + "-";
            if (j3 != -1) {
                str = str + ((j2 + j3) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f32446g);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        if (z2) {
            httpURLConnection.setRequestProperty("Icy-MetaData", "1");
        }
        httpURLConnection.setInstanceFollowRedirects(z3);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(l.b(i2));
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private static URL a(URL url, String str) throws IOException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if ("https".equals(protocol) || "http".equals(protocol)) {
                return url2;
            }
            throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
        }
        throw new ProtocolException("Null location redirect");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long a(java.net.HttpURLConnection r9) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r9.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            if (r1 != 0) goto L_0x0023
            long r3 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0013 }
            goto L_0x0025
        L_0x0013:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected Content-Length ["
            r1.<init>(r3)
            r1.append(r0)
            r1.append(r2)
            com.google.android.exoplayer2.g.l.d()
        L_0x0023:
            r3 = -1
        L_0x0025:
            java.lang.String r1 = "Content-Range"
            java.lang.String r9 = r9.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto L_0x008d
            java.util.regex.Pattern r1 = f32441b
            java.util.regex.Matcher r1 = r1.matcher(r9)
            boolean r5 = r1.find()
            if (r5 == 0) goto L_0x008d
            r5 = 2
            java.lang.String r5 = r1.group(r5)     // Catch:{ NumberFormatException -> 0x007d }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x007d }
            r7 = 1
            java.lang.String r1 = r1.group(r7)     // Catch:{ NumberFormatException -> 0x007d }
            long r7 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x007d }
            long r5 = r5 - r7
            r7 = 1
            long r5 = r5 + r7
            r7 = 0
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x005b
            r3 = r5
            goto L_0x008d
        L_0x005b:
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x008d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x007d }
            java.lang.String r7 = "Inconsistent headers ["
            r1.<init>(r7)     // Catch:{ NumberFormatException -> 0x007d }
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x007d }
            java.lang.String r0 = "] ["
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x007d }
            r1.append(r9)     // Catch:{ NumberFormatException -> 0x007d }
            r1.append(r2)     // Catch:{ NumberFormatException -> 0x007d }
            com.google.android.exoplayer2.g.l.c()     // Catch:{ NumberFormatException -> 0x007d }
            long r0 = java.lang.Math.max(r3, r5)     // Catch:{ NumberFormatException -> 0x007d }
            r3 = r0
            goto L_0x008d
        L_0x007d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected Content-Range ["
            r0.<init>(r1)
            r0.append(r9)
            r0.append(r2)
            com.google.android.exoplayer2.g.l.d()
        L_0x008d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.q.a(java.net.HttpURLConnection):long");
    }

    private void f() {
        HttpURLConnection httpURLConnection = this.l;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                l.b("Unexpected error while disconnecting", e2);
            }
            this.l = null;
        }
    }

    public final int a(byte[] bArr, int i2, int i3) throws v.c {
        try {
            if (this.r != this.p) {
                byte[] andSet = f32442c.getAndSet((Object) null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.r != this.p) {
                    int read = this.m.read(andSet, 0, (int) Math.min(this.p - this.r, (long) andSet.length));
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.r += (long) read;
                        a(read);
                    } else {
                        throw new EOFException();
                    }
                }
                f32442c.set(andSet);
            }
            if (i3 == 0) {
                return 0;
            }
            if (this.q != -1) {
                long j2 = this.q - this.s;
                if (j2 == 0) {
                    return -1;
                }
                i3 = (int) Math.min((long) i3, j2);
            }
            int read2 = this.m.read(bArr, i2, i3);
            if (read2 != -1) {
                this.s += (long) read2;
                a(read2);
                return read2;
            } else if (this.q == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e2) {
            throw new v.c(e2, this.k, 2);
        }
    }
}
