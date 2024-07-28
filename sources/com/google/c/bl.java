package com.google.c;

import com.google.c.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;

final class bl extends j {
    static final int[] minLengthByDepth = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, UpiPushView.REQUEST_CODE_UPI_CHECK_BALANCE, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final j left;
    private final int leftLength;
    /* access modifiers changed from: private */
    public final j right;
    private final int totalLength;
    private final int treeDepth;

    private bl(j jVar, j jVar2) {
        this.left = jVar;
        this.right = jVar2;
        this.leftLength = jVar.size();
        this.totalLength = this.leftLength + jVar2.size();
        this.treeDepth = Math.max(jVar.getTreeDepth(), jVar2.getTreeDepth()) + 1;
    }

    static j concatenate(j jVar, j jVar2) {
        if (jVar2.size() == 0) {
            return jVar;
        }
        if (jVar.size() == 0) {
            return jVar2;
        }
        int size = jVar.size() + jVar2.size();
        if (size < 128) {
            return concatenateBytes(jVar, jVar2);
        }
        if (jVar instanceof bl) {
            bl blVar = (bl) jVar;
            if (blVar.right.size() + jVar2.size() < 128) {
                return new bl(blVar.left, concatenateBytes(blVar.right, jVar2));
            } else if (blVar.left.getTreeDepth() > blVar.right.getTreeDepth() && blVar.getTreeDepth() > jVar2.getTreeDepth()) {
                return new bl(blVar.left, new bl(blVar.right, jVar2));
            }
        }
        if (size >= minLength(Math.max(jVar.getTreeDepth(), jVar2.getTreeDepth()) + 1)) {
            return new bl(jVar, jVar2);
        }
        a aVar = new a((byte) 0);
        aVar.a(jVar);
        aVar.a(jVar2);
        j pop = aVar.f37763a.pop();
        while (!aVar.f37763a.isEmpty()) {
            pop = new bl(aVar.f37763a.pop(), pop);
        }
        return pop;
    }

    private static j concatenateBytes(j jVar, j jVar2) {
        int size = jVar.size();
        int size2 = jVar2.size();
        byte[] bArr = new byte[(size + size2)];
        jVar.copyTo(bArr, 0, 0, size);
        jVar2.copyTo(bArr, 0, size, size2);
        return j.wrap(bArr);
    }

    static bl newInstanceForTest(j jVar, j jVar2) {
        return new bl(jVar, jVar2);
    }

    static int minLength(int i2) {
        int[] iArr = minLengthByDepth;
        if (i2 >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i2];
    }

    public final byte byteAt(int i2) {
        checkIndex(i2, this.totalLength);
        return internalByteAt(i2);
    }

    /* access modifiers changed from: package-private */
    public final byte internalByteAt(int i2) {
        int i3 = this.leftLength;
        if (i2 < i3) {
            return this.left.internalByteAt(i2);
        }
        return this.right.internalByteAt(i2 - i3);
    }

    public final int size() {
        return this.totalLength;
    }

    public final j.e iterator() {
        return new j.a() {

            /* renamed from: a  reason: collision with root package name */
            final b f37760a = new b(bl.this, (byte) 0);

            /* renamed from: b  reason: collision with root package name */
            j.e f37761b = b();

            private j.e b() {
                if (this.f37760a.hasNext()) {
                    return this.f37760a.next().iterator();
                }
                return null;
            }

            public final boolean hasNext() {
                return this.f37761b != null;
            }

            public final byte a() {
                j.e eVar = this.f37761b;
                if (eVar != null) {
                    byte a2 = eVar.a();
                    if (!this.f37761b.hasNext()) {
                        this.f37761b = b();
                    }
                    return a2;
                }
                throw new NoSuchElementException();
            }
        };
    }

    /* access modifiers changed from: protected */
    public final int getTreeDepth() {
        return this.treeDepth;
    }

    /* access modifiers changed from: protected */
    public final boolean isBalanced() {
        return this.totalLength >= minLength(this.treeDepth);
    }

    public final j substring(int i2, int i3) {
        int checkRange = checkRange(i2, i3, this.totalLength);
        if (checkRange == 0) {
            return j.EMPTY;
        }
        if (checkRange == this.totalLength) {
            return this;
        }
        int i4 = this.leftLength;
        if (i3 <= i4) {
            return this.left.substring(i2, i3);
        }
        if (i2 >= i4) {
            return this.right.substring(i2 - i4, i3 - i4);
        }
        return new bl(this.left.substring(i2), this.right.substring(0, i3 - this.leftLength));
    }

