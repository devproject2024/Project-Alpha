package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.iv;
import com.google.android.gms.internal.measurement.jn;

final class jc {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ is f12249a;

    jc(is isVar) {
        this.f12249a = isVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        jn.a();
        if (this.f12249a.H_().d((String) null, o.W)) {
            this.f12249a.h();
            if (this.f12249a.I_().a(this.f12249a.j().a())) {
                this.f12249a.I_().n.a(true);
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    if (runningAppProcessInfo.importance == 100) {
                        this.f12249a.J_().k.a("Detected application was in foreground");
                        b(this.f12249a.j().a(), false);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(long j, boolean z) {
        this.f12249a.h();
        this.f12249a.A();
        if (this.f12249a.I_().a(j)) {
            this.f12249a.I_().n.a(true);
            this.f12249a.I_().s.a(0);
        }
        if (z && this.f12249a.H_().d((String) null, o.R)) {
            this.f12249a.I_().r.a(j);
        }
        if (this.f12249a.I_().n.a()) {
            b(j, z);
        }
    }

    private final void b(long j, boolean z) {
        this.f12249a.h();
        jn.a();
        if (this.f12249a.H_().d((String) null, o.W)) {
            if (this.f12249a.y.r()) {
                this.f12249a.I_().r.a(j);
            } else {
                return;
            }
        }
        this.f12249a.J_().k.a("Session started, time", Long.valueOf(this.f12249a.j().b()));
        Long valueOf = this.f12249a.H_().d((String) null, o.P) ? Long.valueOf(j / 1000) : null;
        this.f12249a.b().a("auto", "_sid", (Object) valueOf, j);
        this.f12249a.I_().n.a(false);
        Bundle bundle = new Bundle();
        if (this.f12249a.H_().d((String) null, o.P)) {
            bundle.putLong("_sid", valueOf.longValue());
        }
        if (this.f12249a.H_().d((String) null, o.aE) && z) {
            bundle.putLong("_aib", 1);
        }
        this.f12249a.b().a("auto", "_s", j, bundle);
        iv.a();
        if (this.f12249a.H_().d((String) null, o.aL)) {
            String a2 = this.f12249a.I_().x.a();
            if (!TextUtils.isEmpty(a2)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", a2);
                this.f12249a.b().a("auto", "_ssr", j, bundle2);
            }
        }
        jn.a();
        if (!this.f12249a.H_().d((String) null, o.W)) {
            this.f12249a.I_().r.a(j);
        }
    }
}
