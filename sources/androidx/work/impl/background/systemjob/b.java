package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.g;
import androidx.work.impl.b.p;
import androidx.work.impl.e;
import androidx.work.impl.j;
import androidx.work.impl.utils.c;
import androidx.work.l;
import androidx.work.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5291a = l.a("SystemJobScheduler");

    /* renamed from: b  reason: collision with root package name */
    private final Context f5292b;

    /* renamed from: c  reason: collision with root package name */
    private final JobScheduler f5293c;

    /* renamed from: d  reason: collision with root package name */
    private final j f5294d;

    /* renamed from: e  reason: collision with root package name */
    private final a f5295e;

    public final boolean a() {
        return true;
    }

    public b(Context context, j jVar) {
        this(context, jVar, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    private b(Context context, j jVar, JobScheduler jobScheduler, a aVar) {
        this.f5292b = context;
        this.f5294d = jVar;
        this.f5293c = jobScheduler;
        this.f5295e = aVar;
    }

    public final void a(p... pVarArr) {
        List<Integer> a2;
        int i2;
        WorkDatabase workDatabase = this.f5294d.f5361c;
        c cVar = new c(workDatabase);
        int length = pVarArr.length;
        int i3 = 0;
        while (i3 < length) {
            p pVar = pVarArr[i3];
            workDatabase.beginTransaction();
            try {
                p b2 = workDatabase.b().b(pVar.f5180a);
                if (b2 == null) {
                    l.a();
                    StringBuilder sb = new StringBuilder("Skipping scheduling ");
                    sb.append(pVar.f5180a);
                    sb.append(" because it's no longer in the DB");
                    workDatabase.setTransactionSuccessful();
                } else if (b2.f5181b != u.a.ENQUEUED) {
                    l.a();
                    StringBuilder sb2 = new StringBuilder("Skipping scheduling ");
                    sb2.append(pVar.f5180a);
                    sb2.append(" because it is no longer enqueued");
                    workDatabase.setTransactionSuccessful();
                } else {
                    g a3 = workDatabase.e().a(pVar.f5180a);
                    int a4 = a3 != null ? a3.f5160b : cVar.a(this.f5294d.f5360b.f5060g, this.f5294d.f5360b.f5061h);
                    if (a3 == null) {
                        this.f5294d.f5361c.e().a(new g(pVar.f5180a, a4));
                    }
                    a(pVar, a4);
                    if (Build.VERSION.SDK_INT == 23 && (a2 = a(this.f5292b, this.f5293c, pVar.f5180a)) != null) {
                        int indexOf = a2.indexOf(Integer.valueOf(a4));
                        if (indexOf >= 0) {
                            a2.remove(indexOf);
                        }
                        if (!a2.isEmpty()) {
                            i2 = a2.get(0).intValue();
                        } else {
                            i2 = cVar.a(this.f5294d.f5360b.f5060g, this.f5294d.f5360b.f5061h);
                        }
                        a(pVar, i2);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                i3++;
            } finally {
                workDatabase.endTransaction();
            }
        }
    }

    private void a(p pVar, int i2) {
        JobInfo a2 = this.f5295e.a(pVar, i2);
        l.a();
        String.format("Scheduling work ID %s Job ID %s", new Object[]{pVar.f5180a, Integer.valueOf(i2)});
        try {
            this.f5293c.schedule(a2);
        } catch (IllegalStateException e2) {
            List<JobInfo> a3 = a(this.f5292b, this.f5293c);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(a3 != null ? a3.size() : 0), Integer.valueOf(this.f5294d.f5361c.b().d().size()), Integer.valueOf(this.f5294d.f5360b.a())});
            l.a();
            throw new IllegalStateException(format, e2);
        } catch (Throwable th) {
            l.a();
            String.format("Unable to schedule %s", new Object[]{pVar});
            new Throwable[1][0] = th;
        }
    }

    public final void a(String str) {
        List<Integer> a2 = a(this.f5292b, this.f5293c, str);
        if (a2 != null && !a2.isEmpty()) {
            for (Integer intValue : a2) {
                a(this.f5293c, intValue.intValue());
            }
            this.f5294d.f5361c.e().b(str);
        }
    }

    private static void a(JobScheduler jobScheduler, int i2) {
        try {
            jobScheduler.cancel(i2);
        } catch (Throwable th) {
            l.a();
            String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i2)});
            new Throwable[1][0] = th;
        }
    }

    public static void a(Context context) {
        List<JobInfo> a2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (a2 = a(context, jobScheduler)) != null && !a2.isEmpty()) {
            for (JobInfo id : a2) {
                a(jobScheduler, id.getId());
            }
        }
    }

    public static void b(Context context) {
        List<JobInfo> a2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (a2 = a(context, jobScheduler)) != null && !a2.isEmpty()) {
            for (JobInfo next : a2) {
                if (a(next) == null) {
                    a(jobScheduler, next.getId());
                }
            }
        }
    }

    private static List<JobInfo> a(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            l.a();
            new Throwable[1][0] = th;
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static List<Integer> a(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> a2 = a(context, jobScheduler);
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo next : a2) {
            if (str.equals(a(next))) {
                arrayList.add(Integer.valueOf(next.getId()));
            }
        }
        return arrayList;
    }

    private static String a(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }
}
