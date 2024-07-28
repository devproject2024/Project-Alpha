package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class am extends aa {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f9137a = eb.a();

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f9138c = Logger.getLogger(am.class.getName());

    /* renamed from: b  reason: collision with root package name */
    an f9139b;

    public static class c extends IOException {
        c() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        c(java.lang.String r3) {
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
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.am.c.<init>(java.lang.String):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        c(java.lang.String r3, java.lang.Throwable r4) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.am.c.<init>(java.lang.String, java.lang.Throwable):void");
        }

        c(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    static final class d extends am {

        /* renamed from: c  reason: collision with root package name */
        private final ByteBuffer f9146c;

        /* renamed from: d  reason: collision with root package name */
        private final ByteBuffer f9147d;

        /* renamed from: e  reason: collision with root package name */
        private final int f9148e;

        d(ByteBuffer byteBuffer) {
            super((byte) 0);
            this.f9146c = byteBuffer;
            this.f9147d = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f9148e = byteBuffer.position();
        }

        private final void c(String str) throws IOException {
            try {
                ed.a((CharSequence) str, this.f9147d);
            } catch (IndexOutOfBoundsException e2) {
                throw new c((Throwable) e2);
            }
        }

        public final void a(byte b2) throws IOException {
            try {
                this.f9147d.put(b2);
            } catch (BufferOverflowException e2) {
                throw new c((Throwable) e2);
            }
        }

        public final void a(int i2) throws IOException {
            if (i2 >= 0) {
                b(i2);
            } else {
                a((long) i2);
            }
        }

        public final void a(int i2, int i3) throws IOException {
            b((i2 << 3) | i3);
        }

        public final void a(int i2, long j) throws IOException {
            a(i2, 0);
            a(j);
        }

        public final void a(int i2, ab abVar) throws IOException {
            a(i2, 2);
            a(abVar);
        }

        public final void a(int i2, cm cmVar) throws IOException {
            a(i2, 2);
            a(cmVar);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, cm cmVar, de deVar) throws IOException {
            a(i2, 2);
            a(cmVar, deVar);
        }

        public final void a(int i2, String str) throws IOException {
            a(i2, 2);
            a(str);
        }

        public final void a(int i2, boolean z) throws IOException {
            a(i2, 0);
            a(z ? (byte) 1 : 0);
        }

        public final void a(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.f9147d.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.f9147d.put((byte) ((int) j));
            } catch (BufferOverflowException e2) {
                throw new c((Throwable) e2);
            }
        }

        public final void a(ab abVar) throws IOException {
            b(abVar.size());
            abVar.zza((aa) this);
        }

        public final void a(cm cmVar) throws IOException {
            b(cmVar.e());
            cmVar.a(this);
        }

        /* access modifiers changed from: package-private */
        public final void a(cm cmVar, de deVar) throws IOException {
            r rVar = (r) cmVar;
            int c2 = rVar.c();
            if (c2 == -1) {
                c2 = deVar.b(rVar);
                rVar.a(c2);
            }
            b(c2);
            deVar.a(cmVar, (ep) this.f9139b);
        }

        public final void a(String str) throws IOException {
            int position = this.f9147d.position();
            try {
                int n = n(str.length() * 3);
                int n2 = n(str.length());
                if (n2 == n) {
                    int position2 = this.f9147d.position() + n2;
                    this.f9147d.position(position2);
                    c(str);
                    int position3 = this.f9147d.position();
                    this.f9147d.position(position);
                    b(position3 - position2);
                    this.f9147d.position(position3);
                    return;
                }
                b(ed.a((CharSequence) str));
                c(str);
            } catch (eg e2) {
                this.f9147d.position(position);
                a(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new c((Throwable) e3);
            }
        }

        public final void a(byte[] bArr, int i2) throws IOException {
            b(i2);
            b(bArr, 0, i2);
        }

        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            b(bArr, i2, i3);
        }

        public final void b(int i2) throws IOException {
            while ((i2 & -128) != 0) {
                this.f9147d.put((byte) ((i2 & 127) | 128));
                i2 >>>= 7;
            }
            try {
                this.f9147d.put((byte) i2);
            } catch (BufferOverflowException e2) {
                throw new c((Throwable) e2);
            }
        }

        public final void b(int i2, int i3) throws IOException {
            a(i2, 0);
            a(i3);
        }

        public final void b(int i2, ab abVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, abVar);
            a(1, 4);
        }

        public final void b(int i2, cm cmVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, cmVar);
            a(1, 4);
        }

        public final void b(byte[] bArr, int i2, int i3) throws IOException {
            try {
                this.f9147d.put(bArr, i2, i3);
            } catch (IndexOutOfBoundsException e2) {
                throw new c((Throwable) e2);
            } catch (BufferOverflowException e3) {
                throw new c((Throwable) e3);
            }
        }

        public final void c(int i2, int i3) throws IOException {
            a(i2, 0);
            b(i3);
        }

        public final void c(int i2, long j) throws IOException {
            a(i2, 1);
            c(j);
        }

        public final void c(long j) throws IOException {
            try {
                this.f9147d.putLong(j);
            } catch (BufferOverflowException e2) {
                throw new c((Throwable) e2);
            }
        }

        public final void d(int i2) throws IOException {
            try {
                this.f9147d.putInt(i2);
            } catch (BufferOverflowException e2) {
                throw new c((Throwable) e2);
            }
        }

        public final void e(int i2, int i3) throws IOException {
            a(i2, 5);
            d(i3);
        }

        public final void h() {
            this.f9146c.position(this.f9147d.position());
        }

        public final int i() {
            return this.f9147d.remaining();
        }
    }

    static final class e extends am {

        /* renamed from: c  reason: collision with root package name */
        private final ByteBuffer f9149c;

        /* renamed from: d  reason: collision with root package name */
        private final ByteBuffer f9150d;

        /* renamed from: e  reason: collision with root package name */
        private final long f9151e;

        /* renamed from: f  reason: collision with root package name */
        private final long f9152f;

        /* renamed from: g  reason: collision with root package name */
        private final long f9153g;

        /* renamed from: h  reason: collision with root package name */
        private final long f9154h = (this.f9153g - 10);

        /* renamed from: i  reason: collision with root package name */
        private long f9155i = this.f9152f;

        e(ByteBuffer byteBuffer) {
            super((byte) 0);
            this.f9149c = byteBuffer;
            this.f9150d = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f9151e = eb.a(byteBuffer);
            this.f9152f = this.f9151e + ((long) byteBuffer.position());
            this.f9153g = this.f9151e + ((long) byteBuffer.limit());
        }

        private final void g(long j) {
            this.f9150d.position((int) (j - this.f9151e));
        }

        public final void a(byte b2) throws IOException {
            long j = this.f9155i;
            if (j < this.f9153g) {
                this.f9155i = 1 + j;
                eb.a(j, b2);
                return;
            }
            throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j), Long.valueOf(this.f9153g), 1}));
        }

        public final void a(int i2) throws IOException {
            if (i2 >= 0) {
                b(i2);
            } else {
                a((long) i2);
            }
        }

        public final void a(int i2, int i3) throws IOException {
            b((i2 << 3) | i3);
        }

        public final void a(int i2, long j) throws IOException {
            a(i2, 0);
            a(j);
        }

        public final void a(int i2, ab abVar) throws IOException {
            a(i2, 2);
            a(abVar);
        }

        public final void a(int i2, cm cmVar) throws IOException {
            a(i2, 2);
            a(cmVar);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, cm cmVar, de deVar) throws IOException {
            a(i2, 2);
            a(cmVar, deVar);
        }

        public final void a(int i2, String str) throws IOException {
            a(i2, 2);
            a(str);
        }

        public final void a(int i2, boolean z) throws IOException {
            a(i2, 0);
            a(z ? (byte) 1 : 0);
        }

        public final void a(long j) throws IOException {
            long j2;
            if (this.f9155i <= this.f9154h) {
                while (true) {
                    int i2 = ((j & -128) > 0 ? 1 : ((j & -128) == 0 ? 0 : -1));
                    j2 = this.f9155i;
                    if (i2 == 0) {
                        break;
                    }
                    this.f9155i = j2 + 1;
                    eb.a(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            } else {
                while (true) {
                    j2 = this.f9155i;
                    if (j2 >= this.f9153g) {
                        throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j2), Long.valueOf(this.f9153g), 1}));
                    } else if ((j & -128) == 0) {
                        break;
                    } else {
                        this.f9155i = j2 + 1;
                        eb.a(j2, (byte) ((((int) j) & 127) | 128));
                        j >>>= 7;
                    }
                }
            }
            this.f9155i = 1 + j2;
            eb.a(j2, (byte) ((int) j));
        }

        public final void a(ab abVar) throws IOException {
            b(abVar.size());
            abVar.zza((aa) this);
        }

        public final void a(cm cmVar) throws IOException {
            b(cmVar.e());
            cmVar.a(this);
        }

        /* access modifiers changed from: package-private */
        public final void a(cm cmVar, de deVar) throws IOException {
            r rVar = (r) cmVar;
            int c2 = rVar.c();
            if (c2 == -1) {
                c2 = deVar.b(rVar);
                rVar.a(c2);
            }
            b(c2);
            deVar.a(cmVar, (ep) this.f9139b);
        }

        public final void a(String str) throws IOException {
            long j = this.f9155i;
            try {
                int n = n(str.length() * 3);
                int n2 = n(str.length());
                if (n2 == n) {
                    int i2 = ((int) (this.f9155i - this.f9151e)) + n2;
                    this.f9150d.position(i2);
                    ed.a((CharSequence) str, this.f9150d);
                    int position = this.f9150d.position() - i2;
                    b(position);
                    this.f9155i += (long) position;
                    return;
                }
                int a2 = ed.a((CharSequence) str);
                b(a2);
                g(this.f9155i);
                ed.a((CharSequence) str, this.f9150d);
                this.f9155i += (long) a2;
            } catch (eg e2) {
                this.f9155i = j;
                g(this.f9155i);
                a(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new c((Throwable) e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new c((Throwable) e4);
            }
        }

        public final void a(byte[] bArr, int i2) throws IOException {
            b(i2);
            b(bArr, 0, i2);
        }

        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            b(bArr, i2, i3);
        }

        public final void b(int i2) throws IOException {
            long j;
            if (this.f9155i <= this.f9154h) {
                while ((i2 & -128) != 0) {
                    long j2 = this.f9155i;
                    this.f9155i = j2 + 1;
                    eb.a(j2, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                j = this.f9155i;
            } else {
                while (true) {
                    j = this.f9155i;
                    if (j >= this.f9153g) {
                        throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j), Long.valueOf(this.f9153g), 1}));
                    } else if ((i2 & -128) == 0) {
                        break;
                    } else {
                        this.f9155i = j + 1;
                        eb.a(j, (byte) ((i2 & 127) | 128));
                        i2 >>>= 7;
                    }
                }
            }
            this.f9155i = 1 + j;
            eb.a(j, (byte) i2);
        }

        public final void b(int i2, int i3) throws IOException {
            a(i2, 0);
            a(i3);
        }

        public final void b(int i2, ab abVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, abVar);
            a(1, 4);
        }

        public final void b(int i2, cm cmVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, cmVar);
            a(1, 4);
        }

        public final void b(byte[] bArr, int i2, int i3) throws IOException {
            if (bArr != null && i2 >= 0 && i3 >= 0 && bArr.length - i3 >= i2) {
                long j = (long) i3;
                long j2 = this.f9155i;
                if (this.f9153g - j >= j2) {
                    eb.a(bArr, (long) i2, j2, j);
                    this.f9155i += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f9155i), Long.valueOf(this.f9153g), Integer.valueOf(i3)}));
        }

        public final void c(int i2, int i3) throws IOException {
            a(i2, 0);
            b(i3);
        }

        public final void c(int i2, long j) throws IOException {
            a(i2, 1);
            c(j);
        }

        public final void c(long j) throws IOException {
            this.f9150d.putLong((int) (this.f9155i - this.f9151e), j);
            this.f9155i += 8;
        }

        public final void d(int i2) throws IOException {
            this.f9150d.putInt((int) (this.f9155i - this.f9151e), i2);
            this.f9155i += 4;
        }

        public final void e(int i2, int i3) throws IOException {
            a(i2, 5);
            d(i3);
        }

        public final void h() {
            this.f9149c.position((int) (this.f9155i - this.f9151e));
        }

        public final int i() {
            return (int) (this.f9153g - this.f9155i);
        }
    }

    private am() {
    }

    /* synthetic */ am(byte b2) {
        this();
    }

    public static int a() {
        return 4;
    }

    public static int a(bt btVar) {
        int b2 = btVar.b();
        return n(b2) + b2;
    }

    public static am a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            return eb.b() ? new e(byteBuffer) : new d(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static am a(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int b() {
        return 4;
    }

    public static int b(ab abVar) {
        int size = abVar.size();
        return n(size) + size;
    }

    public static int b(cm cmVar) {
        int e2 = cmVar.e();
        return n(e2) + e2;
    }

    static int b(cm cmVar, de deVar) {
        r rVar = (r) cmVar;
        int c2 = rVar.c();
        if (c2 == -1) {
            c2 = deVar.b(rVar);
            rVar.a(c2);
        }
        return n(c2) + c2;
    }

    public static int b(String str) {
        int i2;
        try {
            i2 = ed.a((CharSequence) str);
        } catch (eg unused) {
            i2 = str.getBytes(bh.f9208a).length;
        }
        return n(i2) + i2;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        return n(length) + length;
    }

    public static int c() {
        return 8;
    }

    @Deprecated
    public static int c(cm cmVar) {
        return cmVar.e();
    }

    public static int d() {
        return 8;
    }

    public static int d(long j) {
        return e(j);
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

    public static int f(long j) {
        return e(g(j));
    }

    public static int g() {
        return 1;
    }

    private static long g(long j) {
        return (j >> 63) ^ (j << 1);
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

    public static int o(int i2) {
        return n(q(i2));
    }

    public static int p(int i2) {
        return m(i2);
    }

    private static int q(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public abstract void a(byte b2) throws IOException;

    public final void a(double d2) throws IOException {
        c(Double.doubleToRawLongBits(d2));
    }

    public final void a(float f2) throws IOException {
        d(Float.floatToRawIntBits(f2));
    }

    public abstract void a(int i2) throws IOException;

    public final void a(int i2, double d2) throws IOException {
        c(i2, Double.doubleToRawLongBits(d2));
    }

    public final void a(int i2, float f2) throws IOException {
        e(i2, Float.floatToRawIntBits(f2));
    }

    public abstract void a(int i2, int i3) throws IOException;

    public abstract void a(int i2, long j) throws IOException;

    public abstract void a(int i2, ab abVar) throws IOException;

    public abstract void a(int i2, cm cmVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(int i2, cm cmVar, de deVar) throws IOException;

    public abstract void a(int i2, String str) throws IOException;

    public abstract void a(int i2, boolean z) throws IOException;

    public abstract void a(long j) throws IOException;

    public abstract void a(ab abVar) throws IOException;

    public abstract void a(cm cmVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(cm cmVar, de deVar) throws IOException;

    public abstract void a(String str) throws IOException;

    /* access modifiers changed from: package-private */
    public final void a(String str, eg egVar) throws IOException {
        f9138c.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", egVar);
        byte[] bytes = str.getBytes(bh.f9208a);
        try {
            b(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new c((Throwable) e2);
        } catch (c e3) {
            throw e3;
        }
    }

    public final void a(boolean z) throws IOException {
        a(z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public abstract void a(byte[] bArr, int i2) throws IOException;

    public abstract void b(int i2) throws IOException;

    public abstract void b(int i2, int i3) throws IOException;

    public final void b(int i2, long j) throws IOException {
        a(i2, g(j));
    }

    public abstract void b(int i2, ab abVar) throws IOException;

    public abstract void b(int i2, cm cmVar) throws IOException;

    public final void b(long j) throws IOException {
        a(g(j));
    }

    public abstract void b(byte[] bArr, int i2, int i3) throws IOException;

    public final void c(int i2) throws IOException {
        b(q(i2));
    }

    public abstract void c(int i2, int i3) throws IOException;

    public abstract void c(int i2, long j) throws IOException;

    public abstract void c(long j) throws IOException;

    public abstract void d(int i2) throws IOException;

    public final void d(int i2, int i3) throws IOException {
        c(i2, q(i3));
    }

    public abstract void e(int i2, int i3) throws IOException;

    public abstract void h() throws IOException;

    public abstract int i();

    static class a extends am {

        /* renamed from: c  reason: collision with root package name */
        final int f9140c;

        /* renamed from: d  reason: collision with root package name */
        int f9141d;

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f9142e;

        /* renamed from: f  reason: collision with root package name */
        private final int f9143f;

        a(byte[] bArr, int i2, int i3) {
            super((byte) 0);
            if (bArr != null) {
                int i4 = i2 + i3;
                if ((i2 | i3 | (bArr.length - i4)) >= 0) {
                    this.f9142e = bArr;
                    this.f9140c = i2;
                    this.f9141d = i2;
                    this.f9143f = i4;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void a(byte b2) throws IOException {
            try {
                byte[] bArr = this.f9142e;
                int i2 = this.f9141d;
                this.f9141d = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9141d), Integer.valueOf(this.f9143f), 1}), e2);
            }
        }

        public final void a(int i2) throws IOException {
            if (i2 >= 0) {
                b(i2);
            } else {
                a((long) i2);
            }
        }

        public final void a(int i2, int i3) throws IOException {
            b((i2 << 3) | i3);
        }

        public final void a(int i2, long j) throws IOException {
            a(i2, 0);
            a(j);
        }

        public final void a(int i2, ab abVar) throws IOException {
            a(i2, 2);
            a(abVar);
        }

        public final void a(int i2, cm cmVar) throws IOException {
            a(i2, 2);
            a(cmVar);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, cm cmVar, de deVar) throws IOException {
            a(i2, 2);
            r rVar = (r) cmVar;
            int c2 = rVar.c();
            if (c2 == -1) {
                c2 = deVar.b(rVar);
                rVar.a(c2);
            }
            b(c2);
            deVar.a(cmVar, (ep) this.f9139b);
        }

        public final void a(int i2, String str) throws IOException {
            a(i2, 2);
            a(str);
        }

        public final void a(int i2, boolean z) throws IOException {
            a(i2, 0);
            a(z ? (byte) 1 : 0);
        }

        public final void a(ab abVar) throws IOException {
            b(abVar.size());
            abVar.zza((aa) this);
        }

        public final void a(cm cmVar) throws IOException {
            b(cmVar.e());
            cmVar.a(this);
        }

        /* access modifiers changed from: package-private */
        public final void a(cm cmVar, de deVar) throws IOException {
            r rVar = (r) cmVar;
            int c2 = rVar.c();
            if (c2 == -1) {
                c2 = deVar.b(rVar);
                rVar.a(c2);
            }
            b(c2);
            deVar.a(cmVar, (ep) this.f9139b);
        }

        public final void a(String str) throws IOException {
            int i2 = this.f9141d;
            try {
                int n = n(str.length() * 3);
                int n2 = n(str.length());
                if (n2 == n) {
                    this.f9141d = i2 + n2;
                    int a2 = ed.a(str, this.f9142e, this.f9141d, i());
                    this.f9141d = i2;
                    b((a2 - i2) - n2);
                    this.f9141d = a2;
                    return;
                }
                b(ed.a((CharSequence) str));
                this.f9141d = ed.a(str, this.f9142e, this.f9141d, i());
            } catch (eg e2) {
                this.f9141d = i2;
                a(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new c((Throwable) e3);
            }
        }

        public final void a(byte[] bArr, int i2) throws IOException {
            b(i2);
            b(bArr, 0, i2);
        }

        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            b(bArr, i2, i3);
        }

        public final void b(int i2, int i3) throws IOException {
            a(i2, 0);
            a(i3);
        }

        public final void b(int i2, ab abVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, abVar);
            a(1, 4);
        }

        public final void b(int i2, cm cmVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, cmVar);
            a(1, 4);
        }

        public final void b(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f9142e, this.f9141d, i3);
                this.f9141d += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9141d), Integer.valueOf(this.f9143f), Integer.valueOf(i3)}), e2);
            }
        }

        public final void c(int i2, int i3) throws IOException {
            a(i2, 0);
            b(i3);
        }

        public final void c(int i2, long j) throws IOException {
            a(i2, 1);
            c(j);
        }

        public final void c(long j) throws IOException {
            try {
                byte[] bArr = this.f9142e;
                int i2 = this.f9141d;
                this.f9141d = i2 + 1;
                bArr[i2] = (byte) ((int) j);
                byte[] bArr2 = this.f9142e;
                int i3 = this.f9141d;
                this.f9141d = i3 + 1;
                bArr2[i3] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.f9142e;
                int i4 = this.f9141d;
                this.f9141d = i4 + 1;
                bArr3[i4] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.f9142e;
                int i5 = this.f9141d;
                this.f9141d = i5 + 1;
                bArr4[i5] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.f9142e;
                int i6 = this.f9141d;
                this.f9141d = i6 + 1;
                bArr5[i6] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.f9142e;
                int i7 = this.f9141d;
                this.f9141d = i7 + 1;
                bArr6[i7] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.f9142e;
                int i8 = this.f9141d;
                this.f9141d = i8 + 1;
                bArr7[i8] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.f9142e;
                int i9 = this.f9141d;
                this.f9141d = i9 + 1;
                bArr8[i9] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9141d), Integer.valueOf(this.f9143f), 1}), e2);
            }
        }

        public final void d(int i2) throws IOException {
            try {
                byte[] bArr = this.f9142e;
                int i3 = this.f9141d;
                this.f9141d = i3 + 1;
                bArr[i3] = (byte) i2;
                byte[] bArr2 = this.f9142e;
                int i4 = this.f9141d;
                this.f9141d = i4 + 1;
                bArr2[i4] = (byte) (i2 >> 8);
                byte[] bArr3 = this.f9142e;
                int i5 = this.f9141d;
                this.f9141d = i5 + 1;
                bArr3[i5] = (byte) (i2 >> 16);
                byte[] bArr4 = this.f9142e;
                int i6 = this.f9141d;
                this.f9141d = i6 + 1;
                bArr4[i6] = i2 >> 24;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9141d), Integer.valueOf(this.f9143f), 1}), e2);
            }
        }

        public final void e(int i2, int i3) throws IOException {
            a(i2, 5);
            d(i3);
        }

        public void h() {
        }

        public final int i() {
            return this.f9143f - this.f9141d;
        }

        public final void b(int i2) throws IOException {
            if (!am.f9137a || i() < 10) {
                while ((i2 & -128) != 0) {
                    byte[] bArr = this.f9142e;
                    int i3 = this.f9141d;
                    this.f9141d = i3 + 1;
                    bArr[i3] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f9142e;
                    int i4 = this.f9141d;
                    this.f9141d = i4 + 1;
                    bArr2[i4] = (byte) i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9141d), Integer.valueOf(this.f9143f), 1}), e2);
                }
            } else {
                while ((i2 & -128) != 0) {
                    byte[] bArr3 = this.f9142e;
                    int i5 = this.f9141d;
                    this.f9141d = i5 + 1;
                    eb.a(bArr3, (long) i5, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                byte[] bArr4 = this.f9142e;
                int i6 = this.f9141d;
                this.f9141d = i6 + 1;
                eb.a(bArr4, (long) i6, (byte) i2);
            }
        }

        public final void a(long j) throws IOException {
            if (!am.f9137a || i() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.f9142e;
                    int i2 = this.f9141d;
                    this.f9141d = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f9142e;
                    int i3 = this.f9141d;
                    this.f9141d = i3 + 1;
                    bArr2[i3] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e2) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f9141d), Integer.valueOf(this.f9143f), 1}), e2);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.f9142e;
                    int i4 = this.f9141d;
                    this.f9141d = i4 + 1;
                    eb.a(bArr3, (long) i4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.f9142e;
                int i5 = this.f9141d;
                this.f9141d = i5 + 1;
                eb.a(bArr4, (long) i5, (byte) ((int) j));
            }
        }
    }

    static final class b extends a {

        /* renamed from: e  reason: collision with root package name */
        private final ByteBuffer f9144e;

        /* renamed from: f  reason: collision with root package name */
        private int f9145f;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f9144e = byteBuffer;
            this.f9145f = byteBuffer.position();
        }

        public final void h() {
            this.f9144e.position(this.f9145f + (this.f9141d - this.f9140c));
        }
    }

    public static int f(int i2, int i3) {
        return n(i2 << 3) + m(i3);
    }

    public static int g(int i2, int i3) {
        return n(i2 << 3) + n(i3);
    }

    public static int h(int i2, int i3) {
        return n(i2 << 3) + n(q(i3));
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

    public static int c(int i2, ab abVar) {
        int n = n(i2 << 3);
        int size = abVar.size();
        return n + n(size) + size;
    }

    public static int a(int i2, bt btVar) {
        int n = n(i2 << 3);
        int b2 = btVar.b();
        return n + n(b2) + b2;
    }

    public static int c(int i2, cm cmVar) {
        return n(i2 << 3) + b(cmVar);
    }

    static int b(int i2, cm cmVar, de deVar) {
        return n(i2 << 3) + b(cmVar, deVar);
    }

    public static int d(int i2, cm cmVar) {
        return (n(8) << 1) + g(2, i2) + c(3, cmVar);
    }

    public static int d(int i2, ab abVar) {
        return (n(8) << 1) + g(2, i2) + c(3, abVar);
    }

    public static int b(int i2, bt btVar) {
        return (n(8) << 1) + g(2, i2) + a(3, btVar);
    }

    @Deprecated
    static int c(int i2, cm cmVar, de deVar) {
        int n = n(i2 << 3) << 1;
        r rVar = (r) cmVar;
        int c2 = rVar.c();
        if (c2 == -1) {
            c2 = deVar.b(rVar);
            rVar.a(c2);
        }
        return n + c2;
    }
}
