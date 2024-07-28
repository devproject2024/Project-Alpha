package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.j.e;
import kotlinx.coroutines.internal.SystemPropsKt;

public final class TasksKt {
    public static final int BLOCKING_DEFAULT_PARALLELISM = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
    public static final int CORE_POOL_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", e.b(SystemPropsKt.getAVAILABLE_PROCESSORS(), 2), 1, 0, 8, (Object) null);
    public static final long IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));
    public static final int MAX_POOL_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", e.a(SystemPropsKt.getAVAILABLE_PROCESSORS() * 128, CORE_POOL_SIZE, 2097150), 0, 2097150, 4, (Object) null);
    public static final long WORK_STEALING_TIME_RESOLUTION_NS = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);
    public static TimeSource schedulerTimeSource = NanoTimeSource.INSTANCE;
}
