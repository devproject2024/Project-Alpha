package androidx.constraintlayout.a;

import androidx.constraintlayout.a.h;
import java.util.Arrays;
import java.util.HashMap;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f2138a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2139b = true;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f2140c = true;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f2141d = true;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f2142e = true;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f2143f = false;
    public static e o = null;
    public static long p = 0;
    public static long q = 0;
    private static int r = 1000;
    private a A;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2144g = false;

    /* renamed from: h  reason: collision with root package name */
    int f2145h = 0;

    /* renamed from: i  reason: collision with root package name */
    b[] f2146i;
    public boolean j;
    public boolean k;
    int l;
    int m;
    public final c n;
    private HashMap<String, h> s = null;
    private a t;
    private int u = 32;
    private int v;
    private boolean[] w;
    private int x;
    private h[] y;
    private int z;

    interface a {
        h a(boolean[] zArr);

        void a(a aVar);

        boolean b();

        void c();

        h d();

        void d(h hVar);
    }

    class b extends b {
        public b(c cVar) {
            this.f2132e = new i(this, cVar);
        }
    }

    public d() {
        int i2 = this.u;
        this.v = i2;
        this.f2146i = null;
        this.j = false;
        this.k = false;
        this.w = new boolean[i2];
        this.l = 1;
        this.m = 0;
        this.x = i2;
        this.y = new h[r];
        this.z = 0;
        this.f2146i = new b[i2];
        g();
        this.n = new c();
        this.t = new g(this.n);
        if (f2143f) {
            this.A = new b(this.n);
        } else {
            this.A = new b(this.n);
        }
    }

    public static void a(e eVar) {
        o = eVar;
    }

    public static e a() {
        return o;
    }

    private void f() {
        this.u *= 2;
        this.f2146i = (b[]) Arrays.copyOf(this.f2146i, this.u);
        c cVar = this.n;
        cVar.f2137d = (h[]) Arrays.copyOf(cVar.f2137d, this.u);
        int i2 = this.u;
        this.w = new boolean[i2];
        this.v = i2;
        this.x = i2;
        e eVar = o;
        if (eVar != null) {
            eVar.f2151d++;
            e eVar2 = o;
            eVar2.o = Math.max(eVar2.o, (long) this.u);
            e eVar3 = o;
            eVar3.x = eVar3.o;
        }
    }

    private void g() {
        int i2 = 0;
        if (f2143f) {
            while (i2 < this.m) {
                b bVar = this.f2146i[i2];
                if (bVar != null) {
                    this.n.f2134a.a(bVar);
                }
                this.f2146i[i2] = null;
                i2++;
            }
            return;
        }
        while (i2 < this.m) {
            b bVar2 = this.f2146i[i2];
            if (bVar2 != null) {
                this.n.f2135b.a(bVar2);
            }
            this.f2146i[i2] = null;
            i2++;
        }
    }

    public final void b() {
        for (h hVar : this.n.f2137d) {
            if (hVar != null) {
                hVar.b();
            }
        }
        this.n.f2136c.a(this.y, this.z);
        this.z = 0;
        Arrays.fill(this.n.f2137d, (Object) null);
        HashMap<String, h> hashMap = this.s;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f2145h = 0;
        this.t.c();
        this.l = 1;
        for (int i2 = 0; i2 < this.m; i2++) {
            b[] bVarArr = this.f2146i;
            if (bVarArr[i2] != null) {
                bVarArr[i2].f2130c = false;
            }
        }
        g();
        this.m = 0;
        if (f2143f) {
            this.A = new b(this.n);
        } else {
            this.A = new b(this.n);
        }
    }

    public final h a(Object obj) {
        h hVar = null;
        if (obj == null) {
            return null;
        }
        if (this.l + 1 >= this.v) {
            f();
        }
        if (obj instanceof androidx.constraintlayout.a.a.d) {
            androidx.constraintlayout.a.a.d dVar = (androidx.constraintlayout.a.a.d) obj;
            hVar = dVar.f2090i;
            if (hVar == null) {
                dVar.d();
                hVar = dVar.f2090i;
            }
            if (hVar.f2167b == -1 || hVar.f2167b > this.f2145h || this.n.f2137d[hVar.f2167b] == null) {
                if (hVar.f2167b != -1) {
                    hVar.b();
                }
                this.f2145h++;
                this.l++;
                hVar.f2167b = this.f2145h;
                hVar.f2174i = h.a.UNRESTRICTED;
                this.n.f2137d[this.f2145h] = hVar;
            }
        }
        return hVar;
    }

    public final b c() {
        b bVar;
        if (f2143f) {
            bVar = this.n.f2134a.a();
            if (bVar == null) {
                bVar = new b(this.n);
                q++;
            } else {
                bVar.a();
            }
        } else {
            bVar = this.n.f2135b.a();
            if (bVar == null) {
                bVar = new b(this.n);
                p++;
            } else {
                bVar.a();
            }
        }
        h.a();
        return bVar;
    }

    public final h d() {
        e eVar = o;
        if (eVar != null) {
            eVar.m++;
        }
        if (this.l + 1 >= this.v) {
            f();
        }
        h a2 = a(h.a.SLACK);
        this.f2145h++;
        this.l++;
        a2.f2167b = this.f2145h;
        this.n.f2137d[this.f2145h] = a2;
        return a2;
    }

    private void a(b bVar, int i2, int i3) {
        bVar.f2132e.a(a(i3), (float) i2);
    }

    public final h a(int i2) {
        e eVar = o;
        if (eVar != null) {
            eVar.l++;
        }
        if (this.l + 1 >= this.v) {
            f();
        }
        h a2 = a(h.a.ERROR);
        this.f2145h++;
        this.l++;
        a2.f2167b = this.f2145h;
        a2.f2169d = i2;
        this.n.f2137d[this.f2145h] = a2;
        this.t.d(a2);
        return a2;
    }

    private h a(h.a aVar) {
        h a2 = this.n.f2136c.a();
        if (a2 == null) {
            a2 = new h(aVar);
            a2.f2174i = aVar;
        } else {
            a2.b();
            a2.f2174i = aVar;
        }
        int i2 = this.z;
        int i3 = r;
        if (i2 >= i3) {
            r = i3 * 2;
            this.y = (h[]) Arrays.copyOf(this.y, r);
        }
        h[] hVarArr = this.y;
        int i4 = this.z;
        this.z = i4 + 1;
        hVarArr[i4] = a2;
        return a2;
    }

    public static int b(Object obj) {
        h hVar = ((androidx.constraintlayout.a.a.d) obj).f2090i;
        if (hVar != null) {
            return (int) (hVar.f2170e + 0.5f);
        }
        return 0;
    }

    public final void e() throws Exception {
        float f2;
        boolean z2;
        long j2;
        boolean z3;
        e eVar = o;
        long j3 = 1;
        if (eVar != null) {
            eVar.f2152e++;
        }
        if (this.t.b()) {
            h();
            return;
        }
        int i2 = 1;
        if (this.j || this.k) {
            e eVar2 = o;
            if (eVar2 != null) {
                eVar2.q++;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= this.m) {
                    z3 = true;
                    break;
                } else if (!this.f2146i[i3].f2133f) {
                    z3 = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (z3) {
                e eVar3 = o;
                if (eVar3 != null) {
                    eVar3.p++;
                }
                h();
                return;
            }
        }
        a aVar = this.t;
        e eVar4 = o;
        if (eVar4 != null) {
            eVar4.t++;
            e eVar5 = o;
            eVar5.u = Math.max(eVar5.u, (long) this.l);
            e eVar6 = o;
            eVar6.v = Math.max(eVar6.v, (long) this.m);
        }
        int i4 = 0;
        while (true) {
            f2 = 0.0f;
            if (i4 < this.m) {
                if (this.f2146i[i4].f2128a.f2174i != h.a.UNRESTRICTED && this.f2146i[i4].f2129b < 0.0f) {
                    z2 = true;
                    break;
                }
                i4++;
            } else {
                z2 = false;
                break;
            }
        }
        if (z2) {
            boolean z4 = false;
            int i5 = 0;
            while (!z4) {
                e eVar7 = o;
                if (eVar7 != null) {
                    eVar7.k += j3;
                }
                i5 += i2;
                int i6 = 0;
                int i7 = -1;
                int i8 = -1;
                float f3 = Float.MAX_VALUE;
                int i9 = 0;
                while (i6 < this.m) {
                    b bVar = this.f2146i[i6];
                    if (bVar.f2128a.f2174i != h.a.UNRESTRICTED && !bVar.f2133f && bVar.f2129b < f2) {
                        int i10 = 9;
                        if (f2142e) {
                            int c2 = bVar.f2132e.c();
                            int i11 = i9;
                            float f4 = f3;
                            int i12 = i8;
                            int i13 = i7;
                            int i14 = 0;
                            while (i14 < c2) {
                                h a2 = bVar.f2132e.a(i14);
                                float b2 = bVar.f2132e.b(a2);
                                if (b2 > f2) {
                                    int i15 = i11;
                                    float f5 = f4;
                                    int i16 = i12;
                                    int i17 = i13;
                                    int i18 = 0;
                                    while (i18 < i10) {
                                        float f6 = a2.f2172g[i18] / b2;
                                        if ((f6 < f5 && i18 == i15) || i18 > i15) {
                                            f5 = f6;
                                            i17 = i6;
                                            i16 = a2.f2167b;
                                            i15 = i18;
                                        }
                                        i18++;
                                        i10 = 9;
                                    }
                                    i13 = i17;
                                    i12 = i16;
                                    f4 = f5;
                                    i11 = i15;
                                }
                                i14++;
                                i10 = 9;
                            }
                            i7 = i13;
                            i8 = i12;
                            f3 = f4;
                            i9 = i11;
                        } else {
                            int i19 = 1;
                            while (i19 < this.l) {
                                h hVar = this.n.f2137d[i19];
                                float b3 = bVar.f2132e.b(hVar);
                                if (b3 > f2) {
                                    for (int i20 = 0; i20 < 9; i20++) {
                                        float f7 = hVar.f2172g[i20] / b3;
                                        if ((f7 < f3 && i20 == i9) || i20 > i9) {
                                            i8 = i19;
                                            i9 = i20;
                                            f3 = f7;
                                            i7 = i6;
                                        }
                                    }
                                }
                                i19++;
                                f2 = 0.0f;
                            }
                        }
                    }
                    i6++;
                    f2 = 0.0f;
                }
                if (i7 != -1) {
                    b bVar2 = this.f2146i[i7];
                    bVar2.f2128a.f2168c = -1;
                    e eVar8 = o;
                    if (eVar8 != null) {
                        j2 = 1;
                        eVar8.j++;
                    } else {
                        j2 = 1;
                    }
                    bVar2.c(this.n.f2137d[i8]);
                    bVar2.f2128a.f2168c = i7;
                    bVar2.f2128a.a(this, bVar2);
                } else {
                    j2 = 1;
                    z4 = true;
                }
                if (i5 > this.l / 2) {
                    z4 = true;
                }
                j3 = j2;
                i2 = 1;
                f2 = 0.0f;
            }
        }
        a(aVar);
        h();
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0225 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0226  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.constraintlayout.a.b r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.constraintlayout.a.e r2 = o
            r3 = 1
            if (r2 == 0) goto L_0x001d
            long r5 = r2.f2153f
            long r5 = r5 + r3
            r2.f2153f = r5
            boolean r2 = r1.f2133f
            if (r2 == 0) goto L_0x001d
            androidx.constraintlayout.a.e r2 = o
            long r5 = r2.f2154g
            long r5 = r5 + r3
            r2.f2154g = r5
        L_0x001d:
            int r2 = r0.m
            r5 = 1
            int r2 = r2 + r5
            int r6 = r0.x
            if (r2 >= r6) goto L_0x002c
            int r2 = r0.l
            int r2 = r2 + r5
            int r6 = r0.v
            if (r2 < r6) goto L_0x002f
        L_0x002c:
            r18.f()
        L_0x002f:
            boolean r2 = r1.f2133f
            if (r2 != 0) goto L_0x0229
            androidx.constraintlayout.a.b[] r2 = r0.f2146i
            int r2 = r2.length
            r7 = -1
            if (r2 == 0) goto L_0x00e3
            r2 = 0
        L_0x003a:
            if (r2 != 0) goto L_0x00cf
            androidx.constraintlayout.a.b$a r8 = r1.f2132e
            int r8 = r8.c()
            r9 = 0
        L_0x0043:
            if (r9 >= r8) goto L_0x005f
            androidx.constraintlayout.a.b$a r10 = r1.f2132e
            androidx.constraintlayout.a.h r10 = r10.a((int) r9)
            int r11 = r10.f2168c
            if (r11 != r7) goto L_0x0057
            boolean r11 = r10.f2171f
            if (r11 != 0) goto L_0x0057
            boolean r11 = r10.m
            if (r11 == 0) goto L_0x005c
        L_0x0057:
            java.util.ArrayList<androidx.constraintlayout.a.h> r11 = r1.f2131d
            r11.add(r10)
        L_0x005c:
            int r9 = r9 + 1
            goto L_0x0043
        L_0x005f:
            java.util.ArrayList<androidx.constraintlayout.a.h> r8 = r1.f2131d
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x00cc
            r9 = 0
        L_0x0068:
            if (r9 >= r8) goto L_0x00c5
            java.util.ArrayList<androidx.constraintlayout.a.h> r10 = r1.f2131d
            java.lang.Object r10 = r10.get(r9)
            androidx.constraintlayout.a.h r10 = (androidx.constraintlayout.a.h) r10
            boolean r11 = r10.f2171f
            if (r11 == 0) goto L_0x007a
            r1.a((androidx.constraintlayout.a.d) r0, (androidx.constraintlayout.a.h) r10, (boolean) r5)
            goto L_0x00c2
        L_0x007a:
            boolean r11 = r10.m
            if (r11 == 0) goto L_0x00b9
            boolean r11 = r10.m
            if (r11 == 0) goto L_0x00c2
            androidx.constraintlayout.a.b$a r11 = r1.f2132e
            float r11 = r11.b((androidx.constraintlayout.a.h) r10)
            float r12 = r1.f2129b
            float r13 = r10.o
            float r13 = r13 * r11
            float r12 = r12 + r13
            r1.f2129b = r12
            androidx.constraintlayout.a.b$a r12 = r1.f2132e
            r12.a((androidx.constraintlayout.a.h) r10, (boolean) r5)
            r10.b(r1)
            androidx.constraintlayout.a.b$a r12 = r1.f2132e
            androidx.constraintlayout.a.c r13 = r0.n
            androidx.constraintlayout.a.h[] r13 = r13.f2137d
            int r14 = r10.n
            r13 = r13[r14]
            r12.a(r13, r11, r5)
            boolean r11 = f2140c
            if (r11 == 0) goto L_0x00c2
            if (r10 == 0) goto L_0x00c2
            androidx.constraintlayout.a.b$a r10 = r1.f2132e
            int r10 = r10.c()
            if (r10 != 0) goto L_0x00c2
            r1.f2133f = r5
            r0.f2144g = r5
            goto L_0x00c2
        L_0x00b9:
            androidx.constraintlayout.a.b[] r11 = r0.f2146i
            int r10 = r10.f2168c
            r10 = r11[r10]
            r1.a((androidx.constraintlayout.a.d) r0, (androidx.constraintlayout.a.b) r10, (boolean) r5)
        L_0x00c2:
            int r9 = r9 + 1
            goto L_0x0068
        L_0x00c5:
            java.util.ArrayList<androidx.constraintlayout.a.h> r8 = r1.f2131d
            r8.clear()
            goto L_0x003a
        L_0x00cc:
            r2 = 1
            goto L_0x003a
        L_0x00cf:
            boolean r2 = f2140c
            if (r2 == 0) goto L_0x00e3
            androidx.constraintlayout.a.h r2 = r1.f2128a
            if (r2 == 0) goto L_0x00e3
            androidx.constraintlayout.a.b$a r2 = r1.f2132e
            int r2 = r2.c()
            if (r2 != 0) goto L_0x00e3
            r1.f2133f = r5
            r0.f2144g = r5
        L_0x00e3:
            boolean r2 = r19.b()
            if (r2 == 0) goto L_0x00ea
            return
        L_0x00ea:
            float r2 = r1.f2129b
            r8 = 0
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x00fe
            float r2 = r1.f2129b
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r2 * r9
            r1.f2129b = r2
            androidx.constraintlayout.a.b$a r2 = r1.f2132e
            r2.b()
        L_0x00fe:
            androidx.constraintlayout.a.b$a r2 = r1.f2132e
            int r2 = r2.c()
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x010c:
            if (r10 >= r2) goto L_0x016b
            androidx.constraintlayout.a.b$a r6 = r1.f2132e
            float r6 = r6.b((int) r10)
            androidx.constraintlayout.a.b$a r9 = r1.f2132e
            androidx.constraintlayout.a.h r9 = r9.a((int) r10)
            androidx.constraintlayout.a.h$a r7 = r9.f2174i
            androidx.constraintlayout.a.h$a r3 = androidx.constraintlayout.a.h.a.UNRESTRICTED
            if (r7 != r3) goto L_0x013f
            if (r11 != 0) goto L_0x012a
            boolean r3 = androidx.constraintlayout.a.b.b(r9)
        L_0x0126:
            r14 = r3
            r13 = r6
            r11 = r9
            goto L_0x0165
        L_0x012a:
            int r3 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x0133
            boolean r3 = androidx.constraintlayout.a.b.b(r9)
            goto L_0x0126
        L_0x0133:
            if (r14 != 0) goto L_0x0165
            boolean r3 = androidx.constraintlayout.a.b.b(r9)
            if (r3 == 0) goto L_0x0165
            r13 = r6
            r11 = r9
            r14 = 1
            goto L_0x0165
        L_0x013f:
            if (r11 != 0) goto L_0x0165
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0165
            if (r12 != 0) goto L_0x0150
            boolean r3 = androidx.constraintlayout.a.b.b(r9)
        L_0x014b:
            r16 = r3
            r15 = r6
            r12 = r9
            goto L_0x0165
        L_0x0150:
            int r3 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x0159
            boolean r3 = androidx.constraintlayout.a.b.b(r9)
            goto L_0x014b
        L_0x0159:
            if (r16 != 0) goto L_0x0165
            boolean r3 = androidx.constraintlayout.a.b.b(r9)
            if (r3 == 0) goto L_0x0165
            r15 = r6
            r12 = r9
            r16 = 1
        L_0x0165:
            int r10 = r10 + 1
            r3 = 1
            r7 = -1
            goto L_0x010c
        L_0x016b:
            if (r11 == 0) goto L_0x016e
            goto L_0x016f
        L_0x016e:
            r11 = r12
        L_0x016f:
            if (r11 != 0) goto L_0x0173
            r2 = 1
            goto L_0x0177
        L_0x0173:
            r1.c(r11)
            r2 = 0
        L_0x0177:
            androidx.constraintlayout.a.b$a r3 = r1.f2132e
            int r3 = r3.c()
            if (r3 != 0) goto L_0x0181
            r1.f2133f = r5
        L_0x0181:
            if (r2 == 0) goto L_0x020b
            androidx.constraintlayout.a.e r2 = o
            if (r2 == 0) goto L_0x018e
            long r3 = r2.n
            r6 = 1
            long r3 = r3 + r6
            r2.n = r3
        L_0x018e:
            int r2 = r0.l
            int r2 = r2 + r5
            int r3 = r0.v
            if (r2 < r3) goto L_0x0198
            r18.f()
        L_0x0198:
            androidx.constraintlayout.a.h$a r2 = androidx.constraintlayout.a.h.a.SLACK
            androidx.constraintlayout.a.h r2 = r0.a((androidx.constraintlayout.a.h.a) r2)
            int r3 = r0.f2145h
            int r3 = r3 + r5
            r0.f2145h = r3
            int r3 = r0.l
            int r3 = r3 + r5
            r0.l = r3
            int r3 = r0.f2145h
            r2.f2167b = r3
            androidx.constraintlayout.a.c r3 = r0.n
            androidx.constraintlayout.a.h[] r3 = r3.f2137d
            int r4 = r0.f2145h
            r3[r4] = r2
            r1.f2128a = r2
            int r3 = r0.m
            r18.b((androidx.constraintlayout.a.b) r19)
            int r4 = r0.m
            int r3 = r3 + r5
            if (r4 != r3) goto L_0x020b
            androidx.constraintlayout.a.d$a r3 = r0.A
            r3.a((androidx.constraintlayout.a.d.a) r1)
            androidx.constraintlayout.a.d$a r3 = r0.A
            r0.a((androidx.constraintlayout.a.d.a) r3)
            int r3 = r2.f2168c
            r4 = -1
            if (r3 != r4) goto L_0x0209
            androidx.constraintlayout.a.h r3 = r1.f2128a
            if (r3 != r2) goto L_0x01e8
            r3 = 0
            androidx.constraintlayout.a.h r2 = r1.a((boolean[]) r3, (androidx.constraintlayout.a.h) r2)
            if (r2 == 0) goto L_0x01e8
            androidx.constraintlayout.a.e r3 = o
            if (r3 == 0) goto L_0x01e5
            long r6 = r3.j
            r9 = 1
            long r6 = r6 + r9
            r3.j = r6
        L_0x01e5:
            r1.c(r2)
        L_0x01e8:
            boolean r2 = r1.f2133f
            if (r2 != 0) goto L_0x01f1
            androidx.constraintlayout.a.h r2 = r1.f2128a
            r2.a((androidx.constraintlayout.a.d) r0, (androidx.constraintlayout.a.b) r1)
        L_0x01f1:
            boolean r2 = f2143f
            if (r2 == 0) goto L_0x01fd
            androidx.constraintlayout.a.c r2 = r0.n
            androidx.constraintlayout.a.f$a<androidx.constraintlayout.a.b> r2 = r2.f2134a
            r2.a(r1)
            goto L_0x0204
        L_0x01fd:
            androidx.constraintlayout.a.c r2 = r0.n
            androidx.constraintlayout.a.f$a<androidx.constraintlayout.a.b> r2 = r2.f2135b
            r2.a(r1)
        L_0x0204:
            int r2 = r0.m
            int r2 = r2 - r5
            r0.m = r2
        L_0x0209:
            r6 = 1
            goto L_0x020c
        L_0x020b:
            r6 = 0
        L_0x020c:
            androidx.constraintlayout.a.h r2 = r1.f2128a
            if (r2 == 0) goto L_0x0221
            androidx.constraintlayout.a.h r2 = r1.f2128a
            androidx.constraintlayout.a.h$a r2 = r2.f2174i
            androidx.constraintlayout.a.h$a r3 = androidx.constraintlayout.a.h.a.UNRESTRICTED
            if (r2 == r3) goto L_0x021e
            float r2 = r1.f2129b
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x0221
        L_0x021e:
            r17 = 1
            goto L_0x0223
        L_0x0221:
            r17 = 0
        L_0x0223:
            if (r17 != 0) goto L_0x0226
            return
        L_0x0226:
            r17 = r6
            goto L_0x022b
        L_0x0229:
            r17 = 0
        L_0x022b:
            if (r17 != 0) goto L_0x0230
            r18.b((androidx.constraintlayout.a.b) r19)
        L_0x0230:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.d.a(androidx.constraintlayout.a.b):void");
    }

    private final void b(b bVar) {
        int i2;
        if (!f2140c || !bVar.f2133f) {
            this.f2146i[this.m] = bVar;
            h hVar = bVar.f2128a;
            int i3 = this.m;
            hVar.f2168c = i3;
            this.m = i3 + 1;
            bVar.f2128a.a(this, bVar);
        } else {
            bVar.f2128a.a(this, bVar.f2129b);
        }
        if (f2140c && this.f2144g) {
            int i4 = 0;
            while (i4 < this.m) {
                if (this.f2146i[i4] == null) {
                    System.out.println("WTF");
                }
                b[] bVarArr = this.f2146i;
                if (bVarArr[i4] != null && bVarArr[i4].f2133f) {
                    b bVar2 = this.f2146i[i4];
                    bVar2.f2128a.a(this, bVar2.f2129b);
                    if (f2143f) {
                        this.n.f2134a.a(bVar2);
                    } else {
                        this.n.f2135b.a(bVar2);
                    }
                    this.f2146i[i4] = null;
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (true) {
                        i2 = this.m;
                        if (i5 >= i2) {
                            break;
                        }
                        b[] bVarArr2 = this.f2146i;
                        int i7 = i5 - 1;
                        bVarArr2[i7] = bVarArr2[i5];
                        if (bVarArr2[i7].f2128a.f2168c == i5) {
                            this.f2146i[i7].f2128a.f2168c = i7;
                        }
                        i6 = i5;
                        i5++;
                    }
                    if (i6 < i2) {
                        this.f2146i[i6] = null;
                    }
                    this.m--;
                    i4--;
                }
                i4++;
            }
            this.f2144g = false;
        }
    }

    private final int a(a aVar) {
        e eVar = o;
        if (eVar != null) {
            eVar.f2155h++;
        }
        for (int i2 = 0; i2 < this.l; i2++) {
            this.w[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            e eVar2 = o;
            if (eVar2 != null) {
                eVar2.f2156i++;
            }
            i3++;
            if (i3 >= this.l * 2) {
                return i3;
            }
            if (aVar.d() != null) {
                this.w[aVar.d().f2167b] = true;
            }
            h a2 = aVar.a(this.w);
            if (a2 != null) {
                if (this.w[a2.f2167b]) {
                    return i3;
                }
                this.w[a2.f2167b] = true;
            }
            if (a2 != null) {
                int i4 = -1;
                float f2 = Float.MAX_VALUE;
                for (int i5 = 0; i5 < this.m; i5++) {
                    b bVar = this.f2146i[i5];
                    if (bVar.f2128a.f2174i != h.a.UNRESTRICTED && !bVar.f2133f && bVar.a(a2)) {
                        float b2 = bVar.f2132e.b(a2);
                        if (b2 < 0.0f) {
                            float f3 = (-bVar.f2129b) / b2;
                            if (f3 < f2) {
                                i4 = i5;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i4 >= 0) {
                    b bVar2 = this.f2146i[i4];
                    bVar2.f2128a.f2168c = -1;
                    e eVar3 = o;
                    if (eVar3 != null) {
                        eVar3.j++;
                    }
                    bVar2.c(a2);
                    bVar2.f2128a.f2168c = i4;
                    bVar2.f2128a.a(this, bVar2);
                }
            } else {
                z2 = true;
            }
        }
        return i3;
    }

    private void h() {
        for (int i2 = 0; i2 < this.m; i2++) {
            b bVar = this.f2146i[i2];
            bVar.f2128a.f2170e = bVar.f2129b;
        }
    }

    public final void a(h hVar, h hVar2, int i2, int i3) {
        b c2 = c();
        h d2 = d();
        d2.f2169d = 0;
        c2.a(hVar, hVar2, d2, i2);
        if (i3 != 8) {
            a(c2, (int) (c2.f2132e.b(d2) * -1.0f), i3);
        }
        a(c2);
    }

    public final void b(h hVar, h hVar2, int i2, int i3) {
        b c2 = c();
        h d2 = d();
        d2.f2169d = 0;
        c2.b(hVar, hVar2, d2, i2);
        if (i3 != 8) {
            a(c2, (int) (c2.f2132e.b(d2) * -1.0f), i3);
        }
        a(c2);
    }

    public final void a(h hVar, h hVar2, int i2, float f2, h hVar3, h hVar4, int i3, int i4) {
        b c2 = c();
        if (hVar2 == hVar3) {
            c2.f2132e.a(hVar, 1.0f);
            c2.f2132e.a(hVar4, 1.0f);
            c2.f2132e.a(hVar2, -2.0f);
        } else if (f2 == 0.5f) {
            c2.f2132e.a(hVar, 1.0f);
            c2.f2132e.a(hVar2, -1.0f);
            c2.f2132e.a(hVar3, -1.0f);
            c2.f2132e.a(hVar4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                c2.f2129b = (float) ((-i2) + i3);
            }
        } else if (f2 <= 0.0f) {
            c2.f2132e.a(hVar, -1.0f);
            c2.f2132e.a(hVar2, 1.0f);
            c2.f2129b = (float) i2;
        } else if (f2 >= 1.0f) {
            c2.f2132e.a(hVar4, -1.0f);
            c2.f2132e.a(hVar3, 1.0f);
            c2.f2129b = (float) (-i3);
        } else {
            float f3 = 1.0f - f2;
            c2.f2132e.a(hVar, f3 * 1.0f);
            c2.f2132e.a(hVar2, f3 * -1.0f);
            c2.f2132e.a(hVar3, -1.0f * f2);
            c2.f2132e.a(hVar4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                c2.f2129b = (((float) (-i2)) * f3) + (((float) i3) * f2);
            }
        }
        if (i4 != 8) {
            c2.a(this, i4);
        }
        a(c2);
    }

    public final void a(h hVar, h hVar2, h hVar3, h hVar4, float f2) {
        b c2 = c();
        c2.a(hVar, hVar2, hVar3, hVar4, f2);
        a(c2);
    }

    public final b c(h hVar, h hVar2, int i2, int i3) {
        if (!f2139b || i3 != 8 || !hVar2.f2171f || hVar.f2168c != -1) {
            b c2 = c();
            boolean z2 = false;
            if (i2 != 0) {
                if (i2 < 0) {
                    i2 *= -1;
                    z2 = true;
                }
                c2.f2129b = (float) i2;
            }
            if (!z2) {
                c2.f2132e.a(hVar, -1.0f);
                c2.f2132e.a(hVar2, 1.0f);
            } else {
                c2.f2132e.a(hVar, 1.0f);
                c2.f2132e.a(hVar2, -1.0f);
            }
            if (i3 != 8) {
                c2.a(this, i3);
            }
            a(c2);
            return c2;
        }
        hVar.a(this, hVar2.f2170e + ((float) i2));
        return null;
    }

    public final void a(h hVar, int i2) {
        if (!f2139b || hVar.f2168c != -1) {
            int i3 = hVar.f2168c;
            if (hVar.f2168c != -1) {
                b bVar = this.f2146i[i3];
                if (bVar.f2133f) {
                    bVar.f2129b = (float) i2;
                } else if (bVar.f2132e.c() == 0) {
                    bVar.f2133f = true;
                    bVar.f2129b = (float) i2;
                } else {
                    b c2 = c();
                    if (i2 < 0) {
                        c2.f2129b = (float) (i2 * -1);
                        c2.f2132e.a(hVar, 1.0f);
                    } else {
                        c2.f2129b = (float) i2;
                        c2.f2132e.a(hVar, -1.0f);
                    }
                    a(c2);
                }
            } else {
                b c3 = c();
                c3.f2128a = hVar;
                float f2 = (float) i2;
                hVar.f2170e = f2;
                c3.f2129b = f2;
                c3.f2133f = true;
                a(c3);
            }
        } else {
            float f3 = (float) i2;
            hVar.a(this, f3);
            for (int i4 = 0; i4 < this.f2145h + 1; i4++) {
                h hVar2 = this.n.f2137d[i4];
                if (hVar2 != null && hVar2.m && hVar2.n == hVar.f2167b) {
                    hVar2.a(this, hVar2.o + f3);
                }
            }
        }
    }

    public static b a(d dVar, h hVar, h hVar2, float f2) {
        b c2 = dVar.c();
        c2.f2132e.a(hVar, -1.0f);
        c2.f2132e.a(hVar2, f2);
        return c2;
    }
}
