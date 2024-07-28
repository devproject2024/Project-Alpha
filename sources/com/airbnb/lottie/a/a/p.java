package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.c.b.k;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.c;
import java.util.List;

public final class p implements e, j, k, m, a.C0083a {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f5721a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f5722b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final f f5723c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.c.c.a f5724d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5725e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f5726f;

    /* renamed from: g  reason: collision with root package name */
    private final a<Float, Float> f5727g;

    /* renamed from: h  reason: collision with root package name */
    private final a<Float, Float> f5728h;

    /* renamed from: i  reason: collision with root package name */
    private final o f5729i;
    private d j;

    public p(f fVar, com.airbnb.lottie.c.c.a aVar, k kVar) {
        this.f5723c = fVar;
        this.f5724d = aVar;
        this.f5725e = kVar.f5882a;
        this.f5726f = kVar.f5886e;
        this.f5727g = kVar.f5883b.a();
        aVar.a((a<?, ?>) this.f5727g);
        this.f5727g.a((a.C0083a) this);
        this.f5728h = kVar.f5884c.a();
        aVar.a((a<?, ?>) this.f5728h);
        this.f5728h.a((a.C0083a) this);
        this.f5729i = kVar.f5885d.a();
        this.f5729i.a(aVar);
        this.f5729i.a((a.C0083a) this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ListIterator<com.airbnb.lottie.a.a.c> r9) {
        /*
            r8 = this;
            com.airbnb.lottie.a.a.d r0 = r8.j
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = r9.previous()
            if (r0 != r8) goto L_0x0005
        L_0x0011:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0016:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r9.previous()
            r6.add(r0)
            r9.remove()
            goto L_0x0016
        L_0x0027:
            java.util.Collections.reverse(r6)
            com.airbnb.lottie.a.a.d r9 = new com.airbnb.lottie.a.a.d
            com.airbnb.lottie.f r2 = r8.f5723c
            com.airbnb.lottie.c.c.a r3 = r8.f5724d
            boolean r5 = r8.f5726f
            r7 = 0
            java.lang.String r4 = "Repeater"
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.j = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.p.a(java.util.ListIterator):void");
    }

    public final String b() {
        return this.f5725e;
    }

    public final void a(List<c> list, List<c> list2) {
        this.j.a(list, list2);
    }

    public final Path e() {
        Path e2 = this.j.e();
        this.f5722b.reset();
        float floatValue = this.f5727g.f().floatValue();
        float floatValue2 = this.f5728h.f().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f5721a.set(this.f5729i.a(((float) i2) + floatValue2));
            this.f5722b.addPath(e2, this.f5721a);
        }
        return this.f5722b;
    }

    public final void a(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.f5727g.f().floatValue();
        float floatValue2 = this.f5728h.f().floatValue();
        float floatValue3 = this.f5729i.f5786h.f().floatValue() / 100.0f;
        float floatValue4 = this.f5729i.f5787i.f().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.f5721a.set(matrix);
            float f2 = (float) i3;
            this.f5721a.preConcat(this.f5729i.a(f2 + floatValue2));
            this.j.a(canvas, this.f5721a, (int) (((float) i2) * g.a(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        this.j.a(rectF, matrix, z);
    }

    public final void a() {
        this.f5723c.invalidateSelf();
    }

    public final void a(e eVar, int i2, List<e> list, e eVar2) {
        g.a(eVar, i2, list, eVar2, this);
    }

    public final <T> void a(T t, c<T> cVar) {
        if (!this.f5729i.a(t, cVar)) {
            if (t == com.airbnb.lottie.k.q) {
                this.f5727g.a(cVar);
            } else if (t == com.airbnb.lottie.k.r) {
                this.f5728h.a(cVar);
            }
        }
    }
}
