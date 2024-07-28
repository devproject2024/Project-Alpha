package com.airbnb.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.f.g;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.k;
import java.util.List;

public final class f implements k, m, a.C0083a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f5662a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f5663b;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.f f5664c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, PointF> f5665d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, PointF> f5666e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.c.b.a f5667f;

    /* renamed from: g  reason: collision with root package name */
    private b f5668g = new b();

    /* renamed from: h  reason: collision with root package name */
    private boolean f5669h;

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, com.airbnb.lottie.c.b.a aVar2) {
        this.f5663b = aVar2.f5836a;
        this.f5664c = fVar;
        this.f5665d = aVar2.f5838c.a();
        this.f5666e = aVar2.f5837b.a();
        this.f5667f = aVar2;
        aVar.a((a<?, ?>) this.f5665d);
        aVar.a((a<?, ?>) this.f5666e);
        this.f5665d.a((a.C0083a) this);
        this.f5666e.a((a.C0083a) this);
    }

    public final void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.f5743b == q.a.SIMULTANEOUSLY) {
                    this.f5668g.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    public final String b() {
        return this.f5663b;
    }

    public final Path e() {
        if (this.f5669h) {
            return this.f5662a;
        }
        this.f5662a.reset();
        if (this.f5667f.f5840e) {
            this.f5669h = true;
            return this.f5662a;
        }
        PointF f2 = this.f5665d.f();
        float f3 = f2.x / 2.0f;
        float f4 = f2.y / 2.0f;
        float f5 = f3 * 0.55228f;
        float f6 = 0.55228f * f4;
        this.f5662a.reset();
        if (this.f5667f.f5839d) {
            float f7 = -f4;
            this.f5662a.moveTo(0.0f, f7);
            float f8 = 0.0f - f5;
            float f9 = -f3;
            float f10 = 0.0f - f6;
            this.f5662a.cubicTo(f8, f7, f9, f10, f9, 0.0f);
            float f11 = f6 + 0.0f;
            float f12 = f7;
            this.f5662a.cubicTo(f9, f11, f8, f4, 0.0f, f4);
            float f13 = f5 + 0.0f;
            this.f5662a.cubicTo(f13, f4, f3, f11, f3, 0.0f);
            this.f5662a.cubicTo(f3, f10, f13, f12, 0.0f, f12);
        } else {
            float f14 = -f4;
            this.f5662a.moveTo(0.0f, f14);
            float f15 = f5 + 0.0f;
            float f16 = 0.0f - f6;
            this.f5662a.cubicTo(f15, f14, f3, f16, f3, 0.0f);
            float f17 = f6 + 0.0f;
            this.f5662a.cubicTo(f3, f17, f15, f4, 0.0f, f4);
            float f18 = 0.0f - f5;
            float f19 = -f3;
            this.f5662a.cubicTo(f18, f4, f19, f17, f19, 0.0f);
            float f20 = f14;
            this.f5662a.cubicTo(f19, f16, f18, f20, 0.0f, f20);
        }
        PointF f21 = this.f5666e.f();
        this.f5662a.offset(f21.x, f21.y);
        this.f5662a.close();
        this.f5668g.a(this.f5662a);
        this.f5669h = true;
        return this.f5662a;
    }

    public final void a(e eVar, int i2, List<e> list, e eVar2) {
        g.a(eVar, i2, list, eVar2, this);
    }

    public final <T> void a(T t, c<T> cVar) {
        if (t == k.f6161g) {
            this.f5665d.a(cVar);
        } else if (t == k.j) {
            this.f5666e.a(cVar);
        }
    }

    public final void a() {
        this.f5669h = false;
        this.f5664c.invalidateSelf();
    }
}
