package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okhttp3.Headers;
import com.sendbird.android.shadow.okhttp3.Interceptor;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.ResponseBody;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpCodec;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders;
import com.sendbird.android.shadow.okhttp3.internal.http.RealResponseBody;
import com.sendbird.android.shadow.okhttp3.internal.http.RequestLine;
import com.sendbird.android.shadow.okhttp3.internal.http.StatusLine;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.ForwardingSource;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Source;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class Http2Codec implements HttpCodec {
    private static final String CONNECTION = "connection";
    private static final String ENCODING = "encoding";
    private static final String HOST = "host";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList((T[]) new String[]{CONNECTION, "host", KEEP_ALIVE, PROXY_CONNECTION, "te", TRANSFER_ENCODING, ENCODING, UPGRADE, ":method", ":path", ":scheme", ":authority"});
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList((T[]) new String[]{CONNECTION, "host", KEEP_ALIVE, PROXY_CONNECTION, "te", TRANSFER_ENCODING, ENCODING, UPGRADE});
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String UPGRADE = "upgrade";
    private final Interceptor.Chain chain;
    private final Http2Connection connection;
    private final Protocol protocol;
    private Http2Stream stream;
    final StreamAllocation streamAllocation;

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain2, StreamAllocation streamAllocation2, Http2Connection http2Connection) {
        Protocol protocol2;
        this.chain = chain2;
        this.streamAllocation = streamAllocation2;
        this.connection = http2Connection;
        if (okHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol2 = Protocol.HTTP_2;
        }
        this.protocol = protocol2;
    }

    public final Sink createRequestBody(Request request, long j) {
        return this.stream.getSink();
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        if (this.stream == null) {
            this.stream = this.connection.newStream(http2HeadersList(request), request.body() != null);
            this.stream.readTimeout().timeout((long) this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.stream.writeTimeout().timeout((long) this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public final void flushRequest() throws IOException {
        this.connection.flush();
    }

    public final void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeHeaders(), this.protocol);
        if (!z || Internal.instance.code(readHttp2HeadersList) != 100) {
            return readHttp2HeadersList;
        }
        return null;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i2).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8.utf8())) {
                arrayList.add(new Header(encodeUtf8, headers.value(i2)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(Headers headers, Protocol protocol2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        StatusLine statusLine = null;
        for (int i2 = 0; i2 < size; i2++) {
            String name = headers.name(i2);
            String value = headers.value(i2);
            if (name.equals(":status")) {
                statusLine = StatusLine.parse("HTTP/1.1 ".concat(String.valueOf(value)));
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                Internal.instance.addLenient(builder, name, value);
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(protocol2).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), Okio.buffer((Source) new a(this.stream.getSource())));
    }

    public final void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    class a extends ForwardingSource {

        /* renamed from: a  reason: collision with root package name */
        boolean f45096a = false;

        /* renamed from: b  reason: collision with root package name */
        long f45097b = 0;

        a(Source source) {
            super(source);
        }

        public final long read(Buffer buffer, long j) throws IOException {
            try {
                long read = delegate().read(buffer, j);
                if (read > 0) {
                    this.f45097b += read;
                }
                return read;
            } catch (IOException e2) {
                a(e2);
                throw e2;
            }
        }

        public final void close() throws IOException {
            super.close();
            a((IOException) null);
        }

        private void a(IOException iOException) {
            if (!this.f45096a) {
                this.f45096a = true;
                Http2Codec.this.streamAllocation.streamFinished(false, Http2Codec.this, this.f45097b, iOException);
            }
        }
    }
}
