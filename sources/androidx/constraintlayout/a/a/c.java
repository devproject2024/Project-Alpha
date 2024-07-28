package androidx.constraintlayout.a.a;

import java.util.ArrayList;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    protected e f2073a;

    /* renamed from: b  reason: collision with root package name */
    protected e f2074b;

    /* renamed from: c  reason: collision with root package name */
    protected e f2075c;

    /* renamed from: d  reason: collision with root package name */
    protected e f2076d;

    /* renamed from: e  reason: collision with root package name */
    protected e f2077e;

    /* renamed from: f  reason: collision with root package name */
    protected e f2078f;

    /* renamed from: g  reason: collision with root package name */
    protected e f2079g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<e> f2080h;

    /* renamed from: i  reason: collision with root package name */
    protected int f2081i;
    protected int j;
    protected float k = 0.0f;
    int l;
    int m;
    int n;
    boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    boolean t;
    private int u;
    private boolean v = false;

    public c(e eVar, int i2, boolean z) {
        this.f2073a = eVar;
        this.u = i2;
        this.v = z;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0130, code lost:
        if (r5.w == 0) goto L_0x0134;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r15 = this;
            int r0 = r15.u
            r1 = 2
            int r0 = r0 * 2
            androidx.constraintlayout.a.a.e r2 = r15.f2073a
            r3 = 1
            r15.o = r3
            r4 = 0
            r5 = r2
            r6 = r5
            r2 = 0
        L_0x000e:
            if (r2 != 0) goto L_0x0170
            int r7 = r15.f2081i
            int r7 = r7 + r3
            r15.f2081i = r7
            androidx.constraintlayout.a.a.e[] r7 = r5.aG
            int r8 = r15.u
            r9 = 0
            r7[r8] = r9
            androidx.constraintlayout.a.a.e[] r7 = r5.aF
            int r8 = r15.u
            r7[r8] = r9
            int r7 = r5.an
            r8 = 8
            if (r7 == r8) goto L_0x013e
            int r7 = r15.l
            int r7 = r7 + r3
            r15.l = r7
            int r7 = r15.u
            androidx.constraintlayout.a.a.e$a r7 = r5.l(r7)
            androidx.constraintlayout.a.a.e$a r10 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r7 == r10) goto L_0x004d
            int r7 = r15.m
            int r10 = r15.u
            if (r10 != 0) goto L_0x0042
            int r10 = r5.n()
            goto L_0x004a
        L_0x0042:
            if (r10 != r3) goto L_0x0049
            int r10 = r5.o()
            goto L_0x004a
        L_0x0049:
            r10 = 0
        L_0x004a:
            int r7 = r7 + r10
            r15.m = r7
        L_0x004d:
            int r7 = r15.m
            androidx.constraintlayout.a.a.d[] r10 = r5.R
            r10 = r10[r0]
            int r10 = r10.e()
            int r7 = r7 + r10
            r15.m = r7
            int r7 = r15.m
            androidx.constraintlayout.a.a.d[] r10 = r5.R
            int r11 = r0 + 1
            r10 = r10[r11]
            int r10 = r10.e()
            int r7 = r7 + r10
            r15.m = r7
            int r7 = r15.n
            androidx.constraintlayout.a.a.d[] r10 = r5.R
            r10 = r10[r0]
            int r10 = r10.e()
            int r7 = r7 + r10
            r15.n = r7
            int r7 = r15.n
            androidx.constraintlayout.a.a.d[] r10 = r5.R
            r10 = r10[r11]
            int r10 = r10.e()
            int r7 = r7 + r10
            r15.n = r7
            androidx.constraintlayout.a.a.e r7 = r15.f2074b
            if (r7 != 0) goto L_0x0089
            r15.f2074b = r5
        L_0x0089:
            r15.f2076d = r5
            androidx.constraintlayout.a.a.e$a[] r7 = r5.U
            int r10 = r15.u
            r7 = r7[r10]
            androidx.constraintlayout.a.a.e$a r10 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r7 != r10) goto L_0x013e
            int[] r7 = r5.r
            int r10 = r15.u
            r7 = r7[r10]
            r10 = 3
            r11 = 0
            if (r7 == 0) goto L_0x00af
            int[] r7 = r5.r
            int r12 = r15.u
            r7 = r7[r12]
            if (r7 == r10) goto L_0x00af
            int[] r7 = r5.r
            int r12 = r15.u
            r7 = r7[r12]
            if (r7 != r1) goto L_0x0113
        L_0x00af:
            int r7 = r15.j
            int r7 = r7 + r3
            r15.j = r7
            float[] r7 = r5.aE
            int r12 = r15.u
            r7 = r7[r12]
            int r12 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r12 <= 0) goto L_0x00c9
            float r12 = r15.k
            float[] r13 = r5.aE
            int r14 = r15.u
            r13 = r13[r14]
            float r12 = r12 + r13
            r15.k = r12
        L_0x00c9:
            int r12 = r15.u
            int r13 = r5.an
            if (r13 == r8) goto L_0x00e5
            androidx.constraintlayout.a.a.e$a[] r8 = r5.U
            r8 = r8[r12]
            androidx.constraintlayout.a.a.e$a r13 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r8 != r13) goto L_0x00e5
            int[] r8 = r5.r
            r8 = r8[r12]
            if (r8 == 0) goto L_0x00e3
            int[] r8 = r5.r
            r8 = r8[r12]
            if (r8 != r10) goto L_0x00e5
        L_0x00e3:
            r8 = 1
            goto L_0x00e6
        L_0x00e5:
            r8 = 0
        L_0x00e6:
            if (r8 == 0) goto L_0x0101
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 >= 0) goto L_0x00ef
            r15.p = r3
            goto L_0x00f1
        L_0x00ef:
            r15.q = r3
        L_0x00f1:
            java.util.ArrayList<androidx.constraintlayout.a.a.e> r7 = r15.f2080h
            if (r7 != 0) goto L_0x00fc
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r15.f2080h = r7
        L_0x00fc:
            java.util.ArrayList<androidx.constraintlayout.a.a.e> r7 = r15.f2080h
            r7.add(r5)
        L_0x0101:
            androidx.constraintlayout.a.a.e r7 = r15.f2078f
            if (r7 != 0) goto L_0x0107
            r15.f2078f = r5
        L_0x0107:
            androidx.constraintlayout.a.a.e r7 = r15.f2079g
            if (r7 == 0) goto L_0x0111
            androidx.constraintlayout.a.a.e[] r7 = r7.aF
            int r8 = r15.u
            r7[r8] = r5
        L_0x0111:
            r15.f2079g = r5
        L_0x0113:
            int r7 = r15.u
            if (r7 != 0) goto L_0x0126
            int r7 = r5.p
            if (r7 != 0) goto L_0x0132
            int r7 = r5.s
            if (r7 != 0) goto L_0x0123
            int r7 = r5.t
            if (r7 == 0) goto L_0x0134
        L_0x0123:
            r15.o = r4
            goto L_0x0134
        L_0x0126:
            int r7 = r5.q
            if (r7 != 0) goto L_0x0132
            int r7 = r5.v
            if (r7 != 0) goto L_0x0132
            int r7 = r5.w
            if (r7 == 0) goto L_0x0134
        L_0x0132:
            r15.o = r4
        L_0x0134:
            float r7 = r5.Y
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x013e
            r15.o = r4
            r15.s = r3
        L_0x013e:
            if (r6 == r5) goto L_0x0146
            androidx.constraintlayout.a.a.e[] r6 = r6.aG
            int r7 = r15.u
            r6[r7] = r5
        L_0x0146:
            androidx.constraintlayout.a.a.d[] r6 = r5.R
            int r7 = r0 + 1
            r6 = r6[r7]
            androidx.constraintlayout.a.a.d r6 = r6.f2087f
            if (r6 == 0) goto L_0x0166
            androidx.constraintlayout.a.a.e r6 = r6.f2085d
            androidx.constraintlayout.a.a.d[] r7 = r6.R
            r7 = r7[r0]
            androidx.constraintlayout.a.a.d r7 = r7.f2087f
            if (r7 == 0) goto L_0x0166
            androidx.constraintlayout.a.a.d[] r7 = r6.R
            r7 = r7[r0]
            androidx.constraintlayout.a.a.d r7 = r7.f2087f
            androidx.constraintlayout.a.a.e r7 = r7.f2085d
            if (r7 == r5) goto L_0x0165
            goto L_0x0166
        L_0x0165:
            r9 = r6
        L_0x0166:
            if (r9 == 0) goto L_0x016c
            r6 = r5
            r5 = r9
            goto L_0x000e
        L_0x016c:
            r6 = r5
            r2 = 1
            goto L_0x000e
        L_0x0170:
            androidx.constraintlayout.a.a.e r1 = r15.f2074b
            if (r1 == 0) goto L_0x0181
            int r2 = r15.m
            androidx.constraintlayout.a.a.d[] r1 = r1.R
            r1 = r1[r0]
            int r1 = r1.e()
            int r2 = r2 - r1
            r15.m = r2
        L_0x0181:
            androidx.constraintlayout.a.a.e r1 = r15.f2076d
            if (r1 == 0) goto L_0x0193
            int r2 = r15.m
            androidx.constraintlayout.a.a.d[] r1 = r1.R
            int r0 = r0 + r3
            r0 = r1[r0]
            int r0 = r0.e()
            int r2 = r2 - r0
            r15.m = r2
        L_0x0193:
            r15.f2075c = r5
            int r0 = r15.u
            if (r0 != 0) goto L_0x01a2
            boolean r0 = r15.v
            if (r0 == 0) goto L_0x01a2
            androidx.constraintlayout.a.a.e r0 = r15.f2075c
            r15.f2077e = r0
            goto L_0x01a6
        L_0x01a2:
            androidx.constraintlayout.a.a.e r0 = r15.f2073a
            r15.f2077e = r0
        L_0x01a6:
            boolean r0 = r15.q
            if (r0 == 0) goto L_0x01af
            boolean r0 = r15.p
            if (r0 == 0) goto L_0x01af
            goto L_0x01b0
        L_0x01af:
            r3 = 0
        L_0x01b0:
            r15.r = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.c.a():void");
    }
}
