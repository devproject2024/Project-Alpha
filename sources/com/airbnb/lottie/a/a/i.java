package com.airbnb.lottie.a.a;

import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import androidx.a.d;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.c.b.e;
import com.airbnb.lottie.c.b.f;
import com.airbnb.lottie.k;

public final class i extends a {

    /* renamed from: c  reason: collision with root package name */
    private final String f5688c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5689d;

    /* renamed from: e  reason: collision with root package name */
    private final d<LinearGradient> f5690e = new d<>();

    /* renamed from: f  reason: collision with root package name */
    private final d<RadialGradient> f5691f = new d<>();

    /* renamed from: g  reason: collision with root package name */
    private final RectF f5692g = new RectF();

    /* renamed from: h  reason: collision with root package name */
    private final f f5693h;

    /* renamed from: i  reason: collision with root package name */
    private final int f5694i;
    private final a<c, c> j;
    private final a<PointF, PointF> k;
    private final a<PointF, PointF> l;
    private p m;

    /* JADX WARNING: type inference failed for: r2v3, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r8v2, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.graphics.Canvas r17, android.graphics.Matrix r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r0.f5689d
            if (r2 == 0) goto L_0x0009
            return
        L_0x0009:
            android.graphics.RectF r2 = r0.f5692g
            r3 = 0
            r0.a((android.graphics.RectF) r2, (android.graphics.Matrix) r1, (boolean) r3)
            com.airbnb.lottie.c.b.f r2 = r0.f5693h
            com.airbnb.lottie.c.b.f r3 = com.airbnb.lottie.c.b.f.LINEAR
            r4 = 0
            if (r2 != r3) goto L_0x005d
            int r2 = r16.c()
            androidx.a.d<android.graphics.LinearGradient> r3 = r0.f5690e
            long r5 = (long) r2
            java.lang.Object r2 = r3.a(r5, r4)
            android.graphics.LinearGradient r2 = (android.graphics.LinearGradient) r2
            if (r2 == 0) goto L_0x0027
            goto L_0x00ab
        L_0x0027:
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r2 = r0.k
            java.lang.Object r2 = r2.f()
            android.graphics.PointF r2 = (android.graphics.PointF) r2
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r3 = r0.l
            java.lang.Object r3 = r3.f()
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            com.airbnb.lottie.a.b.a<com.airbnb.lottie.c.b.c, com.airbnb.lottie.c.b.c> r4 = r0.j
            java.lang.Object r4 = r4.f()
            com.airbnb.lottie.c.b.c r4 = (com.airbnb.lottie.c.b.c) r4
            int[] r7 = r4.f5842b
            int[] r13 = r0.a(r7)
            float[] r14 = r4.f5841a
            float r9 = r2.x
            float r10 = r2.y
            float r11 = r3.x
            float r12 = r3.y
            android.graphics.LinearGradient r2 = new android.graphics.LinearGradient
            android.graphics.Shader$TileMode r15 = android.graphics.Shader.TileMode.CLAMP
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            androidx.a.d<android.graphics.LinearGradient> r3 = r0.f5690e
            r3.b(r5, r2)
            goto L_0x00ab
        L_0x005d:
            int r2 = r16.c()
            androidx.a.d<android.graphics.RadialGradient> r3 = r0.f5691f
            long r5 = (long) r2
            java.lang.Object r2 = r3.a(r5, r4)
            android.graphics.RadialGradient r2 = (android.graphics.RadialGradient) r2
            if (r2 == 0) goto L_0x006d
            goto L_0x00ab
        L_0x006d:
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r2 = r0.k
            java.lang.Object r2 = r2.f()
            android.graphics.PointF r2 = (android.graphics.PointF) r2
            com.airbnb.lottie.a.b.a<android.graphics.PointF, android.graphics.PointF> r3 = r0.l
            java.lang.Object r3 = r3.f()
            android.graphics.PointF r3 = (android.graphics.PointF) r3
            com.airbnb.lottie.a.b.a<com.airbnb.lottie.c.b.c, com.airbnb.lottie.c.b.c> r4 = r0.j
            java.lang.Object r4 = r4.f()
            com.airbnb.lottie.c.b.c r4 = (com.airbnb.lottie.c.b.c) r4
            int[] r7 = r4.f5842b
            int[] r12 = r0.a(r7)
            float[] r13 = r4.f5841a
            float r9 = r2.x
            float r10 = r2.y
            float r2 = r3.x
            float r3 = r3.y
            float r2 = r2 - r9
            double r7 = (double) r2
            float r3 = r3 - r10
            double r2 = (double) r3
            double r2 = java.lang.Math.hypot(r7, r2)
            float r11 = (float) r2
            android.graphics.RadialGradient r2 = new android.graphics.RadialGradient
            android.graphics.Shader$TileMode r14 = android.graphics.Shader.TileMode.CLAMP
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14)
            androidx.a.d<android.graphics.RadialGradient> r3 = r0.f5691f
            r3.b(r5, r2)
        L_0x00ab:
            r2.setLocalMatrix(r1)
            android.graphics.Paint r3 = r0.f5642b
            r3.setShader(r2)
            super.a((android.graphics.Canvas) r17, (android.graphics.Matrix) r18, (int) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.i.a(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public final String b() {
        return this.f5688c;
    }

    private int c() {
        int round = Math.round(this.k.g() * ((float) this.f5694i));
        int round2 = Math.round(this.l.g() * ((float) this.f5694i));
        int round3 = Math.round(this.j.g() * ((float) this.f5694i));
        int i2 = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }

    private int[] a(int[] iArr) {
        p pVar = this.m;
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

    public final <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t, cVar);
        if (t == k.D) {
            if (this.m != null) {
                this.f5641a.b((a<?, ?>) this.m);
            }
            if (cVar == null) {
                this.m = null;
                return;
            }
            this.m = new p(cVar);
            this.m.a((a.C0083a) this);
            this.f5641a.a((a<?, ?>) this.m);
        }
    }

    public i(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, e eVar) {
        super(fVar, aVar, eVar.f5859h.toPaintCap(), eVar.f5860i.toPaintJoin(), eVar.j, eVar.f5855d, eVar.f5858g, eVar.k, eVar.l);
        this.f5688c = eVar.f5852a;
        this.f5693h = eVar.f5853b;
        this.f5689d = eVar.m;
        this.f5694i = (int) (fVar.f6063a.a() / 32.0f);
        this.j = eVar.f5854c.a();
        this.j.a((a.C0083a) this);
        aVar.a((a<?, ?>) this.j);
        this.k = eVar.f5856e.a();
        this.k.a((a.C0083a) this);
        aVar.a((a<?, ?>) this.k);
        this.l = eVar.f5857f.a();
        this.l.a((a.C0083a) this);
        aVar.a((a<?, ?>) this.l);
    }
}
