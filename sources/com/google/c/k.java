package com.google.c;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    int f37865a;

    /* renamed from: b  reason: collision with root package name */
    int f37866b;

    /* renamed from: c  reason: collision with root package name */
    int f37867c;

    /* renamed from: d  reason: collision with root package name */
    l f37868d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f37869e;

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int e(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public abstract int a() throws IOException;

    public abstract void a(int i2) throws ad;

    public abstract double b() throws IOException;

    public abstract boolean b(int i2) throws IOException;

    public abstract float c() throws IOException;

    public abstract int c(int i2) throws ad;

    public abstract long d() throws IOException;

    public abstract void d(int i2);

    public abstract long e() throws IOException;

    public abstract int f() throws IOException;

    public abstract long g() throws IOException;

    public abstract int h() throws IOException;

    public abstract boolean i() throws IOException;

    public abstract String j() throws IOException;

    public abstract String k() throws IOException;

    public abstract j l() throws IOException;

    public abstract int m() throws IOException;

    public abstract int n() throws IOException;

    public abstract int o() throws IOException;

    public abstract long p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long s() throws IOException;

    public abstract boolean t() throws IOException;

    public abstract int u();

    /* synthetic */ k(byte b2) {
        this();
    }

    static k a(byte[] bArr, int i2, int i3, boolean z) {
        a aVar = new a(bArr, i2, i3, z, (byte) 0);
        try {
            aVar.c(i3);
            return aVar;
        } catch (ad e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private k() {
        this.f37866b = 100;
        this.f37867c = Integer.MAX_VALUE;
        this.f37869e = false;
    }

    static final class a extends k {

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f37870e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f37871f;

        /* renamed from: g  reason: collision with root package name */
        private int f37872g;

        /* renamed from: h  reason: collision with root package name */
        private int f37873h;

        /* renamed from: i  reason: collision with root package name */
        private int f37874i;
        private int j;
        private int k;
        private boolean l;
        private int m;

        /* synthetic */ a(byte[] bArr, int i2, int i3, boolean z, byte b2) {
            this(bArr, i2, i3, z);
        }

        private a(byte[] bArr, int i2, int i3, boolean z) {
            super((byte) 0);
            this.m = Integer.MAX_VALUE;
            this.f37870e = bArr;
            this.f37872g = i3 + i2;
            this.f37874i = i2;
            this.j = this.f37874i;
            this.f37871f = z;
        }

        public final int a() throws IOException {
            if (t()) {
                this.k = 0;
                return 0;
            }
            this.k = v();
            if (bz.b(this.k) != 0) {
                return this.k;
            }
            throw ad.invalidTag();
        }

        public final void a(int i2) throws ad {
            if (this.k != i2) {
                throw ad.invalidEndTag();
            }
        }

        public final boolean b(int i2) throws IOException {
            int a2;
            int a3 = bz.a(i2);
            int i3 = 0;
            if (a3 == 0) {
                if (this.f37872g - this.f37874i >= 10) {
                    while (i3 < 10) {
                        byte[] bArr = this.f37870e;
                        int i4 = this.f37874i;
                        this.f37874i = i4 + 1;
                        if (bArr[i4] < 0) {
                            i3++;
                        }
                    }
                    throw ad.malformedVarint();
                }
                while (i3 < 10) {
                    if (A() < 0) {
                        i3++;
                    }
                }
                throw ad.malformedVarint();
                return true;
            } else if (a3 == 1) {
                f(8);
                return true;
            } else if (a3 == 2) {
                f(v());
                return true;
            } else if (a3 == 3) {
                do {
                    a2 = a();
                    if (a2 == 0 || !b(a2)) {
                        a(bz.a(bz.b(i2), 4));
                    }
                    a2 = a();
                    break;
                } while (!b(a2));
                a(bz.a(bz.b(i2), 4));
                return true;
            } else if (a3 == 4) {
                return false;
            } else {
                if (a3 == 5) {
                    f(4);
                    return true;
                }
                throw ad.invalidWireType();
            }
        }

        public final double b() throws IOException {
            return Double.longBitsToDouble(y());
        }

        public final float c() throws IOException {
            return Float.intBitsToFloat(x());
        }

        public final long d() throws IOException {
            return w();
        }

        public final long e() throws IOException {
            return w();
        }

        public final int f() throws IOException {
            return v();
        }

        public final long g() throws IOException {
            return y();
        }

        public final int h() throws IOException {
            return x();
        }

        public final boolean i() throws IOException {
            return w() != 0;
        }

        public final String j() throws IOException {
            int v = v();
            if (v > 0) {
                int i2 = this.f37872g;
                int i3 = this.f37874i;
                if (v <= i2 - i3) {
                    String str = new String(this.f37870e, i3, v, ac.f37697a);
                    this.f37874i += v;
                    return str;
                }
            }
            if (v == 0) {
                return "";
            }
            if (v < 0) {
                throw ad.negativeSize();
            }
            throw ad.truncatedMessage();
        }

        public final String k() throws IOException {
            int v = v();
            if (v > 0) {
                int i2 = this.f37872g;
                int i3 = this.f37874i;
                if (v <= i2 - i3) {
                    String b2 = by.b(this.f37870e, i3, v);
                    this.f37874i += v;
                    return b2;
                }
            }
            if (v == 0) {
                return "";
            }
            if (v <= 0) {
                throw ad.negativeSize();
            }
            throw ad.truncatedMessage();
        }

        public final j l() throws IOException {
            byte[] bArr;
            j jVar;
            int v = v();
            if (v > 0) {
                int i2 = this.f37872g;
                int i3 = this.f37874i;
                if (v <= i2 - i3) {
                    if (!this.f37871f || !this.l) {
                        jVar = j.copyFrom(this.f37870e, this.f37874i, v);
                    } else {
                        jVar = j.wrap(this.f37870e, i3, v);
                    }
                    this.f37874i += v;
                    return jVar;
                }
            }
            if (v == 0) {
                return j.EMPTY;
            }
            if (v > 0) {
                int i4 = this.f37872g;
                int i5 = this.f37874i;
                if (v <= i4 - i5) {
                    this.f37874i = v + i5;
                    bArr = Arrays.copyOfRange(this.f37870e, i5, this.f37874i);
                    return j.wrap(bArr);
                }
            }
            if (v > 0) {
                throw ad.truncatedMessage();
            } else if (v == 0) {
                bArr = ac.f37699c;
                return j.wrap(bArr);
            } else {
                throw ad.negativeSize();
            }
        }

        public final int m() throws IOException {
            return v();
        }

        public final int n() throws IOException {
            return v();
        }

        public final int o() throws IOException {
            return x();
        }

        public final long p() throws IOException {
            return y();
        }

        public final int q() throws IOException {
            return e(v());
        }

        public final long r() throws IOException {
            return a(w());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
            if (r2[r3] >= 0) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int v() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f37874i
                int r1 = r5.f37872g
                if (r1 == r0) goto L_0x006b
                byte[] r2 = r5.f37870e
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0011
                r5.f37874i = r3
                return r0
            L_0x0011:
                int r1 = r1 - r3
                r4 = 9
                if (r1 < r4) goto L_0x006b
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0022
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0068
            L_0x0022:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x002f
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002d:
                r1 = r3
                goto L_0x0068
            L_0x002f:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003d
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0068
            L_0x003d:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002d
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0068
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002d
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0068
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002d
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 < 0) goto L_0x006b
            L_0x0068:
                r5.f37874i = r1
                return r0
            L_0x006b:
                long r0 = r5.s()
                int r1 = (int) r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.k.a.v():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
            if (((long) r2[r0]) >= 0) goto L_0x00b4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long w() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f37874i
                int r1 = r11.f37872g
                if (r1 == r0) goto L_0x00b8
                byte[] r2 = r11.f37870e
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r11.f37874i = r3
                long r0 = (long) r0
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 < r4) goto L_0x00b8
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0025
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0022:
                long r2 = (long) r0
                goto L_0x00b5
            L_0x0025:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0036
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00b5
            L_0x0036:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0044
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0022
            L_0x0044:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005b
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x0057:
                long r2 = r3 ^ r1
                r1 = r0
                goto L_0x00b5
            L_0x005b:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0070
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x006d:
                long r2 = r3 ^ r5
                goto L_0x00b5
            L_0x0070:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0083
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x0057
            L_0x0083:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0096
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x006d
            L_0x0096:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00b3
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 < 0) goto L_0x00b8
                goto L_0x00b4
            L_0x00b3:
                r1 = r0
            L_0x00b4:
                r2 = r3
            L_0x00b5:
                r11.f37874i = r1
                return r2
            L_0x00b8:
                long r0 = r11.s()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.k.a.w():long");
        }

        /* access modifiers changed from: package-private */
        public final long s() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte A = A();
                j2 |= ((long) (A & Byte.MAX_VALUE)) << i2;
                if ((A & 128) == 0) {
                    return j2;
                }
            }
            throw ad.malformedVarint();
        }

        private int x() throws IOException {
            int i2 = this.f37874i;
            if (this.f37872g - i2 >= 4) {
                byte[] bArr = this.f37870e;
                this.f37874i = i2 + 4;
                return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
            }
            throw ad.truncatedMessage();
        }

        private long y() throws IOException {
            int i2 = this.f37874i;
            if (this.f37872g - i2 >= 8) {
                byte[] bArr = this.f37870e;
                this.f37874i = i2 + 8;
                return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
            }
            throw ad.truncatedMessage();
        }

        public final int c(int i2) throws ad {
            if (i2 >= 0) {
                int u = i2 + u();
                int i3 = this.m;
                if (u <= i3) {
                    this.m = u;
                    z();
                    return i3;
                }
                throw ad.truncatedMessage();
            }
            throw ad.negativeSize();
        }

        private void z() {
            this.f37872g += this.f37873h;
            int i2 = this.f37872g;
            int i3 = i2 - this.j;
            int i4 = this.m;
            if (i3 > i4) {
                this.f37873h = i3 - i4;
                this.f37872g = i2 - this.f37873h;
                return;
            }
            this.f37873h = 0;
        }

        public final void d(int i2) {
            this.m = i2;
            z();
        }

        public final boolean t() throws IOException {
            return this.f37874i == this.f37872g;
        }

        public final int u() {
            return this.f37874i - this.j;
        }

        private byte A() throws IOException {
            int i2 = this.f37874i;
            if (i2 != this.f37872g) {
                byte[] bArr = this.f37870e;
                this.f37874i = i2 + 1;
                return bArr[i2];
            }
            throw ad.truncatedMessage();
        }

        private void f(int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = this.f37872g;
                int i4 = this.f37874i;
                if (i2 <= i3 - i4) {
                    this.f37874i = i4 + i2;
                    return;
                }
            }
            if (i2 < 0) {
                throw ad.negativeSize();
            }
            throw ad.truncatedMessage();
        }
    }

    public static k a(InputStream inputStream) {
        if (inputStream != null) {
            return new b(inputStream, (byte) 0);
        }
        byte[] bArr = ac.f37699c;
        return a(bArr, 0, bArr.length, false);
    }

    static final class c extends k {

        /* renamed from: e  reason: collision with root package name */
        private final ByteBuffer f37880e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f37881f;

        /* renamed from: g  reason: collision with root package name */
        private final long f37882g;

        /* renamed from: h  reason: collision with root package name */
        private long f37883h;

        /* renamed from: i  reason: collision with root package name */
        private long f37884i;
        private long j;
        private int k;
        private int l;
        private boolean m;
        private int n;

        /* synthetic */ c(ByteBuffer byteBuffer, byte b2) {
            this(byteBuffer);
        }

        private c(ByteBuffer byteBuffer) {
            super((byte) 0);
            this.n = Integer.MAX_VALUE;
            this.f37880e = byteBuffer;
            this.f37882g = bx.a(byteBuffer);
            this.f37883h = this.f37882g + ((long) byteBuffer.limit());
            this.f37884i = this.f37882g + ((long) byteBuffer.position());
            this.j = this.f37884i;
            this.f37881f = true;
        }

        public final int a() throws IOException {
            if (t()) {
                this.l = 0;
                return 0;
            }
            this.l = v();
            if (bz.b(this.l) != 0) {
                return this.l;
            }
            throw ad.invalidTag();
        }

        public final void a(int i2) throws ad {
            if (this.l != i2) {
                throw ad.invalidEndTag();
            }
        }

        public final boolean b(int i2) throws IOException {
            int a2;
            int a3 = bz.a(i2);
            int i3 = 0;
            if (a3 == 0) {
                if (B() >= 10) {
                    while (i3 < 10) {
                        long j2 = this.f37884i;
                        this.f37884i = 1 + j2;
                        if (bx.a(j2) < 0) {
                            i3++;
                        }
                    }
                    throw ad.malformedVarint();
                }
                while (i3 < 10) {
                    if (z() < 0) {
                        i3++;
                    }
                }
                throw ad.malformedVarint();
                return true;
            } else if (a3 == 1) {
                f(8);
                return true;
            } else if (a3 == 2) {
                f(v());
                return true;
            } else if (a3 == 3) {
                do {
                    a2 = a();
                    if (a2 == 0 || !b(a2)) {
                        a(bz.a(bz.b(i2), 4));
                    }
                    a2 = a();
                    break;
                } while (!b(a2));
                a(bz.a(bz.b(i2), 4));
                return true;
            } else if (a3 == 4) {
                return false;
            } else {
                if (a3 == 5) {
                    f(4);
                    return true;
                }
                throw ad.invalidWireType();
            }
        }

        public final double b() throws IOException {
            return Double.longBitsToDouble(y());
        }

        public final float c() throws IOException {
            return Float.intBitsToFloat(x());
        }

        public final long d() throws IOException {
            return w();
        }

        public final long e() throws IOException {
            return w();
        }

        public final int f() throws IOException {
            return v();
        }

        public final long g() throws IOException {
            return y();
        }

        public final int h() throws IOException {
            return x();
        }

        public final boolean i() throws IOException {
            return w() != 0;
        }

        public final String j() throws IOException {
            int v = v();
            if (v > 0 && v <= B()) {
                byte[] bArr = new byte[v];
                long j2 = (long) v;
                bx.a(this.f37884i, bArr, j2);
                String str = new String(bArr, ac.f37697a);
                this.f37884i += j2;
                return str;
            } else if (v == 0) {
                return "";
            } else {
                if (v < 0) {
                    throw ad.negativeSize();
                }
                throw ad.truncatedMessage();
            }
        }

        public final String k() throws IOException {
            int v = v();
            if (v > 0 && v <= B()) {
                String a2 = by.a(this.f37880e, (int) (this.f37884i - this.f37882g), v);
                this.f37884i += (long) v;
                return a2;
            } else if (v == 0) {
                return "";
            } else {
                if (v <= 0) {
                    throw ad.negativeSize();
                }
                throw ad.truncatedMessage();
            }
        }

        public final j l() throws IOException {
            int v = v();
            if (v <= 0 || v > B()) {
                if (v == 0) {
                    return j.EMPTY;
                }
                if (v < 0) {
                    throw ad.negativeSize();
                }
                throw ad.truncatedMessage();
            } else if (!this.f37881f || !this.m) {
                byte[] bArr = new byte[v];
                long j2 = (long) v;
                bx.a(this.f37884i, bArr, j2);
                this.f37884i += j2;
                return j.wrap(bArr);
            } else {
                long j3 = this.f37884i;
                long j4 = (long) v;
                ByteBuffer a2 = a(j3, j3 + j4);
                this.f37884i += j4;
                return j.wrap(a2);
            }
        }

        public final int m() throws IOException {
            return v();
        }

        public final int n() throws IOException {
            return v();
        }

        public final int o() throws IOException {
            return x();
        }

        public final long p() throws IOException {
            return y();
        }

        public final int q() throws IOException {
            return e(v());
        }

        public final long r() throws IOException {
            return a(w());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
            if (com.google.c.bx.a(r4) >= 0) goto L_0x0082;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int v() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.f37884i
                long r2 = r10.f37883h
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 == 0) goto L_0x0085
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.c.bx.a((long) r0)
                if (r0 < 0) goto L_0x0015
                r10.f37884i = r4
                return r0
            L_0x0015:
                long r6 = r10.f37883h
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 < 0) goto L_0x0085
                long r6 = r4 + r2
                byte r1 = com.google.c.bx.a((long) r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x002c
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0082
            L_0x002c:
                long r4 = r6 + r2
                byte r1 = com.google.c.bx.a((long) r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x003b
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x0039:
                r6 = r4
                goto L_0x0082
            L_0x003b:
                long r6 = r4 + r2
                byte r1 = com.google.c.bx.a((long) r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L_0x004b
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L_0x0082
            L_0x004b:
                long r4 = r6 + r2
                byte r1 = com.google.c.bx.a((long) r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L_0x0039
                long r6 = r4 + r2
                byte r1 = com.google.c.bx.a((long) r4)
                if (r1 >= 0) goto L_0x0082
                long r4 = r6 + r2
                byte r1 = com.google.c.bx.a((long) r6)
                if (r1 >= 0) goto L_0x0039
                long r6 = r4 + r2
                byte r1 = com.google.c.bx.a((long) r4)
                if (r1 >= 0) goto L_0x0082
                long r4 = r6 + r2
                byte r1 = com.google.c.bx.a((long) r6)
                if (r1 >= 0) goto L_0x0039
                long r6 = r4 + r2
                byte r1 = com.google.c.bx.a((long) r4)
                if (r1 < 0) goto L_0x0085
            L_0x0082:
                r10.f37884i = r6
                return r0
            L_0x0085:
                long r0 = r10.s()
                int r1 = (int) r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.k.c.v():int");
        }

        private long w() throws IOException {
            long j2;
            long j3;
            long j4;
            long j5;
            byte b2;
            long j6 = this.f37884i;
            if (this.f37883h != j6) {
                long j7 = j6 + 1;
                byte a2 = bx.a(j6);
                if (a2 >= 0) {
                    this.f37884i = j7;
                    return (long) a2;
                } else if (this.f37883h - j7 >= 9) {
                    long j8 = j7 + 1;
                    byte a3 = a2 ^ (bx.a(j7) << 7);
                    if (a3 < 0) {
                        b2 = a3 ^ Byte.MIN_VALUE;
                    } else {
                        j2 = j8 + 1;
                        byte a4 = a3 ^ (bx.a(j8) << 14);
                        if (a4 >= 0) {
                            j3 = (long) (a4 ^ 16256);
                        } else {
                            j8 = j2 + 1;
                            byte a5 = a4 ^ (bx.a(j2) << 21);
                            if (a5 < 0) {
                                b2 = a5 ^ -2080896;
                            } else {
                                j2 = j8 + 1;
                                long a6 = ((long) a5) ^ (((long) bx.a(j8)) << 28);
                                if (a6 >= 0) {
                                    j5 = 266354560;
                                } else {
                                    long j9 = j2 + 1;
                                    long a7 = a6 ^ (((long) bx.a(j2)) << 35);
                                    if (a7 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        j2 = j9 + 1;
                                        a6 = a7 ^ (((long) bx.a(j9)) << 42);
                                        if (a6 >= 0) {
                                            j5 = 4363953127296L;
                                        } else {
                                            j9 = j2 + 1;
                                            a7 = a6 ^ (((long) bx.a(j2)) << 49);
                                            if (a7 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                j2 = j9 + 1;
                                                j3 = (a7 ^ (((long) bx.a(j9)) << 56)) ^ 71499008037633920L;
                                                if (j3 < 0) {
                                                    long j10 = 1 + j2;
                                                    if (((long) bx.a(j2)) >= 0) {
                                                        j2 = j10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j3 = a7 ^ j4;
                                    j2 = j9;
                                }
                                j3 = a6 ^ j5;
                            }
                        }
                        this.f37884i = j2;
                        return j3;
                    }
                    j3 = (long) b2;
                    j2 = j8;
                    this.f37884i = j2;
                    return j3;
                }
            }
            return s();
        }

        /* access modifiers changed from: package-private */
        public final long s() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte z = z();
                j2 |= ((long) (z & Byte.MAX_VALUE)) << i2;
                if ((z & 128) == 0) {
                    return j2;
                }
            }
            throw ad.malformedVarint();
        }

        private int x() throws IOException {
            long j2 = this.f37884i;
            if (this.f37883h - j2 >= 4) {
                this.f37884i = 4 + j2;
                return ((bx.a(j2 + 3) & 255) << 24) | (bx.a(j2) & 255) | ((bx.a(1 + j2) & 255) << 8) | ((bx.a(2 + j2) & 255) << 16);
            }
            throw ad.truncatedMessage();
        }

        private long y() throws IOException {
            long j2 = this.f37884i;
            if (this.f37883h - j2 >= 8) {
                this.f37884i = 8 + j2;
                return ((((long) bx.a(j2 + 7)) & 255) << 56) | (((long) bx.a(j2)) & 255) | ((((long) bx.a(1 + j2)) & 255) << 8) | ((((long) bx.a(2 + j2)) & 255) << 16) | ((((long) bx.a(3 + j2)) & 255) << 24) | ((((long) bx.a(4 + j2)) & 255) << 32) | ((((long) bx.a(5 + j2)) & 255) << 40) | ((((long) bx.a(6 + j2)) & 255) << 48);
            }
            throw ad.truncatedMessage();
        }

        public final int c(int i2) throws ad {
            if (i2 >= 0) {
                int u = i2 + u();
                int i3 = this.n;
                if (u <= i3) {
                    this.n = u;
                    A();
                    return i3;
                }
                throw ad.truncatedMessage();
            }
            throw ad.negativeSize();
        }

        public final void d(int i2) {
            this.n = i2;
            A();
        }

        public final boolean t() throws IOException {
            return this.f37884i == this.f37883h;
        }

        public final int u() {
            return (int) (this.f37884i - this.j);
        }

        private byte z() throws IOException {
            long j2 = this.f37884i;
            if (j2 != this.f37883h) {
                this.f37884i = 1 + j2;
                return bx.a(j2);
            }
            throw ad.truncatedMessage();
        }

        private void f(int i2) throws IOException {
            if (i2 >= 0 && i2 <= B()) {
                this.f37884i += (long) i2;
            } else if (i2 < 0) {
                throw ad.negativeSize();
            } else {
                throw ad.truncatedMessage();
            }
        }

        private void A() {
            this.f37883h += (long) this.k;
            long j2 = this.f37883h;
            int i2 = (int) (j2 - this.j);
            int i3 = this.n;
            if (i2 > i3) {
                this.k = i2 - i3;
                this.f37883h = j2 - ((long) this.k);
                return;
            }
            this.k = 0;
        }

        private int B() {
            return (int) (this.f37883h - this.f37884i);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
            throw r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
            r6 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            throw com.google.c.ad.truncatedMessage();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
            r5.f37880e.position(r0);
            r5.f37880e.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0031 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.nio.ByteBuffer a(long r6, long r8) throws java.io.IOException {
            /*
                r5 = this;
                java.nio.ByteBuffer r0 = r5.f37880e
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r5.f37880e
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r5.f37880e     // Catch:{ IllegalArgumentException -> 0x0031 }
                long r3 = r5.f37882g     // Catch:{ IllegalArgumentException -> 0x0031 }
                long r6 = r6 - r3
                int r7 = (int) r6     // Catch:{ IllegalArgumentException -> 0x0031 }
                r2.position(r7)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r6 = r5.f37880e     // Catch:{ IllegalArgumentException -> 0x0031 }
                long r2 = r5.f37882g     // Catch:{ IllegalArgumentException -> 0x0031 }
                long r8 = r8 - r2
                int r7 = (int) r8     // Catch:{ IllegalArgumentException -> 0x0031 }
                r6.limit(r7)     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r6 = r5.f37880e     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r6 = r6.slice()     // Catch:{ IllegalArgumentException -> 0x0031 }
                java.nio.ByteBuffer r7 = r5.f37880e
                r7.position(r0)
                java.nio.ByteBuffer r7 = r5.f37880e
                r7.limit(r1)
                return r6
            L_0x002f:
                r6 = move-exception
                goto L_0x0036
            L_0x0031:
                com.google.c.ad r6 = com.google.c.ad.truncatedMessage()     // Catch:{ all -> 0x002f }
                throw r6     // Catch:{ all -> 0x002f }
            L_0x0036:
                java.nio.ByteBuffer r7 = r5.f37880e
                r7.position(r0)
                java.nio.ByteBuffer r7 = r5.f37880e
                r7.limit(r1)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.k.c.a(long, long):java.nio.ByteBuffer");
        }
    }

    static final class b extends k {

        /* renamed from: e  reason: collision with root package name */
        private final InputStream f37875e;

        /* renamed from: f  reason: collision with root package name */
        private final byte[] f37876f;

        /* renamed from: g  reason: collision with root package name */
        private int f37877g;

        /* renamed from: h  reason: collision with root package name */
        private int f37878h;

        /* renamed from: i  reason: collision with root package name */
        private int f37879i;
        private int j;
        private int k;
        private int l;
        private a m;

        interface a {
        }

        /* synthetic */ b(InputStream inputStream, byte b2) {
            this(inputStream);
        }

        private b(InputStream inputStream) {
            super((byte) 0);
            this.l = Integer.MAX_VALUE;
            this.m = null;
            ac.a(inputStream, "input");
            this.f37875e = inputStream;
            this.f37876f = new byte[4096];
            this.f37877g = 0;
            this.f37879i = 0;
            this.k = 0;
        }

        public final int a() throws IOException {
            if (t()) {
                this.j = 0;
                return 0;
            }
            this.j = v();
            if (bz.b(this.j) != 0) {
                return this.j;
            }
            throw ad.invalidTag();
        }

        public final void a(int i2) throws ad {
            if (this.j != i2) {
                throw ad.invalidEndTag();
            }
        }

        public final boolean b(int i2) throws IOException {
            int a2;
            int a3 = bz.a(i2);
            int i3 = 0;
            if (a3 == 0) {
                if (this.f37877g - this.f37879i >= 10) {
                    while (i3 < 10) {
                        byte[] bArr = this.f37876f;
                        int i4 = this.f37879i;
                        this.f37879i = i4 + 1;
                        if (bArr[i4] < 0) {
                            i3++;
                        }
                    }
                    throw ad.malformedVarint();
                }
                while (i3 < 10) {
                    if (A() < 0) {
                        i3++;
                    }
                }
                throw ad.malformedVarint();
                return true;
            } else if (a3 == 1) {
                k(8);
                return true;
            } else if (a3 == 2) {
                k(v());
                return true;
            } else if (a3 == 3) {
                do {
                    a2 = a();
                    if (a2 == 0 || !b(a2)) {
                        a(bz.a(bz.b(i2), 4));
                    }
                    a2 = a();
                    break;
                } while (!b(a2));
                a(bz.a(bz.b(i2), 4));
                return true;
            } else if (a3 == 4) {
                return false;
            } else {
                if (a3 == 5) {
                    k(4);
                    return true;
                }
                throw ad.invalidWireType();
            }
        }

        public final double b() throws IOException {
            return Double.longBitsToDouble(y());
        }

        public final float c() throws IOException {
            return Float.intBitsToFloat(x());
        }

        public final long d() throws IOException {
            return w();
        }

        public final long e() throws IOException {
            return w();
        }

        public final int f() throws IOException {
            return v();
        }

        public final long g() throws IOException {
            return y();
        }

        public final int h() throws IOException {
            return x();
        }

        public final boolean i() throws IOException {
            return w() != 0;
        }

        public final String j() throws IOException {
            int v = v();
            if (v > 0) {
                int i2 = this.f37877g;
                int i3 = this.f37879i;
                if (v <= i2 - i3) {
                    String str = new String(this.f37876f, i3, v, ac.f37697a);
                    this.f37879i += v;
                    return str;
                }
            }
            if (v == 0) {
                return "";
            }
            if (v > this.f37877g) {
                return new String(h(v), ac.f37697a);
            }
            f(v);
            String str2 = new String(this.f37876f, this.f37879i, v, ac.f37697a);
            this.f37879i += v;
            return str2;
        }

        public final String k() throws IOException {
            byte[] bArr;
            int v = v();
            int i2 = this.f37879i;
            int i3 = 0;
            if (v <= this.f37877g - i2 && v > 0) {
                bArr = this.f37876f;
                this.f37879i = i2 + v;
                i3 = i2;
            } else if (v == 0) {
                return "";
            } else {
                if (v <= this.f37877g) {
                    f(v);
                    bArr = this.f37876f;
                    this.f37879i = v + 0;
                } else {
                    bArr = h(v);
                }
            }
            return by.b(bArr, i3, v);
        }

        public final j l() throws IOException {
            int v = v();
            int i2 = this.f37877g;
            int i3 = this.f37879i;
            if (v <= i2 - i3 && v > 0) {
                j copyFrom = j.copyFrom(this.f37876f, i3, v);
                this.f37879i += v;
                return copyFrom;
            } else if (v == 0) {
                return j.EMPTY;
            } else {
                byte[] i4 = i(v);
                if (i4 != null) {
                    return j.copyFrom(i4);
                }
                int i5 = this.f37879i;
                int i6 = this.f37877g;
                int i7 = i6 - i5;
                this.k += i6;
                this.f37879i = 0;
                this.f37877g = 0;
                List<byte[]> j2 = j(v - i7);
                byte[] bArr = new byte[v];
                System.arraycopy(this.f37876f, i5, bArr, 0, i7);
                for (byte[] next : j2) {
                    System.arraycopy(next, 0, bArr, i7, next.length);
                    i7 += next.length;
                }
                return j.wrap(bArr);
            }
        }

        public final int m() throws IOException {
            return v();
        }

        public final int n() throws IOException {
            return v();
        }

        public final int o() throws IOException {
            return x();
        }

        public final long p() throws IOException {
            return y();
        }

        public final int q() throws IOException {
            return e(v());
        }

        public final long r() throws IOException {
            return a(w());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
            if (r2[r3] >= 0) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int v() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f37879i
                int r1 = r5.f37877g
                if (r1 == r0) goto L_0x006b
                byte[] r2 = r5.f37876f
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0011
                r5.f37879i = r3
                return r0
            L_0x0011:
                int r1 = r1 - r3
                r4 = 9
                if (r1 < r4) goto L_0x006b
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0022
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0068
            L_0x0022:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x002f
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L_0x002d:
                r1 = r3
                goto L_0x0068
            L_0x002f:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x003d
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0068
            L_0x003d:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L_0x002d
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0068
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002d
                int r1 = r3 + 1
                byte r3 = r2[r3]
                if (r3 >= 0) goto L_0x0068
                int r3 = r1 + 1
                byte r1 = r2[r1]
                if (r1 >= 0) goto L_0x002d
                int r1 = r3 + 1
                byte r2 = r2[r3]
                if (r2 < 0) goto L_0x006b
            L_0x0068:
                r5.f37879i = r1
                return r0
            L_0x006b:
                long r0 = r5.s()
                int r1 = (int) r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.k.b.v():int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
            if (((long) r2[r0]) >= 0) goto L_0x00b4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long w() throws java.io.IOException {
            /*
                r11 = this;
                int r0 = r11.f37879i
                int r1 = r11.f37877g
                if (r1 == r0) goto L_0x00b8
                byte[] r2 = r11.f37876f
                int r3 = r0 + 1
                byte r0 = r2[r0]
                if (r0 < 0) goto L_0x0012
                r11.f37879i = r3
                long r0 = (long) r0
                return r0
            L_0x0012:
                int r1 = r1 - r3
                r4 = 9
                if (r1 < r4) goto L_0x00b8
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0025
                r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            L_0x0022:
                long r2 = (long) r0
                goto L_0x00b5
            L_0x0025:
                int r3 = r1 + 1
                byte r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L_0x0036
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
                long r0 = (long) r0
                r9 = r0
                r1 = r3
                r2 = r9
                goto L_0x00b5
            L_0x0036:
                int r1 = r3 + 1
                byte r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L_0x0044
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0022
            L_0x0044:
                long r3 = (long) r0
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r5 = (long) r1
                r1 = 28
                long r5 = r5 << r1
                long r3 = r3 ^ r5
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x005b
                r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            L_0x0057:
                long r2 = r3 ^ r1
                r1 = r0
                goto L_0x00b5
            L_0x005b:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 35
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0070
                r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            L_0x006d:
                long r2 = r3 ^ r5
                goto L_0x00b5
            L_0x0070:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 42
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 < 0) goto L_0x0083
                r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
                goto L_0x0057
            L_0x0083:
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                r0 = 49
                long r7 = r7 << r0
                long r3 = r3 ^ r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x0096
                r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
                goto L_0x006d
            L_0x0096:
                int r0 = r1 + 1
                byte r1 = r2[r1]
                long r7 = (long) r1
                r1 = 56
                long r7 = r7 << r1
                long r3 = r3 ^ r7
                r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
                long r3 = r3 ^ r7
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 >= 0) goto L_0x00b3
                int r1 = r0 + 1
                byte r0 = r2[r0]
                long r7 = (long) r0
                int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r0 < 0) goto L_0x00b8
                goto L_0x00b4
            L_0x00b3:
                r1 = r0
            L_0x00b4:
                r2 = r3
            L_0x00b5:
                r11.f37879i = r1
                return r2
            L_0x00b8:
                long r0 = r11.s()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.k.b.w():long");
        }

        /* access modifiers changed from: package-private */
        public final long s() throws IOException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte A = A();
                j2 |= ((long) (A & Byte.MAX_VALUE)) << i2;
                if ((A & 128) == 0) {
                    return j2;
                }
            }
            throw ad.malformedVarint();
        }

        private int x() throws IOException {
            int i2 = this.f37879i;
            if (this.f37877g - i2 < 4) {
                f(4);
                i2 = this.f37879i;
            }
            byte[] bArr = this.f37876f;
            this.f37879i = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        private long y() throws IOException {
            int i2 = this.f37879i;
            if (this.f37877g - i2 < 8) {
                f(8);
                i2 = this.f37879i;
            }
            byte[] bArr = this.f37876f;
            this.f37879i = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }

        public final int c(int i2) throws ad {
            if (i2 >= 0) {
                int i3 = i2 + this.k + this.f37879i;
                int i4 = this.l;
                if (i3 <= i4) {
                    this.l = i3;
                    z();
                    return i4;
                }
                throw ad.truncatedMessage();
            }
            throw ad.negativeSize();
        }

        private void z() {
            this.f37877g += this.f37878h;
            int i2 = this.k;
            int i3 = this.f37877g;
            int i4 = i2 + i3;
            int i5 = this.l;
            if (i4 > i5) {
                this.f37878h = i4 - i5;
                this.f37877g = i3 - this.f37878h;
                return;
            }
            this.f37878h = 0;
        }

        public final void d(int i2) {
            this.l = i2;
            z();
        }

        public final boolean t() throws IOException {
            return this.f37879i == this.f37877g && !g(1);
        }

        public final int u() {
            return this.k + this.f37879i;
        }

        private void f(int i2) throws IOException {
            if (g(i2)) {
                return;
            }
            if (i2 > (this.f37867c - this.k) - this.f37879i) {
                throw ad.sizeLimitExceeded();
            }
            throw ad.truncatedMessage();
        }

        private boolean g(int i2) throws IOException {
            while (this.f37879i + i2 > this.f37877g) {
                int i3 = this.f37867c;
                int i4 = this.k;
                int i5 = this.f37879i;
                if (i2 > (i3 - i4) - i5 || i4 + i5 + i2 > this.l) {
                    return false;
                }
                if (i5 > 0) {
                    int i6 = this.f37877g;
                    if (i6 > i5) {
                        byte[] bArr = this.f37876f;
                        System.arraycopy(bArr, i5, bArr, 0, i6 - i5);
                    }
                    this.k += i5;
                    this.f37877g -= i5;
                    this.f37879i = 0;
                }
                InputStream inputStream = this.f37875e;
                byte[] bArr2 = this.f37876f;
                int i7 = this.f37877g;
                int read = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.f37867c - this.k) - this.f37877g));
                if (read == 0 || read < -1 || read > this.f37876f.length) {
                    throw new IllegalStateException(this.f37875e.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.f37877g += read;
                    z();
                    if (this.f37877g >= i2) {
                        return true;
                    }
                }
            }
            throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
        }

        private byte A() throws IOException {
            if (this.f37879i == this.f37877g) {
                f(1);
            }
            byte[] bArr = this.f37876f;
            int i2 = this.f37879i;
            this.f37879i = i2 + 1;
            return bArr[i2];
        }

        private byte[] h(int i2) throws IOException {
            byte[] i3 = i(i2);
            if (i3 != null) {
                return i3;
            }
            int i4 = this.f37879i;
            int i5 = this.f37877g;
            int i6 = i5 - i4;
            this.k += i5;
            this.f37879i = 0;
            this.f37877g = 0;
            List<byte[]> j2 = j(i2 - i6);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f37876f, i4, bArr, 0, i6);
            for (byte[] next : j2) {
                System.arraycopy(next, 0, bArr, i6, next.length);
                i6 += next.length;
            }
            return bArr;
        }

        private byte[] i(int i2) throws IOException {
            if (i2 == 0) {
                return ac.f37699c;
            }
            if (i2 >= 0) {
                int i3 = this.k + this.f37879i + i2;
                if (i3 - this.f37867c <= 0) {
                    int i4 = this.l;
                    if (i3 <= i4) {
                        int i5 = this.f37877g - this.f37879i;
                        int i6 = i2 - i5;
                        if (i6 >= 4096 && i6 > this.f37875e.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i2];
                        System.arraycopy(this.f37876f, this.f37879i, bArr, 0, i5);
                        this.k += this.f37877g;
                        this.f37879i = 0;
                        this.f37877g = 0;
                        while (i5 < bArr.length) {
                            int read = this.f37875e.read(bArr, i5, i2 - i5);
                            if (read != -1) {
                                this.k += read;
                                i5 += read;
                            } else {
                                throw ad.truncatedMessage();
                            }
                        }
                        return bArr;
                    }
                    k((i4 - this.k) - this.f37879i);
                    throw ad.truncatedMessage();
                }
                throw ad.sizeLimitExceeded();
            }
            throw ad.negativeSize();
        }

        private List<byte[]> j(int i2) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                byte[] bArr = new byte[Math.min(i2, 4096)];
                int i3 = 0;
                while (i3 < bArr.length) {
                    int read = this.f37875e.read(bArr, i3, bArr.length - i3);
                    if (read != -1) {
                        this.k += read;
                        i3 += read;
                    } else {
                        throw ad.truncatedMessage();
                    }
                }
                i2 -= bArr.length;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void k(int i2) throws IOException {
            int i3 = this.f37877g;
            int i4 = this.f37879i;
            if (i2 > i3 - i4 || i2 < 0) {
                l(i2);
            } else {
                this.f37879i = i4 + i2;
            }
        }

        private void l(int i2) throws IOException {
            if (i2 >= 0) {
                int i3 = this.k;
                int i4 = this.f37879i;
                int i5 = i3 + i4 + i2;
                int i6 = this.l;
                if (i5 <= i6) {
                    int i7 = 0;
                    if (this.m == null) {
                        this.k = i3 + i4;
                        this.f37877g = 0;
                        this.f37879i = 0;
                        i7 = this.f37877g - i4;
                        while (i7 < i2) {
                            try {
                                long j2 = (long) (i2 - i7);
                                long skip = this.f37875e.skip(j2);
                                int i8 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                                if (i8 >= 0 && skip <= j2) {
                                    if (i8 == 0) {
                                        break;
                                    }
                                    i7 += (int) skip;
                                } else {
                                    throw new IllegalStateException(this.f37875e.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                                }
                            } catch (Throwable th) {
                                this.k += i7;
                                z();
                                throw th;
                            }
                        }
                        this.k += i7;
                        z();
                    }
                    if (i7 < i2) {
                        int i9 = this.f37877g;
                        int i10 = i9 - this.f37879i;
                        this.f37879i = i9;
                        f(1);
                        while (true) {
                            int i11 = i2 - i10;
                            int i12 = this.f37877g;
                            if (i11 > i12) {
                                i10 += i12;
                                this.f37879i = i12;
                                f(1);
                            } else {
                                this.f37879i = i11;
                                return;
                            }
                        }
                    }
                } else {
                    k((i6 - i3) - i4);
                    throw ad.truncatedMessage();
                }
            } else {
                throw ad.negativeSize();
            }
        }
    }
}
