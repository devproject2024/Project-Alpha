package com.airbnb.lottie.a.a;

import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import androidx.a.d;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.c.b.f;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

public final class h implements e, k, a.C0083a {

    /* renamed from: a  reason: collision with root package name */
    private final String f5679a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f5680b;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.c.c.a f5681c;

    /* renamed from: d  reason: collision with root package name */
    private final d<LinearGradient> f5682d = new d<>();

    /* renamed from: e  reason: collision with root package name */
    private final d<RadialGradient> f5683e = new d<>();

    /* renamed from: f  reason: collision with root package name */
    private final Path f5684f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final Paint f5685g = new com.airbnb.lottie.a.a(1);

    /* renamed from: h  reason: collision with root package name */
    private final RectF f5686h = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private final List<m> f5687i = new ArrayList();
    private final f j;
    private final a<c, c> k;
    private final a<Integer, Integer> l;
    private final a<PointF, PointF> m;
    private final a<PointF, PointF> n;
    private a<ColorFilter, ColorFilter> o;
    private p p;
    private final com.airbnb.lottie.f q;
    private final int r;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, com.airbnb.lottie.c.b.d dVar) {
        this.f5681c = aVar;
        this.f5679a = dVar.f5849g;
        this.f5680b = dVar.f5850h;
        this.q = fVar;
        this.j = dVar.f5843a;
        this.f5684f.setFillType(dVar.f5844b);
        this.r = (int) (fVar.f6063a.a() / 32.0f);
        this.k = dVar.f5845c.a();
        this.k.a((a.C0083a) this);
        aVar.a((a<?, ?>) this.k);
        this.l = dVar.f5846d.a();
        this.l.a((a.C0083a) this);
        aVar.a((a<?, ?>) this.l);
        this.m = dVar.f5847e.a();
        this.m.a((a.C0083a) this);
        aVar.a((a<?, ?>) this.m);
        this.n = dVar.f5848f.a();
        this.n.a((a.C0083a) this);
        aVar.a((a<?, ?>) this.n);
    }

    public final void a() {
        this.q.invalidateSelf();
    }

    public final void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.f5687i.add((m) cVar);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: android.graphics.LinearGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: android.graphics.RadialGradient} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: android.graphics.RadialGradient} */
    /* JADX WARNING: type inference failed for: r3v23, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.graphics.Canvas r18, android.graphics.Matrix r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r0.f5680b
            if (r2 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r2 = "GradientFillContent#draw"
            com.airbnb.lottie.c.a(r2)
            android.graphics.Path r3 = r0.f5684f
            r3.reset()
            r3 = 0
            r4 = 0
        L_0x0015:
            java.util.List<com.airbnb.lottie.a.a.m> r5 = r0.f5687i
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0031
            android.graphics.Path r5 = r0.f5684f
            java.util.List<com.airbnb.lottie.a.a.m> r6 = r0.f5687i
            java.lang.Object r6 = r6.get(r4)
            com.airbnb.lottie.a.a.m r6 = (com.airbnb.lottie.a.a.m) r6
            android.graphics.Path r6 = r6.e()
            r5.addPath(r6, r1)
            int r4 = r4 + 1
            goto L_0x0015
        L_0x0031:
            android.graphics.Path r4 = r0.f5684f
            android.graphics.RectF r5 = r0.f5686h
            r4.computeBounds(r5, r3)
            com.airbnb.lottie.c.b.f r3 = r0.j
            com.airbnb.lottie.c.b.f r4 = com.airbnb.lottie.c.b.f.LINEAR
            r5 = 0
            if (r3 != r4) goto L_0x0087
            int r3 = r17.c()
            androidx.a.d<android.graphics.LinearGradient> r4 = r0.f5682d
            long r6 = (long) r3
            java.lang.Object r3 = r4.a(r6, r5)
            android.graphics.LinearGradient r3 = (android.graphics.LinearGradient) r3
            if (r3 == 0) goto L_0x0050
            goto L_0x00e2
        L_0x0050:
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r3 = r0.m
            java.lang.Object r3 = r3.f()
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r4 = r0.n
            java.lang.Object r4 = r4.f()
            android.graphics.PointF r4 = (android.graphics.PointF) r4
            com.airbnb.lottie.a.b.a<com.airbnb.lottie.c.b.c, com.airbnb.lottie.c.b.c> r5 = r0.k
            java.lang.Object r5 = r5.f()
            com.airbnb.lottie.c.b.c r5 = (com.airbnb.lottie.c.b.c) r5
            int[] r8 = r5.f5842b
            int[] r14 = r0.a(r8)
            float[] r15 = r5.f5841a
            android.graphics.LinearGradient r5 = new android.graphics.LinearGradient
            float r10 = r3.x
            float r11 = r3.y
            float r12 = r4.x
            float r13 = r4.y
            android.graphics.Shader$TileMode r16 = android.graphics.Shader.TileMode.CLAMP
            r9 = r5
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            androidx.a.d<android.graphics.LinearGradient> r3 = r0.f5682d
            r3.b(r6, r5)
            r3 = r5
            goto L_0x00e2
        L_0x0087:
            int r3 = r17.c()
            androidx.a.d<android.graphics.RadialGradient> r4 = r0.f5683e
            long r6 = (long) r3
            java.lang.Object r3 = r4.a(r6, r5)
            android.graphics.RadialGradient r3 = (android.graphics.RadialGradient) r3
            if (r3 == 0) goto L_0x0097
            goto L_0x00e2
        L_0x0097:
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r3 = r0.m
            java.lang.Object r3 = r3.f()
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r4 = r0.n
            java.lang.Object r4 = r4.f()
            android.graphics.PointF r4 = (android.graphics.PointF) r4
            com.airbnb.lottie.a.b.a<com.airbnb.lottie.c.b.c, com.airbnb.lottie.c.b.c> r5 = r0.k
            java.lang.Object r5 = r5.f()
            com.airbnb.lottie.c.b.c r5 = (com.airbnb.lottie.c.b.c) r5
            int[] r8 = r5.f5842b
            int[] r13 = r0.a(r8)
            float[] r14 = r5.f5841a
            float r10 = r3.x
            float r11 = r3.y
            float r3 = r4.x
            float r4 = r4.y
            float r3 = r3 - r10
            double r8 = (double) r3
            float r4 = r4 - r11
            double r3 = (double) r4
            double r3 = java.lang.Math.hypot(r8, r3)
            float r3 = (float) r3
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00d4
            r3 = 981668463(0x3a83126f, float:0.001)
            r12 = 981668463(0x3a83126f, float:0.001)
            goto L_0x00d5
        L_0x00d4:
            r12 = r3
        L_0x00d5:
            android.graphics.RadialGradient r3 = new android.graphics.RadialGradient
            android.graphics.Shader$TileMode r15 = android.graphics.Shader.TileMode.CLAMP
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15)
            androidx.a.d<android.graphics.RadialGradient> r4 = r0.f5683e
            r4.b(r6, r3)
        L_0x00e2:
            r3.setLocalMatrix(r1)
            android.graphics.Paint r1 = r0.f5685g
            r1.setShader(r3)
            com.airbnb.lottie.a.b.a<android.graphics.ColorFilter, android.graphics.ColorFilter> r1 = r0.o
            if (r1 == 0) goto L_0x00f9
            android.graphics.Paint r3 = r0.f5685g
            java.lang.Object r1 = r1.f()
            android.graphics.ColorFilter r1 = (android.graphics.ColorFilter) r1
            r3.setColorFilter(r1)
        L_0x00f9:
            r1 = r20
            float r1 = (float) r1
            r3 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 / r3
            com.airbnb.lottie.a.b.a<java.lang.Integer, java.lang.Integer> r4 = r0.l
            java.lang.Object r4 = r4.f()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            float r4 = (float) r4
            float r1 = r1 * r4
            r4 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r4
            float r1 = r1 * r3
            int r1 = (int) r1
            android.graphics.Paint r3 = r0.f5685g
            int r1 = com.airbnb.lottie.f.g.a(r1)
            r3.setAlpha(r1)
            android.graphics.Path r1 = r0.f5684f
            android.graphics.Paint r3 = r0.f5685g
            r4 = r18
            r4.drawPath(r1, r3)
            com.airbnb.lottie.c.b(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.h.a(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        this.f5684f.reset();
        for (int i2 = 0; i2 < this.f5687i.size(); i2++) {
            this.f5684f.addPath(this.f5687i.get(i2).e(), matrix);
        }
        this.f5684f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final String b() {
        return this.f5679a;
    }

    private int c() {
        int round = Math.round(this.m.g() * ((float) this.r));
        int round2 = Math.round(this.n.g() * ((float) this.r));
        int round3 = Math.round(this.k.g() * ((float) this.r));
        int i2 = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private int[] a(int[] iArr) {
        p pVar = this.p;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.f();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    public final void a(e eVar, int i2, List<e> list, e eVar2) {
        g.a(eVar, i2, list, eVar2, this);
    }

    public final <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        if (t == k.f6158d) {
            this.l.a(cVar);
        } else if (t == k.C) {
            a<ColorFilter, ColorFilter> aVar = this.o;
            if (aVar != null) {
                this.f5681c.b((a<?, ?>) aVar);
            }
            if (cVar == null) {
                this.o = null;
                return;
            }
            this.o = new p(cVar);
            this.o.a((a.C0083a) this);
            this.f5681c.a((a<?, ?>) this.o);
        } else if (t == k.D) {
            p pVar = this.p;
            if (pVar != null) {
                this.f5681c.b((a<?, ?>) pVar);
            }
            if (cVar == null) {
                this.p = null;
                return;
            }
            this.p = new p(cVar);
            this.p.a((a.C0083a) this);
            this.f5681c.a((a<?, ?>) this.p);
        }
    }
}
