package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.er;
import com.google.android.gms.measurement.internal.es;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements es {

    /* renamed from: a  reason: collision with root package name */
    private er f11675a;

    public final void a(Context context, Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f11675a == null) {
            this.f11675a = new er(this);
        }
        this.f11675a.a(context, intent);
    }

    public final BroadcastReceiver.PendingResult a() {
        return goAsync();
    }
}
