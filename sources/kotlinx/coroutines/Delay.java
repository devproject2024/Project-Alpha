package kotlinx.coroutines;

import kotlin.x;

public interface Delay {
    DisposableHandle invokeOnTimeout(long j, Runnable runnable);

    void scheduleResumeAfterDelay(long j, CancellableContinuation<? super x> cancellableContinuation);

    public static final class DefaultImpls {
        public static DisposableHandle invokeOnTimeout(Delay delay, long j, Runnable runnable) {
            return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(j, runnable);
        }
    }
}
