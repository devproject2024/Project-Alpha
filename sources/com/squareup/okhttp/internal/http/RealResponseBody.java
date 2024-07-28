package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import i.e;

public final class RealResponseBody extends ResponseBody {
    private final Headers headers;
    private final e source;

    public RealResponseBody(Headers headers2, e eVar) {
        this.headers = headers2;
        this.source = eVar;
    }

    public final MediaType contentType() {
        String str = this.headers.get("Content-Type");
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public final long contentLength() {
        return OkHeaders.contentLength(this.headers);
    }

    public final e source() {
        return this.source;
    }
}
