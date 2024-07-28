package com.squareup.okhttp.internal.http;

import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.android.chat.utils.KeyList;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.http.CacheStrategy;
import i.c;
import i.d;
import i.e;
import i.l;
import i.n;
import i.u;
import i.v;
import i.w;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new ResponseBody() {
        public final long contentLength() {
            return 0;
        }

        public final MediaType contentType() {
            return null;
        }

        public final e source() {
            return new c();
        }
    };
    public static final int MAX_FOLLOW_UPS = 20;
    private Address address;
    public final boolean bufferRequestBody;
    private d bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    /* access modifiers changed from: private */
    public Connection connection;
    private final boolean forWebSocket;
    /* access modifiers changed from: private */
    public Request networkRequest;
    private final Response priorResponse;
    private u requestBodyOut;
    private Route route;
    private RouteSelector routeSelector;
    long sentRequestMillis = -1;
    private CacheRequest storeRequest;
    private boolean transparentGzip;
    /* access modifiers changed from: private */
    public Transport transport;
    private final Request userRequest;
    private Response userResponse;

    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean z, boolean z2, boolean z3, Connection connection2, RouteSelector routeSelector2, RetryableSink retryableSink, Response response) {
        this.client = okHttpClient;
        this.userRequest = request;
        this.bufferRequestBody = z;
        this.callerWritesRequestBody = z2;
        this.forWebSocket = z3;
        this.connection = connection2;
        this.routeSelector = routeSelector2;
        this.requestBodyOut = retryableSink;
        this.priorResponse = response;
        if (connection2 != null) {
            Internal.instance.setOwner(connection2, this);
            this.route = connection2.getRoute();
            return;
        }
        this.route = null;
    }

    public final void sendRequest() throws RequestException, RouteException, IOException {
        if (this.cacheStrategy == null) {
            if (this.transport == null) {
                Request networkRequest2 = networkRequest(this.userRequest);
                InternalCache internalCache = Internal.instance.internalCache(this.client);
                Response response = internalCache != null ? internalCache.get(networkRequest2) : null;
                this.cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), networkRequest2, response).get();
                this.networkRequest = this.cacheStrategy.networkRequest;
                this.cacheResponse = this.cacheStrategy.cacheResponse;
                if (internalCache != null) {
                    internalCache.trackResponse(this.cacheStrategy);
                }
                if (response != null && this.cacheResponse == null) {
                    Util.closeQuietly((Closeable) response.body());
                }
                if (this.networkRequest != null) {
                    if (this.connection == null) {
                        connect();
                    }
                    this.transport = Internal.instance.newTransport(this.connection, this);
                    if (this.callerWritesRequestBody && permitsRequestBody() && this.requestBodyOut == null) {
                        long contentLength = OkHeaders.contentLength(networkRequest2);
                        if (!this.bufferRequestBody) {
                            this.transport.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = this.transport.createRequestBody(this.networkRequest, contentLength);
                        } else if (contentLength > 2147483647L) {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        } else if (contentLength != -1) {
                            this.transport.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = new RetryableSink((int) contentLength);
                        } else {
                            this.requestBodyOut = new RetryableSink();
                        }
                    }
                } else {
                    if (this.connection != null) {
                        Internal.instance.recycle(this.client.getConnectionPool(), this.connection);
                        this.connection = null;
                    }
                    Response response2 = this.cacheResponse;
                    if (response2 != null) {
                        this.userResponse = response2.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();
                    } else {
                        this.userResponse = new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build();
                    }
                    this.userResponse = unzip(this.userResponse);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body((ResponseBody) null).build();
    }

    private void connect() throws RequestException, RouteException {
        if (this.connection == null) {
            if (this.routeSelector == null) {
                this.address = createAddress(this.client, this.networkRequest);
                try {
                    this.routeSelector = RouteSelector.get(this.address, this.networkRequest, this.client);
                } catch (IOException e2) {
                    throw new RequestException(e2);
                }
            }
            this.connection = createNextConnection();
            Internal.instance.connectAndSetOwner(this.client, this.connection, this, this.networkRequest);
            this.route = this.connection.getRoute();
            return;
        }
        throw new IllegalStateException();
    }

    private Connection createNextConnection() throws RouteException {
        Connection connection2;
        ConnectionPool connectionPool = this.client.getConnectionPool();
        while (true) {
            connection2 = connectionPool.get(this.address);
            if (connection2 == null) {
                try {
                    return new Connection(connectionPool, this.routeSelector.next());
                } catch (IOException e2) {
                    throw new RouteException(e2);
                }
            } else if (this.networkRequest.method().equals(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD) || Internal.instance.isReadable(connection2)) {
                return connection2;
            } else {
                Util.closeQuietly(connection2.getSocket());
            }
        }
        return connection2;
    }

    public final void writingRequestHeaders() {
        if (this.sentRequestMillis == -1) {
            this.sentRequestMillis = System.currentTimeMillis();
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    public final boolean permitsRequestBody() {
        return HttpMethod.permitsRequestBody(this.userRequest.method());
    }

    public final u getRequestBody() {
        if (this.cacheStrategy != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public final d getBufferedRequestBody() {
        d dVar = this.bufferedRequestBody;
        if (dVar != null) {
            return dVar;
        }
        u requestBody = getRequestBody();
        if (requestBody == null) {
            return null;
        }
        d a2 = n.a(requestBody);
        this.bufferedRequestBody = a2;
        return a2;
    }

    public final boolean hasResponse() {
        return this.userResponse != null;
    }

    public final Request getRequest() {
        return this.userRequest;
    }

    public final Response getResponse() {
        Response response = this.userResponse;
        if (response != null) {
            return response;
        }
        throw new IllegalStateException();
    }

    public final Connection getConnection() {
        return this.connection;
    }

    public final HttpEngine recover(RouteException routeException) {
        RouteSelector routeSelector2 = this.routeSelector;
        if (!(routeSelector2 == null || this.connection == null)) {
            connectFailed(routeSelector2, routeException.getLastConnectException());
        }
        if (this.routeSelector == null && this.connection == null) {
            return null;
        }
        RouteSelector routeSelector3 = this.routeSelector;
        if ((routeSelector3 != null && !routeSelector3.hasNext()) || !isRecoverable(routeException)) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), this.routeSelector, (RetryableSink) this.requestBodyOut, this.priorResponse);
    }

    private boolean isRecoverable(RouteException routeException) {
        if (!this.client.getRetryOnConnectionFailure()) {
            return false;
        }
        IOException lastConnectException = routeException.getLastConnectException();
        if ((lastConnectException instanceof ProtocolException) || (lastConnectException instanceof InterruptedIOException)) {
            return false;
        }
        if ((!(lastConnectException instanceof SSLHandshakeException) || !(lastConnectException.getCause() instanceof CertificateException)) && !(lastConnectException instanceof SSLPeerUnverifiedException)) {
            return true;
        }
        return false;
    }

    public final HttpEngine recover(IOException iOException, u uVar) {
        RouteSelector routeSelector2 = this.routeSelector;
        if (!(routeSelector2 == null || this.connection == null)) {
            connectFailed(routeSelector2, iOException);
        }
        boolean z = uVar == null || (uVar instanceof RetryableSink);
        if (this.routeSelector == null && this.connection == null) {
            return null;
        }
        RouteSelector routeSelector3 = this.routeSelector;
        if ((routeSelector3 != null && !routeSelector3.hasNext()) || !isRecoverable(iOException) || !z) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), this.routeSelector, (RetryableSink) uVar, this.priorResponse);
    }

    private void connectFailed(RouteSelector routeSelector2, IOException iOException) {
        if (Internal.instance.recycleCount(this.connection) <= 0) {
            routeSelector2.connectFailed(this.connection.getRoute(), iOException);
        }
    }

    public final HttpEngine recover(IOException iOException) {
        return recover(iOException, this.requestBodyOut);
    }

    private boolean isRecoverable(IOException iOException) {
        if (this.client.getRetryOnConnectionFailure() && !(iOException instanceof ProtocolException) && !(iOException instanceof InterruptedIOException)) {
            return true;
        }
        return false;
    }

    public final Route getRoute() {
        return this.route;
    }

    private void maybeCache() throws IOException {
        InternalCache internalCache = Internal.instance.internalCache(this.client);
        if (internalCache != null) {
            if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
                this.storeRequest = internalCache.put(stripBody(this.userResponse));
            } else if (HttpMethod.invalidatesCache(this.networkRequest.method())) {
                try {
                    internalCache.remove(this.networkRequest);
                } catch (IOException unused) {
                }
            }
        }
    }

    public final void releaseConnection() throws IOException {
        Transport transport2 = this.transport;
        if (!(transport2 == null || this.connection == null)) {
            transport2.releaseConnectionOnIdle();
        }
        this.connection = null;
    }

    public final void disconnect() {
        try {
            if (this.transport != null) {
                this.transport.disconnect(this);
                return;
            }
            Connection connection2 = this.connection;
            if (connection2 != null) {
                Internal.instance.closeIfOwnedBy(connection2, this);
            }
        } catch (IOException unused) {
        }
    }

    public final Connection close() {
        d dVar = this.bufferedRequestBody;
        if (dVar != null) {
            Util.closeQuietly((Closeable) dVar);
        } else {
            u uVar = this.requestBodyOut;
            if (uVar != null) {
                Util.closeQuietly((Closeable) uVar);
            }
        }
        Response response = this.userResponse;
        if (response == null) {
            Connection connection2 = this.connection;
            if (connection2 != null) {
                Util.closeQuietly(connection2.getSocket());
            }
            this.connection = null;
            return null;
        }
        Util.closeQuietly((Closeable) response.body());
        Transport transport2 = this.transport;
        if (transport2 == null || this.connection == null || transport2.canReuseConnection()) {
            if (this.connection != null && !Internal.instance.clearOwner(this.connection)) {
                this.connection = null;
            }
            Connection connection3 = this.connection;
            this.connection = null;
            return connection3;
        }
        Util.closeQuietly(this.connection.getSocket());
        this.connection = null;
        return null;
    }

    private Response unzip(Response response) throws IOException {
        if (!this.transparentGzip || !"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")) || response.body() == null) {
            return response;
        }
        l lVar = new l(response.body().source());
        Headers build = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(build).body(new RealResponseBody(build, n.a((v) lVar))).build();
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && OkHeaders.contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    private Request networkRequest(Request request) throws IOException {
        Request.Builder newBuilder = request.newBuilder();
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.hostHeader(request.httpUrl()));
        }
        Connection connection2 = this.connection;
        if ((connection2 == null || connection2.getProtocol() != Protocol.HTTP_1_0) && request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.transparentGzip = true;
            newBuilder.header("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            OkHeaders.addCookies(newBuilder, cookieHandler.get(request.uri(), OkHeaders.toMultimap(newBuilder.build().headers(), (String) null)));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent());
        }
        return newBuilder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void readResponse() throws java.io.IOException {
        /*
            r5 = this;
            com.squareup.okhttp.Response r0 = r5.userResponse
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            com.squareup.okhttp.Request r0 = r5.networkRequest
            if (r0 != 0) goto L_0x0016
            com.squareup.okhttp.Response r0 = r5.cacheResponse
            if (r0 == 0) goto L_0x000e
            goto L_0x0016
        L_0x000e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call sendRequest() first!"
            r0.<init>(r1)
            throw r0
        L_0x0016:
            com.squareup.okhttp.Request r0 = r5.networkRequest
            if (r0 != 0) goto L_0x001b
            return
        L_0x001b:
            boolean r1 = r5.forWebSocket
            if (r1 == 0) goto L_0x0026
            com.squareup.okhttp.internal.http.Transport r1 = r5.transport
            r1.writeRequestHeaders(r0)
            goto L_0x00a3
        L_0x0026:
            boolean r1 = r5.callerWritesRequestBody
            if (r1 != 0) goto L_0x0037
            com.squareup.okhttp.internal.http.HttpEngine$NetworkInterceptorChain r1 = new com.squareup.okhttp.internal.http.HttpEngine$NetworkInterceptorChain
            r2 = 0
            r1.<init>(r2, r0)
            com.squareup.okhttp.Request r0 = r5.networkRequest
            com.squareup.okhttp.Response r0 = r1.proceed(r0)
            goto L_0x00a7
        L_0x0037:
            i.d r0 = r5.bufferedRequestBody
            if (r0 == 0) goto L_0x004c
            i.c r0 = r0.a()
            long r0 = r0.f46277b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x004c
            i.d r0 = r5.bufferedRequestBody
            r0.c()
        L_0x004c:
            long r0 = r5.sentRequestMillis
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0087
            com.squareup.okhttp.Request r0 = r5.networkRequest
            long r0 = com.squareup.okhttp.internal.http.OkHeaders.contentLength((com.squareup.okhttp.Request) r0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0080
            i.u r0 = r5.requestBodyOut
            boolean r1 = r0 instanceof com.squareup.okhttp.internal.http.RetryableSink
            if (r1 == 0) goto L_0x0080
            com.squareup.okhttp.internal.http.RetryableSink r0 = (com.squareup.okhttp.internal.http.RetryableSink) r0
            long r0 = r0.contentLength()
            com.squareup.okhttp.Request r2 = r5.networkRequest
            com.squareup.okhttp.Request$Builder r2 = r2.newBuilder()
            java.lang.String r0 = java.lang.Long.toString(r0)
            java.lang.String r1 = "Content-Length"
            com.squareup.okhttp.Request$Builder r0 = r2.header(r1, r0)
            com.squareup.okhttp.Request r0 = r0.build()
            r5.networkRequest = r0
        L_0x0080:
            com.squareup.okhttp.internal.http.Transport r0 = r5.transport
            com.squareup.okhttp.Request r1 = r5.networkRequest
            r0.writeRequestHeaders(r1)
        L_0x0087:
            i.u r0 = r5.requestBodyOut
            if (r0 == 0) goto L_0x00a3
            i.d r1 = r5.bufferedRequestBody
            if (r1 == 0) goto L_0x0093
            r1.close()
            goto L_0x0096
        L_0x0093:
            r0.close()
        L_0x0096:
            i.u r0 = r5.requestBodyOut
            boolean r1 = r0 instanceof com.squareup.okhttp.internal.http.RetryableSink
            if (r1 == 0) goto L_0x00a3
            com.squareup.okhttp.internal.http.Transport r1 = r5.transport
            com.squareup.okhttp.internal.http.RetryableSink r0 = (com.squareup.okhttp.internal.http.RetryableSink) r0
            r1.writeRequestBody(r0)
        L_0x00a3:
            com.squareup.okhttp.Response r0 = r5.readNetworkResponse()
        L_0x00a7:
            com.squareup.okhttp.Headers r1 = r0.headers()
            r5.receiveHeaders(r1)
            com.squareup.okhttp.Response r1 = r5.cacheResponse
            if (r1 == 0) goto L_0x012a
            boolean r1 = validate(r1, r0)
            if (r1 == 0) goto L_0x0121
            com.squareup.okhttp.Response r1 = r5.cacheResponse
            com.squareup.okhttp.Response$Builder r1 = r1.newBuilder()
            com.squareup.okhttp.Request r2 = r5.userRequest
            com.squareup.okhttp.Response$Builder r1 = r1.request(r2)
            com.squareup.okhttp.Response r2 = r5.priorResponse
            com.squareup.okhttp.Response r2 = stripBody(r2)
            com.squareup.okhttp.Response$Builder r1 = r1.priorResponse(r2)
            com.squareup.okhttp.Response r2 = r5.cacheResponse
            com.squareup.okhttp.Headers r2 = r2.headers()
            com.squareup.okhttp.Headers r3 = r0.headers()
            com.squareup.okhttp.Headers r2 = combine(r2, r3)
            com.squareup.okhttp.Response$Builder r1 = r1.headers(r2)
            com.squareup.okhttp.Response r2 = r5.cacheResponse
            com.squareup.okhttp.Response r2 = stripBody(r2)
            com.squareup.okhttp.Response$Builder r1 = r1.cacheResponse(r2)
            com.squareup.okhttp.Response r2 = stripBody(r0)
            com.squareup.okhttp.Response$Builder r1 = r1.networkResponse(r2)
            com.squareup.okhttp.Response r1 = r1.build()
            r5.userResponse = r1
            com.squareup.okhttp.ResponseBody r0 = r0.body()
            r0.close()
            r5.releaseConnection()
            com.squareup.okhttp.internal.Internal r0 = com.squareup.okhttp.internal.Internal.instance
            com.squareup.okhttp.OkHttpClient r1 = r5.client
            com.squareup.okhttp.internal.InternalCache r0 = r0.internalCache(r1)
            r0.trackConditionalCacheHit()
            com.squareup.okhttp.Response r1 = r5.cacheResponse
            com.squareup.okhttp.Response r2 = r5.userResponse
            com.squareup.okhttp.Response r2 = stripBody(r2)
            r0.update(r1, r2)
            com.squareup.okhttp.Response r0 = r5.userResponse
            com.squareup.okhttp.Response r0 = r5.unzip(r0)
            r5.userResponse = r0
            return
        L_0x0121:
            com.squareup.okhttp.Response r1 = r5.cacheResponse
            com.squareup.okhttp.ResponseBody r1 = r1.body()
            com.squareup.okhttp.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x012a:
            com.squareup.okhttp.Response$Builder r1 = r0.newBuilder()
            com.squareup.okhttp.Request r2 = r5.userRequest
            com.squareup.okhttp.Response$Builder r1 = r1.request(r2)
            com.squareup.okhttp.Response r2 = r5.priorResponse
            com.squareup.okhttp.Response r2 = stripBody(r2)
            com.squareup.okhttp.Response$Builder r1 = r1.priorResponse(r2)
            com.squareup.okhttp.Response r2 = r5.cacheResponse
            com.squareup.okhttp.Response r2 = stripBody(r2)
            com.squareup.okhttp.Response$Builder r1 = r1.cacheResponse(r2)
            com.squareup.okhttp.Response r0 = stripBody(r0)
            com.squareup.okhttp.Response$Builder r0 = r1.networkResponse(r0)
            com.squareup.okhttp.Response r0 = r0.build()
            r5.userResponse = r0
            com.squareup.okhttp.Response r0 = r5.userResponse
            boolean r0 = hasBody(r0)
            if (r0 == 0) goto L_0x016f
            r5.maybeCache()
            com.squareup.okhttp.internal.http.CacheRequest r0 = r5.storeRequest
            com.squareup.okhttp.Response r1 = r5.userResponse
            com.squareup.okhttp.Response r0 = r5.cacheWritingResponse(r0, r1)
            com.squareup.okhttp.Response r0 = r5.unzip(r0)
            r5.userResponse = r0
        L_0x016f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.HttpEngine.readResponse():void");
    }

    class NetworkInterceptorChain implements Interceptor.Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int i2, Request request2) {
            this.index = i2;
            this.request = request2;
        }

        public Connection connection() {
            return HttpEngine.this.connection;
        }

        public Request request() {
            return this.request;
        }

        public Response proceed(Request request2) throws IOException {
            this.calls++;
            if (this.index > 0) {
                Interceptor interceptor = HttpEngine.this.client.networkInterceptors().get(this.index - 1);
                Address address = connection().getRoute().getAddress();
                if (!request2.httpUrl().host().equals(address.getUriHost()) || request2.httpUrl().port() != address.getUriPort()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                } else if (this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
                NetworkInterceptorChain networkInterceptorChain = new NetworkInterceptorChain(this.index + 1, request2);
                Interceptor interceptor2 = HttpEngine.this.client.networkInterceptors().get(this.index);
                Response intercept = interceptor2.intercept(networkInterceptorChain);
                if (networkInterceptorChain.calls == 1) {
                    return intercept;
                }
                throw new IllegalStateException("network interceptor " + interceptor2 + " must call proceed() exactly once");
            }
            HttpEngine.this.transport.writeRequestHeaders(request2);
            Request unused = HttpEngine.this.networkRequest = request2;
            if (HttpEngine.this.permitsRequestBody() && request2.body() != null) {
                d a2 = n.a(HttpEngine.this.transport.createRequestBody(request2, request2.body().contentLength()));
                request2.body().writeTo(a2);
                a2.close();
            }
            Response access$300 = HttpEngine.this.readNetworkResponse();
            int code = access$300.code();
            if ((code != 204 && code != 205) || access$300.body().contentLength() <= 0) {
                return access$300;
            }
            throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + access$300.body().contentLength());
        }
    }

    /* access modifiers changed from: private */
    public Response readNetworkResponse() throws IOException {
        this.transport.finishRequest();
        Response build = this.transport.readResponseHeaders().request(this.networkRequest).handshake(this.connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        if (!this.forWebSocket) {
            build = build.newBuilder().body(this.transport.openResponseBody(build)).build();
        }
        Internal.instance.setProtocol(this.connection, build.protocol());
        return build;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        u body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        final e source = response.body().source();
        final d a2 = n.a(body);
        return response.newBuilder().body(new RealResponseBody(response.headers(), n.a((v) new v() {
            boolean cacheRequestClosed;

            public long read(c cVar, long j) throws IOException {
                try {
                    long read = source.read(cVar, j);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            a2.close();
                        }
                        return -1;
                    }
                    cVar.a(a2.a(), cVar.f46277b - read, read);
                    a2.x();
                    return read;
                } catch (IOException e2) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e2;
                }
            }

            public w timeout() {
                return source.timeout();
            }

            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }
        }))).build();
    }

    private static boolean validate(Response response, Response response2) {
        Date date;
        if (response2.code() == 304) {
            return true;
        }
        Date date2 = response.headers().getDate("Last-Modified");
        if (date2 == null || (date = response2.headers().getDate("Last-Modified")) == null || date.getTime() >= date2.getTime()) {
            return false;
        }
        return true;
    }

    private static Headers combine(Headers headers, Headers headers2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String name = headers.name(i2);
            String value = headers.value(i2);
            if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (!OkHeaders.isEndToEnd(name) || headers2.get(name) == null)) {
                builder.add(name, value);
            }
        }
        int size2 = headers2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            String name2 = headers2.name(i3);
            if (!"Content-Length".equalsIgnoreCase(name2) && OkHeaders.isEndToEnd(name2)) {
                builder.add(name2, headers2.value(i3));
            }
        }
        return builder.build();
    }

    public final void receiveHeaders(Headers headers) throws IOException {
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(headers, (String) null));
        }
    }

    public final Request followUpRequest() throws IOException {
        Proxy proxy;
        String header;
        HttpUrl resolve;
        if (this.userResponse != null) {
            if (getRoute() != null) {
                proxy = getRoute().getProxy();
            } else {
                proxy = this.client.getProxy();
            }
            int code = this.userResponse.code();
            if (code != 307 && code != 308) {
                if (code != 401) {
                    if (code != 407) {
                        switch (code) {
                            case 300:
                            case KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA /*301*/:
                            case KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_FILE /*302*/:
                            case KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_AUDIO /*303*/:
                                break;
                            default:
                                return null;
                        }
                    } else if (proxy.type() != Proxy.Type.HTTP) {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                }
                return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, proxy);
            } else if (!this.userRequest.method().equals(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD) && !this.userRequest.method().equals("HEAD")) {
                return null;
            }
            if (!this.client.getFollowRedirects() || (header = this.userResponse.header("Location")) == null || (resolve = this.userRequest.httpUrl().resolve(header)) == null) {
                return null;
            }
            if (!resolve.scheme().equals(this.userRequest.httpUrl().scheme()) && !this.client.getFollowSslRedirects()) {
                return null;
            }
            Request.Builder newBuilder = this.userRequest.newBuilder();
            if (HttpMethod.permitsRequestBody(this.userRequest.method())) {
                newBuilder.method(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD, (RequestBody) null);
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
            if (!sameConnection(resolve)) {
                newBuilder.removeHeader("Authorization");
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    public final boolean sameConnection(HttpUrl httpUrl) {
        HttpUrl httpUrl2 = this.userRequest.httpUrl();
        return httpUrl2.host().equals(httpUrl.host()) && httpUrl2.port() == httpUrl.port() && httpUrl2.scheme().equals(httpUrl.scheme());
    }

    private static Address createAddress(OkHttpClient okHttpClient, Request request) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (request.isHttps()) {
            SSLSocketFactory sslSocketFactory = okHttpClient.getSslSocketFactory();
            hostnameVerifier = okHttpClient.getHostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = okHttpClient.getCertificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(request.httpUrl().host(), request.httpUrl().port(), okHttpClient.getSocketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.getAuthenticator(), okHttpClient.getProxy(), okHttpClient.getProtocols(), okHttpClient.getConnectionSpecs(), okHttpClient.getProxySelector());
    }
}
