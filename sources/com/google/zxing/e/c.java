package com.google.zxing.e;

import com.google.zxing.b.a;
import com.google.zxing.m;

public final class c extends r {

    /* renamed from: a  reason: collision with root package name */
    static final int[][] f40366a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int a(a aVar, int[] iArr, int i2) throws m {
        a(aVar, i2, iArr);
        float f2 = 0.25f;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = f40366a;
            if (i4 >= iArr2.length) {
                break;
            }
            float a2 = a(iArr, iArr2[i4], 0.7f);
            if (a2 < f2) {
                i3 = i4;
                f2 = a2;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw m.getNotFoundInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01ce, code lost:
        r9 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01d1, code lost:
        r9 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01d5, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01d6, code lost:
        if (r15 == false) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01da, code lost:
        if (r9 != 'e') goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01dc, code lost:
        r9 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01df, code lost:
        r9 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01e4, code lost:
        r13 = r8;
        r15 = r10;
        r8 = r21;
        r6 = 6;
        r23 = r16;
        r16 = r2;
        r2 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0133, code lost:
        if (r11 != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0154, code lost:
        r10 = false;
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x017d, code lost:
        r10 = false;
        r11 = false;
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0185, code lost:
        if (r11 != false) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0187, code lost:
        r10 = false;
        r11 = false;
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x018d, code lost:
        r10 = false;
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0192, code lost:
        r9 = 'c';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x019b, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x019d, code lost:
        r5 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.r a(int r25, com.google.zxing.b.a r26, java.util.Map<com.google.zxing.e, ?> r27) throws com.google.zxing.m, com.google.zxing.h, com.google.zxing.d {
        /*
            r24 = this;
            r0 = r26
            r1 = r27
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            com.google.zxing.e r4 = com.google.zxing.e.ASSUME_GS1
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            int r4 = r0.f39881b
            int r5 = r0.c(r3)
            r6 = 6
            int[] r7 = new int[r6]
            r10 = r5
            r8 = 0
            r9 = 0
        L_0x001f:
            if (r5 >= r4) goto L_0x02ae
            boolean r11 = r0.a((int) r5)
            if (r11 == r8) goto L_0x0032
            r11 = r7[r9]
            int r11 = r11 + r2
            r7[r9] = r11
            r11 = r25
            r2 = 0
            r3 = 1
            goto L_0x02a7
        L_0x0032:
            r11 = 5
            if (r9 != r11) goto L_0x029c
            r11 = 1048576000(0x3e800000, float:0.25)
            r13 = -1
            r11 = 103(0x67, float:1.44E-43)
            r14 = 1048576000(0x3e800000, float:0.25)
        L_0x003c:
            r15 = 105(0x69, float:1.47E-43)
            if (r11 > r15) goto L_0x0054
            int[][] r15 = f40366a
            r15 = r15[r11]
            r12 = 1060320051(0x3f333333, float:0.7)
            float r12 = a((int[]) r7, (int[]) r15, (float) r12)
            int r15 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r15 >= 0) goto L_0x0051
            r13 = r11
            r14 = r12
        L_0x0051:
            int r11 = r11 + 1
            goto L_0x003c
        L_0x0054:
            r11 = 2
            if (r13 < 0) goto L_0x0285
            int r12 = r5 - r10
            int r12 = r12 / r11
            int r12 = r10 - r12
            int r12 = java.lang.Math.max(r3, r12)
            boolean r12 = r0.a(r12, r10)
            if (r12 == 0) goto L_0x0285
            r4 = 3
            int[] r4 = new int[r4]
            r4[r3] = r10
            r4[r2] = r5
            r4[r11] = r13
            r5 = r4[r11]
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 20
            r7.<init>(r8)
            byte r9 = (byte) r5
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r7.add(r9)
            switch(r5) {
                case 103: goto L_0x008e;
                case 104: goto L_0x008b;
                case 105: goto L_0x0088;
                default: goto L_0x0083;
            }
        L_0x0083:
            com.google.zxing.h r0 = com.google.zxing.h.getFormatInstance()
            throw r0
        L_0x0088:
            r13 = 99
            goto L_0x0090
        L_0x008b:
            r13 = 100
            goto L_0x0090
        L_0x008e:
            r13 = 101(0x65, float:1.42E-43)
        L_0x0090:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r8)
            r8 = r4[r3]
            r15 = r4[r2]
            int[] r3 = new int[r6]
            r17 = r5
            r9 = r13
            r2 = 0
            r5 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r18 = 0
            r19 = 1
            r13 = r8
            r8 = r15
            r15 = 0
        L_0x00ab:
            if (r5 != 0) goto L_0x01f1
            int r2 = a((com.google.zxing.b.a) r0, (int[]) r3, (int) r8)
            byte r13 = (byte) r2
            java.lang.Byte r13 = java.lang.Byte.valueOf(r13)
            r7.add(r13)
            r13 = 106(0x6a, float:1.49E-43)
            if (r2 == r13) goto L_0x00bf
            r19 = 1
        L_0x00bf:
            if (r2 == r13) goto L_0x00c7
            int r18 = r18 + 1
            int r20 = r18 * r2
            int r17 = r17 + r20
        L_0x00c7:
            r21 = r8
            r10 = 0
        L_0x00ca:
            if (r10 >= r6) goto L_0x00d3
            r22 = r3[r10]
            int r21 = r21 + r22
            int r10 = r10 + 1
            goto L_0x00ca
        L_0x00d3:
            switch(r2) {
                case 103: goto L_0x00dd;
                case 104: goto L_0x00dd;
                case 105: goto L_0x00dd;
                default: goto L_0x00d6;
            }
        L_0x00d6:
            java.lang.String r10 = "]C1"
            switch(r9) {
                case 99: goto L_0x01a1;
                case 100: goto L_0x013f;
                case 101: goto L_0x00e2;
                default: goto L_0x00db;
            }
        L_0x00db:
            goto L_0x019e
        L_0x00dd:
            com.google.zxing.h r0 = com.google.zxing.h.getFormatInstance()
            throw r0
        L_0x00e2:
            r6 = 64
            if (r2 >= r6) goto L_0x00f9
            if (r11 != r12) goto L_0x00f0
            int r6 = r2 + 32
            char r6 = (char) r6
            r14.append(r6)
            goto L_0x0154
        L_0x00f0:
            int r6 = r2 + 32
            int r6 = r6 + 128
            char r6 = (char) r6
            r14.append(r6)
            goto L_0x0154
        L_0x00f9:
            r6 = 96
            if (r2 >= r6) goto L_0x010d
            if (r11 != r12) goto L_0x0106
            int r6 = r2 + -64
            char r6 = (char) r6
            r14.append(r6)
            goto L_0x0154
        L_0x0106:
            int r6 = r2 + 64
            char r6 = (char) r6
            r14.append(r6)
            goto L_0x0154
        L_0x010d:
            if (r2 == r13) goto L_0x0111
            r19 = 0
        L_0x0111:
            if (r2 == r13) goto L_0x019d
            switch(r2) {
                case 96: goto L_0x019e;
                case 97: goto L_0x019e;
                case 98: goto L_0x013a;
                case 99: goto L_0x0192;
                case 100: goto L_0x0136;
                case 101: goto L_0x012c;
                case 102: goto L_0x0118;
                default: goto L_0x0116;
            }
        L_0x0116:
            goto L_0x019e
        L_0x0118:
            if (r1 == 0) goto L_0x019e
            int r6 = r14.length()
            if (r6 != 0) goto L_0x0125
            r14.append(r10)
            goto L_0x019e
        L_0x0125:
            r6 = 29
            r14.append(r6)
            goto L_0x019e
        L_0x012c:
            if (r12 != 0) goto L_0x0131
            if (r11 == 0) goto L_0x0131
            goto L_0x017d
        L_0x0131:
            if (r12 == 0) goto L_0x018d
            if (r11 == 0) goto L_0x018d
            goto L_0x0187
        L_0x0136:
            r6 = 100
            goto L_0x01d1
        L_0x013a:
            r6 = 100
            r9 = 100
            goto L_0x019b
        L_0x013f:
            r6 = 96
            if (r2 >= r6) goto L_0x015a
            if (r11 != r12) goto L_0x014c
            int r6 = r2 + 32
            char r6 = (char) r6
            r14.append(r6)
            goto L_0x0154
        L_0x014c:
            int r6 = r2 + 32
            int r6 = r6 + 128
            char r6 = (char) r6
            r14.append(r6)
        L_0x0154:
            r6 = 100
            r10 = 0
            r11 = 0
            goto L_0x01d6
        L_0x015a:
            if (r2 == r13) goto L_0x015e
            r19 = 0
        L_0x015e:
            if (r2 == r13) goto L_0x019d
            switch(r2) {
                case 96: goto L_0x019e;
                case 97: goto L_0x019e;
                case 98: goto L_0x0197;
                case 99: goto L_0x0192;
                case 100: goto L_0x0179;
                case 101: goto L_0x0176;
                case 102: goto L_0x0164;
                default: goto L_0x0163;
            }
        L_0x0163:
            goto L_0x019e
        L_0x0164:
            if (r1 == 0) goto L_0x019e
            int r6 = r14.length()
            if (r6 != 0) goto L_0x0170
            r14.append(r10)
            goto L_0x019e
        L_0x0170:
            r6 = 29
            r14.append(r6)
            goto L_0x019e
        L_0x0176:
            r6 = 100
            goto L_0x01ce
        L_0x0179:
            if (r12 != 0) goto L_0x0183
            if (r11 == 0) goto L_0x0183
        L_0x017d:
            r6 = 100
            r10 = 0
            r11 = 0
            r12 = 1
            goto L_0x01d6
        L_0x0183:
            if (r12 == 0) goto L_0x018d
            if (r11 == 0) goto L_0x018d
        L_0x0187:
            r6 = 100
            r10 = 0
            r11 = 0
            r12 = 0
            goto L_0x01d6
        L_0x018d:
            r6 = 100
            r10 = 0
            r11 = 1
            goto L_0x01d6
        L_0x0192:
            r6 = 100
            r9 = 99
            goto L_0x01d5
        L_0x0197:
            r6 = 100
            r9 = 101(0x65, float:1.42E-43)
        L_0x019b:
            r10 = 1
            goto L_0x01d6
        L_0x019d:
            r5 = 1
        L_0x019e:
            r6 = 100
            goto L_0x01d5
        L_0x01a1:
            r6 = 100
            if (r2 >= r6) goto L_0x01b2
            r10 = 10
            if (r2 >= r10) goto L_0x01ae
            r10 = 48
            r14.append(r10)
        L_0x01ae:
            r14.append(r2)
            goto L_0x01d5
        L_0x01b2:
            if (r2 == r13) goto L_0x01b6
            r19 = 0
        L_0x01b6:
            if (r2 == r13) goto L_0x01d4
            switch(r2) {
                case 100: goto L_0x01d1;
                case 101: goto L_0x01ce;
                case 102: goto L_0x01bc;
                default: goto L_0x01bb;
            }
        L_0x01bb:
            goto L_0x01d5
        L_0x01bc:
            if (r1 == 0) goto L_0x01d5
            int r13 = r14.length()
            if (r13 != 0) goto L_0x01c8
            r14.append(r10)
            goto L_0x01d5
        L_0x01c8:
            r10 = 29
            r14.append(r10)
            goto L_0x01d5
        L_0x01ce:
            r9 = 101(0x65, float:1.42E-43)
            goto L_0x01d5
        L_0x01d1:
            r9 = 100
            goto L_0x01d5
        L_0x01d4:
            r5 = 1
        L_0x01d5:
            r10 = 0
        L_0x01d6:
            if (r15 == 0) goto L_0x01e2
            r15 = 101(0x65, float:1.42E-43)
            if (r9 != r15) goto L_0x01df
            r9 = 100
            goto L_0x01e4
        L_0x01df:
            r9 = 101(0x65, float:1.42E-43)
            goto L_0x01e4
        L_0x01e2:
            r15 = 101(0x65, float:1.42E-43)
        L_0x01e4:
            r13 = r8
            r15 = r10
            r8 = r21
            r6 = 6
            r23 = r16
            r16 = r2
            r2 = r23
            goto L_0x00ab
        L_0x01f1:
            int r1 = r8 - r13
            int r3 = r0.d(r8)
            int r5 = r0.f39881b
            int r6 = r3 - r13
            r8 = 2
            int r6 = r6 / r8
            int r6 = r6 + r3
            int r5 = java.lang.Math.min(r5, r6)
            boolean r0 = r0.a(r3, r5)
            if (r0 == 0) goto L_0x0280
            int r18 = r18 * r2
            int r17 = r17 - r18
            r0 = 103(0x67, float:1.44E-43)
            int r0 = r17 % 103
            if (r0 != r2) goto L_0x027b
            int r0 = r14.length()
            if (r0 == 0) goto L_0x0276
            if (r0 <= 0) goto L_0x022b
            if (r19 == 0) goto L_0x022b
            r2 = 99
            if (r9 != r2) goto L_0x0226
            int r2 = r0 + -2
            r14.delete(r2, r0)
            goto L_0x022b
        L_0x0226:
            int r2 = r0 + -1
            r14.delete(r2, r0)
        L_0x022b:
            r0 = 1
            r2 = r4[r0]
            r0 = 0
            r3 = r4[r0]
            int r2 = r2 + r3
            float r0 = (float) r2
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            float r2 = (float) r13
            float r1 = (float) r1
            r3 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r3
            float r2 = r2 + r1
            int r1 = r7.size()
            byte[] r3 = new byte[r1]
            r4 = 0
        L_0x0243:
            if (r4 >= r1) goto L_0x0254
            java.lang.Object r5 = r7.get(r4)
            java.lang.Byte r5 = (java.lang.Byte) r5
            byte r5 = r5.byteValue()
            r3[r4] = r5
            int r4 = r4 + 1
            goto L_0x0243
        L_0x0254:
            com.google.zxing.r r1 = new com.google.zxing.r
            java.lang.String r4 = r14.toString()
            r5 = 2
            com.google.zxing.t[] r5 = new com.google.zxing.t[r5]
            com.google.zxing.t r6 = new com.google.zxing.t
            r11 = r25
            float r7 = (float) r11
            r6.<init>(r0, r7)
            r0 = 0
            r5[r0] = r6
            com.google.zxing.t r0 = new com.google.zxing.t
            r0.<init>(r2, r7)
            r2 = 1
            r5[r2] = r0
            com.google.zxing.a r0 = com.google.zxing.a.CODE_128
            r1.<init>(r4, r3, r5, r0)
            return r1
        L_0x0276:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x027b:
            com.google.zxing.d r0 = com.google.zxing.d.getChecksumInstance()
            throw r0
        L_0x0280:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x0285:
            r11 = r25
            r2 = 0
            r3 = r7[r2]
            r6 = 1
            r12 = r7[r6]
            int r3 = r3 + r12
            int r10 = r10 + r3
            int r3 = r9 + -1
            r6 = 2
            java.lang.System.arraycopy(r7, r6, r7, r2, r3)
            r7[r3] = r2
            r7[r9] = r2
            int r9 = r9 + -1
            goto L_0x02a1
        L_0x029c:
            r11 = r25
            r2 = 0
            int r9 = r9 + 1
        L_0x02a1:
            r3 = 1
            r7[r9] = r3
            r6 = r8 ^ 1
            r8 = r6
        L_0x02a7:
            int r5 = r5 + 1
            r2 = 1
            r3 = 0
            r6 = 6
            goto L_0x001f
        L_0x02ae:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.c.a(int, com.google.zxing.b.a, java.util.Map):com.google.zxing.r");
    }
}
