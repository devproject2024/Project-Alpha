package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.sendbird.android.shadow.okhttp3.Headers;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.http2.Header;
import com.sendbird.android.shadow.okio.AsyncTimeout;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Source;
import com.sendbird.android.shadow.okio.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;
    ErrorCode errorCode = null;
    private boolean hasResponseHeaders;
    /* access modifiers changed from: private */
    public Header.a headersListener;
    /* access modifiers changed from: private */
    public final Deque<Headers> headersQueue = new ArrayDeque();
    final int id;
    final c readTimeout = new c();
    final a sink;
    private final b source;
    long unacknowledgedBytesRead = 0;
    final c writeTimeout = new c();

    Http2Stream(int i2, Http2Connection http2Connection, boolean z, boolean z2, Headers headers) {
        if (http2Connection != null) {
            this.id = i2;
            this.connection = http2Connection;
            this.bytesLeftInWriteWindow = (long) http2Connection.peerSettings.getInitialWindowSize();
            this.source = new b((long) http2Connection.okHttpSettings.getInitialWindowSize());
            this.sink = new a();
            this.source.f45139b = z2;
            this.sink.f45134b = z;
            if (headers != null) {
                this.headersQueue.add(headers);
            }
            if (isLocallyInitiated() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!isLocallyInitiated() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    public final int getId() {
        return this.id;
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.f45139b || this.source.f45138a) && ((this.sink.f45134b || this.sink.f45133a) && this.hasResponseHeaders)) {
            return false;
        }
        return true;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r2.readTimeout.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.sendbird.android.shadow.okhttp3.Headers takeHeaders() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream$c r0 = r2.readTimeout     // Catch:{ all -> 0x003c }
            r0.enter()     // Catch:{ all -> 0x003c }
        L_0x0006:
            java.util.Deque<com.sendbird.android.shadow.okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0016
            com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r0 = r2.errorCode     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0016
            r2.waitForIo()     // Catch:{ all -> 0x0035 }
            goto L_0x0006
        L_0x0016:
            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream$c r0 = r2.readTimeout     // Catch:{ all -> 0x003c }
            r0.a()     // Catch:{ all -> 0x003c }
            java.util.Deque<com.sendbird.android.shadow.okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x003c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x002d
            java.util.Deque<com.sendbird.android.shadow.okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x003c }
            com.sendbird.android.shadow.okhttp3.Headers r0 = (com.sendbird.android.shadow.okhttp3.Headers) r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)
            return r0
        L_0x002d:
            com.sendbird.android.shadow.okhttp3.internal.http2.StreamResetException r0 = new com.sendbird.android.shadow.okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x003c }
            com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r1 = r2.errorCode     // Catch:{ all -> 0x003c }
            r0.<init>(r1)     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x0035:
            r0 = move-exception
            com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream$c r1 = r2.readTimeout     // Catch:{ all -> 0x003c }
            r1.a()     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.takeHeaders():com.sendbird.android.shadow.okhttp3.Headers");
    }

    public final synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final void writeHeaders(List<Header> list, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        if (list != null) {
            synchronized (this) {
                this.hasResponseHeaders = true;
                if (!z) {
                    this.sink.f45134b = true;
                    z2 = true;
                    z3 = true;
                } else {
                    z2 = false;
                    z3 = false;
                }
            }
            if (!z2) {
                synchronized (this.connection) {
                    z2 = this.connection.bytesLeftInWriteWindow == 0;
                }
            }
            this.connection.writeSynReply(this.id, z3, list);
            if (z2) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new NullPointerException("headers == null");
    }

    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public final Source getSource() {
        return this.source;
    }

    public final Sink getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders) {
                if (!isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.sink;
    }

    public final void close(ErrorCode errorCode2) throws IOException {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynReset(this.id, errorCode2);
        }
    }

    public final void closeLater(ErrorCode errorCode2) {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynResetLater(this.id, errorCode2);
        }
    }

    private boolean closeInternal(ErrorCode errorCode2) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.f45139b && this.sink.f45134b) {
                return false;
            }
            this.errorCode = errorCode2;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void receiveHeaders(List<Header> list) {
        boolean isOpen;
        synchronized (this) {
            this.hasResponseHeaders = true;
            this.headersQueue.add(Util.toHeaders(list));
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public final void receiveData(BufferedSource bufferedSource, int i2) throws IOException {
        this.source.a(bufferedSource, (long) i2);
    }

    /* access modifiers changed from: package-private */
    public final void receiveFin() {
        boolean isOpen;
        synchronized (this) {
            this.source.f45139b = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void receiveRstStream(ErrorCode errorCode2) {
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    public final synchronized void setHeadersListener(Header.a aVar) {
        this.headersListener = aVar;
        if (!this.headersQueue.isEmpty() && aVar != null) {
            notifyAll();
        }
    }

    final class b implements Source {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f45137c = (!Http2Stream.class.desiredAssertionStatus());

        /* renamed from: a  reason: collision with root package name */
        boolean f45138a;

        /* renamed from: b  reason: collision with root package name */
        boolean f45139b;

        /* renamed from: e  reason: collision with root package name */
        private final Buffer f45141e = new Buffer();

        /* renamed from: f  reason: collision with root package name */
        private final Buffer f45142f = new Buffer();

        /* renamed from: g  reason: collision with root package name */
        private final long f45143g;

        b(long j) {
            this.f45143g = j;
        }

        public final long read(Buffer buffer, long j) throws IOException {
            ErrorCode errorCode;
            Headers headers;
            long j2;
            Header.a aVar;
            long j3 = j;
            if (j3 >= 0) {
                while (true) {
                    synchronized (Http2Stream.this) {
                        Http2Stream.this.readTimeout.enter();
                        try {
                            errorCode = Http2Stream.this.errorCode != null ? Http2Stream.this.errorCode : null;
                            if (!this.f45138a) {
                                if (Http2Stream.this.headersQueue.isEmpty() || Http2Stream.this.headersListener == null) {
                                    if (this.f45142f.size() > 0) {
                                        j2 = this.f45142f.read(buffer, Math.min(j3, this.f45142f.size()));
                                        Http2Stream.this.unacknowledgedBytesRead += j2;
                                        if (errorCode == null && Http2Stream.this.unacknowledgedBytesRead >= ((long) (Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2))) {
                                            Http2Stream.this.connection.writeWindowUpdateLater(Http2Stream.this.id, Http2Stream.this.unacknowledgedBytesRead);
                                            Http2Stream.this.unacknowledgedBytesRead = 0;
                                        }
                                    } else {
                                        Buffer buffer2 = buffer;
                                        if (this.f45139b || errorCode != null) {
                                            j2 = -1;
                                        } else {
                                            Http2Stream.this.waitForIo();
                                        }
                                    }
                                    aVar = null;
                                    headers = null;
                                } else {
                                    aVar = Http2Stream.this.headersListener;
                                    Buffer buffer3 = buffer;
                                    headers = (Headers) Http2Stream.this.headersQueue.removeFirst();
                                    j2 = -1;
                                }
                                Http2Stream.this.readTimeout.a();
                                if (headers == null || aVar == null) {
                                }
                            } else {
                                throw new IOException("stream closed");
                            }
                        } finally {
                            Http2Stream.this.readTimeout.a();
                        }
                    }
                }
                if (j2 != -1) {
                    a(j2);
                    return j2;
                } else if (errorCode == null) {
                    return -1;
                } else {
                    throw new StreamResetException(errorCode);
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
        }

        private void a(long j) {
            if (f45137c || !Thread.holdsLock(Http2Stream.this)) {
                Http2Stream.this.connection.updateConnectionFlowControl(j);
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public final void a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            if (f45137c || !Thread.holdsLock(Http2Stream.this)) {
                while (j > 0) {
                    synchronized (Http2Stream.this) {
                        z = this.f45139b;
                        z2 = true;
                        z3 = this.f45142f.size() + j > this.f45143g;
                    }
                    if (z3) {
                        bufferedSource.skip(j);
                        Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.skip(j);
                        return;
                    } else {
                        long read = bufferedSource.read(this.f45141e, j);
                        if (read != -1) {
                            j -= read;
                            synchronized (Http2Stream.this) {
                                if (this.f45138a) {
                                    j2 = this.f45141e.size();
                                    this.f45141e.clear();
                                } else {
                                    if (this.f45142f.size() != 0) {
                                        z2 = false;
                                    }
                                    this.f45142f.writeAll(this.f45141e);
                                    if (z2) {
                                        Http2Stream.this.notifyAll();
                                    }
                                    j2 = 0;
                                }
                            }
                            if (j2 > 0) {
                                a(j2);
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public final Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }

        public final void close() throws IOException {
            long size;
            ArrayList arrayList;
            Header.a aVar;
            synchronized (Http2Stream.this) {
                this.f45138a = true;
                size = this.f45142f.size();
                this.f45142f.clear();
                arrayList = null;
                if (Http2Stream.this.headersQueue.isEmpty() || Http2Stream.this.headersListener == null) {
                    aVar = null;
                } else {
                    arrayList = new ArrayList(Http2Stream.this.headersQueue);
                    Http2Stream.this.headersQueue.clear();
                    aVar = Http2Stream.this.headersListener;
                }
                Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                a(size);
            }
            Http2Stream.this.cancelStreamIfNecessary();
            if (aVar != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            z = !this.source.f45139b && this.source.f45138a && (this.sink.f45134b || this.sink.f45133a);
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    final class a implements Sink {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f45132c = (!Http2Stream.class.desiredAssertionStatus());

        /* renamed from: a  reason: collision with root package name */
        boolean f45133a;

        /* renamed from: b  reason: collision with root package name */
        boolean f45134b;

        /* renamed from: e  reason: collision with root package name */
        private final Buffer f45136e = new Buffer();

        a() {
        }

        public final void write(Buffer buffer, long j) throws IOException {
            if (f45132c || !Thread.holdsLock(Http2Stream.this)) {
                this.f45136e.write(buffer, j);
                while (this.f45136e.size() >= 16384) {
                    a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX INFO: finally extract failed */
        private void a(boolean z) throws IOException {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (Http2Stream.this.bytesLeftInWriteWindow <= 0 && !this.f45134b && !this.f45133a && Http2Stream.this.errorCode == null) {
                    try {
                        Http2Stream.this.waitForIo();
                    } catch (Throwable th) {
                        Http2Stream.this.writeTimeout.a();
                        throw th;
                    }
                }
                Http2Stream.this.writeTimeout.a();
                Http2Stream.this.checkOutNotClosed();
                min = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.f45136e.size());
                Http2Stream.this.bytesLeftInWriteWindow -= min;
            }
            Http2Stream.this.writeTimeout.enter();
            try {
                Http2Stream.this.connection.writeData(Http2Stream.this.id, z && min == this.f45136e.size(), this.f45136e, min);
            } finally {
                Http2Stream.this.writeTimeout.a();
            }
        }

        public final void flush() throws IOException {
            if (f45132c || !Thread.holdsLock(Http2Stream.this)) {
                synchronized (Http2Stream.this) {
                    Http2Stream.this.checkOutNotClosed();
                }
                while (this.f45136e.size() > 0) {
                    a(false);
                    Http2Stream.this.connection.flush();
                }
                return;
            }
            throw new AssertionError();
        }

        public final Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r8.f45135d.sink.f45134b != false) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
            if (r8.f45136e.size() <= 0) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            if (r8.f45136e.size() <= 0) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            r8.f45135d.connection.writeData(r8.f45135d.id, true, (com.sendbird.android.shadow.okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
            r2 = r8.f45135d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r8.f45133a = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
            r8.f45135d.connection.flush();
            r8.f45135d.cancelStreamIfNecessary();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void close() throws java.io.IOException {
            /*
                r8 = this;
                boolean r0 = f45132c
                if (r0 != 0) goto L_0x0013
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.this
                boolean r0 = java.lang.Thread.holdsLock(r0)
                if (r0 != 0) goto L_0x000d
                goto L_0x0013
            L_0x000d:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0013:
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r8.f45133a     // Catch:{ all -> 0x0065 }
                if (r1 == 0) goto L_0x001c
                monitor-exit(r0)     // Catch:{ all -> 0x0065 }
                return
            L_0x001c:
                monitor-exit(r0)     // Catch:{ all -> 0x0065 }
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.this
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream$a r0 = r0.sink
                boolean r0 = r0.f45134b
                r1 = 1
                if (r0 != 0) goto L_0x004f
                com.sendbird.android.shadow.okio.Buffer r0 = r8.f45136e
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0040
            L_0x0032:
                com.sendbird.android.shadow.okio.Buffer r0 = r8.f45136e
                long r2 = r0.size()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x004f
                r8.a(r1)
                goto L_0x0032
            L_0x0040:
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.this
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r2 = r0.connection
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.this
                int r3 = r0.id
                r4 = 1
                r5 = 0
                r6 = 0
                r2.writeData(r3, r4, r5, r6)
            L_0x004f:
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r2 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r2)
                r8.f45133a = r1     // Catch:{ all -> 0x0062 }
                monitor-exit(r2)     // Catch:{ all -> 0x0062 }
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.this
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Connection r0 = r0.connection
                r0.flush()
                com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream r0 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.this
                r0.cancelStreamIfNecessary()
                return
            L_0x0062:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0062 }
                throw r0
            L_0x0065:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0065 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.Http2Stream.a.close():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public final void checkOutNotClosed() throws IOException {
        if (this.sink.f45133a) {
            throw new IOException("stream closed");
        } else if (!this.sink.f45134b) {
            ErrorCode errorCode2 = this.errorCode;
            if (errorCode2 != null) {
                throw new StreamResetException(errorCode2);
            }
        } else {
            throw new IOException("stream finished");
        }
    }

    /* access modifiers changed from: package-private */
    public final void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    class c extends AsyncTimeout {
        c() {
        }

        public final void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
        }

        public final IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public final void a() throws IOException {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }
    }
}
