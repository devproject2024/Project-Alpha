package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.a.a;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import java.util.Map;

public final class hl extends dc {

    /* renamed from: a  reason: collision with root package name */
    protected hi f12113a;

    /* renamed from: b  reason: collision with root package name */
    volatile hi f12114b;

    /* renamed from: c  reason: collision with root package name */
    hi f12115c;

    /* renamed from: d  reason: collision with root package name */
    final Map<Activity, hi> f12116d = new a();

    /* renamed from: e  reason: collision with root package name */
    private hi f12117e;

    /* renamed from: f  reason: collision with root package name */
    private String f12118f;

    public hl(fc fcVar) {
        super(fcVar);
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }

    public final hi z() {
        u();
        h();
        return this.f12113a;
    }

    public final void a(Activity activity, String str, String str2) {
        if (this.f12114b == null) {
            J_().f11833h.a("setCurrentScreen cannot be called while no activity active");
        } else if (this.f12116d.get(activity) == null) {
            J_().f11833h.a("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = a(activity.getClass().getCanonicalName());
            }
            boolean equals = this.f12114b.f12106b.equals(str2);
            boolean c2 = jq.c(this.f12114b.f12105a, str);
            if (equals && c2) {
                J_().f11833h.a("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                J_().f11833h.a("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                J_().k.a("Setting current screen to name, class", str == null ? "null" : str, str2);
                hi hiVar = new hi(str, str2, L_().c());
                this.f12116d.put(activity, hiVar);
                a(activity, hiVar, true);
            } else {
                J_().f11833h.a("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    private final void a(Activity activity, hi hiVar, boolean z) {
        hi hiVar2 = this.f12114b == null ? this.f12115c : this.f12114b;
        if (hiVar.f12106b == null) {
            hiVar = new hi(hiVar.f12105a, a(activity.getClass().getCanonicalName()), hiVar.f12107c);
        }
        this.f12115c = this.f12114b;
        this.f12114b = hiVar;
        K_().a((Runnable) new hk(this, z, hiVar2, hiVar));
    }

    /* access modifiers changed from: package-private */
    public final void a(hi hiVar, boolean z) {
        a().a(j().b());
        if (s().a(hiVar.f12108d, z)) {
            hiVar.f12108d = false;
        }
    }

    public static void a(hi hiVar, Bundle bundle, boolean z) {
        if (bundle != null && hiVar != null && (!bundle.containsKey("_sc") || z)) {
            if (hiVar.f12105a != null) {
                bundle.putString("_sn", hiVar.f12105a);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", hiVar.f12106b);
            bundle.putLong("_si", hiVar.f12107c);
        } else if (bundle != null && hiVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void a(String str, hi hiVar) {
        h();
        synchronized (this) {
            if (this.f12118f == null || this.f12118f.equals(str) || hiVar != null) {
                this.f12118f = str;
                this.f12117e = hiVar;
            }
        }
    }

    private static String a(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    /* access modifiers changed from: package-private */
    public final hi a(Activity activity) {
        s.a(activity);
        hi hiVar = this.f12116d.get(activity);
        if (hiVar != null) {
            return hiVar;
        }
        hi hiVar2 = new hi((String) null, a(activity.getClass().getCanonicalName()), L_().c());
        this.f12116d.put(activity, hiVar2);
        return hiVar2;
    }

    public final void a(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.f12116d.put(activity, new hi(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void b(Activity activity) {
        a(activity, a(activity), false);
        z a2 = a();
        a2.K_().a((Runnable) new ba(a2, a2.j().b()));
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
}
