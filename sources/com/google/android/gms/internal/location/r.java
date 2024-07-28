package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.ap;
import com.google.android.gms.location.e;

final class r extends ap {

    /* renamed from: a  reason: collision with root package name */
    private final k<e> f10394a;

    r(k<e> kVar) {
        this.f10394a = kVar;
    }

    public final synchronized void a(Location location) {
        this.f10394a.a(new s(location));
    }

    public final synchronized void a() {
        this.f10394a.f8617a = null;
    }
}
