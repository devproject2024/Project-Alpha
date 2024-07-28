package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.b.ab;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private static final AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    private volatile Object onCloseHandler = null;
    private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();

    /* access modifiers changed from: protected */
    public String getBufferDebugString() {
        return "";
    }

    /* access modifiers changed from: protected */
    public abstract boolean isBufferAlwaysFull();

    /* access modifiers changed from: protected */
    public abstract boolean isBufferFull();

    /* access modifiers changed from: protected */
    public void onClosedIdempotent(LockFreeLinkedListNode lockFreeLinkedListNode) {
    }

    /* access modifiers changed from: protected */
    public final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E e2) {
        ReceiveOrClosed takeFirstReceiveOrPeekClosed;
        Symbol tryResumeReceive;
        do {
            takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            if (takeFirstReceiveOrPeekClosed == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e2, (LockFreeLinkedListNode.PrepareOp) null);
        } while (tryResumeReceive == null);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        takeFirstReceiveOrPeekClosed.completeResumeReceive(e2);
        return takeFirstReceiveOrPeekClosed.getOfferResult();
    }

    /* access modifiers changed from: protected */
    public final Closed<?> getClosedForSend() {
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (!(prevNode instanceof Closed)) {
            prevNode = null;
        }
        Closed<?> closed = (Closed) prevNode;
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r2 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.channels.Send takeFirstSendOrPeekClosed() {
        /*
            r4 = this;
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r4.queue
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
        L_0x0004:
            java.lang.Object r1 = r0.getNext()
            if (r1 == 0) goto L_0x0031
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = 0
            if (r1 != r0) goto L_0x0010
            goto L_0x002a
        L_0x0010:
            boolean r3 = r1 instanceof kotlinx.coroutines.channels.Send
            if (r3 != 0) goto L_0x0015
            goto L_0x002a
        L_0x0015:
            r2 = r1
            kotlinx.coroutines.channels.Send r2 = (kotlinx.coroutines.channels.Send) r2
            boolean r2 = r2 instanceof kotlinx.coroutines.channels.Closed
            if (r2 == 0) goto L_0x0023
            boolean r2 = r1.isRemoved()
            if (r2 != 0) goto L_0x0023
            goto L_0x0029
        L_0x0023:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = r1.removeOrNext()
            if (r2 != 0) goto L_0x002d
        L_0x0029:
            r2 = r1
        L_0x002a:
            kotlinx.coroutines.channels.Send r2 = (kotlinx.coroutines.channels.Send) r2
            return r2
        L_0x002d:
            r2.helpRemovePrev()
            goto L_0x0004
        L_0x0031:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractSendChannel.takeFirstSendOrPeekClosed():kotlinx.coroutines.channels.Send");
    }

    /* access modifiers changed from: protected */
    public final ReceiveOrClosed<?> sendBuffered(E e2) {
        LockFreeLinkedListNode prevNode;
        LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
        LockFreeLinkedListNode sendBuffered = new SendBuffered(e2);
        do {
            prevNode = lockFreeLinkedListNode.getPrevNode();
            if (prevNode instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) prevNode;
            }
        } while (!prevNode.addNext(sendBuffered, lockFreeLinkedListNode));
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean isFullImpl() {
        return !(this.queue.getNextNode() instanceof ReceiveOrClosed) && isBufferFull();
    }

    public final Object send(E e2, d<? super x> dVar) {
        if (offerInternal(e2) == AbstractChannelKt.OFFER_SUCCESS) {
            return x.f47997a;
        }
        Object sendSuspend = sendSuspend(e2, dVar);
        return sendSuspend == a.COROUTINE_SUSPENDED ? sendSuspend : x.f47997a;
    }

    /* access modifiers changed from: private */
    public final void helpCloseAndResumeWithSendException(d<?> dVar, Closed<?> closed) {
        helpClose(closed);
        Throwable sendException = closed.getSendException();
        p.a aVar = p.Companion;
        dVar.resumeWith(p.m530constructorimpl(ResultKt.a(sendException)));
    }

    /* access modifiers changed from: protected */
    public Object enqueueSend(Send send) {
        boolean z;
        LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysFull()) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
            do {
                prevNode = lockFreeLinkedListNode.getPrevNode();
                if (prevNode instanceof ReceiveOrClosed) {
                    return prevNode;
                }
            } while (!prevNode.addNext(send, lockFreeLinkedListNode));
            return null;
        }
        LockFreeLinkedListNode lockFreeLinkedListNode2 = this.queue;
        LockFreeLinkedListNode lockFreeLinkedListNode3 = send;
        LockFreeLinkedListNode.CondAddOp abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 = new AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(lockFreeLinkedListNode3, lockFreeLinkedListNode3, this);
        while (true) {
            LockFreeLinkedListNode prevNode2 = lockFreeLinkedListNode2.getPrevNode();
            if (!(prevNode2 instanceof ReceiveOrClosed)) {
                int tryCondAddNext = prevNode2.tryCondAddNext(lockFreeLinkedListNode3, lockFreeLinkedListNode2, abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1);
                z = true;
                if (tryCondAddNext != 1) {
                    if (tryCondAddNext == 2) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return prevNode2;
            }
        }
        if (!z) {
            return AbstractChannelKt.ENQUEUE_FAILED;
        }
        return null;
    }

    public boolean close(Throwable th) {
        boolean z;
        Closed closed = new Closed(th);
        LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
        while (true) {
            LockFreeLinkedListNode prevNode = lockFreeLinkedListNode.getPrevNode();
            z = true;
            if (!(prevNode instanceof Closed)) {
                if (prevNode.addNext(closed, lockFreeLinkedListNode)) {
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            LockFreeLinkedListNode prevNode2 = this.queue.getPrevNode();
            if (prevNode2 != null) {
                closed = (Closed) prevNode2;
            } else {
                throw new u("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
            }
        }
        helpClose(closed);
        if (z) {
            invokeOnCloseHandler(th);
        }
        return z;
    }

    private final void invokeOnCloseHandler(Throwable th) {
        Object obj = this.onCloseHandler;
        if (obj != null && obj != AbstractChannelKt.HANDLER_INVOKED && onCloseHandler$FU.compareAndSet(this, obj, AbstractChannelKt.HANDLER_INVOKED)) {
            ((b) ab.a(obj, 1)).invoke(th);
        }
    }

    private final void helpClose(Closed<?> closed) {
        Object r2 = InlineList.m550constructorimpl$default((Object) null, 1, (g) null);
        while (true) {
            LockFreeLinkedListNode prevNode = closed.getPrevNode();
            if (!(prevNode instanceof Receive)) {
                prevNode = null;
            }
            Receive receive = (Receive) prevNode;
            if (receive == null) {
                break;
            } else if (!receive.remove()) {
                receive.helpRemove();
            } else {
                r2 = InlineList.m553plusimpl(r2, receive);
            }
        }
        if (r2 != null) {
            if (!(r2 instanceof ArrayList)) {
                ((Receive) r2).resumeReceiveClosed(closed);
            } else if (r2 != null) {
                ArrayList arrayList = (ArrayList) r2;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Receive) arrayList.get(size)).resumeReceiveClosed(closed);
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
            }
        }
        onClosedIdempotent(closed);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r2 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.coroutines.channels.ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        /*
            r4 = this;
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r4.queue
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
        L_0x0004:
            java.lang.Object r1 = r0.getNext()
            if (r1 == 0) goto L_0x0031
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = 0
            if (r1 != r0) goto L_0x0010
            goto L_0x002a
        L_0x0010:
            boolean r3 = r1 instanceof kotlinx.coroutines.channels.ReceiveOrClosed
            if (r3 != 0) goto L_0x0015
            goto L_0x002a
        L_0x0015:
            r2 = r1
            kotlinx.coroutines.channels.ReceiveOrClosed r2 = (kotlinx.coroutines.channels.ReceiveOrClosed) r2
            boolean r2 = r2 instanceof kotlinx.coroutines.channels.Closed
            if (r2 == 0) goto L_0x0023
            boolean r2 = r1.isRemoved()
            if (r2 != 0) goto L_0x0023
            goto L_0x0029
        L_0x0023:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = r1.removeOrNext()
            if (r2 != 0) goto L_0x002d
        L_0x0029:
            r2 = r1
        L_0x002a:
            kotlinx.coroutines.channels.ReceiveOrClosed r2 = (kotlinx.coroutines.channels.ReceiveOrClosed) r2
            return r2
        L_0x002d:
            r2.helpRemovePrev()
            goto L_0x0004
        L_0x0031:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractSendChannel.takeFirstReceiveOrPeekClosed():kotlinx.coroutines.channels.ReceiveOrClosed");
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + '{' + getQueueDebugStateString() + '}' + getBufferDebugString();
    }

    private final String getQueueDebugStateString() {
        String str;
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (nextNode == this.queue) {
            return "EmptyQueue";
        }
        if (nextNode instanceof Closed) {
            str = nextNode.toString();
        } else if (nextNode instanceof Receive) {
            str = "ReceiveQueued";
        } else if (nextNode instanceof Send) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:".concat(String.valueOf(nextNode));
        }
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (prevNode == nextNode) {
            return str;
        }
        String str2 = str + ",queueSize=" + countQueueSize();
        if (!(prevNode instanceof Closed)) {
            return str2;
        }
        return str2 + ",closedForSend=" + prevNode;
    }

    private final int countQueueSize() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        Object next = lockFreeLinkedListHead.getNext();
        if (next != null) {
            int i2 = 0;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !k.a((Object) lockFreeLinkedListNode, (Object) lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                    i2++;
                }
            }
            return i2;
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public static final class SendBuffered<E> extends Send {
        public final E element;

        public final void completeResumeSend() {
        }

        public final void resumeSendClosed(Closed<?> closed) {
        }

        public SendBuffered(E e2) {
            this.element = e2;
        }

        public final Object getPollResult() {
            return this.element;
        }

        public final Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol symbol = CancellableContinuationImplKt.RESUME_TOKEN;
            if (prepareOp != null) {
                prepareOp.finishPrepare();
            }
            return symbol;
        }

        public final String toString() {
            return "SendBuffered@" + DebugStringsKt.getHexAddress(this) + '(' + this.element + ')';
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object sendSuspend(E e2, d<? super x> dVar) {
        CancellableContinuationImpl<? super x> orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(kotlin.d.a.b.a(dVar));
        CancellableContinuation cancellableContinuation = orCreateCancellableContinuation;
        while (true) {
            if (isFullImpl()) {
                SendElement sendElement = new SendElement(e2, cancellableContinuation);
                Object enqueueSend = enqueueSend(sendElement);
                if (enqueueSend == null) {
                    CancellableContinuationKt.removeOnCancellation(cancellableContinuation, sendElement);
                    break;
                } else if (enqueueSend instanceof Closed) {
                    helpCloseAndResumeWithSendException(cancellableContinuation, (Closed) enqueueSend);
                    break;
                } else if (enqueueSend != AbstractChannelKt.ENQUEUE_FAILED && !(enqueueSend instanceof Receive)) {
                    throw new IllegalStateException("enqueueSend returned ".concat(String.valueOf(enqueueSend)).toString());
                }
            }
            Object offerInternal = offerInternal(e2);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                x xVar = x.f47997a;
                p.a aVar = p.Companion;
                cancellableContinuation.resumeWith(p.m530constructorimpl(xVar));
                break;
            } else if (offerInternal != AbstractChannelKt.OFFER_FAILED) {
                if (offerInternal instanceof Closed) {
                    helpCloseAndResumeWithSendException(cancellableContinuation, (Closed) offerInternal);
                } else {
                    throw new IllegalStateException("offerInternal returned ".concat(String.valueOf(offerInternal)).toString());
                }
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return result;
    }
}
