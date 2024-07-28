package net.one97.paytm.InAppPushNotification;

import android.content.BroadcastReceiver;

public class CJRNotificationPublisher extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static String f51852a = "notification";

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b A[Catch:{ Exception -> 0x010e }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f3 A[Catch:{ Exception -> 0x010e }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r13, android.content.Intent r14) {
        /*
            r12 = this;
            java.lang.String r0 = "userDropVerticalList"
            java.lang.String r1 = ""
            if (r14 == 0) goto L_0x010e
            java.lang.String r2 = "push_request_code"
            r3 = -1
            int r2 = r14.getIntExtra(r2, r3)     // Catch:{ Exception -> 0x010e }
            android.content.Context r3 = r13.getApplicationContext()     // Catch:{ Exception -> 0x010e }
            com.paytm.b.a.a r3 = net.one97.paytm.utils.ag.a(r3)     // Catch:{ Exception -> 0x010e }
            com.google.gson.f r4 = new com.google.gson.f     // Catch:{ Exception -> 0x010e }
            r4.<init>()     // Catch:{ Exception -> 0x010e }
            r5 = 1
            java.lang.String r6 = r3.b((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)     // Catch:{ Exception -> 0x010e }
            boolean r7 = r6.equals(r1)     // Catch:{ Exception -> 0x010e }
            r8 = 0
            if (r7 == 0) goto L_0x0028
            r6 = r8
        L_0x0028:
            net.one97.paytm.InAppPushNotification.CJRNotificationPublisher$1 r7 = new net.one97.paytm.InAppPushNotification.CJRNotificationPublisher$1     // Catch:{ Exception -> 0x010e }
            r7.<init>()     // Catch:{ Exception -> 0x010e }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception -> 0x010e }
            java.lang.Object r6 = r4.a((java.lang.String) r6, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x010e }
            java.util.Set r6 = (java.util.Set) r6     // Catch:{ Exception -> 0x010e }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x010e }
            r7.<init>()     // Catch:{ Exception -> 0x010e }
            r7.addAll(r6)     // Catch:{ Exception -> 0x010e }
            r9 = 0
            r10 = 0
        L_0x0041:
            int r11 = r7.size()     // Catch:{ Exception -> 0x010e }
            if (r10 >= r11) goto L_0x0066
            java.lang.Object r11 = r7.get(r10)     // Catch:{ Exception -> 0x010e }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ Exception -> 0x010e }
            int r11 = r11.intValue()     // Catch:{ Exception -> 0x010e }
            if (r2 != r11) goto L_0x0063
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x010e }
            r6.remove(r7)     // Catch:{ Exception -> 0x010e }
            java.lang.String r4 = r4.b(r6)     // Catch:{ Exception -> 0x010e }
            r3.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r5)     // Catch:{ Exception -> 0x010e }
            r0 = 1
            goto L_0x0067
        L_0x0063:
            int r10 = r10 + 1
            goto L_0x0041
        L_0x0066:
            r0 = 0
        L_0x0067:
            if (r0 == 0) goto L_0x010e
            r0 = 10
            if (r2 == r0) goto L_0x0078
            r0 = 11
            if (r2 == r0) goto L_0x0078
            r0 = 12
            if (r2 != r0) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r0 = 0
            goto L_0x0079
        L_0x0078:
            r0 = 1
        L_0x0079:
            if (r0 == 0) goto L_0x00f4
            switch(r2) {
                case 10: goto L_0x008b;
                case 11: goto L_0x0086;
                case 12: goto L_0x0081;
                default: goto L_0x007e;
            }     // Catch:{ Exception -> 0x010e }
        L_0x007e:
            r0 = r1
            r2 = r0
            goto L_0x008f
        L_0x0081:
            java.lang.String r0 = "flightPushDate"
            java.lang.String r2 = "flightPushCount"
            goto L_0x008f
        L_0x0086:
            java.lang.String r0 = "trainPushDate"
            java.lang.String r2 = "trainPushCount"
            goto L_0x008f
        L_0x008b:
            java.lang.String r0 = "busPushDate"
            java.lang.String r2 = "busPushCount"
        L_0x008f:
            android.content.Context r3 = r13.getApplicationContext()     // Catch:{ Exception -> 0x010e }
            com.paytm.b.a.a r3 = net.one97.paytm.utils.ag.a(r3)     // Catch:{ Exception -> 0x010e }
            com.google.gson.f r4 = new com.google.gson.f     // Catch:{ Exception -> 0x010e }
            r4.<init>()     // Catch:{ Exception -> 0x010e }
            java.lang.String r6 = r3.b((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)     // Catch:{ Exception -> 0x010e }
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x010e }
            if (r1 == 0) goto L_0x00a7
            r6 = r8
        L_0x00a7:
            int r1 = r3.b((java.lang.String) r2, (int) r9, (boolean) r5)     // Catch:{ Exception -> 0x010e }
            r7 = 3
            if (r1 < r7) goto L_0x00e0
            net.one97.paytm.InAppPushNotification.CJRNotificationPublisher$2 r1 = new net.one97.paytm.InAppPushNotification.CJRNotificationPublisher$2     // Catch:{ Exception -> 0x010e }
            r1.<init>()     // Catch:{ Exception -> 0x010e }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x010e }
            java.lang.Object r1 = r4.a((java.lang.String) r6, (java.lang.reflect.Type) r1)     // Catch:{ Exception -> 0x010e }
            java.util.Date r1 = (java.util.Date) r1     // Catch:{ Exception -> 0x010e }
            java.util.Date r6 = new java.util.Date     // Catch:{ Exception -> 0x010e }
            r6.<init>()     // Catch:{ Exception -> 0x010e }
            long r7 = r6.getTime()     // Catch:{ Exception -> 0x010e }
            long r10 = r1.getTime()     // Catch:{ Exception -> 0x010e }
            long r7 = r7 - r10
            r10 = 86400000(0x5265c00, double:4.2687272E-316)
            long r7 = r7 / r10
            r10 = 1
            int r1 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r1 < 0) goto L_0x00f1
            r3.a((java.lang.String) r2, (int) r5, (boolean) r5)     // Catch:{ Exception -> 0x010e }
            java.lang.String r1 = r4.b(r6)     // Catch:{ Exception -> 0x010e }
            r3.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)     // Catch:{ Exception -> 0x010e }
            goto L_0x00f0
        L_0x00e0:
            int r1 = r1 + r5
            r3.a((java.lang.String) r2, (int) r1, (boolean) r5)     // Catch:{ Exception -> 0x010e }
            java.util.Date r1 = new java.util.Date     // Catch:{ Exception -> 0x010e }
            r1.<init>()     // Catch:{ Exception -> 0x010e }
            java.lang.String r1 = r4.b(r1)     // Catch:{ Exception -> 0x010e }
            r3.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)     // Catch:{ Exception -> 0x010e }
        L_0x00f0:
            r5 = 0
        L_0x00f1:
            if (r5 == 0) goto L_0x00f4
            return
        L_0x00f4:
            java.lang.String r0 = "notification"
            java.lang.Object r13 = r13.getSystemService(r0)     // Catch:{ Exception -> 0x010e }
            android.app.NotificationManager r13 = (android.app.NotificationManager) r13     // Catch:{ Exception -> 0x010e }
            java.lang.String r0 = f51852a     // Catch:{ Exception -> 0x010e }
            android.os.Parcelable r14 = r14.getParcelableExtra(r0)     // Catch:{ Exception -> 0x010e }
            android.app.Notification r14 = (android.app.Notification) r14     // Catch:{ Exception -> 0x010e }
            int r0 = r14.flags     // Catch:{ Exception -> 0x010e }
            r0 = r0 | 16
            r14.flags = r0     // Catch:{ Exception -> 0x010e }
            r13.notify(r9, r14)     // Catch:{ Exception -> 0x010e }
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.InAppPushNotification.CJRNotificationPublisher.onReceive(android.content.Context, android.content.Intent):void");
    }
}
