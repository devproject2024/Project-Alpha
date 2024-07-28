package com.google.zxing.e;

import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.google.zxing.d;
import com.paytm.android.chat.utils.KeyList;

public final class g extends r {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f40372a;

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f40373b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final int f40374c;

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f40375d = new StringBuilder(20);

    /* renamed from: e  reason: collision with root package name */
    private final int[] f40376e = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, H5ErrorCode.HTTP_NOT_FOUND, KeyList.IntentRequestKey.INTENT_USER_CENTER_RESULT_ACTION_CLEAR, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_FILE, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f40372a = iArr;
        f40374c = iArr[47];
    }

    private static int a(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int length = iArr.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int round = Math.round((((float) iArr[i5]) * 9.0f) / ((float) i2));
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                int i6 = i4;
                for (int i7 = 0; i7 < round; i7++) {
                    i6 = (i6 << 1) | 1;
                }
                i4 = i6;
            } else {
                i4 <<= round;
            }
        }
        return i4;
    }

    private static void a(CharSequence charSequence, int i2, int i3) throws d {
        int i4 = 0;
        int i5 = 1;
        for (int i6 = i2 - 1; i6 >= 0; i6--) {
            i4 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i6)) * i5;
            i5++;
            if (i5 > i3) {
                i5 = 1;
            }
        }
        if (charSequence.charAt(i2) != f40373b[i4 % 47]) {
            throw d.getChecksumInstance();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        r8 = f40373b[r9];
        r7.append(r8);
        r9 = r6.length;
        r12 = r4;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r10 >= r9) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9 = r1.c(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        if (r8 != '*') goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        r7.deleteCharAt(r7.length() - 1);
        r8 = r6.length;
        r10 = 0;
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0085, code lost:
        if (r10 >= r8) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        if (r9 == r5) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0093, code lost:
        if (r1.a(r9) == false) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0099, code lost:
        if (r7.length() < 2) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r7.length();
        a((java.lang.CharSequence) r7, r1 - 2, 20);
        a((java.lang.CharSequence) r7, r1 - 1, 15);
        r7.setLength(r7.length() - 2);
        r1 = r7.length();
        r5 = new java.lang.StringBuilder(r1);
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00be, code lost:
        if (r6 >= r1) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c0, code lost:
        r8 = r7.charAt(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c6, code lost:
        if (r8 < 'a') goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ca, code lost:
        if (r8 > 'd') goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ce, code lost:
        if (r6 >= (r1 - 1)) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d0, code lost:
        r6 = r6 + 1;
        r9 = r7.charAt(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dc, code lost:
        switch(r8) {
            case 97: goto L_0x0135;
            case 98: goto L_0x00ff;
            case 99: goto L_0x00ee;
            case 100: goto L_0x00e2;
            default: goto L_0x00df;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00df, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (r9 < 'A') goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e4, code lost:
        if (r9 > 'Z') goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e6, code lost:
        r9 = r9 + ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ed, code lost:
        throw com.google.zxing.h.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ee, code lost:
        if (r9 < 'A') goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f0, code lost:
        if (r9 > 'O') goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f2, code lost:
        r9 = r9 - ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f5, code lost:
        if (r9 != 'Z') goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f7, code lost:
        r8 = ':';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00fe, code lost:
        throw com.google.zxing.h.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ff, code lost:
        if (r9 < 'A') goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0103, code lost:
        if (r9 > 'E') goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0105, code lost:
        r9 = r9 - '&';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010a, code lost:
        if (r9 < 'F') goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010e, code lost:
        if (r9 > 'J') goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0110, code lost:
        r9 = r9 - 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0115, code lost:
        if (r9 < 'K') goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0117, code lost:
        if (r9 > 'O') goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0119, code lost:
        r9 = r9 + 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011e, code lost:
        if (r9 < 'P') goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0122, code lost:
        if (r9 > 'S') goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0124, code lost:
        r9 = r9 + '+';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0129, code lost:
        if (r9 < 'T') goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012b, code lost:
        if (r9 > 'Z') goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012d, code lost:
        r8 = 127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0134, code lost:
        throw com.google.zxing.h.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0135, code lost:
        if (r9 < 'A') goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0137, code lost:
        if (r9 > 'Z') goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0139, code lost:
        r9 = r9 - '@';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x013b, code lost:
        r8 = (char) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0141, code lost:
        throw com.google.zxing.h.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0142, code lost:
        r5.append(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x014a, code lost:
        throw com.google.zxing.h.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x014b, code lost:
        r5.append(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x014e, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0151, code lost:
        r9 = (float) r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x017d, code lost:
        return new com.google.zxing.r(r5.toString(), (byte[]) null, new com.google.zxing.t[]{new com.google.zxing.t(((float) (r2[1] + r2[0])) / 2.0f, r9), new com.google.zxing.t(((float) r4) + (((float) r12) / 2.0f), r9)}, com.google.zxing.a.CODE_93);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0182, code lost:
        throw com.google.zxing.m.getNotFoundInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0187, code lost:
        throw com.google.zxing.m.getNotFoundInstance();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.r a(int r17, com.google.zxing.b.a r18, java.util.Map<com.google.zxing.e, ?> r19) throws com.google.zxing.m, com.google.zxing.d, com.google.zxing.h {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            int r2 = r1.f39881b
            r3 = 0
            int r4 = r1.c(r3)
            int[] r5 = r0.f40376e
            java.util.Arrays.fill(r5, r3)
            int[] r5 = r0.f40376e
            int r6 = r5.length
            r9 = r4
            r7 = 0
            r8 = 0
        L_0x0016:
            if (r4 >= r2) goto L_0x01bd
            boolean r10 = r1.a((int) r4)
            r11 = 1
            if (r10 == r7) goto L_0x0028
            r10 = r5[r8]
            int r10 = r10 + r11
            r5[r8] = r10
            r10 = r17
            goto L_0x01b9
        L_0x0028:
            int r10 = r6 + -1
            if (r8 != r10) goto L_0x01b1
            int r10 = a(r5)
            int r12 = f40374c
            r13 = 2
            if (r10 != r12) goto L_0x019d
            int[] r2 = new int[r13]
            r2[r3] = r9
            r2[r11] = r4
            r4 = r2[r11]
            int r4 = r1.c(r4)
            int r5 = r1.f39881b
            int[] r6 = r0.f40376e
            java.util.Arrays.fill(r6, r3)
            java.lang.StringBuilder r7 = r0.f40375d
            r7.setLength(r3)
        L_0x004d:
            a((com.google.zxing.b.a) r1, (int) r4, (int[]) r6)
            int r8 = a(r6)
            if (r8 < 0) goto L_0x0198
            r9 = 0
        L_0x0057:
            int[] r10 = f40372a
            int r12 = r10.length
            if (r9 >= r12) goto L_0x0193
            r10 = r10[r9]
            if (r10 != r8) goto L_0x018d
            char[] r8 = f40373b
            char r8 = r8[r9]
            r7.append(r8)
            int r9 = r6.length
            r12 = r4
            r10 = 0
        L_0x006a:
            if (r10 >= r9) goto L_0x0072
            r14 = r6[r10]
            int r12 = r12 + r14
            int r10 = r10 + 1
            goto L_0x006a
        L_0x0072:
            int r9 = r1.c(r12)
            r10 = 42
            if (r8 != r10) goto L_0x0188
            int r8 = r7.length()
            int r8 = r8 - r11
            r7.deleteCharAt(r8)
            int r8 = r6.length
            r10 = 0
            r12 = 0
        L_0x0085:
            if (r10 >= r8) goto L_0x008d
            r14 = r6[r10]
            int r12 = r12 + r14
            int r10 = r10 + 1
            goto L_0x0085
        L_0x008d:
            if (r9 == r5) goto L_0x0183
            boolean r1 = r1.a((int) r9)
            if (r1 == 0) goto L_0x0183
            int r1 = r7.length()
            if (r1 < r13) goto L_0x017e
            int r1 = r7.length()
            int r5 = r1 + -2
            r6 = 20
            a((java.lang.CharSequence) r7, (int) r5, (int) r6)
            int r1 = r1 - r11
            r5 = 15
            a((java.lang.CharSequence) r7, (int) r1, (int) r5)
            int r1 = r7.length()
            int r1 = r1 - r13
            r7.setLength(r1)
            int r1 = r7.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
            r6 = 0
        L_0x00be:
            if (r6 >= r1) goto L_0x0151
            char r8 = r7.charAt(r6)
            r9 = 97
            if (r8 < r9) goto L_0x014b
            r9 = 100
            if (r8 > r9) goto L_0x014b
            int r9 = r1 + -1
            if (r6 >= r9) goto L_0x0146
            int r6 = r6 + 1
            char r9 = r7.charAt(r6)
            r10 = 79
            r14 = 90
            r15 = 65
            switch(r8) {
                case 97: goto L_0x0135;
                case 98: goto L_0x00ff;
                case 99: goto L_0x00ee;
                case 100: goto L_0x00e2;
                default: goto L_0x00df;
            }
        L_0x00df:
            r8 = 0
            goto L_0x0142
        L_0x00e2:
            if (r9 < r15) goto L_0x00e9
            if (r9 > r14) goto L_0x00e9
            int r9 = r9 + 32
            goto L_0x013b
        L_0x00e9:
            com.google.zxing.h r1 = com.google.zxing.h.getFormatInstance()
            throw r1
        L_0x00ee:
            if (r9 < r15) goto L_0x00f5
            if (r9 > r10) goto L_0x00f5
            int r9 = r9 + -32
            goto L_0x013b
        L_0x00f5:
            if (r9 != r14) goto L_0x00fa
            r8 = 58
            goto L_0x0142
        L_0x00fa:
            com.google.zxing.h r1 = com.google.zxing.h.getFormatInstance()
            throw r1
        L_0x00ff:
            if (r9 < r15) goto L_0x0108
            r8 = 69
            if (r9 > r8) goto L_0x0108
            int r9 = r9 + -38
            goto L_0x013b
        L_0x0108:
            r8 = 70
            if (r9 < r8) goto L_0x0113
            r8 = 74
            if (r9 > r8) goto L_0x0113
            int r9 = r9 + -11
            goto L_0x013b
        L_0x0113:
            r8 = 75
            if (r9 < r8) goto L_0x011c
            if (r9 > r10) goto L_0x011c
            int r9 = r9 + 16
            goto L_0x013b
        L_0x011c:
            r8 = 80
            if (r9 < r8) goto L_0x0127
            r8 = 83
            if (r9 > r8) goto L_0x0127
            int r9 = r9 + 43
            goto L_0x013b
        L_0x0127:
            r8 = 84
            if (r9 < r8) goto L_0x0130
            if (r9 > r14) goto L_0x0130
            r8 = 127(0x7f, float:1.78E-43)
            goto L_0x0142
        L_0x0130:
            com.google.zxing.h r1 = com.google.zxing.h.getFormatInstance()
            throw r1
        L_0x0135:
            if (r9 < r15) goto L_0x013d
            if (r9 > r14) goto L_0x013d
            int r9 = r9 + -64
        L_0x013b:
            char r8 = (char) r9
            goto L_0x0142
        L_0x013d:
            com.google.zxing.h r1 = com.google.zxing.h.getFormatInstance()
            throw r1
        L_0x0142:
            r5.append(r8)
            goto L_0x014e
        L_0x0146:
            com.google.zxing.h r1 = com.google.zxing.h.getFormatInstance()
            throw r1
        L_0x014b:
            r5.append(r8)
        L_0x014e:
            int r6 = r6 + r11
            goto L_0x00be
        L_0x0151:
            java.lang.String r1 = r5.toString()
            r5 = r2[r11]
            r2 = r2[r3]
            int r5 = r5 + r2
            float r2 = (float) r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r5
            float r4 = (float) r4
            float r6 = (float) r12
            float r6 = r6 / r5
            float r4 = r4 + r6
            com.google.zxing.r r5 = new com.google.zxing.r
            r6 = 0
            com.google.zxing.t[] r7 = new com.google.zxing.t[r13]
            com.google.zxing.t r8 = new com.google.zxing.t
            r10 = r17
            float r9 = (float) r10
            r8.<init>(r2, r9)
            r7[r3] = r8
            com.google.zxing.t r2 = new com.google.zxing.t
            r2.<init>(r4, r9)
            r7[r11] = r2
            com.google.zxing.a r2 = com.google.zxing.a.CODE_93
            r5.<init>(r1, r6, r7, r2)
            return r5
        L_0x017e:
            com.google.zxing.m r1 = com.google.zxing.m.getNotFoundInstance()
            throw r1
        L_0x0183:
            com.google.zxing.m r1 = com.google.zxing.m.getNotFoundInstance()
            throw r1
        L_0x0188:
            r10 = r17
            r4 = r9
            goto L_0x004d
        L_0x018d:
            r10 = r17
            int r9 = r9 + 1
            goto L_0x0057
        L_0x0193:
            com.google.zxing.m r1 = com.google.zxing.m.getNotFoundInstance()
            throw r1
        L_0x0198:
            com.google.zxing.m r1 = com.google.zxing.m.getNotFoundInstance()
            throw r1
        L_0x019d:
            r10 = r17
            r12 = r5[r3]
            r14 = r5[r11]
            int r12 = r12 + r14
            int r9 = r9 + r12
            int r12 = r8 + -1
            java.lang.System.arraycopy(r5, r13, r5, r3, r12)
            r5[r12] = r3
            r5[r8] = r3
            int r8 = r8 + -1
            goto L_0x01b5
        L_0x01b1:
            r10 = r17
            int r8 = r8 + 1
        L_0x01b5:
            r5[r8] = r11
            r7 = r7 ^ 1
        L_0x01b9:
            int r4 = r4 + 1
            goto L_0x0016
        L_0x01bd:
            com.google.zxing.m r1 = com.google.zxing.m.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.g.a(int, com.google.zxing.b.a, java.util.Map):com.google.zxing.r");
    }
}
