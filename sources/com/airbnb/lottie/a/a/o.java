package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.c;
import com.airbnb.lottie.c.b.j;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.k;
import java.util.List;

public final class o implements k, m, a.C0083a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f5712a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f5713b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final String f5714c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5715d;

    /* renamed from: e  reason: collision with root package name */
    private final f f5716e;

    /* renamed from: f  reason: collision with root package name */
    private final a<?, PointF> f5717f;

    /* renamed from: g  reason: collision with root package name */
    private final a<?, PointF> f5718g;

    /* renamed from: h  reason: collision with root package name */
    private final a<?, Float> f5719h;

    /* renamed from: i  reason: collision with root package name */
    private b f5720i = new b();
    private boolean j;

    public o(f fVar, com.airbnb.lottie.c.c.a aVar, j jVar) {
        this.f5714c = jVar.f5877a;
        this.f5715d = jVar.f5881e;
        this.f5716e = fVar;
        this.f5717f = jVar.f5878b.a();
        this.f5718g = jVar.f5879c.a();
        this.f5719h = jVar.f5880d.a();
        aVar.a((a<?, ?>) this.f5717f);
        aVar.a((a<?, ?>) this.f5718g);
        aVar.a((a<?, ?>) this.f5719h);
        this.f5717f.a((a.C0083a) this);
        this.f5718g.a((a.C0083a) this);
        this.f5719h.a((a.C0083a) this);
    }

    public final String b() {
        return this.f5714c;
    }

    public final void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.f5743b == q.a.SIMULTANEOUSLY) {
                    this.f5720i.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    public final Path e() {
        float f2;
        if (this.j) {
            return this.f5712a;
        }
        this.f5712a.reset();
        if (this.f5715d) {
            this.j = true;
            return this.f5712a;
        }
        PointF f3 = this.f5718g.f();
        float f4 = f3.x / 2.0f;
        float f5 = f3.y / 2.0f;
        a<?, Float> aVar = this.f5719h;
        if (aVar == null) {
            f2 = 0.0f;
        } else {
            f2 = ((c) aVar).h();
        }
        float min = Math.min(f4, f5);
        if (f2 > min) {
            f2 = min;
        }
        PointF f6 = this.f5717f.f();
        this.f5712a.moveTo(f6.x + f4, (f6.y - f5) + f2);
        this.f5712a.lineTo(f6.x + f4, (f6.y + f5) - f2);
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i2 > 0) {
            float f7 = f2 * 2.0f;
            this.f5713b.set((f6.x + f4) - f7, (f6.y + f5) - f7, f6.x + f4, f6.y + f5);
            this.f5712a.arcTo(this.f5713b, 0.0f, 90.0f, false);
        }
        this.f5712a.lineTo((f6.x - f4) + f2, f6.y + f5);
        if (i2 > 0) {
            float f8 = f2 * 2.0f;
            this.f5713b.set(f6.x - f4, (f6.y + f5) - f8, (f6.x - f4) + f8, f6.y + f5);
            this.f5712a.arcTo(this.f5713b, 90.0f, 90.0f, false);
        }
        this.f5712a.lineTo(f6.x - f4, (f6.y - f5) + f2);
        if (i2 > 0) {
            float f9 = f2 * 2.0f;
            this.f5713b.set(f6.x - f4, f6.y - f5, (f6.x - f4) + f9, (f6.y - f5) + f9);
            this.f5712a.arcTo(this.f5713b, 180.0f, 90.0f, false);
        }
        this.f5712a.lineTo((f6.x + f4) - f2, f6.y - f5);
        if (i2 > 0) {
            float f10 = f2 * 2.0f;
            this.f5713b.set((f6.x + f4) - f10, f6.y - f5, f6.x + f4, (f6.y - f5) + f10);
            this.f5712a.arcTo(this.f5713b, 270.0f, 90.0f, false);
        }
        this.f5712a.close();
        this.f5720i.a(this.f5712a);
        this.j = true;
        return this.f5712a;
    }

    public final void a(e eVar, int i2, List<e> list, e eVar2) {
        g.a(eVar, i2, list, eVar2, this);
    }

    public final <T> void a(T t, com.airbnb.lottie.g.c<T> cVar) {
        if (t == k.f6162h) {
            this.f5718g.a(cVar);
        } else if (t == k.j) {
            this.f5717f.a(cVar);
        } else if (t == k.f6163i) {
            this.f5719h.a(cVar);
        }
    }

    public final void a() {
        this.j = false;
        this.f5716e.invalidateSelf();
    }
}
