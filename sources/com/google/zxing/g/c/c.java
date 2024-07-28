package com.google.zxing.g.c;

import com.google.zxing.b.a;
import com.google.zxing.b.b.d;
import com.google.zxing.g.a.f;
import com.google.zxing.g.a.h;
import com.google.zxing.g.a.j;
import com.google.zxing.w;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f40550a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX WARNING: Removed duplicated region for block: B:132:0x0105 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f6 A[LOOP:1: B:57:0x00cb->B:70:0x00f6, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.g.c.f a(java.lang.String r13, com.google.zxing.g.a.f r14, java.util.Map<com.google.zxing.g, ?> r15) throws com.google.zxing.w {
        /*
            r0 = 0
            r1 = 1
            if (r15 == 0) goto L_0x000e
            com.google.zxing.g r2 = com.google.zxing.g.CHARACTER_SET
            boolean r2 = r15.containsKey(r2)
            if (r2 == 0) goto L_0x000e
            r2 = 1
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            if (r2 == 0) goto L_0x001c
            com.google.zxing.g r3 = com.google.zxing.g.CHARACTER_SET
            java.lang.Object r3 = r15.get(r3)
            java.lang.String r3 = r3.toString()
            goto L_0x001e
        L_0x001c:
            java.lang.String r3 = "ISO-8859-1"
        L_0x001e:
            java.lang.String r4 = "Shift_JIS"
            boolean r5 = r4.equals(r3)
            r6 = -1
            r7 = 48
            if (r5 == 0) goto L_0x0032
            boolean r5 = a((java.lang.String) r13)
            if (r5 == 0) goto L_0x0032
            com.google.zxing.g.a.h r5 = com.google.zxing.g.a.h.KANJI
            goto L_0x0060
        L_0x0032:
            r5 = 0
            r8 = 0
            r9 = 0
        L_0x0035:
            int r10 = r13.length()
            if (r5 >= r10) goto L_0x0054
            char r10 = r13.charAt(r5)
            if (r10 < r7) goto L_0x0047
            r11 = 57
            if (r10 > r11) goto L_0x0047
            r9 = 1
            goto L_0x004e
        L_0x0047:
            int r8 = a((int) r10)
            if (r8 == r6) goto L_0x0051
            r8 = 1
        L_0x004e:
            int r5 = r5 + 1
            goto L_0x0035
        L_0x0051:
            com.google.zxing.g.a.h r5 = com.google.zxing.g.a.h.BYTE
            goto L_0x0060
        L_0x0054:
            if (r8 == 0) goto L_0x0059
            com.google.zxing.g.a.h r5 = com.google.zxing.g.a.h.ALPHANUMERIC
            goto L_0x0060
        L_0x0059:
            if (r9 == 0) goto L_0x005e
            com.google.zxing.g.a.h r5 = com.google.zxing.g.a.h.NUMERIC
            goto L_0x0060
        L_0x005e:
            com.google.zxing.g.a.h r5 = com.google.zxing.g.a.h.BYTE
        L_0x0060:
            com.google.zxing.b.a r8 = new com.google.zxing.b.a
            r8.<init>()
            com.google.zxing.g.a.h r9 = com.google.zxing.g.a.h.BYTE
            r10 = 4
            r11 = 8
            if (r5 != r9) goto L_0x0084
            if (r2 == 0) goto L_0x0084
            com.google.zxing.b.d r2 = com.google.zxing.b.d.getCharacterSetECIByName(r3)
            if (r2 == 0) goto L_0x0084
            com.google.zxing.g.a.h r9 = com.google.zxing.g.a.h.ECI
            int r9 = r9.getBits()
            r8.b(r9, r10)
            int r2 = r2.getValue()
            r8.b(r2, r11)
        L_0x0084:
            if (r15 == 0) goto L_0x0090
            com.google.zxing.g r2 = com.google.zxing.g.GS1_FORMAT
            boolean r2 = r15.containsKey(r2)
            if (r2 == 0) goto L_0x0090
            r2 = 1
            goto L_0x0091
        L_0x0090:
            r2 = 0
        L_0x0091:
            if (r2 == 0) goto L_0x00ac
            com.google.zxing.g r2 = com.google.zxing.g.GS1_FORMAT
            java.lang.Object r2 = r15.get(r2)
            java.lang.String r2 = r2.toString()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00ac
            com.google.zxing.g.a.h r2 = com.google.zxing.g.a.h.FNC1_FIRST_POSITION
            a((com.google.zxing.g.a.h) r2, (com.google.zxing.b.a) r8)
        L_0x00ac:
            a((com.google.zxing.g.a.h) r5, (com.google.zxing.b.a) r8)
            com.google.zxing.b.a r2 = new com.google.zxing.b.a
            r2.<init>()
            int[] r9 = com.google.zxing.g.c.c.AnonymousClass1.f40551a
            int r12 = r5.ordinal()
            r9 = r9[r12]
            if (r9 == r1) goto L_0x0175
            r7 = 2
            if (r9 == r7) goto L_0x013a
            r7 = 3
            if (r9 == r7) goto L_0x0124
            if (r9 != r10) goto L_0x0114
            byte[] r3 = r13.getBytes(r4)     // Catch:{ UnsupportedEncodingException -> 0x010d }
            int r4 = r3.length
        L_0x00cb:
            if (r0 >= r4) goto L_0x01b4
            byte r7 = r3[r0]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r9 = r0 + 1
            byte r9 = r3[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r11
            r7 = r7 | r9
            r9 = 33088(0x8140, float:4.6366E-41)
            if (r7 < r9) goto L_0x00e5
            r10 = 40956(0x9ffc, float:5.7392E-41)
            if (r7 > r10) goto L_0x00e5
        L_0x00e3:
            int r7 = r7 - r9
            goto L_0x00f4
        L_0x00e5:
            r9 = 57408(0xe040, float:8.0446E-41)
            if (r7 < r9) goto L_0x00f3
            r9 = 60351(0xebbf, float:8.457E-41)
            if (r7 > r9) goto L_0x00f3
            r9 = 49472(0xc140, float:6.9325E-41)
            goto L_0x00e3
        L_0x00f3:
            r7 = -1
        L_0x00f4:
            if (r7 == r6) goto L_0x0105
            int r9 = r7 >> 8
            int r9 = r9 * 192
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r9 = r9 + r7
            r7 = 13
            r2.b(r9, r7)
            int r0 = r0 + 2
            goto L_0x00cb
        L_0x0105:
            com.google.zxing.w r13 = new com.google.zxing.w
            java.lang.String r14 = "Invalid byte sequence"
            r13.<init>((java.lang.String) r14)
            throw r13
        L_0x010d:
            r13 = move-exception
            com.google.zxing.w r14 = new com.google.zxing.w
            r14.<init>((java.lang.Throwable) r13)
            throw r14
        L_0x0114:
            com.google.zxing.w r13 = new com.google.zxing.w
            java.lang.String r14 = java.lang.String.valueOf(r5)
            java.lang.String r15 = "Invalid mode: "
            java.lang.String r14 = r15.concat(r14)
            r13.<init>((java.lang.String) r14)
            throw r13
        L_0x0124:
            byte[] r3 = r13.getBytes(r3)     // Catch:{ UnsupportedEncodingException -> 0x0133 }
            int r4 = r3.length
        L_0x0129:
            if (r0 >= r4) goto L_0x01b4
            byte r6 = r3[r0]
            r2.b(r6, r11)
            int r0 = r0 + 1
            goto L_0x0129
        L_0x0133:
            r13 = move-exception
            com.google.zxing.w r14 = new com.google.zxing.w
            r14.<init>((java.lang.Throwable) r13)
            throw r14
        L_0x013a:
            int r3 = r13.length()
        L_0x013e:
            if (r0 >= r3) goto L_0x01b4
            char r4 = r13.charAt(r0)
            int r4 = a((int) r4)
            if (r4 == r6) goto L_0x016f
            int r7 = r0 + 1
            if (r7 >= r3) goto L_0x0169
            char r7 = r13.charAt(r7)
            int r7 = a((int) r7)
            if (r7 == r6) goto L_0x0163
            int r4 = r4 * 45
            int r4 = r4 + r7
            r7 = 11
            r2.b(r4, r7)
            int r0 = r0 + 2
            goto L_0x013e
        L_0x0163:
            com.google.zxing.w r13 = new com.google.zxing.w
            r13.<init>()
            throw r13
        L_0x0169:
            r0 = 6
            r2.b(r4, r0)
            r0 = r7
            goto L_0x013e
        L_0x016f:
            com.google.zxing.w r13 = new com.google.zxing.w
            r13.<init>()
            throw r13
        L_0x0175:
            int r3 = r13.length()
        L_0x0179:
            if (r0 >= r3) goto L_0x01b4
            char r4 = r13.charAt(r0)
            int r4 = r4 - r7
            int r6 = r0 + 2
            if (r6 >= r3) goto L_0x019e
            int r9 = r0 + 1
            char r9 = r13.charAt(r9)
            int r9 = r9 - r7
            char r6 = r13.charAt(r6)
            int r6 = r6 - r7
            int r4 = r4 * 100
            r11 = 10
            int r9 = r9 * 10
            int r4 = r4 + r9
            int r4 = r4 + r6
            r2.b(r4, r11)
            int r0 = r0 + 3
            goto L_0x0179
        L_0x019e:
            int r0 = r0 + 1
            if (r0 >= r3) goto L_0x01b0
            char r0 = r13.charAt(r0)
            int r0 = r0 - r7
            int r4 = r4 * 10
            int r4 = r4 + r0
            r0 = 7
            r2.b(r4, r0)
            r0 = r6
            goto L_0x0179
        L_0x01b0:
            r2.b(r4, r10)
            goto L_0x0179
        L_0x01b4:
            if (r15 == 0) goto L_0x01e3
            com.google.zxing.g r0 = com.google.zxing.g.QR_VERSION
            boolean r0 = r15.containsKey(r0)
            if (r0 == 0) goto L_0x01e3
            com.google.zxing.g r0 = com.google.zxing.g.QR_VERSION
            java.lang.Object r15 = r15.get(r0)
            java.lang.String r15 = r15.toString()
            int r15 = java.lang.Integer.parseInt(r15)
            com.google.zxing.g.a.j r15 = com.google.zxing.g.a.j.b(r15)
            int r0 = a((com.google.zxing.g.a.h) r5, (com.google.zxing.b.a) r8, (com.google.zxing.b.a) r2, (com.google.zxing.g.a.j) r15)
            boolean r0 = a((int) r0, (com.google.zxing.g.a.j) r15, (com.google.zxing.g.a.f) r14)
            if (r0 == 0) goto L_0x01db
            goto L_0x01f7
        L_0x01db:
            com.google.zxing.w r13 = new com.google.zxing.w
            java.lang.String r14 = "Data too big for requested version"
            r13.<init>((java.lang.String) r14)
            throw r13
        L_0x01e3:
            com.google.zxing.g.a.j r15 = com.google.zxing.g.a.j.b(r1)
            int r15 = a((com.google.zxing.g.a.h) r5, (com.google.zxing.b.a) r8, (com.google.zxing.b.a) r2, (com.google.zxing.g.a.j) r15)
            com.google.zxing.g.a.j r15 = a((int) r15, (com.google.zxing.g.a.f) r14)
            int r15 = a((com.google.zxing.g.a.h) r5, (com.google.zxing.b.a) r8, (com.google.zxing.b.a) r2, (com.google.zxing.g.a.j) r15)
            com.google.zxing.g.a.j r15 = a((int) r15, (com.google.zxing.g.a.f) r14)
        L_0x01f7:
            com.google.zxing.b.a r0 = new com.google.zxing.b.a
            r0.<init>()
            r0.a((com.google.zxing.b.a) r8)
            com.google.zxing.g.a.h r3 = com.google.zxing.g.a.h.BYTE
            if (r5 != r3) goto L_0x0208
            int r13 = r2.a()
            goto L_0x020c
        L_0x0208:
            int r13 = r13.length()
        L_0x020c:
            int r3 = r5.getCharacterCountBits(r15)
            int r4 = r1 << r3
            if (r13 >= r4) goto L_0x0252
            r0.b(r13, r3)
            r0.a((com.google.zxing.b.a) r2)
            com.google.zxing.g.a.j$b r13 = r15.a((com.google.zxing.g.a.f) r14)
            int r1 = r15.f40517c
            int r2 = r13.b()
            int r1 = r1 - r2
            a((int) r1, (com.google.zxing.b.a) r0)
            int r2 = r15.f40517c
            int r13 = r13.a()
            com.google.zxing.b.a r13 = a((com.google.zxing.b.a) r0, (int) r2, (int) r1, (int) r13)
            com.google.zxing.g.c.f r0 = new com.google.zxing.g.c.f
            r0.<init>()
            r0.f40557b = r14
            r0.f40556a = r5
            r0.f40558c = r15
            int r1 = r15.a()
            com.google.zxing.g.c.b r2 = new com.google.zxing.g.c.b
            r2.<init>(r1, r1)
            int r1 = a((com.google.zxing.b.a) r13, (com.google.zxing.g.a.f) r14, (com.google.zxing.g.a.j) r15, (com.google.zxing.g.c.b) r2)
            r0.f40559d = r1
            com.google.zxing.g.c.e.a(r13, r14, r15, r1, r2)
            r0.f40560e = r2
            return r0
        L_0x0252:
            com.google.zxing.w r14 = new com.google.zxing.w
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r13)
            java.lang.String r13 = " is bigger than "
            r15.append(r13)
            int r4 = r4 - r1
            r15.append(r4)
            java.lang.String r13 = r15.toString()
            r14.<init>((java.lang.String) r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.g.c.c.a(java.lang.String, com.google.zxing.g.a.f, java.util.Map):com.google.zxing.g.c.f");
    }

    private static int a(int i2) {
        int[] iArr = f40550a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                byte b2 = bytes[i2] & 255;
                if ((b2 < 129 || b2 > 159) && (b2 < 224 || b2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(a aVar, f fVar, j jVar, b bVar) throws w {
        b bVar2 = bVar;
        boolean z = false;
        int i2 = -1;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (i3 < 8) {
            e.a(aVar, fVar, jVar, i3, bVar2);
            int a2 = d.a(bVar2, true) + d.a(bVar2, z);
            byte[][] bArr = bVar2.f40547a;
            int i5 = bVar2.f40548b;
            int i6 = bVar2.f40549c;
            int i7 = 0;
            int i8 = 0;
            while (i7 < i6 - 1) {
                byte[] bArr2 = bArr[i7];
                int i9 = i8;
                int i10 = 0;
                while (i10 < i5 - 1) {
                    byte b2 = bArr2[i10];
                    int i11 = i10 + 1;
                    if (b2 == bArr2[i11]) {
                        int i12 = i7 + 1;
                        if (b2 == bArr[i12][i10] && b2 == bArr[i12][i11]) {
                            i9++;
                        }
                    }
                    i10 = i11;
                }
                i7++;
                i8 = i9;
            }
            int i13 = a2 + (i8 * 3);
            byte[][] bArr3 = bVar2.f40547a;
            int i14 = bVar2.f40548b;
            int i15 = bVar2.f40549c;
            int i16 = 0;
            int i17 = 0;
            while (i16 < i15) {
                int i18 = i17;
                int i19 = 0;
                while (i19 < i14) {
                    byte[] bArr4 = bArr3[i16];
                    int i20 = i19 + 6;
                    if (i20 < i14 && bArr4[i19] == 1 && bArr4[i19 + 1] == 0 && bArr4[i19 + 2] == 1 && bArr4[i19 + 3] == 1 && bArr4[i19 + 4] == 1 && bArr4[i19 + 5] == 0 && bArr4[i20] == 1 && (d.a(bArr4, i19 - 4, i19) || d.a(bArr4, i19 + 7, i19 + 11))) {
                        i18++;
                    }
                    int i21 = i16 + 6;
                    if (i21 < i15 && bArr3[i16][i19] == 1 && bArr3[i16 + 1][i19] == 0 && bArr3[i16 + 2][i19] == 1 && bArr3[i16 + 3][i19] == 1 && bArr3[i16 + 4][i19] == 1 && bArr3[i16 + 5][i19] == 0 && bArr3[i21][i19] == 1 && (d.a(bArr3, i19, i16 - 4, i16) || d.a(bArr3, i19, i16 + 7, i16 + 11))) {
                        i18++;
                    }
                    i19++;
                    a aVar2 = aVar;
                    f fVar2 = fVar;
                }
                i16++;
                a aVar3 = aVar;
                f fVar3 = fVar;
                i17 = i18;
            }
            int i22 = i13 + (i17 * 40);
            byte[][] bArr5 = bVar2.f40547a;
            int i23 = bVar2.f40548b;
            int i24 = bVar2.f40549c;
            int i25 = 0;
            int i26 = 0;
            while (i25 < i24) {
                byte[] bArr6 = bArr5[i25];
                int i27 = i26;
                for (int i28 = 0; i28 < i23; i28++) {
                    if (bArr6[i28] == 1) {
                        i27++;
                    }
                }
                i25++;
                i26 = i27;
            }
            int i29 = bVar2.f40549c * bVar2.f40548b;
            int abs = i22 + (((Math.abs((i26 << 1) - i29) * 10) / i29) * 10);
            if (abs < i4) {
                i2 = i3;
                i4 = abs;
            }
            i3++;
            z = false;
        }
        return i2;
    }

    private static j a(int i2, f fVar) throws w {
        for (int i3 = 1; i3 <= 40; i3++) {
            j b2 = j.b(i3);
            if (a(i2, b2, fVar)) {
                return b2;
            }
        }
        throw new w("Data too big");
    }

    private static a a(a aVar, int i2, int i3, int i4) throws w {
        char c2;
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        if (aVar.a() == i6) {
            ArrayList<a> arrayList = new ArrayList<>(i7);
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i8 < i7) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                if (i8 < i7) {
                    int i12 = i5 % i7;
                    int i13 = i7 - i12;
                    int i14 = i5 / i7;
                    int i15 = i14 + 1;
                    int i16 = i6 / i7;
                    int i17 = i16 + 1;
                    int i18 = i14 - i16;
                    int i19 = i15 - i17;
                    if (i18 != i19) {
                        throw new w("EC bytes mismatch");
                    } else if (i7 != i13 + i12) {
                        throw new w("RS blocks mismatch");
                    } else if (i5 == ((i16 + i18) * i13) + ((i17 + i19) * i12)) {
                        if (i8 < i13) {
                            c2 = 0;
                            iArr[0] = i16;
                            iArr2[0] = i18;
                        } else {
                            c2 = 0;
                            iArr[0] = i17;
                            iArr2[0] = i19;
                        }
                        int i20 = iArr[c2];
                        byte[] bArr = new byte[i20];
                        aVar.a(i9 << 3, bArr, i20);
                        byte[] a2 = a(bArr, iArr2[c2]);
                        arrayList.add(new a(bArr, a2));
                        i10 = Math.max(i10, i20);
                        i11 = Math.max(i11, a2.length);
                        i9 += iArr[c2];
                        i8++;
                    } else {
                        throw new w("Total bytes mismatch");
                    }
                } else {
                    throw new w("Block ID too large");
                }
            }
            if (i6 == i9) {
                a aVar2 = new a();
                for (int i21 = 0; i21 < i10; i21++) {
                    for (a aVar3 : arrayList) {
                        byte[] bArr2 = aVar3.f40545a;
                        if (i21 < bArr2.length) {
                            aVar2.b(bArr2[i21], 8);
                        }
                    }
                }
                for (int i22 = 0; i22 < i11; i22++) {
                    for (a aVar4 : arrayList) {
                        byte[] bArr3 = aVar4.f40546b;
                        if (i22 < bArr3.length) {
                            aVar2.b(bArr3[i22], 8);
                        }
                    }
                }
                if (i5 == aVar2.a()) {
                    return aVar2;
                }
                throw new w("Interleaving error: " + i5 + " and " + aVar2.a() + " differ.");
            }
            throw new w("Data bytes does not match offset");
        }
        throw new w("Number of bits and data bytes does not match");
    }

    private static byte[] a(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[(length + i2)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new d(com.google.zxing.b.b.a.f39897e).a(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    private static void a(h hVar, a aVar) {
        aVar.b(hVar.getBits(), 4);
    }

    /* renamed from: com.google.zxing.g.c.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f40551a = new int[h.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.google.zxing.g.a.h[] r0 = com.google.zxing.g.a.h.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40551a = r0
                int[] r0 = f40551a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.zxing.g.a.h r1 = com.google.zxing.g.a.h.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f40551a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.zxing.g.a.h r1 = com.google.zxing.g.a.h.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f40551a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.zxing.g.a.h r1 = com.google.zxing.g.a.h.BYTE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f40551a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.zxing.g.a.h r1 = com.google.zxing.g.a.h.KANJI     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.g.c.c.AnonymousClass1.<clinit>():void");
        }
    }

    private static int a(h hVar, a aVar, a aVar2, j jVar) {
        return aVar.f39881b + hVar.getCharacterCountBits(jVar) + aVar2.f39881b;
    }

    private static boolean a(int i2, j jVar, f fVar) {
        return jVar.f40517c - jVar.a(fVar).b() >= (i2 + 7) / 8;
    }

    private static void a(int i2, a aVar) throws w {
        int i3 = i2 << 3;
        if (aVar.f39881b <= i3) {
            for (int i4 = 0; i4 < 4 && aVar.f39881b < i3; i4++) {
                aVar.a(false);
            }
            int i5 = aVar.f39881b & 7;
            if (i5 > 0) {
                while (i5 < 8) {
                    aVar.a(false);
                    i5++;
                }
            }
            int a2 = i2 - aVar.a();
            for (int i6 = 0; i6 < a2; i6++) {
                aVar.b((i6 & 1) == 0 ? 236 : 17, 8);
            }
            if (aVar.f39881b != i3) {
                throw new w("Bits size does not equal capacity");
            }
            return;
        }
        throw new w("data bits cannot fit in the QR Code" + aVar.f39881b + " > " + i3);
    }
}
