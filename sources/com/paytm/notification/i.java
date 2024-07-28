package com.paytm.notification;

import android.content.Context;
import com.paytm.notification.FlashManager;
import com.paytm.notification.a;
import com.paytm.notification.b.e;
import com.paytm.notification.g;
import com.paytm.notification.models.PushMessage;
import com.paytm.notification.models.callback.ErrorReportCallback;
import com.paytm.notification.models.callback.InboxHandlerReadyCallback;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.x;

public final class i implements h {

    /* renamed from: d  reason: collision with root package name */
    public static final a f43209d = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static i f43210i;

    /* renamed from: a  reason: collision with root package name */
    final ExecutorService f43211a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f43212b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public final com.paytm.notification.data.c.b f43213c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f43214e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final com.paytm.notification.schedulers.c f43215f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final com.paytm.notification.data.c.h f43216g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final com.paytm.notification.data.c.j f43217h;

    private i(Context context, com.paytm.notification.schedulers.c cVar, com.paytm.notification.data.c.b bVar, com.paytm.notification.data.c.h hVar, com.paytm.notification.data.c.j jVar) {
        this.f43212b = context;
        this.f43215f = cVar;
        this.f43213c = bVar;
        this.f43216g = hVar;
        this.f43217h = jVar;
        this.f43211a = Executors.newCachedThreadPool();
    }

