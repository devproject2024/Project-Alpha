package com.paytm.signal.schedulers;

import android.content.Context;
import com.paytm.notification.b.e;
import com.paytm.signal.c.d;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f43662a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final String f43663b = c.class.getCanonicalName();

    /* renamed from: c  reason: collision with root package name */
    private static final Executor f43664c;

    /* renamed from: d  reason: collision with root package name */
    private static long f43665d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f43666e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f43667f;

    /* renamed from: g  reason: collision with root package name */
    private static Context f43668g;

    /* renamed from: h  reason: collision with root package name */
    private static long f43669h = 1000;

    /* renamed from: i  reason: collision with root package name */
    private static int f43670i;

    static {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        k.a((Object) newCachedThreadPool, "Executors.newCachedThreadPool()");
        f43664c = newCachedThreadPool;
    }

    private c() {
    }

    public static long a() {
        return f43665d;
    }

    public static void a(Context context) {
        k.c(context, "context");
        a(context, true);
    }

    public static void a(Context context, boolean z) {
        k.c(context, "context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        f43668g = applicationContext;
        f43670i = 0;
        f43669h = 1000;
        f43666e = false;
        f43667f = false;
        f43664c.execute(new a(z));
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f43671a;

        a(boolean z) {
            this.f43671a = z;
        }

        public final void run() {
            c cVar = c.f43662a;
            c.a(this.f43671a);
        }
    }

    public static final /* synthetic */ void a(boolean z) {
        int i2;
        while (true) {
            com.paytm.signal.c cVar = com.paytm.signal.c.f43614a;
            Context context = f43668g;
            if (context == null) {
                k.a("context");
            }
            com.paytm.signal.data.c b2 = cVar.b(context);
            d dVar = new d();
            try {
                if (dVar.a("pool.ntp.org")) {
                    f43666e = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    e.f43014a.a(f43663b, "server time " + dVar + ".ntpTime");
                    e.f43014a.a(f43663b, "device time ".concat(String.valueOf(currentTimeMillis)));
                    f43665d = dVar.a() - System.currentTimeMillis();
                    e.f43014a.b(f43663b, "deltaTime Found: " + f43665d);
                    b2.a().edit().putLong("server_device_time_delta", f43665d).apply();
                } else if (!f43667f) {
                    f43665d = b2.c();
                    e.f43014a.c("deltaTime FAILED - old delta time: " + f43665d, new Object[0]);
                    f43667f = true;
                }
            } catch (Exception e2) {
                if (!f43667f) {
                    f43665d = b2.c();
                    e.f43014a.a(e2, "deltaTime FAILED - old delta time: " + f43665d, new Object[0]);
                    f43667f = true;
                }
            }
            if (z && !f43666e && (i2 = f43670i) <= 5) {
                f43670i = i2 + 1;
                e.f43014a.a(f43663b, "Retrying to get network time " + f43670i + AppConstants.DOTS);
                try {
                    Thread.sleep(f43669h);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                f43669h *= 2;
                z = true;
            } else {
                return;
            }
        }
    }
}
