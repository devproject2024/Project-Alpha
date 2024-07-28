package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import kotlin.d.f;
import kotlin.g.b.g;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

public class ExperimentalCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    private final int corePoolSize;
    private CoroutineScheduler coroutineScheduler;
    private final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    private final String schedulerName;

    public ExperimentalCoroutineDispatcher(int i2, int i3, long j, String str) {
        this.corePoolSize = i2;
        this.maxPoolSize = i3;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        this.coroutineScheduler = createScheduler();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i2, int i3, String str, int i4, g gVar) {
        this((i4 & 1) != 0 ? TasksKt.CORE_POOL_SIZE : i2, (i4 & 2) != 0 ? TasksKt.MAX_POOL_SIZE : i3, (i4 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public ExperimentalCoroutineDispatcher(int i2, int i3, String str) {
        this(i2, i3, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, str);
    }

    public void dispatch(f fVar, Runnable runnable) {
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable, (TaskContext) null, false, 6, (Object) null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatch(fVar, runnable);
        }
    }

    public void close() {
        this.coroutineScheduler.close();
    }

    public String toString() {
        return super.toString() + "[scheduler = " + this.coroutineScheduler + ']';
    }

    public final CoroutineDispatcher blocking(int i2) {
        if (i2 > 0) {
            return new LimitingDispatcher(this, i2, 1);
        }
        throw new IllegalArgumentException("Expected positive parallelism level, but have ".concat(String.valueOf(i2)).toString());
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(Runnable runnable, TaskContext taskContext, boolean z) {
        try {
            this.coroutineScheduler.dispatch(runnable, taskContext, z);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.enqueue(this.coroutineScheduler.createTask$kotlinx_coroutines_core(runnable, taskContext));
        }
    }

    private final CoroutineScheduler createScheduler() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }
}
