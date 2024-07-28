package com.google.zxing.g.c;

import com.alipay.mobile.h5container.api.H5Param;
import com.google.zxing.b.a;
import com.google.zxing.g.a.f;
import com.google.zxing.g.a.j;
import com.google.zxing.w;
import easypay.manager.Constants;
import java.util.Arrays;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f40552a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f40553b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f40554c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, H5Param.WEBVIEW_FONT_SIZE_LARGER}, new int[]{6, 24, 50, 76, 102, 128, Constants.ACTION_PASSWORD_FOUND}, new int[]{6, 28, 54, 80, 106, 132, Constants.ACTION_INCORRECT_OTP}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f40555d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private static boolean a(int i2) {
        return i2 == -1;
    }

    private static void a(int i2, int i3, b bVar) throws w {
        int i4 = 0;
        while (i4 < 8) {
            int i5 = i2 + i4;
            if (a(bVar.a(i5, i3))) {
                bVar.a(i5, i3, 0);
                i4++;
            } else {
                throw new w();
            }
        }
    }

    private static void b(int i2, int i3, b bVar) throws w {
        int i4 = 0;
        while (i4 < 7) {
            int i5 = i3 + i4;
            if (a(bVar.a(i2, i5))) {
                bVar.a(i2, i5, 0);
                i4++;
            } else {
                throw new w();
            }
        }
    }

    private static void c(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 7; i4++) {
            int[] iArr = f40552a[i4];
            for (int i5 = 0; i5 < 7; i5++) {
                bVar.a(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    static void a(a aVar, f fVar, j jVar, int i2, b bVar) throws w {
        j jVar2 = jVar;
        int i3 = i2;
        b bVar2 = bVar;
        int i4 = 0;
        for (byte[] fill : bVar2.f40547a) {
            Arrays.fill(fill, (byte) -1);
        }
        int length = f40552a[0].length;
        c(0, 0, bVar2);
        c(bVar2.f40548b - length, 0, bVar2);
        c(0, bVar2.f40548b - length, bVar2);
        a(0, 7, bVar2);
        a(bVar2.f40548b - 8, 7, bVar2);
        a(0, bVar2.f40548b - 8, bVar2);
        b(7, 0, bVar2);
        b((bVar2.f40549c - 7) - 1, 0, bVar2);
        b(7, bVar2.f40549c - 7, bVar2);
        if (bVar2.a(8, bVar2.f40549c - 8) != 0) {
            bVar2.a(8, bVar2.f40549c - 8, 1);
            int i5 = 5;
            if (jVar2.f40515a >= 2) {
                int[] iArr = f40554c[jVar2.f40515a - 1];
                int length2 = iArr.length;
                int i6 = 0;
                while (i6 < length2) {
                    int i7 = iArr[i6];
                    if (i7 >= 0) {
                        int length3 = iArr.length;
                        int i8 = 0;
                        while (i8 < length3) {
                            int i9 = iArr[i8];
                            if (i9 >= 0 && a(bVar2.a(i9, i7))) {
                                int i10 = i9 - 2;
                                int i11 = i7 - 2;
                                int i12 = 0;
                                while (i12 < i5) {
                                    int[] iArr2 = f40553b[i12];
                                    while (i4 < i5) {
                                        bVar2.a(i10 + i4, i11 + i12, iArr2[i4]);
                                        i4++;
                                        i5 = 5;
                                    }
                                    i12++;
                                    i4 = 0;
                                    i5 = 5;
                                }
                            }
                            i8++;
                            i4 = 0;
                            i5 = 5;
                        }
                    }
                    i6++;
                    i4 = 0;
                    i5 = 5;
                }
            }
            int i13 = 8;
            while (i13 < bVar2.f40548b - 8) {
                int i14 = i13 + 1;
                int i15 = i14 % 2;
                if (a(bVar2.a(i13, 6))) {
                    bVar2.a(i13, 6, i15);
                }
                if (a(bVar2.a(6, i13))) {
                    bVar2.a(6, i13, i15);
                }
                i13 = i14;
            }
            a aVar2 = new a();
            if (i3 >= 0 && i3 < 8) {
                int bits = (fVar.getBits() << 3) | i3;
                aVar2.b(bits, 5);
                aVar2.b(a(bits, 1335), 10);
                a aVar3 = new a();
                aVar3.b(21522, 15);
                if (aVar2.f39881b == aVar3.f39881b) {
                    for (int i16 = 0; i16 < aVar2.f39880a.length; i16++) {
                        int[] iArr3 = aVar2.f39880a;
                        iArr3[i16] = iArr3[i16] ^ aVar3.f39880a[i16];
                    }
                    if (aVar2.f39881b == 15) {
                        for (int i17 = 0; i17 < aVar2.f39881b; i17++) {
                            boolean a2 = aVar2.a((aVar2.f39881b - 1) - i17);
                            int[] iArr4 = f40555d[i17];
                            bVar2.a(iArr4[0], iArr4[1], a2);
                            if (i17 < 8) {
                                bVar2.a((bVar2.f40548b - i17) - 1, 8, a2);
                            } else {
                                bVar2.a(8, (bVar2.f40549c - 7) + (i17 - 8), a2);
                            }
                        }
                        a(jVar2, bVar2);
                        a(aVar, i3, bVar2);
                        return;
                    }
                    throw new w("should not happen but we got: " + aVar2.f39881b);
                }
                throw new IllegalArgumentException("Sizes don't match");
            }
            throw new w("Invalid mask pattern");
        }
        throw new w();
    }

    private static void a(j jVar, b bVar) throws w {
        if (jVar.f40515a >= 7) {
            a aVar = new a();
            aVar.b(jVar.f40515a, 6);
            aVar.b(a(jVar.f40515a, 7973), 12);
            if (aVar.f39881b == 18) {
                int i2 = 0;
                int i3 = 17;
                while (i2 < 6) {
                    int i4 = i3;
                    for (int i5 = 0; i5 < 3; i5++) {
                        boolean a2 = aVar.a(i4);
                        i4--;
                        bVar.a(i2, (bVar.f40549c - 11) + i5, a2);
                        bVar.a((bVar.f40549c - 11) + i5, i2, a2);
                    }
                    i2++;
                    i3 = i4;
                }
                return;
            }
            throw new w("should not happen but we got: " + aVar.f39881b);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        r10 = r10 + r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0078, code lost:
        r10 = r10 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0079, code lost:
        if (r10 != 0) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007d, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007e, code lost:
        if (r10 == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0080, code lost:
        r9 = !r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.zxing.b.a r12, int r13, com.google.zxing.g.c.b r14) throws com.google.zxing.w {
        /*
            int r0 = r14.f40548b
            r1 = 1
            int r0 = r0 - r1
            int r2 = r14.f40549c
            int r2 = r2 - r1
            r3 = -1
            r4 = 0
            r6 = r2
            r2 = 0
            r5 = -1
        L_0x000c:
            if (r0 <= 0) goto L_0x0091
            r7 = 6
            if (r0 != r7) goto L_0x0013
            int r0 = r0 + -1
        L_0x0013:
            if (r6 < 0) goto L_0x008b
            int r7 = r14.f40549c
            if (r6 >= r7) goto L_0x008b
            r7 = r2
            r2 = 0
        L_0x001b:
            r8 = 2
            if (r2 >= r8) goto L_0x0088
            int r8 = r0 - r2
            byte r9 = r14.a(r8, r6)
            boolean r9 = a(r9)
            if (r9 == 0) goto L_0x0085
            int r9 = r12.f39881b
            if (r7 >= r9) goto L_0x0035
            boolean r9 = r12.a((int) r7)
            int r7 = r7 + 1
            goto L_0x0036
        L_0x0035:
            r9 = 0
        L_0x0036:
            if (r13 == r3) goto L_0x0082
            switch(r13) {
                case 0: goto L_0x0076;
                case 1: goto L_0x0073;
                case 2: goto L_0x0070;
                case 3: goto L_0x006b;
                case 4: goto L_0x0065;
                case 5: goto L_0x005d;
                case 6: goto L_0x0053;
                case 7: goto L_0x004b;
                default: goto L_0x003b;
            }
        L_0x003b:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r14 = "Invalid mask pattern: "
            java.lang.String r13 = r14.concat(r13)
            r12.<init>(r13)
            throw r12
        L_0x004b:
            int r10 = r6 * r8
            int r10 = r10 % 3
            int r11 = r6 + r8
            r11 = r11 & r1
            goto L_0x0069
        L_0x0053:
            int r10 = r6 * r8
            r11 = r10 & 1
            int r10 = r10 % 3
            int r11 = r11 + r10
            r10 = r11 & 1
            goto L_0x0079
        L_0x005d:
            int r10 = r6 * r8
            r11 = r10 & 1
            int r10 = r10 % 3
            int r10 = r10 + r11
            goto L_0x0079
        L_0x0065:
            int r10 = r6 / 2
            int r11 = r8 / 3
        L_0x0069:
            int r10 = r10 + r11
            goto L_0x0078
        L_0x006b:
            int r10 = r6 + r8
            int r10 = r10 % 3
            goto L_0x0079
        L_0x0070:
            int r10 = r8 % 3
            goto L_0x0079
        L_0x0073:
            r10 = r6 & 1
            goto L_0x0079
        L_0x0076:
            int r10 = r6 + r8
        L_0x0078:
            r10 = r10 & r1
        L_0x0079:
            if (r10 != 0) goto L_0x007d
            r10 = 1
            goto L_0x007e
        L_0x007d:
            r10 = 0
        L_0x007e:
            if (r10 == 0) goto L_0x0082
            r9 = r9 ^ 1
        L_0x0082:
            r14.a((int) r8, (int) r6, (boolean) r9)
        L_0x0085:
            int r2 = r2 + 1
            goto L_0x001b
        L_0x0088:
            int r6 = r6 + r5
            r2 = r7
            goto L_0x0013
        L_0x008b:
            int r5 = -r5
            int r6 = r6 + r5
            int r0 = r0 + -2
            goto L_0x000c
        L_0x0091:
            int r13 = r12.f39881b
            if (r2 != r13) goto L_0x0096
            return
        L_0x0096:
            com.google.zxing.w r13 = new com.google.zxing.w
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "Not all bits consumed: "
            r14.<init>(r0)
            r14.append(r2)
            r0 = 47
            r14.append(r0)
            int r12 = r12.f39881b
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            r13.<init>((java.lang.String) r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.g.c.e.a(com.google.zxing.b.a, int, com.google.zxing.g.c.b):void");
    }

    private static int a(int i2, int i3) {
        if (i3 != 0) {
            int numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(i3);
            int i4 = i2 << (numberOfLeadingZeros - 1);
            while (32 - Integer.numberOfLeadingZeros(i4) >= numberOfLeadingZeros) {
                i4 ^= i3 << ((32 - Integer.numberOfLeadingZeros(i4)) - numberOfLeadingZeros);
            }
            return i4;
        }
        throw new IllegalArgumentException("0 polynomial");
    }
}
