package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.p;
import kotlin.x;

final class ResumeAwaitOnCompletion<T> extends JobNode<JobSupport> {
    private final CancellableContinuationImpl<T> continuation;

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public ResumeAwaitOnCompletion(JobSupport jobSupport, CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        super(jobSupport);
        this.continuation = cancellableContinuationImpl;
    }

    public final void invoke(Throwable th) {
        Object state$kotlinx_coroutines_core = ((JobSupport) this.job).getState$kotlinx_coroutines_core();
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new AssertionError();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            Throwable th2 = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            p.a aVar = p.Companion;
            this.continuation.resumeWith(p.m530constructorimpl(ResultKt.a(th2)));
        } else {
            Object unboxState = JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            p.a aVar2 = p.Companion;
            this.continuation.resumeWith(p.m530constructorimpl(unboxState));
        }
    }

    public final String toString() {
        return "ResumeAwaitOnCompletion[" + this.continuation + ']';
    }
}
