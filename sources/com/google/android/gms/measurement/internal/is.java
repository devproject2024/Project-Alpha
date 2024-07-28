package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.hs;
import com.google.android.gms.internal.measurement.jm;

public final class is extends dc {

    /* renamed from: a  reason: collision with root package name */
    Handler f12226a;

    /* renamed from: b  reason: collision with root package name */
    protected jc f12227b = new jc(this);

    /* renamed from: c  reason: collision with root package name */
    protected ja f12228c = new ja(this);

    /* renamed from: d  reason: collision with root package name */
    private it f12229d = new it(this);

    is(fc fcVar) {
        super(fcVar);
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void z() {
        K_().a((Runnable) new ir(this, j().b()));
    }

    /* access modifiers changed from: package-private */
    public final void A() {
        h();
        if (this.f12226a == null) {
            this.f12226a = new hs(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(long j) {
        h();
        A();
        J_().k.a("Activity resumed, time", Long.valueOf(j));
        it itVar = this.f12229d;
        itVar.f12232c.h();
        if (itVar.f12232c.H_().d((String) null, o.aD)) {
            jm.a();
            if (!itVar.f12232c.H_().d(itVar.f12232c.c().z(), o.aQ)) {
                itVar.f12232c.f12226a.removeCallbacks(itVar.f12231b);
            } else if (itVar.f12230a != null) {
                itVar.f12232c.f12226a.removeCallbacks(itVar.f12230a);
            }
        }
        ja jaVar = this.f12228c;
        jaVar.f12246d.h();
        jaVar.f12245c.c();
        jaVar.f12243a = j;
        jaVar.f12244b = jaVar.f12243a;
        jc jcVar = this.f12227b;
        jcVar.f12249a.h();
        if (jcVar.f12249a.y.r()) {
            if (jcVar.f12249a.H_().d((String) null, o.S)) {
                jcVar.f12249a.I_().u.a(false);
            }
            jcVar.a(jcVar.f12249a.j().a(), false);
        }
    }

    public final boolean a(boolean z, boolean z2) {
        return this.f12228c.a(z, z2);
    }

    public final /* bridge */ /* synthetic */ void M_() {
        super.M_();
    }

    public final /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final /* bridge */ /* synthetic */ z a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ ge b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ dr c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ hm d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ hl e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ du r() {
        return super.r();
    }

    public final /* bridge */ /* synthetic */ is s() {
        return super.s();
    }

    public final /* bridge */ /* synthetic */ i i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ e j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ Context k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ dw l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ jq L_() {
        return super.L_();
    }

    public final /* bridge */ /* synthetic */ eu K_() {
        return super.K_();
    }

    public final /* bridge */ /* synthetic */ dy J_() {
        return super.J_();
    }

    public final /* bridge */ /* synthetic */ eh I_() {
        return super.I_();
    }

    public final /* bridge */ /* synthetic */ ke H_() {
        return super.H_();
    }

    static /* synthetic */ void a(is isVar, long j) {
        isVar.h();
        isVar.A();
        isVar.J_().k.a("Activity paused, time", Long.valueOf(j));
        it itVar = isVar.f12229d;
        if (itVar.f12232c.H_().d((String) null, o.aD)) {
            jm.a();
            if (itVar.f12232c.H_().d(itVar.f12232c.c().z(), o.aQ)) {
                itVar.f12230a = new iy(itVar, itVar.f12232c.j().a());
                itVar.f12232c.f12226a.postDelayed(itVar.f12230a, 2000);
            } else {
                itVar.f12232c.f12226a.postDelayed(itVar.f12231b, 2000);
            }
        }
        ja jaVar = isVar.f12228c;
        jaVar.f12245c.c();
        if (jaVar.f12243a != 0) {
            jaVar.f12246d.I_().s.a(jaVar.f12246d.I_().s.a() + (j - jaVar.f12243a));
        }
        jc jcVar = isVar.f12227b;
        if (jcVar.f12249a.H_().d((String) null, o.S)) {
            jcVar.f12249a.I_().u.a(true);
        }
    }
}
