package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.a.c;
import androidx.constraintlayout.a.a.a.l;
import androidx.constraintlayout.a.a.a.n;
import androidx.constraintlayout.a.a.a.p;
import androidx.constraintlayout.a.a.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class e {
    public static float aj = 0.5f;
    int A = -1;
    float B = 1.0f;
    public int[] C = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float D = 0.0f;
    public boolean E = false;
    public boolean F;
    public boolean G = false;
    public int H = 0;
    public int I = 0;
    public d J = new d(this, d.a.LEFT);
    public d K = new d(this, d.a.TOP);
    public d L = new d(this, d.a.RIGHT);
    public d M = new d(this, d.a.BOTTOM);
    public d N = new d(this, d.a.BASELINE);
    d O = new d(this, d.a.CENTER_X);
    d P = new d(this, d.a.CENTER_Y);
    public d Q = new d(this, d.a.CENTER);
    public d[] R = {this.J, this.L, this.K, this.M, this.N, this.Q};
    protected ArrayList<d> S = new ArrayList<>();
    boolean[] T = new boolean[2];
    public a[] U = {a.FIXED, a.FIXED};
    public e V = null;
    int W = 0;
    int X = 0;
    public float Y = 0.0f;
    protected int Z = -1;

    /* renamed from: a  reason: collision with root package name */
    private boolean f2092a = false;
    public int aA;
    public int aB;
    boolean aC;
    boolean aD;
    public float[] aE;
    protected e[] aF;
    protected e[] aG;
    e aH;
    e aI;
    public int aJ;
    public int aK;
    private int aL;
    private String aM;
    protected int aa = 0;
    protected int ab = 0;
    int ac = 0;
    int ad = 0;
    protected int ae = 0;
    protected int af = 0;
    public int ag = 0;
    protected int ah;
    protected int ai;
    public float ak;
    public float al;
    public Object am;
    public int an;
    public String ao;
    int ap;
    int aq;
    int ar;
    int as;
    boolean at;
    boolean au;
    boolean av;
    boolean aw;
    boolean ax;
    boolean ay;
    boolean az;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2093b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2094c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2095d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2096e = false;

    /* renamed from: f  reason: collision with root package name */
    public p[] f2097f = new p[2];

    /* renamed from: g  reason: collision with root package name */
    public c f2098g;

    /* renamed from: h  reason: collision with root package name */
    public c f2099h;

    /* renamed from: i  reason: collision with root package name */
    public l f2100i = null;
    public n j = null;
    public boolean[] k = {true, true};
    boolean l = false;
    boolean m = true;
    public int n = -1;
    public int o = -1;
    public int p = 0;
    public int q = 0;
    public int[] r = new int[2];
    public int s = 0;
    public int t = 0;
    public float u = 1.0f;
    public int v = 0;
    public int w = 0;
    public float x = 1.0f;
    public boolean y;
    public boolean z;

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public final p a(int i2) {
        if (i2 == 0) {
            return this.f2100i;
        }
        if (i2 == 1) {
            return this.j;
        }
        return null;
    }

    public final void f() {
        this.J.a(0);
        this.aa = 0;
    }

    public final void c_() {
        this.K.a(0);
        this.ab = 0;
    }

    public final void a(int i2, int i3) {
        this.J.a(i2);
        this.L.a(i3);
        this.aa = i2;
        this.W = i3 - i2;
        this.f2094c = true;
    }

    public final void b(int i2, int i3) {
        this.K.a(i2);
        this.M.a(i3);
        this.ab = i2;
        this.X = i3 - i2;
        if (this.E) {
            this.N.a(i2 + this.ag);
        }
        this.f2095d = true;
    }

    public final void b(int i2) {
        if (this.E) {
            int i3 = i2 - this.ag;
            int i4 = this.X + i3;
            this.ab = i3;
            this.K.a(i3);
            this.M.a(i4);
            this.N.a(i2);
            this.f2095d = true;
        }
    }

    public boolean b() {
        if (!this.f2094c) {
            return this.J.f2084c && this.L.f2084c;
        }
        return true;
    }

    public boolean c() {
        if (!this.f2095d) {
            return this.K.f2084c && this.M.f2084c;
        }
        return true;
    }

    public final void h() {
        this.f2094c = false;
        this.f2095d = false;
        int size = this.S.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = this.S.get(i2);
            dVar.f2084c = false;
            dVar.f2083b = 0;
        }
    }

    public final boolean c(int i2) {
        if (i2 == 0) {
            return (this.J.f2087f != null ? 1 : 0) + (this.L.f2087f != null ? 1 : 0) < 2;
        }
        return ((this.K.f2087f != null ? 1 : 0) + (this.M.f2087f != null ? 1 : 0)) + (this.N.f2087f != null ? 1 : 0) < 2;
    }

    public final boolean i() {
        return this.m && this.an != 8;
    }

    public final void c(int i2, int i3) {
        this.H = i2;
        this.I = i3;
        this.m = false;
    }

    public void j() {
        this.J.f();
        this.K.f();
        this.L.f();
        this.M.f();
        this.N.f();
        this.O.f();
        this.P.f();
        this.Q.f();
        this.V = null;
        this.D = 0.0f;
        this.W = 0;
        this.X = 0;
        this.Y = 0.0f;
        this.Z = -1;
        this.aa = 0;
        this.ab = 0;
        this.ae = 0;
        this.af = 0;
        this.ag = 0;
        this.ah = 0;
        this.ai = 0;
        float f2 = aj;
        this.ak = f2;
        this.al = f2;
        this.U[0] = a.FIXED;
        this.U[1] = a.FIXED;
        this.am = null;
        this.aL = 0;
        this.an = 0;
        this.aM = null;
        this.ax = false;
        this.ay = false;
        this.aA = 0;
        this.aB = 0;
        this.aC = false;
        this.aD = false;
        float[] fArr = this.aE;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.n = -1;
        this.o = -1;
        int[] iArr = this.C;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.p = 0;
        this.q = 0;
        this.u = 1.0f;
        this.x = 1.0f;
        this.t = Integer.MAX_VALUE;
        this.w = Integer.MAX_VALUE;
        this.s = 0;
        this.v = 0;
        this.l = false;
        this.A = -1;
        this.B = 1.0f;
        this.az = false;
        boolean[] zArr = this.k;
        zArr[0] = true;
        zArr[1] = true;
        this.G = false;
        boolean[] zArr2 = this.T;
        zArr2[0] = false;
        zArr2[1] = false;
        this.m = true;
    }

    public e() {
        float f2 = aj;
        this.ak = f2;
        this.al = f2;
        this.aL = 0;
        this.an = 0;
        this.ao = null;
        this.aM = null;
        this.az = false;
        this.aA = 0;
        this.aB = 0;
        this.aE = new float[]{-1.0f, -1.0f};
        this.aF = new e[]{null, null};
        this.aG = new e[]{null, null};
        this.aH = null;
        this.aI = null;
        this.aJ = -1;
        this.aK = -1;
        this.S.add(this.J);
        this.S.add(this.K);
        this.S.add(this.L);
        this.S.add(this.M);
        this.S.add(this.O);
        this.S.add(this.P);
        this.S.add(this.Q);
        this.S.add(this.N);
    }

    public final void k() {
        if (this.f2100i == null) {
            this.f2100i = new l(this);
        }
        if (this.j == null) {
            this.j = new n(this);
        }
    }

    public void a(androidx.constraintlayout.a.c cVar) {
        this.J.d();
        this.K.d();
        this.L.d();
        this.M.d();
        this.N.d();
        this.Q.d();
        this.O.d();
        this.P.d();
    }

    public final void a(androidx.constraintlayout.a.d dVar) {
        dVar.a((Object) this.J);
        dVar.a((Object) this.K);
        dVar.a((Object) this.L);
        dVar.a((Object) this.M);
        if (this.ag > 0) {
            dVar.a((Object) this.N);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.aM != null) {
            str = "type: " + this.aM + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.ao != null) {
            str2 = "id: " + this.ao + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.aa);
        sb.append(", ");
        sb.append(this.ab);
        sb.append(") - (");
        sb.append(this.W);
        sb.append(" x ");
        sb.append(this.X);
        sb.append(")");
        return sb.toString();
    }

    public final int l() {
        e eVar = this.V;
        if (eVar == null || !(eVar instanceof f)) {
            return this.aa;
        }
        return ((f) eVar).aN + this.aa;
    }

    public final int m() {
        e eVar = this.V;
        if (eVar == null || !(eVar instanceof f)) {
            return this.ab;
        }
        return ((f) eVar).aO + this.ab;
    }

    public final int n() {
        if (this.an == 8) {
            return 0;
        }
        return this.W;
    }

    public final int o() {
        if (this.an == 8) {
            return 0;
        }
        return this.X;
    }

    public final int p() {
        return this.ah;
    }

    public final int q() {
        return this.ai;
    }

    public final int r() {
        return l() + this.W;
    }

    public final int s() {
        return m() + this.X;
    }

    public final float d(int i2) {
        if (i2 == 0) {
            return this.ak;
        }
        if (i2 == 1) {
            return this.al;
        }
        return -1.0f;
    }

    public final void e(int i2) {
        this.aa = i2;
    }

    public final void f(int i2) {
        this.ab = i2;
    }

    public final void d(int i2, int i3) {
        this.aa = i2;
        this.ab = i3;
    }

    public final void g(int i2) {
        this.W = i2;
        int i3 = this.W;
        int i4 = this.ah;
        if (i3 < i4) {
            this.W = i4;
        }
    }

    public final void h(int i2) {
        this.X = i2;
        int i3 = this.X;
        int i4 = this.ai;
        if (i3 < i4) {
            this.X = i4;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x008e
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0037
            int r6 = r2 + -1
            if (r3 >= r6) goto L_0x0037
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002c
            r1 = 0
            goto L_0x0035
        L_0x002c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0035
            r1 = 1
        L_0x0035:
            int r4 = r3 + 1
        L_0x0037:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L_0x0075
            int r2 = r2 - r5
            if (r3 >= r2) goto L_0x0075
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0084
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0084
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            if (r1 != r5) goto L_0x006f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x006f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0075:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0084
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = 0
        L_0x0085:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r8.Y = r9
            r8.Z = r1
        L_0x008d:
            return
        L_0x008e:
            r8.Y = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.e.a(java.lang.String):void");
    }

    public final int t() {
        return this.Z;
    }

    public final void i(int i2) {
        if (i2 < 0) {
            this.ah = 0;
        } else {
            this.ah = i2;
        }
    }

    public final void j(int i2) {
        if (i2 < 0) {
            this.ai = 0;
        } else {
            this.ai = i2;
        }
    }

    public final void e(int i2, int i3) {
        this.aa = i2;
        this.W = i3 - i2;
        int i4 = this.W;
        int i5 = this.ah;
        if (i4 < i5) {
            this.W = i5;
        }
    }

    public final void f(int i2, int i3) {
        this.ab = i2;
        this.X = i3 - i2;
        int i4 = this.X;
        int i5 = this.ai;
        if (i4 < i5) {
            this.X = i5;
        }
    }

    public final void k(int i2) {
        this.ag = i2;
        this.E = i2 > 0;
    }

    public boolean a() {
        return this.an != 8;
    }

    public final void a(d.a aVar, e eVar, d.a aVar2, int i2, int i3) {
        a(aVar).a(eVar.a(aVar2), i2, i3, true);
    }

    private void a(d.a aVar, e eVar, d.a aVar2, int i2) {
        boolean z2;
        if (aVar == d.a.CENTER) {
            if (aVar2 == d.a.CENTER) {
                d a2 = a(d.a.LEFT);
                d a3 = a(d.a.RIGHT);
                d a4 = a(d.a.TOP);
                d a5 = a(d.a.BOTTOM);
                boolean z3 = true;
                if ((a2 == null || !a2.g()) && (a3 == null || !a3.g())) {
                    a(d.a.LEFT, eVar, d.a.LEFT, 0);
                    a(d.a.RIGHT, eVar, d.a.RIGHT, 0);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((a4 == null || !a4.g()) && (a5 == null || !a5.g())) {
                    a(d.a.TOP, eVar, d.a.TOP, 0);
                    a(d.a.BOTTOM, eVar, d.a.BOTTOM, 0);
                } else {
                    z3 = false;
                }
                if (z2 && z3) {
                    a(d.a.CENTER).a(eVar.a(d.a.CENTER), 0);
                } else if (z2) {
                    a(d.a.CENTER_X).a(eVar.a(d.a.CENTER_X), 0);
                } else if (z3) {
                    a(d.a.CENTER_Y).a(eVar.a(d.a.CENTER_Y), 0);
                }
            } else if (aVar2 == d.a.LEFT || aVar2 == d.a.RIGHT) {
                a(d.a.LEFT, eVar, aVar2, 0);
                a(d.a.RIGHT, eVar, aVar2, 0);
                a(d.a.CENTER).a(eVar.a(aVar2), 0);
            } else if (aVar2 == d.a.TOP || aVar2 == d.a.BOTTOM) {
                a(d.a.TOP, eVar, aVar2, 0);
                a(d.a.BOTTOM, eVar, aVar2, 0);
                a(d.a.CENTER).a(eVar.a(aVar2), 0);
            }
        } else if (aVar == d.a.CENTER_X && (aVar2 == d.a.LEFT || aVar2 == d.a.RIGHT)) {
            d a6 = a(d.a.LEFT);
            d a7 = eVar.a(aVar2);
            d a8 = a(d.a.RIGHT);
            a6.a(a7, 0);
            a8.a(a7, 0);
            a(d.a.CENTER_X).a(a7, 0);
        } else if (aVar == d.a.CENTER_Y && (aVar2 == d.a.TOP || aVar2 == d.a.BOTTOM)) {
            d a9 = eVar.a(aVar2);
            a(d.a.TOP).a(a9, 0);
            a(d.a.BOTTOM).a(a9, 0);
            a(d.a.CENTER_Y).a(a9, 0);
        } else if (aVar == d.a.CENTER_X && aVar2 == d.a.CENTER_X) {
            a(d.a.LEFT).a(eVar.a(d.a.LEFT), 0);
            a(d.a.RIGHT).a(eVar.a(d.a.RIGHT), 0);
            a(d.a.CENTER_X).a(eVar.a(aVar2), 0);
        } else if (aVar == d.a.CENTER_Y && aVar2 == d.a.CENTER_Y) {
            a(d.a.TOP).a(eVar.a(d.a.TOP), 0);
            a(d.a.BOTTOM).a(eVar.a(d.a.BOTTOM), 0);
            a(d.a.CENTER_Y).a(eVar.a(aVar2), 0);
        } else {
            d a10 = a(aVar);
            d a11 = eVar.a(aVar2);
            if (a10.a(a11)) {
                if (aVar == d.a.BASELINE) {
                    d a12 = a(d.a.TOP);
                    d a13 = a(d.a.BOTTOM);
                    if (a12 != null) {
                        a12.f();
                    }
                    if (a13 != null) {
                        a13.f();
                    }
                    i2 = 0;
                } else if (aVar == d.a.TOP || aVar == d.a.BOTTOM) {
                    d a14 = a(d.a.BASELINE);
                    if (a14 != null) {
                        a14.f();
                    }
                    d a15 = a(d.a.CENTER);
                    if (a15.f2087f != a11) {
                        a15.f();
                    }
                    d h2 = a(aVar).h();
                    d a16 = a(d.a.CENTER_Y);
                    if (a16.g()) {
                        h2.f();
                        a16.f();
                    }
                } else if (aVar == d.a.LEFT || aVar == d.a.RIGHT) {
                    d a17 = a(d.a.CENTER);
                    if (a17.f2087f != a11) {
                        a17.f();
                    }
                    d h3 = a(aVar).h();
                    d a18 = a(d.a.CENTER_X);
                    if (a18.g()) {
                        h3.f();
                        a18.f();
                    }
                }
                a10.a(a11, i2);
            }
        }
    }

    public final void u() {
        int size = this.S.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.S.get(i2).f();
        }
    }

    public d a(d.a aVar) {
        switch (aVar) {
            case LEFT:
                return this.J;
            case TOP:
                return this.K;
            case RIGHT:
                return this.L;
            case BOTTOM:
                return this.M;
            case BASELINE:
                return this.N;
            case CENTER:
                return this.Q;
            case CENTER_X:
                return this.O;
            case CENTER_Y:
                return this.P;
            case NONE:
                return null;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public final boolean v() {
        if (this.J.f2087f == null || this.J.f2087f.f2087f != this.J) {
            return this.L.f2087f != null && this.L.f2087f.f2087f == this.L;
        }
        return true;
    }

    public final e m(int i2) {
        d dVar;
        d dVar2;
        if (i2 == 0) {
            if (this.J.f2087f == null || this.J.f2087f.f2087f != (dVar2 = this.J)) {
                return null;
            }
            return dVar2.f2087f.f2085d;
        } else if (i2 == 1 && this.K.f2087f != null && this.K.f2087f.f2087f == (dVar = this.K)) {
            return dVar.f2087f.f2085d;
        } else {
            return null;
        }
    }

    public final e n(int i2) {
        d dVar;
        d dVar2;
        if (i2 == 0) {
            if (this.L.f2087f == null || this.L.f2087f.f2087f != (dVar2 = this.L)) {
                return null;
            }
            return dVar2.f2087f.f2085d;
        } else if (i2 == 1 && this.M.f2087f != null && this.M.f2087f.f2087f == (dVar = this.M)) {
            return dVar.f2087f.f2085d;
        } else {
            return null;
        }
    }

    public final boolean w() {
        if (this.K.f2087f == null || this.K.f2087f.f2087f != this.K) {
            return this.M.f2087f != null && this.M.f2087f.f2087f == this.M;
        }
        return true;
    }

    private boolean o(int i2) {
        int i3 = i2 * 2;
        if (this.R[i3].f2087f == null) {
            return false;
        }
        d dVar = this.R[i3].f2087f.f2087f;
        d[] dVarArr = this.R;
        if (dVar == dVarArr[i3]) {
            return false;
        }
        int i4 = i3 + 1;
        return dVarArr[i4].f2087f != null && this.R[i4].f2087f.f2087f == this.R[i4];
    }

    /* JADX WARNING: Removed duplicated region for block: B:255:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x03ff  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0434  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0525  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0580  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0587  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0610  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0613  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0653  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x065b  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0687  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.a.d r52, boolean r53) {
        /*
            r51 = this;
            r15 = r51
            r14 = r52
            androidx.constraintlayout.a.a.d r0 = r15.J
            androidx.constraintlayout.a.h r13 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.a.a.d r0 = r15.L
            androidx.constraintlayout.a.h r12 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.a.a.d r0 = r15.K
            androidx.constraintlayout.a.h r11 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.a.a.d r0 = r15.M
            androidx.constraintlayout.a.h r10 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.a.a.d r0 = r15.N
            androidx.constraintlayout.a.h r9 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.a.a.e r0 = r15.V
            r8 = 1
            r7 = 0
            if (r0 == 0) goto L_0x0049
            if (r0 == 0) goto L_0x0034
            androidx.constraintlayout.a.a.e$a[] r0 = r0.U
            r0 = r0[r7]
            androidx.constraintlayout.a.a.e$a r1 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r0 != r1) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            androidx.constraintlayout.a.a.e r1 = r15.V
            if (r1 == 0) goto L_0x0043
            androidx.constraintlayout.a.a.e$a[] r1 = r1.U
            r1 = r1[r8]
            androidx.constraintlayout.a.a.e$a r2 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r1 != r2) goto L_0x0043
            r1 = 1
            goto L_0x0044
        L_0x0043:
            r1 = 0
        L_0x0044:
            r28 = r0
            r29 = r1
            goto L_0x004d
        L_0x0049:
            r28 = 0
            r29 = 0
        L_0x004d:
            int r0 = r15.an
            r6 = 8
            if (r0 != r6) goto L_0x007d
            java.util.ArrayList<androidx.constraintlayout.a.a.d> r0 = r15.S
            int r0 = r0.size()
            r1 = 0
        L_0x005a:
            if (r1 >= r0) goto L_0x006f
            java.util.ArrayList<androidx.constraintlayout.a.a.d> r2 = r15.S
            java.lang.Object r2 = r2.get(r1)
            androidx.constraintlayout.a.a.d r2 = (androidx.constraintlayout.a.a.d) r2
            boolean r2 = r2.a()
            if (r2 == 0) goto L_0x006c
            r0 = 1
            goto L_0x0070
        L_0x006c:
            int r1 = r1 + 1
            goto L_0x005a
        L_0x006f:
            r0 = 0
        L_0x0070:
            if (r0 != 0) goto L_0x007d
            boolean[] r0 = r15.T
            boolean r1 = r0[r7]
            if (r1 != 0) goto L_0x007d
            boolean r0 = r0[r8]
            if (r0 != 0) goto L_0x007d
            return
        L_0x007d:
            boolean r0 = r15.f2094c
            r5 = 5
            if (r0 != 0) goto L_0x0086
            boolean r0 = r15.f2095d
            if (r0 == 0) goto L_0x0105
        L_0x0086:
            boolean r0 = r15.f2094c
            if (r0 == 0) goto L_0x00b7
            int r0 = r15.aa
            r14.a(r13, r0)
            int r0 = r15.aa
            int r1 = r15.W
            int r0 = r0 + r1
            r14.a(r12, r0)
            if (r28 == 0) goto L_0x00b7
            androidx.constraintlayout.a.a.e r0 = r15.V
            if (r0 == 0) goto L_0x00b7
            boolean r1 = r15.f2093b
            if (r1 == 0) goto L_0x00ae
            androidx.constraintlayout.a.a.f r0 = (androidx.constraintlayout.a.a.f) r0
            androidx.constraintlayout.a.a.d r1 = r15.J
            r0.a((androidx.constraintlayout.a.a.d) r1)
            androidx.constraintlayout.a.a.d r1 = r15.L
            r0.d((androidx.constraintlayout.a.a.d) r1)
            goto L_0x00b7
        L_0x00ae:
            androidx.constraintlayout.a.a.d r0 = r0.L
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r14.a((androidx.constraintlayout.a.h) r0, (androidx.constraintlayout.a.h) r12, (int) r7, (int) r5)
        L_0x00b7:
            boolean r0 = r15.f2095d
            if (r0 == 0) goto L_0x00f8
            int r0 = r15.ab
            r14.a(r11, r0)
            int r0 = r15.ab
            int r1 = r15.X
            int r0 = r0 + r1
            r14.a(r10, r0)
            androidx.constraintlayout.a.a.d r0 = r15.N
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x00d8
            int r0 = r15.ab
            int r1 = r15.ag
            int r0 = r0 + r1
            r14.a(r9, r0)
        L_0x00d8:
            if (r29 == 0) goto L_0x00f8
            androidx.constraintlayout.a.a.e r0 = r15.V
            if (r0 == 0) goto L_0x00f8
            boolean r1 = r15.f2093b
            if (r1 == 0) goto L_0x00ef
            androidx.constraintlayout.a.a.f r0 = (androidx.constraintlayout.a.a.f) r0
            androidx.constraintlayout.a.a.d r1 = r15.K
            r0.a((androidx.constraintlayout.a.a.d) r1)
            androidx.constraintlayout.a.a.d r1 = r15.M
            r0.c((androidx.constraintlayout.a.a.d) r1)
            goto L_0x00f8
        L_0x00ef:
            androidx.constraintlayout.a.a.d r0 = r0.M
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r14.a((androidx.constraintlayout.a.h) r0, (androidx.constraintlayout.a.h) r10, (int) r7, (int) r5)
        L_0x00f8:
            boolean r0 = r15.f2094c
            if (r0 == 0) goto L_0x0105
            boolean r0 = r15.f2095d
            if (r0 == 0) goto L_0x0105
            r15.f2094c = r7
            r15.f2095d = r7
            return
        L_0x0105:
            androidx.constraintlayout.a.e r0 = androidx.constraintlayout.a.d.o
            r1 = 1
            if (r0 == 0) goto L_0x0112
            androidx.constraintlayout.a.e r0 = androidx.constraintlayout.a.d.o
            long r3 = r0.y
            long r3 = r3 + r1
            r0.y = r3
        L_0x0112:
            if (r53 == 0) goto L_0x01ad
            androidx.constraintlayout.a.a.a.l r0 = r15.f2100i
            if (r0 == 0) goto L_0x01ad
            androidx.constraintlayout.a.a.a.n r3 = r15.j
            if (r3 == 0) goto L_0x01ad
            androidx.constraintlayout.a.a.a.f r0 = r0.j
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x01ad
            androidx.constraintlayout.a.a.a.l r0 = r15.f2100i
            androidx.constraintlayout.a.a.a.f r0 = r0.k
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x01ad
            androidx.constraintlayout.a.a.a.n r0 = r15.j
            androidx.constraintlayout.a.a.a.f r0 = r0.j
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x01ad
            androidx.constraintlayout.a.a.a.n r0 = r15.j
            androidx.constraintlayout.a.a.a.f r0 = r0.k
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x01ad
            androidx.constraintlayout.a.e r0 = androidx.constraintlayout.a.d.o
            if (r0 == 0) goto L_0x0145
            androidx.constraintlayout.a.e r0 = androidx.constraintlayout.a.d.o
            long r3 = r0.r
            long r3 = r3 + r1
            r0.r = r3
        L_0x0145:
            androidx.constraintlayout.a.a.a.l r0 = r15.f2100i
            androidx.constraintlayout.a.a.a.f r0 = r0.j
            int r0 = r0.f2033g
            r14.a(r13, r0)
            androidx.constraintlayout.a.a.a.l r0 = r15.f2100i
            androidx.constraintlayout.a.a.a.f r0 = r0.k
            int r0 = r0.f2033g
            r14.a(r12, r0)
            androidx.constraintlayout.a.a.a.n r0 = r15.j
            androidx.constraintlayout.a.a.a.f r0 = r0.j
            int r0 = r0.f2033g
            r14.a(r11, r0)
            androidx.constraintlayout.a.a.a.n r0 = r15.j
            androidx.constraintlayout.a.a.a.f r0 = r0.k
            int r0 = r0.f2033g
            r14.a(r10, r0)
            androidx.constraintlayout.a.a.a.n r0 = r15.j
            androidx.constraintlayout.a.a.a.f r0 = r0.f2047a
            int r0 = r0.f2033g
            r14.a(r9, r0)
            androidx.constraintlayout.a.a.e r0 = r15.V
            if (r0 == 0) goto L_0x01a8
            if (r28 == 0) goto L_0x018f
            boolean[] r0 = r15.k
            boolean r0 = r0[r7]
            if (r0 == 0) goto L_0x018f
            boolean r0 = r51.v()
            if (r0 != 0) goto L_0x018f
            androidx.constraintlayout.a.a.e r0 = r15.V
            androidx.constraintlayout.a.a.d r0 = r0.L
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r14.a((androidx.constraintlayout.a.h) r0, (androidx.constraintlayout.a.h) r12, (int) r7, (int) r6)
        L_0x018f:
            if (r29 == 0) goto L_0x01a8
            boolean[] r0 = r15.k
            boolean r0 = r0[r8]
            if (r0 == 0) goto L_0x01a8
            boolean r0 = r51.w()
            if (r0 != 0) goto L_0x01a8
            androidx.constraintlayout.a.a.e r0 = r15.V
            androidx.constraintlayout.a.a.d r0 = r0.M
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r14.a((androidx.constraintlayout.a.h) r0, (androidx.constraintlayout.a.h) r10, (int) r7, (int) r6)
        L_0x01a8:
            r15.f2094c = r7
            r15.f2095d = r7
            return
        L_0x01ad:
            androidx.constraintlayout.a.e r0 = androidx.constraintlayout.a.d.o
            if (r0 == 0) goto L_0x01b8
            androidx.constraintlayout.a.e r0 = androidx.constraintlayout.a.d.o
            long r3 = r0.s
            long r3 = r3 + r1
            r0.s = r3
        L_0x01b8:
            androidx.constraintlayout.a.a.e r0 = r15.V
            if (r0 == 0) goto L_0x0229
            boolean r0 = r15.o(r7)
            if (r0 == 0) goto L_0x01cb
            androidx.constraintlayout.a.a.e r0 = r15.V
            androidx.constraintlayout.a.a.f r0 = (androidx.constraintlayout.a.a.f) r0
            r0.a((androidx.constraintlayout.a.a.e) r15, (int) r7)
            r0 = 1
            goto L_0x01cf
        L_0x01cb:
            boolean r0 = r51.v()
        L_0x01cf:
            boolean r1 = r15.o(r8)
            if (r1 == 0) goto L_0x01de
            androidx.constraintlayout.a.a.e r1 = r15.V
            androidx.constraintlayout.a.a.f r1 = (androidx.constraintlayout.a.a.f) r1
            r1.a((androidx.constraintlayout.a.a.e) r15, (int) r8)
            r1 = 1
            goto L_0x01e2
        L_0x01de:
            boolean r1 = r51.w()
        L_0x01e2:
            if (r0 != 0) goto L_0x0201
            if (r28 == 0) goto L_0x0201
            int r2 = r15.an
            if (r2 == r6) goto L_0x0201
            androidx.constraintlayout.a.a.d r2 = r15.J
            androidx.constraintlayout.a.a.d r2 = r2.f2087f
            if (r2 != 0) goto L_0x0201
            androidx.constraintlayout.a.a.d r2 = r15.L
            androidx.constraintlayout.a.a.d r2 = r2.f2087f
            if (r2 != 0) goto L_0x0201
            androidx.constraintlayout.a.a.e r2 = r15.V
            androidx.constraintlayout.a.a.d r2 = r2.L
            androidx.constraintlayout.a.h r2 = r14.a((java.lang.Object) r2)
            r14.a((androidx.constraintlayout.a.h) r2, (androidx.constraintlayout.a.h) r12, (int) r7, (int) r8)
        L_0x0201:
            if (r1 != 0) goto L_0x0224
            if (r29 == 0) goto L_0x0224
            int r2 = r15.an
            if (r2 == r6) goto L_0x0224
            androidx.constraintlayout.a.a.d r2 = r15.K
            androidx.constraintlayout.a.a.d r2 = r2.f2087f
            if (r2 != 0) goto L_0x0224
            androidx.constraintlayout.a.a.d r2 = r15.M
            androidx.constraintlayout.a.a.d r2 = r2.f2087f
            if (r2 != 0) goto L_0x0224
            androidx.constraintlayout.a.a.d r2 = r15.N
            if (r2 != 0) goto L_0x0224
            androidx.constraintlayout.a.a.e r2 = r15.V
            androidx.constraintlayout.a.a.d r2 = r2.M
            androidx.constraintlayout.a.h r2 = r14.a((java.lang.Object) r2)
            r14.a((androidx.constraintlayout.a.h) r2, (androidx.constraintlayout.a.h) r10, (int) r7, (int) r8)
        L_0x0224:
            r30 = r0
            r31 = r1
            goto L_0x022d
        L_0x0229:
            r30 = 0
            r31 = 0
        L_0x022d:
            int r0 = r15.W
            int r1 = r15.ah
            if (r0 >= r1) goto L_0x0234
            r0 = r1
        L_0x0234:
            int r1 = r15.X
            int r2 = r15.ai
            if (r1 >= r2) goto L_0x023b
            r1 = r2
        L_0x023b:
            androidx.constraintlayout.a.a.e$a[] r2 = r15.U
            r2 = r2[r7]
            androidx.constraintlayout.a.a.e$a r3 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r2 == r3) goto L_0x0245
            r2 = 1
            goto L_0x0246
        L_0x0245:
            r2 = 0
        L_0x0246:
            androidx.constraintlayout.a.a.e$a[] r3 = r15.U
            r3 = r3[r8]
            androidx.constraintlayout.a.a.e$a r4 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r3 == r4) goto L_0x0250
            r3 = 1
            goto L_0x0251
        L_0x0250:
            r3 = 0
        L_0x0251:
            int r4 = r15.Z
            r15.A = r4
            float r4 = r15.Y
            r15.B = r4
            int r5 = r15.p
            int r8 = r15.q
            r18 = 0
            r19 = 4
            int r4 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r4 <= 0) goto L_0x03bd
            int r4 = r15.an
            if (r4 == r6) goto L_0x03bd
            androidx.constraintlayout.a.a.e$a[] r4 = r15.U
            r18 = 0
            r4 = r4[r18]
            androidx.constraintlayout.a.a.e$a r6 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            r7 = 3
            if (r4 != r6) goto L_0x0277
            if (r5 != 0) goto L_0x0277
            r5 = 3
        L_0x0277:
            androidx.constraintlayout.a.a.e$a[] r4 = r15.U
            r6 = 1
            r4 = r4[r6]
            androidx.constraintlayout.a.a.e$a r6 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r4 != r6) goto L_0x0283
            if (r8 != 0) goto L_0x0283
            r8 = 3
        L_0x0283:
            androidx.constraintlayout.a.a.e$a[] r4 = r15.U
            r6 = 0
            r4 = r4[r6]
            androidx.constraintlayout.a.a.e$a r6 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            r22 = 1065353216(0x3f800000, float:1.0)
            if (r4 != r6) goto L_0x035e
            androidx.constraintlayout.a.a.e$a[] r4 = r15.U
            r6 = 1
            r4 = r4[r6]
            androidx.constraintlayout.a.a.e$a r6 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r4 != r6) goto L_0x035e
            if (r5 != r7) goto L_0x035e
            if (r8 != r7) goto L_0x035e
            int r4 = r15.A
            r6 = -1
            if (r4 != r6) goto L_0x02b9
            if (r2 == 0) goto L_0x02a8
            if (r3 != 0) goto L_0x02a8
            r4 = 0
            r15.A = r4
            goto L_0x02b9
        L_0x02a8:
            if (r2 != 0) goto L_0x02b9
            if (r3 == 0) goto L_0x02b9
            r2 = 1
            r15.A = r2
            int r2 = r15.Z
            if (r2 != r6) goto L_0x02b9
            float r2 = r15.B
            float r2 = r22 / r2
            r15.B = r2
        L_0x02b9:
            int r2 = r15.A
            if (r2 != 0) goto L_0x02d1
            androidx.constraintlayout.a.a.d r2 = r15.K
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x02cd
            androidx.constraintlayout.a.a.d r2 = r15.M
            boolean r2 = r2.g()
            if (r2 != 0) goto L_0x02d1
        L_0x02cd:
            r2 = 1
            r15.A = r2
            goto L_0x02e9
        L_0x02d1:
            r2 = 1
            int r3 = r15.A
            if (r3 != r2) goto L_0x02e9
            androidx.constraintlayout.a.a.d r2 = r15.J
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x02e6
            androidx.constraintlayout.a.a.d r2 = r15.L
            boolean r2 = r2.g()
            if (r2 != 0) goto L_0x02e9
        L_0x02e6:
            r2 = 0
            r15.A = r2
        L_0x02e9:
            int r2 = r15.A
            r3 = -1
            if (r2 != r3) goto L_0x033b
            androidx.constraintlayout.a.a.d r2 = r15.K
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x030e
            androidx.constraintlayout.a.a.d r2 = r15.M
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x030e
            androidx.constraintlayout.a.a.d r2 = r15.J
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x030e
            androidx.constraintlayout.a.a.d r2 = r15.L
            boolean r2 = r2.g()
            if (r2 != 0) goto L_0x033b
        L_0x030e:
            androidx.constraintlayout.a.a.d r2 = r15.K
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x0322
            androidx.constraintlayout.a.a.d r2 = r15.M
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x0322
            r2 = 0
            r15.A = r2
            goto L_0x033b
        L_0x0322:
            androidx.constraintlayout.a.a.d r2 = r15.J
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x033b
            androidx.constraintlayout.a.a.d r2 = r15.L
            boolean r2 = r2.g()
            if (r2 == 0) goto L_0x033b
            float r2 = r15.B
            float r2 = r22 / r2
            r15.B = r2
            r2 = 1
            r15.A = r2
        L_0x033b:
            int r2 = r15.A
            r3 = -1
            if (r2 != r3) goto L_0x03b5
            int r2 = r15.s
            if (r2 <= 0) goto L_0x034c
            int r2 = r15.v
            if (r2 != 0) goto L_0x034c
            r2 = 0
            r15.A = r2
            goto L_0x03b5
        L_0x034c:
            int r2 = r15.s
            if (r2 != 0) goto L_0x03b5
            int r2 = r15.v
            if (r2 <= 0) goto L_0x03b5
            float r2 = r15.B
            float r2 = r22 / r2
            r15.B = r2
            r2 = 1
            r15.A = r2
            goto L_0x03b5
        L_0x035e:
            androidx.constraintlayout.a.a.e$a[] r2 = r15.U
            r3 = 0
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e$a r4 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r2 != r4) goto L_0x0384
            if (r5 != r7) goto L_0x0384
            r15.A = r3
            float r0 = r15.B
            int r2 = r15.X
            float r2 = (float) r2
            float r0 = r0 * r2
            int r0 = (int) r0
            androidx.constraintlayout.a.a.e$a[] r2 = r15.U
            r3 = 1
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e$a r4 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r2 == r4) goto L_0x03b5
            r34 = r1
            r33 = r8
            r8 = 0
            r32 = 4
            goto L_0x03c4
        L_0x0384:
            r3 = 1
            androidx.constraintlayout.a.a.e$a[] r2 = r15.U
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e$a r4 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r2 != r4) goto L_0x03b5
            if (r8 != r7) goto L_0x03b5
            r15.A = r3
            int r1 = r15.Z
            r2 = -1
            if (r1 != r2) goto L_0x039c
            float r1 = r15.B
            float r1 = r22 / r1
            r15.B = r1
        L_0x039c:
            float r1 = r15.B
            int r2 = r15.W
            float r2 = (float) r2
            float r1 = r1 * r2
            int r1 = (int) r1
            androidx.constraintlayout.a.a.e$a[] r2 = r15.U
            r3 = 0
            r2 = r2[r3]
            androidx.constraintlayout.a.a.e$a r3 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r2 == r3) goto L_0x03b5
            r34 = r1
            r32 = r5
            r8 = 0
            r33 = 4
            goto L_0x03c4
        L_0x03b5:
            r34 = r1
            r32 = r5
            r33 = r8
            r8 = 1
            goto L_0x03c4
        L_0x03bd:
            r34 = r1
            r32 = r5
            r33 = r8
            r8 = 0
        L_0x03c4:
            int[] r1 = r15.r
            r2 = 0
            r1[r2] = r32
            r2 = 1
            r1[r2] = r33
            r15.l = r8
            if (r8 == 0) goto L_0x03da
            int r1 = r15.A
            r2 = -1
            if (r1 == 0) goto L_0x03d7
            if (r1 != r2) goto L_0x03db
        L_0x03d7:
            r19 = 1
            goto L_0x03dd
        L_0x03da:
            r2 = -1
        L_0x03db:
            r19 = 0
        L_0x03dd:
            if (r8 == 0) goto L_0x03e9
            int r1 = r15.A
            r3 = 1
            if (r1 == r3) goto L_0x03e6
            if (r1 != r2) goto L_0x03e9
        L_0x03e6:
            r35 = 1
            goto L_0x03eb
        L_0x03e9:
            r35 = 0
        L_0x03eb:
            androidx.constraintlayout.a.a.e$a[] r1 = r15.U
            r2 = 0
            r1 = r1[r2]
            androidx.constraintlayout.a.a.e$a r2 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r1 != r2) goto L_0x03fb
            boolean r1 = r15 instanceof androidx.constraintlayout.a.a.f
            if (r1 == 0) goto L_0x03fb
            r21 = 1
            goto L_0x03fd
        L_0x03fb:
            r21 = 0
        L_0x03fd:
            if (r21 == 0) goto L_0x0402
            r22 = 0
            goto L_0x0404
        L_0x0402:
            r22 = r0
        L_0x0404:
            androidx.constraintlayout.a.a.d r0 = r15.Q
            boolean r0 = r0.g()
            r1 = 1
            r36 = r0 ^ 1
            boolean[] r0 = r15.T
            r2 = 0
            boolean r23 = r0[r2]
            boolean r37 = r0[r1]
            int r0 = r15.n
            r7 = 2
            r38 = 0
            if (r0 == r7) goto L_0x0503
            boolean r0 = r15.f2094c
            if (r0 != 0) goto L_0x0503
            if (r53 == 0) goto L_0x046a
            androidx.constraintlayout.a.a.a.l r0 = r15.f2100i
            if (r0 == 0) goto L_0x046a
            androidx.constraintlayout.a.a.a.f r0 = r0.j
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x046a
            androidx.constraintlayout.a.a.a.l r0 = r15.f2100i
            androidx.constraintlayout.a.a.a.f r0 = r0.k
            boolean r0 = r0.j
            if (r0 != 0) goto L_0x0434
            goto L_0x046a
        L_0x0434:
            if (r53 == 0) goto L_0x0503
            androidx.constraintlayout.a.a.a.l r0 = r15.f2100i
            androidx.constraintlayout.a.a.a.f r0 = r0.j
            int r0 = r0.f2033g
            r14.a(r13, r0)
            androidx.constraintlayout.a.a.a.l r0 = r15.f2100i
            androidx.constraintlayout.a.a.a.f r0 = r0.k
            int r0 = r0.f2033g
            r14.a(r12, r0)
            androidx.constraintlayout.a.a.e r0 = r15.V
            if (r0 == 0) goto L_0x0503
            if (r28 == 0) goto L_0x0503
            boolean[] r0 = r15.k
            r1 = 0
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x0503
            boolean r0 = r51.v()
            if (r0 != 0) goto L_0x0503
            androidx.constraintlayout.a.a.e r0 = r15.V
            androidx.constraintlayout.a.a.d r0 = r0.L
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r6 = 8
            r14.a((androidx.constraintlayout.a.h) r0, (androidx.constraintlayout.a.h) r12, (int) r1, (int) r6)
            goto L_0x0503
        L_0x046a:
            r6 = 8
            androidx.constraintlayout.a.a.e r0 = r15.V
            if (r0 == 0) goto L_0x0479
            androidx.constraintlayout.a.a.d r0 = r0.L
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r18 = r0
            goto L_0x047b
        L_0x0479:
            r18 = r38
        L_0x047b:
            androidx.constraintlayout.a.a.e r0 = r15.V
            if (r0 == 0) goto L_0x0488
            androidx.constraintlayout.a.a.d r0 = r0.J
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r27 = r0
            goto L_0x048a
        L_0x0488:
            r27 = r38
        L_0x048a:
            boolean[] r0 = r15.k
            r20 = 0
            boolean r5 = r0[r20]
            androidx.constraintlayout.a.a.e$a[] r0 = r15.U
            r39 = r0[r20]
            androidx.constraintlayout.a.a.d r4 = r15.J
            androidx.constraintlayout.a.a.d r3 = r15.L
            int r1 = r15.aa
            int r2 = r15.ah
            int[] r6 = r15.C
            r42 = r6[r20]
            float r6 = r15.ak
            r17 = 1
            r0 = r0[r17]
            androidx.constraintlayout.a.a.e$a r7 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r0 != r7) goto L_0x04ad
            r44 = 1
            goto L_0x04af
        L_0x04ad:
            r44 = 0
        L_0x04af:
            int r0 = r15.s
            r24 = r0
            int r0 = r15.t
            r25 = r0
            float r0 = r15.u
            r26 = r0
            r0 = r51
            r45 = r1
            r1 = r52
            r40 = r2
            r2 = 1
            r46 = r3
            r3 = r28
            r47 = r4
            r4 = r29
            r7 = 5
            r16 = r6
            r6 = r27
            r7 = r18
            r41 = r8
            r8 = r39
            r48 = r9
            r9 = r21
            r49 = r10
            r10 = r47
            r50 = r11
            r11 = r46
            r39 = r12
            r12 = r45
            r43 = r13
            r13 = r22
            r14 = r40
            r15 = r42
            r17 = r19
            r18 = r44
            r19 = r30
            r20 = r31
            r21 = r23
            r22 = r32
            r23 = r33
            r27 = r36
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x050f
        L_0x0503:
            r41 = r8
            r48 = r9
            r49 = r10
            r50 = r11
            r39 = r12
            r43 = r13
        L_0x050f:
            r15 = r51
            if (r53 == 0) goto L_0x056e
            androidx.constraintlayout.a.a.a.n r0 = r15.j
            if (r0 == 0) goto L_0x056e
            androidx.constraintlayout.a.a.a.f r0 = r0.j
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x056e
            androidx.constraintlayout.a.a.a.n r0 = r15.j
            androidx.constraintlayout.a.a.a.f r0 = r0.k
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x056e
            androidx.constraintlayout.a.a.a.n r0 = r15.j
            androidx.constraintlayout.a.a.a.f r0 = r0.j
            int r0 = r0.f2033g
            r14 = r52
            r13 = r50
            r14.a(r13, r0)
            androidx.constraintlayout.a.a.a.n r0 = r15.j
            androidx.constraintlayout.a.a.a.f r0 = r0.k
            int r0 = r0.f2033g
            r12 = r49
            r14.a(r12, r0)
            androidx.constraintlayout.a.a.a.n r0 = r15.j
            androidx.constraintlayout.a.a.a.f r0 = r0.f2047a
            int r0 = r0.f2033g
            r1 = r48
            r14.a(r1, r0)
            androidx.constraintlayout.a.a.e r0 = r15.V
            if (r0 == 0) goto L_0x0568
            if (r31 != 0) goto L_0x0568
            if (r29 == 0) goto L_0x0568
            boolean[] r2 = r15.k
            r11 = 1
            boolean r2 = r2[r11]
            if (r2 == 0) goto L_0x0564
            androidx.constraintlayout.a.a.d r0 = r0.M
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r2 = 8
            r10 = 0
            r14.a((androidx.constraintlayout.a.h) r0, (androidx.constraintlayout.a.h) r12, (int) r10, (int) r2)
            goto L_0x056c
        L_0x0564:
            r2 = 8
            r10 = 0
            goto L_0x056c
        L_0x0568:
            r2 = 8
            r10 = 0
            r11 = 1
        L_0x056c:
            r7 = 0
            goto L_0x057b
        L_0x056e:
            r14 = r52
            r1 = r48
            r12 = r49
            r13 = r50
            r2 = 8
            r10 = 0
            r11 = 1
            r7 = 1
        L_0x057b:
            int r0 = r15.o
            r3 = 2
            if (r0 != r3) goto L_0x0581
            r7 = 0
        L_0x0581:
            if (r7 == 0) goto L_0x0653
            boolean r0 = r15.f2095d
            if (r0 != 0) goto L_0x0653
            androidx.constraintlayout.a.a.e$a[] r0 = r15.U
            r0 = r0[r11]
            androidx.constraintlayout.a.a.e$a r3 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT
            if (r0 != r3) goto L_0x0595
            boolean r0 = r15 instanceof androidx.constraintlayout.a.a.f
            if (r0 == 0) goto L_0x0595
            r9 = 1
            goto L_0x0596
        L_0x0595:
            r9 = 0
        L_0x0596:
            if (r9 == 0) goto L_0x059a
            r34 = 0
        L_0x059a:
            androidx.constraintlayout.a.a.e r0 = r15.V
            if (r0 == 0) goto L_0x05a6
            androidx.constraintlayout.a.a.d r0 = r0.M
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r7 = r0
            goto L_0x05a8
        L_0x05a6:
            r7 = r38
        L_0x05a8:
            androidx.constraintlayout.a.a.e r0 = r15.V
            if (r0 == 0) goto L_0x05b4
            androidx.constraintlayout.a.a.d r0 = r0.K
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r6 = r0
            goto L_0x05b6
        L_0x05b4:
            r6 = r38
        L_0x05b6:
            int r0 = r15.ag
            if (r0 > 0) goto L_0x05be
            int r0 = r15.an
            if (r0 != r2) goto L_0x05f0
        L_0x05be:
            androidx.constraintlayout.a.a.d r0 = r15.N
            androidx.constraintlayout.a.a.d r0 = r0.f2087f
            if (r0 == 0) goto L_0x05e3
            int r0 = r15.ag
            r14.c(r1, r13, r0, r2)
            androidx.constraintlayout.a.a.d r0 = r15.N
            androidx.constraintlayout.a.a.d r0 = r0.f2087f
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r14.c(r1, r0, r10, r2)
            if (r29 == 0) goto L_0x05e0
            androidx.constraintlayout.a.a.d r0 = r15.M
            androidx.constraintlayout.a.h r0 = r14.a((java.lang.Object) r0)
            r1 = 5
            r14.a((androidx.constraintlayout.a.h) r7, (androidx.constraintlayout.a.h) r0, (int) r10, (int) r1)
        L_0x05e0:
            r27 = 0
            goto L_0x05f2
        L_0x05e3:
            int r0 = r15.an
            if (r0 != r2) goto L_0x05eb
            r14.c(r1, r13, r10, r2)
            goto L_0x05f0
        L_0x05eb:
            int r0 = r15.ag
            r14.c(r1, r13, r0, r2)
        L_0x05f0:
            r27 = r36
        L_0x05f2:
            boolean[] r0 = r15.k
            boolean r5 = r0[r11]
            androidx.constraintlayout.a.a.e$a[] r0 = r15.U
            r8 = r0[r11]
            androidx.constraintlayout.a.a.d r4 = r15.K
            androidx.constraintlayout.a.a.d r3 = r15.M
            int r1 = r15.ab
            int r2 = r15.ai
            int[] r10 = r15.C
            r16 = r10[r11]
            float r10 = r15.al
            r17 = 0
            r0 = r0[r17]
            androidx.constraintlayout.a.a.e$a r11 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r0 != r11) goto L_0x0613
            r18 = 1
            goto L_0x0615
        L_0x0613:
            r18 = 0
        L_0x0615:
            int r0 = r15.v
            r24 = r0
            int r0 = r15.w
            r25 = r0
            float r0 = r15.x
            r26 = r0
            r0 = r51
            r19 = r1
            r1 = r52
            r20 = r2
            r2 = 0
            r11 = r3
            r3 = r29
            r21 = r4
            r4 = r28
            r17 = r10
            r10 = r21
            r28 = r12
            r12 = r19
            r29 = r13
            r13 = r34
            r14 = r20
            r15 = r16
            r16 = r17
            r17 = r35
            r19 = r31
            r20 = r30
            r21 = r37
            r22 = r33
            r23 = r32
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0657
        L_0x0653:
            r28 = r12
            r29 = r13
        L_0x0657:
            r6 = r51
            if (r41 == 0) goto L_0x067f
            int r0 = r6.A
            r1 = 1
            if (r0 != r1) goto L_0x0670
            float r5 = r6.B
            r0 = r52
            r1 = r28
            r2 = r29
            r3 = r39
            r4 = r43
            r0.a(r1, r2, r3, r4, r5)
            goto L_0x067f
        L_0x0670:
            float r5 = r6.B
            r0 = r52
            r1 = r39
            r2 = r43
            r3 = r28
            r4 = r29
            r0.a(r1, r2, r3, r4, r5)
        L_0x067f:
            androidx.constraintlayout.a.a.d r0 = r6.Q
            boolean r0 = r0.g()
            if (r0 == 0) goto L_0x071c
            androidx.constraintlayout.a.a.d r0 = r6.Q
            androidx.constraintlayout.a.a.d r0 = r0.f2087f
            androidx.constraintlayout.a.a.e r0 = r0.f2085d
            float r1 = r6.D
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.a.a.d r2 = r6.Q
            int r2 = r2.e()
            androidx.constraintlayout.a.a.d$a r3 = androidx.constraintlayout.a.a.d.a.LEFT
            androidx.constraintlayout.a.a.d r3 = r6.a((androidx.constraintlayout.a.a.d.a) r3)
            r4 = r52
            androidx.constraintlayout.a.h r8 = r4.a((java.lang.Object) r3)
            androidx.constraintlayout.a.a.d$a r3 = androidx.constraintlayout.a.a.d.a.TOP
            androidx.constraintlayout.a.a.d r3 = r6.a((androidx.constraintlayout.a.a.d.a) r3)
            androidx.constraintlayout.a.h r10 = r4.a((java.lang.Object) r3)
            androidx.constraintlayout.a.a.d$a r3 = androidx.constraintlayout.a.a.d.a.RIGHT
            androidx.constraintlayout.a.a.d r3 = r6.a((androidx.constraintlayout.a.a.d.a) r3)
            androidx.constraintlayout.a.h r3 = r4.a((java.lang.Object) r3)
            androidx.constraintlayout.a.a.d$a r5 = androidx.constraintlayout.a.a.d.a.BOTTOM
            androidx.constraintlayout.a.a.d r5 = r6.a((androidx.constraintlayout.a.a.d.a) r5)
            androidx.constraintlayout.a.h r11 = r4.a((java.lang.Object) r5)
            androidx.constraintlayout.a.a.d$a r5 = androidx.constraintlayout.a.a.d.a.LEFT
            androidx.constraintlayout.a.a.d r5 = r0.a((androidx.constraintlayout.a.a.d.a) r5)
            androidx.constraintlayout.a.h r5 = r4.a((java.lang.Object) r5)
            androidx.constraintlayout.a.a.d$a r7 = androidx.constraintlayout.a.a.d.a.TOP
            androidx.constraintlayout.a.a.d r7 = r0.a((androidx.constraintlayout.a.a.d.a) r7)
            androidx.constraintlayout.a.h r12 = r4.a((java.lang.Object) r7)
            androidx.constraintlayout.a.a.d$a r7 = androidx.constraintlayout.a.a.d.a.RIGHT
            androidx.constraintlayout.a.a.d r7 = r0.a((androidx.constraintlayout.a.a.d.a) r7)
            androidx.constraintlayout.a.h r15 = r4.a((java.lang.Object) r7)
            androidx.constraintlayout.a.a.d$a r7 = androidx.constraintlayout.a.a.d.a.BOTTOM
            androidx.constraintlayout.a.a.d r0 = r0.a((androidx.constraintlayout.a.a.d.a) r7)
            androidx.constraintlayout.a.h r13 = r4.a((java.lang.Object) r0)
            androidx.constraintlayout.a.b r0 = r52.c()
            double r6 = (double) r1
            double r16 = java.lang.Math.sin(r6)
            double r1 = (double) r2
            r53 = r15
            double r14 = r16 * r1
            float r14 = (float) r14
            r9 = r0
            r9.b(r10, r11, r12, r13, r14)
            r4.a((androidx.constraintlayout.a.b) r0)
            androidx.constraintlayout.a.b r0 = r52.c()
            double r6 = java.lang.Math.cos(r6)
            double r6 = r6 * r1
            float r12 = (float) r6
            r7 = r0
            r9 = r3
            r10 = r5
            r11 = r53
            r7.b(r8, r9, r10, r11, r12)
            r4.a((androidx.constraintlayout.a.b) r0)
        L_0x071c:
            r1 = 0
            r0 = r51
            r0.f2094c = r1
            r0.f2095d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.e.a(androidx.constraintlayout.a.d, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean x() {
        return (this instanceof l) || (this instanceof h);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0433, code lost:
        if ((r3 instanceof androidx.constraintlayout.a.a.a) != false) goto L_0x0438;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x03b4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x041e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x04ea A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x0519  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0528 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:350:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:354:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.constraintlayout.a.d r35, boolean r36, boolean r37, boolean r38, boolean r39, androidx.constraintlayout.a.h r40, androidx.constraintlayout.a.h r41, androidx.constraintlayout.a.a.e.a r42, boolean r43, androidx.constraintlayout.a.a.d r44, androidx.constraintlayout.a.a.d r45, int r46, int r47, int r48, int r49, float r50, boolean r51, boolean r52, boolean r53, boolean r54, boolean r55, int r56, int r57, int r58, int r59, float r60, boolean r61) {
        /*
            r34 = this;
            r0 = r34
            r10 = r35
            r11 = r40
            r12 = r41
            r13 = r44
            r14 = r45
            r15 = r48
            r1 = r49
            r2 = r57
            r3 = r58
            r4 = r59
            androidx.constraintlayout.a.h r9 = r10.a((java.lang.Object) r13)
            androidx.constraintlayout.a.h r8 = r10.a((java.lang.Object) r14)
            androidx.constraintlayout.a.a.d r5 = r13.f2087f
            androidx.constraintlayout.a.h r7 = r10.a((java.lang.Object) r5)
            androidx.constraintlayout.a.a.d r5 = r14.f2087f
            androidx.constraintlayout.a.h r6 = r10.a((java.lang.Object) r5)
            androidx.constraintlayout.a.e r5 = androidx.constraintlayout.a.d.a()
            if (r5 == 0) goto L_0x003c
            androidx.constraintlayout.a.e r5 = androidx.constraintlayout.a.d.a()
            long r11 = r5.w
            r16 = 1
            long r11 = r11 + r16
            r5.w = r11
        L_0x003c:
            boolean r11 = r44.g()
            boolean r12 = r45.g()
            androidx.constraintlayout.a.a.d r5 = r0.Q
            boolean r16 = r5.g()
            if (r11 == 0) goto L_0x004f
            r18 = 1
            goto L_0x0051
        L_0x004f:
            r18 = 0
        L_0x0051:
            if (r12 == 0) goto L_0x0055
            int r18 = r18 + 1
        L_0x0055:
            if (r16 == 0) goto L_0x0059
            int r18 = r18 + 1
        L_0x0059:
            r19 = r18
            if (r51 == 0) goto L_0x0060
            r20 = 3
            goto L_0x0062
        L_0x0060:
            r20 = r56
        L_0x0062:
            int[] r21 = androidx.constraintlayout.a.a.e.AnonymousClass1.f2102b
            int r22 = r42.ordinal()
            r5 = r21[r22]
            r2 = 2
            r14 = 1
            if (r5 == r14) goto L_0x0082
            if (r5 == r2) goto L_0x0082
            r14 = 3
            if (r5 == r14) goto L_0x0082
            r14 = 4
            if (r5 == r14) goto L_0x007b
            r5 = r20
        L_0x0078:
            r20 = 0
            goto L_0x0086
        L_0x007b:
            r5 = r20
            if (r5 == r14) goto L_0x0078
            r20 = 1
            goto L_0x0086
        L_0x0082:
            r5 = r20
            r14 = 4
            goto L_0x0078
        L_0x0086:
            int r14 = r0.an
            r2 = 8
            if (r14 != r2) goto L_0x0090
            r14 = 0
            r20 = 0
            goto L_0x0092
        L_0x0090:
            r14 = r47
        L_0x0092:
            if (r61 == 0) goto L_0x00b0
            if (r11 != 0) goto L_0x00a0
            if (r12 != 0) goto L_0x00a0
            if (r16 != 0) goto L_0x00a0
            r2 = r46
            r10.a(r9, r2)
            goto L_0x00b0
        L_0x00a0:
            if (r11 == 0) goto L_0x00b0
            if (r12 != 0) goto L_0x00b0
            int r2 = r44.e()
            r22 = r6
            r6 = 8
            r10.c(r9, r7, r2, r6)
            goto L_0x00b4
        L_0x00b0:
            r22 = r6
            r6 = 8
        L_0x00b4:
            if (r20 != 0) goto L_0x00e0
            if (r43 == 0) goto L_0x00cd
            r2 = 3
            r6 = 0
            r10.c(r8, r9, r6, r2)
            r14 = 8
            if (r15 <= 0) goto L_0x00c4
            r10.a((androidx.constraintlayout.a.h) r8, (androidx.constraintlayout.a.h) r9, (int) r15, (int) r14)
        L_0x00c4:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r2) goto L_0x00d3
            r10.b(r8, r9, r1, r14)
            goto L_0x00d3
        L_0x00cd:
            r1 = 8
            r6 = 0
            r10.c(r8, r9, r14, r1)
        L_0x00d3:
            r23 = r3
            r15 = r5
            r1 = r7
            r14 = r8
            r2 = r22
            r22 = r19
        L_0x00dc:
            r19 = r39
            goto L_0x01dc
        L_0x00e0:
            r1 = r19
            r2 = 2
            r6 = 0
            if (r1 == r2) goto L_0x010b
            if (r51 != 0) goto L_0x010b
            r2 = 1
            if (r5 == r2) goto L_0x00ed
            if (r5 != 0) goto L_0x010b
        L_0x00ed:
            int r2 = java.lang.Math.max(r3, r14)
            if (r4 <= 0) goto L_0x00f7
            int r2 = java.lang.Math.min(r4, r2)
        L_0x00f7:
            r14 = 8
            r10.c(r8, r9, r2, r14)
            r19 = r39
            r23 = r3
            r15 = r5
            r14 = r8
            r2 = r22
            r20 = 0
        L_0x0106:
            r22 = r1
            r1 = r7
            goto L_0x01dc
        L_0x010b:
            r2 = -2
            if (r3 != r2) goto L_0x010f
            r3 = r14
        L_0x010f:
            if (r4 != r2) goto L_0x0113
            r2 = r14
            goto L_0x0114
        L_0x0113:
            r2 = r4
        L_0x0114:
            if (r14 <= 0) goto L_0x011a
            r4 = 1
            if (r5 == r4) goto L_0x011a
            r14 = 0
        L_0x011a:
            if (r3 <= 0) goto L_0x0125
            r4 = 8
            r10.a((androidx.constraintlayout.a.h) r8, (androidx.constraintlayout.a.h) r9, (int) r3, (int) r4)
            int r14 = java.lang.Math.max(r14, r3)
        L_0x0125:
            if (r2 <= 0) goto L_0x013e
            if (r37 == 0) goto L_0x012e
            r4 = 1
            if (r5 != r4) goto L_0x012e
            r4 = 0
            goto L_0x012f
        L_0x012e:
            r4 = 1
        L_0x012f:
            if (r4 == 0) goto L_0x0137
            r4 = 8
            r10.b(r8, r9, r2, r4)
            goto L_0x0139
        L_0x0137:
            r4 = 8
        L_0x0139:
            int r14 = java.lang.Math.min(r14, r2)
            goto L_0x0140
        L_0x013e:
            r4 = 8
        L_0x0140:
            r6 = 1
            if (r5 != r6) goto L_0x0164
            if (r37 == 0) goto L_0x0149
            r10.c(r8, r9, r14, r4)
            goto L_0x015a
        L_0x0149:
            if (r53 == 0) goto L_0x0153
            r6 = 5
            r10.c(r8, r9, r14, r6)
            r10.b(r8, r9, r14, r4)
            goto L_0x015a
        L_0x0153:
            r6 = 5
            r10.c(r8, r9, r14, r6)
            r10.b(r8, r9, r14, r4)
        L_0x015a:
            r19 = r39
            r4 = r2
            r23 = r3
            r15 = r5
            r14 = r8
            r2 = r22
            goto L_0x0106
        L_0x0164:
            r14 = 2
            if (r5 != r14) goto L_0x01cb
            androidx.constraintlayout.a.a.d$a r4 = r13.f2086e
            androidx.constraintlayout.a.a.d$a r6 = androidx.constraintlayout.a.a.d.a.TOP
            if (r4 == r6) goto L_0x018d
            androidx.constraintlayout.a.a.d$a r4 = r13.f2086e
            androidx.constraintlayout.a.a.d$a r6 = androidx.constraintlayout.a.a.d.a.BOTTOM
            if (r4 != r6) goto L_0x0174
            goto L_0x018d
        L_0x0174:
            androidx.constraintlayout.a.a.e r4 = r0.V
            androidx.constraintlayout.a.a.d$a r6 = androidx.constraintlayout.a.a.d.a.LEFT
            androidx.constraintlayout.a.a.d r4 = r4.a((androidx.constraintlayout.a.a.d.a) r6)
            androidx.constraintlayout.a.h r4 = r10.a((java.lang.Object) r4)
            androidx.constraintlayout.a.a.e r6 = r0.V
            androidx.constraintlayout.a.a.d$a r14 = androidx.constraintlayout.a.a.d.a.RIGHT
            androidx.constraintlayout.a.a.d r6 = r6.a((androidx.constraintlayout.a.a.d.a) r14)
            androidx.constraintlayout.a.h r6 = r10.a((java.lang.Object) r6)
            goto L_0x01a5
        L_0x018d:
            androidx.constraintlayout.a.a.e r4 = r0.V
            androidx.constraintlayout.a.a.d$a r6 = androidx.constraintlayout.a.a.d.a.TOP
            androidx.constraintlayout.a.a.d r4 = r4.a((androidx.constraintlayout.a.a.d.a) r6)
            androidx.constraintlayout.a.h r4 = r10.a((java.lang.Object) r4)
            androidx.constraintlayout.a.a.e r6 = r0.V
            androidx.constraintlayout.a.a.d$a r14 = androidx.constraintlayout.a.a.d.a.BOTTOM
            androidx.constraintlayout.a.a.d r6 = r6.a((androidx.constraintlayout.a.a.d.a) r14)
            androidx.constraintlayout.a.h r6 = r10.a((java.lang.Object) r6)
        L_0x01a5:
            r14 = r4
            androidx.constraintlayout.a.b r4 = r35.c()
            r19 = r3
            r3 = r4
            r4 = r8
            r43 = r2
            r15 = r5
            r2 = 0
            r5 = r9
            r2 = r22
            r22 = r1
            r1 = r7
            r7 = r14
            r14 = r8
            r8 = r60
            androidx.constraintlayout.a.b r3 = r3.a(r4, r5, r6, r7, r8)
            r10.a((androidx.constraintlayout.a.b) r3)
            r4 = r43
            r23 = r19
            r20 = 0
            goto L_0x00dc
        L_0x01cb:
            r43 = r2
            r19 = r3
            r15 = r5
            r14 = r8
            r2 = r22
            r22 = r1
            r1 = r7
            r4 = r43
            r23 = r19
            r19 = 1
        L_0x01dc:
            if (r61 == 0) goto L_0x0519
            if (r53 == 0) goto L_0x01ef
            r3 = r40
            r4 = r41
            r7 = r9
            r2 = r22
            r1 = 0
            r5 = 2
            r13 = 8
            r21 = 1
            goto L_0x0526
        L_0x01ef:
            if (r11 != 0) goto L_0x01f5
            if (r12 != 0) goto L_0x01f5
            if (r16 == 0) goto L_0x01fa
        L_0x01f5:
            if (r11 == 0) goto L_0x01ff
            if (r12 == 0) goto L_0x01fa
            goto L_0x01ff
        L_0x01fa:
            r12 = r45
            r1 = 0
            goto L_0x04e6
        L_0x01ff:
            if (r11 != 0) goto L_0x022f
            if (r12 == 0) goto L_0x022f
            int r1 = r45.e()
            int r1 = -r1
            r3 = 8
            r10.c(r14, r2, r1, r3)
            if (r37 == 0) goto L_0x01fa
            boolean r1 = r0.f2092a
            if (r1 == 0) goto L_0x0227
            boolean r1 = r9.f2171f
            if (r1 == 0) goto L_0x0227
            androidx.constraintlayout.a.a.e r1 = r0.V
            if (r1 == 0) goto L_0x0227
            androidx.constraintlayout.a.a.f r1 = (androidx.constraintlayout.a.a.f) r1
            if (r36 == 0) goto L_0x0223
            r1.b((androidx.constraintlayout.a.a.d) r13)
            goto L_0x01fa
        L_0x0223:
            r1.a((androidx.constraintlayout.a.a.d) r13)
            goto L_0x01fa
        L_0x0227:
            r8 = r40
            r1 = 5
            r3 = 0
            r10.a((androidx.constraintlayout.a.h) r9, (androidx.constraintlayout.a.h) r8, (int) r3, (int) r1)
            goto L_0x01fa
        L_0x022f:
            r8 = r40
            r3 = 0
            if (r11 == 0) goto L_0x01fa
            if (r12 == 0) goto L_0x01fa
            androidx.constraintlayout.a.a.d r5 = r13.f2087f
            androidx.constraintlayout.a.a.e r11 = r5.f2085d
            r12 = r45
            r16 = 4
            androidx.constraintlayout.a.a.d r5 = r12.f2087f
            androidx.constraintlayout.a.a.e r7 = r5.f2085d
            androidx.constraintlayout.a.a.e r6 = r0.V
            r18 = 6
            if (r20 == 0) goto L_0x0362
            if (r15 != 0) goto L_0x02a9
            if (r4 != 0) goto L_0x0274
            if (r23 != 0) goto L_0x0274
            boolean r4 = r1.f2171f
            if (r4 == 0) goto L_0x0268
            boolean r4 = r2.f2171f
            if (r4 == 0) goto L_0x0268
            int r3 = r44.e()
            r5 = 8
            r10.c(r9, r1, r3, r5)
            int r1 = r45.e()
            int r1 = -r1
            r10.c(r14, r2, r1, r5)
            return
        L_0x0268:
            r5 = 8
            r4 = 0
            r21 = 1
            r22 = 0
            r24 = 8
            r25 = 8
            goto L_0x027f
        L_0x0274:
            r5 = 8
            r4 = 1
            r21 = 0
            r22 = 1
            r24 = 5
            r25 = 5
        L_0x027f:
            boolean r3 = r11 instanceof androidx.constraintlayout.a.a.a
            if (r3 != 0) goto L_0x0297
            boolean r3 = r7 instanceof androidx.constraintlayout.a.a.a
            if (r3 == 0) goto L_0x0288
            goto L_0x0297
        L_0x0288:
            r17 = r22
            r27 = r24
            r26 = r25
            r3 = 5
            r5 = 1
            r24 = 6
            r22 = r4
            r25 = r21
            goto L_0x02a5
        L_0x0297:
            r25 = r21
            r17 = r22
            r27 = r24
            r3 = 5
            r5 = 1
            r24 = 6
            r26 = 4
            r22 = r4
        L_0x02a5:
            r4 = r41
            goto L_0x03b2
        L_0x02a9:
            r3 = 1
            r5 = 8
            if (r15 != r3) goto L_0x02c0
            r4 = r41
            r3 = 5
            r5 = 1
            r17 = 1
            r22 = 1
            r24 = 6
            r25 = 0
            r26 = 4
        L_0x02bc:
            r27 = 8
            goto L_0x03b2
        L_0x02c0:
            r3 = 3
            if (r15 != r3) goto L_0x0359
            int r3 = r0.A
            r5 = -1
            if (r3 != r5) goto L_0x02e9
            if (r54 == 0) goto L_0x02da
            r4 = r41
            r3 = 5
            r5 = 1
            r17 = 1
            r22 = 1
            if (r37 == 0) goto L_0x02d7
            r24 = 5
            goto L_0x02e4
        L_0x02d7:
            r24 = 4
            goto L_0x02e4
        L_0x02da:
            r4 = r41
            r3 = 5
            r5 = 1
            r17 = 1
            r22 = 1
            r24 = 8
        L_0x02e4:
            r25 = 1
            r26 = 5
            goto L_0x02bc
        L_0x02e9:
            if (r51 == 0) goto L_0x030e
            r3 = r57
            r5 = 2
            if (r3 == r5) goto L_0x02f6
            r5 = 1
            if (r3 != r5) goto L_0x02f4
            goto L_0x02f7
        L_0x02f4:
            r3 = 0
            goto L_0x02f8
        L_0x02f6:
            r5 = 1
        L_0x02f7:
            r3 = 1
        L_0x02f8:
            if (r3 != 0) goto L_0x02fe
            r3 = 8
            r4 = 5
            goto L_0x0300
        L_0x02fe:
            r3 = 5
            r4 = 4
        L_0x0300:
            r27 = r3
            r26 = r4
            r3 = 5
            r17 = 1
            r22 = 1
            r24 = 6
            r25 = 1
            goto L_0x02a5
        L_0x030e:
            r5 = 1
            if (r4 <= 0) goto L_0x0320
            r4 = r41
            r3 = 5
            r17 = 1
            r22 = 1
            r24 = 6
            r25 = 1
            r26 = 5
            goto L_0x03b0
        L_0x0320:
            if (r4 != 0) goto L_0x034d
            if (r23 != 0) goto L_0x034d
            if (r54 != 0) goto L_0x0335
            r4 = r41
            r3 = 5
            r17 = 1
            r22 = 1
            r24 = 6
            r25 = 1
            r26 = 8
            goto L_0x03b0
        L_0x0335:
            if (r11 == r6) goto L_0x033b
            if (r7 == r6) goto L_0x033b
            r3 = 4
            goto L_0x033c
        L_0x033b:
            r3 = 5
        L_0x033c:
            r4 = r41
            r27 = r3
            r3 = 5
            r17 = 1
            r22 = 1
            r24 = 6
            r25 = 1
            r26 = 4
            goto L_0x03b2
        L_0x034d:
            r4 = r41
            r3 = 5
            r17 = 1
            r22 = 1
            r24 = 6
            r25 = 1
            goto L_0x03ae
        L_0x0359:
            r5 = 1
            r4 = r41
            r3 = 5
            r17 = 0
            r22 = 0
            goto L_0x03aa
        L_0x0362:
            r5 = 1
            boolean r3 = r1.f2171f
            if (r3 == 0) goto L_0x03a3
            boolean r3 = r2.f2171f
            if (r3 == 0) goto L_0x03a3
            int r3 = r44.e()
            int r4 = r45.e()
            r5 = 8
            r51 = r35
            r52 = r9
            r53 = r1
            r54 = r3
            r55 = r50
            r56 = r2
            r57 = r14
            r58 = r4
            r59 = r5
            r51.a(r52, r53, r54, r55, r56, r57, r58, r59)
            if (r37 == 0) goto L_0x03a2
            if (r19 == 0) goto L_0x03a2
            androidx.constraintlayout.a.a.d r1 = r12.f2087f
            if (r1 == 0) goto L_0x0399
            int r5 = r45.e()
            r4 = r41
            goto L_0x039c
        L_0x0399:
            r4 = r41
            r5 = 0
        L_0x039c:
            if (r2 == r4) goto L_0x03a2
            r3 = 5
            r10.a((androidx.constraintlayout.a.h) r4, (androidx.constraintlayout.a.h) r14, (int) r5, (int) r3)
        L_0x03a2:
            return
        L_0x03a3:
            r4 = r41
            r3 = 5
            r17 = 1
            r22 = 1
        L_0x03aa:
            r24 = 6
            r25 = 0
        L_0x03ae:
            r26 = 4
        L_0x03b0:
            r27 = 5
        L_0x03b2:
            if (r17 == 0) goto L_0x03bd
            if (r1 != r2) goto L_0x03bd
            if (r11 == r6) goto L_0x03bd
            r17 = 0
            r28 = 0
            goto L_0x03bf
        L_0x03bd:
            r28 = 1
        L_0x03bf:
            if (r22 == 0) goto L_0x0402
            if (r20 != 0) goto L_0x03d4
            if (r52 != 0) goto L_0x03d4
            if (r54 != 0) goto L_0x03d4
            if (r1 != r8) goto L_0x03d4
            if (r2 != r4) goto L_0x03d4
            r22 = 0
            r24 = 8
            r27 = 8
            r28 = 0
            goto L_0x03d6
        L_0x03d4:
            r22 = r37
        L_0x03d6:
            int r29 = r44.e()
            int r30 = r45.e()
            r42 = r1
            r1 = r35
            r5 = r2
            r3 = 3
            r13 = 8
            r21 = 1
            r2 = r9
            r3 = r42
            r4 = r29
            r39 = r5
            r5 = r50
            r31 = r6
            r6 = r39
            r32 = r7
            r7 = r14
            r8 = r30
            r33 = r9
            r9 = r24
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0412
        L_0x0402:
            r42 = r1
            r39 = r2
            r31 = r6
            r32 = r7
            r33 = r9
            r13 = 8
            r21 = 1
            r22 = r37
        L_0x0412:
            r5 = r28
            int r1 = r0.an
            if (r1 != r13) goto L_0x041f
            boolean r1 = r45.a()
            if (r1 != 0) goto L_0x041f
            return
        L_0x041f:
            r2 = r39
            r1 = r42
            if (r17 == 0) goto L_0x0450
            if (r22 == 0) goto L_0x043a
            if (r1 == r2) goto L_0x043a
            if (r20 != 0) goto L_0x043a
            boolean r3 = r11 instanceof androidx.constraintlayout.a.a.a
            if (r3 != 0) goto L_0x0436
            r3 = r32
            boolean r4 = r3 instanceof androidx.constraintlayout.a.a.a
            if (r4 == 0) goto L_0x043c
            goto L_0x0438
        L_0x0436:
            r3 = r32
        L_0x0438:
            r4 = 6
            goto L_0x043e
        L_0x043a:
            r3 = r32
        L_0x043c:
            r4 = r27
        L_0x043e:
            int r6 = r44.e()
            r7 = r33
            r10.a((androidx.constraintlayout.a.h) r7, (androidx.constraintlayout.a.h) r1, (int) r6, (int) r4)
            int r6 = r45.e()
            int r6 = -r6
            r10.b(r14, r2, r6, r4)
            goto L_0x0456
        L_0x0450:
            r3 = r32
            r7 = r33
            r4 = r27
        L_0x0456:
            if (r22 == 0) goto L_0x0466
            if (r55 == 0) goto L_0x0466
            boolean r6 = r11 instanceof androidx.constraintlayout.a.a.a
            if (r6 != 0) goto L_0x0466
            boolean r6 = r3 instanceof androidx.constraintlayout.a.a.a
            if (r6 != 0) goto L_0x0466
            r4 = 6
            r5 = 1
            r6 = 6
            goto L_0x0469
        L_0x0466:
            r6 = r4
            r4 = r26
        L_0x0469:
            if (r5 == 0) goto L_0x04b9
            if (r25 == 0) goto L_0x0499
            if (r54 == 0) goto L_0x0471
            if (r38 == 0) goto L_0x0499
        L_0x0471:
            r5 = r31
            if (r11 == r5) goto L_0x047a
            if (r3 != r5) goto L_0x0478
            goto L_0x047a
        L_0x0478:
            r18 = r4
        L_0x047a:
            boolean r8 = r11 instanceof androidx.constraintlayout.a.a.h
            if (r8 != 0) goto L_0x0482
            boolean r8 = r3 instanceof androidx.constraintlayout.a.a.h
            if (r8 == 0) goto L_0x0484
        L_0x0482:
            r18 = 5
        L_0x0484:
            boolean r8 = r11 instanceof androidx.constraintlayout.a.a.a
            if (r8 != 0) goto L_0x048c
            boolean r8 = r3 instanceof androidx.constraintlayout.a.a.a
            if (r8 == 0) goto L_0x048e
        L_0x048c:
            r18 = 5
        L_0x048e:
            if (r54 == 0) goto L_0x0492
            r8 = 5
            goto L_0x0494
        L_0x0492:
            r8 = r18
        L_0x0494:
            int r4 = java.lang.Math.max(r8, r4)
            goto L_0x049b
        L_0x0499:
            r5 = r31
        L_0x049b:
            if (r22 == 0) goto L_0x04aa
            int r4 = java.lang.Math.min(r6, r4)
            if (r51 == 0) goto L_0x04aa
            if (r54 != 0) goto L_0x04aa
            if (r11 == r5) goto L_0x04a9
            if (r3 != r5) goto L_0x04aa
        L_0x04a9:
            r4 = 4
        L_0x04aa:
            int r3 = r44.e()
            r10.c(r7, r1, r3, r4)
            int r3 = r45.e()
            int r3 = -r3
            r10.c(r14, r2, r3, r4)
        L_0x04b9:
            if (r22 == 0) goto L_0x04cb
            r3 = r40
            if (r3 != r1) goto L_0x04c4
            int r5 = r44.e()
            goto L_0x04c5
        L_0x04c4:
            r5 = 0
        L_0x04c5:
            if (r1 == r3) goto L_0x04cb
            r1 = 5
            r10.a((androidx.constraintlayout.a.h) r7, (androidx.constraintlayout.a.h) r3, (int) r5, (int) r1)
        L_0x04cb:
            if (r22 == 0) goto L_0x04e4
            if (r20 == 0) goto L_0x04e4
            r5 = r15
            if (r48 != 0) goto L_0x04e4
            if (r23 != 0) goto L_0x04e4
            if (r20 == 0) goto L_0x04de
            r1 = 3
            if (r5 != r1) goto L_0x04de
            r1 = 0
            r10.a((androidx.constraintlayout.a.h) r14, (androidx.constraintlayout.a.h) r7, (int) r1, (int) r13)
            goto L_0x04e8
        L_0x04de:
            r1 = 0
            r3 = 5
            r10.a((androidx.constraintlayout.a.h) r14, (androidx.constraintlayout.a.h) r7, (int) r1, (int) r3)
            goto L_0x04e8
        L_0x04e4:
            r1 = 0
            goto L_0x04e8
        L_0x04e6:
            r22 = r37
        L_0x04e8:
            if (r22 == 0) goto L_0x0518
            if (r19 == 0) goto L_0x0518
            androidx.constraintlayout.a.a.d r3 = r12.f2087f
            if (r3 == 0) goto L_0x04f7
            int r5 = r45.e()
            r4 = r41
            goto L_0x04fa
        L_0x04f7:
            r4 = r41
            r5 = 0
        L_0x04fa:
            if (r2 == r4) goto L_0x0518
            boolean r1 = r0.f2092a
            if (r1 == 0) goto L_0x0514
            boolean r1 = r14.f2171f
            if (r1 == 0) goto L_0x0514
            androidx.constraintlayout.a.a.e r1 = r0.V
            if (r1 == 0) goto L_0x0514
            androidx.constraintlayout.a.a.f r1 = (androidx.constraintlayout.a.a.f) r1
            if (r36 == 0) goto L_0x0510
            r1.d((androidx.constraintlayout.a.a.d) r12)
            return
        L_0x0510:
            r1.c((androidx.constraintlayout.a.a.d) r12)
            return
        L_0x0514:
            r1 = 5
            r10.a((androidx.constraintlayout.a.h) r4, (androidx.constraintlayout.a.h) r14, (int) r5, (int) r1)
        L_0x0518:
            return
        L_0x0519:
            r3 = r40
            r4 = r41
            r7 = r9
            r1 = 0
            r5 = 2
            r13 = 8
            r21 = 1
            r2 = r22
        L_0x0526:
            if (r2 >= r5) goto L_0x0568
            if (r37 == 0) goto L_0x0568
            if (r19 == 0) goto L_0x0568
            r10.a((androidx.constraintlayout.a.h) r7, (androidx.constraintlayout.a.h) r3, (int) r1, (int) r13)
            if (r36 != 0) goto L_0x053a
            androidx.constraintlayout.a.a.d r2 = r0.N
            androidx.constraintlayout.a.a.d r2 = r2.f2087f
            if (r2 != 0) goto L_0x0538
            goto L_0x053a
        L_0x0538:
            r5 = 0
            goto L_0x053b
        L_0x053a:
            r5 = 1
        L_0x053b:
            if (r36 != 0) goto L_0x0563
            androidx.constraintlayout.a.a.d r2 = r0.N
            androidx.constraintlayout.a.a.d r2 = r2.f2087f
            if (r2 == 0) goto L_0x0563
            androidx.constraintlayout.a.a.d r2 = r0.N
            androidx.constraintlayout.a.a.d r2 = r2.f2087f
            androidx.constraintlayout.a.a.e r2 = r2.f2085d
            float r3 = r2.Y
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0562
            androidx.constraintlayout.a.a.e$a[] r3 = r2.U
            r3 = r3[r1]
            androidx.constraintlayout.a.a.e$a r5 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r3 != r5) goto L_0x0562
            androidx.constraintlayout.a.a.e$a[] r2 = r2.U
            r2 = r2[r21]
            androidx.constraintlayout.a.a.e$a r3 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x0562
            r5 = 1
            goto L_0x0563
        L_0x0562:
            r5 = 0
        L_0x0563:
            if (r5 == 0) goto L_0x0568
            r10.a((androidx.constraintlayout.a.h) r4, (androidx.constraintlayout.a.h) r14, (int) r1, (int) r13)
        L_0x0568:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.e.a(androidx.constraintlayout.a.d, boolean, boolean, boolean, boolean, androidx.constraintlayout.a.h, androidx.constraintlayout.a.h, androidx.constraintlayout.a.a.e$a, boolean, androidx.constraintlayout.a.a.d, androidx.constraintlayout.a.a.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* renamed from: androidx.constraintlayout.a.a.e$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2102b = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
        static {
            /*
                androidx.constraintlayout.a.a.e$a[] r0 = androidx.constraintlayout.a.a.e.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2102b = r0
                r0 = 1
                int[] r1 = f2102b     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.constraintlayout.a.a.e$a r2 = androidx.constraintlayout.a.a.e.a.FIXED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f2102b     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.constraintlayout.a.a.e$a r3 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f2102b     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.constraintlayout.a.a.e$a r4 = androidx.constraintlayout.a.a.e.a.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f2102b     // Catch:{ NoSuchFieldError -> 0x0035 }
                androidx.constraintlayout.a.a.e$a r5 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                androidx.constraintlayout.a.a.d$a[] r4 = androidx.constraintlayout.a.a.d.a.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f2101a = r4
                int[] r4 = f2101a     // Catch:{ NoSuchFieldError -> 0x0048 }
                androidx.constraintlayout.a.a.d$a r5 = androidx.constraintlayout.a.a.d.a.LEFT     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f2101a     // Catch:{ NoSuchFieldError -> 0x0052 }
                androidx.constraintlayout.a.a.d$a r4 = androidx.constraintlayout.a.a.d.a.TOP     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f2101a     // Catch:{ NoSuchFieldError -> 0x005c }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.RIGHT     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f2101a     // Catch:{ NoSuchFieldError -> 0x0066 }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = f2101a     // Catch:{ NoSuchFieldError -> 0x0071 }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.BASELINE     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f2101a     // Catch:{ NoSuchFieldError -> 0x007c }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.CENTER     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = f2101a     // Catch:{ NoSuchFieldError -> 0x0087 }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f2101a     // Catch:{ NoSuchFieldError -> 0x0093 }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r0 = f2101a     // Catch:{ NoSuchFieldError -> 0x009f }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.NONE     // Catch:{ NoSuchFieldError -> 0x009f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.e.AnonymousClass1.<clinit>():void");
        }
    }

    public void a(boolean z2) {
        int i2;
        int i3;
        n nVar;
        l lVar;
        int b2 = androidx.constraintlayout.a.d.b((Object) this.J);
        int b3 = androidx.constraintlayout.a.d.b((Object) this.K);
        int b4 = androidx.constraintlayout.a.d.b((Object) this.L);
        int b5 = androidx.constraintlayout.a.d.b((Object) this.M);
        if (z2 && (lVar = this.f2100i) != null && lVar.j.j && this.f2100i.k.j) {
            b2 = this.f2100i.j.f2033g;
            b4 = this.f2100i.k.f2033g;
        }
        if (z2 && (nVar = this.j) != null && nVar.j.j && this.j.k.j) {
            b3 = this.j.j.f2033g;
            b5 = this.j.k.f2033g;
        }
        int i4 = b5 - b3;
        if (b4 - b2 < 0 || i4 < 0 || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE || b5 == Integer.MIN_VALUE || b5 == Integer.MAX_VALUE) {
            b2 = 0;
            b3 = 0;
            b4 = 0;
            b5 = 0;
        }
        int i5 = b4 - b2;
        int i6 = b5 - b3;
        this.aa = b2;
        this.ab = b3;
        if (this.an == 8) {
            this.W = 0;
            this.X = 0;
            return;
        }
        if (this.U[0] != a.FIXED || i5 >= (i2 = this.W)) {
            i2 = i5;
        }
        if (this.U[1] != a.FIXED || i6 >= (i3 = this.X)) {
            i3 = i6;
        }
        this.W = i2;
        this.X = i3;
        int i7 = this.X;
        int i8 = this.ai;
        if (i7 < i8) {
            this.X = i8;
        }
        int i9 = this.W;
        int i10 = this.ah;
        if (i9 < i10) {
            this.W = i10;
        }
    }

    public void a(e eVar, HashMap<e, e> hashMap) {
        this.n = eVar.n;
        this.o = eVar.o;
        this.p = eVar.p;
        this.q = eVar.q;
        int[] iArr = this.r;
        int[] iArr2 = eVar.r;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.s = eVar.s;
        this.t = eVar.t;
        this.v = eVar.v;
        this.w = eVar.w;
        this.x = eVar.x;
        this.y = eVar.y;
        this.z = eVar.z;
        this.A = eVar.A;
        this.B = eVar.B;
        int[] iArr3 = eVar.C;
        this.C = Arrays.copyOf(iArr3, iArr3.length);
        this.D = eVar.D;
        this.E = eVar.E;
        this.F = eVar.F;
        this.J.f();
        this.K.f();
        this.L.f();
        this.M.f();
        this.N.f();
        this.O.f();
        this.P.f();
        this.Q.f();
        this.U = (a[]) Arrays.copyOf(this.U, 2);
        e eVar2 = null;
        this.V = this.V == null ? null : hashMap.get(eVar.V);
        this.W = eVar.W;
        this.X = eVar.X;
        this.Y = eVar.Y;
        this.Z = eVar.Z;
        this.aa = eVar.aa;
        this.ab = eVar.ab;
        this.ac = eVar.ac;
        this.ad = eVar.ad;
        this.ae = eVar.ae;
        this.af = eVar.af;
        this.ag = eVar.ag;
        this.ah = eVar.ah;
        this.ai = eVar.ai;
        this.ak = eVar.ak;
        this.al = eVar.al;
        this.am = eVar.am;
        this.aL = eVar.aL;
        this.an = eVar.an;
        this.ao = eVar.ao;
        this.aM = eVar.aM;
        this.ap = eVar.ap;
        this.aq = eVar.aq;
        this.ar = eVar.ar;
        this.as = eVar.as;
        this.at = eVar.at;
        this.au = eVar.au;
        this.av = eVar.av;
        this.aw = eVar.aw;
        this.ax = eVar.ax;
        this.ay = eVar.ay;
        this.aA = eVar.aA;
        this.aB = eVar.aB;
        this.aC = eVar.aC;
        this.aD = eVar.aD;
        float[] fArr = this.aE;
        float[] fArr2 = eVar.aE;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        e[] eVarArr = this.aF;
        e[] eVarArr2 = eVar.aF;
        eVarArr[0] = eVarArr2[0];
        eVarArr[1] = eVarArr2[1];
        e[] eVarArr3 = this.aG;
        e[] eVarArr4 = eVar.aG;
        eVarArr3[0] = eVarArr4[0];
        eVarArr3[1] = eVarArr4[1];
        e eVar3 = eVar.aH;
        this.aH = eVar3 == null ? null : hashMap.get(eVar3);
        e eVar4 = eVar.aI;
        if (eVar4 != null) {
            eVar2 = hashMap.get(eVar4);
        }
        this.aI = eVar2;
    }

    public void a(boolean z2, boolean z3) {
        int i2;
        int i3;
        boolean z4 = z2 & this.f2100i.f2071i;
        boolean z5 = z3 & this.j.f2071i;
        int i4 = this.f2100i.j.f2033g;
        int i5 = this.j.j.f2033g;
        int i6 = this.f2100i.k.f2033g;
        int i7 = this.j.k.f2033g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (z4) {
            this.aa = i4;
        }
        if (z5) {
            this.ab = i5;
        }
        if (this.an == 8) {
            this.W = 0;
            this.X = 0;
            return;
        }
        if (z4) {
            if (this.U[0] != a.FIXED || i9 >= (i3 = this.W)) {
                i3 = i9;
            }
            this.W = i3;
            int i11 = this.W;
            int i12 = this.ah;
            if (i11 < i12) {
                this.W = i12;
            }
        }
        if (z5) {
            if (this.U[1] != a.FIXED || i10 >= (i2 = this.X)) {
                i2 = i10;
            }
            this.X = i2;
            int i13 = this.X;
            int i14 = this.ai;
            if (i13 < i14) {
                this.X = i14;
            }
        }
    }

    public final void a(f fVar, androidx.constraintlayout.a.d dVar, HashSet<e> hashSet, int i2, boolean z2) {
        if (z2) {
            if (hashSet.contains(this)) {
                k.a(fVar, dVar, this);
                hashSet.remove(this);
                a(dVar, fVar.p(64));
            } else {
                return;
            }
        }
        if (i2 == 0) {
            HashSet<d> hashSet2 = this.J.f2082a;
            if (hashSet2 != null) {
                Iterator<d> it2 = hashSet2.iterator();
                while (it2.hasNext()) {
                    it2.next().f2085d.a(fVar, dVar, hashSet, i2, true);
                }
            }
            HashSet<d> hashSet3 = this.L.f2082a;
            if (hashSet3 != null) {
                Iterator<d> it3 = hashSet3.iterator();
                while (it3.hasNext()) {
                    it3.next().f2085d.a(fVar, dVar, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<d> hashSet4 = this.K.f2082a;
        if (hashSet4 != null) {
            Iterator<d> it4 = hashSet4.iterator();
            while (it4.hasNext()) {
                it4.next().f2085d.a(fVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<d> hashSet5 = this.M.f2082a;
        if (hashSet5 != null) {
            Iterator<d> it5 = hashSet5.iterator();
            while (it5.hasNext()) {
                it5.next().f2085d.a(fVar, dVar, hashSet, i2, true);
            }
        }
        HashSet<d> hashSet6 = this.N.f2082a;
        if (hashSet6 != null) {
            Iterator<d> it6 = hashSet6.iterator();
            while (it6.hasNext()) {
                it6.next().f2085d.a(fVar, dVar, hashSet, i2, true);
            }
        }
    }

    public final void a(d dVar, d dVar2, int i2) {
        if (dVar.f2085d == this) {
            a(dVar.f2086e, dVar2.f2085d, dVar2.f2086e, i2);
        }
    }

    public final a l(int i2) {
        if (i2 == 0) {
            return this.U[0];
        }
        if (i2 == 1) {
            return this.U[1];
        }
        return null;
    }
}
