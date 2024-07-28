package com.google.c;

import com.google.c.by;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class m extends i {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f37890a = bx.a();

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f37891d = Logger.getLogger(m.class.getName());

    /* renamed from: b  reason: collision with root package name */
    n f37892b;

    /* renamed from: c  reason: collision with root package name */
    boolean f37893c;

    public static int a() {
        return 4;
    }

    public static int b() {
        return 4;
    }

    public static int c() {
        return 8;
    }

    public static int d() {
        return 8;
    }

    public static int e() {
        return 4;
    }

    public static int e(long j) {
        int i2;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i2 = 6;
            j >>>= 28;
        } else {
            i2 = 2;
        }
        if ((-2097152 & j) != 0) {
            i2 += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i2 + 1 : i2;
    }

    public static int f() {
        return 8;
    }

    public static int g() {
        return 1;
    }

    private static long g(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int n(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    private static int s(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public abstract void a(byte b2) throws IOException;

    public abstract void a(int i2) throws IOException;

    public abstract void a(int i2, int i3) throws IOException;

    public abstract void a(int i2, long j) throws IOException;

    public abstract void a(int i2, at atVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(int i2, at atVar, bm bmVar) throws IOException;

    public abstract void a(int i2, j jVar) throws IOException;

    public abstract void a(int i2, String str) throws IOException;

    public abstract void a(int i2, boolean z) throws IOException;

    public abstract void a(long j) throws IOException;

    public abstract void a(at atVar) throws IOException;

    public abstract void a(j jVar) throws IOException;

    public abstract void a(String str) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(byte[] bArr, int i2) throws IOException;

    public abstract void a(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void b(int i2) throws IOException;

    public abstract void b(int i2, int i3) throws IOException;

    public abstract void b(int i2, j jVar) throws IOException;

    public abstract void c(int i2, int i3) throws IOException;

    public abstract void c(int i2, long j) throws IOException;

    public abstract void c(long j) throws IOException;

    public abstract void d(int i2) throws IOException;

    public abstract void e(int i2, int i3) throws IOException;

    public abstract int h();

    /* synthetic */ m(byte b2) {
        this();
    }

    public static m a(byte[] bArr) {
        return new a(bArr, bArr.length);
    }

    private m() {
    }

    public final void d(int i2, int i3) throws IOException {
        c(i2, s(i3));
    }

    public final void b(int i2, long j) throws IOException {
        a(i2, g(j));
    }

    public final void a(int i2, float f2) throws IOException {
        e(i2, Float.floatToRawIntBits(f2));
    }

    public final void a(int i2, double d2) throws IOException {
        c(i2, Double.doubleToRawLongBits(d2));
    }

    public final void c(int i2) throws IOException {
        b(s(i2));
    }

    public final void b(long j) throws IOException {
        a(g(j));
    }

    public final void a(float f2) throws IOException {
        d(Float.floatToRawIntBits(f2));
    }

    public final void a(double d2) throws IOException {
        c(Double.doubleToRawLongBits(d2));
    }

    public final void a(boolean z) throws IOException {
        a(z ? (byte) 1 : 0);
    }

    public static int f(int i2, int i3) {
        return l(i2) + m(i3);
    }

    public static int g(int i2, int i3) {
        return l(i2) + n(i3);
    }

    public static int h(int i2, int i3) {
        return l(i2) + n(s(i3));
    }

    public static int e(int i2) {
        return l(i2) + 4;
    }

    public static int f(int i2) {
        return l(i2) + 4;
    }

    public static int d(int i2, long j) {
        return l(i2) + e(j);
    }

    public static int e(int i2, long j) {
        return l(i2) + e(j);
    }

    public static int f(int i2, long j) {
        return l(i2) + e(g(j));
    }

    public static int g(int i2) {
        return l(i2) + 8;
    }

    public static int h(int i2) {
        return l(i2) + 8;
    }

    public static int i(int i2) {
        return l(i2) + 4;
    }

    public static int j(int i2) {
        return l(i2) + 8;
    }

    public static int k(int i2) {
        return l(i2) + 1;
    }

    public static int i(int i2, int i3) {
        return l(i2) + m(i3);
    }

    public static int b(int i2, String str) {
        return l(i2) + b(str);
    }

    public static int c(int i2, j jVar) {
        int l = l(i2);
        int size = jVar.size();
        return l + n(size) + size;
    }

    public static int a(int i2, ag agVar) {
        int l = l(i2);
        int b2 = agVar.b();
        return l + n(b2) + b2;
    }

    static int b(int i2, at atVar, bm bmVar) {
        return l(i2) + a(atVar, bmVar);
    }

    public static int b(int i2, at atVar) {
        return (l(1) * 2) + g(2, i2) + l(3) + b(atVar);
    }

    public static int d(int i2, j jVar) {
        return (l(1) * 2) + g(2, i2) + c(3, jVar);
    }

    public static int b(int i2, ag agVar) {
        return (l(1) * 2) + g(2, i2) + a(3, agVar);
    }

    public static int l(int i2) {
        return n(bz.a(i2, 0));
    }

    public static int m(int i2) {
        if (i2 >= 0) {
            return n(i2);
        }
        return 10;
    }

    public static int o(int i2) {
        return n(s(i2));
    }

    public static int d(long j) {
        return e(j);
    }

    public static int f(long j) {
        return e(g(j));
    }

    public static int p(int i2) {
        return m(i2);
    }

    public static int b(String str) {
        int i2;
        try {
            i2 = by.a((CharSequence) str);
        } catch (by.d unused) {
            i2 = str.getBytes(ac.f37697a).length;
        }
        return n(i2) + i2;
    }

    public static int a(ag agVar) {
        int b2 = agVar.b();
        return n(b2) + b2;
    }

    public static int b(j jVar) {
        int size = jVar.size();
        return n(size) + size;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        return n(length) + length;
    }

    public static int b(at atVar) {
        int j = atVar.j();
        return n(j) + j;
    }

    static int a(at atVar, bm bmVar) {
        int a2 = ((a) atVar).a(bmVar);
        return n(a2) + a2;
    }

    static int q(int i2) {
        return n(i2) + i2;
    }

    public final void i() {
        if (h() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static class b extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        b() {
            super(MESSAGE);
        }

        b(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)));
        }

        b(Throwable th) {
            super(MESSAGE, th);
        }

        b(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, by.d dVar) throws IOException {
        f37891d.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", dVar);
        byte[] bytes = str.getBytes(ac.f37697a);
        try {
            b(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new b((Throwable) e2);
        } catch (b e3) {
            throw e3;
        }
    }

    @Deprecated
    static int c(int i2, at atVar, bm bmVar) {
        return (l(i2) * 2) + ((a) atVar).a(bmVar);
    }

    @Deprecated
    public static int c(at atVar) {
        return atVar.j();
    }

    @Deprecated
    public static int r(int i2) {
        return n(i2);
    }

    static class a extends m {

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f37894d;

        /* renamed from: e  reason: collision with root package name */
        private final int f37895e;

        /* renamed from: f  reason: collision with root package name */
        private final int f37896f;

        /* renamed from: g  reason: collision with root package name */
        private int f37897g;

        a(byte[] bArr, int i2) {
            super((byte) 0);
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.f37894d = bArr;
                    this.f37895e = 0;
                    this.f37897g = 0;
                    this.f37896f = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void a(int i2, int i3) throws IOException {
            b(bz.a(i2, i3));
        }

        public final void b(int i2, int i3) throws IOException {
            a(i2, 0);
            a(i3);
        }

        public final void c(int i2, int i3) throws IOException {
            a(i2, 0);
            b(i3);
        }

        public final void e(int i2, int i3) throws IOException {
            a(i2, 5);
            d(i3);
        }

        public final void a(int i2, long j) throws IOException {
            a(i2, 0);
            a(j);
        }

        public final void c(int i2, long j) throws IOException {
            a(i2, 1);
            c(j);
        }

        public final void a(int i2, boolean z) throws IOException {
            a(i2, 0);
            a(z ? (byte) 1 : 0);
        }

        public final void a(int i2, String str) throws IOException {
            a(i2, 2);
            a(str);
        }

        public final void a(int i2, j jVar) throws IOException {
            a(i2, 2);
            a(jVar);
        }

        public final void a(j jVar) throws IOException {
            b(jVar.size());
            jVar.writeTo((i) this);
        }

        public final void a(byte[] bArr, int i2) throws IOException {
            b(i2);
            b(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, at atVar, bm bmVar) throws IOException {
            a(i2, 2);
            b(((a) atVar).a(bmVar));
            bmVar.a(atVar, (ca) this.f37892b);
        }

        public final void a(int i2, at atVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, 2);
            a(atVar);
            a(1, 4);
        }

        public final void b(int i2, j jVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, jVar);
            a(1, 4);
        }

        public final void a(at atVar) throws IOException {
            b(atVar.j());
            atVar.a(this);
        }

        public final void a(byte b2) throws IOException {
            try {
                byte[] bArr = this.f37894d;
                int i2 = this.f37897g;
                this.f37897g = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f37897g), Integer.valueOf(this.f37896f), 1}), e2);
            }
        }

        public final void a(int i2) throws IOException {
            if (i2 >= 0) {
                b(i2);
            } else {
                a((long) i2);
            }
        }

        public final void d(int i2) throws IOException {
            try {
                byte[] bArr = this.f37894d;
                int i3 = this.f37897g;
                this.f37897g = i3 + 1;
                bArr[i3] = (byte) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
                byte[] bArr2 = this.f37894d;
                int i4 = this.f37897g;
                this.f37897g = i4 + 1;
                bArr2[i4] = (byte) ((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
                byte[] bArr3 = this.f37894d;
                int i5 = this.f37897g;
                this.f37897g = i5 + 1;
                bArr3[i5] = (byte) ((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID);
                byte[] bArr4 = this.f37894d;
                int i6 = this.f37897g;
                this.f37897g = i6 + 1;
                bArr4[i6] = (byte) ((i2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID);
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f37897g), Integer.valueOf(this.f37896f), 1}), e2);
            }
        }

        public final void c(long j) throws IOException {
            try {
                byte[] bArr = this.f37894d;
                int i2 = this.f37897g;
                this.f37897g = i2 + 1;
                bArr[i2] = (byte) (((int) j) & PriceRangeSeekBar.INVALID_POINTER_ID);
                byte[] bArr2 = this.f37894d;
                int i3 = this.f37897g;
                this.f37897g = i3 + 1;
                bArr2[i3] = (byte) (((int) (j >> 8)) & PriceRangeSeekBar.INVALID_POINTER_ID);
                byte[] bArr3 = this.f37894d;
                int i4 = this.f37897g;
                this.f37897g = i4 + 1;
                bArr3[i4] = (byte) (((int) (j >> 16)) & PriceRangeSeekBar.INVALID_POINTER_ID);
                byte[] bArr4 = this.f37894d;
                int i5 = this.f37897g;
                this.f37897g = i5 + 1;
                bArr4[i5] = (byte) (((int) (j >> 24)) & PriceRangeSeekBar.INVALID_POINTER_ID);
                byte[] bArr5 = this.f37894d;
                int i6 = this.f37897g;
                this.f37897g = i6 + 1;
                bArr5[i6] = (byte) (((int) (j >> 32)) & PriceRangeSeekBar.INVALID_POINTER_ID);
                byte[] bArr6 = this.f37894d;
                int i7 = this.f37897g;
                this.f37897g = i7 + 1;
                bArr6[i7] = (byte) (((int) (j >> 40)) & PriceRangeSeekBar.INVALID_POINTER_ID);
                byte[] bArr7 = this.f37894d;
                int i8 = this.f37897g;
                this.f37897g = i8 + 1;
                bArr7[i8] = (byte) (((int) (j >> 48)) & PriceRangeSeekBar.INVALID_POINTER_ID);
                byte[] bArr8 = this.f37894d;
                int i9 = this.f37897g;
                this.f37897g = i9 + 1;
                bArr8[i9] = (byte) (((int) (j >> 56)) & PriceRangeSeekBar.INVALID_POINTER_ID);
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f37897g), Integer.valueOf(this.f37896f), 1}), e2);
            }
        }

        private void b(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f37894d, this.f37897g, i3);
                this.f37897g += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f37897g), Integer.valueOf(this.f37896f), Integer.valueOf(i3)}), e2);
            }
        }

        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            b(bArr, i2, i3);
        }

        public final void a(String str) throws IOException {
            int i2 = this.f37897g;
            try {
                int n = n(str.length() * 3);
                int n2 = n(str.length());
                if (n2 == n) {
                    this.f37897g = i2 + n2;
                    int a2 = by.a((CharSequence) str, this.f37894d, this.f37897g, h());
                    this.f37897g = i2;
                    b((a2 - i2) - n2);
                    this.f37897g = a2;
                    return;
                }
                b(by.a((CharSequence) str));
                this.f37897g = by.a((CharSequence) str, this.f37894d, this.f37897g, h());
            } catch (by.d e2) {
                this.f37897g = i2;
                a(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new b((Throwable) e3);
            }
        }

        public final int h() {
            return this.f37896f - this.f37897g;
        }

        public final void b(int i2) throws IOException {
            if (!m.f37890a || d.a() || h() < 5) {
                while ((i2 & -128) != 0) {
                    byte[] bArr = this.f37894d;
                    int i3 = this.f37897g;
                    this.f37897g = i3 + 1;
                    bArr[i3] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f37894d;
                    int i4 = this.f37897g;
                    this.f37897g = i4 + 1;
                    bArr2[i4] = (byte) i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f37897g), Integer.valueOf(this.f37896f), 1}), e2);
                }
            } else if ((i2 & -128) == 0) {
                byte[] bArr3 = this.f37894d;
                int i5 = this.f37897g;
                this.f37897g = i5 + 1;
                bx.a(bArr3, (long) i5, (byte) i2);
            } else {
                byte[] bArr4 = this.f37894d;
                int i6 = this.f37897g;
                this.f37897g = i6 + 1;
                bx.a(bArr4, (long) i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & -128) == 0) {
                    byte[] bArr5 = this.f37894d;
                    int i8 = this.f37897g;
                    this.f37897g = i8 + 1;
                    bx.a(bArr5, (long) i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.f37894d;
                int i9 = this.f37897g;
                this.f37897g = i9 + 1;
                bx.a(bArr6, (long) i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & -128) == 0) {
                    byte[] bArr7 = this.f37894d;
                    int i11 = this.f37897g;
                    this.f37897g = i11 + 1;
                    bx.a(bArr7, (long) i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.f37894d;
                int i12 = this.f37897g;
                this.f37897g = i12 + 1;
                bx.a(bArr8, (long) i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & -128) == 0) {
                    byte[] bArr9 = this.f37894d;
                    int i14 = this.f37897g;
                    this.f37897g = i14 + 1;
                    bx.a(bArr9, (long) i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.f37894d;
                int i15 = this.f37897g;
                this.f37897g = i15 + 1;
                bx.a(bArr10, (long) i15, (byte) (i13 | 128));
                byte[] bArr11 = this.f37894d;
                int i16 = this.f37897g;
                this.f37897g = i16 + 1;
                bx.a(bArr11, (long) i16, (byte) (i13 >>> 7));
            }
        }

        public final void a(long j) throws IOException {
            if (!m.f37890a || h() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f37894d;
                    int i2 = this.f37897g;
                    this.f37897g = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f37894d;
                    int i3 = this.f37897g;
                    this.f37897g = i3 + 1;
                    bArr2[i3] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f37897g), Integer.valueOf(this.f37896f), 1}), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f37894d;
                    int i4 = this.f37897g;
                    this.f37897g = i4 + 1;
                    bx.a(bArr3, (long) i4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f37894d;
                int i5 = this.f37897g;
                this.f37897g = i5 + 1;
                bx.a(bArr4, (long) i5, (byte) ((int) j));
            }
        }

        public final void a(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f37894d, this.f37897g, remaining);
                this.f37897g += remaining;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f37897g), Integer.valueOf(this.f37896f), Integer.valueOf(remaining)}), e2);
            }
        }
    }
}
