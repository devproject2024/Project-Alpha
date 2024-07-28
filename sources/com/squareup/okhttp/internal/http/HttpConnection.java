package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import i.c;
import i.d;
import i.e;
import i.j;
import i.n;
import i.u;
import i.v;
import i.w;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

public final class HttpConnection {
    private static final int ON_IDLE_CLOSE = 2;
    private static final int ON_IDLE_HOLD = 0;
    private static final int ON_IDLE_POOL = 1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    /* access modifiers changed from: private */
    public final Connection connection;
    /* access modifiers changed from: private */
    public int onIdle = 0;
    /* access modifiers changed from: private */
    public final ConnectionPool pool;
    /* access modifiers changed from: private */
    public final d sink;
    private final Socket socket;
    /* access modifiers changed from: private */
    public final e source;
    /* access modifiers changed from: private */
    public int state = 0;

    public HttpConnection(ConnectionPool connectionPool, Connection connection2, Socket socket2) throws IOException {
        this.pool = connectionPool;
        this.connection = connection2;
        this.socket = socket2;
        this.source = n.a(n.b(socket2));
        this.sink = n.a(n.a(socket2));
    }

    public final void setTimeouts(int i2, int i3) {
        if (i2 != 0) {
            this.source.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
        }
        if (i3 != 0) {
            this.sink.timeout().timeout((long) i3, TimeUnit.MILLISECONDS);
        }
    }

    public final void poolOnIdle() {
        this.onIdle = 1;
        if (this.state == 0) {
            this.onIdle = 0;
            Internal.instance.recycle(this.pool, this.connection);
        }
    }

