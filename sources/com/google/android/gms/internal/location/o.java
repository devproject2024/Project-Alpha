package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.d;

final class o implements k.b<d> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ LocationResult f10392a;

    o(LocationResult locationResult) {
        this.f10392a = locationResult;
    }

    public final /* synthetic */ void a(Object obj) {
        ((d) obj).onLocationResult(this.f10392a);
    }
}
