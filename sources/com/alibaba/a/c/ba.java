package com.alibaba.a.c;

import com.alibaba.a.a;
import com.alibaba.a.d;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.ref.SoftReference;

public final class ba extends Writer {

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<SoftReference<char[]>> f6303c = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    protected char[] f6304a;

    /* renamed from: b  reason: collision with root package name */
    protected int f6305b;

    /* renamed from: d  reason: collision with root package name */
    private int f6306d;

    /* renamed from: e  reason: collision with root package name */
    private final Writer f6307e;

    public ba() {
        this((Writer) null);
    }

    public ba(Writer writer) {
        this.f6307e = writer;
        this.f6306d = a.DEFAULT_GENERATE_FEATURE;
        SoftReference softReference = f6303c.get();
        if (softReference != null) {
            this.f6304a = (char[]) softReference.get();
            f6303c.set((Object) null);
        }
        if (this.f6304a == null) {
            this.f6304a = new char[TarConstants.EOF_BLOCK];
        }
    }

    public ba(bb... bbVarArr) {
        this(bbVarArr, (byte) 0);
    }

    private ba(bb[] bbVarArr, byte b2) {
        this.f6307e = null;
        SoftReference softReference = f6303c.get();
        if (softReference != null) {
            this.f6304a = (char[]) softReference.get();
            f6303c.set((Object) null);
        }
        if (this.f6304a == null) {
            this.f6304a = new char[TarConstants.EOF_BLOCK];
        }
        int i2 = 0;
        for (bb mask : bbVarArr) {
            i2 |= mask.getMask();
        }
        this.f6306d = i2;
    }

    public final void a(bb bbVar) {
        this.f6306d = bbVar.getMask() | this.f6306d;
    }

    public final boolean b(bb bbVar) {
        return bb.isEnabled(this.f6306d, bbVar);
    }

    public final void write(int i2) {
        int i3 = this.f6305b + 1;
        if (i3 > this.f6304a.length) {
            if (this.f6307e == null) {
                b(i3);
            } else {
                flush();
                i3 = 1;
            }
        }
        this.f6304a[this.f6305b] = (char) i2;
        this.f6305b = i3;
    }

    public final void a(char c2) {
        int i2 = this.f6305b + 1;
        if (i2 > this.f6304a.length) {
            if (this.f6307e == null) {
                b(i2);
            } else {
                flush();
                i2 = 1;
            }
        }
        this.f6304a[this.f6305b] = c2;
        this.f6305b = i2;
    }

