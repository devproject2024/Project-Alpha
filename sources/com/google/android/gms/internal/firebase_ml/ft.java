package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ft extends ff {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f9887a = Logger.getLogger(ft.class.getName());

    /* renamed from: b  reason: collision with root package name */
    static final boolean f9888b = d.a();

    /* renamed from: c  reason: collision with root package name */
    fv f9889c;

    public static int a() {
        return 4;
    }

    public static ft a(byte[] bArr) {
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

    private static int s(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public abstract void a(byte b2) throws IOException;

    public abstract void a(int i2) throws IOException;

    public abstract void a(int i2, int i3) throws IOException;

    public abstract void a(int i2, long j) throws IOException;

    public abstract void a(int i2, fh fhVar) throws IOException;

    public abstract void a(int i2, hn hnVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(int i2, hn hnVar, ig igVar) throws IOException;

    public abstract void a(int i2, String str) throws IOException;

    public abstract void a(int i2, boolean z) throws IOException;

    public abstract void a(long j) throws IOException;

    public abstract void a(fh fhVar) throws IOException;

    public abstract void a(hn hnVar) throws IOException;

    public abstract void a(String str) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(byte[] bArr, int i2) throws IOException;

    public abstract void b(int i2) throws IOException;

    public abstract void b(int i2, int i3) throws IOException;

    public abstract void b(int i2, fh fhVar) throws IOException;

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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.ft.b.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private ft() {
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

    static class a extends ft {

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f9890d;

        /* renamed from: e  reason: collision with root package name */
        private final int f9891e;

        /* renamed from: f  reason: collision with root package name */
        private final int f9892f;

        /* renamed from: g  reason: collision with root package name */
        private int f9893g;

        a(byte[] bArr, int i2) {
            super((byte) 0);
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.f9890d = bArr;
                    this.f9891e = 0;
                    this.f9893g = 0;
                    this.f9892f = i3;
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

        public final void a(int i2, fh fhVar) throws IOException {
            a(i2, 2);
            a(fhVar);
        }

        public final void a(fh fhVar) throws IOException {
            b(fhVar.size());
            fhVar.zza(this);
        }

        public final void a(byte[] bArr, int i2) throws IOException {
            b(i2);
            b(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, hn hnVar, ig igVar) throws IOException {
            a(i2, 2);
            fb fbVar = (fb) hnVar;
            int f2 = fbVar.f();
            if (f2 == -1) {
                f2 = igVar.b(fbVar);
                fbVar.a(f2);
            }
            b(f2);
            igVar.a(hnVar, (s) this.f9889c);
        }

        public final void a(int i2, hn hnVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, 2);
            a(hnVar);
            a(1, 4);
        }

        public final void b(int i2, fh fhVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, fhVar);
            a(1, 4);
        }

        public final void a(hn hnVar) throws IOException {
            b(hnVar.i());
            hnVar.a(this);
        }

        public final void a(byte b2) throws IOException {
            try {
                byte[] bArr = this.f9890d;
                int i2 = this.f9893g;
                this.f9893g = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9893g), Integer.valueOf(this.f9892f), 1}), e2);
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
                byte[] bArr = this.f9890d;
                int i3 = this.f9893g;
                this.f9893g = i3 + 1;
                bArr[i3] = (byte) i2;
                byte[] bArr2 = this.f9890d;
                int i4 = this.f9893g;
                this.f9893g = i4 + 1;
                bArr2[i4] = (byte) (i2 >> 8);
                byte[] bArr3 = this.f9890d;
                int i5 = this.f9893g;
                this.f9893g = i5 + 1;
                bArr3[i5] = (byte) (i2 >> 16);
                byte[] bArr4 = this.f9890d;
                int i6 = this.f9893g;
                this.f9893g = i6 + 1;
                bArr4[i6] = (byte) (i2 >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9893g), Integer.valueOf(this.f9892f), 1}), e2);
            }
        }

        public final void c(long j) throws IOException {
            try {
                byte[] bArr = this.f9890d;
                int i2 = this.f9893g;
                this.f9893g = i2 + 1;
                bArr[i2] = (byte) ((int) j);
                byte[] bArr2 = this.f9890d;
                int i3 = this.f9893g;
                this.f9893g = i3 + 1;
                bArr2[i3] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.f9890d;
                int i4 = this.f9893g;
                this.f9893g = i4 + 1;
                bArr3[i4] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.f9890d;
                int i5 = this.f9893g;
                this.f9893g = i5 + 1;
                bArr4[i5] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.f9890d;
                int i6 = this.f9893g;
                this.f9893g = i6 + 1;
                bArr5[i6] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.f9890d;
                int i7 = this.f9893g;
                this.f9893g = i7 + 1;
                bArr6[i7] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.f9890d;
                int i8 = this.f9893g;
                this.f9893g = i8 + 1;
                bArr7[i8] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.f9890d;
                int i9 = this.f9893g;
                this.f9893g = i9 + 1;
                bArr8[i9] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9893g), Integer.valueOf(this.f9892f), 1}), e2);
            }
        }

        private final void b(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f9890d, this.f9893g, i3);
                this.f9893g += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9893g), Integer.valueOf(this.f9892f), Integer.valueOf(i3)}), e2);
            }
        }

        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            b(bArr, i2, i3);
        }

        public final void a(String str) throws IOException {
            int i2 = this.f9893g;
            try {
                int n = n(str.length() * 3);
                int n2 = n(str.length());
                if (n2 == n) {
                    this.f9893g = i2 + n2;
                    int a2 = g.a((CharSequence) str, this.f9890d, this.f9893g, h());
                    this.f9893g = i2;
                    b((a2 - i2) - n2);
                    this.f9893g = a2;
                    return;
                }
                b(g.a((CharSequence) str));
                this.f9893g = g.a((CharSequence) str, this.f9890d, this.f9893g, h());
            } catch (i e2) {
                this.f9893g = i2;
                ft.f9887a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", e2);
                byte[] bytes = str.getBytes(gk.f9935a);
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
            return this.f9892f - this.f9893g;
        }

        public final void b(int i2) throws IOException {
            if (!ft.f9888b || fd.a() || h() < 5) {
                while ((i2 & -128) != 0) {
                    byte[] bArr = this.f9890d;
                    int i3 = this.f9893g;
                    this.f9893g = i3 + 1;
                    bArr[i3] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f9890d;
                    int i4 = this.f9893g;
                    this.f9893g = i4 + 1;
                    bArr2[i4] = (byte) i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9893g), Integer.valueOf(this.f9892f), 1}), e2);
                }
            } else if ((i2 & -128) == 0) {
                byte[] bArr3 = this.f9890d;
                int i5 = this.f9893g;
                this.f9893g = i5 + 1;
                d.a(bArr3, (long) i5, (byte) i2);
            } else {
                byte[] bArr4 = this.f9890d;
                int i6 = this.f9893g;
                this.f9893g = i6 + 1;
                d.a(bArr4, (long) i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & -128) == 0) {
                    byte[] bArr5 = this.f9890d;
                    int i8 = this.f9893g;
                    this.f9893g = i8 + 1;
                    d.a(bArr5, (long) i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.f9890d;
                int i9 = this.f9893g;
                this.f9893g = i9 + 1;
                d.a(bArr6, (long) i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & -128) == 0) {
                    byte[] bArr7 = this.f9890d;
                    int i11 = this.f9893g;
                    this.f9893g = i11 + 1;
                    d.a(bArr7, (long) i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.f9890d;
                int i12 = this.f9893g;
                this.f9893g = i12 + 1;
                d.a(bArr8, (long) i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & -128) == 0) {
                    byte[] bArr9 = this.f9890d;
                    int i14 = this.f9893g;
                    this.f9893g = i14 + 1;
                    d.a(bArr9, (long) i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.f9890d;
                int i15 = this.f9893g;
                this.f9893g = i15 + 1;
                d.a(bArr10, (long) i15, (byte) (i13 | 128));
                byte[] bArr11 = this.f9890d;
                int i16 = this.f9893g;
                this.f9893g = i16 + 1;
                d.a(bArr11, (long) i16, (byte) (i13 >>> 7));
            }
        }

        public final void a(long j) throws IOException {
            if (!ft.f9888b || h() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f9890d;
                    int i2 = this.f9893g;
                    this.f9893g = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f9890d;
                    int i3 = this.f9893g;
                    this.f9893g = i3 + 1;
                    bArr2[i3] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9893g), Integer.valueOf(this.f9892f), 1}), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f9890d;
                    int i4 = this.f9893g;
                    this.f9893g = i4 + 1;
                    d.a(bArr3, (long) i4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f9890d;
                int i5 = this.f9893g;
                this.f9893g = i5 + 1;
                d.a(bArr4, (long) i5, (byte) ((int) j));
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
            i2 = g.a((CharSequence) str);
        } catch (i unused) {
            i2 = str.getBytes(gk.f9935a).length;
        }
        return n(i2) + i2;
    }

    public static int a(gx gxVar) {
        int b2 = gxVar.b();
        return n(b2) + b2;
    }

    public static int b(fh fhVar) {
        int size = fhVar.size();
        return n(size) + size;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        return n(length) + length;
    }

    public static int b(hn hnVar) {
        int i2 = hnVar.i();
        return n(i2) + i2;
    }

    static int a(hn hnVar, ig igVar) {
        fb fbVar = (fb) hnVar;
        int f2 = fbVar.f();
        if (f2 == -1) {
            f2 = igVar.b(fbVar);
            fbVar.a(f2);
        }
        return n(f2) + f2;
    }

    static int q(int i2) {
        return n(i2) + i2;
    }

    public final void i() {
        if (h() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    @Deprecated
    public static int c(hn hnVar) {
        return hnVar.i();
    }

    @Deprecated
    public static int r(int i2) {
        return n(i2);
    }

    /* synthetic */ ft(byte b2) {
        this();
    }

    public static int f(int i2, int i3) {
        return n(i2 << 3) + m(i3);
    }

    public static int g(int i2, int i3) {
        return n(i2 << 3) + n(i3);
    }

    public static int h(int i2, int i3) {
        return n(i2 << 3) + n(s(i3));
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

    public static int c(int i2, fh fhVar) {
        int n = n(i2 << 3);
        int size = fhVar.size();
        return n + n(size) + size;
    }

    public static int a(int i2, gx gxVar) {
        int n = n(i2 << 3);
        int b2 = gxVar.b();
        return n + n(b2) + b2;
    }

    static int b(int i2, hn hnVar, ig igVar) {
        return n(i2 << 3) + a(hnVar, igVar);
    }

    public static int b(int i2, hn hnVar) {
        return (n(8) << 1) + g(2, i2) + n(24) + b(hnVar);
    }

    public static int d(int i2, fh fhVar) {
        return (n(8) << 1) + g(2, i2) + c(3, fhVar);
    }

    public static int b(int i2, gx gxVar) {
        return (n(8) << 1) + g(2, i2) + a(3, gxVar);
    }

    @Deprecated
    static int c(int i2, hn hnVar, ig igVar) {
        int n = n(i2 << 3) << 1;
        fb fbVar = (fb) hnVar;
        int f2 = fbVar.f();
        if (f2 == -1) {
            f2 = igVar.b(fbVar);
            fbVar.a(f2);
        }
        return n + f2;
    }
}
