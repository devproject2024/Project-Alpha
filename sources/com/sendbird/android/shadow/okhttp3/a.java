package com.sendbird.android.shadow.okhttp3;

import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.sendbird.android.shadow.okhttp3.internal.NamedRunnable;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.cache.CacheInterceptor;
import com.sendbird.android.shadow.okhttp3.internal.connection.ConnectInterceptor;
import com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import com.sendbird.android.shadow.okhttp3.internal.http.BridgeInterceptor;
import com.sendbird.android.shadow.okhttp3.internal.http.CallServerInterceptor;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpCodec;
import com.sendbird.android.shadow.okhttp3.internal.http.RealInterceptorChain;
import com.sendbird.android.shadow.okhttp3.internal.http.RetryAndFollowUpInterceptor;
import com.sendbird.android.shadow.okhttp3.internal.platform.Platform;
import com.sendbird.android.shadow.okio.AsyncTimeout;
import com.sendbird.android.shadow.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

final class a implements Call {

    /* renamed from: a  reason: collision with root package name */
    final OkHttpClient f45039a;

    /* renamed from: b  reason: collision with root package name */
    final RetryAndFollowUpInterceptor f45040b;

    /* renamed from: c  reason: collision with root package name */
    final AsyncTimeout f45041c = new AsyncTimeout() {
        public final void timedOut() {
            a.this.cancel();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    final Request f45042d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f45043e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EventListener f45044f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45045g;

    private a(OkHttpClient okHttpClient, Request request, boolean z) {
        this.f45039a = okHttpClient;
        this.f45042d = request;
        this.f45043e = z;
        this.f45040b = new RetryAndFollowUpInterceptor(okHttpClient, z);
        this.f45041c.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    static a a(OkHttpClient okHttpClient, Request request, boolean z) {
        a aVar = new a(okHttpClient, request, z);
        aVar.f45044f = okHttpClient.eventListenerFactory().create(aVar);
        return aVar;
    }

    public final Request request() {
        return this.f45042d;
    }

    public final Response execute() throws IOException {
        synchronized (this) {
            if (!this.f45045g) {
                this.f45045g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        c();
        this.f45041c.enter();
        this.f45044f.callStart(this);
        try {
            this.f45039a.dispatcher().executed(this);
            Response b2 = b();
            if (b2 != null) {
                this.f45039a.dispatcher().finished(this);
                return b2;
            }
            throw new IOException("Canceled");
        } catch (IOException e2) {
            IOException a2 = a(e2);
            this.f45044f.callFailed(this, a2);
            throw a2;
        } catch (Throwable th) {
            this.f45039a.dispatcher().finished(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException a(IOException iOException) {
        if (!this.f45041c.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private void c() {
        this.f45040b.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public final void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.f45045g) {
                this.f45045g = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        c();
        this.f45044f.callStart(this);
        this.f45039a.dispatcher().enqueue(new C0757a(callback));
    }

    public final void cancel() {
        this.f45040b.cancel();
    }

    public final Timeout timeout() {
        return this.f45041c;
    }

    public final synchronized boolean isExecuted() {
        return this.f45045g;
    }

    public final boolean isCanceled() {
        return this.f45040b.isCanceled();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public a clone() {
        return a(this.f45039a, this.f45042d, this.f45043e);
    }

    /* renamed from: com.sendbird.android.shadow.okhttp3.a$a  reason: collision with other inner class name */
    final class C0757a extends NamedRunnable {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ boolean f45047b = (!a.class.desiredAssertionStatus());

        /* renamed from: a  reason: collision with root package name */
        final Callback f45048a;

        C0757a(Callback callback) {
            super("OkHttp %s", a.this.a());
            this.f45048a = callback;
        }

        /* access modifiers changed from: package-private */
        public final String a() {
            return a.this.f45042d.url().host();
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0030 A[Catch:{ IOException -> 0x0047, all -> 0x0026, all -> 0x00b0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0052 A[Catch:{ IOException -> 0x0047, all -> 0x0026, all -> 0x00b0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x009c A[Catch:{ IOException -> 0x0047, all -> 0x0026, all -> 0x00b0 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void execute() {
            /*
                r7 = this;
                com.sendbird.android.shadow.okhttp3.a r0 = com.sendbird.android.shadow.okhttp3.a.this
                com.sendbird.android.shadow.okio.AsyncTimeout r0 = r0.f45041c
                r0.enter()
                r0 = 0
                com.sendbird.android.shadow.okhttp3.a r1 = com.sendbird.android.shadow.okhttp3.a.this     // Catch:{ IOException -> 0x0047, all -> 0x0026 }
                com.sendbird.android.shadow.okhttp3.Response r0 = r1.b()     // Catch:{ IOException -> 0x0047, all -> 0x0026 }
                r1 = 1
                com.sendbird.android.shadow.okhttp3.Callback r2 = r7.f45048a     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
                com.sendbird.android.shadow.okhttp3.a r3 = com.sendbird.android.shadow.okhttp3.a.this     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            L_0x0016:
                com.sendbird.android.shadow.okhttp3.a r0 = com.sendbird.android.shadow.okhttp3.a.this
                com.sendbird.android.shadow.okhttp3.OkHttpClient r0 = r0.f45039a
                com.sendbird.android.shadow.okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.finished((com.sendbird.android.shadow.okhttp3.a.C0757a) r7)
                return
            L_0x0022:
                r0 = move-exception
                goto L_0x0029
            L_0x0024:
                r0 = move-exception
                goto L_0x004a
            L_0x0026:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x0029:
                com.sendbird.android.shadow.okhttp3.a r2 = com.sendbird.android.shadow.okhttp3.a.this     // Catch:{ all -> 0x00b0 }
                r2.cancel()     // Catch:{ all -> 0x00b0 }
                if (r1 != 0) goto L_0x0046
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00b0 }
                java.lang.String r2 = "canceled due to "
                java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00b0 }
                java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x00b0 }
                r1.<init>(r2)     // Catch:{ all -> 0x00b0 }
                com.sendbird.android.shadow.okhttp3.Callback r2 = r7.f45048a     // Catch:{ all -> 0x00b0 }
                com.sendbird.android.shadow.okhttp3.a r3 = com.sendbird.android.shadow.okhttp3.a.this     // Catch:{ all -> 0x00b0 }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x00b0 }
            L_0x0046:
                throw r0     // Catch:{ all -> 0x00b0 }
            L_0x0047:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x004a:
                com.sendbird.android.shadow.okhttp3.a r2 = com.sendbird.android.shadow.okhttp3.a.this     // Catch:{ all -> 0x00b0 }
                java.io.IOException r0 = r2.a((java.io.IOException) r0)     // Catch:{ all -> 0x00b0 }
                if (r1 == 0) goto L_0x009c
                com.sendbird.android.shadow.okhttp3.internal.platform.Platform r1 = com.sendbird.android.shadow.okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x00b0 }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
                java.lang.String r4 = "Callback failure for "
                r3.<init>(r4)     // Catch:{ all -> 0x00b0 }
                com.sendbird.android.shadow.okhttp3.a r4 = com.sendbird.android.shadow.okhttp3.a.this     // Catch:{ all -> 0x00b0 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
                r5.<init>()     // Catch:{ all -> 0x00b0 }
                boolean r6 = r4.isCanceled()     // Catch:{ all -> 0x00b0 }
                if (r6 == 0) goto L_0x006e
                java.lang.String r6 = "canceled "
                goto L_0x0070
            L_0x006e:
                java.lang.String r6 = ""
            L_0x0070:
                r5.append(r6)     // Catch:{ all -> 0x00b0 }
                boolean r6 = r4.f45043e     // Catch:{ all -> 0x00b0 }
                if (r6 == 0) goto L_0x007b
                java.lang.String r6 = "web socket"
                goto L_0x007d
            L_0x007b:
                java.lang.String r6 = "call"
            L_0x007d:
                r5.append(r6)     // Catch:{ all -> 0x00b0 }
                java.lang.String r6 = " to "
                r5.append(r6)     // Catch:{ all -> 0x00b0 }
                java.lang.String r4 = r4.a()     // Catch:{ all -> 0x00b0 }
                r5.append(r4)     // Catch:{ all -> 0x00b0 }
                java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x00b0 }
                r3.append(r4)     // Catch:{ all -> 0x00b0 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b0 }
                r1.log(r2, r3, r0)     // Catch:{ all -> 0x00b0 }
                goto L_0x0016
            L_0x009c:
                com.sendbird.android.shadow.okhttp3.a r1 = com.sendbird.android.shadow.okhttp3.a.this     // Catch:{ all -> 0x00b0 }
                com.sendbird.android.shadow.okhttp3.EventListener r1 = r1.f45044f     // Catch:{ all -> 0x00b0 }
                com.sendbird.android.shadow.okhttp3.a r2 = com.sendbird.android.shadow.okhttp3.a.this     // Catch:{ all -> 0x00b0 }
                r1.callFailed(r2, r0)     // Catch:{ all -> 0x00b0 }
                com.sendbird.android.shadow.okhttp3.Callback r1 = r7.f45048a     // Catch:{ all -> 0x00b0 }
                com.sendbird.android.shadow.okhttp3.a r2 = com.sendbird.android.shadow.okhttp3.a.this     // Catch:{ all -> 0x00b0 }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x00b0 }
                goto L_0x0016
            L_0x00b0:
                r0 = move-exception
                com.sendbird.android.shadow.okhttp3.a r1 = com.sendbird.android.shadow.okhttp3.a.this
                com.sendbird.android.shadow.okhttp3.OkHttpClient r1 = r1.f45039a
                com.sendbird.android.shadow.okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.finished((com.sendbird.android.shadow.okhttp3.a.C0757a) r7)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.a.C0757a.execute():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f45042d.url().redact();
    }

    /* access modifiers changed from: package-private */
    public final Response b() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f45039a.interceptors());
        arrayList.add(this.f45040b);
        arrayList.add(new BridgeInterceptor(this.f45039a.cookieJar()));
        arrayList.add(new CacheInterceptor(this.f45039a.internalCache()));
        arrayList.add(new ConnectInterceptor(this.f45039a));
        if (!this.f45043e) {
            arrayList.addAll(this.f45039a.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.f45043e));
        Response proceed = new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.f45042d, this, this.f45044f, this.f45039a.connectTimeoutMillis(), this.f45039a.readTimeoutMillis(), this.f45039a.writeTimeoutMillis()).proceed(this.f45042d);
        if (!this.f45040b.isCanceled()) {
            return proceed;
        }
        Util.closeQuietly((Closeable) proceed);
        throw new IOException("Canceled");
    }
}
