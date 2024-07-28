package com.google.android.exoplayer2.g;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f32546a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f32547b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c  reason: collision with root package name */
    private static final Object f32548c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static int[] f32549d = new int[10];

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f32553a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32554b;

        /* renamed from: c  reason: collision with root package name */
        public final int f32555c;

        /* renamed from: d  reason: collision with root package name */
        public final int f32556d;

        /* renamed from: e  reason: collision with root package name */
        public final int f32557e;

        /* renamed from: f  reason: collision with root package name */
        public final int f32558f;

        /* renamed from: g  reason: collision with root package name */
        public final float f32559g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f32560h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f32561i;
        public final int j;
        public final int k;
        public final int l;
        public final boolean m;

        public b(int i2, int i3, int i4, int i5, int i6, int i7, float f2, boolean z, boolean z2, int i8, int i9, int i10, boolean z3) {
            this.f32553a = i2;
            this.f32554b = i3;
            this.f32555c = i4;
            this.f32556d = i5;
            this.f32557e = i6;
            this.f32558f = i7;
            this.f32559g = f2;
            this.f32560h = z;
            this.f32561i = z2;
            this.j = i8;
            this.k = i9;
            this.l = i10;
            this.m = z3;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f32550a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32551b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32552c;

        public a(int i2, int i3, boolean z) {
            this.f32550a = i2;
            this.f32551b = i3;
            this.f32552c = z;
        }
    }

    public static int a(byte[] bArr, int i2) {
        int i3;
        synchronized (f32548c) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                while (true) {
                    if (i4 < i2 - 2) {
                        if (bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 3) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = i2;
                        break;
                    }
                }
                if (i4 < i2) {
                    if (f32549d.length <= i5) {
                        int[] iArr = f32549d;
                        f32549d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f32549d[i5] = i4;
                    i4 += 3;
                    i5++;
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = f32549d[i8] - i7;
                System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i11 + 1;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
        }
        return i3;
    }

    public static void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 < position) {
                byte b2 = byteBuffer.get(i2) & 255;
                if (i3 == 3) {
                    if (b2 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i2 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b2 == 0) {
                    i3++;
                }
                if (b2 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean a(String str, byte b2) {
        if ((!"video/avc".equals(str) || (b2 & 31) != 6) && (!"video/hevc".equals(str) || ((b2 & 126) >> 1) != 39)) {
            return false;
        }
        return true;
    }

    public static int b(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    public static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0164  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.g.p.b a(byte[] r21, int r22, int r23) {
        /*
            com.google.android.exoplayer2.g.s r0 = new com.google.android.exoplayer2.g.s
            r1 = r21
            r2 = r22
            r3 = r23
            r0.<init>(r1, r2, r3)
            r1 = 8
            r0.a(r1)
            int r3 = r0.c(r1)
            int r4 = r0.c(r1)
            int r5 = r0.c(r1)
            int r6 = r0.e()
            r2 = 3
            r7 = 16
            r9 = 1
            r10 = 100
            if (r3 == r10) goto L_0x0050
            r10 = 110(0x6e, float:1.54E-43)
            if (r3 == r10) goto L_0x0050
            r10 = 122(0x7a, float:1.71E-43)
            if (r3 == r10) goto L_0x0050
            r10 = 244(0xf4, float:3.42E-43)
            if (r3 == r10) goto L_0x0050
            r10 = 44
            if (r3 == r10) goto L_0x0050
            r10 = 83
            if (r3 == r10) goto L_0x0050
            r10 = 86
            if (r3 == r10) goto L_0x0050
            r10 = 118(0x76, float:1.65E-43)
            if (r3 == r10) goto L_0x0050
            r10 = 128(0x80, float:1.794E-43)
            if (r3 == r10) goto L_0x0050
            r10 = 138(0x8a, float:1.93E-43)
            if (r3 != r10) goto L_0x004d
            goto L_0x0050
        L_0x004d:
            r10 = 1
            r11 = 0
            goto L_0x00a3
        L_0x0050:
            int r10 = r0.e()
            if (r10 != r2) goto L_0x005b
            boolean r11 = r0.b()
            goto L_0x005c
        L_0x005b:
            r11 = 0
        L_0x005c:
            r0.e()
            r0.e()
            r0.a()
            boolean r12 = r0.b()
            if (r12 == 0) goto L_0x00a3
            if (r10 == r2) goto L_0x0070
            r12 = 8
            goto L_0x0072
        L_0x0070:
            r12 = 12
        L_0x0072:
            r13 = 0
        L_0x0073:
            if (r13 >= r12) goto L_0x00a3
            boolean r14 = r0.b()
            if (r14 == 0) goto L_0x00a0
            r14 = 6
            if (r13 >= r14) goto L_0x0081
            r14 = 16
            goto L_0x0083
        L_0x0081:
            r14 = 64
        L_0x0083:
            r15 = 0
            r16 = 8
            r17 = 8
        L_0x0088:
            if (r15 >= r14) goto L_0x00a0
            if (r16 == 0) goto L_0x0098
            int r16 = r0.d()
            int r8 = r17 + r16
            int r8 = r8 + 256
            int r8 = r8 % 256
            r16 = r8
        L_0x0098:
            if (r16 != 0) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r17 = r16
        L_0x009d:
            int r15 = r15 + 1
            goto L_0x0088
        L_0x00a0:
            int r13 = r13 + 1
            goto L_0x0073
        L_0x00a3:
            int r8 = r0.e()
            int r12 = r8 + 4
            int r13 = r0.e()
            if (r13 != 0) goto L_0x00b9
            int r8 = r0.e()
            int r8 = r8 + 4
            r23 = r3
            r14 = r8
            goto L_0x00de
        L_0x00b9:
            if (r13 != r9) goto L_0x00db
            boolean r8 = r0.b()
            r0.d()
            r0.d()
            int r14 = r0.e()
            long r14 = (long) r14
            r23 = r3
            r1 = 0
        L_0x00cd:
            long r2 = (long) r1
            int r17 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r17 >= 0) goto L_0x00d8
            r0.e()
            int r1 = r1 + 1
            goto L_0x00cd
        L_0x00d8:
            r15 = r8
            r14 = 0
            goto L_0x00df
        L_0x00db:
            r23 = r3
            r14 = 0
        L_0x00de:
            r15 = 0
        L_0x00df:
            r0.e()
            r0.a()
            int r1 = r0.e()
            int r1 = r1 + r9
            int r2 = r0.e()
            int r2 = r2 + r9
            boolean r17 = r0.b()
            r3 = 2
            int r8 = 2 - r17
            int r8 = r8 * r2
            if (r17 != 0) goto L_0x00fd
            r0.a()
        L_0x00fd:
            r0.a()
            int r1 = r1 * 16
            int r8 = r8 * 16
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x0138
            int r2 = r0.e()
            int r18 = r0.e()
            int r19 = r0.e()
            int r20 = r0.e()
            if (r10 != 0) goto L_0x0120
            int r3 = 2 - r17
            r7 = 1
            goto L_0x012d
        L_0x0120:
            r7 = 3
            if (r10 != r7) goto L_0x0125
            r7 = 1
            goto L_0x0126
        L_0x0125:
            r7 = 2
        L_0x0126:
            if (r10 != r9) goto L_0x0129
            r9 = 2
        L_0x0129:
            int r3 = 2 - r17
            int r3 = r3 * r9
        L_0x012d:
            int r2 = r2 + r18
            int r2 = r2 * r7
            int r1 = r1 - r2
            int r19 = r19 + r20
            int r19 = r19 * r3
            int r8 = r8 - r19
        L_0x0138:
            r7 = r1
            r1 = 1065353216(0x3f800000, float:1.0)
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x0179
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x0179
            r2 = 8
            int r2 = r0.c(r2)
            r3 = 255(0xff, float:3.57E-43)
            if (r2 != r3) goto L_0x0164
            r3 = 16
            int r2 = r0.c(r3)
            int r0 = r0.c(r3)
            if (r2 == 0) goto L_0x0162
            if (r0 == 0) goto L_0x0162
            float r1 = (float) r2
            float r0 = (float) r0
            float r1 = r1 / r0
        L_0x0162:
            r9 = r1
            goto L_0x017b
        L_0x0164:
            float[] r0 = f32547b
            int r3 = r0.length
            if (r2 >= r3) goto L_0x016d
            r0 = r0[r2]
            r9 = r0
            goto L_0x017b
        L_0x016d:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "Unexpected aspect_ratio_idc value: "
            r2.concat(r0)
            com.google.android.exoplayer2.g.l.c()
        L_0x0179:
            r9 = 1065353216(0x3f800000, float:1.0)
        L_0x017b:
            com.google.android.exoplayer2.g.p$b r0 = new com.google.android.exoplayer2.g.p$b
            r2 = r0
            r3 = r23
            r10 = r11
            r11 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.p.a(byte[], int, int):com.google.android.exoplayer2.g.p$b");
    }

    public static a d(byte[] bArr, int i2) {
        s sVar = new s(bArr, 3, i2);
        sVar.a(8);
        int e2 = sVar.e();
        int e3 = sVar.e();
        sVar.a();
        return new a(e2, e3, sVar.b());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0096, code lost:
        r8 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
            int r0 = r9 - r8
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            com.google.android.exoplayer2.g.a.b(r3)
            if (r0 != 0) goto L_0x000f
            return r9
        L_0x000f:
            r3 = 2
            if (r10 == 0) goto L_0x0040
            boolean r4 = r10[r1]
            if (r4 == 0) goto L_0x001c
            a((boolean[]) r10)
            int r8 = r8 + -3
            return r8
        L_0x001c:
            if (r0 <= r2) goto L_0x002b
            boolean r4 = r10[r2]
            if (r4 == 0) goto L_0x002b
            byte r4 = r7[r8]
            if (r4 != r2) goto L_0x002b
            a((boolean[]) r10)
            int r8 = r8 - r3
            return r8
        L_0x002b:
            if (r0 <= r3) goto L_0x0040
            boolean r4 = r10[r3]
            if (r4 == 0) goto L_0x0040
            byte r4 = r7[r8]
            if (r4 != 0) goto L_0x0040
            int r4 = r8 + 1
            byte r4 = r7[r4]
            if (r4 != r2) goto L_0x0040
            a((boolean[]) r10)
            int r8 = r8 - r2
            return r8
        L_0x0040:
            int r4 = r9 + -1
            int r8 = r8 + r3
        L_0x0043:
            if (r8 >= r4) goto L_0x0066
            byte r5 = r7[r8]
            r5 = r5 & 254(0xfe, float:3.56E-43)
            if (r5 != 0) goto L_0x0063
            int r5 = r8 + -2
            byte r6 = r7[r5]
            if (r6 != 0) goto L_0x0061
            int r6 = r8 + -1
            byte r6 = r7[r6]
            if (r6 != 0) goto L_0x0061
            byte r6 = r7[r8]
            if (r6 != r2) goto L_0x0061
            if (r10 == 0) goto L_0x0060
            a((boolean[]) r10)
        L_0x0060:
            return r5
        L_0x0061:
            int r8 = r8 + -2
        L_0x0063:
            int r8 = r8 + 3
            goto L_0x0043
        L_0x0066:
            if (r10 == 0) goto L_0x00ba
            if (r0 <= r3) goto L_0x007d
            int r8 = r9 + -3
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x007b
            int r8 = r9 + -2
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x007b
            byte r8 = r7[r4]
            if (r8 != r2) goto L_0x007b
            goto L_0x0096
        L_0x007b:
            r8 = 0
            goto L_0x0097
        L_0x007d:
            if (r0 != r3) goto L_0x008e
            boolean r8 = r10[r3]
            if (r8 == 0) goto L_0x007b
            int r8 = r9 + -2
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x007b
            byte r8 = r7[r4]
            if (r8 != r2) goto L_0x007b
            goto L_0x0096
        L_0x008e:
            boolean r8 = r10[r2]
            if (r8 == 0) goto L_0x007b
            byte r8 = r7[r4]
            if (r8 != r2) goto L_0x007b
        L_0x0096:
            r8 = 1
        L_0x0097:
            r10[r1] = r8
            if (r0 <= r2) goto L_0x00a6
            int r8 = r9 + -2
            byte r8 = r7[r8]
            if (r8 != 0) goto L_0x00b0
            byte r8 = r7[r4]
            if (r8 != 0) goto L_0x00b0
            goto L_0x00ae
        L_0x00a6:
            boolean r8 = r10[r3]
            if (r8 == 0) goto L_0x00b0
            byte r8 = r7[r4]
            if (r8 != 0) goto L_0x00b0
        L_0x00ae:
            r8 = 1
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            r10[r2] = r8
            byte r7 = r7[r4]
            if (r7 != 0) goto L_0x00b8
            r1 = 1
        L_0x00b8:
            r10[r3] = r1
        L_0x00ba:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.p.a(byte[], int, int, boolean[]):int");
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
