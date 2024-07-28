package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.internal.c;

final class ab implements c.b {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ m f8762a;

    ab(m mVar) {
        this.f8762a = mVar;
    }

    public final void a(ConnectionResult connectionResult) {
        this.f8762a.onConnectionFailed(connectionResult);
    }
}
