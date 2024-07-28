package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.f;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.k;

public final class r extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a f5737c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5738d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f5739e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.a.b.a<Integer, Integer> f5740f;

    /* renamed from: g  reason: collision with root package name */
    private com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> f5741g;

    public final void a(Canvas canvas, Matrix matrix, int i2) {
        if (!this.f5739e) {
            this.f5642b.setColor(((b) this.f5740f).h());
            if (this.f5741g != null) {
                this.f5642b.setColorFilter(this.f5741g.f());
            }
            super.a(canvas, matrix, i2);
        }
    }

    public final String b() {
        return this.f5738d;
    }

    public final <T> void a(T t, c<T> cVar) {
        super.a(t, cVar);
        if (t == k.f6156b) {
            this.f5740f.a(cVar);
        } else if (t == k.C) {
            com.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f5741g;
            if (aVar != null) {
                this.f5737c.b((com.airbnb.lottie.a.b.a<?, ?>) aVar);
            }
            if (cVar == null) {
                this.f5741g = null;
                return;
            }
            this.f5741g = new p(cVar);
            this.f5741g.a((a.C0083a) this);
            this.f5737c.a((com.airbnb.lottie.a.b.a<?, ?>) this.f5740f);
        }
    }

    public r(f fVar, com.airbnb.lottie.c.c.a aVar, com.airbnb.lottie.c.b.p pVar) {
        super(fVar, aVar, pVar.f5909g.toPaintCap(), pVar.f5910h.toPaintJoin(), pVar.f5911i, pVar.f5907e, pVar.f5908f, pVar.f5905c, pVar.f5904b);
        this.f5737c = aVar;
        this.f5738d = pVar.f5903a;
        this.f5739e = pVar.j;
        this.f5740f = pVar.f5906d.a();
        this.f5740f.a((a.C0083a) this);
        aVar.a((com.airbnb.lottie.a.b.a<?, ?>) this.f5740f);
    }
}
