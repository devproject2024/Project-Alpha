package kotlinx.coroutines;

import kotlin.d.d;
import kotlinx.coroutines.internal.ScopeCoroutine;

final class TimeoutCoroutine<U, T extends U> extends ScopeCoroutine<T> implements Runnable {
    public final long time;

    public TimeoutCoroutine(long j, d<? super U> dVar) {
        super(dVar.getContext(), dVar);
        this.time = j;
    }

    public final void run() {
        cancelCoroutine(TimeoutKt.TimeoutCancellationException(this.time, this));
    }

    public final String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core() + "(timeMillis=" + this.time + ')';
    }
}
