package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.impl.b;
import androidx.work.impl.j;
import androidx.work.l;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5285a = l.a("SystemJobService");

    /* renamed from: b  reason: collision with root package name */
    private j f5286b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, JobParameters> f5287c = new HashMap();

    public void onCreate() {
        super.onCreate();
        try {
            this.f5286b = j.b(getApplicationContext());
            this.f5286b.f5364f.a((b) this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                l.a();
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        j jVar = this.f5286b;
        if (jVar != null) {
            jVar.f5364f.b((b) this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        r2 = new androidx.work.WorkerParameters.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r7.getTriggeredContentUris() == null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r2.f5052b = java.util.Arrays.asList(r7.getTriggeredContentUris());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r7.getTriggeredContentAuthorities() == null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0068, code lost:
        r2.f5051a = java.util.Arrays.asList(r7.getTriggeredContentAuthorities());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (android.os.Build.VERSION.SDK_INT < 28) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        r2.f5053c = r7.getNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007e, code lost:
        r6.f5286b.a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r7) {
        /*
            r6 = this;
            androidx.work.impl.j r0 = r6.f5286b
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000d
            androidx.work.l.a()
            r6.jobFinished(r7, r1)
            return r2
        L_0x000d:
            java.lang.String r0 = a(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x001b
            androidx.work.l.a()
            return r2
        L_0x001b:
            java.util.Map<java.lang.String, android.app.job.JobParameters> r3 = r6.f5287c
            monitor-enter(r3)
            java.util.Map<java.lang.String, android.app.job.JobParameters> r4 = r6.f5287c     // Catch:{ all -> 0x0084 }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x0034
            androidx.work.l.a()     // Catch:{ all -> 0x0084 }
            java.lang.String r7 = "Job is already being executed by SystemJobService: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0084 }
            r1[r2] = r0     // Catch:{ all -> 0x0084 }
            java.lang.String.format(r7, r1)     // Catch:{ all -> 0x0084 }
            monitor-exit(r3)     // Catch:{ all -> 0x0084 }
            return r2
        L_0x0034:
            androidx.work.l.a()     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = "onStartJob for %s"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0084 }
            r5[r2] = r0     // Catch:{ all -> 0x0084 }
            java.lang.String.format(r4, r5)     // Catch:{ all -> 0x0084 }
            java.util.Map<java.lang.String, android.app.job.JobParameters> r2 = r6.f5287c     // Catch:{ all -> 0x0084 }
            r2.put(r0, r7)     // Catch:{ all -> 0x0084 }
            monitor-exit(r3)     // Catch:{ all -> 0x0084 }
            r2 = 0
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r3 < r4) goto L_0x007e
            androidx.work.WorkerParameters$a r2 = new androidx.work.WorkerParameters$a
            r2.<init>()
            android.net.Uri[] r3 = r7.getTriggeredContentUris()
            if (r3 == 0) goto L_0x0062
            android.net.Uri[] r3 = r7.getTriggeredContentUris()
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.f5052b = r3
        L_0x0062:
            java.lang.String[] r3 = r7.getTriggeredContentAuthorities()
            if (r3 == 0) goto L_0x0072
            java.lang.String[] r3 = r7.getTriggeredContentAuthorities()
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.f5051a = r3
        L_0x0072:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r3 < r4) goto L_0x007e
            android.net.Network r7 = r7.getNetwork()
            r2.f5053c = r7
        L_0x007e:
            androidx.work.impl.j r7 = r6.f5286b
            r7.a((java.lang.String) r0, (androidx.work.WorkerParameters.a) r2)
            return r1
        L_0x0084:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0084 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f5286b == null) {
            l.a();
            return true;
        }
        String a2 = a(jobParameters);
        if (TextUtils.isEmpty(a2)) {
            l.a();
            return false;
        }
        l.a();
        String.format("onStopJob for %s", new Object[]{a2});
        synchronized (this.f5287c) {
            this.f5287c.remove(a2);
        }
        this.f5286b.d(a2);
        if (!this.f5286b.f5364f.e(a2)) {
            return true;
        }
        return false;
    }

    public final void a(String str, boolean z) {
        JobParameters remove;
        l.a();
        String.format("%s executed on JobScheduler", new Object[]{str});
        synchronized (this.f5287c) {
            remove = this.f5287c.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    private static String a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }
}
