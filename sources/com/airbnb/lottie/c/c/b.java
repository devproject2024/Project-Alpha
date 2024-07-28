package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.k;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {

    /* renamed from: h  reason: collision with root package name */
    public final List<a> f5936h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public Boolean f5937i;
    private a<Float, Float> j;
    private final RectF k = new RectF();
    private final RectF l = new RectF();
    private Paint m = new Paint();
    private Boolean n;

    public b(f fVar, d dVar, List<d> list, d dVar2) {
        super(fVar, dVar);
        a aVar;
        a aVar2;
        com.airbnb.lottie.c.a.b bVar = dVar.s;
        if (bVar != null) {
            this.j = bVar.a();
            a((a<?, ?>) this.j);
            this.j.a((a.C0083a) this);
        } else {
            this.j = null;
        }
        androidx.a.d dVar3 = new androidx.a.d(dVar2.f5981h.size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (true) {
            if (size >= 0) {
                d dVar4 = list.get(size);
                switch (dVar4.f5945e) {
                    case SHAPE:
                        aVar2 = new f(fVar, dVar4);
                        break;
                    case PRE_COMP:
                        aVar2 = new b(fVar, dVar4, dVar2.f5975b.get(dVar4.f5947g), dVar2);
                        break;
                    case SOLID:
                        aVar2 = new g(fVar, dVar4);
                        break;
                    case IMAGE:
                        aVar2 = new c(fVar, dVar4);
                        break;
                    case NULL:
                        aVar2 = new e(fVar, dVar4);
                        break;
                    case TEXT:
                        aVar2 = new h(fVar, dVar4);
                        break;
                    default:
                        com.airbnb.lottie.f.d.a("Unknown layer type " + dVar4.f5945e);
                        aVar2 = null;
                        break;
                }
                if (aVar2 != null) {
                    dVar3.b(aVar2.f5926c.f5944d, aVar2);
                    if (aVar3 != null) {
                        aVar3.f5928e = aVar2;
                        aVar3 = null;
                    } else {
                        this.f5936h.add(0, aVar2);
                        int i2 = AnonymousClass1.f5938a[dVar4.u.ordinal()];
                        if (i2 == 1 || i2 == 2) {
                            aVar3 = aVar2;
                        }
                    }
                }
                size--;
            } else {
                for (int i3 = 0; i3 < dVar3.b(); i3++) {
                    a aVar4 = (a) dVar3.a(dVar3.b(i3), null);
                    if (!(aVar4 == null || (aVar = (a) dVar3.a(aVar4.f5926c.f5946f, null)) == null)) {
                        aVar4.f5929f = aVar;
                    }
                }
                return;
            }
        }
    }

    /* renamed from: com.airbnb.lottie.c.c.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5938a = new int[d.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.airbnb.lottie.c.c.d$b[] r0 = com.airbnb.lottie.c.c.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5938a = r0
                int[] r0 = f5938a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.c.d$b r1 = com.airbnb.lottie.c.c.d.b.ADD     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5938a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.c.d$b r1 = com.airbnb.lottie.c.c.d.b.INVERT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.c.b.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Canvas canvas, Matrix matrix, int i2) {
        c.a("CompositionLayer#draw");
        this.l.set(0.0f, 0.0f, (float) this.f5926c.o, (float) this.f5926c.p);
        matrix.mapRect(this.l);
        boolean z = this.f5925b.r && this.f5936h.size() > 1 && i2 != 255;
        if (z) {
            this.m.setAlpha(i2);
            h.a(canvas, this.l, this.m);
        } else {
            canvas.save();
        }
        if (z) {
            i2 = PriceRangeSeekBar.INVALID_POINTER_ID;
        }
        for (int size = this.f5936h.size() - 1; size >= 0; size--) {
            if (!this.l.isEmpty() ? canvas.clipRect(this.l) : true) {
                this.f5936h.get(size).a(canvas, matrix, i2);
            }
        }
        canvas.restore();
        c.b("CompositionLayer#draw");
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.f5936h.size() - 1; size >= 0; size--) {
            this.k.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f5936h.get(size).a(this.k, this.f5924a, true);
            rectF.union(this.k);
        }
    }

    public final void a(float f2) {
        super.a(f2);
        if (this.j != null) {
            f2 = ((this.j.f().floatValue() * this.f5926c.f5942b.l) - this.f5926c.f5942b.j) / (this.f5925b.f6063a.b() + 0.01f);
        }
        if (this.j == null) {
            d dVar = this.f5926c;
            f2 -= dVar.n / dVar.f5942b.b();
        }
        if (this.f5926c.m != 0.0f) {
            f2 /= this.f5926c.m;
        }
        for (int size = this.f5936h.size() - 1; size >= 0; size--) {
            this.f5936h.get(size).a(f2);
        }
    }

    public final boolean e() {
        if (this.n == null) {
            for (int size = this.f5936h.size() - 1; size >= 0; size--) {
                a aVar = this.f5936h.get(size);
                if (aVar instanceof f) {
                    if (aVar.d()) {
                        this.n = Boolean.TRUE;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).e()) {
                    this.n = Boolean.TRUE;
                    return true;
                }
            }
            this.n = Boolean.FALSE;
        }
        return this.n.booleanValue();
    }

    /* access modifiers changed from: protected */
    public final void b(e eVar, int i2, List<e> list, e eVar2) {
        for (int i3 = 0; i3 < this.f5936h.size(); i3++) {
            this.f5936h.get(i3).a(eVar, i2, list, eVar2);
        }
    }

    public final <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t, cVar);
        if (t != k.A) {
            return;
        }
        if (cVar == null) {
            a<Float, Float> aVar = this.j;
            if (aVar != null) {
                aVar.a((com.airbnb.lottie.g.c<Float>) null);
                return;
            }
            return;
        }
        this.j = new p(cVar);
        this.j.a((a.C0083a) this);
        a((a<?, ?>) this.j);
    }
}
