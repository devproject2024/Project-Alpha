package com.sendbird.android.shadow.okhttp3.internal.ws;

import com.alipay.mobile.h5container.api.H5Param;
import com.sendbird.android.shadow.okhttp3.Call;
import com.sendbird.android.shadow.okhttp3.Callback;
import com.sendbird.android.shadow.okhttp3.EventListener;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.WebSocket;
import com.sendbird.android.shadow.okhttp3.WebSocketListener;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import com.sendbird.android.shadow.okhttp3.internal.ws.WebSocketReader;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private a writer;
    private final Runnable writerRunnable;

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random2, long j) {
        if (H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD.equals(request.method())) {
            this.originalRequest = request;
            this.listener = webSocketListener;
            this.random = random2;
            this.pingIntervalMillis = j;
            byte[] bArr = new byte[16];
            random2.nextBytes(bArr);
            this.key = ByteString.of(bArr).base64();
            this.writerRunnable = new Runnable() {
                public final void run() {
                    do {
                        try {
                        } catch (IOException e2) {
                            RealWebSocket.this.failWebSocket(e2, (Response) null);
                            return;
                        }
                    } while (RealWebSocket.this.writeOneFrame());
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }

    public final Request request() {
        return this.originalRequest;
    }

    public final synchronized long queueSize() {
        return this.queueSize;
    }

    public final void cancel() {
        this.call.cancel();
    }

    public final void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        this.call = Internal.instance.newWebSocketCall(build, build2);
        this.call.timeout().clearTimeout();
        this.call.enqueue(new Callback() {
            public final void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.checkResponse(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket.this.listener.onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e2) {
                        RealWebSocket.this.failWebSocket(e2, (Response) null);
                    }
                } catch (ProtocolException e3) {
                    RealWebSocket.this.failWebSocket(e3, response);
                    Util.closeQuietly((Closeable) response);
                }
            }

            public final void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, (Response) null);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void checkResponse(Response response) throws ProtocolException {
        if (response.code() == 101) {
            String header = response.header("Connection");
            if ("Upgrade".equalsIgnoreCase(header)) {
                String header2 = response.header("Upgrade");
                if ("websocket".equalsIgnoreCase(header2)) {
                    String header3 = response.header("Sec-WebSocket-Accept");
                    String base64 = ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
                    if (!base64.equals(header3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
                    }
                    return;
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
    }

    public final void initReaderAndWriter(String str, Streams streams2) throws IOException {
        synchronized (this) {
            this.streams = streams2;
            this.writer = new a(streams2.client, streams2.sink, this.random);
            this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            if (this.pingIntervalMillis != 0) {
                this.executor.scheduleAtFixedRate(new d(), this.pingIntervalMillis, this.pingIntervalMillis, TimeUnit.MILLISECONDS);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new WebSocketReader(streams2.client, streams2.source, this);
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean processNextFrame() throws IOException {
        try {
            this.reader.a();
            if (this.receivedCloseCode == -1) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            failWebSocket(e2, (Response) null);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void awaitTermination(int i2, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination((long) i2, timeUnit);
    }

    /* access modifiers changed from: package-private */
    public final void tearDown() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    /* access modifiers changed from: package-private */
    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    /* access modifiers changed from: package-private */
    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public final void onReadMessage(String str) throws IOException {
        this.listener.onMessage((WebSocket) this, str);
    }

    public final void onReadMessage(ByteString byteString) throws IOException {
        this.listener.onMessage((WebSocket) this, byteString);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onReadPing(com.sendbird.android.shadow.okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.failed     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0022
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            java.util.ArrayDeque<com.sendbird.android.shadow.okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0024 }
            r0.add(r2)     // Catch:{ all -> 0x0024 }
            r1.runWriter()     // Catch:{ all -> 0x0024 }
            int r2 = r1.receivedPingCount     // Catch:{ all -> 0x0024 }
            int r2 = r2 + 1
            r1.receivedPingCount = r2     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)
            return
        L_0x0022:
            monitor-exit(r1)
            return
        L_0x0024:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.onReadPing(com.sendbird.android.shadow.okio.ByteString):void");
    }

    public final synchronized void onReadPong(ByteString byteString) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final void onReadClose(int i2, String str) {
        Streams streams2;
        if (i2 != -1) {
            synchronized (this) {
                if (this.receivedCloseCode == -1) {
                    this.receivedCloseCode = i2;
                    this.receivedCloseReason = str;
                    if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                        streams2 = null;
                    } else {
                        streams2 = this.streams;
                        this.streams = null;
                        if (this.cancelFuture != null) {
                            this.cancelFuture.cancel(false);
                        }
                        this.executor.shutdown();
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.listener.onClosing(this, i2, str);
                if (streams2 != null) {
                    this.listener.onClosed(this, i2, str);
                }
            } finally {
                Util.closeQuietly((Closeable) streams2);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final boolean send(String str) {
        if (str != null) {
            return send(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public final boolean send(ByteString byteString) {
        if (byteString != null) {
            return send(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean send(com.sendbird.android.shadow.okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.failed     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.enqueuedClose     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r0 = r7.size()     // Catch:{ all -> 0x003e }
            long r4 = (long) r0     // Catch:{ all -> 0x003e }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.close(r7, r8)     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return r1
        L_0x0022:
            long r0 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.queueSize = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.messageAndCloseQueue     // Catch:{ all -> 0x003e }
            com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$c r1 = new com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$c     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.runWriter()     // Catch:{ all -> 0x003e }
            r7 = 1
            monitor-exit(r6)
            return r7
        L_0x003c:
            monitor-exit(r6)
            return r1
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.send(com.sendbird.android.shadow.okio.ByteString, int):boolean");
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean pong(ByteString byteString) {
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(byteString);
                runWriter();
                return true;
            }
        }
        return false;
    }

    public final boolean close(int i2, String str) {
        return close(i2, str, CANCEL_AFTER_CLOSE_MILLIS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean close(int i2, String str, long j) {
        WebSocketProtocol.validateCloseCode(i2);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (((long) byteString.size()) > 123) {
                throw new IllegalArgumentException("reason.size() > 123: ".concat(String.valueOf(str)));
            }
        }
        if (!this.failed) {
            if (!this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new b(i2, byteString, j));
                runWriter();
                return true;
            }
        }
        return false;
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r2 == null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.a(10, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        if ((r4 instanceof com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.c) == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005e, code lost:
        r2 = ((com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.c) r4).f45223b;
        r4 = ((com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.c) r4).f45222a;
        r5 = (long) r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
        if (r0.f45241h != false) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        r0.f45241h = true;
        r0.f45240g.f45243a = r4;
        r0.f45240g.f45244b = r5;
        r0.f45240g.f45245c = true;
        r0.f45240g.f45246d = false;
        r0 = com.sendbird.android.shadow.okio.Okio.buffer((com.sendbird.android.shadow.okio.Sink) r0.f45240g);
        r0.write(r2);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        monitor-enter(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r12.queueSize -= (long) r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0099, code lost:
        monitor-exit(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a5, code lost:
        throw new java.lang.IllegalStateException("Another message writer is active. Did you call close()?");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a8, code lost:
        if ((r4 instanceof com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.b) == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00aa, code lost:
        r4 = (com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.b) r4;
        r1 = r4.f45219a;
        r2 = r4.f45220b;
        r4 = com.sendbird.android.shadow.okio.ByteString.EMPTY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b2, code lost:
        if (r1 != 0) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b4, code lost:
        if (r2 == null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b6, code lost:
        if (r1 == 0) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b8, code lost:
        com.sendbird.android.shadow.okhttp3.internal.ws.WebSocketProtocol.validateCloseCode(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bb, code lost:
        r4 = new com.sendbird.android.shadow.okio.Buffer();
        r4.writeShort(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c3, code lost:
        if (r2 == null) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c5, code lost:
        r4.write(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c8, code lost:
        r4 = r4.readByteString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r0.a(8, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r0.f45238e = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d3, code lost:
        if (r3 == null) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d5, code lost:
        r12.listener.onClosed(r12, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00da, code lost:
        com.sendbird.android.shadow.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00dd, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00de, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r0.f45238e = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e1, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e7, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00e9, code lost:
        com.sendbird.android.shadow.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ec, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:24:0x0055, B:54:0x00ce] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean writeOneFrame() throws java.io.IOException {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.failed     // Catch:{ all -> 0x00ed }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r12)     // Catch:{ all -> 0x00ed }
            return r1
        L_0x0008:
            com.sendbird.android.shadow.okhttp3.internal.ws.a r0 = r12.writer     // Catch:{ all -> 0x00ed }
            java.util.ArrayDeque<com.sendbird.android.shadow.okio.ByteString> r2 = r12.pongQueue     // Catch:{ all -> 0x00ed }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x00ed }
            com.sendbird.android.shadow.okio.ByteString r2 = (com.sendbird.android.shadow.okio.ByteString) r2     // Catch:{ all -> 0x00ed }
            r3 = 0
            if (r2 != 0) goto L_0x004c
            java.util.ArrayDeque<java.lang.Object> r4 = r12.messageAndCloseQueue     // Catch:{ all -> 0x00ed }
            java.lang.Object r4 = r4.poll()     // Catch:{ all -> 0x00ed }
            boolean r5 = r4 instanceof com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.b     // Catch:{ all -> 0x00ed }
            if (r5 == 0) goto L_0x0046
            int r5 = r12.receivedCloseCode     // Catch:{ all -> 0x00ed }
            java.lang.String r6 = r12.receivedCloseReason     // Catch:{ all -> 0x00ed }
            r7 = -1
            if (r5 == r7) goto L_0x0031
            com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$Streams r7 = r12.streams     // Catch:{ all -> 0x00ed }
            r12.streams = r3     // Catch:{ all -> 0x00ed }
            java.util.concurrent.ScheduledExecutorService r3 = r12.executor     // Catch:{ all -> 0x00ed }
            r3.shutdown()     // Catch:{ all -> 0x00ed }
            r3 = r7
            goto L_0x004f
        L_0x0031:
            java.util.concurrent.ScheduledExecutorService r7 = r12.executor     // Catch:{ all -> 0x00ed }
            com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$a r8 = new com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$a     // Catch:{ all -> 0x00ed }
            r8.<init>()     // Catch:{ all -> 0x00ed }
            r9 = r4
            com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$b r9 = (com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.b) r9     // Catch:{ all -> 0x00ed }
            long r9 = r9.f45221c     // Catch:{ all -> 0x00ed }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00ed }
            java.util.concurrent.ScheduledFuture r7 = r7.schedule(r8, r9, r11)     // Catch:{ all -> 0x00ed }
            r12.cancelFuture = r7     // Catch:{ all -> 0x00ed }
            goto L_0x004f
        L_0x0046:
            if (r4 != 0) goto L_0x004a
            monitor-exit(r12)     // Catch:{ all -> 0x00ed }
            return r1
        L_0x004a:
            r6 = r3
            goto L_0x004e
        L_0x004c:
            r4 = r3
            r6 = r4
        L_0x004e:
            r5 = 0
        L_0x004f:
            monitor-exit(r12)     // Catch:{ all -> 0x00ed }
            r7 = 1
            if (r2 == 0) goto L_0x005a
            r1 = 10
            r0.a(r1, r2)     // Catch:{ all -> 0x00e8 }
            goto L_0x00da
        L_0x005a:
            boolean r2 = r4 instanceof com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.c     // Catch:{ all -> 0x00e8 }
            if (r2 == 0) goto L_0x00a6
            r2 = r4
            com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$c r2 = (com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.c) r2     // Catch:{ all -> 0x00e8 }
            com.sendbird.android.shadow.okio.ByteString r2 = r2.f45223b     // Catch:{ all -> 0x00e8 }
            com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$c r4 = (com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.c) r4     // Catch:{ all -> 0x00e8 }
            int r4 = r4.f45222a     // Catch:{ all -> 0x00e8 }
            int r5 = r2.size()     // Catch:{ all -> 0x00e8 }
            long r5 = (long) r5     // Catch:{ all -> 0x00e8 }
            boolean r8 = r0.f45241h     // Catch:{ all -> 0x00e8 }
            if (r8 != 0) goto L_0x009e
            r0.f45241h = r7     // Catch:{ all -> 0x00e8 }
            com.sendbird.android.shadow.okhttp3.internal.ws.a$a r8 = r0.f45240g     // Catch:{ all -> 0x00e8 }
            r8.f45243a = r4     // Catch:{ all -> 0x00e8 }
            com.sendbird.android.shadow.okhttp3.internal.ws.a$a r4 = r0.f45240g     // Catch:{ all -> 0x00e8 }
            r4.f45244b = r5     // Catch:{ all -> 0x00e8 }
            com.sendbird.android.shadow.okhttp3.internal.ws.a$a r4 = r0.f45240g     // Catch:{ all -> 0x00e8 }
            r4.f45245c = r7     // Catch:{ all -> 0x00e8 }
            com.sendbird.android.shadow.okhttp3.internal.ws.a$a r4 = r0.f45240g     // Catch:{ all -> 0x00e8 }
            r4.f45246d = r1     // Catch:{ all -> 0x00e8 }
            com.sendbird.android.shadow.okhttp3.internal.ws.a$a r0 = r0.f45240g     // Catch:{ all -> 0x00e8 }
            com.sendbird.android.shadow.okio.BufferedSink r0 = com.sendbird.android.shadow.okio.Okio.buffer((com.sendbird.android.shadow.okio.Sink) r0)     // Catch:{ all -> 0x00e8 }
            r0.write((com.sendbird.android.shadow.okio.ByteString) r2)     // Catch:{ all -> 0x00e8 }
            r0.close()     // Catch:{ all -> 0x00e8 }
            monitor-enter(r12)     // Catch:{ all -> 0x00e8 }
            long r0 = r12.queueSize     // Catch:{ all -> 0x009b }
            int r2 = r2.size()     // Catch:{ all -> 0x009b }
            long r4 = (long) r2     // Catch:{ all -> 0x009b }
            long r0 = r0 - r4
            r12.queueSize = r0     // Catch:{ all -> 0x009b }
            monitor-exit(r12)     // Catch:{ all -> 0x009b }
            goto L_0x00da
        L_0x009b:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x009b }
            throw r0     // Catch:{ all -> 0x00e8 }
        L_0x009e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e8 }
            java.lang.String r1 = "Another message writer is active. Did you call close()?"
            r0.<init>(r1)     // Catch:{ all -> 0x00e8 }
            throw r0     // Catch:{ all -> 0x00e8 }
        L_0x00a6:
            boolean r1 = r4 instanceof com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.b     // Catch:{ all -> 0x00e8 }
            if (r1 == 0) goto L_0x00e2
            com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$b r4 = (com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.b) r4     // Catch:{ all -> 0x00e8 }
            int r1 = r4.f45219a     // Catch:{ all -> 0x00e8 }
            com.sendbird.android.shadow.okio.ByteString r2 = r4.f45220b     // Catch:{ all -> 0x00e8 }
            com.sendbird.android.shadow.okio.ByteString r4 = com.sendbird.android.shadow.okio.ByteString.EMPTY     // Catch:{ all -> 0x00e8 }
            if (r1 != 0) goto L_0x00b6
            if (r2 == 0) goto L_0x00cc
        L_0x00b6:
            if (r1 == 0) goto L_0x00bb
            com.sendbird.android.shadow.okhttp3.internal.ws.WebSocketProtocol.validateCloseCode(r1)     // Catch:{ all -> 0x00e8 }
        L_0x00bb:
            com.sendbird.android.shadow.okio.Buffer r4 = new com.sendbird.android.shadow.okio.Buffer     // Catch:{ all -> 0x00e8 }
            r4.<init>()     // Catch:{ all -> 0x00e8 }
            r4.writeShort((int) r1)     // Catch:{ all -> 0x00e8 }
            if (r2 == 0) goto L_0x00c8
            r4.write((com.sendbird.android.shadow.okio.ByteString) r2)     // Catch:{ all -> 0x00e8 }
        L_0x00c8:
            com.sendbird.android.shadow.okio.ByteString r4 = r4.readByteString()     // Catch:{ all -> 0x00e8 }
        L_0x00cc:
            r1 = 8
            r0.a(r1, r4)     // Catch:{ all -> 0x00de }
            r0.f45238e = r7     // Catch:{ all -> 0x00e8 }
            if (r3 == 0) goto L_0x00da
            com.sendbird.android.shadow.okhttp3.WebSocketListener r0 = r12.listener     // Catch:{ all -> 0x00e8 }
            r0.onClosed(r12, r5, r6)     // Catch:{ all -> 0x00e8 }
        L_0x00da:
            com.sendbird.android.shadow.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
            return r7
        L_0x00de:
            r1 = move-exception
            r0.f45238e = r7     // Catch:{ all -> 0x00e8 }
            throw r1     // Catch:{ all -> 0x00e8 }
        L_0x00e2:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x00e8 }
            r0.<init>()     // Catch:{ all -> 0x00e8 }
            throw r0     // Catch:{ all -> 0x00e8 }
        L_0x00e8:
            r0 = move-exception
            com.sendbird.android.shadow.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
            throw r0
        L_0x00ed:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00ed }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.writeOneFrame():boolean");
    }

    final class d implements Runnable {
        d() {
        }

        public final void run() {
            RealWebSocket.this.writePingFrame();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r1 == -1) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), (com.sendbird.android.shadow.okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.a(9, com.sendbird.android.shadow.okio.ByteString.EMPTY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        failWebSocket(r0, (com.sendbird.android.shadow.okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writePingFrame() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.failed     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)     // Catch:{ all -> 0x0052 }
            return
        L_0x0007:
            com.sendbird.android.shadow.okhttp3.internal.ws.a r0 = r7.writer     // Catch:{ all -> 0x0052 }
            boolean r1 = r7.awaitingPong     // Catch:{ all -> 0x0052 }
            r2 = -1
            if (r1 == 0) goto L_0x0011
            int r1 = r7.sentPingCount     // Catch:{ all -> 0x0052 }
            goto L_0x0012
        L_0x0011:
            r1 = -1
        L_0x0012:
            int r3 = r7.sentPingCount     // Catch:{ all -> 0x0052 }
            r4 = 1
            int r3 = r3 + r4
            r7.sentPingCount = r3     // Catch:{ all -> 0x0052 }
            r7.awaitingPong = r4     // Catch:{ all -> 0x0052 }
            monitor-exit(r7)     // Catch:{ all -> 0x0052 }
            r3 = 0
            if (r1 == r2) goto L_0x0045
            java.net.SocketTimeoutException r0 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "sent ping but didn't receive pong within "
            r2.<init>(r5)
            long r5 = r7.pingIntervalMillis
            r2.append(r5)
            java.lang.String r5 = "ms (after "
            r2.append(r5)
            int r1 = r1 - r4
            r2.append(r1)
            java.lang.String r1 = " successful ping/pongs)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            r7.failWebSocket(r0, r3)
            return
        L_0x0045:
            com.sendbird.android.shadow.okio.ByteString r1 = com.sendbird.android.shadow.okio.ByteString.EMPTY     // Catch:{ IOException -> 0x004d }
            r2 = 9
            r0.a(r2, r1)     // Catch:{ IOException -> 0x004d }
            return
        L_0x004d:
            r0 = move-exception
            r7.failWebSocket(r0, r3)
            return
        L_0x0052:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0052 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.writePingFrame():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3.listener.onFailure(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        com.sendbird.android.shadow.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void failWebSocket(java.lang.Exception r4, com.sendbird.android.shadow.okhttp3.Response r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.failed     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0007:
            r0 = 1
            r3.failed = r0     // Catch:{ all -> 0x0031 }
            com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket$Streams r0 = r3.streams     // Catch:{ all -> 0x0031 }
            r1 = 0
            r3.streams = r1     // Catch:{ all -> 0x0031 }
            java.util.concurrent.ScheduledFuture<?> r1 = r3.cancelFuture     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0019
            java.util.concurrent.ScheduledFuture<?> r1 = r3.cancelFuture     // Catch:{ all -> 0x0031 }
            r2 = 0
            r1.cancel(r2)     // Catch:{ all -> 0x0031 }
        L_0x0019:
            java.util.concurrent.ScheduledExecutorService r1 = r3.executor     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0022
            java.util.concurrent.ScheduledExecutorService r1 = r3.executor     // Catch:{ all -> 0x0031 }
            r1.shutdown()     // Catch:{ all -> 0x0031 }
        L_0x0022:
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            com.sendbird.android.shadow.okhttp3.WebSocketListener r1 = r3.listener     // Catch:{ all -> 0x002c }
            r1.onFailure(r3, r4, r5)     // Catch:{ all -> 0x002c }
            com.sendbird.android.shadow.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
            return
        L_0x002c:
            r4 = move-exception
            com.sendbird.android.shadow.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
            throw r4
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.ws.RealWebSocket.failWebSocket(java.lang.Exception, com.sendbird.android.shadow.okhttp3.Response):void");
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        final int f45222a;

        /* renamed from: b  reason: collision with root package name */
        final ByteString f45223b;

        c(int i2, ByteString byteString) {
            this.f45222a = i2;
            this.f45223b = byteString;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f45219a;

        /* renamed from: b  reason: collision with root package name */
        final ByteString f45220b;

        /* renamed from: c  reason: collision with root package name */
        final long f45221c;

        b(int i2, ByteString byteString, long j) {
            this.f45219a = i2;
            this.f45220b = byteString;
            this.f45221c = j;
        }
    }

    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    final class a implements Runnable {
        a() {
        }

        public final void run() {
            RealWebSocket.this.cancel();
        }
    }
}