    public final void closeOnIdle() throws IOException {
        this.onIdle = 2;
        if (this.state == 0) {
            this.state = 6;
            this.connection.getSocket().close();
        }
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    public final void closeIfOwnedBy(Object obj) throws IOException {
        Internal.instance.closeIfOwnedBy(this.connection, obj);
    }

    public final void flush() throws IOException {
        this.sink.flush();
    }

    public final long bufferSize() {
        return this.source.a().f46277b;
    }

    public final boolean isReadable() {
        int soTimeout;
        try {
            soTimeout = this.socket.getSoTimeout();
            this.socket.setSoTimeout(1);
            if (this.source.d()) {
                this.socket.setSoTimeout(soTimeout);
                return false;
            }
            this.socket.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        } catch (Throwable th) {
            this.socket.setSoTimeout(soTimeout);
            throw th;
        }
    }

    public final void writeRequest(Headers headers, String str) throws IOException {
        if (this.state == 0) {
            this.sink.b(str).b("\r\n");
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.sink.b(headers.name(i2)).b(": ").b(headers.value(i2)).b("\r\n");
            }
            this.sink.b("\r\n");
            this.state = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final Response.Builder readResponse() throws IOException {
        StatusLine parse;
        Response.Builder message;
        int i2 = this.state;
        if (i2 == 1 || i2 == 3) {
            do {
                try {
                    parse = StatusLine.parse(this.source.r());
                    message = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message);
                    Headers.Builder builder = new Headers.Builder();
                    readHeaders(builder);
                    builder.add(OkHeaders.SELECTED_PROTOCOL, parse.protocol.toString());
                    message.headers(builder.build());
                } catch (EOFException e2) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.connection + " (recycle count=" + Internal.instance.recycleCount(this.connection) + ")");
                    iOException.initCause(e2);
                    throw iOException;
                }
            } while (parse.code == 100);
            this.state = 4;
            return message;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final void readHeaders(Headers.Builder builder) throws IOException {
        while (true) {
            String r = this.source.r();
            if (r.length() != 0) {
                Internal.instance.addLenient(builder, r);
            } else {
                return;
            }
        }
    }

    public final u newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final u newFixedLengthSink(long j) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final void writeRequestBody(RetryableSink retryableSink) throws IOException {
        if (this.state == 1) {
            this.state = 3;
            retryableSink.writeToSocket(this.sink);
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final v newFixedLengthSource(long j) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final v newChunkedSource(HttpEngine httpEngine) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpEngine);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final v newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new UnknownLengthSource();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final d rawSink() {
        return this.sink;
    }

    public final e rawSource() {
        return this.source;
    }

    final class FixedLengthSink implements u {
        private long bytesRemaining;
        private boolean closed;
        private final j timeout;

        private FixedLengthSink(long j) {
            this.timeout = new j(HttpConnection.this.sink.timeout());
            this.bytesRemaining = j;
        }

        public final w timeout() {
            return this.timeout;
        }

        public final void write(c cVar, long j) throws IOException {
            if (!this.closed) {
                Util.checkOffsetAndCount(cVar.f46277b, 0, j);
                if (j <= this.bytesRemaining) {
                    HttpConnection.this.sink.write(cVar, j);
                    this.bytesRemaining -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public final void flush() throws IOException {
            if (!this.closed) {
                HttpConnection.this.sink.flush();
            }
        }

        public final void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining <= 0) {
                    HttpConnection.this.detachTimeout(this.timeout);
                    int unused = HttpConnection.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    final class ChunkedSink implements u {
        private boolean closed;
        private final j timeout;

        private ChunkedSink() {
            this.timeout = new j(HttpConnection.this.sink.timeout());
        }

        public final w timeout() {
            return this.timeout;
        }

        public final void write(c cVar, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                HttpConnection.this.sink.m(j);
                HttpConnection.this.sink.b("\r\n");
                HttpConnection.this.sink.write(cVar, j);
                HttpConnection.this.sink.b("\r\n");
            }
        }

        public final synchronized void flush() throws IOException {
            if (!this.closed) {
                HttpConnection.this.sink.flush();
            }
        }

        public final synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                HttpConnection.this.sink.b("0\r\n\r\n");
                HttpConnection.this.detachTimeout(this.timeout);
                int unused = HttpConnection.this.state = 3;
            }
        }
    }

    abstract class AbstractSource implements v {
        protected boolean closed;
        protected final j timeout;

        private AbstractSource() {
            this.timeout = new j(HttpConnection.this.source.timeout());
        }

        public w timeout() {
            return this.timeout;
        }

        /* access modifiers changed from: protected */
        public final void endOfInput(boolean z) throws IOException {
            if (HttpConnection.this.state == 5) {
                HttpConnection.this.detachTimeout(this.timeout);
                int unused = HttpConnection.this.state = 0;
                if (z && HttpConnection.this.onIdle == 1) {
                    int unused2 = HttpConnection.this.onIdle = 0;
                    Internal.instance.recycle(HttpConnection.this.pool, HttpConnection.this.connection);
                } else if (HttpConnection.this.onIdle == 2) {
                    int unused3 = HttpConnection.this.state = 6;
                    HttpConnection.this.connection.getSocket().close();
                }
            } else {
                throw new IllegalStateException("state: " + HttpConnection.this.state);
            }
        }

        /* access modifiers changed from: protected */
        public final void unexpectedEndOfInput() {
            Util.closeQuietly(HttpConnection.this.connection.getSocket());
            int unused = HttpConnection.this.state = 6;
        }
    }

    class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) throws IOException {
            super();
            this.bytesRemaining = j;
            if (this.bytesRemaining == 0) {
                endOfInput(true);
            }
        }

        public long read(c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.bytesRemaining == 0) {
                return -1;
            } else {
                long read = HttpConnection.this.source.read(cVar, Math.min(this.bytesRemaining, j));
                if (read != -1) {
                    this.bytesRemaining -= read;
                    if (this.bytesRemaining == 0) {
                        endOfInput(true);
                    }
                    return read;
                }
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }
    }

    class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        private final HttpEngine httpEngine;

        ChunkedSource(HttpEngine httpEngine2) throws IOException {
            super();
            this.httpEngine = httpEngine2;
        }

        public long read(c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                long j2 = this.bytesRemainingInChunk;
                if (j2 == 0 || j2 == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1;
                    }
                }
                long read = HttpConnection.this.source.read(cVar, Math.min(j, this.bytesRemainingInChunk));
                if (read != -1) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                HttpConnection.this.source.r();
            }
            try {
                this.bytesRemainingInChunk = HttpConnection.this.source.o();
                String trim = HttpConnection.this.source.r().trim();
                if (this.bytesRemainingInChunk < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + "\"");
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    Headers.Builder builder = new Headers.Builder();
                    HttpConnection.this.readHeaders(builder);
                    this.httpEngine.receiveHeaders(builder.build());
                    endOfInput(true);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }
    }

    class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        private UnknownLengthSource() {
            super();
        }

        public long read(c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = HttpConnection.this.source.read(cVar, j);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(false);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    unexpectedEndOfInput();
                }
                this.closed = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public void detachTimeout(j jVar) {
        w wVar = jVar.f46290a;
        jVar.a(w.NONE);
        wVar.clearDeadline();
        wVar.clearTimeout();
    }
}
