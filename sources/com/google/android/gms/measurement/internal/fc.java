package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.c.c;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.internal.measurement.bd;
import com.google.android.gms.internal.measurement.iv;
import com.google.android.gms.internal.measurement.zzv;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class fc implements fv {
    private static volatile fc l;
    private boolean A = false;
    private Boolean B;
    private long C;
    private volatile Boolean D;
    private Boolean E;
    private Boolean F;
    private AtomicInteger G = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    final String f11941a;

    /* renamed from: b  reason: collision with root package name */
    final String f11942b;

    /* renamed from: c  reason: collision with root package name */
    final String f11943c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f11944d;

    /* renamed from: e  reason: collision with root package name */
    final ke f11945e;

    /* renamed from: f  reason: collision with root package name */
    final dy f11946f;

    /* renamed from: g  reason: collision with root package name */
    final eu f11947g;

    /* renamed from: h  reason: collision with root package name */
    final ge f11948h;

    /* renamed from: i  reason: collision with root package name */
    em f11949i;
    int j;
    final long k;
    private final Context m;
    private final kd n;
    private final eh o;
    private final is p;
    private final jq q;
    private final dw r;
    private final e s;
    private final hl t;
    private final z u;
    private final hb v;
    private du w;
    private hm x;
    private i y;
    private dr z;

    private fc(gf gfVar) {
        s.a(gfVar);
        this.n = new kd();
        Cdo.f11804a = this.n;
        this.m = gfVar.f12022a;
        this.f11941a = gfVar.f12023b;
        this.f11942b = gfVar.f12024c;
        this.f11943c = gfVar.f12025d;
        this.f11944d = gfVar.f12029h;
        this.D = gfVar.f12026e;
        zzv zzv = gfVar.f12028g;
        if (!(zzv == null || zzv.f10965g == null)) {
            Object obj = zzv.f10965g.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.E = (Boolean) obj;
            }
            Object obj2 = zzv.f10965g.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.F = (Boolean) obj2;
            }
        }
        bd.a(this.m);
        this.s = h.d();
        this.k = this.s.a();
        this.f11945e = new ke(this);
        eh ehVar = new eh(this);
        ehVar.x();
        this.o = ehVar;
        dy dyVar = new dy(this);
        dyVar.x();
        this.f11946f = dyVar;
        jq jqVar = new jq(this);
        jqVar.x();
        this.q = jqVar;
        dw dwVar = new dw(this);
        dwVar.x();
        this.r = dwVar;
        this.u = new z(this);
        hl hlVar = new hl(this);
        hlVar.v();
        this.t = hlVar;
        ge geVar = new ge(this);
        geVar.v();
        this.f11948h = geVar;
        is isVar = new is(this);
        isVar.v();
        this.p = isVar;
        hb hbVar = new hb(this);
        hbVar.x();
        this.v = hbVar;
        eu euVar = new eu(this);
        euVar.x();
        this.f11947g = euVar;
        boolean z2 = !((gfVar.f12028g == null || gfVar.f12028g.f10960b == 0) ? false : true);
        if (this.m.getApplicationContext() instanceof Application) {
            ge d2 = d();
            if (d2.k().getApplicationContext() instanceof Application) {
                Application application = (Application) d2.k().getApplicationContext();
                if (d2.f12016a == null) {
                    d2.f12016a = new ha(d2, (byte) 0);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(d2.f12016a);
                    application.registerActivityLifecycleCallbacks(d2.f12016a);
                    d2.J_().k.a("Registered activity lifecycle callback");
                }
            }
        } else {
            J_().f11831f.a("Application context is not an Application");
        }
        this.f11947g.a((Runnable) new fe(this, gfVar));
    }

    /* access modifiers changed from: protected */
    public final void a() {
        K_().h();
        if (b().f11861d.a() == 0) {
            b().f11861d.a(this.s.a());
        }
        if (b().f11866i.a() == 0) {
            J_().k.a("Persisting first open", Long.valueOf(this.k));
            b().f11866i.a(this.k);
        }
        if (u()) {
            if (!TextUtils.isEmpty(m().A()) || !TextUtils.isEmpty(m().B())) {
                e();
                if (jq.a(m().A(), b().d(), m().B(), b().e())) {
                    J_().f11834i.a("Rechecking which service to use due to a GMP App Id change");
                    b().s();
                    g().z();
                    this.x.F();
                    this.x.E();
                    b().f11866i.a(this.k);
                    b().k.a((String) null);
                }
                b().c(m().A());
                b().d(m().B());
            }
            d().a(b().k.a());
            iv.a();
            if (this.f11945e.d((String) null, o.aL) && !e().u() && !TextUtils.isEmpty(b().x.a())) {
                J_().f11831f.a("Remote config removed with active feature rollouts");
                b().x.a((String) null);
            }
            if (!TextUtils.isEmpty(m().A()) || !TextUtils.isEmpty(m().B())) {
                boolean r2 = r();
                if (!b().f11859b.contains("deferred_analytics_collection") && !this.f11945e.b()) {
                    b().c(!r2);
                }
                if (r2) {
                    d().C();
                }
                c().f12227b.a();
                i().a((AtomicReference<String>) new AtomicReference());
            }
        } else if (r()) {
            if (!e().d("android.permission.INTERNET")) {
                J_().f11828c.a("App is missing INTERNET permission");
            }
            if (!e().d("android.permission.ACCESS_NETWORK_STATE")) {
                J_().f11828c.a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!c.a(this.m).a() && !this.f11945e.s()) {
                if (!er.a(this.m)) {
                    J_().f11828c.a("AppMeasurementReceiver not registered/enabled");
                }
                if (!jq.a(this.m)) {
                    J_().f11828c.a("AppMeasurementService not registered/enabled");
                }
            }
            J_().f11828c.a("Uploading is not possible. App measurement disabled");
        }
        b().p.a(this.f11945e.d((String) null, o.ah));
        b().q.a(this.f11945e.d((String) null, o.ai));
    }

    public final eh b() {
        a((ft) this.o);
        return this.o;
    }

    public final dy J_() {
        a((fw) this.f11946f);
        return this.f11946f;
    }

    public final eu K_() {
        a((fw) this.f11947g);
        return this.f11947g;
    }

    public final is c() {
        a((dc) this.p);
        return this.p;
    }

    public final ge d() {
        a((dc) this.f11948h);
        return this.f11948h;
    }

    public final jq e() {
        a((ft) this.q);
        return this.q;
    }

    public final dw f() {
        a((ft) this.r);
        return this.r;
    }

    public final du g() {
        a((dc) this.w);
        return this.w;
    }

    private final hb w() {
        a((fw) this.v);
        return this.v;
    }

    public final Context k() {
        return this.m;
    }

    public final e j() {
        return this.s;
    }

    public final hl h() {
        a((dc) this.t);
        return this.t;
    }

    public final hm i() {
        a((dc) this.x);
        return this.x;
    }

    public final i l() {
        a((fw) this.y);
        return this.y;
    }

    public final dr m() {
        a((dc) this.z);
        return this.z;
    }

    public final z p() {
        z zVar = this.u;
        if (zVar != null) {
            return zVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public static fc a(Context context, Bundle bundle) {
        return a(context, new zzv(0, 0, true, (String) null, (String) null, (String) null, bundle));
    }

    public static fc a(Context context, zzv zzv) {
        if (zzv != null && (zzv.f10963e == null || zzv.f10964f == null)) {
            zzv = new zzv(zzv.f10959a, zzv.f10960b, zzv.f10961c, zzv.f10962d, (String) null, (String) null, zzv.f10965g);
        }
        s.a(context);
        s.a(context.getApplicationContext());
        if (l == null) {
            synchronized (fc.class) {
                if (l == null) {
                    l = new fc(new gf(context, zzv));
                }
            }
        } else if (!(zzv == null || zzv.f10965g == null || !zzv.f10965g.containsKey("dataCollectionDefaultEnabled"))) {
            l.a(zzv.f10965g.getBoolean("dataCollectionDefaultEnabled"));
        }
        return l;
    }

    private final void x() {
        if (!this.A) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private static void a(fw fwVar) {
        if (fwVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!fwVar.v()) {
            String valueOf = String.valueOf(fwVar.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void a(dc dcVar) {
        if (dcVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!dcVar.t()) {
            String valueOf = String.valueOf(dcVar.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void a(ft ftVar) {
        if (ftVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        this.D = Boolean.valueOf(z2);
    }

    public final boolean q() {
        return this.D != null && this.D.booleanValue();
    }

    public final boolean r() {
        K_().h();
        x();
        if (this.f11945e.b()) {
            return false;
        }
        Boolean bool = this.F;
        if (bool != null && bool.booleanValue()) {
            return false;
        }
        Boolean t2 = b().t();
        if (t2 != null) {
            return t2.booleanValue();
        }
        Boolean b2 = this.f11945e.b("firebase_analytics_collection_enabled");
        if (b2 != null) {
            return b2.booleanValue();
        }
        Boolean bool2 = this.E;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (g.b()) {
            return false;
        }
        if (!this.f11945e.d((String) null, o.X) || this.D == null) {
            return true;
        }
        return this.D.booleanValue();
    }

    static void s() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    public final void t() {
        this.G.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        x();
        K_().h();
        Boolean bool = this.B;
        if (bool == null || this.C == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.s.b() - this.C) > 1000)) {
            this.C = this.s.b();
            boolean z2 = true;
            this.B = Boolean.valueOf(e().d("android.permission.INTERNET") && e().d("android.permission.ACCESS_NETWORK_STATE") && (c.a(this.m).a() || this.f11945e.s() || (er.a(this.m) && jq.a(this.m))));
            if (this.B.booleanValue()) {
                if (!e().a(m().A(), m().B(), m().C()) && TextUtils.isEmpty(m().B())) {
                    z2 = false;
                }
                this.B = Boolean.valueOf(z2);
            }
        }
        return this.B.booleanValue();
    }

    public final void v() {
        K_().h();
        a((fw) w());
        String z2 = m().z();
        Pair<String, Boolean> a2 = b().a(z2);
        if (!this.f11945e.c().booleanValue() || ((Boolean) a2.second).booleanValue() || TextUtils.isEmpty((CharSequence) a2.first)) {
            J_().j.a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        } else if (!w().c()) {
            J_().f11831f.a("Network is not available for Deferred Deep Link request. Skipping");
        } else {
            jq e2 = e();
            m();
            URL a3 = e2.a(z2, (String) a2.first, b().w.a() - 1);
            hb w2 = w();
            fa faVar = new fa(this);
            w2.h();
            w2.w();
            s.a(a3);
            s.a(faVar);
            w2.K_().b((Runnable) new he(w2, z2, a3, faVar));
        }
    }

    static /* synthetic */ void a(fc fcVar, gf gfVar) {
        String str;
        ea eaVar;
        fcVar.K_().h();
        i iVar = new i(fcVar);
        iVar.x();
        fcVar.y = iVar;
        dr drVar = new dr(fcVar, gfVar.f12027f);
        drVar.v();
        fcVar.z = drVar;
        du duVar = new du(fcVar);
        duVar.v();
        fcVar.w = duVar;
        hm hmVar = new hm(fcVar);
        hmVar.v();
        fcVar.x = hmVar;
        fcVar.q.y();
        fcVar.o.y();
        fcVar.f11949i = new em(fcVar);
        fcVar.z.w();
        fcVar.J_().f11834i.a("App measurement is starting up, version", 19000L);
        fcVar.J_().f11834i.a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String z2 = drVar.z();
        if (TextUtils.isEmpty(fcVar.f11941a)) {
            if (fcVar.e().f(z2)) {
                eaVar = fcVar.J_().f11834i;
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                eaVar = fcVar.J_().f11834i;
                String valueOf = String.valueOf(z2);
                str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
            }
            eaVar.a(str);
        }
        fcVar.J_().j.a("Debug-level message logging enabled");
        if (fcVar.j != fcVar.G.get()) {
            fcVar.J_().f11828c.a("Not all components initialized", Integer.valueOf(fcVar.j), Integer.valueOf(fcVar.G.get()));
        }
        fcVar.A = true;
    }
}
