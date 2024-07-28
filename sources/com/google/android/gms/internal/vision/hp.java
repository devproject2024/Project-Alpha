package com.google.android.gms.internal.vision;

final class hp extends hk {
    hp() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b0, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(byte[] r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = r14 | r15
            int r1 = r13.length
            int r1 = r1 - r15
            r0 = r0 | r1
            r1 = 2
            r2 = 3
            r3 = 0
            if (r0 < 0) goto L_0x00b1
            long r4 = (long) r14
            long r14 = (long) r15
            long r14 = r14 - r4
            int r15 = (int) r14
            r14 = 16
            r6 = 1
            if (r15 >= r14) goto L_0x0016
            r14 = 0
            goto L_0x0028
        L_0x0016:
            r8 = r4
            r14 = 0
        L_0x0018:
            if (r14 >= r15) goto L_0x0027
            long r10 = r8 + r6
            byte r0 = com.google.android.gms.internal.vision.hg.a((byte[]) r13, (long) r8)
            if (r0 >= 0) goto L_0x0023
            goto L_0x0028
        L_0x0023:
            int r14 = r14 + 1
            r8 = r10
            goto L_0x0018
        L_0x0027:
            r14 = r15
        L_0x0028:
            int r15 = r15 - r14
            long r8 = (long) r14
            long r4 = r4 + r8
        L_0x002b:
            r14 = 0
        L_0x002c:
            if (r15 <= 0) goto L_0x003b
            long r8 = r4 + r6
            byte r14 = com.google.android.gms.internal.vision.hg.a((byte[]) r13, (long) r4)
            if (r14 < 0) goto L_0x003a
            int r15 = r15 + -1
            r4 = r8
            goto L_0x002c
        L_0x003a:
            r4 = r8
        L_0x003b:
            if (r15 != 0) goto L_0x003e
            return r3
        L_0x003e:
            int r15 = r15 + -1
            r0 = -32
            r8 = -65
            r9 = -1
            if (r14 >= r0) goto L_0x005c
            if (r15 != 0) goto L_0x004a
            return r14
        L_0x004a:
            int r15 = r15 + -1
            r0 = -62
            if (r14 < r0) goto L_0x005b
            long r10 = r4 + r6
            byte r14 = com.google.android.gms.internal.vision.hg.a((byte[]) r13, (long) r4)
            if (r14 <= r8) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r4 = r10
            goto L_0x002b
        L_0x005b:
            return r9
        L_0x005c:
            r10 = -16
            if (r14 >= r10) goto L_0x0086
            if (r15 >= r1) goto L_0x0067
            int r13 = a((byte[]) r13, (int) r14, (long) r4, (int) r15)
            return r13
        L_0x0067:
            int r15 = r15 + -2
            long r10 = r4 + r6
            byte r4 = com.google.android.gms.internal.vision.hg.a((byte[]) r13, (long) r4)
            if (r4 > r8) goto L_0x0085
            r5 = -96
            if (r14 != r0) goto L_0x0077
            if (r4 < r5) goto L_0x0085
        L_0x0077:
            r0 = -19
            if (r14 != r0) goto L_0x007d
            if (r4 >= r5) goto L_0x0085
        L_0x007d:
            long r4 = r10 + r6
            byte r14 = com.google.android.gms.internal.vision.hg.a((byte[]) r13, (long) r10)
            if (r14 <= r8) goto L_0x002b
        L_0x0085:
            return r9
        L_0x0086:
            if (r15 >= r2) goto L_0x008d
            int r13 = a((byte[]) r13, (int) r14, (long) r4, (int) r15)
            return r13
        L_0x008d:
            int r15 = r15 + -3
            long r10 = r4 + r6
            byte r0 = com.google.android.gms.internal.vision.hg.a((byte[]) r13, (long) r4)
            if (r0 > r8) goto L_0x00b0
            int r14 = r14 << 28
            int r0 = r0 + 112
            int r14 = r14 + r0
            int r14 = r14 >> 30
            if (r14 != 0) goto L_0x00b0
            long r4 = r10 + r6
            byte r14 = com.google.android.gms.internal.vision.hg.a((byte[]) r13, (long) r10)
            if (r14 > r8) goto L_0x00b0
            long r10 = r4 + r6
            byte r14 = com.google.android.gms.internal.vision.hg.a((byte[]) r13, (long) r4)
            if (r14 <= r8) goto L_0x0059
        L_0x00b0:
            return r9
        L_0x00b1:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.Object[] r2 = new java.lang.Object[r2]
            int r13 = r13.length
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r2[r3] = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
            r14 = 1
            r2[r14] = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)
            r2[r1] = r13
            java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r13 = java.lang.String.format(r13, r2)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.hp.b(byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public final String c(byte[] bArr, int i2, int i3) throws eu {
        if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (r13 < i4) {
                byte a2 = hg.a(bArr, (long) r13);
                if (!(a2 >= 0)) {
                    break;
                }
                i2 = r13 + 1;
                cArr[i5] = (char) a2;
                i5++;
            }
            int i6 = i5;
            while (r13 < i4) {
                int i7 = r13 + 1;
                byte a3 = hg.a(bArr, (long) r13);
                if (a3 >= 0) {
                    int i8 = i6 + 1;
                    cArr[i6] = (char) a3;
                    while (i7 < i4) {
                        byte a4 = hg.a(bArr, (long) i7);
                        if (!(a4 >= 0)) {
                            break;
                        }
                        i7++;
                        cArr[i8] = (char) a4;
                        i8++;
                    }
                    r13 = i7;
                    i6 = i8;
                } else if (hl.a(a3)) {
                    if (i7 < i4) {
                        hl.a(a3, hg.a(bArr, (long) i7), cArr, i6);
                        r13 = i7 + 1;
                        i6++;
                    } else {
                        throw eu.zzgt();
                    }
                } else if (hl.b(a3)) {
                    if (i7 < i4 - 1) {
                        int i9 = i7 + 1;
                        hl.a(a3, hg.a(bArr, (long) i7), hg.a(bArr, (long) i9), cArr, i6);
                        r13 = i9 + 1;
                        i6++;
                    } else {
                        throw eu.zzgt();
                    }
                } else if (i7 < i4 - 2) {
                    int i10 = i7 + 1;
                    byte a5 = hg.a(bArr, (long) i7);
                    int i11 = i10 + 1;
                    hl.a(a3, a5, hg.a(bArr, (long) i10), hg.a(bArr, (long) i11), cArr, i6);
                    r13 = i11 + 1;
                    i6 = i6 + 1 + 1;
                } else {
                    throw eu.zzgt();
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00fb, LOOP_START, PHI: r2 r3 r4 r11 
      PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v3 char) = (r3v2 char), (r3v4 char) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.CharSequence r23, byte[] r24, int r25, int r26) {
        /*
            r22 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            long r4 = (long) r2
            long r6 = (long) r3
            long r6 = r6 + r4
            int r8 = r23.length()
            java.lang.String r9 = " at index "
            java.lang.String r10 = "Failed writing "
            if (r8 > r3) goto L_0x0146
            int r11 = r1.length
            int r11 = r11 - r3
            if (r11 < r2) goto L_0x0146
            r2 = 0
        L_0x001a:
            r3 = 128(0x80, float:1.794E-43)
            r11 = 1
            if (r2 >= r8) goto L_0x002f
            char r13 = r0.charAt(r2)
            if (r13 >= r3) goto L_0x002f
            long r11 = r11 + r4
            byte r3 = (byte) r13
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r4, (byte) r3)
            int r2 = r2 + 1
            r4 = r11
            goto L_0x001a
        L_0x002f:
            if (r2 != r8) goto L_0x0033
            int r0 = (int) r4
            return r0
        L_0x0033:
            if (r2 >= r8) goto L_0x0144
            char r13 = r0.charAt(r2)
            if (r13 >= r3) goto L_0x004b
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 >= 0) goto L_0x004b
            long r14 = r4 + r11
            byte r13 = (byte) r13
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r4, (byte) r13)
            r4 = r11
            r12 = r14
        L_0x0047:
            r11 = 128(0x80, float:1.794E-43)
            goto L_0x00fb
        L_0x004b:
            r14 = 2048(0x800, float:2.87E-42)
            if (r13 >= r14) goto L_0x0075
            r14 = 2
            long r14 = r6 - r14
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 > 0) goto L_0x0075
            long r14 = r4 + r11
            int r3 = r13 >>> 6
            r3 = r3 | 960(0x3c0, float:1.345E-42)
            byte r3 = (byte) r3
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r4, (byte) r3)
            long r3 = r14 + r11
            r5 = r13 & 63
            r13 = 128(0x80, float:1.794E-43)
            r5 = r5 | r13
            byte r5 = (byte) r5
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r14, (byte) r5)
            r20 = r11
            r11 = 128(0x80, float:1.794E-43)
            r12 = r3
            r4 = r20
            goto L_0x00fb
        L_0x0075:
            r3 = 57343(0xdfff, float:8.0355E-41)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r13 < r14) goto L_0x007f
            if (r3 >= r13) goto L_0x00ae
        L_0x007f:
            r15 = 3
            long r15 = r6 - r15
            int r17 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r17 > 0) goto L_0x00ae
            long r14 = r4 + r11
            int r3 = r13 >>> 12
            r3 = r3 | 480(0x1e0, float:6.73E-43)
            byte r3 = (byte) r3
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r4, (byte) r3)
            long r3 = r14 + r11
            int r5 = r13 >>> 6
            r5 = r5 & 63
            r11 = 128(0x80, float:1.794E-43)
            r5 = r5 | r11
            byte r5 = (byte) r5
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r14, (byte) r5)
            r14 = 1
            long r18 = r3 + r14
            r5 = r13 & 63
            r5 = r5 | r11
            byte r5 = (byte) r5
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r3, (byte) r5)
            r12 = r18
            r4 = 1
            goto L_0x0047
        L_0x00ae:
            r11 = 4
            long r11 = r6 - r11
            int r15 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r15 > 0) goto L_0x010f
            int r3 = r2 + 1
            if (r3 == r8) goto L_0x0107
            char r2 = r0.charAt(r3)
            boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
            if (r11 == 0) goto L_0x0106
            int r2 = java.lang.Character.toCodePoint(r13, r2)
            r11 = 1
            long r13 = r4 + r11
            int r15 = r2 >>> 18
            r15 = r15 | 240(0xf0, float:3.36E-43)
            byte r15 = (byte) r15
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r4, (byte) r15)
            long r4 = r13 + r11
            int r15 = r2 >>> 12
            r15 = r15 & 63
            r11 = 128(0x80, float:1.794E-43)
            r12 = r15 | 128(0x80, float:1.794E-43)
            byte r12 = (byte) r12
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r13, (byte) r12)
            r12 = 1
            long r14 = r4 + r12
            int r16 = r2 >>> 6
            r12 = r16 & 63
            r12 = r12 | r11
            byte r12 = (byte) r12
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r4, (byte) r12)
            r4 = 1
            long r12 = r14 + r4
            r2 = r2 & 63
            r2 = r2 | r11
            byte r2 = (byte) r2
            com.google.android.gms.internal.vision.hg.a((byte[]) r1, (long) r14, (byte) r2)
            r2 = r3
        L_0x00fb:
            int r2 = r2 + 1
            r3 = 128(0x80, float:1.794E-43)
            r20 = r4
            r4 = r12
            r11 = r20
            goto L_0x0033
        L_0x0106:
            r2 = r3
        L_0x0107:
            com.google.android.gms.internal.vision.hm r0 = new com.google.android.gms.internal.vision.hm
            int r2 = r2 + -1
            r0.<init>(r2, r8)
            throw r0
        L_0x010f:
            if (r14 > r13) goto L_0x0127
            if (r13 > r3) goto L_0x0127
            int r1 = r2 + 1
            if (r1 == r8) goto L_0x0121
            char r0 = r0.charAt(r1)
            boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
            if (r0 != 0) goto L_0x0127
        L_0x0121:
            com.google.android.gms.internal.vision.hm r0 = new com.google.android.gms.internal.vision.hm
            r0.<init>(r2, r8)
            throw r0
        L_0x0127:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r1 = 46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            r2.append(r10)
            r2.append(r13)
            r2.append(r9)
            r2.append(r4)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0144:
            int r0 = (int) r4
            return r0
        L_0x0146:
            java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
            int r8 = r8 + -1
            char r0 = r0.charAt(r8)
            int r2 = r2 + r3
            r3 = 37
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r10)
            r4.append(r0)
            r4.append(r9)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.hp.a(java.lang.CharSequence, byte[], int, int):int");
    }

    private static int a(byte[] bArr, int i2, long j, int i3) {
        if (i3 == 0) {
            return hj.b(i2);
        }
        if (i3 == 1) {
            return hj.b(i2, hg.a(bArr, j));
        }
        if (i3 == 2) {
            return hj.b(i2, (int) hg.a(bArr, j), (int) hg.a(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
