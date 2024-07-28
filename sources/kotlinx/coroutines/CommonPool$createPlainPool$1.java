package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class CommonPool$createPlainPool$1 implements ThreadFactory {
    final /* synthetic */ AtomicInteger $threadId;

    CommonPool$createPlainPool$1(AtomicInteger atomicInteger) {
        this.$threadId = atomicInteger;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "CommonPool-worker-" + this.$threadId.incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
