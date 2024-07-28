package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.e.a;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.q;

public class JobInfoSchedulerService extends JobService {
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i2 = jobParameters.getExtras().getInt("priority");
        int i3 = jobParameters.getExtras().getInt("attemptNumber");
        q.a(getApplicationContext());
        l.a a2 = l.d().a(string).a(a.a(i2));
        if (string2 != null) {
            a2.a(Base64.decode(string2, 0));
        }
        q.a().f7801a.a(a2.a(), i3, f.a(this, jobParameters));
        return true;
    }
}
