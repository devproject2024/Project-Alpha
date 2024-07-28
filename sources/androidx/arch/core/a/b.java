package androidx.arch.core.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1846a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f1847b = Executors.newFixedThreadPool(4, new ThreadFactory() {

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f1850b = new AtomicInteger(0);

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f1850b.getAndIncrement())}));
            return thread;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f1848c;

    public final void a(Runnable runnable) {
        this.f1847b.execute(runnable);
    }

    public final void b(Runnable runnable) {
        if (this.f1848c == null) {
            synchronized (this.f1846a) {
                if (this.f1848c == null) {
                    this.f1848c = a(Looper.getMainLooper());
                }
            }
        }
        this.f1848c.post(runnable);
    }

    public final boolean d() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private static Handler a(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Class<Handler> cls = Handler.class;
            try {
                return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }
}
