package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.dy;
import com.google.android.gms.measurement.internal.fc;
import com.google.android.gms.measurement.internal.fd;
import com.google.android.gms.measurement.internal.il;
import com.google.android.gms.measurement.internal.io;
import com.google.android.gms.measurement.internal.ip;
import com.google.android.gms.measurement.internal.jj;

public final class AppMeasurementService extends Service implements ip {

    /* renamed from: a  reason: collision with root package name */
    private il<AppMeasurementService> f11678a;

    private final il<AppMeasurementService> a() {
        if (this.f11678a == null) {
            this.f11678a = new il<>(this);
        }
        return this.f11678a;
    }

    public final void onCreate() {
        super.onCreate();
        a().a();
    }

    public final void onDestroy() {
        a().b();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        il<AppMeasurementService> a2 = a();
        dy J_ = fc.a((Context) a2.f12213a, (zzv) null).J_();
        if (intent == null) {
            J_.f11831f.a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        J_.k.a("Local AppMeasurementService called. startId, action", Integer.valueOf(i3), action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        a2.a((Runnable) new io(a2, i3, J_, intent));
        return 2;
    }

    public final IBinder onBind(Intent intent) {
        il<AppMeasurementService> a2 = a();
        if (intent == null) {
            a2.c().f11828c.a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new fd(jj.a((Context) a2.f12213a));
        }
        a2.c().f11831f.a("onBind received unknown action", action);
        return null;
    }

    public final boolean onUnbind(Intent intent) {
        return a().a(intent);
    }

    public final void onRebind(Intent intent) {
        a().b(intent);
    }

    public final boolean a(int i2) {
        return stopSelfResult(i2);
    }

    public final void a(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    public final void a(Intent intent) {
        AppMeasurementReceiver.a(intent);
    }
}