    public /* synthetic */ i(Context context, com.paytm.notification.schedulers.c cVar, com.paytm.notification.data.c.b bVar, com.paytm.notification.data.c.h hVar, com.paytm.notification.data.c.j jVar, byte b2) {
        this(context, cVar, bVar, hVar, jVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x004a, code lost:
        r3 = r3.getContent();
     */
    /* JADX WARNING: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0189 A[Catch:{ Exception -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0197 A[SYNTHETIC, Splitter:B:64:0x0197] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.firebase.messaging.RemoteMessage r13) {
        /*
            r12 = this;
            java.lang.String r0 = "EXTRA_PUSH_SERIALIZED"
            java.lang.String r1 = "context.applicationContext"
            java.lang.String r2 = "remoteMessage"
            kotlin.g.b.k.c(r13, r2)
            java.util.Map r2 = r13.b()
            java.lang.String r3 = "remoteMessage.data"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            com.paytm.notification.models.PushMessage r2 = r12.a((java.util.Map<java.lang.String, java.lang.String>) r2)
            if (r2 != 0) goto L_0x0019
            return
        L_0x0019:
            java.lang.String r3 = r13.c()
            r2.setMessageId(r3)
            long r3 = r13.d()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r2.setSendTime(r3)
            java.lang.String r13 = r13.a()
            r2.setSenderId(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r3 = r2.getPushId()
            r13.append(r3)
            java.lang.String r3 = "_"
            r13.append(r3)
            com.paytm.notification.models.Notification r3 = r2.getNotification()
            r4 = 0
            if (r3 == 0) goto L_0x0055
            com.paytm.notification.models.Content r3 = r3.getContent()
            if (r3 == 0) goto L_0x0055
            java.lang.String r3 = r3.getType()
            goto L_0x0056
        L_0x0055:
            r3 = r4
        L_0x0056:
            r13.append(r3)
            java.lang.String r13 = r13.toString()
            java.util.concurrent.ExecutorService r3 = r12.f43211a
            com.paytm.notification.i$i r5 = new com.paytm.notification.i$i
            r5.<init>(r13)
            java.lang.Runnable r5 = (java.lang.Runnable) r5
            r3.execute(r5)
            long r5 = r2.getExpiry()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0078
            long r5 = r2.getExpiry()
            goto L_0x008c
        L_0x0078:
            java.util.Date r3 = new java.util.Date
            r3.<init>()
            long r5 = r3.getTime()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            r7 = 7
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.DAYS
            long r7 = r3.convert(r7, r9)
            long r5 = r5 + r7
        L_0x008c:
            com.paytm.notification.data.datasource.dao.l r3 = new com.paytm.notification.data.datasource.dao.l
            r3.<init>(r13, r5)
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            long r5 = r5.getTime()
            boolean r7 = a((long) r5)
            if (r7 == 0) goto L_0x00ac
            java.util.concurrent.ExecutorService r7 = r12.f43211a
            com.paytm.notification.i$j r8 = new com.paytm.notification.i$j
            r8.<init>(r12, r5)
            java.lang.Runnable r8 = (java.lang.Runnable) r8
            r7.execute(r8)
        L_0x00ac:
            com.paytm.notification.g$c r5 = com.paytm.notification.g.f43191a
            java.util.List r5 = com.paytm.notification.g.c.b()
            boolean r5 = r5.contains(r3)
            r10 = 0
            if (r5 == 0) goto L_0x00d7
            java.util.concurrent.ExecutorService r0 = r12.f43211a
            com.paytm.notification.i$k r1 = new com.paytm.notification.i$k
            r1.<init>(r12, r2)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r0.execute(r1)
            com.paytm.notification.b.e$b r0 = com.paytm.notification.b.e.f43014a
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r1 = "Duplicate Push ID received. Ignoring the push: "
            java.lang.String r13 = r1.concat(r13)
            java.lang.Object[] r1 = new java.lang.Object[r10]
            r0.d(r13, r1)
            return
        L_0x00d7:
            com.paytm.notification.g$c r13 = com.paytm.notification.g.f43191a
            java.lang.String r13 = "pushData"
            kotlin.g.b.k.c(r3, r13)
            java.util.List r13 = com.paytm.notification.g.c.b()
            r13.add(r3)
            java.util.concurrent.ExecutorService r13 = r12.f43211a
            com.paytm.notification.i$l r5 = new com.paytm.notification.i$l
            r5.<init>(r12, r3)
            java.lang.Runnable r5 = (java.lang.Runnable) r5
            r13.execute(r5)
            com.paytm.notification.data.c.h r13 = r12.f43216g
            if (r13 == 0) goto L_0x0100
            com.paytm.notification.models.NotificationUserConfig r13 = r13.a()
            if (r13 == 0) goto L_0x0100
            java.lang.Boolean r13 = r13.isPushEnabled$paytmnotification_paytmRelease()
            goto L_0x0101
        L_0x0100:
            r13 = r4
        L_0x0101:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.Object) r3)
            if (r13 == 0) goto L_0x0427
            boolean r13 = r2.isSilent()     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x014f
            com.paytm.notification.models.Notification r13 = r2.getNotification()     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x011a
            java.util.HashMap r13 = r13.getExtras()     // Catch:{ Exception -> 0x041e }
            goto L_0x011b
        L_0x011a:
            r13 = r4
        L_0x011b:
            if (r13 == 0) goto L_0x014f
            com.paytm.notification.models.Notification r13 = r2.getNotification()     // Catch:{ Exception -> 0x041e }
            if (r13 != 0) goto L_0x0126
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x041e }
        L_0x0126:
            java.util.HashMap r13 = r13.getExtras()     // Catch:{ Exception -> 0x041e }
            if (r13 != 0) goto L_0x012f
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x041e }
        L_0x012f:
            java.lang.String r3 = "sendActivityLog"
            java.lang.Object r13 = r13.get(r3)     // Catch:{ Exception -> 0x041e }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x041e }
            java.lang.String r3 = "true"
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.Object) r3)     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x014f
            com.paytm.notification.b.a r13 = com.paytm.notification.b.a.f42999a     // Catch:{ Exception -> 0x041e }
            java.lang.String r13 = r2.getPushId()     // Catch:{ Exception -> 0x041e }
            if (r13 != 0) goto L_0x014b
            java.lang.String r13 = "-1"
        L_0x014b:
            com.paytm.notification.b.a.e(r13)     // Catch:{ Exception -> 0x041e }
            return
        L_0x014f:
            kotlin.g.b.x$e r13 = new kotlin.g.b.x$e     // Catch:{ Exception -> 0x041e }
            r13.<init>()     // Catch:{ Exception -> 0x041e }
            r13.element = r4     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.models.Context r3 = r2.getContext()     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x0161
            java.lang.String r3 = r3.getPushId()     // Catch:{ Exception -> 0x041e }
            goto L_0x0162
        L_0x0161:
            r3 = r4
        L_0x0162:
            r11 = 1
            if (r3 != 0) goto L_0x016b
            java.lang.String r3 = "pushMessage.context?.pushId == null"
            r13.element = r3     // Catch:{ Exception -> 0x041e }
        L_0x0169:
            r3 = 0
            goto L_0x0187
        L_0x016b:
            boolean r3 = r2.isExpired$paytmnotification_paytmRelease()     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x0186
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x041e }
            java.lang.String r5 = "pushMessage.isExpired() Expiry: "
            r3.<init>(r5)     // Catch:{ Exception -> 0x041e }
            long r5 = r2.getExpiry()     // Catch:{ Exception -> 0x041e }
            r3.append(r5)     // Catch:{ Exception -> 0x041e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x041e }
            r13.element = r3     // Catch:{ Exception -> 0x041e }
            goto L_0x0169
        L_0x0186:
            r3 = 1
        L_0x0187:
            if (r3 != 0) goto L_0x0195
            java.util.concurrent.ExecutorService r5 = r12.f43211a     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.i$o r6 = new com.paytm.notification.i$o     // Catch:{ Exception -> 0x041e }
            r6.<init>(r2, r13)     // Catch:{ Exception -> 0x041e }
            java.lang.Runnable r6 = (java.lang.Runnable) r6     // Catch:{ Exception -> 0x041e }
            r5.execute(r6)     // Catch:{ Exception -> 0x041e }
        L_0x0195:
            if (r3 == 0) goto L_0x0426
            android.content.Intent r13 = new android.content.Intent     // Catch:{ Exception -> 0x01de }
            java.lang.String r3 = "com.paytm.notification.RECEIVED"
            r13.<init>(r3)     // Catch:{ Exception -> 0x01de }
            com.google.gson.f r3 = new com.google.gson.f     // Catch:{ Exception -> 0x01de }
            r3.<init>()     // Catch:{ Exception -> 0x01de }
            java.lang.String r3 = r3.b(r2)     // Catch:{ Exception -> 0x01de }
            android.content.Intent r13 = r13.putExtra(r0, r3)     // Catch:{ Exception -> 0x01de }
            android.content.Context r3 = r12.f43212b     // Catch:{ Exception -> 0x01de }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ Exception -> 0x01de }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x01de }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x01de }
            android.content.Intent r13 = r13.addCategory(r3)     // Catch:{ Exception -> 0x01de }
            android.content.Context r3 = r12.f43212b     // Catch:{ Exception -> 0x01de }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ Exception -> 0x01de }
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x01de }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x01de }
            android.content.Intent r13 = r13.setPackage(r3)     // Catch:{ Exception -> 0x01de }
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r13 = r13.addFlags(r3)     // Catch:{ Exception -> 0x01de }
            java.lang.String r3 = "Intent(PushConstants.ACT…FLAG_RECEIVER_FOREGROUND)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)     // Catch:{ Exception -> 0x01de }
            android.content.Context r3 = r12.f43212b     // Catch:{ Exception -> 0x01de }
            r3.sendBroadcast(r13, r4)     // Catch:{ Exception -> 0x01de }
            goto L_0x01e6
        L_0x01de:
            r13 = move-exception
            com.paytm.notification.b.e$b r3 = com.paytm.notification.b.e.f43014a     // Catch:{ Exception -> 0x041e }
            java.lang.Throwable r13 = (java.lang.Throwable) r13     // Catch:{ Exception -> 0x041e }
            r3.b(r13)     // Catch:{ Exception -> 0x041e }
        L_0x01e6:
            com.paytm.notification.data.c.b r13 = r12.f43213c     // Catch:{ Exception -> 0x041e }
            int r13 = r13.d()     // Catch:{ Exception -> 0x041e }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x041e }
            r2.setNotificationId(r13)     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.data.c.h r13 = r12.f43216g     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x0208
            com.paytm.notification.models.NotificationUserConfig r13 = r13.a()     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x0208
            java.lang.Integer r13 = r13.getMsgIcon$paytmnotification_paytmRelease()     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x0208
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x041e }
            goto L_0x0209
        L_0x0208:
            r13 = -1
        L_0x0209:
            r2.setNotificationIcon(r13)     // Catch:{ Exception -> 0x041e }
            boolean r13 = r2.isSilent()     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x0220
            java.util.concurrent.ExecutorService r13 = r12.f43211a     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.i$e r3 = new com.paytm.notification.i$e     // Catch:{ Exception -> 0x041e }
            r3.<init>(r12, r2)     // Catch:{ Exception -> 0x041e }
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ Exception -> 0x041e }
            r13.execute(r3)     // Catch:{ Exception -> 0x041e }
            goto L_0x02ba
        L_0x0220:
            boolean r13 = r2.isPush()     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x0243
            com.paytm.notification.c.d r13 = com.paytm.notification.c.d.f43025a     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.data.datasource.dao.i r13 = com.paytm.notification.c.d.a(r2)     // Catch:{ Exception -> 0x041e }
            r13.f43157c = r11     // Catch:{ Exception -> 0x041e }
            r13.f43158d = r11     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.data.c.b r3 = r12.f43213c     // Catch:{ Exception -> 0x041e }
            r3.a((com.paytm.notification.data.datasource.dao.i) r13)     // Catch:{ Exception -> 0x041e }
            java.util.concurrent.ExecutorService r13 = r12.f43211a     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.i$f r3 = new com.paytm.notification.i$f     // Catch:{ Exception -> 0x041e }
            r3.<init>(r12, r2)     // Catch:{ Exception -> 0x041e }
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ Exception -> 0x041e }
            r13.execute(r3)     // Catch:{ Exception -> 0x041e }
            goto L_0x02ba
        L_0x0243:
            boolean r13 = r2.isFlash()     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x02ba
            com.paytm.notification.data.datasource.dao.c r13 = com.paytm.notification.c.c.a((com.paytm.notification.models.PushMessage) r2)     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.data.c.h r3 = r12.f43216g     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x025c
            com.paytm.notification.models.NotificationUserConfig r3 = r3.a()     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x025c
            java.lang.String r3 = r3.getCustomerId$paytmnotification_paytmRelease()     // Catch:{ Exception -> 0x041e }
            goto L_0x025d
        L_0x025c:
            r3 = r4
        L_0x025d:
            if (r3 != 0) goto L_0x026c
            java.util.concurrent.ExecutorService r0 = r12.f43211a     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.i$g r1 = new com.paytm.notification.i$g     // Catch:{ Exception -> 0x041e }
            r1.<init>(r12, r13)     // Catch:{ Exception -> 0x041e }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ Exception -> 0x041e }
            r0.execute(r1)     // Catch:{ Exception -> 0x041e }
            return
        L_0x026c:
            java.lang.String r3 = r13.s     // Catch:{ Exception -> 0x041e }
            java.lang.String r5 = ""
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r5)     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x028e
            com.paytm.notification.data.c.h r3 = r12.f43216g     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x0285
            com.paytm.notification.models.NotificationUserConfig r3 = r3.a()     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x0285
            java.lang.String r3 = r3.getCustomerId$paytmnotification_paytmRelease()     // Catch:{ Exception -> 0x041e }
            goto L_0x0286
        L_0x0285:
            r3 = r4
        L_0x0286:
            if (r3 != 0) goto L_0x028b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x041e }
        L_0x028b:
            r13.c(r3)     // Catch:{ Exception -> 0x041e }
        L_0x028e:
            com.paytm.notification.j r3 = com.paytm.notification.j.f43241a     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.data.c.d r3 = r3.e()     // Catch:{ Exception -> 0x041e }
            r3.a((com.paytm.notification.data.datasource.dao.c) r13)     // Catch:{ Exception -> 0x041e }
            java.util.concurrent.ExecutorService r3 = r12.f43211a     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.i$h r5 = new com.paytm.notification.i$h     // Catch:{ Exception -> 0x041e }
            r5.<init>(r12, r13)     // Catch:{ Exception -> 0x041e }
            java.lang.Runnable r5 = (java.lang.Runnable) r5     // Catch:{ Exception -> 0x041e }
            r3.execute(r5)     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.data.c.h r13 = r12.f43216g     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.models.NotificationProjectConfig r13 = r13.g()     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x02b0
            java.lang.Boolean r13 = r13.getShowFlashFromPush$paytmnotification_paytmRelease()     // Catch:{ Exception -> 0x041e }
            goto L_0x02b1
        L_0x02b0:
            r13 = r4
        L_0x02b1:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x041e }
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.Object) r3)     // Catch:{ Exception -> 0x041e }
            r13 = r13 ^ r11
            if (r13 != 0) goto L_0x0426
        L_0x02ba:
            java.util.concurrent.CountDownLatch r13 = new java.util.concurrent.CountDownLatch     // Catch:{ Exception -> 0x041e }
            r3 = 4
            r13.<init>(r3)     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.i$c r3 = new com.paytm.notification.i$c     // Catch:{ Exception -> 0x041e }
            r3.<init>(r13)     // Catch:{ Exception -> 0x041e }
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ Exception -> 0x041e }
            boolean r5 = r2.isSilent()     // Catch:{ Exception -> 0x041e }
            if (r5 == 0) goto L_0x03c4
            java.lang.String r5 = r2.getBadge()     // Catch:{ Exception -> 0x041e }
            if (r5 == 0) goto L_0x0377
            java.lang.String r0 = r2.getAudience_type()     // Catch:{ NumberFormatException -> 0x0372 }
            java.lang.String r1 = "user"
            if (r0 == 0) goto L_0x032c
            boolean r0 = r0.equals(r1)     // Catch:{ NumberFormatException -> 0x0372 }
            if (r0 != r11) goto L_0x032c
            java.lang.String r0 = r2.getAudience()     // Catch:{ NumberFormatException -> 0x0372 }
            if (r0 == 0) goto L_0x032c
            java.lang.String r0 = r2.getAudience()     // Catch:{ NumberFormatException -> 0x0372 }
            com.paytm.notification.data.c.h r5 = r12.f43216g     // Catch:{ NumberFormatException -> 0x0372 }
            if (r5 == 0) goto L_0x02fb
            com.paytm.notification.models.NotificationUserConfig r5 = r5.a()     // Catch:{ NumberFormatException -> 0x0372 }
            if (r5 == 0) goto L_0x02fb
            java.lang.String r5 = r5.getCustomerId$paytmnotification_paytmRelease()     // Catch:{ NumberFormatException -> 0x0372 }
            goto L_0x02fc
        L_0x02fb:
            r5 = r4
        L_0x02fc:
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r5, (boolean) r10)     // Catch:{ NumberFormatException -> 0x0372 }
            if (r0 == 0) goto L_0x032c
            java.lang.String r0 = r2.getBadge()     // Catch:{ NumberFormatException -> 0x0372 }
            if (r0 != 0) goto L_0x030b
            kotlin.g.b.k.a()     // Catch:{ NumberFormatException -> 0x0372 }
        L_0x030b:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0372 }
            com.paytm.notification.data.c.g$a r1 = com.paytm.notification.data.c.g.f43067b     // Catch:{ NumberFormatException -> 0x0372 }
            android.content.Context r1 = r12.f43212b     // Catch:{ NumberFormatException -> 0x0372 }
            int r1 = com.paytm.notification.data.c.g.a.a(r1)     // Catch:{ NumberFormatException -> 0x0372 }
            com.paytm.notification.schedulers.b.c$a r4 = com.paytm.notification.schedulers.b.c.f43258h     // Catch:{ NumberFormatException -> 0x0372 }
            android.content.Context r4 = r12.f43212b     // Catch:{ NumberFormatException -> 0x0372 }
            com.paytm.notification.schedulers.b.c.a.a(r4, r1, r0)     // Catch:{ NumberFormatException -> 0x0372 }
            com.paytm.notification.g$c r1 = com.paytm.notification.g.f43191a     // Catch:{ NumberFormatException -> 0x0372 }
            com.paytm.notification.i$b r1 = new com.paytm.notification.i$b     // Catch:{ NumberFormatException -> 0x0372 }
            r1.<init>(r12, r0)     // Catch:{ NumberFormatException -> 0x0372 }
            com.paytm.notification.models.callback.InboxHandlerReadyCallback r1 = (com.paytm.notification.models.callback.InboxHandlerReadyCallback) r1     // Catch:{ NumberFormatException -> 0x0372 }
            com.paytm.notification.g.c.a((com.paytm.notification.models.callback.InboxHandlerReadyCallback) r1)     // Catch:{ NumberFormatException -> 0x0372 }
            goto L_0x03c0
        L_0x032c:
            java.lang.String r0 = r2.getAudience_type()     // Catch:{ NumberFormatException -> 0x0372 }
            if (r0 == 0) goto L_0x0368
            boolean r0 = r0.equals(r1)     // Catch:{ NumberFormatException -> 0x0372 }
            if (r0 != r11) goto L_0x0368
            com.paytm.notification.b.e$b r0 = com.paytm.notification.b.e.f43014a     // Catch:{ NumberFormatException -> 0x0372 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0372 }
            java.lang.String r5 = "Discarding Badge silent push. Audience doesn't match. Audience = "
            r1.<init>(r5)     // Catch:{ NumberFormatException -> 0x0372 }
            java.lang.String r5 = r2.getAudience()     // Catch:{ NumberFormatException -> 0x0372 }
            r1.append(r5)     // Catch:{ NumberFormatException -> 0x0372 }
            java.lang.String r5 = " CustomerID = "
            r1.append(r5)     // Catch:{ NumberFormatException -> 0x0372 }
            com.paytm.notification.data.c.h r5 = r12.f43216g     // Catch:{ NumberFormatException -> 0x0372 }
            if (r5 == 0) goto L_0x035b
            com.paytm.notification.models.NotificationUserConfig r5 = r5.a()     // Catch:{ NumberFormatException -> 0x0372 }
            if (r5 == 0) goto L_0x035b
            java.lang.String r4 = r5.getCustomerId$paytmnotification_paytmRelease()     // Catch:{ NumberFormatException -> 0x0372 }
        L_0x035b:
            r1.append(r4)     // Catch:{ NumberFormatException -> 0x0372 }
            java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x0372 }
            java.lang.Object[] r4 = new java.lang.Object[r10]     // Catch:{ NumberFormatException -> 0x0372 }
            r0.d(r1, r4)     // Catch:{ NumberFormatException -> 0x0372 }
            goto L_0x03c0
        L_0x0368:
            com.paytm.notification.b.e$b r0 = com.paytm.notification.b.e.f43014a     // Catch:{ NumberFormatException -> 0x0372 }
            java.lang.String r1 = "Discarding Badge silent push. Audience type is is not USER"
            java.lang.Object[] r4 = new java.lang.Object[r10]     // Catch:{ NumberFormatException -> 0x0372 }
            r0.c(r1, r4)     // Catch:{ NumberFormatException -> 0x0372 }
            goto L_0x03c0
        L_0x0372:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x041e }
            goto L_0x03c0
        L_0x0377:
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x03b8 }
            java.lang.String r6 = "com.paytm.notification.SILENT"
            r5.<init>(r6)     // Catch:{ Exception -> 0x03b8 }
            com.google.gson.f r6 = new com.google.gson.f     // Catch:{ Exception -> 0x03b8 }
            r6.<init>()     // Catch:{ Exception -> 0x03b8 }
            java.lang.String r6 = r6.b(r2)     // Catch:{ Exception -> 0x03b8 }
            android.content.Intent r0 = r5.putExtra(r0, r6)     // Catch:{ Exception -> 0x03b8 }
            android.content.Context r5 = r12.f43212b     // Catch:{ Exception -> 0x03b8 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Exception -> 0x03b8 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x03b8 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x03b8 }
            android.content.Intent r0 = r0.addCategory(r5)     // Catch:{ Exception -> 0x03b8 }
            android.content.Context r5 = r12.f43212b     // Catch:{ Exception -> 0x03b8 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Exception -> 0x03b8 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x03b8 }
            java.lang.String r1 = r5.getPackageName()     // Catch:{ Exception -> 0x03b8 }
            android.content.Intent r0 = r0.setPackage(r1)     // Catch:{ Exception -> 0x03b8 }
            java.lang.String r1 = "Intent(PushConstants.ACT…ationContext.packageName)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x03b8 }
            android.content.Context r1 = r12.f43212b     // Catch:{ Exception -> 0x03b8 }
            r1.sendOrderedBroadcast(r0, r4)     // Catch:{ Exception -> 0x03b8 }
            goto L_0x03c0
        L_0x03b8:
            r0 = move-exception
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a     // Catch:{ Exception -> 0x041e }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x041e }
            r1.b(r0)     // Catch:{ Exception -> 0x041e }
        L_0x03c0:
            r3.run()     // Catch:{ Exception -> 0x041e }
            goto L_0x03c7
        L_0x03c4:
            r3.run()     // Catch:{ Exception -> 0x041e }
        L_0x03c7:
            boolean r0 = r2.isPush()     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x03e7
            java.util.concurrent.ExecutorService r0 = r12.f43211a     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.d.a r1 = new com.paytm.notification.d.a     // Catch:{ Exception -> 0x041e }
            android.content.Context r5 = r12.f43212b     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.j r4 = com.paytm.notification.j.f43241a     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.data.c.b r7 = r4.a()     // Catch:{ Exception -> 0x041e }
            com.paytm.notification.schedulers.c r9 = r12.f43215f     // Catch:{ Exception -> 0x041e }
            r4 = r1
            r6 = r3
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x041e }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ Exception -> 0x041e }
            r0.execute(r1)     // Catch:{ Exception -> 0x041e }
            goto L_0x03ea
        L_0x03e7:
            r3.run()     // Catch:{ Exception -> 0x041e }
        L_0x03ea:
            boolean r0 = r2.isFlash()     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x03fb
            com.paytm.notification.b r0 = r12.f43214e     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x03f7
            r0.a()     // Catch:{ Exception -> 0x041e }
        L_0x03f7:
            r3.run()     // Catch:{ Exception -> 0x041e }
            goto L_0x03fe
        L_0x03fb:
            r3.run()     // Catch:{ Exception -> 0x041e }
        L_0x03fe:
            r2.isInBox()     // Catch:{ Exception -> 0x041e }
            r3.run()     // Catch:{ Exception -> 0x041e }
            r13.await()     // Catch:{ InterruptedException -> 0x0411 }
            com.paytm.notification.b.e$b r13 = com.paytm.notification.b.e.f43014a     // Catch:{ InterruptedException -> 0x0411 }
            java.lang.String r0 = "Notification count down latch exit successfully"
            java.lang.Object[] r1 = new java.lang.Object[r10]     // Catch:{ InterruptedException -> 0x0411 }
            r13.b(r0, r1)     // Catch:{ InterruptedException -> 0x0411 }
            return
        L_0x0411:
            r13 = move-exception
            com.paytm.notification.b.e$b r0 = com.paytm.notification.b.e.f43014a     // Catch:{ Exception -> 0x041e }
            java.lang.String r1 = "Failed to wait for push."
            java.lang.Object[] r2 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x041e }
            r2[r10] = r13     // Catch:{ Exception -> 0x041e }
            r0.b(r1, r2)     // Catch:{ Exception -> 0x041e }
            return
        L_0x041e:
            r13 = move-exception
            com.paytm.notification.b.e$b r0 = com.paytm.notification.b.e.f43014a
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            r0.b(r13)
        L_0x0426:
            return
        L_0x0427:
            java.util.concurrent.ExecutorService r13 = r12.f43211a
            com.paytm.notification.i$m r0 = new com.paytm.notification.i$m
            r0.<init>(r2)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r13.execute(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.i.a(com.google.firebase.messaging.RemoteMessage):void");
    }

    /* renamed from: com.paytm.notification.i$i  reason: collision with other inner class name */
    static final class C0727i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f43230a;

        C0727i(String str) {
            this.f43230a = str;
        }

        public final void run() {
            try {
                g.c cVar = g.f43191a;
                ErrorReportCallback f2 = g.l;
                if (f2 != null) {
                    f2.onErrorLog("[PushSDK] Push received: " + this.f43230a);
                }
            } catch (Exception unused) {
            }
        }
    }

    static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f43231a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f43232b;

        j(i iVar, long j) {
            this.f43231a = iVar;
            this.f43232b = j;
        }

        public final void run() {
            this.f43231a.f43217h.a(this.f43232b);
        }
    }

