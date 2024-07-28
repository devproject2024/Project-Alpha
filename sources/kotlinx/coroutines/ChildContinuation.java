package kotlinx.coroutines;

import kotlin.x;

public final class ChildContinuation extends JobCancellingNode<Job> {
    public final CancellableContinuationImpl<?> child;

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public ChildContinuation(Job job, CancellableContinuationImpl<?> cancellableContinuationImpl) {
        super(job);
        this.child = cancellableContinuationImpl;
    }

    public final void invoke(Throwable th) {
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.child;
        cancellableContinuationImpl.parentCancelled$kotlinx_coroutines_core(cancellableContinuationImpl.getContinuationCancellationCause(this.job));
    }

    public final String toString() {
        return "ChildContinuation[" + this.child + ']';
    }
}
