package kotlinx.coroutines;

import kotlin.d.d;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

public final class CancellableContinuationKt {
    public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(d<? super T> dVar) {
        if (!(dVar instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(dVar, 0);
        }
        CancellableContinuationImpl<T> claimReusableCancellableContinuation = ((DispatchedContinuation) dVar).claimReusableCancellableContinuation();
        if (claimReusableCancellableContinuation != null) {
            if (!claimReusableCancellableContinuation.resetState()) {
                claimReusableCancellableContinuation = null;
            }
            if (claimReusableCancellableContinuation != null) {
                return claimReusableCancellableContinuation;
            }
        }
        return new CancellableContinuationImpl<>(dVar, 0);
    }

    public static final void removeOnCancellation(CancellableContinuation<?> cancellableContinuation, LockFreeLinkedListNode lockFreeLinkedListNode) {
        cancellableContinuation.invokeOnCancellation(new RemoveOnCancel(lockFreeLinkedListNode));
    }

    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        cancellableContinuation.invokeOnCancellation(new DisposeOnCancel(disposableHandle));
    }
}