    static final class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f43233a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PushMessage f43234b;

        k(i iVar, PushMessage pushMessage) {
            this.f43233a = iVar;
            this.f43234b = pushMessage;
        }

        public final void run() {
            this.f43233a.f43213c.e(this.f43234b);
        }
    }

    static final class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f43235a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.notification.data.datasource.dao.l f43236b;

        l(i iVar, com.paytm.notification.data.datasource.dao.l lVar) {
            this.f43235a = iVar;
            this.f43236b = lVar;
        }

        public final void run() {
            this.f43235a.f43217h.a(this.f43236b);
        }
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PushMessage f43237a;

        m(PushMessage pushMessage) {
            this.f43237a = pushMessage;
        }

        public final void run() {
            j.f43241a.a().b(this.f43237a, "Config server turned off Push service");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r1 = r1.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.paytm.notification.models.PushMessage a(java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            r3 = this;
            r0 = 0
            com.paytm.notification.c.e r1 = com.paytm.notification.c.e.f43026a     // Catch:{ Exception -> 0x0031 }
            com.paytm.notification.models.PushMessage r4 = com.paytm.notification.c.e.a(r4)     // Catch:{ Exception -> 0x0031 }
            if (r4 != 0) goto L_0x000a
            return r0
        L_0x000a:
            if (r4 != 0) goto L_0x000f
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0031 }
        L_0x000f:
            com.paytm.notification.data.c.h r1 = r3.f43216g     // Catch:{ Exception -> 0x0031 }
            if (r1 == 0) goto L_0x001e
            com.paytm.notification.models.NotificationUserConfig r1 = r1.a()     // Catch:{ Exception -> 0x0031 }
            if (r1 == 0) goto L_0x001e
            java.lang.String r1 = r1.getCustomerId$paytmnotification_paytmRelease()     // Catch:{ Exception -> 0x0031 }
            goto L_0x001f
        L_0x001e:
            r1 = r0
        L_0x001f:
            boolean r1 = a((com.paytm.notification.models.PushMessage) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x0031 }
            if (r1 != 0) goto L_0x0030
            com.paytm.notification.b.e$b r4 = com.paytm.notification.b.e.f43014a     // Catch:{ Exception -> 0x0031 }
            java.lang.String r1 = "Discarding notification .. either user is logged out or not a valid user for this notification"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0031 }
            r4.b(r1, r2)     // Catch:{ Exception -> 0x0031 }
            return r0
        L_0x0030:
            return r4
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.i.a(java.util.Map):com.paytm.notification.models.PushMessage");
    }

    private static boolean a(long j2) {
        g.c cVar = g.f43191a;
        Iterator<com.paytm.notification.data.datasource.dao.l> it2 = g.c.b().iterator();
        boolean z = false;
        while (it2.hasNext()) {
            com.paytm.notification.data.datasource.dao.l next = it2.next();
            if (next.f43173c <= j2) {
                z = true;
                e.b bVar = com.paytm.notification.b.e.f43014a;
                bVar.b("push [" + next.f43172b + "] is EXPIRED and DELETED", new Object[0]);
                it2.remove();
            }
        }
        return z;
    }

    public final void a(Integer num) {
        if (num != null) {
            this.f43213c.a(num.intValue());
            this.f43213c.a(num.intValue(), 3);
        }
    }

    public final void b(Integer num) {
        if (num != null) {
            this.f43213c.b(num.intValue());
            this.f43213c.a(num.intValue(), 4);
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f43222a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PushMessage f43223b;

        e(i iVar, PushMessage pushMessage) {
            this.f43222a = iVar;
            this.f43223b = pushMessage;
        }

        public final void run() {
            this.f43222a.f43213c.b(this.f43223b);
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f43224a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PushMessage f43225b;

        f(i iVar, PushMessage pushMessage) {
            this.f43224a = iVar;
            this.f43225b = pushMessage;
        }

        public final void run() {
            this.f43224a.f43213c.b();
            this.f43224a.f43213c.a(this.f43225b);
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f43226a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.notification.data.datasource.dao.c f43227b;

        g(i iVar, com.paytm.notification.data.datasource.dao.c cVar) {
            this.f43226a = iVar;
            this.f43227b = cVar;
        }

        public final void run() {
            com.paytm.notification.b.e.f43014a.c("Flash received while customerId == null. Flash not displaying.", new Object[0]);
            com.paytm.notification.data.c.b b2 = this.f43226a.f43213c;
            String str = this.f43227b.f43116f;
            String str2 = this.f43227b.f43115e;
            if (str2 == null) {
                str2 = "";
            }
            b2.a(str, str2, "customer id null - customer may have logged out");
            this.f43226a.f43213c.a();
        }
    }

    static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f43228a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.notification.data.datasource.dao.c f43229b;

        h(i iVar, com.paytm.notification.data.datasource.dao.c cVar) {
            this.f43228a = iVar;
            this.f43229b = cVar;
        }

        public final void run() {
            com.paytm.notification.data.c.b b2 = this.f43228a.f43213c;
            String str = this.f43229b.f43116f;
            String str2 = this.f43229b.f43115e;
            if (str2 == null) {
                str2 = "";
            }
            b2.d(str, str2);
        }
    }

    public static final class b implements InboxHandlerReadyCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f43218a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f43219b;

        b(i iVar, int i2) {
            this.f43218a = iVar;
            this.f43219b = i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
            r0 = r0.a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCallbackReady(com.paytm.notification.c r4) {
            /*
                r3 = this;
                java.lang.String r0 = "inboxHandler"
                kotlin.g.b.k.c(r4, r0)
                androidx.lifecycle.y r0 = r4.e()
                androidx.lifecycle.LiveData r1 = r4.a()
                if (r0 == 0) goto L_0x0018
                int r2 = r3.f43219b
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r0.postValue(r2)
            L_0x0018:
                r2 = 1
                if (r0 == 0) goto L_0x0021
                boolean r0 = r0.hasActiveObservers()
                if (r0 == r2) goto L_0x0029
            L_0x0021:
                if (r1 == 0) goto L_0x005d
                boolean r0 = r1.hasActiveObservers()
                if (r0 != r2) goto L_0x005d
            L_0x0029:
                com.paytm.notification.i r0 = r3.f43218a
                com.paytm.notification.data.c.h r0 = r0.f43216g
                r1 = 0
                if (r0 == 0) goto L_0x003d
                com.paytm.notification.models.NotificationUserConfig r0 = r0.a()
                if (r0 == 0) goto L_0x003d
                java.lang.String r0 = r0.getCustomerId$paytmnotification_paytmRelease()
                goto L_0x003e
            L_0x003d:
                r0 = r1
            L_0x003e:
                if (r0 == 0) goto L_0x005d
                com.paytm.notification.i r0 = r3.f43218a
                com.paytm.notification.data.c.h r0 = r0.f43216g
                if (r0 == 0) goto L_0x0052
                com.paytm.notification.models.NotificationUserConfig r0 = r0.a()
                if (r0 == 0) goto L_0x0052
                java.lang.Boolean r1 = r0.isInboxEnabled$paytmnotification_paytmRelease()
            L_0x0052:
                java.lang.Boolean r0 = java.lang.Boolean.TRUE
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x005d
                r4.c()
            L_0x005d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.i.b.onCallbackReady(com.paytm.notification.c):void");
        }
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PushMessage f43239a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f43240b;

        o(PushMessage pushMessage, x.e eVar) {
            this.f43239a = pushMessage;
            this.f43240b = eVar;
        }

        public final void run() {
            com.paytm.notification.data.c.b a2 = j.f43241a.a();
            PushMessage pushMessage = this.f43239a;
            String str = (String) this.f43240b.element;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            a2.b(pushMessage, str);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f43220a;

        c(CountDownLatch countDownLatch) {
            this.f43220a = countDownLatch;
        }

        public final void run() {
            this.f43220a.countDown();
        }
    }

    static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f43238a;

        n(i iVar) {
            this.f43238a = iVar;
        }

        public final void run() {
            FlashManager.b bVar = FlashManager.f42980a;
            Context applicationContext = this.f43238a.f43212b.getApplicationContext();
            kotlin.g.b.k.a((Object) applicationContext, "context.applicationContext");
            kotlin.g.b.k.c(applicationContext, "context");
            if (FlashManager.m == null) {
                synchronized (f.class) {
                    if (FlashManager.m == null) {
                        Context applicationContext2 = applicationContext.getApplicationContext();
                        kotlin.g.b.k.a((Object) applicationContext2, "context.applicationContext");
                        com.paytm.notification.data.c.b a2 = j.f43241a.a();
                        com.paytm.notification.data.c.d e2 = j.f43241a.e();
                        a.C0717a aVar = a.f42997a;
                        FlashManager.m = new FlashManager(applicationContext2, a2, e2, a.C0717a.a(applicationContext));
                        FlashManager e3 = FlashManager.m;
                        if (e3 != null) {
                            a.a(applicationContext, new FlashManager.c());
                        }
                    }
                    kotlin.x xVar = kotlin.x.f47997a;
                }
            }
            i iVar = this.f43238a;
            FlashManager.b bVar2 = FlashManager.f42980a;
            if (FlashManager.m != null) {
                iVar.f43214e = FlashManager.m;
                return;
            }
            throw new com.paytm.notification.a.a.a("You need to call init() at least once to create the singleton");
        }
    }

    public final void a() {
        b bVar = this.f43214e;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void b() {
        this.f43211a.execute(new d(this));
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f43221a;

        d(i iVar) {
            this.f43221a = iVar;
        }

        public final void run() {
            try {
                this.f43221a.f43215f.d();
            } catch (Exception e2) {
                com.paytm.notification.b.e.f43014a.b(e2);
            }
        }
    }

    public final void c() {
        this.f43215f.g();
    }

    private static boolean a(PushMessage pushMessage, String str) {
        try {
            if (pushMessage.getUserId() == null) {
                return true;
            }
            if (str == null || !kotlin.g.b.k.a((Object) str, (Object) pushMessage.getUserId())) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            com.paytm.notification.b.e.f43014a.b(e2);
            return false;
        }
    }
}
