package com.sendbird.android.shadow.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class c implements BufferedSource {

    /* renamed from: a  reason: collision with root package name */
    public final Buffer f45269a = new Buffer();

    /* renamed from: b  reason: collision with root package name */
    public final Source f45270b;

    /* renamed from: c  reason: collision with root package name */
    boolean f45271c;

    c(Source source) {
        if (source != null) {
            this.f45270b = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public final Buffer buffer() {
        return this.f45269a;
    }

    public final long read(Buffer buffer, long j) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.f45271c) {
            throw new IllegalStateException("closed");
        } else if (this.f45269a.size == 0 && this.f45270b.read(this.f45269a, 8192) == -1) {
            return -1;
        } else {
            return this.f45269a.read(buffer, Math.min(j, this.f45269a.size));
        }
    }

    public final boolean exhausted() throws IOException {
        if (!this.f45271c) {
            return this.f45269a.exhausted() && this.f45270b.read(this.f45269a, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public final void require(long j) throws IOException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    public final boolean request(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (!this.f45271c) {
            while (this.f45269a.size < j) {
                if (this.f45270b.read(this.f45269a, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final byte readByte() throws IOException {
        require(1);
        return this.f45269a.readByte();
    }

    public final ByteString readByteString() throws IOException {
        this.f45269a.writeAll(this.f45270b);
        return this.f45269a.readByteString();
    }

    public final ByteString readByteString(long j) throws IOException {
        require(j);
        return this.f45269a.readByteString(j);
    }

    public final int select(Options options) throws IOException {
        if (!this.f45271c) {
            do {
                int selectPrefix = this.f45269a.selectPrefix(options, true);
                if (selectPrefix == -1) {
                    return -1;
                }
                if (selectPrefix != -2) {
                    this.f45269a.skip((long) options.byteStrings[selectPrefix].size());
                    return selectPrefix;
                }
            } while (this.f45270b.read(this.f45269a, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public final byte[] readByteArray() throws IOException {
        this.f45269a.writeAll(this.f45270b);
        return this.f45269a.readByteArray();
    }

    public final byte[] readByteArray(long j) throws IOException {
        require(j);
        return this.f45269a.readByteArray(j);
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final void readFully(byte[] bArr) throws IOException {
        try {
            require((long) bArr.length);
            this.f45269a.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.f45269a.size > 0) {
                Buffer buffer = this.f45269a;
                int read = buffer.read(bArr, i2, (int) buffer.size);
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e2;
        }
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        long j = (long) i3;
        g.a((long) bArr.length, (long) i2, j);
        if (this.f45269a.size == 0 && this.f45270b.read(this.f45269a, 8192) == -1) {
            return -1;
        }
        return this.f45269a.read(bArr, i2, (int) Math.min(j, this.f45269a.size));
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f45269a.size == 0 && this.f45270b.read(this.f45269a, 8192) == -1) {
            return -1;
        }
        return this.f45269a.read(byteBuffer);
    }

    public final void readFully(Buffer buffer, long j) throws IOException {
        try {
            require(j);
            this.f45269a.readFully(buffer, j);
        } catch (EOFException e2) {
            buffer.writeAll(this.f45269a);
            throw e2;
        }
    }

    public final long readAll(Sink sink) throws IOException {
        if (sink != null) {
            long j = 0;
            while (this.f45270b.read(this.f45269a, 8192) != -1) {
                long completeSegmentByteCount = this.f45269a.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    j += completeSegmentByteCount;
                    sink.write(this.f45269a, completeSegmentByteCount);
                }
            }
            if (this.f45269a.size() <= 0) {
                return j;
            }
            long size = j + this.f45269a.size();
            Buffer buffer = this.f45269a;
            sink.write(buffer, buffer.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public final String readUtf8() throws IOException {
        this.f45269a.writeAll(this.f45270b);
        return this.f45269a.readUtf8();
    }

    public final String readUtf8(long j) throws IOException {
        require(j);
        return this.f45269a.readUtf8(j);
    }

    public final String readString(Charset charset) throws IOException {
        if (charset != null) {
            this.f45269a.writeAll(this.f45270b);
            return this.f45269a.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public final String readString(long j, Charset charset) throws IOException {
        require(j);
        if (charset != null) {
            return this.f45269a.readString(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public final String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.f45269a.readUtf8Line(indexOf);
        }
        if (this.f45269a.size != 0) {
            return readUtf8(this.f45269a.size);
        }
        return null;
    }

    public final String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public final String readUtf8LineStrict(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return this.f45269a.readUtf8Line(indexOf);
            }
            if (j2 < Long.MAX_VALUE && request(j2) && this.f45269a.getByte(j2 - 1) == 13 && request(1 + j2) && this.f45269a.getByte(j2) == 10) {
                return this.f45269a.readUtf8Line(j2);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.f45269a;
            buffer2.copyTo(buffer, 0, Math.min(32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f45269a.size(), j) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
    }

    public final int readUtf8CodePoint() throws IOException {
        require(1);
        byte b2 = this.f45269a.getByte(0);
        if ((b2 & 224) == 192) {
            require(2);
        } else if ((b2 & 240) == 224) {
            require(3);
        } else if ((b2 & 248) == 240) {
            require(4);
        }
        return this.f45269a.readUtf8CodePoint();
    }

    public final short readShort() throws IOException {
        require(2);
        return this.f45269a.readShort();
    }

    public final short readShortLe() throws IOException {
        require(2);
        return this.f45269a.readShortLe();
    }

    public final int readInt() throws IOException {
        require(4);
        return this.f45269a.readInt();
    }

    public final int readIntLe() throws IOException {
        require(4);
        return this.f45269a.readIntLe();
    }

    public final long readLong() throws IOException {
        require(8);
        return this.f45269a.readLong();
    }

    public final long readLongLe() throws IOException {
        require(8);
        return this.f45269a.readLongLe();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long readDecimalLong() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.require(r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.request(r3)
            if (r3 == 0) goto L_0x0040
            com.sendbird.android.shadow.okio.Buffer r3 = r6.f45269a
            long r4 = (long) r1
            byte r3 = r3.getByte(r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            com.sendbird.android.shadow.okio.Buffer r0 = r6.f45269a
            long r0 = r0.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okio.c.readDecimalLong():long");
    }

    public final long readHexadecimalUnsignedLong() throws IOException {
        require(1);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!request((long) i3)) {
                break;
            }
            byte b2 = this.f45269a.getByte((long) i2);
            if ((b2 >= 48 && b2 <= 57) || ((b2 >= 97 && b2 <= 102) || (b2 >= 65 && b2 <= 70))) {
                i2 = i3;
            } else if (i2 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b2)}));
            }
        }
        return this.f45269a.readHexadecimalUnsignedLong();
    }

    public final void skip(long j) throws IOException {
        if (!this.f45271c) {
            while (j > 0) {
                if (this.f45269a.size == 0 && this.f45270b.read(this.f45269a, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f45269a.size());
                this.f45269a.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final long indexOf(byte b2) throws IOException {
        return indexOf(b2, 0, Long.MAX_VALUE);
    }

    public final long indexOf(byte b2, long j) throws IOException {
        return indexOf(b2, j, Long.MAX_VALUE);
    }

    public final long indexOf(byte b2, long j, long j2) throws IOException {
        if (this.f45271c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long indexOf = this.f45269a.indexOf(b2, j, j2);
                if (indexOf == -1) {
                    long j3 = this.f45269a.size;
                    if (j3 >= j2 || this.f45270b.read(this.f45269a, 8192) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return indexOf;
                }
            }
            return -1;
        }
    }

    public final long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public final long indexOf(ByteString byteString, long j) throws IOException {
        if (!this.f45271c) {
            while (true) {
                long indexOf = this.f45269a.indexOf(byteString, j);
                if (indexOf != -1) {
                    return indexOf;
                }
                long j2 = this.f45269a.size;
                if (this.f45270b.read(this.f45269a, 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, (j2 - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0);
    }

    public final long indexOfElement(ByteString byteString, long j) throws IOException {
        if (!this.f45271c) {
            while (true) {
                long indexOfElement = this.f45269a.indexOfElement(byteString, j);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                long j2 = this.f45269a.size;
                if (this.f45270b.read(this.f45269a, 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, j2);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final boolean rangeEquals(long j, ByteString byteString) throws IOException {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    public final boolean rangeEquals(long j, ByteString byteString, int i2, int i3) throws IOException {
        if (this.f45271c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || i2 < 0 || i3 < 0 || byteString.size() - i2 < i3) {
            return false;
        } else {
            for (int i4 = 0; i4 < i3; i4++) {
                long j2 = ((long) i4) + j;
                if (!request(1 + j2) || this.f45269a.getByte(j2) != byteString.getByte(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final InputStream inputStream() {
        return new InputStream() {
            public final int read() throws IOException {
                if (c.this.f45271c) {
                    throw new IOException("closed");
                } else if (c.this.f45269a.size == 0 && c.this.f45270b.read(c.this.f45269a, 8192) == -1) {
                    return -1;
                } else {
                    return c.this.f45269a.readByte() & 255;
                }
            }

            public final int read(byte[] bArr, int i2, int i3) throws IOException {
                if (!c.this.f45271c) {
                    g.a((long) bArr.length, (long) i2, (long) i3);
                    if (c.this.f45269a.size == 0 && c.this.f45270b.read(c.this.f45269a, 8192) == -1) {
                        return -1;
                    }
                    return c.this.f45269a.read(bArr, i2, i3);
                }
                throw new IOException("closed");
            }

            public final int available() throws IOException {
                if (!c.this.f45271c) {
                    return (int) Math.min(c.this.f45269a.size, 2147483647L);
                }
                throw new IOException("closed");
            }

            public final void close() throws IOException {
                c.this.close();
            }

            public final String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public final boolean isOpen() {
        return !this.f45271c;
    }

    public final void close() throws IOException {
        if (!this.f45271c) {
            this.f45271c = true;
            this.f45270b.close();
            this.f45269a.clear();
        }
    }

    public final Timeout timeout() {
        return this.f45270b.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f45270b + ")";
    }
}
