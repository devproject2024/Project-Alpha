package net.one97.paytm.InAppPushNotification;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class CJRNotificationPublisherService extends JobService {

    /* renamed from: a  reason: collision with root package name */
    public static String f51855a = "notification";

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087 A[Catch:{ Exception -> 0x01a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0106 A[Catch:{ Exception -> 0x01a5 }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(android.app.job.JobParameters r15) {
        /*
            r14 = this;
            java.lang.String r0 = "ur_type"
            java.lang.String r1 = "userDropVerticalList"
            java.lang.String r2 = ""
            r3 = 0
            if (r15 == 0) goto L_0x01a5
            android.os.PersistableBundle r15 = r15.getExtras()     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r4 = "push_request_code"
            r5 = -1
            int r4 = r15.getInt(r4, r5)     // Catch:{ Exception -> 0x01a5 }
            android.content.Context r5 = r14.getApplicationContext()     // Catch:{ Exception -> 0x01a5 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Exception -> 0x01a5 }
            com.paytm.b.a.a r5 = net.one97.paytm.utils.ag.a(r5)     // Catch:{ Exception -> 0x01a5 }
            com.google.gson.f r6 = new com.google.gson.f     // Catch:{ Exception -> 0x01a5 }
            r6.<init>()     // Catch:{ Exception -> 0x01a5 }
            r7 = 1
            java.lang.String r8 = r5.b((java.lang.String) r1, (java.lang.String) r2, (boolean) r7)     // Catch:{ Exception -> 0x01a5 }
            boolean r9 = r8.equals(r2)     // Catch:{ Exception -> 0x01a5 }
            r10 = 0
            if (r9 == 0) goto L_0x0034
            r8 = r10
        L_0x0034:
            net.one97.paytm.InAppPushNotification.CJRNotificationPublisherService$1 r9 = new net.one97.paytm.InAppPushNotification.CJRNotificationPublisherService$1     // Catch:{ Exception -> 0x01a5 }
            r9.<init>()     // Catch:{ Exception -> 0x01a5 }
            java.lang.reflect.Type r9 = r9.getType()     // Catch:{ Exception -> 0x01a5 }
            java.lang.Object r8 = r6.a((java.lang.String) r8, (java.lang.reflect.Type) r9)     // Catch:{ Exception -> 0x01a5 }
            java.util.Set r8 = (java.util.Set) r8     // Catch:{ Exception -> 0x01a5 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x01a5 }
            r9.<init>()     // Catch:{ Exception -> 0x01a5 }
            r9.addAll(r8)     // Catch:{ Exception -> 0x01a5 }
            r11 = 0
        L_0x004c:
            int r12 = r9.size()     // Catch:{ Exception -> 0x01a5 }
            if (r11 >= r12) goto L_0x0071
            java.lang.Object r12 = r9.get(r11)     // Catch:{ Exception -> 0x01a5 }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ Exception -> 0x01a5 }
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x01a5 }
            if (r4 != r12) goto L_0x006e
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x01a5 }
            r8.remove(r9)     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r6 = r6.b(r8)     // Catch:{ Exception -> 0x01a5 }
            r5.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r7)     // Catch:{ Exception -> 0x01a5 }
            r1 = 1
            goto L_0x0072
        L_0x006e:
            int r11 = r11 + 1
            goto L_0x004c
        L_0x0071:
            r1 = 0
        L_0x0072:
            if (r1 == 0) goto L_0x01a5
            r1 = 10
            if (r4 == r1) goto L_0x0083
            r1 = 11
            if (r4 == r1) goto L_0x0083
            r1 = 12
            if (r4 != r1) goto L_0x0081
            goto L_0x0083
        L_0x0081:
            r1 = 0
            goto L_0x0084
        L_0x0083:
            r1 = 1
        L_0x0084:
            r5 = 3
            if (r1 == 0) goto L_0x0107
            android.content.Context r1 = r14.getApplicationContext()     // Catch:{ Exception -> 0x01a5 }
            switch(r4) {
                case 10: goto L_0x009d;
                case 11: goto L_0x0096;
                case 12: goto L_0x0091;
                default: goto L_0x008e;
            }     // Catch:{ Exception -> 0x01a5 }
        L_0x008e:
            r4 = r2
            r6 = r4
            goto L_0x00a1
        L_0x0091:
            java.lang.String r4 = "flightPushDate"
            java.lang.String r6 = "flightPushCount"
            goto L_0x00a1
        L_0x0096:
            java.lang.String r4 = "trainPushDate"
            java.lang.String r6 = "trainPushCount"
            goto L_0x00a1
        L_0x009d:
            java.lang.String r4 = "busPushDate"
            java.lang.String r6 = "busPushCount"
        L_0x00a1:
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ Exception -> 0x01a5 }
            com.paytm.b.a.a r1 = net.one97.paytm.utils.ag.a(r1)     // Catch:{ Exception -> 0x01a5 }
            com.google.gson.f r8 = new com.google.gson.f     // Catch:{ Exception -> 0x01a5 }
            r8.<init>()     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r9 = r1.b((java.lang.String) r4, (java.lang.String) r2, (boolean) r7)     // Catch:{ Exception -> 0x01a5 }
            boolean r2 = r9.equals(r2)     // Catch:{ Exception -> 0x01a5 }
            if (r2 == 0) goto L_0x00b9
            r9 = r10
        L_0x00b9:
            int r2 = r1.b((java.lang.String) r6, (int) r3, (boolean) r7)     // Catch:{ Exception -> 0x01a5 }
            if (r2 < r5) goto L_0x00f3
            net.one97.paytm.InAppPushNotification.CJRNotificationPublisherService$2 r2 = new net.one97.paytm.InAppPushNotification.CJRNotificationPublisherService$2     // Catch:{ Exception -> 0x01a5 }
            r2.<init>()     // Catch:{ Exception -> 0x01a5 }
            java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x01a5 }
            java.lang.Object r2 = r8.a((java.lang.String) r9, (java.lang.reflect.Type) r2)     // Catch:{ Exception -> 0x01a5 }
            java.util.Date r2 = (java.util.Date) r2     // Catch:{ Exception -> 0x01a5 }
            java.util.Date r9 = new java.util.Date     // Catch:{ Exception -> 0x01a5 }
            r9.<init>()     // Catch:{ Exception -> 0x01a5 }
            long r10 = r9.getTime()     // Catch:{ Exception -> 0x01a5 }
            long r12 = r2.getTime()     // Catch:{ Exception -> 0x01a5 }
            long r10 = r10 - r12
            r12 = 86400000(0x5265c00, double:4.2687272E-316)
            long r10 = r10 / r12
            r12 = 1
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 < 0) goto L_0x00f1
            r1.a((java.lang.String) r6, (int) r7, (boolean) r7)     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r2 = r8.b(r9)     // Catch:{ Exception -> 0x01a5 }
            r1.a((java.lang.String) r4, (java.lang.String) r2, (boolean) r7)     // Catch:{ Exception -> 0x01a5 }
            goto L_0x0103
        L_0x00f1:
            r1 = 1
            goto L_0x0104
        L_0x00f3:
            int r2 = r2 + r7
            r1.a((java.lang.String) r6, (int) r2, (boolean) r7)     // Catch:{ Exception -> 0x01a5 }
            java.util.Date r2 = new java.util.Date     // Catch:{ Exception -> 0x01a5 }
            r2.<init>()     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r2 = r8.b(r2)     // Catch:{ Exception -> 0x01a5 }
            r1.a((java.lang.String) r4, (java.lang.String) r2, (boolean) r7)     // Catch:{ Exception -> 0x01a5 }
        L_0x0103:
            r1 = 0
        L_0x0104:
            if (r1 == 0) goto L_0x0107
            return r3
        L_0x0107:
            android.content.Context r1 = r14.getApplicationContext()     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r2 = "notification"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x01a5 }
            android.app.NotificationManager r1 = (android.app.NotificationManager) r1     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r2 = r15.getString(r0)     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r0 = r15.getString(r0)     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r4 = "push_message"
            java.lang.String r4 = r15.getString(r4)     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r6 = "push_title"
            java.lang.String r6 = r15.getString(r6)     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r8 = "utm_source"
            java.lang.String r8 = r15.getString(r8)     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r9 = "utm_temd"
            java.lang.String r15 = r15.getString(r9)     // Catch:{ Exception -> 0x01a5 }
            android.content.Context r9 = r14.getApplicationContext()     // Catch:{ Exception -> 0x01a5 }
            android.content.res.Resources r10 = r9.getResources()     // Catch:{ Exception -> 0x01a5 }
            r11 = 2131232370(0x7f080672, float:1.8080847E38)
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeResource(r10, r11)     // Catch:{ Exception -> 0x01a5 }
            androidx.core.app.h$c r11 = new androidx.core.app.h$c     // Catch:{ Exception -> 0x01a5 }
            r11.<init>()     // Catch:{ Exception -> 0x01a5 }
            android.text.Spanned r12 = android.text.Html.fromHtml(r4)     // Catch:{ Exception -> 0x01a5 }
            androidx.core.app.h$c r11 = r11.a((java.lang.CharSequence) r12)     // Catch:{ Exception -> 0x01a5 }
            android.content.Intent r12 = new android.content.Intent     // Catch:{ Exception -> 0x01a5 }
            java.lang.Class<net.one97.paytm.landingpage.activity.AJRMainActivity> r13 = net.one97.paytm.landingpage.activity.AJRMainActivity.class
            r12.<init>(r9, r13)     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r13 = "android.intent.action.MAIN"
            r12.setAction(r13)     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r13 = "android.intent.category.LAUNCHER"
            r12.addCategory(r13)     // Catch:{ Exception -> 0x01a5 }
            r13 = 872415232(0x34000000, float:1.1920929E-7)
            r12.setFlags(r13)     // Catch:{ Exception -> 0x01a5 }
            android.net.Uri r15 = net.one97.paytm.InAppPushNotification.a.a(r2, r0, r8, r15)     // Catch:{ Exception -> 0x01a5 }
            r12.setData(r15)     // Catch:{ Exception -> 0x01a5 }
            java.lang.String r15 = "push_notification"
            r12.putExtra(r15, r3)     // Catch:{ Exception -> 0x01a5 }
            android.app.PendingIntent r15 = android.app.PendingIntent.getActivity(r9, r3, r12, r3)     // Catch:{ Exception -> 0x01a5 }
            androidx.core.app.h$e r0 = new androidx.core.app.h$e     // Catch:{ Exception -> 0x01a5 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x01a5 }
            r0.a((boolean) r7)     // Catch:{ Exception -> 0x01a5 }
            r0.a((java.lang.CharSequence) r6)     // Catch:{ Exception -> 0x01a5 }
            r0.b((java.lang.CharSequence) r4)     // Catch:{ Exception -> 0x01a5 }
            r0.f2723f = r15     // Catch:{ Exception -> 0x01a5 }
            r0.a((android.graphics.Bitmap) r10)     // Catch:{ Exception -> 0x01a5 }
            r0.a((androidx.core.app.h.C0039h) r11)     // Catch:{ Exception -> 0x01a5 }
            r15 = 2131232373(0x7f080675, float:1.8080853E38)
            r0.a((int) r15)     // Catch:{ Exception -> 0x01a5 }
            r0.l = r7     // Catch:{ Exception -> 0x01a5 }
            r0.b((int) r5)     // Catch:{ Exception -> 0x01a5 }
            android.app.Notification r15 = r0.d()     // Catch:{ Exception -> 0x01a5 }
            int r0 = r15.flags     // Catch:{ Exception -> 0x01a5 }
            r0 = r0 | 16
            r15.flags = r0     // Catch:{ Exception -> 0x01a5 }
            r1.notify(r3, r15)     // Catch:{ Exception -> 0x01a5 }
        L_0x01a5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.InAppPushNotification.CJRNotificationPublisherService.onStartJob(android.app.job.JobParameters):boolean");
    }
}