    public final void write(char[] cArr, int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 > cArr.length || i3 < 0 || (i4 = i2 + i3) > cArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i3 != 0) {
            int i5 = this.f6305b + i3;
            if (i5 > this.f6304a.length) {
                if (this.f6307e == null) {
                    b(i5);
                } else {
                    do {
                        char[] cArr2 = this.f6304a;
                        int length = cArr2.length;
                        int i6 = this.f6305b;
                        int i7 = length - i6;
                        System.arraycopy(cArr, i2, cArr2, i6, i7);
                        this.f6305b = this.f6304a.length;
                        flush();
                        i3 -= i7;
                        i2 += i7;
                    } while (i3 > this.f6304a.length);
                    i5 = i3;
                }
            }
            System.arraycopy(cArr, i2, this.f6304a, this.f6305b, i3);
            this.f6305b = i5;
        }
    }

    private void b(int i2) {
        int length = ((this.f6304a.length * 3) / 2) + 1;
        if (length >= i2) {
            i2 = length;
        }
        char[] cArr = new char[i2];
        System.arraycopy(this.f6304a, 0, cArr, 0, this.f6305b);
        this.f6304a = cArr;
    }

    public final void write(String str, int i2, int i3) {
        int i4;
        int i5 = this.f6305b + i3;
        if (i5 > this.f6304a.length) {
            if (this.f6307e == null) {
                b(i5);
            } else {
                while (true) {
                    char[] cArr = this.f6304a;
                    int length = cArr.length;
                    int i6 = this.f6305b;
                    int i7 = length - i6;
                    i4 = i2 + i7;
                    str.getChars(i2, i4, cArr, i6);
                    this.f6305b = this.f6304a.length;
                    flush();
                    i3 -= i7;
                    if (i3 <= this.f6304a.length) {
                        break;
                    }
                    i2 = i4;
                }
                i5 = i3;
                i2 = i4;
            }
        }
        str.getChars(i2, i3 + i2, this.f6304a, this.f6305b);
        this.f6305b = i5;
    }

    /* renamed from: a */
    public final ba append(CharSequence charSequence) {
        String obj = charSequence == null ? "null" : charSequence.toString();
        write(obj, 0, obj.length());
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ba append(CharSequence charSequence, int i2, int i3) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String obj = charSequence.subSequence(i2, i3).toString();
        write(obj, 0, obj.length());
        return this;
    }

    public final ba b(char c2) {
        a(c2);
        return this;
    }

    public final byte[] a(String str) {
        if (this.f6307e == null) {
            try {
                return new String(this.f6304a, 0, this.f6305b).getBytes(str);
            } catch (UnsupportedEncodingException e2) {
                throw new d("toBytes error", e2);
            }
        } else {
            throw new UnsupportedOperationException("writer not null");
        }
    }

    public final String toString() {
        return new String(this.f6304a, 0, this.f6305b);
    }

    public final void close() {
        if (this.f6307e != null && this.f6305b > 0) {
            flush();
        }
        char[] cArr = this.f6304a;
        if (cArr.length <= 8192) {
            f6303c.set(new SoftReference(cArr));
        }
        this.f6304a = null;
    }

    public final void write(String str) {
        while (str == null) {
            str = "null";
        }
        write(str, 0, str.length());
    }

    public final void a(int i2) {
        if (i2 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int a2 = i2 < 0 ? com.alibaba.a.d.d.a(-i2) + 1 : com.alibaba.a.d.d.a(i2);
        int i3 = this.f6305b + a2;
        if (i3 > this.f6304a.length) {
            if (this.f6307e == null) {
                b(i3);
            } else {
                char[] cArr = new char[a2];
                com.alibaba.a.d.d.a((long) i2, a2, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        com.alibaba.a.d.d.a((long) i2, i3, this.f6304a);
        this.f6305b = i3;
    }

    public final void a(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        boolean b2 = b(bb.UseSingleQuotes);
        char c2 = b2 ? '\'' : '\"';
        if (length == 0) {
            write(b2 ? "''" : "\"\"");
            return;
        }
        char[] cArr = com.alibaba.a.d.a.f6343a;
        int i2 = (length / 3) * 3;
        int i3 = length - 1;
        int i4 = this.f6305b;
        int i5 = (((i3 / 3) + 1) << 2) + i4 + 2;
        int i6 = 0;
        if (i5 > this.f6304a.length) {
            if (this.f6307e != null) {
                a(c2);
                int i7 = 0;
                while (i7 < i2) {
                    int i8 = i7 + 1;
                    int i9 = i8 + 1;
                    byte b3 = ((bArr2[i7] & 255) << 16) | ((bArr2[i8] & 255) << 8) | (bArr2[i9] & 255);
                    a(cArr[(b3 >>> 18) & 63]);
                    a(cArr[(b3 >>> 12) & 63]);
                    a(cArr[(b3 >>> 6) & 63]);
                    a(cArr[b3 & 63]);
                    i7 = i9 + 1;
                }
                int i10 = length - i2;
                if (i10 > 0) {
                    int i11 = (bArr2[i2] & 255) << 10;
                    if (i10 == 2) {
                        i6 = (bArr2[i3] & 255) << 2;
                    }
                    int i12 = i11 | i6;
                    a(cArr[i12 >> 12]);
                    a(cArr[(i12 >>> 6) & 63]);
                    a(i10 == 2 ? cArr[i12 & 63] : '=');
                    a('=');
                }
                a(c2);
                return;
            }
            b(i5);
        }
        this.f6305b = i5;
        int i13 = i4 + 1;
        this.f6304a[i4] = c2;
        int i14 = 0;
        while (i14 < i2) {
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            byte b4 = ((bArr2[i14] & 255) << 16) | ((bArr2[i15] & 255) << 8);
            int i17 = i16 + 1;
            byte b5 = b4 | (bArr2[i16] & 255);
            char[] cArr2 = this.f6304a;
            int i18 = i13 + 1;
            cArr2[i13] = cArr[(b5 >>> 18) & 63];
            int i19 = i18 + 1;
            cArr2[i18] = cArr[(b5 >>> 12) & 63];
            int i20 = i19 + 1;
            cArr2[i19] = cArr[(b5 >>> 6) & 63];
            i13 = i20 + 1;
            cArr2[i20] = cArr[b5 & 63];
            i14 = i17;
        }
        int i21 = length - i2;
        if (i21 > 0) {
            int i22 = (bArr2[i2] & 255) << 10;
            if (i21 == 2) {
                i6 = (bArr2[i3] & 255) << 2;
            }
            int i23 = i22 | i6;
            char[] cArr3 = this.f6304a;
            cArr3[i5 - 5] = cArr[i23 >> 12];
            cArr3[i5 - 4] = cArr[(i23 >>> 6) & 63];
            cArr3[i5 - 3] = i21 == 2 ? cArr[i23 & 63] : '=';
            this.f6304a[i5 - 2] = '=';
        }
        this.f6304a[i5 - 1] = c2;
    }

    public final void a(long j, char c2) throws IOException {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            a(c2);
            return;
        }
        int a2 = this.f6305b + (j < 0 ? com.alibaba.a.d.d.a(-j) + 1 : com.alibaba.a.d.d.a(j));
        int i2 = a2 + 1;
        if (i2 > this.f6304a.length) {
            if (this.f6307e != null) {
                a(j);
                a(c2);
                return;
            }
            b(i2);
        }
        com.alibaba.a.d.d.a(j, a2, this.f6304a);
        this.f6304a[a2] = c2;
        this.f6305b = i2;
    }

    public final void a(long j) {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        int a2 = j < 0 ? com.alibaba.a.d.d.a(-j) + 1 : com.alibaba.a.d.d.a(j);
        int i2 = this.f6305b + a2;
        if (i2 > this.f6304a.length) {
            if (this.f6307e == null) {
                b(i2);
            } else {
                char[] cArr = new char[a2];
                com.alibaba.a.d.d.a(j, a2, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        com.alibaba.a.d.d.a(j, i2, this.f6304a);
        this.f6305b = i2;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, char c2) {
        a(str, c2, true);
    }

    public final void a(String str, long j) {
        if (j == Long.MIN_VALUE || !b(bb.QuoteFieldNames)) {
            a(',');
            a(str, false);
            a(j);
            return;
        }
        char c2 = b(bb.UseSingleQuotes) ? '\'' : '\"';
        int a2 = j < 0 ? com.alibaba.a.d.d.a(-j) + 1 : com.alibaba.a.d.d.a(j);
        int length = str.length();
        int i2 = this.f6305b + length + 4 + a2;
        if (i2 > this.f6304a.length) {
            if (this.f6307e != null) {
                a(',');
                a(str, false);
                a(j);
                return;
            }
            b(i2);
        }
        int i3 = this.f6305b;
        this.f6305b = i2;
        char[] cArr = this.f6304a;
        cArr[i3] = ',';
        int i4 = i3 + length + 1;
        cArr[i3 + 1] = c2;
        str.getChars(0, length, cArr, i3 + 2);
        char[] cArr2 = this.f6304a;
        cArr2[i4 + 1] = c2;
        cArr2[i4 + 2] = ':';
        com.alibaba.a.d.d.a(j, this.f6305b, cArr2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0094, code lost:
        if (r9 == -1) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c7, code lost:
        if (r9 == -1) goto L_0x0096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            int r3 = r17.length()
            int r4 = r0.f6305b
            r5 = 4
            if (r2 != 0) goto L_0x0014
            int r6 = r3 + 8
            int r4 = r4 + r6
            r6 = 4
            goto L_0x001d
        L_0x0014:
            int r6 = r18.length()
            int r7 = r3 + r6
            int r7 = r7 + 6
            int r4 = r4 + r7
        L_0x001d:
            char[] r7 = r0.f6304a
            int r7 = r7.length
            r8 = 58
            r9 = 44
            r10 = 0
            r11 = 1
            if (r4 <= r7) goto L_0x0039
            java.io.Writer r7 = r0.f6307e
            if (r7 == 0) goto L_0x0036
            r0.a((char) r9)
            r0.a((java.lang.String) r1, (char) r8, (boolean) r11)
            r0.a((java.lang.String) r2, (char) r10, (boolean) r11)
            return
        L_0x0036:
            r0.b((int) r4)
        L_0x0039:
            char[] r7 = r0.f6304a
            int r12 = r0.f6305b
            r7[r12] = r9
            int r9 = r12 + 2
            int r13 = r9 + r3
            int r12 = r12 + r11
            r14 = 34
            r7[r12] = r14
            r1.getChars(r10, r3, r7, r9)
            r0.f6305b = r4
            char[] r1 = r0.f6304a
            r1[r13] = r14
            int r13 = r13 + r11
            int r3 = r13 + 1
            r1[r13] = r8
            r7 = 117(0x75, float:1.64E-43)
            if (r2 != 0) goto L_0x006f
            int r2 = r3 + 1
            r4 = 110(0x6e, float:1.54E-43)
            r1[r3] = r4
            int r3 = r2 + 1
            r1[r2] = r7
            int r2 = r3 + 1
            r4 = 108(0x6c, float:1.51E-43)
            r1[r3] = r4
            r3 = 108(0x6c, float:1.51E-43)
            r1[r2] = r3
            return
        L_0x006f:
            int r8 = r3 + 1
            r1[r3] = r14
            int r3 = r8 + r6
            r2.getChars(r10, r6, r1, r8)
            com.alibaba.a.c.bb r1 = com.alibaba.a.c.bb.DisableCheckSpecialChar
            boolean r1 = r0.b((com.alibaba.a.c.bb) r1)
            if (r1 != 0) goto L_0x0235
            r1 = -1
            r6 = r4
            r4 = r8
            r9 = -1
            r12 = 0
            r13 = -1
        L_0x0086:
            r15 = 8232(0x2028, float:1.1535E-41)
            if (r4 >= r3) goto L_0x00cf
            char[] r14 = r0.f6304a
            char r14 = r14[r4]
            if (r14 != r15) goto L_0x009c
            int r10 = r10 + 1
            int r6 = r6 + 4
            if (r9 != r1) goto L_0x0099
        L_0x0096:
            r9 = r4
            r13 = r9
            goto L_0x009a
        L_0x0099:
            r13 = r4
        L_0x009a:
            r12 = r14
            goto L_0x00ca
        L_0x009c:
            r15 = 93
            if (r14 < r15) goto L_0x00b0
            r15 = 127(0x7f, float:1.78E-43)
            if (r14 < r15) goto L_0x00ca
            r15 = 160(0xa0, float:2.24E-43)
            if (r14 > r15) goto L_0x00ca
            if (r9 != r1) goto L_0x00ab
            r9 = r4
        L_0x00ab:
            int r10 = r10 + 1
            int r6 = r6 + 4
            goto L_0x0099
        L_0x00b0:
            int r15 = r0.f6306d
            boolean r15 = a((char) r14, (int) r15)
            if (r15 == 0) goto L_0x00ca
            int r10 = r10 + 1
            byte[] r12 = com.alibaba.a.d.d.f6362d
            int r12 = r12.length
            if (r14 >= r12) goto L_0x00c7
            byte[] r12 = com.alibaba.a.d.d.f6362d
            byte r12 = r12[r14]
            if (r12 != r5) goto L_0x00c7
            int r6 = r6 + 4
        L_0x00c7:
            if (r9 != r1) goto L_0x0099
            goto L_0x0096
        L_0x00ca:
            int r4 = r4 + 1
            r14 = 34
            goto L_0x0086
        L_0x00cf:
            if (r10 <= 0) goto L_0x0235
            int r6 = r6 + r10
            char[] r1 = r0.f6304a
            int r1 = r1.length
            if (r6 <= r1) goto L_0x00da
            r0.b((int) r6)
        L_0x00da:
            r0.f6305b = r6
            r1 = 92
            if (r10 != r11) goto L_0x0172
            if (r12 != r15) goto L_0x0109
            int r2 = r13 + 1
            int r4 = r13 + 6
            int r3 = r3 - r13
            int r3 = r3 - r11
            char[] r5 = r0.f6304a
            java.lang.System.arraycopy(r5, r2, r5, r4, r3)
            char[] r3 = r0.f6304a
            r3[r13] = r1
            r3[r2] = r7
            int r2 = r2 + r11
            r1 = 50
            r3[r2] = r1
            int r2 = r2 + r11
            r1 = 48
            r3[r2] = r1
            int r2 = r2 + r11
            r1 = 50
            r3[r2] = r1
            int r2 = r2 + r11
            r1 = 56
            r3[r2] = r1
            goto L_0x0235
        L_0x0109:
            byte[] r2 = com.alibaba.a.d.d.f6362d
            int r2 = r2.length
            if (r12 >= r2) goto L_0x015b
            byte[] r2 = com.alibaba.a.d.d.f6362d
            byte r2 = r2[r12]
            if (r2 != r5) goto L_0x015b
            int r2 = r13 + 1
            int r4 = r13 + 6
            int r3 = r3 - r13
            int r3 = r3 - r11
            char[] r5 = r0.f6304a
            java.lang.System.arraycopy(r5, r2, r5, r4, r3)
            char[] r3 = r0.f6304a
            r3[r13] = r1
            int r1 = r2 + 1
            r3[r2] = r7
            int r2 = r1 + 1
            char[] r4 = com.alibaba.a.d.d.f6359a
            int r5 = r12 >>> 12
            r5 = r5 & 15
            char r4 = r4[r5]
            r3[r1] = r4
            char[] r1 = r0.f6304a
            int r3 = r2 + 1
            char[] r4 = com.alibaba.a.d.d.f6359a
            int r5 = r12 >>> 8
            r5 = r5 & 15
            char r4 = r4[r5]
            r1[r2] = r4
            char[] r1 = r0.f6304a
            int r2 = r3 + 1
            char[] r4 = com.alibaba.a.d.d.f6359a
            int r5 = r12 >>> 4
            r5 = r5 & 15
            char r4 = r4[r5]
            r1[r3] = r4
            char[] r1 = r0.f6304a
            char[] r3 = com.alibaba.a.d.d.f6359a
            r4 = r12 & 15
            char r3 = r3[r4]
            r1[r2] = r3
            goto L_0x0235
        L_0x015b:
            int r2 = r13 + 1
            int r4 = r13 + 2
            int r3 = r3 - r13
            int r3 = r3 - r11
            char[] r5 = r0.f6304a
            java.lang.System.arraycopy(r5, r2, r5, r4, r3)
            char[] r3 = r0.f6304a
            r3[r13] = r1
            char[] r1 = com.alibaba.a.d.d.f6364f
            char r1 = r1[r12]
            r3[r2] = r1
            goto L_0x0235
        L_0x0172:
            if (r10 <= r11) goto L_0x0235
            int r3 = r9 - r8
        L_0x0176:
            int r4 = r18.length()
            if (r3 >= r4) goto L_0x0235
            char r4 = r2.charAt(r3)
            byte[] r6 = com.alibaba.a.d.d.f6362d
            int r6 = r6.length
            if (r4 >= r6) goto L_0x018b
            byte[] r6 = com.alibaba.a.d.d.f6362d
            byte r6 = r6[r4]
            if (r6 != 0) goto L_0x0197
        L_0x018b:
            r6 = 47
            if (r4 != r6) goto L_0x01e9
            com.alibaba.a.c.bb r6 = com.alibaba.a.c.bb.WriteSlashAsSpecial
            boolean r6 = r0.b((com.alibaba.a.c.bb) r6)
            if (r6 == 0) goto L_0x01e9
        L_0x0197:
            char[] r6 = r0.f6304a
            int r8 = r9 + 1
            r6[r9] = r1
            byte[] r6 = com.alibaba.a.d.d.f6362d
            byte r6 = r6[r4]
            if (r6 != r5) goto L_0x01de
            char[] r6 = r0.f6304a
            int r9 = r8 + 1
            r6[r8] = r7
            int r8 = r9 + 1
            char[] r10 = com.alibaba.a.d.d.f6359a
            int r12 = r4 >>> 12
            r12 = r12 & 15
            char r10 = r10[r12]
            r6[r9] = r10
            char[] r6 = r0.f6304a
            int r9 = r8 + 1
            char[] r10 = com.alibaba.a.d.d.f6359a
            int r12 = r4 >>> 8
            r12 = r12 & 15
            char r10 = r10[r12]
            r6[r8] = r10
            char[] r6 = r0.f6304a
            int r8 = r9 + 1
            char[] r10 = com.alibaba.a.d.d.f6359a
            int r12 = r4 >>> 4
            r12 = r12 & 15
            char r10 = r10[r12]
            r6[r9] = r10
            char[] r6 = r0.f6304a
            int r9 = r8 + 1
            char[] r10 = com.alibaba.a.d.d.f6359a
            r4 = r4 & 15
            char r4 = r10[r4]
            r6[r8] = r4
            goto L_0x0231
        L_0x01de:
            char[] r6 = r0.f6304a
            int r9 = r8 + 1
            char[] r10 = com.alibaba.a.d.d.f6364f
            char r4 = r10[r4]
            r6[r8] = r4
            goto L_0x0231
        L_0x01e9:
            if (r4 != r15) goto L_0x022a
            char[] r6 = r0.f6304a
            int r8 = r9 + 1
            r6[r9] = r1
            int r9 = r8 + 1
            r6[r8] = r7
            int r8 = r9 + 1
            char[] r10 = com.alibaba.a.d.d.f6359a
            int r12 = r4 >>> 12
            r12 = r12 & 15
            char r10 = r10[r12]
            r6[r9] = r10
            char[] r6 = r0.f6304a
            int r9 = r8 + 1
            char[] r10 = com.alibaba.a.d.d.f6359a
            int r12 = r4 >>> 8
            r12 = r12 & 15
            char r10 = r10[r12]
            r6[r8] = r10
            char[] r6 = r0.f6304a
            int r8 = r9 + 1
            char[] r10 = com.alibaba.a.d.d.f6359a
            int r12 = r4 >>> 4
            r12 = r12 & 15
            char r10 = r10[r12]
            r6[r9] = r10
            char[] r6 = r0.f6304a
            int r9 = r8 + 1
            char[] r10 = com.alibaba.a.d.d.f6359a
            r4 = r4 & 15
            char r4 = r10[r4]
            r6[r8] = r4
            goto L_0x0231
        L_0x022a:
            char[] r6 = r0.f6304a
            int r8 = r9 + 1
            r6[r9] = r4
            r9 = r8
        L_0x0231:
            int r3 = r3 + 1
            goto L_0x0176
        L_0x0235:
            char[] r1 = r0.f6304a
            int r2 = r0.f6305b
            int r2 = r2 - r11
            r3 = 34
            r1[r2] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.c.ba.a(java.lang.String, java.lang.String):void");
    }

    private static boolean a(char c2, int i2) {
        if (c2 == ' ') {
            return false;
        }
        if (c2 == '/' && bb.isEnabled(i2, bb.WriteSlashAsSpecial)) {
            return true;
        }
        if (c2 <= '#' || c2 == '\\') {
            return c2 <= 31 || c2 == '\\' || c2 == '\"';
        }
        return false;
    }

    public final void b(String str) {
        if (b(bb.UseSingleQuotes)) {
            c(str);
        } else {
            a(str, 0, true);
        }
    }

    private void c(String str) {
        int i2 = 0;
        if (str == null) {
            int i3 = this.f6305b + 4;
            if (i3 > this.f6304a.length) {
                b(i3);
            }
            "null".getChars(0, 4, this.f6304a, this.f6305b);
            this.f6305b = i3;
            return;
        }
        int length = str.length();
        int i4 = this.f6305b + length + 2;
        if (i4 > this.f6304a.length) {
            if (this.f6307e != null) {
                a('\'');
                while (i2 < str.length()) {
                    char charAt = str.charAt(i2);
                    if (charAt <= 13 || charAt == '\\' || charAt == '\'' || (charAt == '/' && b(bb.WriteSlashAsSpecial))) {
                        a('\\');
                        a(com.alibaba.a.d.d.f6364f[charAt]);
                    } else {
                        a(charAt);
                    }
                    i2++;
                }
                a('\'');
                return;
            }
            b(i4);
        }
        int i5 = this.f6305b;
        int i6 = i5 + 1;
        int i7 = i6 + length;
        char[] cArr = this.f6304a;
        cArr[i5] = '\'';
        str.getChars(0, length, cArr, i6);
        this.f6305b = i4;
        int i8 = -1;
        char c2 = 0;
        for (int i9 = i6; i9 < i7; i9++) {
            char c3 = this.f6304a[i9];
            if (c3 <= 13 || c3 == '\\' || c3 == '\'' || (c3 == '/' && b(bb.WriteSlashAsSpecial))) {
                i2++;
                i8 = i9;
                c2 = c3;
            }
        }
        int i10 = i4 + i2;
        if (i10 > this.f6304a.length) {
            b(i10);
        }
        this.f6305b = i10;
        if (i2 == 1) {
            char[] cArr2 = this.f6304a;
            int i11 = i8 + 1;
            System.arraycopy(cArr2, i11, cArr2, i8 + 2, (i7 - i8) - 1);
            char[] cArr3 = this.f6304a;
            cArr3[i8] = '\\';
            cArr3[i11] = com.alibaba.a.d.d.f6364f[c2];
        } else if (i2 > 1) {
            char[] cArr4 = this.f6304a;
            int i12 = i8 + 1;
            System.arraycopy(cArr4, i12, cArr4, i8 + 2, (i7 - i8) - 1);
            char[] cArr5 = this.f6304a;
            cArr5[i8] = '\\';
            cArr5[i12] = com.alibaba.a.d.d.f6364f[c2];
            int i13 = i7 + 1;
            for (int i14 = i12 - 2; i14 >= i6; i14--) {
                char c4 = this.f6304a[i14];
                if (c4 <= 13 || c4 == '\\' || c4 == '\'' || (c4 == '/' && b(bb.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.f6304a;
                    int i15 = i14 + 1;
                    System.arraycopy(cArr6, i15, cArr6, i14 + 2, (i13 - i14) - 1);
                    char[] cArr7 = this.f6304a;
                    cArr7[i14] = '\\';
                    cArr7[i15] = com.alibaba.a.d.d.f6364f[c4];
                    i13++;
                }
            }
        }
        this.f6304a[this.f6305b - 1] = '\'';
    }

    public final void a(String str, boolean z) {
        if (str == null) {
            write("null:");
        } else if (b(bb.UseSingleQuotes)) {
            if (b(bb.QuoteFieldNames)) {
                c(str);
                a(':');
                return;
            }
            e(str);
        } else if (b(bb.QuoteFieldNames)) {
            a(str, ':', z);
        } else {
            d(str);
        }
    }

    private void d(String str) {
        int i2;
        String str2 = str;
        byte[] bArr = com.alibaba.a.d.d.f6362d;
        int length = str.length();
        boolean z = true;
        int i3 = this.f6305b + length + 1;
        int i4 = 0;
        if (i3 > this.f6304a.length) {
            if (this.f6307e == null) {
                b(i3);
            } else if (length == 0) {
                a('\"');
                a('\"');
                a(':');
                return;
            } else {
                int i5 = 0;
                while (true) {
                    if (i5 < length) {
                        char charAt = str2.charAt(i5);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        }
                        i5++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    a('\"');
                }
                while (i4 < length) {
                    char charAt2 = str2.charAt(i4);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        a(charAt2);
                    } else {
                        a('\\');
                        a(com.alibaba.a.d.d.f6364f[charAt2]);
                    }
                    i4++;
                }
                if (z) {
                    a('\"');
                }
                a(':');
                return;
            }
        }
        if (length == 0) {
            int i6 = this.f6305b;
            if (i6 + 3 > this.f6304a.length) {
                b(i6 + 3);
            }
            char[] cArr = this.f6304a;
            int i7 = this.f6305b;
            this.f6305b = i7 + 1;
            cArr[i7] = '\"';
            int i8 = this.f6305b;
            this.f6305b = i8 + 1;
            cArr[i8] = '\"';
            int i9 = this.f6305b;
            this.f6305b = i9 + 1;
            cArr[i9] = ':';
            return;
        }
        int i10 = this.f6305b;
        int i11 = i10 + length;
        str2.getChars(0, length, this.f6304a, i10);
        this.f6305b = i3;
        int i12 = i10;
        boolean z2 = false;
        while (i12 < i11) {
            char[] cArr2 = this.f6304a;
            char c2 = cArr2[i12];
            if (c2 >= bArr.length || bArr[c2] == 0) {
                i2 = i12;
            } else if (!z2) {
                i3 += 3;
                if (i3 > cArr2.length) {
                    b(i3);
                }
                this.f6305b = i3;
                char[] cArr3 = this.f6304a;
                int i13 = i12 + 1;
                System.arraycopy(cArr3, i13, cArr3, i12 + 3, (i11 - i12) - 1);
                char[] cArr4 = this.f6304a;
                System.arraycopy(cArr4, i4, cArr4, 1, i12);
                char[] cArr5 = this.f6304a;
                cArr5[i10] = '\"';
                cArr5[i13] = '\\';
                int i14 = i13 + 1;
                cArr5[i14] = com.alibaba.a.d.d.f6364f[c2];
                i11 += 2;
                this.f6304a[this.f6305b - 2] = '\"';
                i2 = i14;
                z2 = true;
            } else {
                i3++;
                if (i3 > cArr2.length) {
                    b(i3);
                }
                this.f6305b = i3;
                char[] cArr6 = this.f6304a;
                i2 = i12 + 1;
                System.arraycopy(cArr6, i2, cArr6, i12 + 2, i11 - i12);
                char[] cArr7 = this.f6304a;
                cArr7[i12] = '\\';
                cArr7[i2] = com.alibaba.a.d.d.f6364f[c2];
                i11++;
            }
            i12 = i2 + 1;
            i4 = 0;
        }
        this.f6304a[this.f6305b - 1] = ':';
    }

    private void e(String str) {
        int i2;
        String str2 = str;
        byte[] bArr = com.alibaba.a.d.d.f6363e;
        int length = str.length();
        boolean z = true;
        int i3 = this.f6305b + length + 1;
        int i4 = 0;
        if (i3 > this.f6304a.length) {
            if (this.f6307e == null) {
                b(i3);
            } else if (length == 0) {
                a('\'');
                a('\'');
                a(':');
                return;
            } else {
                int i5 = 0;
                while (true) {
                    if (i5 < length) {
                        char charAt = str2.charAt(i5);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        }
                        i5++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    a('\'');
                }
                while (i4 < length) {
                    char charAt2 = str2.charAt(i4);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        a(charAt2);
                    } else {
                        a('\\');
                        a(com.alibaba.a.d.d.f6364f[charAt2]);
                    }
                    i4++;
                }
                if (z) {
                    a('\'');
                }
                a(':');
                return;
            }
        }
        if (length == 0) {
            int i6 = this.f6305b;
            if (i6 + 3 > this.f6304a.length) {
                b(i6 + 3);
            }
            char[] cArr = this.f6304a;
            int i7 = this.f6305b;
            this.f6305b = i7 + 1;
            cArr[i7] = '\'';
            int i8 = this.f6305b;
            this.f6305b = i8 + 1;
            cArr[i8] = '\'';
            int i9 = this.f6305b;
            this.f6305b = i9 + 1;
            cArr[i9] = ':';
            return;
        }
        int i10 = this.f6305b;
        int i11 = i10 + length;
        str2.getChars(0, length, this.f6304a, i10);
        this.f6305b = i3;
        int i12 = i10;
        boolean z2 = false;
        while (i12 < i11) {
            char[] cArr2 = this.f6304a;
            char c2 = cArr2[i12];
            if (c2 >= bArr.length || bArr[c2] == 0) {
                i2 = i12;
            } else if (!z2) {
                i3 += 3;
                if (i3 > cArr2.length) {
                    b(i3);
                }
                this.f6305b = i3;
                char[] cArr3 = this.f6304a;
                int i13 = i12 + 1;
                System.arraycopy(cArr3, i13, cArr3, i12 + 3, (i11 - i12) - 1);
                char[] cArr4 = this.f6304a;
                System.arraycopy(cArr4, i4, cArr4, 1, i12);
                char[] cArr5 = this.f6304a;
                cArr5[i10] = '\'';
                cArr5[i13] = '\\';
                int i14 = i13 + 1;
                cArr5[i14] = com.alibaba.a.d.d.f6364f[c2];
                i11 += 2;
                this.f6304a[this.f6305b - 2] = '\'';
                i2 = i14;
                z2 = true;
            } else {
                i3++;
                if (i3 > cArr2.length) {
                    b(i3);
                }
                this.f6305b = i3;
                char[] cArr6 = this.f6304a;
                i2 = i12 + 1;
                System.arraycopy(cArr6, i2, cArr6, i12 + 2, i11 - i12);
                char[] cArr7 = this.f6304a;
                cArr7[i12] = '\\';
                cArr7[i2] = com.alibaba.a.d.d.f6364f[c2];
                i11++;
            }
            i12 = i2 + 1;
            i4 = 0;
        }
        this.f6304a[i3 - 1] = ':';
    }

    public final void flush() {
        Writer writer = this.f6307e;
        if (writer != null) {
            try {
                writer.write(this.f6304a, 0, this.f6305b);
                this.f6307e.flush();
                this.f6305b = 0;
            } catch (IOException e2) {
                throw new d(e2.getMessage(), e2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0256, code lost:
        if (r11 == -1) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0287, code lost:
        if (r11 == -1) goto L_0x0258;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r18, char r19, boolean r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            if (r1 != 0) goto L_0x0013
            java.lang.String r1 = "null"
            r0.write((java.lang.String) r1)
            if (r2 == 0) goto L_0x0012
            r0.a((char) r2)
        L_0x0012:
            return
        L_0x0013:
            int r3 = r18.length()
            int r4 = r0.f6305b
            int r4 = r4 + r3
            int r4 = r4 + 2
            if (r2 == 0) goto L_0x0020
            int r4 = r4 + 1
        L_0x0020:
            char[] r5 = r0.f6304a
            int r5 = r5.length
            r6 = 127(0x7f, float:1.78E-43)
            r7 = 0
            r8 = 48
            r9 = 47
            r10 = 117(0x75, float:1.64E-43)
            r11 = 12
            r12 = 8
            r13 = 34
            r14 = 92
            r15 = 1
            if (r4 <= r5) goto L_0x00fa
            java.io.Writer r5 = r0.f6307e
            if (r5 == 0) goto L_0x00f7
            r0.a((char) r13)
        L_0x003e:
            int r3 = r18.length()
            if (r7 >= r3) goto L_0x00ee
            char r3 = r1.charAt(r7)
            com.alibaba.a.c.bb r4 = com.alibaba.a.c.bb.BrowserCompatible
            boolean r4 = r0.b((com.alibaba.a.c.bb) r4)
            if (r4 == 0) goto L_0x00c7
            if (r3 == r12) goto L_0x00bc
            if (r3 == r11) goto L_0x00bc
            r4 = 10
            if (r3 == r4) goto L_0x00bc
            r4 = 13
            if (r3 == r4) goto L_0x00bc
            r4 = 9
            if (r3 == r4) goto L_0x00bc
            if (r3 == r13) goto L_0x00bc
            if (r3 == r9) goto L_0x00bc
            if (r3 != r14) goto L_0x0067
            goto L_0x00bc
        L_0x0067:
            r4 = 32
            if (r3 >= r4) goto L_0x0089
            r0.a((char) r14)
            r0.a((char) r10)
            r0.a((char) r8)
            r0.a((char) r8)
            char[] r4 = com.alibaba.a.d.d.f6365g
            int r3 = r3 * 2
            char r4 = r4[r3]
            r0.a((char) r4)
            char[] r4 = com.alibaba.a.d.d.f6365g
            int r3 = r3 + r15
            char r3 = r4[r3]
            r0.a((char) r3)
            goto L_0x00ea
        L_0x0089:
            if (r3 < r6) goto L_0x00e7
            r0.a((char) r14)
            r0.a((char) r10)
            char[] r4 = com.alibaba.a.d.d.f6359a
            int r5 = r3 >>> 12
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.a((char) r4)
            char[] r4 = com.alibaba.a.d.d.f6359a
            int r5 = r3 >>> 8
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.a((char) r4)
            char[] r4 = com.alibaba.a.d.d.f6359a
            int r5 = r3 >>> 4
            r5 = r5 & 15
            char r4 = r4[r5]
            r0.a((char) r4)
            char[] r4 = com.alibaba.a.d.d.f6359a
            r3 = r3 & 15
            char r3 = r4[r3]
            r0.a((char) r3)
            goto L_0x00ea
        L_0x00bc:
            r0.a((char) r14)
            char[] r4 = com.alibaba.a.d.d.f6364f
            char r3 = r4[r3]
            r0.a((char) r3)
            goto L_0x00ea
        L_0x00c7:
            byte[] r4 = com.alibaba.a.d.d.f6362d
            int r4 = r4.length
            if (r3 >= r4) goto L_0x00d2
            byte[] r4 = com.alibaba.a.d.d.f6362d
            byte r4 = r4[r3]
            if (r4 != 0) goto L_0x00dc
        L_0x00d2:
            if (r3 != r9) goto L_0x00e7
            com.alibaba.a.c.bb r4 = com.alibaba.a.c.bb.WriteSlashAsSpecial
            boolean r4 = r0.b((com.alibaba.a.c.bb) r4)
            if (r4 == 0) goto L_0x00e7
        L_0x00dc:
            r0.a((char) r14)
            char[] r4 = com.alibaba.a.d.d.f6364f
            char r3 = r4[r3]
            r0.a((char) r3)
            goto L_0x00ea
        L_0x00e7:
            r0.a((char) r3)
        L_0x00ea:
            int r7 = r7 + 1
            goto L_0x003e
        L_0x00ee:
            r0.a((char) r13)
            if (r2 == 0) goto L_0x00f6
            r0.a((char) r2)
        L_0x00f6:
            return
        L_0x00f7:
            r0.b((int) r4)
        L_0x00fa:
            int r5 = r0.f6305b
            int r8 = r5 + 1
            int r10 = r8 + r3
            char[] r15 = r0.f6304a
            r15[r5] = r13
            r1.getChars(r7, r3, r15, r8)
            r0.f6305b = r4
            com.alibaba.a.c.bb r3 = com.alibaba.a.c.bb.BrowserCompatible
            boolean r3 = r0.b((com.alibaba.a.c.bb) r3)
            r5 = -1
            if (r3 == 0) goto L_0x0241
            r1 = r8
        L_0x0113:
            if (r1 >= r10) goto L_0x0141
            char[] r3 = r0.f6304a
            char r3 = r3[r1]
            if (r3 == r13) goto L_0x013b
            if (r3 == r9) goto L_0x013b
            if (r3 != r14) goto L_0x0120
            goto L_0x013b
        L_0x0120:
            if (r3 == r12) goto L_0x013b
            if (r3 == r11) goto L_0x013b
            r7 = 10
            if (r3 == r7) goto L_0x013b
            r7 = 13
            if (r3 == r7) goto L_0x013b
            r7 = 9
            if (r3 != r7) goto L_0x0131
            goto L_0x013b
        L_0x0131:
            r7 = 32
            if (r3 >= r7) goto L_0x0138
        L_0x0135:
            int r4 = r4 + 5
            goto L_0x013d
        L_0x0138:
            if (r3 < r6) goto L_0x013e
            goto L_0x0135
        L_0x013b:
            int r4 = r4 + 1
        L_0x013d:
            r5 = r1
        L_0x013e:
            int r1 = r1 + 1
            goto L_0x0113
        L_0x0141:
            char[] r1 = r0.f6304a
            int r1 = r1.length
            if (r4 <= r1) goto L_0x0149
            r0.b((int) r4)
        L_0x0149:
            r0.f6305b = r4
        L_0x014b:
            if (r5 < r8) goto L_0x0229
            char[] r1 = r0.f6304a
            char r3 = r1[r5]
            if (r3 == r12) goto L_0x020a
            if (r3 == r11) goto L_0x020a
            r4 = 10
            if (r3 == r4) goto L_0x020a
            r4 = 13
            if (r3 == r4) goto L_0x020a
            r4 = 9
            if (r3 != r4) goto L_0x0163
            goto L_0x020a
        L_0x0163:
            if (r3 == r13) goto L_0x01f4
            if (r3 == r9) goto L_0x01f4
            if (r3 != r14) goto L_0x016b
            goto L_0x01f4
        L_0x016b:
            r4 = 32
            if (r3 >= r4) goto L_0x01a8
            int r4 = r5 + 1
            int r7 = r5 + 6
            int r15 = r10 - r5
            r16 = 1
            int r15 = r15 + -1
            java.lang.System.arraycopy(r1, r4, r1, r7, r15)
            char[] r1 = r0.f6304a
            r1[r5] = r14
            r7 = 117(0x75, float:1.64E-43)
            r1[r4] = r7
            int r4 = r5 + 2
            r7 = 48
            r1[r4] = r7
            int r4 = r5 + 3
            r1[r4] = r7
            int r4 = r5 + 4
            char[] r7 = com.alibaba.a.d.d.f6365g
            int r3 = r3 * 2
            char r7 = r7[r3]
            r1[r4] = r7
            char[] r1 = r0.f6304a
            int r4 = r5 + 5
            char[] r7 = com.alibaba.a.d.d.f6365g
            r15 = 1
            int r3 = r3 + r15
            char r3 = r7[r3]
            r1[r4] = r3
        L_0x01a4:
            int r10 = r10 + 5
            goto L_0x0225
        L_0x01a8:
            if (r3 < r6) goto L_0x0225
            int r4 = r5 + 1
            int r7 = r5 + 6
            int r15 = r10 - r5
            r16 = 1
            int r15 = r15 + -1
            java.lang.System.arraycopy(r1, r4, r1, r7, r15)
            char[] r1 = r0.f6304a
            r1[r5] = r14
            r7 = 117(0x75, float:1.64E-43)
            r1[r4] = r7
            int r4 = r5 + 2
            char[] r7 = com.alibaba.a.d.d.f6359a
            int r15 = r3 >>> 12
            r15 = r15 & 15
            char r7 = r7[r15]
            r1[r4] = r7
            char[] r1 = r0.f6304a
            int r4 = r5 + 3
            char[] r7 = com.alibaba.a.d.d.f6359a
            int r15 = r3 >>> 8
            r15 = r15 & 15
            char r7 = r7[r15]
            r1[r4] = r7
            char[] r1 = r0.f6304a
            int r4 = r5 + 4
            char[] r7 = com.alibaba.a.d.d.f6359a
            int r15 = r3 >>> 4
            r15 = r15 & 15
            char r7 = r7[r15]
            r1[r4] = r7
            char[] r1 = r0.f6304a
            int r4 = r5 + 5
            char[] r7 = com.alibaba.a.d.d.f6359a
            r3 = r3 & 15
            char r3 = r7[r3]
            r1[r4] = r3
            goto L_0x01a4
        L_0x01f4:
            char[] r1 = r0.f6304a
            int r4 = r5 + 1
            int r7 = r5 + 2
            int r15 = r10 - r5
            r16 = 1
            int r15 = r15 + -1
            java.lang.System.arraycopy(r1, r4, r1, r7, r15)
            char[] r1 = r0.f6304a
            r1[r5] = r14
            r1[r4] = r3
            goto L_0x0223
        L_0x020a:
            char[] r1 = r0.f6304a
            int r4 = r5 + 1
            int r7 = r5 + 2
            int r15 = r10 - r5
            r16 = 1
            int r15 = r15 + -1
            java.lang.System.arraycopy(r1, r4, r1, r7, r15)
            char[] r1 = r0.f6304a
            r1[r5] = r14
            char[] r7 = com.alibaba.a.d.d.f6364f
            char r3 = r7[r3]
            r1[r4] = r3
        L_0x0223:
            int r10 = r10 + 1
        L_0x0225:
            int r5 = r5 + -1
            goto L_0x014b
        L_0x0229:
            if (r2 == 0) goto L_0x0238
            char[] r1 = r0.f6304a
            int r3 = r0.f6305b
            int r4 = r3 + -2
            r1[r4] = r13
            r4 = 1
            int r3 = r3 - r4
            r1[r3] = r2
            return
        L_0x0238:
            r4 = 1
            char[] r1 = r0.f6304a
            int r2 = r0.f6305b
            int r2 = r2 - r4
            r1[r2] = r13
            return
        L_0x0241:
            if (r20 == 0) goto L_0x041d
            r3 = r8
            r11 = -1
            r12 = 0
            r15 = -1
        L_0x0247:
            r13 = 4
            if (r3 >= r10) goto L_0x0291
            char[] r9 = r0.f6304a
            char r9 = r9[r3]
            r14 = 8232(0x2028, float:1.1535E-41)
            if (r9 != r14) goto L_0x025e
            int r7 = r7 + 1
            int r4 = r4 + 4
            if (r11 != r5) goto L_0x025b
        L_0x0258:
            r11 = r3
            r15 = r11
            goto L_0x025c
        L_0x025b:
            r15 = r3
        L_0x025c:
            r12 = r9
            goto L_0x028a
        L_0x025e:
            r14 = 93
            if (r9 < r14) goto L_0x0270
            if (r9 < r6) goto L_0x028a
            r13 = 160(0xa0, float:2.24E-43)
            if (r9 > r13) goto L_0x028a
            if (r11 != r5) goto L_0x026b
            r11 = r3
        L_0x026b:
            int r7 = r7 + 1
            int r4 = r4 + 4
            goto L_0x025b
        L_0x0270:
            int r14 = r0.f6306d
            boolean r14 = a((char) r9, (int) r14)
            if (r14 == 0) goto L_0x028a
            int r7 = r7 + 1
            byte[] r12 = com.alibaba.a.d.d.f6362d
            int r12 = r12.length
            if (r9 >= r12) goto L_0x0287
            byte[] r12 = com.alibaba.a.d.d.f6362d
            byte r12 = r12[r9]
            if (r12 != r13) goto L_0x0287
            int r4 = r4 + 4
        L_0x0287:
            if (r11 != r5) goto L_0x025b
            goto L_0x0258
        L_0x028a:
            int r3 = r3 + 1
            r9 = 47
            r14 = 92
            goto L_0x0247
        L_0x0291:
            if (r7 <= 0) goto L_0x041d
            int r4 = r4 + r7
            char[] r3 = r0.f6304a
            int r3 = r3.length
            if (r4 <= r3) goto L_0x029c
            r0.b((int) r4)
        L_0x029c:
            r0.f6305b = r4
            r3 = 1
            if (r7 != r3) goto L_0x0341
            r1 = 8232(0x2028, float:1.1535E-41)
            if (r12 != r1) goto L_0x02d0
            int r1 = r15 + 1
            int r4 = r15 + 6
            int r10 = r10 - r15
            int r10 = r10 - r3
            char[] r5 = r0.f6304a
            java.lang.System.arraycopy(r5, r1, r5, r4, r10)
            char[] r4 = r0.f6304a
            r5 = 92
            r4[r15] = r5
            r5 = 117(0x75, float:1.64E-43)
            r4[r1] = r5
            int r1 = r1 + r3
            r5 = 50
            r4[r1] = r5
            int r1 = r1 + r3
            r5 = 48
            r4[r1] = r5
            int r1 = r1 + r3
            r5 = 50
            r4[r1] = r5
            int r1 = r1 + r3
            r3 = 56
            r4[r1] = r3
            goto L_0x041d
        L_0x02d0:
            byte[] r1 = com.alibaba.a.d.d.f6362d
            int r1 = r1.length
            if (r12 >= r1) goto L_0x0327
            byte[] r1 = com.alibaba.a.d.d.f6362d
            byte r1 = r1[r12]
            if (r1 != r13) goto L_0x0327
            int r1 = r15 + 1
            int r3 = r15 + 6
            int r10 = r10 - r15
            r4 = 1
            int r10 = r10 - r4
            char[] r4 = r0.f6304a
            java.lang.System.arraycopy(r4, r1, r4, r3, r10)
            char[] r3 = r0.f6304a
            r4 = 92
            r3[r15] = r4
            int r4 = r1 + 1
            r5 = 117(0x75, float:1.64E-43)
            r3[r1] = r5
            int r1 = r4 + 1
            char[] r5 = com.alibaba.a.d.d.f6359a
            int r6 = r12 >>> 12
            r6 = r6 & 15
            char r5 = r5[r6]
            r3[r4] = r5
            char[] r3 = r0.f6304a
            int r4 = r1 + 1
            char[] r5 = com.alibaba.a.d.d.f6359a
            int r6 = r12 >>> 8
            r6 = r6 & 15
            char r5 = r5[r6]
            r3[r1] = r5
            char[] r1 = r0.f6304a
            int r3 = r4 + 1
            char[] r5 = com.alibaba.a.d.d.f6359a
            int r6 = r12 >>> 4
            r6 = r6 & 15
            char r5 = r5[r6]
            r1[r4] = r5
            char[] r1 = r0.f6304a
            char[] r4 = com.alibaba.a.d.d.f6359a
            r5 = r12 & 15
            char r4 = r4[r5]
            r1[r3] = r4
            goto L_0x041d
        L_0x0327:
            int r1 = r15 + 1
            int r3 = r15 + 2
            int r10 = r10 - r15
            r4 = 1
            int r10 = r10 - r4
            char[] r5 = r0.f6304a
            java.lang.System.arraycopy(r5, r1, r5, r3, r10)
            char[] r3 = r0.f6304a
            r5 = 92
            r3[r15] = r5
            char[] r5 = com.alibaba.a.d.d.f6364f
            char r5 = r5[r12]
            r3[r1] = r5
            goto L_0x041d
        L_0x0341:
            r4 = 1
            if (r7 <= r4) goto L_0x041d
            int r3 = r11 - r8
        L_0x0346:
            int r4 = r18.length()
            if (r3 >= r4) goto L_0x041d
            char r4 = r1.charAt(r3)
            byte[] r5 = com.alibaba.a.d.d.f6362d
            int r5 = r5.length
            if (r4 >= r5) goto L_0x035f
            byte[] r5 = com.alibaba.a.d.d.f6362d
            byte r5 = r5[r4]
            if (r5 != 0) goto L_0x035c
            goto L_0x035f
        L_0x035c:
            r5 = 47
            goto L_0x036b
        L_0x035f:
            r5 = 47
            if (r4 != r5) goto L_0x03c6
            com.alibaba.a.c.bb r6 = com.alibaba.a.c.bb.WriteSlashAsSpecial
            boolean r6 = r0.b((com.alibaba.a.c.bb) r6)
            if (r6 == 0) goto L_0x03c6
        L_0x036b:
            char[] r6 = r0.f6304a
            int r7 = r11 + 1
            r8 = 92
            r6[r11] = r8
            byte[] r6 = com.alibaba.a.d.d.f6362d
            byte r6 = r6[r4]
            if (r6 != r13) goto L_0x03b6
            char[] r6 = r0.f6304a
            int r8 = r7 + 1
            r9 = 117(0x75, float:1.64E-43)
            r6[r7] = r9
            int r7 = r8 + 1
            char[] r9 = com.alibaba.a.d.d.f6359a
            int r10 = r4 >>> 12
            r10 = r10 & 15
            char r9 = r9[r10]
            r6[r8] = r9
            char[] r6 = r0.f6304a
            int r8 = r7 + 1
            char[] r9 = com.alibaba.a.d.d.f6359a
            int r10 = r4 >>> 8
            r10 = r10 & 15
            char r9 = r9[r10]
            r6[r7] = r9
            char[] r6 = r0.f6304a
            int r7 = r8 + 1
            char[] r9 = com.alibaba.a.d.d.f6359a
            int r10 = r4 >>> 4
            r10 = r10 & 15
            char r9 = r9[r10]
            r6[r8] = r9
            char[] r6 = r0.f6304a
            int r8 = r7 + 1
            char[] r9 = com.alibaba.a.d.d.f6359a
            r4 = r4 & 15
            char r4 = r9[r4]
            r6[r7] = r4
            goto L_0x03c0
        L_0x03b6:
            char[] r6 = r0.f6304a
            int r8 = r7 + 1
            char[] r9 = com.alibaba.a.d.d.f6364f
            char r4 = r9[r4]
            r6[r7] = r4
        L_0x03c0:
            r11 = r8
            r8 = 92
            r10 = 117(0x75, float:1.64E-43)
            goto L_0x0419
        L_0x03c6:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r4 != r6) goto L_0x040e
            char[] r6 = r0.f6304a
            int r7 = r11 + 1
            r8 = 92
            r6[r11] = r8
            int r9 = r7 + 1
            r10 = 117(0x75, float:1.64E-43)
            r6[r7] = r10
            int r7 = r9 + 1
            char[] r11 = com.alibaba.a.d.d.f6359a
            int r12 = r4 >>> 12
            r12 = r12 & 15
            char r11 = r11[r12]
            r6[r9] = r11
            char[] r6 = r0.f6304a
            int r9 = r7 + 1
            char[] r11 = com.alibaba.a.d.d.f6359a
            int r12 = r4 >>> 8
            r12 = r12 & 15
            char r11 = r11[r12]
            r6[r7] = r11
            char[] r6 = r0.f6304a
            int r7 = r9 + 1
            char[] r11 = com.alibaba.a.d.d.f6359a
            int r12 = r4 >>> 4
            r12 = r12 & 15
            char r11 = r11[r12]
            r6[r9] = r11
            char[] r6 = r0.f6304a
            int r9 = r7 + 1
            char[] r11 = com.alibaba.a.d.d.f6359a
            r4 = r4 & 15
            char r4 = r11[r4]
            r6[r7] = r4
            r11 = r9
            goto L_0x0419
        L_0x040e:
            r8 = 92
            r10 = 117(0x75, float:1.64E-43)
            char[] r6 = r0.f6304a
            int r7 = r11 + 1
            r6[r11] = r4
            r11 = r7
        L_0x0419:
            int r3 = r3 + 1
            goto L_0x0346
        L_0x041d:
            if (r2 == 0) goto L_0x042e
            char[] r1 = r0.f6304a
            int r3 = r0.f6305b
            int r4 = r3 + -2
            r5 = 34
            r1[r4] = r5
            r4 = 1
            int r3 = r3 - r4
            r1[r3] = r2
            return
        L_0x042e:
            r4 = 1
            r5 = 34
            char[] r1 = r0.f6304a
            int r2 = r0.f6305b
            int r2 = r2 - r4
            r1[r2] = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.c.ba.a(java.lang.String, char, boolean):void");
    }
}
