package kotlinx.coroutines.internal;

import kotlin.d.f;
import kotlin.x;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {
    private final Throwable cause;
    private final String errorHint;

    public MissingMainCoroutineDispatcher(Throwable th, String str) {
        this.cause = th;
        this.errorHint = str;
    }

    public final MainCoroutineDispatcher getImmediate() {
        return this;
    }

    public final boolean isDispatchNeeded(f fVar) {
        missing();
        throw null;
    }

    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable) {
        missing();
        throw null;
    }

    public final Void dispatch(f fVar, Runnable runnable) {
        missing();
        throw null;
    }

    public final Void scheduleResumeAfterDelay(long j, CancellableContinuation<? super x> cancellableContinuation) {
        missing();
        throw null;
    }

    private final Void missing() {
        String str;
        if (this.cause != null) {
            StringBuilder sb = new StringBuilder("Module with the Main dispatcher had failed to initialize");
            String str2 = this.errorHint;
            if (str2 == null || (str = ". ".concat(String.valueOf(str2))) == null) {
                str = "";
            }
            sb.append(str);
            throw new IllegalStateException(sb.toString(), this.cause);
        }
        MainDispatchersKt.throwMissingMainDispatcherException();
        throw null;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Main[missing");
        if (this.cause != null) {
            str = ", cause=" + this.cause;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
