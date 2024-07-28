package com.squareup.okhttp;

import com.alipay.mobile.h5container.api.H5Event;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RetryableSink;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.RouteSelector;
import i.u;
import java.io.IOException;
import java.net.ProtocolException;

public class Call {
    volatile boolean canceled;
    /* access modifiers changed from: private */
    public final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    protected Call(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient.copyWithDefaults();
        this.originalRequest = request;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        try {
            this.client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain(false);
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.getDispatcher().finished(this);
        }
    }

    /* access modifiers changed from: package-private */
    public Object tag() {
        return this.originalRequest.tag();
    }

    public void enqueue(Callback callback) {
        enqueue(callback, false);
    }

    /* access modifiers changed from: package-private */
    public void enqueue(Callback callback, boolean z) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.client.getDispatcher().enqueue(new AsyncCall(callback, z));
    }

    public void cancel() {
        this.canceled = true;
        HttpEngine httpEngine = this.engine;
        if (httpEngine != null) {
            httpEngine.disconnect();
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        private AsyncCall(Callback callback, boolean z) {
            super("OkHttp %s", Call.this.originalRequest.urlString());
            this.responseCallback = callback;
            this.forWebSocket = z;
        }

        /* access modifiers changed from: package-private */
        public final String host() {
            return Call.this.originalRequest.httpUrl().host();
        }

        /* access modifiers changed from: package-private */
        public final Request request() {
            return Call.this.originalRequest;
        }

        /* access modifiers changed from: package-private */
        public final Object tag() {
            return Call.this.originalRequest.tag();
        }

        /* access modifiers changed from: package-private */
        public final void cancel() {
            Call.this.cancel();
        }

        /* access modifiers changed from: package-private */
        public final Call get() {
            return Call.this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[SYNTHETIC, Splitter:B:14:0x003d] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0059 A[Catch:{ all -> 0x0036 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void execute() {
            /*
                r5 = this;
                r0 = 1
                r1 = 0
                com.squareup.okhttp.Call r2 = com.squareup.okhttp.Call.this     // Catch:{ IOException -> 0x0038 }
                boolean r3 = r5.forWebSocket     // Catch:{ IOException -> 0x0038 }
                com.squareup.okhttp.Response r2 = r2.getResponseWithInterceptorChain(r3)     // Catch:{ IOException -> 0x0038 }
                com.squareup.okhttp.Call r3 = com.squareup.okhttp.Call.this     // Catch:{ IOException -> 0x0038 }
                boolean r1 = r3.canceled     // Catch:{ IOException -> 0x0038 }
                if (r1 == 0) goto L_0x0021
                com.squareup.okhttp.Callback r1 = r5.responseCallback     // Catch:{ IOException -> 0x0034 }
                com.squareup.okhttp.Call r2 = com.squareup.okhttp.Call.this     // Catch:{ IOException -> 0x0034 }
                com.squareup.okhttp.Request r2 = r2.originalRequest     // Catch:{ IOException -> 0x0034 }
                java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0034 }
                java.lang.String r4 = "Canceled"
                r3.<init>(r4)     // Catch:{ IOException -> 0x0034 }
                r1.onFailure(r2, r3)     // Catch:{ IOException -> 0x0034 }
                goto L_0x0026
            L_0x0021:
                com.squareup.okhttp.Callback r1 = r5.responseCallback     // Catch:{ IOException -> 0x0034 }
                r1.onResponse(r2)     // Catch:{ IOException -> 0x0034 }
            L_0x0026:
                com.squareup.okhttp.Call r0 = com.squareup.okhttp.Call.this
                com.squareup.okhttp.OkHttpClient r0 = r0.client
                com.squareup.okhttp.Dispatcher r0 = r0.getDispatcher()
                r0.finished((com.squareup.okhttp.Call.AsyncCall) r5)
                return
            L_0x0034:
                r1 = move-exception
                goto L_0x003b
            L_0x0036:
                r0 = move-exception
                goto L_0x0067
            L_0x0038:
                r0 = move-exception
                r1 = r0
                r0 = 0
            L_0x003b:
                if (r0 == 0) goto L_0x0059
                java.util.logging.Logger r0 = com.squareup.okhttp.internal.Internal.logger     // Catch:{ all -> 0x0036 }
                java.util.logging.Level r2 = java.util.logging.Level.INFO     // Catch:{ all -> 0x0036 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
                java.lang.String r4 = "Callback failure for "
                r3.<init>(r4)     // Catch:{ all -> 0x0036 }
                com.squareup.okhttp.Call r4 = com.squareup.okhttp.Call.this     // Catch:{ all -> 0x0036 }
                java.lang.String r4 = r4.toLoggableString()     // Catch:{ all -> 0x0036 }
                r3.append(r4)     // Catch:{ all -> 0x0036 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0036 }
                r0.log(r2, r3, r1)     // Catch:{ all -> 0x0036 }
                goto L_0x0026
            L_0x0059:
                com.squareup.okhttp.Callback r0 = r5.responseCallback     // Catch:{ all -> 0x0036 }
                com.squareup.okhttp.Call r2 = com.squareup.okhttp.Call.this     // Catch:{ all -> 0x0036 }
                com.squareup.okhttp.internal.http.HttpEngine r2 = r2.engine     // Catch:{ all -> 0x0036 }
                com.squareup.okhttp.Request r2 = r2.getRequest()     // Catch:{ all -> 0x0036 }
                r0.onFailure(r2, r1)     // Catch:{ all -> 0x0036 }
                goto L_0x0026
            L_0x0067:
                com.squareup.okhttp.Call r1 = com.squareup.okhttp.Call.this
                com.squareup.okhttp.OkHttpClient r1 = r1.client
                com.squareup.okhttp.Dispatcher r1 = r1.getDispatcher()
                r1.finished((com.squareup.okhttp.Call.AsyncCall) r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.Call.AsyncCall.execute():void");
        }
    }

    /* access modifiers changed from: private */
    public String toLoggableString() {
        String str = this.canceled ? "canceled call" : H5Event.TYPE_CALL;
        HttpUrl resolve = this.originalRequest.httpUrl().resolve("/...");
        return str + " to " + resolve;
    }

    /* access modifiers changed from: private */
    public Response getResponseWithInterceptorChain(boolean z) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, z).proceed(this.originalRequest);
    }

    class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        public Connection connection() {
            return null;
        }

        ApplicationInterceptorChain(int i2, Request request2, boolean z) {
            this.index = i2;
            this.request = request2;
            this.forWebSocket = z;
        }

        public Request request() {
            return this.request;
        }

        public Response proceed(Request request2) throws IOException {
            if (this.index >= Call.this.client.interceptors().size()) {
                return Call.this.getResponse(request2, this.forWebSocket);
            }
            return Call.this.client.interceptors().get(this.index).intercept(new ApplicationInterceptorChain(this.index + 1, request2, this.forWebSocket));
        }
    }

    /* access modifiers changed from: package-private */
    public Response getResponse(Request request, boolean z) throws IOException {
        RequestBody body = request.body();
        if (body != null) {
            Request.Builder newBuilder = request.newBuilder();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header("Content-Length", Long.toString(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", "chunked");
                newBuilder.removeHeader("Content-Length");
            }
            request = newBuilder.build();
        }
        this.engine = new HttpEngine(this.client, request, false, false, z, (Connection) null, (RouteSelector) null, (RetryableSink) null, (Response) null);
        int i2 = 0;
        while (!this.canceled) {
            try {
                this.engine.sendRequest();
                this.engine.readResponse();
                Response response = this.engine.getResponse();
                Request followUpRequest = this.engine.followUpRequest();
                if (followUpRequest == null) {
                    if (!z) {
                        this.engine.releaseConnection();
                    }
                    return response;
                }
                i2++;
                if (i2 <= 20) {
                    if (!this.engine.sameConnection(followUpRequest.httpUrl())) {
                        this.engine.releaseConnection();
                    }
                    this.engine = new HttpEngine(this.client, followUpRequest, false, false, z, this.engine.close(), (RouteSelector) null, (RetryableSink) null, response);
                } else {
                    throw new ProtocolException("Too many follow-up requests: ".concat(String.valueOf(i2)));
                }
            } catch (RequestException e2) {
                throw e2.getCause();
            } catch (RouteException e3) {
                HttpEngine recover = this.engine.recover(e3);
                if (recover != null) {
                    this.engine = recover;
                } else {
                    throw e3.getLastConnectException();
                }
            } catch (IOException e4) {
                HttpEngine recover2 = this.engine.recover(e4, (u) null);
                if (recover2 != null) {
                    this.engine = recover2;
                } else {
                    throw e4;
                }
            }
        }
        this.engine.releaseConnection();
        throw new IOException("Canceled");
    }
}
