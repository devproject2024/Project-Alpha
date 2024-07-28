package androidx.work.impl.utils;

import androidx.work.l;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public final class n {

    /* renamed from: e  reason: collision with root package name */
    private static final String f5483e = l.a("WorkTimer");

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f5484a = Executors.newSingleThreadScheduledExecutor(this.f5488f);

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, b> f5485b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, a> f5486c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Object f5487d = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final ThreadFactory f5488f = new ThreadFactory() {

        /* renamed from: b  reason: collision with root package name */
        private int f5490b = 0;

        public final Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.f5490b);
            this.f5490b = this.f5490b + 1;
            return newThread;
        }
    };

    public interface a {
        void a(String str);
    }

    public final void a(String str) {
        synchronized (this.f5487d) {
            if (this.f5485b.remove(str) != null) {
                l.a();
                String.format("Stopping timer for %s", new Object[]{str});
                this.f5486c.remove(str);
            }
        }
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final n f5491a;

        /* renamed from: b  reason: collision with root package name */
        private final String f5492b;

        public b(n nVar, String str) {
            this.f5491a = nVar;
            this.f5492b = str;
        }

        public final void run() {
            synchronized (this.f5491a.f5487d) {
                if (this.f5491a.f5485b.remove(this.f5492b) != null) {
                    a remove = this.f5491a.f5486c.remove(this.f5492b);
                    if (remove != null) {
                        remove.a(this.f5492b);
                    }
                } else {
                    l.a();
                    String.format("Timer with %s is already marked as complete.", new Object[]{this.f5492b});
                }
            }
        }
    }
}
