package kotlinx.coroutines.channels;

import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

public final class Closed<E> extends Send implements ReceiveOrClosed<E> {
    public final Throwable closeCause;

    public final void completeResumeReceive(E e2) {
    }

    public final void completeResumeSend() {
    }

    public final Closed<E> getOfferResult() {
        return this;
    }

    public final Closed<E> getPollResult() {
        return this;
    }

    public Closed(Throwable th) {
        this.closeCause = th;
    }

    public final Throwable getSendException() {
        Throwable th = this.closeCause;
        return th == null ? new ClosedSendChannelException("Channel was closed") : th;
    }

    public final Throwable getReceiveException() {
        Throwable th = this.closeCause;
        return th == null ? new ClosedReceiveChannelException("Channel was closed") : th;
    }

    public final Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp prepareOp) {
        Symbol symbol = CancellableContinuationImplKt.RESUME_TOKEN;
        if (prepareOp != null) {
            prepareOp.finishPrepare();
        }
        return symbol;
    }

    public final Symbol tryResumeReceive(E e2, LockFreeLinkedListNode.PrepareOp prepareOp) {
        Symbol symbol = CancellableContinuationImplKt.RESUME_TOKEN;
        if (prepareOp != null) {
            prepareOp.finishPrepare();
        }
        return symbol;
    }

    public final void resumeSendClosed(Closed<?> closed) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            throw new AssertionError();
        }
    }

    public final String toString() {
        return "Closed@" + DebugStringsKt.getHexAddress(this) + '[' + this.closeCause + ']';
    }
}
