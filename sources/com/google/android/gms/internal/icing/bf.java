package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class bf extends aq {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f10070a = Logger.getLogger(bf.class.getName());

    /* renamed from: b  reason: collision with root package name */
    static final boolean f10071b = eo.a();

    /* renamed from: c  reason: collision with root package name */
    bi f10072c;

    public static int a() {
        return 4;
    }

    public static bf a(byte[] bArr) {
        return new a(bArr, bArr.length);
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

    private static int r(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public abstract void a(byte b2) throws IOException;

    public abstract void a(int i2) throws IOException;

    public abstract void a(int i2, int i3) throws IOException;

    public abstract void a(int i2, long j) throws IOException;

    public abstract void a(int i2, at atVar) throws IOException;

    public abstract void a(int i2, dd ddVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(int i2, dd ddVar, dr drVar) throws IOException;

    public abstract void a(int i2, String str) throws IOException;

    public abstract void a(int i2, boolean z) throws IOException;

    public abstract void a(long j) throws IOException;

    public abstract void a(at atVar) throws IOException;

    public abstract void a(dd ddVar) throws IOException;

    public abstract void a(String str) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(byte[] bArr, int i2) throws IOException;

    public abstract void b(int i2) throws IOException;

    public abstract void b(int i2, int i3) throws IOException;

    public abstract void b(int i2, at atVar) throws IOException;

    public abstract void c(int i2, int i3) throws IOException;

    public abstract void c(int i2, long j) throws IOException;

    public abstract void c(long j) throws IOException;

    public abstract void d(int i2) throws IOException;

    public abstract void e(int i2, int i3) throws IOException;

    public abstract int h();

    public static class b extends IOException {
        b() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        b(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        b(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.bf.b.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private bf() {
    }

    public final void d(int i2, int i3) throws IOException {
        c(i2, r(i3));
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
        b(r(i2));
    }

    static class a extends bf {

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f10073d;

        /* renamed from: e  reason: collision with root package name */
        private final int f10074e;

        /* renamed from: f  reason: collision with root package name */
        private final int f10075f;

        /* renamed from: g  reason: collision with root package name */
        private int f10076g;

        a(byte[] bArr, int i2) {
            super((byte) 0);
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.f10073d = bArr;
                    this.f10074e = 0;
                    this.f10076g = 0;
                    this.f10075f = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void a(int i2, int i3) throws IOException {
            b((i2 << 3) | i3);
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

        public final void a(int i2, at atVar) throws IOException {
            a(i2, 2);
            a(atVar);
        }

        public final void a(at atVar) throws IOException {
            b(atVar.size());
            atVar.zza((aq) this);
        }

        public final void a(byte[] bArr, int i2) throws IOException {
            b(i2);
            b(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, dd ddVar, dr drVar) throws IOException {
            a(i2, 2);
            al alVar = (al) ddVar;
            int b2 = alVar.b();
            if (b2 == -1) {
                b2 = drVar.d(alVar);
                alVar.a(b2);
            }
            b(b2);
            drVar.a(ddVar, (fc) this.f10072c);
        }

        public final void a(int i2, dd ddVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, 2);
            a(ddVar);
            a(1, 4);
        }

        public final void b(int i2, at atVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, atVar);
            a(1, 4);
        }

        public final void a(dd ddVar) throws IOException {
            b(ddVar.d());
            ddVar.a(this);
        }

        public final void a(byte b2) throws IOException {
            try {
                byte[] bArr = this.f10073d;
                int i2 = this.f10076g;
                this.f10076g = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10076g), Integer.valueOf(this.f10075f), 1}), e2);
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
                byte[] bArr = this.f10073d;
                int i3 = this.f10076g;
                this.f10076g = i3 + 1;
                bArr[i3] = (byte) i2;
                byte[] bArr2 = this.f10073d;
                int i4 = this.f10076g;
                this.f10076g = i4 + 1;
                bArr2[i4] = (byte) (i2 >> 8);
                byte[] bArr3 = this.f10073d;
                int i5 = this.f10076g;
                this.f10076g = i5 + 1;
                bArr3[i5] = (byte) (i2 >> 16);
                byte[] bArr4 = this.f10073d;
                int i6 = this.f10076g;
                this.f10076g = i6 + 1;
                bArr4[i6] = (byte) (i2 >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10076g), Integer.valueOf(this.f10075f), 1}), e2);
            }
        }

        public final void c(long j) throws IOException {
            try {
                byte[] bArr = this.f10073d;
                int i2 = this.f10076g;
                this.f10076g = i2 + 1;
                bArr[i2] = (byte) ((int) j);
                byte[] bArr2 = this.f10073d;
                int i3 = this.f10076g;
                this.f10076g = i3 + 1;
                bArr2[i3] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.f10073d;
                int i4 = this.f10076g;
                this.f10076g = i4 + 1;
                bArr3[i4] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.f10073d;
                int i5 = this.f10076g;
                this.f10076g = i5 + 1;
                bArr4[i5] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.f10073d;
                int i6 = this.f10076g;
                this.f10076g = i6 + 1;
                bArr5[i6] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.f10073d;
                int i7 = this.f10076g;
                this.f10076g = i7 + 1;
                bArr6[i7] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.f10073d;
                int i8 = this.f10076g;
                this.f10076g = i8 + 1;
                bArr7[i8] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.f10073d;
                int i9 = this.f10076g;
                this.f10076g = i9 + 1;
                bArr8[i9] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10076g), Integer.valueOf(this.f10075f), 1}), e2);
            }
        }

        private final void b(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f10073d, this.f10076g, i3);
                this.f10076g += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10076g), Integer.valueOf(this.f10075f), Integer.valueOf(i3)}), e2);
            }
        }

        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            b(bArr, i2, i3);
        }

        public final void a(String str) throws IOException {
            int i2 = this.f10076g;
            try {
                int n = n(str.length() * 3);
                int n2 = n(str.length());
                if (n2 == n) {
                    this.f10076g = i2 + n2;
                    int a2 = er.a(str, this.f10073d, this.f10076g, h());
                    this.f10076g = i2;
                    b((a2 - i2) - n2);
                    this.f10076g = a2;
                    return;
                }
                b(er.a((CharSequence) str));
                this.f10076g = er.a(str, this.f10073d, this.f10076g, h());
            } catch (ev e2) {
                this.f10076g = i2;
                bf.f10070a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", e2);
                byte[] bytes = str.getBytes(bx.f10119a);
                try {
                    b(bytes.length);
                    a(bytes, 0, bytes.length);
                } catch (IndexOutOfBoundsException e3) {
                    throw new b(e3);
                } catch (b e4) {
                    throw e4;
                }
            } catch (IndexOutOfBoundsException e5) {
                throw new b(e5);
            }
        }

        public final int h() {
            return this.f10075f - this.f10076g;
        }

        public final void b(int i2) throws IOException {
            if (!bf.f10071b || ao.a() || h() < 5) {
                while ((i2 & -128) != 0) {
                    byte[] bArr = this.f10073d;
                    int i3 = this.f10076g;
                    this.f10076g = i3 + 1;
                    bArr[i3] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f10073d;
                    int i4 = this.f10076g;
                    this.f10076g = i4 + 1;
                    bArr2[i4] = (byte) i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10076g), Integer.valueOf(this.f10075f), 1}), e2);
                }
            } else if ((i2 & -128) == 0) {
                byte[] bArr3 = this.f10073d;
                int i5 = this.f10076g;
                this.f10076g = i5 + 1;
                eo.a(bArr3, (long) i5, (byte) i2);
            } else {
                byte[] bArr4 = this.f10073d;
                int i6 = this.f10076g;
                this.f10076g = i6 + 1;
                eo.a(bArr4, (long) i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & -128) == 0) {
                    byte[] bArr5 = this.f10073d;
                    int i8 = this.f10076g;
                    this.f10076g = i8 + 1;
                    eo.a(bArr5, (long) i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.f10073d;
                int i9 = this.f10076g;
                this.f10076g = i9 + 1;
                eo.a(bArr6, (long) i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & -128) == 0) {
                    byte[] bArr7 = this.f10073d;
                    int i11 = this.f10076g;
                    this.f10076g = i11 + 1;
                    eo.a(bArr7, (long) i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.f10073d;
                int i12 = this.f10076g;
                this.f10076g = i12 + 1;
                eo.a(bArr8, (long) i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & -128) == 0) {
                    byte[] bArr9 = this.f10073d;
                    int i14 = this.f10076g;
                    this.f10076g = i14 + 1;
                    eo.a(bArr9, (long) i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.f10073d;
                int i15 = this.f10076g;
                this.f10076g = i15 + 1;
                eo.a(bArr10, (long) i15, (byte) (i13 | 128));
                byte[] bArr11 = this.f10073d;
                int i16 = this.f10076g;
                this.f10076g = i16 + 1;
                eo.a(bArr11, (long) i16, (byte) (i13 >>> 7));
            }
        }

        public final void a(long j) throws IOException {
            if (!bf.f10071b || h() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f10073d;
                    int i2 = this.f10076g;
                    this.f10076g = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f10073d;
                    int i3 = this.f10076g;
                    this.f10076g = i3 + 1;
                    bArr2[i3] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f10076g), Integer.valueOf(this.f10075f), 1}), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f10073d;
                    int i4 = this.f10076g;
                    this.f10076g = i4 + 1;
                    eo.a(bArr3, (long) i4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f10073d;
                int i5 = this.f10076g;
                this.f10076g = i5 + 1;
                eo.a(bArr4, (long) i5, (byte) ((int) j));
            }
        }
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

    public static int l(int i2) {
        return n(i2 << 3);
    }

    public static int m(int i2) {
        if (i2 >= 0) {
            return n(i2);
        }
        return 10;
    }

    public static int o(int i2) {
        return n(r(i2));
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
            i2 = er.a((CharSequence) str);
        } catch (ev unused) {
            i2 = str.getBytes(bx.f10119a).length;
        }
        return n(i2) + i2;
    }

    public static int a(cm cmVar) {
        int b2 = cmVar.b();
        return n(b2) + b2;
    }

    public static int b(at atVar) {
        int size = atVar.size();
        return n(size) + size;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        return n(length) + length;
    }

    public static int b(dd ddVar) {
        int d2 = ddVar.d();
        return n(d2) + d2;
    }

    static int a(dd ddVar, dr drVar) {
        al alVar = (al) ddVar;
        int b2 = alVar.b();
        if (b2 == -1) {
            b2 = drVar.d(alVar);
            alVar.a(b2);
        }
        return n(b2) + b2;
    }

    @Deprecated
    public static int c(dd ddVar) {
        return ddVar.d();
    }

    @Deprecated
    public static int q(int i2) {
        return n(i2);
    }

    /* synthetic */ bf(byte b2) {
        this();
    }

    public static int f(int i2, int i3) {
        return n(i2 << 3) + m(i3);
    }

    public static int g(int i2, int i3) {
        return n(i2 << 3) + n(i3);
    }

    public static int h(int i2, int i3) {
        return n(i2 << 3) + n(r(i3));
    }

    public static int e(int i2) {
        return n(i2 << 3) + 4;
    }

    public static int f(int i2) {
        return n(i2 << 3) + 4;
    }

    public static int d(int i2, long j) {
        return n(i2 << 3) + e(j);
    }

    public static int e(int i2, long j) {
        return n(i2 << 3) + e(j);
    }

    public static int f(int i2, long j) {
        return n(i2 << 3) + e(g(j));
    }

    public static int g(int i2) {
        return n(i2 << 3) + 8;
    }

    public static int h(int i2) {
        return n(i2 << 3) + 8;
    }

    public static int i(int i2) {
        return n(i2 << 3) + 4;
    }

    public static int j(int i2) {
        return n(i2 << 3) + 8;
    }

    public static int k(int i2) {
        return n(i2 << 3) + 1;
    }

    public static int i(int i2, int i3) {
        return n(i2 << 3) + m(i3);
    }

    public static int b(int i2, String str) {
        return n(i2 << 3) + b(str);
    }

    public static int c(int i2, at atVar) {
        int n = n(i2 << 3);
        int size = atVar.size();
        return n + n(size) + size;
    }

    public static int a(int i2, cm cmVar) {
        int n = n(i2 << 3);
        int b2 = cmVar.b();
        return n + n(b2) + b2;
    }

    static int b(int i2, dd ddVar, dr drVar) {
        return n(i2 << 3) + a(ddVar, drVar);
    }

    public static int b(int i2, dd ddVar) {
        return (n(8) << 1) + g(2, i2) + n(24) + b(ddVar);
    }

    public static int d(int i2, at atVar) {
        return (n(8) << 1) + g(2, i2) + c(3, atVar);
    }

    public static int b(int i2, cm cmVar) {
        return (n(8) << 1) + g(2, i2) + a(3, cmVar);
    }

    @Deprecated
    static int c(int i2, dd ddVar, dr drVar) {
        int n = n(i2 << 3) << 1;
        al alVar = (al) ddVar;
        int b2 = alVar.b();
        if (b2 == -1) {
            b2 = drVar.d(alVar);
            alVar.a(b2);
        }
        return n + b2;
    }
}
