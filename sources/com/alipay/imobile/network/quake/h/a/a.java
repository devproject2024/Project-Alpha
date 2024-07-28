package com.alipay.imobile.network.quake.h.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.imobile.network.quake.b.a;
import com.alipay.imobile.network.quake.e;
import com.alipay.imobile.network.quake.h.b;
import com.alipay.imobile.network.quake.h.c;
import com.alipay.imobile.network.quake.h.d;
import com.alipay.imobile.network.quake.i.b;
import com.alipay.imobile.network.quake.i.g;
import com.alipay.imobile.network.quake.m;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public abstract class a implements c {

    /* renamed from: h  reason: collision with root package name */
    private static final ExecutorService f14830h = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), g.c("Quake http ConnectionPool"));

    /* renamed from: a  reason: collision with root package name */
    protected final com.alipay.imobile.network.quake.h.b.a f14831a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f14832b;

    /* renamed from: c  reason: collision with root package name */
    private final c f14833c;

    /* renamed from: d  reason: collision with root package name */
    private final b f14834d;

    /* renamed from: e  reason: collision with root package name */
    private String f14835e;

    /* renamed from: f  reason: collision with root package name */
    private String f14836f;

    /* renamed from: g  reason: collision with root package name */
    private ExecutorService f14837g;

    /* renamed from: com.alipay.imobile.network.quake.h.a.a$a  reason: collision with other inner class name */
    class C0204a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        e f14838a;

        /* renamed from: b  reason: collision with root package name */
        d f14839b;

        /* renamed from: c  reason: collision with root package name */
        long f14840c;

        private C0204a(e eVar, d dVar, long j) {
            this.f14838a = eVar;
            this.f14839b = dVar;
            this.f14840c = j;
        }

        /* synthetic */ C0204a(a aVar, e eVar, d dVar, long j, byte b2) {
            this(eVar, dVar, j);
        }

        public final void run() {
            try {
                com.alipay.imobile.network.quake.b a2 = a.this.a(this.f14838a);
                String str = com.alipay.imobile.network.quake.c.f14737a;
                new StringBuilder("http:requestLifetime,").append(SystemClock.elapsedRealtime() - this.f14840c);
                com.alipay.iap.android.common.b.c.c();
                if (this.f14839b != null) {
                    this.f14839b.a(this.f14838a, a2);
                }
            } catch (com.alipay.mobile.b.b.a e2) {
                d dVar = this.f14839b;
                if (dVar != null) {
                    dVar.a(this.f14838a, e2);
                }
            }
            this.f14838a = null;
        }
    }

    public a() {
        this((byte) 0);
    }

    public static byte[] a(byte[] bArr) throws IOException {
        String str = com.alipay.imobile.network.quake.c.f14737a;
        com.alipay.iap.android.common.b.c.c();
        if (bArr.length < 160) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String str2 = com.alipay.imobile.network.quake.c.f14737a;
        StringBuilder sb = new StringBuilder("gzip size:");
        sb.append(bArr.length);
        sb.append("->");
        sb.append(byteArray.length);
        com.alipay.iap.android.common.b.c.c();
        return byteArray;
    }

    private String b(e eVar) {
        c cVar = this.f14833c;
        if (cVar == null || cVar == c.f14860a) {
            String str = com.alipay.imobile.network.quake.c.f14737a;
            com.alipay.iap.android.common.b.c.e();
            return null;
        }
        try {
            return a(this.f14833c.a(new URL(eVar.d())));
        } catch (MalformedURLException unused) {
            String str2 = com.alipay.imobile.network.quake.c.f14737a;
            com.alipay.iap.android.common.b.c.j();
            throw new com.alipay.imobile.network.quake.c.a((Integer) 9, "can not load cookie");
        }
    }

    /* access modifiers changed from: protected */
    public abstract f a(e eVar, Map<String, String> map) throws IOException, com.alipay.mobile.b.b.a;

    private a(byte b2) {
        b bVar;
        this.f14831a = new com.alipay.imobile.network.quake.h.b.a();
        m a2 = m.a();
        this.f14832b = a2.f14928b;
        com.alipay.imobile.network.quake.d dVar = a2.m;
        if (dVar != null) {
            this.f14833c = dVar.f14752i;
            bVar = dVar.j;
        } else {
            bVar = null;
            this.f14833c = null;
        }
        this.f14834d = bVar;
        this.f14837g = f14830h;
    }

    public void a(e eVar, d dVar) {
        if (!eVar.j) {
            this.f14837g.submit(new C0204a(this, eVar, dVar, SystemClock.elapsedRealtime(), (byte) 0));
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0208, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x020a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x020b, code lost:
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x020d, code lost:
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0214, code lost:
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0218, code lost:
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x021c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x021d, code lost:
        r26 = r4;
        r10 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0221, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0222, code lost:
        r26 = r4;
        r10 = r5;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x022c, code lost:
        r5 = r9.f14864a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0230, code lost:
        if (r5 == 301) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0237, code lost:
        r9 = com.alipay.imobile.network.quake.c.f14737a;
        com.alipay.iap.android.common.b.c.a("Unexpected response code %d for %s", java.lang.Integer.valueOf(r5), r36.d());
        com.alipay.iap.android.common.b.c.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0251, code lost:
        r9 = com.alipay.imobile.network.quake.c.f14737a;
        com.alipay.iap.android.common.b.c.a("Request at %s has been redirected to %s", r2.f14769a, r36.d());
        com.alipay.iap.android.common.b.c.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0268, code lost:
        r9 = r10.concat(java.lang.String.valueOf(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0270, code lost:
        if (r16 != null) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0274, code lost:
        if (r5 == 301) goto L_0x028a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x027b, code lost:
        r2 = com.alipay.imobile.network.quake.c.f14737a;
        com.alipay.iap.android.common.b.c.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0289, code lost:
        throw new com.alipay.imobile.network.quake.c.c((java.lang.Integer) 5000, (java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x028a, code lost:
        a("redirect", r2, (com.alipay.mobile.b.b.a) new com.alipay.imobile.network.quake.c.c((java.lang.Integer) 4, r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x029a, code lost:
        r2 = com.alipay.imobile.network.quake.c.f14737a;
        com.alipay.iap.android.common.b.c.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02a8, code lost:
        throw new com.alipay.imobile.network.quake.c.c((java.lang.Integer) 5000, (java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02a9, code lost:
        r2 = com.alipay.imobile.network.quake.c.f14737a;
        com.alipay.iap.android.common.b.c.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02b7, code lost:
        throw new com.alipay.imobile.network.quake.c.c((java.lang.Integer) 5000, (java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02c3, code lost:
        throw new com.alipay.imobile.network.quake.c.c((java.lang.Integer) 3, (java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02d1, code lost:
        throw new com.alipay.imobile.network.quake.c.c((java.lang.Integer) 3002, "Illegal url config");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02d2, code lost:
        r26 = r4;
        r10 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02d5, code lost:
        r0 = new com.alipay.imobile.network.quake.c.d(4, "connect time out");
        r4 = "connection";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02e4, code lost:
        r26 = r4;
        r10 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02e7, code lost:
        r0 = new com.alipay.imobile.network.quake.c.d(5, "socket time out");
        r4 = "socket";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02f5, code lost:
        a(r4, r2, (com.alipay.mobile.b.b.a) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01da, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01db, code lost:
        r16 = r5;
        r10 = r27;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException), PHI: r26 r27 
      PHI: (r26v11 java.lang.String) = (r26v12 java.lang.String), (r26v12 java.lang.String), (r26v12 java.lang.String), (r26v14 java.lang.String) binds: [B:80:0x0197, B:97:0x01f8, B:83:0x01a3, B:38:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r27v1 java.lang.String) = (r27v2 java.lang.String), (r27v2 java.lang.String), (r27v2 java.lang.String), (r27v4 java.lang.String) binds: [B:80:0x0197, B:97:0x01f8, B:83:0x01a3, B:38:0x00b7] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:38:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), PHI: r26 r27 
      PHI: (r26v10 java.lang.String) = (r26v12 java.lang.String), (r26v12 java.lang.String), (r26v12 java.lang.String), (r26v14 java.lang.String) binds: [B:80:0x0197, B:97:0x01f8, B:83:0x01a3, B:38:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r27v0 java.lang.String) = (r27v2 java.lang.String), (r27v2 java.lang.String), (r27v2 java.lang.String), (r27v4 java.lang.String) binds: [B:80:0x0197, B:97:0x01f8, B:83:0x01a3, B:38:0x00b7] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:38:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02b8 A[ExcHandler: SSLHandshakeException (r0v8 'e' javax.net.ssl.SSLHandshakeException A[CUSTOM_DECLARE]), Splitter:B:7:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[ExcHandler: MalformedURLException (unused java.net.MalformedURLException), SYNTHETIC, Splitter:B:7:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:146:? A[ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException), SYNTHETIC, Splitter:B:7:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:7:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02a9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0144 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e7 A[Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ef A[Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0107 A[Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0178 A[Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.alipay.imobile.network.quake.b a(com.alipay.imobile.network.quake.e r36) throws com.alipay.mobile.b.b.a {
        /*
            r35 = this;
            r1 = r35
            r2 = r36
            java.lang.String r3 = "Mgw-TraceId"
            java.lang.String r4 = "ts"
            java.lang.String r5 = "the status code from server is "
            android.content.Context r0 = r1.f14832b
            boolean r0 = com.alipay.imobile.network.quake.i.a.a(r0)
            r6 = 2
            if (r0 == 0) goto L_0x02fd
            com.alipay.imobile.network.quake.e$a r0 = r2.f14774f
            if (r0 == 0) goto L_0x001e
            com.alipay.imobile.network.quake.e$a r0 = r2.f14774f
            r0.a(r2)
        L_0x001e:
            long r7 = android.os.SystemClock.elapsedRealtime()
        L_0x0022:
            r15 = 1
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            r14.<init>()     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            android.content.Context r0 = r1.f14832b     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            com.alipay.imobile.network.quake.d.a.b r0 = com.alipay.imobile.network.quake.d.a.b.a((android.content.Context) r0)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            java.lang.String r0 = r0.a()     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            boolean r17 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            if (r17 != 0) goto L_0x003d
            java.lang.String r9 = "did"
            r2.a(r9, r0)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
        L_0x003d:
            android.content.Context r0 = r1.f14832b     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            com.alipay.iap.android.common.e.a r0 = com.alipay.iap.android.common.e.a.a(r0)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            if (r0 == 0) goto L_0x005a
            com.alipay.iap.android.common.e.a.a r9 = r0.f14693b     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            if (r9 != 0) goto L_0x0053
            java.lang.String r9 = com.alipay.iap.android.common.e.a.f14691a     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            com.alipay.iap.android.common.b.c.i()     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            goto L_0x005e
        L_0x0053:
            com.alipay.iap.android.common.e.a.a r9 = r0.f14693b     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            long r18 = r9.a()     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            goto L_0x005e
        L_0x005a:
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
        L_0x005e:
            java.lang.String r9 = java.lang.String.valueOf(r18)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            r14.append(r9)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            r2.a(r4, r9)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            r10.<init>()     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            r10.put(r4, r9)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            r1.a((java.util.Map<java.lang.String, java.lang.String>) r10, (com.alipay.imobile.network.quake.e) r2)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            com.alipay.imobile.network.quake.h.a.f r9 = r1.a((com.alipay.imobile.network.quake.e) r2, (java.util.Map<java.lang.String, java.lang.String>) r10)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0221 }
            int r10 = r9.f14864a     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x021c }
            com.alipay.imobile.network.quake.h.a.e r12 = r9.f14865b     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x021c }
            java.util.Map r12 = a((com.alipay.imobile.network.quake.h.a.e) r12)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x021c }
            java.lang.String r13 = "Server-Time"
            java.lang.Object r13 = r12.get(r13)     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x021c }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ SocketTimeoutException -> 0x02e4, ConnectTimeoutException -> 0x02d2, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x021c }
            if (r13 == 0) goto L_0x00d3
            java.lang.Long r19 = java.lang.Long.valueOf(r13)     // Catch:{ Exception -> 0x00b0 }
            r22 = r12
            long r11 = r19.longValue()     // Catch:{ Exception -> 0x00aa }
            if (r0 == 0) goto L_0x00a5
            long r19 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00aa }
            r26 = r4
            r27 = r5
            long r4 = r19 - r7
            r0.a(r4, r11)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00d9
        L_0x00a3:
            r0 = move-exception
            goto L_0x00b7
        L_0x00a5:
            r26 = r4
            r27 = r5
            goto L_0x00d9
        L_0x00aa:
            r0 = move-exception
            r26 = r4
            r27 = r5
            goto L_0x00b7
        L_0x00b0:
            r0 = move-exception
            r26 = r4
            r27 = r5
            r22 = r12
        L_0x00b7:
            java.lang.String r4 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.lang.String r5 = "get Server-Time error,time:"
            r4.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            r4.append(r13)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.lang.String r5 = ",error="
            r4.append(r5)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            r4.append(r0)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            com.alipay.iap.android.common.b.c.i()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            goto L_0x00d9
        L_0x00d3:
            r26 = r4
            r27 = r5
            r22 = r12
        L_0x00d9:
            r4 = r22
            java.lang.Object r0 = r4.get(r3)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            if (r5 == 0) goto L_0x00e9
            java.lang.String r0 = "-"
        L_0x00e9:
            boolean r5 = com.alipay.iap.android.common.b.c.a()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            if (r5 == 0) goto L_0x0100
            java.lang.String r5 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.lang.String r5 = "RPC ==> current rpc_trace_id: %1$s and sofa_id: %2$s"
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            r12 = 0
            r11[r12] = r14     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            r11[r15] = r0     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            com.alipay.iap.android.common.b.c.a(r5, r11)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            com.alipay.iap.android.common.b.c.c()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
        L_0x0100:
            r2.a(r3, r0)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            com.alipay.imobile.network.quake.h.a.c r0 = r1.f14833c     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            if (r0 == 0) goto L_0x013d
            com.alipay.imobile.network.quake.h.a.c r0 = r1.f14833c     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            com.alipay.imobile.network.quake.h.a.c r5 = com.alipay.imobile.network.quake.h.a.c.f14860a     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            if (r0 != r5) goto L_0x010e
            goto L_0x013d
        L_0x010e:
            if (r9 == 0) goto L_0x013a
            if (r2 != 0) goto L_0x0113
            goto L_0x013a
        L_0x0113:
            java.lang.String r0 = r36.d()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.net.URL r5 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            r5.<init>(r0)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.lang.String r0 = "Set-Cookie"
            com.alipay.imobile.network.quake.h.a.e r11 = r9.f14865b     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.util.List r0 = r11.a((java.lang.String) r0)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.util.List r0 = com.alipay.imobile.network.quake.h.a.b.a(r5, r0)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            boolean r11 = r0.isEmpty()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            if (r11 == 0) goto L_0x0134
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
        L_0x0130:
            com.alipay.iap.android.common.b.c.e()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            goto L_0x0140
        L_0x0134:
            com.alipay.imobile.network.quake.h.a.c r11 = r1.f14833c     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            r11.a(r5, r0)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            goto L_0x0140
        L_0x013a:
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            goto L_0x0130
        L_0x013d:
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            goto L_0x0130
        L_0x0140:
            r0 = 304(0x130, float:4.26E-43)
            if (r10 != r0) goto L_0x0178
            com.alipay.imobile.network.quake.b.a$a r0 = r2.n     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            if (r0 != 0) goto L_0x015e
            com.alipay.imobile.network.quake.b r0 = new com.alipay.imobile.network.quake.b     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            r20 = 304(0x130, float:4.26E-43)
            r21 = 0
            r23 = 1
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            long r24 = r10 - r7
            r19 = r0
            r22 = r4
            r19.<init>(r20, r21, r22, r23, r24)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            return r0
        L_0x015e:
            com.alipay.imobile.network.quake.b r4 = new com.alipay.imobile.network.quake.b     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            r29 = 304(0x130, float:4.26E-43)
            byte[] r5 = r0.f14718a     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.f14723f     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            r32 = 1
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            long r33 = r10 - r7
            r28 = r4
            r30 = r5
            r31 = r0
            r28.<init>(r29, r30, r31, r32, r33)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            return r4
        L_0x0178:
            r5 = 301(0x12d, float:4.22E-43)
            if (r10 == r5) goto L_0x0180
            r5 = 302(0x12e, float:4.23E-43)
            if (r10 != r5) goto L_0x018a
        L_0x0180:
            java.lang.String r0 = "Location"
            java.lang.Object r0 = r4.get(r0)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            r2.f14771c = r0     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
        L_0x018a:
            com.alipay.imobile.network.quake.h.a.g r0 = r9.f14866c     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            if (r0 == 0) goto L_0x0193
            byte[] r0 = r1.a((com.alipay.imobile.network.quake.h.a.g) r0)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
            goto L_0x0196
        L_0x0193:
            r5 = 0
            byte[] r0 = new byte[r5]     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0210 }
        L_0x0196:
            r5 = r0
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x020a }
            long r24 = r11 - r7
            boolean r0 = com.alipay.iap.android.common.b.c.a()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x020a }
            if (r0 == 0) goto L_0x01e0
            java.lang.String r0 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            java.lang.String r0 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [status=%d], [retryCount=%s]"
            r11 = 5
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            r11 = 0
            r12[r11] = r2     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            java.lang.Long r11 = java.lang.Long.valueOf(r24)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            r12[r15] = r11     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            if (r5 == 0) goto L_0x01bb
            int r11 = r5.length     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            goto L_0x01bd
        L_0x01bb:
            java.lang.String r11 = "null"
        L_0x01bd:
            r12[r6] = r11     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            r13 = 3
            r12[r13] = r11     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            com.alipay.imobile.network.quake.h.c.b r11 = r2.m     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            int r11 = r11.b()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            r13 = 4
            r12[r13] = r11     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            com.alipay.iap.android.common.b.c.a(r0, r12)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            com.alipay.iap.android.common.b.c.b()     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            goto L_0x01e0
        L_0x01da:
            r0 = move-exception
            r16 = r5
            r10 = r27
            goto L_0x0228
        L_0x01e0:
            r0 = 200(0xc8, float:2.8E-43)
            if (r10 < r0) goto L_0x01f8
            r0 = 299(0x12b, float:4.19E-43)
            if (r10 > r0) goto L_0x01f8
            com.alipay.imobile.network.quake.b r0 = new com.alipay.imobile.network.quake.b     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            r23 = 0
            r19 = r0
            r20 = r10
            r21 = r5
            r22 = r4
            r19.<init>(r20, r21, r22, r23, r24)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x01da }
            return r0
        L_0x01f8:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x020a }
            java.lang.String r4 = java.lang.String.valueOf(r10)     // Catch:{ SocketTimeoutException -> 0x0218, ConnectTimeoutException -> 0x0214, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x020a }
            r10 = r27
            java.lang.String r4 = r10.concat(r4)     // Catch:{ SocketTimeoutException -> 0x02e7, ConnectTimeoutException -> 0x02d5, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0208 }
            r0.<init>(r4)     // Catch:{ SocketTimeoutException -> 0x02e7, ConnectTimeoutException -> 0x02d5, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0208 }
            throw r0     // Catch:{ SocketTimeoutException -> 0x02e7, ConnectTimeoutException -> 0x02d5, MalformedURLException -> 0x02c4, SSLHandshakeException -> 0x02b8, IOException -> 0x0208 }
        L_0x0208:
            r0 = move-exception
            goto L_0x020d
        L_0x020a:
            r0 = move-exception
            r10 = r27
        L_0x020d:
            r16 = r5
            goto L_0x0228
        L_0x0210:
            r0 = move-exception
            r10 = r27
            goto L_0x0226
        L_0x0214:
            r10 = r27
            goto L_0x02d5
        L_0x0218:
            r10 = r27
            goto L_0x02e7
        L_0x021c:
            r0 = move-exception
            r26 = r4
            r10 = r5
            goto L_0x0226
        L_0x0221:
            r0 = move-exception
            r26 = r4
            r10 = r5
            r9 = 0
        L_0x0226:
            r16 = 0
        L_0x0228:
            r4 = 5000(0x1388, float:7.006E-42)
            if (r9 == 0) goto L_0x02a9
            int r5 = r9.f14864a
            r9 = 301(0x12d, float:4.22E-43)
            if (r5 == r9) goto L_0x0251
            r9 = 302(0x12e, float:4.23E-43)
            if (r5 != r9) goto L_0x0237
            goto L_0x0251
        L_0x0237:
            java.lang.String r9 = com.alipay.imobile.network.quake.c.f14737a
            java.lang.Object[] r9 = new java.lang.Object[r6]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
            r12 = 0
            r9[r12] = r11
            java.lang.String r11 = r36.d()
            r9[r15] = r11
            java.lang.String r11 = "Unexpected response code %d for %s"
            com.alipay.iap.android.common.b.c.a(r11, r9)
            com.alipay.iap.android.common.b.c.i()
            goto L_0x0268
        L_0x0251:
            r12 = 0
            java.lang.String r9 = com.alipay.imobile.network.quake.c.f14737a
            java.lang.Object[] r9 = new java.lang.Object[r6]
            java.lang.String r11 = r2.f14769a
            r9[r12] = r11
            java.lang.String r11 = r36.d()
            r9[r15] = r11
            java.lang.String r11 = "Request at %s has been redirected to %s"
            com.alipay.iap.android.common.b.c.a(r11, r9)
            com.alipay.iap.android.common.b.c.c()
        L_0x0268:
            java.lang.String r9 = java.lang.String.valueOf(r5)
            java.lang.String r9 = r10.concat(r9)
            if (r16 == 0) goto L_0x029a
            r11 = 301(0x12d, float:4.22E-43)
            if (r5 == r11) goto L_0x028a
            r11 = 302(0x12e, float:4.23E-43)
            if (r5 != r11) goto L_0x027b
            goto L_0x028a
        L_0x027b:
            java.lang.String r2 = com.alipay.imobile.network.quake.c.f14737a
            com.alipay.iap.android.common.b.c.f()
            com.alipay.imobile.network.quake.c.c r2 = new com.alipay.imobile.network.quake.c.c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r2.<init>((java.lang.Integer) r3, (java.lang.Throwable) r0)
            throw r2
        L_0x028a:
            com.alipay.imobile.network.quake.c.c r0 = new com.alipay.imobile.network.quake.c.c
            r4 = 4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0.<init>((java.lang.Integer) r4, (java.lang.String) r9)
            java.lang.String r4 = "redirect"
            a((java.lang.String) r4, (com.alipay.imobile.network.quake.e) r2, (com.alipay.mobile.b.b.a) r0)
            goto L_0x02f8
        L_0x029a:
            java.lang.String r2 = com.alipay.imobile.network.quake.c.f14737a
            com.alipay.iap.android.common.b.c.j()
            com.alipay.imobile.network.quake.c.c r2 = new com.alipay.imobile.network.quake.c.c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r2.<init>((java.lang.Integer) r3, (java.lang.Throwable) r0)
            throw r2
        L_0x02a9:
            java.lang.String r2 = com.alipay.imobile.network.quake.c.f14737a
            com.alipay.iap.android.common.b.c.j()
            com.alipay.imobile.network.quake.c.c r2 = new com.alipay.imobile.network.quake.c.c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r2.<init>((java.lang.Integer) r3, (java.lang.Throwable) r0)
            throw r2
        L_0x02b8:
            r0 = move-exception
            com.alipay.imobile.network.quake.c.c r2 = new com.alipay.imobile.network.quake.c.c
            r3 = 3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.<init>((java.lang.Integer) r3, (java.lang.Throwable) r0)
            throw r2
        L_0x02c4:
            com.alipay.imobile.network.quake.c.c r0 = new com.alipay.imobile.network.quake.c.c
            r2 = 3002(0xbba, float:4.207E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "Illegal url config"
            r0.<init>((java.lang.Integer) r2, (java.lang.String) r3)
            throw r0
        L_0x02d2:
            r26 = r4
            r10 = r5
        L_0x02d5:
            com.alipay.imobile.network.quake.c.d r0 = new com.alipay.imobile.network.quake.c.d
            r4 = 4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "connect time out"
            r0.<init>(r4, r5)
            java.lang.String r4 = "connection"
            goto L_0x02f5
        L_0x02e4:
            r26 = r4
            r10 = r5
        L_0x02e7:
            com.alipay.imobile.network.quake.c.d r0 = new com.alipay.imobile.network.quake.c.d
            r4 = 5
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "socket time out"
            r0.<init>(r4, r5)
            java.lang.String r4 = "socket"
        L_0x02f5:
            a((java.lang.String) r4, (com.alipay.imobile.network.quake.e) r2, (com.alipay.mobile.b.b.a) r0)
        L_0x02f8:
            r5 = r10
            r4 = r26
            goto L_0x0022
        L_0x02fd:
            com.alipay.imobile.network.quake.c.a r0 = new com.alipay.imobile.network.quake.c.a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.String r3 = "The network is not available"
            r0.<init>((java.lang.Integer) r2, (java.lang.String) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.h.a.a.a(com.alipay.imobile.network.quake.e):com.alipay.imobile.network.quake.b");
    }

    private static String a(List<b> list) {
        String str = com.alipay.imobile.network.quake.c.f14737a;
        com.alipay.iap.android.common.b.c.e();
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            b bVar = list.get(i2);
            sb.append(bVar.f14846a);
            sb.append('=');
            sb.append(bVar.f14847b);
        }
        return sb.toString();
    }

    private static Map<String, String> a(e eVar) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int length = eVar.f14862a.length / 2;
        for (int i2 = 0; i2 < length; i2++) {
            treeMap.put(eVar.a(i2), eVar.b(i2));
        }
        return treeMap;
    }

    private static void a(String str, e eVar, com.alipay.mobile.b.b.a aVar) throws com.alipay.mobile.b.b.a {
        com.alipay.imobile.network.quake.h.c.b bVar = eVar.m;
        int e2 = eVar.e();
        try {
            bVar.a(aVar);
            eVar.a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(e2)}));
        } catch (com.alipay.mobile.b.b.a e3) {
            eVar.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(e2)}));
            throw e3;
        }
    }

    private byte[] a(g gVar) throws IOException, com.alipay.mobile.b.b.a {
        com.alipay.imobile.network.quake.h.b.b bVar = new com.alipay.imobile.network.quake.h.b.b(this.f14831a, (int) gVar.f14876c);
        try {
            a(gVar.f14874a, gVar.f14875b, (OutputStream) bVar);
            return bVar.toByteArray();
        } finally {
            try {
                gVar.a();
            } catch (IOException unused) {
                String str = com.alipay.imobile.network.quake.c.f14737a;
                com.alipay.iap.android.common.b.c.j();
            }
            bVar.close();
        }
    }

    private long a(InputStream inputStream, String str, OutputStream outputStream) throws IOException, com.alipay.mobile.b.b.a {
        if (inputStream != null) {
            com.alipay.imobile.network.quake.h.b.c cVar = new com.alipay.imobile.network.quake.h.b.c(inputStream);
            InputStream gZIPInputStream = (TextUtils.isEmpty(str) || !str.contains("gzip")) ? cVar : new GZIPInputStream(cVar);
            long j = 0;
            try {
                byte[] a2 = this.f14831a.a((int) EmiUtil.EMI_PLAN_REQUEST_CODE);
                while (true) {
                    int read = gZIPInputStream.read(a2);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(a2, 0, read);
                    j += (long) read;
                }
                outputStream.flush();
                if (a2 != null) {
                    this.f14831a.a(a2);
                }
                try {
                    gZIPInputStream.close();
                } catch (IOException unused) {
                    String str2 = com.alipay.imobile.network.quake.c.f14737a;
                    com.alipay.iap.android.common.b.c.j();
                }
                return j;
            } catch (Exception e2) {
                String str3 = com.alipay.imobile.network.quake.c.f14737a;
                com.alipay.iap.android.common.b.c.j();
                IOException iOException = new IOException("http transport get data from entity error!");
                iOException.initCause(e2);
                throw iOException;
            } catch (Throwable th) {
                if (0 != 0) {
                    this.f14831a.a((byte[]) null);
                }
                try {
                    gZIPInputStream.close();
                } catch (IOException unused2) {
                    String str4 = com.alipay.imobile.network.quake.c.f14737a;
                    com.alipay.iap.android.common.b.c.j();
                }
                throw th;
            }
        } else {
            throw new com.alipay.imobile.network.quake.c.c((Integer) 6, "the content of the network response is null.");
        }
    }

    private void a(Map<String, String> map, e eVar) {
        map.putAll(eVar.b().b());
        map.put("Accept-Encoding", "gzip");
        map.put("Connection", "Keep-Alive");
        a.C0201a aVar = eVar.n;
        if (aVar != null) {
            if (aVar.f14719b != null) {
                map.put("If-None-Match", aVar.f14719b);
            }
            if (aVar.f14720c > 0) {
                map.put("If-Modified-Since", com.alipay.imobile.network.quake.h.a.a(new Date(aVar.f14720c)));
            }
        }
        String b2 = b(eVar);
        if (com.alipay.iap.android.common.b.c.a()) {
            String replace = b2.replace("%", "");
            String str = com.alipay.imobile.network.quake.c.f14737a;
            StringBuilder sb = new StringBuilder("add cookie=");
            sb.append(replace);
            sb.append(". url=");
            sb.append(eVar.d());
            com.alipay.iap.android.common.b.c.c();
        }
        if (!TextUtils.isEmpty(b2)) {
            map.put("Cookie", b2);
        }
        String a2 = g.a(this.f14832b);
        if (!TextUtils.isEmpty(a2)) {
            map.put("Accept-Language", a2);
        }
        if (eVar != null) {
            if (TextUtils.isEmpty(this.f14835e)) {
                this.f14835e = m.a().f14929c;
                this.f14836f = m.a().f14931e;
            }
            b.a aVar2 = null;
            if (eVar instanceof com.alipay.imobile.network.quake.g.e) {
                aVar2 = ((com.alipay.imobile.network.quake.g.e) eVar).v;
            }
            if (aVar2 == null) {
                aVar2 = new b.a(this.f14835e, this.f14836f);
            }
            String str2 = com.alipay.imobile.network.quake.c.f14737a;
            com.alipay.iap.android.common.b.c.b();
            String a3 = com.alipay.imobile.network.quake.i.b.a(eVar, this.f14832b, aVar2);
            if (!TextUtils.isEmpty(a3)) {
                map.put("sign", a3);
            }
        }
        if (g.b(this.f14832b)) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : map.entrySet()) {
                sb2.append((String) next.getKey());
                sb2.append(AppConstants.COLON);
                sb2.append((String) next.getValue());
                sb2.append(", ");
            }
            if (com.alipay.iap.android.common.b.c.a()) {
                String replace2 = sb2.toString().replace("%", "");
                String str3 = com.alipay.imobile.network.quake.c.f14737a;
                "Added request headers : ".concat(String.valueOf(replace2));
                com.alipay.iap.android.common.b.c.c();
            }
        }
    }
}
