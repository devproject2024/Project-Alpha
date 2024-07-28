package com.sendbird.android.shadow.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class b implements BufferedSink {

    /* renamed from: a  reason: collision with root package name */
    public final Buffer f45265a = new Buffer();

    /* renamed from: b  reason: collision with root package name */
    public final Sink f45266b;

    /* renamed from: c  reason: collision with root package name */
    boolean f45267c;

    b(Sink sink) {
        if (sink != null) {
            this.f45266b = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public final Buffer buffer() {
        return this.f45265a;
    }

    public final void write(Buffer buffer, long j) throws IOException {
        if (!this.f45267c) {
            this.f45265a.write(buffer, j);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink write(ByteString byteString) throws IOException {
        if (!this.f45267c) {
            this.f45265a.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeUtf8(String str) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeUtf8(String str, int i2, int i3) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeUtf8(str, i2, i3);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeUtf8CodePoint(int i2) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeUtf8CodePoint(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeString(String str, Charset charset) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeString(str, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeString(String str, int i2, int i3, Charset charset) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeString(str, i2, i3, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink write(byte[] bArr) throws IOException {
        if (!this.f45267c) {
            this.f45265a.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink write(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f45267c) {
            this.f45265a.write(bArr, i2, i3);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f45267c) {
            int write = this.f45265a.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public final long writeAll(Source source) throws IOException {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this.f45265a, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
                emitCompleteSegments();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this.f45265a, j);
            if (read != -1) {
                j -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public final BufferedSink writeByte(int i2) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeByte(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeShort(int i2) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeShort(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeShortLe(int i2) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeShortLe(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeInt(int i2) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeInt(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeIntLe(int i2) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeIntLe(i2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeLong(long j) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeLongLe(long j) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeLongLe(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeDecimalLong(long j) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeDecimalLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink writeHexadecimalUnsignedLong(long j) throws IOException {
        if (!this.f45267c) {
            this.f45265a.writeHexadecimalUnsignedLong(j);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink emitCompleteSegments() throws IOException {
        if (!this.f45267c) {
            long completeSegmentByteCount = this.f45265a.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.f45266b.write(this.f45265a, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink emit() throws IOException {
        if (!this.f45267c) {
            long size = this.f45265a.size();
            if (size > 0) {
                this.f45266b.write(this.f45265a, size);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final OutputStream outputStream() {
        return new OutputStream() {
            public final void write(int i2) throws IOException {
                if (!b.this.f45267c) {
                    b.this.f45265a.writeByte((int) (byte) i2);
                    b.this.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }

            public final void write(byte[] bArr, int i2, int i3) throws IOException {
                if (!b.this.f45267c) {
                    b.this.f45265a.write(bArr, i2, i3);
                    b.this.emitCompleteSegments();
                    return;
                }
                throw new IOException("closed");
            }

            public final void flush() throws IOException {
                if (!b.this.f45267c) {
                    b.this.flush();
                }
            }

            public final void close() throws IOException {
                b.this.close();
            }

            public final String toString() {
                return b.this + ".outputStream()";
            }
        };
    }

    public final void flush() throws IOException {
        if (!this.f45267c) {
            if (this.f45265a.size > 0) {
                Sink sink = this.f45266b;
                Buffer buffer = this.f45265a;
                sink.write(buffer, buffer.size);
            }
            this.f45266b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final boolean isOpen() {
        return !this.f45267c;
    }

    public final void close() throws IOException {
        if (!this.f45267c) {
            Throwable th = null;
            try {
                if (this.f45265a.size > 0) {
                    this.f45266b.write(this.f45265a, this.f45265a.size);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f45266b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f45267c = true;
            if (th != null) {
                g.a(th);
            }
        }
    }

    public final Timeout timeout() {
        return this.f45266b.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f45266b + ")";
    }
}
