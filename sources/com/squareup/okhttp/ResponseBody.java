package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import i.c;
import i.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public abstract class ResponseBody implements Closeable {
    private Reader reader;

    public abstract long contentLength() throws IOException;

    public abstract MediaType contentType();

    public abstract e source() throws IOException;

    public final InputStream byteStream() throws IOException {
        return source().e();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            e source = source();
            try {
                byte[] s = source.s();
                Util.closeQuietly((Closeable) source);
                if (contentLength == -1 || contentLength == ((long) s.length)) {
                    return s;
                }
                throw new IOException("Content-Length and stream length disagree");
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) source);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(contentLength)));
        }
    }

    public final Reader charStream() throws IOException {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(byteStream(), charset());
        this.reader = inputStreamReader;
        return inputStreamReader;
    }

    public final String string() throws IOException {
        return new String(bytes(), charset().name());
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public void close() throws IOException {
        source().close();
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        c a2 = new c().a(str, charset);
        return create(mediaType, a2.f46277b, a2);
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, (long) bArr.length, new c().c(bArr));
    }

    public static ResponseBody create(final MediaType mediaType, final long j, final e eVar) {
        if (eVar != null) {
            return new ResponseBody() {
                public final MediaType contentType() {
                    return mediaType;
                }

                public final long contentLength() {
                    return j;
                }

                public final e source() {
                    return eVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
