package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.am;
import com.google.android.gms.location.d;

final class n extends am {

    /* renamed from: a  reason: collision with root package name */
    private final k<d> f10391a;

    n(k<d> kVar) {
        this.f10391a = kVar;
    }

    public final void a(LocationAvailability locationAvailability) {
        this.f10391a.a(new p(locationAvailability));
    }

    public final void a(LocationResult locationResult) {
        this.f10391a.a(new o(locationResult));
    }

    public final synchronized void a() {
        this.f10391a.f8617a = null;
    }
}
