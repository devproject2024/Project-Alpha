package androidx.work.impl.background.systemjob;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.l;
import androidx.work.m;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5288a = l.a("SystemJobInfoConverter");

    /* renamed from: b  reason: collision with root package name */
    private final ComponentName f5289b;

    a(Context context) {
        this.f5289b = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (android.os.Build.VERSION.SDK_INT < 26) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.app.job.JobInfo a(androidx.work.impl.b.p r11, int r12) {
        /*
            r10 = this;
            androidx.work.c r0 = r11.j
            androidx.work.m r1 = r0.f5073b
            int[] r2 = androidx.work.impl.background.systemjob.a.AnonymousClass1.f5290a
            int r3 = r1.ordinal()
            r2 = r2[r3]
            r3 = 26
            r4 = 24
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 0
            r9 = 1
            if (r2 == r9) goto L_0x003c
            if (r2 == r7) goto L_0x0038
            if (r2 == r6) goto L_0x003a
            if (r2 == r5) goto L_0x0026
            r6 = 5
            if (r2 == r6) goto L_0x0021
            goto L_0x002c
        L_0x0021:
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r3) goto L_0x002c
            goto L_0x003d
        L_0x0026:
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r4) goto L_0x002c
            r5 = 3
            goto L_0x003d
        L_0x002c:
            androidx.work.l.a()
            java.lang.Object[] r2 = new java.lang.Object[r9]
            r2[r8] = r1
            java.lang.String r1 = "API version too low. Cannot convert network type value %s"
            java.lang.String.format(r1, r2)
        L_0x0038:
            r5 = 1
            goto L_0x003d
        L_0x003a:
            r5 = 2
            goto L_0x003d
        L_0x003c:
            r5 = 0
        L_0x003d:
            android.os.PersistableBundle r1 = new android.os.PersistableBundle
            r1.<init>()
            java.lang.String r2 = r11.f5180a
            java.lang.String r6 = "EXTRA_WORK_SPEC_ID"
            r1.putString(r6, r2)
            boolean r2 = r11.a()
            java.lang.String r6 = "EXTRA_IS_PERIODIC"
            r1.putBoolean(r6, r2)
            android.app.job.JobInfo$Builder r2 = new android.app.job.JobInfo$Builder
            android.content.ComponentName r6 = r10.f5289b
            r2.<init>(r12, r6)
            android.app.job.JobInfo$Builder r12 = r2.setRequiredNetworkType(r5)
            boolean r2 = r0.f5074c
            android.app.job.JobInfo$Builder r12 = r12.setRequiresCharging(r2)
            boolean r2 = r0.f5075d
            android.app.job.JobInfo$Builder r12 = r12.setRequiresDeviceIdle(r2)
            android.app.job.JobInfo$Builder r12 = r12.setExtras(r1)
            boolean r1 = r0.f5075d
            if (r1 != 0) goto L_0x007f
            androidx.work.a r1 = r11.l
            androidx.work.a r2 = androidx.work.a.LINEAR
            if (r1 != r2) goto L_0x0079
            r1 = 0
            goto L_0x007a
        L_0x0079:
            r1 = 1
        L_0x007a:
            long r5 = r11.m
            r12.setBackoffCriteria(r5, r1)
        L_0x007f:
            long r1 = r11.c()
            long r5 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r5
            r5 = 0
            long r1 = java.lang.Math.max(r1, r5)
            int r11 = android.os.Build.VERSION.SDK_INT
            r7 = 28
            if (r11 > r7) goto L_0x0098
            r12.setMinimumLatency(r1)
            goto L_0x00a3
        L_0x0098:
            int r11 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r11 <= 0) goto L_0x00a0
            r12.setMinimumLatency(r1)
            goto L_0x00a3
        L_0x00a0:
            r12.setImportantWhileForeground(r9)
        L_0x00a3:
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 < r4) goto L_0x00d8
            boolean r11 = r0.a()
            if (r11 == 0) goto L_0x00d8
            androidx.work.d r11 = r0.f5080i
            java.util.Set<androidx.work.d$a> r11 = r11.f5089a
            java.util.Iterator r11 = r11.iterator()
        L_0x00b5:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x00ce
            java.lang.Object r1 = r11.next()
            androidx.work.d$a r1 = (androidx.work.d.a) r1
            boolean r2 = r1.f5091b
            android.app.job.JobInfo$TriggerContentUri r4 = new android.app.job.JobInfo$TriggerContentUri
            android.net.Uri r1 = r1.f5090a
            r4.<init>(r1, r2)
            r12.addTriggerContentUri(r4)
            goto L_0x00b5
        L_0x00ce:
            long r1 = r0.f5078g
            r12.setTriggerContentUpdateDelay(r1)
            long r1 = r0.f5079h
            r12.setTriggerContentMaxDelay(r1)
        L_0x00d8:
            r12.setPersisted(r8)
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 < r3) goto L_0x00e9
            boolean r11 = r0.f5076e
            r12.setRequiresBatteryNotLow(r11)
            boolean r11 = r0.f5077f
            r12.setRequiresStorageNotLow(r11)
        L_0x00e9:
            android.app.job.JobInfo r11 = r12.build()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.a.a(androidx.work.impl.b.p, int):android.app.job.JobInfo");
    }

    /* renamed from: androidx.work.impl.background.systemjob.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5290a = new int[m.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                androidx.work.m[] r0 = androidx.work.m.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5290a = r0
                int[] r0 = f5290a     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.work.m r1 = androidx.work.m.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5290a     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.work.m r1 = androidx.work.m.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f5290a     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.work.m r1 = androidx.work.m.UNMETERED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f5290a     // Catch:{ NoSuchFieldError -> 0x0035 }
                androidx.work.m r1 = androidx.work.m.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f5290a     // Catch:{ NoSuchFieldError -> 0x0040 }
                androidx.work.m r1 = androidx.work.m.METERED     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.a.AnonymousClass1.<clinit>():void");
        }
    }
}
