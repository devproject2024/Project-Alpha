package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.FrameReader;
import i.c;
import i.e;
import i.f;
import i.n;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class FramedConnection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    /* access modifiers changed from: private */
    public static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    /* access modifiers changed from: private */
    public final Set<Integer> currentPushRequests;
    final FrameWriter frameWriter;
    /* access modifiers changed from: private */
    public final IncomingStreamHandler handler;
    /* access modifiers changed from: private */
    public final String hostName;
    private long idleStartTimeNs;
    /* access modifiers changed from: private */
    public int lastGoodStreamId;
    private int nextPingId;
    /* access modifiers changed from: private */
    public int nextStreamId;
    final Settings okHttpSettings;
    final Settings peerSettings;
    private Map<Integer, Ping> pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    /* access modifiers changed from: private */
    public final PushObserver pushObserver;
    final Reader readerRunnable;
    /* access modifiers changed from: private */
    public boolean receivedInitialPeerSettings;
    /* access modifiers changed from: private */
    public boolean shutdown;
    final Socket socket;
    /* access modifiers changed from: private */
    public final Map<Integer, FramedStream> streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    private FramedConnection(Builder builder) throws IOException {
        this.streams = new HashMap();
        this.idleStartTimeNs = System.nanoTime();
        this.unacknowledgedBytesRead = 0;
        this.okHttpSettings = new Settings();
        this.peerSettings = new Settings();
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        this.protocol = builder.protocol;
        this.pushObserver = builder.pushObserver;
        this.client = builder.client;
        this.handler = builder.handler;
        int i2 = 2;
        this.nextStreamId = builder.client ? 1 : 2;
        if (builder.client && this.protocol == Protocol.HTTP_2) {
            this.nextStreamId += 2;
        }
        this.nextPingId = builder.client ? 1 : i2;
        if (builder.client) {
            this.okHttpSettings.set(7, 0, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        this.hostName = builder.hostName;
        if (this.protocol == Protocol.HTTP_2) {
            this.variant = new Http2();
            this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[]{this.hostName}), true));
            this.peerSettings.set(7, 0, 65535);
            this.peerSettings.set(5, 0, 16384);
        } else if (this.protocol == Protocol.SPDY_3) {
            this.variant = new Spdy3();
            this.pushExecutor = null;
        } else {
            throw new AssertionError(this.protocol);
        }
        this.bytesLeftInWriteWindow = (long) this.peerSettings.getInitialWindowSize(65536);
        this.socket = builder.socket;
        this.frameWriter = this.variant.newWriter(n.a(n.a(builder.socket)), this.client);
        this.readerRunnable = new Reader();
        new Thread(this.readerRunnable).start();
    }

    public final Protocol getProtocol() {
        return this.protocol;
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    /* access modifiers changed from: package-private */
    public final synchronized FramedStream getStream(int i2) {
        return this.streams.get(Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final synchronized FramedStream removeStream(int i2) {
        FramedStream remove;
        remove = this.streams.remove(Integer.valueOf(i2));
        if (remove != null && this.streams.isEmpty()) {
            setIdle(true);
        }
        notifyAll();
        return remove;
    }

    private synchronized void setIdle(boolean z) {
        long j;
        if (z) {
            try {
                j = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            j = Long.MAX_VALUE;
        }
        this.idleStartTimeNs = j;
    }

    public final synchronized boolean isIdle() {
        return this.idleStartTimeNs != Long.MAX_VALUE;
    }

    public final synchronized long getIdleStartTimeNs() {
        return this.idleStartTimeNs;
    }

    public final FramedStream pushStream(int i2, List<Header> list, boolean z) throws IOException {
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        } else if (this.protocol == Protocol.HTTP_2) {
            return newStream(i2, list, z, false);
        } else {
            throw new IllegalStateException("protocol != HTTP_2");
        }
    }

    public final FramedStream newStream(List<Header> list, boolean z, boolean z2) throws IOException {
        return newStream(0, list, z, z2);
    }

    private FramedStream newStream(int i2, List<Header> list, boolean z, boolean z2) throws IOException {
        int i3;
        FramedStream framedStream;
        boolean z3 = !z;
        boolean z4 = !z2;
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (!this.shutdown) {
                    i3 = this.nextStreamId;
                    this.nextStreamId += 2;
                    framedStream = new FramedStream(i3, this, z3, z4, list);
                    if (framedStream.isOpen()) {
                        this.streams.put(Integer.valueOf(i3), framedStream);
                        setIdle(false);
                    }
                } else {
                    throw new IOException("shutdown");
                }
            }
            if (i2 == 0) {
                this.frameWriter.synStream(z3, z4, i3, i2, list);
            } else if (!this.client) {
                this.frameWriter.pushPromise(i2, i3, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (!z) {
            this.frameWriter.flush();
        }
        return framedStream;
    }

    /* access modifiers changed from: package-private */
    public final void writeSynReply(int i2, boolean z, List<Header> list) throws IOException {
        this.frameWriter.synReply(z, i2, list);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.bytesLeftInWriteWindow), r8.frameWriter.maxDataLength());
        r6 = (long) r3;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeData(int r9, boolean r10, i.c r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            com.squareup.okhttp.internal.framed.FrameWriter r12 = r8.frameWriter
            r12.data(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0062
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.bytesLeftInWriteWindow     // Catch:{ InterruptedException -> 0x005a }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, com.squareup.okhttp.internal.framed.FramedStream> r3 = r8.streams     // Catch:{ InterruptedException -> 0x005a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005a }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x005a }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005a }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005a }
            throw r9     // Catch:{ InterruptedException -> 0x005a }
        L_0x0030:
            long r3 = r8.bytesLeftInWriteWindow     // Catch:{ all -> 0x0058 }
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0058 }
            int r4 = (int) r3     // Catch:{ all -> 0x0058 }
            com.squareup.okhttp.internal.framed.FrameWriter r3 = r8.frameWriter     // Catch:{ all -> 0x0058 }
            int r3 = r3.maxDataLength()     // Catch:{ all -> 0x0058 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0058 }
            long r4 = r8.bytesLeftInWriteWindow     // Catch:{ all -> 0x0058 }
            long r6 = (long) r3     // Catch:{ all -> 0x0058 }
            long r4 = r4 - r6
            r8.bytesLeftInWriteWindow = r4     // Catch:{ all -> 0x0058 }
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            long r12 = r12 - r6
            com.squareup.okhttp.internal.framed.FrameWriter r4 = r8.frameWriter
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            r4.data(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0058:
            r9 = move-exception
            goto L_0x0060
        L_0x005a:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0058 }
            r9.<init>()     // Catch:{ all -> 0x0058 }
            throw r9     // Catch:{ all -> 0x0058 }
        L_0x0060:
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            throw r9
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedConnection.writeData(int, boolean, i.c, long):void");
    }

    /* access modifiers changed from: package-private */
    public final void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public final void writeSynResetLater(int i2, ErrorCode errorCode) {
        final int i3 = i2;
        final ErrorCode errorCode2 = errorCode;
        executor.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostName, Integer.valueOf(i2)}) {
            public void execute() {
                try {
                    FramedConnection.this.writeSynReset(i3, errorCode2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void writeSynReset(int i2, ErrorCode errorCode) throws IOException {
        this.frameWriter.rstStream(i2, errorCode);
    }

    /* access modifiers changed from: package-private */
    public final void writeWindowUpdateLater(int i2, long j) {
        final int i3 = i2;
        final long j2 = j;
        executor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostName, Integer.valueOf(i2)}) {
            public void execute() {
                try {
                    FramedConnection.this.frameWriter.windowUpdate(i3, j2);
                } catch (IOException unused) {
                }
            }
        });
    }

    public final Ping ping() throws IOException {
        int i2;
        Ping ping = new Ping();
        synchronized (this) {
            if (!this.shutdown) {
                i2 = this.nextPingId;
                this.nextPingId += 2;
                if (this.pings == null) {
                    this.pings = new HashMap();
                }
                this.pings.put(Integer.valueOf(i2), ping);
            } else {
                throw new IOException("shutdown");
            }
        }
        writePing(false, i2, 1330343787, ping);
        return ping;
    }

    /* access modifiers changed from: private */
    public void writePingLater(boolean z, int i2, int i3, Ping ping) {
        final boolean z2 = z;
        final int i4 = i2;
        final int i5 = i3;
        final Ping ping2 = ping;
        executor.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.hostName, Integer.valueOf(i2), Integer.valueOf(i3)}) {
            public void execute() {
                try {
                    FramedConnection.this.writePing(z2, i4, i5, ping2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void writePing(boolean z, int i2, int i3, Ping ping) throws IOException {
        synchronized (this.frameWriter) {
            if (ping != null) {
                ping.send();
            }
            this.frameWriter.ping(z, i2, i3);
        }
    }

    /* access modifiers changed from: private */
    public synchronized Ping removePing(int i2) {
        if (this.pings == null) {
            return null;
        }
        return this.pings.remove(Integer.valueOf(i2));
    }

    public final void flush() throws IOException {
        this.frameWriter.flush();
    }

    public final void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    int i2 = this.lastGoodStreamId;
                    this.frameWriter.goAway(i2, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public final void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: private */
    public void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        int i2;
        FramedStream[] framedStreamArr;
        Ping[] pingArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                framedStreamArr = (FramedStream[]) this.streams.values().toArray(new FramedStream[this.streams.size()]);
                this.streams.clear();
                setIdle(false);
            } else {
                framedStreamArr = null;
            }
            if (this.pings != null) {
                this.pings = null;
                pingArr = (Ping[]) this.pings.values().toArray(new Ping[this.pings.size()]);
            }
        }
        if (framedStreamArr != null) {
            IOException iOException = e;
            for (FramedStream close : framedStreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e3) {
                    if (iOException != null) {
                        iOException = e3;
                    }
                }
            }
            e = iOException;
        }
        if (pingArr != null) {
            for (Ping cancel : pingArr) {
                cancel.cancel();
            }
        }
        try {
            this.frameWriter.close();
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
        if (e != null) {
            throw e;
        }
    }

    public final void sendConnectionPreface() throws IOException {
        this.frameWriter.connectionPreface();
        this.frameWriter.settings(this.okHttpSettings);
        int initialWindowSize = this.okHttpSettings.getInitialWindowSize(65536);
        if (initialWindowSize != 65536) {
            this.frameWriter.windowUpdate(0, (long) (initialWindowSize - 65536));
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean client;
        /* access modifiers changed from: private */
        public IncomingStreamHandler handler;
        /* access modifiers changed from: private */
        public String hostName;
        /* access modifiers changed from: private */
        public Protocol protocol;
        /* access modifiers changed from: private */
        public PushObserver pushObserver;
        /* access modifiers changed from: private */
        public Socket socket;

        public Builder(boolean z, Socket socket2) throws IOException {
            this(((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), z, socket2);
        }

        public Builder(String str, boolean z, Socket socket2) throws IOException {
            this.handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            this.protocol = Protocol.SPDY_3;
            this.pushObserver = PushObserver.CANCEL;
            this.hostName = str;
            this.client = z;
            this.socket = socket2;
        }

        public Builder handler(IncomingStreamHandler incomingStreamHandler) {
            this.handler = incomingStreamHandler;
            return this;
        }

        public Builder protocol(Protocol protocol2) {
            this.protocol = protocol2;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public FramedConnection build() throws IOException {
            return new FramedConnection(this);
        }
    }

    class Reader extends NamedRunnable implements FrameReader.Handler {
        FrameReader frameReader;

        public void ackSettings() {
        }

        public void alternateService(int i2, String str, f fVar, String str2, int i3, long j) {
        }

        public void priority(int i2, int i3, int i4, boolean z) {
        }

        private Reader() {
            super("OkHttp %s", FramedConnection.this.hostName);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:15|16|17|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0 = com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR;
            r1 = com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r2 = r5.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            com.squareup.okhttp.internal.framed.FramedConnection.access$1000(r5.this$0, r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
            com.squareup.okhttp.internal.Util.closeQuietly((java.io.Closeable) r5.frameReader);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
            throw r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0042 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r5 = this;
                com.squareup.okhttp.internal.framed.ErrorCode r0 = com.squareup.okhttp.internal.framed.ErrorCode.INTERNAL_ERROR
                com.squareup.okhttp.internal.framed.ErrorCode r1 = com.squareup.okhttp.internal.framed.ErrorCode.INTERNAL_ERROR
                com.squareup.okhttp.internal.framed.FramedConnection r2 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ IOException -> 0x0042 }
                com.squareup.okhttp.internal.framed.Variant r2 = r2.variant     // Catch:{ IOException -> 0x0042 }
                com.squareup.okhttp.internal.framed.FramedConnection r3 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ IOException -> 0x0042 }
                java.net.Socket r3 = r3.socket     // Catch:{ IOException -> 0x0042 }
                i.v r3 = i.n.b((java.net.Socket) r3)     // Catch:{ IOException -> 0x0042 }
                i.e r3 = i.n.a((i.v) r3)     // Catch:{ IOException -> 0x0042 }
                com.squareup.okhttp.internal.framed.FramedConnection r4 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ IOException -> 0x0042 }
                boolean r4 = r4.client     // Catch:{ IOException -> 0x0042 }
                com.squareup.okhttp.internal.framed.FrameReader r2 = r2.newReader(r3, r4)     // Catch:{ IOException -> 0x0042 }
                r5.frameReader = r2     // Catch:{ IOException -> 0x0042 }
                com.squareup.okhttp.internal.framed.FramedConnection r2 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ IOException -> 0x0042 }
                boolean r2 = r2.client     // Catch:{ IOException -> 0x0042 }
                if (r2 != 0) goto L_0x0029
                com.squareup.okhttp.internal.framed.FrameReader r2 = r5.frameReader     // Catch:{ IOException -> 0x0042 }
                r2.readConnectionPreface()     // Catch:{ IOException -> 0x0042 }
            L_0x0029:
                com.squareup.okhttp.internal.framed.FrameReader r2 = r5.frameReader     // Catch:{ IOException -> 0x0042 }
                boolean r2 = r2.nextFrame(r5)     // Catch:{ IOException -> 0x0042 }
                if (r2 != 0) goto L_0x0029
                com.squareup.okhttp.internal.framed.ErrorCode r0 = com.squareup.okhttp.internal.framed.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x0042 }
                com.squareup.okhttp.internal.framed.ErrorCode r1 = com.squareup.okhttp.internal.framed.ErrorCode.CANCEL     // Catch:{ IOException -> 0x0042 }
                com.squareup.okhttp.internal.framed.FramedConnection r2 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ IOException -> 0x003a }
            L_0x0037:
                r2.close(r0, r1)     // Catch:{ IOException -> 0x003a }
            L_0x003a:
                com.squareup.okhttp.internal.framed.FrameReader r0 = r5.frameReader
                com.squareup.okhttp.internal.Util.closeQuietly((java.io.Closeable) r0)
                return
            L_0x0040:
                r2 = move-exception
                goto L_0x0049
            L_0x0042:
                com.squareup.okhttp.internal.framed.ErrorCode r0 = com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x0040 }
                com.squareup.okhttp.internal.framed.ErrorCode r1 = com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x0040 }
                com.squareup.okhttp.internal.framed.FramedConnection r2 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ IOException -> 0x003a }
                goto L_0x0037
            L_0x0049:
                com.squareup.okhttp.internal.framed.FramedConnection r3 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ IOException -> 0x004e }
                r3.close(r0, r1)     // Catch:{ IOException -> 0x004e }
            L_0x004e:
                com.squareup.okhttp.internal.framed.FrameReader r0 = r5.frameReader
                com.squareup.okhttp.internal.Util.closeQuietly((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedConnection.Reader.execute():void");
        }

        public void data(boolean z, int i2, e eVar, int i3) throws IOException {
            if (FramedConnection.this.pushedStream(i2)) {
                FramedConnection.this.pushDataLater(i2, eVar, i3, z);
                return;
            }
            FramedStream stream = FramedConnection.this.getStream(i2);
            if (stream == null) {
                FramedConnection.this.writeSynResetLater(i2, ErrorCode.INVALID_STREAM);
                eVar.i((long) i3);
                return;
            }
            stream.receiveData(eVar, i3);
            if (z) {
                stream.receiveFin();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
            if (r14.failIfStreamPresent() == false) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
            r0.closeLater(com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR);
            r8.this$0.removeStream(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
            r0.receiveHeaders(r13, r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x009f, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a1, code lost:
            r0.receiveFin();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r9, boolean r10, int r11, int r12, java.util.List<com.squareup.okhttp.internal.framed.Header> r13, com.squareup.okhttp.internal.framed.HeadersMode r14) {
            /*
                r8 = this;
                com.squareup.okhttp.internal.framed.FramedConnection r12 = com.squareup.okhttp.internal.framed.FramedConnection.this
                boolean r12 = r12.pushedStream(r11)
                if (r12 == 0) goto L_0x000e
                com.squareup.okhttp.internal.framed.FramedConnection r9 = com.squareup.okhttp.internal.framed.FramedConnection.this
                r9.pushHeadersLater(r11, r13, r10)
                return
            L_0x000e:
                com.squareup.okhttp.internal.framed.FramedConnection r12 = com.squareup.okhttp.internal.framed.FramedConnection.this
                monitor-enter(r12)
                com.squareup.okhttp.internal.framed.FramedConnection r0 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x00a5 }
                boolean r0 = r0.shutdown     // Catch:{ all -> 0x00a5 }
                if (r0 == 0) goto L_0x001b
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                return
            L_0x001b:
                com.squareup.okhttp.internal.framed.FramedConnection r0 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x00a5 }
                com.squareup.okhttp.internal.framed.FramedStream r0 = r0.getStream(r11)     // Catch:{ all -> 0x00a5 }
                if (r0 != 0) goto L_0x008a
                boolean r14 = r14.failIfStreamAbsent()     // Catch:{ all -> 0x00a5 }
                if (r14 == 0) goto L_0x0032
                com.squareup.okhttp.internal.framed.FramedConnection r9 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x00a5 }
                com.squareup.okhttp.internal.framed.ErrorCode r10 = com.squareup.okhttp.internal.framed.ErrorCode.INVALID_STREAM     // Catch:{ all -> 0x00a5 }
                r9.writeSynResetLater(r11, r10)     // Catch:{ all -> 0x00a5 }
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                return
            L_0x0032:
                com.squareup.okhttp.internal.framed.FramedConnection r14 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x00a5 }
                int r14 = r14.lastGoodStreamId     // Catch:{ all -> 0x00a5 }
                if (r11 > r14) goto L_0x003c
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                return
            L_0x003c:
                int r14 = r11 % 2
                com.squareup.okhttp.internal.framed.FramedConnection r0 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x00a5 }
                int r0 = r0.nextStreamId     // Catch:{ all -> 0x00a5 }
                r1 = 2
                int r0 = r0 % r1
                if (r14 != r0) goto L_0x004a
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                return
            L_0x004a:
                com.squareup.okhttp.internal.framed.FramedStream r14 = new com.squareup.okhttp.internal.framed.FramedStream     // Catch:{ all -> 0x00a5 }
                com.squareup.okhttp.internal.framed.FramedConnection r4 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x00a5 }
                r2 = r14
                r3 = r11
                r5 = r9
                r6 = r10
                r7 = r13
                r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a5 }
                com.squareup.okhttp.internal.framed.FramedConnection r9 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x00a5 }
                int unused = r9.lastGoodStreamId = r11     // Catch:{ all -> 0x00a5 }
                com.squareup.okhttp.internal.framed.FramedConnection r9 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x00a5 }
                java.util.Map r9 = r9.streams     // Catch:{ all -> 0x00a5 }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00a5 }
                r9.put(r10, r14)     // Catch:{ all -> 0x00a5 }
                java.util.concurrent.ExecutorService r9 = com.squareup.okhttp.internal.framed.FramedConnection.executor     // Catch:{ all -> 0x00a5 }
                com.squareup.okhttp.internal.framed.FramedConnection$Reader$1 r10 = new com.squareup.okhttp.internal.framed.FramedConnection$Reader$1     // Catch:{ all -> 0x00a5 }
                java.lang.String r13 = "OkHttp %s stream %d"
                java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a5 }
                r1 = 0
                com.squareup.okhttp.internal.framed.FramedConnection r2 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x00a5 }
                java.lang.String r2 = r2.hostName     // Catch:{ all -> 0x00a5 }
                r0[r1] = r2     // Catch:{ all -> 0x00a5 }
                r1 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00a5 }
                r0[r1] = r11     // Catch:{ all -> 0x00a5 }
                r10.<init>(r13, r0, r14)     // Catch:{ all -> 0x00a5 }
                r9.execute(r10)     // Catch:{ all -> 0x00a5 }
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                return
            L_0x008a:
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                boolean r9 = r14.failIfStreamPresent()
                if (r9 == 0) goto L_0x009c
                com.squareup.okhttp.internal.framed.ErrorCode r9 = com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                r0.closeLater(r9)
                com.squareup.okhttp.internal.framed.FramedConnection r9 = com.squareup.okhttp.internal.framed.FramedConnection.this
                r9.removeStream(r11)
                return
            L_0x009c:
                r0.receiveHeaders(r13, r14)
                if (r10 == 0) goto L_0x00a4
                r0.receiveFin()
            L_0x00a4:
                return
            L_0x00a5:
                r9 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x00a5 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedConnection.Reader.headers(boolean, boolean, int, int, java.util.List, com.squareup.okhttp.internal.framed.HeadersMode):void");
        }

        public void rstStream(int i2, ErrorCode errorCode) {
            if (FramedConnection.this.pushedStream(i2)) {
                FramedConnection.this.pushResetLater(i2, errorCode);
                return;
            }
            FramedStream removeStream = FramedConnection.this.removeStream(i2);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        /* JADX WARNING: type inference failed for: r1v14, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void settings(boolean r7, com.squareup.okhttp.internal.framed.Settings r8) {
            /*
                r6 = this;
                com.squareup.okhttp.internal.framed.FramedConnection r0 = com.squareup.okhttp.internal.framed.FramedConnection.this
                monitor-enter(r0)
                com.squareup.okhttp.internal.framed.FramedConnection r1 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.framed.Settings r1 = r1.peerSettings     // Catch:{ all -> 0x0093 }
                r2 = 65536(0x10000, float:9.18355E-41)
                int r1 = r1.getInitialWindowSize(r2)     // Catch:{ all -> 0x0093 }
                if (r7 == 0) goto L_0x0016
                com.squareup.okhttp.internal.framed.FramedConnection r7 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.framed.Settings r7 = r7.peerSettings     // Catch:{ all -> 0x0093 }
                r7.clear()     // Catch:{ all -> 0x0093 }
            L_0x0016:
                com.squareup.okhttp.internal.framed.FramedConnection r7 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.framed.Settings r7 = r7.peerSettings     // Catch:{ all -> 0x0093 }
                r7.merge(r8)     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.framed.FramedConnection r7 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.Protocol r7 = r7.getProtocol()     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.Protocol r3 = com.squareup.okhttp.Protocol.HTTP_2     // Catch:{ all -> 0x0093 }
                if (r7 != r3) goto L_0x002a
                r6.ackSettingsLater(r8)     // Catch:{ all -> 0x0093 }
            L_0x002a:
                com.squareup.okhttp.internal.framed.FramedConnection r7 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.framed.Settings r7 = r7.peerSettings     // Catch:{ all -> 0x0093 }
                int r7 = r7.getInitialWindowSize(r2)     // Catch:{ all -> 0x0093 }
                r8 = -1
                r2 = 0
                r4 = 0
                if (r7 == r8) goto L_0x0079
                if (r7 == r1) goto L_0x0079
                int r7 = r7 - r1
                long r7 = (long) r7     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.framed.FramedConnection r1 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                boolean r1 = r1.receivedInitialPeerSettings     // Catch:{ all -> 0x0093 }
                if (r1 != 0) goto L_0x004f
                com.squareup.okhttp.internal.framed.FramedConnection r1 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                r1.addBytesToWriteWindow(r7)     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.framed.FramedConnection r1 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                r5 = 1
                boolean unused = r1.receivedInitialPeerSettings = r5     // Catch:{ all -> 0x0093 }
            L_0x004f:
                com.squareup.okhttp.internal.framed.FramedConnection r1 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                java.util.Map r1 = r1.streams     // Catch:{ all -> 0x0093 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0093 }
                if (r1 != 0) goto L_0x007a
                com.squareup.okhttp.internal.framed.FramedConnection r1 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                java.util.Map r1 = r1.streams     // Catch:{ all -> 0x0093 }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.framed.FramedConnection r4 = com.squareup.okhttp.internal.framed.FramedConnection.this     // Catch:{ all -> 0x0093 }
                java.util.Map r4 = r4.streams     // Catch:{ all -> 0x0093 }
                int r4 = r4.size()     // Catch:{ all -> 0x0093 }
                com.squareup.okhttp.internal.framed.FramedStream[] r4 = new com.squareup.okhttp.internal.framed.FramedStream[r4]     // Catch:{ all -> 0x0093 }
                java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ all -> 0x0093 }
                r4 = r1
                com.squareup.okhttp.internal.framed.FramedStream[] r4 = (com.squareup.okhttp.internal.framed.FramedStream[]) r4     // Catch:{ all -> 0x0093 }
                goto L_0x007a
            L_0x0079:
                r7 = r2
            L_0x007a:
                monitor-exit(r0)     // Catch:{ all -> 0x0093 }
                if (r4 == 0) goto L_0x0092
                int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x0092
                int r0 = r4.length
                r1 = 0
            L_0x0083:
                if (r1 >= r0) goto L_0x0092
                r2 = r4[r1]
                monitor-enter(r2)
                r2.addBytesToWriteWindow(r7)     // Catch:{ all -> 0x008f }
                monitor-exit(r2)     // Catch:{ all -> 0x008f }
                int r1 = r1 + 1
                goto L_0x0083
            L_0x008f:
                r7 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x008f }
                throw r7
            L_0x0092:
                return
            L_0x0093:
                r7 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0093 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedConnection.Reader.settings(boolean, com.squareup.okhttp.internal.framed.Settings):void");
        }

        private void ackSettingsLater(final Settings settings) {
            FramedConnection.executor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{FramedConnection.this.hostName}) {
                public void execute() {
                    try {
                        FramedConnection.this.frameWriter.ackSettings(settings);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        public void ping(boolean z, int i2, int i3) {
            if (z) {
                Ping access$2200 = FramedConnection.this.removePing(i2);
                if (access$2200 != null) {
                    access$2200.receive();
                    return;
                }
                return;
            }
            FramedConnection.this.writePingLater(true, i2, i3, (Ping) null);
        }

        public void goAway(int i2, ErrorCode errorCode, f fVar) {
            FramedStream[] framedStreamArr;
            fVar.size();
            synchronized (FramedConnection.this) {
                framedStreamArr = (FramedStream[]) FramedConnection.this.streams.values().toArray(new FramedStream[FramedConnection.this.streams.size()]);
                boolean unused = FramedConnection.this.shutdown = true;
            }
            for (FramedStream framedStream : framedStreamArr) {
                if (framedStream.getId() > i2 && framedStream.isLocallyInitiated()) {
                    framedStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    FramedConnection.this.removeStream(framedStream.getId());
                }
            }
        }

        public void windowUpdate(int i2, long j) {
            if (i2 == 0) {
                synchronized (FramedConnection.this) {
                    FramedConnection.this.bytesLeftInWriteWindow += j;
                    FramedConnection.this.notifyAll();
                }
                return;
            }
            FramedStream stream = FramedConnection.this.getStream(i2);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        public void pushPromise(int i2, int i3, List<Header> list) {
            FramedConnection.this.pushRequestLater(i3, list);
        }
    }

    /* access modifiers changed from: private */
    public boolean pushedStream(int i2) {
        return this.protocol == Protocol.HTTP_2 && i2 != 0 && (i2 & 1) == 0;
    }

    /* access modifiers changed from: private */
    public void pushRequestLater(int i2, List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i2))) {
                writeSynResetLater(i2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i2));
            final int i3 = i2;
            final List<Header> list2 = list;
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostName, Integer.valueOf(i2)}) {
                public void execute() {
                    if (FramedConnection.this.pushObserver.onRequest(i3, list2)) {
                        try {
                            FramedConnection.this.frameWriter.rstStream(i3, ErrorCode.CANCEL);
                            synchronized (FramedConnection.this) {
                                FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i3));
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void pushHeadersLater(int i2, List<Header> list, boolean z) {
        final int i3 = i2;
        final List<Header> list2 = list;
        final boolean z2 = z;
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostName, Integer.valueOf(i2)}) {
            public void execute() {
                boolean onHeaders = FramedConnection.this.pushObserver.onHeaders(i3, list2, z2);
                if (onHeaders) {
                    try {
                        FramedConnection.this.frameWriter.rstStream(i3, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (!onHeaders) {
                    if (!z2) {
                        return;
                    }
                }
                synchronized (FramedConnection.this) {
                    FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i3));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void pushDataLater(int i2, e eVar, int i3, boolean z) throws IOException {
        final c cVar = new c();
        long j = (long) i3;
        eVar.a(j);
        eVar.read(cVar, j);
        if (cVar.f46277b == j) {
            final int i4 = i2;
            final int i5 = i3;
            final boolean z2 = z;
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostName, Integer.valueOf(i2)}) {
                public void execute() {
                    try {
                        boolean onData = FramedConnection.this.pushObserver.onData(i4, cVar, i5, z2);
                        if (onData) {
                            FramedConnection.this.frameWriter.rstStream(i4, ErrorCode.CANCEL);
                        }
                        if (!onData) {
                            if (!z2) {
                                return;
                            }
                        }
                        synchronized (FramedConnection.this) {
                            FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i4));
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(cVar.f46277b + " != " + i3);
    }

    /* access modifiers changed from: private */
    public void pushResetLater(int i2, ErrorCode errorCode) {
        final int i3 = i2;
        final ErrorCode errorCode2 = errorCode;
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostName, Integer.valueOf(i2)}) {
            public void execute() {
                FramedConnection.this.pushObserver.onReset(i3, errorCode2);
                synchronized (FramedConnection.this) {
                    FramedConnection.this.currentPushRequests.remove(Integer.valueOf(i3));
                }
            }
        });
    }
}
