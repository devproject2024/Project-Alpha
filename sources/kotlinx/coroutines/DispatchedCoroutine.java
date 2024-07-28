package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlinx.coroutines.internal.ScopeCoroutine;

final class DispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    private volatile int _decision = 0;

    public DispatchedCoroutine(f fVar, d<? super T> dVar) {
        super(fVar, dVar);
    }

    public final void afterCompletion(Object obj) {
        afterResume(obj);
    }

    public final void afterResume(Object obj) {
        if (!tryResume()) {
            DispatchedContinuationKt.resumeCancellableWith(b.a(this.uCont), CompletedExceptionallyKt.recoverResult(obj, this.uCont));
        }
    }

    public final Object getResult() {
        if (trySuspend()) {
            return a.COROUTINE_SUSPENDED;
        }
        Object unboxState = JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
        if (!(unboxState instanceof CompletedExceptionally)) {
            return unboxState;
        }
        throw ((CompletedExceptionally) unboxState).cause;
    }

    private final boolean trySuspend() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean tryResume() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }
}
