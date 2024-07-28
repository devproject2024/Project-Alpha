package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.a.a;
import com.google.android.gms.common.util.e;
import java.util.Map;

public final class z extends eb {

    /* renamed from: a  reason: collision with root package name */
    final Map<String, Long> f12364a = new a();

    /* renamed from: b  reason: collision with root package name */
    final Map<String, Integer> f12365b = new a();

    /* renamed from: c  reason: collision with root package name */
    long f12366c;

    public z(fc fcVar) {
        super(fcVar);
    }

    public final void a(String str, long j) {
        if (str == null || str.length() == 0) {
            J_().f11828c.a("Ad unit id must be a non-empty string");
        } else {
            K_().a((Runnable) new a(this, str, j));
        }
    }

    public final void b(String str, long j) {
        if (str == null || str.length() == 0) {
            J_().f11828c.a("Ad unit id must be a non-empty string");
        } else {
            K_().a((Runnable) new cb(this, str, j));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(long j, hi hiVar) {
        if (hiVar == null) {
            J_().k.a("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            J_().k.a("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            hl.a(hiVar, bundle, true);
            b().a("am", "_xa", bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, long j, hi hiVar) {
        if (hiVar == null) {
            J_().k.a("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            J_().k.a("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            hl.a(hiVar, bundle, true);
            b().a("am", "_xu", bundle);
        }
    }

    public final void a(long j) {
        hi z = e().z();
        for (String next : this.f12364a.keySet()) {
            a(next, j - this.f12364a.get(next).longValue(), z);
        }
        if (!this.f12364a.isEmpty()) {
            a(j - this.f12366c, z);
        }
        b(j);
    }

    /* access modifiers changed from: package-private */
    public final void b(long j) {
        for (String put : this.f12364a.keySet()) {
            this.f12364a.put(put, Long.valueOf(j));
        }
        if (!this.f12364a.isEmpty()) {
            this.f12366c = j;
        }
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
