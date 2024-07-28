package androidx.constraintlayout.motion.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.motion.a.b;
import androidx.constraintlayout.motion.a.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class n {
    private HashMap<String, s> A;
    private l[] B;

    /* renamed from: a  reason: collision with root package name */
    View f2360a;

    /* renamed from: b  reason: collision with root package name */
    int f2361b;

    /* renamed from: c  reason: collision with root package name */
    String f2362c;

    /* renamed from: d  reason: collision with root package name */
    public p f2363d = new p();

    /* renamed from: e  reason: collision with root package name */
    public p f2364e = new p();

    /* renamed from: f  reason: collision with root package name */
    m f2365f = new m();

    /* renamed from: g  reason: collision with root package name */
    public b[] f2366g;

    /* renamed from: h  reason: collision with root package name */
    public b f2367h;

    /* renamed from: i  reason: collision with root package name */
    float f2368i = Float.NaN;
    float j = 0.0f;
    float k = 1.0f;
    public int[] l;
    public double[] m;
    public double[] n;
    public float[] o = new float[1];
    ArrayList<c> p = new ArrayList<>();
    public HashMap<String, r> q;
    public HashMap<String, g> r;
    int s = c.f2299a;
    private int t = -1;
    private m u = new m();
    private String[] v;
    private int[] w;
    private int x = 4;
    private float[] y = new float[this.x];
    private ArrayList<p> z = new ArrayList<>();

    /* access modifiers changed from: package-private */
    public final p a(int i2) {
        return this.z.get(i2);
    }

    n(View view) {
        this.f2360a = view;
        this.f2361b = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f2362c = ((ConstraintLayout.LayoutParams) layoutParams).V;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(float[] fArr, int i2) {
        float[] fArr2 = fArr;
        int i3 = i2;
        float f2 = 1.0f;
        float f3 = 1.0f / ((float) (i3 - 1));
        HashMap<String, r> hashMap = this.q;
        g gVar = null;
        r rVar = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, r> hashMap2 = this.q;
        r rVar2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, g> hashMap3 = this.r;
        g gVar2 = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, g> hashMap4 = this.r;
        if (hashMap4 != null) {
            gVar = hashMap4.get("translationY");
        }
        int i4 = 0;
        while (i4 < i3) {
            float f4 = ((float) i4) * f3;
            float f5 = 0.0f;
            if (this.k != f2) {
                if (f4 < this.j) {
                    f4 = 0.0f;
                }
                float f6 = this.j;
                if (f4 > f6 && ((double) f4) < 1.0d) {
                    f4 = (f4 - f6) * this.k;
                }
            }
            double d2 = (double) f4;
            c cVar = this.f2363d.f2370b;
            float f7 = Float.NaN;
            Iterator<p> it2 = this.z.iterator();
            while (it2.hasNext()) {
                p next = it2.next();
                if (next.f2370b != null) {
                    if (next.f2372d < f4) {
                        cVar = next.f2370b;
                        f5 = next.f2372d;
                    } else if (Float.isNaN(f7)) {
                        f7 = next.f2372d;
                    }
                }
                int i5 = i2;
            }
            if (cVar != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                float f8 = f7 - f5;
                d2 = (double) ((((float) cVar.a((double) ((f4 - f5) / f8))) * f8) + f5);
            }
            this.f2366g[0].a(d2, this.m);
            b bVar = this.f2367h;
            if (bVar != null) {
                double[] dArr = this.m;
                if (dArr.length > 0) {
                    bVar.a(d2, dArr);
                }
            }
            int i6 = i4 * 2;
            this.f2363d.a(this.l, this.m, fArr2, i6);
            if (gVar2 != null) {
                fArr2[i6] = fArr2[i6] + gVar2.a(f4);
            } else if (rVar != null) {
                fArr2[i6] = fArr2[i6] + rVar.a(f4);
            }
            if (gVar != null) {
                int i7 = i6 + 1;
                fArr2[i7] = fArr2[i7] + gVar.a(f4);
            } else if (rVar2 != null) {
                int i8 = i6 + 1;
                fArr2[i8] = fArr2[i8] + rVar2.a(f4);
            }
            i4++;
            i3 = i2;
            f2 = 1.0f;
        }
    }

    private float b() {
        float[] fArr = new float[2];
        double d2 = 0.0d;
        double d3 = 0.0d;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < 100; i2++) {
            float f3 = ((float) i2) * 0.01010101f;
            double d4 = (double) f3;
            c cVar = this.f2363d.f2370b;
            float f4 = Float.NaN;
            Iterator<p> it2 = this.z.iterator();
            float f5 = 0.0f;
            while (it2.hasNext()) {
                p next = it2.next();
                if (next.f2370b != null) {
                    if (next.f2372d < f3) {
                        cVar = next.f2370b;
                        f5 = next.f2372d;
                    } else if (Float.isNaN(f4)) {
                        f4 = next.f2372d;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f4)) {
                    f4 = 1.0f;
                }
                float f6 = f4 - f5;
                d4 = (double) ((((float) cVar.a((double) ((f3 - f5) / f6))) * f6) + f5);
            }
            this.f2366g[0].a(d4, this.m);
            this.f2363d.a(this.l, this.m, fArr, 0);
            if (i2 > 0) {
                f2 = (float) (((double) f2) + Math.hypot(d3 - ((double) fArr[1]), d2 - ((double) fArr[0])));
            }
            d2 = (double) fArr[0];
            d3 = (double) fArr[1];
        }
        return f2;
    }

    /* access modifiers changed from: package-private */
    public final int a(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] a2 = this.f2366g[0].a();
        if (iArr != null) {
            Iterator<p> it2 = this.z.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr[i2] = it2.next().n;
                i2++;
            }
        }
        int i3 = 0;
        for (double a3 : a2) {
            this.f2366g[0].a(a3, this.m);
            this.f2363d.a(this.l, this.m, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: androidx.constraintlayout.motion.widget.g$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v44, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v163, resolved type: androidx.constraintlayout.motion.widget.r$b} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0261, code lost:
        r7 = r16;
        r14 = r18;
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0267, code lost:
        r6 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0361, code lost:
        r7 = r16;
        r14 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03ab, code lost:
        r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03bf, code lost:
        r16 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03c1, code lost:
        switch(r16) {
            case 0: goto L_0x0423;
            case 1: goto L_0x041d;
            case 2: goto L_0x0417;
            case 3: goto L_0x0411;
            case 4: goto L_0x040b;
            case 5: goto L_0x0405;
            case 6: goto L_0x03ff;
            case 7: goto L_0x03f9;
            case 8: goto L_0x03f3;
            case 9: goto L_0x03ed;
            case 10: goto L_0x03e7;
            case 11: goto L_0x03e1;
            case 12: goto L_0x03db;
            case 13: goto L_0x03d5;
            case 14: goto L_0x03cf;
            case 15: goto L_0x03c9;
            default: goto L_0x03c4;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03c4, code lost:
        r16 = r7;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03c9, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03cf, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03d5, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03db, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03e1, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03e7, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03ed, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03f3, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03f9, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03ff, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0405, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x040b, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0411, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0417, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x041d, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0423, code lost:
        r16 = new androidx.constraintlayout.motion.widget.r.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0428, code lost:
        r29 = r16;
        r16 = r7;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x08b4, code lost:
        r7 = r16;
        r6 = r17;
        r15 = r18;
        r10 = r19;
        r12 = r21;
        r9 = r22;
        r4 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x08c2, code lost:
        r5 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x08c4, code lost:
        r13 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x097b, code lost:
        r7 = r16;
        r6 = r17;
        r15 = r18;
        r10 = r19;
        r12 = r21;
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x09d2, code lost:
        r12 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0a15, code lost:
        r7 = r16;
        r6 = r17;
        r15 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x0a9f, code lost:
        r16 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0aa1, code lost:
        switch(r16) {
            case 0: goto L_0x0af4;
            case 1: goto L_0x0aee;
            case 2: goto L_0x0ae8;
            case 3: goto L_0x0ae2;
            case 4: goto L_0x0adc;
            case 5: goto L_0x0ad6;
            case 6: goto L_0x0ad0;
            case 7: goto L_0x0aca;
            case 8: goto L_0x0ac4;
            case 9: goto L_0x0abe;
            case 10: goto L_0x0ab8;
            case 11: goto L_0x0ab2;
            case 12: goto L_0x0aac;
            case 13: goto L_0x0aa6;
            default: goto L_0x0aa4;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x0aa4, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:400:0x0aa6, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x0aac, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0ab2, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x0ab8, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x0abe, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0ac4, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x0aca, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:0x0ad0, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x0ad6, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x0adc, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x0ae2, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x0ae8, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.C0032g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x0aee, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x0af4, code lost:
        r16 = new androidx.constraintlayout.motion.widget.g.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0af9, code lost:
        r14 = r16;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r31, int r32, long r33) {
        /*
            r30 = this;
            r0 = r30
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r5 = r0.s
            int r6 = androidx.constraintlayout.motion.widget.c.f2299a
            if (r5 == r6) goto L_0x0027
            androidx.constraintlayout.motion.widget.p r5 = r0.f2363d
            int r6 = r0.s
            r5.l = r6
        L_0x0027:
            androidx.constraintlayout.motion.widget.m r5 = r0.f2365f
            androidx.constraintlayout.motion.widget.m r6 = r0.u
            float r7 = r5.f2351a
            float r8 = r6.f2351a
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r8)
            java.lang.String r8 = "alpha"
            if (r7 == 0) goto L_0x003a
            r2.add(r8)
        L_0x003a:
            float r7 = r5.f2355e
            float r9 = r6.f2355e
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r9)
            java.lang.String r9 = "elevation"
            if (r7 == 0) goto L_0x0049
            r2.add(r9)
        L_0x0049:
            int r7 = r5.f2353c
            int r10 = r6.f2353c
            if (r7 == r10) goto L_0x005e
            int r7 = r5.f2352b
            if (r7 != 0) goto L_0x005e
            int r7 = r5.f2353c
            if (r7 == 0) goto L_0x005b
            int r7 = r6.f2353c
            if (r7 != 0) goto L_0x005e
        L_0x005b:
            r2.add(r8)
        L_0x005e:
            float r7 = r5.f2356f
            float r10 = r6.f2356f
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r10)
            java.lang.String r10 = "rotation"
            if (r7 == 0) goto L_0x006d
            r2.add(r10)
        L_0x006d:
            float r7 = r5.p
            boolean r7 = java.lang.Float.isNaN(r7)
            java.lang.String r11 = "transitionPathRotate"
            if (r7 == 0) goto L_0x0080
            float r7 = r6.p
            boolean r7 = java.lang.Float.isNaN(r7)
            if (r7 != 0) goto L_0x0083
        L_0x0080:
            r2.add(r11)
        L_0x0083:
            float r7 = r5.q
            boolean r7 = java.lang.Float.isNaN(r7)
            java.lang.String r12 = "progress"
            if (r7 == 0) goto L_0x0095
            float r7 = r6.q
            boolean r7 = java.lang.Float.isNaN(r7)
            if (r7 != 0) goto L_0x0098
        L_0x0095:
            r2.add(r12)
        L_0x0098:
            float r7 = r5.f2357g
            float r13 = r6.f2357g
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r13)
            java.lang.String r13 = "rotationX"
            if (r7 == 0) goto L_0x00a7
            r2.add(r13)
        L_0x00a7:
            float r7 = r5.f2358h
            float r14 = r6.f2358h
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r14)
            java.lang.String r14 = "rotationY"
            if (r7 == 0) goto L_0x00b6
            r2.add(r14)
        L_0x00b6:
            float r7 = r5.k
            float r15 = r6.k
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r15)
            if (r7 == 0) goto L_0x00c6
            java.lang.String r7 = "transformPivotX"
            r2.add(r7)
        L_0x00c6:
            float r7 = r5.l
            float r15 = r6.l
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r15)
            if (r7 == 0) goto L_0x00d6
            java.lang.String r7 = "transformPivotY"
            r2.add(r7)
        L_0x00d6:
            float r7 = r5.f2359i
            float r15 = r6.f2359i
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r15)
            java.lang.String r15 = "scaleX"
            if (r7 == 0) goto L_0x00e5
            r2.add(r15)
        L_0x00e5:
            float r7 = r5.j
            r16 = r13
            float r13 = r6.j
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r13)
            java.lang.String r13 = "scaleY"
            if (r7 == 0) goto L_0x00f6
            r2.add(r13)
        L_0x00f6:
            float r7 = r5.m
            r17 = r14
            float r14 = r6.m
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r14)
            java.lang.String r14 = "translationX"
            if (r7 == 0) goto L_0x0108
            r2.add(r14)
        L_0x0108:
            float r7 = r5.n
            r18 = r14
            float r14 = r6.n
            boolean r7 = androidx.constraintlayout.motion.widget.m.a((float) r7, (float) r14)
            java.lang.String r14 = "translationY"
            if (r7 == 0) goto L_0x011a
            r2.add(r14)
        L_0x011a:
            float r5 = r5.o
            float r6 = r6.o
            boolean r5 = androidx.constraintlayout.motion.widget.m.a((float) r5, (float) r6)
            if (r5 == 0) goto L_0x012a
            java.lang.String r5 = "translationZ"
            r2.add(r5)
        L_0x012a:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c> r5 = r0.p
            if (r5 == 0) goto L_0x01d2
            java.util.Iterator r5 = r5.iterator()
            r19 = 0
        L_0x0134:
            boolean r20 = r5.hasNext()
            if (r20 == 0) goto L_0x01cb
            java.lang.Object r20 = r5.next()
            r6 = r20
            androidx.constraintlayout.motion.widget.c r6 = (androidx.constraintlayout.motion.widget.c) r6
            boolean r7 = r6 instanceof androidx.constraintlayout.motion.widget.i
            if (r7 == 0) goto L_0x0192
            androidx.constraintlayout.motion.widget.i r6 = (androidx.constraintlayout.motion.widget.i) r6
            androidx.constraintlayout.motion.widget.p r7 = new androidx.constraintlayout.motion.widget.p
            r27 = r5
            androidx.constraintlayout.motion.widget.p r5 = r0.f2363d
            r28 = r14
            androidx.constraintlayout.motion.widget.p r14 = r0.f2364e
            r21 = r7
            r22 = r31
            r23 = r32
            r24 = r6
            r25 = r5
            r26 = r14
            r21.<init>(r22, r23, r24, r25, r26)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p> r5 = r0.z
            int r5 = java.util.Collections.binarySearch(r5, r7)
            if (r5 != 0) goto L_0x017d
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r21 = r12
            java.lang.String r12 = " KeyPath positon \""
            r14.<init>(r12)
            float r12 = r7.f2373e
            r14.append(r12)
            java.lang.String r12 = "\" outside of range"
            r14.append(r12)
            goto L_0x017f
        L_0x017d:
            r21 = r12
        L_0x017f:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p> r12 = r0.z
            int r5 = -r5
            r14 = 1
            int r5 = r5 - r14
            r12.add(r5, r7)
            int r5 = r6.q
            int r7 = androidx.constraintlayout.motion.widget.c.f2299a
            if (r5 == r7) goto L_0x01c3
            int r5 = r6.q
            r0.t = r5
            goto L_0x01c3
        L_0x0192:
            r27 = r5
            r21 = r12
            r28 = r14
            boolean r5 = r6 instanceof androidx.constraintlayout.motion.widget.f
            if (r5 == 0) goto L_0x01a0
            r6.a((java.util.HashSet<java.lang.String>) r3)
            goto L_0x01c3
        L_0x01a0:
            boolean r5 = r6 instanceof androidx.constraintlayout.motion.widget.k
            if (r5 == 0) goto L_0x01a8
            r6.a((java.util.HashSet<java.lang.String>) r1)
            goto L_0x01c3
        L_0x01a8:
            boolean r5 = r6 instanceof androidx.constraintlayout.motion.widget.l
            if (r5 == 0) goto L_0x01bd
            if (r19 != 0) goto L_0x01b3
            java.util.ArrayList r19 = new java.util.ArrayList
            r19.<init>()
        L_0x01b3:
            r5 = r19
            androidx.constraintlayout.motion.widget.l r6 = (androidx.constraintlayout.motion.widget.l) r6
            r5.add(r6)
            r19 = r5
            goto L_0x01c3
        L_0x01bd:
            r6.b(r4)
            r6.a((java.util.HashSet<java.lang.String>) r2)
        L_0x01c3:
            r12 = r21
            r5 = r27
            r14 = r28
            goto L_0x0134
        L_0x01cb:
            r21 = r12
            r28 = r14
            r5 = r19
            goto L_0x01d7
        L_0x01d2:
            r21 = r12
            r28 = r14
            r5 = 0
        L_0x01d7:
            r7 = 0
            if (r5 == 0) goto L_0x01e4
            androidx.constraintlayout.motion.widget.l[] r6 = new androidx.constraintlayout.motion.widget.l[r7]
            java.lang.Object[] r5 = r5.toArray(r6)
            androidx.constraintlayout.motion.widget.l[] r5 = (androidx.constraintlayout.motion.widget.l[]) r5
            r0.B = r5
        L_0x01e4:
            boolean r5 = r2.isEmpty()
            if (r5 != 0) goto L_0x04b6
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r0.q = r5
            java.util.Iterator r5 = r2.iterator()
        L_0x01f5:
            boolean r12 = r5.hasNext()
            if (r12 == 0) goto L_0x0449
            java.lang.Object r12 = r5.next()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r14 = "CUSTOM,"
            boolean r14 = r12.startsWith(r14)
            if (r14 == 0) goto L_0x0258
            android.util.SparseArray r14 = new android.util.SparseArray
            r14.<init>()
            java.lang.String r6 = ","
            java.lang.String[] r6 = r12.split(r6)
            r19 = 1
            r6 = r6[r19]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c> r7 = r0.p
            java.util.Iterator r7 = r7.iterator()
        L_0x021e:
            boolean r19 = r7.hasNext()
            if (r19 == 0) goto L_0x0248
            java.lang.Object r19 = r7.next()
            r22 = r5
            r5 = r19
            androidx.constraintlayout.motion.widget.c r5 = (androidx.constraintlayout.motion.widget.c) r5
            r19 = r7
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r7 = r5.f2304f
            if (r7 == 0) goto L_0x0243
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r7 = r5.f2304f
            java.lang.Object r7 = r7.get(r6)
            androidx.constraintlayout.widget.a r7 = (androidx.constraintlayout.widget.a) r7
            if (r7 == 0) goto L_0x0243
            int r5 = r5.f2300b
            r14.append(r5, r7)
        L_0x0243:
            r7 = r19
            r5 = r22
            goto L_0x021e
        L_0x0248:
            r22 = r5
            androidx.constraintlayout.motion.widget.r$b r6 = new androidx.constraintlayout.motion.widget.r$b
            r6.<init>(r12, r14)
            r7 = r6
            r14 = r18
            r5 = r21
            r6 = r28
            goto L_0x042e
        L_0x0258:
            r22 = r5
            int r5 = r12.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x03ae;
                case -1249320805: goto L_0x0392;
                case -1225497657: goto L_0x037f;
                case -1225497656: goto L_0x0367;
                case -1225497655: goto L_0x034a;
                case -1001078227: goto L_0x0336;
                case -908189618: goto L_0x0322;
                case -908189617: goto L_0x030e;
                case -797520672: goto L_0x02f7;
                case -760884510: goto L_0x02e1;
                case -760884509: goto L_0x02cb;
                case -40300674: goto L_0x02b9;
                case -4379043: goto L_0x02a7;
                case 37232917: goto L_0x0294;
                case 92909918: goto L_0x0282;
                case 156108012: goto L_0x026b;
                default: goto L_0x0261;
            }
        L_0x0261:
            r7 = r16
            r14 = r18
            r5 = r21
        L_0x0267:
            r6 = r28
            goto L_0x03bf
        L_0x026b:
            java.lang.String r5 = "waveOffset"
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L_0x0261
            r7 = 10
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            r16 = 10
            goto L_0x03c1
        L_0x0282:
            boolean r5 = r12.equals(r8)
            if (r5 == 0) goto L_0x0261
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            r16 = 0
            goto L_0x03c1
        L_0x0294:
            boolean r5 = r12.equals(r11)
            if (r5 == 0) goto L_0x0261
            r7 = 7
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            r16 = 7
            goto L_0x03c1
        L_0x02a7:
            boolean r5 = r12.equals(r9)
            if (r5 == 0) goto L_0x0261
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            r16 = 1
            goto L_0x03c1
        L_0x02b9:
            boolean r5 = r12.equals(r10)
            if (r5 == 0) goto L_0x0261
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            r16 = 2
            goto L_0x03c1
        L_0x02cb:
            java.lang.String r5 = "transformPivotY"
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L_0x0261
            r7 = 6
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            r16 = 6
            goto L_0x03c1
        L_0x02e1:
            java.lang.String r5 = "transformPivotX"
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L_0x0261
            r7 = 5
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            r16 = 5
            goto L_0x03c1
        L_0x02f7:
            java.lang.String r5 = "waveVariesBy"
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L_0x0261
            r7 = 11
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            r16 = 11
            goto L_0x03c1
        L_0x030e:
            boolean r5 = r12.equals(r13)
            if (r5 == 0) goto L_0x0261
            r7 = 9
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            r16 = 9
            goto L_0x03c1
        L_0x0322:
            boolean r5 = r12.equals(r15)
            if (r5 == 0) goto L_0x0261
            r7 = 8
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            r16 = 8
            goto L_0x03c1
        L_0x0336:
            r5 = r21
            boolean r6 = r12.equals(r5)
            if (r6 == 0) goto L_0x0361
            r7 = 15
            r7 = r16
            r14 = r18
            r6 = r28
            r16 = 15
            goto L_0x03c1
        L_0x034a:
            r5 = r21
            java.lang.String r6 = "translationZ"
            boolean r6 = r12.equals(r6)
            if (r6 == 0) goto L_0x0361
            r7 = 14
            r7 = r16
            r14 = r18
            r6 = r28
            r16 = 14
            goto L_0x03c1
        L_0x0361:
            r7 = r16
            r14 = r18
            goto L_0x0267
        L_0x0367:
            r5 = r21
            r6 = r28
            boolean r14 = r12.equals(r6)
            if (r14 == 0) goto L_0x037a
            r7 = 13
            r7 = r16
            r14 = r18
            r16 = 13
            goto L_0x03c1
        L_0x037a:
            r7 = r16
            r14 = r18
            goto L_0x03bf
        L_0x037f:
            r14 = r18
            r5 = r21
            r6 = r28
            boolean r18 = r12.equals(r14)
            if (r18 == 0) goto L_0x03ab
            r7 = 12
            r7 = r16
            r16 = 12
            goto L_0x03c1
        L_0x0392:
            r7 = r17
            r14 = r18
            r5 = r21
            r6 = r28
            boolean r17 = r12.equals(r7)
            if (r17 == 0) goto L_0x03a9
            r17 = 4
            r17 = r7
            r7 = r16
            r16 = 4
            goto L_0x03c1
        L_0x03a9:
            r17 = r7
        L_0x03ab:
            r7 = r16
            goto L_0x03bf
        L_0x03ae:
            r7 = r16
            r14 = r18
            r5 = r21
            r6 = r28
            boolean r16 = r12.equals(r7)
            if (r16 == 0) goto L_0x03bf
            r16 = 3
            goto L_0x03c1
        L_0x03bf:
            r16 = -1
        L_0x03c1:
            switch(r16) {
                case 0: goto L_0x0423;
                case 1: goto L_0x041d;
                case 2: goto L_0x0417;
                case 3: goto L_0x0411;
                case 4: goto L_0x040b;
                case 5: goto L_0x0405;
                case 6: goto L_0x03ff;
                case 7: goto L_0x03f9;
                case 8: goto L_0x03f3;
                case 9: goto L_0x03ed;
                case 10: goto L_0x03e7;
                case 11: goto L_0x03e1;
                case 12: goto L_0x03db;
                case 13: goto L_0x03d5;
                case 14: goto L_0x03cf;
                case 15: goto L_0x03c9;
                default: goto L_0x03c4;
            }
        L_0x03c4:
            r16 = r7
            r7 = 0
            goto L_0x042e
        L_0x03c9:
            androidx.constraintlayout.motion.widget.r$g r16 = new androidx.constraintlayout.motion.widget.r$g
            r16.<init>()
            goto L_0x0428
        L_0x03cf:
            androidx.constraintlayout.motion.widget.r$p r16 = new androidx.constraintlayout.motion.widget.r$p
            r16.<init>()
            goto L_0x0428
        L_0x03d5:
            androidx.constraintlayout.motion.widget.r$o r16 = new androidx.constraintlayout.motion.widget.r$o
            r16.<init>()
            goto L_0x0428
        L_0x03db:
            androidx.constraintlayout.motion.widget.r$n r16 = new androidx.constraintlayout.motion.widget.r$n
            r16.<init>()
            goto L_0x0428
        L_0x03e1:
            androidx.constraintlayout.motion.widget.r$a r16 = new androidx.constraintlayout.motion.widget.r$a
            r16.<init>()
            goto L_0x0428
        L_0x03e7:
            androidx.constraintlayout.motion.widget.r$a r16 = new androidx.constraintlayout.motion.widget.r$a
            r16.<init>()
            goto L_0x0428
        L_0x03ed:
            androidx.constraintlayout.motion.widget.r$l r16 = new androidx.constraintlayout.motion.widget.r$l
            r16.<init>()
            goto L_0x0428
        L_0x03f3:
            androidx.constraintlayout.motion.widget.r$k r16 = new androidx.constraintlayout.motion.widget.r$k
            r16.<init>()
            goto L_0x0428
        L_0x03f9:
            androidx.constraintlayout.motion.widget.r$d r16 = new androidx.constraintlayout.motion.widget.r$d
            r16.<init>()
            goto L_0x0428
        L_0x03ff:
            androidx.constraintlayout.motion.widget.r$f r16 = new androidx.constraintlayout.motion.widget.r$f
            r16.<init>()
            goto L_0x0428
        L_0x0405:
            androidx.constraintlayout.motion.widget.r$e r16 = new androidx.constraintlayout.motion.widget.r$e
            r16.<init>()
            goto L_0x0428
        L_0x040b:
            androidx.constraintlayout.motion.widget.r$j r16 = new androidx.constraintlayout.motion.widget.r$j
            r16.<init>()
            goto L_0x0428
        L_0x0411:
            androidx.constraintlayout.motion.widget.r$i r16 = new androidx.constraintlayout.motion.widget.r$i
            r16.<init>()
            goto L_0x0428
        L_0x0417:
            androidx.constraintlayout.motion.widget.r$h r16 = new androidx.constraintlayout.motion.widget.r$h
            r16.<init>()
            goto L_0x0428
        L_0x041d:
            androidx.constraintlayout.motion.widget.r$c r16 = new androidx.constraintlayout.motion.widget.r$c
            r16.<init>()
            goto L_0x0428
        L_0x0423:
            androidx.constraintlayout.motion.widget.r$a r16 = new androidx.constraintlayout.motion.widget.r$a
            r16.<init>()
        L_0x0428:
            r29 = r16
            r16 = r7
            r7 = r29
        L_0x042e:
            if (r7 == 0) goto L_0x043e
            r7.f2404d = r12
            r18 = r14
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r14 = r0.q
            r14.put(r12, r7)
            r21 = r5
            r28 = r6
            goto L_0x0444
        L_0x043e:
            r21 = r5
            r28 = r6
            r18 = r14
        L_0x0444:
            r5 = r22
            r7 = 0
            goto L_0x01f5
        L_0x0449:
            r5 = r21
            r6 = r28
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c> r7 = r0.p
            if (r7 == 0) goto L_0x046b
            java.util.Iterator r7 = r7.iterator()
        L_0x0455:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L_0x046b
            java.lang.Object r12 = r7.next()
            androidx.constraintlayout.motion.widget.c r12 = (androidx.constraintlayout.motion.widget.c) r12
            boolean r14 = r12 instanceof androidx.constraintlayout.motion.widget.d
            if (r14 == 0) goto L_0x0455
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r14 = r0.q
            r12.a((java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r>) r14)
            goto L_0x0455
        L_0x046b:
            androidx.constraintlayout.motion.widget.m r7 = r0.f2365f
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r12 = r0.q
            r14 = 0
            r7.a((java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r>) r12, (int) r14)
            androidx.constraintlayout.motion.widget.m r7 = r0.u
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r12 = r0.q
            r14 = 100
            r7.a((java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r>) r12, (int) r14)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r7 = r0.q
            java.util.Set r7 = r7.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0486:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L_0x04ba
            java.lang.Object r12 = r7.next()
            java.lang.String r12 = (java.lang.String) r12
            boolean r14 = r4.containsKey(r12)
            if (r14 == 0) goto L_0x04a5
            java.lang.Object r14 = r4.get(r12)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            r19 = r7
            goto L_0x04a8
        L_0x04a5:
            r19 = r7
            r14 = 0
        L_0x04a8:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r7 = r0.q
            java.lang.Object r7 = r7.get(r12)
            androidx.constraintlayout.motion.widget.r r7 = (androidx.constraintlayout.motion.widget.r) r7
            r7.a((int) r14)
            r7 = r19
            goto L_0x0486
        L_0x04b6:
            r5 = r21
            r6 = r28
        L_0x04ba:
            boolean r7 = r1.isEmpty()
            if (r7 != 0) goto L_0x05b3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r7 = r0.A
            if (r7 != 0) goto L_0x04cb
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.A = r7
        L_0x04cb:
            java.util.Iterator r1 = r1.iterator()
        L_0x04cf:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x055b
            java.lang.Object r7 = r1.next()
            java.lang.String r7 = (java.lang.String) r7
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r12 = r0.A
            boolean r12 = r12.containsKey(r7)
            if (r12 != 0) goto L_0x054f
            java.lang.String r12 = "CUSTOM,"
            boolean r12 = r7.startsWith(r12)
            if (r12 == 0) goto L_0x0537
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.lang.String r14 = ","
            java.lang.String[] r14 = r7.split(r14)
            r19 = 1
            r14 = r14[r19]
            r19 = r1
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c> r1 = r0.p
            java.util.Iterator r1 = r1.iterator()
        L_0x0502:
            boolean r21 = r1.hasNext()
            if (r21 == 0) goto L_0x052c
            java.lang.Object r21 = r1.next()
            r22 = r1
            r1 = r21
            androidx.constraintlayout.motion.widget.c r1 = (androidx.constraintlayout.motion.widget.c) r1
            r28 = r6
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r6 = r1.f2304f
            if (r6 == 0) goto L_0x0527
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.a> r6 = r1.f2304f
            java.lang.Object r6 = r6.get(r14)
            androidx.constraintlayout.widget.a r6 = (androidx.constraintlayout.widget.a) r6
            if (r6 == 0) goto L_0x0527
            int r1 = r1.f2300b
            r12.append(r1, r6)
        L_0x0527:
            r1 = r22
            r6 = r28
            goto L_0x0502
        L_0x052c:
            r28 = r6
            androidx.constraintlayout.motion.widget.s r1 = androidx.constraintlayout.motion.widget.s.a((java.lang.String) r7, (android.util.SparseArray<androidx.constraintlayout.widget.a>) r12)
            r21 = r5
            r5 = r33
            goto L_0x0543
        L_0x0537:
            r19 = r1
            r21 = r5
            r28 = r6
            r5 = r33
            androidx.constraintlayout.motion.widget.s r1 = androidx.constraintlayout.motion.widget.s.a((java.lang.String) r7, (long) r5)
        L_0x0543:
            if (r1 == 0) goto L_0x054c
            r1.f2414e = r7
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r12 = r0.A
            r12.put(r7, r1)
        L_0x054c:
            r1 = r19
            goto L_0x0555
        L_0x054f:
            r21 = r5
            r28 = r6
            r5 = r33
        L_0x0555:
            r5 = r21
            r6 = r28
            goto L_0x04cf
        L_0x055b:
            r21 = r5
            r28 = r6
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c> r1 = r0.p
            if (r1 == 0) goto L_0x057f
            java.util.Iterator r1 = r1.iterator()
        L_0x0567:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x057f
            java.lang.Object r5 = r1.next()
            androidx.constraintlayout.motion.widget.c r5 = (androidx.constraintlayout.motion.widget.c) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.motion.widget.k
            if (r6 == 0) goto L_0x0567
            androidx.constraintlayout.motion.widget.k r5 = (androidx.constraintlayout.motion.widget.k) r5
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r6 = r0.A
            r5.c((java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s>) r6)
            goto L_0x0567
        L_0x057f:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r1 = r0.A
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0589:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x05b7
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = r4.containsKey(r5)
            if (r6 == 0) goto L_0x05a6
            java.lang.Object r6 = r4.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r7 = r6.intValue()
            goto L_0x05a7
        L_0x05a6:
            r7 = 0
        L_0x05a7:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r6 = r0.A
            java.lang.Object r5 = r6.get(r5)
            androidx.constraintlayout.motion.widget.s r5 = (androidx.constraintlayout.motion.widget.s) r5
            r5.a((int) r7)
            goto L_0x0589
        L_0x05b3:
            r21 = r5
            r28 = r6
        L_0x05b7:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p> r1 = r0.z
            int r1 = r1.size()
            r4 = 2
            int r1 = r1 + r4
            androidx.constraintlayout.motion.widget.p[] r1 = new androidx.constraintlayout.motion.widget.p[r1]
            androidx.constraintlayout.motion.widget.p r4 = r0.f2363d
            r5 = 0
            r1[r5] = r4
            int r4 = r1.length
            r6 = 1
            int r4 = r4 - r6
            androidx.constraintlayout.motion.widget.p r6 = r0.f2364e
            r1[r4] = r6
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p> r4 = r0.z
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x05dc
            int r4 = r0.t
            r6 = -1
            if (r4 != r6) goto L_0x05dc
            r0.t = r5
        L_0x05dc:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.p> r4 = r0.z
            java.util.Iterator r4 = r4.iterator()
            r5 = 1
        L_0x05e3:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x05f5
            java.lang.Object r6 = r4.next()
            androidx.constraintlayout.motion.widget.p r6 = (androidx.constraintlayout.motion.widget.p) r6
            int r7 = r5 + 1
            r1[r5] = r6
            r5 = r7
            goto L_0x05e3
        L_0x05f5:
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            androidx.constraintlayout.motion.widget.p r5 = r0.f2364e
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r5 = r5.m
            java.util.Set r5 = r5.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0606:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0630
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            androidx.constraintlayout.motion.widget.p r7 = r0.f2363d
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r7 = r7.m
            boolean r7 = r7.containsKey(r6)
            if (r7 == 0) goto L_0x0606
            java.lang.String r7 = java.lang.String.valueOf(r6)
            java.lang.String r12 = "CUSTOM,"
            java.lang.String r7 = r12.concat(r7)
            boolean r7 = r2.contains(r7)
            if (r7 != 0) goto L_0x0606
            r4.add(r6)
            goto L_0x0606
        L_0x0630:
            r6 = 0
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.Object[] r2 = r4.toArray(r2)
            java.lang.String[] r2 = (java.lang.String[]) r2
            r0.v = r2
            java.lang.String[] r2 = r0.v
            int r2 = r2.length
            int[] r2 = new int[r2]
            r0.w = r2
            r2 = 0
        L_0x0643:
            java.lang.String[] r4 = r0.v
            int r5 = r4.length
            if (r2 >= r5) goto L_0x0679
            r4 = r4[r2]
            int[] r5 = r0.w
            r6 = 0
            r5[r2] = r6
            r5 = 0
        L_0x0650:
            int r6 = r1.length
            if (r5 >= r6) goto L_0x0676
            r6 = r1[r5]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r6 = r6.m
            boolean r6 = r6.containsKey(r4)
            if (r6 == 0) goto L_0x0673
            int[] r6 = r0.w
            r7 = r6[r2]
            r5 = r1[r5]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r5 = r5.m
            java.lang.Object r4 = r5.get(r4)
            androidx.constraintlayout.widget.a r4 = (androidx.constraintlayout.widget.a) r4
            int r4 = r4.a()
            int r7 = r7 + r4
            r6[r2] = r7
            goto L_0x0676
        L_0x0673:
            int r5 = r5 + 1
            goto L_0x0650
        L_0x0676:
            int r2 = r2 + 1
            goto L_0x0643
        L_0x0679:
            r2 = 0
            r4 = r1[r2]
            int r2 = r4.l
            int r4 = androidx.constraintlayout.motion.widget.c.f2299a
            if (r2 == r4) goto L_0x0684
            r2 = 1
            goto L_0x0685
        L_0x0684:
            r2 = 0
        L_0x0685:
            java.lang.String[] r4 = r0.v
            int r4 = r4.length
            int r4 = r4 + 18
            boolean[] r4 = new boolean[r4]
            r5 = 1
        L_0x068d:
            int r6 = r1.length
            if (r5 >= r6) goto L_0x06e9
            r6 = r1[r5]
            int r7 = r5 + -1
            r7 = r1[r7]
            r12 = 0
            boolean r14 = r4[r12]
            float r12 = r6.f2373e
            r19 = r15
            float r15 = r7.f2373e
            boolean r12 = androidx.constraintlayout.motion.widget.p.a((float) r12, (float) r15)
            r12 = r12 | r14
            r14 = 0
            r4[r14] = r12
            r12 = 1
            boolean r14 = r4[r12]
            float r15 = r6.f2374f
            float r12 = r7.f2374f
            boolean r12 = androidx.constraintlayout.motion.widget.p.a((float) r15, (float) r12)
            r12 = r12 | r2
            r12 = r12 | r14
            r14 = 1
            r4[r14] = r12
            r12 = 2
            boolean r14 = r4[r12]
            float r15 = r6.f2375g
            float r12 = r7.f2375g
            boolean r12 = androidx.constraintlayout.motion.widget.p.a((float) r15, (float) r12)
            r12 = r12 | r2
            r12 = r12 | r14
            r14 = 2
            r4[r14] = r12
            r12 = 3
            boolean r14 = r4[r12]
            float r15 = r6.f2376h
            float r12 = r7.f2376h
            boolean r12 = androidx.constraintlayout.motion.widget.p.a((float) r15, (float) r12)
            r12 = r12 | r14
            r14 = 3
            r4[r14] = r12
            r12 = 4
            boolean r14 = r4[r12]
            float r6 = r6.f2377i
            float r7 = r7.f2377i
            boolean r6 = androidx.constraintlayout.motion.widget.p.a((float) r6, (float) r7)
            r6 = r6 | r14
            r4[r12] = r6
            int r5 = r5 + 1
            r15 = r19
            goto L_0x068d
        L_0x06e9:
            r19 = r15
            r2 = 1
            r5 = 0
        L_0x06ed:
            int r6 = r4.length
            if (r2 >= r6) goto L_0x06f9
            boolean r6 = r4[r2]
            if (r6 == 0) goto L_0x06f6
            int r5 = r5 + 1
        L_0x06f6:
            int r2 = r2 + 1
            goto L_0x06ed
        L_0x06f9:
            int[] r2 = new int[r5]
            r0.l = r2
            int[] r2 = r0.l
            int r5 = r2.length
            double[] r5 = new double[r5]
            r0.m = r5
            int r2 = r2.length
            double[] r2 = new double[r2]
            r0.n = r2
            r2 = 1
            r5 = 0
        L_0x070b:
            int r6 = r4.length
            if (r2 >= r6) goto L_0x071c
            boolean r6 = r4[r2]
            if (r6 == 0) goto L_0x0719
            int[] r6 = r0.l
            int r7 = r5 + 1
            r6[r5] = r2
            r5 = r7
        L_0x0719:
            int r2 = r2 + 1
            goto L_0x070b
        L_0x071c:
            int r2 = r1.length
            int[] r4 = r0.l
            int r4 = r4.length
            int[] r2 = new int[]{r2, r4}
            java.lang.Class<double> r4 = double.class
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r4, r2)
            double[][] r2 = (double[][]) r2
            int r4 = r1.length
            double[] r4 = new double[r4]
            r5 = 0
        L_0x0730:
            int r6 = r1.length
            if (r5 >= r6) goto L_0x0746
            r6 = r1[r5]
            r7 = r2[r5]
            int[] r12 = r0.l
            r6.a((double[]) r7, (int[]) r12)
            r6 = r1[r5]
            float r6 = r6.f2372d
            double r6 = (double) r6
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x0730
        L_0x0746:
            r5 = 0
        L_0x0747:
            int[] r6 = r0.l
            int r7 = r6.length
            if (r5 >= r7) goto L_0x078a
            r6 = r6[r5]
            java.lang.String[] r7 = androidx.constraintlayout.motion.widget.p.f2369a
            int r7 = r7.length
            if (r6 >= r7) goto L_0x0787
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String[] r7 = androidx.constraintlayout.motion.widget.p.f2369a
            int[] r12 = r0.l
            r12 = r12[r5]
            r7 = r7[r12]
            r6.append(r7)
            java.lang.String r7 = " ["
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = r6
            r6 = 0
        L_0x076e:
            int r12 = r1.length
            if (r6 >= r12) goto L_0x0787
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r7)
            r7 = r2[r6]
            r14 = r7[r5]
            r12.append(r14)
            java.lang.String r7 = r12.toString()
            int r6 = r6 + 1
            goto L_0x076e
        L_0x0787:
            int r5 = r5 + 1
            goto L_0x0747
        L_0x078a:
            java.lang.String[] r5 = r0.v
            int r5 = r5.length
            r6 = 1
            int r5 = r5 + r6
            androidx.constraintlayout.motion.a.b[] r5 = new androidx.constraintlayout.motion.a.b[r5]
            r0.f2366g = r5
            r5 = 0
        L_0x0794:
            java.lang.String[] r6 = r0.v
            int r7 = r6.length
            if (r5 >= r7) goto L_0x0811
            r6 = r6[r5]
            r22 = r13
            r7 = 0
            r12 = 0
            r14 = 0
            r15 = 0
        L_0x07a1:
            int r13 = r1.length
            if (r7 >= r13) goto L_0x07f0
            r13 = r1[r7]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r13 = r13.m
            boolean r13 = r13.containsKey(r6)
            if (r13 == 0) goto L_0x07e5
            if (r15 != 0) goto L_0x07cf
            int r12 = r1.length
            double[] r12 = new double[r12]
            int r13 = r1.length
            r15 = r1[r7]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r15 = r15.m
            java.lang.Object r15 = r15.get(r6)
            androidx.constraintlayout.widget.a r15 = (androidx.constraintlayout.widget.a) r15
            int r15 = r15.a()
            int[] r13 = new int[]{r13, r15}
            java.lang.Class<double> r15 = double.class
            java.lang.Object r13 = java.lang.reflect.Array.newInstance(r15, r13)
            r15 = r13
            double[][] r15 = (double[][]) r15
        L_0x07cf:
            r13 = r1[r7]
            float r13 = r13.f2372d
            r23 = r9
            r24 = r10
            double r9 = (double) r13
            r12[r14] = r9
            r9 = r1[r7]
            r10 = r15[r14]
            r13 = 0
            r9.a(r6, r10, r13)
            int r14 = r14 + 1
            goto L_0x07e9
        L_0x07e5:
            r23 = r9
            r24 = r10
        L_0x07e9:
            int r7 = r7 + 1
            r9 = r23
            r10 = r24
            goto L_0x07a1
        L_0x07f0:
            r23 = r9
            r24 = r10
            double[] r6 = java.util.Arrays.copyOf(r12, r14)
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r15, r14)
            double[][] r7 = (double[][]) r7
            androidx.constraintlayout.motion.a.b[] r9 = r0.f2366g
            int r5 = r5 + 1
            int r10 = r0.t
            androidx.constraintlayout.motion.a.b r6 = androidx.constraintlayout.motion.a.b.a(r10, r6, r7)
            r9[r5] = r6
            r13 = r22
            r9 = r23
            r10 = r24
            goto L_0x0794
        L_0x0811:
            r23 = r9
            r24 = r10
            r22 = r13
            androidx.constraintlayout.motion.a.b[] r5 = r0.f2366g
            int r6 = r0.t
            androidx.constraintlayout.motion.a.b r2 = androidx.constraintlayout.motion.a.b.a(r6, r4, r2)
            r4 = 0
            r5[r4] = r2
            r2 = r1[r4]
            int r2 = r2.l
            int r4 = androidx.constraintlayout.motion.widget.c.f2299a
            if (r2 == r4) goto L_0x086c
            int r2 = r1.length
            int[] r4 = new int[r2]
            double[] r5 = new double[r2]
            r6 = 2
            int[] r7 = new int[]{r2, r6}
            java.lang.Class<double> r9 = double.class
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r9, r7)
            double[][] r7 = (double[][]) r7
            r9 = 0
        L_0x083d:
            if (r9 >= r2) goto L_0x0863
            r10 = r1[r9]
            int r10 = r10.l
            r4[r9] = r10
            r10 = r1[r9]
            float r10 = r10.f2372d
            double r12 = (double) r10
            r5[r9] = r12
            r10 = r7[r9]
            r12 = r1[r9]
            float r12 = r12.f2374f
            double r12 = (double) r12
            r14 = 0
            r10[r14] = r12
            r10 = r7[r9]
            r12 = r1[r9]
            float r12 = r12.f2375g
            double r12 = (double) r12
            r15 = 1
            r10[r15] = r12
            int r9 = r9 + 1
            goto L_0x083d
        L_0x0863:
            r14 = 0
            androidx.constraintlayout.motion.a.a r1 = new androidx.constraintlayout.motion.a.a
            r1.<init>(r4, r5, r7)
            r0.f2367h = r1
            goto L_0x086e
        L_0x086c:
            r6 = 2
            r14 = 0
        L_0x086e:
            r1 = 2143289344(0x7fc00000, float:NaN)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.r = r2
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c> r2 = r0.p
            if (r2 == 0) goto L_0x0b6d
            java.util.Iterator r2 = r3.iterator()
        L_0x087f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0b35
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "CUSTOM"
            boolean r4 = r3.startsWith(r4)
            if (r4 == 0) goto L_0x08ad
            androidx.constraintlayout.motion.widget.g$b r4 = new androidx.constraintlayout.motion.widget.g$b
            r4.<init>()
            r14 = r4
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
            r5 = r24
            r13 = r28
            goto L_0x0afb
        L_0x08ad:
            int r4 = r3.hashCode()
            switch(r4) {
                case -1249320806: goto L_0x0a84;
                case -1249320805: goto L_0x0a65;
                case -1225497657: goto L_0x0a43;
                case -1225497656: goto L_0x0a1d;
                case -1225497655: goto L_0x09f4;
                case -1001078227: goto L_0x09d6;
                case -908189618: goto L_0x09af;
                case -908189617: goto L_0x0989;
                case -797520672: goto L_0x095a;
                case -40300674: goto L_0x093e;
                case -4379043: goto L_0x0922;
                case 37232917: goto L_0x0905;
                case 92909918: goto L_0x08e9;
                case 156108012: goto L_0x08c8;
                default: goto L_0x08b4;
            }
        L_0x08b4:
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
        L_0x08c2:
            r5 = r24
        L_0x08c4:
            r13 = r28
            goto L_0x0a9f
        L_0x08c8:
            java.lang.String r4 = "waveOffset"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x08b4
            r7 = 8
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
            r5 = r24
            r13 = r28
            r16 = 8
            goto L_0x0aa1
        L_0x08e9:
            boolean r4 = r3.equals(r8)
            if (r4 == 0) goto L_0x08b4
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
            r5 = r24
            r13 = r28
            r16 = 0
            goto L_0x0aa1
        L_0x0905:
            boolean r4 = r3.equals(r11)
            if (r4 == 0) goto L_0x08b4
            r7 = 5
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
            r5 = r24
            r13 = r28
            r16 = 5
            goto L_0x0aa1
        L_0x0922:
            r4 = r23
            boolean r5 = r3.equals(r4)
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            if (r5 == 0) goto L_0x08c2
            r5 = r24
            r13 = r28
            r16 = 1
            goto L_0x0aa1
        L_0x093e:
            r4 = r23
            r5 = r24
            boolean r9 = r3.equals(r5)
            if (r9 == 0) goto L_0x097b
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            r13 = r28
            r16 = 2
            goto L_0x0aa1
        L_0x095a:
            r4 = r23
            r5 = r24
            java.lang.String r9 = "waveVariesBy"
            boolean r9 = r3.equals(r9)
            if (r9 == 0) goto L_0x097b
            r7 = 9
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            r13 = r28
            r16 = 9
            goto L_0x0aa1
        L_0x097b:
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            goto L_0x08c4
        L_0x0989:
            r9 = r22
            r4 = r23
            r5 = r24
            boolean r10 = r3.equals(r9)
            if (r10 == 0) goto L_0x09a6
            r7 = 7
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r13 = r28
            r16 = 7
            goto L_0x0aa1
        L_0x09a6:
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            goto L_0x09d2
        L_0x09af:
            r10 = r19
            r9 = r22
            r4 = r23
            r5 = r24
            boolean r12 = r3.equals(r10)
            if (r12 == 0) goto L_0x09cc
            r7 = 6
            r7 = r16
            r6 = r17
            r15 = r18
            r12 = r21
            r13 = r28
            r16 = 6
            goto L_0x0aa1
        L_0x09cc:
            r7 = r16
            r6 = r17
            r15 = r18
        L_0x09d2:
            r12 = r21
            goto L_0x08c4
        L_0x09d6:
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
            r5 = r24
            boolean r13 = r3.equals(r12)
            if (r13 == 0) goto L_0x0a15
            r7 = 13
            r7 = r16
            r6 = r17
            r15 = r18
            r13 = r28
            r16 = 13
            goto L_0x0aa1
        L_0x09f4:
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
            r5 = r24
            java.lang.String r13 = "translationZ"
            boolean r13 = r3.equals(r13)
            if (r13 == 0) goto L_0x0a15
            r7 = 12
            r7 = r16
            r6 = r17
            r15 = r18
            r13 = r28
            r16 = 12
            goto L_0x0aa1
        L_0x0a15:
            r7 = r16
            r6 = r17
            r15 = r18
            goto L_0x08c4
        L_0x0a1d:
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
            r5 = r24
            r13 = r28
            boolean r15 = r3.equals(r13)
            if (r15 == 0) goto L_0x0a3b
            r7 = 11
            r7 = r16
            r6 = r17
            r15 = r18
            r16 = 11
            goto L_0x0aa1
        L_0x0a3b:
            r7 = r16
            r6 = r17
            r15 = r18
            goto L_0x0a9f
        L_0x0a43:
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
            r5 = r24
            r13 = r28
            boolean r18 = r3.equals(r15)
            if (r18 == 0) goto L_0x0a60
            r7 = 10
            r7 = r16
            r6 = r17
            r16 = 10
            goto L_0x0aa1
        L_0x0a60:
            r7 = r16
            r6 = r17
            goto L_0x0a9f
        L_0x0a65:
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
            r5 = r24
            r13 = r28
            boolean r17 = r3.equals(r6)
            if (r17 == 0) goto L_0x0a81
            r7 = 4
            r7 = r16
            r16 = 4
            goto L_0x0aa1
        L_0x0a81:
            r7 = r16
            goto L_0x0a9f
        L_0x0a84:
            r7 = r16
            r6 = r17
            r15 = r18
            r10 = r19
            r12 = r21
            r9 = r22
            r4 = r23
            r5 = r24
            r13 = r28
            boolean r16 = r3.equals(r7)
            if (r16 == 0) goto L_0x0a9f
            r16 = 3
            goto L_0x0aa1
        L_0x0a9f:
            r16 = -1
        L_0x0aa1:
            switch(r16) {
                case 0: goto L_0x0af4;
                case 1: goto L_0x0aee;
                case 2: goto L_0x0ae8;
                case 3: goto L_0x0ae2;
                case 4: goto L_0x0adc;
                case 5: goto L_0x0ad6;
                case 6: goto L_0x0ad0;
                case 7: goto L_0x0aca;
                case 8: goto L_0x0ac4;
                case 9: goto L_0x0abe;
                case 10: goto L_0x0ab8;
                case 11: goto L_0x0ab2;
                case 12: goto L_0x0aac;
                case 13: goto L_0x0aa6;
                default: goto L_0x0aa4;
            }
        L_0x0aa4:
            r14 = 0
            goto L_0x0afb
        L_0x0aa6:
            androidx.constraintlayout.motion.widget.g$f r16 = new androidx.constraintlayout.motion.widget.g$f
            r16.<init>()
            goto L_0x0af9
        L_0x0aac:
            androidx.constraintlayout.motion.widget.g$n r16 = new androidx.constraintlayout.motion.widget.g$n
            r16.<init>()
            goto L_0x0af9
        L_0x0ab2:
            androidx.constraintlayout.motion.widget.g$m r16 = new androidx.constraintlayout.motion.widget.g$m
            r16.<init>()
            goto L_0x0af9
        L_0x0ab8:
            androidx.constraintlayout.motion.widget.g$l r16 = new androidx.constraintlayout.motion.widget.g$l
            r16.<init>()
            goto L_0x0af9
        L_0x0abe:
            androidx.constraintlayout.motion.widget.g$a r16 = new androidx.constraintlayout.motion.widget.g$a
            r16.<init>()
            goto L_0x0af9
        L_0x0ac4:
            androidx.constraintlayout.motion.widget.g$a r16 = new androidx.constraintlayout.motion.widget.g$a
            r16.<init>()
            goto L_0x0af9
        L_0x0aca:
            androidx.constraintlayout.motion.widget.g$k r16 = new androidx.constraintlayout.motion.widget.g$k
            r16.<init>()
            goto L_0x0af9
        L_0x0ad0:
            androidx.constraintlayout.motion.widget.g$j r16 = new androidx.constraintlayout.motion.widget.g$j
            r16.<init>()
            goto L_0x0af9
        L_0x0ad6:
            androidx.constraintlayout.motion.widget.g$e r16 = new androidx.constraintlayout.motion.widget.g$e
            r16.<init>()
            goto L_0x0af9
        L_0x0adc:
            androidx.constraintlayout.motion.widget.g$i r16 = new androidx.constraintlayout.motion.widget.g$i
            r16.<init>()
            goto L_0x0af9
        L_0x0ae2:
            androidx.constraintlayout.motion.widget.g$h r16 = new androidx.constraintlayout.motion.widget.g$h
            r16.<init>()
            goto L_0x0af9
        L_0x0ae8:
            androidx.constraintlayout.motion.widget.g$g r16 = new androidx.constraintlayout.motion.widget.g$g
            r16.<init>()
            goto L_0x0af9
        L_0x0aee:
            androidx.constraintlayout.motion.widget.g$d r16 = new androidx.constraintlayout.motion.widget.g$d
            r16.<init>()
            goto L_0x0af9
        L_0x0af4:
            androidx.constraintlayout.motion.widget.g$a r16 = new androidx.constraintlayout.motion.widget.g$a
            r16.<init>()
        L_0x0af9:
            r14 = r16
        L_0x0afb:
            if (r14 == 0) goto L_0x0b1f
            r33 = r2
            int r2 = r14.f2317d
            r23 = r4
            r4 = 1
            if (r2 != r4) goto L_0x0b08
            r2 = 1
            goto L_0x0b09
        L_0x0b08:
            r2 = 0
        L_0x0b09:
            if (r2 == 0) goto L_0x0b15
            boolean r2 = java.lang.Float.isNaN(r1)
            if (r2 == 0) goto L_0x0b15
            float r1 = r30.b()
        L_0x0b15:
            r14.f2315b = r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.g> r2 = r0.r
            r2.put(r3, r14)
            r2 = r33
            goto L_0x0b21
        L_0x0b1f:
            r23 = r4
        L_0x0b21:
            r24 = r5
            r17 = r6
            r16 = r7
            r22 = r9
            r19 = r10
            r21 = r12
            r28 = r13
            r18 = r15
            r6 = 2
            r14 = 0
            goto L_0x087f
        L_0x0b35:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c> r2 = r0.p
            java.util.Iterator r2 = r2.iterator()
        L_0x0b3b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0b53
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.c r3 = (androidx.constraintlayout.motion.widget.c) r3
            boolean r4 = r3 instanceof androidx.constraintlayout.motion.widget.f
            if (r4 == 0) goto L_0x0b3b
            androidx.constraintlayout.motion.widget.f r3 = (androidx.constraintlayout.motion.widget.f) r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.g> r4 = r0.r
            r3.c((java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.g>) r4)
            goto L_0x0b3b
        L_0x0b53:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.g> r2 = r0.r
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0b5d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0b6d
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.g r3 = (androidx.constraintlayout.motion.widget.g) r3
            r3.c(r1)
            goto L_0x0b5d
        L_0x0b6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.n.a(int, int, long):void");
    }

    public final String toString() {
        return " start: x: " + this.f2363d.f2374f + " y: " + this.f2363d.f2375g + " end: x: " + this.f2364e.f2374f + " y: " + this.f2364e.f2375g;
    }

    private void a(p pVar) {
        pVar.a((float) ((int) this.f2360a.getX()), (float) ((int) this.f2360a.getY()), (float) this.f2360a.getWidth(), (float) this.f2360a.getHeight());
    }

    /* access modifiers changed from: package-private */
    public final void a(e eVar, androidx.constraintlayout.widget.c cVar) {
        p pVar = this.f2363d;
        pVar.f2372d = 0.0f;
        pVar.f2373e = 0.0f;
        a(pVar);
        this.f2363d.a((float) eVar.l(), (float) eVar.m(), (float) eVar.n(), (float) eVar.o());
        c.a e2 = cVar.e(this.f2361b);
        this.f2363d.a(e2);
        this.f2368i = e2.f2540c.f2559f;
        this.f2365f.a(eVar, cVar, this.f2361b);
    }

    /* access modifiers changed from: package-private */
    public final void b(e eVar, androidx.constraintlayout.widget.c cVar) {
        p pVar = this.f2364e;
        pVar.f2372d = 1.0f;
        pVar.f2373e = 1.0f;
        a(pVar);
        this.f2364e.a((float) eVar.l(), (float) eVar.m(), (float) eVar.n(), (float) eVar.o());
        this.f2364e.a(cVar.e(this.f2361b));
        this.u.a(eVar, cVar, this.f2361b);
    }

    public final float a(float f2, float[] fArr) {
        float f3 = 0.0f;
        float f4 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else if (((double) this.k) != 1.0d) {
            if (f2 < this.j) {
                f2 = 0.0f;
            }
            float f5 = this.j;
            if (f2 > f5 && ((double) f2) < 1.0d) {
                f2 = (f2 - f5) * this.k;
            }
        }
        androidx.constraintlayout.motion.a.c cVar = this.f2363d.f2370b;
        float f6 = Float.NaN;
        Iterator<p> it2 = this.z.iterator();
        while (it2.hasNext()) {
            p next = it2.next();
            if (next.f2370b != null) {
                if (next.f2372d < f2) {
                    cVar = next.f2370b;
                    f3 = next.f2372d;
                } else if (Float.isNaN(f6)) {
                    f6 = next.f2372d;
                }
            }
        }
        if (cVar != null) {
            if (!Float.isNaN(f6)) {
                f4 = f6;
            }
            float f7 = f4 - f3;
            double d2 = (double) ((f2 - f3) / f7);
            f2 = (((float) cVar.a(d2)) * f7) + f3;
            if (fArr != null) {
                fArr[0] = (float) cVar.b(d2);
            }
        }
        return f2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: androidx.constraintlayout.motion.widget.s} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: androidx.constraintlayout.motion.widget.s$d} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0411 A[SYNTHETIC, Splitter:B:210:0x0411] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0478 A[SYNTHETIC, Splitter:B:223:0x0478] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.view.View r27, float r28, long r29, androidx.constraintlayout.motion.widget.e r31) {
        /*
            r26 = this;
            r0 = r26
            r11 = r27
            r1 = 0
            r2 = r28
            float r12 = r0.a((float) r2, (float[]) r1)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r2 = r0.q
            if (r2 == 0) goto L_0x0027
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0017:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.r r3 = (androidx.constraintlayout.motion.widget.r) r3
            r3.a((android.view.View) r11, (float) r12)
            goto L_0x0017
        L_0x0027:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r2 = r0.A
            r13 = 0
            if (r2 == 0) goto L_0x005a
            java.util.Collection r2 = r2.values()
            java.util.Iterator r7 = r2.iterator()
            r9 = r1
            r8 = 0
        L_0x0036:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.widget.s r1 = (androidx.constraintlayout.motion.widget.s) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.widget.s.d
            if (r2 == 0) goto L_0x004a
            r9 = r1
            androidx.constraintlayout.motion.widget.s$d r9 = (androidx.constraintlayout.motion.widget.s.d) r9
            goto L_0x0036
        L_0x004a:
            r2 = r27
            r3 = r12
            r4 = r29
            r6 = r31
            boolean r1 = r1.a((android.view.View) r2, (float) r3, (long) r4, (androidx.constraintlayout.motion.widget.e) r6)
            r8 = r8 | r1
            goto L_0x0036
        L_0x0057:
            r14 = r8
            r1 = r9
            goto L_0x005b
        L_0x005a:
            r14 = 0
        L_0x005b:
            androidx.constraintlayout.motion.a.b[] r2 = r0.f2366g
            if (r2 == 0) goto L_0x04e0
            r2 = r2[r13]
            double r9 = (double) r12
            double[] r5 = r0.m
            r2.a((double) r9, (double[]) r5)
            androidx.constraintlayout.motion.a.b[] r2 = r0.f2366g
            r2 = r2[r13]
            double[] r5 = r0.n
            r2.b(r9, r5)
            androidx.constraintlayout.motion.a.b r2 = r0.f2367h
            if (r2 == 0) goto L_0x0083
            double[] r5 = r0.m
            int r6 = r5.length
            if (r6 <= 0) goto L_0x0083
            r2.a((double) r9, (double[]) r5)
            androidx.constraintlayout.motion.a.b r2 = r0.f2367h
            double[] r5 = r0.n
            r2.b(r9, r5)
        L_0x0083:
            androidx.constraintlayout.motion.widget.p r2 = r0.f2363d
            int[] r5 = r0.l
            double[] r6 = r0.m
            double[] r7 = r0.n
            float r8 = r2.f2374f
            float r13 = r2.f2375g
            float r3 = r2.f2376h
            float r4 = r2.f2377i
            int r15 = r5.length
            if (r15 == 0) goto L_0x00b4
            double[] r15 = r2.o
            int r15 = r15.length
            r17 = r3
            int r3 = r5.length
            r16 = 1
            int r3 = r3 + -1
            r3 = r5[r3]
            if (r15 > r3) goto L_0x00b6
            int r3 = r5.length
            int r3 = r3 + -1
            r3 = r5[r3]
            int r3 = r3 + 1
            double[] r15 = new double[r3]
            r2.o = r15
            double[] r3 = new double[r3]
            r2.p = r3
            goto L_0x00b6
        L_0x00b4:
            r17 = r3
        L_0x00b6:
            double[] r3 = r2.o
            r18 = r9
            r10 = r8
            r8 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            java.util.Arrays.fill(r3, r8)
            r3 = 0
        L_0x00c1:
            int r8 = r5.length
            if (r3 >= r8) goto L_0x00d7
            double[] r8 = r2.o
            r9 = r5[r3]
            r20 = r6[r3]
            r8[r9] = r20
            double[] r8 = r2.p
            r9 = r5[r3]
            r20 = r7[r3]
            r8[r9] = r20
            int r3 = r3 + 1
            goto L_0x00c1
        L_0x00d7:
            r20 = r4
            r4 = 0
            r5 = 2143289344(0x7fc00000, float:NaN)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x00e0:
            double[] r15 = r2.o
            int r15 = r15.length
            if (r4 >= r15) goto L_0x0142
            double[] r15 = r2.o
            r22 = r15[r4]
            boolean r15 = java.lang.Double.isNaN(r22)
            if (r15 != 0) goto L_0x013a
            double[] r15 = r2.o
            r22 = r15[r4]
            boolean r15 = java.lang.Double.isNaN(r22)
            r22 = 0
            if (r15 == 0) goto L_0x00fc
            goto L_0x0102
        L_0x00fc:
            double[] r15 = r2.o
            r24 = r15[r4]
            double r22 = r24 + r22
        L_0x0102:
            r24 = r4
            r3 = r22
            float r3 = (float) r3
            double[] r4 = r2.p
            r22 = r2
            r23 = r3
            r2 = r4[r24]
            float r2 = (float) r2
            if (r24 == 0) goto L_0x0137
            r3 = r24
            r4 = 1
            if (r3 == r4) goto L_0x0133
            r4 = 2
            if (r3 == r4) goto L_0x012f
            r4 = 3
            if (r3 == r4) goto L_0x012b
            r4 = 4
            if (r3 == r4) goto L_0x0127
            r2 = 5
            if (r3 == r2) goto L_0x0124
            goto L_0x013d
        L_0x0124:
            r5 = r23
            goto L_0x013d
        L_0x0127:
            r9 = r2
            r20 = r23
            goto L_0x013d
        L_0x012b:
            r7 = r2
            r17 = r23
            goto L_0x013d
        L_0x012f:
            r8 = r2
            r13 = r23
            goto L_0x013d
        L_0x0133:
            r6 = r2
            r10 = r23
            goto L_0x013d
        L_0x0137:
            r3 = r24
            goto L_0x013d
        L_0x013a:
            r22 = r2
            r3 = r4
        L_0x013d:
            int r4 = r3 + 1
            r2 = r22
            goto L_0x00e0
        L_0x0142:
            boolean r2 = java.lang.Float.isNaN(r5)
            if (r2 == 0) goto L_0x0158
            r2 = 2143289344(0x7fc00000, float:NaN)
            boolean r3 = java.lang.Float.isNaN(r2)
            if (r3 != 0) goto L_0x0153
            r11.setRotation(r2)
        L_0x0153:
            r22 = r14
        L_0x0155:
            r2 = 1056964608(0x3f000000, float:0.5)
            goto L_0x017c
        L_0x0158:
            r2 = 2143289344(0x7fc00000, float:NaN)
            boolean r3 = java.lang.Float.isNaN(r2)
            if (r3 == 0) goto L_0x0161
            r2 = 0
        L_0x0161:
            r3 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r3
            float r6 = r6 + r7
            float r9 = r9 / r3
            float r8 = r8 + r9
            double r2 = (double) r2
            double r4 = (double) r5
            double r7 = (double) r8
            r22 = r14
            double r14 = (double) r6
            double r6 = java.lang.Math.atan2(r7, r14)
            double r6 = java.lang.Math.toDegrees(r6)
            double r4 = r4 + r6
            double r2 = r2 + r4
            float r2 = (float) r2
            r11.setRotation(r2)
            goto L_0x0155
        L_0x017c:
            float r10 = r10 + r2
            int r3 = (int) r10
            float r13 = r13 + r2
            int r2 = (int) r13
            float r10 = r10 + r17
            int r4 = (int) r10
            float r13 = r13 + r20
            int r5 = (int) r13
            int r6 = r4 - r3
            int r7 = r5 - r2
            int r8 = r27.getMeasuredWidth()
            if (r6 != r8) goto L_0x0199
            int r8 = r27.getMeasuredHeight()
            if (r7 == r8) goto L_0x0197
            goto L_0x0199
        L_0x0197:
            r8 = 0
            goto L_0x019a
        L_0x0199:
            r8 = 1
        L_0x019a:
            if (r8 == 0) goto L_0x01a9
            r8 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r8)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r8)
            r11.measure(r6, r7)
        L_0x01a9:
            r11.layout(r3, r2, r4, r5)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r2 = r0.q
            if (r2 == 0) goto L_0x01e4
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x01b8:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01e4
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.widget.r r3 = (androidx.constraintlayout.motion.widget.r) r3
            boolean r4 = r3 instanceof androidx.constraintlayout.motion.widget.r.d
            if (r4 == 0) goto L_0x01b8
            androidx.constraintlayout.motion.widget.r$d r3 = (androidx.constraintlayout.motion.widget.r.d) r3
            double[] r4 = r0.n
            r5 = 0
            r6 = r4[r5]
            r5 = 1
            r8 = r4[r5]
            float r3 = r3.a((float) r12)
            double r4 = java.lang.Math.atan2(r8, r6)
            double r4 = java.lang.Math.toDegrees(r4)
            float r4 = (float) r4
            float r3 = r3 + r4
            r11.setRotation(r3)
            goto L_0x01b8
        L_0x01e4:
            if (r1 == 0) goto L_0x01fe
            double[] r2 = r0.n
            r3 = 0
            r7 = r2[r3]
            r3 = 1
            r9 = r2[r3]
            r2 = r27
            r3 = r31
            r4 = r12
            r5 = r29
            r13 = r18
            boolean r1 = r1.a(r2, r3, r4, r5, r7, r9)
            r1 = r22 | r1
            goto L_0x0202
        L_0x01fe:
            r13 = r18
            r1 = r22
        L_0x0202:
            r2 = 1
        L_0x0203:
            androidx.constraintlayout.motion.a.b[] r3 = r0.f2366g
            int r4 = r3.length
            if (r2 >= r4) goto L_0x0227
            r3 = r3[r2]
            float[] r4 = r0.y
            r3.a((double) r13, (float[]) r4)
            androidx.constraintlayout.motion.widget.p r3 = r0.f2363d
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.a> r3 = r3.m
            java.lang.String[] r4 = r0.v
            int r5 = r2 + -1
            r4 = r4[r5]
            java.lang.Object r3 = r3.get(r4)
            androidx.constraintlayout.widget.a r3 = (androidx.constraintlayout.widget.a) r3
            float[] r4 = r0.y
            r3.a((android.view.View) r11, (float[]) r4)
            int r2 = r2 + 1
            goto L_0x0203
        L_0x0227:
            androidx.constraintlayout.motion.widget.m r2 = r0.f2365f
            int r2 = r2.f2352b
            if (r2 != 0) goto L_0x0256
            r2 = 0
            int r3 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x023a
            androidx.constraintlayout.motion.widget.m r2 = r0.f2365f
            int r2 = r2.f2353c
            r11.setVisibility(r2)
            goto L_0x0256
        L_0x023a:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0248
            androidx.constraintlayout.motion.widget.m r2 = r0.u
            int r2 = r2.f2353c
            r11.setVisibility(r2)
            goto L_0x0256
        L_0x0248:
            androidx.constraintlayout.motion.widget.m r2 = r0.u
            int r2 = r2.f2353c
            androidx.constraintlayout.motion.widget.m r3 = r0.f2365f
            int r3 = r3.f2353c
            if (r2 == r3) goto L_0x0256
            r2 = 0
            r11.setVisibility(r2)
        L_0x0256:
            androidx.constraintlayout.motion.widget.l[] r2 = r0.B
            if (r2 == 0) goto L_0x04db
            r2 = 0
        L_0x025b:
            androidx.constraintlayout.motion.widget.l[] r3 = r0.B
            int r4 = r3.length
            if (r2 >= r4) goto L_0x04db
            r3 = r3[r2]
            int r4 = r3.l
            int r5 = androidx.constraintlayout.motion.widget.l.f2299a
            if (r4 == r5) goto L_0x02cb
            android.view.View r4 = r3.m
            if (r4 != 0) goto L_0x027a
            android.view.ViewParent r4 = r27.getParent()
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            int r5 = r3.l
            android.view.View r4 = r4.findViewById(r5)
            r3.m = r4
        L_0x027a:
            android.graphics.RectF r4 = r3.x
            android.view.View r5 = r3.m
            boolean r6 = r3.w
            androidx.constraintlayout.motion.widget.l.a(r4, r5, r6)
            android.graphics.RectF r4 = r3.y
            boolean r5 = r3.w
            androidx.constraintlayout.motion.widget.l.a(r4, r11, r5)
            android.graphics.RectF r4 = r3.x
            android.graphics.RectF r5 = r3.y
            boolean r4 = r4.intersect(r5)
            if (r4 == 0) goto L_0x02b1
            boolean r4 = r3.o
            if (r4 == 0) goto L_0x029d
            r4 = 0
            r3.o = r4
            r5 = 1
            goto L_0x029f
        L_0x029d:
            r4 = 0
            r5 = 0
        L_0x029f:
            boolean r6 = r3.q
            if (r6 == 0) goto L_0x02a8
            r3.q = r4
            r4 = 1
            r13 = 1
            goto L_0x02aa
        L_0x02a8:
            r4 = 1
            r13 = 0
        L_0x02aa:
            r3.p = r4
            r4 = r13
            r7 = 0
            r13 = 0
            goto L_0x0358
        L_0x02b1:
            r4 = 1
            boolean r5 = r3.o
            if (r5 != 0) goto L_0x02ba
            r3.o = r4
            r5 = 1
            goto L_0x02bb
        L_0x02ba:
            r5 = 0
        L_0x02bb:
            boolean r6 = r3.p
            if (r6 == 0) goto L_0x02c4
            r6 = 0
            r3.p = r6
            r13 = 1
            goto L_0x02c5
        L_0x02c4:
            r13 = 0
        L_0x02c5:
            r3.q = r4
            r4 = 0
            r7 = 0
            goto L_0x0358
        L_0x02cb:
            boolean r4 = r3.o
            if (r4 == 0) goto L_0x02e7
            float r4 = r3.r
            float r4 = r12 - r4
            float r5 = r3.v
            float r6 = r3.r
            float r5 = r5 - r6
            float r4 = r4 * r5
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x02e4
            r4 = 0
            r3.o = r4
            r13 = 1
            goto L_0x02e5
        L_0x02e4:
            r13 = 0
        L_0x02e5:
            r5 = r13
            goto L_0x02f9
        L_0x02e7:
            float r4 = r3.r
            float r4 = r12 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r3.n
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x02f8
            r4 = 1
            r3.o = r4
        L_0x02f8:
            r5 = 0
        L_0x02f9:
            boolean r4 = r3.p
            if (r4 == 0) goto L_0x0316
            float r4 = r3.r
            float r4 = r12 - r4
            float r6 = r3.v
            float r7 = r3.r
            float r6 = r6 - r7
            float r6 = r6 * r4
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x0327
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0327
            r4 = 0
            r3.p = r4
            r13 = 1
            goto L_0x0328
        L_0x0316:
            float r4 = r3.r
            float r4 = r12 - r4
            float r4 = java.lang.Math.abs(r4)
            float r6 = r3.n
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0327
            r4 = 1
            r3.p = r4
        L_0x0327:
            r13 = 0
        L_0x0328:
            boolean r4 = r3.q
            if (r4 == 0) goto L_0x0345
            float r4 = r3.r
            float r4 = r12 - r4
            float r6 = r3.v
            float r7 = r3.r
            float r6 = r6 - r7
            float r6 = r6 * r4
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x0357
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x0357
            r4 = 0
            r3.q = r4
            r4 = 1
            goto L_0x0358
        L_0x0345:
            r7 = 0
            float r4 = r3.r
            float r4 = r12 - r4
            float r4 = java.lang.Math.abs(r4)
            float r6 = r3.n
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0357
            r4 = 1
            r3.q = r4
        L_0x0357:
            r4 = 0
        L_0x0358:
            r3.v = r12
            if (r13 != 0) goto L_0x0360
            if (r5 != 0) goto L_0x0360
            if (r4 == 0) goto L_0x037a
        L_0x0360:
            android.view.ViewParent r6 = r27.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r6 = (androidx.constraintlayout.motion.widget.MotionLayout) r6
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout$g> r8 = r6.z
            if (r8 == 0) goto L_0x037a
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionLayout$g> r6 = r6.z
            java.util.Iterator r6 = r6.iterator()
        L_0x0370:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x037a
            r6.next()
            goto L_0x0370
        L_0x037a:
            int r6 = r3.f2348h
            int r8 = androidx.constraintlayout.motion.widget.l.f2299a
            if (r6 != r8) goto L_0x0382
            r6 = r11
            goto L_0x038e
        L_0x0382:
            android.view.ViewParent r6 = r27.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r6 = (androidx.constraintlayout.motion.widget.MotionLayout) r6
            int r8 = r3.f2348h
            android.view.View r6 = r6.findViewById(r8)
        L_0x038e:
            java.lang.String r8 = "Could not find method \""
            java.lang.String r9 = "Exception in call \""
            java.lang.String r10 = " "
            java.lang.String r14 = "\"on class "
            if (r13 == 0) goto L_0x0405
            java.lang.String r13 = r3.f2349i
            if (r13 == 0) goto L_0x0405
            java.lang.reflect.Method r13 = r3.t
            if (r13 != 0) goto L_0x03d7
            java.lang.Class r13 = r6.getClass()     // Catch:{ NoSuchMethodException -> 0x03b2 }
            java.lang.String r15 = r3.f2349i     // Catch:{ NoSuchMethodException -> 0x03b2 }
            r29 = r1
            r7 = 0
            java.lang.Class[] r1 = new java.lang.Class[r7]     // Catch:{ NoSuchMethodException -> 0x03b4 }
            java.lang.reflect.Method r1 = r13.getMethod(r15, r1)     // Catch:{ NoSuchMethodException -> 0x03b4 }
            r3.t = r1     // Catch:{ NoSuchMethodException -> 0x03b4 }
            goto L_0x03d9
        L_0x03b2:
            r29 = r1
        L_0x03b4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            java.lang.String r7 = r3.f2349i
            r1.append(r7)
            r1.append(r14)
            java.lang.Class r7 = r6.getClass()
            java.lang.String r7 = r7.getSimpleName()
            r1.append(r7)
            r1.append(r10)
            java.lang.String r7 = androidx.constraintlayout.motion.widget.a.a((android.view.View) r6)
            r1.append(r7)
            goto L_0x03d9
        L_0x03d7:
            r29 = r1
        L_0x03d9:
            java.lang.reflect.Method r1 = r3.t     // Catch:{ Exception -> 0x03e2 }
            r7 = 0
            java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x03e2 }
            r1.invoke(r6, r13)     // Catch:{ Exception -> 0x03e2 }
            goto L_0x0407
        L_0x03e2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            java.lang.String r7 = r3.f2349i
            r1.append(r7)
            r1.append(r14)
            java.lang.Class r7 = r6.getClass()
            java.lang.String r7 = r7.getSimpleName()
            r1.append(r7)
            r1.append(r10)
            java.lang.String r7 = androidx.constraintlayout.motion.widget.a.a((android.view.View) r6)
            r1.append(r7)
            goto L_0x0407
        L_0x0405:
            r29 = r1
        L_0x0407:
            if (r4 == 0) goto L_0x046e
            java.lang.String r1 = r3.j
            if (r1 == 0) goto L_0x046e
            java.lang.reflect.Method r1 = r3.u
            if (r1 != 0) goto L_0x0443
            java.lang.Class r1 = r6.getClass()     // Catch:{ NoSuchMethodException -> 0x0421 }
            java.lang.String r4 = r3.j     // Catch:{ NoSuchMethodException -> 0x0421 }
            r7 = 0
            java.lang.Class[] r13 = new java.lang.Class[r7]     // Catch:{ NoSuchMethodException -> 0x0421 }
            java.lang.reflect.Method r1 = r1.getMethod(r4, r13)     // Catch:{ NoSuchMethodException -> 0x0421 }
            r3.u = r1     // Catch:{ NoSuchMethodException -> 0x0421 }
            goto L_0x0443
        L_0x0421:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            java.lang.String r4 = r3.j
            r1.append(r4)
            r1.append(r14)
            java.lang.Class r4 = r6.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r1.append(r4)
            r1.append(r10)
            java.lang.String r4 = androidx.constraintlayout.motion.widget.a.a((android.view.View) r6)
            r1.append(r4)
        L_0x0443:
            java.lang.reflect.Method r1 = r3.u     // Catch:{ Exception -> 0x044c }
            r4 = 0
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x044c }
            r1.invoke(r6, r7)     // Catch:{ Exception -> 0x044c }
            goto L_0x046e
        L_0x044c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            java.lang.String r4 = r3.j
            r1.append(r4)
            r1.append(r14)
            java.lang.Class r4 = r6.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r1.append(r4)
            r1.append(r10)
            java.lang.String r4 = androidx.constraintlayout.motion.widget.a.a((android.view.View) r6)
            r1.append(r4)
        L_0x046e:
            if (r5 == 0) goto L_0x04d5
            java.lang.String r1 = r3.f2347g
            if (r1 == 0) goto L_0x04d5
            java.lang.reflect.Method r1 = r3.s
            if (r1 != 0) goto L_0x04aa
            java.lang.Class r1 = r6.getClass()     // Catch:{ NoSuchMethodException -> 0x0488 }
            java.lang.String r4 = r3.f2347g     // Catch:{ NoSuchMethodException -> 0x0488 }
            r5 = 0
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x0488 }
            java.lang.reflect.Method r1 = r1.getMethod(r4, r7)     // Catch:{ NoSuchMethodException -> 0x0488 }
            r3.s = r1     // Catch:{ NoSuchMethodException -> 0x0488 }
            goto L_0x04aa
        L_0x0488:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            java.lang.String r4 = r3.f2347g
            r1.append(r4)
            r1.append(r14)
            java.lang.Class r4 = r6.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r1.append(r4)
            r1.append(r10)
            java.lang.String r4 = androidx.constraintlayout.motion.widget.a.a((android.view.View) r6)
            r1.append(r4)
        L_0x04aa:
            java.lang.reflect.Method r1 = r3.s     // Catch:{ Exception -> 0x04b3 }
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x04b3 }
            r1.invoke(r6, r5)     // Catch:{ Exception -> 0x04b3 }
            goto L_0x04d5
        L_0x04b3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            java.lang.String r3 = r3.f2347g
            r1.append(r3)
            r1.append(r14)
            java.lang.Class r3 = r6.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r1.append(r3)
            r1.append(r10)
            java.lang.String r3 = androidx.constraintlayout.motion.widget.a.a((android.view.View) r6)
            r1.append(r3)
        L_0x04d5:
            int r2 = r2 + 1
            r1 = r29
            goto L_0x025b
        L_0x04db:
            r29 = r1
            r22 = r29
            goto L_0x0558
        L_0x04e0:
            r22 = r14
            androidx.constraintlayout.motion.widget.p r1 = r0.f2363d
            float r1 = r1.f2374f
            androidx.constraintlayout.motion.widget.p r2 = r0.f2364e
            float r2 = r2.f2374f
            androidx.constraintlayout.motion.widget.p r3 = r0.f2363d
            float r3 = r3.f2374f
            float r2 = r2 - r3
            float r2 = r2 * r12
            float r1 = r1 + r2
            androidx.constraintlayout.motion.widget.p r2 = r0.f2363d
            float r2 = r2.f2375g
            androidx.constraintlayout.motion.widget.p r3 = r0.f2364e
            float r3 = r3.f2375g
            androidx.constraintlayout.motion.widget.p r4 = r0.f2363d
            float r4 = r4.f2375g
            float r3 = r3 - r4
            float r3 = r3 * r12
            float r2 = r2 + r3
            androidx.constraintlayout.motion.widget.p r3 = r0.f2363d
            float r3 = r3.f2376h
            androidx.constraintlayout.motion.widget.p r4 = r0.f2364e
            float r4 = r4.f2376h
            androidx.constraintlayout.motion.widget.p r5 = r0.f2363d
            float r5 = r5.f2376h
            float r4 = r4 - r5
            float r4 = r4 * r12
            float r3 = r3 + r4
            androidx.constraintlayout.motion.widget.p r4 = r0.f2363d
            float r4 = r4.f2377i
            androidx.constraintlayout.motion.widget.p r5 = r0.f2364e
            float r5 = r5.f2377i
            androidx.constraintlayout.motion.widget.p r6 = r0.f2363d
            float r6 = r6.f2377i
            float r5 = r5 - r6
            float r5 = r5 * r12
            float r4 = r4 + r5
            r5 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 + r5
            int r6 = (int) r1
            float r2 = r2 + r5
            int r5 = (int) r2
            float r1 = r1 + r3
            int r1 = (int) r1
            float r2 = r2 + r4
            int r2 = (int) r2
            int r3 = r1 - r6
            int r4 = r2 - r5
            androidx.constraintlayout.motion.widget.p r7 = r0.f2364e
            float r7 = r7.f2376h
            androidx.constraintlayout.motion.widget.p r8 = r0.f2363d
            float r8 = r8.f2376h
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x0548
            androidx.constraintlayout.motion.widget.p r7 = r0.f2364e
            float r7 = r7.f2377i
            androidx.constraintlayout.motion.widget.p r8 = r0.f2363d
            float r8 = r8.f2377i
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 == 0) goto L_0x0555
        L_0x0548:
            r7 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r7)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r7)
            r11.measure(r3, r4)
        L_0x0555:
            r11.layout(r6, r5, r1, r2)
        L_0x0558:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.g> r1 = r0.r
            if (r1 == 0) goto L_0x0596
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x0564:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0596
            java.lang.Object r2 = r1.next()
            androidx.constraintlayout.motion.widget.g r2 = (androidx.constraintlayout.motion.widget.g) r2
            boolean r3 = r2 instanceof androidx.constraintlayout.motion.widget.g.e
            if (r3 == 0) goto L_0x0590
            androidx.constraintlayout.motion.widget.g$e r2 = (androidx.constraintlayout.motion.widget.g.e) r2
            double[] r3 = r0.n
            r4 = 0
            r5 = r3[r4]
            r7 = 1
            r8 = r3[r7]
            float r2 = r2.a(r12)
            double r5 = java.lang.Math.atan2(r8, r5)
            double r5 = java.lang.Math.toDegrees(r5)
            float r3 = (float) r5
            float r2 = r2 + r3
            r11.setRotation(r2)
            goto L_0x0564
        L_0x0590:
            r4 = 0
            r7 = 1
            r2.a(r11, r12)
            goto L_0x0564
        L_0x0596:
            return r22
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.n.a(android.view.View, float, long, androidx.constraintlayout.motion.widget.e):boolean");
    }

    public final void a(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float a2 = a(f2, this.o);
        b[] bVarArr = this.f2366g;
        int i2 = 0;
        if (bVarArr != null) {
            double d2 = (double) a2;
            bVarArr[0].b(d2, this.n);
            this.f2366g[0].a(d2, this.m);
            float f5 = this.o[0];
            while (true) {
                dArr = this.n;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2] = dArr[i2] * ((double) f5);
                i2++;
            }
            b bVar = this.f2367h;
            if (bVar != null) {
                double[] dArr2 = this.m;
                if (dArr2.length > 0) {
                    bVar.a(d2, dArr2);
                    this.f2367h.b(d2, this.n);
                    p.a(f3, f4, fArr, this.l, this.n);
                    return;
                }
                return;
            }
            p.a(f3, f4, fArr, this.l, dArr);
            return;
        }
        float f6 = this.f2364e.f2374f - this.f2363d.f2374f;
        float f7 = this.f2364e.f2375g - this.f2363d.f2375g;
        float f8 = (this.f2364e.f2377i - this.f2363d.f2377i) + f7;
        fArr[0] = (f6 * (1.0f - f3)) + (((this.f2364e.f2376h - this.f2363d.f2376h) + f6) * f3);
        fArr[1] = (f7 * (1.0f - f4)) + (f8 * f4);
    }

    public final int a() {
        int i2 = this.f2363d.f2371c;
        Iterator<p> it2 = this.z.iterator();
        while (it2.hasNext()) {
            i2 = Math.max(i2, it2.next().f2371c);
        }
        return Math.max(i2, this.f2364e.f2371c);
    }
}
