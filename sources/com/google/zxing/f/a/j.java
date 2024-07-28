package com.google.zxing.f.a;

import com.google.zxing.b.b;
import com.google.zxing.f.a.a.a;
import com.google.zxing.m;
import com.google.zxing.t;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final a f40456a = new a();

    private static boolean a(int i2, int i3, int i4) {
        return i3 + -2 <= i2 && i2 <= i4 + 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r3.f40419e != r4.f40419e) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x00c0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.b.e a(com.google.zxing.b.b r22, com.google.zxing.t r23, com.google.zxing.t r24, com.google.zxing.t r25, com.google.zxing.t r26, int r27, int r28) throws com.google.zxing.m, com.google.zxing.h, com.google.zxing.d {
        /*
            com.google.zxing.f.a.c r6 = new com.google.zxing.f.a.c
            r0 = r6
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = 0
            r9 = r6
            r2 = 0
            r3 = 0
            r4 = 0
            r10 = 0
        L_0x0016:
            r11 = 2
            if (r2 >= r11) goto L_0x00c5
            if (r23 == 0) goto L_0x0029
            r6 = 1
            r3 = r22
            r4 = r9
            r5 = r23
            r7 = r27
            r8 = r28
            com.google.zxing.f.a.h r3 = a((com.google.zxing.b.b) r3, (com.google.zxing.f.a.c) r4, (com.google.zxing.t) r5, (boolean) r6, (int) r7, (int) r8)
        L_0x0029:
            r12 = r3
            if (r25 == 0) goto L_0x003b
            r6 = 0
            r3 = r22
            r4 = r9
            r5 = r25
            r7 = r27
            r8 = r28
            com.google.zxing.f.a.h r3 = a((com.google.zxing.b.b) r3, (com.google.zxing.f.a.c) r4, (com.google.zxing.t) r5, (boolean) r6, (int) r7, (int) r8)
            r10 = r3
        L_0x003b:
            if (r12 != 0) goto L_0x0042
            if (r10 != 0) goto L_0x0042
        L_0x003f:
            r4 = 0
            goto L_0x009e
        L_0x0042:
            if (r12 == 0) goto L_0x0067
            com.google.zxing.f.a.a r3 = r12.b()
            if (r3 != 0) goto L_0x004b
            goto L_0x0067
        L_0x004b:
            if (r10 == 0) goto L_0x006f
            com.google.zxing.f.a.a r4 = r10.b()
            if (r4 != 0) goto L_0x0054
            goto L_0x006f
        L_0x0054:
            int r5 = r3.f40415a
            int r6 = r4.f40415a
            if (r5 == r6) goto L_0x006f
            int r5 = r3.f40416b
            int r6 = r4.f40416b
            if (r5 == r6) goto L_0x006f
            int r5 = r3.f40419e
            int r4 = r4.f40419e
            if (r5 == r4) goto L_0x006f
            goto L_0x0069
        L_0x0067:
            if (r10 != 0) goto L_0x006b
        L_0x0069:
            r3 = 0
            goto L_0x006f
        L_0x006b:
            com.google.zxing.f.a.a r3 = r10.b()
        L_0x006f:
            if (r3 != 0) goto L_0x0072
            goto L_0x003f
        L_0x0072:
            com.google.zxing.f.a.c r4 = a((com.google.zxing.f.a.h) r12)
            com.google.zxing.f.a.c r5 = a((com.google.zxing.f.a.h) r10)
            if (r4 != 0) goto L_0x007e
            r4 = r5
            goto L_0x0098
        L_0x007e:
            if (r5 != 0) goto L_0x0081
            goto L_0x0098
        L_0x0081:
            com.google.zxing.f.a.c r6 = new com.google.zxing.f.a.c
            com.google.zxing.b.b r14 = r4.f40430a
            com.google.zxing.t r15 = r4.f40431b
            com.google.zxing.t r4 = r4.f40432c
            com.google.zxing.t r7 = r5.f40433d
            com.google.zxing.t r5 = r5.f40434e
            r13 = r6
            r16 = r4
            r17 = r7
            r18 = r5
            r13.<init>(r14, r15, r16, r17, r18)
            r4 = r6
        L_0x0098:
            com.google.zxing.f.a.f r5 = new com.google.zxing.f.a.f
            r5.<init>(r3, r4)
            r4 = r5
        L_0x009e:
            if (r4 == 0) goto L_0x00c0
            if (r2 != 0) goto L_0x00bd
            com.google.zxing.f.a.c r3 = r4.f40450c
            if (r3 == 0) goto L_0x00bd
            com.google.zxing.f.a.c r3 = r4.f40450c
            int r3 = r3.f40437h
            int r5 = r9.f40437h
            if (r3 < r5) goto L_0x00b6
            com.google.zxing.f.a.c r3 = r4.f40450c
            int r3 = r3.f40438i
            int r5 = r9.f40438i
            if (r3 <= r5) goto L_0x00bd
        L_0x00b6:
            com.google.zxing.f.a.c r9 = r4.f40450c
            int r2 = r2 + 1
            r3 = r12
            goto L_0x0016
        L_0x00bd:
            r4.f40450c = r9
            goto L_0x00c6
        L_0x00c0:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x00c5:
            r12 = r3
        L_0x00c6:
            int r2 = r4.f40451d
            r3 = 1
            int r2 = r2 + r3
            com.google.zxing.f.a.g[] r5 = r4.f40449b
            r5[r1] = r12
            com.google.zxing.f.a.g[] r5 = r4.f40449b
            r5[r2] = r10
            if (r12 == 0) goto L_0x00d6
            r5 = 1
            goto L_0x00d7
        L_0x00d6:
            r5 = 0
        L_0x00d7:
            r7 = r27
            r8 = r28
            r6 = 1
        L_0x00dc:
            if (r6 > r2) goto L_0x01fd
            if (r5 == 0) goto L_0x00e2
            r10 = r6
            goto L_0x00e4
        L_0x00e2:
            int r10 = r2 - r6
        L_0x00e4:
            com.google.zxing.f.a.g[] r12 = r4.f40449b
            r12 = r12[r10]
            if (r12 != 0) goto L_0x01f2
            if (r10 == 0) goto L_0x00f5
            if (r10 != r2) goto L_0x00ef
            goto L_0x00f5
        L_0x00ef:
            com.google.zxing.f.a.g r12 = new com.google.zxing.f.a.g
            r12.<init>(r9)
            goto L_0x00ff
        L_0x00f5:
            com.google.zxing.f.a.h r12 = new com.google.zxing.f.a.h
            if (r10 != 0) goto L_0x00fb
            r13 = 1
            goto L_0x00fc
        L_0x00fb:
            r13 = 0
        L_0x00fc:
            r12.<init>(r9, r13)
        L_0x00ff:
            com.google.zxing.f.a.g[] r13 = r4.f40449b
            r13[r10] = r12
            int r13 = r9.f40437h
            r14 = r7
            r7 = r13
            r13 = r8
            r8 = -1
        L_0x0109:
            int r0 = r9.f40438i
            if (r7 > r0) goto L_0x01eb
            if (r5 == 0) goto L_0x0111
            r0 = 1
            goto L_0x0112
        L_0x0111:
            r0 = -1
        L_0x0112:
            int r3 = r10 - r0
            boolean r16 = a(r4, r3)
            if (r16 == 0) goto L_0x0123
            com.google.zxing.f.a.g[] r1 = r4.f40449b
            r1 = r1[r3]
            com.google.zxing.f.a.d r1 = r1.c(r7)
            goto L_0x0124
        L_0x0123:
            r1 = 0
        L_0x0124:
            if (r1 == 0) goto L_0x0131
            if (r5 == 0) goto L_0x012b
            int r0 = r1.f40440b
            goto L_0x012d
        L_0x012b:
            int r0 = r1.f40439a
        L_0x012d:
            r21 = r2
            goto L_0x01a2
        L_0x0131:
            com.google.zxing.f.a.g[] r1 = r4.f40449b
            r1 = r1[r10]
            com.google.zxing.f.a.d r1 = r1.a(r7)
            if (r1 == 0) goto L_0x0143
            if (r5 == 0) goto L_0x0140
            int r0 = r1.f40439a
            goto L_0x012d
        L_0x0140:
            int r0 = r1.f40440b
            goto L_0x012d
        L_0x0143:
            boolean r16 = a(r4, r3)
            if (r16 == 0) goto L_0x0151
            com.google.zxing.f.a.g[] r1 = r4.f40449b
            r1 = r1[r3]
            com.google.zxing.f.a.d r1 = r1.a(r7)
        L_0x0151:
            if (r1 == 0) goto L_0x015b
            if (r5 == 0) goto L_0x0158
            int r0 = r1.f40440b
            goto L_0x012d
        L_0x0158:
            int r0 = r1.f40439a
            goto L_0x012d
        L_0x015b:
            r1 = r10
            r3 = 0
        L_0x015d:
            int r1 = r1 - r0
            boolean r16 = a(r4, r1)
            if (r16 == 0) goto L_0x0195
            com.google.zxing.f.a.g[] r11 = r4.f40449b
            r11 = r11[r1]
            com.google.zxing.f.a.d[] r11 = r11.f40453b
            int r15 = r11.length
            r27 = r1
            r1 = 0
        L_0x016e:
            if (r1 >= r15) goto L_0x018d
            r21 = r2
            r2 = r11[r1]
            if (r2 == 0) goto L_0x0188
            if (r5 == 0) goto L_0x017b
            int r1 = r2.f40440b
            goto L_0x017d
        L_0x017b:
            int r1 = r2.f40439a
        L_0x017d:
            int r0 = r0 * r3
            int r3 = r2.f40440b
            int r2 = r2.f40439a
            int r3 = r3 - r2
            int r0 = r0 * r3
            int r0 = r0 + r1
            goto L_0x01a2
        L_0x0188:
            int r1 = r1 + 1
            r2 = r21
            goto L_0x016e
        L_0x018d:
            r21 = r2
            int r3 = r3 + 1
            r1 = r27
            r11 = 2
            goto L_0x015d
        L_0x0195:
            r21 = r2
            if (r5 == 0) goto L_0x019e
            com.google.zxing.f.a.c r0 = r4.f40450c
            int r0 = r0.f40435f
            goto L_0x01a2
        L_0x019e:
            com.google.zxing.f.a.c r0 = r4.f40450c
            int r0 = r0.f40436g
        L_0x01a2:
            if (r0 < 0) goto L_0x01ac
            int r1 = r9.f40436g
            if (r0 <= r1) goto L_0x01a9
            goto L_0x01ac
        L_0x01a9:
            r1 = r0
            r0 = -1
            goto L_0x01b0
        L_0x01ac:
            r0 = -1
            if (r8 == r0) goto L_0x01de
            r1 = r8
        L_0x01b0:
            int r2 = r9.f40435f
            int r15 = r9.f40436g
            r3 = r13
            r13 = r22
            r11 = r14
            r14 = r2
            r16 = r5
            r17 = r1
            r18 = r7
            r19 = r11
            r20 = r3
            com.google.zxing.f.a.d r2 = a(r13, r14, r15, r16, r17, r18, r19, r20)
            if (r2 == 0) goto L_0x01e0
            r12.a(r7, r2)
            int r8 = r2.c()
            int r14 = java.lang.Math.min(r11, r8)
            int r2 = r2.c()
            int r13 = java.lang.Math.max(r3, r2)
            r8 = r1
            goto L_0x01e2
        L_0x01de:
            r3 = r13
            r11 = r14
        L_0x01e0:
            r13 = r3
            r14 = r11
        L_0x01e2:
            int r7 = r7 + 1
            r2 = r21
            r1 = 0
            r3 = 1
            r11 = 2
            goto L_0x0109
        L_0x01eb:
            r21 = r2
            r3 = r13
            r11 = r14
            r8 = r3
            r7 = r11
            goto L_0x01f4
        L_0x01f2:
            r21 = r2
        L_0x01f4:
            int r6 = r6 + 1
            r2 = r21
            r1 = 0
            r3 = 1
            r11 = 2
            goto L_0x00dc
        L_0x01fd:
            com.google.zxing.f.a.a r0 = r4.f40448a
            int r0 = r0.f40419e
            int r1 = r4.f40451d
            r2 = 2
            int r1 = r1 + r2
            int[] r0 = new int[]{r0, r1}
            java.lang.Class<com.google.zxing.f.a.b> r1 = com.google.zxing.f.a.b.class
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r1, r0)
            com.google.zxing.f.a.b[][] r0 = (com.google.zxing.f.a.b[][]) r0
            r1 = 0
        L_0x0212:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x022a
            r2 = 0
        L_0x0216:
            r3 = r0[r1]
            int r3 = r3.length
            if (r2 >= r3) goto L_0x0227
            r3 = r0[r1]
            com.google.zxing.f.a.b r5 = new com.google.zxing.f.a.b
            r5.<init>()
            r3[r2] = r5
            int r2 = r2 + 1
            goto L_0x0216
        L_0x0227:
            int r1 = r1 + 1
            goto L_0x0212
        L_0x022a:
            com.google.zxing.f.a.g[] r1 = r4.f40449b
            r2 = 0
            r1 = r1[r2]
            r4.a(r1)
            com.google.zxing.f.a.g[] r1 = r4.f40449b
            int r3 = r4.f40451d
            r5 = 1
            int r3 = r3 + r5
            r1 = r1[r3]
            r4.a(r1)
            r1 = 928(0x3a0, float:1.3E-42)
            r3 = 928(0x3a0, float:1.3E-42)
        L_0x0241:
            com.google.zxing.f.a.g[] r6 = r4.f40449b
            r6 = r6[r2]
            if (r6 == 0) goto L_0x02a3
            com.google.zxing.f.a.g[] r6 = r4.f40449b
            int r7 = r4.f40451d
            int r7 = r7 + r5
            r6 = r6[r7]
            if (r6 != 0) goto L_0x0251
            goto L_0x02a3
        L_0x0251:
            com.google.zxing.f.a.g[] r6 = r4.f40449b
            r6 = r6[r2]
            com.google.zxing.f.a.d[] r2 = r6.f40453b
            com.google.zxing.f.a.g[] r6 = r4.f40449b
            int r7 = r4.f40451d
            int r7 = r7 + r5
            r5 = r6[r7]
            com.google.zxing.f.a.d[] r5 = r5.f40453b
            r6 = 0
        L_0x0261:
            int r7 = r2.length
            if (r6 >= r7) goto L_0x02a3
            r7 = r2[r6]
            if (r7 == 0) goto L_0x029f
            r7 = r5[r6]
            if (r7 == 0) goto L_0x029f
            r7 = r2[r6]
            int r7 = r7.f40443e
            r8 = r5[r6]
            int r8 = r8.f40443e
            if (r7 != r8) goto L_0x029f
            r7 = 1
        L_0x0277:
            int r8 = r4.f40451d
            if (r7 > r8) goto L_0x029f
            com.google.zxing.f.a.g[] r8 = r4.f40449b
            r8 = r8[r7]
            com.google.zxing.f.a.d[] r8 = r8.f40453b
            r8 = r8[r6]
            if (r8 == 0) goto L_0x029b
            r9 = r2[r6]
            int r9 = r9.f40443e
            r8.f40443e = r9
            boolean r8 = r8.a()
            if (r8 != 0) goto L_0x029b
            com.google.zxing.f.a.g[] r8 = r4.f40449b
            r8 = r8[r7]
            com.google.zxing.f.a.d[] r8 = r8.f40453b
            r9 = 0
            r8[r6] = r9
            goto L_0x029c
        L_0x029b:
            r9 = 0
        L_0x029c:
            int r7 = r7 + 1
            goto L_0x0277
        L_0x029f:
            r9 = 0
            int r6 = r6 + 1
            goto L_0x0261
        L_0x02a3:
            r9 = 0
            com.google.zxing.f.a.g[] r2 = r4.f40449b
            r5 = 0
            r2 = r2[r5]
            if (r2 != 0) goto L_0x02ac
            goto L_0x02e9
        L_0x02ac:
            com.google.zxing.f.a.g[] r2 = r4.f40449b
            r2 = r2[r5]
            com.google.zxing.f.a.d[] r2 = r2.f40453b
            r5 = 0
            r6 = 0
        L_0x02b4:
            int r7 = r2.length
            if (r5 >= r7) goto L_0x02e8
            r7 = r2[r5]
            if (r7 == 0) goto L_0x02e5
            r7 = r2[r5]
            int r7 = r7.f40443e
            r10 = r6
            r6 = 1
            r8 = 0
        L_0x02c2:
            int r11 = r4.f40451d
            r12 = 1
            int r11 = r11 + r12
            if (r6 >= r11) goto L_0x02e4
            r11 = 2
            if (r8 >= r11) goto L_0x02e4
            com.google.zxing.f.a.g[] r11 = r4.f40449b
            r11 = r11[r6]
            com.google.zxing.f.a.d[] r11 = r11.f40453b
            r11 = r11[r5]
            if (r11 == 0) goto L_0x02e1
            int r8 = com.google.zxing.f.a.f.a(r7, r8, r11)
            boolean r11 = r11.a()
            if (r11 != 0) goto L_0x02e1
            int r10 = r10 + 1
        L_0x02e1:
            int r6 = r6 + 1
            goto L_0x02c2
        L_0x02e4:
            r6 = r10
        L_0x02e5:
            int r5 = r5 + 1
            goto L_0x02b4
        L_0x02e8:
            r5 = r6
        L_0x02e9:
            com.google.zxing.f.a.g[] r2 = r4.f40449b
            int r6 = r4.f40451d
            r7 = 1
            int r6 = r6 + r7
            r2 = r2[r6]
            if (r2 != 0) goto L_0x02f5
            r8 = 0
            goto L_0x0331
        L_0x02f5:
            com.google.zxing.f.a.g[] r2 = r4.f40449b
            int r6 = r4.f40451d
            int r6 = r6 + r7
            r2 = r2[r6]
            com.google.zxing.f.a.d[] r2 = r2.f40453b
            r6 = 0
            r8 = 0
        L_0x0300:
            int r10 = r2.length
            if (r6 >= r10) goto L_0x0331
            r10 = r2[r6]
            if (r10 == 0) goto L_0x032d
            r10 = r2[r6]
            int r10 = r10.f40443e
            int r11 = r4.f40451d
            int r11 = r11 + r7
            r7 = 0
        L_0x030f:
            if (r11 <= 0) goto L_0x032d
            r12 = 2
            if (r7 >= r12) goto L_0x032d
            com.google.zxing.f.a.g[] r12 = r4.f40449b
            r12 = r12[r11]
            com.google.zxing.f.a.d[] r12 = r12.f40453b
            r12 = r12[r6]
            if (r12 == 0) goto L_0x032a
            int r7 = com.google.zxing.f.a.f.a(r10, r7, r12)
            boolean r12 = r12.a()
            if (r12 != 0) goto L_0x032a
            int r8 = r8 + 1
        L_0x032a:
            int r11 = r11 + -1
            goto L_0x030f
        L_0x032d:
            int r6 = r6 + 1
            r7 = 1
            goto L_0x0300
        L_0x0331:
            int r2 = r5 + r8
            if (r2 != 0) goto L_0x0338
            r2 = 0
            goto L_0x03fd
        L_0x0338:
            r5 = 1
        L_0x0339:
            int r6 = r4.f40451d
            r7 = 1
            int r6 = r6 + r7
            if (r5 >= r6) goto L_0x03fd
            com.google.zxing.f.a.g[] r6 = r4.f40449b
            r6 = r6[r5]
            com.google.zxing.f.a.d[] r6 = r6.f40453b
            r7 = 0
        L_0x0346:
            int r8 = r6.length
            if (r7 >= r8) goto L_0x03f9
            r8 = r6[r7]
            if (r8 == 0) goto L_0x03f5
            r8 = r6[r7]
            boolean r8 = r8.a()
            if (r8 != 0) goto L_0x03f5
            r8 = r6[r7]
            com.google.zxing.f.a.g[] r10 = r4.f40449b
            int r11 = r5 + -1
            r10 = r10[r11]
            com.google.zxing.f.a.d[] r10 = r10.f40453b
            com.google.zxing.f.a.g[] r11 = r4.f40449b
            int r12 = r5 + 1
            r11 = r11[r12]
            if (r11 == 0) goto L_0x036e
            com.google.zxing.f.a.g[] r11 = r4.f40449b
            r11 = r11[r12]
            com.google.zxing.f.a.d[] r11 = r11.f40453b
            goto L_0x036f
        L_0x036e:
            r11 = r10
        L_0x036f:
            r12 = 14
            com.google.zxing.f.a.d[] r13 = new com.google.zxing.f.a.d[r12]
            r14 = r10[r7]
            r15 = 2
            r13[r15] = r14
            r14 = 3
            r15 = r11[r7]
            r13[r14] = r15
            if (r7 <= 0) goto L_0x0391
            int r14 = r7 + -1
            r15 = r6[r14]
            r16 = 0
            r13[r16] = r15
            r15 = 4
            r16 = r10[r14]
            r13[r15] = r16
            r15 = 5
            r14 = r11[r14]
            r13[r15] = r14
        L_0x0391:
            r14 = 1
            if (r7 <= r14) goto L_0x03a8
            r14 = 8
            int r15 = r7 + -2
            r16 = r6[r15]
            r13[r14] = r16
            r14 = 10
            r16 = r10[r15]
            r13[r14] = r16
            r14 = 11
            r15 = r11[r15]
            r13[r14] = r15
        L_0x03a8:
            int r14 = r6.length
            r15 = 1
            int r14 = r14 - r15
            if (r7 >= r14) goto L_0x03bd
            int r14 = r7 + 1
            r16 = r6[r14]
            r13[r15] = r16
            r15 = 6
            r16 = r10[r14]
            r13[r15] = r16
            r15 = 7
            r14 = r11[r14]
            r13[r15] = r14
        L_0x03bd:
            int r14 = r6.length
            r15 = 2
            int r14 = r14 - r15
            if (r7 >= r14) goto L_0x03d6
            r14 = 9
            int r15 = r7 + 2
            r16 = r6[r15]
            r13[r14] = r16
            r14 = 12
            r10 = r10[r15]
            r13[r14] = r10
            r10 = 13
            r11 = r11[r15]
            r13[r10] = r11
        L_0x03d6:
            r10 = 0
        L_0x03d7:
            if (r10 >= r12) goto L_0x03f5
            r11 = r13[r10]
            if (r11 == 0) goto L_0x03ef
            boolean r14 = r11.a()
            if (r14 == 0) goto L_0x03ef
            int r14 = r11.f40441c
            int r15 = r8.f40441c
            if (r14 != r15) goto L_0x03ef
            int r11 = r11.f40443e
            r8.f40443e = r11
            r11 = 1
            goto L_0x03f0
        L_0x03ef:
            r11 = 0
        L_0x03f0:
            if (r11 != 0) goto L_0x03f5
            int r10 = r10 + 1
            goto L_0x03d7
        L_0x03f5:
            int r7 = r7 + 1
            goto L_0x0346
        L_0x03f9:
            int r5 = r5 + 1
            goto L_0x0339
        L_0x03fd:
            if (r2 <= 0) goto L_0x0407
            if (r2 < r3) goto L_0x0402
            goto L_0x0407
        L_0x0402:
            r3 = r2
            r2 = 0
            r5 = 1
            goto L_0x0241
        L_0x0407:
            com.google.zxing.f.a.g[] r2 = r4.f40449b
            int r3 = r2.length
            r5 = 0
            r6 = 0
        L_0x040c:
            if (r5 >= r3) goto L_0x0434
            r7 = r2[r5]
            if (r7 == 0) goto L_0x042f
            com.google.zxing.f.a.d[] r7 = r7.f40453b
            int r8 = r7.length
            r9 = 0
        L_0x0416:
            if (r9 >= r8) goto L_0x042f
            r10 = r7[r9]
            if (r10 == 0) goto L_0x042c
            int r11 = r10.f40443e
            if (r11 < 0) goto L_0x042c
            int r12 = r0.length
            if (r11 >= r12) goto L_0x042c
            r11 = r0[r11]
            r11 = r11[r6]
            int r10 = r10.f40442d
            r11.a(r10)
        L_0x042c:
            int r9 = r9 + 1
            goto L_0x0416
        L_0x042f:
            int r6 = r6 + 1
            int r5 = r5 + 1
            goto L_0x040c
        L_0x0434:
            r5 = 0
            r2 = r0[r5]
            r3 = 1
            r2 = r2[r3]
            int[] r3 = r2.a()
            int r5 = r4.f40451d
            com.google.zxing.f.a.a r6 = r4.f40448a
            int r6 = r6.f40419e
            int r5 = r5 * r6
            com.google.zxing.f.a.a r6 = r4.f40448a
            int r6 = r6.f40416b
            r7 = 2
            int r6 = r7 << r6
            int r5 = r5 - r6
            int r6 = r3.length
            if (r6 != 0) goto L_0x045e
            if (r5 <= 0) goto L_0x0459
            if (r5 > r1) goto L_0x0459
            r2.a(r5)
            goto L_0x0466
        L_0x0459:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x045e:
            r1 = 0
            r3 = r3[r1]
            if (r3 == r5) goto L_0x0466
            r2.a(r5)
        L_0x0466:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.google.zxing.f.a.a r2 = r4.f40448a
            int r2 = r2.f40419e
            int r3 = r4.f40451d
            int r2 = r2 * r3
            int[] r2 = new int[r2]
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
        L_0x0480:
            com.google.zxing.f.a.a r7 = r4.f40448a
            int r7 = r7.f40419e
            if (r6 >= r7) goto L_0x04c3
            r7 = 0
        L_0x0487:
            int r8 = r4.f40451d
            if (r7 >= r8) goto L_0x04be
            r8 = r0[r6]
            int r9 = r7 + 1
            r8 = r8[r9]
            int[] r8 = r8.a()
            int r10 = r4.f40451d
            int r10 = r10 * r6
            int r10 = r10 + r7
            int r7 = r8.length
            if (r7 != 0) goto L_0x04a7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r1.add(r7)
            r7 = 0
            r11 = 1
            goto L_0x04bc
        L_0x04a7:
            int r7 = r8.length
            r11 = 1
            if (r7 != r11) goto L_0x04b1
            r7 = 0
            r8 = r8[r7]
            r2[r10] = r8
            goto L_0x04bc
        L_0x04b1:
            r7 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r5.add(r10)
            r3.add(r8)
        L_0x04bc:
            r7 = r9
            goto L_0x0487
        L_0x04be:
            r7 = 0
            r11 = 1
            int r6 = r6 + 1
            goto L_0x0480
        L_0x04c3:
            r7 = 0
            int r0 = r3.size()
            int[][] r0 = new int[r0][]
        L_0x04ca:
            int r6 = r0.length
            if (r7 >= r6) goto L_0x04d8
            java.lang.Object r6 = r3.get(r7)
            int[] r6 = (int[]) r6
            r0[r7] = r6
            int r7 = r7 + 1
            goto L_0x04ca
        L_0x04d8:
            com.google.zxing.f.a.a r3 = r4.f40448a
            int r3 = r3.f40416b
            int[] r1 = com.google.zxing.f.a.a((java.util.Collection<java.lang.Integer>) r1)
            int[] r4 = com.google.zxing.f.a.a((java.util.Collection<java.lang.Integer>) r5)
            com.google.zxing.b.e r0 = a(r3, r2, r1, r4, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.a.j.a(com.google.zxing.b.b, com.google.zxing.t, com.google.zxing.t, com.google.zxing.t, com.google.zxing.t, int, int):com.google.zxing.b.e");
    }

    private static c a(h hVar) throws m {
        int[] a2;
        if (hVar == null || (a2 = hVar.a()) == null) {
            return null;
        }
        int a3 = a(a2);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : a2) {
            i3 += a3 - i4;
            if (i4 > 0) {
                break;
            }
        }
        d[] dVarArr = hVar.f40453b;
        int i5 = 0;
        while (i3 > 0 && dVarArr[i5] == null) {
            i3--;
            i5++;
        }
        for (int length = a2.length - 1; length >= 0; length--) {
            i2 += a3 - a2[length];
            if (a2[length] > 0) {
                break;
            }
        }
        int length2 = dVarArr.length - 1;
        while (i2 > 0 && dVarArr[length2] == null) {
            i2--;
            length2--;
        }
        return hVar.f40452a.a(i3, i2, hVar.f40454c);
    }

    private static int a(int[] iArr) {
        int i2 = -1;
        for (int max : iArr) {
            i2 = Math.max(i2, max);
        }
        return i2;
    }

    private static h a(b bVar, c cVar, t tVar, boolean z, int i2, int i3) {
        c cVar2 = cVar;
        t tVar2 = tVar;
        boolean z2 = z;
        h hVar = new h(cVar2, z2);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int i6 = (int) tVar2.f40584a;
            int i7 = (int) tVar2.f40585b;
            while (i7 <= cVar2.f40438i && i7 >= cVar2.f40437h) {
                d a2 = a(bVar, 0, bVar.f39889a, z, i6, i7, i2, i3);
                if (a2 != null) {
                    hVar.a(i7, a2);
                    if (z2) {
                        i6 = a2.f40439a;
                    } else {
                        i6 = a2.f40440b;
                    }
                }
                i7 += i5;
            }
            i4++;
        }
        return hVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0220, code lost:
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0226, code lost:
        throw com.google.zxing.d.getChecksumInstance();
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x025d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.zxing.b.e a(int r20, int[] r21, int[] r22, int[] r23, int[][] r24) throws com.google.zxing.h, com.google.zxing.d {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            int r3 = r2.length
            int[] r3 = new int[r3]
            r4 = 100
        L_0x000b:
            int r5 = r4 + -1
            if (r4 <= 0) goto L_0x0262
            r6 = 0
        L_0x0010:
            int r7 = r3.length
            if (r6 >= r7) goto L_0x0020
            r7 = r2[r6]
            r8 = r24[r6]
            r9 = r3[r6]
            r8 = r8[r9]
            r0[r7] = r8
            int r6 = r6 + 1
            goto L_0x0010
        L_0x0020:
            r6 = 1
            int r7 = r0.length     // Catch:{ d -> 0x0230 }
            if (r7 == 0) goto L_0x0227
            int r7 = r20 + 1
            int r7 = r6 << r7
            if (r1 == 0) goto L_0x0031
            int r8 = r1.length     // Catch:{ d -> 0x0230 }
            int r9 = r7 / 2
            int r9 = r9 + 3
            if (r8 > r9) goto L_0x0220
        L_0x0031:
            if (r7 < 0) goto L_0x0220
            r8 = 512(0x200, float:7.175E-43)
            if (r7 > r8) goto L_0x0220
            com.google.zxing.f.a.a.a r8 = f40456a     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.c r9 = new com.google.zxing.f.a.a.c     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.b r10 = r8.f40420a     // Catch:{ d -> 0x0230 }
            r9.<init>(r10, r0)     // Catch:{ d -> 0x0230 }
            int[] r10 = new int[r7]     // Catch:{ d -> 0x0230 }
            r11 = r7
            r12 = 0
        L_0x0044:
            if (r11 <= 0) goto L_0x005a
            com.google.zxing.f.a.a.b r13 = r8.f40420a     // Catch:{ d -> 0x0230 }
            int[] r13 = r13.f40422b     // Catch:{ d -> 0x0230 }
            r13 = r13[r11]     // Catch:{ d -> 0x0230 }
            int r13 = r9.b((int) r13)     // Catch:{ d -> 0x0230 }
            int r14 = r7 - r11
            r10[r14] = r13     // Catch:{ d -> 0x0230 }
            if (r13 == 0) goto L_0x0057
            r12 = 1
        L_0x0057:
            int r11 = r11 + -1
            goto L_0x0044
        L_0x005a:
            if (r12 != 0) goto L_0x0061
            r16 = r5
            r4 = 0
            goto L_0x01e1
        L_0x0061:
            com.google.zxing.f.a.a.b r9 = r8.f40420a     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.c r9 = r9.f40425e     // Catch:{ d -> 0x0230 }
            r11 = 2
            if (r1 == 0) goto L_0x0098
            int r12 = r1.length     // Catch:{ d -> 0x0230 }
            r13 = r9
            r9 = 0
        L_0x006b:
            if (r9 >= r12) goto L_0x0098
            r14 = r1[r9]     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.b r15 = r8.f40420a     // Catch:{ d -> 0x0230 }
            int r4 = r0.length     // Catch:{ d -> 0x0230 }
            int r4 = r4 - r6
            int r4 = r4 - r14
            int[] r14 = r15.f40422b     // Catch:{ d -> 0x0230 }
            r4 = r14[r4]     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.c r14 = new com.google.zxing.f.a.a.c     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.b r15 = r8.f40420a     // Catch:{ d -> 0x0230 }
            int[] r6 = new int[r11]     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.b r11 = r8.f40420a     // Catch:{ d -> 0x0230 }
            r2 = 0
            int r4 = r11.c(r2, r4)     // Catch:{ d -> 0x0230 }
            r6[r2] = r4     // Catch:{ d -> 0x0230 }
            r2 = 1
            r6[r2] = r2     // Catch:{ d -> 0x0230 }
            r14.<init>(r15, r6)     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.c r13 = r13.c((com.google.zxing.f.a.a.c) r14)     // Catch:{ d -> 0x0230 }
            int r9 = r9 + 1
            r2 = r23
            r6 = 1
            r11 = 2
            goto L_0x006b
        L_0x0098:
            com.google.zxing.f.a.a.c r2 = new com.google.zxing.f.a.a.c     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.b r4 = r8.f40420a     // Catch:{ d -> 0x0230 }
            r2.<init>(r4, r10)     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.b r4 = r8.f40420a     // Catch:{ d -> 0x0230 }
            r6 = 1
            com.google.zxing.f.a.a.c r4 = r4.a(r7, r6)     // Catch:{ d -> 0x0230 }
            int[] r9 = r4.f40428b     // Catch:{ d -> 0x0230 }
            int r9 = r9.length     // Catch:{ d -> 0x0230 }
            int r9 = r9 - r6
            int[] r10 = r2.f40428b     // Catch:{ d -> 0x0230 }
            int r10 = r10.length     // Catch:{ d -> 0x0230 }
            int r10 = r10 - r6
            if (r9 >= r10) goto L_0x00b1
            goto L_0x00b6
        L_0x00b1:
            r18 = r4
            r4 = r2
            r2 = r18
        L_0x00b6:
            com.google.zxing.f.a.a.b r6 = r8.f40420a     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.c r6 = r6.f40424d     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.b r9 = r8.f40420a     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.c r9 = r9.f40425e     // Catch:{ d -> 0x0230 }
            r18 = r4
            r4 = r2
            r2 = r18
            r19 = r9
            r9 = r6
            r6 = r19
        L_0x00c8:
            int[] r10 = r2.f40428b     // Catch:{ d -> 0x0230 }
            int r10 = r10.length     // Catch:{ d -> 0x0230 }
            r11 = 1
            int r10 = r10 - r11
            int r11 = r7 / 2
            if (r10 < r11) goto L_0x0186
            boolean r10 = r2.a()     // Catch:{ d -> 0x0230 }
            if (r10 != 0) goto L_0x017f
            com.google.zxing.f.a.a.b r10 = r8.f40420a     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.c r10 = r10.f40424d     // Catch:{ d -> 0x0230 }
            int[] r11 = r2.f40428b     // Catch:{ d -> 0x0230 }
            int r11 = r11.length     // Catch:{ d -> 0x0230 }
            r12 = 1
            int r11 = r11 - r12
            int r11 = r2.a((int) r11)     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.b r12 = r8.f40420a     // Catch:{ d -> 0x0230 }
            int r11 = r12.a(r11)     // Catch:{ d -> 0x0230 }
        L_0x00ea:
            int[] r12 = r4.f40428b     // Catch:{ d -> 0x0230 }
            int r12 = r12.length     // Catch:{ d -> 0x0230 }
            r13 = 1
            int r12 = r12 - r13
            int[] r14 = r2.f40428b     // Catch:{ d -> 0x0230 }
            int r14 = r14.length     // Catch:{ d -> 0x0230 }
            int r14 = r14 - r13
            if (r12 < r14) goto L_0x0166
            boolean r12 = r4.a()     // Catch:{ d -> 0x0230 }
            if (r12 != 0) goto L_0x0166
            int[] r12 = r4.f40428b     // Catch:{ d -> 0x0230 }
            int r12 = r12.length     // Catch:{ d -> 0x0230 }
            int r12 = r12 - r13
            int[] r14 = r2.f40428b     // Catch:{ d -> 0x0230 }
            int r14 = r14.length     // Catch:{ d -> 0x0230 }
            int r14 = r14 - r13
            int r12 = r12 - r14
            com.google.zxing.f.a.a.b r14 = r8.f40420a     // Catch:{ d -> 0x0230 }
            int[] r15 = r4.f40428b     // Catch:{ d -> 0x0230 }
            int r15 = r15.length     // Catch:{ d -> 0x0230 }
            int r15 = r15 - r13
            int r13 = r4.a((int) r15)     // Catch:{ d -> 0x0230 }
            int r13 = r14.d(r13, r11)     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.b r14 = r8.f40420a     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.c r14 = r14.a(r12, r13)     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.c r10 = r10.a((com.google.zxing.f.a.a.c) r14)     // Catch:{ d -> 0x0230 }
            if (r12 < 0) goto L_0x015e
            if (r13 != 0) goto L_0x0129
            com.google.zxing.f.a.a.b r12 = r2.f40427a     // Catch:{ d -> 0x0230 }
            com.google.zxing.f.a.a.c r12 = r12.f40424d     // Catch:{ d -> 0x0230 }
            r16 = r5
            r17 = r10
            goto L_0x0155
        L_0x0129:
            int[] r14 = r2.f40428b     // Catch:{ d -> 0x0230 }
            int r14 = r14.length     // Catch:{ d -> 0x0230 }
            int r12 = r12 + r14
            int[] r12 = new int[r12]     // Catch:{ d -> 0x0230 }
            r15 = 0
        L_0x0130:
            if (r15 >= r14) goto L_0x0149
            r16 = r5
            com.google.zxing.f.a.a.b r5 = r2.f40427a     // Catch:{ d -> 0x022e }
            r17 = r10
            int[] r10 = r2.f40428b     // Catch:{ d -> 0x022e }
            r10 = r10[r15]     // Catch:{ d -> 0x022e }
            int r5 = r5.d(r10, r13)     // Catch:{ d -> 0x022e }
            r12[r15] = r5     // Catch:{ d -> 0x022e }
            int r15 = r15 + 1
            r5 = r16
            r10 = r17
            goto L_0x0130
        L_0x0149:
            r16 = r5
            r17 = r10
            com.google.zxing.f.a.a.c r5 = new com.google.zxing.f.a.a.c     // Catch:{ d -> 0x022e }
            com.google.zxing.f.a.a.b r10 = r2.f40427a     // Catch:{ d -> 0x022e }
            r5.<init>(r10, r12)     // Catch:{ d -> 0x022e }
            r12 = r5
        L_0x0155:
            com.google.zxing.f.a.a.c r4 = r4.b((com.google.zxing.f.a.a.c) r12)     // Catch:{ d -> 0x022e }
            r5 = r16
            r10 = r17
            goto L_0x00ea
        L_0x015e:
            r16 = r5
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ d -> 0x022e }
            r2.<init>()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x0166:
            r16 = r5
            com.google.zxing.f.a.a.c r5 = r10.c((com.google.zxing.f.a.a.c) r6)     // Catch:{ d -> 0x022e }
            com.google.zxing.f.a.a.c r5 = r5.b((com.google.zxing.f.a.a.c) r9)     // Catch:{ d -> 0x022e }
            com.google.zxing.f.a.a.c r5 = r5.b()     // Catch:{ d -> 0x022e }
            r9 = r6
            r6 = r5
            r5 = r16
            r18 = r4
            r4 = r2
            r2 = r18
            goto L_0x00c8
        L_0x017f:
            r16 = r5
            com.google.zxing.d r2 = com.google.zxing.d.getChecksumInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x0186:
            r16 = r5
            r4 = 0
            int r5 = r6.a((int) r4)     // Catch:{ d -> 0x022e }
            if (r5 == 0) goto L_0x021b
            com.google.zxing.f.a.a.b r4 = r8.f40420a     // Catch:{ d -> 0x022e }
            int r4 = r4.a(r5)     // Catch:{ d -> 0x022e }
            com.google.zxing.f.a.a.c r5 = r6.c((int) r4)     // Catch:{ d -> 0x022e }
            com.google.zxing.f.a.a.c r2 = r2.c((int) r4)     // Catch:{ d -> 0x022e }
            r4 = 2
            com.google.zxing.f.a.a.c[] r4 = new com.google.zxing.f.a.a.c[r4]     // Catch:{ d -> 0x022e }
            r6 = 0
            r4[r6] = r5     // Catch:{ d -> 0x022e }
            r5 = 1
            r4[r5] = r2     // Catch:{ d -> 0x022e }
            r2 = r4[r6]     // Catch:{ d -> 0x022e }
            r4 = r4[r5]     // Catch:{ d -> 0x022e }
            int[] r5 = r8.a(r2)     // Catch:{ d -> 0x022e }
            int[] r2 = r8.a(r4, r2, r5)     // Catch:{ d -> 0x022e }
            r4 = 0
        L_0x01b3:
            int r6 = r5.length     // Catch:{ d -> 0x022e }
            if (r4 >= r6) goto L_0x01e0
            int r6 = r0.length     // Catch:{ d -> 0x022e }
            r9 = 1
            int r6 = r6 - r9
            com.google.zxing.f.a.a.b r9 = r8.f40420a     // Catch:{ d -> 0x022e }
            r10 = r5[r4]     // Catch:{ d -> 0x022e }
            if (r10 == 0) goto L_0x01da
            int[] r9 = r9.f40423c     // Catch:{ d -> 0x022e }
            r9 = r9[r10]     // Catch:{ d -> 0x022e }
            int r6 = r6 - r9
            if (r6 < 0) goto L_0x01d5
            com.google.zxing.f.a.a.b r9 = r8.f40420a     // Catch:{ d -> 0x022e }
            r10 = r0[r6]     // Catch:{ d -> 0x022e }
            r11 = r2[r4]     // Catch:{ d -> 0x022e }
            int r9 = r9.c(r10, r11)     // Catch:{ d -> 0x022e }
            r0[r6] = r9     // Catch:{ d -> 0x022e }
            int r4 = r4 + 1
            goto L_0x01b3
        L_0x01d5:
            com.google.zxing.d r2 = com.google.zxing.d.getChecksumInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x01da:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ d -> 0x022e }
            r2.<init>()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x01e0:
            int r4 = r5.length     // Catch:{ d -> 0x022e }
        L_0x01e1:
            int r2 = r0.length     // Catch:{ d -> 0x022e }
            r5 = 4
            if (r2 < r5) goto L_0x0216
            r2 = 0
            r5 = r0[r2]     // Catch:{ d -> 0x022e }
            int r2 = r0.length     // Catch:{ d -> 0x022e }
            if (r5 > r2) goto L_0x0211
            if (r5 != 0) goto L_0x01fb
            int r2 = r0.length     // Catch:{ d -> 0x022e }
            if (r7 >= r2) goto L_0x01f6
            int r2 = r0.length     // Catch:{ d -> 0x022e }
            int r2 = r2 - r7
            r5 = 0
            r0[r5] = r2     // Catch:{ d -> 0x022e }
            goto L_0x01fb
        L_0x01f6:
            com.google.zxing.h r2 = com.google.zxing.h.getFormatInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x01fb:
            java.lang.String r2 = java.lang.String.valueOf(r20)     // Catch:{ d -> 0x022e }
            com.google.zxing.b.e r2 = com.google.zxing.f.a.e.a((int[]) r0, (java.lang.String) r2)     // Catch:{ d -> 0x022e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ d -> 0x022e }
            r2.f39915f = r4     // Catch:{ d -> 0x022e }
            int r4 = r1.length     // Catch:{ d -> 0x022e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ d -> 0x022e }
            r2.f39916g = r4     // Catch:{ d -> 0x022e }
            return r2
        L_0x0211:
            com.google.zxing.h r2 = com.google.zxing.h.getFormatInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x0216:
            com.google.zxing.h r2 = com.google.zxing.h.getFormatInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x021b:
            com.google.zxing.d r2 = com.google.zxing.d.getChecksumInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x0220:
            r16 = r5
            com.google.zxing.d r2 = com.google.zxing.d.getChecksumInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x0227:
            r16 = r5
            com.google.zxing.h r2 = com.google.zxing.h.getFormatInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x022e:
            goto L_0x0232
        L_0x0230:
            r16 = r5
        L_0x0232:
            int r2 = r3.length
            if (r2 == 0) goto L_0x025d
            r2 = 0
        L_0x0236:
            int r4 = r3.length
            if (r2 >= r4) goto L_0x0257
            r4 = r3[r2]
            r5 = r24[r2]
            int r5 = r5.length
            r6 = 1
            int r5 = r5 - r6
            if (r4 >= r5) goto L_0x0248
            r4 = r3[r2]
            int r4 = r4 + r6
            r3[r2] = r4
            goto L_0x0257
        L_0x0248:
            r4 = 0
            r3[r2] = r4
            int r5 = r3.length
            int r5 = r5 - r6
            if (r2 == r5) goto L_0x0252
            int r2 = r2 + 1
            goto L_0x0236
        L_0x0252:
            com.google.zxing.d r0 = com.google.zxing.d.getChecksumInstance()
            throw r0
        L_0x0257:
            r2 = r23
            r4 = r16
            goto L_0x000b
        L_0x025d:
            com.google.zxing.d r0 = com.google.zxing.d.getChecksumInstance()
            throw r0
        L_0x0262:
            com.google.zxing.d r0 = com.google.zxing.d.getChecksumInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.a.j.a(int, int[], int[], int[], int[][]):com.google.zxing.b.e");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r7 = com.google.zxing.f.a.i.a(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.zxing.f.a.d a(com.google.zxing.b.b r7, int r8, int r9, boolean r10, int r11, int r12, int r13, int r14) {
        /*
            int r11 = b(r7, r8, r9, r10, r11, r12)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            int[] r7 = a((com.google.zxing.b.b) r0, (int) r1, (int) r2, (boolean) r3, (int) r4, (int) r5)
            r8 = 0
            if (r7 != 0) goto L_0x0012
            return r8
        L_0x0012:
            int r9 = com.google.zxing.b.a.a.a((int[]) r7)
            if (r10 == 0) goto L_0x001e
            int r10 = r11 + r9
            r6 = r11
            r11 = r10
            r10 = r6
            goto L_0x0039
        L_0x001e:
            r10 = 0
        L_0x001f:
            int r12 = r7.length
            int r12 = r12 / 2
            if (r10 >= r12) goto L_0x0037
            r12 = r7[r10]
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r0 = r7[r0]
            r7[r10] = r0
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r7[r0] = r12
            int r10 = r10 + 1
            goto L_0x001f
        L_0x0037:
            int r10 = r11 - r9
        L_0x0039:
            boolean r9 = a(r9, r13, r14)
            if (r9 != 0) goto L_0x0040
            return r8
        L_0x0040:
            int r7 = com.google.zxing.f.a.i.a(r7)
            int r9 = com.google.zxing.f.a.a((int) r7)
            r12 = -1
            if (r9 != r12) goto L_0x004c
            return r8
        L_0x004c:
            com.google.zxing.f.a.d r8 = new com.google.zxing.f.a.d
            int r7 = b((int) r7)
            r8.<init>(r10, r11, r7, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.f.a.j.a(com.google.zxing.b.b, int, int, boolean, int, int, int, int):com.google.zxing.f.a.d");
    }

    private static int[] a(b bVar, int i2, int i3, boolean z, int i4, int i5) {
        int[] iArr = new int[8];
        int i6 = z ? 1 : -1;
        int i7 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i4 < i2) {
                    break;
                }
            } else if (i4 >= i3) {
                break;
            }
            if (i7 >= 8) {
                break;
            } else if (bVar.a(i4, i5) == z2) {
                iArr[i7] = iArr[i7] + 1;
                i4 += i6;
            } else {
                i7++;
                z2 = !z2;
            }
        }
        if (i7 != 8) {
            if (z) {
                i2 = i3;
            }
            if (!(i4 == i2 && i7 == 7)) {
                return null;
            }
        }
        return iArr;
    }

    private static int b(b bVar, int i2, int i3, boolean z, int i4, int i5) {
        int i6 = z ? -1 : 1;
        boolean z2 = z;
        int i7 = i4;
        for (int i8 = 0; i8 < 2; i8++) {
            while (true) {
                if (!z2) {
                    if (i7 >= i3) {
                        continue;
                        break;
                    }
                } else if (i7 < i2) {
                    continue;
                    break;
                }
                if (z2 != bVar.a(i7, i5)) {
                    continue;
                    break;
                } else if (Math.abs(i4 - i7) > 2) {
                    return i4;
                } else {
                    i7 += i6;
                }
            }
            i6 = -i6;
            z2 = !z2;
        }
        return i7;
    }

    private static int[] a(int i2) {
        int[] iArr = new int[8];
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i2 & 1;
            if (i5 != i3) {
                i4--;
                if (i4 < 0) {
                    return iArr;
                }
                i3 = i5;
            }
            iArr[i4] = iArr[i4] + 1;
            i2 >>= 1;
        }
    }

    private static int b(int i2) {
        return b(a(i2));
    }

    private static int b(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static boolean a(f fVar, int i2) {
        return i2 >= 0 && i2 <= fVar.f40451d + 1;
    }
}
