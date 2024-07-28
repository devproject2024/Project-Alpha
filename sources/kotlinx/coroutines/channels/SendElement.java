package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

public final class SendElement extends Send {
    public final CancellableContinuation<x> cont;
    private final Object pollResult;

    public final Object getPollResult() {
        return this.pollResult;
    }

    public SendElement(Object obj, CancellableContinuation<? super x> cancellableContinuation) {
        this.pollResult = obj;
        this.cont = cancellableContinuation;
    }

    public final Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp prepareOp) {
        Object tryResume = this.cont.tryResume(x.f47997a, prepareOp != null ? prepareOp.desc : null);
        if (tryResume == null) {
            return null;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(tryResume == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        if (prepareOp != null) {
            prepareOp.finishPrepare();
        }
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }

    public final void completeResumeSend() {
        this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
    }

    public final void resumeSendClosed(Closed<?> closed) {
        Throwable sendException = closed.getSendException();
        p.a aVar = p.Companion;
        this.cont.resumeWith(p.m530constructorimpl(ResultKt.a(sendException)));
    }

    public final String toString() {
        return "SendElement@" + DebugStringsKt.getHexAddress(this) + '(' + getPollResult() + ')';
    }
}
