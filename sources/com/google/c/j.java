package com.google.c;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

public abstract class j implements Serializable, Iterable<Byte> {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final j EMPTY = new h(ac.f37699c);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<j> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<j>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            j jVar = (j) obj;
            j jVar2 = (j) obj2;
            e it2 = jVar.iterator();
            e it3 = jVar2.iterator();
            while (it2.hasNext() && it3.hasNext()) {
                int compare = Integer.compare(j.toInt(it2.a()), j.toInt(it3.a()));
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(jVar.size(), jVar2.size());
        }
    };
    private static final d byteArrayCopier = (d.a() ? new C0623j((byte) 0) : new b((byte) 0));
    private int hash = 0;

    interface d {
        byte[] a(byte[] bArr, int i2, int i3);
    }

    public interface e extends Iterator<Byte> {
        byte a();
    }

    /* access modifiers changed from: private */
    public static int toInt(byte b2) {
        return b2 & 255;
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i2);

    public abstract void copyTo(ByteBuffer byteBuffer);

    /* access modifiers changed from: protected */
    public abstract void copyToInternal(byte[] bArr, int i2, int i3, int i4);

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: protected */
    public abstract int getTreeDepth();

    /* access modifiers changed from: package-private */
    public abstract byte internalByteAt(int i2);

    /* access modifiers changed from: protected */
    public abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    public abstract k newCodedInput();

    public abstract InputStream newInput();

    /* access modifiers changed from: protected */
    public abstract int partialHash(int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract int partialIsValidUtf8(int i2, int i3, int i4);

    public abstract int size();

    public abstract j substring(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String toStringInternal(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void writeTo(i iVar) throws IOException;

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeToInternal(OutputStream outputStream, int i2, int i3) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeToReverse(i iVar) throws IOException;

    /* renamed from: com.google.c.j$j  reason: collision with other inner class name */
    static final class C0623j implements d {
        private C0623j() {
        }

        /* synthetic */ C0623j(byte b2) {
            this();
        }

        public final byte[] a(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
    }

    static final class b implements d {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final byte[] a(byte[] bArr, int i2, int i3) {
            return Arrays.copyOfRange(bArr, i2, i3 + i2);
        }
    }

    j() {
    }

    public e iterator() {
        return new a() {

            /* renamed from: b  reason: collision with root package name */
            private int f37855b = 0;

            /* renamed from: c  reason: collision with root package name */
            private final int f37856c = j.this.size();

            public final boolean hasNext() {
                return this.f37855b < this.f37856c;
            }

            public final byte a() {
                int i2 = this.f37855b;
                if (i2 < this.f37856c) {
                    this.f37855b = i2 + 1;
                    return j.this.internalByteAt(i2);
                }
                throw new NoSuchElementException();
            }
        };
    }

    static abstract class a implements e {
        a() {
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ Object next() {
            return Byte.valueOf(a());
        }
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public static Comparator<j> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public final j substring(int i2) {
        return substring(i2, size());
    }

    public final boolean startsWith(j jVar) {
        return size() >= jVar.size() && substring(0, jVar.size()).equals(jVar);
    }

    public final boolean endsWith(j jVar) {
        return size() >= jVar.size() && substring(size() - jVar.size()).equals(jVar);
    }

    public static j copyFrom(byte[] bArr, int i2, int i3) {
        checkRange(i2, i2 + i3, bArr.length);
        return new h(byteArrayCopier.a(bArr, i2, i3));
    }

    public static j copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    static j wrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new bb(byteBuffer);
        }
        return wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    static j wrap(byte[] bArr) {
        return new h(bArr);
    }

    static j wrap(byte[] bArr, int i2, int i3) {
        return new c(bArr, i2, i3);
    }

    public static j copyFrom(ByteBuffer byteBuffer, int i2) {
        checkRange(0, i2, byteBuffer.remaining());
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return new h(bArr);
    }

    public static j copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static j copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new h(str.getBytes(str2));
    }

    public static j copyFrom(String str, Charset charset) {
        return new h(str.getBytes(charset));
    }

    public static j copyFromUtf8(String str) {
        return new h(str.getBytes(ac.f37697a));
    }

    public static j readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    public static j readFrom(InputStream inputStream, int i2) throws IOException {
        return readFrom(inputStream, i2, i2);
    }

    public static j readFrom(InputStream inputStream, int i2, int i3) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            j readChunk = readChunk(inputStream, i2);
            if (readChunk == null) {
                return copyFrom((Iterable<j>) arrayList);
            }
            arrayList.add(readChunk);
            i2 = Math.min(i2 * 2, i3);
        }
    }

    private static j readChunk(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        if (i3 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i3);
    }

    public final j concat(j jVar) {
        if (Integer.MAX_VALUE - size() >= jVar.size()) {
            return bl.concatenate(this, jVar);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + jVar.size());
    }

    public static j copyFrom(Iterable<j> iterable) {
        int i2;
        if (!(iterable instanceof Collection)) {
            i2 = 0;
            Iterator<j> it2 = iterable.iterator();
            while (it2.hasNext()) {
                it2.next();
                i2++;
            }
        } else {
            i2 = ((Collection) iterable).size();
        }
        if (i2 == 0) {
            return EMPTY;
        }
        return balancedConcat(iterable.iterator(), i2);
    }

    private static j balancedConcat(Iterator<j> it2, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i2)}));
        } else if (i2 == 1) {
            return it2.next();
        } else {
            int i3 = i2 >>> 1;
            return balancedConcat(it2, i3).concat(balancedConcat(it2, i2 - i3));
        }
    }

    public void copyTo(byte[] bArr, int i2) {
        copyTo(bArr, 0, i2, size());
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i2, int i3, int i4) {
        checkRange(i2, i2 + i4, size());
        checkRange(i3, i3 + i4, bArr.length);
        if (i4 > 0) {
            copyToInternal(bArr, i2, i3, i4);
        }
    }

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return ac.f37699c;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final void writeTo(OutputStream outputStream, int i2, int i3) throws IOException {
        checkRange(i2, i2 + i3, size());
        if (i3 > 0) {
            writeToInternal(outputStream, i2, i3);
        }
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e2) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e2);
            throw unsupportedEncodingException;
        }
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    public final String toStringUtf8() {
        return toString(ac.f37697a);
    }

    static abstract class g extends j {
        /* access modifiers changed from: package-private */
        public abstract boolean equalsRange(j jVar, int i2, int i3);

        /* access modifiers changed from: protected */
        public final int getTreeDepth() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public final boolean isBalanced() {
            return true;
        }

        g() {
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return j.super.iterator();
        }

        /* access modifiers changed from: package-private */
        public void writeToReverse(i iVar) throws IOException {
            writeTo(iVar);
        }
    }

    public final int hashCode() {
        int i2 = this.hash;
        if (i2 == 0) {
            int size = size();
            i2 = partialHash(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.hash = i2;
        }
        return i2;
    }

    public static i newOutput(int i2) {
        return new i(i2);
    }

    public static i newOutput() {
        return new i(128);
    }

    public static final class i extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f37859a = new byte[0];

        /* renamed from: b  reason: collision with root package name */
        private final int f37860b;

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<j> f37861c;

        /* renamed from: d  reason: collision with root package name */
        private int f37862d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f37863e;

        /* renamed from: f  reason: collision with root package name */
        private int f37864f;

        i(int i2) {
            if (i2 >= 0) {
                this.f37860b = i2;
                this.f37861c = new ArrayList<>();
                this.f37863e = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        public final synchronized void write(int i2) {
            if (this.f37864f == this.f37863e.length) {
                a(1);
            }
            byte[] bArr = this.f37863e;
            int i3 = this.f37864f;
            this.f37864f = i3 + 1;
            bArr[i3] = (byte) i2;
        }

        public final synchronized void write(byte[] bArr, int i2, int i3) {
            if (i3 <= this.f37863e.length - this.f37864f) {
                System.arraycopy(bArr, i2, this.f37863e, this.f37864f, i3);
                this.f37864f += i3;
                return;
            }
            int length = this.f37863e.length - this.f37864f;
            System.arraycopy(bArr, i2, this.f37863e, this.f37864f, length);
            int i4 = i3 - length;
            a(i4);
            System.arraycopy(bArr, i2 + length, this.f37863e, 0, i4);
            this.f37864f = i4;
        }

        private synchronized int a() {
            return this.f37862d + this.f37864f;
        }

        public final String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(a())});
        }

        private void a(int i2) {
            this.f37861c.add(new h(this.f37863e));
            this.f37862d += this.f37863e.length;
            this.f37863e = new byte[Math.max(this.f37860b, Math.max(i2, this.f37862d >>> 1))];
            this.f37864f = 0;
        }
    }

    static f newCodedBuilder(int i2) {
        return new f(i2, (byte) 0);
    }

    static final class f {

        /* renamed from: a  reason: collision with root package name */
        final m f37857a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f37858b;

        /* synthetic */ f(int i2, byte b2) {
            this(i2);
        }

        private f(int i2) {
            this.f37858b = new byte[i2];
            this.f37857a = m.a(this.f37858b);
        }

        public final j a() {
            this.f37857a.i();
            return new h(this.f37858b);
        }
    }

    /* access modifiers changed from: protected */
    public final int peekCachedHashCode() {
        return this.hash;
    }

    static void checkIndex(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return;
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: ".concat(String.valueOf(i2)));
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
    }

    static int checkRange(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        } else if (i3 < i2) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + ", " + i3);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
        }
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay()});
    }

    private String truncateAndEscapeForDisplay() {
        if (size() <= 50) {
            return br.a(this);
        }
        return br.a(substring(0, 47)) + AppConstants.DOTS;
    }

    static class h extends g {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        /* access modifiers changed from: protected */
        public int getOffsetIntoBytes() {
            return 0;
        }

        h(byte[] bArr) {
            if (bArr != null) {
                this.bytes = bArr;
                return;
            }
            throw new NullPointerException();
        }

        public byte byteAt(int i2) {
            return this.bytes[i2];
        }

        /* access modifiers changed from: package-private */
        public byte internalByteAt(int i2) {
            return this.bytes[i2];
        }

        public int size() {
            return this.bytes.length;
        }

        public final j substring(int i2, int i3) {
            int checkRange = checkRange(i2, i3, size());
            if (checkRange == 0) {
                return j.EMPTY;
            }
            return new c(this.bytes, getOffsetIntoBytes() + i2, checkRange);
        }

        /* access modifiers changed from: protected */
        public void copyToInternal(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.bytes, i2, bArr, i3, i4);
        }

        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }

        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        /* access modifiers changed from: package-private */
        public final void writeToInternal(OutputStream outputStream, int i2, int i3) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + i2, i3);
        }

        /* access modifiers changed from: package-private */
        public final void writeTo(i iVar) throws IOException {
            iVar.a(this.bytes, getOffsetIntoBytes(), size());
        }

        /* access modifiers changed from: protected */
        public final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return by.a(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        /* access modifiers changed from: protected */
        public final int partialIsValidUtf8(int i2, int i3, int i4) {
            int offsetIntoBytes = getOffsetIntoBytes() + i3;
            return by.a(i2, this.bytes, offsetIntoBytes, i4 + offsetIntoBytes);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof j) || size() != ((j) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof h)) {
                return obj.equals(this);
            }
            h hVar = (h) obj;
            int peekCachedHashCode = peekCachedHashCode();
            int peekCachedHashCode2 = hVar.peekCachedHashCode();
            if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
                return equalsRange(hVar, 0, size());
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean equalsRange(j jVar, int i2, int i3) {
            if (i3 <= jVar.size()) {
                int i4 = i2 + i3;
                if (i4 > jVar.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i2 + ", " + i3 + ", " + jVar.size());
                } else if (!(jVar instanceof h)) {
                    return jVar.substring(i2, i4).equals(substring(0, i3));
                } else {
                    h hVar = (h) jVar;
                    byte[] bArr = this.bytes;
                    byte[] bArr2 = hVar.bytes;
                    int offsetIntoBytes = getOffsetIntoBytes() + i3;
                    int offsetIntoBytes2 = getOffsetIntoBytes();
                    int offsetIntoBytes3 = hVar.getOffsetIntoBytes() + i2;
                    while (offsetIntoBytes2 < offsetIntoBytes) {
                        if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                            return false;
                        }
                        offsetIntoBytes2++;
                        offsetIntoBytes3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i3 + size());
            }
        }

        /* access modifiers changed from: protected */
        public final int partialHash(int i2, int i3, int i4) {
            return ac.a(i2, this.bytes, getOffsetIntoBytes() + i3, i4);
        }

        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        public final k newCodedInput() {
            return k.a(this.bytes, getOffsetIntoBytes(), size(), true);
        }
    }

    static final class c extends h {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        c(byte[] bArr, int i2, int i3) {
            super(bArr);
            checkRange(i2, i2 + i3, bArr.length);
            this.bytesOffset = i2;
            this.bytesLength = i3;
        }

        public final byte byteAt(int i2) {
            checkIndex(i2, size());
            return this.bytes[this.bytesOffset + i2];
        }

        /* access modifiers changed from: package-private */
        public final byte internalByteAt(int i2) {
            return this.bytes[this.bytesOffset + i2];
        }

        public final int size() {
            return this.bytesLength;
        }

        /* access modifiers changed from: protected */
        public final int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        /* access modifiers changed from: protected */
        public final void copyToInternal(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i2, bArr, i3, i4);
        }

        /* access modifiers changed from: package-private */
        public final Object writeReplace() {
            return j.wrap(toByteArray());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }
    }
}
