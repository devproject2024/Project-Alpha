package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.a.f;
import androidx.constraintlayout.a.a.a.p;
import androidx.constraintlayout.a.a.d;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.i;

public final class l extends p {

    /* renamed from: a  reason: collision with root package name */
    private static int[] f2037a = new int[2];

    public l(e eVar) {
        super(eVar);
        this.j.f2031e = f.a.LEFT;
        this.k.f2031e = f.a.RIGHT;
        this.f2070h = 0;
    }

    public final String toString() {
        return "HorizontalRun " + this.f2066d.ao;
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f2067e = null;
        this.j.a();
        this.k.a();
        this.f2069g.a();
        this.f2071i = false;
    }

    public final void g() {
        this.f2071i = false;
        this.j.a();
        this.j.j = false;
        this.k.a();
        this.k.j = false;
        this.f2069g.j = false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        if (this.f2068f != e.a.MATCH_CONSTRAINT || this.f2066d.p == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        e eVar;
        e eVar2;
        if (this.f2066d.f2096e) {
            this.f2069g.a(this.f2066d.n());
        }
        if (!this.f2069g.j) {
            this.f2068f = this.f2066d.U[0];
            if (this.f2068f != e.a.MATCH_CONSTRAINT) {
                if (this.f2068f == e.a.MATCH_PARENT && (((eVar2 = this.f2066d.V) != null && eVar2.U[0] == e.a.FIXED) || eVar2.U[0] == e.a.MATCH_PARENT)) {
                    int n = (eVar2.n() - this.f2066d.J.e()) - this.f2066d.L.e();
                    a(this.j, eVar2.f2100i.j, this.f2066d.J.e());
                    a(this.k, eVar2.f2100i.k, -this.f2066d.L.e());
                    this.f2069g.a(n);
                    return;
                } else if (this.f2068f == e.a.FIXED) {
                    this.f2069g.a(this.f2066d.n());
                }
            }
        } else if (this.f2068f == e.a.MATCH_PARENT && (((eVar = this.f2066d.V) != null && eVar.U[0] == e.a.FIXED) || eVar.U[0] == e.a.MATCH_PARENT)) {
            a(this.j, eVar.f2100i.j, this.f2066d.J.e());
            a(this.k, eVar.f2100i.k, -this.f2066d.L.e());
            return;
        }
        if (!this.f2069g.j || !this.f2066d.f2096e) {
            if (this.f2068f == e.a.MATCH_CONSTRAINT) {
                int i2 = this.f2066d.p;
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
                } else if (i2 == 3) {
                    if (this.f2066d.q == 3) {
                        this.j.f2027a = this;
                        this.k.f2027a = this;
                        this.f2066d.j.j.f2027a = this;
                        this.f2066d.j.k.f2027a = this;
                        this.f2069g.f2027a = this;
                        if (this.f2066d.w()) {
                            this.f2069g.l.add(this.f2066d.j.f2069g);
                            this.f2066d.j.f2069g.k.add(this.f2069g);
                            this.f2066d.j.f2069g.f2027a = this;
                            this.f2069g.l.add(this.f2066d.j.j);
                            this.f2069g.l.add(this.f2066d.j.k);
                            this.f2066d.j.j.k.add(this.f2069g);
                            this.f2066d.j.k.k.add(this.f2069g);
                        } else if (this.f2066d.v()) {
                            this.f2066d.j.f2069g.l.add(this.f2069g);
                            this.f2069g.k.add(this.f2066d.j.f2069g);
                        } else {
                            this.f2066d.j.f2069g.l.add(this.f2069g);
                        }
                    } else {
                        g gVar2 = this.f2066d.j.f2069g;
                        this.f2069g.l.add(gVar2);
                        gVar2.k.add(this.f2069g);
                        this.f2066d.j.j.k.add(this.f2069g);
                        this.f2066d.j.k.k.add(this.f2069g);
                        this.f2069g.f2028b = true;
                        this.f2069g.k.add(this.j);
                        this.f2069g.k.add(this.k);
                        this.j.l.add(this.f2069g);
                        this.k.l.add(this.f2069g);
                    }
                }
            }
            if (this.f2066d.R[0].f2087f == null || this.f2066d.R[1].f2087f == null) {
                if (this.f2066d.R[0].f2087f != null) {
                    f a2 = a(this.f2066d.R[0]);
                    if (a2 != null) {
                        a(this.j, a2, this.f2066d.R[0].e());
                        a(this.k, this.j, 1, this.f2069g);
                    }
                } else if (this.f2066d.R[1].f2087f != null) {
                    f a3 = a(this.f2066d.R[1]);
                    if (a3 != null) {
                        a(this.k, a3, -this.f2066d.R[1].e());
                        a(this.j, this.k, -1, this.f2069g);
                    }
                } else if (!(this.f2066d instanceof i) && this.f2066d.V != null) {
                    a(this.j, this.f2066d.V.f2100i.j, this.f2066d.l());
                    a(this.k, this.j, 1, this.f2069g);
                }
            } else if (this.f2066d.v()) {
                this.j.f2032f = this.f2066d.R[0].e();
                this.k.f2032f = -this.f2066d.R[1].e();
            } else {
                f a4 = a(this.f2066d.R[0]);
                f a5 = a(this.f2066d.R[1]);
                a4.a((d) this);
                a5.a((d) this);
                this.l = p.a.CENTER;
            }
        } else if (this.f2066d.R[0].f2087f == null || this.f2066d.R[1].f2087f == null) {
            if (this.f2066d.R[0].f2087f != null) {
                f a6 = a(this.f2066d.R[0]);
                if (a6 != null) {
                    a(this.j, a6, this.f2066d.R[0].e());
                    a(this.k, this.j, this.f2069g.f2033g);
                }
            } else if (this.f2066d.R[1].f2087f != null) {
                f a7 = a(this.f2066d.R[1]);
                if (a7 != null) {
                    a(this.k, a7, -this.f2066d.R[1].e());
                    a(this.j, this.k, -this.f2069g.f2033g);
                }
            } else if (!(this.f2066d instanceof i) && this.f2066d.V != null && this.f2066d.a(d.a.CENTER).f2087f == null) {
                a(this.j, this.f2066d.V.f2100i.j, this.f2066d.l());
                a(this.k, this.j, this.f2069g.f2033g);
            }
        } else if (this.f2066d.v()) {
            this.j.f2032f = this.f2066d.R[0].e();
            this.k.f2032f = -this.f2066d.R[1].e();
        } else {
            f a8 = a(this.f2066d.R[0]);
            if (a8 != null) {
                a(this.j, a8, this.f2066d.R[0].e());
            }
            f a9 = a(this.f2066d.R[1]);
            if (a9 != null) {
                a(this.k, a9, -this.f2066d.R[1].e());
            }
            this.j.f2028b = true;
            this.k.f2028b = true;
        }
    }

