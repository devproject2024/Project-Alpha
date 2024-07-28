package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.d;

final class p implements k.b<d> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ LocationAvailability f10393a;

    p(LocationAvailability locationAvailability) {
        this.f10393a = locationAvailability;
    }

    public final /* synthetic */ void a(Object obj) {
        ((d) obj).onLocationAvailability(this.f10393a);
    }
}
