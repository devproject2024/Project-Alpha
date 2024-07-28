package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.airbnb.lottie.a.a.e;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.c;
import com.airbnb.lottie.a.b.g;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.c.b.g;
import com.airbnb.lottie.c.b.l;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.c.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class a implements e, a.C0083a, f {

    /* renamed from: a  reason: collision with root package name */
    final Matrix f5924a;

    /* renamed from: b  reason: collision with root package name */
    final com.airbnb.lottie.f f5925b;

    /* renamed from: c  reason: collision with root package name */
    final d f5926c;

    /* renamed from: d  reason: collision with root package name */
    c f5927d;

    /* renamed from: e  reason: collision with root package name */
    a f5928e;

    /* renamed from: f  reason: collision with root package name */
    a f5929f;

    /* renamed from: g  reason: collision with root package name */
    final o f5930g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f5931h = new Path();

    /* renamed from: i  reason: collision with root package name */
    private final Matrix f5932i = new Matrix();
    private final Paint j;
    private final Paint k;
    private final Paint l;
    private final Paint m;
    private final Paint n;
    private final RectF o;
    private final RectF p;
    private final RectF q;
    private final RectF r;
    private final String s;
    private g t;
    private List<a> u;
    private final List<com.airbnb.lottie.a.b.a<?, ?>> v;
    private boolean w;

    public final void a(List<com.airbnb.lottie.a.a.c> list, List<com.airbnb.lottie.a.a.c> list2) {
    }

    /* access modifiers changed from: package-private */
    public abstract void b(Canvas canvas, Matrix matrix, int i2);

    /* access modifiers changed from: package-private */
    public void b(com.airbnb.lottie.c.e eVar, int i2, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
    }

    a(com.airbnb.lottie.f fVar, d dVar) {
        boolean z = true;
        this.j = new com.airbnb.lottie.a.a(1);
        this.k = new com.airbnb.lottie.a.a(PorterDuff.Mode.DST_IN, (byte) 0);
        this.l = new com.airbnb.lottie.a.a(PorterDuff.Mode.DST_OUT, (byte) 0);
        this.m = new com.airbnb.lottie.a.a(1);
        this.n = new com.airbnb.lottie.a.a(PorterDuff.Mode.CLEAR);
        this.o = new RectF();
        this.p = new RectF();
        this.q = new RectF();
        this.r = new RectF();
        this.f5924a = new Matrix();
        this.v = new ArrayList();
        this.w = true;
        this.f5925b = fVar;
        this.f5926c = dVar;
        this.s = dVar.f5943c + "#draw";
        if (dVar.u == d.b.INVERT) {
            this.m.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.m.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.f5930g = dVar.f5949i.a();
        this.f5930g.a((a.C0083a) this);
        if (dVar.f5948h != null && !dVar.f5948h.isEmpty()) {
            this.t = new g(dVar.f5948h);
            for (com.airbnb.lottie.a.b.a<l, Path> a2 : this.t.f5764a) {
                a2.a((a.C0083a) this);
            }
            for (com.airbnb.lottie.a.b.a next : this.t.f5765b) {
                a((com.airbnb.lottie.a.b.a<?, ?>) next);
                next.a((a.C0083a) this);
            }
        }
        if (!this.f5926c.t.isEmpty()) {
            this.f5927d = new c(this.f5926c.t);
            c cVar = this.f5927d;
            cVar.f5750b = true;
            cVar.a((a.C0083a) new a.C0083a() {
                public final void a() {
                    a aVar = a.this;
                    aVar.a(aVar.f5927d.h() == 1.0f);
                }
            });
            a(((Float) this.f5927d.f()).floatValue() != 1.0f ? false : z);
            a((com.airbnb.lottie.a.b.a<?, ?>) this.f5927d);
            return;
        }
        a(true);
    }

    public final boolean c() {
        return this.f5928e != null;
    }

    public final void a(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (aVar != null) {
            this.v.add(aVar);
        }
    }

    public final void b(com.airbnb.lottie.a.b.a<?, ?> aVar) {
        this.v.remove(aVar);
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.o.set(0.0f, 0.0f, 0.0f, 0.0f);
        e();
        this.f5924a.set(matrix);
        if (z) {
            List<a> list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f5924a.preConcat(this.u.get(size).f5930g.a());
                }
            } else {
                a aVar = this.f5929f;
                if (aVar != null) {
                    this.f5924a.preConcat(aVar.f5930g.a());
                }
            }
        }
        this.f5924a.preConcat(this.f5930g.a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x03d2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x03c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.graphics.Canvas r17, android.graphics.Matrix r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.String r3 = r0.s
            com.airbnb.lottie.c.a(r3)
            boolean r3 = r0.w
            if (r3 == 0) goto L_0x0420
            com.airbnb.lottie.c.c.d r3 = r0.f5926c
            boolean r3 = r3.v
            if (r3 == 0) goto L_0x0017
            goto L_0x0420
        L_0x0017:
            r16.e()
            java.lang.String r3 = "Layer#parentMatrix"
            com.airbnb.lottie.c.a(r3)
            android.graphics.Matrix r4 = r0.f5932i
            r4.reset()
            android.graphics.Matrix r4 = r0.f5932i
            r4.set(r2)
            java.util.List<com.airbnb.lottie.c.c.a> r4 = r0.u
            int r4 = r4.size()
            r5 = 1
            int r4 = r4 - r5
        L_0x0031:
            if (r4 < 0) goto L_0x0049
            android.graphics.Matrix r6 = r0.f5932i
            java.util.List<com.airbnb.lottie.c.c.a> r7 = r0.u
            java.lang.Object r7 = r7.get(r4)
            com.airbnb.lottie.c.c.a r7 = (com.airbnb.lottie.c.c.a) r7
            com.airbnb.lottie.a.b.o r7 = r7.f5930g
            android.graphics.Matrix r7 = r7.a()
            r6.preConcat(r7)
            int r4 = r4 + -1
            goto L_0x0031
        L_0x0049:
            com.airbnb.lottie.c.b(r3)
            com.airbnb.lottie.a.b.o r3 = r0.f5930g
            com.airbnb.lottie.a.b.a<java.lang.Integer, java.lang.Integer> r3 = r3.f5783e
            if (r3 != 0) goto L_0x0059
            r3 = 100
            r3 = r19
            r4 = 100
            goto L_0x006a
        L_0x0059:
            com.airbnb.lottie.a.b.o r3 = r0.f5930g
            com.airbnb.lottie.a.b.a<java.lang.Integer, java.lang.Integer> r3 = r3.f5783e
            java.lang.Object r3 = r3.f()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = r3
            r3 = r19
        L_0x006a:
            float r3 = (float) r3
            r6 = 1132396544(0x437f0000, float:255.0)
            float r3 = r3 / r6
            float r4 = (float) r4
            float r3 = r3 * r4
            r4 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 / r4
            float r3 = r3 * r6
            int r3 = (int) r3
            boolean r4 = r16.c()
            java.lang.String r6 = "Layer#drawLayer"
            if (r4 != 0) goto L_0x00a5
            boolean r4 = r16.d()
            if (r4 != 0) goto L_0x00a5
            android.graphics.Matrix r2 = r0.f5932i
            com.airbnb.lottie.a.b.o r4 = r0.f5930g
            android.graphics.Matrix r4 = r4.a()
            r2.preConcat(r4)
            com.airbnb.lottie.c.a(r6)
            android.graphics.Matrix r2 = r0.f5932i
            r0.b(r1, r2, r3)
            com.airbnb.lottie.c.b(r6)
            java.lang.String r1 = r0.s
            float r1 = com.airbnb.lottie.c.b(r1)
            r0.b((float) r1)
            return
        L_0x00a5:
            java.lang.String r4 = "Layer#computeBounds"
            com.airbnb.lottie.c.a(r4)
            android.graphics.RectF r7 = r0.o
            android.graphics.Matrix r8 = r0.f5932i
            r9 = 0
            r0.a((android.graphics.RectF) r7, (android.graphics.Matrix) r8, (boolean) r9)
            android.graphics.RectF r7 = r0.o
            boolean r8 = r16.c()
            r10 = 0
            if (r8 == 0) goto L_0x00da
            com.airbnb.lottie.c.c.d r8 = r0.f5926c
            com.airbnb.lottie.c.c.d$b r8 = r8.u
            com.airbnb.lottie.c.c.d$b r11 = com.airbnb.lottie.c.c.d.b.INVERT
            if (r8 == r11) goto L_0x00da
            android.graphics.RectF r8 = r0.q
            r8.set(r10, r10, r10, r10)
            com.airbnb.lottie.c.c.a r8 = r0.f5928e
            android.graphics.RectF r11 = r0.q
            r8.a((android.graphics.RectF) r11, (android.graphics.Matrix) r2, (boolean) r5)
            android.graphics.RectF r8 = r0.q
            boolean r8 = r7.intersect(r8)
            if (r8 != 0) goto L_0x00da
            r7.set(r10, r10, r10, r10)
        L_0x00da:
            android.graphics.Matrix r7 = r0.f5932i
            com.airbnb.lottie.a.b.o r8 = r0.f5930g
            android.graphics.Matrix r8 = r8.a()
            r7.preConcat(r8)
            android.graphics.RectF r7 = r0.o
            android.graphics.Matrix r8 = r0.f5932i
            android.graphics.RectF r11 = r0.p
            r11.set(r10, r10, r10, r10)
            boolean r11 = r16.d()
            r13 = 3
            r14 = 2
            if (r11 == 0) goto L_0x0198
            com.airbnb.lottie.a.b.g r11 = r0.t
            java.util.List<com.airbnb.lottie.c.b.g> r11 = r11.f5766c
            int r11 = r11.size()
            r15 = 0
        L_0x00ff:
            if (r15 >= r11) goto L_0x018b
            com.airbnb.lottie.a.b.g r10 = r0.t
            java.util.List<com.airbnb.lottie.c.b.g> r10 = r10.f5766c
            java.lang.Object r10 = r10.get(r15)
            com.airbnb.lottie.c.b.g r10 = (com.airbnb.lottie.c.b.g) r10
            com.airbnb.lottie.a.b.g r9 = r0.t
            java.util.List<com.airbnb.lottie.a.b.a<com.airbnb.lottie.c.b.l, android.graphics.Path>> r9 = r9.f5764a
            java.lang.Object r9 = r9.get(r15)
            com.airbnb.lottie.a.b.a r9 = (com.airbnb.lottie.a.b.a) r9
            java.lang.Object r9 = r9.f()
            android.graphics.Path r9 = (android.graphics.Path) r9
            android.graphics.Path r12 = r0.f5931h
            r12.set(r9)
            android.graphics.Path r9 = r0.f5931h
            r9.transform(r8)
            int[] r9 = com.airbnb.lottie.c.c.a.AnonymousClass2.f5935b
            com.airbnb.lottie.c.b.g$a r12 = r10.f5861a
            int r12 = r12.ordinal()
            r9 = r9[r12]
            if (r9 == r5) goto L_0x0198
            if (r9 == r14) goto L_0x0198
            if (r9 == r13) goto L_0x0139
            r12 = 4
            if (r9 == r12) goto L_0x0139
            goto L_0x013d
        L_0x0139:
            boolean r9 = r10.f5864d
            if (r9 != 0) goto L_0x0198
        L_0x013d:
            android.graphics.Path r9 = r0.f5931h
            android.graphics.RectF r10 = r0.r
            r12 = 0
            r9.computeBounds(r10, r12)
            if (r15 != 0) goto L_0x014f
            android.graphics.RectF r9 = r0.p
            android.graphics.RectF r10 = r0.r
            r9.set(r10)
            goto L_0x0182
        L_0x014f:
            android.graphics.RectF r9 = r0.p
            float r10 = r9.left
            android.graphics.RectF r12 = r0.r
            float r12 = r12.left
            float r10 = java.lang.Math.min(r10, r12)
            android.graphics.RectF r12 = r0.p
            float r12 = r12.top
            android.graphics.RectF r13 = r0.r
            float r13 = r13.top
            float r12 = java.lang.Math.min(r12, r13)
            android.graphics.RectF r13 = r0.p
            float r13 = r13.right
            android.graphics.RectF r14 = r0.r
            float r14 = r14.right
            float r13 = java.lang.Math.max(r13, r14)
            android.graphics.RectF r14 = r0.p
            float r14 = r14.bottom
            android.graphics.RectF r5 = r0.r
            float r5 = r5.bottom
            float r5 = java.lang.Math.max(r14, r5)
            r9.set(r10, r12, r13, r5)
        L_0x0182:
            int r15 = r15 + 1
            r5 = 1
            r9 = 0
            r10 = 0
            r13 = 3
            r14 = 2
            goto L_0x00ff
        L_0x018b:
            android.graphics.RectF r5 = r0.p
            boolean r5 = r7.intersect(r5)
            if (r5 != 0) goto L_0x0198
            r5 = 0
            r7.set(r5, r5, r5, r5)
            goto L_0x0199
        L_0x0198:
            r5 = 0
        L_0x0199:
            android.graphics.RectF r7 = r0.o
            int r8 = r17.getWidth()
            float r8 = (float) r8
            int r9 = r17.getHeight()
            float r9 = (float) r9
            boolean r7 = r7.intersect(r5, r5, r8, r9)
            if (r7 != 0) goto L_0x01b0
            android.graphics.RectF r7 = r0.o
            r7.set(r5, r5, r5, r5)
        L_0x01b0:
            com.airbnb.lottie.c.b(r4)
            android.graphics.RectF r4 = r0.o
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0416
            java.lang.String r4 = "Layer#saveLayer"
            com.airbnb.lottie.c.a(r4)
            android.graphics.Paint r5 = r0.j
            r7 = 255(0xff, float:3.57E-43)
            r5.setAlpha(r7)
            android.graphics.RectF r5 = r0.o
            android.graphics.Paint r8 = r0.j
            com.airbnb.lottie.f.h.a((android.graphics.Canvas) r1, (android.graphics.RectF) r5, (android.graphics.Paint) r8)
            com.airbnb.lottie.c.b(r4)
            r16.a((android.graphics.Canvas) r17)
            com.airbnb.lottie.c.a(r6)
            android.graphics.Matrix r5 = r0.f5932i
            r0.b(r1, r5, r3)
            com.airbnb.lottie.c.b(r6)
            boolean r5 = r16.d()
            r6 = 19
            java.lang.String r8 = "Layer#restoreLayer"
            if (r5 == 0) goto L_0x03df
            android.graphics.Matrix r5 = r0.f5932i
            com.airbnb.lottie.c.a(r4)
            android.graphics.RectF r9 = r0.o
            android.graphics.Paint r10 = r0.k
            com.airbnb.lottie.f.h.a((android.graphics.Canvas) r1, (android.graphics.RectF) r9, (android.graphics.Paint) r10, (int) r6)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 28
            if (r9 >= r10) goto L_0x01fe
            r16.a((android.graphics.Canvas) r17)
        L_0x01fe:
            com.airbnb.lottie.c.b(r4)
            r9 = 0
        L_0x0202:
            com.airbnb.lottie.a.b.g r10 = r0.t
            java.util.List<com.airbnb.lottie.c.b.g> r10 = r10.f5766c
            int r10 = r10.size()
            if (r9 >= r10) goto L_0x03d6
            com.airbnb.lottie.a.b.g r10 = r0.t
            java.util.List<com.airbnb.lottie.c.b.g> r10 = r10.f5766c
            java.lang.Object r10 = r10.get(r9)
            com.airbnb.lottie.c.b.g r10 = (com.airbnb.lottie.c.b.g) r10
            com.airbnb.lottie.a.b.g r11 = r0.t
            java.util.List<com.airbnb.lottie.a.b.a<com.airbnb.lottie.c.b.l, android.graphics.Path>> r11 = r11.f5764a
            java.lang.Object r11 = r11.get(r9)
            com.airbnb.lottie.a.b.a r11 = (com.airbnb.lottie.a.b.a) r11
            com.airbnb.lottie.a.b.g r12 = r0.t
            java.util.List<com.airbnb.lottie.a.b.a<java.lang.Integer, java.lang.Integer>> r12 = r12.f5765b
            java.lang.Object r12 = r12.get(r9)
            com.airbnb.lottie.a.b.a r12 = (com.airbnb.lottie.a.b.a) r12
            int[] r13 = com.airbnb.lottie.c.c.a.AnonymousClass2.f5935b
            com.airbnb.lottie.c.b.g$a r14 = r10.f5861a
            int r14 = r14.ordinal()
            r13 = r13[r14]
            r14 = 1
            if (r13 == r14) goto L_0x0398
            r15 = 1076048691(0x40233333, float:2.55)
            r14 = 2
            if (r13 == r14) goto L_0x032a
            r14 = 3
            if (r13 == r14) goto L_0x02b2
            r14 = 4
            if (r13 == r14) goto L_0x0245
            goto L_0x03d2
        L_0x0245:
            boolean r10 = r10.f5864d
            if (r10 == 0) goto L_0x0286
            android.graphics.RectF r10 = r0.o
            android.graphics.Paint r13 = r0.j
            com.airbnb.lottie.f.h.a((android.graphics.Canvas) r1, (android.graphics.RectF) r10, (android.graphics.Paint) r13)
            android.graphics.RectF r10 = r0.o
            android.graphics.Paint r13 = r0.j
            r1.drawRect(r10, r13)
            java.lang.Object r10 = r11.f()
            android.graphics.Path r10 = (android.graphics.Path) r10
            android.graphics.Path r11 = r0.f5931h
            r11.set(r10)
            android.graphics.Path r10 = r0.f5931h
            r10.transform(r5)
            android.graphics.Paint r10 = r0.j
            java.lang.Object r11 = r12.f()
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            float r11 = (float) r11
            float r11 = r11 * r15
            int r11 = (int) r11
            r10.setAlpha(r11)
            android.graphics.Path r10 = r0.f5931h
            android.graphics.Paint r11 = r0.l
            r1.drawPath(r10, r11)
            r17.restore()
            goto L_0x03d2
        L_0x0286:
            java.lang.Object r10 = r11.f()
            android.graphics.Path r10 = (android.graphics.Path) r10
            android.graphics.Path r11 = r0.f5931h
            r11.set(r10)
            android.graphics.Path r10 = r0.f5931h
            r10.transform(r5)
            android.graphics.Paint r10 = r0.j
            java.lang.Object r11 = r12.f()
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            float r11 = (float) r11
            float r11 = r11 * r15
            int r11 = (int) r11
            r10.setAlpha(r11)
            android.graphics.Path r10 = r0.f5931h
            android.graphics.Paint r11 = r0.j
            r1.drawPath(r10, r11)
            goto L_0x03d2
        L_0x02b2:
            r14 = 4
            boolean r10 = r10.f5864d
            if (r10 == 0) goto L_0x02f4
            android.graphics.RectF r10 = r0.o
            android.graphics.Paint r13 = r0.k
            com.airbnb.lottie.f.h.a((android.graphics.Canvas) r1, (android.graphics.RectF) r10, (android.graphics.Paint) r13)
            android.graphics.RectF r10 = r0.o
            android.graphics.Paint r13 = r0.j
            r1.drawRect(r10, r13)
            android.graphics.Paint r10 = r0.l
            java.lang.Object r12 = r12.f()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            float r12 = (float) r12
            float r12 = r12 * r15
            int r12 = (int) r12
            r10.setAlpha(r12)
            java.lang.Object r10 = r11.f()
            android.graphics.Path r10 = (android.graphics.Path) r10
            android.graphics.Path r11 = r0.f5931h
            r11.set(r10)
            android.graphics.Path r10 = r0.f5931h
            r10.transform(r5)
            android.graphics.Path r10 = r0.f5931h
            android.graphics.Paint r11 = r0.l
            r1.drawPath(r10, r11)
            r17.restore()
            goto L_0x03d2
        L_0x02f4:
            android.graphics.RectF r10 = r0.o
            android.graphics.Paint r13 = r0.k
            com.airbnb.lottie.f.h.a((android.graphics.Canvas) r1, (android.graphics.RectF) r10, (android.graphics.Paint) r13)
            java.lang.Object r10 = r11.f()
            android.graphics.Path r10 = (android.graphics.Path) r10
            android.graphics.Path r11 = r0.f5931h
            r11.set(r10)
            android.graphics.Path r10 = r0.f5931h
            r10.transform(r5)
            android.graphics.Paint r10 = r0.j
            java.lang.Object r11 = r12.f()
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            float r11 = (float) r11
            float r11 = r11 * r15
            int r11 = (int) r11
            r10.setAlpha(r11)
            android.graphics.Path r10 = r0.f5931h
            android.graphics.Paint r11 = r0.j
            r1.drawPath(r10, r11)
            r17.restore()
            goto L_0x03d2
        L_0x032a:
            r14 = 4
            if (r9 != 0) goto L_0x0340
            android.graphics.Paint r13 = r0.j
            r14 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r13.setColor(r14)
            android.graphics.Paint r13 = r0.j
            r13.setAlpha(r7)
            android.graphics.RectF r13 = r0.o
            android.graphics.Paint r14 = r0.j
            r1.drawRect(r13, r14)
        L_0x0340:
            boolean r10 = r10.f5864d
            if (r10 == 0) goto L_0x0380
            android.graphics.RectF r10 = r0.o
            android.graphics.Paint r13 = r0.l
            com.airbnb.lottie.f.h.a((android.graphics.Canvas) r1, (android.graphics.RectF) r10, (android.graphics.Paint) r13)
            android.graphics.RectF r10 = r0.o
            android.graphics.Paint r13 = r0.j
            r1.drawRect(r10, r13)
            android.graphics.Paint r10 = r0.l
            java.lang.Object r12 = r12.f()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            float r12 = (float) r12
            float r12 = r12 * r15
            int r12 = (int) r12
            r10.setAlpha(r12)
            java.lang.Object r10 = r11.f()
            android.graphics.Path r10 = (android.graphics.Path) r10
            android.graphics.Path r11 = r0.f5931h
            r11.set(r10)
            android.graphics.Path r10 = r0.f5931h
            r10.transform(r5)
            android.graphics.Path r10 = r0.f5931h
            android.graphics.Paint r11 = r0.l
            r1.drawPath(r10, r11)
            r17.restore()
            goto L_0x03d2
        L_0x0380:
            java.lang.Object r10 = r11.f()
            android.graphics.Path r10 = (android.graphics.Path) r10
            android.graphics.Path r11 = r0.f5931h
            r11.set(r10)
            android.graphics.Path r10 = r0.f5931h
            r10.transform(r5)
            android.graphics.Path r10 = r0.f5931h
            android.graphics.Paint r11 = r0.l
            r1.drawPath(r10, r11)
            goto L_0x03d2
        L_0x0398:
            com.airbnb.lottie.a.b.g r10 = r0.t
            java.util.List<com.airbnb.lottie.a.b.a<com.airbnb.lottie.c.b.l, android.graphics.Path>> r10 = r10.f5764a
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x03a4
        L_0x03a2:
            r10 = 0
            goto L_0x03c4
        L_0x03a4:
            r10 = 0
        L_0x03a5:
            com.airbnb.lottie.a.b.g r11 = r0.t
            java.util.List<com.airbnb.lottie.c.b.g> r11 = r11.f5766c
            int r11 = r11.size()
            if (r10 >= r11) goto L_0x03c3
            com.airbnb.lottie.a.b.g r11 = r0.t
            java.util.List<com.airbnb.lottie.c.b.g> r11 = r11.f5766c
            java.lang.Object r11 = r11.get(r10)
            com.airbnb.lottie.c.b.g r11 = (com.airbnb.lottie.c.b.g) r11
            com.airbnb.lottie.c.b.g$a r11 = r11.f5861a
            com.airbnb.lottie.c.b.g$a r12 = com.airbnb.lottie.c.b.g.a.MASK_MODE_NONE
            if (r11 == r12) goto L_0x03c0
            goto L_0x03a2
        L_0x03c0:
            int r10 = r10 + 1
            goto L_0x03a5
        L_0x03c3:
            r10 = 1
        L_0x03c4:
            if (r10 == 0) goto L_0x03d2
            android.graphics.Paint r10 = r0.j
            r10.setAlpha(r7)
            android.graphics.RectF r10 = r0.o
            android.graphics.Paint r11 = r0.j
            r1.drawRect(r10, r11)
        L_0x03d2:
            int r9 = r9 + 1
            goto L_0x0202
        L_0x03d6:
            com.airbnb.lottie.c.a(r8)
            r17.restore()
            com.airbnb.lottie.c.b(r8)
        L_0x03df:
            boolean r5 = r16.c()
            if (r5 == 0) goto L_0x040d
            java.lang.String r5 = "Layer#drawMatte"
            com.airbnb.lottie.c.a(r5)
            com.airbnb.lottie.c.a(r4)
            android.graphics.RectF r5 = r0.o
            android.graphics.Paint r7 = r0.m
            com.airbnb.lottie.f.h.a((android.graphics.Canvas) r1, (android.graphics.RectF) r5, (android.graphics.Paint) r7, (int) r6)
            com.airbnb.lottie.c.b(r4)
            r16.a((android.graphics.Canvas) r17)
            com.airbnb.lottie.c.c.a r4 = r0.f5928e
            r4.a((android.graphics.Canvas) r1, (android.graphics.Matrix) r2, (int) r3)
            com.airbnb.lottie.c.a(r8)
            r17.restore()
            com.airbnb.lottie.c.b(r8)
            java.lang.String r2 = "Layer#drawMatte"
            com.airbnb.lottie.c.b(r2)
        L_0x040d:
            com.airbnb.lottie.c.a(r8)
            r17.restore()
            com.airbnb.lottie.c.b(r8)
        L_0x0416:
            java.lang.String r1 = r0.s
            float r1 = com.airbnb.lottie.c.b(r1)
            r0.b((float) r1)
            return
        L_0x0420:
            java.lang.String r1 = r0.s
            com.airbnb.lottie.c.b(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.c.a.a(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    private void b(float f2) {
        this.f5925b.f6063a.f5974a.a(this.f5926c.f5943c, f2);
    }

    private void a(Canvas canvas) {
        com.airbnb.lottie.c.a("Layer#clearLayer");
        canvas.drawRect(this.o.left - 1.0f, this.o.top - 1.0f, this.o.right + 1.0f, this.o.bottom + 1.0f, this.n);
        com.airbnb.lottie.c.b("Layer#clearLayer");
    }

    /* renamed from: com.airbnb.lottie.c.c.a$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5935b = new int[g.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        static {
            /*
                com.airbnb.lottie.c.b.g$a[] r0 = com.airbnb.lottie.c.b.g.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5935b = r0
                r0 = 1
                int[] r1 = f5935b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.g$a r2 = com.airbnb.lottie.c.b.g.a.MASK_MODE_NONE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f5935b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.g$a r3 = com.airbnb.lottie.c.b.g.a.MASK_MODE_SUBTRACT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f5935b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.c.b.g$a r4 = com.airbnb.lottie.c.b.g.a.MASK_MODE_INTERSECT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f5935b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.airbnb.lottie.c.b.g$a r5 = com.airbnb.lottie.c.b.g.a.MASK_MODE_ADD     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                com.airbnb.lottie.c.c.d$a[] r4 = com.airbnb.lottie.c.c.d.a.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f5934a = r4
                int[] r4 = f5934a     // Catch:{ NoSuchFieldError -> 0x0048 }
                com.airbnb.lottie.c.c.d$a r5 = com.airbnb.lottie.c.c.d.a.SHAPE     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f5934a     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.airbnb.lottie.c.c.d$a r4 = com.airbnb.lottie.c.c.d.a.PRE_COMP     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f5934a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.SOLID     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f5934a     // Catch:{ NoSuchFieldError -> 0x0066 }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.IMAGE     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = f5934a     // Catch:{ NoSuchFieldError -> 0x0071 }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.NULL     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f5934a     // Catch:{ NoSuchFieldError -> 0x007c }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.TEXT     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = f5934a     // Catch:{ NoSuchFieldError -> 0x0087 }
                com.airbnb.lottie.c.c.d$a r1 = com.airbnb.lottie.c.c.d.a.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.c.a.AnonymousClass2.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        com.airbnb.lottie.a.b.g gVar = this.t;
        return gVar != null && !gVar.f5764a.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (z != this.w) {
            this.w = z;
            this.f5925b.invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        o oVar = this.f5930g;
        if (oVar.f5783e != null) {
            oVar.f5783e.a(f2);
        }
        if (oVar.f5786h != null) {
            oVar.f5786h.a(f2);
        }
        if (oVar.f5787i != null) {
            oVar.f5787i.a(f2);
        }
        if (oVar.f5779a != null) {
            oVar.f5779a.a(f2);
        }
        if (oVar.f5780b != null) {
            oVar.f5780b.a(f2);
        }
        if (oVar.f5781c != null) {
            oVar.f5781c.a(f2);
        }
        if (oVar.f5782d != null) {
            oVar.f5782d.a(f2);
        }
        if (oVar.f5784f != null) {
            oVar.f5784f.a(f2);
        }
        if (oVar.f5785g != null) {
            oVar.f5785g.a(f2);
        }
        if (this.t != null) {
            for (int i2 = 0; i2 < this.t.f5764a.size(); i2++) {
                this.t.f5764a.get(i2).a(f2);
            }
        }
        if (this.f5926c.m != 0.0f) {
            f2 /= this.f5926c.m;
        }
        c cVar = this.f5927d;
        if (cVar != null) {
            cVar.a(f2 / this.f5926c.m);
        }
        a aVar = this.f5928e;
        if (aVar != null) {
            this.f5928e.a(aVar.f5926c.m * f2);
        }
        for (int i3 = 0; i3 < this.v.size(); i3++) {
            this.v.get(i3).a(f2);
        }
    }

    private void e() {
        if (this.u == null) {
            if (this.f5929f == null) {
                this.u = Collections.emptyList();
                return;
            }
            this.u = new ArrayList();
            for (a aVar = this.f5929f; aVar != null; aVar = aVar.f5929f) {
                this.u.add(aVar);
            }
        }
    }

    public final String b() {
        return this.f5926c.f5943c;
    }

    public <T> void a(T t2, com.airbnb.lottie.g.c<T> cVar) {
        this.f5930g.a(t2, cVar);
    }

    public final void a() {
        this.f5925b.invalidateSelf();
    }

    public final void a(com.airbnb.lottie.c.e eVar, int i2, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
        if (eVar.a(this.f5926c.f5943c, i2)) {
            if (!"__container".equals(this.f5926c.f5943c)) {
                eVar2 = eVar2.a(this.f5926c.f5943c);
                if (eVar.c(this.f5926c.f5943c, i2)) {
                    list.add(eVar2.a((f) this));
                }
            }
            if (eVar.d(this.f5926c.f5943c, i2)) {
                b(eVar, i2 + eVar.b(this.f5926c.f5943c, i2), list, eVar2);
            }
        }
    }
}
