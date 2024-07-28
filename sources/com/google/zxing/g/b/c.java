package com.google.zxing.g.b;

import com.google.zxing.b.a.a;
import com.google.zxing.b.b;
import com.google.zxing.t;
import com.google.zxing.u;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final b f40533a;

    /* renamed from: b  reason: collision with root package name */
    public u f40534b;

    public c(b bVar) {
        this.f40533a = bVar;
    }

    private float a(int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        float f3;
        float b2 = b(i2, i3, i4, i5);
        int i7 = i2 - (i4 - i2);
        int i8 = 0;
        if (i7 < 0) {
            f2 = ((float) i2) / ((float) (i2 - i7));
            i6 = 0;
        } else if (i7 >= this.f40533a.f39889a) {
            f2 = ((float) ((this.f40533a.f39889a - 1) - i2)) / ((float) (i7 - i2));
            i6 = this.f40533a.f39889a - 1;
        } else {
            i6 = i7;
            f2 = 1.0f;
        }
        float f4 = (float) i3;
        int i9 = (int) (f4 - (((float) (i5 - i3)) * f2));
        if (i9 < 0) {
            f3 = f4 / ((float) (i3 - i9));
        } else if (i9 >= this.f40533a.f39890b) {
            f3 = ((float) ((this.f40533a.f39890b - 1) - i3)) / ((float) (i9 - i3));
            i8 = this.f40533a.f39890b - 1;
        } else {
            i8 = i9;
            f3 = 1.0f;
        }
        return (b2 + b(i2, i3, (int) (((float) i2) + (((float) (i6 - i2)) * f3)), i8)) - 1.0f;
    }

    private float b(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        c cVar;
        boolean z2;
        int i11 = 1;
        boolean z3 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z3) {
            i6 = i2;
            i8 = i3;
            i7 = i4;
            i9 = i5;
        } else {
            i8 = i2;
            i6 = i3;
            i9 = i4;
            i7 = i5;
        }
        int abs = Math.abs(i9 - i8);
        int abs2 = Math.abs(i7 - i6);
        int i12 = (-abs) / 2;
        int i13 = -1;
        int i14 = i8 < i9 ? 1 : -1;
        if (i6 < i7) {
            i13 = 1;
        }
        int i15 = i9 + i14;
        int i16 = i6;
        int i17 = i12;
        int i18 = 0;
        int i19 = i8;
        while (true) {
            if (i19 == i15) {
                i10 = i15;
                break;
            }
            int i20 = z3 ? i16 : i19;
            int i21 = z3 ? i19 : i16;
            if (i18 == i11) {
                cVar = this;
                z = z3;
                i10 = i15;
                z2 = true;
            } else {
                cVar = this;
                z = z3;
                i10 = i15;
                z2 = false;
            }
            if (z2 == cVar.f40533a.a(i20, i21)) {
                if (i18 == 2) {
                    return a.a(i19, i16, i8, i6);
                }
                i18++;
            }
            i17 += abs2;
            if (i17 > 0) {
                if (i16 == i7) {
                    break;
                }
                i16 += i13;
                i17 -= abs;
            }
            i19 += i14;
            i15 = i10;
            z3 = z;
            i11 = 1;
        }
        if (i18 == 2) {
            return a.a(i10, i7, i8, i6);
        }
        return Float.NaN;
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0255  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.b.g a(com.google.zxing.g.b.f r41) throws com.google.zxing.m, com.google.zxing.h {
        /*
            r40 = this;
            r0 = r40
            r1 = r41
            com.google.zxing.g.b.d r2 = r1.f40543b
            com.google.zxing.g.b.d r3 = r1.f40544c
            com.google.zxing.g.b.d r1 = r1.f40542a
            float r4 = r0.a(r2, r3)
            float r5 = r0.a(r2, r1)
            float r4 = r4 + r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            r5 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 < 0) goto L_0x026b
            float r6 = com.google.zxing.t.a(r2, r3)
            float r6 = r6 / r4
            int r6 = com.google.zxing.b.a.a.a((float) r6)
            float r7 = com.google.zxing.t.a(r2, r1)
            float r7 = r7 / r4
            int r7 = com.google.zxing.b.a.a.a((float) r7)
            int r6 = r6 + r7
            r14 = 2
            int r6 = r6 / r14
            int r6 = r6 + 7
            r7 = r6 & 3
            r15 = 3
            if (r7 == 0) goto L_0x0046
            if (r7 == r14) goto L_0x0043
            if (r7 == r15) goto L_0x003e
        L_0x003c:
            r13 = r6
            goto L_0x0049
        L_0x003e:
            com.google.zxing.m r1 = com.google.zxing.m.getNotFoundInstance()
            throw r1
        L_0x0043:
            int r6 = r6 + -1
            goto L_0x003c
        L_0x0046:
            int r6 = r6 + 1
            goto L_0x003c
        L_0x0049:
            com.google.zxing.g.a.j r6 = com.google.zxing.g.a.j.a((int) r13)
            int r7 = r6.a()
            int r7 = r7 + -7
            r16 = 0
            int[] r6 = r6.f40516b
            int r6 = r6.length
            r17 = 1077936128(0x40400000, float:3.0)
            r11 = 0
            r10 = 1
            if (r6 <= 0) goto L_0x01e4
            float r6 = r3.f40584a
            float r8 = r2.f40584a
            float r6 = r6 - r8
            float r8 = r1.f40584a
            float r6 = r6 + r8
            float r8 = r3.f40585b
            float r9 = r2.f40585b
            float r8 = r8 - r9
            float r9 = r1.f40585b
            float r8 = r8 + r9
            float r7 = (float) r7
            float r7 = r17 / r7
            float r5 = r5 - r7
            float r7 = r2.f40584a
            float r9 = r2.f40584a
            float r6 = r6 - r9
            float r6 = r6 * r5
            float r7 = r7 + r6
            int r9 = (int) r7
            float r6 = r2.f40585b
            float r7 = r2.f40585b
            float r8 = r8 - r7
            float r5 = r5 * r8
            float r6 = r6 + r5
            int r5 = (int) r6
            r8 = 4
        L_0x0085:
            r6 = 16
            if (r8 > r6) goto L_0x01e4
            float r6 = (float) r8
            float r6 = r6 * r4
            int r6 = (int) r6
            int r7 = r9 - r6
            int r18 = java.lang.Math.max(r11, r7)     // Catch:{ m -> 0x01ca }
            com.google.zxing.b.b r7 = r0.f40533a     // Catch:{ m -> 0x01ca }
            int r7 = r7.f39889a     // Catch:{ m -> 0x01ca }
            int r7 = r7 - r10
            int r12 = r9 + r6
            int r7 = java.lang.Math.min(r7, r12)     // Catch:{ m -> 0x01ca }
            int r12 = r7 - r18
            float r7 = (float) r12     // Catch:{ m -> 0x01ca }
            float r19 = r4 * r17
            int r7 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r7 < 0) goto L_0x01bb
            int r7 = r5 - r6
            int r20 = java.lang.Math.max(r11, r7)     // Catch:{ m -> 0x01ca }
            com.google.zxing.b.b r7 = r0.f40533a     // Catch:{ m -> 0x01ca }
            int r7 = r7.f39890b     // Catch:{ m -> 0x01ca }
            int r7 = r7 - r10
            int r6 = r6 + r5
            int r6 = java.lang.Math.min(r7, r6)     // Catch:{ m -> 0x01ca }
            int r7 = r6 - r20
            float r6 = (float) r7     // Catch:{ m -> 0x01ca }
            int r6 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r6 < 0) goto L_0x01ac
            com.google.zxing.g.b.b r6 = new com.google.zxing.g.b.b     // Catch:{ m -> 0x01ca }
            com.google.zxing.b.b r10 = r0.f40533a     // Catch:{ m -> 0x01ca }
            com.google.zxing.u r14 = r0.f40534b     // Catch:{ m -> 0x01ca }
            r21 = r6
            r6 = r21
            r22 = r7
            r7 = r10
            r23 = r8
            r8 = r18
            r18 = r9
            r9 = r20
            r10 = r12
            r12 = 0
            r11 = r22
            r12 = r4
            r24 = r13
            r13 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ m -> 0x01a7 }
            int r7 = r6.f40526c     // Catch:{ m -> 0x01a7 }
            int r8 = r6.f40529f     // Catch:{ m -> 0x01a7 }
            int r9 = r6.f40528e     // Catch:{ m -> 0x01a7 }
            int r9 = r9 + r7
            int r10 = r6.f40527d     // Catch:{ m -> 0x01a7 }
            int r11 = r8 / 2
            int r10 = r10 + r11
            int[] r11 = new int[r15]     // Catch:{ m -> 0x01a7 }
            r12 = 0
        L_0x00ed:
            if (r12 >= r8) goto L_0x018a
            r13 = r12 & 1
            if (r13 != 0) goto L_0x00f8
            int r13 = r12 + 1
            r14 = 2
            int r13 = r13 / r14
            goto L_0x00fd
        L_0x00f8:
            r14 = 2
            int r13 = r12 + 1
            int r13 = r13 / r14
            int r13 = -r13
        L_0x00fd:
            int r13 = r13 + r10
            r15 = 0
            r11[r15] = r15     // Catch:{ m -> 0x01a7 }
            r14 = 1
            r11[r14] = r15     // Catch:{ m -> 0x01a7 }
            r19 = 2
            r11[r19] = r15     // Catch:{ m -> 0x01a7 }
            r15 = r7
        L_0x0109:
            if (r15 >= r9) goto L_0x0117
            com.google.zxing.b.b r14 = r6.f40524a     // Catch:{ m -> 0x01a7 }
            boolean r14 = r14.a((int) r15, (int) r13)     // Catch:{ m -> 0x01a7 }
            if (r14 != 0) goto L_0x0117
            int r15 = r15 + 1
            r14 = 1
            goto L_0x0109
        L_0x0117:
            r14 = 0
        L_0x0118:
            if (r15 >= r9) goto L_0x0170
            r19 = r4
            com.google.zxing.b.b r4 = r6.f40524a     // Catch:{ m -> 0x01a9 }
            boolean r4 = r4.a((int) r15, (int) r13)     // Catch:{ m -> 0x01a9 }
            if (r4 == 0) goto L_0x015d
            r4 = 1
            if (r14 != r4) goto L_0x0130
            r20 = r11[r4]     // Catch:{ m -> 0x01a9 }
            int r20 = r20 + 1
            r11[r4] = r20     // Catch:{ m -> 0x01a9 }
            r20 = r5
            goto L_0x0169
        L_0x0130:
            r4 = 2
            if (r14 != r4) goto L_0x0152
            boolean r14 = r6.a(r11)     // Catch:{ m -> 0x01a9 }
            if (r14 == 0) goto L_0x0143
            com.google.zxing.g.b.a r14 = r6.a(r11, r13, r15)     // Catch:{ m -> 0x01a9 }
            if (r14 == 0) goto L_0x0143
            r16 = r14
            goto L_0x01e6
        L_0x0143:
            r14 = r11[r4]     // Catch:{ m -> 0x01a9 }
            r20 = 0
            r11[r20] = r14     // Catch:{ m -> 0x01a9 }
            r14 = 1
            r11[r14] = r14     // Catch:{ m -> 0x01a9 }
            r11[r4] = r20     // Catch:{ m -> 0x01a9 }
            r20 = r5
            r14 = 1
            goto L_0x0169
        L_0x0152:
            int r14 = r14 + 1
            r4 = r11[r14]     // Catch:{ m -> 0x01a9 }
            r20 = r5
            r5 = 1
            int r4 = r4 + r5
            r11[r14] = r4     // Catch:{ m -> 0x01d4 }
            goto L_0x0169
        L_0x015d:
            r20 = r5
            r5 = 1
            if (r14 != r5) goto L_0x0164
            int r14 = r14 + 1
        L_0x0164:
            r4 = r11[r14]     // Catch:{ m -> 0x01d4 }
            int r4 = r4 + r5
            r11[r14] = r4     // Catch:{ m -> 0x01d4 }
        L_0x0169:
            int r15 = r15 + 1
            r4 = r19
            r5 = r20
            goto L_0x0118
        L_0x0170:
            r19 = r4
            r20 = r5
            boolean r4 = r6.a(r11)     // Catch:{ m -> 0x01d4 }
            if (r4 == 0) goto L_0x0181
            com.google.zxing.g.b.a r4 = r6.a(r11, r13, r9)     // Catch:{ m -> 0x01d4 }
            if (r4 == 0) goto L_0x0181
            goto L_0x019f
        L_0x0181:
            int r12 = r12 + 1
            r4 = r19
            r5 = r20
            r15 = 3
            goto L_0x00ed
        L_0x018a:
            r19 = r4
            r20 = r5
            java.util.List<com.google.zxing.g.b.a> r4 = r6.f40525b     // Catch:{ m -> 0x01d4 }
            boolean r4 = r4.isEmpty()     // Catch:{ m -> 0x01d4 }
            if (r4 != 0) goto L_0x01a2
            java.util.List<com.google.zxing.g.b.a> r4 = r6.f40525b     // Catch:{ m -> 0x01d4 }
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch:{ m -> 0x01d4 }
            com.google.zxing.g.b.a r4 = (com.google.zxing.g.b.a) r4     // Catch:{ m -> 0x01d4 }
        L_0x019f:
            r16 = r4
            goto L_0x01e6
        L_0x01a2:
            com.google.zxing.m r4 = com.google.zxing.m.getNotFoundInstance()     // Catch:{ m -> 0x01d4 }
            throw r4     // Catch:{ m -> 0x01d4 }
        L_0x01a7:
            r19 = r4
        L_0x01a9:
            r20 = r5
            goto L_0x01d4
        L_0x01ac:
            r19 = r4
            r20 = r5
            r23 = r8
            r18 = r9
            r24 = r13
            com.google.zxing.m r4 = com.google.zxing.m.getNotFoundInstance()     // Catch:{ m -> 0x01d4 }
            throw r4     // Catch:{ m -> 0x01d4 }
        L_0x01bb:
            r19 = r4
            r20 = r5
            r23 = r8
            r18 = r9
            r24 = r13
            com.google.zxing.m r4 = com.google.zxing.m.getNotFoundInstance()     // Catch:{ m -> 0x01d4 }
            throw r4     // Catch:{ m -> 0x01d4 }
        L_0x01ca:
            r19 = r4
            r20 = r5
            r23 = r8
            r18 = r9
            r24 = r13
        L_0x01d4:
            int r8 = r23 << 1
            r9 = r18
            r4 = r19
            r5 = r20
            r13 = r24
            r10 = 1
            r11 = 0
            r14 = 2
            r15 = 3
            goto L_0x0085
        L_0x01e4:
            r24 = r13
        L_0x01e6:
            r4 = r16
            r6 = r24
            float r5 = (float) r6
            r7 = 1080033280(0x40600000, float:3.5)
            float r31 = r5 - r7
            if (r4 == 0) goto L_0x01fe
            float r5 = r4.f40584a
            float r7 = r4.f40585b
            float r8 = r31 - r17
            r36 = r5
            r37 = r7
            r29 = r8
            goto L_0x0214
        L_0x01fe:
            float r5 = r3.f40584a
            float r7 = r2.f40584a
            float r5 = r5 - r7
            float r7 = r1.f40584a
            float r5 = r5 + r7
            float r7 = r3.f40585b
            float r8 = r2.f40585b
            float r7 = r7 - r8
            float r8 = r1.f40585b
            float r7 = r7 + r8
            r36 = r5
            r37 = r7
            r29 = r31
        L_0x0214:
            r24 = 1080033280(0x40600000, float:3.5)
            r25 = 1080033280(0x40600000, float:3.5)
            r27 = 1080033280(0x40600000, float:3.5)
            r30 = 1080033280(0x40600000, float:3.5)
            float r5 = r2.f40584a
            float r7 = r2.f40585b
            float r8 = r3.f40584a
            float r9 = r3.f40585b
            float r10 = r1.f40584a
            float r11 = r1.f40585b
            r26 = r31
            r28 = r29
            r32 = r5
            r33 = r7
            r34 = r8
            r35 = r9
            r38 = r10
            r39 = r11
            com.google.zxing.b.k r5 = com.google.zxing.b.k.a(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
            com.google.zxing.b.b r7 = r0.f40533a
            com.google.zxing.b.i r8 = com.google.zxing.b.i.a()
            com.google.zxing.b.b r5 = r8.a(r7, r6, r6, r5)
            if (r4 != 0) goto L_0x0255
            r6 = 3
            com.google.zxing.t[] r4 = new com.google.zxing.t[r6]
            r7 = 0
            r4[r7] = r1
            r8 = 1
            r4[r8] = r2
            r9 = 2
            r4[r9] = r3
            goto L_0x0265
        L_0x0255:
            r6 = 3
            r7 = 0
            r8 = 1
            r9 = 2
            r10 = 4
            com.google.zxing.t[] r10 = new com.google.zxing.t[r10]
            r10[r7] = r1
            r10[r8] = r2
            r10[r9] = r3
            r10[r6] = r4
            r4 = r10
        L_0x0265:
            com.google.zxing.b.g r1 = new com.google.zxing.b.g
            r1.<init>(r5, r4)
            return r1
        L_0x026b:
            com.google.zxing.m r1 = com.google.zxing.m.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.g.b.c.a(com.google.zxing.g.b.f):com.google.zxing.b.g");
    }

    private float a(t tVar, t tVar2) {
        float a2 = a((int) tVar.f40584a, (int) tVar.f40585b, (int) tVar2.f40584a, (int) tVar2.f40585b);
        float a3 = a((int) tVar2.f40584a, (int) tVar2.f40585b, (int) tVar.f40584a, (int) tVar.f40585b);
        if (Float.isNaN(a2)) {
            return a3 / 7.0f;
        }
        return Float.isNaN(a3) ? a2 / 7.0f : (a2 + a3) / 14.0f;
    }
}
