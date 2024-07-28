package i;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class t extends f {
    final transient int[] directory;
    final transient byte[][] segments;

    t(c cVar, int i2) {
        super((byte[]) null);
        x.a(cVar.f46277b, 0, (long) i2);
        int i3 = 0;
        r rVar = cVar.f46276a;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            if (rVar.f46322c != rVar.f46321b) {
                i4 += rVar.f46322c - rVar.f46321b;
                i5++;
                rVar = rVar.f46325f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i5][];
        this.directory = new int[(i5 * 2)];
        r rVar2 = cVar.f46276a;
        int i6 = 0;
        while (i3 < i2) {
            this.segments[i6] = rVar2.f46320a;
            i3 += rVar2.f46322c - rVar2.f46321b;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.directory;
            iArr[i6] = i3;
            iArr[this.segments.length + i6] = rVar2.f46321b;
            rVar2.f46323d = true;
            i6++;
            rVar2 = rVar2.f46325f;
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

    public final f toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public final f toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    public final f md5() {
        return toByteString().md5();
    }

    public final f sha1() {
        return toByteString().sha1();
    }

    public final f sha256() {
        return toByteString().sha256();
    }

    public final f hmacSha1(f fVar) {
        return toByteString().hmacSha1(fVar);
    }

    public final f hmacSha256(f fVar) {
        return toByteString().hmacSha256(fVar);
    }

    public final String base64Url() {
        return toByteString().base64Url();
    }

    public final f substring(int i2) {
        return toByteString().substring(i2);
    }

    public final f substring(int i2, int i3) {
        return toByteString().substring(i2, i3);
    }

    public final byte getByte(int i2) {
        int i3;
        x.a((long) this.directory[this.segments.length - 1], (long) i2, 1);
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
    public final void write(c cVar) {
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.directory;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            r rVar = new r(this.segments[i2], i4, (i4 + i5) - i3, true, false);
            if (cVar.f46276a == null) {
                rVar.f46326g = rVar;
                rVar.f46325f = rVar;
                cVar.f46276a = rVar;
            } else {
                cVar.f46276a.f46326g.a(rVar);
            }
            i2++;
            i3 = i5;
        }
        cVar.f46277b += (long) i3;
    }

    public final boolean rangeEquals(int i2, f fVar, int i3, int i4) {
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
            if (!fVar.rangeEquals(i3, bArr[segment], (i2 - i5) + iArr[bArr.length + segment], min)) {
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
            if (!x.a(bArr2[segment], (i2 - i5) + iArr[bArr2.length + segment], bArr, i3, min)) {
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

    private f toByteString() {
        return new f(toByteArray());
    }

    /* access modifiers changed from: package-private */
    public final byte[] internalArray() {
        return toByteArray();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return fVar.size() == size() && rangeEquals(0, fVar, 0, size());
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