    private static void a(int[] iArr, int i2, int i3, int i4, int i5, float f2, int i6) {
        int i7 = i3 - i2;
        int i8 = i5 - i4;
        if (i6 == -1) {
            int i9 = (int) ((((float) i8) * f2) + 0.5f);
            int i10 = (int) ((((float) i7) / f2) + 0.5f);
            if (i9 <= i7 && i8 <= i8) {
                iArr[0] = i9;
                iArr[1] = i8;
            } else if (i7 <= i7 && i10 <= i8) {
                iArr[0] = i7;
                iArr[1] = i10;
            }
        } else if (i6 == 0) {
            iArr[0] = (int) ((((float) i8) * f2) + 0.5f);
            iArr[1] = i8;
        } else if (i6 == 1) {
            iArr[0] = i7;
            iArr[1] = (int) ((((float) i7) * f2) + 0.5f);
        }
    }

    /* renamed from: androidx.constraintlayout.a.a.a.l$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2038a = new int[p.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                androidx.constraintlayout.a.a.a.p$a[] r0 = androidx.constraintlayout.a.a.a.p.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2038a = r0
                int[] r0 = f2038a     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.constraintlayout.a.a.a.p$a r1 = androidx.constraintlayout.a.a.a.p.a.START     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2038a     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.constraintlayout.a.a.a.p$a r1 = androidx.constraintlayout.a.a.a.p.a.END     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2038a     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.constraintlayout.a.a.a.p$a r1 = androidx.constraintlayout.a.a.a.p.a.CENTER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.a.l.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02d0, code lost:
        if (r11 != 1) goto L_0x033c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r19 = this;
            r0 = r19
            int[] r1 = androidx.constraintlayout.a.a.a.l.AnonymousClass1.f2038a
            androidx.constraintlayout.a.a.a.p$a r2 = r0.l
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 2
            r3 = 3
            r4 = 1
            r5 = 0
            if (r1 == r4) goto L_0x0023
            if (r1 == r2) goto L_0x0023
            if (r1 == r3) goto L_0x0017
            goto L_0x0023
        L_0x0017:
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.d r1 = r1.J
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            androidx.constraintlayout.a.a.d r2 = r2.L
            r0.a((androidx.constraintlayout.a.a.d) r1, (androidx.constraintlayout.a.a.d) r2, (int) r5)
            return
        L_0x0023:
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            boolean r1 = r1.j
            r6 = 1056964608(0x3f000000, float:0.5)
            if (r1 != 0) goto L_0x033c
            androidx.constraintlayout.a.a.e$a r1 = r0.f2068f
            androidx.constraintlayout.a.a.e$a r7 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r1 != r7) goto L_0x033c
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            int r1 = r1.p
            if (r1 == r2) goto L_0x031a
            if (r1 == r3) goto L_0x003b
            goto L_0x033c
        L_0x003b:
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            int r1 = r1.q
            r2 = -1
            if (r1 == 0) goto L_0x008c
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            int r1 = r1.q
            if (r1 != r3) goto L_0x0049
            goto L_0x008c
        L_0x0049:
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            int r1 = r1.t()
            if (r1 == r2) goto L_0x0074
            if (r1 == 0) goto L_0x0065
            if (r1 == r4) goto L_0x0057
            r1 = 0
            goto L_0x0085
        L_0x0057:
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r1 = r1.j
            androidx.constraintlayout.a.a.a.g r1 = r1.f2069g
            int r1 = r1.f2033g
            float r1 = (float) r1
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            float r2 = r2.Y
            goto L_0x0081
        L_0x0065:
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r1 = r1.j
            androidx.constraintlayout.a.a.a.g r1 = r1.f2069g
            int r1 = r1.f2033g
            float r1 = (float) r1
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            float r2 = r2.Y
            float r1 = r1 / r2
            goto L_0x0083
        L_0x0074:
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r1 = r1.j
            androidx.constraintlayout.a.a.a.g r1 = r1.f2069g
            int r1 = r1.f2033g
            float r1 = (float) r1
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            float r2 = r2.Y
        L_0x0081:
            float r1 = r1 * r2
        L_0x0083:
            float r1 = r1 + r6
            int r1 = (int) r1
        L_0x0085:
            androidx.constraintlayout.a.a.a.g r2 = r0.f2069g
            r2.a(r1)
            goto L_0x033c
        L_0x008c:
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r1 = r1.j
            androidx.constraintlayout.a.a.a.f r1 = r1.j
            androidx.constraintlayout.a.a.e r3 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r3 = r3.j
            androidx.constraintlayout.a.a.a.f r3 = r3.k
            androidx.constraintlayout.a.a.e r7 = r0.f2066d
            androidx.constraintlayout.a.a.d r7 = r7.J
            androidx.constraintlayout.a.a.d r7 = r7.f2087f
            if (r7 == 0) goto L_0x00a2
            r7 = 1
            goto L_0x00a3
        L_0x00a2:
            r7 = 0
        L_0x00a3:
            androidx.constraintlayout.a.a.e r8 = r0.f2066d
            androidx.constraintlayout.a.a.d r8 = r8.K
            androidx.constraintlayout.a.a.d r8 = r8.f2087f
            if (r8 == 0) goto L_0x00ad
            r8 = 1
            goto L_0x00ae
        L_0x00ad:
            r8 = 0
        L_0x00ae:
            androidx.constraintlayout.a.a.e r9 = r0.f2066d
            androidx.constraintlayout.a.a.d r9 = r9.L
            androidx.constraintlayout.a.a.d r9 = r9.f2087f
            if (r9 == 0) goto L_0x00b8
            r9 = 1
            goto L_0x00b9
        L_0x00b8:
            r9 = 0
        L_0x00b9:
            androidx.constraintlayout.a.a.e r10 = r0.f2066d
            androidx.constraintlayout.a.a.d r10 = r10.M
            androidx.constraintlayout.a.a.d r10 = r10.f2087f
            if (r10 == 0) goto L_0x00c3
            r10 = 1
            goto L_0x00c4
        L_0x00c3:
            r10 = 0
        L_0x00c4:
            androidx.constraintlayout.a.a.e r11 = r0.f2066d
            int r11 = r11.t()
            if (r7 == 0) goto L_0x0218
            if (r8 == 0) goto L_0x0218
            if (r9 == 0) goto L_0x0218
            if (r10 == 0) goto L_0x0218
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            float r2 = r2.Y
            boolean r7 = r1.j
            if (r7 == 0) goto L_0x013b
            boolean r7 = r3.j
            if (r7 == 0) goto L_0x013b
            androidx.constraintlayout.a.a.a.f r6 = r0.j
            boolean r6 = r6.f2029c
            if (r6 == 0) goto L_0x013a
            androidx.constraintlayout.a.a.a.f r6 = r0.k
            boolean r6 = r6.f2029c
            if (r6 != 0) goto L_0x00eb
            goto L_0x013a
        L_0x00eb:
            androidx.constraintlayout.a.a.a.f r6 = r0.j
            java.util.List<androidx.constraintlayout.a.a.a.f> r6 = r6.l
            java.lang.Object r6 = r6.get(r5)
            androidx.constraintlayout.a.a.a.f r6 = (androidx.constraintlayout.a.a.a.f) r6
            int r6 = r6.f2033g
            androidx.constraintlayout.a.a.a.f r7 = r0.j
            int r7 = r7.f2032f
            int r13 = r6 + r7
            androidx.constraintlayout.a.a.a.f r6 = r0.k
            java.util.List<androidx.constraintlayout.a.a.a.f> r6 = r6.l
            java.lang.Object r6 = r6.get(r5)
            androidx.constraintlayout.a.a.a.f r6 = (androidx.constraintlayout.a.a.a.f) r6
            int r6 = r6.f2033g
            androidx.constraintlayout.a.a.a.f r7 = r0.k
            int r7 = r7.f2032f
            int r14 = r6 - r7
            int r6 = r1.f2033g
            int r1 = r1.f2032f
            int r15 = r6 + r1
            int r1 = r3.f2033g
            int r3 = r3.f2032f
            int r16 = r1 - r3
            int[] r12 = f2037a
            r17 = r2
            r18 = r11
            a(r12, r13, r14, r15, r16, r17, r18)
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            int[] r2 = f2037a
            r2 = r2[r5]
            r1.a(r2)
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r1 = r1.j
            androidx.constraintlayout.a.a.a.g r1 = r1.f2069g
            int[] r2 = f2037a
            r2 = r2[r4]
            r1.a(r2)
        L_0x013a:
            return
        L_0x013b:
            androidx.constraintlayout.a.a.a.f r7 = r0.j
            boolean r7 = r7.j
            if (r7 == 0) goto L_0x01a1
            androidx.constraintlayout.a.a.a.f r7 = r0.k
            boolean r7 = r7.j
            if (r7 == 0) goto L_0x01a1
            boolean r7 = r1.f2029c
            if (r7 == 0) goto L_0x01a0
            boolean r7 = r3.f2029c
            if (r7 != 0) goto L_0x0150
            goto L_0x01a0
        L_0x0150:
            androidx.constraintlayout.a.a.a.f r7 = r0.j
            int r7 = r7.f2033g
            androidx.constraintlayout.a.a.a.f r8 = r0.j
            int r8 = r8.f2032f
            int r13 = r7 + r8
            androidx.constraintlayout.a.a.a.f r7 = r0.k
            int r7 = r7.f2033g
            androidx.constraintlayout.a.a.a.f r8 = r0.k
            int r8 = r8.f2032f
            int r14 = r7 - r8
            java.util.List<androidx.constraintlayout.a.a.a.f> r7 = r1.l
            java.lang.Object r7 = r7.get(r5)
            androidx.constraintlayout.a.a.a.f r7 = (androidx.constraintlayout.a.a.a.f) r7
            int r7 = r7.f2033g
            int r8 = r1.f2032f
            int r15 = r7 + r8
            java.util.List<androidx.constraintlayout.a.a.a.f> r7 = r3.l
            java.lang.Object r7 = r7.get(r5)
            androidx.constraintlayout.a.a.a.f r7 = (androidx.constraintlayout.a.a.a.f) r7
            int r7 = r7.f2033g
            int r8 = r3.f2032f
            int r16 = r7 - r8
            int[] r12 = f2037a
            r17 = r2
            r18 = r11
            a(r12, r13, r14, r15, r16, r17, r18)
            androidx.constraintlayout.a.a.a.g r7 = r0.f2069g
            int[] r8 = f2037a
            r8 = r8[r5]
            r7.a(r8)
            androidx.constraintlayout.a.a.e r7 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r7 = r7.j
            androidx.constraintlayout.a.a.a.g r7 = r7.f2069g
            int[] r8 = f2037a
            r8 = r8[r4]
            r7.a(r8)
            goto L_0x01a1
        L_0x01a0:
            return
        L_0x01a1:
            androidx.constraintlayout.a.a.a.f r7 = r0.j
            boolean r7 = r7.f2029c
            if (r7 == 0) goto L_0x0217
            androidx.constraintlayout.a.a.a.f r7 = r0.k
            boolean r7 = r7.f2029c
            if (r7 == 0) goto L_0x0217
            boolean r7 = r1.f2029c
            if (r7 == 0) goto L_0x0217
            boolean r7 = r3.f2029c
            if (r7 != 0) goto L_0x01b6
            goto L_0x0217
        L_0x01b6:
            androidx.constraintlayout.a.a.a.f r7 = r0.j
            java.util.List<androidx.constraintlayout.a.a.a.f> r7 = r7.l
            java.lang.Object r7 = r7.get(r5)
            androidx.constraintlayout.a.a.a.f r7 = (androidx.constraintlayout.a.a.a.f) r7
            int r7 = r7.f2033g
            androidx.constraintlayout.a.a.a.f r8 = r0.j
            int r8 = r8.f2032f
            int r13 = r7 + r8
            androidx.constraintlayout.a.a.a.f r7 = r0.k
            java.util.List<androidx.constraintlayout.a.a.a.f> r7 = r7.l
            java.lang.Object r7 = r7.get(r5)
            androidx.constraintlayout.a.a.a.f r7 = (androidx.constraintlayout.a.a.a.f) r7
            int r7 = r7.f2033g
            androidx.constraintlayout.a.a.a.f r8 = r0.k
            int r8 = r8.f2032f
            int r14 = r7 - r8
            java.util.List<androidx.constraintlayout.a.a.a.f> r7 = r1.l
            java.lang.Object r7 = r7.get(r5)
            androidx.constraintlayout.a.a.a.f r7 = (androidx.constraintlayout.a.a.a.f) r7
            int r7 = r7.f2033g
            int r1 = r1.f2032f
            int r15 = r7 + r1
            java.util.List<androidx.constraintlayout.a.a.a.f> r1 = r3.l
            java.lang.Object r1 = r1.get(r5)
            androidx.constraintlayout.a.a.a.f r1 = (androidx.constraintlayout.a.a.a.f) r1
            int r1 = r1.f2033g
            int r3 = r3.f2032f
            int r16 = r1 - r3
            int[] r12 = f2037a
            r17 = r2
            r18 = r11
            a(r12, r13, r14, r15, r16, r17, r18)
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            int[] r2 = f2037a
            r2 = r2[r5]
            r1.a(r2)
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r1 = r1.j
            androidx.constraintlayout.a.a.a.g r1 = r1.f2069g
            int[] r2 = f2037a
            r2 = r2[r4]
            r1.a(r2)
            goto L_0x033c
        L_0x0217:
            return
        L_0x0218:
            if (r7 == 0) goto L_0x02a1
            if (r9 == 0) goto L_0x02a1
            androidx.constraintlayout.a.a.a.f r1 = r0.j
            boolean r1 = r1.f2029c
            if (r1 == 0) goto L_0x02a0
            androidx.constraintlayout.a.a.a.f r1 = r0.k
            boolean r1 = r1.f2029c
            if (r1 != 0) goto L_0x022a
            goto L_0x02a0
        L_0x022a:
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            float r1 = r1.Y
            androidx.constraintlayout.a.a.a.f r3 = r0.j
            java.util.List<androidx.constraintlayout.a.a.a.f> r3 = r3.l
            java.lang.Object r3 = r3.get(r5)
            androidx.constraintlayout.a.a.a.f r3 = (androidx.constraintlayout.a.a.a.f) r3
            int r3 = r3.f2033g
            androidx.constraintlayout.a.a.a.f r7 = r0.j
            int r7 = r7.f2032f
            int r3 = r3 + r7
            androidx.constraintlayout.a.a.a.f r7 = r0.k
            java.util.List<androidx.constraintlayout.a.a.a.f> r7 = r7.l
            java.lang.Object r7 = r7.get(r5)
            androidx.constraintlayout.a.a.a.f r7 = (androidx.constraintlayout.a.a.a.f) r7
            int r7 = r7.f2033g
            androidx.constraintlayout.a.a.a.f r8 = r0.k
            int r8 = r8.f2032f
            int r7 = r7 - r8
            if (r11 == r2) goto L_0x027c
            if (r11 == 0) goto L_0x027c
            if (r11 == r4) goto L_0x0258
            goto L_0x033c
        L_0x0258:
            int r7 = r7 - r3
            int r2 = r0.a((int) r7, (int) r5)
            float r3 = (float) r2
            float r3 = r3 / r1
            float r3 = r3 + r6
            int r3 = (int) r3
            int r7 = r0.a((int) r3, (int) r4)
            if (r3 == r7) goto L_0x026c
            float r2 = (float) r7
            float r2 = r2 * r1
            float r2 = r2 + r6
            int r2 = (int) r2
        L_0x026c:
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            r1.a(r2)
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r1 = r1.j
            androidx.constraintlayout.a.a.a.g r1 = r1.f2069g
            r1.a(r7)
            goto L_0x033c
        L_0x027c:
            int r7 = r7 - r3
            int r2 = r0.a((int) r7, (int) r5)
            float r3 = (float) r2
            float r3 = r3 * r1
            float r3 = r3 + r6
            int r3 = (int) r3
            int r7 = r0.a((int) r3, (int) r4)
            if (r3 == r7) goto L_0x0290
            float r2 = (float) r7
            float r2 = r2 / r1
            float r2 = r2 + r6
            int r2 = (int) r2
        L_0x0290:
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            r1.a(r2)
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r1 = r1.j
            androidx.constraintlayout.a.a.a.g r1 = r1.f2069g
            r1.a(r7)
            goto L_0x033c
        L_0x02a0:
            return
        L_0x02a1:
            if (r8 == 0) goto L_0x033c
            if (r10 == 0) goto L_0x033c
            boolean r7 = r1.f2029c
            if (r7 == 0) goto L_0x0319
            boolean r7 = r3.f2029c
            if (r7 != 0) goto L_0x02ae
            goto L_0x0319
        L_0x02ae:
            androidx.constraintlayout.a.a.e r7 = r0.f2066d
            float r7 = r7.Y
            java.util.List<androidx.constraintlayout.a.a.a.f> r8 = r1.l
            java.lang.Object r8 = r8.get(r5)
            androidx.constraintlayout.a.a.a.f r8 = (androidx.constraintlayout.a.a.a.f) r8
            int r8 = r8.f2033g
            int r1 = r1.f2032f
            int r8 = r8 + r1
            java.util.List<androidx.constraintlayout.a.a.a.f> r1 = r3.l
            java.lang.Object r1 = r1.get(r5)
            androidx.constraintlayout.a.a.a.f r1 = (androidx.constraintlayout.a.a.a.f) r1
            int r1 = r1.f2033g
            int r3 = r3.f2032f
            int r1 = r1 - r3
            if (r11 == r2) goto L_0x02f6
            if (r11 == 0) goto L_0x02d3
            if (r11 == r4) goto L_0x02f6
            goto L_0x033c
        L_0x02d3:
            int r1 = r1 - r8
            int r1 = r0.a((int) r1, (int) r4)
            float r2 = (float) r1
            float r2 = r2 * r7
            float r2 = r2 + r6
            int r2 = (int) r2
            int r3 = r0.a((int) r2, (int) r5)
            if (r2 == r3) goto L_0x02e7
            float r1 = (float) r3
            float r1 = r1 / r7
            float r1 = r1 + r6
            int r1 = (int) r1
        L_0x02e7:
            androidx.constraintlayout.a.a.a.g r2 = r0.f2069g
            r2.a(r3)
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r2 = r2.j
            androidx.constraintlayout.a.a.a.g r2 = r2.f2069g
            r2.a(r1)
            goto L_0x033c
        L_0x02f6:
            int r1 = r1 - r8
            int r1 = r0.a((int) r1, (int) r4)
            float r2 = (float) r1
            float r2 = r2 / r7
            float r2 = r2 + r6
            int r2 = (int) r2
            int r3 = r0.a((int) r2, (int) r5)
            if (r2 == r3) goto L_0x030a
            float r1 = (float) r3
            float r1 = r1 * r7
            float r1 = r1 + r6
            int r1 = (int) r1
        L_0x030a:
            androidx.constraintlayout.a.a.a.g r2 = r0.f2069g
            r2.a(r3)
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            androidx.constraintlayout.a.a.a.n r2 = r2.j
            androidx.constraintlayout.a.a.a.g r2 = r2.f2069g
            r2.a(r1)
            goto L_0x033c
        L_0x0319:
            return
        L_0x031a:
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.e r1 = r1.V
            if (r1 == 0) goto L_0x033c
            androidx.constraintlayout.a.a.a.l r2 = r1.f2100i
            androidx.constraintlayout.a.a.a.g r2 = r2.f2069g
            boolean r2 = r2.j
            if (r2 == 0) goto L_0x033c
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            float r2 = r2.u
            androidx.constraintlayout.a.a.a.l r1 = r1.f2100i
            androidx.constraintlayout.a.a.a.g r1 = r1.f2069g
            int r1 = r1.f2033g
            float r1 = (float) r1
            float r1 = r1 * r2
            float r1 = r1 + r6
            int r1 = (int) r1
            androidx.constraintlayout.a.a.a.g r2 = r0.f2069g
            r2.a(r1)
        L_0x033c:
            androidx.constraintlayout.a.a.a.f r1 = r0.j
            boolean r1 = r1.f2029c
            if (r1 == 0) goto L_0x0466
            androidx.constraintlayout.a.a.a.f r1 = r0.k
            boolean r1 = r1.f2029c
            if (r1 != 0) goto L_0x034a
            goto L_0x0466
        L_0x034a:
            androidx.constraintlayout.a.a.a.f r1 = r0.j
            boolean r1 = r1.j
            if (r1 == 0) goto L_0x035d
            androidx.constraintlayout.a.a.a.f r1 = r0.k
            boolean r1 = r1.j
            if (r1 == 0) goto L_0x035d
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            boolean r1 = r1.j
            if (r1 == 0) goto L_0x035d
            return
        L_0x035d:
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            boolean r1 = r1.j
            if (r1 != 0) goto L_0x03ab
            androidx.constraintlayout.a.a.e$a r1 = r0.f2068f
            androidx.constraintlayout.a.a.e$a r2 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r1 != r2) goto L_0x03ab
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            int r1 = r1.p
            if (r1 != 0) goto L_0x03ab
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            boolean r1 = r1.v()
            if (r1 != 0) goto L_0x03ab
            androidx.constraintlayout.a.a.a.f r1 = r0.j
            java.util.List<androidx.constraintlayout.a.a.a.f> r1 = r1.l
            java.lang.Object r1 = r1.get(r5)
            androidx.constraintlayout.a.a.a.f r1 = (androidx.constraintlayout.a.a.a.f) r1
            androidx.constraintlayout.a.a.a.f r2 = r0.k
            java.util.List<androidx.constraintlayout.a.a.a.f> r2 = r2.l
            java.lang.Object r2 = r2.get(r5)
            androidx.constraintlayout.a.a.a.f r2 = (androidx.constraintlayout.a.a.a.f) r2
            int r1 = r1.f2033g
            androidx.constraintlayout.a.a.a.f r3 = r0.j
            int r3 = r3.f2032f
            int r1 = r1 + r3
            int r2 = r2.f2033g
            androidx.constraintlayout.a.a.a.f r3 = r0.k
            int r3 = r3.f2032f
            int r2 = r2 + r3
            int r3 = r2 - r1
            androidx.constraintlayout.a.a.a.f r4 = r0.j
            r4.a((int) r1)
            androidx.constraintlayout.a.a.a.f r1 = r0.k
            r1.a((int) r2)
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            r1.a(r3)
            return
        L_0x03ab:
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            boolean r1 = r1.j
            if (r1 != 0) goto L_0x0411
            androidx.constraintlayout.a.a.e$a r1 = r0.f2068f
            androidx.constraintlayout.a.a.e$a r2 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r1 != r2) goto L_0x0411
            int r1 = r0.f2065c
            if (r1 != r4) goto L_0x0411
            androidx.constraintlayout.a.a.a.f r1 = r0.j
            java.util.List<androidx.constraintlayout.a.a.a.f> r1 = r1.l
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0411
            androidx.constraintlayout.a.a.a.f r1 = r0.k
            java.util.List<androidx.constraintlayout.a.a.a.f> r1 = r1.l
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0411
            androidx.constraintlayout.a.a.a.f r1 = r0.j
            java.util.List<androidx.constraintlayout.a.a.a.f> r1 = r1.l
            java.lang.Object r1 = r1.get(r5)
            androidx.constraintlayout.a.a.a.f r1 = (androidx.constraintlayout.a.a.a.f) r1
            androidx.constraintlayout.a.a.a.f r2 = r0.k
            java.util.List<androidx.constraintlayout.a.a.a.f> r2 = r2.l
            java.lang.Object r2 = r2.get(r5)
            androidx.constraintlayout.a.a.a.f r2 = (androidx.constraintlayout.a.a.a.f) r2
            int r1 = r1.f2033g
            androidx.constraintlayout.a.a.a.f r3 = r0.j
            int r3 = r3.f2032f
            int r1 = r1 + r3
            int r2 = r2.f2033g
            androidx.constraintlayout.a.a.a.f r3 = r0.k
            int r3 = r3.f2032f
            int r2 = r2 + r3
            int r2 = r2 - r1
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            int r1 = r1.m
            int r1 = java.lang.Math.min(r2, r1)
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            int r2 = r2.t
            androidx.constraintlayout.a.a.e r3 = r0.f2066d
            int r3 = r3.s
            int r1 = java.lang.Math.max(r3, r1)
            if (r2 <= 0) goto L_0x040c
            int r1 = java.lang.Math.min(r2, r1)
        L_0x040c:
            androidx.constraintlayout.a.a.a.g r2 = r0.f2069g
            r2.a(r1)
        L_0x0411:
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            boolean r1 = r1.j
            if (r1 != 0) goto L_0x0418
            return
        L_0x0418:
            androidx.constraintlayout.a.a.a.f r1 = r0.j
            java.util.List<androidx.constraintlayout.a.a.a.f> r1 = r1.l
            java.lang.Object r1 = r1.get(r5)
            androidx.constraintlayout.a.a.a.f r1 = (androidx.constraintlayout.a.a.a.f) r1
            androidx.constraintlayout.a.a.a.f r2 = r0.k
            java.util.List<androidx.constraintlayout.a.a.a.f> r2 = r2.l
            java.lang.Object r2 = r2.get(r5)
            androidx.constraintlayout.a.a.a.f r2 = (androidx.constraintlayout.a.a.a.f) r2
            int r3 = r1.f2033g
            androidx.constraintlayout.a.a.a.f r4 = r0.j
            int r4 = r4.f2032f
            int r3 = r3 + r4
            int r4 = r2.f2033g
            androidx.constraintlayout.a.a.a.f r5 = r0.k
            int r5 = r5.f2032f
            int r4 = r4 + r5
            androidx.constraintlayout.a.a.e r5 = r0.f2066d
            float r5 = r5.ak
            if (r1 != r2) goto L_0x0446
            int r3 = r1.f2033g
            int r4 = r2.f2033g
            r5 = 1056964608(0x3f000000, float:0.5)
        L_0x0446:
            int r4 = r4 - r3
            androidx.constraintlayout.a.a.a.g r1 = r0.f2069g
            int r1 = r1.f2033g
            int r4 = r4 - r1
            androidx.constraintlayout.a.a.a.f r1 = r0.j
            float r2 = (float) r3
            float r2 = r2 + r6
            float r3 = (float) r4
            float r3 = r3 * r5
            float r2 = r2 + r3
            int r2 = (int) r2
            r1.a((int) r2)
            androidx.constraintlayout.a.a.a.f r1 = r0.k
            androidx.constraintlayout.a.a.a.f r2 = r0.j
            int r2 = r2.f2033g
            androidx.constraintlayout.a.a.a.g r3 = r0.f2069g
            int r3 = r3.f2033g
            int r2 = r2 + r3
            r1.a((int) r2)
        L_0x0466:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.a.l.d():void");
    }

    public final void e() {
        if (this.j.j) {
            this.f2066d.e(this.j.f2033g);
        }
    }
}
