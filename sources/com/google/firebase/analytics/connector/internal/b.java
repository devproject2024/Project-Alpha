package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.a;
import java.util.HashSet;
import java.util.Set;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    Set<String> f37977a;

    /* renamed from: b  reason: collision with root package name */
    a.b f37978b;

    /* renamed from: c  reason: collision with root package name */
    private AppMeasurement f37979c;

    /* renamed from: d  reason: collision with root package name */
    private e f37980d = new e(this);

    public b(AppMeasurement appMeasurement, a.b bVar) {
        this.f37978b = bVar;
        this.f37979c = appMeasurement;
        this.f37979c.a((AppMeasurement.b) this.f37980d);
        this.f37977a = new HashSet();
    }
}
