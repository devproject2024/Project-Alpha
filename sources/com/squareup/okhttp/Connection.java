package com.squareup.okhttp;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.http.FramedTransport;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.Transport;
import i.d;
import i.e;
import i.v;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class Connection {
    private boolean connected = false;
    private FramedConnection framedConnection;
    private Handshake handshake;
    private HttpConnection httpConnection;
    private long idleStartTimeNs;
    private Object owner;
    private final ConnectionPool pool;
    private Protocol protocol = Protocol.HTTP_1_1;
    private int recycleCount;
    private final Route route;
    private Socket socket;

    public Connection(ConnectionPool connectionPool, Route route2) {
        this.pool = connectionPool;
        this.route = route2;
    }

    /* access modifiers changed from: package-private */
    public final Object getOwner() {
        Object obj;
        synchronized (this.pool) {
            obj = this.owner;
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final void setOwner(Object obj) {
        if (!isFramed()) {
            synchronized (this.pool) {
                if (this.owner == null) {
                    this.owner = obj;
                } else {
                    throw new IllegalStateException("Connection already has an owner!");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean clearOwner() {
        synchronized (this.pool) {
            if (this.owner == null) {
                return false;
            }
            this.owner = null;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        r3 = r2.socket;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        if (r3 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void closeIfOwnedBy(java.lang.Object r3) throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r2.isFramed()
            if (r0 != 0) goto L_0x001e
            com.squareup.okhttp.ConnectionPool r0 = r2.pool
            monitor-enter(r0)
            java.lang.Object r1 = r2.owner     // Catch:{ all -> 0x001b }
            if (r1 == r3) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x000f:
            r3 = 0
            r2.owner = r3     // Catch:{ all -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            java.net.Socket r3 = r2.socket
            if (r3 == 0) goto L_0x001a
            r3.close()
        L_0x001a:
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r3
        L_0x001e:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.Connection.closeIfOwnedBy(java.lang.Object):void");
    }

    /* access modifiers changed from: package-private */
    public final void connect(int i2, int i3, int i4, Request request, List<ConnectionSpec> list, boolean z) throws RouteException {
        Socket socket2;
        List<ConnectionSpec> list2 = list;
        if (!this.connected) {
            ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list2);
            Proxy proxy = this.route.getProxy();
            Address address = this.route.getAddress();
            if (this.route.address.getSslSocketFactory() != null || list2.contains(ConnectionSpec.CLEARTEXT)) {
                RouteException routeException = null;
                while (!this.connected) {
                    try {
                        if (proxy.type() != Proxy.Type.DIRECT) {
                            if (proxy.type() != Proxy.Type.HTTP) {
                                socket2 = new Socket(proxy);
                                this.socket = socket2;
                                connectSocket(i2, i3, i4, request, connectionSpecSelector);
                                this.connected = true;
                            }
                        }
                        socket2 = address.getSocketFactory().createSocket();
                        this.socket = socket2;
                        connectSocket(i2, i3, i4, request, connectionSpecSelector);
                        this.connected = true;
                    } catch (IOException e2) {
                        Util.closeQuietly(this.socket);
                        this.socket = null;
                        if (routeException == null) {
                            routeException = new RouteException(e2);
                        } else {
                            routeException.addConnectException(e2);
                        }
                        if (!z || !connectionSpecSelector.connectionFailed(e2)) {
                            throw routeException;
                        }
                    }
                }
                return;
            }
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: ".concat(String.valueOf(list))));
        }
        throw new IllegalStateException("already connected");
    }

    private void connectSocket(int i2, int i3, int i4, Request request, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        this.socket.setSoTimeout(i3);
        Platform.get().connectSocket(this.socket, this.route.getSocketAddress(), i2);
        if (this.route.address.getSslSocketFactory() != null) {
            connectTls(i3, i4, request, connectionSpecSelector);
        }
        if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
            this.socket.setSoTimeout(0);
            this.framedConnection = new FramedConnection.Builder(this.route.address.uriHost, true, this.socket).protocol(this.protocol).build();
            this.framedConnection.sendConnectionPreface();
            return;
        }
        this.httpConnection = new HttpConnection(this.pool, this, this.socket);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r6v2, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ed A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f3 A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void connectTls(int r5, int r6, com.squareup.okhttp.Request r7, com.squareup.okhttp.internal.ConnectionSpecSelector r8) throws java.io.IOException {
        /*
            r4 = this;
            com.squareup.okhttp.Route r0 = r4.route
            boolean r0 = r0.requiresTunnel()
            if (r0 == 0) goto L_0x000b
            r4.createTunnel(r5, r6, r7)
        L_0x000b:
            com.squareup.okhttp.Route r5 = r4.route
            com.squareup.okhttp.Address r5 = r5.getAddress()
            javax.net.ssl.SSLSocketFactory r6 = r5.getSslSocketFactory()
            r7 = 0
            java.net.Socket r0 = r4.socket     // Catch:{ AssertionError -> 0x00e6 }
            java.lang.String r1 = r5.getUriHost()     // Catch:{ AssertionError -> 0x00e6 }
            int r2 = r5.getUriPort()     // Catch:{ AssertionError -> 0x00e6 }
            r3 = 1
            java.net.Socket r6 = r6.createSocket(r0, r1, r2, r3)     // Catch:{ AssertionError -> 0x00e6 }
            javax.net.ssl.SSLSocket r6 = (javax.net.ssl.SSLSocket) r6     // Catch:{ AssertionError -> 0x00e6 }
            com.squareup.okhttp.ConnectionSpec r8 = r8.configureSecureSocket(r6)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            boolean r0 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            if (r0 == 0) goto L_0x0040
            com.squareup.okhttp.internal.Platform r0 = com.squareup.okhttp.internal.Platform.get()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r1 = r5.getUriHost()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.util.List r2 = r5.getProtocols()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            r0.configureTlsExtensions(r6, r1, r2)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
        L_0x0040:
            r6.startHandshake()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            javax.net.ssl.SSLSession r0 = r6.getSession()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            com.squareup.okhttp.Handshake r0 = com.squareup.okhttp.Handshake.get(r0)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            javax.net.ssl.HostnameVerifier r1 = r5.getHostnameVerifier()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r2 = r5.getUriHost()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            javax.net.ssl.SSLSession r3 = r6.getSession()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            boolean r1 = r1.verify(r2, r3)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            if (r1 == 0) goto L_0x0093
            com.squareup.okhttp.CertificatePinner r1 = r5.getCertificatePinner()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r5 = r5.getUriHost()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.util.List r2 = r0.peerCertificates()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            r1.check((java.lang.String) r5, (java.util.List<java.security.cert.Certificate>) r2)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            boolean r5 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            if (r5 == 0) goto L_0x007a
            com.squareup.okhttp.internal.Platform r5 = com.squareup.okhttp.internal.Platform.get()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r7 = r5.getSelectedProtocol(r6)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
        L_0x007a:
            if (r7 == 0) goto L_0x0081
            com.squareup.okhttp.Protocol r5 = com.squareup.okhttp.Protocol.get(r7)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            goto L_0x0083
        L_0x0081:
            com.squareup.okhttp.Protocol r5 = com.squareup.okhttp.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
        L_0x0083:
            r4.protocol = r5     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            r4.handshake = r0     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            r4.socket = r6     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            if (r6 == 0) goto L_0x0092
            com.squareup.okhttp.internal.Platform r5 = com.squareup.okhttp.internal.Platform.get()
            r5.afterHandshake(r6)
        L_0x0092:
            return
        L_0x0093:
            java.util.List r7 = r0.peerCertificates()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            r8 = 0
            java.lang.Object r7 = r7.get(r8)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.security.cert.X509Certificate r7 = (java.security.cert.X509Certificate) r7     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            javax.net.ssl.SSLPeerUnverifiedException r8 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r1 = "Hostname "
            r0.<init>(r1)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r5 = r5.getUriHost()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            r0.append(r5)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r5 = " not verified:\n    certificate: "
            r0.append(r5)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r5 = com.squareup.okhttp.CertificatePinner.pin(r7)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            r0.append(r5)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r5 = "\n    DN: "
            r0.append(r5)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.security.Principal r5 = r7.getSubjectDN()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r5 = r5.getName()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            r0.append(r5)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r5 = "\n    subjectAltNames: "
            r0.append(r5)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.util.List r5 = com.squareup.okhttp.internal.tls.OkHostnameVerifier.allSubjectAltNames(r7)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            r0.append(r5)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            java.lang.String r5 = r0.toString()     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            r8.<init>(r5)     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
            throw r8     // Catch:{ AssertionError -> 0x00e0, all -> 0x00de }
        L_0x00de:
            r5 = move-exception
            goto L_0x00f4
        L_0x00e0:
            r5 = move-exception
            r7 = r6
            goto L_0x00e7
        L_0x00e3:
            r5 = move-exception
            r6 = r7
            goto L_0x00f4
        L_0x00e6:
            r5 = move-exception
        L_0x00e7:
            boolean r6 = com.squareup.okhttp.internal.Util.isAndroidGetsocknameError(r5)     // Catch:{ all -> 0x00e3 }
            if (r6 == 0) goto L_0x00f3
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x00e3 }
            r6.<init>(r5)     // Catch:{ all -> 0x00e3 }
            throw r6     // Catch:{ all -> 0x00e3 }
        L_0x00f3:
            throw r5     // Catch:{ all -> 0x00e3 }
        L_0x00f4:
            if (r6 == 0) goto L_0x00fd
            com.squareup.okhttp.internal.Platform r7 = com.squareup.okhttp.internal.Platform.get()
            r7.afterHandshake(r6)
        L_0x00fd:
            com.squareup.okhttp.internal.Util.closeQuietly((java.net.Socket) r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.Connection.connectTls(int, int, com.squareup.okhttp.Request, com.squareup.okhttp.internal.ConnectionSpecSelector):void");
    }

    private void createTunnel(int i2, int i3, Request request) throws IOException {
        Request createTunnelRequest = createTunnelRequest(request);
        HttpConnection httpConnection2 = new HttpConnection(this.pool, this, this.socket);
        httpConnection2.setTimeouts(i2, i3);
        HttpUrl httpUrl = createTunnelRequest.httpUrl();
        String str = "CONNECT " + httpUrl.host() + AppConstants.COLON + httpUrl.port() + " HTTP/1.1";
        do {
            httpConnection2.writeRequest(createTunnelRequest.headers(), str);
            httpConnection2.flush();
            Response build = httpConnection2.readResponse().request(createTunnelRequest).build();
            long contentLength = OkHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            v newFixedLengthSource = httpConnection2.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    createTunnelRequest = OkHeaders.processAuthHeader(this.route.getAddress().getAuthenticator(), build, this.route.getProxy());
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else if (httpConnection2.bufferSize() > 0) {
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else {
                return;
            }
        } while (createTunnelRequest != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private Request createTunnelRequest(Request request) throws IOException {
        HttpUrl build = new HttpUrl.Builder().scheme("https").host(request.httpUrl().host()).port(request.httpUrl().port()).build();
        Request.Builder header = new Request.Builder().url(build).header("Host", Util.hostHeader(build)).header("Proxy-Connection", "Keep-Alive");
        String header2 = request.header("User-Agent");
        if (header2 != null) {
            header.header("User-Agent", header2);
        }
        String header3 = request.header("Proxy-Authorization");
        if (header3 != null) {
            header.header("Proxy-Authorization", header3);
        }
        return header.build();
    }

    /* access modifiers changed from: package-private */
    public final void connectAndSetOwner(OkHttpClient okHttpClient, Object obj, Request request) throws RouteException {
        setOwner(obj);
        if (!isConnected()) {
            Request request2 = request;
            connect(okHttpClient.getConnectTimeout(), okHttpClient.getReadTimeout(), okHttpClient.getWriteTimeout(), request2, this.route.address.getConnectionSpecs(), okHttpClient.getRetryOnConnectionFailure());
            if (isFramed()) {
                okHttpClient.getConnectionPool().share(this);
            }
            okHttpClient.routeDatabase().connected(getRoute());
        }
        setTimeouts(okHttpClient.getReadTimeout(), okHttpClient.getWriteTimeout());
    }

    /* access modifiers changed from: package-private */
    public final boolean isConnected() {
        return this.connected;
    }

    public final Route getRoute() {
        return this.route;
    }

    public final Socket getSocket() {
        return this.socket;
    }

    /* access modifiers changed from: package-private */
    public final e rawSource() {
        HttpConnection httpConnection2 = this.httpConnection;
        if (httpConnection2 != null) {
            return httpConnection2.rawSource();
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final d rawSink() {
        HttpConnection httpConnection2 = this.httpConnection;
        if (httpConnection2 != null) {
            return httpConnection2.rawSink();
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final boolean isAlive() {
        return !this.socket.isClosed() && !this.socket.isInputShutdown() && !this.socket.isOutputShutdown();
    }

    /* access modifiers changed from: package-private */
    public final boolean isReadable() {
        HttpConnection httpConnection2 = this.httpConnection;
        if (httpConnection2 != null) {
            return httpConnection2.isReadable();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void resetIdleStartTime() {
        if (this.framedConnection == null) {
            this.idleStartTimeNs = System.nanoTime();
            return;
        }
        throw new IllegalStateException("framedConnection != null");
    }

    /* access modifiers changed from: package-private */
    public final boolean isIdle() {
        FramedConnection framedConnection2 = this.framedConnection;
        return framedConnection2 == null || framedConnection2.isIdle();
    }

    /* access modifiers changed from: package-private */
    public final long getIdleStartTimeNs() {
        FramedConnection framedConnection2 = this.framedConnection;
        return framedConnection2 == null ? this.idleStartTimeNs : framedConnection2.getIdleStartTimeNs();
    }

    public final Handshake getHandshake() {
        return this.handshake;
    }

    /* access modifiers changed from: package-private */
    public final Transport newTransport(HttpEngine httpEngine) throws IOException {
        FramedConnection framedConnection2 = this.framedConnection;
        return framedConnection2 != null ? new FramedTransport(httpEngine, framedConnection2) : new HttpTransport(httpEngine, this.httpConnection);
    }

    /* access modifiers changed from: package-private */
    public final boolean isFramed() {
        return this.framedConnection != null;
    }

    public final Protocol getProtocol() {
        return this.protocol;
    }

    /* access modifiers changed from: package-private */
    public final void setProtocol(Protocol protocol2) {
        if (protocol2 != null) {
            this.protocol = protocol2;
            return;
        }
        throw new IllegalArgumentException("protocol == null");
    }

    /* access modifiers changed from: package-private */
    public final void setTimeouts(int i2, int i3) throws RouteException {
        if (!this.connected) {
            throw new IllegalStateException("setTimeouts - not connected");
        } else if (this.httpConnection != null) {
            try {
                this.socket.setSoTimeout(i2);
                this.httpConnection.setTimeouts(i2, i3);
            } catch (IOException e2) {
                throw new RouteException(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void incrementRecycleCount() {
        this.recycleCount++;
    }

    /* access modifiers changed from: package-private */
    public final int recycleCount() {
        return this.recycleCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.route.address.uriHost);
        sb.append(AppConstants.COLON);
        sb.append(this.route.address.uriPort);
        sb.append(", proxy=");
        sb.append(this.route.proxy);
        sb.append(" hostAddress=");
        sb.append(this.route.inetSocketAddress.getAddress().getHostAddress());
        sb.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        sb.append(handshake2 != null ? handshake2.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
