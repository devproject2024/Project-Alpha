package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.d.f;
import kotlin.g.b.k;

final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    private final Thread blockedThread;
    private final EventLoop eventLoop;

    /* access modifiers changed from: protected */
    public final boolean isScopedCoroutine() {
        return true;
    }

    public BlockingCoroutine(f fVar, Thread thread, EventLoop eventLoop2) {
        super(fVar, true);
        this.blockedThread = thread;
        this.eventLoop = eventLoop2;
    }

    /* access modifiers changed from: protected */
    public final void afterCompletion(Object obj) {
        if (!k.a((Object) Thread.currentThread(), (Object) this.blockedThread)) {
            LockSupport.unpark(this.blockedThread);
        }
    }

    public final T joinBlocking() {
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            EventLoop eventLoop2 = this.eventLoop;
            T t = null;
            if (eventLoop2 != null) {
                EventLoop.incrementUseCount$default(eventLoop2, false, 1, (Object) null);
            }
            while (!Thread.interrupted()) {
                EventLoop eventLoop3 = this.eventLoop;
                long processNextEvent = eventLoop3 != null ? eventLoop3.processNextEvent() : Long.MAX_VALUE;
                if (!isCompleted()) {
                    TimeSource timeSource2 = TimeSourceKt.getTimeSource();
                    if (timeSource2 != null) {
                        timeSource2.parkNanos(this, processNextEvent);
                    } else {
                        LockSupport.parkNanos(this, processNextEvent);
                    }
                } else {
                    EventLoop eventLoop4 = this.eventLoop;
                    if (eventLoop4 != null) {
                        EventLoop.decrementUseCount$default(eventLoop4, false, 1, (Object) null);
                    }
                    TimeSource timeSource3 = TimeSourceKt.getTimeSource();
                    if (timeSource3 != null) {
                        timeSource3.unregisterTimeLoopThread();
                    }
                    T unboxState = JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
                    if (unboxState instanceof CompletedExceptionally) {
                        t = unboxState;
                    }
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) t;
                    if (completedExceptionally == null) {
                        return unboxState;
                    }
                    throw completedExceptionally.cause;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            cancelCoroutine(interruptedException);
            throw interruptedException;
        } catch (Throwable th) {
            TimeSource timeSource4 = TimeSourceKt.getTimeSource();
            if (timeSource4 != null) {
                timeSource4.unregisterTimeLoopThread();
            }
            throw th;
        }
    }
}
