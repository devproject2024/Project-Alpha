package io.branch.referral;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import java.io.UnsupportedEncodingException;
import net.one97.paytm.upi.util.UpiConstants;

final class b {

    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f46446a;

        /* renamed from: b  reason: collision with root package name */
        public int f46447b;

        a() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010f, code lost:
        if (r8 == 0) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0111, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0112, code lost:
        if (r8 == 1) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0114, code lost:
        if (r8 == 2) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0116, code lost:
        if (r8 == 3) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0118, code lost:
        if (r8 == 4) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011b, code lost:
        r2.f46454c = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x011f, code lost:
        r1 = r13 + 1;
        r9[r13] = (byte) (r12 >> 10);
        r13 = r1 + 1;
        r9[r1] = (byte) (r12 >> 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012e, code lost:
        r9[r13] = (byte) (r12 >> 4);
        r13 = r13 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0137, code lost:
        r2.f46454c = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013b, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013c, code lost:
        r2.f46454c = r8;
        r2.f46447b = r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r17) {
        /*
            r0 = r17
            int r1 = r0.length
            io.branch.referral.b$b r2 = new io.branch.referral.b$b
            int r3 = r1 * 3
            r4 = 4
            int r3 = r3 / r4
            byte[] r3 = new byte[r3]
            r2.<init>(r3)
            int r3 = r2.f46454c
            r5 = 6
            r6 = 0
            r7 = 1
            if (r3 != r5) goto L_0x0018
        L_0x0015:
            r0 = 0
            goto L_0x0140
        L_0x0018:
            int r1 = r1 + r6
            int r3 = r2.f46454c
            int r8 = r2.f46455d
            byte[] r9 = r2.f46446a
            int[] r10 = r2.f46456e
            r12 = r8
            r13 = 0
            r8 = r3
            r3 = 0
        L_0x0025:
            r14 = 3
            r15 = 2
            if (r3 >= r1) goto L_0x010f
            if (r8 != 0) goto L_0x006f
        L_0x002b:
            int r6 = r3 + 4
            if (r6 > r1) goto L_0x006d
            byte r12 = r0[r3]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r10[r12]
            int r12 = r12 << 18
            int r16 = r3 + 1
            byte r11 = r0[r16]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r11 = r10[r11]
            int r11 = r11 << 12
            r11 = r11 | r12
            int r12 = r3 + 2
            byte r12 = r0[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r10[r12]
            int r12 = r12 << r5
            r11 = r11 | r12
            int r12 = r3 + 3
            byte r12 = r0[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r12 = r10[r12]
            r12 = r12 | r11
            if (r12 < 0) goto L_0x006d
            int r3 = r13 + 2
            byte r11 = (byte) r12
            r9[r3] = r11
            int r3 = r13 + 1
            int r11 = r12 >> 8
            byte r11 = (byte) r11
            r9[r3] = r11
            int r3 = r12 >> 16
            byte r3 = (byte) r3
            r9[r13] = r3
            int r13 = r13 + 3
            r3 = r6
            r6 = 0
            goto L_0x002b
        L_0x006d:
            if (r3 >= r1) goto L_0x010f
        L_0x006f:
            int r6 = r3 + 1
            byte r3 = r0[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r10[r3]
            r11 = -1
            if (r8 == 0) goto L_0x00fd
            if (r8 == r7) goto L_0x00ed
            r7 = -2
            if (r8 == r15) goto L_0x00d3
            if (r8 == r14) goto L_0x0097
            if (r8 == r4) goto L_0x008d
            r14 = 5
            if (r8 == r14) goto L_0x0088
            goto L_0x010a
        L_0x0088:
            if (r3 == r11) goto L_0x010a
            r2.f46454c = r5
            goto L_0x0015
        L_0x008d:
            r14 = 5
            if (r3 != r7) goto L_0x0091
            goto L_0x00f4
        L_0x0091:
            if (r3 == r11) goto L_0x010a
            r2.f46454c = r5
            goto L_0x0015
        L_0x0097:
            r14 = 5
            if (r3 < 0) goto L_0x00b7
            int r7 = r12 << 6
            r12 = r7 | r3
            int r3 = r13 + 2
            byte r7 = (byte) r12
            r9[r3] = r7
            int r3 = r13 + 1
            int r7 = r12 >> 8
            byte r7 = (byte) r7
            r9[r3] = r7
            int r3 = r12 >> 16
            byte r3 = (byte) r3
            r9[r13] = r3
            int r13 = r13 + 3
            r3 = r6
            r6 = 0
            r7 = 1
            r8 = 0
            goto L_0x0025
        L_0x00b7:
            if (r3 != r7) goto L_0x00cd
            int r3 = r13 + 1
            int r7 = r12 >> 2
            byte r7 = (byte) r7
            r9[r3] = r7
            int r3 = r12 >> 10
            byte r3 = (byte) r3
            r9[r13] = r3
            int r13 = r13 + 2
            r3 = r6
            r6 = 0
            r7 = 1
            r8 = 5
            goto L_0x0025
        L_0x00cd:
            if (r3 == r11) goto L_0x010a
            r2.f46454c = r5
            goto L_0x0015
        L_0x00d3:
            r14 = 5
            if (r3 < 0) goto L_0x00d7
            goto L_0x00f0
        L_0x00d7:
            if (r3 != r7) goto L_0x00e7
            int r3 = r13 + 1
            int r7 = r12 >> 4
            byte r7 = (byte) r7
            r9[r13] = r7
            r13 = r3
            r3 = r6
            r6 = 0
            r7 = 1
            r8 = 4
            goto L_0x0025
        L_0x00e7:
            if (r3 == r11) goto L_0x010a
            r2.f46454c = r5
            goto L_0x0015
        L_0x00ed:
            r14 = 5
            if (r3 < 0) goto L_0x00f7
        L_0x00f0:
            int r7 = r12 << 6
            r12 = r7 | r3
        L_0x00f4:
            int r8 = r8 + 1
            goto L_0x010a
        L_0x00f7:
            if (r3 == r11) goto L_0x010a
            r2.f46454c = r5
            goto L_0x0015
        L_0x00fd:
            r14 = 5
            if (r3 < 0) goto L_0x0104
            int r8 = r8 + 1
            r12 = r3
            goto L_0x010a
        L_0x0104:
            if (r3 == r11) goto L_0x010a
            r2.f46454c = r5
            goto L_0x0015
        L_0x010a:
            r3 = r6
            r6 = 0
            r7 = 1
            goto L_0x0025
        L_0x010f:
            if (r8 == 0) goto L_0x013b
            r0 = 1
            if (r8 == r0) goto L_0x0137
            if (r8 == r15) goto L_0x012e
            if (r8 == r14) goto L_0x011f
            if (r8 == r4) goto L_0x011b
            goto L_0x013c
        L_0x011b:
            r2.f46454c = r5
            goto L_0x0015
        L_0x011f:
            int r1 = r13 + 1
            int r3 = r12 >> 10
            byte r3 = (byte) r3
            r9[r13] = r3
            int r13 = r1 + 1
            int r3 = r12 >> 2
            byte r3 = (byte) r3
            r9[r1] = r3
            goto L_0x013c
        L_0x012e:
            int r1 = r13 + 1
            int r3 = r12 >> 4
            byte r3 = (byte) r3
            r9[r13] = r3
            r13 = r1
            goto L_0x013c
        L_0x0137:
            r2.f46454c = r5
            goto L_0x0015
        L_0x013b:
            r0 = 1
        L_0x013c:
            r2.f46454c = r8
            r2.f46447b = r13
        L_0x0140:
            if (r0 == 0) goto L_0x0159
            int r0 = r2.f46447b
            byte[] r1 = r2.f46446a
            int r1 = r1.length
            if (r0 != r1) goto L_0x014c
            byte[] r0 = r2.f46446a
            return r0
        L_0x014c:
            int r0 = r2.f46447b
            byte[] r0 = new byte[r0]
            byte[] r1 = r2.f46446a
            int r2 = r2.f46447b
            r3 = 0
            java.lang.System.arraycopy(r1, r3, r0, r3, r2)
            return r0
        L_0x0159:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "bad base-64"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.b.a(byte[]):byte[]");
    }

    /* renamed from: io.branch.referral.b$b  reason: collision with other inner class name */
    static class C0781b extends a {

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f46452f;

        /* renamed from: g  reason: collision with root package name */
        private static final int[] f46453g;

        /* renamed from: c  reason: collision with root package name */
        int f46454c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f46455d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int[] f46456e = f46452f;

        static {
            int[] iArr = new int[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];
            // fill-array-data instruction
            iArr[0] = -1;
            iArr[1] = -1;
            iArr[2] = -1;
            iArr[3] = -1;
            iArr[4] = -1;
            iArr[5] = -1;
            iArr[6] = -1;
            iArr[7] = -1;
            iArr[8] = -1;
            iArr[9] = -1;
            iArr[10] = -1;
            iArr[11] = -1;
            iArr[12] = -1;
            iArr[13] = -1;
            iArr[14] = -1;
            iArr[15] = -1;
            iArr[16] = -1;
            iArr[17] = -1;
            iArr[18] = -1;
            iArr[19] = -1;
            iArr[20] = -1;
            iArr[21] = -1;
            iArr[22] = -1;
            iArr[23] = -1;
            iArr[24] = -1;
            iArr[25] = -1;
            iArr[26] = -1;
            iArr[27] = -1;
            iArr[28] = -1;
            iArr[29] = -1;
            iArr[30] = -1;
            iArr[31] = -1;
            iArr[32] = -1;
            iArr[33] = -1;
            iArr[34] = -1;
            iArr[35] = -1;
            iArr[36] = -1;
            iArr[37] = -1;
            iArr[38] = -1;
            iArr[39] = -1;
            iArr[40] = -1;
            iArr[41] = -1;
            iArr[42] = -1;
            iArr[43] = 62;
            iArr[44] = -1;
            iArr[45] = -1;
            iArr[46] = -1;
            iArr[47] = 63;
            iArr[48] = 52;
            iArr[49] = 53;
            iArr[50] = 54;
            iArr[51] = 55;
            iArr[52] = 56;
            iArr[53] = 57;
            iArr[54] = 58;
            iArr[55] = 59;
            iArr[56] = 60;
            iArr[57] = 61;
            iArr[58] = -1;
            iArr[59] = -1;
            iArr[60] = -1;
            iArr[61] = -2;
            iArr[62] = -1;
            iArr[63] = -1;
            iArr[64] = -1;
            iArr[65] = 0;
            iArr[66] = 1;
            iArr[67] = 2;
            iArr[68] = 3;
            iArr[69] = 4;
            iArr[70] = 5;
            iArr[71] = 6;
            iArr[72] = 7;
            iArr[73] = 8;
            iArr[74] = 9;
            iArr[75] = 10;
            iArr[76] = 11;
            iArr[77] = 12;
            iArr[78] = 13;
            iArr[79] = 14;
            iArr[80] = 15;
            iArr[81] = 16;
            iArr[82] = 17;
            iArr[83] = 18;
            iArr[84] = 19;
            iArr[85] = 20;
            iArr[86] = 21;
            iArr[87] = 22;
            iArr[88] = 23;
            iArr[89] = 24;
            iArr[90] = 25;
            iArr[91] = -1;
            iArr[92] = -1;
            iArr[93] = -1;
            iArr[94] = -1;
            iArr[95] = -1;
            iArr[96] = -1;
            iArr[97] = 26;
            iArr[98] = 27;
            iArr[99] = 28;
            iArr[100] = 29;
            iArr[101] = 30;
            iArr[102] = 31;
            iArr[103] = 32;
            iArr[104] = 33;
            iArr[105] = 34;
            iArr[106] = 35;
            iArr[107] = 36;
            iArr[108] = 37;
            iArr[109] = 38;
            iArr[110] = 39;
            iArr[111] = 40;
            iArr[112] = 41;
            iArr[113] = 42;
            iArr[114] = 43;
            iArr[115] = 44;
            iArr[116] = 45;
            iArr[117] = 46;
            iArr[118] = 47;
            iArr[119] = 48;
            iArr[120] = 49;
            iArr[121] = 50;
            iArr[122] = 51;
            iArr[123] = -1;
            iArr[124] = -1;
            iArr[125] = -1;
            iArr[126] = -1;
            iArr[127] = -1;
            iArr[128] = -1;
            iArr[129] = -1;
            iArr[130] = -1;
            iArr[131] = -1;
            iArr[132] = -1;
            iArr[133] = -1;
            iArr[134] = -1;
            iArr[135] = -1;
            iArr[136] = -1;
            iArr[137] = -1;
            iArr[138] = -1;
            iArr[139] = -1;
            iArr[140] = -1;
            iArr[141] = -1;
            iArr[142] = -1;
            iArr[143] = -1;
            iArr[144] = -1;
            iArr[145] = -1;
            iArr[146] = -1;
            iArr[147] = -1;
            iArr[148] = -1;
            iArr[149] = -1;
            iArr[150] = -1;
            iArr[151] = -1;
            iArr[152] = -1;
            iArr[153] = -1;
            iArr[154] = -1;
            iArr[155] = -1;
            iArr[156] = -1;
            iArr[157] = -1;
            iArr[158] = -1;
            iArr[159] = -1;
            iArr[160] = -1;
            iArr[161] = -1;
            iArr[162] = -1;
            iArr[163] = -1;
            iArr[164] = -1;
            iArr[165] = -1;
            iArr[166] = -1;
            iArr[167] = -1;
            iArr[168] = -1;
            iArr[169] = -1;
            iArr[170] = -1;
            iArr[171] = -1;
            iArr[172] = -1;
            iArr[173] = -1;
            iArr[174] = -1;
            iArr[175] = -1;
            iArr[176] = -1;
            iArr[177] = -1;
            iArr[178] = -1;
            iArr[179] = -1;
            iArr[180] = -1;
            iArr[181] = -1;
            iArr[182] = -1;
            iArr[183] = -1;
            iArr[184] = -1;
            iArr[185] = -1;
            iArr[186] = -1;
            iArr[187] = -1;
            iArr[188] = -1;
            iArr[189] = -1;
            iArr[190] = -1;
            iArr[191] = -1;
            iArr[192] = -1;
            iArr[193] = -1;
            iArr[194] = -1;
            iArr[195] = -1;
            iArr[196] = -1;
            iArr[197] = -1;
            iArr[198] = -1;
            iArr[199] = -1;
            iArr[200] = -1;
            iArr[201] = -1;
            iArr[202] = -1;
            iArr[203] = -1;
            iArr[204] = -1;
            iArr[205] = -1;
            iArr[206] = -1;
            iArr[207] = -1;
            iArr[208] = -1;
            iArr[209] = -1;
            iArr[210] = -1;
            iArr[211] = -1;
            iArr[212] = -1;
            iArr[213] = -1;
            iArr[214] = -1;
            iArr[215] = -1;
            iArr[216] = -1;
            iArr[217] = -1;
            iArr[218] = -1;
            iArr[219] = -1;
            iArr[220] = -1;
            iArr[221] = -1;
            iArr[222] = -1;
            iArr[223] = -1;
            iArr[224] = -1;
            iArr[225] = -1;
            iArr[226] = -1;
            iArr[227] = -1;
            iArr[228] = -1;
            iArr[229] = -1;
            iArr[230] = -1;
            iArr[231] = -1;
            iArr[232] = -1;
            iArr[233] = -1;
            iArr[234] = -1;
            iArr[235] = -1;
            iArr[236] = -1;
            iArr[237] = -1;
            iArr[238] = -1;
            iArr[239] = -1;
            iArr[240] = -1;
            iArr[241] = -1;
            iArr[242] = -1;
            iArr[243] = -1;
            iArr[244] = -1;
            iArr[245] = -1;
            iArr[246] = -1;
            iArr[247] = -1;
            iArr[248] = -1;
            iArr[249] = -1;
            iArr[250] = -1;
            iArr[251] = -1;
            iArr[252] = -1;
            iArr[253] = -1;
            iArr[254] = -1;
            iArr[255] = -1;
            f46452f = iArr;
            int[] iArr2 = new int[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];
            // fill-array-data instruction
            iArr2[0] = -1;
            iArr2[1] = -1;
            iArr2[2] = -1;
            iArr2[3] = -1;
            iArr2[4] = -1;
            iArr2[5] = -1;
            iArr2[6] = -1;
            iArr2[7] = -1;
            iArr2[8] = -1;
            iArr2[9] = -1;
            iArr2[10] = -1;
            iArr2[11] = -1;
            iArr2[12] = -1;
            iArr2[13] = -1;
            iArr2[14] = -1;
            iArr2[15] = -1;
            iArr2[16] = -1;
            iArr2[17] = -1;
            iArr2[18] = -1;
            iArr2[19] = -1;
            iArr2[20] = -1;
            iArr2[21] = -1;
            iArr2[22] = -1;
            iArr2[23] = -1;
            iArr2[24] = -1;
            iArr2[25] = -1;
            iArr2[26] = -1;
            iArr2[27] = -1;
            iArr2[28] = -1;
            iArr2[29] = -1;
            iArr2[30] = -1;
            iArr2[31] = -1;
            iArr2[32] = -1;
            iArr2[33] = -1;
            iArr2[34] = -1;
            iArr2[35] = -1;
            iArr2[36] = -1;
            iArr2[37] = -1;
            iArr2[38] = -1;
            iArr2[39] = -1;
            iArr2[40] = -1;
            iArr2[41] = -1;
            iArr2[42] = -1;
            iArr2[43] = -1;
            iArr2[44] = -1;
            iArr2[45] = 62;
            iArr2[46] = -1;
            iArr2[47] = -1;
            iArr2[48] = 52;
            iArr2[49] = 53;
            iArr2[50] = 54;
            iArr2[51] = 55;
            iArr2[52] = 56;
            iArr2[53] = 57;
            iArr2[54] = 58;
            iArr2[55] = 59;
            iArr2[56] = 60;
            iArr2[57] = 61;
            iArr2[58] = -1;
            iArr2[59] = -1;
            iArr2[60] = -1;
            iArr2[61] = -2;
            iArr2[62] = -1;
            iArr2[63] = -1;
            iArr2[64] = -1;
            iArr2[65] = 0;
            iArr2[66] = 1;
            iArr2[67] = 2;
            iArr2[68] = 3;
            iArr2[69] = 4;
            iArr2[70] = 5;
            iArr2[71] = 6;
            iArr2[72] = 7;
            iArr2[73] = 8;
            iArr2[74] = 9;
            iArr2[75] = 10;
            iArr2[76] = 11;
            iArr2[77] = 12;
            iArr2[78] = 13;
            iArr2[79] = 14;
            iArr2[80] = 15;
            iArr2[81] = 16;
            iArr2[82] = 17;
            iArr2[83] = 18;
            iArr2[84] = 19;
            iArr2[85] = 20;
            iArr2[86] = 21;
            iArr2[87] = 22;
            iArr2[88] = 23;
            iArr2[89] = 24;
            iArr2[90] = 25;
            iArr2[91] = -1;
            iArr2[92] = -1;
            iArr2[93] = -1;
            iArr2[94] = -1;
            iArr2[95] = 63;
            iArr2[96] = -1;
            iArr2[97] = 26;
            iArr2[98] = 27;
            iArr2[99] = 28;
            iArr2[100] = 29;
            iArr2[101] = 30;
            iArr2[102] = 31;
            iArr2[103] = 32;
            iArr2[104] = 33;
            iArr2[105] = 34;
            iArr2[106] = 35;
            iArr2[107] = 36;
            iArr2[108] = 37;
            iArr2[109] = 38;
            iArr2[110] = 39;
            iArr2[111] = 40;
            iArr2[112] = 41;
            iArr2[113] = 42;
            iArr2[114] = 43;
            iArr2[115] = 44;
            iArr2[116] = 45;
            iArr2[117] = 46;
            iArr2[118] = 47;
            iArr2[119] = 48;
            iArr2[120] = 49;
            iArr2[121] = 50;
            iArr2[122] = 51;
            iArr2[123] = -1;
            iArr2[124] = -1;
            iArr2[125] = -1;
            iArr2[126] = -1;
            iArr2[127] = -1;
            iArr2[128] = -1;
            iArr2[129] = -1;
            iArr2[130] = -1;
            iArr2[131] = -1;
            iArr2[132] = -1;
            iArr2[133] = -1;
            iArr2[134] = -1;
            iArr2[135] = -1;
            iArr2[136] = -1;
            iArr2[137] = -1;
            iArr2[138] = -1;
            iArr2[139] = -1;
            iArr2[140] = -1;
            iArr2[141] = -1;
            iArr2[142] = -1;
            iArr2[143] = -1;
            iArr2[144] = -1;
            iArr2[145] = -1;
            iArr2[146] = -1;
            iArr2[147] = -1;
            iArr2[148] = -1;
            iArr2[149] = -1;
            iArr2[150] = -1;
            iArr2[151] = -1;
            iArr2[152] = -1;
            iArr2[153] = -1;
            iArr2[154] = -1;
            iArr2[155] = -1;
            iArr2[156] = -1;
            iArr2[157] = -1;
            iArr2[158] = -1;
            iArr2[159] = -1;
            iArr2[160] = -1;
            iArr2[161] = -1;
            iArr2[162] = -1;
            iArr2[163] = -1;
            iArr2[164] = -1;
            iArr2[165] = -1;
            iArr2[166] = -1;
            iArr2[167] = -1;
            iArr2[168] = -1;
            iArr2[169] = -1;
            iArr2[170] = -1;
            iArr2[171] = -1;
            iArr2[172] = -1;
            iArr2[173] = -1;
            iArr2[174] = -1;
            iArr2[175] = -1;
            iArr2[176] = -1;
            iArr2[177] = -1;
            iArr2[178] = -1;
            iArr2[179] = -1;
            iArr2[180] = -1;
            iArr2[181] = -1;
            iArr2[182] = -1;
            iArr2[183] = -1;
            iArr2[184] = -1;
            iArr2[185] = -1;
            iArr2[186] = -1;
            iArr2[187] = -1;
            iArr2[188] = -1;
            iArr2[189] = -1;
            iArr2[190] = -1;
            iArr2[191] = -1;
            iArr2[192] = -1;
            iArr2[193] = -1;
            iArr2[194] = -1;
            iArr2[195] = -1;
            iArr2[196] = -1;
            iArr2[197] = -1;
            iArr2[198] = -1;
            iArr2[199] = -1;
            iArr2[200] = -1;
            iArr2[201] = -1;
            iArr2[202] = -1;
            iArr2[203] = -1;
            iArr2[204] = -1;
            iArr2[205] = -1;
            iArr2[206] = -1;
            iArr2[207] = -1;
            iArr2[208] = -1;
            iArr2[209] = -1;
            iArr2[210] = -1;
            iArr2[211] = -1;
            iArr2[212] = -1;
            iArr2[213] = -1;
            iArr2[214] = -1;
            iArr2[215] = -1;
            iArr2[216] = -1;
            iArr2[217] = -1;
            iArr2[218] = -1;
            iArr2[219] = -1;
            iArr2[220] = -1;
            iArr2[221] = -1;
            iArr2[222] = -1;
            iArr2[223] = -1;
            iArr2[224] = -1;
            iArr2[225] = -1;
            iArr2[226] = -1;
            iArr2[227] = -1;
            iArr2[228] = -1;
            iArr2[229] = -1;
            iArr2[230] = -1;
            iArr2[231] = -1;
            iArr2[232] = -1;
            iArr2[233] = -1;
            iArr2[234] = -1;
            iArr2[235] = -1;
            iArr2[236] = -1;
            iArr2[237] = -1;
            iArr2[238] = -1;
            iArr2[239] = -1;
            iArr2[240] = -1;
            iArr2[241] = -1;
            iArr2[242] = -1;
            iArr2[243] = -1;
            iArr2[244] = -1;
            iArr2[245] = -1;
            iArr2[246] = -1;
            iArr2[247] = -1;
            iArr2[248] = -1;
            iArr2[249] = -1;
            iArr2[250] = -1;
            iArr2[251] = -1;
            iArr2[252] = -1;
            iArr2[253] = -1;
            iArr2[254] = -1;
            iArr2[255] = -1;
            f46453g = iArr2;
        }

        public C0781b(byte[] bArr) {
            this.f46446a = bArr;
        }
    }

    public static String b(byte[] bArr) {
        try {
            int length = bArr.length;
            c cVar = new c();
            int i2 = (length / 3) * 4;
            int i3 = 2;
            if (!cVar.f46460d) {
                int i4 = length % 3;
                if (i4 != 0) {
                    if (i4 == 1) {
                        i2 += 2;
                    } else if (i4 == 2) {
                        i2 += 3;
                    }
                }
            } else if (length % 3 > 0) {
                i2 += 4;
            }
            if (cVar.f46461e && length > 0) {
                int i5 = ((length - 1) / 57) + 1;
                if (!cVar.f46462f) {
                    i3 = 1;
                }
                i2 += i5 * i3;
            }
            cVar.f46446a = new byte[i2];
            cVar.a(bArr, length);
            return new String(cVar.f46446a, "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    static class c extends a {

        /* renamed from: g  reason: collision with root package name */
        private static final byte[] f46457g = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 43, 47};

        /* renamed from: h  reason: collision with root package name */
        private static final byte[] f46458h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 45, 95};

        /* renamed from: c  reason: collision with root package name */
        int f46459c = 0;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f46460d = true;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f46461e = false;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f46462f = false;

        /* renamed from: i  reason: collision with root package name */
        private final byte[] f46463i = new byte[2];
        private int j;
        private final byte[] k = f46457g;

        public c() {
            this.f46446a = null;
            this.j = this.f46461e ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0131  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x00e0 A[SYNTHETIC] */
        public final boolean a(byte[] r18, int r19) {
            /*
                r17 = this;
                r0 = r17
                byte[] r1 = r0.k
                byte[] r2 = r0.f46446a
                int r3 = r0.j
                r4 = 0
                int r5 = r19 + 0
                int r6 = r0.f46459c
                r7 = -1
                r8 = 2
                r9 = 1
                if (r6 == 0) goto L_0x004b
                if (r6 == r9) goto L_0x0031
                if (r6 == r8) goto L_0x0017
                goto L_0x004b
            L_0x0017:
                if (r5 <= 0) goto L_0x004b
                byte[] r6 = r0.f46463i
                byte r10 = r6[r4]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 16
                byte r6 = r6[r9]
                r6 = r6 & 255(0xff, float:3.57E-43)
                int r6 = r6 << 8
                r6 = r6 | r10
                byte r10 = r18[r4]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r6 = r6 | r10
                r0.f46459c = r4
                r10 = 1
                goto L_0x004d
            L_0x0031:
                if (r8 > r5) goto L_0x004b
                byte[] r6 = r0.f46463i
                byte r6 = r6[r4]
                r6 = r6 & 255(0xff, float:3.57E-43)
                int r6 = r6 << 16
                byte r10 = r18[r4]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r6 = r6 | r10
                byte r10 = r18[r9]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r6 = r6 | r10
                r0.f46459c = r4
                r10 = 2
                goto L_0x004d
            L_0x004b:
                r6 = -1
                r10 = 0
            L_0x004d:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r6 == r7) goto L_0x0089
                int r7 = r6 >> 18
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r4] = r7
                int r7 = r6 >> 12
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r9] = r7
                int r7 = r6 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r8] = r7
                r6 = r6 & 63
                byte r6 = r1[r6]
                r7 = 3
                r2[r7] = r6
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x0087
                boolean r3 = r0.f46462f
                if (r3 == 0) goto L_0x007f
                r3 = 5
                r2[r12] = r13
                goto L_0x0080
            L_0x007f:
                r3 = 4
            L_0x0080:
                int r6 = r3 + 1
                r2[r3] = r14
            L_0x0084:
                r3 = 19
                goto L_0x008a
            L_0x0087:
                r6 = 4
                goto L_0x008a
            L_0x0089:
                r6 = 0
            L_0x008a:
                int r7 = r10 + 3
                if (r7 > r5) goto L_0x00e0
                byte r15 = r18[r10]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r10 + 1
                byte r11 = r18[r16]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r11 = r11 | r15
                int r10 = r10 + 2
                byte r10 = r18[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                int r11 = r10 >> 18
                r11 = r11 & 63
                byte r11 = r1[r11]
                r2[r6] = r11
                int r11 = r6 + 1
                int r15 = r10 >> 12
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 2
                int r15 = r10 >> 6
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 3
                r10 = r10 & 63
                byte r10 = r1[r10]
                r2[r11] = r10
                int r6 = r6 + 4
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x00de
                boolean r3 = r0.f46462f
                if (r3 == 0) goto L_0x00d7
                int r3 = r6 + 1
                r2[r6] = r13
                goto L_0x00d8
            L_0x00d7:
                r3 = r6
            L_0x00d8:
                int r6 = r3 + 1
                r2[r3] = r14
                r10 = r7
                goto L_0x0084
            L_0x00de:
                r10 = r7
                goto L_0x008a
            L_0x00e0:
                int r7 = r0.f46459c
                int r11 = r10 - r7
                int r15 = r5 + -1
                if (r11 != r15) goto L_0x0131
                if (r7 <= 0) goto L_0x00f0
                byte[] r5 = r0.f46463i
                byte r4 = r5[r4]
                r5 = 1
                goto L_0x00f4
            L_0x00f0:
                byte r5 = r18[r10]
                r4 = r5
                r5 = 0
            L_0x00f4:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r12
                int r7 = r0.f46459c
                int r7 = r7 - r5
                r0.f46459c = r7
                int r5 = r6 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r5] = r1
                boolean r1 = r0.f46460d
                if (r1 == 0) goto L_0x011c
                int r1 = r6 + 1
                r4 = 61
                r2[r6] = r4
                int r6 = r1 + 1
                r2[r1] = r4
            L_0x011c:
                boolean r1 = r0.f46461e
                if (r1 == 0) goto L_0x01b3
                boolean r1 = r0.f46462f
                if (r1 == 0) goto L_0x0129
                int r1 = r6 + 1
                r2[r6] = r13
                goto L_0x012a
            L_0x0129:
                r1 = r6
            L_0x012a:
                int r4 = r1 + 1
                r2[r1] = r14
            L_0x012e:
                r6 = r4
                goto L_0x01b3
            L_0x0131:
                int r11 = r10 - r7
                int r5 = r5 - r8
                if (r11 != r5) goto L_0x019b
                if (r7 <= r9) goto L_0x013f
                byte[] r5 = r0.f46463i
                byte r4 = r5[r4]
                r5 = r10
                r7 = 1
                goto L_0x0145
            L_0x013f:
                int r5 = r10 + 1
                byte r7 = r18[r10]
                r4 = r7
                r7 = 0
            L_0x0145:
                r4 = r4 & 255(0xff, float:3.57E-43)
                int r4 = r4 << r14
                int r10 = r0.f46459c
                if (r10 <= 0) goto L_0x0154
                byte[] r5 = r0.f46463i
                int r10 = r7 + 1
                byte r5 = r5[r7]
                r7 = r10
                goto L_0x0156
            L_0x0154:
                byte r5 = r18[r5]
            L_0x0156:
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << r8
                r4 = r4 | r5
                int r5 = r0.f46459c
                int r5 = r5 - r7
                r0.f46459c = r5
                int r5 = r6 + 1
                int r7 = r4 >> 12
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r6] = r7
                int r6 = r5 + 1
                int r7 = r4 >> 6
                r7 = r7 & 63
                byte r7 = r1[r7]
                r2[r5] = r7
                int r5 = r6 + 1
                r4 = r4 & 63
                byte r1 = r1[r4]
                r2[r6] = r1
                boolean r1 = r0.f46460d
                if (r1 == 0) goto L_0x0186
                int r1 = r5 + 1
                r4 = 61
                r2[r5] = r4
                goto L_0x0187
            L_0x0186:
                r1 = r5
            L_0x0187:
                boolean r4 = r0.f46461e
                if (r4 == 0) goto L_0x0199
                boolean r4 = r0.f46462f
                if (r4 == 0) goto L_0x0194
                int r4 = r1 + 1
                r2[r1] = r13
                r1 = r4
            L_0x0194:
                int r4 = r1 + 1
                r2[r1] = r14
                goto L_0x012e
            L_0x0199:
                r6 = r1
                goto L_0x01b3
            L_0x019b:
                boolean r1 = r0.f46461e
                if (r1 == 0) goto L_0x01b3
                if (r6 <= 0) goto L_0x01b3
                r1 = 19
                if (r3 == r1) goto L_0x01b3
                boolean r1 = r0.f46462f
                if (r1 == 0) goto L_0x01ae
                int r1 = r6 + 1
                r2[r6] = r13
                goto L_0x01af
            L_0x01ae:
                r1 = r6
            L_0x01af:
                int r6 = r1 + 1
                r2[r1] = r14
            L_0x01b3:
                r0.f46447b = r6
                r0.j = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.b.c.a(byte[], int):boolean");
        }
    }
}
