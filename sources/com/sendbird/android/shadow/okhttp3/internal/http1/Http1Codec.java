package com.sendbird.android.shadow.okhttp3.internal.http1;

import com.sendbird.android.shadow.okhttp3.Headers;
import com.sendbird.android.shadow.okhttp3.HttpUrl;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.ResponseBody;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpCodec;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders;
import com.sendbird.android.shadow.okhttp3.internal.http.RealResponseBody;
import com.sendbird.android.shadow.okhttp3.internal.http.RequestLine;
import com.sendbird.android.shadow.okhttp3.internal.http.StatusLine;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ForwardingTimeout;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Source;
import com.sendbird.android.shadow.okio.Timeout;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final OkHttpClient client;
    private long headerLimit = 262144;
    final BufferedSink sink;
    final BufferedSource source;
    int state = 0;
    final StreamAllocation streamAllocation;

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation2, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation2;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    public final Sink createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public final void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        String header = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0, Okio.buffer(newFixedLengthSource(0)));
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return new RealResponseBody(header, -1, Okio.buffer(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(header, contentLength, Okio.buffer(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(header, -1, Okio.buffer(newUnknownLengthSource()));
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    public final void flushRequest() throws IOException {
        this.sink.flush();
    }

    public final void finishRequest() throws IOException {
        this.sink.flush();
    }

    public final void writeRequest(Headers headers, String str) throws IOException {
        if (this.state == 0) {
            this.sink.writeUtf8(str).writeUtf8("\r\n");
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.sink.writeUtf8(headers.name(i2)).writeUtf8(": ").writeUtf8(headers.value(i2)).writeUtf8("\r\n");
            }
            this.sink.writeUtf8("\r\n");
            this.state = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        int i2 = this.state;
        if (i2 == 1 || i2 == 3) {
            try {
                StatusLine parse = StatusLine.parse(readHeaderLine());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                if (z && parse.code == 100) {
                    return null;
                }
                if (parse.code == 100) {
                    this.state = 3;
                    return headers;
                }
                this.state = 4;
                return headers;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.streamAllocation);
                iOException.initCause(e2);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.state);
        }
    }

    private String readHeaderLine() throws IOException {
        String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    public final Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, readHeaderLine);
        }
    }

    public final Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new b();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final Sink newFixedLengthSink(long j) {
        if (this.state == 1) {
            this.state = 2;
            return new d(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final Source newFixedLengthSource(long j) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final Source newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new c(httpUrl);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public final Source newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            StreamAllocation streamAllocation2 = this.streamAllocation;
            if (streamAllocation2 != null) {
                this.state = 5;
                streamAllocation2.noNewStreams();
                return new f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.state);
    }

    /* access modifiers changed from: package-private */
    public final void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    final class d implements Sink {

        /* renamed from: b  reason: collision with root package name */
        private final ForwardingTimeout f45089b = new ForwardingTimeout(Http1Codec.this.sink.timeout());

        /* renamed from: c  reason: collision with root package name */
        private boolean f45090c;

        /* renamed from: d  reason: collision with root package name */
        private long f45091d;

        d(long j) {
            this.f45091d = j;
        }

        public final Timeout timeout() {
            return this.f45089b;
        }

        public final void write(Buffer buffer, long j) throws IOException {
            if (!this.f45090c) {
                Util.checkOffsetAndCount(buffer.size(), 0, j);
                if (j <= this.f45091d) {
                    Http1Codec.this.sink.write(buffer, j);
                    this.f45091d -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f45091d + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public final void flush() throws IOException {
            if (!this.f45090c) {
                Http1Codec.this.sink.flush();
            }
        }

        public final void close() throws IOException {
            if (!this.f45090c) {
                this.f45090c = true;
                if (this.f45091d <= 0) {
                    Http1Codec.this.detachTimeout(this.f45089b);
                    Http1Codec.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    final class b implements Sink {

        /* renamed from: b  reason: collision with root package name */
        private final ForwardingTimeout f45082b = new ForwardingTimeout(Http1Codec.this.sink.timeout());

        /* renamed from: c  reason: collision with root package name */
        private boolean f45083c;

        b() {
        }

        public final Timeout timeout() {
            return this.f45082b;
        }

        public final void write(Buffer buffer, long j) throws IOException {
            if (this.f45083c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1Codec.this.sink.writeHexadecimalUnsignedLong(j);
                Http1Codec.this.sink.writeUtf8("\r\n");
                Http1Codec.this.sink.write(buffer, j);
                Http1Codec.this.sink.writeUtf8("\r\n");
            }
        }

        public final synchronized void flush() throws IOException {
            if (!this.f45083c) {
                Http1Codec.this.sink.flush();
            }
        }

        public final synchronized void close() throws IOException {
            if (!this.f45083c) {
                this.f45083c = true;
                Http1Codec.this.sink.writeUtf8("0\r\n\r\n");
                Http1Codec.this.detachTimeout(this.f45082b);
                Http1Codec.this.state = 3;
            }
        }
    }

    abstract class a implements Source {

        /* renamed from: a  reason: collision with root package name */
        protected final ForwardingTimeout f45077a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f45078b;

        /* renamed from: c  reason: collision with root package name */
        protected long f45079c;

        private a() {
            this.f45077a = new ForwardingTimeout(Http1Codec.this.source.timeout());
            this.f45079c = 0;
        }

        /* synthetic */ a(Http1Codec http1Codec, byte b2) {
            this();
        }

        public Timeout timeout() {
            return this.f45077a;
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = Http1Codec.this.source.read(buffer, j);
                if (read > 0) {
                    this.f45079c += read;
                }
                return read;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        /* access modifiers changed from: protected */
        public final void a(boolean z, IOException iOException) throws IOException {
            if (Http1Codec.this.state != 6) {
                if (Http1Codec.this.state == 5) {
                    Http1Codec.this.detachTimeout(this.f45077a);
                    Http1Codec http1Codec = Http1Codec.this;
                    http1Codec.state = 6;
                    if (http1Codec.streamAllocation != null) {
                        Http1Codec.this.streamAllocation.streamFinished(!z, Http1Codec.this, this.f45079c, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + Http1Codec.this.state);
            }
        }
    }

    class e extends a {

        /* renamed from: f  reason: collision with root package name */
        private long f45093f;

        e(long j) throws IOException {
            super(Http1Codec.this, (byte) 0);
            this.f45093f = j;
            if (this.f45093f == 0) {
                a(true, (IOException) null);
            }
        }

        public final long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (!this.f45078b) {
                long j2 = this.f45093f;
                if (j2 == 0) {
                    return -1;
                }
                long read = super.read(buffer, Math.min(j2, j));
                if (read != -1) {
                    this.f45093f -= read;
                    if (this.f45093f == 0) {
                        a(true, (IOException) null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public final void close() throws IOException {
            if (!this.f45078b) {
                if (this.f45093f != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, (IOException) null);
                }
                this.f45078b = true;
            }
        }
    }

    class c extends a {

        /* renamed from: f  reason: collision with root package name */
        private final HttpUrl f45085f;

        /* renamed from: g  reason: collision with root package name */
        private long f45086g = -1;

        /* renamed from: h  reason: collision with root package name */
        private boolean f45087h = true;

        c(HttpUrl httpUrl) {
            super(Http1Codec.this, (byte) 0);
            this.f45085f = httpUrl;
        }

        public final long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.f45078b) {
                throw new IllegalStateException("closed");
            } else if (!this.f45087h) {
                return -1;
            } else {
                long j2 = this.f45086g;
                if (j2 == 0 || j2 == -1) {
                    if (this.f45086g != -1) {
                        Http1Codec.this.source.readUtf8LineStrict();
                    }
                    try {
                        this.f45086g = Http1Codec.this.source.readHexadecimalUnsignedLong();
                        String trim = Http1Codec.this.source.readUtf8LineStrict().trim();
                        if (this.f45086g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f45086g + trim + "\"");
                        }
                        if (this.f45086g == 0) {
                            this.f45087h = false;
                            HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.f45085f, Http1Codec.this.readHeaders());
                            a(true, (IOException) null);
                        }
                        if (!this.f45087h) {
                            return -1;
                        }
                    } catch (NumberFormatException e2) {
                        throw new ProtocolException(e2.getMessage());
                    }
                }
                long read = super.read(buffer, Math.min(j, this.f45086g));
                if (read != -1) {
                    this.f45086g -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
        }

        public final void close() throws IOException {
            if (!this.f45078b) {
                if (this.f45087h && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    a(false, (IOException) null);
                }
                this.f45078b = true;
            }
        }
    }

    class f extends a {

        /* renamed from: f  reason: collision with root package name */
        private boolean f45095f;

        f() {
            super(Http1Codec.this, (byte) 0);
        }

        public final long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            } else if (this.f45078b) {
                throw new IllegalStateException("closed");
            } else if (this.f45095f) {
                return -1;
            } else {
                long read = super.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.f45095f = true;
                a(true, (IOException) null);
                return -1;
            }
        }

        public final void close() throws IOException {
            if (!this.f45078b) {
                if (!this.f45095f) {
                    a(false, (IOException) null);
                }
                this.f45078b = true;
            }
        }
    }
}
