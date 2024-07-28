package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.b.b;
import com.airbnb.lottie.c.b.n;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.c.f;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g.c;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.List;

public final class d implements e, m, a.C0083a, f {

    /* renamed from: a  reason: collision with root package name */
    private Paint f5653a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f5654b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f5655c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f5656d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f5657e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5658f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5659g;

    /* renamed from: h  reason: collision with root package name */
    private final List<c> f5660h;

    /* renamed from: i  reason: collision with root package name */
    private final com.airbnb.lottie.f f5661i;
    private List<m> j;
    private o k;

    private static List<c> a(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, List<b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            c a2 = list.get(i2).a(fVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    private static l a(List<b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar instanceof l) {
                return (l) bVar;
            }
        }
        return null;
    }

    d(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, String str, boolean z, List<c> list, l lVar) {
        this.f5653a = new com.airbnb.lottie.a.a();
        this.f5654b = new RectF();
        this.f5655c = new Matrix();
        this.f5656d = new Path();
        this.f5657e = new RectF();
        this.f5658f = str;
        this.f5661i = fVar;
        this.f5659g = z;
        this.f5660h = list;
        if (lVar != null) {
            this.k = lVar.a();
            this.k.a(aVar);
            this.k.a((a.C0083a) this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    public final void a() {
        this.f5661i.invalidateSelf();
    }

    public final String b() {
        return this.f5658f;
    }

    public final void a(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f5660h.size());
        arrayList.addAll(list);
        for (int size = this.f5660h.size() - 1; size >= 0; size--) {
            c cVar = this.f5660h.get(size);
            cVar.a(arrayList, this.f5660h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final List<m> c() {
        if (this.j == null) {
            this.j = new ArrayList();
            for (int i2 = 0; i2 < this.f5660h.size(); i2++) {
                c cVar = this.f5660h.get(i2);
                if (cVar instanceof m) {
                    this.j.add((m) cVar);
                }
            }
        }
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final Matrix d() {
        o oVar = this.k;
        if (oVar != null) {
            return oVar.a();
        }
        this.f5655c.reset();
        return this.f5655c;
    }

    public final Path e() {
        this.f5655c.reset();
        o oVar = this.k;
        if (oVar != null) {
            this.f5655c.set(oVar.a());
        }
        this.f5656d.reset();
        if (this.f5659g) {
            return this.f5656d;
        }
        for (int size = this.f5660h.size() - 1; size >= 0; size--) {
            c cVar = this.f5660h.get(size);
            if (cVar instanceof m) {
                this.f5656d.addPath(((m) cVar).e(), this.f5655c);
            }
        }
        return this.f5656d;
    }

    public final void a(Canvas canvas, Matrix matrix, int i2) {
        boolean z;
        if (!this.f5659g) {
            this.f5655c.set(matrix);
            o oVar = this.k;
            if (oVar != null) {
                this.f5655c.preConcat(oVar.a());
                i2 = (int) ((((((float) (this.k.f5783e == null ? 100 : this.k.f5783e.f().intValue())) / 100.0f) * ((float) i2)) / 255.0f) * 255.0f);
            }
            boolean z2 = false;
            if (this.f5661i.r) {
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 < this.f5660h.size()) {
                        if ((this.f5660h.get(i3) instanceof e) && (i4 = i4 + 1) >= 2) {
                            z = true;
                            break;
                        }
                        i3++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z && i2 != 255) {
                    z2 = true;
                }
            }
            if (z2) {
                this.f5654b.set(0.0f, 0.0f, 0.0f, 0.0f);
                a(this.f5654b, this.f5655c, true);
                this.f5653a.setAlpha(i2);
                h.a(canvas, this.f5654b, this.f5653a);
            }
            if (z2) {
                i2 = PriceRangeSeekBar.INVALID_POINTER_ID;
            }
            for (int size = this.f5660h.size() - 1; size >= 0; size--) {
                c cVar = this.f5660h.get(size);
                if (cVar instanceof e) {
                    ((e) cVar).a(canvas, this.f5655c, i2);
                }
            }
            if (z2) {
                canvas.restore();
            }
        }
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        this.f5655c.set(matrix);
        o oVar = this.k;
        if (oVar != null) {
            this.f5655c.preConcat(oVar.a());
        }
        this.f5657e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f5660h.size() - 1; size >= 0; size--) {
            c cVar = this.f5660h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(this.f5657e, this.f5655c, z);
                rectF.union(this.f5657e);
            }
        }
    }

    public final <T> void a(T t, c<T> cVar) {
        o oVar = this.k;
        if (oVar != null) {
            oVar.a(t, cVar);
        }
    }

    public d(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, n nVar) {
        this(fVar, aVar, nVar.f5896a, nVar.f5898c, a(fVar, aVar, nVar.f5897b), a(nVar.f5897b));
    }

    public final void a(e eVar, int i2, List<e> list, e eVar2) {
        if (eVar.a(this.f5658f, i2)) {
            if (!"__container".equals(this.f5658f)) {
                eVar2 = eVar2.a(this.f5658f);
                if (eVar.c(this.f5658f, i2)) {
                    list.add(eVar2.a((f) this));
                }
            }
            if (eVar.d(this.f5658f, i2)) {
                int b2 = i2 + eVar.b(this.f5658f, i2);
                for (int i3 = 0; i3 < this.f5660h.size(); i3++) {
                    c cVar = this.f5660h.get(i3);
                    if (cVar instanceof f) {
                        ((f) cVar).a(eVar, b2, list, eVar2);
                    }
                }
            }
        }
    }
}
