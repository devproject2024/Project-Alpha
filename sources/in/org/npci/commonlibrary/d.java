package in.org.npci.commonlibrary;

import com.alipay.mobile.nebula.util.tar.TarHeader;

class d extends b {

    /* renamed from: g  reason: collision with root package name */
    static final /* synthetic */ boolean f46339g = (!a.class.desiredAssertionStatus());

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f46340h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 43, 47};

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f46341i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 45, 95};

    /* renamed from: c  reason: collision with root package name */
    int f46342c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f46343d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f46344e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f46345f;
    private final byte[] j;
    private int k;
    private final byte[] l;

    public d(int i2, byte[] bArr) {
        this.f46332a = bArr;
        boolean z = true;
        this.f46343d = (i2 & 1) == 0;
        this.f46344e = (i2 & 2) == 0;
        this.f46345f = (i2 & 4) == 0 ? false : z;
        this.l = (i2 & 8) == 0 ? f46340h : f46341i;
        this.j = new byte[2];
        this.f46342c = 0;
        this.k = this.f46344e ? 19 : -1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x00e9 A[SYNTHETIC] */
    public boolean a(byte[] r18, int r19, int r20, boolean r21) {
        /*
            r17 = this;
            r0 = r17
            byte[] r1 = r0.l
            byte[] r2 = r0.f46332a
            int r3 = r0.k
            int r4 = r20 + r19
            int r5 = r0.f46342c
            r6 = -1
            r7 = 2
            r8 = 0
            r9 = 1
            if (r5 == 0) goto L_0x0053
            if (r5 == r9) goto L_0x0034
            if (r5 == r7) goto L_0x0017
            goto L_0x0053
        L_0x0017:
            int r5 = r19 + 1
            if (r5 > r4) goto L_0x0053
            byte[] r10 = r0.j
            byte r11 = r10[r8]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 16
            byte r10 = r10[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r10 = r10 | r11
            byte r11 = r18[r19]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r10 = r10 | r11
            r0.f46342c = r8
            r11 = r5
            r5 = r10
            goto L_0x0056
        L_0x0034:
            int r5 = r19 + 2
            if (r5 > r4) goto L_0x0053
            byte[] r5 = r0.j
            byte r5 = r5[r8]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 16
            int r10 = r19 + 1
            byte r11 = r18[r19]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r5 = r5 | r11
            int r11 = r10 + 1
            byte r10 = r18[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r5 = r5 | r10
            r0.f46342c = r8
            goto L_0x0056
        L_0x0053:
            r11 = r19
            r5 = -1
        L_0x0056:
            r12 = 4
            r13 = 13
            r14 = 10
            if (r5 == r6) goto L_0x0092
            int r6 = r5 >> 18
            r6 = r6 & 63
            byte r6 = r1[r6]
            r2[r8] = r6
            int r6 = r5 >> 12
            r6 = r6 & 63
            byte r6 = r1[r6]
            r2[r9] = r6
            int r6 = r5 >> 6
            r6 = r6 & 63
            byte r6 = r1[r6]
            r2[r7] = r6
            r5 = r5 & 63
            byte r5 = r1[r5]
            r6 = 3
            r2[r6] = r5
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x0090
            boolean r3 = r0.f46345f
            if (r3 == 0) goto L_0x0088
            r3 = 5
            r2[r12] = r13
            goto L_0x0089
        L_0x0088:
            r3 = 4
        L_0x0089:
            int r5 = r3 + 1
            r2[r3] = r14
        L_0x008d:
            r3 = 19
            goto L_0x0093
        L_0x0090:
            r5 = 4
            goto L_0x0093
        L_0x0092:
            r5 = 0
        L_0x0093:
            int r6 = r11 + 3
            if (r6 > r4) goto L_0x00e9
            byte r15 = r18[r11]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << 16
            int r16 = r11 + 1
            byte r10 = r18[r16]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r10 = r10 | r15
            int r11 = r11 + 2
            byte r11 = r18[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r10 = r10 | r11
            int r11 = r10 >> 18
            r11 = r11 & 63
            byte r11 = r1[r11]
            r2[r5] = r11
            int r11 = r5 + 1
            int r15 = r10 >> 12
            r15 = r15 & 63
            byte r15 = r1[r15]
            r2[r11] = r15
            int r11 = r5 + 2
            int r15 = r10 >> 6
            r15 = r15 & 63
            byte r15 = r1[r15]
            r2[r11] = r15
            int r11 = r5 + 3
            r10 = r10 & 63
            byte r10 = r1[r10]
            r2[r11] = r10
            int r5 = r5 + 4
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x00e7
            boolean r3 = r0.f46345f
            if (r3 == 0) goto L_0x00e0
            int r3 = r5 + 1
            r2[r5] = r13
            goto L_0x00e1
        L_0x00e0:
            r3 = r5
        L_0x00e1:
            int r5 = r3 + 1
            r2[r3] = r14
            r11 = r6
            goto L_0x008d
        L_0x00e7:
            r11 = r6
            goto L_0x0093
        L_0x00e9:
            if (r21 == 0) goto L_0x01e1
            int r6 = r0.f46342c
            int r10 = r11 - r6
            int r15 = r4 + -1
            if (r10 != r15) goto L_0x013d
            if (r6 <= 0) goto L_0x00fb
            byte[] r6 = r0.j
            byte r6 = r6[r8]
            r8 = 1
            goto L_0x0101
        L_0x00fb:
            int r6 = r11 + 1
            byte r7 = r18[r11]
            r11 = r6
            r6 = r7
        L_0x0101:
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r12
            int r7 = r0.f46342c
            int r7 = r7 - r8
            r0.f46342c = r7
            int r7 = r5 + 1
            int r8 = r6 >> 6
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r5] = r8
            int r5 = r7 + 1
            r6 = r6 & 63
            byte r1 = r1[r6]
            r2[r7] = r1
            boolean r1 = r0.f46343d
            if (r1 == 0) goto L_0x0129
            int r1 = r5 + 1
            r6 = 61
            r2[r5] = r6
            int r5 = r1 + 1
            r2[r1] = r6
        L_0x0129:
            boolean r1 = r0.f46344e
            if (r1 == 0) goto L_0x01c5
            boolean r1 = r0.f46345f
            if (r1 == 0) goto L_0x0136
            int r1 = r5 + 1
            r2[r5] = r13
            goto L_0x0137
        L_0x0136:
            r1 = r5
        L_0x0137:
            int r5 = r1 + 1
            r2[r1] = r14
            goto L_0x01c5
        L_0x013d:
            int r10 = r11 - r6
            int r12 = r4 + -2
            if (r10 != r12) goto L_0x01ad
            if (r6 <= r9) goto L_0x014b
            byte[] r6 = r0.j
            byte r6 = r6[r8]
            r8 = 1
            goto L_0x0151
        L_0x014b:
            int r6 = r11 + 1
            byte r10 = r18[r11]
            r11 = r6
            r6 = r10
        L_0x0151:
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r14
            int r10 = r0.f46342c
            if (r10 <= 0) goto L_0x0161
            byte[] r10 = r0.j
            int r12 = r8 + 1
            byte r8 = r10[r8]
            r10 = r11
            r11 = r8
            goto L_0x0166
        L_0x0161:
            int r10 = r11 + 1
            byte r11 = r18[r11]
            r12 = r8
        L_0x0166:
            r8 = r11 & 255(0xff, float:3.57E-43)
            int r7 = r8 << 2
            r6 = r6 | r7
            int r7 = r0.f46342c
            int r7 = r7 - r12
            r0.f46342c = r7
            int r7 = r5 + 1
            int r8 = r6 >> 12
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r5] = r8
            int r5 = r7 + 1
            int r8 = r6 >> 6
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r7] = r8
            int r7 = r5 + 1
            r6 = r6 & 63
            byte r1 = r1[r6]
            r2[r5] = r1
            boolean r1 = r0.f46343d
            if (r1 == 0) goto L_0x0197
            int r1 = r7 + 1
            r5 = 61
            r2[r7] = r5
            goto L_0x0198
        L_0x0197:
            r1 = r7
        L_0x0198:
            boolean r5 = r0.f46344e
            if (r5 == 0) goto L_0x01aa
            boolean r5 = r0.f46345f
            if (r5 == 0) goto L_0x01a5
            int r5 = r1 + 1
            r2[r1] = r13
            r1 = r5
        L_0x01a5:
            int r5 = r1 + 1
            r2[r1] = r14
            r1 = r5
        L_0x01aa:
            r5 = r1
            r11 = r10
            goto L_0x01c5
        L_0x01ad:
            boolean r1 = r0.f46344e
            if (r1 == 0) goto L_0x01c5
            if (r5 <= 0) goto L_0x01c5
            r1 = 19
            if (r3 == r1) goto L_0x01c5
            boolean r1 = r0.f46345f
            if (r1 == 0) goto L_0x01c0
            int r1 = r5 + 1
            r2[r5] = r13
            goto L_0x01c1
        L_0x01c0:
            r1 = r5
        L_0x01c1:
            int r5 = r1 + 1
            r2[r1] = r14
        L_0x01c5:
            boolean r1 = f46339g
            if (r1 != 0) goto L_0x01d4
            int r1 = r0.f46342c
            if (r1 != 0) goto L_0x01ce
            goto L_0x01d4
        L_0x01ce:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01d4:
            boolean r1 = f46339g
            if (r1 != 0) goto L_0x020c
            if (r11 != r4) goto L_0x01db
            goto L_0x020c
        L_0x01db:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01e1:
            int r1 = r4 + -1
            if (r11 != r1) goto L_0x01f2
            byte[] r1 = r0.j
            int r2 = r0.f46342c
            int r4 = r2 + 1
            r0.f46342c = r4
            byte r4 = r18[r11]
            r1[r2] = r4
            goto L_0x020c
        L_0x01f2:
            int r4 = r4 - r7
            if (r11 != r4) goto L_0x020c
            byte[] r1 = r0.j
            int r2 = r0.f46342c
            int r4 = r2 + 1
            r0.f46342c = r4
            byte r4 = r18[r11]
            r1[r2] = r4
            int r2 = r0.f46342c
            int r4 = r2 + 1
            r0.f46342c = r4
            int r11 = r11 + r9
            byte r4 = r18[r11]
            r1[r2] = r4
        L_0x020c:
            r0.f46333b = r5
            r0.k = r3
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: in.org.npci.commonlibrary.d.a(byte[], int, int, boolean):boolean");
    }
}
