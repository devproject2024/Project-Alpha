package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

final class fl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzan f11975a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzm f11976b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ fd f11977c;

    fl(fd fdVar, zzan zzan, zzm zzm) {
        this.f11977c = fdVar;
        this.f11975a = zzan;
        this.f11976b = zzm;
    }

    public final void run() {
        zzan zzan;
        fd fdVar = this.f11977c;
        zzan zzan2 = this.f11975a;
        zzm zzm = this.f11976b;
        boolean z = false;
        if (!(!"_cmp".equals(zzan2.f12368a) || zzan2.f12369b == null || zzan2.f12369b.f12367a.size() == 0)) {
            String d2 = zzan2.f12369b.d("_cis");
            if (!TextUtils.isEmpty(d2) && (("referrer broadcast".equals(d2) || "referrer API".equals(d2)) && fdVar.f11950a.f12266b.f11945e.d(zzm.f12380a, o.O))) {
                z = true;
            }
        }
        if (z) {
            fdVar.f11950a.J_().f11834i.a("Event has been filtered ", zzan2.toString());
            zzan = new zzan("_cmpx", zzan2.f12369b, zzan2.f12370c, zzan2.f12371d);
        } else {
            zzan = zzan2;
        }
        this.f11977c.f11950a.l();
        this.f11977c.f11950a.a(zzan, this.f11976b);
    }
}
