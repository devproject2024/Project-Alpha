package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.f;

final class bd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f8458a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ f.a f8459b;

    bd(f.a aVar, ConnectionResult connectionResult) {
        this.f8459b = aVar;
        this.f8458a = connectionResult;
    }

    public final void run() {
        this.f8459b.onConnectionFailed(this.f8458a);
    }
}
