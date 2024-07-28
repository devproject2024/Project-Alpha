package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.d.f;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements Executor, TaskContext {
    private static final AtomicIntegerFieldUpdater inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    private final ExperimentalCoroutineDispatcher dispatcher;
    private volatile int inFlightTasks = 0;
    private final int parallelism;
    private final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();
    private final int taskMode;

    public final int getTaskMode() {
        return this.taskMode;
    }

    public LimitingDispatcher(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i2, int i3) {
        this.dispatcher = experimentalCoroutineDispatcher;
        this.parallelism = i2;
        this.taskMode = i3;
    }

    public final void execute(Runnable runnable) {
        dispatch(runnable, false);
    }

    public final void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    public final void dispatch(f fVar, Runnable runnable) {
        dispatch(runnable, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dispatch(java.lang.Runnable r3, boolean r4) {
        /*
            r2 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = inFlightTasks$FU
            int r0 = r0.incrementAndGet(r2)
            int r1 = r2.parallelism
            if (r0 > r1) goto L_0x0013
            kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher r0 = r2.dispatcher
            r1 = r2
            kotlinx.coroutines.scheduling.TaskContext r1 = (kotlinx.coroutines.scheduling.TaskContext) r1
            r0.dispatchWithContext$kotlinx_coroutines_core(r3, r1, r4)
            return
        L_0x0013:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r0 = r2.queue
            r0.add(r3)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = inFlightTasks$FU
            int r3 = r3.decrementAndGet(r2)
            int r0 = r2.parallelism
            if (r3 < r0) goto L_0x0023
            return
        L_0x0023:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r3 = r2.queue
            java.lang.Object r3 = r3.poll()
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            if (r3 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.LimitingDispatcher.dispatch(java.lang.Runnable, boolean):void");
    }

    public final String toString() {
        return super.toString() + "[dispatcher = " + this.dispatcher + ']';
    }

    public final void afterTask() {
        Runnable poll = this.queue.poll();
        if (poll != null) {
            this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(poll, this, true);
            return;
        }
        inFlightTasks$FU.decrementAndGet(this);
        Runnable poll2 = this.queue.poll();
        if (poll2 != null) {
            dispatch(poll2, true);
        }
    }
}
