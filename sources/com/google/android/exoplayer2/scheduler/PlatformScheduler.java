package com.google.android.exoplayer2.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;

public final class PlatformScheduler {

    public static final class PlatformSchedulerService extends JobService {
        public final boolean onStopJob(JobParameters jobParameters) {
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00b3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onStartJob(android.app.job.JobParameters r8) {
            /*
                r7 = this;
                android.os.PersistableBundle r0 = r8.getExtras()
                com.google.android.exoplayer2.scheduler.Requirements r1 = new com.google.android.exoplayer2.scheduler.Requirements
                java.lang.String r2 = "requirements"
                int r2 = r0.getInt(r2)
                r1.<init>(r2)
                int r2 = r1.f32779a
                r3 = 1
                r2 = r2 & r3
                r4 = 0
                if (r2 == 0) goto L_0x0018
                r2 = 1
                goto L_0x0019
            L_0x0018:
                r2 = 0
            L_0x0019:
                r5 = 2
                if (r2 == 0) goto L_0x0054
                java.lang.String r2 = "connectivity"
                java.lang.Object r2 = r7.getSystemService(r2)
                android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
                java.lang.Object r6 = com.google.android.exoplayer2.g.a.a(r2)
                android.net.ConnectivityManager r6 = (android.net.ConnectivityManager) r6
                android.net.NetworkInfo r6 = r6.getActiveNetworkInfo()
                if (r6 == 0) goto L_0x004f
                boolean r6 = r6.isConnected()
                if (r6 == 0) goto L_0x004f
                boolean r6 = com.google.android.exoplayer2.scheduler.Requirements.a((android.net.ConnectivityManager) r2)
                if (r6 != 0) goto L_0x003d
                goto L_0x004f
            L_0x003d:
                int r6 = r1.f32779a
                r6 = r6 & r5
                if (r6 == 0) goto L_0x0044
                r6 = 1
                goto L_0x0045
            L_0x0044:
                r6 = 0
            L_0x0045:
                if (r6 == 0) goto L_0x0054
                boolean r2 = r2.isActiveNetworkMetered()
                if (r2 == 0) goto L_0x0054
                r2 = 2
                goto L_0x0055
            L_0x004f:
                int r2 = r1.f32779a
                r2 = r2 & 3
                goto L_0x0055
            L_0x0054:
                r2 = 0
            L_0x0055:
                int r5 = r1.f32779a
                r5 = r5 & 8
                if (r5 == 0) goto L_0x005d
                r5 = 1
                goto L_0x005e
            L_0x005d:
                r5 = 0
            L_0x005e:
                if (r5 == 0) goto L_0x0068
                boolean r5 = com.google.android.exoplayer2.scheduler.Requirements.a((android.content.Context) r7)
                if (r5 != 0) goto L_0x0068
                r2 = r2 | 8
            L_0x0068:
                int r1 = r1.f32779a
                r1 = r1 & 4
                if (r1 == 0) goto L_0x0070
                r1 = 1
                goto L_0x0071
            L_0x0070:
                r1 = 0
            L_0x0071:
                if (r1 == 0) goto L_0x007b
                boolean r1 = com.google.android.exoplayer2.scheduler.Requirements.b(r7)
                if (r1 != 0) goto L_0x007b
                r2 = r2 | 4
            L_0x007b:
                if (r2 != 0) goto L_0x007f
                r1 = 1
                goto L_0x0080
            L_0x007f:
                r1 = 0
            L_0x0080:
                if (r1 == 0) goto L_0x00b3
                java.lang.String r8 = "service_action"
                java.lang.String r8 = r0.getString(r8)
                java.lang.String r1 = "service_package"
                java.lang.String r0 = r0.getString(r1)
                android.content.Intent r1 = new android.content.Intent
                java.lang.Object r2 = com.google.android.exoplayer2.g.a.a(r8)
                java.lang.String r2 = (java.lang.String) r2
                r1.<init>(r2)
                android.content.Intent r1 = r1.setPackage(r0)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "Starting service action: "
                r2.<init>(r3)
                r2.append(r8)
                java.lang.String r8 = " package: "
                r2.append(r8)
                r2.append(r0)
                com.google.android.exoplayer2.g.ae.a((android.content.Context) r7, (android.content.Intent) r1)
                goto L_0x00b6
            L_0x00b3:
                r7.jobFinished(r8, r3)
            L_0x00b6:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.scheduler.PlatformScheduler.PlatformSchedulerService.onStartJob(android.app.job.JobParameters):boolean");
        }
    }
}
