package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.d;
import java.util.ArrayList;
import java.util.HashMap;

public final class g extends l {

    /* renamed from: a  reason: collision with root package name */
    public int f2107a = -1;
    public int aL = -1;
    public int aM = -1;
    public float aN = 0.5f;
    public float aO = 0.5f;
    public float aP = 0.5f;
    public float aQ = 0.5f;
    public float aR = 0.5f;
    public float aS = 0.5f;
    public int aT = 0;
    public int aU = 0;
    public int aV = 2;
    public int aW = 2;
    public int aX = 0;
    public int aY = -1;
    public int aZ = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f2108b = -1;
    private ArrayList<a> bn = new ArrayList<>();
    private e[] bo = null;
    private e[] bp = null;
    private int[] bq = null;
    /* access modifiers changed from: private */
    public e[] br;
    /* access modifiers changed from: private */
    public int bs = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f2109c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f2110d = -1;

    public final void a(e eVar, HashMap<e, e> hashMap) {
        super.a(eVar, hashMap);
        g gVar = (g) eVar;
        this.f2107a = gVar.f2107a;
        this.f2108b = gVar.f2108b;
        this.f2109c = gVar.f2109c;
        this.f2110d = gVar.f2110d;
        this.aL = gVar.aL;
        this.aM = gVar.aM;
        this.aN = gVar.aN;
        this.aO = gVar.aO;
        this.aP = gVar.aP;
        this.aQ = gVar.aQ;
        this.aR = gVar.aR;
        this.aS = gVar.aS;
        this.aT = gVar.aT;
        this.aU = gVar.aU;
        this.aV = gVar.aV;
        this.aW = gVar.aW;
        this.aX = gVar.aX;
        this.aY = gVar.aY;
        this.aZ = gVar.aZ;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v3, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v4, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v5, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v5, resolved type: int} */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0200 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011f  */
    public final void a(int r34, int r35, int r36, int r37) {
        /*
            r33 = this;
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r36
            r12 = r37
            int r0 = r8.bb
            r13 = 0
            if (r0 <= 0) goto L_0x001b
            boolean r0 = r33.e()
            if (r0 != 0) goto L_0x001b
            r8.g(r13, r13)
            r8.bi = r13
            return
        L_0x001b:
            int r14 = r8.bg
            int r15 = r8.bh
            int r7 = r8.bc
            int r6 = r8.bd
            r0 = 2
            int[] r5 = new int[r0]
            int r1 = r10 - r14
            int r1 = r1 - r15
            int r2 = r8.aZ
            r4 = 1
            if (r2 != r4) goto L_0x0031
            int r1 = r12 - r7
            int r1 = r1 - r6
        L_0x0031:
            r3 = r1
            int r1 = r8.aZ
            r2 = -1
            if (r1 != 0) goto L_0x0044
            int r1 = r8.f2107a
            if (r1 != r2) goto L_0x003d
            r8.f2107a = r13
        L_0x003d:
            int r1 = r8.f2108b
            if (r1 != r2) goto L_0x0050
            r8.f2108b = r13
            goto L_0x0050
        L_0x0044:
            int r1 = r8.f2107a
            if (r1 != r2) goto L_0x004a
            r8.f2107a = r13
        L_0x004a:
            int r1 = r8.f2108b
            if (r1 != r2) goto L_0x0050
            r8.f2108b = r13
        L_0x0050:
            androidx.constraintlayout.a.a.e[] r1 = r8.ba
            r2 = 0
            r16 = 0
        L_0x0055:
            int r13 = r8.bb
            r0 = 8
            if (r2 >= r13) goto L_0x0069
            androidx.constraintlayout.a.a.e[] r13 = r8.ba
            r13 = r13[r2]
            int r13 = r13.an
            if (r13 != r0) goto L_0x0065
            int r16 = r16 + 1
        L_0x0065:
            int r2 = r2 + 1
            r0 = 2
            goto L_0x0055
        L_0x0069:
            int r2 = r8.bb
            if (r16 <= 0) goto L_0x0091
            int r1 = r8.bb
            int r1 = r1 - r16
            androidx.constraintlayout.a.a.e[] r1 = new androidx.constraintlayout.a.a.e[r1]
            r2 = 0
            r13 = 0
        L_0x0075:
            int r4 = r8.bb
            if (r2 >= r4) goto L_0x008c
            androidx.constraintlayout.a.a.e[] r4 = r8.ba
            r4 = r4[r2]
            r18 = r6
            int r6 = r4.an
            if (r6 == r0) goto L_0x0087
            r1[r13] = r4
            int r13 = r13 + 1
        L_0x0087:
            int r2 = r2 + 1
            r6 = r18
            goto L_0x0075
        L_0x008c:
            r18 = r6
            r6 = r13
            r13 = r1
            goto L_0x0095
        L_0x0091:
            r18 = r6
            r13 = r1
            r6 = r2
        L_0x0095:
            r8.br = r13
            r8.bs = r6
            int r0 = r8.aX
            if (r0 == 0) goto L_0x044b
            r2 = 1
            if (r0 == r2) goto L_0x0214
            r2 = 2
            if (r0 == r2) goto L_0x00b2
            r28 = r5
            r30 = r7
            r32 = r14
            r31 = r15
            r29 = r18
        L_0x00ad:
            r4 = 1
            r16 = 0
            goto L_0x04d8
        L_0x00b2:
            int r0 = r8.aZ
            if (r0 != 0) goto L_0x00df
            int r2 = r8.aY
            if (r2 > 0) goto L_0x00db
            r2 = 0
            r4 = 0
            r19 = 0
        L_0x00be:
            if (r2 >= r6) goto L_0x00d5
            if (r2 <= 0) goto L_0x00c5
            int r1 = r8.aT
            int r4 = r4 + r1
        L_0x00c5:
            r1 = r13[r2]
            if (r1 == 0) goto L_0x00d2
            int r1 = r8.a((androidx.constraintlayout.a.a.e) r1, (int) r3)
            int r4 = r4 + r1
            if (r4 > r3) goto L_0x00d5
            int r19 = r19 + 1
        L_0x00d2:
            int r2 = r2 + 1
            goto L_0x00be
        L_0x00d5:
            r2 = r19
            r1 = 0
            r19 = r7
            goto L_0x0106
        L_0x00db:
            r19 = r7
            r1 = 0
            goto L_0x0106
        L_0x00df:
            int r1 = r8.aY
            if (r1 > 0) goto L_0x0103
            r1 = 0
            r2 = 0
            r4 = 0
        L_0x00e6:
            r19 = r7
            if (r1 >= r6) goto L_0x0101
            if (r1 <= 0) goto L_0x00ef
            int r7 = r8.aU
            int r2 = r2 + r7
        L_0x00ef:
            r7 = r13[r1]
            if (r7 == 0) goto L_0x00fc
            int r7 = r8.b(r7, r3)
            int r2 = r2 + r7
            if (r2 > r3) goto L_0x0101
            int r4 = r4 + 1
        L_0x00fc:
            int r1 = r1 + 1
            r7 = r19
            goto L_0x00e6
        L_0x0101:
            r1 = r4
            goto L_0x0105
        L_0x0103:
            r19 = r7
        L_0x0105:
            r2 = 0
        L_0x0106:
            int[] r4 = r8.bq
            if (r4 != 0) goto L_0x010f
            r4 = 2
            int[] r4 = new int[r4]
            r8.bq = r4
        L_0x010f:
            if (r1 != 0) goto L_0x0114
            r4 = 1
            if (r0 == r4) goto L_0x0118
        L_0x0114:
            if (r2 != 0) goto L_0x011b
            if (r0 != 0) goto L_0x011b
        L_0x0118:
            r4 = r1
        L_0x0119:
            r1 = 1
            goto L_0x011d
        L_0x011b:
            r4 = r1
            r1 = 0
        L_0x011d:
            if (r1 != 0) goto L_0x0200
            if (r0 != 0) goto L_0x012b
            float r4 = (float) r6
            float r7 = (float) r2
            float r4 = r4 / r7
            double r11 = (double) r4
            double r11 = java.lang.Math.ceil(r11)
            int r4 = (int) r11
            goto L_0x0134
        L_0x012b:
            float r2 = (float) r6
            float r7 = (float) r4
            float r2 = r2 / r7
            double r11 = (double) r2
            double r11 = java.lang.Math.ceil(r11)
            int r2 = (int) r11
        L_0x0134:
            androidx.constraintlayout.a.a.e[] r7 = r8.bp
            if (r7 == 0) goto L_0x0141
            int r11 = r7.length
            if (r11 >= r2) goto L_0x013c
            goto L_0x0141
        L_0x013c:
            r11 = 0
            java.util.Arrays.fill(r7, r11)
            goto L_0x0146
        L_0x0141:
            r11 = 0
            androidx.constraintlayout.a.a.e[] r7 = new androidx.constraintlayout.a.a.e[r2]
            r8.bp = r7
        L_0x0146:
            androidx.constraintlayout.a.a.e[] r7 = r8.bo
            if (r7 == 0) goto L_0x0152
            int r12 = r7.length
            if (r12 >= r4) goto L_0x014e
            goto L_0x0152
        L_0x014e:
            java.util.Arrays.fill(r7, r11)
            goto L_0x0156
        L_0x0152:
            androidx.constraintlayout.a.a.e[] r7 = new androidx.constraintlayout.a.a.e[r4]
            r8.bo = r7
        L_0x0156:
            r7 = 0
        L_0x0157:
            if (r7 >= r2) goto L_0x01a9
            r11 = 0
        L_0x015a:
            if (r11 >= r4) goto L_0x01a2
            int r12 = r11 * r2
            int r12 = r12 + r7
            r17 = r1
            r1 = 1
            if (r0 != r1) goto L_0x0168
            int r1 = r7 * r4
            int r12 = r1 + r11
        L_0x0168:
            int r1 = r13.length
            if (r12 >= r1) goto L_0x019b
            r1 = r13[r12]
            if (r1 == 0) goto L_0x019b
            int r12 = r8.a((androidx.constraintlayout.a.a.e) r1, (int) r3)
            androidx.constraintlayout.a.a.e[] r10 = r8.bp
            r21 = r10[r7]
            if (r21 == 0) goto L_0x0181
            r10 = r10[r7]
            int r10 = r10.n()
            if (r10 >= r12) goto L_0x0185
        L_0x0181:
            androidx.constraintlayout.a.a.e[] r10 = r8.bp
            r10[r7] = r1
        L_0x0185:
            int r10 = r8.b(r1, r3)
            androidx.constraintlayout.a.a.e[] r12 = r8.bo
            r21 = r12[r11]
            if (r21 == 0) goto L_0x0197
            r12 = r12[r11]
            int r12 = r12.o()
            if (r12 >= r10) goto L_0x019b
        L_0x0197:
            androidx.constraintlayout.a.a.e[] r10 = r8.bo
            r10[r11] = r1
        L_0x019b:
            int r11 = r11 + 1
            r10 = r35
            r1 = r17
            goto L_0x015a
        L_0x01a2:
            r17 = r1
            int r7 = r7 + 1
            r10 = r35
            goto L_0x0157
        L_0x01a9:
            r17 = r1
            r1 = 0
            r7 = 0
        L_0x01ad:
            if (r1 >= r2) goto L_0x01c2
            androidx.constraintlayout.a.a.e[] r10 = r8.bp
            r10 = r10[r1]
            if (r10 == 0) goto L_0x01bf
            if (r1 <= 0) goto L_0x01ba
            int r11 = r8.aT
            int r7 = r7 + r11
        L_0x01ba:
            int r10 = r8.a((androidx.constraintlayout.a.a.e) r10, (int) r3)
            int r7 = r7 + r10
        L_0x01bf:
            int r1 = r1 + 1
            goto L_0x01ad
        L_0x01c2:
            r1 = 0
            r10 = 0
        L_0x01c4:
            if (r1 >= r4) goto L_0x01d9
            androidx.constraintlayout.a.a.e[] r11 = r8.bo
            r11 = r11[r1]
            if (r11 == 0) goto L_0x01d6
            if (r1 <= 0) goto L_0x01d1
            int r12 = r8.aU
            int r10 = r10 + r12
        L_0x01d1:
            int r11 = r8.b(r11, r3)
            int r10 = r10 + r11
        L_0x01d6:
            int r1 = r1 + 1
            goto L_0x01c4
        L_0x01d9:
            r1 = 0
            r5[r1] = r7
            r11 = 1
            r5[r11] = r10
            if (r0 != 0) goto L_0x01e8
            if (r7 <= r3) goto L_0x01f8
            if (r2 <= r11) goto L_0x01f8
            int r2 = r2 + -1
            goto L_0x01ee
        L_0x01e8:
            if (r10 <= r3) goto L_0x01f8
            if (r4 <= r11) goto L_0x01f8
            int r4 = r4 + -1
        L_0x01ee:
            r10 = r35
            r11 = r36
            r12 = r37
            r1 = r17
            goto L_0x011d
        L_0x01f8:
            r10 = r35
            r11 = r36
            r12 = r37
            goto L_0x0119
        L_0x0200:
            r11 = 1
            int[] r0 = r8.bq
            r1 = 0
            r0[r1] = r2
            r0[r11] = r4
        L_0x0208:
            r28 = r5
            r32 = r14
            r31 = r15
            r29 = r18
            r30 = r19
            goto L_0x00ad
        L_0x0214:
            r19 = r7
            r11 = 1
            int r10 = r8.aZ
            if (r6 == 0) goto L_0x0208
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r0 = r8.bn
            r0.clear()
            androidx.constraintlayout.a.a.g$a r12 = new androidx.constraintlayout.a.a.g$a
            androidx.constraintlayout.a.a.d r4 = r8.J
            androidx.constraintlayout.a.a.d r7 = r8.K
            androidx.constraintlayout.a.a.d r2 = r8.L
            androidx.constraintlayout.a.a.d r1 = r8.M
            r0 = r12
            r16 = r1
            r1 = r33
            r17 = r2
            r2 = r10
            r27 = r3
            r3 = r4
            r4 = r7
            r28 = r5
            r5 = r17
            r7 = r6
            r29 = r18
            r6 = r16
            r11 = r7
            r30 = r19
            r7 = r27
            r0.<init>(r2, r3, r4, r5, r6, r7)
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r0 = r8.bn
            r0.add(r12)
            if (r10 != 0) goto L_0x02d0
            r2 = r12
            r0 = 0
            r1 = 0
            r12 = 0
        L_0x0252:
            if (r12 >= r11) goto L_0x02cc
            r7 = r13[r12]
            r6 = r27
            int r16 = r8.a((androidx.constraintlayout.a.a.e) r7, (int) r6)
            androidx.constraintlayout.a.a.e$a[] r3 = r7.U
            r4 = 0
            r3 = r3[r4]
            androidx.constraintlayout.a.a.e$a r4 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x0267
            int r0 = r0 + 1
        L_0x0267:
            r17 = r0
            if (r1 == r6) goto L_0x0272
            int r0 = r8.aT
            int r0 = r0 + r1
            int r0 = r0 + r16
            if (r0 <= r6) goto L_0x0278
        L_0x0272:
            androidx.constraintlayout.a.a.e r0 = r2.f2111a
            if (r0 == 0) goto L_0x0278
            r4 = 1
            goto L_0x0279
        L_0x0278:
            r4 = 0
        L_0x0279:
            if (r4 != 0) goto L_0x0286
            if (r12 <= 0) goto L_0x0286
            int r0 = r8.aY
            if (r0 <= 0) goto L_0x0286
            int r0 = r12 % r0
            if (r0 != 0) goto L_0x0286
            r4 = 1
        L_0x0286:
            if (r4 == 0) goto L_0x02b4
            androidx.constraintlayout.a.a.g$a r5 = new androidx.constraintlayout.a.a.g$a
            androidx.constraintlayout.a.a.d r3 = r8.J
            androidx.constraintlayout.a.a.d r4 = r8.K
            androidx.constraintlayout.a.a.d r2 = r8.L
            androidx.constraintlayout.a.a.d r1 = r8.M
            r0 = r5
            r18 = r1
            r1 = r33
            r19 = r2
            r2 = r10
            r9 = r5
            r5 = r19
            r27 = r6
            r6 = r18
            r31 = r15
            r15 = r7
            r7 = r27
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r9.f2115e = r12
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r0 = r8.bn
            r0.add(r9)
            r2 = r9
        L_0x02b1:
            r1 = r16
            goto L_0x02c0
        L_0x02b4:
            r27 = r6
            r31 = r15
            r15 = r7
            if (r12 <= 0) goto L_0x02b1
            int r0 = r8.aT
            int r0 = r0 + r16
            int r1 = r1 + r0
        L_0x02c0:
            r2.a((androidx.constraintlayout.a.a.e) r15)
            int r12 = r12 + 1
            r9 = r34
            r0 = r17
            r15 = r31
            goto L_0x0252
        L_0x02cc:
            r31 = r15
            goto L_0x0339
        L_0x02d0:
            r31 = r15
            r0 = 0
            r1 = 0
            r9 = 0
        L_0x02d5:
            if (r9 >= r11) goto L_0x0339
            r15 = r13[r9]
            r7 = r27
            int r16 = r8.b(r15, r7)
            androidx.constraintlayout.a.a.e$a[] r2 = r15.U
            r3 = 1
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e$a r3 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x02ea
            int r0 = r0 + 1
        L_0x02ea:
            r17 = r0
            if (r1 == r7) goto L_0x02f5
            int r0 = r8.aU
            int r0 = r0 + r1
            int r0 = r0 + r16
            if (r0 <= r7) goto L_0x02fb
        L_0x02f5:
            androidx.constraintlayout.a.a.e r0 = r12.f2111a
            if (r0 == 0) goto L_0x02fb
            r4 = 1
            goto L_0x02fc
        L_0x02fb:
            r4 = 0
        L_0x02fc:
            if (r4 != 0) goto L_0x0309
            if (r9 <= 0) goto L_0x0309
            int r0 = r8.aY
            if (r0 <= 0) goto L_0x0309
            int r0 = r9 % r0
            if (r0 != 0) goto L_0x0309
            r4 = 1
        L_0x0309:
            if (r4 == 0) goto L_0x0328
            androidx.constraintlayout.a.a.g$a r12 = new androidx.constraintlayout.a.a.g$a
            androidx.constraintlayout.a.a.d r3 = r8.J
            androidx.constraintlayout.a.a.d r4 = r8.K
            androidx.constraintlayout.a.a.d r5 = r8.L
            androidx.constraintlayout.a.a.d r6 = r8.M
            r0 = r12
            r1 = r33
            r2 = r10
            r27 = r7
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r12.f2115e = r9
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r0 = r8.bn
            r0.add(r12)
        L_0x0325:
            r1 = r16
            goto L_0x0331
        L_0x0328:
            r27 = r7
            if (r9 <= 0) goto L_0x0325
            int r0 = r8.aU
            int r0 = r0 + r16
            int r1 = r1 + r0
        L_0x0331:
            r12.a((androidx.constraintlayout.a.a.e) r15)
            int r9 = r9 + 1
            r0 = r17
            goto L_0x02d5
        L_0x0339:
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r1 = r8.bn
            int r1 = r1.size()
            androidx.constraintlayout.a.a.d r2 = r8.J
            androidx.constraintlayout.a.a.d r3 = r8.K
            androidx.constraintlayout.a.a.d r4 = r8.L
            androidx.constraintlayout.a.a.d r5 = r8.M
            int r6 = r8.bg
            int r7 = r8.bc
            int r9 = r8.bh
            int r11 = r8.bd
            androidx.constraintlayout.a.a.e$a[] r12 = r8.U
            r13 = 0
            r12 = r12[r13]
            androidx.constraintlayout.a.a.e$a r13 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r12 == r13) goto L_0x0364
            androidx.constraintlayout.a.a.e$a[] r12 = r8.U
            r13 = 1
            r12 = r12[r13]
            androidx.constraintlayout.a.a.e$a r13 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r12 != r13) goto L_0x0362
            goto L_0x0364
        L_0x0362:
            r12 = 0
            goto L_0x0365
        L_0x0364:
            r12 = 1
        L_0x0365:
            if (r0 <= 0) goto L_0x038c
            if (r12 == 0) goto L_0x038c
            r0 = 0
        L_0x036a:
            if (r0 >= r1) goto L_0x038c
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r12 = r8.bn
            java.lang.Object r12 = r12.get(r0)
            androidx.constraintlayout.a.a.g$a r12 = (androidx.constraintlayout.a.a.g.a) r12
            if (r10 != 0) goto L_0x0380
            int r13 = r12.a()
            int r13 = r27 - r13
            r12.a((int) r13)
            goto L_0x0389
        L_0x0380:
            int r13 = r12.b()
            int r13 = r27 - r13
            r12.a((int) r13)
        L_0x0389:
            int r0 = r0 + 1
            goto L_0x036a
        L_0x038c:
            r12 = r4
            r13 = r9
            r0 = 0
            r4 = r2
            r9 = r7
            r2 = 0
            r7 = r6
            r6 = r5
            r5 = r3
            r3 = 0
        L_0x0396:
            if (r0 >= r1) goto L_0x0441
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r15 = r8.bn
            java.lang.Object r15 = r15.get(r0)
            androidx.constraintlayout.a.a.g$a r15 = (androidx.constraintlayout.a.a.g.a) r15
            if (r10 != 0) goto L_0x03f0
            int r6 = r1 + -1
            if (r0 >= r6) goto L_0x03b8
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r6 = r8.bn
            int r11 = r0 + 1
            java.lang.Object r6 = r6.get(r11)
            androidx.constraintlayout.a.a.g$a r6 = (androidx.constraintlayout.a.a.g.a) r6
            androidx.constraintlayout.a.a.e r6 = r6.f2111a
            androidx.constraintlayout.a.a.d r6 = r6.K
            r32 = r14
            r11 = 0
            goto L_0x03be
        L_0x03b8:
            androidx.constraintlayout.a.a.d r6 = r8.M
            int r11 = r8.bd
            r32 = r14
        L_0x03be:
            androidx.constraintlayout.a.a.e r14 = r15.f2111a
            androidx.constraintlayout.a.a.d r14 = r14.M
            r16 = r15
            r17 = r10
            r18 = r4
            r19 = r5
            r20 = r12
            r21 = r6
            r22 = r7
            r23 = r9
            r24 = r13
            r25 = r11
            r26 = r27
            r16.a(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r5 = r15.a()
            int r2 = java.lang.Math.max(r2, r5)
            int r5 = r15.b()
            int r3 = r3 + r5
            if (r0 <= 0) goto L_0x03ed
            int r5 = r8.aU
            int r3 = r3 + r5
        L_0x03ed:
            r5 = r14
            r9 = 0
            goto L_0x043b
        L_0x03f0:
            r32 = r14
            int r12 = r1 + -1
            if (r0 >= r12) goto L_0x0406
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r12 = r8.bn
            int r13 = r0 + 1
            java.lang.Object r12 = r12.get(r13)
            androidx.constraintlayout.a.a.g$a r12 = (androidx.constraintlayout.a.a.g.a) r12
            androidx.constraintlayout.a.a.e r12 = r12.f2111a
            androidx.constraintlayout.a.a.d r12 = r12.J
            r13 = 0
            goto L_0x040a
        L_0x0406:
            androidx.constraintlayout.a.a.d r12 = r8.L
            int r13 = r8.bh
        L_0x040a:
            androidx.constraintlayout.a.a.e r14 = r15.f2111a
            androidx.constraintlayout.a.a.d r14 = r14.L
            r16 = r15
            r17 = r10
            r18 = r4
            r19 = r5
            r20 = r12
            r21 = r6
            r22 = r7
            r23 = r9
            r24 = r13
            r25 = r11
            r26 = r27
            r16.a(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r4 = r15.a()
            int r2 = r2 + r4
            int r4 = r15.b()
            int r3 = java.lang.Math.max(r3, r4)
            if (r0 <= 0) goto L_0x0439
            int r4 = r8.aT
            int r2 = r2 + r4
        L_0x0439:
            r4 = r14
            r7 = 0
        L_0x043b:
            int r0 = r0 + 1
            r14 = r32
            goto L_0x0396
        L_0x0441:
            r32 = r14
            r0 = 0
            r28[r0] = r2
            r0 = 1
            r28[r0] = r3
            goto L_0x00ad
        L_0x044b:
            r27 = r3
            r28 = r5
            r11 = r6
            r30 = r7
            r32 = r14
            r31 = r15
            r29 = r18
            int r2 = r8.aZ
            if (r11 == 0) goto L_0x00ad
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r0 = r8.bn
            int r0 = r0.size()
            if (r0 != 0) goto L_0x047d
            androidx.constraintlayout.a.a.g$a r9 = new androidx.constraintlayout.a.a.g$a
            androidx.constraintlayout.a.a.d r3 = r8.J
            androidx.constraintlayout.a.a.d r4 = r8.K
            androidx.constraintlayout.a.a.d r5 = r8.L
            androidx.constraintlayout.a.a.d r6 = r8.M
            r0 = r9
            r1 = r33
            r7 = r27
            r0.<init>(r2, r3, r4, r5, r6, r7)
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r0 = r8.bn
            r0.add(r9)
            r0 = r9
            goto L_0x04be
        L_0x047d:
            java.util.ArrayList<androidx.constraintlayout.a.a.g$a> r0 = r8.bn
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            androidx.constraintlayout.a.a.g$a r0 = (androidx.constraintlayout.a.a.g.a) r0
            r0.f2112b = r1
            r3 = 0
            r0.f2111a = r3
            r0.f2113c = r1
            r0.f2114d = r1
            r0.f2115e = r1
            r0.f2116f = r1
            r0.f2117g = r1
            androidx.constraintlayout.a.a.d r1 = r8.J
            androidx.constraintlayout.a.a.d r3 = r8.K
            androidx.constraintlayout.a.a.d r4 = r8.L
            androidx.constraintlayout.a.a.d r5 = r8.M
            int r6 = r8.bg
            int r7 = r8.bc
            int r9 = r8.bh
            int r10 = r8.bd
            r16 = r0
            r17 = r2
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r9
            r25 = r10
            r26 = r27
            r16.a(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
        L_0x04be:
            r1 = 0
        L_0x04bf:
            if (r1 >= r11) goto L_0x04c9
            r2 = r13[r1]
            r0.a((androidx.constraintlayout.a.a.e) r2)
            int r1 = r1 + 1
            goto L_0x04bf
        L_0x04c9:
            int r1 = r0.a()
            r16 = 0
            r28[r16] = r1
            int r0 = r0.b()
            r4 = 1
            r28[r4] = r0
        L_0x04d8:
            r0 = r28[r16]
            int r0 = r0 + r32
            int r0 = r0 + r31
            r1 = r28[r4]
            int r1 = r1 + r30
            int r1 = r1 + r29
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r5 = r34
            if (r5 != r3) goto L_0x04f1
            r5 = r35
        L_0x04ee:
            r0 = r36
            goto L_0x0501
        L_0x04f1:
            if (r5 != r2) goto L_0x04fb
            r6 = r35
            int r0 = java.lang.Math.min(r0, r6)
        L_0x04f9:
            r5 = r0
            goto L_0x04ee
        L_0x04fb:
            if (r5 != 0) goto L_0x04fe
            goto L_0x04f9
        L_0x04fe:
            r0 = r36
            r5 = 0
        L_0x0501:
            if (r0 != r3) goto L_0x0506
            r0 = r37
            goto L_0x0514
        L_0x0506:
            if (r0 != r2) goto L_0x050f
            r2 = r37
            int r0 = java.lang.Math.min(r1, r2)
            goto L_0x0514
        L_0x050f:
            if (r0 != 0) goto L_0x0513
            r0 = r1
            goto L_0x0514
        L_0x0513:
            r0 = 0
        L_0x0514:
            r8.g(r5, r0)
            r8.g(r5)
            r8.h(r0)
            int r0 = r8.bb
            if (r0 <= 0) goto L_0x0522
            goto L_0x0523
        L_0x0522:
            r4 = 0
        L_0x0523:
            r8.bi = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.g.a(int, int, int, int):void");
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        e f2111a = null;

        /* renamed from: b  reason: collision with root package name */
        int f2112b = 0;

        /* renamed from: c  reason: collision with root package name */
        int f2113c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f2114d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f2115e = 0;

        /* renamed from: f  reason: collision with root package name */
        int f2116f = 0;

        /* renamed from: g  reason: collision with root package name */
        int f2117g = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f2119i = 0;
        private d j;
        private d k;
        private d l;
        private d m;
        private int n = 0;
        private int o = 0;
        private int p = 0;
        private int q = 0;
        private int r = 0;

        public a(int i2, d dVar, d dVar2, d dVar3, d dVar4, int i3) {
            this.f2119i = i2;
            this.j = dVar;
            this.k = dVar2;
            this.l = dVar3;
            this.m = dVar4;
            this.n = g.this.bg;
            this.o = g.this.bc;
            this.p = g.this.bh;
            this.q = g.this.bd;
            this.r = i3;
        }

        public final void a(int i2, d dVar, d dVar2, d dVar3, d dVar4, int i3, int i4, int i5, int i6, int i7) {
            this.f2119i = i2;
            this.j = dVar;
            this.k = dVar2;
            this.l = dVar3;
            this.m = dVar4;
            this.n = i3;
            this.o = i4;
            this.p = i5;
            this.q = i6;
            this.r = i7;
        }

        public final int a() {
            if (this.f2119i == 0) {
                return this.f2113c - g.this.aT;
            }
            return this.f2113c;
        }

        public final int b() {
            if (this.f2119i == 1) {
                return this.f2114d - g.this.aU;
            }
            return this.f2114d;
        }

        public final void a(e eVar) {
            int i2 = 0;
            if (this.f2119i == 0) {
                int a2 = g.this.a(eVar, this.r);
                if (eVar.U[0] == e.a.MATCH_CONSTRAINT) {
                    this.f2117g++;
                    a2 = 0;
                }
                int a3 = g.this.aT;
                if (eVar.an != 8) {
                    i2 = a3;
                }
                this.f2113c += a2 + i2;
                int b2 = g.this.b(eVar, this.r);
                if (this.f2111a == null || this.f2112b < b2) {
                    this.f2111a = eVar;
                    this.f2112b = b2;
                    this.f2114d = b2;
                }
            } else {
                int a4 = g.this.a(eVar, this.r);
                int b3 = g.this.b(eVar, this.r);
                if (eVar.U[1] == e.a.MATCH_CONSTRAINT) {
                    this.f2117g++;
                    b3 = 0;
                }
                int b4 = g.this.aU;
                if (eVar.an != 8) {
                    i2 = b4;
                }
                this.f2114d += b3 + i2;
                if (this.f2111a == null || this.f2112b < a4) {
                    this.f2111a = eVar;
                    this.f2112b = a4;
                    this.f2113c = a4;
                }
            }
            this.f2116f++;
        }

        public final void a(boolean z, int i2, boolean z2) {
            e eVar;
            int i3 = this.f2116f;
            int i4 = 0;
            while (i4 < i3 && this.f2115e + i4 < g.this.bs) {
                e eVar2 = g.this.br[this.f2115e + i4];
                if (eVar2 != null) {
                    eVar2.u();
                }
                i4++;
            }
            if (i3 != 0 && this.f2111a != null) {
                boolean z3 = z2 && i2 == 0;
                int i5 = -1;
                int i6 = -1;
                for (int i7 = 0; i7 < i3; i7++) {
                    int i8 = z ? (i3 - 1) - i7 : i7;
                    if (this.f2115e + i8 >= g.this.bs) {
                        break;
                    }
                    if (g.this.br[this.f2115e + i8].an == 0) {
                        if (i5 == -1) {
                            i5 = i7;
                        }
                        i6 = i7;
                    }
                }
                if (this.f2119i == 0) {
                    e eVar3 = this.f2111a;
                    eVar3.aB = g.this.f2108b;
                    int i9 = this.o;
                    if (i2 > 0) {
                        i9 += g.this.aU;
                    }
                    eVar3.K.a(this.k, i9);
                    if (z2) {
                        eVar3.M.a(this.m, this.q);
                    }
                    if (i2 > 0) {
                        this.k.f2085d.M.a(eVar3.K, 0);
                    }
                    if (g.this.aW == 3 && !eVar3.E) {
                        int i10 = 0;
                        while (true) {
                            if (i10 < i3) {
                                int i11 = z ? (i3 - 1) - i10 : i10;
                                if (this.f2115e + i11 >= g.this.bs) {
                                    break;
                                }
                                eVar = g.this.br[this.f2115e + i11];
                                if (eVar.E) {
                                    break;
                                }
                                i10++;
                            } else {
                                break;
                            }
                        }
                    }
                    eVar = eVar3;
                    e eVar4 = null;
                    int i12 = 0;
                    while (i12 < i3) {
                        int i13 = z ? (i3 - 1) - i12 : i12;
                        if (this.f2115e + i13 < g.this.bs) {
                            e eVar5 = g.this.br[this.f2115e + i13];
                            if (i12 == 0) {
                                eVar5.a(eVar5.J, this.j, this.n);
                            }
                            if (i13 == 0) {
                                int g2 = g.this.f2107a;
                                float h2 = g.this.aN;
                                if (this.f2115e == 0 && g.this.f2109c != -1) {
                                    g2 = g.this.f2109c;
                                    h2 = g.this.aP;
                                } else if (z2 && g.this.aL != -1) {
                                    g2 = g.this.aL;
                                    h2 = g.this.aR;
                                }
                                eVar5.aA = g2;
                                eVar5.ak = h2;
                            }
                            if (i12 == i3 - 1) {
                                eVar5.a(eVar5.L, this.l, this.p);
                            }
                            if (eVar4 != null) {
                                eVar5.J.a(eVar4.L, g.this.aT);
                                if (i12 == i5) {
                                    eVar5.J.b(this.n);
                                }
                                eVar4.L.a(eVar5.J, 0);
                                if (i12 == i6 + 1) {
                                    eVar4.L.b(this.p);
                                }
                            }
                            if (eVar5 != eVar3) {
                                if (g.this.aW != 3 || !eVar.E || eVar5 == eVar || !eVar5.E) {
                                    int f2 = g.this.aW;
                                    if (f2 == 0) {
                                        eVar5.K.a(eVar3.K, 0);
                                    } else if (f2 == 1) {
                                        eVar5.M.a(eVar3.M, 0);
                                    } else if (z3) {
                                        eVar5.K.a(this.k, this.o);
                                        eVar5.M.a(this.m, this.q);
                                    } else {
                                        eVar5.K.a(eVar3.K, 0);
                                        eVar5.M.a(eVar3.M, 0);
                                    }
                                } else {
                                    eVar5.N.a(eVar.N, 0);
                                }
                            }
                            i12++;
                            eVar4 = eVar5;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                e eVar6 = this.f2111a;
                eVar6.aA = g.this.f2107a;
                int i14 = this.n;
                if (i2 > 0) {
                    i14 += g.this.aT;
                }
                if (z) {
                    eVar6.L.a(this.l, i14);
                    if (z2) {
                        eVar6.J.a(this.j, this.p);
                    }
                    if (i2 > 0) {
                        this.l.f2085d.J.a(eVar6.L, 0);
                    }
                } else {
                    eVar6.J.a(this.j, i14);
                    if (z2) {
                        eVar6.L.a(this.l, this.p);
                    }
                    if (i2 > 0) {
                        this.j.f2085d.L.a(eVar6.J, 0);
                    }
                }
                e eVar7 = null;
                int i15 = 0;
                while (i15 < i3 && this.f2115e + i15 < g.this.bs) {
                    e eVar8 = g.this.br[this.f2115e + i15];
                    if (i15 == 0) {
                        eVar8.a(eVar8.K, this.k, this.o);
                        int e2 = g.this.f2108b;
                        float m2 = g.this.aO;
                        if (this.f2115e == 0 && g.this.f2110d != -1) {
                            e2 = g.this.f2110d;
                            m2 = g.this.aQ;
                        } else if (z2 && g.this.aM != -1) {
                            e2 = g.this.aM;
                            m2 = g.this.aS;
                        }
                        eVar8.aB = e2;
                        eVar8.al = m2;
                    }
                    if (i15 == i3 - 1) {
                        eVar8.a(eVar8.M, this.m, this.q);
                    }
                    if (eVar7 != null) {
                        eVar8.K.a(eVar7.M, g.this.aU);
                        if (i15 == i5) {
                            eVar8.K.b(this.o);
                        }
                        eVar7.M.a(eVar8.K, 0);
                        if (i15 == i6 + 1) {
                            eVar7.M.b(this.q);
                        }
                    }
                    if (eVar8 != eVar6) {
                        if (z) {
                            int r2 = g.this.aV;
                            if (r2 == 0) {
                                eVar8.L.a(eVar6.L, 0);
                            } else if (r2 == 1) {
                                eVar8.J.a(eVar6.J, 0);
                            } else if (r2 == 2) {
                                eVar8.J.a(eVar6.J, 0);
                                eVar8.L.a(eVar6.L, 0);
                            }
                        } else {
                            int r3 = g.this.aV;
                            if (r3 == 0) {
                                eVar8.J.a(eVar6.J, 0);
                            } else if (r3 == 1) {
                                eVar8.L.a(eVar6.L, 0);
                            } else if (r3 == 2) {
                                if (z3) {
                                    eVar8.J.a(this.j, this.n);
                                    eVar8.L.a(this.l, this.p);
                                } else {
                                    eVar8.J.a(eVar6.J, 0);
                                    eVar8.L.a(eVar6.L, 0);
                                }
                            }
                            i15++;
                            eVar7 = eVar8;
                        }
                    }
                    i15++;
                    eVar7 = eVar8;
                }
            }
        }

        public final void a(int i2) {
            int i3 = this.f2117g;
            if (i3 != 0) {
                int i4 = this.f2116f;
                int i5 = i2 / i3;
                int i6 = 0;
                while (i6 < i4 && this.f2115e + i6 < g.this.bs) {
                    e eVar = g.this.br[this.f2115e + i6];
                    if (this.f2119i == 0) {
                        if (eVar != null && eVar.U[0] == e.a.MATCH_CONSTRAINT && eVar.p == 0) {
                            g.this.a(eVar, e.a.FIXED, i5, eVar.U[1], eVar.o());
                        }
                    } else if (eVar != null && eVar.U[1] == e.a.MATCH_CONSTRAINT && eVar.q == 0) {
                        g.this.a(eVar, eVar.U[0], eVar.n(), e.a.FIXED, i5);
                    }
                    i6++;
                }
                this.f2113c = 0;
                this.f2114d = 0;
                this.f2111a = null;
                this.f2112b = 0;
                int i7 = this.f2116f;
                int i8 = 0;
                while (i8 < i7 && this.f2115e + i8 < g.this.bs) {
                    e eVar2 = g.this.br[this.f2115e + i8];
                    if (this.f2119i == 0) {
                        int n2 = eVar2.n();
                        int a2 = g.this.aT;
                        if (eVar2.an == 8) {
                            a2 = 0;
                        }
                        this.f2113c += n2 + a2;
                        int b2 = g.this.b(eVar2, this.r);
                        if (this.f2111a == null || this.f2112b < b2) {
                            this.f2111a = eVar2;
                            this.f2112b = b2;
                            this.f2114d = b2;
                        }
                    } else {
                        int a3 = g.this.a(eVar2, this.r);
                        int b3 = g.this.b(eVar2, this.r);
                        int b4 = g.this.aU;
                        if (eVar2.an == 8) {
                            b4 = 0;
                        }
                        this.f2114d += b3 + b4;
                        if (this.f2111a == null || this.f2112b < a3) {
                            this.f2111a = eVar2;
                            this.f2112b = a3;
                            this.f2113c = a3;
                        }
                    }
                    i8++;
                }
            }
        }
    }

    public final void a(d dVar, boolean z) {
        boolean z2;
        e eVar;
        super.a(dVar, z);
        if (this.V != null) {
            z2 = ((f) this.V).f2106d;
        } else {
            z2 = false;
        }
        int i2 = this.aX;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = this.bn.size();
                int i3 = 0;
                while (i3 < size) {
                    this.bn.get(i3).a(z2, i3, i3 == size + -1);
                    i3++;
                }
            } else if (!(i2 != 2 || this.bq == null || this.bp == null || this.bo == null)) {
                for (int i4 = 0; i4 < this.bs; i4++) {
                    this.br[i4].u();
                }
                int[] iArr = this.bq;
                int i5 = iArr[0];
                int i6 = iArr[1];
                e eVar2 = null;
                for (int i7 = 0; i7 < i5; i7++) {
                    e eVar3 = this.bp[z2 ? (i5 - i7) - 1 : i7];
                    if (!(eVar3 == null || eVar3.an == 8)) {
                        if (i7 == 0) {
                            eVar3.a(eVar3.J, this.J, this.bg);
                            eVar3.aA = this.f2107a;
                            eVar3.ak = this.aN;
                        }
                        if (i7 == i5 - 1) {
                            eVar3.a(eVar3.L, this.L, this.bh);
                        }
                        if (i7 > 0) {
                            eVar3.a(eVar3.J, eVar2.L, this.aT);
                            eVar2.a(eVar2.L, eVar3.J, 0);
                        }
                        eVar2 = eVar3;
                    }
                }
                for (int i8 = 0; i8 < i6; i8++) {
                    e eVar4 = this.bo[i8];
                    if (!(eVar4 == null || eVar4.an == 8)) {
                        if (i8 == 0) {
                            eVar4.a(eVar4.K, this.K, this.bc);
                            eVar4.aB = this.f2108b;
                            eVar4.al = this.aO;
                        }
                        if (i8 == i6 - 1) {
                            eVar4.a(eVar4.M, this.M, this.bd);
                        }
                        if (i8 > 0) {
                            eVar4.a(eVar4.K, eVar2.M, this.aU);
                            eVar2.a(eVar2.M, eVar4.K, 0);
                        }
                        eVar2 = eVar4;
                    }
                }
                for (int i9 = 0; i9 < i5; i9++) {
                    for (int i10 = 0; i10 < i6; i10++) {
                        int i11 = (i10 * i5) + i9;
                        if (this.aZ == 1) {
                            i11 = (i9 * i6) + i10;
                        }
                        e[] eVarArr = this.br;
                        if (!(i11 >= eVarArr.length || (eVar = eVarArr[i11]) == null || eVar.an == 8)) {
                            e eVar5 = this.bp[i9];
                            e eVar6 = this.bo[i10];
                            if (eVar != eVar5) {
                                eVar.a(eVar.J, eVar5.J, 0);
                                eVar.a(eVar.L, eVar5.L, 0);
                            }
                            if (eVar != eVar6) {
                                eVar.a(eVar.K, eVar6.K, 0);
                                eVar.a(eVar.M, eVar6.M, 0);
                            }
                        }
                    }
                }
            }
        } else if (this.bn.size() > 0) {
            this.bn.get(0).a(z2, 0, true);
        }
        this.bi = false;
    }

    /* access modifiers changed from: private */
    public final int a(e eVar, int i2) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.U[0] == e.a.MATCH_CONSTRAINT) {
            if (eVar.p == 0) {
                return 0;
            }
            if (eVar.p == 2) {
                int i3 = (int) (eVar.u * ((float) i2));
                if (i3 != eVar.n()) {
                    eVar.m = true;
                    a(eVar, e.a.FIXED, i3, eVar.U[1], eVar.o());
                }
                return i3;
            } else if (eVar.p == 1) {
                return eVar.n();
            } else {
                if (eVar.p == 3) {
                    return (int) ((((float) eVar.o()) * eVar.Y) + 0.5f);
                }
            }
        }
        return eVar.n();
    }

    /* access modifiers changed from: private */
    public final int b(e eVar, int i2) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.U[1] == e.a.MATCH_CONSTRAINT) {
            if (eVar.q == 0) {
                return 0;
            }
            if (eVar.q == 2) {
                int i3 = (int) (eVar.x * ((float) i2));
                if (i3 != eVar.o()) {
                    eVar.m = true;
                    a(eVar, eVar.U[0], eVar.n(), e.a.FIXED, i3);
                }
                return i3;
            } else if (eVar.q == 1) {
                return eVar.o();
            } else {
                if (eVar.q == 3) {
                    return (int) ((((float) eVar.n()) * eVar.Y) + 0.5f);
                }
            }
        }
        return eVar.o();
    }
}
