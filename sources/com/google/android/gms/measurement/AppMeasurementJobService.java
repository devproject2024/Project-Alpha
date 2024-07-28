package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.dy;
import com.google.android.gms.measurement.internal.fc;
import com.google.android.gms.measurement.internal.il;
import com.google.android.gms.measurement.internal.in;
import com.google.android.gms.measurement.internal.ip;

public final class AppMeasurementJobService extends JobService implements ip {

    /* renamed from: a  reason: collision with root package name */
    private il<AppMeasurementJobService> f11676a;

    private final il<AppMeasurementJobService> a() {
        if (this.f11676a == null) {
            this.f11676a = new il<>(this);
        }
        return this.f11676a;
    }

    public final void a(Intent intent) {
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final void onCreate() {
        super.onCreate();
        a().a();
    }

    public final void onDestroy() {
        a().b();
        super.onDestroy();
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        il<AppMeasurementJobService> a2 = a();
        dy J_ = fc.a((Context) a2.f12213a, (zzv) null).J_();
        String string = jobParameters.getExtras().getString("action");
        J_.k.a("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        a2.a((Runnable) new in(a2, J_, jobParameters));
        return true;
    }

    public final boolean onUnbind(Intent intent) {
        return a().a(intent);
    }

    public final void onRebind(Intent intent) {
        a().b(intent);
    }

    public final boolean a(int i2) {
        throw new UnsupportedOperationException();
    }

    public final void a(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }
}
