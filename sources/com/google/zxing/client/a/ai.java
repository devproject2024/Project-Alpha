package com.google.zxing.client.a;

import com.google.zxing.r;
import java.util.regex.Pattern;

public final class ai extends u {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f40021a = Pattern.compile("[IOQ]");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f40022b = Pattern.compile("[A-Z0-9]{17}");

    public final /* synthetic */ q a(r rVar) {
        return d(rVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x015d A[Catch:{ IllegalArgumentException -> 0x01c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0164 A[Catch:{ IllegalArgumentException -> 0x01c5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.zxing.client.a.ah d(com.google.zxing.r r19) {
        /*
            r0 = r19
            com.google.zxing.a r1 = r0.f40580d
            com.google.zxing.a r2 = com.google.zxing.a.CODE_39
            r3 = 0
            if (r1 == r2) goto L_0x000a
            return r3
        L_0x000a:
            java.lang.String r0 = r0.f40577a
            java.util.regex.Pattern r1 = f40021a
            java.util.regex.Matcher r0 = r1.matcher(r0)
            java.lang.String r1 = ""
            java.lang.String r0 = r0.replaceAll(r1)
            java.lang.String r5 = r0.trim()
            java.util.regex.Pattern r0 = f40022b
            java.util.regex.Matcher r0 = r0.matcher(r5)
            boolean r0 = r0.matches()
            if (r0 != 0) goto L_0x0029
            return r3
        L_0x0029:
            r1 = 0
            r2 = 0
        L_0x002b:
            int r4 = r5.length()     // Catch:{ IllegalArgumentException -> 0x01c7 }
            r6 = 8
            r7 = 83
            r8 = 74
            r9 = 48
            r10 = 57
            r11 = 9
            r12 = 10
            r13 = 1
            r14 = 82
            r15 = 65
            if (r1 >= r4) goto L_0x0096
            int r4 = r1 + 1
            if (r4 <= 0) goto L_0x004e
            r0 = 7
            if (r4 > r0) goto L_0x004e
            int r0 = 9 - r4
            goto L_0x005f
        L_0x004e:
            if (r4 != r6) goto L_0x0053
            r0 = 10
            goto L_0x005f
        L_0x0053:
            if (r4 != r11) goto L_0x0057
            r0 = 0
            goto L_0x005f
        L_0x0057:
            if (r4 < r12) goto L_0x0090
            r0 = 17
            if (r4 > r0) goto L_0x0090
            int r0 = 19 - r4
        L_0x005f:
            char r1 = r5.charAt(r1)     // Catch:{ IllegalArgumentException -> 0x01c7 }
            if (r1 < r15) goto L_0x006d
            r6 = 73
            if (r1 > r6) goto L_0x006d
            int r1 = r1 + -65
        L_0x006b:
            int r1 = r1 + r13
            goto L_0x0085
        L_0x006d:
            if (r1 < r8) goto L_0x0074
            if (r1 > r14) goto L_0x0074
            int r1 = r1 + -74
            goto L_0x006b
        L_0x0074:
            if (r1 < r7) goto L_0x007f
            r6 = 90
            if (r1 > r6) goto L_0x007f
            int r1 = r1 + -83
            int r1 = r1 + 2
            goto L_0x0085
        L_0x007f:
            if (r1 < r9) goto L_0x008a
            if (r1 > r10) goto L_0x008a
            int r1 = r1 + -48
        L_0x0085:
            int r0 = r0 * r1
            int r2 = r2 + r0
            r1 = r4
            goto L_0x002b
        L_0x008a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01c7 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x01c7 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01c7 }
        L_0x0090:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01c7 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x01c7 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01c7 }
        L_0x0096:
            char r0 = r5.charAt(r6)     // Catch:{ IllegalArgumentException -> 0x01c7 }
            int r2 = r2 % 11
            if (r2 >= r12) goto L_0x00a1
            int r2 = r2 + r9
            char r1 = (char) r2     // Catch:{ IllegalArgumentException -> 0x01c7 }
            goto L_0x00a5
        L_0x00a1:
            if (r2 != r12) goto L_0x01bf
            r1 = 88
        L_0x00a5:
            if (r0 != r1) goto L_0x00a9
            r0 = 1
            goto L_0x00aa
        L_0x00a9:
            r0 = 0
        L_0x00aa:
            if (r0 != 0) goto L_0x00ad
            return r3
        L_0x00ad:
            r0 = 3
            r1 = 0
            java.lang.String r2 = r5.substring(r1, r0)     // Catch:{ IllegalArgumentException -> 0x01c7 }
            com.google.zxing.client.a.ah r16 = new com.google.zxing.client.a.ah     // Catch:{ IllegalArgumentException -> 0x01c7 }
            java.lang.String r17 = r5.substring(r0, r11)     // Catch:{ IllegalArgumentException -> 0x01c7 }
            r4 = 17
            java.lang.String r18 = r5.substring(r11, r4)     // Catch:{ IllegalArgumentException -> 0x01c7 }
            char r1 = r2.charAt(r1)     // Catch:{ IllegalArgumentException -> 0x01c7 }
            char r4 = r2.charAt(r13)     // Catch:{ IllegalArgumentException -> 0x01c7 }
            r13 = 84
            r3 = 69
            if (r1 == r10) goto L_0x0141
            if (r1 == r7) goto L_0x012f
            r12 = 90
            if (r1 == r12) goto L_0x0128
            switch(r1) {
                case 49: goto L_0x0124;
                case 50: goto L_0x0121;
                case 51: goto L_0x0118;
                case 52: goto L_0x0124;
                case 53: goto L_0x0124;
                default: goto L_0x00d6;
            }
        L_0x00d6:
            switch(r1) {
                case 74: goto L_0x0111;
                case 75: goto L_0x0108;
                case 76: goto L_0x0105;
                case 77: goto L_0x00fe;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            switch(r1) {
                case 86: goto L_0x00ec;
                case 87: goto L_0x00e9;
                case 88: goto L_0x00de;
                default: goto L_0x00dc;
            }
        L_0x00dc:
            goto L_0x014e
        L_0x00de:
            if (r4 == r9) goto L_0x00e6
            r1 = 51
            if (r4 < r1) goto L_0x014e
            if (r4 > r10) goto L_0x014e
        L_0x00e6:
            java.lang.String r1 = "RU"
            goto L_0x0126
        L_0x00e9:
            java.lang.String r1 = "DE"
            goto L_0x0126
        L_0x00ec:
            r1 = 70
            if (r4 < r1) goto L_0x00f5
            if (r4 > r14) goto L_0x00f5
            java.lang.String r1 = "FR"
            goto L_0x0126
        L_0x00f5:
            if (r4 < r7) goto L_0x014e
            r1 = 87
            if (r4 > r1) goto L_0x014e
            java.lang.String r1 = "ES"
            goto L_0x0126
        L_0x00fe:
            if (r4 < r15) goto L_0x014e
            if (r4 > r3) goto L_0x014e
            java.lang.String r1 = "IN"
            goto L_0x0126
        L_0x0105:
            java.lang.String r1 = "CN"
            goto L_0x0126
        L_0x0108:
            r1 = 76
            if (r4 < r1) goto L_0x014e
            if (r4 > r14) goto L_0x014e
            java.lang.String r1 = "KO"
            goto L_0x0126
        L_0x0111:
            if (r4 < r15) goto L_0x014e
            if (r4 > r13) goto L_0x014e
            java.lang.String r1 = "JP"
            goto L_0x0126
        L_0x0118:
            if (r4 < r15) goto L_0x014e
            r1 = 87
            if (r4 > r1) goto L_0x014e
            java.lang.String r1 = "MX"
            goto L_0x0126
        L_0x0121:
            java.lang.String r1 = "CA"
            goto L_0x0126
        L_0x0124:
            java.lang.String r1 = "US"
        L_0x0126:
            r9 = r1
            goto L_0x014f
        L_0x0128:
            if (r4 < r15) goto L_0x014e
            if (r4 > r14) goto L_0x014e
            java.lang.String r1 = "IT"
            goto L_0x0126
        L_0x012f:
            if (r4 < r15) goto L_0x0138
            r1 = 77
            if (r4 > r1) goto L_0x0138
            java.lang.String r1 = "UK"
            goto L_0x0126
        L_0x0138:
            r1 = 78
            if (r4 < r1) goto L_0x014e
            if (r4 > r13) goto L_0x014e
            java.lang.String r1 = "DE"
            goto L_0x0126
        L_0x0141:
            if (r4 < r15) goto L_0x0145
            if (r4 <= r3) goto L_0x014b
        L_0x0145:
            r1 = 51
            if (r4 < r1) goto L_0x014e
            if (r4 > r10) goto L_0x014e
        L_0x014b:
            java.lang.String r1 = "BR"
            goto L_0x0126
        L_0x014e:
            r9 = 0
        L_0x014f:
            java.lang.String r0 = r5.substring(r0, r6)     // Catch:{ IllegalArgumentException -> 0x01c5 }
            char r1 = r5.charAt(r11)     // Catch:{ IllegalArgumentException -> 0x01c5 }
            if (r1 < r3) goto L_0x0164
            r4 = 72
            if (r1 > r4) goto L_0x0164
            int r1 = r1 - r3
            int r1 = r1 + 1984
        L_0x0160:
            r11 = r1
            r1 = 10
            goto L_0x01a3
        L_0x0164:
            if (r1 < r8) goto L_0x016e
            r3 = 78
            if (r1 > r3) goto L_0x016e
            int r1 = r1 - r8
            int r1 = r1 + 1988
            goto L_0x0160
        L_0x016e:
            r3 = 80
            if (r1 != r3) goto L_0x0179
            r1 = 1993(0x7c9, float:2.793E-42)
            r1 = 10
            r11 = 1993(0x7c9, float:2.793E-42)
            goto L_0x01a3
        L_0x0179:
            if (r1 < r14) goto L_0x0181
            if (r1 > r13) goto L_0x0181
            int r1 = r1 - r14
            int r1 = r1 + 1994
            goto L_0x0160
        L_0x0181:
            r3 = 86
            if (r1 < r3) goto L_0x018e
            r3 = 89
            if (r1 > r3) goto L_0x018e
            int r1 = r1 + -86
            int r1 = r1 + 1997
            goto L_0x0160
        L_0x018e:
            r3 = 49
            if (r1 < r3) goto L_0x0199
            if (r1 > r10) goto L_0x0199
            int r1 = r1 + -49
            int r1 = r1 + 2001
            goto L_0x0160
        L_0x0199:
            if (r1 < r15) goto L_0x01b9
            r3 = 68
            if (r1 > r3) goto L_0x01b9
            int r1 = r1 - r15
            int r1 = r1 + 2010
            goto L_0x0160
        L_0x01a3:
            char r12 = r5.charAt(r1)     // Catch:{ IllegalArgumentException -> 0x01c5 }
            r1 = 11
            java.lang.String r13 = r5.substring(r1)     // Catch:{ IllegalArgumentException -> 0x01c5 }
            r4 = r16
            r6 = r2
            r7 = r17
            r8 = r18
            r10 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ IllegalArgumentException -> 0x01c5 }
            return r16
        L_0x01b9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01c5 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x01c5 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01c5 }
        L_0x01bf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01c5 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x01c5 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01c5 }
        L_0x01c5:
            r0 = 0
            goto L_0x01c8
        L_0x01c7:
            r0 = r3
        L_0x01c8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.a.ai.d(com.google.zxing.r):com.google.zxing.client.a.ah");
    }
}
