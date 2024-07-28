package com.google.android.gms.internal.firebase_ml;

final class l extends h {
    l() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.a(r1, r8) > -65) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.a(r1, r8) > -65) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0102, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0129, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(int r24, byte[] r25, int r26, int r27) {
        /*
            r23 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r2 | r3
            int r5 = r1.length
            int r5 = r5 - r3
            r4 = r4 | r5
            r7 = 0
            if (r4 < 0) goto L_0x015d
            long r8 = (long) r2
            long r2 = (long) r3
            r4 = -19
            r10 = -62
            r11 = -16
            r12 = 16
            r13 = -96
            r14 = -32
            r15 = -1
            r6 = -65
            r16 = 1
            if (r0 == 0) goto L_0x00ac
            int r18 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r18 < 0) goto L_0x002a
            return r0
        L_0x002a:
            byte r5 = (byte) r0
            if (r5 >= r14) goto L_0x0038
            if (r5 < r10) goto L_0x0037
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r8)
            if (r0 <= r6) goto L_0x00ae
        L_0x0037:
            return r15
        L_0x0038:
            if (r5 >= r11) goto L_0x0064
            int r0 = r0 >> 8
            int r0 = ~r0
            byte r0 = (byte) r0
            if (r0 != 0) goto L_0x0051
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r8)
            int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x004f
            int r0 = com.google.android.gms.internal.firebase_ml.g.b(r5, r0)
            return r0
        L_0x004f:
            r8 = r19
        L_0x0051:
            if (r0 > r6) goto L_0x0063
            if (r5 != r14) goto L_0x0057
            if (r0 < r13) goto L_0x0063
        L_0x0057:
            if (r5 != r4) goto L_0x005b
            if (r0 >= r13) goto L_0x0063
        L_0x005b:
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r8)
            if (r0 <= r6) goto L_0x00ae
        L_0x0063:
            return r15
        L_0x0064:
            int r4 = r0 >> 8
            int r4 = ~r4
            byte r4 = (byte) r4
            if (r4 != 0) goto L_0x007d
            long r19 = r8 + r16
            byte r4 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r8)
            int r0 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0079
            int r0 = com.google.android.gms.internal.firebase_ml.g.b(r5, r4)
            return r0
        L_0x0079:
            r8 = r19
            r0 = 0
            goto L_0x007f
        L_0x007d:
            int r0 = r0 >> r12
            byte r0 = (byte) r0
        L_0x007f:
            if (r0 != 0) goto L_0x0092
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r8)
            int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x0090
            int r0 = com.google.android.gms.internal.firebase_ml.g.b((int) r5, (int) r4, (int) r0)
            return r0
        L_0x0090:
            r8 = r19
        L_0x0092:
            if (r4 > r6) goto L_0x00ab
            int r5 = r5 << 28
            int r4 = r4 + 112
            int r5 = r5 + r4
            int r4 = r5 >> 30
            if (r4 != 0) goto L_0x00ab
            if (r0 > r6) goto L_0x00ab
            long r4 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r8)
            if (r0 <= r6) goto L_0x00a8
            goto L_0x00ab
        L_0x00a8:
            r19 = r4
            goto L_0x00ae
        L_0x00ab:
            return r15
        L_0x00ac:
            r19 = r8
        L_0x00ae:
            long r2 = r2 - r19
            int r0 = (int) r2
            if (r0 >= r12) goto L_0x00b5
            r2 = 0
            goto L_0x00c8
        L_0x00b5:
            r3 = r19
            r2 = 0
        L_0x00b8:
            if (r2 >= r0) goto L_0x00c7
            long r8 = r3 + r16
            byte r3 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r3)
            if (r3 >= 0) goto L_0x00c3
            goto L_0x00c8
        L_0x00c3:
            int r2 = r2 + 1
            r3 = r8
            goto L_0x00b8
        L_0x00c7:
            r2 = r0
        L_0x00c8:
            int r0 = r0 - r2
            long r2 = (long) r2
            long r19 = r19 + r2
        L_0x00cc:
            r2 = r19
            r4 = 0
        L_0x00cf:
            if (r0 <= 0) goto L_0x00e1
            long r4 = r2 + r16
            byte r2 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r2)
            if (r2 < 0) goto L_0x00e6
            int r0 = r0 + -1
            r21 = r4
            r4 = r2
            r2 = r21
            goto L_0x00cf
        L_0x00e1:
            r21 = r2
            r2 = r4
            r4 = r21
        L_0x00e6:
            if (r0 != 0) goto L_0x00e9
            return r7
        L_0x00e9:
            int r0 = r0 + -1
            if (r2 >= r14) goto L_0x0103
            if (r0 != 0) goto L_0x00f0
            return r2
        L_0x00f0:
            int r0 = r0 + -1
            if (r2 < r10) goto L_0x0102
            long r2 = r4 + r16
            byte r4 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r4)
            if (r4 <= r6) goto L_0x00fd
            goto L_0x0102
        L_0x00fd:
            r19 = r2
            r12 = -19
            goto L_0x00cc
        L_0x0102:
            return r15
        L_0x0103:
            if (r2 >= r11) goto L_0x012a
            r3 = 2
            if (r0 >= r3) goto L_0x010d
            int r0 = a((byte[]) r1, (int) r2, (long) r4, (int) r0)
            return r0
        L_0x010d:
            int r0 = r0 + -2
            long r8 = r4 + r16
            byte r3 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r4)
            if (r3 > r6) goto L_0x0129
            if (r2 != r14) goto L_0x011b
            if (r3 < r13) goto L_0x0129
        L_0x011b:
            r12 = -19
            if (r2 != r12) goto L_0x0121
            if (r3 >= r13) goto L_0x0129
        L_0x0121:
            long r19 = r8 + r16
            byte r2 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r8)
            if (r2 <= r6) goto L_0x00cc
        L_0x0129:
            return r15
        L_0x012a:
            r3 = 3
            r12 = -19
            if (r0 >= r3) goto L_0x0134
            int r0 = a((byte[]) r1, (int) r2, (long) r4, (int) r0)
            return r0
        L_0x0134:
            int r0 = r0 + -3
            long r8 = r4 + r16
            byte r3 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r4)
            if (r3 > r6) goto L_0x015c
            int r2 = r2 << 28
            int r3 = r3 + 112
            int r2 = r2 + r3
            int r2 = r2 >> 30
            if (r2 != 0) goto L_0x015c
            long r2 = r8 + r16
            byte r4 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r8)
            if (r4 > r6) goto L_0x015c
            long r4 = r2 + r16
            byte r2 = com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r2)
            if (r2 <= r6) goto L_0x0158
            goto L_0x015c
        L_0x0158:
            r19 = r4
            goto L_0x00cc
        L_0x015c:
            return r15
        L_0x015d:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r1 = r1.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4[r7] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r26)
            r2 = 1
            r4[r2] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r27)
            r2 = 2
            r4[r2] = r1
            java.lang.String r1 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r1 = java.lang.String.format(r1, r4)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.l.a(int, byte[], int, int):int");
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
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r4, (byte) r3)
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
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r4, (byte) r13)
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
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r4, (byte) r3)
            long r3 = r14 + r11
            r5 = r13 & 63
            r13 = 128(0x80, float:1.794E-43)
            r5 = r5 | r13
            byte r5 = (byte) r5
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r14, (byte) r5)
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
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r4, (byte) r3)
            long r3 = r14 + r11
            int r5 = r13 >>> 6
            r5 = r5 & 63
            r11 = 128(0x80, float:1.794E-43)
            r5 = r5 | r11
            byte r5 = (byte) r5
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r14, (byte) r5)
            r14 = 1
            long r18 = r3 + r14
            r5 = r13 & 63
            r5 = r5 | r11
            byte r5 = (byte) r5
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r3, (byte) r5)
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
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r4, (byte) r15)
            long r4 = r13 + r11
            int r15 = r2 >>> 12
            r15 = r15 & 63
            r11 = 128(0x80, float:1.794E-43)
            r12 = r15 | 128(0x80, float:1.794E-43)
            byte r12 = (byte) r12
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r13, (byte) r12)
            r12 = 1
            long r14 = r4 + r12
            int r16 = r2 >>> 6
            r12 = r16 & 63
            r12 = r12 | r11
            byte r12 = (byte) r12
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r4, (byte) r12)
            r4 = 1
            long r12 = r14 + r4
            r2 = r2 & 63
            r2 = r2 | r11
            byte r2 = (byte) r2
            com.google.android.gms.internal.firebase_ml.d.a((byte[]) r1, (long) r14, (byte) r2)
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
            com.google.android.gms.internal.firebase_ml.i r0 = new com.google.android.gms.internal.firebase_ml.i
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
            com.google.android.gms.internal.firebase_ml.i r0 = new com.google.android.gms.internal.firebase_ml.i
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.l.a(java.lang.CharSequence, byte[], int, int):int");
    }

    private static int a(byte[] bArr, int i2, long j, int i3) {
        if (i3 == 0) {
            return g.b(i2);
        }
        if (i3 == 1) {
            return g.b(i2, d.a(bArr, j));
        }
        if (i3 == 2) {
            return g.b(i2, (int) d.a(bArr, j), (int) d.a(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
