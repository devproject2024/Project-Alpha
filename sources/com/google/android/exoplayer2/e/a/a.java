package com.google.android.exoplayer2.e.a;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.j;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.nativesdk.instruments.upicollect.view.UpiCollectViewNew;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f31395b = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f31396c = {0, 4, 8, 12, 16, 20, 24, 28};
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f31397d = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f31398e = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, Constants.EASY_PAY_GENERIC_CALLBACK, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, UpiPushView.REQUEST_CODE_UPI_CHECK_BALANCE, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f31399f = {174, 176, 189, 191, 8482, 162, 163, 9834, Constants.EASY_PAY_INVISIBLE_ASSIST, 32, 232, 226, 234, 238, 244, 251};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f31400g = {193, 201, 211, 218, 220, 252, 8216, Constants.ACTION_NB_WV_LOGIN_CLICKED, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, UpiCollectViewNew.REQUEST_CODE_UPI_APP};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f31401h = {195, 227, 205, CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, Constants.EASY_PAY_VISIBLE_ASSIST, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};

    /* renamed from: i  reason: collision with root package name */
    private static final boolean[] f31402i;
    private final r j = new r();
    private final int k;
    private final int l;
    private final int m;
    private final ArrayList<C0533a> n = new ArrayList<>();
    private C0533a o = new C0533a(0, 4);
    private List<b> p;
    private List<b> q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private byte v;
    private byte w;
    private int x = 0;
    private boolean y;

    private static boolean b(byte b2) {
        return (b2 & 224) == 0;
    }

    public final void d() {
    }

    public final /* bridge */ /* synthetic */ void a(long j2) {
        super.a(j2);
    }

    public final /* bridge */ /* synthetic */ void b(i iVar) throws g {
        super.a(iVar);
    }

    public final /* bridge */ /* synthetic */ j g() throws g {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ i h() throws g {
        return super.a();
    }

    static {
        boolean[] zArr = new boolean[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];
        // fill-array-data instruction
        zArr[0] = 0;
        zArr[1] = 1;
        zArr[2] = 1;
        zArr[3] = 0;
        zArr[4] = 1;
        zArr[5] = 0;
        zArr[6] = 0;
        zArr[7] = 1;
        zArr[8] = 1;
        zArr[9] = 0;
        zArr[10] = 0;
        zArr[11] = 1;
        zArr[12] = 0;
        zArr[13] = 1;
        zArr[14] = 1;
        zArr[15] = 0;
        zArr[16] = 1;
        zArr[17] = 0;
        zArr[18] = 0;
        zArr[19] = 1;
        zArr[20] = 0;
        zArr[21] = 1;
        zArr[22] = 1;
        zArr[23] = 0;
        zArr[24] = 0;
        zArr[25] = 1;
        zArr[26] = 1;
        zArr[27] = 0;
        zArr[28] = 1;
        zArr[29] = 0;
        zArr[30] = 0;
        zArr[31] = 1;
        zArr[32] = 1;
        zArr[33] = 0;
        zArr[34] = 0;
        zArr[35] = 1;
        zArr[36] = 0;
        zArr[37] = 1;
        zArr[38] = 1;
        zArr[39] = 0;
        zArr[40] = 0;
        zArr[41] = 1;
        zArr[42] = 1;
        zArr[43] = 0;
        zArr[44] = 1;
        zArr[45] = 0;
        zArr[46] = 0;
        zArr[47] = 1;
        zArr[48] = 0;
        zArr[49] = 1;
        zArr[50] = 1;
        zArr[51] = 0;
        zArr[52] = 1;
        zArr[53] = 0;
        zArr[54] = 0;
        zArr[55] = 1;
        zArr[56] = 1;
        zArr[57] = 0;
        zArr[58] = 0;
        zArr[59] = 1;
        zArr[60] = 0;
        zArr[61] = 1;
        zArr[62] = 1;
        zArr[63] = 0;
        zArr[64] = 1;
        zArr[65] = 0;
        zArr[66] = 0;
        zArr[67] = 1;
        zArr[68] = 0;
        zArr[69] = 1;
        zArr[70] = 1;
        zArr[71] = 0;
        zArr[72] = 0;
        zArr[73] = 1;
        zArr[74] = 1;
        zArr[75] = 0;
        zArr[76] = 1;
        zArr[77] = 0;
        zArr[78] = 0;
        zArr[79] = 1;
        zArr[80] = 0;
        zArr[81] = 1;
        zArr[82] = 1;
        zArr[83] = 0;
        zArr[84] = 1;
        zArr[85] = 0;
        zArr[86] = 0;
        zArr[87] = 1;
        zArr[88] = 1;
        zArr[89] = 0;
        zArr[90] = 0;
        zArr[91] = 1;
        zArr[92] = 0;
        zArr[93] = 1;
        zArr[94] = 1;
        zArr[95] = 0;
        zArr[96] = 0;
        zArr[97] = 1;
        zArr[98] = 1;
        zArr[99] = 0;
        zArr[100] = 1;
        zArr[101] = 0;
        zArr[102] = 0;
        zArr[103] = 1;
        zArr[104] = 1;
        zArr[105] = 0;
        zArr[106] = 0;
        zArr[107] = 1;
        zArr[108] = 0;
        zArr[109] = 1;
        zArr[110] = 1;
        zArr[111] = 0;
        zArr[112] = 1;
        zArr[113] = 0;
        zArr[114] = 0;
        zArr[115] = 1;
        zArr[116] = 0;
        zArr[117] = 1;
        zArr[118] = 1;
        zArr[119] = 0;
        zArr[120] = 0;
        zArr[121] = 1;
        zArr[122] = 1;
        zArr[123] = 0;
        zArr[124] = 1;
        zArr[125] = 0;
        zArr[126] = 0;
        zArr[127] = 1;
        zArr[128] = 1;
        zArr[129] = 0;
        zArr[130] = 0;
        zArr[131] = 1;
        zArr[132] = 0;
        zArr[133] = 1;
        zArr[134] = 1;
        zArr[135] = 0;
        zArr[136] = 0;
        zArr[137] = 1;
        zArr[138] = 1;
        zArr[139] = 0;
        zArr[140] = 1;
        zArr[141] = 0;
        zArr[142] = 0;
        zArr[143] = 1;
        zArr[144] = 0;
        zArr[145] = 1;
        zArr[146] = 1;
        zArr[147] = 0;
        zArr[148] = 1;
        zArr[149] = 0;
        zArr[150] = 0;
        zArr[151] = 1;
        zArr[152] = 1;
        zArr[153] = 0;
        zArr[154] = 0;
        zArr[155] = 1;
        zArr[156] = 0;
        zArr[157] = 1;
        zArr[158] = 1;
        zArr[159] = 0;
        zArr[160] = 0;
        zArr[161] = 1;
        zArr[162] = 1;
        zArr[163] = 0;
        zArr[164] = 1;
        zArr[165] = 0;
        zArr[166] = 0;
        zArr[167] = 1;
        zArr[168] = 1;
        zArr[169] = 0;
        zArr[170] = 0;
        zArr[171] = 1;
        zArr[172] = 0;
        zArr[173] = 1;
        zArr[174] = 1;
        zArr[175] = 0;
        zArr[176] = 1;
        zArr[177] = 0;
        zArr[178] = 0;
        zArr[179] = 1;
        zArr[180] = 0;
        zArr[181] = 1;
        zArr[182] = 1;
        zArr[183] = 0;
        zArr[184] = 0;
        zArr[185] = 1;
        zArr[186] = 1;
        zArr[187] = 0;
        zArr[188] = 1;
        zArr[189] = 0;
        zArr[190] = 0;
        zArr[191] = 1;
        zArr[192] = 0;
        zArr[193] = 1;
        zArr[194] = 1;
        zArr[195] = 0;
        zArr[196] = 1;
        zArr[197] = 0;
        zArr[198] = 0;
        zArr[199] = 1;
        zArr[200] = 1;
        zArr[201] = 0;
        zArr[202] = 0;
        zArr[203] = 1;
        zArr[204] = 0;
        zArr[205] = 1;
        zArr[206] = 1;
        zArr[207] = 0;
        zArr[208] = 1;
        zArr[209] = 0;
        zArr[210] = 0;
        zArr[211] = 1;
        zArr[212] = 0;
        zArr[213] = 1;
        zArr[214] = 1;
        zArr[215] = 0;
        zArr[216] = 0;
        zArr[217] = 1;
        zArr[218] = 1;
        zArr[219] = 0;
        zArr[220] = 1;
        zArr[221] = 0;
        zArr[222] = 0;
        zArr[223] = 1;
        zArr[224] = 1;
        zArr[225] = 0;
        zArr[226] = 0;
        zArr[227] = 1;
        zArr[228] = 0;
        zArr[229] = 1;
        zArr[230] = 1;
        zArr[231] = 0;
        zArr[232] = 0;
        zArr[233] = 1;
        zArr[234] = 1;
        zArr[235] = 0;
        zArr[236] = 1;
        zArr[237] = 0;
        zArr[238] = 0;
        zArr[239] = 1;
        zArr[240] = 0;
        zArr[241] = 1;
        zArr[242] = 1;
        zArr[243] = 0;
        zArr[244] = 1;
        zArr[245] = 0;
        zArr[246] = 0;
        zArr[247] = 1;
        zArr[248] = 1;
        zArr[249] = 0;
        zArr[250] = 0;
        zArr[251] = 1;
        zArr[252] = 0;
        zArr[253] = 1;
        zArr[254] = 1;
        zArr[255] = 0;
        f31402i = zArr;
    }

    public a(String str, int i2) {
        this.k = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 == 1) {
            this.m = 0;
            this.l = 0;
        } else if (i2 == 2) {
            this.m = 1;
            this.l = 0;
        } else if (i2 == 3) {
            this.m = 0;
            this.l = 1;
        } else if (i2 != 4) {
            l.c();
            this.m = 0;
            this.l = 0;
        } else {
            this.m = 1;
            this.l = 1;
        }
        a(0);
        k();
        this.y = true;
    }

    public final void c() {
        super.c();
        this.p = null;
        this.q = null;
        a(0);
        b(4);
        k();
        this.t = false;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = true;
    }

    /* access modifiers changed from: protected */
    public final boolean e() {
        return this.p != this.q;
    }

    /* access modifiers changed from: protected */
    public final e f() {
        List<b> list = this.p;
        this.q = list;
        return new e(list);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0014 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.exoplayer2.e.i r14) {
        /*
            r13 = this;
            com.google.android.exoplayer2.g.r r0 = r13.j
            java.nio.ByteBuffer r1 = r14.f31311c
            byte[] r1 = r1.array()
            java.nio.ByteBuffer r14 = r14.f31311c
            int r14 = r14.limit()
            r0.a((byte[]) r1, (int) r14)
            r14 = 0
            r0 = 1
            r1 = 0
        L_0x0014:
            com.google.android.exoplayer2.g.r r2 = r13.j
            int r2 = r2.b()
            int r3 = r13.k
            r4 = 3
            if (r2 < r3) goto L_0x0294
            r2 = 2
            if (r3 != r2) goto L_0x0024
            r3 = -4
            goto L_0x002b
        L_0x0024:
            com.google.android.exoplayer2.g.r r3 = r13.j
            int r3 = r3.c()
            byte r3 = (byte) r3
        L_0x002b:
            com.google.android.exoplayer2.g.r r5 = r13.j
            int r5 = r5.c()
            com.google.android.exoplayer2.g.r r6 = r13.j
            int r6 = r6.c()
            r7 = r3 & 2
            if (r7 != 0) goto L_0x0014
            r7 = r3 & 1
            int r8 = r13.l
            if (r7 != r8) goto L_0x0014
            r7 = r5 & 127(0x7f, float:1.78E-43)
            byte r7 = (byte) r7
            r8 = r6 & 127(0x7f, float:1.78E-43)
            byte r8 = (byte) r8
            if (r7 != 0) goto L_0x004b
            if (r8 == 0) goto L_0x0014
        L_0x004b:
            boolean r9 = r13.t
            r3 = r3 & 4
            r10 = 4
            if (r3 != r10) goto L_0x005e
            boolean[] r3 = f31402i
            boolean r5 = r3[r5]
            if (r5 == 0) goto L_0x005e
            boolean r3 = r3[r6]
            if (r3 == 0) goto L_0x005e
            r3 = 1
            goto L_0x005f
        L_0x005e:
            r3 = 0
        L_0x005f:
            r13.t = r3
            boolean r3 = r13.t
            r5 = 16
            if (r3 == 0) goto L_0x0087
            r3 = r7 & 240(0xf0, float:3.36E-43)
            if (r3 != r5) goto L_0x006d
            r3 = 1
            goto L_0x006e
        L_0x006d:
            r3 = 0
        L_0x006e:
            if (r3 == 0) goto L_0x0087
            boolean r3 = r13.u
            if (r3 == 0) goto L_0x0080
            byte r3 = r13.v
            if (r3 != r7) goto L_0x0080
            byte r3 = r13.w
            if (r3 != r8) goto L_0x0080
            r13.u = r14
            r3 = 1
            goto L_0x008a
        L_0x0080:
            r13.u = r0
            r13.v = r7
            r13.w = r8
            goto L_0x0089
        L_0x0087:
            r13.u = r14
        L_0x0089:
            r3 = 0
        L_0x008a:
            if (r3 != 0) goto L_0x0014
            boolean r3 = r13.t
            if (r3 != 0) goto L_0x0098
            if (r9 == 0) goto L_0x0014
            r13.k()
        L_0x0095:
            r1 = 1
            goto L_0x0014
        L_0x0098:
            if (r7 <= 0) goto L_0x00a0
            r3 = 15
            if (r7 > r3) goto L_0x00a0
            r3 = 1
            goto L_0x00a1
        L_0x00a0:
            r3 = 0
        L_0x00a1:
            r6 = 20
            r9 = 32
            if (r3 == 0) goto L_0x00aa
            r13.y = r14
            goto L_0x00c5
        L_0x00aa:
            r3 = r7 & 247(0xf7, float:3.46E-43)
            if (r3 != r6) goto L_0x00b0
            r3 = 1
            goto L_0x00b1
        L_0x00b0:
            r3 = 0
        L_0x00b1:
            if (r3 == 0) goto L_0x00c5
            if (r8 == r9) goto L_0x00c3
            r3 = 47
            if (r8 == r3) goto L_0x00c3
            switch(r8) {
                case 37: goto L_0x00c3;
                case 38: goto L_0x00c3;
                case 39: goto L_0x00c3;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            switch(r8) {
                case 41: goto L_0x00c3;
                case 42: goto L_0x00c0;
                case 43: goto L_0x00c0;
                default: goto L_0x00bf;
            }
        L_0x00bf:
            goto L_0x00c5
        L_0x00c0:
            r13.y = r14
            goto L_0x00c5
        L_0x00c3:
            r13.y = r0
        L_0x00c5:
            boolean r3 = r13.y
            if (r3 == 0) goto L_0x0014
            boolean r3 = b((byte) r7)
            if (r3 == 0) goto L_0x00d4
            int r3 = r7 >> 3
            r3 = r3 & r0
            r13.x = r3
        L_0x00d4:
            int r3 = r13.x
            int r11 = r13.m
            if (r3 != r11) goto L_0x00dc
            r3 = 1
            goto L_0x00dd
        L_0x00dc:
            r3 = 0
        L_0x00dd:
            if (r3 == 0) goto L_0x0014
            boolean r1 = b((byte) r7)
            if (r1 == 0) goto L_0x027c
            r1 = r7 & 247(0xf7, float:3.46E-43)
            r3 = 17
            if (r1 != r3) goto L_0x00f3
            r11 = r8 & 240(0xf0, float:3.36E-43)
            r12 = 48
            if (r11 != r12) goto L_0x00f3
            r11 = 1
            goto L_0x00f4
        L_0x00f3:
            r11 = 0
        L_0x00f4:
            if (r11 == 0) goto L_0x0103
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            r2 = r8 & 15
            int[] r3 = f31399f
            r2 = r3[r2]
            char r2 = (char) r2
            r1.a((char) r2)
            goto L_0x0095
        L_0x0103:
            r11 = r7 & 246(0xf6, float:3.45E-43)
            r12 = 18
            if (r11 != r12) goto L_0x010f
            r12 = r8 & 224(0xe0, float:3.14E-43)
            if (r12 != r9) goto L_0x010f
            r12 = 1
            goto L_0x0110
        L_0x010f:
            r12 = 0
        L_0x0110:
            if (r12 == 0) goto L_0x0130
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            r1.b()
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            r2 = r7 & 1
            if (r2 != 0) goto L_0x0124
            r2 = r8 & 31
            int[] r3 = f31400g
            r2 = r3[r2]
            goto L_0x012a
        L_0x0124:
            r2 = r8 & 31
            int[] r3 = f31401h
            r2 = r3[r2]
        L_0x012a:
            char r2 = (char) r2
            r1.a((char) r2)
            goto L_0x0095
        L_0x0130:
            if (r1 != r3) goto L_0x0138
            r3 = r8 & 240(0xf0, float:3.36E-43)
            if (r3 != r9) goto L_0x0138
            r3 = 1
            goto L_0x0139
        L_0x0138:
            r3 = 0
        L_0x0139:
            if (r3 == 0) goto L_0x0152
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            r1.a((char) r9)
            r1 = r8 & 1
            if (r1 != r0) goto L_0x0146
            r1 = 1
            goto L_0x0147
        L_0x0146:
            r1 = 0
        L_0x0147:
            int r2 = r8 >> 1
            r2 = r2 & 7
            com.google.android.exoplayer2.e.a.a$a r3 = r13.o
            r3.a(r2, r1)
            goto L_0x0095
        L_0x0152:
            r3 = r7 & 240(0xf0, float:3.36E-43)
            if (r3 != r5) goto L_0x015e
            r3 = r8 & 192(0xc0, float:2.69E-43)
            r12 = 64
            if (r3 != r12) goto L_0x015e
            r3 = 1
            goto L_0x015f
        L_0x015e:
            r3 = 0
        L_0x015f:
            if (r3 == 0) goto L_0x01c3
            int[] r1 = f31395b
            r2 = r7 & 7
            r1 = r1[r2]
            r2 = r8 & 32
            if (r2 == 0) goto L_0x016d
            r2 = 1
            goto L_0x016e
        L_0x016d:
            r2 = 0
        L_0x016e:
            if (r2 == 0) goto L_0x0172
            int r1 = r1 + 1
        L_0x0172:
            com.google.android.exoplayer2.e.a.a$a r2 = r13.o
            int r2 = r2.f31406d
            if (r1 == r2) goto L_0x019a
            int r2 = r13.r
            if (r2 == r0) goto L_0x0196
            com.google.android.exoplayer2.e.a.a$a r2 = r13.o
            boolean r2 = r2.a()
            if (r2 != 0) goto L_0x0196
            com.google.android.exoplayer2.e.a.a$a r2 = new com.google.android.exoplayer2.e.a.a$a
            int r3 = r13.r
            int r4 = r13.s
            r2.<init>(r3, r4)
            r13.o = r2
            java.util.ArrayList<com.google.android.exoplayer2.e.a.a$a> r2 = r13.n
            com.google.android.exoplayer2.e.a.a$a r3 = r13.o
            r2.add(r3)
        L_0x0196:
            com.google.android.exoplayer2.e.a.a$a r2 = r13.o
            r2.f31406d = r1
        L_0x019a:
            r1 = r8 & 16
            if (r1 != r5) goto L_0x01a0
            r1 = 1
            goto L_0x01a1
        L_0x01a0:
            r1 = 0
        L_0x01a1:
            r2 = r8 & 1
            if (r2 != r0) goto L_0x01a7
            r2 = 1
            goto L_0x01a8
        L_0x01a7:
            r2 = 0
        L_0x01a8:
            int r3 = r8 >> 1
            r3 = r3 & 7
            com.google.android.exoplayer2.e.a.a$a r4 = r13.o
            if (r1 == 0) goto L_0x01b3
            r5 = 8
            goto L_0x01b4
        L_0x01b3:
            r5 = r3
        L_0x01b4:
            r4.a(r5, r2)
            if (r1 == 0) goto L_0x0095
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            int[] r2 = f31396c
            r2 = r2[r3]
            r1.f31407e = r2
            goto L_0x0095
        L_0x01c3:
            r3 = 23
            if (r1 != r3) goto L_0x01d1
            r1 = 33
            if (r8 < r1) goto L_0x01d1
            r1 = 35
            if (r8 > r1) goto L_0x01d1
            r1 = 1
            goto L_0x01d2
        L_0x01d1:
            r1 = 0
        L_0x01d2:
            if (r1 == 0) goto L_0x01dc
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            int r8 = r8 + -32
            r1.f31408f = r8
            goto L_0x0095
        L_0x01dc:
            if (r11 != r6) goto L_0x01e4
            r1 = r8 & 240(0xf0, float:3.36E-43)
            if (r1 != r9) goto L_0x01e4
            r1 = 1
            goto L_0x01e5
        L_0x01e4:
            r1 = 0
        L_0x01e5:
            if (r1 == 0) goto L_0x0095
            if (r8 == r9) goto L_0x0277
            r1 = 41
            if (r8 == r1) goto L_0x0272
            switch(r8) {
                case 37: goto L_0x026a;
                case 38: goto L_0x0262;
                case 39: goto L_0x025a;
                default: goto L_0x01f0;
            }
        L_0x01f0:
            int r1 = r13.r
            if (r1 == 0) goto L_0x0095
            r2 = 33
            if (r8 == r2) goto L_0x0253
            switch(r8) {
                case 44: goto L_0x0242;
                case 45: goto L_0x020d;
                case 46: goto L_0x0208;
                case 47: goto L_0x01fd;
                default: goto L_0x01fb;
            }
        L_0x01fb:
            goto L_0x0095
        L_0x01fd:
            java.util.List r1 = r13.j()
            r13.p = r1
            r13.k()
            goto L_0x0095
        L_0x0208:
            r13.k()
            goto L_0x0095
        L_0x020d:
            if (r1 != r0) goto L_0x0095
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x0095
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            java.util.List<android.text.SpannableString> r2 = r1.f31404b
            android.text.SpannableString r3 = r1.c()
            r2.add(r3)
            java.lang.StringBuilder r2 = r1.f31405c
            r2.setLength(r14)
            java.util.List<com.google.android.exoplayer2.e.a.a$a$a> r2 = r1.f31403a
            r2.clear()
            int r2 = r1.f31410h
            int r3 = r1.f31406d
            int r2 = java.lang.Math.min(r2, r3)
        L_0x0234:
            java.util.List<android.text.SpannableString> r3 = r1.f31404b
            int r3 = r3.size()
            if (r3 < r2) goto L_0x0095
            java.util.List<android.text.SpannableString> r3 = r1.f31404b
            r3.remove(r14)
            goto L_0x0234
        L_0x0242:
            java.util.List r1 = java.util.Collections.emptyList()
            r13.p = r1
            int r1 = r13.r
            if (r1 == r0) goto L_0x024e
            if (r1 != r4) goto L_0x0095
        L_0x024e:
            r13.k()
            goto L_0x0095
        L_0x0253:
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            r1.b()
            goto L_0x0095
        L_0x025a:
            r13.a((int) r0)
            r13.b((int) r10)
            goto L_0x0095
        L_0x0262:
            r13.a((int) r0)
            r13.b((int) r4)
            goto L_0x0095
        L_0x026a:
            r13.a((int) r0)
            r13.b((int) r2)
            goto L_0x0095
        L_0x0272:
            r13.a((int) r4)
            goto L_0x0095
        L_0x0277:
            r13.a((int) r2)
            goto L_0x0095
        L_0x027c:
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            char r2 = a((byte) r7)
            r1.a((char) r2)
            r1 = r8 & 224(0xe0, float:3.14E-43)
            if (r1 == 0) goto L_0x0095
            com.google.android.exoplayer2.e.a.a$a r1 = r13.o
            char r2 = a((byte) r8)
            r1.a((char) r2)
            goto L_0x0095
        L_0x0294:
            if (r1 == 0) goto L_0x02a2
            int r14 = r13.r
            if (r14 == r0) goto L_0x029c
            if (r14 != r4) goto L_0x02a2
        L_0x029c:
            java.util.List r14 = r13.j()
            r13.p = r14
        L_0x02a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.a.a.a(com.google.android.exoplayer2.e.i):void");
    }

    private List<b> j() {
        int size = this.n.size();
        ArrayList arrayList = new ArrayList(size);
        int i2 = 2;
        for (int i3 = 0; i3 < size; i3++) {
            b b2 = this.n.get(i3).b(Integer.MIN_VALUE);
            arrayList.add(b2);
            if (b2 != null) {
                i2 = Math.min(i2, b2.f31453i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = (b) arrayList.get(i4);
            if (bVar != null) {
                if (bVar.f31453i != i2) {
                    bVar = this.n.get(i4).b(i2);
                }
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    private void a(int i2) {
        int i3 = this.r;
        if (i3 != i2) {
            this.r = i2;
            if (i2 == 3) {
                for (int i4 = 0; i4 < this.n.size(); i4++) {
                    this.n.get(i4).f31409g = i2;
                }
                return;
            }
            k();
            if (i3 == 3 || i2 == 1 || i2 == 0) {
                this.p = Collections.emptyList();
            }
        }
    }

    private void b(int i2) {
        this.s = i2;
        this.o.f31410h = i2;
    }

    private void k() {
        this.o.a(this.r);
        this.n.clear();
        this.n.add(this.o);
    }

    private static char a(byte b2) {
        return (char) f31398e[(b2 & Byte.MAX_VALUE) - 32];
    }

    /* renamed from: com.google.android.exoplayer2.e.a.a$a  reason: collision with other inner class name */
    static class C0533a {

        /* renamed from: a  reason: collision with root package name */
        final List<C0534a> f31403a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final List<SpannableString> f31404b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        final StringBuilder f31405c = new StringBuilder();

        /* renamed from: d  reason: collision with root package name */
        int f31406d;

        /* renamed from: e  reason: collision with root package name */
        int f31407e;

        /* renamed from: f  reason: collision with root package name */
        int f31408f;

        /* renamed from: g  reason: collision with root package name */
        int f31409g;

        /* renamed from: h  reason: collision with root package name */
        int f31410h;

        public C0533a(int i2, int i3) {
            a(i2);
            this.f31410h = i3;
        }

        public final void a(int i2) {
            this.f31409g = i2;
            this.f31403a.clear();
            this.f31404b.clear();
            this.f31405c.setLength(0);
            this.f31406d = 15;
            this.f31407e = 0;
            this.f31408f = 0;
        }

        public final boolean a() {
            return this.f31403a.isEmpty() && this.f31404b.isEmpty() && this.f31405c.length() == 0;
        }

        public final void a(int i2, boolean z) {
            this.f31403a.add(new C0534a(i2, z, this.f31405c.length()));
        }

        public final void b() {
            int length = this.f31405c.length();
            if (length > 0) {
                this.f31405c.delete(length - 1, length);
                int size = this.f31403a.size() - 1;
                while (size >= 0) {
                    C0534a aVar = this.f31403a.get(size);
                    if (aVar.f31413c == length) {
                        aVar.f31413c--;
                        size--;
                    } else {
                        return;
                    }
                }
            }
        }

        public final void a(char c2) {
            this.f31405c.append(c2);
        }

        public final b b(int i2) {
            float f2;
            int i3;
            int i4;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < this.f31404b.size(); i5++) {
                spannableStringBuilder.append(this.f31404b.get(i5));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(c());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i6 = this.f31407e + this.f31408f;
            int length = (32 - i6) - spannableStringBuilder.length();
            int i7 = i6 - length;
            if (i2 == Integer.MIN_VALUE) {
                if (this.f31409g != 2 || (Math.abs(i7) >= 3 && length >= 0)) {
                    i2 = (this.f31409g != 2 || i7 <= 0) ? 0 : 2;
                } else {
                    i2 = 1;
                }
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    i6 = 32 - length;
                }
                f2 = ((((float) i6) / 32.0f) * 0.8f) + 0.1f;
            } else {
                f2 = 0.5f;
            }
            if (this.f31409g == 1 || (i4 = this.f31406d) > 7) {
                i4 = (this.f31406d - 15) - 2;
                i3 = 2;
            } else {
                i3 = 0;
            }
            return new b((CharSequence) spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, (float) i4, 1, i3, f2, i2, Float.MIN_VALUE);
        }

        /* access modifiers changed from: package-private */
        public final SpannableString c() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f31405c);
            int length = spannableStringBuilder.length();
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            boolean z = false;
            while (i2 < this.f31403a.size()) {
                C0534a aVar = this.f31403a.get(i2);
                boolean z2 = aVar.f31412b;
                int i8 = aVar.f31411a;
                if (i8 != 8) {
                    boolean z3 = i8 == 7;
                    if (i8 != 7) {
                        i7 = a.f31397d[i8];
                    }
                    z = z3;
                }
                int i9 = aVar.f31413c;
                i2++;
                if (i9 != (i2 < this.f31403a.size() ? this.f31403a.get(i2).f31413c : length)) {
                    if (i3 != -1 && !z2) {
                        a(spannableStringBuilder, i3, i9);
                        i3 = -1;
                    } else if (i3 == -1 && z2) {
                        i3 = i9;
                    }
                    if (i4 != -1 && !z) {
                        b(spannableStringBuilder, i4, i9);
                        i4 = -1;
                    } else if (i4 == -1 && z) {
                        i4 = i9;
                    }
                    if (i7 != i6) {
                        a(spannableStringBuilder, i5, i9, i6);
                        i6 = i7;
                        i5 = i9;
                    }
                }
            }
            if (!(i3 == -1 || i3 == length)) {
                a(spannableStringBuilder, i3, length);
            }
            if (!(i4 == -1 || i4 == length)) {
                b(spannableStringBuilder, i4, length);
            }
            if (i5 != length) {
                a(spannableStringBuilder, i5, length, i6);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }

        private static void b(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i2, i3, 33);
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4) {
            if (i4 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i2, i3, 33);
            }
        }

        /* renamed from: com.google.android.exoplayer2.e.a.a$a$a  reason: collision with other inner class name */
        static class C0534a {

            /* renamed from: a  reason: collision with root package name */
            public final int f31411a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f31412b;

            /* renamed from: c  reason: collision with root package name */
            public int f31413c;

            public C0534a(int i2, boolean z, int i3) {
                this.f31411a = i2;
                this.f31412b = z;
                this.f31413c = i3;
            }
        }
    }
}
