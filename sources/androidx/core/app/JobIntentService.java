package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService extends Service {

    /* renamed from: h  reason: collision with root package name */
    static final Object f2625h = new Object();

    /* renamed from: i  reason: collision with root package name */
    static final HashMap<ComponentName, h> f2626i = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    b f2627a;

    /* renamed from: b  reason: collision with root package name */
    h f2628b;

    /* renamed from: c  reason: collision with root package name */
    a f2629c;

    /* renamed from: d  reason: collision with root package name */
    boolean f2630d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f2631e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f2632f = false;

    /* renamed from: g  reason: collision with root package name */
    final ArrayList<d> f2633g;

    interface b {
        IBinder a();

        e b();
    }

    interface e {
        Intent a();

        void b();
    }

    /* access modifiers changed from: protected */
    public abstract void a(Intent intent);

    static abstract class h {

        /* renamed from: c  reason: collision with root package name */
        final ComponentName f2650c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2651d;

        /* renamed from: e  reason: collision with root package name */
        int f2652e;

        public void a() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Intent intent);

        public void b() {
        }

        public void c() {
        }

        h(ComponentName componentName) {
            this.f2650c = componentName;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            if (!this.f2651d) {
                this.f2651d = true;
                this.f2652e = i2;
            } else if (this.f2652e != i2) {
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.f2652e);
            }
        }
    }

    static final class c extends h {

        /* renamed from: a  reason: collision with root package name */
        boolean f2635a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2636b;

        /* renamed from: f  reason: collision with root package name */
        private final Context f2637f;

        /* renamed from: g  reason: collision with root package name */
        private final PowerManager.WakeLock f2638g;

        /* renamed from: h  reason: collision with root package name */
        private final PowerManager.WakeLock f2639h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f2637f = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            this.f2638g = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f2638g.setReferenceCounted(false);
            this.f2639h = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f2639h.setReferenceCounted(false);
        }

        /* access modifiers changed from: package-private */
        public final void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f2650c);
            if (this.f2637f.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f2635a) {
                        this.f2635a = true;
                        if (!this.f2636b) {
                            this.f2638g.acquire(60000);
                        }
                    }
                }
            }
        }

        public final void a() {
            synchronized (this) {
                this.f2635a = false;
            }
        }

        public final void b() {
            synchronized (this) {
                if (!this.f2636b) {
                    this.f2636b = true;
                    this.f2639h.acquire(600000);
                    this.f2638g.release();
                }
            }
        }

        public final void c() {
            synchronized (this) {
                if (this.f2636b) {
                    if (this.f2635a) {
                        this.f2638g.acquire(60000);
                    }
                    this.f2636b = false;
                    this.f2639h.release();
                }
            }
        }
    }

    static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        final JobIntentService f2643a;

        /* renamed from: b  reason: collision with root package name */
        final Object f2644b = new Object();

        /* renamed from: c  reason: collision with root package name */
        JobParameters f2645c;

        final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f2646a;

            a(JobWorkItem jobWorkItem) {
                this.f2646a = jobWorkItem;
            }

            public final Intent a() {
                return this.f2646a.getIntent();
            }

            public final void b() {
                synchronized (f.this.f2644b) {
                    if (f.this.f2645c != null) {
                        f.this.f2645c.completeWork(this.f2646a);
                    }
                }
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f2643a = jobIntentService;
        }

        public final IBinder a() {
            return getBinder();
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            this.f2645c = jobParameters;
            this.f2643a.a(false);
            return true;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            JobIntentService jobIntentService = this.f2643a;
            if (jobIntentService.f2629c != null) {
                jobIntentService.f2629c.cancel(jobIntentService.f2630d);
            }
            jobIntentService.f2631e = true;
            synchronized (this.f2644b) {
                this.f2645c = null;
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
            r1.getIntent().setExtrasClassLoader(r3.f2643a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            return new androidx.core.app.JobIntentService.f.a(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r1 == null) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.core.app.JobIntentService.e b() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.f2644b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.f2645c     // Catch:{ all -> 0x0027 }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x000a:
                android.app.job.JobParameters r1 = r3.f2645c     // Catch:{ all -> 0x0027 }
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x0027 }
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                if (r1 == 0) goto L_0x0026
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.JobIntentService r2 = r3.f2643a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.JobIntentService$f$a r0 = new androidx.core.app.JobIntentService$f$a
                r0.<init>(r1)
                return r0
            L_0x0026:
                return r2
            L_0x0027:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.f.b():androidx.core.app.JobIntentService$e");
        }
    }

    static final class g extends h {

        /* renamed from: a  reason: collision with root package name */
        private final JobInfo f2648a;

        /* renamed from: b  reason: collision with root package name */
        private final JobScheduler f2649b;

        g(Context context, ComponentName componentName, int i2) {
            super(componentName);
            a(i2);
            this.f2648a = new JobInfo.Builder(i2, this.f2650c).setOverrideDeadline(0).build();
            this.f2649b = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        public final void a(Intent intent) {
            this.f2649b.enqueue(this.f2648a, new JobWorkItem(intent));
        }
    }

    final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        final Intent f2640a;

        /* renamed from: b  reason: collision with root package name */
        final int f2641b;

        d(Intent intent, int i2) {
            this.f2640a = intent;
            this.f2641b = i2;
        }

        public final Intent a() {
            return this.f2640a;
        }

        public final void b() {
            JobIntentService.this.stopSelf(this.f2641b);
        }
    }

    final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onCancelled(Object obj) {
            JobIntentService.this.b();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            JobIntentService.this.b();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            while (true) {
                e a2 = JobIntentService.this.a();
                if (a2 == null) {
                    return null;
                }
                JobIntentService.this.a(a2.a());
                a2.b();
            }
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2633g = null;
        } else {
            this.f2633g = new ArrayList<>();
        }
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2627a = new f(this);
            this.f2628b = null;
            return;
        }
        this.f2627a = null;
        this.f2628b = a((Context) this, new ComponentName(this, getClass()), false, 0);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.f2633g == null) {
            return 2;
        }
        this.f2628b.a();
        synchronized (this.f2633g) {
            ArrayList<d> arrayList = this.f2633g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i3));
            a(true);
        }
        return 3;
    }

    public IBinder onBind(Intent intent) {
        b bVar = this.f2627a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f2633g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2632f = true;
                this.f2628b.c();
            }
        }
    }

    public static void a(Context context, Class<?> cls, int i2, Intent intent) {
        a(context, new ComponentName(context, cls), i2, intent);
    }

    public static void a(Context context, ComponentName componentName, int i2, Intent intent) {
        if (intent != null) {
            synchronized (f2625h) {
                h a2 = a(context, componentName, true, i2);
                a2.a(i2);
                a2.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    private static h a(Context context, ComponentName componentName, boolean z, int i2) {
        h hVar;
        h hVar2 = f2626i.get(componentName);
        if (hVar2 != null) {
            return hVar2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hVar = new c(context, componentName);
        } else if (z) {
            hVar = new g(context, componentName, i2);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        h hVar3 = hVar;
        f2626i.put(componentName, hVar3);
        return hVar3;
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (this.f2629c == null) {
            this.f2629c = new a();
            h hVar = this.f2628b;
            if (hVar != null && z) {
                hVar.b();
            }
            this.f2629c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        ArrayList<d> arrayList = this.f2633g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2629c = null;
                if (this.f2633g != null && this.f2633g.size() > 0) {
                    a(false);
                } else if (!this.f2632f) {
                    this.f2628b.c();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public e a() {
        b bVar = this.f2627a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f2633g) {
            if (this.f2633g.size() <= 0) {
                return null;
            }
            e remove = this.f2633g.remove(0);
            return remove;
        }
    }
}
