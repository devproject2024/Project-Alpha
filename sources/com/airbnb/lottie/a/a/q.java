package com.airbnb.lottie.a.a;

import android.graphics.Path;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.o;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.f;
import java.util.List;

public final class q implements m, a.C0083a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f5730a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f5731b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5732c;

    /* renamed from: d  reason: collision with root package name */
    private final f f5733d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, Path> f5734e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5735f;

    /* renamed from: g  reason: collision with root package name */
    private b f5736g = new b();

    public q(f fVar, com.airbnb.lottie.c.c.a aVar, o oVar) {
        this.f5731b = oVar.f5899a;
        this.f5732c = oVar.f5901c;
        this.f5733d = fVar;
        this.f5734e = oVar.f5900b.a();
        aVar.a((a<?, ?>) this.f5734e);
        this.f5734e.a((a.C0083a) this);
    }

    public final void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.f5743b == q.a.SIMULTANEOUSLY) {
                    this.f5736g.a(sVar);
                    sVar.a(this);
                }
            }
        }
    }

    public final Path e() {
        if (this.f5735f) {
            return this.f5730a;
        }
        this.f5730a.reset();
        if (this.f5732c) {
            this.f5735f = true;
            return this.f5730a;
        }
        this.f5730a.set(this.f5734e.f());
        this.f5730a.setFillType(Path.FillType.EVEN_ODD);
        this.f5736g.a(this.f5730a);
        this.f5735f = true;
        return this.f5730a;
    }

    public final String b() {
        return this.f5731b;
    }

    public final void a() {
        this.f5735f = false;
        this.f5733d.invalidateSelf();
    }
}
