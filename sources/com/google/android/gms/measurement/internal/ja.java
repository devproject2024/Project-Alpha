package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.jn;

final class ja {

    /* renamed from: a  reason: collision with root package name */
    long f12243a;

    /* renamed from: b  reason: collision with root package name */
    long f12244b;

    /* renamed from: c  reason: collision with root package name */
    final g f12245c = new iz(this, this.f12246d.y);

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ is f12246d;

    public ja(is isVar) {
        this.f12246d = isVar;
        this.f12243a = isVar.j().b();
        this.f12244b = this.f12243a;
    }

    public final boolean a(boolean z, boolean z2) {
        this.f12246d.h();
        this.f12246d.u();
        long b2 = this.f12246d.j().b();
        jn.a();
        if (!this.f12246d.H_().d((String) null, o.aM) || this.f12246d.y.r()) {
            this.f12246d.I_().r.a(this.f12246d.j().a());
        }
        long j = b2 - this.f12243a;
        if (z || j >= 1000) {
            this.f12246d.I_().s.a(j);
            this.f12246d.J_().k.a("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            hl.a(this.f12246d.e().z(), bundle, true);
            if (this.f12246d.H_().d(this.f12246d.c().z(), o.Y)) {
                if (this.f12246d.H_().d((String) null, o.Z)) {
                    if (!z2) {
                        a();
                    }
                } else if (z2) {
                    bundle.putLong("_fr", 1);
                } else {
                    a();
                }
            }
            if (!this.f12246d.H_().d((String) null, o.Z) || !z2) {
                this.f12246d.b().a("auto", "_e", bundle);
            }
            this.f12243a = b2;
            this.f12245c.c();
            this.f12245c.a(Math.max(0, 3600000 - this.f12246d.I_().s.a()));
            return true;
        }
        this.f12246d.J_().k.a("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long a() {
        long b2 = this.f12246d.j().b();
        long j = b2 - this.f12244b;
        this.f12244b = b2;
        return j;
    }
}
