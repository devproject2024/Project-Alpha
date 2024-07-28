package net.one97.paytm.smartNotification;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class SmartNotificationJobSchedulerService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
