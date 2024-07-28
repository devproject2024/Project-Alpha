package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.channels.ValueOrClosed;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {
    /* access modifiers changed from: protected */
    public abstract boolean isBufferAlwaysEmpty();

    /* access modifiers changed from: protected */
    public abstract boolean isBufferEmpty();

    /* access modifiers changed from: protected */
    public void onReceiveDequeued() {
    }

    /* access modifiers changed from: protected */
    public void onReceiveEnqueued() {
    }

    /* access modifiers changed from: protected */
    public Object pollInternal() {
        Send takeFirstSendOrPeekClosed;
        Symbol tryResumeSend;
        do {
            takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
            if (takeFirstSendOrPeekClosed == null) {
                return AbstractChannelKt.POLL_FAILED;
            }
            tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend((LockFreeLinkedListNode.PrepareOp) null);
        } while (tryResumeSend == null);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        takeFirstSendOrPeekClosed.completeResumeSend();
        return takeFirstSendOrPeekClosed.getPollResult();
    }

    /* access modifiers changed from: protected */
    public boolean enqueueReceiveInternal(Receive<? super E> receive) {
        int tryCondAddNext;
        LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysEmpty()) {
            LockFreeLinkedListNode queue = getQueue();
            do {
                prevNode = queue.getPrevNode();
                if (!(!(prevNode instanceof Send))) {
                    return false;
                }
            } while (!prevNode.addNext(receive, queue));
            return true;
        }
        LockFreeLinkedListNode queue2 = getQueue();
        LockFreeLinkedListNode lockFreeLinkedListNode = receive;
        LockFreeLinkedListNode.CondAddOp abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 = new AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1(lockFreeLinkedListNode, lockFreeLinkedListNode, this);
        do {
            LockFreeLinkedListNode prevNode2 = queue2.getPrevNode();
            if (!(!(prevNode2 instanceof Send))) {
                return false;
            }
            tryCondAddNext = prevNode2.tryCondAddNext(lockFreeLinkedListNode, queue2, abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean enqueueReceive(Receive<? super E> receive) {
        boolean enqueueReceiveInternal = enqueueReceiveInternal(receive);
        if (enqueueReceiveInternal) {
            onReceiveEnqueued();
        }
        return enqueueReceiveInternal;
    }

    public final Object receiveOrClosed(d<? super ValueOrClosed<? extends E>> dVar) {
        Object obj;
        Object pollInternal = pollInternal();
        if (pollInternal == AbstractChannelKt.POLL_FAILED) {
            return receiveSuspend(2, dVar);
        }
        if (pollInternal instanceof Closed) {
            ValueOrClosed.Companion companion = ValueOrClosed.Companion;
            obj = ValueOrClosed.m541constructorimpl(new ValueOrClosed.Closed(((Closed) pollInternal).closeCause));
        } else {
            ValueOrClosed.Companion companion2 = ValueOrClosed.Companion;
            obj = ValueOrClosed.m541constructorimpl(pollInternal);
        }
        return ValueOrClosed.m540boximpl(obj);
    }

    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled");
        }
        cancelInternal$kotlinx_coroutines_core(cancellationException);
    }

    public final boolean cancelInternal$kotlinx_coroutines_core(Throwable th) {
        boolean close = close(th);
        onCancelIdempotent(close);
        return close;
    }

    /* access modifiers changed from: protected */
    public void onCancelIdempotent(boolean z) {
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend != null) {
            Object r1 = InlineList.m550constructorimpl$default((Object) null, 1, (g) null);
            while (true) {
                LockFreeLinkedListNode prevNode = closedForSend.getPrevNode();
                if (!(prevNode instanceof LockFreeLinkedListHead)) {
                    if (DebugKt.getASSERTIONS_ENABLED() && !(prevNode instanceof Send)) {
                        throw new AssertionError();
                    } else if (!prevNode.remove()) {
                        prevNode.helpRemove();
                    } else if (prevNode != null) {
                        r1 = InlineList.m553plusimpl(r1, (Send) prevNode);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
                    }
                } else if (r1 == null) {
                    return;
                } else {
                    if (!(r1 instanceof ArrayList)) {
                        ((Send) r1).resumeSendClosed(closedForSend);
                        return;
                    } else if (r1 != null) {
                        ArrayList arrayList = (ArrayList) r1;
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ((Send) arrayList.get(size)).resumeSendClosed(closedForSend);
                        }
                        return;
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
                    }
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    /* access modifiers changed from: protected */
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = super.takeFirstReceiveOrPeekClosed();
        if (takeFirstReceiveOrPeekClosed != null && !(takeFirstReceiveOrPeekClosed instanceof Closed)) {
            onReceiveDequeued();
        }
        return takeFirstReceiveOrPeekClosed;
    }

    /* access modifiers changed from: private */
    public final void removeReceiveOnCancel(CancellableContinuation<?> cancellableContinuation, Receive<?> receive) {
        cancellableContinuation.invokeOnCancellation(new RemoveReceiveOnCancel(receive));
    }

    final class RemoveReceiveOnCancel extends CancelHandler {
        private final Receive<?> receive;

        public RemoveReceiveOnCancel(Receive<?> receive2) {
            this.receive = receive2;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return x.f47997a;
        }

        public final void invoke(Throwable th) {
            if (this.receive.remove()) {
                AbstractChannel.this.onReceiveDequeued();
            }
        }

        public final String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + ']';
        }
    }

    static final class ReceiveElement<E> extends Receive<E> {
        public final CancellableContinuation<Object> cont;
        public final int receiveMode;

        public ReceiveElement(CancellableContinuation<Object> cancellableContinuation, int i2) {
            this.cont = cancellableContinuation;
            this.receiveMode = i2;
        }

        public final Object resumeValue(E e2) {
            if (this.receiveMode != 2) {
                return e2;
            }
            ValueOrClosed.Companion companion = ValueOrClosed.Companion;
            return ValueOrClosed.m540boximpl(ValueOrClosed.m541constructorimpl(e2));
        }

        public final Symbol tryResumeReceive(E e2, LockFreeLinkedListNode.PrepareOp prepareOp) {
            Object tryResume = this.cont.tryResume(resumeValue(e2), prepareOp != null ? prepareOp.desc : null);
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

        public final void completeResumeReceive(E e2) {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        public final void resumeReceiveClosed(Closed<?> closed) {
            if (this.receiveMode == 1 && closed.closeCause == null) {
                p.a aVar = p.Companion;
                this.cont.resumeWith(p.m530constructorimpl((Object) null));
            } else if (this.receiveMode == 2) {
                ValueOrClosed.Companion companion = ValueOrClosed.Companion;
                ValueOrClosed r3 = ValueOrClosed.m540boximpl(ValueOrClosed.m541constructorimpl(new ValueOrClosed.Closed(closed.closeCause)));
                p.a aVar2 = p.Companion;
                this.cont.resumeWith(p.m530constructorimpl(r3));
            } else {
                Throwable receiveException = closed.getReceiveException();
                p.a aVar3 = p.Companion;
                this.cont.resumeWith(p.m530constructorimpl(ResultKt.a(receiveException)));
            }
        }

        public final String toString() {
            return "ReceiveElement@" + DebugStringsKt.getHexAddress(this) + "[receiveMode=" + this.receiveMode + ']';
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ <R> Object receiveSuspend(int i2, d<? super R> dVar) {
        CancellableContinuationImpl<? super R> orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(b.a(dVar));
        CancellableContinuation cancellableContinuation = orCreateCancellableContinuation;
        if (cancellableContinuation != null) {
            ReceiveElement receiveElement = new ReceiveElement(cancellableContinuation, i2);
            while (true) {
                Receive receive = receiveElement;
                if (!enqueueReceive(receive)) {
                    Object pollInternal = pollInternal();
                    if (!(pollInternal instanceof Closed)) {
                        if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                            Object resumeValue = receiveElement.resumeValue(pollInternal);
                            p.a aVar = p.Companion;
                            cancellableContinuation.resumeWith(p.m530constructorimpl(resumeValue));
                            break;
                        }
                    } else {
                        receiveElement.resumeReceiveClosed((Closed) pollInternal);
                        break;
                    }
                } else {
                    removeReceiveOnCancel(cancellableContinuation, receive);
                    break;
                }
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == a.COROUTINE_SUSPENDED) {
                k.d(dVar, "frame");
            }
            return result;
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
    }
}
