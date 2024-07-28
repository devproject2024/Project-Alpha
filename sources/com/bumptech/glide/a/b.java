package com.bumptech.glide.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

final class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final Charset f6415a;

    /* renamed from: b  reason: collision with root package name */
    int f6416b;

    /* renamed from: c  reason: collision with root package name */
    private final InputStream f6417c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f6418d;

    /* renamed from: e  reason: collision with root package name */
    private int f6419e;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private b(InputStream inputStream, Charset charset, byte b2) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (charset.equals(c.f6421a)) {
            this.f6417c = inputStream;
            this.f6415a = charset;
            this.f6418d = new byte[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final void close() throws IOException {
        synchronized (this.f6417c) {
            if (this.f6418d != null) {
                this.f6418d = null;
                this.f6417c.close();
            }
        }
    }

    public final String a() throws IOException {
        int i2;
        int i3;
        synchronized (this.f6417c) {
            if (this.f6418d != null) {
                if (this.f6419e >= this.f6416b) {
                    b();
                }
                for (int i4 = this.f6419e; i4 != this.f6416b; i4++) {
                    if (this.f6418d[i4] == 10) {
                        if (i4 != this.f6419e) {
                            i3 = i4 - 1;
                            if (this.f6418d[i3] == 13) {
                                String str = new String(this.f6418d, this.f6419e, i3 - this.f6419e, this.f6415a.name());
                                this.f6419e = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f6418d, this.f6419e, i3 - this.f6419e, this.f6415a.name());
                        this.f6419e = i4 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.f6416b - this.f6419e) + 80) {
                    public final String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, b.this.f6415a.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1:
                while (true) {
                    r1.write(this.f6418d, this.f6419e, this.f6416b - this.f6419e);
                    this.f6416b = -1;
                    b();
                    i2 = this.f6419e;
                    while (true) {
                        if (i2 != this.f6416b) {
                            if (this.f6418d[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                if (i2 != this.f6419e) {
                    r1.write(this.f6418d, this.f6419e, i2 - this.f6419e);
                }
                this.f6419e = i2 + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    private void b() throws IOException {
        InputStream inputStream = this.f6417c;
        byte[] bArr = this.f6418d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f6419e = 0;
            this.f6416b = read;
            return;
        }
        throw new EOFException();
    }
}
