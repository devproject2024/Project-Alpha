package com.google.zxing.client.a;

public final class l extends u {
    private static String a(int i2, String str) {
        if (str.charAt(i2) != '(') {
            return null;
        }
        String substring = str.substring(i2 + 1);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < substring.length(); i3++) {
            char charAt = substring.charAt(i3);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String b(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i2);
        for (int i3 = 0; i3 < substring.length(); i3++) {
            char charAt = substring.charAt(i3);
            if (charAt == '(') {
                if (a(i3, substring) != null) {
                    break;
                }
                sb.append('(');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0215, code lost:
        r3 = r2;
        r2 = r21;
        r15 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x024e, code lost:
        r13 = r1;
        r3 = r2;
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0261, code lost:
        r2 = r21;
        r15 = r22;
        r3 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0260  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.zxing.client.a.q a(com.google.zxing.r r24) {
        /*
            r23 = this;
            r0 = r24
            com.google.zxing.a r1 = r0.f40580d
            com.google.zxing.a r2 = com.google.zxing.a.RSS_EXPANDED
            r3 = 0
            if (r1 == r2) goto L_0x000a
            return r3
        L_0x000a:
            java.lang.String r5 = b((com.google.zxing.r) r24)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r6 = r3
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r18 = r17
            r2 = 0
        L_0x0024:
            int r4 = r5.length()
            if (r2 >= r4) goto L_0x0268
            java.lang.String r4 = a(r2, r5)
            if (r4 != 0) goto L_0x0031
            return r3
        L_0x0031:
            int r19 = r4.length()
            r20 = 2
            int r19 = r19 + 2
            int r2 = r2 + r19
            java.lang.String r1 = b(r2, r5)
            int r19 = r1.length()
            int r2 = r2 + r19
            r19 = -1
            int r3 = r4.hashCode()
            r21 = r2
            r2 = 1536(0x600, float:2.152E-42)
            r22 = r15
            r15 = 3
            if (r3 == r2) goto L_0x0202
            r2 = 1537(0x601, float:2.154E-42)
            if (r3 == r2) goto L_0x01f8
            r2 = 1567(0x61f, float:2.196E-42)
            if (r3 == r2) goto L_0x01ee
            r2 = 1568(0x620, float:2.197E-42)
            if (r3 == r2) goto L_0x01e4
            r2 = 1570(0x622, float:2.2E-42)
            if (r3 == r2) goto L_0x01da
            r2 = 1572(0x624, float:2.203E-42)
            if (r3 == r2) goto L_0x01d0
            r2 = 1574(0x626, float:2.206E-42)
            if (r3 == r2) goto L_0x01c6
            switch(r3) {
                case 1567966: goto L_0x01bc;
                case 1567967: goto L_0x01b1;
                case 1567968: goto L_0x01a6;
                case 1567969: goto L_0x019a;
                case 1567970: goto L_0x018e;
                case 1567971: goto L_0x0182;
                case 1567972: goto L_0x0176;
                case 1567973: goto L_0x016a;
                case 1567974: goto L_0x015e;
                case 1567975: goto L_0x0152;
                default: goto L_0x006f;
            }
        L_0x006f:
            switch(r3) {
                case 1568927: goto L_0x0146;
                case 1568928: goto L_0x013a;
                case 1568929: goto L_0x012e;
                case 1568930: goto L_0x0122;
                case 1568931: goto L_0x0116;
                case 1568932: goto L_0x010a;
                case 1568933: goto L_0x00fe;
                case 1568934: goto L_0x00f2;
                case 1568935: goto L_0x00e6;
                case 1568936: goto L_0x00da;
                default: goto L_0x0072;
            }
        L_0x0072:
            switch(r3) {
                case 1575716: goto L_0x00ce;
                case 1575717: goto L_0x00c2;
                case 1575718: goto L_0x00b6;
                case 1575719: goto L_0x00aa;
                default: goto L_0x0075;
            }
        L_0x0075:
            switch(r3) {
                case 1575747: goto L_0x009e;
                case 1575748: goto L_0x0092;
                case 1575749: goto L_0x0086;
                case 1575750: goto L_0x007a;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x020c
        L_0x007a:
            java.lang.String r2 = "3933"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 34
            goto L_0x020d
        L_0x0086:
            java.lang.String r2 = "3932"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 33
            goto L_0x020d
        L_0x0092:
            java.lang.String r2 = "3931"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 32
            goto L_0x020d
        L_0x009e:
            java.lang.String r2 = "3930"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 31
            goto L_0x020d
        L_0x00aa:
            java.lang.String r2 = "3923"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 30
            goto L_0x020d
        L_0x00b6:
            java.lang.String r2 = "3922"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 29
            goto L_0x020d
        L_0x00c2:
            java.lang.String r2 = "3921"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 28
            goto L_0x020d
        L_0x00ce:
            java.lang.String r2 = "3920"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 27
            goto L_0x020d
        L_0x00da:
            java.lang.String r2 = "3209"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 26
            goto L_0x020d
        L_0x00e6:
            java.lang.String r2 = "3208"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 25
            goto L_0x020d
        L_0x00f2:
            java.lang.String r2 = "3207"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 24
            goto L_0x020d
        L_0x00fe:
            java.lang.String r2 = "3206"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 23
            goto L_0x020d
        L_0x010a:
            java.lang.String r2 = "3205"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 22
            goto L_0x020d
        L_0x0116:
            java.lang.String r2 = "3204"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 21
            goto L_0x020d
        L_0x0122:
            java.lang.String r2 = "3203"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 20
            goto L_0x020d
        L_0x012e:
            java.lang.String r2 = "3202"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 19
            goto L_0x020d
        L_0x013a:
            java.lang.String r2 = "3201"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 18
            goto L_0x020d
        L_0x0146:
            java.lang.String r2 = "3200"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 17
            goto L_0x020d
        L_0x0152:
            java.lang.String r2 = "3109"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 16
            goto L_0x020d
        L_0x015e:
            java.lang.String r2 = "3108"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 15
            goto L_0x020d
        L_0x016a:
            java.lang.String r2 = "3107"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 14
            goto L_0x020d
        L_0x0176:
            java.lang.String r2 = "3106"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 13
            goto L_0x020d
        L_0x0182:
            java.lang.String r2 = "3105"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 12
            goto L_0x020d
        L_0x018e:
            java.lang.String r2 = "3104"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 11
            goto L_0x020d
        L_0x019a:
            java.lang.String r2 = "3103"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 10
            goto L_0x020d
        L_0x01a6:
            java.lang.String r2 = "3102"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 9
            goto L_0x020d
        L_0x01b1:
            java.lang.String r2 = "3101"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 8
            goto L_0x020d
        L_0x01bc:
            java.lang.String r2 = "3100"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 7
            goto L_0x020d
        L_0x01c6:
            java.lang.String r2 = "17"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 6
            goto L_0x020d
        L_0x01d0:
            java.lang.String r2 = "15"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 5
            goto L_0x020d
        L_0x01da:
            java.lang.String r2 = "13"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 4
            goto L_0x020d
        L_0x01e4:
            java.lang.String r2 = "11"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 3
            goto L_0x020d
        L_0x01ee:
            java.lang.String r2 = "10"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 2
            goto L_0x020d
        L_0x01f8:
            java.lang.String r2 = "01"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 1
            goto L_0x020d
        L_0x0202:
            java.lang.String r2 = "00"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x020c
            r2 = 0
            goto L_0x020d
        L_0x020c:
            r2 = -1
        L_0x020d:
            switch(r2) {
                case 0: goto L_0x0260;
                case 1: goto L_0x025e;
                case 2: goto L_0x025c;
                case 3: goto L_0x025a;
                case 4: goto L_0x0258;
                case 5: goto L_0x0256;
                case 6: goto L_0x0254;
                case 7: goto L_0x0246;
                case 8: goto L_0x0246;
                case 9: goto L_0x0246;
                case 10: goto L_0x0246;
                case 11: goto L_0x0246;
                case 12: goto L_0x0246;
                case 13: goto L_0x0246;
                case 14: goto L_0x0246;
                case 15: goto L_0x0246;
                case 16: goto L_0x0246;
                case 17: goto L_0x023d;
                case 18: goto L_0x023d;
                case 19: goto L_0x023d;
                case 20: goto L_0x023d;
                case 21: goto L_0x023d;
                case 22: goto L_0x023d;
                case 23: goto L_0x023d;
                case 24: goto L_0x023d;
                case 25: goto L_0x023d;
                case 26: goto L_0x023d;
                case 27: goto L_0x0234;
                case 28: goto L_0x0234;
                case 29: goto L_0x0234;
                case 30: goto L_0x0234;
                case 31: goto L_0x021c;
                case 32: goto L_0x021c;
                case 33: goto L_0x021c;
                case 34: goto L_0x021c;
                default: goto L_0x0210;
            }
        L_0x0210:
            r2 = 0
            r3 = 0
            r0.put(r4, r1)
        L_0x0215:
            r3 = r2
            r2 = r21
            r15 = r22
            goto L_0x0024
        L_0x021c:
            int r2 = r1.length()
            r3 = 4
            if (r2 >= r3) goto L_0x0225
            r2 = 0
            return r2
        L_0x0225:
            r2 = 0
            java.lang.String r16 = r1.substring(r15)
            r3 = 0
            java.lang.String r18 = r1.substring(r3, r15)
            java.lang.String r17 = r4.substring(r15)
            goto L_0x0215
        L_0x0234:
            r2 = 0
            r3 = 0
            java.lang.String r17 = r4.substring(r15)
            r16 = r1
            goto L_0x0215
        L_0x023d:
            r2 = 0
            r3 = 0
            java.lang.String r15 = r4.substring(r15)
            java.lang.String r14 = "LB"
            goto L_0x024e
        L_0x0246:
            r2 = 0
            r3 = 0
            java.lang.String r15 = r4.substring(r15)
            java.lang.String r14 = "KG"
        L_0x024e:
            r13 = r1
            r3 = r2
            r2 = r21
            goto L_0x0024
        L_0x0254:
            r12 = r1
            goto L_0x0261
        L_0x0256:
            r11 = r1
            goto L_0x0261
        L_0x0258:
            r10 = r1
            goto L_0x0261
        L_0x025a:
            r9 = r1
            goto L_0x0261
        L_0x025c:
            r8 = r1
            goto L_0x0261
        L_0x025e:
            r6 = r1
            goto L_0x0261
        L_0x0260:
            r7 = r1
        L_0x0261:
            r2 = r21
            r15 = r22
            r3 = 0
            goto L_0x0024
        L_0x0268:
            r22 = r15
            com.google.zxing.client.a.k r1 = new com.google.zxing.client.a.k
            r4 = r1
            r19 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.a.l.a(com.google.zxing.r):com.google.zxing.client.a.q");
    }
}
