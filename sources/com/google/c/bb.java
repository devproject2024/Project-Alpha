package com.google.c;

import com.google.c.j;
import com.google.c.k;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class bb extends j.g {
    /* access modifiers changed from: private */
    public final ByteBuffer buffer;

    bb(ByteBuffer byteBuffer) {
        ac.a(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private Object writeReplace() {
        return j.copyFrom(this.buffer.slice());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    public final byte byteAt(int i2) {
        try {
            return this.buffer.get(i2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new ArrayIndexOutOfBoundsException(e3.getMessage());
        }
    }

    public final byte internalByteAt(int i2) {
        return byteAt(i2);
    }

    public final int size() {
        return this.buffer.remaining();
    }

    public final j substring(int i2, int i3) {
        try {
            return new bb(slice(i2, i3));
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new ArrayIndexOutOfBoundsException(e3.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void copyToInternal(byte[] bArr, int i2, int i3, int i4) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i2);
        slice.get(bArr, i3, i4);
    }

    public final void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    /* access modifiers changed from: package-private */
    public final boolean equalsRange(j jVar, int i2, int i3) {
        return substring(0, i3).equals(jVar.substring(i2, i3 + i2));
    }

    /* access modifiers changed from: package-private */
    public final void writeToInternal(OutputStream outputStream, int i2, int i3) throws IOException {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i2, i3);
            return;
        }
        h.a(slice(i2, i3 + i2), outputStream);
    }

    /* access modifiers changed from: package-private */
    public final void writeTo(i iVar) throws IOException {
        iVar.a(this.buffer.slice());
    }

    public final ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    public final List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    /* access modifiers changed from: protected */
    public final String toStringInternal(Charset charset) {
        int i2;
        int i3;
        byte[] bArr;
        if (this.buffer.hasArray()) {
            bArr = this.buffer.array();
            i3 = this.buffer.arrayOffset() + this.buffer.position();
            i2 = this.buffer.remaining();
        } else {
            bArr = toByteArray();
            i3 = 0;
            i2 = bArr.length;
        }
        return new String(bArr, i3, i2, charset);
    }

    public final boolean isValidUtf8() {
        return by.a(this.buffer);
    }

    /* access modifiers changed from: protected */
    public final int partialIsValidUtf8(int i2, int i3, int i4) {
        return by.a(i2, this.buffer, i3, i4 + i3);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (size() != jVar.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof bb) {
            return this.buffer.equals(((bb) obj).buffer);
        }
        if (obj instanceof bl) {
            return obj.equals(this);
        }
        return this.buffer.equals(jVar.asReadOnlyByteBuffer());
    }

    /* access modifiers changed from: protected */
    public final int partialHash(int i2, int i3, int i4) {
        int i5 = i2;
        for (int i6 = i3; i6 < i3 + i4; i6++) {
            i5 = (i5 * 31) + this.buffer.get(i6);
        }
        return i5;
    }

    public final InputStream newInput() {
        return new InputStream() {

            /* renamed from: b  reason: collision with root package name */
            private final ByteBuffer f37747b = bb.this.buffer.slice();

            public final boolean markSupported() {
                return true;
            }

            public final void mark(int i2) {
                this.f37747b.mark();
            }

            public final void reset() throws IOException {
                try {
                    this.f37747b.reset();
                } catch (InvalidMarkException e2) {
                    throw new IOException(e2);
                }
            }

            public final int available() throws IOException {
                return this.f37747b.remaining();
            }

            public final int read() throws IOException {
                if (!this.f37747b.hasRemaining()) {
                    return -1;
                }
                return this.f37747b.get() & 255;
            }

            public final int read(byte[] bArr, int i2, int i3) throws IOException {
                if (!this.f37747b.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i3, this.f37747b.remaining());
                this.f37747b.get(bArr, i2, min);
                return min;
            }
        };
    }

    public final k newCodedInput() {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer.hasArray()) {
            return k.a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), true);
        }
        if (byteBuffer.isDirect() && bx.b()) {
            return new k.c(byteBuffer, (byte) 0);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.duplicate().get(bArr);
        return k.a(bArr, 0, bArr.length, true);
    }

    private ByteBuffer slice(int i2, int i3) {
        if (i2 < this.buffer.position() || i3 > this.buffer.limit() || i2 > i3) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
        }
        ByteBuffer slice = this.buffer.slice();
        slice.position(i2 - this.buffer.position());
        slice.limit(i3 - this.buffer.position());
        return slice;
    }
}
