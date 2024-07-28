package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.i;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.k;
import java.util.List;

public final class n implements k, m, a.C0083a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f5702a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f5703b;

    /* renamed from: c  reason: collision with root package name */
    private final f f5704c;

    /* renamed from: d  reason: collision with root package name */
    private final i.a f5705d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f5706e;

    /* renamed from: f  reason: collision with root package name */
    private final a<?, Float> f5707f;

    /* renamed from: g  reason: collision with root package name */
    private final a<?, PointF> f5708g;

    /* renamed from: h  reason: collision with root package name */
    private final a<?, Float> f5709h;

    /* renamed from: i  reason: collision with root package name */
    private final a<?, Float> f5710i;
    private final a<?, Float> j;
    private final a<?, Float> k;
    private final a<?, Float> l;
    private b m = new b();
    private boolean n;

    public n(f fVar, com.airbnb.lottie.c.c.a aVar, i iVar) {
        this.f5704c = fVar;
        this.f5703b = iVar.f5868a;
        this.f5705d = iVar.f5869b;
        this.f5706e = iVar.j;
        this.f5707f = iVar.f5870c.a();
        this.f5708g = iVar.f5871d.a();
        this.f5709h = iVar.f5872e.a();
        this.j = iVar.f5874g.a();
        this.l = iVar.f5876i.a();
        if (this.f5705d == i.a.STAR) {
            this.f5710i = iVar.f5873f.a();
            this.k = iVar.f5875h.a();
        } else {
            this.f5710i = null;
            this.k = null;
        }
        aVar.a((a<?, ?>) this.f5707f);
        aVar.a((a<?, ?>) this.f5708g);
        aVar.a((a<?, ?>) this.f5709h);
        aVar.a((a<?, ?>) this.j);
        aVar.a((a<?, ?>) this.l);
        if (this.f5705d == i.a.STAR) {
            aVar.a((a<?, ?>) this.f5710i);
            aVar.a((a<?, ?>) this.k);
        }
        this.f5707f.a((a.C0083a) this);
        this.f5708g.a((a.C0083a) this);
        this.f5709h.a((a.C0083a) this);
        this.j.a((a.C0083a) this);
        this.l.a((a.C0083a) this);
        if (this.f5705d == i.a.STAR) {
            this.f5710i.a((a.C0083a) this);
            this.k.a((a.C0083a) this);
        }
    }

    public final void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.f5743b == q.a.SIMULTANEOUSLY) {
                    this.m.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0274  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Path e() {
        /*
            r44 = this;
            r0 = r44
            boolean r1 = r0.n
            if (r1 == 0) goto L_0x0009
            android.graphics.Path r1 = r0.f5702a
            return r1
        L_0x0009:
            android.graphics.Path r1 = r0.f5702a
            r1.reset()
            boolean r1 = r0.f5706e
            r2 = 1
            if (r1 == 0) goto L_0x0018
            r0.n = r2
            android.graphics.Path r1 = r0.f5702a
            return r1
        L_0x0018:
            int[] r1 = com.airbnb.lottie.a.a.n.AnonymousClass1.f5711a
            com.airbnb.lottie.c.b.i$a r3 = r0.f5705d
            int r3 = r3.ordinal()
            r1 = r1[r3]
            r3 = 4618760256179416344(0x401921fb54442d18, double:6.283185307179586)
            r5 = 4636033603912859648(0x4056800000000000, double:90.0)
            r7 = 0
            r10 = 1120403456(0x42c80000, float:100.0)
            r13 = 0
            if (r1 == r2) goto L_0x0135
            r14 = 2
            if (r1 == r14) goto L_0x0038
            goto L_0x032c
        L_0x0038:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r1 = r0.f5707f
            java.lang.Object r1 = r1.f()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            double r14 = (double) r1
            double r14 = java.lang.Math.floor(r14)
            int r1 = (int) r14
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r14 = r0.f5709h
            if (r14 != 0) goto L_0x004f
            goto L_0x005a
        L_0x004f:
            java.lang.Object r7 = r14.f()
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            double r7 = (double) r7
        L_0x005a:
            double r7 = r7 - r5
            double r5 = java.lang.Math.toRadians(r7)
            double r7 = (double) r1
            double r3 = r3 / r7
            float r1 = (float) r3
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r3 = r0.l
            java.lang.Object r3 = r3.f()
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            float r3 = r3 / r10
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r4 = r0.j
            java.lang.Object r4 = r4.f()
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            double r14 = (double) r4
            double r16 = java.lang.Math.cos(r5)
            double r9 = r14 * r16
            float r9 = (float) r9
            double r16 = java.lang.Math.sin(r5)
            double r11 = r14 * r16
            float r10 = (float) r11
            android.graphics.Path r11 = r0.f5702a
            r11.moveTo(r9, r10)
            double r11 = (double) r1
            double r5 = r5 + r11
            double r7 = java.lang.Math.ceil(r7)
            r17 = r3
            r1 = 0
        L_0x0098:
            double r2 = (double) r1
            int r18 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r18 >= 0) goto L_0x011d
            double r2 = java.lang.Math.cos(r5)
            double r2 = r2 * r14
            float r2 = (float) r2
            double r19 = java.lang.Math.sin(r5)
            r26 = r7
            double r7 = r14 * r19
            float r3 = (float) r7
            int r7 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x0107
            double r7 = (double) r10
            r28 = r14
            double r13 = (double) r9
            double r7 = java.lang.Math.atan2(r7, r13)
            r13 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r7 = r7 - r13
            float r7 = (float) r7
            double r7 = (double) r7
            double r13 = java.lang.Math.cos(r7)
            float r13 = (float) r13
            double r7 = java.lang.Math.sin(r7)
            float r7 = (float) r7
            double r14 = (double) r3
            r30 = r5
            double r5 = (double) r2
            double r5 = java.lang.Math.atan2(r14, r5)
            r14 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r5 = r5 - r14
            float r5 = (float) r5
            double r5 = (double) r5
            double r14 = java.lang.Math.cos(r5)
            float r8 = (float) r14
            double r5 = java.lang.Math.sin(r5)
            float r5 = (float) r5
            float r6 = r4 * r17
            r14 = 1048576000(0x3e800000, float:0.25)
            float r6 = r6 * r14
            float r13 = r13 * r6
            float r7 = r7 * r6
            float r8 = r8 * r6
            float r6 = r6 * r5
            android.graphics.Path r5 = r0.f5702a
            float r20 = r9 - r13
            float r21 = r10 - r7
            float r22 = r2 + r8
            float r23 = r3 + r6
            r19 = r5
            r24 = r2
            r25 = r3
            r19.cubicTo(r20, r21, r22, r23, r24, r25)
            goto L_0x0110
        L_0x0107:
            r30 = r5
            r28 = r14
            android.graphics.Path r5 = r0.f5702a
            r5.lineTo(r2, r3)
        L_0x0110:
            double r5 = r30 + r11
            int r1 = r1 + 1
            r9 = r2
            r10 = r3
            r7 = r26
            r14 = r28
            r13 = 0
            goto L_0x0098
        L_0x011d:
            com.airbnb.lottie.a.b.a<?, android.graphics.PointF> r1 = r0.f5708g
            java.lang.Object r1 = r1.f()
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            android.graphics.Path r2 = r0.f5702a
            float r3 = r1.x
            float r1 = r1.y
            r2.offset(r3, r1)
            android.graphics.Path r1 = r0.f5702a
            r1.close()
            goto L_0x032c
        L_0x0135:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r1 = r0.f5707f
            java.lang.Object r1 = r1.f()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r2 = r0.f5709h
            if (r2 != 0) goto L_0x0146
            goto L_0x0151
        L_0x0146:
            java.lang.Object r2 = r2.f()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            double r7 = (double) r2
        L_0x0151:
            double r7 = r7 - r5
            double r5 = java.lang.Math.toRadians(r7)
            double r7 = (double) r1
            double r3 = r3 / r7
            float r2 = (float) r3
            r3 = 1073741824(0x40000000, float:2.0)
            float r4 = r2 / r3
            int r9 = (int) r1
            float r9 = (float) r9
            float r1 = r1 - r9
            r9 = 0
            int r11 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x016c
            r9 = 1065353216(0x3f800000, float:1.0)
            float r9 = r9 - r1
            float r9 = r9 * r4
            double r12 = (double) r9
            double r5 = r5 + r12
        L_0x016c:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r9 = r0.j
            java.lang.Object r9 = r9.f()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r12 = r0.f5710i
            java.lang.Object r12 = r12.f()
            java.lang.Float r12 = (java.lang.Float) r12
            float r12 = r12.floatValue()
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r13 = r0.k
            if (r13 == 0) goto L_0x0194
            java.lang.Object r13 = r13.f()
            java.lang.Float r13 = (java.lang.Float) r13
            float r13 = r13.floatValue()
            float r13 = r13 / r10
            goto L_0x0195
        L_0x0194:
            r13 = 0
        L_0x0195:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r14 = r0.l
            if (r14 == 0) goto L_0x01a6
            java.lang.Object r14 = r14.f()
            java.lang.Float r14 = (java.lang.Float) r14
            float r14 = r14.floatValue()
            float r10 = r14 / r10
            goto L_0x01a7
        L_0x01a6:
            r10 = 0
        L_0x01a7:
            if (r11 == 0) goto L_0x01d6
            float r14 = r9 - r12
            float r14 = r14 * r1
            float r14 = r14 + r12
            r17 = r4
            double r3 = (double) r14
            double r19 = java.lang.Math.cos(r5)
            r21 = r14
            double r14 = r3 * r19
            float r14 = (float) r14
            double r19 = java.lang.Math.sin(r5)
            double r3 = r3 * r19
            float r3 = (float) r3
            android.graphics.Path r4 = r0.f5702a
            r4.moveTo(r14, r3)
            float r4 = r2 * r1
            r15 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r15
            r19 = r3
            double r3 = (double) r4
            double r5 = r5 + r3
            r4 = r17
            r3 = r19
            r17 = r14
            goto L_0x01f4
        L_0x01d6:
            r17 = r4
            double r3 = (double) r9
            double r19 = java.lang.Math.cos(r5)
            double r14 = r3 * r19
            float r14 = (float) r14
            double r19 = java.lang.Math.sin(r5)
            double r3 = r3 * r19
            float r3 = (float) r3
            android.graphics.Path r4 = r0.f5702a
            r4.moveTo(r14, r3)
            r4 = r17
            r17 = r14
            double r14 = (double) r4
            double r5 = r5 + r14
            r21 = 0
        L_0x01f4:
            double r7 = java.lang.Math.ceil(r7)
            r14 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r7 = r7 * r14
            r19 = r5
            r5 = r17
            r18 = 0
            r6 = r3
            r3 = 0
        L_0x0204:
            double r14 = (double) r3
            int r17 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r17 >= 0) goto L_0x0316
            if (r18 == 0) goto L_0x020e
            r17 = r9
            goto L_0x0210
        L_0x020e:
            r17 = r12
        L_0x0210:
            r25 = 0
            int r26 = (r21 > r25 ? 1 : (r21 == r25 ? 0 : -1))
            if (r26 == 0) goto L_0x022e
            r23 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r28 = r7 - r23
            int r25 = (r14 > r28 ? 1 : (r14 == r28 ? 0 : -1))
            if (r25 != 0) goto L_0x022b
            float r25 = r2 * r1
            r22 = 1073741824(0x40000000, float:2.0)
            float r25 = r25 / r22
            r43 = r25
            r25 = r2
            r2 = r43
            goto L_0x0235
        L_0x022b:
            r22 = 1073741824(0x40000000, float:2.0)
            goto L_0x0232
        L_0x022e:
            r22 = 1073741824(0x40000000, float:2.0)
            r23 = 4611686018427387904(0x4000000000000000, double:2.0)
        L_0x0232:
            r25 = r2
            r2 = r4
        L_0x0235:
            r28 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r26 == 0) goto L_0x0246
            double r26 = r7 - r28
            int r30 = (r14 > r26 ? 1 : (r14 == r26 ? 0 : -1))
            if (r30 != 0) goto L_0x0246
            r26 = r4
            r30 = r14
            r4 = r21
            goto L_0x024c
        L_0x0246:
            r26 = r4
            r30 = r14
            r4 = r17
        L_0x024c:
            double r14 = (double) r4
            double r32 = java.lang.Math.cos(r19)
            r34 = r7
            double r7 = r14 * r32
            float r4 = (float) r7
            double r7 = java.lang.Math.sin(r19)
            double r14 = r14 * r7
            float r7 = (float) r14
            r8 = 0
            int r14 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r14 != 0) goto L_0x0274
            int r14 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r14 != 0) goto L_0x0274
            android.graphics.Path r5 = r0.f5702a
            r5.lineTo(r4, r7)
            r17 = r9
            r15 = r10
            r27 = r12
            r32 = r13
            goto L_0x02fe
        L_0x0274:
            double r14 = (double) r6
            r17 = r9
            double r8 = (double) r5
            double r8 = java.lang.Math.atan2(r14, r8)
            r14 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r8 = r8 - r14
            float r8 = (float) r8
            double r8 = (double) r8
            double r14 = java.lang.Math.cos(r8)
            float r14 = (float) r14
            double r8 = java.lang.Math.sin(r8)
            float r8 = (float) r8
            r15 = r10
            double r9 = (double) r7
            r27 = r12
            r32 = r13
            double r12 = (double) r4
            double r9 = java.lang.Math.atan2(r9, r12)
            r12 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r9 = r9 - r12
            float r9 = (float) r9
            double r9 = (double) r9
            double r12 = java.lang.Math.cos(r9)
            float r12 = (float) r12
            double r9 = java.lang.Math.sin(r9)
            float r9 = (float) r9
            if (r18 == 0) goto L_0x02b0
            r10 = r32
            goto L_0x02b1
        L_0x02b0:
            r10 = r15
        L_0x02b1:
            if (r18 == 0) goto L_0x02b5
            r13 = r15
            goto L_0x02b7
        L_0x02b5:
            r13 = r32
        L_0x02b7:
            if (r18 == 0) goto L_0x02bc
            r33 = r27
            goto L_0x02be
        L_0x02bc:
            r33 = r17
        L_0x02be:
            if (r18 == 0) goto L_0x02c3
            r36 = r17
            goto L_0x02c5
        L_0x02c3:
            r36 = r27
        L_0x02c5:
            float r33 = r33 * r10
            r10 = 1056236141(0x3ef4e26d, float:0.47829)
            float r33 = r33 * r10
            float r14 = r14 * r33
            float r33 = r33 * r8
            float r36 = r36 * r13
            float r36 = r36 * r10
            float r12 = r12 * r36
            float r36 = r36 * r9
            if (r11 == 0) goto L_0x02eb
            if (r3 != 0) goto L_0x02e1
            float r14 = r14 * r1
            float r33 = r33 * r1
            goto L_0x02eb
        L_0x02e1:
            double r8 = r34 - r28
            int r10 = (r30 > r8 ? 1 : (r30 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x02eb
            float r12 = r12 * r1
            float r36 = r36 * r1
        L_0x02eb:
            android.graphics.Path r8 = r0.f5702a
            float r37 = r5 - r14
            float r38 = r6 - r33
            float r39 = r4 + r12
            float r40 = r7 + r36
            r36 = r8
            r41 = r4
            r42 = r7
            r36.cubicTo(r37, r38, r39, r40, r41, r42)
        L_0x02fe:
            double r5 = (double) r2
            double r19 = r19 + r5
            r18 = r18 ^ 1
            int r3 = r3 + 1
            r5 = r4
            r6 = r7
            r10 = r15
            r9 = r17
            r2 = r25
            r4 = r26
            r12 = r27
            r13 = r32
            r7 = r34
            goto L_0x0204
        L_0x0316:
            com.airbnb.lottie.a.b.a<?, android.graphics.PointF> r1 = r0.f5708g
            java.lang.Object r1 = r1.f()
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            android.graphics.Path r2 = r0.f5702a
            float r3 = r1.x
            float r1 = r1.y
            r2.offset(r3, r1)
            android.graphics.Path r1 = r0.f5702a
            r1.close()
        L_0x032c:
            android.graphics.Path r1 = r0.f5702a
            r1.close()
            com.airbnb.lottie.a.a.b r1 = r0.m
            android.graphics.Path r2 = r0.f5702a
            r1.a((android.graphics.Path) r2)
            r1 = 1
            r0.n = r1
            android.graphics.Path r1 = r0.f5702a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.n.e():android.graphics.Path");
    }

    /* renamed from: com.airbnb.lottie.a.a.n$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5711a = new int[i.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.airbnb.lottie.c.b.i$a[] r0 = com.airbnb.lottie.c.b.i.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5711a = r0
                int[] r0 = f5711a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.i$a r1 = com.airbnb.lottie.c.b.i.a.STAR     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5711a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.i$a r1 = com.airbnb.lottie.c.b.i.a.POLYGON     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.n.AnonymousClass1.<clinit>():void");
        }
    }

    public final String b() {
        return this.f5703b;
    }

    public final void a(e eVar, int i2, List<e> list, e eVar2) {
        g.a(eVar, i2, list, eVar2, this);
    }

    public final <T> void a(T t, c<T> cVar) {
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == k.s) {
            this.f5707f.a(cVar);
        } else if (t == k.t) {
            this.f5709h.a(cVar);
        } else if (t == k.j) {
            this.f5708g.a(cVar);
        } else if (t == k.u && (aVar2 = this.f5710i) != null) {
            aVar2.a((c<Float>) cVar);
        } else if (t == k.v) {
            this.j.a(cVar);
        } else if (t == k.w && (aVar = this.k) != null) {
            aVar.a((c<Float>) cVar);
        } else if (t == k.x) {
            this.l.a(cVar);
        }
    }

    public final void a() {
        this.n = false;
        this.f5704c.invalidateSelf();
    }
}
