package com.travel.bus.busticket.InAppPushNotification;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class CJRNotificationPublisherService extends JobService {

    /* renamed from: a  reason: collision with root package name */
    public static String f21525a = "notification";

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e A[Catch:{ Exception -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f1 A[Catch:{ Exception -> 0x0131 }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r14) {
        /*
            r13 = this;
            java.lang.String r0 = "ur_type"
            java.lang.String r1 = "userDropVerticalList"
            java.lang.String r2 = ""
            r3 = 0
            if (r14 == 0) goto L_0x0131
            android.os.PersistableBundle r14 = r14.getExtras()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r4 = "push_request_code"
            r5 = -1
            int r4 = r14.getInt(r4, r5)     // Catch:{ Exception -> 0x0131 }
            android.content.Context r5 = r13.getApplicationContext()     // Catch:{ Exception -> 0x0131 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Exception -> 0x0131 }
            com.paytm.b.a.a r5 = com.travel.bus.b.a.a(r5)     // Catch:{ Exception -> 0x0131 }
            com.google.gsonhtcfix.f r6 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0131 }
            r6.<init>()     // Catch:{ Exception -> 0x0131 }
            r7 = 1
            java.lang.String r8 = r5.b((java.lang.String) r1, (java.lang.String) r2, (boolean) r7)     // Catch:{ Exception -> 0x0131 }
            com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisherService$1 r9 = new com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisherService$1     // Catch:{ Exception -> 0x0131 }
            r9.<init>()     // Catch:{ Exception -> 0x0131 }
            java.lang.reflect.Type r9 = r9.getType()     // Catch:{ Exception -> 0x0131 }
            java.lang.Object r8 = r6.a((java.lang.String) r8, (java.lang.reflect.Type) r9)     // Catch:{ Exception -> 0x0131 }
            java.util.Set r8 = (java.util.Set) r8     // Catch:{ Exception -> 0x0131 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0131 }
            r9.<init>()     // Catch:{ Exception -> 0x0131 }
            r9.addAll(r8)     // Catch:{ Exception -> 0x0131 }
            r10 = 0
        L_0x0044:
            int r11 = r9.size()     // Catch:{ Exception -> 0x0131 }
            if (r10 >= r11) goto L_0x0069
            java.lang.Object r11 = r9.get(r10)     // Catch:{ Exception -> 0x0131 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ Exception -> 0x0131 }
            int r11 = r11.intValue()     // Catch:{ Exception -> 0x0131 }
            if (r4 != r11) goto L_0x0066
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0131 }
            r8.remove(r9)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r6 = r6.a((java.lang.Object) r8)     // Catch:{ Exception -> 0x0131 }
            r5.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r7)     // Catch:{ Exception -> 0x0131 }
            r1 = 1
            goto L_0x006a
        L_0x0066:
            int r10 = r10 + 1
            goto L_0x0044
        L_0x0069:
            r1 = 0
        L_0x006a:
            if (r1 == 0) goto L_0x0131
            r1 = 10
            if (r4 == r1) goto L_0x007b
            r1 = 11
            if (r4 == r1) goto L_0x007b
            r1 = 12
            if (r4 != r1) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r1 = 0
            goto L_0x007c
        L_0x007b:
            r1 = 1
        L_0x007c:
            if (r1 == 0) goto L_0x00f2
            switch(r4) {
                case 10: goto L_0x0090;
                case 11: goto L_0x0089;
                case 12: goto L_0x0084;
                default: goto L_0x0081;
            }     // Catch:{ Exception -> 0x0131 }
        L_0x0081:
            r1 = r2
            r4 = r1
            goto L_0x0094
        L_0x0084:
            java.lang.String r1 = "flightPushDate"
            java.lang.String r4 = "flightPushCount"
            goto L_0x0094
        L_0x0089:
            java.lang.String r1 = "trainPushDate"
            java.lang.String r4 = "trainPushCount"
            goto L_0x0094
        L_0x0090:
            java.lang.String r1 = "busPushDate"
            java.lang.String r4 = "busPushCount"
        L_0x0094:
            android.content.Context r5 = r13.getApplicationContext()     // Catch:{ Exception -> 0x0131 }
            com.paytm.b.a.a r5 = com.travel.bus.b.a.a(r5)     // Catch:{ Exception -> 0x0131 }
            com.google.gsonhtcfix.f r6 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0131 }
            r6.<init>()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r2 = r5.b((java.lang.String) r1, (java.lang.String) r2, (boolean) r7)     // Catch:{ Exception -> 0x0131 }
            int r8 = r5.b((java.lang.String) r4, (int) r3, (boolean) r7)     // Catch:{ Exception -> 0x0131 }
            r9 = 3
            if (r8 < r9) goto L_0x00de
            com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisherService$2 r8 = new com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisherService$2     // Catch:{ Exception -> 0x0131 }
            r8.<init>()     // Catch:{ Exception -> 0x0131 }
            java.lang.reflect.Type r8 = r8.getType()     // Catch:{ Exception -> 0x0131 }
            java.lang.Object r2 = r6.a((java.lang.String) r2, (java.lang.reflect.Type) r8)     // Catch:{ Exception -> 0x0131 }
            java.util.Date r2 = (java.util.Date) r2     // Catch:{ Exception -> 0x0131 }
            java.util.Date r8 = new java.util.Date     // Catch:{ Exception -> 0x0131 }
            r8.<init>()     // Catch:{ Exception -> 0x0131 }
            long r9 = r8.getTime()     // Catch:{ Exception -> 0x0131 }
            long r11 = r2.getTime()     // Catch:{ Exception -> 0x0131 }
            long r9 = r9 - r11
            r11 = 86400000(0x5265c00, double:4.2687272E-316)
            long r9 = r9 / r11
            r11 = 1
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 < 0) goto L_0x00ef
            r5.a((java.lang.String) r4, (int) r7, (boolean) r7)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r2 = r6.a((java.lang.Object) r8)     // Catch:{ Exception -> 0x0131 }
            r5.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r7)     // Catch:{ Exception -> 0x0131 }
            goto L_0x00ee
        L_0x00de:
            int r8 = r8 + r7
            r5.a((java.lang.String) r4, (int) r8, (boolean) r7)     // Catch:{ Exception -> 0x0131 }
            java.util.Date r2 = new java.util.Date     // Catch:{ Exception -> 0x0131 }
            r2.<init>()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r2 = r6.a((java.lang.Object) r2)     // Catch:{ Exception -> 0x0131 }
            r5.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r7)     // Catch:{ Exception -> 0x0131 }
        L_0x00ee:
            r7 = 0
        L_0x00ef:
            if (r7 == 0) goto L_0x00f2
            return r3
        L_0x00f2:
            android.content.Context r1 = r13.getApplicationContext()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r2 = "notification"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x0131 }
            android.app.NotificationManager r1 = (android.app.NotificationManager) r1     // Catch:{ Exception -> 0x0131 }
            java.lang.String r5 = r14.getString(r0)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r6 = r14.getString(r0)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r0 = "push_message"
            java.lang.String r7 = r14.getString(r0)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r0 = "push_title"
            java.lang.String r8 = r14.getString(r0)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r0 = "utm_source"
            java.lang.String r9 = r14.getString(r0)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r0 = "utm_temd"
            java.lang.String r10 = r14.getString(r0)     // Catch:{ Exception -> 0x0131 }
            android.content.Context r4 = r13.getApplicationContext()     // Catch:{ Exception -> 0x0131 }
            android.app.Notification r14 = com.travel.bus.busticket.InAppPushNotification.a.a(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0131 }
            int r0 = r14.flags     // Catch:{ Exception -> 0x0131 }
            r0 = r0 | 16
            r14.flags = r0     // Catch:{ Exception -> 0x0131 }
            r1.notify(r3, r14)     // Catch:{ Exception -> 0x0131 }
        L_0x0131:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisherService.onStartJob(android.app.job.JobParameters):boolean");
    }
}
