package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.internal.NamedRunnable;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.http2.b;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.Okio;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    /* access modifiers changed from: private */
    public static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    /* access modifiers changed from: private */
    public boolean awaitingPong;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests = new LinkedHashSet();
    final String hostname;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings = new Settings();
    final Settings peerSettings = new Settings();
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final b readerRunnable;
    boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    final c writer;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService writerExecutor;

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            public final void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    /* access modifiers changed from: package-private */
    public final boolean pushedStream(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    Http2Connection(Builder builder) {
        Builder builder2 = builder;
        this.pushObserver = builder2.pushObserver;
        this.client = builder2.client;
        this.listener = builder2.listener;
        this.nextStreamId = builder2.client ? 1 : 2;
        if (builder2.client) {
            this.nextStreamId += 2;
        }
        if (builder2.client) {
            this.okHttpSettings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        this.hostname = builder2.hostname;
        this.writerExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", this.hostname), false));
        if (builder2.pingIntervalMillis != 0) {
            this.writerExecutor.scheduleAtFixedRate(new a(false, 0, 0), (long) builder2.pingIntervalMillis, (long) builder2.pingIntervalMillis, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", this.hostname), true));
        this.peerSettings.set(7, 65535);
        this.peerSettings.set(5, 16384);
        this.bytesLeftInWriteWindow = (long) this.peerSettings.getInitialWindowSize();
        this.socket = builder2.socket;
        this.writer = new c(builder2.sink, this.client);
        this.readerRunnable = new b(new b(builder2.source, this.client));
    }

    public final Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    /* access modifiers changed from: package-private */
    public final synchronized Http2Stream getStream(int i2) {
        return this.streams.get(Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final synchronized Http2Stream removeStream(int i2) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public final synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void updateConnectionFlowControl(long j) {
        this.unacknowledgedBytesRead += j;
        if (this.unacknowledgedBytesRead >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0;
        }
    }

    public final Http2Stream pushStream(int i2, List<Header> list, boolean z) throws IOException {
        if (!this.client) {
            return newStream(i2, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    public final Http2Stream newStream(List<Header> list, boolean z) throws IOException {
        return newStream(0, list, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream newStream(int r11, java.util.List<com.sendbird.android.shadow.okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            com.sendbird.android.shadow.okhttp3.internal.http2.c r7 = r10.writer
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0078 }
            int r0 = r10.nextStreamId     // Catch:{ all -> 0x0075 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0012
            com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r0 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0075 }
            r10.shutdown(r0)     // Catch:{ all -> 0x0075 }
        L_0x0012:
            boolean r0 = r10.shutdown     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x006f
            int r8 = r10.nextStreamId     // Catch:{ all -> 0x0075 }
            int r0 = r10.nextStreamId     // Catch:{ all -> 0x0075 }
            int r0 = r0 + 2
            r10.nextStreamId = r0     // Catch:{ all -> 0x0075 }
            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r9 = new com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0075 }
            r4 = 0
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0075 }
            if (r13 == 0) goto L_0x003c
            long r0 = r10.bytesLeftInWriteWindow     // Catch:{ all -> 0x0075 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003c
            long r0 = r9.bytesLeftInWriteWindow     // Catch:{ all -> 0x0075 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r13 = 0
            goto L_0x003d
        L_0x003c:
            r13 = 1
        L_0x003d:
            boolean r0 = r9.isOpen()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x004c
            java.util.Map<java.lang.Integer, com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream> r0 = r10.streams     // Catch:{ all -> 0x0075 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0075 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0075 }
        L_0x004c:
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            if (r11 != 0) goto L_0x0055
            com.sendbird.android.shadow.okhttp3.internal.http2.c r11 = r10.writer     // Catch:{ all -> 0x0078 }
            r11.a((boolean) r6, (int) r8, (java.util.List<com.sendbird.android.shadow.okhttp3.internal.http2.Header>) r12)     // Catch:{ all -> 0x0078 }
            goto L_0x005e
        L_0x0055:
            boolean r0 = r10.client     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0067
            com.sendbird.android.shadow.okhttp3.internal.http2.c r0 = r10.writer     // Catch:{ all -> 0x0078 }
            r0.a((int) r11, (int) r8, (java.util.List<com.sendbird.android.shadow.okhttp3.internal.http2.Header>) r12)     // Catch:{ all -> 0x0078 }
        L_0x005e:
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x0066
            com.sendbird.android.shadow.okhttp3.internal.http2.c r11 = r10.writer
            r11.b()
        L_0x0066:
            return r9
        L_0x0067:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0078 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0078 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x006f:
            com.sendbird.android.shadow.okhttp3.internal.http2.ConnectionShutdownException r11 = new com.sendbird.android.shadow.okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0075 }
            r11.<init>()     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream");
    }

    /* access modifiers changed from: package-private */
    public final void writeSynReply(int i2, boolean z, List<Header> list) throws IOException {
        this.writer.b(z, i2, list);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.bytesLeftInWriteWindow), r8.writer.f45176a);
        r6 = (long) r3;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0059 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeData(int r9, boolean r10, com.sendbird.android.shadow.okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            com.sendbird.android.shadow.okhttp3.internal.http2.c r12 = r8.writer
            r12.a((boolean) r10, (int) r9, (com.sendbird.android.shadow.okio.Buffer) r11, (int) r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0068
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.bytesLeftInWriteWindow     // Catch:{ InterruptedException -> 0x0059 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0031
            java.util.Map<java.lang.Integer, com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream> r3 = r8.streams     // Catch:{ InterruptedException -> 0x0059 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0059 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0059 }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0059 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0059 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0059 }
            throw r9     // Catch:{ InterruptedException -> 0x0059 }
        L_0x0031:
            long r3 = r8.bytesLeftInWriteWindow     // Catch:{ all -> 0x0057 }
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0057 }
            int r4 = (int) r3     // Catch:{ all -> 0x0057 }
            com.sendbird.android.shadow.okhttp3.internal.http2.c r3 = r8.writer     // Catch:{ all -> 0x0057 }
            int r3 = r3.f45176a     // Catch:{ all -> 0x0057 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0057 }
            long r4 = r8.bytesLeftInWriteWindow     // Catch:{ all -> 0x0057 }
            long r6 = (long) r3     // Catch:{ all -> 0x0057 }
            long r4 = r4 - r6
            r8.bytesLeftInWriteWindow = r4     // Catch:{ all -> 0x0057 }
            monitor-exit(r8)     // Catch:{ all -> 0x0057 }
            long r12 = r12 - r6
            com.sendbird.android.shadow.okhttp3.internal.http2.c r4 = r8.writer
            if (r10 == 0) goto L_0x0052
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0052
            r5 = 1
            goto L_0x0053
        L_0x0052:
            r5 = 0
        L_0x0053:
            r4.a((boolean) r5, (int) r9, (com.sendbird.android.shadow.okio.Buffer) r11, (int) r3)
            goto L_0x000d
        L_0x0057:
            r9 = move-exception
            goto L_0x0066
        L_0x0059:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0057 }
            r9.interrupt()     // Catch:{ all -> 0x0057 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0057 }
            r9.<init>()     // Catch:{ all -> 0x0057 }
            throw r9     // Catch:{ all -> 0x0057 }
        L_0x0066:
            monitor-exit(r8)     // Catch:{ all -> 0x0057 }
            throw r9
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.writeData(int, boolean, com.sendbird.android.shadow.okio.Buffer, long):void");
    }

    /* access modifiers changed from: package-private */
    public final void writeSynResetLater(int i2, ErrorCode errorCode) {
        try {
            final int i3 = i2;
            final ErrorCode errorCode2 = errorCode;
            this.writerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i2)}) {
                public final void execute() {
                    try {
                        Http2Connection.this.writeSynReset(i3, errorCode2);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void writeSynReset(int i2, ErrorCode errorCode) throws IOException {
        this.writer.a(i2, errorCode);
    }

    /* access modifiers changed from: package-private */
    public final void writeWindowUpdateLater(int i2, long j) {
        try {
            final int i3 = i2;
            final long j2 = j;
            this.writerExecutor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i2)}) {
                public final void execute() {
                    try {
                        Http2Connection.this.writer.a(i3, j2);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    final class a extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final boolean f45120a;

        /* renamed from: b  reason: collision with root package name */
        final int f45121b;

        /* renamed from: c  reason: collision with root package name */
        final int f45122c;

        a(boolean z, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.hostname, Integer.valueOf(i2), Integer.valueOf(i3));
            this.f45120a = z;
            this.f45121b = i2;
            this.f45122c = i3;
        }

        public final void execute() {
            Http2Connection.this.writePing(this.f45120a, this.f45121b, this.f45122c);
        }
    }

    /* access modifiers changed from: package-private */
    public final void writePing(boolean z, int i2, int i3) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.awaitingPong;
                this.awaitingPong = true;
            }
            if (z2) {
                failConnection();
                return;
            }
        }
        try {
            this.writer.a(z, i2, i3);
        } catch (IOException unused) {
            failConnection();
        }
    }

    /* access modifiers changed from: package-private */
    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing(false, 1330343787, -257978967);
        awaitPong();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitingPong) {
            wait();
        }
    }

    public final void flush() throws IOException {
        this.writer.b();
    }

    public final void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    int i2 = this.lastGoodStreamId;
                    this.writer.a(i2, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public final void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: package-private */
    public final void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                this.streams.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream close : http2StreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e5) {
            e = e5;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: private */
    public void failConnection() {
        try {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            close(errorCode, errorCode);
        } catch (IOException unused) {
        }
    }

    public final void start() throws IOException {
        start(true);
    }

    /* access modifiers changed from: package-private */
    public final void start(boolean z) throws IOException {
        if (z) {
            this.writer.a();
            this.writer.b(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.a(0, (long) (initialWindowSize - 65535));
            }
        }
        new Thread(this.readerRunnable).start();
    }

    public final void setSettings(Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.okHttpSettings.merge(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.b(settings);
        }
    }

    public final synchronized boolean isShutdown() {
        return this.shutdown;
    }

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        int pingIntervalMillis;
        PushObserver pushObserver = PushObserver.CANCEL;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder(boolean z) {
            this.client = z;
        }

        public Builder socket(Socket socket2) throws IOException {
            return socket(socket2, ((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket2)), Okio.buffer(Okio.sink(socket2)));
        }

        public Builder socket(Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket2;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }

        public Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Builder pingIntervalMillis(int i2) {
            this.pingIntervalMillis = i2;
            return this;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    class b extends NamedRunnable implements b.C0759b {

        /* renamed from: a  reason: collision with root package name */
        final b f45124a;

        b(b bVar) {
            super("OkHttp %s", Http2Connection.this.hostname);
            this.f45124a = bVar;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:28|29|30|31) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r0 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
            r1 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r2 = r9.f45125b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            r9.f45125b.close(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0082, code lost:
            com.sendbird.android.shadow.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9.f45124a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0087, code lost:
            throw r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0076 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void execute() {
            /*
                r9 = this;
                com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r0 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r1 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                com.sendbird.android.shadow.okhttp3.internal.http2.b r2 = r9.f45124a     // Catch:{ IOException -> 0x0076 }
                boolean r3 = r2.f45166c     // Catch:{ IOException -> 0x0076 }
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L_0x001c
                boolean r2 = r2.a(r4, r9)     // Catch:{ IOException -> 0x0076 }
                if (r2 == 0) goto L_0x0013
                goto L_0x004e
            L_0x0013:
                java.lang.String r2 = "Required SETTINGS preface not received"
                java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0076 }
                java.io.IOException r2 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r2, r3)     // Catch:{ IOException -> 0x0076 }
                throw r2     // Catch:{ IOException -> 0x0076 }
            L_0x001c:
                com.sendbird.android.shadow.okio.BufferedSource r2 = r2.f45165b     // Catch:{ IOException -> 0x0076 }
                com.sendbird.android.shadow.okio.ByteString r3 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.CONNECTION_PREFACE     // Catch:{ IOException -> 0x0076 }
                int r3 = r3.size()     // Catch:{ IOException -> 0x0076 }
                long r6 = (long) r3     // Catch:{ IOException -> 0x0076 }
                com.sendbird.android.shadow.okio.ByteString r2 = r2.readByteString(r6)     // Catch:{ IOException -> 0x0076 }
                java.util.logging.Logger r3 = com.sendbird.android.shadow.okhttp3.internal.http2.b.f45164a     // Catch:{ IOException -> 0x0076 }
                java.util.logging.Level r6 = java.util.logging.Level.FINE     // Catch:{ IOException -> 0x0076 }
                boolean r3 = r3.isLoggable(r6)     // Catch:{ IOException -> 0x0076 }
                if (r3 == 0) goto L_0x0046
                java.util.logging.Logger r3 = com.sendbird.android.shadow.okhttp3.internal.http2.b.f45164a     // Catch:{ IOException -> 0x0076 }
                java.lang.String r6 = "<< CONNECTION %s"
                java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0076 }
                java.lang.String r8 = r2.hex()     // Catch:{ IOException -> 0x0076 }
                r7[r5] = r8     // Catch:{ IOException -> 0x0076 }
                java.lang.String r6 = com.sendbird.android.shadow.okhttp3.internal.Util.format(r6, r7)     // Catch:{ IOException -> 0x0076 }
                r3.fine(r6)     // Catch:{ IOException -> 0x0076 }
            L_0x0046:
                com.sendbird.android.shadow.okio.ByteString r3 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.CONNECTION_PREFACE     // Catch:{ IOException -> 0x0076 }
                boolean r3 = r3.equals(r2)     // Catch:{ IOException -> 0x0076 }
                if (r3 == 0) goto L_0x0065
            L_0x004e:
                com.sendbird.android.shadow.okhttp3.internal.http2.b r2 = r9.f45124a     // Catch:{ IOException -> 0x0076 }
                boolean r2 = r2.a(r5, r9)     // Catch:{ IOException -> 0x0076 }
                if (r2 != 0) goto L_0x004e
                com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r0 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x0076 }
                com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r1 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x0076 }
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r2 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x005f }
            L_0x005c:
                r2.close(r0, r1)     // Catch:{ IOException -> 0x005f }
            L_0x005f:
                com.sendbird.android.shadow.okhttp3.internal.http2.b r0 = r9.f45124a
                com.sendbird.android.shadow.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                return
            L_0x0065:
                java.lang.String r3 = "Expected a connection header but was %s"
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0076 }
                java.lang.String r2 = r2.utf8()     // Catch:{ IOException -> 0x0076 }
                r4[r5] = r2     // Catch:{ IOException -> 0x0076 }
                java.io.IOException r2 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r3, r4)     // Catch:{ IOException -> 0x0076 }
                throw r2     // Catch:{ IOException -> 0x0076 }
            L_0x0074:
                r2 = move-exception
                goto L_0x007d
            L_0x0076:
                com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r0 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x0074 }
                com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r1 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x0074 }
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r2 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x005f }
                goto L_0x005c
            L_0x007d:
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r3 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0082 }
                r3.close(r0, r1)     // Catch:{ IOException -> 0x0082 }
            L_0x0082:
                com.sendbird.android.shadow.okhttp3.internal.http2.b r0 = r9.f45124a
                com.sendbird.android.shadow.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.b.execute():void");
        }

        public final void a(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException {
            if (Http2Connection.this.pushedStream(i2)) {
                Http2Connection.this.pushDataLater(i2, bufferedSource, i3, z);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i2);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i2, ErrorCode.PROTOCOL_ERROR);
                long j = (long) i3;
                Http2Connection.this.updateConnectionFlowControl(j);
                bufferedSource.skip(j);
                return;
            }
            stream.receiveData(bufferedSource, i3);
            if (z) {
                stream.receiveFin();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
            r1.receiveHeaders(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
            if (r11 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0079, code lost:
            r1.receiveFin();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(boolean r11, int r12, java.util.List<com.sendbird.android.shadow.okhttp3.internal.http2.Header> r13) {
            /*
                r10 = this;
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this
                boolean r0 = r0.pushedStream(r12)
                if (r0 == 0) goto L_0x000e
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this
                r0.pushHeadersLater(r12, r13, r11)
                return
            L_0x000e:
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this
                monitor-enter(r0)
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r1 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r1 = r1.getStream(r12)     // Catch:{ all -> 0x007d }
                if (r1 != 0) goto L_0x0073
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r1 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                boolean r1 = r1.shutdown     // Catch:{ all -> 0x007d }
                if (r1 == 0) goto L_0x0021
                monitor-exit(r0)     // Catch:{ all -> 0x007d }
                return
            L_0x0021:
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r1 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                int r1 = r1.lastGoodStreamId     // Catch:{ all -> 0x007d }
                if (r12 > r1) goto L_0x0029
                monitor-exit(r0)     // Catch:{ all -> 0x007d }
                return
            L_0x0029:
                int r1 = r12 % 2
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r2 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                int r2 = r2.nextStreamId     // Catch:{ all -> 0x007d }
                r3 = 2
                int r2 = r2 % r3
                if (r1 != r2) goto L_0x0035
                monitor-exit(r0)     // Catch:{ all -> 0x007d }
                return
            L_0x0035:
                com.sendbird.android.shadow.okhttp3.Headers r9 = com.sendbird.android.shadow.okhttp3.internal.Util.toHeaders(r13)     // Catch:{ all -> 0x007d }
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r13 = new com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x007d }
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r6 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                r7 = 0
                r4 = r13
                r5 = r12
                r8 = r11
                r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x007d }
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                r11.lastGoodStreamId = r12     // Catch:{ all -> 0x007d }
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                java.util.Map<java.lang.Integer, com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream> r11 = r11.streams     // Catch:{ all -> 0x007d }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x007d }
                r11.put(r1, r13)     // Catch:{ all -> 0x007d }
                java.util.concurrent.ExecutorService r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.listenerExecutor     // Catch:{ all -> 0x007d }
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection$b$1 r1 = new com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection$b$1     // Catch:{ all -> 0x007d }
                java.lang.String r2 = "OkHttp %s stream %d"
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x007d }
                r4 = 0
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r5 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x007d }
                java.lang.String r5 = r5.hostname     // Catch:{ all -> 0x007d }
                r3[r4] = r5     // Catch:{ all -> 0x007d }
                r4 = 1
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x007d }
                r3[r4] = r12     // Catch:{ all -> 0x007d }
                r1.<init>(r2, r3, r13)     // Catch:{ all -> 0x007d }
                r11.execute(r1)     // Catch:{ all -> 0x007d }
                monitor-exit(r0)     // Catch:{ all -> 0x007d }
                return
            L_0x0073:
                monitor-exit(r0)     // Catch:{ all -> 0x007d }
                r1.receiveHeaders(r13)
                if (r11 == 0) goto L_0x007c
                r1.receiveFin()
            L_0x007c:
                return
            L_0x007d:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x007d }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.b.a(boolean, int, java.util.List):void");
        }

        public final void a(int i2, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(i2)) {
                Http2Connection.this.pushResetLater(i2, errorCode);
                return;
            }
            Http2Stream removeStream = Http2Connection.this.removeStream(i2);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        public final void a(final Settings settings) {
            try {
                Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.hostname}) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ boolean f45128a = false;

                    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|d|17|18|19|20|21) */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0069 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void execute() {
                        /*
                            r8 = this;
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection$b r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.b.this
                            boolean r1 = r8.f45128a
                            com.sendbird.android.shadow.okhttp3.internal.http2.Settings r2 = r7
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r3 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this
                            com.sendbird.android.shadow.okhttp3.internal.http2.c r3 = r3.writer
                            monitor-enter(r3)
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r4 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x009e }
                            monitor-enter(r4)     // Catch:{ all -> 0x009e }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r5 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x009b }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Settings r5 = r5.peerSettings     // Catch:{ all -> 0x009b }
                            int r5 = r5.getInitialWindowSize()     // Catch:{ all -> 0x009b }
                            if (r1 == 0) goto L_0x001f
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r1 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x009b }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Settings r1 = r1.peerSettings     // Catch:{ all -> 0x009b }
                            r1.clear()     // Catch:{ all -> 0x009b }
                        L_0x001f:
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r1 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x009b }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Settings r1 = r1.peerSettings     // Catch:{ all -> 0x009b }
                            r1.merge(r2)     // Catch:{ all -> 0x009b }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r1 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x009b }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Settings r1 = r1.peerSettings     // Catch:{ all -> 0x009b }
                            int r1 = r1.getInitialWindowSize()     // Catch:{ all -> 0x009b }
                            r2 = -1
                            r6 = 0
                            if (r1 == r2) goto L_0x005a
                            if (r1 == r5) goto L_0x005a
                            int r1 = r1 - r5
                            long r1 = (long) r1     // Catch:{ all -> 0x009b }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r5 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x009b }
                            java.util.Map<java.lang.Integer, com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream> r5 = r5.streams     // Catch:{ all -> 0x009b }
                            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x009b }
                            if (r5 != 0) goto L_0x005c
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r5 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x009b }
                            java.util.Map<java.lang.Integer, com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream> r5 = r5.streams     // Catch:{ all -> 0x009b }
                            java.util.Collection r5 = r5.values()     // Catch:{ all -> 0x009b }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r6 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x009b }
                            java.util.Map<java.lang.Integer, com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream> r6 = r6.streams     // Catch:{ all -> 0x009b }
                            int r6 = r6.size()     // Catch:{ all -> 0x009b }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream[] r6 = new com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream[r6]     // Catch:{ all -> 0x009b }
                            java.lang.Object[] r5 = r5.toArray(r6)     // Catch:{ all -> 0x009b }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream[] r5 = (com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream[]) r5     // Catch:{ all -> 0x009b }
                            r6 = r5
                            goto L_0x005c
                        L_0x005a:
                            r1 = 0
                        L_0x005c:
                            monitor-exit(r4)     // Catch:{ all -> 0x009b }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r4 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0069 }
                            com.sendbird.android.shadow.okhttp3.internal.http2.c r4 = r4.writer     // Catch:{ IOException -> 0x0069 }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r5 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0069 }
                            com.sendbird.android.shadow.okhttp3.internal.http2.Settings r5 = r5.peerSettings     // Catch:{ IOException -> 0x0069 }
                            r4.a(r5)     // Catch:{ IOException -> 0x0069 }
                            goto L_0x006e
                        L_0x0069:
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r4 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x009e }
                            r4.failConnection()     // Catch:{ all -> 0x009e }
                        L_0x006e:
                            monitor-exit(r3)     // Catch:{ all -> 0x009e }
                            r3 = 0
                            if (r6 == 0) goto L_0x0083
                            int r4 = r6.length
                            r5 = 0
                        L_0x0074:
                            if (r5 >= r4) goto L_0x0083
                            r7 = r6[r5]
                            monitor-enter(r7)
                            r7.addBytesToWriteWindow(r1)     // Catch:{ all -> 0x0080 }
                            monitor-exit(r7)     // Catch:{ all -> 0x0080 }
                            int r5 = r5 + 1
                            goto L_0x0074
                        L_0x0080:
                            r0 = move-exception
                            monitor-exit(r7)     // Catch:{ all -> 0x0080 }
                            throw r0
                        L_0x0083:
                            java.util.concurrent.ExecutorService r1 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.listenerExecutor
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection$b$3 r2 = new com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection$b$3
                            r4 = 1
                            java.lang.Object[] r4 = new java.lang.Object[r4]
                            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r5 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.this
                            java.lang.String r5 = r5.hostname
                            r4[r3] = r5
                            java.lang.String r3 = "OkHttp %s settings"
                            r2.<init>(r3, r4)
                            r1.execute(r2)
                            return
                        L_0x009b:
                            r0 = move-exception
                            monitor-exit(r4)     // Catch:{ all -> 0x009b }
                            throw r0     // Catch:{ all -> 0x009e }
                        L_0x009e:
                            r0 = move-exception
                            monitor-exit(r3)     // Catch:{ all -> 0x009e }
                            throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection.b.AnonymousClass2.execute():void");
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        public final void a(boolean z, int i2, int i3) {
            if (z) {
                synchronized (Http2Connection.this) {
                    boolean unused = Http2Connection.this.awaitingPong = false;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            try {
                Http2Connection.this.writerExecutor.execute(new a(true, i2, i3));
            } catch (RejectedExecutionException unused2) {
            }
        }

        public final void a(int i2, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i2 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        public final void a(int i2, long j) {
            if (i2 == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.bytesLeftInWriteWindow += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i2);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        public final void a(int i2, List<Header> list) {
            Http2Connection.this.pushRequestLater(i2, list);
        }
    }

    /* access modifiers changed from: package-private */
    public final void pushRequestLater(int i2, List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i2))) {
                writeSynResetLater(i2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i2));
            try {
                final int i3 = i2;
                final List<Header> list2 = list;
                pushExecutorExecute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostname, Integer.valueOf(i2)}) {
                    public final void execute() {
                        if (Http2Connection.this.pushObserver.onRequest(i3, list2)) {
                            try {
                                Http2Connection.this.writer.a(i3, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i3));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void pushHeadersLater(int i2, List<Header> list, boolean z) {
        try {
            final int i3 = i2;
            final List<Header> list2 = list;
            final boolean z2 = z;
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i2)}) {
                public final void execute() {
                    boolean onHeaders = Http2Connection.this.pushObserver.onHeaders(i3, list2, z2);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.writer.a(i3, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (!onHeaders) {
                        if (!z2) {
                            return;
                        }
                    }
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i3));
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void pushDataLater(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = (long) i3;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            final int i4 = i2;
            final int i5 = i3;
            final boolean z2 = z;
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i2)}) {
                public final void execute() {
                    try {
                        boolean onData = Http2Connection.this.pushObserver.onData(i4, buffer, i5, z2);
                        if (onData) {
                            Http2Connection.this.writer.a(i4, ErrorCode.CANCEL);
                        }
                        if (!onData) {
                            if (!z2) {
                                return;
                            }
                        }
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i4));
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i3);
    }

    /* access modifiers changed from: package-private */
    public final void pushResetLater(int i2, ErrorCode errorCode) {
        final int i3 = i2;
        final ErrorCode errorCode2 = errorCode;
        pushExecutorExecute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i2)}) {
            public final void execute() {
                Http2Connection.this.pushObserver.onReset(i3, errorCode2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i3));
                }
            }
        });
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!isShutdown()) {
            this.pushExecutor.execute(namedRunnable);
        }
    }
}
