package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.d;
import com.google.android.datatransport.runtime.e.a;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.scheduling.a.c;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.g;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

public final class e implements s {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7910a;

    /* renamed from: b  reason: collision with root package name */
    private final c f7911b;

    /* renamed from: c  reason: collision with root package name */
    private final g f7912c;

    public e(Context context, c cVar, g gVar) {
        this.f7910a = context;
        this.f7911b = cVar;
        this.f7912c = gVar;
    }

    private static boolean a(JobScheduler jobScheduler, int i2, int i3) {
        Iterator<JobInfo> it2 = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            JobInfo next = it2.next();
            int i4 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i2) {
                if (i4 >= i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(l lVar, int i2) {
        ComponentName componentName = new ComponentName(this.f7910a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f7910a.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(this.f7910a.getPackageName().getBytes(Charset.forName(AppConstants.UTF_8)));
        adler32.update(lVar.a().getBytes(Charset.forName(AppConstants.UTF_8)));
        adler32.update(ByteBuffer.allocate(4).putInt(a.a(lVar.c())).array());
        if (lVar.b() != null) {
            adler32.update(lVar.b());
        }
        int value = (int) adler32.getValue();
        if (a(jobScheduler, value, i2)) {
            com.google.android.datatransport.runtime.a.a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", (Object) lVar);
            return;
        }
        long a2 = this.f7911b.a(lVar);
        g gVar = this.f7912c;
        JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
        d c2 = lVar.c();
        builder.setMinimumLatency(gVar.a(c2, a2, i2));
        Set<g.c> c3 = gVar.b().get(c2).c();
        if (c3.contains(g.c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (c3.contains(g.c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (c3.contains(g.c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i2);
        persistableBundle.putString("backendName", lVar.a());
        persistableBundle.putInt("priority", a.a(lVar.c()));
        if (lVar.b() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(lVar.b(), 0));
        }
        builder.setExtras(persistableBundle);
        com.google.android.datatransport.runtime.a.a.a("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", lVar, Integer.valueOf(value), Long.valueOf(this.f7912c.a(lVar.c(), a2, i2)), Long.valueOf(a2), Integer.valueOf(i2));
        jobScheduler.schedule(builder.build());
    }
}
