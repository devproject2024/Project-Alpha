package com.alipay.mobile.nebula.wallet;

import com.alipay.mobile.nebula.provider.H5ThreadPoolProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class H5ThreadPoolFactory {
    private static final String TAG = "H5ThreadPoolFactory";
    private static Executor orderedExecutor;
    private static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
    private static ThreadPoolExecutor threadPoolExecutor;

    static ThreadPoolExecutor getExecutor(String str) {
        H5ThreadPoolProvider h5ThreadPoolProvider = (H5ThreadPoolProvider) H5Utils.getProvider(H5ThreadPoolProvider.class.getName());
        if (h5ThreadPoolProvider != null) {
            ThreadPoolExecutor executor = h5ThreadPoolProvider.getExecutor(str);
            threadPoolExecutor = executor;
            if (executor != null) {
                return threadPoolExecutor;
            }
        }
        return getDefaultExecutor();
    }

    public static synchronized ThreadPoolExecutor getDefaultExecutor() {
        ThreadPoolExecutor threadPoolExecutor2;
        synchronized (H5ThreadPoolFactory.class) {
            if (threadPoolExecutor == null) {
                threadPoolExecutor = new ThreadPoolExecutor(8, 32, 3, TimeUnit.SECONDS, new ArrayBlockingQueue(1), new ThreadFactory() {
                    public final Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(runnable);
                        thread.setName("H5_background_executor_" + thread.getId());
                        thread.setDaemon(true);
                        return thread;
                    }
                }, new DiscardOldestPolicy());
            }
            threadPoolExecutor2 = threadPoolExecutor;
        }
        return threadPoolExecutor2;
    }

    static ScheduledThreadPoolExecutor getScheduledExecutor() {
        H5ThreadPoolProvider h5ThreadPoolProvider = (H5ThreadPoolProvider) H5Utils.getProvider(H5ThreadPoolProvider.class.getName());
        if (h5ThreadPoolProvider != null) {
            ScheduledThreadPoolExecutor scheduledExecutor = h5ThreadPoolProvider.getScheduledExecutor();
            scheduledThreadPoolExecutor = scheduledExecutor;
            if (scheduledExecutor != null) {
                return scheduledThreadPoolExecutor;
            }
        }
        return getDefaultScheduledExecutor();
    }

    public static synchronized ScheduledThreadPoolExecutor getDefaultScheduledExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2;
        synchronized (H5ThreadPoolFactory.class) {
            if (scheduledThreadPoolExecutor == null) {
                scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(3, new ThreadFactory() {
                    public final Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(runnable);
                        thread.setName("H5 Schedule background executor_" + thread.getId());
                        thread.setDaemon(true);
                        return thread;
                    }
                }, new DiscardOldestPolicy());
            }
            scheduledThreadPoolExecutor2 = scheduledThreadPoolExecutor;
        }
        return scheduledThreadPoolExecutor2;
    }

    public static synchronized Executor getSingleThreadExecutor() {
        Executor executor;
        synchronized (H5ThreadPoolFactory.class) {
            if (orderedExecutor == null) {
                orderedExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(40), new H5SingleThreadFactory("H5_SingleThreadExecutor_for_log"), new DiscardOldestPolicy());
            }
            executor = orderedExecutor;
        }
        return executor;
    }

    public static class DiscardOldestPolicy extends ThreadPoolExecutor.DiscardOldestPolicy {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            super.rejectedExecution(runnable, threadPoolExecutor);
            H5Log.d(H5ThreadPoolFactory.TAG, "Reject runnable " + runnable + " in " + threadPoolExecutor);
        }
    }

    public static class H5SingleThreadFactory implements ThreadFactory {
        private String threadName;

        public H5SingleThreadFactory(String str) {
            this.threadName = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(this.threadName + "_" + thread.getId());
            thread.setPriority(5);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    H5Log.e(H5ThreadPoolFactory.TAG, "H5SingleThreadFactory catchUncaughtException ".concat(String.valueOf(th)));
                }
            });
            return thread;
        }
    }
}
