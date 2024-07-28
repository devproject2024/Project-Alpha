package com.google.zxing.b;

import com.google.zxing.m;

public final class f extends i {
    public final b a(b bVar, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws m {
        b bVar2 = bVar;
        int i4 = i2;
        int i5 = i3;
        return a(bVar, i2, i3, k.a(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.b.b a(com.google.zxing.b.b r23, int r24, int r25, com.google.zxing.b.k r26) throws com.google.zxing.m {
        /*
            r22 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            if (r1 <= 0) goto L_0x0113
            if (r2 <= 0) goto L_0x0113
            com.google.zxing.b.b r4 = new com.google.zxing.b.b
            r4.<init>(r1, r2)
            int r1 = r1 * 2
            float[] r1 = new float[r1]
            r6 = 0
        L_0x0016:
            if (r6 >= r2) goto L_0x0112
            int r7 = r1.length
            float r8 = (float) r6
            r9 = 1056964608(0x3f000000, float:0.5)
            float r8 = r8 + r9
            r10 = 0
        L_0x001e:
            if (r10 >= r7) goto L_0x002d
            int r11 = r10 / 2
            float r11 = (float) r11
            float r11 = r11 + r9
            r1[r10] = r11
            int r11 = r10 + 1
            r1[r11] = r8
            int r10 = r10 + 2
            goto L_0x001e
        L_0x002d:
            int r8 = r1.length
            float r9 = r3.f39926a
            float r10 = r3.f39927b
            float r11 = r3.f39928c
            float r12 = r3.f39929d
            float r13 = r3.f39930e
            float r14 = r3.f39931f
            float r15 = r3.f39932g
            float r5 = r3.f39933h
            float r2 = r3.f39934i
            r3 = 0
        L_0x0041:
            if (r3 >= r8) goto L_0x006c
            r16 = r1[r3]
            int r17 = r3 + 1
            r18 = r1[r17]
            float r19 = r11 * r16
            float r20 = r14 * r18
            float r19 = r19 + r20
            float r19 = r19 + r2
            float r20 = r9 * r16
            float r21 = r12 * r18
            float r20 = r20 + r21
            float r20 = r20 + r15
            float r20 = r20 / r19
            r1[r3] = r20
            float r16 = r16 * r10
            float r18 = r18 * r13
            float r16 = r16 + r18
            float r16 = r16 + r5
            float r16 = r16 / r19
            r1[r17] = r16
            int r3 = r3 + 2
            goto L_0x0041
        L_0x006c:
            int r2 = r0.f39889a
            int r3 = r0.f39890b
            r5 = 1
            r8 = 0
            r9 = 1
        L_0x0073:
            int r10 = r1.length
            r11 = 0
            r12 = -1
            if (r8 >= r10) goto L_0x00af
            if (r9 == 0) goto L_0x00af
            r9 = r1[r8]
            int r9 = (int) r9
            int r10 = r8 + 1
            r13 = r1[r10]
            int r13 = (int) r13
            if (r9 < r12) goto L_0x00aa
            if (r9 > r2) goto L_0x00aa
            if (r13 < r12) goto L_0x00aa
            if (r13 > r3) goto L_0x00aa
            if (r9 != r12) goto L_0x0090
            r1[r8] = r11
        L_0x008e:
            r9 = 1
            goto L_0x0099
        L_0x0090:
            if (r9 != r2) goto L_0x0098
            int r9 = r2 + -1
            float r9 = (float) r9
            r1[r8] = r9
            goto L_0x008e
        L_0x0098:
            r9 = 0
        L_0x0099:
            if (r13 != r12) goto L_0x009f
            r1[r10] = r11
        L_0x009d:
            r9 = 1
            goto L_0x00a7
        L_0x009f:
            if (r13 != r3) goto L_0x00a7
            int r9 = r3 + -1
            float r9 = (float) r9
            r1[r10] = r9
            goto L_0x009d
        L_0x00a7:
            int r8 = r8 + 2
            goto L_0x0073
        L_0x00aa:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x00af:
            int r8 = r1.length
            int r8 = r8 + -2
            r9 = 1
        L_0x00b3:
            if (r8 < 0) goto L_0x00ec
            if (r9 == 0) goto L_0x00ec
            r9 = r1[r8]
            int r9 = (int) r9
            int r10 = r8 + 1
            r13 = r1[r10]
            int r13 = (int) r13
            if (r9 < r12) goto L_0x00e7
            if (r9 > r2) goto L_0x00e7
            if (r13 < r12) goto L_0x00e7
            if (r13 > r3) goto L_0x00e7
            if (r9 != r12) goto L_0x00cd
            r1[r8] = r11
        L_0x00cb:
            r9 = 1
            goto L_0x00d6
        L_0x00cd:
            if (r9 != r2) goto L_0x00d5
            int r9 = r2 + -1
            float r9 = (float) r9
            r1[r8] = r9
            goto L_0x00cb
        L_0x00d5:
            r9 = 0
        L_0x00d6:
            if (r13 != r12) goto L_0x00dc
            r1[r10] = r11
        L_0x00da:
            r9 = 1
            goto L_0x00e4
        L_0x00dc:
            if (r13 != r3) goto L_0x00e4
            int r9 = r3 + -1
            float r9 = (float) r9
            r1[r10] = r9
            goto L_0x00da
        L_0x00e4:
            int r8 = r8 + -2
            goto L_0x00b3
        L_0x00e7:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x00ec:
            r2 = 0
        L_0x00ed:
            if (r2 >= r7) goto L_0x010a
            r3 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0105 }
            int r3 = (int) r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0105 }
            int r5 = r2 + 1
            r5 = r1[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0105 }
            int r5 = (int) r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0105 }
            boolean r3 = r0.a((int) r3, (int) r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0105 }
            if (r3 == 0) goto L_0x0102
            int r3 = r2 / 2
            r4.b((int) r3, (int) r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0105 }
        L_0x0102:
            int r2 = r2 + 2
            goto L_0x00ed
        L_0x0105:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x010a:
            int r6 = r6 + 1
            r2 = r25
            r3 = r26
            goto L_0x0016
        L_0x0112:
            return r4
        L_0x0113:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.b.f.a(com.google.zxing.b.b, int, int, com.google.zxing.b.k):com.google.zxing.b.b");
    }
}
