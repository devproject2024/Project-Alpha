package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.a.f;
import androidx.constraintlayout.a.a.a.p;
import androidx.constraintlayout.a.a.d;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.i;

public final class n extends p {

    /* renamed from: a  reason: collision with root package name */
    public f f2047a = new f(this);

    /* renamed from: b  reason: collision with root package name */
    g f2048b = null;

    public n(e eVar) {
        super(eVar);
        this.j.f2031e = f.a.TOP;
        this.k.f2031e = f.a.BOTTOM;
        this.f2047a.f2031e = f.a.BASELINE;
        this.f2070h = 1;
    }

    public final String toString() {
        return "VerticalRun " + this.f2066d.ao;
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f2067e = null;
        this.j.a();
        this.k.a();
        this.f2047a.a();
        this.f2069g.a();
        this.f2071i = false;
    }

    public final void g() {
        this.f2071i = false;
        this.j.a();
        this.j.j = false;
        this.k.a();
        this.k.j = false;
        this.f2047a.a();
        this.f2047a.j = false;
        this.f2069g.j = false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        if (this.f2068f != e.a.MATCH_CONSTRAINT || this.f2066d.q == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: androidx.constraintlayout.a.a.a.n$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2049a = new int[p.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                androidx.constraintlayout.a.a.a.p$a[] r0 = androidx.constraintlayout.a.a.a.p.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2049a = r0
                int[] r0 = f2049a     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.constraintlayout.a.a.a.p$a r1 = androidx.constraintlayout.a.a.a.p.a.START     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2049a     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.constraintlayout.a.a.a.p$a r1 = androidx.constraintlayout.a.a.a.p.a.END     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2049a     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.constraintlayout.a.a.a.p$a r1 = androidx.constraintlayout.a.a.a.p.a.CENTER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.a.n.AnonymousClass1.<clinit>():void");
        }
    }

    public final void d() {
        int i2;
        float f2;
        float f3;
        float f4;
        int i3 = AnonymousClass1.f2049a[this.l.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 != 3) {
            if (this.f2069g.f2029c && !this.f2069g.j && this.f2068f == e.a.MATCH_CONSTRAINT) {
                int i4 = this.f2066d.q;
                if (i4 == 2) {
                    e eVar = this.f2066d.V;
                    if (eVar != null && eVar.j.f2069g.j) {
                        float f5 = this.f2066d.x;
                        this.f2069g.a((int) ((((float) eVar.j.f2069g.f2033g) * f5) + 0.5f));
                    }
                } else if (i4 == 3 && this.f2066d.f2100i.f2069g.j) {
                    int t = this.f2066d.t();
                    if (t == -1) {
                        f4 = (float) this.f2066d.f2100i.f2069g.f2033g;
                        f3 = this.f2066d.Y;
                    } else if (t == 0) {
                        f2 = ((float) this.f2066d.f2100i.f2069g.f2033g) * this.f2066d.Y;
                        i2 = (int) (f2 + 0.5f);
                        this.f2069g.a(i2);
                    } else if (t != 1) {
                        i2 = 0;
                        this.f2069g.a(i2);
                    } else {
                        f4 = (float) this.f2066d.f2100i.f2069g.f2033g;
                        f3 = this.f2066d.Y;
                    }
                    f2 = f4 / f3;
                    i2 = (int) (f2 + 0.5f);
                    this.f2069g.a(i2);
                }
            }
            if (this.j.f2029c && this.k.f2029c) {
                if (this.j.j && this.k.j && this.f2069g.j) {
                    return;
                }
                if (this.f2069g.j || this.f2068f != e.a.MATCH_CONSTRAINT || this.f2066d.p != 0 || this.f2066d.w()) {
                    if (!this.f2069g.j && this.f2068f == e.a.MATCH_CONSTRAINT && this.f2065c == 1 && this.j.l.size() > 0 && this.k.l.size() > 0) {
                        int i5 = (this.k.l.get(0).f2033g + this.k.f2032f) - (this.j.l.get(0).f2033g + this.j.f2032f);
                        if (i5 < this.f2069g.m) {
                            this.f2069g.a(i5);
                        } else {
                            this.f2069g.a(this.f2069g.m);
                        }
                    }
                    if (this.f2069g.j && this.j.l.size() > 0 && this.k.l.size() > 0) {
                        f fVar = this.j.l.get(0);
                        f fVar2 = this.k.l.get(0);
                        int i6 = fVar.f2033g + this.j.f2032f;
                        int i7 = fVar2.f2033g + this.k.f2032f;
                        float f6 = this.f2066d.al;
                        if (fVar == fVar2) {
                            i6 = fVar.f2033g;
                            i7 = fVar2.f2033g;
                            f6 = 0.5f;
                        }
                        this.j.a((int) (((float) i6) + 0.5f + (((float) ((i7 - i6) - this.f2069g.f2033g)) * f6)));
                        this.k.a(this.j.f2033g + this.f2069g.f2033g);
                        return;
                    }
                    return;
                }
                int i8 = this.j.l.get(0).f2033g + this.j.f2032f;
                int i9 = this.k.l.get(0).f2033g + this.k.f2032f;
                this.j.a(i8);
                this.k.a(i9);
                this.f2069g.a(i9 - i8);
                return;
            }
            return;
        }
        a(this.f2066d.K, this.f2066d.M, 1);
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        e eVar;
        e eVar2;
        if (this.f2066d.f2096e) {
            this.f2069g.a(this.f2066d.o());
        }
        if (!this.f2069g.j) {
            this.f2068f = this.f2066d.U[1];
            if (this.f2066d.E) {
                this.f2048b = new a(this);
            }
            if (this.f2068f != e.a.MATCH_CONSTRAINT) {
                if (this.f2068f == e.a.MATCH_PARENT && (eVar2 = this.f2066d.V) != null && eVar2.U[1] == e.a.FIXED) {
                    int o = (eVar2.o() - this.f2066d.K.e()) - this.f2066d.M.e();
                    a(this.j, eVar2.j.j, this.f2066d.K.e());
                    a(this.k, eVar2.j.k, -this.f2066d.M.e());
                    this.f2069g.a(o);
                    return;
                } else if (this.f2068f == e.a.FIXED) {
                    this.f2069g.a(this.f2066d.o());
                }
            }
        } else if (this.f2068f == e.a.MATCH_PARENT && (eVar = this.f2066d.V) != null && eVar.U[1] == e.a.FIXED) {
            a(this.j, eVar.j.j, this.f2066d.K.e());
            a(this.k, eVar.j.k, -this.f2066d.M.e());
            return;
        }
        if (!this.f2069g.j || !this.f2066d.f2096e) {
            if (this.f2069g.j || this.f2068f != e.a.MATCH_CONSTRAINT) {
                this.f2069g.a((d) this);
            } else {
                int i2 = this.f2066d.q;
                if (i2 == 2) {
                    e eVar3 = this.f2066d.V;
                    if (eVar3 != null) {
                        g gVar = eVar3.j.f2069g;
                        this.f2069g.l.add(gVar);
                        gVar.k.add(this.f2069g);
                        this.f2069g.f2028b = true;
                        this.f2069g.k.add(this.j);
                        this.f2069g.k.add(this.k);
                    }
                } else if (i2 == 3 && !this.f2066d.w() && this.f2066d.p != 3) {
                    g gVar2 = this.f2066d.f2100i.f2069g;
                    this.f2069g.l.add(gVar2);
                    gVar2.k.add(this.f2069g);
                    this.f2069g.f2028b = true;
                    this.f2069g.k.add(this.j);
                    this.f2069g.k.add(this.k);
                }
            }
            if (this.f2066d.R[2].f2087f != null && this.f2066d.R[3].f2087f != null) {
                if (this.f2066d.w()) {
                    this.j.f2032f = this.f2066d.R[2].e();
                    this.k.f2032f = -this.f2066d.R[3].e();
                } else {
                    f a2 = a(this.f2066d.R[2]);
                    f a3 = a(this.f2066d.R[3]);
                    a2.a((d) this);
                    a3.a((d) this);
                    this.l = p.a.CENTER;
                }
                if (this.f2066d.E) {
                    a(this.f2047a, this.j, 1, this.f2048b);
                }
            } else if (this.f2066d.R[2].f2087f != null) {
                f a4 = a(this.f2066d.R[2]);
                if (a4 != null) {
                    a(this.j, a4, this.f2066d.R[2].e());
                    a(this.k, this.j, 1, this.f2069g);
                    if (this.f2066d.E) {
                        a(this.f2047a, this.j, 1, this.f2048b);
                    }
                    if (this.f2068f == e.a.MATCH_CONSTRAINT && this.f2066d.Y > 0.0f && this.f2066d.f2100i.f2068f == e.a.MATCH_CONSTRAINT) {
                        this.f2066d.f2100i.f2069g.k.add(this.f2069g);
                        this.f2069g.l.add(this.f2066d.f2100i.f2069g);
                        this.f2069g.f2027a = this;
                    }
                }
            } else if (this.f2066d.R[3].f2087f != null) {
                f a5 = a(this.f2066d.R[3]);
                if (a5 != null) {
                    a(this.k, a5, -this.f2066d.R[3].e());
                    a(this.j, this.k, -1, this.f2069g);
                    if (this.f2066d.E) {
                        a(this.f2047a, this.j, 1, this.f2048b);
                    }
                }
            } else if (this.f2066d.R[4].f2087f != null) {
                f a6 = a(this.f2066d.R[4]);
                if (a6 != null) {
                    a(this.f2047a, a6, 0);
                    a(this.j, this.f2047a, -1, this.f2048b);
                    a(this.k, this.j, 1, this.f2069g);
                }
            } else if (!(this.f2066d instanceof i) && this.f2066d.V != null) {
                a(this.j, this.f2066d.V.j.j, this.f2066d.m());
                a(this.k, this.j, 1, this.f2069g);
                if (this.f2066d.E) {
                    a(this.f2047a, this.j, 1, this.f2048b);
                }
                if (this.f2068f == e.a.MATCH_CONSTRAINT && this.f2066d.Y > 0.0f && this.f2066d.f2100i.f2068f == e.a.MATCH_CONSTRAINT) {
                    this.f2066d.f2100i.f2069g.k.add(this.f2069g);
                    this.f2069g.l.add(this.f2066d.f2100i.f2069g);
                    this.f2069g.f2027a = this;
                }
            }
            if (this.f2069g.l.size() == 0) {
                this.f2069g.f2029c = true;
            }
        } else if (this.f2066d.R[2].f2087f != null && this.f2066d.R[3].f2087f != null) {
            if (this.f2066d.w()) {
                this.j.f2032f = this.f2066d.R[2].e();
                this.k.f2032f = -this.f2066d.R[3].e();
            } else {
                f a7 = a(this.f2066d.R[2]);
                if (a7 != null) {
                    a(this.j, a7, this.f2066d.R[2].e());
                }
                f a8 = a(this.f2066d.R[3]);
                if (a8 != null) {
                    a(this.k, a8, -this.f2066d.R[3].e());
                }
                this.j.f2028b = true;
                this.k.f2028b = true;
            }
            if (this.f2066d.E) {
                a(this.f2047a, this.j, this.f2066d.ag);
            }
        } else if (this.f2066d.R[2].f2087f != null) {
            f a9 = a(this.f2066d.R[2]);
            if (a9 != null) {
                a(this.j, a9, this.f2066d.R[2].e());
                a(this.k, this.j, this.f2069g.f2033g);
                if (this.f2066d.E) {
                    a(this.f2047a, this.j, this.f2066d.ag);
                }
            }
        } else if (this.f2066d.R[3].f2087f != null) {
            f a10 = a(this.f2066d.R[3]);
            if (a10 != null) {
                a(this.k, a10, -this.f2066d.R[3].e());
                a(this.j, this.k, -this.f2069g.f2033g);
            }
            if (this.f2066d.E) {
                a(this.f2047a, this.j, this.f2066d.ag);
            }
        } else if (this.f2066d.R[4].f2087f != null) {
            f a11 = a(this.f2066d.R[4]);
            if (a11 != null) {
                a(this.f2047a, a11, 0);
                a(this.j, this.f2047a, -this.f2066d.ag);
                a(this.k, this.j, this.f2069g.f2033g);
            }
        } else if (!(this.f2066d instanceof i) && this.f2066d.V != null && this.f2066d.a(d.a.CENTER).f2087f == null) {
            a(this.j, this.f2066d.V.j.j, this.f2066d.m());
            a(this.k, this.j, this.f2069g.f2033g);
            if (this.f2066d.E) {
                a(this.f2047a, this.j, this.f2066d.ag);
            }
        }
    }

    public final void e() {
        if (this.j.j) {
            this.f2066d.f(this.j.f2033g);
        }
    }
}
