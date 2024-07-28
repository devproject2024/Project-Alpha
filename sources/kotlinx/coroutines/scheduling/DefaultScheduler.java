package kotlinx.coroutines.scheduling;

import kotlin.g.b.g;
import kotlin.j.e;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt;

public final class DefaultScheduler extends ExperimentalCoroutineDispatcher {
    public static final DefaultScheduler INSTANCE;
    private static final CoroutineDispatcher IO;

    public final String toString() {
        return "DefaultDispatcher";
    }

    static {
        DefaultScheduler defaultScheduler = new DefaultScheduler();
        INSTANCE = defaultScheduler;
        IO = defaultScheduler.blocking(SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.io.parallelism", e.b(64, SystemPropsKt.getAVAILABLE_PROCESSORS()), 0, 0, 12, (Object) null));
    }

    private DefaultScheduler() {
        super(0, 0, (String) null, 7, (g) null);
    }

    public final CoroutineDispatcher getIO() {
        return IO;
    }

    public final void close() {
        throw new UnsupportedOperationException("DefaultDispatcher cannot be closed");
    }
}
