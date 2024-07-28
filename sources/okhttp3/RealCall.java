package okhttp3;

import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.h5container.api.H5Event;
import i.a;
import i.w;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

final class RealCall implements Call {
    final OkHttpClient client;
    /* access modifiers changed from: private */
    public EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final a timeout = new a() {
        public void timedOut() {
            RealCall.this.cancel();
        }
    };

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z);
        this.timeout.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    public final Request request() {
        return this.originalRequest;
    }

    public final Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            this.client.dispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain != null) {
                this.client.dispatcher().finished(this);
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } catch (IOException e2) {
            IOException timeoutExit = timeoutExit(e2);
            this.eventListener.callFailed(this, timeoutExit);
            throw timeoutExit;
        } catch (Throwable th) {
            this.client.dispatcher().finished(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final IOException timeoutExit(IOException iOException) {
        if (!this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public final void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    public final void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    public final w timeout() {
        return this.timeout;
    }

    public final synchronized boolean isExecuted() {
        return this.executed;
    }

    public final boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    public final RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    /* access modifiers changed from: package-private */
    public final StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Callback responseCallback;

        static {
            Class<RealCall> cls = RealCall.class;
        }

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        /* access modifiers changed from: package-private */
        public final String host() {
            return RealCall.this.originalRequest.url().host();
        }

        /* access modifiers changed from: package-private */
        public final Request request() {
            return RealCall.this.originalRequest;
        }

        /* access modifiers changed from: package-private */
        public final RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: package-private */
        public final void executeOn(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e2) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e2);
                RealCall.this.eventListener.callFailed(RealCall.this, interruptedIOException);
                this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                RealCall.this.client.dispatcher().finished(this);
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0031 A[Catch:{ all -> 0x0024 }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x004e A[Catch:{ all -> 0x0024 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void execute() {
            /*
                r5 = this;
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                i.a r0 = r0.timeout
                r0.enter()
                r0 = 0
                okhttp3.RealCall r1 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x0026 }
                okhttp3.Response r0 = r1.getResponseWithInterceptorChain()     // Catch:{ IOException -> 0x0026 }
                r1 = 1
                okhttp3.Callback r2 = r5.responseCallback     // Catch:{ IOException -> 0x0022 }
                okhttp3.RealCall r3 = okhttp3.RealCall.this     // Catch:{ IOException -> 0x0022 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0022 }
            L_0x0016:
                okhttp3.RealCall r0 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r0 = r0.client
                okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.finished((okhttp3.RealCall.AsyncCall) r5)
                return
            L_0x0022:
                r0 = move-exception
                goto L_0x0029
            L_0x0024:
                r0 = move-exception
                goto L_0x0061
            L_0x0026:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x0029:
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x0024 }
                java.io.IOException r0 = r2.timeoutExit(r0)     // Catch:{ all -> 0x0024 }
                if (r1 == 0) goto L_0x004e
                okhttp3.internal.platform.Platform r1 = okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x0024 }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0024 }
                java.lang.String r4 = "Callback failure for "
                r3.<init>(r4)     // Catch:{ all -> 0x0024 }
                okhttp3.RealCall r4 = okhttp3.RealCall.this     // Catch:{ all -> 0x0024 }
                java.lang.String r4 = r4.toLoggableString()     // Catch:{ all -> 0x0024 }
                r3.append(r4)     // Catch:{ all -> 0x0024 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0024 }
                r1.log(r2, r3, r0)     // Catch:{ all -> 0x0024 }
                goto L_0x0016
            L_0x004e:
                okhttp3.RealCall r1 = okhttp3.RealCall.this     // Catch:{ all -> 0x0024 }
                okhttp3.EventListener r1 = r1.eventListener     // Catch:{ all -> 0x0024 }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x0024 }
                r1.callFailed(r2, r0)     // Catch:{ all -> 0x0024 }
                okhttp3.Callback r1 = r5.responseCallback     // Catch:{ all -> 0x0024 }
                okhttp3.RealCall r2 = okhttp3.RealCall.this     // Catch:{ all -> 0x0024 }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x0024 }
                goto L_0x0016
            L_0x0061:
                okhttp3.RealCall r1 = okhttp3.RealCall.this
                okhttp3.OkHttpClient r1 = r1.client
                okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.finished((okhttp3.RealCall.AsyncCall) r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.AsyncCall.execute():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : H5Event.TYPE_CALL);
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    /* access modifiers changed from: package-private */
    public final Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        Response proceed = new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
        if (!this.retryAndFollowUpInterceptor.isCanceled()) {
            return proceed;
        }
        Util.closeQuietly((Closeable) proceed);
        throw new IOException("Canceled");
    }
}
