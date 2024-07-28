package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.j.e;

public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    public static final DefaultExecutor INSTANCE;
    private static final long KEEP_ALIVE_NANOS;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        EventLoop.incrementUseCount$default(defaultExecutor, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    private DefaultExecutor() {
    }

    /* access modifiers changed from: protected */
    public final Thread getThread() {
        Thread thread = _thread;
        return thread == null ? createThreadSync() : thread;
    }

    private final boolean isShutdownRequested() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable) {
        return scheduleInvokeOnTimeout(j, runnable);
    }

    public final void run() {
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            if (notifyStartup()) {
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long processNextEvent = processNextEvent();
                    if (processNextEvent == Long.MAX_VALUE) {
                        TimeSource timeSource2 = TimeSourceKt.getTimeSource();
                        long nanoTime = timeSource2 != null ? timeSource2.nanoTime() : System.nanoTime();
                        if (j == Long.MAX_VALUE) {
                            j = KEEP_ALIVE_NANOS + nanoTime;
                        }
                        long j2 = j - nanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            TimeSource timeSource3 = TimeSourceKt.getTimeSource();
                            if (timeSource3 != null) {
                                timeSource3.unregisterTimeLoopThread();
                            }
                            if (!isEmpty()) {
                                getThread();
                                return;
                            }
                            return;
                        }
                        processNextEvent = e.a(processNextEvent, j2);
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (processNextEvent > 0) {
                        if (isShutdownRequested()) {
                            _thread = null;
                            acknowledgeShutdownIfNeeded();
                            TimeSource timeSource4 = TimeSourceKt.getTimeSource();
                            if (timeSource4 != null) {
                                timeSource4.unregisterTimeLoopThread();
                            }
                            if (!isEmpty()) {
                                getThread();
                                return;
                            }
                            return;
                        }
                        TimeSource timeSource5 = TimeSourceKt.getTimeSource();
                        if (timeSource5 != null) {
                            timeSource5.parkNanos(this, processNextEvent);
                        } else {
                            LockSupport.parkNanos(this, processNextEvent);
                        }
                    }
                }
            }
        } finally {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            TimeSource timeSource6 = TimeSourceKt.getTimeSource();
            if (timeSource6 != null) {
                timeSource6.unregisterTimeLoopThread();
            }
            if (!isEmpty()) {
                getThread();
            }
        }
    }

    private final synchronized Thread createThreadSync() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final synchronized boolean notifyStartup() {
        if (isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (isShutdownRequested()) {
            debugStatus = 3;
            resetAll();
            notifyAll();
        }
    }
}
