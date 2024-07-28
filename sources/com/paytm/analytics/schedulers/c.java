package com.paytm.analytics.schedulers;

import android.content.Context;
import com.paytm.a.a.b;
import com.paytm.analytics.c.d;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f40979a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final String f40980b = c.class.getCanonicalName();

    /* renamed from: c  reason: collision with root package name */
    private static final Executor f40981c;

    /* renamed from: d  reason: collision with root package name */
    private static long f40982d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f40983e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f40984f;

    /* renamed from: g  reason: collision with root package name */
    private static Context f40985g;

    /* renamed from: h  reason: collision with root package name */
    private static long f40986h = 1000;

    /* renamed from: i  reason: collision with root package name */
    private static int f40987i;

    static {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        k.a((Object) newCachedThreadPool, "Executors.newCachedThreadPool()");
        f40981c = newCachedThreadPool;
    }

    private c() {
    }

    public static long a() {
        return f40982d;
    }

    public static void a(Context context) {
        k.c(context, "context");
        a(context, true);
    }

    public static void a(Context context, boolean z) {
        k.c(context, "context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        f40985g = applicationContext;
        f40987i = 0;
        f40986h = 1000;
        f40983e = false;
        f40984f = false;
        f40981c.execute(new a(z));
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f40988a;

        a(boolean z) {
            this.f40988a = z;
        }

        public final void run() {
            c cVar = c.f40979a;
            c.a(this.f40988a);
        }
    }

    public static final /* synthetic */ void a(boolean z) {
        int i2;
        while (true) {
            com.paytm.analytics.c cVar = com.paytm.analytics.c.f40931a;
            Context context = f40985g;
            if (context == null) {
                k.a("context");
            }
            com.paytm.analytics.data.c b2 = cVar.b(context);
            d dVar = new d();
            try {
                if (dVar.a("pool.ntp.org")) {
                    f40983e = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    b.f40832a.a(f40980b, "server time " + dVar + ".ntpTime");
                    b.f40832a.a(f40980b, "device time ".concat(String.valueOf(currentTimeMillis)));
                    f40982d = dVar.a() - System.currentTimeMillis();
                    b.f40832a.b(f40980b, "deltaTime Found: " + f40982d);
                    b2.a().edit().putLong("server_device_time_delta", f40982d).apply();
                } else if (!f40984f) {
                    f40982d = b2.c();
                    b.f40832a.c("deltaTime FAILED - old delta time: " + f40982d, new Object[0]);
                    f40984f = true;
                }
            } catch (Exception e2) {
                if (!f40984f) {
                    f40982d = b2.c();
                    b.f40832a.a(e2, "deltaTime FAILED - old delta time: " + f40982d, new Object[0]);
                    f40984f = true;
                }
            }
            if (z && !f40983e && (i2 = f40987i) <= 5) {
                f40987i = i2 + 1;
                b.f40832a.a(f40980b, "Retrying to get network time " + f40987i + AppConstants.DOTS);
                try {
                    Thread.sleep(f40986h);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                f40986h *= 2;
                z = true;
            } else {
                return;
            }
        }
    }
}
