package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    a.b f37987a;

    /* renamed from: b  reason: collision with root package name */
    private AppMeasurement f37988b;

    /* renamed from: c  reason: collision with root package name */
    private f f37989c = new f(this);

    public d(AppMeasurement appMeasurement, a.b bVar) {
        this.f37987a = bVar;
        this.f37988b = appMeasurement;
        this.f37988b.a((AppMeasurement.b) this.f37989c);
    }
}
