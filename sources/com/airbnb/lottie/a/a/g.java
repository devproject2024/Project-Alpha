package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.b.m;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

public final class g implements e, k, a.C0083a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f5670a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Paint f5671b = new com.airbnb.lottie.a.a(1);

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.c.c.a f5672c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5673d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f5674e;

    /* renamed from: f  reason: collision with root package name */
    private final List<m> f5675f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final a<Integer, Integer> f5676g;

    /* renamed from: h  reason: collision with root package name */
    private final a<Integer, Integer> f5677h;

    /* renamed from: i  reason: collision with root package name */
    private a<ColorFilter, ColorFilter> f5678i;
    private final f j;

    public g(f fVar, com.airbnb.lottie.c.c.a aVar, m mVar) {
        this.f5672c = aVar;
        this.f5673d = mVar.f5891b;
        this.f5674e = mVar.f5894e;
        this.j = fVar;
        if (mVar.f5892c == null || mVar.f5893d == null) {
            this.f5676g = null;
            this.f5677h = null;
            return;
        }
        this.f5670a.setFillType(mVar.f5890a);
        this.f5676g = mVar.f5892c.a();
        this.f5676g.a((a.C0083a) this);
        aVar.a((a<?, ?>) this.f5676g);
        this.f5677h = mVar.f5893d.a();
        this.f5677h.a((a.C0083a) this);
        aVar.a((a<?, ?>) this.f5677h);
    }

    public final void a() {
        this.j.invalidateSelf();
    }

    public final void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof m) {
                this.f5675f.add((m) cVar);
            }
        }
    }

    public final String b() {
        return this.f5673d;
    }

    public final void a(Canvas canvas, Matrix matrix, int i2) {
        if (!this.f5674e) {
            c.a("FillContent#draw");
            this.f5671b.setColor(((b) this.f5676g).h());
            this.f5671b.setAlpha(com.airbnb.lottie.f.g.a((int) ((((((float) i2) / 255.0f) * ((float) this.f5677h.f().intValue())) / 100.0f) * 255.0f)));
            a<ColorFilter, ColorFilter> aVar = this.f5678i;
            if (aVar != null) {
                this.f5671b.setColorFilter(aVar.f());
            }
            this.f5670a.reset();
            for (int i3 = 0; i3 < this.f5675f.size(); i3++) {
                this.f5670a.addPath(this.f5675f.get(i3).e(), matrix);
            }
            canvas.drawPath(this.f5670a, this.f5671b);
            c.b("FillContent#draw");
        }
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        this.f5670a.reset();
        for (int i2 = 0; i2 < this.f5675f.size(); i2++) {
            this.f5670a.addPath(this.f5675f.get(i2).e(), matrix);
        }
        this.f5670a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final void a(e eVar, int i2, List<e> list, e eVar2) {
        com.airbnb.lottie.f.g.a(eVar, i2, list, eVar2, this);
    }

    public final <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        if (t == k.f6155a) {
            this.f5676g.a(cVar);
        } else if (t == k.f6158d) {
            this.f5677h.a(cVar);
        } else if (t == k.C) {
            a<ColorFilter, ColorFilter> aVar = this.f5678i;
            if (aVar != null) {
                this.f5672c.b((a<?, ?>) aVar);
            }
            if (cVar == null) {
                this.f5678i = null;
                return;
            }
            this.f5678i = new p(cVar);
            this.f5678i.a((a.C0083a) this);
            this.f5672c.a((a<?, ?>) this.f5678i);
        }
    }
}
