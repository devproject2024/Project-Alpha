package androidx.constraintlayout.a;

import androidx.constraintlayout.a.b;
import java.util.Arrays;
import java.util.Comparator;

public final class g extends b {

    /* renamed from: g  reason: collision with root package name */
    a f2159g;

    /* renamed from: h  reason: collision with root package name */
    c f2160h;

    /* renamed from: i  reason: collision with root package name */
    private int f2161i = 128;
    private h[] j;
    private h[] k;
    private int l;

    class a implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        h f2163a;

        /* renamed from: b  reason: collision with root package name */
        g f2164b;

        public a(g gVar) {
            this.f2164b = gVar;
        }

        public final int compareTo(Object obj) {
            return this.f2163a.f2167b - ((h) obj).f2167b;
        }

        public final String toString() {
            String str = "[ ";
            if (this.f2163a != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    str = str + this.f2163a.f2173h[i2] + " ";
                }
            }
            return str + "] " + this.f2163a;
        }
    }

    public final void c() {
        this.l = 0;
        this.f2129b = 0.0f;
    }

    public g(c cVar) {
        super(cVar);
        int i2 = this.f2161i;
        this.j = new h[i2];
        this.k = new h[i2];
        this.l = 0;
        this.f2159g = new a(this);
        this.f2160h = cVar;
    }

    public final boolean b() {
        return this.l == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r9 < r8) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.constraintlayout.a.h a(boolean[] r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = -1
            r2 = 0
            r3 = -1
        L_0x0004:
            int r4 = r11.l
            if (r2 >= r4) goto L_0x0057
            androidx.constraintlayout.a.h[] r4 = r11.j
            r4 = r4[r2]
            int r5 = r4.f2167b
            boolean r5 = r12[r5]
            if (r5 != 0) goto L_0x0054
            androidx.constraintlayout.a.g$a r5 = r11.f2159g
            r5.f2163a = r4
            r4 = 8
            r6 = 1
            if (r3 != r1) goto L_0x0034
        L_0x001b:
            if (r4 < 0) goto L_0x0030
            androidx.constraintlayout.a.h r7 = r5.f2163a
            float[] r7 = r7.f2173h
            r7 = r7[r4]
            r8 = 0
            int r9 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r9 > 0) goto L_0x0030
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            int r4 = r4 + -1
            goto L_0x001b
        L_0x0030:
            r6 = 0
        L_0x0031:
            if (r6 == 0) goto L_0x0054
            goto L_0x0053
        L_0x0034:
            androidx.constraintlayout.a.h[] r7 = r11.j
            r7 = r7[r3]
        L_0x0038:
            if (r4 < 0) goto L_0x0050
            float[] r8 = r7.f2173h
            r8 = r8[r4]
            androidx.constraintlayout.a.h r9 = r5.f2163a
            float[] r9 = r9.f2173h
            r9 = r9[r4]
            int r10 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x004d
            int r4 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0050
            goto L_0x0051
        L_0x004d:
            int r4 = r4 + -1
            goto L_0x0038
        L_0x0050:
            r6 = 0
        L_0x0051:
            if (r6 == 0) goto L_0x0054
        L_0x0053:
            r3 = r2
        L_0x0054:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0057:
            if (r3 != r1) goto L_0x005b
            r12 = 0
            return r12
        L_0x005b:
            androidx.constraintlayout.a.h[] r12 = r11.j
            r12 = r12[r3]
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.g.a(boolean[]):androidx.constraintlayout.a.h");
    }

    public final void d(h hVar) {
        a aVar = this.f2159g;
        aVar.f2163a = hVar;
        Arrays.fill(aVar.f2163a.f2173h, 0.0f);
        hVar.f2173h[hVar.f2169d] = 1.0f;
        e(hVar);
    }

    private final void e(h hVar) {
        int i2;
        int i3 = this.l + 1;
        h[] hVarArr = this.j;
        if (i3 > hVarArr.length) {
            this.j = (h[]) Arrays.copyOf(hVarArr, hVarArr.length * 2);
            h[] hVarArr2 = this.j;
            this.k = (h[]) Arrays.copyOf(hVarArr2, hVarArr2.length * 2);
        }
        h[] hVarArr3 = this.j;
        int i4 = this.l;
        hVarArr3[i4] = hVar;
        this.l = i4 + 1;
        int i5 = this.l;
        if (i5 > 1 && hVarArr3[i5 - 1].f2167b > hVar.f2167b) {
            int i6 = 0;
            while (true) {
                i2 = this.l;
                if (i6 >= i2) {
                    break;
                }
                this.k[i6] = this.j[i6];
                i6++;
            }
            Arrays.sort(this.k, 0, i2, new Comparator<h>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((h) obj).f2167b - ((h) obj2).f2167b;
                }
            });
            for (int i7 = 0; i7 < this.l; i7++) {
                this.j[i7] = this.k[i7];
            }
        }
        hVar.f2166a = true;
        hVar.a(this);
    }

    private void f(h hVar) {
        int i2 = 0;
        while (i2 < this.l) {
            if (this.j[i2] == hVar) {
                while (true) {
                    int i3 = this.l;
                    if (i2 < i3 - 1) {
                        h[] hVarArr = this.j;
                        int i4 = i2 + 1;
                        hVarArr[i2] = hVarArr[i4];
                        i2 = i4;
                    } else {
                        this.l = i3 - 1;
                        hVar.f2166a = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    public final void a(d dVar, b bVar, boolean z) {
        b bVar2 = bVar;
        h hVar = bVar2.f2128a;
        if (hVar != null) {
            b.a aVar = bVar2.f2132e;
            int c2 = aVar.c();
            for (int i2 = 0; i2 < c2; i2++) {
                h a2 = aVar.a(i2);
                float b2 = aVar.b(i2);
                a aVar2 = this.f2159g;
                aVar2.f2163a = a2;
                boolean z2 = true;
                if (aVar2.f2163a.f2166a) {
                    for (int i3 = 0; i3 < 9; i3++) {
                        float[] fArr = aVar2.f2163a.f2173h;
                        fArr[i3] = fArr[i3] + (hVar.f2173h[i3] * b2);
                        if (Math.abs(aVar2.f2163a.f2173h[i3]) < 1.0E-4f) {
                            aVar2.f2163a.f2173h[i3] = 0.0f;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        g.this.f(aVar2.f2163a);
                    }
                    z2 = false;
                } else {
                    for (int i4 = 0; i4 < 9; i4++) {
                        float f2 = hVar.f2173h[i4];
                        if (f2 != 0.0f) {
                            float f3 = f2 * b2;
                            if (Math.abs(f3) < 1.0E-4f) {
                                f3 = 0.0f;
                            }
                            aVar2.f2163a.f2173h[i4] = f3;
                        } else {
                            aVar2.f2163a.f2173h[i4] = 0.0f;
                        }
                    }
                }
                if (z2) {
                    e(a2);
                }
                this.f2129b += bVar2.f2129b * b2;
            }
            f(hVar);
        }
    }

    public final String toString() {
        String str = "" + " goal -> (" + this.f2129b + ") : ";
        for (int i2 = 0; i2 < this.l; i2++) {
            this.f2159g.f2163a = this.j[i2];
            str = str + this.f2159g + " ";
        }
        return str;
    }
}
