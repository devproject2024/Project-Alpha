package com.paytm.notification.ui;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.app.k;
import com.paytm.notification.b.e;
import com.squareup.picasso.w;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43334a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final int f43335b = 2;

    private a() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0214, code lost:
        if (r13.intValue() != 0) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0256, code lost:
        if (r13.intValue() != 0) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        r0 = r0.getContent();
     */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01a5 A[Catch:{ Exception -> 0x035b }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01b6 A[Catch:{ Exception -> 0x035b }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0286 A[Catch:{ Exception -> 0x035b }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A[Catch:{ Exception -> 0x035b }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x03e8 A[SYNTHETIC, Splitter:B:220:0x03e8] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008e A[Catch:{ Exception -> 0x035b }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094 A[SYNTHETIC, Splitter:B:41:0x0094] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.paytm.notification.ui.b a(android.content.Context r17, com.paytm.notification.models.PushMessage r18, int r19) {
        /*
            r16 = this;
            r1 = r17
            r2 = r18
            monitor-enter(r16)
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r1, r0)     // Catch:{ all -> 0x03f0 }
            java.lang.String r0 = "pushMessage"
            kotlin.g.b.k.c(r2, r0)     // Catch:{ all -> 0x03f0 }
            com.paytm.notification.ui.b r3 = new com.paytm.notification.ui.b     // Catch:{ all -> 0x03f0 }
            r3.<init>()     // Catch:{ all -> 0x03f0 }
            com.paytm.notification.models.Notification r0 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            r4 = 0
            if (r0 == 0) goto L_0x0026
            com.paytm.notification.models.Content r0 = r0.getContent()     // Catch:{ all -> 0x03f0 }
            if (r0 == 0) goto L_0x0026
            java.lang.String r0 = r0.getSound()     // Catch:{ all -> 0x03f0 }
            goto L_0x0027
        L_0x0026:
            r0 = r4
        L_0x0027:
            android.net.Uri r5 = a((java.lang.String) r0, (android.content.Context) r1)     // Catch:{ all -> 0x03f0 }
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x03f0 }
            r7 = 0
            r8 = 1
            if (r6 == 0) goto L_0x003b
            int r6 = r6.length()     // Catch:{ all -> 0x03f0 }
            if (r6 != 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r6 = 0
            goto L_0x003c
        L_0x003b:
            r6 = 1
        L_0x003c:
            if (r6 != 0) goto L_0x0078
            if (r0 == 0) goto L_0x0070
            java.lang.String r6 = r0.toLowerCase()     // Catch:{ all -> 0x03f0 }
            java.lang.String r9 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)     // Catch:{ all -> 0x03f0 }
            if (r6 == 0) goto L_0x0068
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x03f0 }
            java.lang.CharSequence r6 = kotlin.m.p.b(r6)     // Catch:{ all -> 0x03f0 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x03f0 }
            java.lang.String r9 = "default"
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r9)     // Catch:{ all -> 0x03f0 }
            r6 = r6 ^ r8
            if (r6 == 0) goto L_0x0078
            r3.f43340e = r8     // Catch:{ all -> 0x03f0 }
            if (r5 == 0) goto L_0x0064
            r6 = 1
            goto L_0x0065
        L_0x0064:
            r6 = 0
        L_0x0065:
            r3.f43341f = r6     // Catch:{ all -> 0x03f0 }
            goto L_0x0078
        L_0x0068:
            kotlin.u r0 = new kotlin.u     // Catch:{ all -> 0x03f0 }
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)     // Catch:{ all -> 0x03f0 }
            throw r0     // Catch:{ all -> 0x03f0 }
        L_0x0070:
            kotlin.u r0 = new kotlin.u     // Catch:{ all -> 0x03f0 }
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)     // Catch:{ all -> 0x03f0 }
            throw r0     // Catch:{ all -> 0x03f0 }
        L_0x0078:
            if (r5 == 0) goto L_0x0080
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x03f0 }
            if (r6 != 0) goto L_0x0082
        L_0x0080:
            java.lang.String r6 = "Default"
        L_0x0082:
            java.lang.String r9 = "soundUri?.toString()\n   …IFICATION_CHANNEL_DEFAULT"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)     // Catch:{ all -> 0x03f0 }
            java.lang.String r9 = a((android.content.Context) r1, (java.lang.String) r6)     // Catch:{ all -> 0x03f0 }
            if (r9 == 0) goto L_0x0094
            r3.f43339d = r8     // Catch:{ all -> 0x03f0 }
            r3.f43342g = r9     // Catch:{ all -> 0x03f0 }
            monitor-exit(r16)
            return r3
        L_0x0094:
            androidx.core.app.h$e r9 = new androidx.core.app.h$e     // Catch:{ all -> 0x03f0 }
            r9.<init>(r1, r6)     // Catch:{ all -> 0x03f0 }
            com.paytm.notification.models.Notification r10 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x00aa
            com.paytm.notification.models.Content r10 = r10.getContent()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x00aa
            java.lang.String r10 = r10.getTitle()     // Catch:{ all -> 0x03f0 }
            goto L_0x00ab
        L_0x00aa:
            r10 = r4
        L_0x00ab:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x03f0 }
            androidx.core.app.h$e r9 = r9.a((java.lang.CharSequence) r10)     // Catch:{ all -> 0x03f0 }
            androidx.core.app.h$e r9 = r9.a((boolean) r8)     // Catch:{ all -> 0x03f0 }
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x03f0 }
            r11 = 26
            if (r10 >= r11) goto L_0x00c7
            if (r5 != 0) goto L_0x00c3
            r10 = 2
            android.net.Uri r10 = android.media.RingtoneManager.getDefaultUri(r10)     // Catch:{ all -> 0x03f0 }
            goto L_0x00c4
        L_0x00c3:
            r10 = r5
        L_0x00c4:
            r9.a((android.net.Uri) r10)     // Catch:{ all -> 0x03f0 }
        L_0x00c7:
            com.paytm.notification.models.Notification r10 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x00d8
            com.paytm.notification.models.Content r10 = r10.getContent()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x00d8
            java.lang.String r10 = r10.getBody()     // Catch:{ all -> 0x03f0 }
            goto L_0x00d9
        L_0x00d8:
            r10 = r4
        L_0x00d9:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x03f0 }
            r9.b((java.lang.CharSequence) r10)     // Catch:{ all -> 0x03f0 }
            com.paytm.notification.models.Notification r10 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x00ef
            com.paytm.notification.models.Content r10 = r10.getContent()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x00ef
            java.lang.String r10 = r10.getSubText()     // Catch:{ all -> 0x03f0 }
            goto L_0x00f0
        L_0x00ef:
            r10 = r4
        L_0x00f0:
            if (r10 == 0) goto L_0x0109
            com.paytm.notification.models.Notification r10 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x0103
            com.paytm.notification.models.Content r10 = r10.getContent()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x0103
            java.lang.String r10 = r10.getSubText()     // Catch:{ all -> 0x03f0 }
            goto L_0x0104
        L_0x0103:
            r10 = r4
        L_0x0104:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x03f0 }
            r9.c((java.lang.CharSequence) r10)     // Catch:{ all -> 0x03f0 }
        L_0x0109:
            com.paytm.notification.models.Notification r10 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x011a
            com.paytm.notification.models.Content r10 = r10.getContent()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x011a
            java.lang.String r10 = r10.getBody()     // Catch:{ all -> 0x03f0 }
            goto L_0x011b
        L_0x011a:
            r10 = r4
        L_0x011b:
            if (r10 != 0) goto L_0x0120
            kotlin.g.b.k.a()     // Catch:{ all -> 0x03f0 }
        L_0x0120:
            int r10 = r10.length()     // Catch:{ all -> 0x03f0 }
            r12 = 40
            if (r10 <= r12) goto L_0x013d
            com.paytm.notification.models.Notification r10 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x0139
            com.paytm.notification.models.Content r10 = r10.getContent()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x0139
            java.lang.String r10 = r10.getBody()     // Catch:{ all -> 0x03f0 }
            goto L_0x013a
        L_0x0139:
            r10 = r4
        L_0x013a:
            r2.setBigText(r10)     // Catch:{ all -> 0x03f0 }
        L_0x013d:
            int r10 = r18.getNotificationIcon()     // Catch:{ all -> 0x03f0 }
            r12 = -1
            if (r10 == r12) goto L_0x014c
            int r10 = r18.getNotificationIcon()     // Catch:{ all -> 0x03f0 }
            r9.a((int) r10)     // Catch:{ all -> 0x03f0 }
            goto L_0x0151
        L_0x014c:
            int r10 = com.paytm.notification.R.drawable.logo     // Catch:{ all -> 0x03f0 }
            r9.a((int) r10)     // Catch:{ all -> 0x03f0 }
        L_0x0151:
            java.lang.String r10 = r18.getBigText()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x016b
            androidx.core.app.h$c r10 = new androidx.core.app.h$c     // Catch:{ all -> 0x03f0 }
            r10.<init>()     // Catch:{ all -> 0x03f0 }
            java.lang.String r12 = r18.getBigText()     // Catch:{ all -> 0x03f0 }
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ all -> 0x03f0 }
            androidx.core.app.h$c r10 = r10.a((java.lang.CharSequence) r12)     // Catch:{ all -> 0x03f0 }
            androidx.core.app.h$h r10 = (androidx.core.app.h.C0039h) r10     // Catch:{ all -> 0x03f0 }
            r9.a((androidx.core.app.h.C0039h) r10)     // Catch:{ all -> 0x03f0 }
        L_0x016b:
            com.paytm.notification.models.Notification r10 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x017c
            com.paytm.notification.models.Content r10 = r10.getContent()     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x017c
            java.lang.String r10 = r10.getImageSource()     // Catch:{ all -> 0x03f0 }
            goto L_0x017d
        L_0x017c:
            r10 = r4
        L_0x017d:
            android.graphics.Bitmap r10 = a(r10)     // Catch:{ all -> 0x03f0 }
            if (r10 == 0) goto L_0x01e3
            com.paytm.notification.models.Notification r12 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r12 == 0) goto L_0x0194
            com.paytm.notification.models.Content r12 = r12.getContent()     // Catch:{ all -> 0x03f0 }
            if (r12 == 0) goto L_0x0194
            java.lang.String r12 = r12.getSummary()     // Catch:{ all -> 0x03f0 }
            goto L_0x0195
        L_0x0194:
            r12 = r4
        L_0x0195:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ all -> 0x03f0 }
            if (r12 == 0) goto L_0x01a2
            int r12 = r12.length()     // Catch:{ all -> 0x03f0 }
            if (r12 != 0) goto L_0x01a0
            goto L_0x01a2
        L_0x01a0:
            r12 = 0
            goto L_0x01a3
        L_0x01a2:
            r12 = 1
        L_0x01a3:
            if (r12 != 0) goto L_0x01b6
            com.paytm.notification.models.Notification r12 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r12 == 0) goto L_0x01c7
            com.paytm.notification.models.Content r12 = r12.getContent()     // Catch:{ all -> 0x03f0 }
            if (r12 == 0) goto L_0x01c7
            java.lang.String r12 = r12.getSummary()     // Catch:{ all -> 0x03f0 }
            goto L_0x01c8
        L_0x01b6:
            com.paytm.notification.models.Notification r12 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r12 == 0) goto L_0x01c7
            com.paytm.notification.models.Content r12 = r12.getContent()     // Catch:{ all -> 0x03f0 }
            if (r12 == 0) goto L_0x01c7
            java.lang.String r12 = r12.getBody()     // Catch:{ all -> 0x03f0 }
            goto L_0x01c8
        L_0x01c7:
            r12 = r4
        L_0x01c8:
            r9.a((android.graphics.Bitmap) r10)     // Catch:{ all -> 0x03f0 }
            androidx.core.app.h$b r13 = new androidx.core.app.h$b     // Catch:{ all -> 0x03f0 }
            r13.<init>()     // Catch:{ all -> 0x03f0 }
            androidx.core.app.h$b r13 = r13.a((android.graphics.Bitmap) r10)     // Catch:{ all -> 0x03f0 }
            androidx.core.app.h$b r13 = r13.a()     // Catch:{ all -> 0x03f0 }
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ all -> 0x03f0 }
            androidx.core.app.h$b r12 = r13.a((java.lang.CharSequence) r12)     // Catch:{ all -> 0x03f0 }
            androidx.core.app.h$h r12 = (androidx.core.app.h.C0039h) r12     // Catch:{ all -> 0x03f0 }
            r9.a((androidx.core.app.h.C0039h) r12)     // Catch:{ all -> 0x03f0 }
        L_0x01e3:
            java.lang.String r12 = "notificationBuilder"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r12)     // Catch:{ all -> 0x03f0 }
            r9.a()     // Catch:{ all -> 0x03f0 }
            com.paytm.notification.j r12 = com.paytm.notification.j.f43241a     // Catch:{ all -> 0x03f0 }
            com.paytm.notification.data.c.h r12 = r12.c()     // Catch:{ all -> 0x03f0 }
            if (r12 == 0) goto L_0x01fe
            com.paytm.notification.models.NotificationProjectConfig r13 = r12.g()     // Catch:{ all -> 0x03f0 }
            if (r13 == 0) goto L_0x01fe
            java.lang.Integer r13 = r13.getNotificationAccentColorFromResource$paytmnotification_paytmRelease()     // Catch:{ all -> 0x03f0 }
            goto L_0x01ff
        L_0x01fe:
            r13 = r4
        L_0x01ff:
            if (r13 == 0) goto L_0x0233
            com.paytm.notification.models.NotificationProjectConfig r13 = r12.g()     // Catch:{ all -> 0x03f0 }
            if (r13 == 0) goto L_0x020c
            java.lang.Integer r13 = r13.getNotificationAccentColorFromResource$paytmnotification_paytmRelease()     // Catch:{ all -> 0x03f0 }
            goto L_0x020d
        L_0x020c:
            r13 = r4
        L_0x020d:
            if (r13 != 0) goto L_0x0210
            goto L_0x0216
        L_0x0210:
            int r13 = r13.intValue()     // Catch:{ all -> 0x03f0 }
            if (r13 == 0) goto L_0x0233
        L_0x0216:
            com.paytm.notification.models.NotificationProjectConfig r12 = r12.g()     // Catch:{ all -> 0x03f0 }
            if (r12 == 0) goto L_0x0221
            java.lang.Integer r12 = r12.getNotificationAccentColorFromResource$paytmnotification_paytmRelease()     // Catch:{ all -> 0x03f0 }
            goto L_0x0222
        L_0x0221:
            r12 = r4
        L_0x0222:
            if (r12 != 0) goto L_0x0227
            kotlin.g.b.k.a()     // Catch:{ all -> 0x03f0 }
        L_0x0227:
            int r12 = r12.intValue()     // Catch:{ all -> 0x03f0 }
            int r12 = androidx.core.content.b.c(r1, r12)     // Catch:{ all -> 0x03f0 }
            r9.c((int) r12)     // Catch:{ all -> 0x03f0 }
            goto L_0x027b
        L_0x0233:
            if (r12 == 0) goto L_0x0240
            com.paytm.notification.models.NotificationProjectConfig r13 = r12.g()     // Catch:{ all -> 0x03f0 }
            if (r13 == 0) goto L_0x0240
            java.lang.Integer r13 = r13.getNotificationAccentColor$paytmnotification_paytmRelease()     // Catch:{ all -> 0x03f0 }
            goto L_0x0241
        L_0x0240:
            r13 = r4
        L_0x0241:
            if (r13 == 0) goto L_0x0272
            com.paytm.notification.models.NotificationProjectConfig r13 = r12.g()     // Catch:{ all -> 0x03f0 }
            if (r13 == 0) goto L_0x024e
            java.lang.Integer r13 = r13.getNotificationAccentColor$paytmnotification_paytmRelease()     // Catch:{ all -> 0x03f0 }
            goto L_0x024f
        L_0x024e:
            r13 = r4
        L_0x024f:
            if (r13 != 0) goto L_0x0252
            goto L_0x0258
        L_0x0252:
            int r13 = r13.intValue()     // Catch:{ all -> 0x03f0 }
            if (r13 == 0) goto L_0x0272
        L_0x0258:
            com.paytm.notification.models.NotificationProjectConfig r12 = r12.g()     // Catch:{ all -> 0x03f0 }
            if (r12 != 0) goto L_0x0261
            kotlin.g.b.k.a()     // Catch:{ all -> 0x03f0 }
        L_0x0261:
            java.lang.Integer r12 = r12.getNotificationAccentColor$paytmnotification_paytmRelease()     // Catch:{ all -> 0x03f0 }
            if (r12 != 0) goto L_0x026a
            kotlin.g.b.k.a()     // Catch:{ all -> 0x03f0 }
        L_0x026a:
            int r12 = r12.intValue()     // Catch:{ all -> 0x03f0 }
            r9.c((int) r12)     // Catch:{ all -> 0x03f0 }
            goto L_0x027b
        L_0x0272:
            int r12 = com.paytm.notification.R.color.pai_pushsdk_notification_color     // Catch:{ all -> 0x03f0 }
            int r12 = androidx.core.content.b.c(r1, r12)     // Catch:{ all -> 0x03f0 }
            r9.c((int) r12)     // Catch:{ all -> 0x03f0 }
        L_0x027b:
            r9.a((boolean) r8)     // Catch:{ all -> 0x03f0 }
            java.lang.String r12 = "notification"
            java.lang.Object r12 = r1.getSystemService(r12)     // Catch:{ all -> 0x03f0 }
            if (r12 == 0) goto L_0x03e8
            android.app.NotificationManager r12 = (android.app.NotificationManager) r12     // Catch:{ all -> 0x03f0 }
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x03f0 }
            if (r13 < r11) goto L_0x030c
            r11 = 3
            if (r5 == 0) goto L_0x02e7
            java.lang.String r13 = "Default"
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r13)     // Catch:{ all -> 0x03f0 }
            if (r13 == 0) goto L_0x0298
            goto L_0x02e7
        L_0x0298:
            kotlin.g.b.aa r13 = kotlin.g.b.aa.f47921a     // Catch:{ all -> 0x03f0 }
            int r13 = com.paytm.notification.R.string.default_notification_channel_name_custom     // Catch:{ all -> 0x03f0 }
            java.lang.String r13 = r1.getString(r13)     // Catch:{ all -> 0x03f0 }
            java.lang.String r14 = "context.getString(R.stri…tion_channel_name_custom)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)     // Catch:{ all -> 0x03f0 }
            java.lang.Object[] r14 = new java.lang.Object[r8]     // Catch:{ all -> 0x03f0 }
            r14[r7] = r0     // Catch:{ all -> 0x03f0 }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r14, r8)     // Catch:{ all -> 0x03f0 }
            java.lang.String r0 = java.lang.String.format(r13, r0)     // Catch:{ all -> 0x03f0 }
            java.lang.String r13 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)     // Catch:{ all -> 0x03f0 }
            int r13 = com.paytm.notification.R.string.default_notification_channel_description_custom     // Catch:{ all -> 0x03f0 }
            java.lang.String r13 = r1.getString(r13)     // Catch:{ all -> 0x03f0 }
            java.lang.String r14 = "context.getString(R.stri…annel_description_custom)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)     // Catch:{ all -> 0x03f0 }
            android.media.AudioAttributes$Builder r14 = new android.media.AudioAttributes$Builder     // Catch:{ all -> 0x03f0 }
            r14.<init>()     // Catch:{ all -> 0x03f0 }
            r15 = 4
            android.media.AudioAttributes$Builder r14 = r14.setContentType(r15)     // Catch:{ all -> 0x03f0 }
            r15 = 5
            android.media.AudioAttributes$Builder r14 = r14.setUsage(r15)     // Catch:{ all -> 0x03f0 }
            android.media.AudioAttributes r14 = r14.build()     // Catch:{ all -> 0x03f0 }
            java.lang.String r15 = "AudioAttributes.Builder(…                 .build()"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)     // Catch:{ all -> 0x03f0 }
            android.app.NotificationChannel r15 = new android.app.NotificationChannel     // Catch:{ all -> 0x03f0 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x03f0 }
            r15.<init>(r6, r0, r11)     // Catch:{ all -> 0x03f0 }
            r15.setDescription(r13)     // Catch:{ all -> 0x03f0 }
            r15.setSound(r5, r14)     // Catch:{ all -> 0x03f0 }
            goto L_0x0309
        L_0x02e7:
            int r0 = com.paytm.notification.R.string.default_notification_channel_name     // Catch:{ all -> 0x03f0 }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x03f0 }
            java.lang.String r5 = "context.getString(R.stri…otification_channel_name)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)     // Catch:{ all -> 0x03f0 }
            int r5 = com.paytm.notification.R.string.default_notification_channel_description     // Catch:{ all -> 0x03f0 }
            java.lang.String r5 = r1.getString(r5)     // Catch:{ all -> 0x03f0 }
            java.lang.String r6 = "context.getString(R.stri…tion_channel_description)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ all -> 0x03f0 }
            android.app.NotificationChannel r15 = new android.app.NotificationChannel     // Catch:{ all -> 0x03f0 }
            java.lang.String r6 = "Default"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x03f0 }
            r15.<init>(r6, r0, r11)     // Catch:{ all -> 0x03f0 }
            r15.setDescription(r5)     // Catch:{ all -> 0x03f0 }
        L_0x0309:
            r12.createNotificationChannel(r15)     // Catch:{ all -> 0x03f0 }
        L_0x030c:
            android.app.Notification r5 = r9.d()     // Catch:{ all -> 0x03f0 }
            java.lang.String r0 = "notification"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ all -> 0x03f0 }
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x035b }
            java.lang.Class<com.paytm.notification.ActionReceiver> r9 = com.paytm.notification.ActionReceiver.class
            r0.<init>(r1, r9)     // Catch:{ Exception -> 0x035b }
            java.lang.String r9 = "com.paytm.notification.OPENED_INTERNAL"
            android.content.Intent r0 = r0.setAction(r9)     // Catch:{ Exception -> 0x035b }
            java.lang.String r9 = "EXTRA_PUSH_SERIALIZED"
            com.google.gson.f r11 = new com.google.gson.f     // Catch:{ Exception -> 0x035b }
            r11.<init>()     // Catch:{ Exception -> 0x035b }
            java.lang.String r11 = r11.b(r2)     // Catch:{ Exception -> 0x035b }
            android.content.Intent r0 = r0.putExtra(r9, r11)     // Catch:{ Exception -> 0x035b }
            java.lang.String r9 = "NOTIFICATION_ID"
            java.lang.Integer r11 = r18.getNotificationId()     // Catch:{ Exception -> 0x035b }
            java.io.Serializable r11 = (java.io.Serializable) r11     // Catch:{ Exception -> 0x035b }
            android.content.Intent r0 = r0.putExtra(r9, r11)     // Catch:{ Exception -> 0x035b }
            java.util.UUID r9 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x035b }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x035b }
            android.content.Intent r0 = r0.addCategory(r9)     // Catch:{ Exception -> 0x035b }
            android.content.Intent r0 = r0.addFlags(r6)     // Catch:{ Exception -> 0x035b }
            java.lang.String r9 = "Intent(context, ActionRe…FLAG_RECEIVER_FOREGROUND)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)     // Catch:{ Exception -> 0x035b }
            android.app.PendingIntent r0 = android.app.PendingIntent.getBroadcast(r1, r7, r0, r7)     // Catch:{ Exception -> 0x035b }
            r5.contentIntent = r0     // Catch:{ Exception -> 0x035b }
            goto L_0x0363
        L_0x035b:
            r0 = move-exception
            com.paytm.notification.b.e$b r9 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x03f0 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x03f0 }
            r9.b(r0)     // Catch:{ all -> 0x03f0 }
        L_0x0363:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x03a7 }
            java.lang.Class<com.paytm.notification.ActionReceiver> r9 = com.paytm.notification.ActionReceiver.class
            r0.<init>(r1, r9)     // Catch:{ Exception -> 0x03a7 }
            java.lang.String r9 = "com.paytm.notification.DISMISSED_INTERNAL"
            android.content.Intent r0 = r0.setAction(r9)     // Catch:{ Exception -> 0x03a7 }
            java.lang.String r9 = "EXTRA_PUSH_SERIALIZED"
            com.google.gson.f r11 = new com.google.gson.f     // Catch:{ Exception -> 0x03a7 }
            r11.<init>()     // Catch:{ Exception -> 0x03a7 }
            java.lang.String r11 = r11.b(r2)     // Catch:{ Exception -> 0x03a7 }
            android.content.Intent r0 = r0.putExtra(r9, r11)     // Catch:{ Exception -> 0x03a7 }
            java.lang.String r9 = "NOTIFICATION_ID"
            java.lang.Integer r11 = r18.getNotificationId()     // Catch:{ Exception -> 0x03a7 }
            java.io.Serializable r11 = (java.io.Serializable) r11     // Catch:{ Exception -> 0x03a7 }
            android.content.Intent r0 = r0.putExtra(r9, r11)     // Catch:{ Exception -> 0x03a7 }
            java.util.UUID r9 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x03a7 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x03a7 }
            android.content.Intent r0 = r0.addCategory(r9)     // Catch:{ Exception -> 0x03a7 }
            android.content.Intent r0 = r0.addFlags(r6)     // Catch:{ Exception -> 0x03a7 }
            java.lang.String r6 = "Intent(context, ActionRe…FLAG_RECEIVER_FOREGROUND)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x03a7 }
            android.app.PendingIntent r0 = android.app.PendingIntent.getBroadcast(r1, r7, r0, r7)     // Catch:{ Exception -> 0x03a7 }
            r5.deleteIntent = r0     // Catch:{ Exception -> 0x03a7 }
            goto L_0x03af
        L_0x03a7:
            r0 = move-exception
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x03f0 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x03f0 }
            r1.b(r0)     // Catch:{ all -> 0x03f0 }
        L_0x03af:
            r1 = r19
            r12.notify(r1, r5)     // Catch:{ all -> 0x03f0 }
            r3.f43336a = r8     // Catch:{ all -> 0x03f0 }
            com.paytm.notification.models.Notification r0 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r0 == 0) goto L_0x03c7
            com.paytm.notification.models.Content r0 = r0.getContent()     // Catch:{ all -> 0x03f0 }
            if (r0 == 0) goto L_0x03c7
            java.lang.String r0 = r0.getImageSource()     // Catch:{ all -> 0x03f0 }
            goto L_0x03c8
        L_0x03c7:
            r0 = r4
        L_0x03c8:
            if (r0 == 0) goto L_0x03cc
            r0 = 1
            goto L_0x03cd
        L_0x03cc:
            r0 = 0
        L_0x03cd:
            r3.f43337b = r0     // Catch:{ all -> 0x03f0 }
            com.paytm.notification.models.Notification r0 = r18.getNotification()     // Catch:{ all -> 0x03f0 }
            if (r0 == 0) goto L_0x03df
            com.paytm.notification.models.Content r0 = r0.getContent()     // Catch:{ all -> 0x03f0 }
            if (r0 == 0) goto L_0x03df
            java.lang.String r4 = r0.getImageSource()     // Catch:{ all -> 0x03f0 }
        L_0x03df:
            if (r4 == 0) goto L_0x03e4
            if (r10 == 0) goto L_0x03e4
            r7 = 1
        L_0x03e4:
            r3.f43338c = r7     // Catch:{ all -> 0x03f0 }
            monitor-exit(r16)
            return r3
        L_0x03e8:
            kotlin.u r0 = new kotlin.u     // Catch:{ all -> 0x03f0 }
            java.lang.String r1 = "null cannot be cast to non-null type android.app.NotificationManager"
            r0.<init>(r1)     // Catch:{ all -> 0x03f0 }
            throw r0     // Catch:{ all -> 0x03f0 }
        L_0x03f0:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.ui.a.a(android.content.Context, com.paytm.notification.models.PushMessage, int):com.paytm.notification.ui.b");
    }

    private static String a(Context context, String str) {
        String str2 = null;
        try {
            if (!k.a(context).a()) {
                str2 = "notifications from the calling package are blocked";
            }
            return (Build.VERSION.SDK_INT < 26 || !b(context, str)) ? str2 : "isChannelBlocked(context, channelId) == true";
        } catch (Exception e2) {
            e.f43014a.b(e2);
            return null;
        }
    }

    private static boolean b(Context context, String str) {
        try {
            NotificationChannel notificationChannel = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel(str);
            if (notificationChannel == null || notificationChannel.getImportance() != 0) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            e.f43014a.b(e2);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a9, code lost:
        if (r1.intValue() != 0) goto L_0x00ab;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[Catch:{ Exception -> 0x0034 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.net.Uri a(java.lang.String r4, android.content.Context r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0037
            java.util.Locale r1 = java.util.Locale.ROOT     // Catch:{ Exception -> 0x0034 }
            java.lang.String r2 = "Locale.ROOT"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0034 }
            if (r4 == 0) goto L_0x002c
            java.lang.String r4 = r4.toLowerCase(r1)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x0034 }
            if (r4 == 0) goto L_0x0037
            if (r4 == 0) goto L_0x0024
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0034 }
            java.lang.CharSequence r4 = kotlin.m.p.b(r4)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0038
        L_0x0024:
            kotlin.u r4 = new kotlin.u     // Catch:{ Exception -> 0x0034 }
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.CharSequence"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0034 }
            throw r4     // Catch:{ Exception -> 0x0034 }
        L_0x002c:
            kotlin.u r4 = new kotlin.u     // Catch:{ Exception -> 0x0034 }
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.String"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0034 }
            throw r4     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r4 = move-exception
            goto L_0x00d2
        L_0x0037:
            r4 = r0
        L_0x0038:
            if (r4 == 0) goto L_0x00d5
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0034 }
            int r1 = r1.length()     // Catch:{ Exception -> 0x0034 }
            r2 = 0
            if (r1 != 0) goto L_0x0046
            r1 = 1
            goto L_0x0047
        L_0x0046:
            r1 = 0
        L_0x0047:
            if (r1 == 0) goto L_0x004b
            goto L_0x00d5
        L_0x004b:
            java.lang.String r1 = "default"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x0054
            return r0
        L_0x0054:
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0034 }
            java.lang.String r3 = ".mp3"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0034 }
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r3, (boolean) r2)     // Catch:{ Exception -> 0x0034 }
            if (r1 != 0) goto L_0x007b
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0034 }
            java.lang.String r3 = ".ogg"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0034 }
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r3, (boolean) r2)     // Catch:{ Exception -> 0x0034 }
            if (r1 != 0) goto L_0x007b
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0034 }
            java.lang.String r3 = ".wav"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0034 }
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r3, (boolean) r2)     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x008a
        L_0x007b:
            int r1 = r4.length()     // Catch:{ Exception -> 0x0034 }
            int r1 = r1 + -4
            java.lang.String r4 = r4.substring(r2, r1)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x0034 }
        L_0x008a:
            if (r5 == 0) goto L_0x00a1
            android.content.res.Resources r1 = r5.getResources()     // Catch:{ Exception -> 0x0034 }
            if (r1 == 0) goto L_0x00a1
            java.lang.String r2 = "raw"
            java.lang.String r3 = r5.getPackageName()     // Catch:{ Exception -> 0x0034 }
            int r1 = r1.getIdentifier(r4, r2, r3)     // Catch:{ Exception -> 0x0034 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0034 }
            goto L_0x00a2
        L_0x00a1:
            r1 = r0
        L_0x00a2:
            if (r1 != 0) goto L_0x00a5
            goto L_0x00ab
        L_0x00a5:
            int r2 = r1.intValue()     // Catch:{ Exception -> 0x0034 }
            if (r2 == 0) goto L_0x00d1
        L_0x00ab:
            if (r1 != 0) goto L_0x00ae
            goto L_0x00d1
        L_0x00ae:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0034 }
            java.lang.String r2 = "android.resource://"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0034 }
            if (r5 == 0) goto L_0x00bc
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x0034 }
            goto L_0x00bd
        L_0x00bc:
            r5 = r0
        L_0x00bd:
            r1.append(r5)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r5 = "/raw/"
            r1.append(r5)     // Catch:{ Exception -> 0x0034 }
            r1.append(r4)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0034 }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0034 }
            return r4
        L_0x00d1:
            return r0
        L_0x00d2:
            r4.printStackTrace()
        L_0x00d5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.ui.a.a(java.lang.String, android.content.Context):android.net.Uri");
    }

    private static Bitmap a(String str) {
        if (str == null) {
            return null;
        }
        boolean z = true;
        Bitmap bitmap = null;
        int i2 = 0;
        while (z) {
            if (str == null) {
                bitmap = null;
            } else {
                try {
                    bitmap = w.a().a(str).e();
                } catch (Exception unused) {
                }
            }
            if (bitmap != null || i2 >= f43335b) {
                z = false;
            } else {
                i2++;
                Thread.sleep(1000);
            }
        }
        return bitmap;
    }
}
