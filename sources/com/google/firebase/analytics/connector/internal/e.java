package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;

final class e implements AppMeasurement.b {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b f37990a;

    public e(b bVar) {
        this.f37990a = bVar;
    }

    public final void a(String str, String str2, Bundle bundle, long j) {
        if (this.f37990a.f37977a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(EventsModuleManager.MODULE_NAME, c.c(str2));
            this.f37990a.f37978b.a(2, bundle2);
        }
    }
}
