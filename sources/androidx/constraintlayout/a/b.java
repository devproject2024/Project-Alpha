package androidx.constraintlayout.a;

import androidx.constraintlayout.a.d;
import androidx.constraintlayout.a.h;
import java.util.ArrayList;

public class b implements d.a {

    /* renamed from: a  reason: collision with root package name */
    h f2128a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f2129b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    boolean f2130c = false;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<h> f2131d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public a f2132e;

    /* renamed from: f  reason: collision with root package name */
    boolean f2133f = false;

    public interface a {
        float a(b bVar, boolean z);

        float a(h hVar, boolean z);

        h a(int i2);

        void a();

        void a(float f2);

        void a(h hVar, float f2);

        void a(h hVar, float f2, boolean z);

        boolean a(h hVar);

        float b(int i2);

        float b(h hVar);

        void b();

        int c();
    }

    public b() {
    }

    public b(c cVar) {
        this.f2132e = new a(this, cVar);
    }

    public final void a() {
        this.f2128a = null;
        this.f2132e.a();
        this.f2129b = 0.0f;
        this.f2133f = false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(h hVar) {
        return this.f2132e.a(hVar);
    }

    public final b a(h hVar, h hVar2, h hVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2129b = (float) i2;
        }
        if (!z) {
            this.f2132e.a(hVar, -1.0f);
            this.f2132e.a(hVar2, 1.0f);
            this.f2132e.a(hVar3, 1.0f);
        } else {
            this.f2132e.a(hVar, 1.0f);
            this.f2132e.a(hVar2, -1.0f);
            this.f2132e.a(hVar3, -1.0f);
        }
        return this;
    }

    public final b b(h hVar, h hVar2, h hVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2129b = (float) i2;
        }
        if (!z) {
            this.f2132e.a(hVar, -1.0f);
            this.f2132e.a(hVar2, 1.0f);
            this.f2132e.a(hVar3, -1.0f);
        } else {
            this.f2132e.a(hVar, 1.0f);
            this.f2132e.a(hVar2, -1.0f);
            this.f2132e.a(hVar3, 1.0f);
        }
        return this;
    }

    public final b a(d dVar, int i2) {
        this.f2132e.a(dVar.a(i2), 1.0f);
        this.f2132e.a(dVar.a(i2), -1.0f);
        return this;
    }

    public final b a(h hVar, h hVar2, h hVar3, h hVar4, float f2) {
        this.f2132e.a(hVar, -1.0f);
        this.f2132e.a(hVar2, 1.0f);
        this.f2132e.a(hVar3, f2);
        this.f2132e.a(hVar4, -f2);
        return this;
    }

    public final b b(h hVar, h hVar2, h hVar3, h hVar4, float f2) {
        this.f2132e.a(hVar3, 0.5f);
        this.f2132e.a(hVar4, 0.5f);
        this.f2132e.a(hVar, -0.5f);
        this.f2132e.a(hVar2, -0.5f);
        this.f2129b = -f2;
        return this;
    }

    static boolean b(h hVar) {
        return hVar.l <= 1;
    }

    /* access modifiers changed from: package-private */
    public final void c(h hVar) {
        h hVar2 = this.f2128a;
        if (hVar2 != null) {
            this.f2132e.a(hVar2, -1.0f);
            this.f2128a.f2168c = -1;
            this.f2128a = null;
        }
        float a2 = this.f2132e.a(hVar, true) * -1.0f;
        this.f2128a = hVar;
        if (a2 != 1.0f) {
            this.f2129b /= a2;
            this.f2132e.a(a2);
        }
    }

    public boolean b() {
        return this.f2128a == null && this.f2129b == 0.0f && this.f2132e.c() == 0;
    }

    public void a(d dVar, b bVar, boolean z) {
        this.f2129b += bVar.f2129b * this.f2132e.a(bVar, z);
        if (z) {
            bVar.f2128a.b(this);
        }
        if (d.f2140c && this.f2128a != null && this.f2132e.c() == 0) {
            this.f2133f = true;
            dVar.f2144g = true;
        }
    }

    public final void a(d dVar, h hVar, boolean z) {
        if (hVar.f2171f) {
            this.f2129b += hVar.f2170e * this.f2132e.b(hVar);
            this.f2132e.a(hVar, z);
            if (z) {
                hVar.b(this);
            }
            if (d.f2140c && hVar != null && this.f2132e.c() == 0) {
                this.f2133f = true;
                dVar.f2144g = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final h a(boolean[] zArr, h hVar) {
        int c2 = this.f2132e.c();
        h hVar2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < c2; i2++) {
            float b2 = this.f2132e.b(i2);
            if (b2 < 0.0f) {
                h a2 = this.f2132e.a(i2);
                if ((zArr == null || !zArr[a2.f2167b]) && a2 != hVar && ((a2.f2174i == h.a.SLACK || a2.f2174i == h.a.ERROR) && b2 < f2)) {
                    f2 = b2;
                    hVar2 = a2;
                }
            }
        }
        return hVar2;
    }

    public h a(boolean[] zArr) {
        return a(zArr, (h) null);
    }

    public void c() {
        this.f2132e.a();
        this.f2128a = null;
        this.f2129b = 0.0f;
    }

    public final void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f2128a = null;
            this.f2132e.a();
            for (int i2 = 0; i2 < bVar.f2132e.c(); i2++) {
                this.f2132e.a(bVar.f2132e.a(i2), bVar.f2132e.b(i2), true);
            }
        }
    }

    public void d(h hVar) {
        float f2 = 1.0f;
        if (hVar.f2169d != 1) {
            if (hVar.f2169d == 2) {
                f2 = 1000.0f;
            } else if (hVar.f2169d == 3) {
                f2 = 1000000.0f;
            } else if (hVar.f2169d == 4) {
                f2 = 1.0E9f;
            } else if (hVar.f2169d == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f2132e.a(hVar, f2);
    }

    public final h d() {
        return this.f2128a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r10 = this;
            androidx.constraintlayout.a.h r0 = r10.f2128a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            androidx.constraintlayout.a.h r1 = r10.f2128a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.f2129b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f2129b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            androidx.constraintlayout.a.b$a r5 = r10.f2132e
            int r5 = r5.c()
        L_0x005d:
            if (r2 >= r5) goto L_0x00e8
            androidx.constraintlayout.a.b$a r6 = r10.f2132e
            androidx.constraintlayout.a.h r6 = r6.a((int) r2)
            if (r6 == 0) goto L_0x00e4
            androidx.constraintlayout.a.b$a r7 = r10.f2132e
            float r7 = r7.b((int) r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00e4
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x008f
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b4
        L_0x008f:
            if (r8 <= 0) goto L_0x00a3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b6
        L_0x00a3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00b4:
            float r7 = r7 * r9
        L_0x00b6:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00cc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e3
        L_0x00cc:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e3:
            r1 = 1
        L_0x00e4:
            int r2 = r2 + 1
            goto L_0x005d
        L_0x00e8:
            if (r1 != 0) goto L_0x00fb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00fb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.b.toString():java.lang.String");
    }
}
