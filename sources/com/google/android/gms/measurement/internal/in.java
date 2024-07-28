package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

public final /* synthetic */ class in implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final il f12215a;

    /* renamed from: b  reason: collision with root package name */
    private final dy f12216b;

    /* renamed from: c  reason: collision with root package name */
    private final JobParameters f12217c;

    public in(il ilVar, dy dyVar, JobParameters jobParameters) {
        this.f12215a = ilVar;
        this.f12216b = dyVar;
        this.f12217c = jobParameters;
    }

    public final void run() {
        il ilVar = this.f12215a;
        dy dyVar = this.f12216b;
        JobParameters jobParameters = this.f12217c;
        dyVar.k.a("AppMeasurementJobService processed last upload request.");
        ((ip) ilVar.f12213a).a(jobParameters);
    }
}
