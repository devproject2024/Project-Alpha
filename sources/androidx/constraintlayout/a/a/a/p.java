package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.d;
import androidx.constraintlayout.a.a.e;

public abstract class p implements d {

    /* renamed from: c  reason: collision with root package name */
    public int f2065c;

    /* renamed from: d  reason: collision with root package name */
    public e f2066d;

    /* renamed from: e  reason: collision with root package name */
    m f2067e;

    /* renamed from: f  reason: collision with root package name */
    protected e.a f2068f;

    /* renamed from: g  reason: collision with root package name */
    public g f2069g = new g(this);

    /* renamed from: h  reason: collision with root package name */
    public int f2070h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2071i = false;
    public f j = new f(this);
    public f k = new f(this);
    protected a l = a.NONE;

    enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public abstract boolean a();

    /* access modifiers changed from: package-private */
    public abstract void c();

    public void d() {
    }

    public abstract void e();

    /* access modifiers changed from: package-private */
    public abstract void f();

    public p(e eVar) {
        this.f2066d = eVar;
    }

    protected static f a(d dVar) {
        if (dVar.f2087f == null) {
            return null;
        }
        e eVar = dVar.f2087f.f2085d;
        int i2 = AnonymousClass1.f2072a[dVar.f2087f.f2086e.ordinal()];
        if (i2 == 1) {
            return eVar.f2100i.j;
        }
        if (i2 == 2) {
            return eVar.f2100i.k;
        }
        if (i2 == 3) {
            return eVar.j.j;
        }
        if (i2 == 4) {
            return eVar.j.f2047a;
        }
        if (i2 != 5) {
            return null;
        }
        return eVar.j.k;
    }

    /* renamed from: androidx.constraintlayout.a.a.a.p$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2072a = new int[d.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                androidx.constraintlayout.a.a.d$a[] r0 = androidx.constraintlayout.a.a.d.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2072a = r0
                int[] r0 = f2072a     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.LEFT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2072a     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.RIGHT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2072a     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.TOP     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f2072a     // Catch:{ NoSuchFieldError -> 0x0035 }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.BASELINE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f2072a     // Catch:{ NoSuchFieldError -> 0x0040 }
                androidx.constraintlayout.a.a.d$a r1 = androidx.constraintlayout.a.a.d.a.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.a.p.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final void a(d dVar, d dVar2, int i2) {
        float f2;
        int i3;
        f a2 = a(dVar);
        f a3 = a(dVar2);
        if (a2.j && a3.j) {
            int e2 = a2.f2033g + dVar.e();
            int e3 = a3.f2033g - dVar2.e();
            int i4 = e3 - e2;
            if (!this.f2069g.j && this.f2068f == e.a.MATCH_CONSTRAINT) {
                int i5 = this.f2065c;
                if (i5 == 0) {
                    this.f2069g.a(a(i4, i2));
                } else if (i5 == 1) {
                    this.f2069g.a(Math.min(a(this.f2069g.m, i2), i4));
                } else if (i5 == 2) {
                    e eVar = this.f2066d.V;
                    if (eVar != null) {
                        p pVar = i2 == 0 ? eVar.f2100i : eVar.j;
                        if (pVar.f2069g.j) {
                            e eVar2 = this.f2066d;
                            this.f2069g.a(a((int) ((((float) pVar.f2069g.f2033g) * (i2 == 0 ? eVar2.u : eVar2.x)) + 0.5f), i2));
                        }
                    }
                } else if (i5 == 3 && !(this.f2066d.f2100i.f2068f == e.a.MATCH_CONSTRAINT && this.f2066d.f2100i.f2065c == 3 && this.f2066d.j.f2068f == e.a.MATCH_CONSTRAINT && this.f2066d.j.f2065c == 3)) {
                    e eVar3 = this.f2066d;
                    p pVar2 = i2 == 0 ? eVar3.j : eVar3.f2100i;
                    if (pVar2.f2069g.j) {
                        float f3 = this.f2066d.Y;
                        if (i2 == 1) {
                            i3 = (int) ((((float) pVar2.f2069g.f2033g) / f3) + 0.5f);
                        } else {
                            i3 = (int) ((f3 * ((float) pVar2.f2069g.f2033g)) + 0.5f);
                        }
                        this.f2069g.a(i3);
                    }
                }
            }
            if (this.f2069g.j) {
                if (this.f2069g.f2033g == i4) {
                    this.j.a(e2);
                    this.k.a(e3);
                    return;
                }
                e eVar4 = this.f2066d;
                if (i2 == 0) {
                    f2 = eVar4.ak;
                } else {
                    f2 = eVar4.al;
                }
                if (a2 == a3) {
                    e2 = a2.f2033g;
                    e3 = a3.f2033g;
                    f2 = 0.5f;
                }
                this.j.a((int) (((float) e2) + 0.5f + (((float) ((e3 - e2) - this.f2069g.f2033g)) * f2)));
                this.k.a(this.j.f2033g + this.f2069g.f2033g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int a(int i2, int i3) {
        if (i3 == 0) {
            int i4 = this.f2066d.t;
            int max = Math.max(this.f2066d.s, i2);
            if (i4 > 0) {
                max = Math.min(i4, i2);
            }
            if (max != i2) {
                return max;
            }
            return i2;
        }
        int i5 = this.f2066d.w;
        int min = i5 > 0 ? Math.min(i5, i2) : Math.max(this.f2066d.v, i2);
        return min != i2 ? min : i2;
    }

    protected static f a(d dVar, int i2) {
        if (dVar.f2087f == null) {
            return null;
        }
        e eVar = dVar.f2087f.f2085d;
        p pVar = i2 == 0 ? eVar.f2100i : eVar.j;
        int i3 = AnonymousClass1.f2072a[dVar.f2087f.f2086e.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return null;
                    }
                }
            }
            return pVar.k;
        }
        return pVar.j;
    }

    protected static void a(f fVar, f fVar2, int i2) {
        fVar.l.add(fVar2);
        fVar.f2032f = i2;
        fVar2.k.add(fVar);
    }

    /* access modifiers changed from: protected */
    public final void a(f fVar, f fVar2, int i2, g gVar) {
        fVar.l.add(fVar2);
        fVar.l.add(this.f2069g);
        fVar.f2034h = i2;
        fVar.f2035i = gVar;
        fVar2.k.add(fVar);
        gVar.k.add(fVar);
    }

    public long b() {
        if (this.f2069g.j) {
            return (long) this.f2069g.f2033g;
        }
        return 0;
    }
}
