package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import i.d;
import i.f;
import i.n;
import i.v;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class RequestBody {
    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(d dVar) throws IOException;

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = Util.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(final MediaType mediaType, final f fVar) {
        return new RequestBody() {
            public final MediaType contentType() {
                return mediaType;
            }

            public final long contentLength() throws IOException {
                return (long) fVar.size();
            }

            public final void writeTo(d dVar) throws IOException {
                dVar.d(fVar);
            }
        };
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i2, final int i3) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i2, (long) i3);
            return new RequestBody() {
                public final MediaType contentType() {
                    return mediaType;
                }

                public final long contentLength() {
                    return (long) i3;
                }

                public final void writeTo(d dVar) throws IOException {
                    dVar.c(bArr, i2, i3);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                public final MediaType contentType() {
                    return mediaType;
                }

                public final long contentLength() {
                    return file.length();
                }

                public final void writeTo(d dVar) throws IOException {
                    v vVar = null;
                    try {
                        vVar = n.a(file);
                        dVar.a(vVar);
                    } finally {
                        Util.closeQuietly((Closeable) vVar);
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
