package com.travel.bus.busticket.InAppPushNotification;

import android.content.BroadcastReceiver;

public class CJRNotificationPublisher extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static String f21522a = "notification";

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072 A[Catch:{ Exception -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e3 A[Catch:{ Exception -> 0x00fe }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
            r13 = this;
            java.lang.String r0 = "userDropVerticalList"
            java.lang.String r1 = ""
            if (r15 == 0) goto L_0x00fe
            java.lang.String r2 = "push_request_code"
            r3 = -1
            int r2 = r15.getIntExtra(r2, r3)     // Catch:{ Exception -> 0x00fe }
            android.content.Context r3 = r14.getApplicationContext()     // Catch:{ Exception -> 0x00fe }
            com.paytm.b.a.a r3 = com.travel.bus.b.a.a(r3)     // Catch:{ Exception -> 0x00fe }
            com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x00fe }
            r4.<init>()     // Catch:{ Exception -> 0x00fe }
            r5 = 1
            java.lang.String r6 = r3.b((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)     // Catch:{ Exception -> 0x00fe }
            com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisher$1 r7 = new com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisher$1     // Catch:{ Exception -> 0x00fe }
            r7.<init>()     // Catch:{ Exception -> 0x00fe }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r6 = r4.a((java.lang.String) r6, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x00fe }
            java.util.Set r6 = (java.util.Set) r6     // Catch:{ Exception -> 0x00fe }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x00fe }
            r7.<init>()     // Catch:{ Exception -> 0x00fe }
            r7.addAll(r6)     // Catch:{ Exception -> 0x00fe }
            r8 = 0
            r9 = 0
        L_0x0038:
            int r10 = r7.size()     // Catch:{ Exception -> 0x00fe }
            if (r9 >= r10) goto L_0x005d
            java.lang.Object r10 = r7.get(r9)     // Catch:{ Exception -> 0x00fe }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ Exception -> 0x00fe }
            int r10 = r10.intValue()     // Catch:{ Exception -> 0x00fe }
            if (r2 != r10) goto L_0x005a
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00fe }
            r6.remove(r7)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r4 = r4.a((java.lang.Object) r6)     // Catch:{ Exception -> 0x00fe }
            r3.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r5)     // Catch:{ Exception -> 0x00fe }
            r0 = 1
            goto L_0x005e
        L_0x005a:
            int r9 = r9 + 1
            goto L_0x0038
        L_0x005d:
            r0 = 0
        L_0x005e:
            if (r0 == 0) goto L_0x00fe
            r0 = 10
            if (r2 == r0) goto L_0x006f
            r0 = 11
            if (r2 == r0) goto L_0x006f
            r0 = 12
            if (r2 != r0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r0 = 0
            goto L_0x0070
        L_0x006f:
            r0 = 1
        L_0x0070:
            if (r0 == 0) goto L_0x00e4
            switch(r2) {
                case 10: goto L_0x0082;
                case 11: goto L_0x007d;
                case 12: goto L_0x0078;
                default: goto L_0x0075;
            }     // Catch:{ Exception -> 0x00fe }
        L_0x0075:
            r0 = r1
            r2 = r0
            goto L_0x0086
        L_0x0078:
            java.lang.String r0 = "flightPushDate"
            java.lang.String r2 = "flightPushCount"
            goto L_0x0086
        L_0x007d:
            java.lang.String r0 = "trainPushDate"
            java.lang.String r2 = "trainPushCount"
            goto L_0x0086
        L_0x0082:
            java.lang.String r0 = "busPushDate"
            java.lang.String r2 = "busPushCount"
        L_0x0086:
            android.content.Context r3 = r14.getApplicationContext()     // Catch:{ Exception -> 0x00fe }
            com.paytm.b.a.a r3 = com.travel.bus.b.a.a(r3)     // Catch:{ Exception -> 0x00fe }
            com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x00fe }
            r4.<init>()     // Catch:{ Exception -> 0x00fe }
            java.lang.String r1 = r3.b((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)     // Catch:{ Exception -> 0x00fe }
            int r6 = r3.b((java.lang.String) r2, (int) r8, (boolean) r5)     // Catch:{ Exception -> 0x00fe }
            r7 = 3
            if (r6 < r7) goto L_0x00d0
            com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisher$2 r6 = new com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisher$2     // Catch:{ Exception -> 0x00fe }
            r6.<init>()     // Catch:{ Exception -> 0x00fe }
            java.lang.reflect.Type r6 = r6.getType()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r1 = r4.a((java.lang.String) r1, (java.lang.reflect.Type) r6)     // Catch:{ Exception -> 0x00fe }
            java.util.Date r1 = (java.util.Date) r1     // Catch:{ Exception -> 0x00fe }
            java.util.Date r6 = new java.util.Date     // Catch:{ Exception -> 0x00fe }
            r6.<init>()     // Catch:{ Exception -> 0x00fe }
            long r9 = r6.getTime()     // Catch:{ Exception -> 0x00fe }
            long r11 = r1.getTime()     // Catch:{ Exception -> 0x00fe }
            long r9 = r9 - r11
            r11 = 86400000(0x5265c00, double:4.2687272E-316)
            long r9 = r9 / r11
            r11 = 1
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 < 0) goto L_0x00e1
            r3.a((java.lang.String) r2, (int) r5, (boolean) r5)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r1 = r4.a((java.lang.Object) r6)     // Catch:{ Exception -> 0x00fe }
            r3.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)     // Catch:{ Exception -> 0x00fe }
            goto L_0x00e0
        L_0x00d0:
            int r6 = r6 + r5
            r3.a((java.lang.String) r2, (int) r6, (boolean) r5)     // Catch:{ Exception -> 0x00fe }
            java.util.Date r1 = new java.util.Date     // Catch:{ Exception -> 0x00fe }
            r1.<init>()     // Catch:{ Exception -> 0x00fe }
            java.lang.String r1 = r4.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x00fe }
            r3.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)     // Catch:{ Exception -> 0x00fe }
        L_0x00e0:
            r5 = 0
        L_0x00e1:
            if (r5 == 0) goto L_0x00e4
            return
        L_0x00e4:
            java.lang.String r0 = "notification"
            java.lang.Object r14 = r14.getSystemService(r0)     // Catch:{ Exception -> 0x00fe }
            android.app.NotificationManager r14 = (android.app.NotificationManager) r14     // Catch:{ Exception -> 0x00fe }
            java.lang.String r0 = f21522a     // Catch:{ Exception -> 0x00fe }
            android.os.Parcelable r15 = r15.getParcelableExtra(r0)     // Catch:{ Exception -> 0x00fe }
            android.app.Notification r15 = (android.app.Notification) r15     // Catch:{ Exception -> 0x00fe }
            int r0 = r15.flags     // Catch:{ Exception -> 0x00fe }
            r0 = r0 | 16
            r15.flags = r0     // Catch:{ Exception -> 0x00fe }
            r14.notify(r8, r15)     // Catch:{ Exception -> 0x00fe }
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisher.onReceive(android.content.Context, android.content.Intent):void");
    }
}
