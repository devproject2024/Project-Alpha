package com.squareup.okhttp.internal.http;

import com.alipay.mobile.h5container.api.H5Param;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedStream;
import com.squareup.okhttp.internal.framed.Header;
import i.f;
import i.n;
import i.u;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class FramedTransport implements Transport {
    private static final List<f> HTTP_2_PROHIBITED_HEADERS = Util.immutableList((T[]) new f[]{f.encodeUtf8("connection"), f.encodeUtf8(H5Param.HOST), f.encodeUtf8("keep-alive"), f.encodeUtf8("proxy-connection"), f.encodeUtf8("te"), f.encodeUtf8("transfer-encoding"), f.encodeUtf8("encoding"), f.encodeUtf8("upgrade")});
    private static final List<f> SPDY_3_PROHIBITED_HEADERS = Util.immutableList((T[]) new f[]{f.encodeUtf8("connection"), f.encodeUtf8(H5Param.HOST), f.encodeUtf8("keep-alive"), f.encodeUtf8("proxy-connection"), f.encodeUtf8("transfer-encoding")});
    private final FramedConnection framedConnection;
    private final HttpEngine httpEngine;
    private FramedStream stream;

    public final boolean canReuseConnection() {
        return true;
    }

    public final void releaseConnectionOnIdle() {
    }

    public FramedTransport(HttpEngine httpEngine2, FramedConnection framedConnection2) {
        this.httpEngine = httpEngine2;
        this.framedConnection = framedConnection2;
    }

    public final u createRequestBody(Request request, long j) throws IOException {
        return this.stream.getSink();
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        if (this.stream == null) {
            this.httpEngine.writingRequestHeaders();
            boolean permitsRequestBody = this.httpEngine.permitsRequestBody();
            String version = RequestLine.version(this.httpEngine.getConnection().getProtocol());
            FramedConnection framedConnection2 = this.framedConnection;
            this.stream = framedConnection2.newStream(writeNameValueBlock(request, framedConnection2.getProtocol(), version), permitsRequestBody, true);
            this.stream.readTimeout().timeout((long) this.httpEngine.client.getReadTimeout(), TimeUnit.MILLISECONDS);
        }
    }

    public final void writeRequestBody(RetryableSink retryableSink) throws IOException {
        retryableSink.writeToSocket(this.stream.getSink());
    }

    public final void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public final Response.Builder readResponseHeaders() throws IOException {
        return readNameValueBlock(this.stream.getResponseHeaders(), this.framedConnection.getProtocol());
    }

    public static List<Header> writeNameValueBlock(Request request, Protocol protocol, String str) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 10);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.httpUrl())));
        String hostHeader = Util.hostHeader(request.httpUrl());
        if (Protocol.SPDY_3 == protocol) {
            arrayList.add(new Header(Header.VERSION, str));
            arrayList.add(new Header(Header.TARGET_HOST, hostHeader));
        } else if (Protocol.HTTP_2 == protocol) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, hostHeader));
        } else {
            throw new AssertionError();
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.httpUrl().scheme()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            f encodeUtf8 = f.encodeUtf8(headers.name(i2).toLowerCase(Locale.US));
            String value = headers.value(i2);
            if (!isProhibitedHeader(protocol, encodeUtf8) && !encodeUtf8.equals(Header.TARGET_METHOD) && !encodeUtf8.equals(Header.TARGET_PATH) && !encodeUtf8.equals(Header.TARGET_SCHEME) && !encodeUtf8.equals(Header.TARGET_AUTHORITY) && !encodeUtf8.equals(Header.TARGET_HOST) && !encodeUtf8.equals(Header.VERSION)) {
                if (linkedHashSet.add(encodeUtf8)) {
                    arrayList.add(new Header(encodeUtf8, value));
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= arrayList.size()) {
                            break;
                        } else if (((Header) arrayList.get(i3)).name.equals(encodeUtf8)) {
                            arrayList.set(i3, new Header(encodeUtf8, joinOnNull(((Header) arrayList.get(i3)).value.utf8(), value)));
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static String joinOnNull(String str, String str2) {
        return str + 0 + str2;
    }

    public static Response.Builder readNameValueBlock(List<Header> list, Protocol protocol) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        builder.set(OkHeaders.SELECTED_PROTOCOL, protocol.toString());
        int size = list.size();
        String str = "HTTP/1.1";
        String str2 = null;
        int i2 = 0;
        while (i2 < size) {
            f fVar = list.get(i2).name;
            String utf8 = list.get(i2).value.utf8();
            String str3 = str;
            String str4 = str2;
            int i3 = 0;
            while (i3 < utf8.length()) {
                int indexOf = utf8.indexOf(0, i3);
                if (indexOf == -1) {
                    indexOf = utf8.length();
                }
                String substring = utf8.substring(i3, indexOf);
                if (fVar.equals(Header.RESPONSE_STATUS)) {
                    str4 = substring;
                } else if (fVar.equals(Header.VERSION)) {
                    str3 = substring;
                } else if (!isProhibitedHeader(protocol, fVar)) {
                    builder.add(fVar.utf8(), substring);
                }
                i3 = indexOf + 1;
            }
            i2++;
            str2 = str4;
            str = str3;
        }
        if (str2 != null) {
            StatusLine parse = StatusLine.parse(str + " " + str2);
            return new Response.Builder().protocol(protocol).code(parse.code).message(parse.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), n.a(this.stream.getSource()));
    }

    public final void disconnect(HttpEngine httpEngine2) throws IOException {
        FramedStream framedStream = this.stream;
        if (framedStream != null) {
            framedStream.close(ErrorCode.CANCEL);
        }
    }

    private static boolean isProhibitedHeader(Protocol protocol, f fVar) {
        if (protocol == Protocol.SPDY_3) {
            return SPDY_3_PROHIBITED_HEADERS.contains(fVar);
        }
        if (protocol == Protocol.HTTP_2) {
            return HTTP_2_PROHIBITED_HEADERS.contains(fVar);
        }
        throw new AssertionError(protocol);
    }
}
