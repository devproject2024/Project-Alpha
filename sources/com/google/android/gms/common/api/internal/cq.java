package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.s;

public final class cq implements e.b, e.c {

    /* renamed from: a  reason: collision with root package name */
    public final a<?> f8537a;

    /* renamed from: b  reason: collision with root package name */
    cs f8538b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8539c;

    public cq(a<?> aVar, boolean z) {
        this.f8537a = aVar;
        this.f8539c = z;
    }

    public final void onConnected(Bundle bundle) {
        a();
        this.f8538b.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i2) {
        a();
        this.f8538b.onConnectionSuspended(i2);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        a();
        this.f8538b.a(connectionResult, this.f8537a, this.f8539c);
    }

    private final void a() {
        s.a(this.f8538b, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }
}
