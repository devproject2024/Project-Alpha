package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.d.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47692a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f47693b;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f47694c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f47695d = new ConcurrentHashMap();

    static {
        b bVar = new b();
        boolean a2 = a("rx3.purge-enabled", bVar);
        f47692a = a2;
        f47693b = a(a2, "rx3.purge-period-seconds", bVar);
        a();
    }

    private static void a() {
        if (f47692a) {
            while (true) {
                ScheduledExecutorService scheduledExecutorService = f47694c.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new j("RxSchedulerPurge"));
                    if (f47694c.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        a aVar = new a();
                        int i2 = f47693b;
                        newScheduledThreadPool.scheduleAtFixedRate(aVar, (long) i2, (long) i2, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    private static int a(boolean z, String str, h<String, String> hVar) {
        if (z) {
            try {
                String apply = hVar.apply(str);
                if (apply == null) {
                    return 1;
                }
                return Integer.parseInt(apply);
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
            }
        }
        return 1;
    }

    private static boolean a(String str, h<String, String> hVar) {
        try {
            String apply = hVar.apply(str);
            if (apply == null) {
                return true;
            }
            return "true".equals(apply);
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            return true;
        }
    }

    static final class b implements h<String, String> {
        b() {
        }

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            return System.getProperty((String) obj);
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (f47692a && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            f47695d.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }

    static final class a implements Runnable {
        a() {
        }

        public final void run() {
            Iterator it2 = new ArrayList(n.f47695d.keySet()).iterator();
            while (it2.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it2.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    n.f47695d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }
}
