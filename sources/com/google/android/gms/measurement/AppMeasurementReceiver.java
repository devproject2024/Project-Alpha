package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.er;
import com.google.android.gms.measurement.internal.es;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements es {

    /* renamed from: a  reason: collision with root package name */
    private er f11677a;

    public final void onReceive(Context context, Intent intent) {
        if (this.f11677a == null) {
            this.f11677a = new er(this);
        }
        this.f11677a.a(context, intent);
    }

    public final void a(Context context, Intent intent) {
        a_(context, intent);
    }

    public final BroadcastReceiver.PendingResult a() {
        return goAsync();
    }
}
