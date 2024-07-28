package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.g.n;
import com.google.android.exoplayer2.g.x;

final class g implements n {

    /* renamed from: a  reason: collision with root package name */
    private final x f32488a;

    /* renamed from: b  reason: collision with root package name */
    private final a f32489b;

    /* renamed from: c  reason: collision with root package name */
    private ab f32490c;

    /* renamed from: d  reason: collision with root package name */
    private n f32491d;

    public interface a {
        void a(x xVar);
    }

    public g(a aVar, b bVar) {
        this.f32489b = aVar;
        this.f32488a = new x(bVar);
    }

    public final void a() {
        x xVar = this.f32488a;
        if (!xVar.f32590b) {
            xVar.f32591c = xVar.f32589a.a();
            xVar.f32590b = true;
        }
    }

    public final void b() {
        x xVar = this.f32488a;
        if (xVar.f32590b) {
            xVar.a(xVar.d());
            xVar.f32590b = false;
        }
    }

    public final void a(long j) {
        this.f32488a.a(j);
    }

    public final void a(ab abVar) throws i {
        n nVar;
        n c2 = abVar.c();
        if (c2 != null && c2 != (nVar = this.f32491d)) {
            if (nVar == null) {
                this.f32491d = c2;
                this.f32490c = abVar;
                this.f32491d.a(this.f32488a.f32592d);
                f();
                return;
            }
            throw i.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    public final void b(ab abVar) {
        if (abVar == this.f32490c) {
            this.f32491d = null;
            this.f32490c = null;
        }
    }

    public final long c() {
        if (!g()) {
            return this.f32488a.d();
        }
        f();
        return this.f32491d.d();
    }

    public final long d() {
        if (g()) {
            return this.f32491d.d();
        }
        return this.f32488a.d();
    }

    public final x a(x xVar) {
        n nVar = this.f32491d;
        if (nVar != null) {
            xVar = nVar.a(xVar);
        }
        this.f32488a.a(xVar);
        this.f32489b.a(xVar);
        return xVar;
    }

    public final x e() {
        n nVar = this.f32491d;
        return nVar != null ? nVar.e() : this.f32488a.f32592d;
    }

    private void f() {
        this.f32488a.a(this.f32491d.d());
        x e2 = this.f32491d.e();
        if (!e2.equals(this.f32488a.f32592d)) {
            this.f32488a.a(e2);
            this.f32489b.a(e2);
        }
    }

    private boolean g() {
        ab abVar = this.f32490c;
        if (abVar == null || abVar.u()) {
            return false;
        }
        return this.f32490c.t() || !this.f32490c.g();
    }
}