    /* access modifiers changed from: protected */
    public final void copyToInternal(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        int i6 = this.leftLength;
        if (i5 <= i6) {
            this.left.copyToInternal(bArr, i2, i3, i4);
        } else if (i2 >= i6) {
            this.right.copyToInternal(bArr, i2 - i6, i3, i4);
        } else {
            int i7 = i6 - i2;
            this.left.copyToInternal(bArr, i2, i3, i7);
            this.right.copyToInternal(bArr, 0, i3 + i7, i4 - i7);
        }
    }

    public final void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    public final ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public final List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        b bVar = new b(this, (byte) 0);
        while (bVar.hasNext()) {
            arrayList.add(bVar.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    /* access modifiers changed from: package-private */
    public final void writeToInternal(OutputStream outputStream, int i2, int i3) throws IOException {
        int i4 = i2 + i3;
        int i5 = this.leftLength;
        if (i4 <= i5) {
            this.left.writeToInternal(outputStream, i2, i3);
        } else if (i2 >= i5) {
            this.right.writeToInternal(outputStream, i2 - i5, i3);
        } else {
            int i6 = i5 - i2;
            this.left.writeToInternal(outputStream, i2, i6);
            this.right.writeToInternal(outputStream, 0, i3 - i6);
        }
    }

    /* access modifiers changed from: package-private */
    public final void writeTo(i iVar) throws IOException {
        this.left.writeTo(iVar);
        this.right.writeTo(iVar);
    }

    /* access modifiers changed from: package-private */
    public final void writeToReverse(i iVar) throws IOException {
        this.right.writeToReverse(iVar);
        this.left.writeToReverse(iVar);
    }

    /* access modifiers changed from: protected */
    public final String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    public final boolean isValidUtf8() {
        int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        j jVar = this.right;
        if (jVar.partialIsValidUtf8(partialIsValidUtf8, 0, jVar.size()) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int partialIsValidUtf8(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.leftLength;
        if (i5 <= i6) {
            return this.left.partialIsValidUtf8(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.right.partialIsValidUtf8(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i2, i3, i7), 0, i4 - i7);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.totalLength != jVar.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int peekCachedHashCode = peekCachedHashCode();
        int peekCachedHashCode2 = jVar.peekCachedHashCode();
        if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
            return equalsFragments(jVar);
        }
        return false;
    }

    private boolean equalsFragments(j jVar) {
        boolean z;
        b bVar = new b(this, (byte) 0);
        j.g gVar = (j.g) bVar.next();
        b bVar2 = new b(jVar, (byte) 0);
        j.g gVar2 = (j.g) bVar2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int size = gVar.size() - i2;
            int size2 = gVar2.size() - i3;
            int min = Math.min(size, size2);
            if (i2 == 0) {
                z = gVar.equalsRange(gVar2, i3, min);
            } else {
                z = gVar2.equalsRange(gVar, i2, min);
            }
            if (!z) {
                return false;
            }
            i4 += min;
            int i5 = this.totalLength;
            if (i4 < i5) {
                if (min == size) {
                    gVar = (j.g) bVar.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
                if (min == size2) {
                    gVar2 = (j.g) bVar2.next();
                    i3 = 0;
                } else {
                    i3 += min;
                }
            } else if (i4 == i5) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int partialHash(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.leftLength;
        if (i5 <= i6) {
            return this.left.partialHash(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.right.partialHash(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.right.partialHash(this.left.partialHash(i2, i3, i7), 0, i4 - i7);
    }

    public final k newCodedInput() {
        return k.a((InputStream) new c());
    }

    public final InputStream newInput() {
        return new c();
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final ArrayDeque<j> f37763a;

        private a() {
            this.f37763a = new ArrayDeque<>();
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void a(j jVar) {
            while (!jVar.isBalanced()) {
                if (jVar instanceof bl) {
                    bl blVar = (bl) jVar;
                    a(blVar.left);
                    jVar = blVar.right;
                } else {
                    throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + jVar.getClass());
                }
            }
            int a2 = a(jVar.size());
            int minLength = bl.minLength(a2 + 1);
            if (this.f37763a.isEmpty() || this.f37763a.peek().size() >= minLength) {
                this.f37763a.push(jVar);
                return;
            }
            int minLength2 = bl.minLength(a2);
            j pop = this.f37763a.pop();
            while (!this.f37763a.isEmpty() && this.f37763a.peek().size() < minLength2) {
                pop = new bl(this.f37763a.pop(), pop);
            }
            bl blVar2 = new bl(pop, jVar);
            while (!this.f37763a.isEmpty() && this.f37763a.peek().size() < bl.minLength(a(blVar2.size()) + 1)) {
                blVar2 = new bl(this.f37763a.pop(), blVar2);
            }
            this.f37763a.push(blVar2);
        }

        private static int a(int i2) {
            int binarySearch = Arrays.binarySearch(bl.minLengthByDepth, i2);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }
    }

    static final class b implements Iterator<j.g> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayDeque<bl> f37764a;

        /* renamed from: b  reason: collision with root package name */
        private j.g f37765b;

        /* synthetic */ b(j jVar, byte b2) {
            this(jVar);
        }

        private b(j jVar) {
            if (jVar instanceof bl) {
                bl blVar = (bl) jVar;
                this.f37764a = new ArrayDeque<>(blVar.getTreeDepth());
                this.f37764a.push(blVar);
                this.f37765b = a(blVar.left);
                return;
            }
            this.f37764a = null;
            this.f37765b = (j.g) jVar;
        }

        private j.g a(j jVar) {
            while (jVar instanceof bl) {
                bl blVar = (bl) jVar;
                this.f37764a.push(blVar);
                jVar = blVar.left;
            }
            return (j.g) jVar;
        }

        private j.g b() {
            j.g a2;
            do {
                ArrayDeque<bl> arrayDeque = this.f37764a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                a2 = a(this.f37764a.pop().right);
            } while (a2.isEmpty());
            return a2;
        }

        public final boolean hasNext() {
            return this.f37765b != null;
        }

        /* renamed from: a */
        public final j.g next() {
            j.g gVar = this.f37765b;
            if (gVar != null) {
                this.f37765b = b();
                return gVar;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: package-private */
    public final Object writeReplace() {
        return j.wrap(toByteArray());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    class c extends InputStream {

        /* renamed from: b  reason: collision with root package name */
        private b f37767b;

        /* renamed from: c  reason: collision with root package name */
        private j.g f37768c;

        /* renamed from: d  reason: collision with root package name */
        private int f37769d;

        /* renamed from: e  reason: collision with root package name */
        private int f37770e;

        /* renamed from: f  reason: collision with root package name */
        private int f37771f;

        /* renamed from: g  reason: collision with root package name */
        private int f37772g;

        public final boolean markSupported() {
            return true;
        }

        public c() {
            a();
        }

        public final int read(byte[] bArr, int i2, int i3) {
            if (bArr == null) {
                throw new NullPointerException();
            } else if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
                throw new IndexOutOfBoundsException();
            } else {
                int a2 = a(bArr, i2, i3);
                if (a2 == 0) {
                    return -1;
                }
                return a2;
            }
        }

        public final long skip(long j) {
            if (j >= 0) {
                if (j > 2147483647L) {
                    j = 2147483647L;
                }
                return (long) a((byte[]) null, 0, (int) j);
            }
            throw new IndexOutOfBoundsException();
        }

        private int a(byte[] bArr, int i2, int i3) {
            int i4 = i2;
            int i5 = i3;
            while (i5 > 0) {
                b();
                if (this.f37768c == null) {
                    break;
                }
                int min = Math.min(this.f37769d - this.f37770e, i5);
                if (bArr != null) {
                    this.f37768c.copyTo(bArr, this.f37770e, i4, min);
                    i4 += min;
                }
                this.f37770e += min;
                i5 -= min;
            }
            return i3 - i5;
        }

        public final int read() throws IOException {
            b();
            j.g gVar = this.f37768c;
            if (gVar == null) {
                return -1;
            }
            int i2 = this.f37770e;
            this.f37770e = i2 + 1;
            return gVar.byteAt(i2) & 255;
        }

        public final int available() throws IOException {
            return bl.this.size() - (this.f37771f + this.f37770e);
        }

        public final void mark(int i2) {
            this.f37772g = this.f37771f + this.f37770e;
        }

        public final synchronized void reset() {
            a();
            a((byte[]) null, 0, this.f37772g);
        }

        private void a() {
            this.f37767b = new b(bl.this, (byte) 0);
            this.f37768c = this.f37767b.next();
            this.f37769d = this.f37768c.size();
            this.f37770e = 0;
            this.f37771f = 0;
        }

        private void b() {
            int i2;
            if (this.f37768c != null && this.f37770e == (i2 = this.f37769d)) {
                this.f37771f += i2;
                this.f37770e = 0;
                if (this.f37767b.hasNext()) {
                    this.f37768c = this.f37767b.next();
                    this.f37769d = this.f37768c.size();
                    return;
                }
                this.f37768c = null;
                this.f37769d = 0;
            }
        }
    }
}
