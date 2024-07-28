package com.paytm.notification;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.paytm.notification.a;
import com.paytm.notification.b.e;
import com.paytm.notification.i;
import com.paytm.notification.models.FlashMessage;
import com.paytm.notification.models.NotificationProjectConfig;
import com.paytm.notification.models.NotificationUserConfig;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;

public class FlashManager implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f42980a = new b((byte) 0);
    /* access modifiers changed from: private */
    public static FlashManager m;
    /* access modifiers changed from: private */
    public static long n;
    /* access modifiers changed from: private */
    public static int o;
    /* access modifiers changed from: private */
    public static String p;

    /* renamed from: b  reason: collision with root package name */
    private final String f42981b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f42982c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Activity> f42983d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f42984e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.g f42985f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f42986g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f42987h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final com.paytm.notification.data.c.b f42988i;
    /* access modifiers changed from: private */
    public final com.paytm.notification.data.c.d j;
    private final a k;
    /* access modifiers changed from: private */
    public final com.paytm.notification.ui.inapp.view.a l;

    static final class a extends l implements kotlin.g.a.a<Long> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final long invoke() {
            return 5000;
        }
    }

    private FlashManager(Context context, com.paytm.notification.data.c.b bVar, com.paytm.notification.data.c.d dVar, a aVar, com.paytm.notification.ui.inapp.view.a aVar2) {
        k.c(context, "context");
        k.c(bVar, "analyticsRepo");
        k.c(dVar, "flashRepo");
        k.c(aVar, "activityMonitor");
        k.c(aVar2, "flashDisplayAdapter");
        this.f42987h = context;
        this.f42988i = bVar;
        this.j = dVar;
        this.k = aVar;
        this.l = aVar2;
        this.f42981b = "com.paytm.push.INCLUDE_FLASH_SHOW";
        this.f42982c = Executors.newCachedThreadPool();
        this.f42985f = h.a(a.INSTANCE);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlashManager(Context context, com.paytm.notification.data.c.b bVar, com.paytm.notification.data.c.d dVar, a aVar) {
        this(context, bVar, dVar, aVar, com.paytm.notification.ui.inapp.view.b.a());
        com.paytm.notification.ui.inapp.view.b bVar2 = com.paytm.notification.ui.inapp.view.b.f43383a;
    }

    public final void a() {
        g();
    }

    /* access modifiers changed from: private */
    public final void g() {
        WeakReference<Activity> weakReference = this.f42983d;
        if (!a(weakReference != null ? (Activity) weakReference.get() : null)) {
            b.a();
        } else if (!this.f42986g) {
            this.f42982c.execute(new f(this));
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlashManager f42994a;

        f(FlashManager flashManager) {
            this.f42994a = flashManager;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r9 = this;
                java.lang.Class<com.paytm.notification.FlashManager> r0 = com.paytm.notification.FlashManager.class
                monitor-enter(r0)
                com.paytm.notification.FlashManager r1 = r9.f42994a     // Catch:{ all -> 0x0095 }
                boolean r1 = com.paytm.notification.FlashManager.i(r1)     // Catch:{ all -> 0x0095 }
                if (r1 == 0) goto L_0x000d
                monitor-exit(r0)
                return
            L_0x000d:
                com.paytm.notification.FlashManager r1 = r9.f42994a     // Catch:{ all -> 0x0095 }
                com.paytm.notification.data.c.d r1 = r1.j     // Catch:{ all -> 0x0095 }
                java.util.List r1 = r1.a()     // Catch:{ all -> 0x0095 }
                if (r1 == 0) goto L_0x0091
                r2 = r1
                java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0095 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0095 }
                r3 = 1
                r2 = r2 ^ r3
                if (r2 == 0) goto L_0x0091
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0095 }
                r2 = 0
                r4 = 0
            L_0x002a:
                boolean r5 = r1.hasNext()     // Catch:{ all -> 0x0095 }
                if (r5 == 0) goto L_0x0086
                java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x0095 }
                com.paytm.notification.data.datasource.dao.c r5 = (com.paytm.notification.data.datasource.dao.c) r5     // Catch:{ all -> 0x0095 }
                java.lang.String r6 = r5.f43119i     // Catch:{ all -> 0x0095 }
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x0095 }
                if (r6 == 0) goto L_0x0045
                int r6 = r6.length()     // Catch:{ all -> 0x0095 }
                if (r6 != 0) goto L_0x0043
                goto L_0x0045
            L_0x0043:
                r6 = 0
                goto L_0x0046
            L_0x0045:
                r6 = 1
            L_0x0046:
                if (r6 == 0) goto L_0x0073
                com.paytm.notification.b.e$b r4 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x0095 }
                java.lang.String r6 = "Flash Ignored. Empty flash message"
                java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x0095 }
                r4.c(r6, r7)     // Catch:{ all -> 0x0095 }
                com.paytm.notification.FlashManager r4 = r9.f42994a     // Catch:{ all -> 0x0095 }
                com.paytm.notification.data.c.b r4 = r4.f42988i     // Catch:{ all -> 0x0095 }
                java.lang.String r6 = r5.f43116f     // Catch:{ all -> 0x0095 }
                java.lang.String r7 = r5.f43115e     // Catch:{ all -> 0x0095 }
                if (r7 != 0) goto L_0x005f
                java.lang.String r7 = ""
            L_0x005f:
                java.lang.String r8 = "empty flash message"
                r4.a(r6, r7, r8)     // Catch:{ all -> 0x0095 }
                com.paytm.notification.FlashManager r4 = r9.f42994a     // Catch:{ all -> 0x0095 }
                com.paytm.notification.data.c.d r4 = r4.j     // Catch:{ all -> 0x0095 }
                java.lang.String r6 = r5.s     // Catch:{ all -> 0x0095 }
                java.lang.String r5 = r5.f43116f     // Catch:{ all -> 0x0095 }
                r4.b((java.lang.String) r6, (java.lang.String) r5)     // Catch:{ all -> 0x0095 }
                r4 = 1
                goto L_0x002a
            L_0x0073:
                com.paytm.notification.b.e$b r6 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x0095 }
                java.lang.String r7 = "Found a flash to display"
                java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x0095 }
                r6.b(r7, r8)     // Catch:{ all -> 0x0095 }
                com.paytm.notification.models.FlashMessage r5 = com.paytm.notification.c.c.a((com.paytm.notification.data.datasource.dao.c) r5)     // Catch:{ all -> 0x0095 }
                com.paytm.notification.FlashManager r6 = r9.f42994a     // Catch:{ all -> 0x0095 }
                r6.a((com.paytm.notification.models.FlashMessage) r5)     // Catch:{ all -> 0x0095 }
                goto L_0x002a
            L_0x0086:
                if (r4 == 0) goto L_0x0091
                com.paytm.notification.FlashManager r1 = r9.f42994a     // Catch:{ all -> 0x0095 }
                com.paytm.notification.data.c.b r1 = r1.f42988i     // Catch:{ all -> 0x0095 }
                r1.a()     // Catch:{ all -> 0x0095 }
            L_0x0091:
                kotlin.x r1 = kotlin.x.f47997a     // Catch:{ all -> 0x0095 }
                monitor-exit(r0)
                return
            L_0x0095:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.FlashManager.f.run():void");
        }
    }

    /* access modifiers changed from: private */
    public final void a(FlashMessage flashMessage) {
        Activity activity;
        n = System.currentTimeMillis();
        p = flashMessage.getPushId();
        o = flashMessage.getDisplayPeriodInSecs();
        e.b bVar = com.paytm.notification.b.e.f43014a;
        bVar.a("FlashTesting: displaying flash for " + o + " seconds", new Object[0]);
        WeakReference<Activity> weakReference = this.f42983d;
        if (weakReference != null && (activity = (Activity) weakReference.get()) != null) {
            activity.runOnUiThread(new e(this, flashMessage));
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlashManager f42992a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FlashMessage f42993b;

        e(FlashManager flashManager, FlashMessage flashMessage) {
            this.f42992a = flashManager;
            this.f42993b = flashMessage;
        }

        public final void run() {
            FlashManager flashManager = this.f42992a;
            FlashMessage flashMessage = this.f42993b;
            WeakReference a2 = flashManager.f42983d;
            flashManager.a(flashMessage, a2 != null ? (Activity) a2.get() : null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r5 = r5.metaData;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(android.app.Activity r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.paytm.notification.e.a r1 = new com.paytm.notification.e.a     // Catch:{ Exception -> 0x0042 }
            r1.<init>()     // Catch:{ Exception -> 0x0042 }
            java.lang.Class r1 = r5.getClass()     // Catch:{ Exception -> 0x0042 }
            android.content.Context r5 = (android.content.Context) r5     // Catch:{ Exception -> 0x0042 }
            android.content.pm.ActivityInfo r5 = com.paytm.notification.e.a.a(r1, r5)     // Catch:{ Exception -> 0x0042 }
            if (r5 == 0) goto L_0x0024
            android.os.Bundle r5 = r5.metaData     // Catch:{ Exception -> 0x0042 }
            if (r5 == 0) goto L_0x0024
            java.lang.String r1 = r4.f42981b     // Catch:{ Exception -> 0x0042 }
            boolean r5 = r5.getBoolean(r1, r0)     // Catch:{ Exception -> 0x0042 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0025
        L_0x0024:
            r5 = 0
        L_0x0025:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0042 }
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0042 }
            if (r5 == 0) goto L_0x0038
            com.paytm.notification.b.e$b r5 = com.paytm.notification.b.e.f43014a     // Catch:{ Exception -> 0x0042 }
            java.lang.String r1 = "This Activity contains metadata to show flash message"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0042 }
            r5.a(r1, r2)     // Catch:{ Exception -> 0x0042 }
            r5 = 1
            return r5
        L_0x0038:
            com.paytm.notification.b.e$b r5 = com.paytm.notification.b.e.f43014a     // Catch:{ Exception -> 0x0042 }
            java.lang.String r1 = "This Activity does not contain metadata to show flash message. To show flash, add <meta-data android:name=\"com.paytm.push.INCLUDE_FLASH_SHOW\" android:value=\"true\"/>"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0042 }
            r5.a(r1, r2)     // Catch:{ Exception -> 0x0042 }
            return r0
        L_0x0042:
            r5 = move-exception
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a
            java.lang.Object[] r2 = new java.lang.Object[r0]
            java.lang.String r3 = "GoogleApiActivity casting error expectedly found on amazon/blayn/KYOCERA type of devices"
            r1.c(r3, r2)
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r1.a((java.lang.Throwable) r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.FlashManager.a(android.app.Activity):boolean");
    }

    /* access modifiers changed from: private */
    public final synchronized void a(FlashMessage flashMessage, Activity activity) {
        com.paytm.notification.b.e.f43014a.b("Display Flash message", new Object[0]);
        if (activity == null) {
            com.paytm.notification.b.e.f43014a.b("Null activity found... Display aborted", new Object[0]);
            return;
        }
        try {
            if (this.l.a(flashMessage, activity)) {
                this.f42986g = true;
                try {
                    Intent intent = new Intent("com.paytm.notification.flash.DISPLAYED");
                    Context applicationContext = this.f42987h.getApplicationContext();
                    Intent addCategory = intent.addCategory(applicationContext != null ? applicationContext.getPackageName() : null);
                    Context applicationContext2 = this.f42987h.getApplicationContext();
                    Intent putExtra = addCategory.setPackage(applicationContext2 != null ? applicationContext2.getPackageName() : null).putExtra("EXTRA_FLASH_SERIALIZED", new com.google.gson.f().b(flashMessage));
                    k.a((Object) putExtra, "Intent(ACTION_FLASH_DISP…ED, Gson().toJson(flash))");
                    Context applicationContext3 = this.f42987h.getApplicationContext();
                    if (applicationContext3 != null) {
                        applicationContext3.sendOrderedBroadcast(putExtra, (String) null);
                    }
                } catch (Exception e2) {
                    com.paytm.notification.b.e.f43014a.b(e2);
                }
                this.f42982c.execute(new d(this, flashMessage));
                com.paytm.notification.b.e.f43014a.b("Flash Displayed successfully", new Object[0]);
                return;
            }
            this.f42986g = false;
        } catch (Exception e3) {
            this.f42986g = false;
            com.paytm.notification.b.e.f43014a.b(e3);
            com.paytm.notification.b.e.f43014a.b("Fail to display flash", new Object[0]);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlashManager f42990a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FlashMessage f42991b;

        d(FlashManager flashManager, FlashMessage flashMessage) {
            this.f42990a = flashManager;
            this.f42991b = flashMessage;
        }

        public final void run() {
            this.f42990a.j.a(this.f42991b.getCustomerId(), this.f42991b.getPushId());
            com.paytm.notification.data.c.b k = this.f42990a.f42988i;
            String pushId = this.f42991b.getPushId();
            String campaignId = this.f42991b.getCampaignId();
            if (campaignId == null) {
                campaignId = "";
            }
            k.f(pushId, campaignId);
            this.f42990a.f42988i.a();
        }
    }

    public final class c extends a.b {
        public c() {
        }

        public final void onActivityPaused(Activity activity) {
            k.c(activity, "activity");
            try {
                FlashManager.this.f42983d = null;
                FlashManager.this.f42984e = System.currentTimeMillis();
                if (FlashManager.n > 0) {
                    FlashManager.o = (int) (((long) FlashManager.o) - ((System.currentTimeMillis() - FlashManager.n) / 1000));
                    e.b bVar = com.paytm.notification.b.e.f43014a;
                    bVar.a("FlashTesting: remaining time " + FlashManager.o, new Object[0]);
                }
                com.paytm.notification.ui.inapp.view.a c2 = FlashManager.this.l;
                if (c2 != null) {
                    c2.a(activity);
                }
                FlashManager.this.f42986g = false;
            } catch (Exception e2) {
                com.paytm.notification.b.e.f43014a.c("GoogleApiActivity casting error expectedly found on amazon/blayn/KYOCERA type of devices", new Object[0]);
                com.paytm.notification.b.e.f43014a.a((Throwable) e2);
            }
        }

        public final void onActivityResumed(Activity activity) {
            k.c(activity, "activity");
            try {
                long currentTimeMillis = System.currentTimeMillis() - FlashManager.this.f42984e;
                FlashManager.this.f42983d = new WeakReference(activity);
                NotificationUserConfig a2 = j.f43241a.c().a();
                if (FlashManager.this.f42984e != 0 && currentTimeMillis > ((Number) FlashManager.this.f42985f.getValue()).longValue()) {
                    if ((a2 != null ? a2.getCustomerId$paytmnotification_paytmRelease() : null) == null || !k.a((Object) a2.isFlashEnabled$paytmnotification_paytmRelease(), (Object) Boolean.TRUE)) {
                        i.a aVar = i.f43209d;
                        i d2 = i.f43210i;
                        if (d2 != null) {
                            d2.c();
                            return;
                        }
                        return;
                    }
                    i.a aVar2 = i.f43209d;
                    i d3 = i.f43210i;
                    if (d3 != null) {
                        d3.b();
                    }
                } else if (FlashManager.this.f42984e != 0) {
                    FlashManager.this.g();
                }
            } catch (Exception e2) {
                com.paytm.notification.b.e.f43014a.c("GoogleApiActivity casting error expectedly found on amazon/blayn/KYOCERA type of devices", new Object[0]);
                com.paytm.notification.b.e.f43014a.a((Throwable) e2);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            k.c(activity, "activity");
            FlashManager.this.f42984e = 0;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        static void a() {
            FlashManager.n = 0;
            FlashManager.o = 0;
            FlashManager.p = null;
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlashManager f42995a;

        g(FlashManager flashManager) {
            this.f42995a = flashManager;
        }

        public final void run() {
            this.f42995a.f42986g = false;
            b bVar = FlashManager.f42980a;
            b.a();
            NotificationProjectConfig g2 = j.f43241a.c().g();
            if (g2 != null && k.a((Object) g2.getShowFlashFromPush$paytmnotification_paytmRelease(), (Object) Boolean.TRUE)) {
                this.f42995a.g();
            }
        }
    }

    public static final class OnFlashDismissed extends BroadcastReceiver {
        public final void onReceive(Context context, Intent intent) {
            k.c(context, "context");
            com.paytm.notification.b.e.f43014a.b("flash dismissed", new Object[0]);
            FlashManager e2 = FlashManager.m;
            if (e2 != null) {
                e2.f42982c.execute(new g(e2));
            }
        }
    }

    public static final /* synthetic */ boolean i(FlashManager flashManager) {
        if (o > 0 && p != null) {
            com.paytm.notification.data.c.d e2 = j.f43241a.e();
            String str = p;
            if (str == null) {
                k.a();
            }
            com.paytm.notification.data.datasource.dao.c b2 = e2.b(str);
            if (b2 != null) {
                FlashMessage a2 = com.paytm.notification.c.c.a(b2);
                a2.setDisplayPeriodInSecs(o);
                flashManager.a(a2);
                return true;
            }
        }
        b.a();
        return false;
    }
}
