package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class f implements AppMeasurement.b {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ d f37991a;

    public f(d dVar) {
        this.f37991a = dVar;
    }

    public final void a(String str, String str2, Bundle bundle, long j) {
        if (str != null && !str.equals("crash") && c.b(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("timestampInMillis", j);
            bundle2.putBundle("params", bundle);
            this.f37991a.f37987a.a(3, bundle2);
        }
    }
}
