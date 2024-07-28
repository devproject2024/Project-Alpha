package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.e;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.d;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;

public abstract class a implements e, k, a.C0083a {

    /* renamed from: a  reason: collision with root package name */
    protected final com.airbnb.lottie.c.c.a f5641a;

    /* renamed from: b  reason: collision with root package name */
    final Paint f5642b = new com.airbnb.lottie.a.a(1);

    /* renamed from: c  reason: collision with root package name */
    private final PathMeasure f5643c = new PathMeasure();

    /* renamed from: d  reason: collision with root package name */
    private final Path f5644d = new Path();

    /* renamed from: e  reason: collision with root package name */
    private final Path f5645e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f5646f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final f f5647g;

    /* renamed from: h  reason: collision with root package name */
    private final List<C0082a> f5648h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final float[] f5649i;
    private final com.airbnb.lottie.a.b.a<?, Float> j;
    private final com.airbnb.lottie.a.b.a<?, Integer> k;
    private final List<com.airbnb.lottie.a.b.a<?, Float>> l;
    private final com.airbnb.lottie.a.b.a<?, Float> m;
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> n;

    a(f fVar, com.airbnb.lottie.c.c.a aVar, Paint.Cap cap, Paint.Join join, float f2, d dVar, b bVar, List<b> list, b bVar2) {
        this.f5647g = fVar;
        this.f5641a = aVar;
        this.f5642b.setStyle(Paint.Style.STROKE);
        this.f5642b.setStrokeCap(cap);
        this.f5642b.setStrokeJoin(join);
        this.f5642b.setStrokeMiter(f2);
        this.k = dVar.a();
        this.j = bVar.a();
        if (bVar2 == null) {
            this.m = null;
        } else {
            this.m = bVar2.a();
        }
        this.l = new ArrayList(list.size());
        this.f5649i = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.l.add(list.get(i2).a());
        }
        aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.k);
        aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.j);
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.l.get(i3));
        }
        com.airbnb.lottie.a.b.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar.a((com.airbnb.lottie.a.b.a<?, ?>) aVar2);
        }
        this.k.a((a.C0083a) this);
        this.j.a((a.C0083a) this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.l.get(i4).a((a.C0083a) this);
        }
        com.airbnb.lottie.a.b.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a((a.C0083a) this);
        }
    }

    public final void a() {
        this.f5647g.invalidateSelf();
    }

    public final void a(List<c> list, List<c> list2) {
        C0082a aVar = null;
        s sVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof s) {
                s sVar2 = (s) cVar;
                if (sVar2.f5743b == q.a.INDIVIDUALLY) {
                    sVar = sVar2;
                }
            }
        }
        if (sVar != null) {
            sVar.a(this);
        }
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.f5743b == q.a.INDIVIDUALLY) {
                    if (aVar != null) {
                        this.f5648h.add(aVar);
                    }
                    C0082a aVar2 = new C0082a(sVar3, (byte) 0);
                    sVar3.a(this);
                    aVar = aVar2;
                }
            }
            if (cVar2 instanceof m) {
                if (aVar == null) {
                    aVar = new C0082a(sVar, (byte) 0);
                }
                aVar.f5650a.add((m) cVar2);
            }
        }
        if (aVar != null) {
            this.f5648h.add(aVar);
        }
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        c.a("StrokeContent#draw");
        if (h.b(matrix)) {
            c.b("StrokeContent#draw");
            return;
        }
        this.f5642b.setAlpha(g.a((int) ((((((float) i2) / 255.0f) * ((float) ((e) this.k).h())) / 100.0f) * 255.0f)));
        this.f5642b.setStrokeWidth(((com.airbnb.lottie.a.b.c) this.j).h() * h.a(matrix));
        float f2 = 0.0f;
        if (this.f5642b.getStrokeWidth() <= 0.0f) {
            c.b("StrokeContent#draw");
            return;
        }
        c.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            c.b("StrokeContent#applyDashPattern");
        } else {
            float a2 = h.a(matrix);
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                this.f5649i[i3] = ((Float) this.l.get(i3).f()).floatValue();
                if (i3 % 2 == 0) {
                    float[] fArr = this.f5649i;
                    if (fArr[i3] < 1.0f) {
                        fArr[i3] = 1.0f;
                    }
                } else {
                    float[] fArr2 = this.f5649i;
                    if (fArr2[i3] < 0.1f) {
                        fArr2[i3] = 0.1f;
                    }
                }
                float[] fArr3 = this.f5649i;
                fArr3[i3] = fArr3[i3] * a2;
            }
            com.airbnb.lottie.a.b.a<?, Float> aVar = this.m;
            if (aVar != null) {
                f2 = aVar.f().floatValue() * a2;
            }
            this.f5642b.setPathEffect(new DashPathEffect(this.f5649i, f2));
            c.b("StrokeContent#applyDashPattern");
        }
        com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar2 = this.n;
        if (aVar2 != null) {
            this.f5642b.setColorFilter(aVar2.f());
        }
        for (int i4 = 0; i4 < this.f5648h.size(); i4++) {
            C0082a aVar3 = this.f5648h.get(i4);
            if (aVar3.f5651b != null) {
                a(canvas, aVar3, matrix);
            } else {
                c.a("StrokeContent#buildPath");
                this.f5644d.reset();
                for (int size = aVar3.f5650a.size() - 1; size >= 0; size--) {
                    this.f5644d.addPath(aVar3.f5650a.get(size).e(), matrix);
                }
                c.b("StrokeContent#buildPath");
                c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f5644d, this.f5642b);
                c.b("StrokeContent#drawPath");
            }
        }
        c.b("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0082a aVar, Matrix matrix) {
        float f2;
        c.a("StrokeContent#applyTrimPath");
        if (aVar.f5651b == null) {
            c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f5644d.reset();
        for (int size = aVar.f5650a.size() - 1; size >= 0; size--) {
            this.f5644d.addPath(aVar.f5650a.get(size).e(), matrix);
        }
        this.f5643c.setPath(this.f5644d, false);
        float length = this.f5643c.getLength();
        while (this.f5643c.nextContour()) {
            length += this.f5643c.getLength();
        }
        float floatValue = (aVar.f5651b.f5746e.f().floatValue() * length) / 360.0f;
        float floatValue2 = ((aVar.f5651b.f5744c.f().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((aVar.f5651b.f5745d.f().floatValue() * length) / 100.0f) + floatValue;
        float f3 = 0.0f;
        for (int size2 = aVar.f5650a.size() - 1; size2 >= 0; size2--) {
            this.f5645e.set(aVar.f5650a.get(size2).e());
            this.f5645e.transform(matrix);
            this.f5643c.setPath(this.f5645e, false);
            float length2 = this.f5643c.getLength();
            float f4 = 1.0f;
            if (floatValue3 > length) {
                float f5 = floatValue3 - length;
                if (f5 < f3 + length2 && f3 < f5) {
                    f2 = floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f;
                    f4 = Math.min(f5 / length2, 1.0f);
                    h.a(this.f5645e, f2, f4, 0.0f);
                    canvas.drawPath(this.f5645e, this.f5642b);
                    f3 += length2;
                }
            }
            float f6 = f3 + length2;
            if (f6 >= floatValue2 && f3 <= floatValue3) {
                if (f6 > floatValue3 || floatValue2 >= f3) {
                    f2 = floatValue2 < f3 ? 0.0f : (floatValue2 - f3) / length2;
                    if (floatValue3 <= f6) {
                        f4 = (floatValue3 - f3) / length2;
                    }
                    h.a(this.f5645e, f2, f4, 0.0f);
                    canvas.drawPath(this.f5645e, this.f5642b);
                } else {
                    canvas.drawPath(this.f5645e, this.f5642b);
                }
            }
            f3 += length2;
        }
        c.b("StrokeContent#applyTrimPath");
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        c.a("StrokeContent#getBounds");
        this.f5644d.reset();
        for (int i2 = 0; i2 < this.f5648h.size(); i2++) {
            C0082a aVar = this.f5648h.get(i2);
            for (int i3 = 0; i3 < aVar.f5650a.size(); i3++) {
                this.f5644d.addPath(aVar.f5650a.get(i3).e(), matrix);
            }
        }
        this.f5644d.computeBounds(this.f5646f, false);
        float h2 = ((com.airbnb.lottie.a.b.c) this.j).h();
        RectF rectF2 = this.f5646f;
        float f2 = h2 / 2.0f;
        rectF2.set(rectF2.left - f2, this.f5646f.top - f2, this.f5646f.right + f2, this.f5646f.bottom + f2);
        rectF.set(this.f5646f);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        c.b("StrokeContent#getBounds");
    }

    public final void a(com.airbnb.lottie.c.e eVar, int i2, List<com.airbnb.lottie.c.e> list, com.airbnb.lottie.c.e eVar2) {
        g.a(eVar, i2, list, eVar2, this);
    }

    public <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        if (t == k.f6158d) {
            this.k.a(cVar);
        } else if (t == k.o) {
            this.j.a(cVar);
        } else if (t == k.C) {
            com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.n;
            if (aVar != null) {
                this.f5641a.b((com.airbnb.lottie.a.b.a<?, ?>) aVar);
            }
            if (cVar == null) {
                this.n = null;
                return;
            }
            this.n = new p(cVar);
            this.n.a((a.C0083a) this);
            this.f5641a.a((com.airbnb.lottie.a.b.a<?, ?>) this.n);
        }
    }

    /* renamed from: com.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    static final class C0082a {

        /* renamed from: a  reason: collision with root package name */
        final List<m> f5650a;

        /* renamed from: b  reason: collision with root package name */
        final s f5651b;

        /* synthetic */ C0082a(s sVar, byte b2) {
            this(sVar);
        }

        private C0082a(s sVar) {
            this.f5650a = new ArrayList();
            this.f5651b = sVar;
        }
    }
}
