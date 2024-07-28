package com.google.zxing.e;

final class x {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f40399a = {1, 1, 2};

    /* renamed from: b  reason: collision with root package name */
    private final v f40400b = new v();

    /* renamed from: c  reason: collision with root package name */
    private final w f40401c = new w();

    x() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0136 A[Catch:{ q -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0138 A[Catch:{ q -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016a A[Catch:{ q -> 0x0183 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.r a(int r19, com.google.zxing.b.a r20, int r21) throws com.google.zxing.m {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            int[] r3 = f40399a
            r4 = 0
            r5 = r21
            int[] r3 = com.google.zxing.e.y.a((com.google.zxing.b.a) r2, (int) r5, (boolean) r4, (int[]) r3)
            com.google.zxing.e.w r5 = r0.f40401c     // Catch:{ q -> 0x0183 }
            java.lang.StringBuilder r6 = r5.f40398c     // Catch:{ q -> 0x0183 }
            r6.setLength(r4)     // Catch:{ q -> 0x0183 }
            int[] r5 = r5.f40397b     // Catch:{ q -> 0x0183 }
            r5[r4] = r4     // Catch:{ q -> 0x0183 }
            r7 = 1
            r5[r7] = r4     // Catch:{ q -> 0x0183 }
            r8 = 2
            r5[r8] = r4     // Catch:{ q -> 0x0183 }
            r9 = 3
            r5[r9] = r4     // Catch:{ q -> 0x0183 }
            int r10 = r2.f39881b     // Catch:{ q -> 0x0183 }
            r11 = r3[r7]     // Catch:{ q -> 0x0183 }
            r12 = r11
            r11 = 0
            r13 = 0
        L_0x002a:
            r14 = 5
            r15 = 48
            r8 = 10
            if (r11 >= r14) goto L_0x0066
            if (r12 >= r10) goto L_0x0066
            int[][] r14 = com.google.zxing.e.y.f40406f     // Catch:{ q -> 0x0183 }
            int r14 = com.google.zxing.e.y.a((com.google.zxing.b.a) r2, (int[]) r5, (int) r12, (int[][]) r14)     // Catch:{ q -> 0x0183 }
            int r16 = r14 % 10
            int r15 = r16 + 48
            char r15 = (char) r15     // Catch:{ q -> 0x0183 }
            r6.append(r15)     // Catch:{ q -> 0x0183 }
            int r15 = r5.length     // Catch:{ q -> 0x0183 }
            r4 = r12
            r12 = 0
        L_0x0044:
            if (r12 >= r15) goto L_0x004d
            r17 = r5[r12]     // Catch:{ q -> 0x0183 }
            int r4 = r4 + r17
            int r12 = r12 + 1
            goto L_0x0044
        L_0x004d:
            r12 = 4
            if (r14 < r8) goto L_0x0056
            int r8 = 4 - r11
            int r8 = r7 << r8
            r8 = r8 | r13
            r13 = r8
        L_0x0056:
            if (r11 == r12) goto L_0x0060
            int r4 = r2.c(r4)     // Catch:{ q -> 0x0183 }
            int r4 = r2.d(r4)     // Catch:{ q -> 0x0183 }
        L_0x0060:
            r12 = r4
            int r11 = r11 + 1
            r4 = 0
            r8 = 2
            goto L_0x002a
        L_0x0066:
            int r4 = r6.length()     // Catch:{ q -> 0x0183 }
            if (r4 != r14) goto L_0x017e
            r4 = 0
        L_0x006d:
            if (r4 >= r8) goto L_0x0179
            int[] r5 = com.google.zxing.e.w.f40396a     // Catch:{ q -> 0x0183 }
            r5 = r5[r4]     // Catch:{ q -> 0x0183 }
            if (r13 != r5) goto L_0x0173
            java.lang.String r5 = r6.toString()     // Catch:{ q -> 0x0183 }
            int r10 = r5.length()     // Catch:{ q -> 0x0183 }
            int r11 = r10 + -2
            r13 = 0
        L_0x0080:
            if (r11 < 0) goto L_0x008d
            char r17 = r5.charAt(r11)     // Catch:{ q -> 0x0183 }
            int r17 = r17 + -48
            int r13 = r13 + r17
            int r11 = r11 + -2
            goto L_0x0080
        L_0x008d:
            int r13 = r13 * 3
            int r10 = r10 - r7
        L_0x0090:
            if (r10 < 0) goto L_0x009b
            char r11 = r5.charAt(r10)     // Catch:{ q -> 0x0183 }
            int r11 = r11 - r15
            int r13 = r13 + r11
            int r10 = r10 + -2
            goto L_0x0090
        L_0x009b:
            int r13 = r13 * 3
            int r13 = r13 % r8
            if (r13 != r4) goto L_0x016e
            java.lang.String r4 = r6.toString()     // Catch:{ q -> 0x0183 }
            int r5 = r4.length()     // Catch:{ q -> 0x0183 }
            r6 = 0
            if (r5 == r14) goto L_0x00ae
        L_0x00ab:
            r8 = r6
            goto L_0x0144
        L_0x00ae:
            r5 = 0
            char r9 = r4.charAt(r5)     // Catch:{ q -> 0x0183 }
            java.lang.String r5 = ""
            if (r9 == r15) goto L_0x00f9
            r10 = 53
            if (r9 == r10) goto L_0x00f6
            r10 = 57
            if (r9 == r10) goto L_0x00c0
            goto L_0x00fc
        L_0x00c0:
            r9 = -1
            int r10 = r4.hashCode()     // Catch:{ q -> 0x0183 }
            switch(r10) {
                case 54118329: goto L_0x00dd;
                case 54395376: goto L_0x00d3;
                case 54395377: goto L_0x00c9;
                default: goto L_0x00c8;
            }     // Catch:{ q -> 0x0183 }
        L_0x00c8:
            goto L_0x00e6
        L_0x00c9:
            java.lang.String r10 = "99991"
            boolean r10 = r4.equals(r10)     // Catch:{ q -> 0x0183 }
            if (r10 == 0) goto L_0x00e6
            r9 = 1
            goto L_0x00e6
        L_0x00d3:
            java.lang.String r10 = "99990"
            boolean r10 = r4.equals(r10)     // Catch:{ q -> 0x0183 }
            if (r10 == 0) goto L_0x00e6
            r9 = 2
            goto L_0x00e6
        L_0x00dd:
            java.lang.String r10 = "90000"
            boolean r10 = r4.equals(r10)     // Catch:{ q -> 0x0183 }
            if (r10 == 0) goto L_0x00e6
            r9 = 0
        L_0x00e6:
            if (r9 == 0) goto L_0x00f4
            if (r9 == r7) goto L_0x00f1
            r10 = 2
            if (r9 == r10) goto L_0x00ee
            goto L_0x00fc
        L_0x00ee:
            java.lang.String r5 = "Used"
            goto L_0x0134
        L_0x00f1:
            java.lang.String r5 = "0.00"
            goto L_0x0134
        L_0x00f4:
            r5 = r6
            goto L_0x0134
        L_0x00f6:
            java.lang.String r5 = "$"
            goto L_0x00fc
        L_0x00f9:
            java.lang.String r5 = "£"
        L_0x00fc:
            java.lang.String r9 = r4.substring(r7)     // Catch:{ q -> 0x0183 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ q -> 0x0183 }
            int r10 = r9 / 100
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ q -> 0x0183 }
            int r9 = r9 % 100
            if (r9 >= r8) goto L_0x0119
            java.lang.String r8 = "0"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ q -> 0x0183 }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ q -> 0x0183 }
            goto L_0x011d
        L_0x0119:
            java.lang.String r8 = java.lang.String.valueOf(r9)     // Catch:{ q -> 0x0183 }
        L_0x011d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ q -> 0x0183 }
            r9.<init>()     // Catch:{ q -> 0x0183 }
            r9.append(r5)     // Catch:{ q -> 0x0183 }
            r9.append(r10)     // Catch:{ q -> 0x0183 }
            r5 = 46
            r9.append(r5)     // Catch:{ q -> 0x0183 }
            r9.append(r8)     // Catch:{ q -> 0x0183 }
            java.lang.String r5 = r9.toString()     // Catch:{ q -> 0x0183 }
        L_0x0134:
            if (r5 != 0) goto L_0x0138
            goto L_0x00ab
        L_0x0138:
            java.util.EnumMap r8 = new java.util.EnumMap     // Catch:{ q -> 0x0183 }
            java.lang.Class<com.google.zxing.s> r9 = com.google.zxing.s.class
            r8.<init>(r9)     // Catch:{ q -> 0x0183 }
            com.google.zxing.s r9 = com.google.zxing.s.SUGGESTED_PRICE     // Catch:{ q -> 0x0183 }
            r8.put(r9, r5)     // Catch:{ q -> 0x0183 }
        L_0x0144:
            com.google.zxing.r r5 = new com.google.zxing.r     // Catch:{ q -> 0x0183 }
            r10 = 2
            com.google.zxing.t[] r9 = new com.google.zxing.t[r10]     // Catch:{ q -> 0x0183 }
            com.google.zxing.t r10 = new com.google.zxing.t     // Catch:{ q -> 0x0183 }
            r11 = 0
            r13 = r3[r11]     // Catch:{ q -> 0x0183 }
            r14 = r3[r7]     // Catch:{ q -> 0x0183 }
            int r13 = r13 + r14
            float r13 = (float) r13     // Catch:{ q -> 0x0183 }
            r14 = 1073741824(0x40000000, float:2.0)
            float r13 = r13 / r14
            float r14 = (float) r1     // Catch:{ q -> 0x0183 }
            r10.<init>(r13, r14)     // Catch:{ q -> 0x0183 }
            r9[r11] = r10     // Catch:{ q -> 0x0183 }
            com.google.zxing.t r10 = new com.google.zxing.t     // Catch:{ q -> 0x0183 }
            float r11 = (float) r12     // Catch:{ q -> 0x0183 }
            r10.<init>(r11, r14)     // Catch:{ q -> 0x0183 }
            r9[r7] = r10     // Catch:{ q -> 0x0183 }
            com.google.zxing.a r7 = com.google.zxing.a.UPC_EAN_EXTENSION     // Catch:{ q -> 0x0183 }
            r5.<init>(r4, r6, r9, r7)     // Catch:{ q -> 0x0183 }
            if (r8 == 0) goto L_0x016d
            r5.a(r8)     // Catch:{ q -> 0x0183 }
        L_0x016d:
            return r5
        L_0x016e:
            com.google.zxing.m r4 = com.google.zxing.m.getNotFoundInstance()     // Catch:{ q -> 0x0183 }
            throw r4     // Catch:{ q -> 0x0183 }
        L_0x0173:
            r10 = 2
            r11 = 0
            int r4 = r4 + 1
            goto L_0x006d
        L_0x0179:
            com.google.zxing.m r4 = com.google.zxing.m.getNotFoundInstance()     // Catch:{ q -> 0x0183 }
            throw r4     // Catch:{ q -> 0x0183 }
        L_0x017e:
            com.google.zxing.m r4 = com.google.zxing.m.getNotFoundInstance()     // Catch:{ q -> 0x0183 }
            throw r4     // Catch:{ q -> 0x0183 }
        L_0x0183:
            com.google.zxing.e.v r4 = r0.f40400b
            com.google.zxing.r r1 = r4.a(r1, r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.x.a(int, com.google.zxing.b.a, int):com.google.zxing.r");
    }
}
