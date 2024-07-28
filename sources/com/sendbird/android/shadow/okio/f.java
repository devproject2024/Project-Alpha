package com.sendbird.android.shadow.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class f extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    f(Buffer buffer, int i2) {
        super((byte[]) null);
        g.a(buffer.size, 0, (long) i2);
        int i3 = 0;
        d dVar = buffer.head;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            if (dVar.f45275c != dVar.f45274b) {
                i4 += dVar.f45275c - dVar.f45274b;
                i5++;
                dVar = dVar.f45278f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i5][];
        this.directory = new int[(i5 * 2)];
        d dVar2 = buffer.head;
        int i6 = 0;
        while (i3 < i2) {
            this.segments[i6] = dVar2.f45273a;
            i3 += dVar2.f45275c - dVar2.f45274b;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.directory;
            iArr[i6] = i3;
            iArr[this.segments.length + i6] = dVar2.f45274b;
            dVar2.f45276d = true;
            i6++;
            dVar2 = dVar2.f45278f;
        }
    }

    public final String utf8() {
        return toByteString().utf8();
    }

    public final String string(Charset charset) {
        return toByteString().string(charset);
    }

    public final String base64() {
        return toByteString().base64();
    }

    public final String hex() {
        return toByteString().hex();
    }

    public final ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public final ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    public final ByteString md5() {
        return toByteString().md5();
    }

    public final ByteString sha1() {
        return toByteString().sha1();
    }

    public final ByteString sha256() {
        return toByteString().sha256();
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return toByteString().hmacSha1(byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return toByteString().hmacSha256(byteString);
    }

    public final String base64Url() {
        return toByteString().base64Url();
    }

    public final ByteString substring(int i2) {
        return toByteString().substring(i2);
    }

    public final ByteString substring(int i2, int i3) {
        return toByteString().substring(i2, i3);
    }

    public final byte getByte(int i2) {
        int i3;
        g.a((long) this.directory[this.segments.length - 1], (long) i2, 1);
        int segment = segment(i2);
        if (segment == 0) {
            i3 = 0;
        } else {
            i3 = this.directory[segment - 1];
        }
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[segment][(i2 - i3) + iArr[bArr.length + segment]];
    }

    private int segment(int i2) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public final int size() {
        return this.directory[this.segments.length - 1];
    }

    public final byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.directory;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.segments[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    public final ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public final void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            int length = this.segments.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int[] iArr = this.directory;
                int i4 = iArr[length + i2];
                int i5 = iArr[i2];
                outputStream.write(this.segments[i2], i4, i5 - i3);
                i2++;
                i3 = i5;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* access modifiers changed from: package-private */
    public final void write(Buffer buffer) {
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.directory;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            d dVar = new d(this.segments[i2], i4, (i4 + i5) - i3, true, false);
            if (buffer.head == null) {
                dVar.f45279g = dVar;
                dVar.f45278f = dVar;
                buffer.head = dVar;
            } else {
                buffer.head.f45279g.a(dVar);
            }
            i2++;
            i3 = i5;
        }
        buffer.size += (long) i3;
    }

    public final boolean rangeEquals(int i2, ByteString byteString, int i3, int i4) {
        int i5;
        if (i2 < 0 || i2 > size() - i4) {
            return false;
        }
        int segment = segment(i2);
        while (i4 > 0) {
            if (segment == 0) {
                i5 = 0;
            } else {
                i5 = this.directory[segment - 1];
            }
            int min = Math.min(i4, ((this.directory[segment] - i5) + i5) - i2);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i3, bArr[segment], (i2 - i5) + iArr[bArr.length + segment], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            segment++;
        }
        return true;
    }

    public final boolean rangeEquals(int i2, byte[] bArr, int i3, int i4) {
        int i5;
        if (i2 < 0 || i2 > size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int segment = segment(i2);
        while (i4 > 0) {
            if (segment == 0) {
                i5 = 0;
            } else {
                i5 = this.directory[segment - 1];
            }
            int min = Math.min(i4, ((this.directory[segment] - i5) + i5) - i2);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!g.a(bArr2[segment], (i2 - i5) + iArr[bArr2.length + segment], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            segment++;
        }
        return true;
    }

    public final int indexOf(byte[] bArr, int i2) {
        return toByteString().indexOf(bArr, i2);
    }

    public final int lastIndexOf(byte[] bArr, int i2) {
        return toByteString().lastIndexOf(bArr, i2);
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    /* access modifiers changed from: package-private */
    public final byte[] internalArray() {
        return toByteArray();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == size() && rangeEquals(0, byteString, 0, size());
        }
    }

    public final int hashCode() {
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
        }
        int length = this.segments.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            byte[] bArr = this.segments[i3];
            int[] iArr = this.directory;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i5) + i6;
            while (i6 < i8) {
                i4 = (i4 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i5 = i7;
        }
        this.hashCode = i4;
        return i4;
    }

    public final String toString() {
        return toByteString().toString();
    }

    private Object writeReplace() {
        return toByteString();
    }
}
