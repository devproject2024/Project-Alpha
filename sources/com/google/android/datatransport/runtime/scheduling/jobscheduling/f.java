package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final JobInfoSchedulerService f7913a;

    /* renamed from: b  reason: collision with root package name */
    private final JobParameters f7914b;

    private f(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f7913a = jobInfoSchedulerService;
        this.f7914b = jobParameters;
    }

    public static Runnable a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new f(jobInfoSchedulerService, jobParameters);
    }

    public final void run() {
        this.f7913a.jobFinished(this.f7914b, false);
    }
}
