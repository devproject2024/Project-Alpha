package com.paytm.notification;

import android.content.Context;
import com.google.firebase.iid.FirebaseInstanceId;
import com.paytm.notification.b.e;
import com.paytm.notification.data.c.h;
import com.paytm.notification.models.JOB_RESULT;
import com.paytm.notification.models.NotificationProjectConfig;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.notification.models.PushConfig;
import com.paytm.notification.schedulers.b.e;
import com.paytm.notification.schedulers.b.g;
import com.paytm.notification.schedulers.jobs.LoginJob;
import com.paytm.notification.schedulers.jobs.LogoutJob;
import com.paytm.signal.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43174a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static f f43175h;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f43176b;

    /* renamed from: c  reason: collision with root package name */
    private final ReentrantLock f43177c;

    /* renamed from: d  reason: collision with root package name */
    private final Condition f43178d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f43179e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Context f43180f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final com.paytm.notification.schedulers.c f43181g;

    private f(Context context, com.paytm.notification.schedulers.c cVar) {
        this.f43180f = context;
        this.f43181g = cVar;
        this.f43176b = Executors.newCachedThreadPool();
        this.f43177c = new ReentrantLock();
        this.f43178d = this.f43177c.newCondition();
    }

    public /* synthetic */ f(Context context, com.paytm.notification.schedulers.c cVar, byte b2) {
        this(context, cVar);
    }

    public final void a(String str) {
        com.paytm.notification.schedulers.c cVar = this.f43181g;
        LogoutJob.a aVar = LogoutJob.f43326c;
        cVar.b(LogoutJob.f43327e);
        this.f43176b.execute(new d(this, str));
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f43184a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f43185b;

        d(f fVar, String str) {
            this.f43184a = fVar;
            this.f43185b = str;
        }

        public final void run() {
            try {
                f.a(this.f43184a, this.f43185b);
            } catch (com.paytm.notification.a.a.a e2) {
                e.f43014a.b(e2);
            }
        }
    }

    public final void a(PushConfig pushConfig) {
        Lock lock;
        k.c(pushConfig, "pushConfig");
        j.f43241a.c().c(pushConfig.getSecret$paytmnotification_paytmRelease());
        try {
            lock = this.f43177c;
            lock.lock();
            h c2 = j.f43241a.c();
            Context context = this.f43180f;
            k.c(pushConfig, "$this$mapToNotificationConfig");
            k.c(context, "context");
            NotificationUserConfig.Builder builder = new NotificationUserConfig.Builder();
            builder.setAppVersion$paytmnotification_paytmRelease(pushConfig.getAppVersion$paytmnotification_paytmRelease());
            builder.setClientName$paytmnotification_paytmRelease(pushConfig.getClientName$paytmnotification_paytmRelease());
            builder.setSecret$paytmnotification_paytmRelease(pushConfig.getSecret$paytmnotification_paytmRelease());
            builder.setMsgIcon$paytmnotification_paytmRelease(pushConfig.getMsgIcon$paytmnotification_paytmRelease());
            builder.setStaging$paytmnotification_paytmRelease(pushConfig.getStaging$paytmnotification_paytmRelease());
            com.paytm.notification.c.b bVar = com.paytm.notification.c.b.f43023b;
            builder.setDeviceId$paytmnotification_paytmRelease(com.paytm.notification.c.b.d(context));
            builder.setLoginState$paytmnotification_paytmRelease(pushConfig.getLoginMode$paytmnotification_paytmRelease());
            builder.setConfigEndPoints$paytmnotification_paytmRelease(pushConfig.getConfigEndPoints$paytmnotification_paytmRelease());
            c2.a(builder.build());
            e.f43014a.a("update config successful", new Object[0]);
            this.f43178d.signalAll();
            x xVar = x.f47997a;
            lock.unlock();
        } catch (com.paytm.notification.a.a.a e2) {
            e.f43014a.b(e2);
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public final void a(g gVar, NotificationProjectConfig notificationProjectConfig) {
        k.c(gVar, "paytmNotifications");
        k.c(notificationProjectConfig, "projectConfig");
        this.f43176b.execute(new b(this));
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f43182a;

        b(f fVar) {
            this.f43182a = fVar;
        }

        public final void run() {
            try {
                this.f43182a.f43181g.b("get_fcm_token");
                com.paytm.notification.schedulers.b.e eVar = com.paytm.notification.schedulers.b.e.f43267a;
                Context b2 = this.f43182a.f43180f;
                com.paytm.notification.schedulers.c a2 = this.f43182a.f43181g;
                k.c(b2, "context");
                k.c(a2, "jobScheduler");
                h c2 = j.f43241a.c();
                com.google.firebase.c a3 = com.paytm.notification.schedulers.b.e.a(b2, c2);
                if (a3 == null) {
                    a2.l();
                    return;
                }
                FirebaseInstanceId instance = FirebaseInstanceId.getInstance(a3);
                k.a((Object) instance, "FirebaseInstanceId.getInstance(app)");
                instance.f().a(new e.b(a2, b2, c2));
            } catch (Exception e2) {
                com.paytm.notification.b.e.f43014a.b(e2);
            }
        }
    }

    public final void a() {
        com.paytm.notification.schedulers.c cVar = this.f43181g;
        LoginJob.a aVar = LoginJob.f43322c;
        cVar.b(LoginJob.f43323e);
        this.f43176b.execute(new c(this));
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f43183a;

        c(f fVar) {
            this.f43183a = fVar;
        }

        public final void run() {
            try {
                h c2 = j.f43241a.c();
                NotificationUserConfig a2 = c2.a();
                if (a2 != null) {
                    a2.setCustomerId$paytmnotification_paytmRelease((String) null);
                }
                c2.h();
                b.C0745b bVar = com.paytm.signal.b.f43594e;
                Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new b.C0745b.c((kotlin.d.d) null), 2, (Object) null);
                try {
                    if (g.f43280a.a(this.f43183a.f43180f) == JOB_RESULT.RETRY) {
                        this.f43183a.f43181g.k();
                    }
                } catch (Exception e2) {
                    com.paytm.notification.b.e.f43014a.b(e2, "Sync token job scheduling failed on Logout", new Object[0]);
                }
            } catch (Exception e3) {
                com.paytm.notification.b.e.f43014a.b(e3);
            }
        }
    }

    public final void b() {
        if (!this.f43179e) {
            Lock lock = this.f43177c;
            lock.lock();
            try {
                com.paytm.notification.b.e.f43014a.a("fetch config schedule starts", new Object[0]);
                this.f43181g.b();
                this.f43179e = true;
                x xVar = x.f47997a;
            } finally {
                lock.unlock();
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(f fVar, String str) {
        NotificationUserConfig a2;
        Lock lock = fVar.f43177c;
        lock.lock();
        try {
            com.paytm.notification.b.e.f43014a.a("update customerid starts", new Object[0]);
            h c2 = j.f43241a.c();
            a2 = c2.a();
            String customerId$paytmnotification_paytmRelease = a2.getCustomerId$paytmnotification_paytmRelease();
            if (!(customerId$paytmnotification_paytmRelease == null || str == null || !(!k.a((Object) customerId$paytmnotification_paytmRelease, (Object) str))) || ((customerId$paytmnotification_paytmRelease == null && str != null) || (customerId$paytmnotification_paytmRelease != null && str == null))) {
                com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
                com.paytm.notification.b.a.c("Login(): ".concat(String.valueOf(str)));
            }
            a2.setCustomerId$paytmnotification_paytmRelease(str);
            c2.a(a2);
            if (a2.handleLogin() && (!(customerId$paytmnotification_paytmRelease == null || a2.getCustomerId$paytmnotification_paytmRelease() == null || !(!k.a((Object) customerId$paytmnotification_paytmRelease, (Object) a2.getCustomerId$paytmnotification_paytmRelease()))) || ((customerId$paytmnotification_paytmRelease == null && a2.getCustomerId$paytmnotification_paytmRelease() != null) || (customerId$paytmnotification_paytmRelease != null && a2.getCustomerId$paytmnotification_paytmRelease() == null)))) {
                c2.i();
                if (g.f43280a.b(fVar.f43180f) == JOB_RESULT.RETRY) {
                    fVar.f43181g.j();
                }
            }
        } catch (Exception e2) {
            com.paytm.notification.b.e.f43014a.b(e2);
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
        b.C0745b bVar = com.paytm.signal.b.f43594e;
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new b.C0745b.C0746b(a2.getCustomerId$paytmnotification_paytmRelease(), (kotlin.d.d) null), 2, (Object) null);
        x xVar = x.f47997a;
        lock.unlock();
    }
}
