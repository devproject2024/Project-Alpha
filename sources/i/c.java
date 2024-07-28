package i;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import easypay.manager.Constants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

public final class c implements d, e, Cloneable, ByteChannel {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f46275c = {TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with root package name */
    r f46276a;

    /* renamed from: b  reason: collision with root package name */
    public long f46277b;

    public final c a() {
        return this;
    }

    public final c b() {
        return this;
    }

    public final d c() {
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final boolean isOpen() {
        return true;
    }

    public final /* bridge */ /* synthetic */ d x() throws IOException {
        return this;
    }

    public final boolean d() {
        return this.f46277b == 0;
    }

    public final void a(long j) throws EOFException {
        if (this.f46277b < j) {
            throw new EOFException();
        }
    }

    public final boolean b(long j) {
        return this.f46277b >= j;
    }

    public final InputStream e() {
        return new InputStream() {
            public final void close() {
            }

            public final int read() {
                if (c.this.f46277b > 0) {
                    return c.this.g() & 255;
                }
                return -1;
            }

            public final int read(byte[] bArr, int i2, int i3) {
                return c.this.a(bArr, i2, i3);
            }

            public final int available() {
                return (int) Math.min(c.this.f46277b, 2147483647L);
            }

            public final String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar != null) {
            x.a(this.f46277b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f46277b += j2;
            r rVar = this.f46276a;
            while (j >= ((long) (rVar.f46322c - rVar.f46321b))) {
                j -= (long) (rVar.f46322c - rVar.f46321b);
                rVar = rVar.f46325f;
            }
            while (j2 > 0) {
                r a2 = rVar.a();
                a2.f46321b = (int) (((long) a2.f46321b) + j);
                a2.f46322c = Math.min(a2.f46321b + ((int) j2), a2.f46322c);
                r rVar2 = cVar.f46276a;
                if (rVar2 == null) {
                    a2.f46326g = a2;
                    a2.f46325f = a2;
                    cVar.f46276a = a2;
                } else {
                    rVar2.f46326g.a(a2);
                }
                j2 -= (long) (a2.f46322c - a2.f46321b);
                rVar = rVar.f46325f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final long f() {
        long j = this.f46277b;
        if (j == 0) {
            return 0;
        }
        r rVar = this.f46276a.f46326g;
        return (rVar.f46322c >= 8192 || !rVar.f46324e) ? j : j - ((long) (rVar.f46322c - rVar.f46321b));
    }

    public final byte g() {
        if (this.f46277b != 0) {
            r rVar = this.f46276a;
            int i2 = rVar.f46321b;
            int i3 = rVar.f46322c;
            int i4 = i2 + 1;
            byte b2 = rVar.f46320a[i2];
            this.f46277b--;
            if (i4 == i3) {
                this.f46276a = rVar.c();
                s.a(rVar);
            } else {
                rVar.f46321b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public final byte c(long j) {
        x.a(this.f46277b, j, 1);
        long j2 = this.f46277b;
        if (j2 - j > j) {
            r rVar = this.f46276a;
            while (true) {
                long j3 = (long) (rVar.f46322c - rVar.f46321b);
                if (j < j3) {
                    return rVar.f46320a[rVar.f46321b + ((int) j)];
                }
                j -= j3;
                rVar = rVar.f46325f;
            }
        } else {
            long j4 = j - j2;
            r rVar2 = this.f46276a;
            do {
                rVar2 = rVar2.f46326g;
                j4 += (long) (rVar2.f46322c - rVar2.f46321b);
            } while (j4 < 0);
            return rVar2.f46320a[rVar2.f46321b + ((int) j4)];
        }
    }

    public final short h() {
        if (this.f46277b >= 2) {
            r rVar = this.f46276a;
            int i2 = rVar.f46321b;
            int i3 = rVar.f46322c;
            if (i3 - i2 < 2) {
                return (short) (((g() & 255) << 8) | (g() & 255));
            }
            byte[] bArr = rVar.f46320a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            this.f46277b -= 2;
            if (i5 == i3) {
                this.f46276a = rVar.c();
                s.a(rVar);
            } else {
                rVar.f46321b = i5;
            }
            return (short) b2;
        }
        throw new IllegalStateException("size < 2: " + this.f46277b);
    }

    public final int i() {
        if (this.f46277b >= 4) {
            r rVar = this.f46276a;
            int i2 = rVar.f46321b;
            int i3 = rVar.f46322c;
            if (i3 - i2 < 4) {
                return ((g() & 255) << 24) | ((g() & 255) << 16) | ((g() & 255) << 8) | (g() & 255);
            }
            byte[] bArr = rVar.f46320a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i6 = i5 + 1;
            byte b3 = b2 | ((bArr[i5] & 255) << 8);
            int i7 = i6 + 1;
            byte b4 = b3 | (bArr[i6] & 255);
            this.f46277b -= 4;
            if (i7 == i3) {
                this.f46276a = rVar.c();
                s.a(rVar);
            } else {
                rVar.f46321b = i7;
            }
            return b4;
        }
        throw new IllegalStateException("size < 4: " + this.f46277b);
    }

    public final long j() {
        if (this.f46277b >= 8) {
            r rVar = this.f46276a;
            int i2 = rVar.f46321b;
            int i3 = rVar.f46322c;
            if (i3 - i2 < 8) {
                return ((((long) i()) & 4294967295L) << 32) | (4294967295L & ((long) i()));
            }
            byte[] bArr = rVar.f46320a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            long j = (((long) bArr[i10]) & 255) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i4]) & 255) << 48) | ((((long) bArr[i5]) & 255) << 40) | ((((long) bArr[i6]) & 255) << 32) | ((((long) bArr[i7]) & 255) << 24) | ((((long) bArr[i8]) & 255) << 16) | ((((long) bArr[i9]) & 255) << 8);
            this.f46277b -= 8;
            if (i11 == i3) {
                this.f46276a = rVar.c();
                s.a(rVar);
            } else {
                rVar.f46321b = i11;
            }
            return j;
        }
        throw new IllegalStateException("size < 8: " + this.f46277b);
    }

    public final short k() {
        return x.a(h());
    }

    public final int l() {
        return x.a(i());
    }

    public final long m() {
        return x.a(j());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r1 = new i.c().k(r6).b((int) r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r3 != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r1.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.q());
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long n() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f46277b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00bd
            r1 = -7
            r5 = 0
            r6 = r3
            r3 = 0
            r4 = 0
        L_0x0010:
            i.r r8 = r0.f46276a
            byte[] r9 = r8.f46320a
            int r10 = r8.f46321b
            int r11 = r8.f46322c
        L_0x0018:
            r12 = 1
            if (r10 >= r11) goto L_0x009c
            byte r13 = r9[r10]
            r14 = 48
            if (r13 < r14) goto L_0x006b
            r15 = 57
            if (r13 > r15) goto L_0x006b
            int r14 = r14 - r13
            r15 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r12 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r12 < 0) goto L_0x0041
            r15 = r8
            r16 = r9
            if (r12 != 0) goto L_0x003a
            long r8 = (long) r14
            int r12 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r12 >= 0) goto L_0x003a
            goto L_0x0041
        L_0x003a:
            r8 = 10
            long r6 = r6 * r8
            long r8 = (long) r14
            long r6 = r6 + r8
            goto L_0x0078
        L_0x0041:
            i.c r1 = new i.c
            r1.<init>()
            i.c r1 = r1.n((long) r6)
            i.c r1 = r1.j((int) r13)
            if (r3 != 0) goto L_0x0053
            r1.g()
        L_0x0053:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Number too large: "
            r3.<init>(r4)
            java.lang.String r1 = r1.q()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006b:
            r15 = r8
            r16 = r9
            r8 = 45
            if (r13 != r8) goto L_0x0080
            if (r5 != 0) goto L_0x0080
            r8 = 1
            long r1 = r1 - r8
            r3 = 1
        L_0x0078:
            int r10 = r10 + 1
            int r5 = r5 + 1
            r8 = r15
            r9 = r16
            goto L_0x0018
        L_0x0080:
            if (r5 == 0) goto L_0x0084
            r4 = 1
            goto L_0x009d
        L_0x0084:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.<init>(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r13)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x009c:
            r15 = r8
        L_0x009d:
            if (r10 != r11) goto L_0x00a9
            i.r r8 = r15.c()
            r0.f46276a = r8
            i.s.a(r15)
            goto L_0x00ac
        L_0x00a9:
            r8 = r15
            r8.f46321b = r10
        L_0x00ac:
            if (r4 != 0) goto L_0x00b2
            i.r r8 = r0.f46276a
            if (r8 != 0) goto L_0x0010
        L_0x00b2:
            long r1 = r0.f46277b
            long r4 = (long) r5
            long r1 = r1 - r4
            r0.f46277b = r1
            if (r3 == 0) goto L_0x00bb
            return r6
        L_0x00bb:
            long r1 = -r6
            return r1
        L_0x00bd:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i.c.n():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008c, code lost:
        if (r8 != r9) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        r15.f46276a = r6.c();
        i.s.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        r6.f46321b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        if (r5 != false) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0074 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long o() {
        /*
            r15 = this;
            long r0 = r15.f46277b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00a7
            r0 = 0
            r0 = r2
            r4 = 0
            r5 = 0
        L_0x000c:
            i.r r6 = r15.f46276a
            byte[] r7 = r6.f46320a
            int r8 = r6.f46321b
            int r9 = r6.f46322c
        L_0x0014:
            if (r8 >= r9) goto L_0x008c
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0023
            r11 = 57
            if (r10 > r11) goto L_0x0023
            int r11 = r10 + -48
            goto L_0x003b
        L_0x0023:
            r11 = 97
            if (r10 < r11) goto L_0x0030
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x0030
            int r11 = r10 + -97
        L_0x002d:
            int r11 = r11 + 10
            goto L_0x003b
        L_0x0030:
            r11 = 65
            if (r10 < r11) goto L_0x0070
            r11 = 70
            if (r10 > r11) goto L_0x0070
            int r11 = r10 + -65
            goto L_0x002d
        L_0x003b:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r0
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004b
            r10 = 4
            long r0 = r0 << r10
            long r10 = (long) r11
            long r0 = r0 | r10
            int r8 = r8 + 1
            int r4 = r4 + 1
            goto L_0x0014
        L_0x004b:
            i.c r2 = new i.c
            r2.<init>()
            i.c r0 = r2.m(r0)
            i.c r0 = r0.j((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.q()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0070:
            if (r4 == 0) goto L_0x0074
            r5 = 1
            goto L_0x008c
        L_0x0074:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008c:
            if (r8 != r9) goto L_0x0098
            i.r r7 = r6.c()
            r15.f46276a = r7
            i.s.a(r6)
            goto L_0x009a
        L_0x0098:
            r6.f46321b = r8
        L_0x009a:
            if (r5 != 0) goto L_0x00a0
            i.r r6 = r15.f46276a
            if (r6 != 0) goto L_0x000c
        L_0x00a0:
            long r2 = r15.f46277b
            long r4 = (long) r4
            long r2 = r2 - r4
            r15.f46277b = r2
            return r0
        L_0x00a7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.c.o():long");
    }

    public final f p() {
        return new f(s());
    }

    public final f d(long j) throws EOFException {
        return new f(h(j));
    }

    public final int a(o oVar) {
        int a2 = a(oVar, false);
        if (a2 == -1) {
            return -1;
        }
        try {
            i((long) oVar.f46311a[a2].size());
            return a2;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(o oVar, boolean z) {
        int i2;
        int i3;
        r rVar;
        o oVar2 = oVar;
        r rVar2 = this.f46276a;
        if (rVar2 != null) {
            byte[] bArr = rVar2.f46320a;
            int i4 = rVar2.f46321b;
            int i5 = rVar2.f46322c;
            int[] iArr = oVar2.f46312b;
            int i6 = i4;
            int i7 = i5;
            int i8 = -1;
            r rVar3 = rVar2;
            byte[] bArr2 = bArr;
            int i9 = 0;
            loop0:
            while (true) {
                int i10 = i9 + 1;
                int i11 = iArr[i9];
                int i12 = i10 + 1;
                int i13 = iArr[i10];
                if (i13 != -1) {
                    i8 = i13;
                }
                if (rVar3 == null) {
                    break;
                }
                if (i11 < 0) {
                    int i14 = i12 + (i11 * -1);
                    while (true) {
                        int i15 = i6 + 1;
                        int i16 = i12 + 1;
                        if ((bArr2[i6] & 255) != iArr[i12]) {
                            return i8;
                        }
                        boolean z2 = i16 == i14;
                        if (i15 == i7) {
                            rVar = rVar3.f46325f;
                            i3 = rVar.f46321b;
                            bArr2 = rVar.f46320a;
                            i7 = rVar.f46322c;
                            if (rVar == rVar2) {
                                if (!z2) {
                                    break loop0;
                                }
                                rVar = null;
                            }
                        } else {
                            r rVar4 = rVar3;
                            i3 = i15;
                            rVar = rVar4;
                        }
                        if (z2) {
                            i2 = iArr[i16];
                            break;
                        }
                        i6 = i3;
                        i12 = i16;
                        rVar3 = rVar;
                    }
                } else {
                    int i17 = i6 + 1;
                    byte b2 = bArr2[i6] & 255;
                    int i18 = i12 + i11;
                    while (i12 != i18) {
                        if (b2 == iArr[i12]) {
                            i2 = iArr[i12 + i11];
                            if (i17 == i7) {
                                rVar = rVar3.f46325f;
                                i3 = rVar.f46321b;
                                bArr2 = rVar.f46320a;
                                i7 = rVar.f46322c;
                                if (rVar == rVar2) {
                                    rVar = null;
                                }
                            } else {
                                rVar = rVar3;
                                i3 = i17;
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i8;
                }
                if (i2 >= 0) {
                    return i2;
                }
                int i19 = -i2;
                i6 = i3;
                rVar3 = rVar;
                i9 = i19;
            }
            if (z) {
                return -2;
            }
            return i8;
        } else if (z) {
            return -2;
        } else {
            return oVar2.indexOf(f.EMPTY);
        }
    }

    public final void a(c cVar, long j) throws EOFException {
        long j2 = this.f46277b;
        if (j2 >= j) {
            cVar.write(this, j);
        } else {
            cVar.write(this, j2);
            throw new EOFException();
        }
    }

    public final long a(u uVar) throws IOException {
        long j = this.f46277b;
        if (j > 0) {
            uVar.write(this, j);
        }
        return j;
    }

    public final String q() {
        try {
            return a(this.f46277b, x.f46329a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String e(long j) throws EOFException {
        return a(j, x.f46329a);
    }

    public final String a(Charset charset) {
        try {
            return a(this.f46277b, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String a(long j, Charset charset) throws EOFException {
        x.a(this.f46277b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        } else if (j == 0) {
            return "";
        } else {
            r rVar = this.f46276a;
            if (((long) rVar.f46321b) + j > ((long) rVar.f46322c)) {
                return new String(h(j), charset);
            }
            String str = new String(rVar.f46320a, rVar.f46321b, (int) j, charset);
            rVar.f46321b = (int) (((long) rVar.f46321b) + j);
            this.f46277b -= j;
            if (rVar.f46321b == rVar.f46322c) {
                this.f46276a = rVar.c();
                s.a(rVar);
            }
            return str;
        }
    }

    public final String r() throws EOFException {
        return f(Long.MAX_VALUE);
    }

    public final String f(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long a2 = a((byte) 10, 0, j2);
            if (a2 != -1) {
                return g(a2);
            }
            if (j2 < this.f46277b && c(j2 - 1) == 13 && c(j2) == 10) {
                return g(j2);
            }
            c cVar = new c();
            a(cVar, 0, Math.min(32, this.f46277b));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f46277b, j) + " content=" + cVar.p().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
    }

    /* access modifiers changed from: package-private */
    public final String g(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (c(j2) == 13) {
                String e2 = e(j2);
                i(2);
                return e2;
            }
        }
        String e3 = e(j);
        i(1);
        return e3;
    }

    public final byte[] s() {
        try {
            return h(this.f46277b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final byte[] h(long j) throws EOFException {
        x.a(this.f46277b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public final void a(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a2 = a(bArr, i2, bArr.length - i2);
            if (a2 != -1) {
                i2 += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    public final int a(byte[] bArr, int i2, int i3) {
        x.a((long) bArr.length, (long) i2, (long) i3);
        r rVar = this.f46276a;
        if (rVar == null) {
            return -1;
        }
        int min = Math.min(i3, rVar.f46322c - rVar.f46321b);
        System.arraycopy(rVar.f46320a, rVar.f46321b, bArr, i2, min);
        rVar.f46321b += min;
        this.f46277b -= (long) min;
        if (rVar.f46321b == rVar.f46322c) {
            this.f46276a = rVar.c();
            s.a(rVar);
        }
        return min;
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        r rVar = this.f46276a;
        if (rVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), rVar.f46322c - rVar.f46321b);
        byteBuffer.put(rVar.f46320a, rVar.f46321b, min);
        rVar.f46321b += min;
        this.f46277b -= (long) min;
        if (rVar.f46321b == rVar.f46322c) {
            this.f46276a = rVar.c();
            s.a(rVar);
        }
        return min;
    }

    public final void t() {
        try {
            i(this.f46277b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void i(long j) throws EOFException {
        while (j > 0) {
            r rVar = this.f46276a;
            if (rVar != null) {
                int min = (int) Math.min(j, (long) (rVar.f46322c - this.f46276a.f46321b));
                long j2 = (long) min;
                this.f46277b -= j2;
                j -= j2;
                this.f46276a.f46321b += min;
                if (this.f46276a.f46321b == this.f46276a.f46322c) {
                    r rVar2 = this.f46276a;
                    this.f46276a = rVar2.c();
                    s.a(rVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public final c d(f fVar) {
        if (fVar != null) {
            fVar.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public final c b(String str) {
        return b(str, 0, str.length());
    }

    /* renamed from: a */
    public final c b(String str, int i2, int i3) {
        char c2;
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i2)));
        } else if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        } else if (i3 <= str.length()) {
            while (i2 < i3) {
                char charAt2 = str.charAt(i2);
                if (charAt2 < 128) {
                    r f2 = f(1);
                    byte[] bArr = f2.f46320a;
                    int i4 = f2.f46322c - i2;
                    int min = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) charAt2;
                    while (true) {
                        i2 = i5;
                        if (i2 >= min || (charAt = str.charAt(i2)) >= 128) {
                            int i6 = (i4 + i2) - f2.f46322c;
                            f2.f46322c += i6;
                            this.f46277b += (long) i6;
                        } else {
                            i5 = i2 + 1;
                            bArr[i2 + i4] = (byte) charAt;
                        }
                    }
                    int i62 = (i4 + i2) - f2.f46322c;
                    f2.f46322c += i62;
                    this.f46277b += (long) i62;
                } else {
                    if (charAt2 < 2048) {
                        j((charAt2 >> 6) | 192);
                        j((int) (charAt2 & '?') | 128);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        j((charAt2 >> 12) | Constants.EASY_PAY_INVISIBLE_ASSIST);
                        j(((charAt2 >> 6) & 63) | 128);
                        j((int) (charAt2 & '?') | 128);
                    } else {
                        int i7 = i2 + 1;
                        if (i7 < i3) {
                            c2 = str.charAt(i7);
                        } else {
                            c2 = 0;
                        }
                        if (charAt2 > 56319 || c2 < 56320 || c2 > 57343) {
                            j(63);
                            i2 = i7;
                        } else {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & c2)) + 0;
                            j((i8 >> 18) | 240);
                            j(((i8 >> 12) & 63) | 128);
                            j(((i8 >> 6) & 63) | 128);
                            j((i8 & 63) | 128);
                            i2 += 2;
                        }
                    }
                    i2++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
    }

    public final c a(int i2) {
        if (i2 < 128) {
            j(i2);
        } else if (i2 < 2048) {
            j((i2 >> 6) | 192);
            j((i2 & 63) | 128);
        } else if (i2 < 65536) {
            if (i2 < 55296 || i2 > 57343) {
                j((i2 >> 12) | Constants.EASY_PAY_INVISIBLE_ASSIST);
                j(((i2 >> 6) & 63) | 128);
                j((i2 & 63) | 128);
            } else {
                j(63);
            }
        } else if (i2 <= 1114111) {
            j((i2 >> 18) | 240);
            j(((i2 >> 12) & 63) | 128);
            j(((i2 >> 6) & 63) | 128);
            j((i2 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
        }
        return this;
    }

    public final c a(String str, Charset charset) {
        return a(str, 0, str.length(), charset);
    }

    public final c a(String str, int i2, int i3, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i2)));
        } else if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        } else if (i3 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(x.f46329a)) {
            return b(str, i2, i3);
        } else {
            byte[] bytes = str.substring(i2, i3).getBytes(charset);
            return c(bytes, 0, bytes.length);
        }
    }

    /* renamed from: b */
    public final c c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public final c c(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j = (long) i3;
            x.a((long) bArr.length, (long) i2, j);
            int i4 = i3 + i2;
            while (i2 < i4) {
                r f2 = f(1);
                int min = Math.min(i4 - i2, 8192 - f2.f46322c);
                System.arraycopy(bArr, i2, f2.f46320a, f2.f46322c, min);
                i2 += min;
                f2.f46322c += min;
            }
            this.f46277b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                r f2 = f(1);
                int min = Math.min(i2, 8192 - f2.f46322c);
                byteBuffer.get(f2.f46320a, f2.f46322c, min);
                i2 -= min;
                f2.f46322c += min;
            }
            this.f46277b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final long a(v vVar) throws IOException {
        if (vVar != null) {
            long j = 0;
            while (true) {
                long read = vVar.read(this, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: b */
    public final c j(int i2) {
        r f2 = f(1);
        byte[] bArr = f2.f46320a;
        int i3 = f2.f46322c;
        f2.f46322c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f46277b++;
        return this;
    }

    /* renamed from: c */
    public final c i(int i2) {
        r f2 = f(2);
        byte[] bArr = f2.f46320a;
        int i3 = f2.f46322c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
        bArr[i4] = (byte) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
        f2.f46322c = i4 + 1;
        this.f46277b += 2;
        return this;
    }

    /* renamed from: d */
    public final c h(int i2) {
        r f2 = f(4);
        byte[] bArr = f2.f46320a;
        int i3 = f2.f46322c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & PriceRangeSeekBar.INVALID_POINTER_ID);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & PriceRangeSeekBar.INVALID_POINTER_ID);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
        bArr[i6] = (byte) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
        f2.f46322c = i6 + 1;
        this.f46277b += 4;
        return this;
    }

    /* renamed from: e */
    public final c g(int i2) {
        return h(x.a(i2));
    }

    public final c j(long j) {
        r f2 = f(8);
        byte[] bArr = f2.f46320a;
        int i2 = f2.f46322c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 56) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 48) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 40) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 32) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 24) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 16) & 255));
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i9] = (byte) ((int) (j & 255));
        f2.f46322c = i9 + 1;
        this.f46277b += 8;
        return this;
    }

    /* renamed from: k */
    public final c n(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 == 0) {
            return j(48);
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i3 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i3 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i3 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        r f2 = f(i3);
        byte[] bArr = f2.f46320a;
        int i4 = f2.f46322c + i3;
        while (j != 0) {
            i4--;
            bArr[i4] = f46275c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i4 - 1] = 45;
        }
        f2.f46322c += i3;
        this.f46277b += (long) i3;
        return this;
    }

    /* renamed from: l */
    public final c m(long j) {
        if (j == 0) {
            return j(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        r f2 = f(numberOfTrailingZeros);
        byte[] bArr = f2.f46320a;
        int i2 = f2.f46322c;
        for (int i3 = (f2.f46322c + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f46275c[(int) (15 & j)];
            j >>>= 4;
        }
        f2.f46322c += numberOfTrailingZeros;
        this.f46277b += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final r f(int i2) {
        if (i2 <= 0 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        r rVar = this.f46276a;
        if (rVar == null) {
            this.f46276a = s.a();
            r rVar2 = this.f46276a;
            rVar2.f46326g = rVar2;
            rVar2.f46325f = rVar2;
            return rVar2;
        }
        r rVar3 = rVar.f46326g;
        return (rVar3.f46322c + i2 > 8192 || !rVar3.f46324e) ? rVar3.a(s.a()) : rVar3;
    }

    public final void write(c cVar, long j) {
        r rVar;
        int i2;
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            x.a(cVar.f46277b, 0, j);
            while (j > 0) {
                int i3 = 0;
                if (j < ((long) (cVar.f46276a.f46322c - cVar.f46276a.f46321b))) {
                    r rVar2 = this.f46276a;
                    r rVar3 = rVar2 != null ? rVar2.f46326g : null;
                    if (rVar3 != null && rVar3.f46324e) {
                        long j2 = ((long) rVar3.f46322c) + j;
                        if (rVar3.f46323d) {
                            i2 = 0;
                        } else {
                            i2 = rVar3.f46321b;
                        }
                        if (j2 - ((long) i2) <= 8192) {
                            cVar.f46276a.a(rVar3, (int) j);
                            cVar.f46277b -= j;
                            this.f46277b += j;
                            return;
                        }
                    }
                    r rVar4 = cVar.f46276a;
                    int i4 = (int) j;
                    if (i4 <= 0 || i4 > rVar4.f46322c - rVar4.f46321b) {
                        throw new IllegalArgumentException();
                    }
                    if (i4 >= 1024) {
                        rVar = rVar4.a();
                    } else {
                        rVar = s.a();
                        System.arraycopy(rVar4.f46320a, rVar4.f46321b, rVar.f46320a, 0, i4);
                    }
                    rVar.f46322c = rVar.f46321b + i4;
                    rVar4.f46321b += i4;
                    rVar4.f46326g.a(rVar);
                    cVar.f46276a = rVar;
                }
                r rVar5 = cVar.f46276a;
                long j3 = (long) (rVar5.f46322c - rVar5.f46321b);
                cVar.f46276a = rVar5.c();
                r rVar6 = this.f46276a;
                if (rVar6 == null) {
                    this.f46276a = rVar5;
                    r rVar7 = this.f46276a;
                    rVar7.f46326g = rVar7;
                    rVar7.f46325f = rVar7;
                } else {
                    r a2 = rVar6.f46326g.a(rVar5);
                    if (a2.f46326g == a2) {
                        throw new IllegalStateException();
                    } else if (a2.f46326g.f46324e) {
                        int i5 = a2.f46322c - a2.f46321b;
                        int i6 = 8192 - a2.f46326g.f46322c;
                        if (!a2.f46326g.f46323d) {
                            i3 = a2.f46326g.f46321b;
                        }
                        if (i5 <= i6 + i3) {
                            a2.a(a2.f46326g, i5);
                            a2.c();
                            s.a(a2);
                        }
                    }
                }
                cVar.f46277b -= j3;
                this.f46277b += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public final long read(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f46277b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
    }

    public final long u() {
        return a((byte) 0, 0, Long.MAX_VALUE);
    }

    public final long a(byte b2, long j, long j2) {
        r rVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f46277b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.f46277b;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4 || (rVar = this.f46276a) == null) {
            return -1;
        }
        long j5 = this.f46277b;
        if (j5 - j >= j) {
            while (true) {
                j5 = j3;
                j3 = ((long) (rVar.f46322c - rVar.f46321b)) + j5;
                if (j3 >= j) {
                    break;
                }
                rVar = rVar.f46325f;
            }
        } else {
            while (j5 > j) {
                rVar = rVar.f46326g;
                j5 -= (long) (rVar.f46322c - rVar.f46321b);
            }
        }
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr = rVar.f46320a;
            int min = (int) Math.min((long) rVar.f46322c, (((long) rVar.f46321b) + j4) - j5);
            for (int i2 = (int) ((((long) rVar.f46321b) + j6) - j5); i2 < min; i2++) {
                if (bArr[i2] == b2) {
                    return ((long) (i2 - rVar.f46321b)) + j5;
                }
            }
            byte b3 = b2;
            j6 = ((long) (rVar.f46322c - rVar.f46321b)) + j5;
            rVar = rVar.f46325f;
            j5 = j6;
        }
        return -1;
    }

    public final long b(f fVar) throws IOException {
        return a(fVar, 0);
    }

    public final long a(f fVar, long j) throws IOException {
        f fVar2 = fVar;
        if (fVar.size() != 0) {
            long j2 = 0;
            if (j >= 0) {
                r rVar = this.f46276a;
                long j3 = -1;
                if (rVar == null) {
                    return -1;
                }
                long j4 = this.f46277b;
                if (j4 - j >= j) {
                    while (true) {
                        j4 = j2;
                        j2 = ((long) (rVar.f46322c - rVar.f46321b)) + j4;
                        if (j2 >= j) {
                            break;
                        }
                        rVar = rVar.f46325f;
                    }
                } else {
                    while (j4 > j) {
                        rVar = rVar.f46326g;
                        j4 -= (long) (rVar.f46322c - rVar.f46321b);
                    }
                }
                byte b2 = fVar2.getByte(0);
                int size = fVar.size();
                long j5 = (this.f46277b - ((long) size)) + 1;
                long j6 = j;
                while (j4 < j5) {
                    byte[] bArr = rVar.f46320a;
                    int min = (int) Math.min((long) rVar.f46322c, (((long) rVar.f46321b) + j5) - j4);
                    for (int i2 = (int) ((((long) rVar.f46321b) + j6) - j4); i2 < min; i2++) {
                        if (bArr[i2] == b2 && a(rVar, i2 + 1, fVar2, size)) {
                            return ((long) (i2 - rVar.f46321b)) + j4;
                        }
                    }
                    j6 = j4 + ((long) (rVar.f46322c - rVar.f46321b));
                    rVar = rVar.f46325f;
                    j4 = j6;
                    j3 = -1;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public final long c(f fVar) {
        return b(fVar, 0);
    }

    public final long b(f fVar, long j) {
        int i2;
        int i3;
        long j2 = 0;
        if (j >= 0) {
            r rVar = this.f46276a;
            if (rVar == null) {
                return -1;
            }
            long j3 = this.f46277b;
            if (j3 - j >= j) {
                while (true) {
                    j3 = j2;
                    j2 = ((long) (rVar.f46322c - rVar.f46321b)) + j3;
                    if (j2 >= j) {
                        break;
                    }
                    rVar = rVar.f46325f;
                }
            } else {
                while (j3 > j) {
                    rVar = rVar.f46326g;
                    j3 -= (long) (rVar.f46322c - rVar.f46321b);
                }
            }
            if (fVar.size() == 2) {
                byte b2 = fVar.getByte(0);
                byte b3 = fVar.getByte(1);
                while (j3 < this.f46277b) {
                    byte[] bArr = rVar.f46320a;
                    i2 = (int) ((((long) rVar.f46321b) + j) - j3);
                    int i4 = rVar.f46322c;
                    while (i2 < i4) {
                        byte b4 = bArr[i2];
                        if (b4 == b2 || b4 == b3) {
                            i3 = rVar.f46321b;
                        } else {
                            i2++;
                        }
                    }
                    j = ((long) (rVar.f46322c - rVar.f46321b)) + j3;
                    rVar = rVar.f46325f;
                    j3 = j;
                }
                return -1;
            }
            byte[] internalArray = fVar.internalArray();
            while (j3 < this.f46277b) {
                byte[] bArr2 = rVar.f46320a;
                int i5 = (int) ((((long) rVar.f46321b) + j) - j3);
                int i6 = rVar.f46322c;
                while (i2 < i6) {
                    byte b5 = bArr2[i2];
                    int length = internalArray.length;
                    int i7 = 0;
                    while (i7 < length) {
                        if (b5 == internalArray[i7]) {
                            i3 = rVar.f46321b;
                        } else {
                            i7++;
                        }
                    }
                    i5 = i2 + 1;
                }
                j = ((long) (rVar.f46322c - rVar.f46321b)) + j3;
                rVar = rVar.f46325f;
                j3 = j;
            }
            return -1;
            return ((long) (i2 - i3)) + j3;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public final boolean a(long j, f fVar) {
        int size = fVar.size();
        if (j < 0 || size < 0 || this.f46277b - j < ((long) size) || fVar.size() - 0 < size) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (c(((long) i2) + j) != fVar.getByte(i2 + 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(r rVar, int i2, f fVar, int i3) {
        int i4 = rVar.f46322c;
        byte[] bArr = rVar.f46320a;
        r rVar2 = rVar;
        for (int i5 = 1; i5 < i3; i5++) {
            if (i2 == i4) {
                r rVar3 = rVar2.f46325f;
                byte[] bArr2 = rVar3.f46320a;
                int i6 = rVar3.f46321b;
                int i7 = rVar3.f46322c;
                int i8 = i6;
                rVar2 = rVar3;
                i2 = i8;
                int i9 = i7;
                bArr = bArr2;
                i4 = i9;
            }
            if (bArr[i2] != fVar.getByte(i5)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public final w timeout() {
        return w.NONE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.f46277b;
        if (j != cVar.f46277b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        r rVar = this.f46276a;
        r rVar2 = cVar.f46276a;
        int i2 = rVar.f46321b;
        int i3 = rVar2.f46321b;
        while (j2 < this.f46277b) {
            long min = (long) Math.min(rVar.f46322c - i2, rVar2.f46322c - i3);
            int i4 = i3;
            int i5 = i2;
            int i6 = 0;
            while (((long) i6) < min) {
                int i7 = i5 + 1;
                int i8 = i4 + 1;
                if (rVar.f46320a[i5] != rVar2.f46320a[i4]) {
                    return false;
                }
                i6++;
                i5 = i7;
                i4 = i8;
            }
            if (i5 == rVar.f46322c) {
                rVar = rVar.f46325f;
                i2 = rVar.f46321b;
            } else {
                i2 = i5;
            }
            if (i4 == rVar2.f46322c) {
                rVar2 = rVar2.f46325f;
                i3 = rVar2.f46321b;
            } else {
                i3 = i4;
            }
            j2 += min;
        }
        return true;
    }

    public final int hashCode() {
        r rVar = this.f46276a;
        if (rVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = rVar.f46322c;
            for (int i4 = rVar.f46321b; i4 < i3; i4++) {
                i2 = (i2 * 31) + rVar.f46320a[i4];
            }
            rVar = rVar.f46325f;
        } while (rVar != this.f46276a);
        return i2;
    }

    public final String toString() {
        return w().toString();
    }

    /* renamed from: v */
    public final c clone() {
        c cVar = new c();
        if (this.f46277b == 0) {
            return cVar;
        }
        cVar.f46276a = this.f46276a.a();
        r rVar = cVar.f46276a;
        rVar.f46326g = rVar;
        rVar.f46325f = rVar;
        r rVar2 = this.f46276a;
        while (true) {
            rVar2 = rVar2.f46325f;
            if (rVar2 != this.f46276a) {
                cVar.f46276a.f46326g.a(rVar2.a());
            } else {
                cVar.f46277b = this.f46277b;
                return cVar;
            }
        }
    }

    public final f w() {
        long j = this.f46277b;
        if (j <= 2147483647L) {
            return k((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f46277b);
    }

    private f k(int i2) {
        if (i2 == 0) {
            return f.EMPTY;
        }
        return new t(this, i2);
    }

    public final a a(a aVar) {
        if (aVar.f46280a == null) {
            aVar.f46280a = this;
            aVar.f46281b = true;
            return aVar;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public static final class a implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public c f46280a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f46281b;

        /* renamed from: c  reason: collision with root package name */
        public long f46282c = -1;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f46283d;

        /* renamed from: e  reason: collision with root package name */
        public int f46284e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f46285f = -1;

        /* renamed from: g  reason: collision with root package name */
        private r f46286g;

        public final int a(long j) {
            r rVar;
            long j2;
            int i2 = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if (i2 < 0 || j > this.f46280a.f46277b) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j), Long.valueOf(this.f46280a.f46277b)}));
            } else if (i2 == 0 || j == this.f46280a.f46277b) {
                this.f46286g = null;
                this.f46282c = j;
                this.f46283d = null;
                this.f46284e = -1;
                this.f46285f = -1;
                return -1;
            } else {
                long j3 = 0;
                long j4 = this.f46280a.f46277b;
                r rVar2 = this.f46280a.f46276a;
                r rVar3 = this.f46280a.f46276a;
                r rVar4 = this.f46286g;
                if (rVar4 != null) {
                    long j5 = this.f46282c - ((long) (this.f46284e - rVar4.f46321b));
                    if (j5 > j) {
                        rVar3 = this.f46286g;
                        j4 = j5;
                    } else {
                        rVar2 = this.f46286g;
                        j3 = j5;
                    }
                }
                if (j4 - j > j - j3) {
                    while (j >= ((long) (rVar.f46322c - rVar.f46321b)) + j2) {
                        j3 = j2 + ((long) (rVar.f46322c - rVar.f46321b));
                        rVar2 = rVar.f46325f;
                    }
                } else {
                    j2 = j4;
                    rVar = rVar3;
                    while (j2 > j) {
                        rVar = rVar.f46326g;
                        j2 -= (long) (rVar.f46322c - rVar.f46321b);
                    }
                }
                if (this.f46281b && rVar.f46323d) {
                    r b2 = rVar.b();
                    if (this.f46280a.f46276a == rVar) {
                        this.f46280a.f46276a = b2;
                    }
                    rVar = rVar.a(b2);
                    rVar.f46326g.c();
                }
                this.f46286g = rVar;
                this.f46282c = j;
                this.f46283d = rVar.f46320a;
                this.f46284e = rVar.f46321b + ((int) (j - j2));
                this.f46285f = rVar.f46322c;
                return this.f46285f - this.f46284e;
            }
        }

        public final void close() {
            if (this.f46280a != null) {
                this.f46280a = null;
                this.f46286g = null;
                this.f46282c = -1;
                this.f46283d = null;
                this.f46284e = -1;
                this.f46285f = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }
}
