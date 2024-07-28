package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

public class ConflatedChannel<E> extends AbstractChannel<E> {
    private static final Companion Companion = new Companion((g) null);
    private static final Symbol EMPTY = new Symbol("EMPTY");
    private final ReentrantLock lock = new ReentrantLock();
    private Object value = EMPTY;

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferFull() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferEmpty() {
        return this.value == EMPTY;
    }

    static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E e2) {
        ReceiveOrClosed takeFirstReceiveOrPeekClosed;
        Symbol tryResumeReceive;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (this.value == EMPTY) {
                do {
                    takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                    if (takeFirstReceiveOrPeekClosed != null) {
                        if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                            if (takeFirstReceiveOrPeekClosed == null) {
                                k.a();
                            }
                            lock2.unlock();
                            return takeFirstReceiveOrPeekClosed;
                        }
                        if (takeFirstReceiveOrPeekClosed == null) {
                            k.a();
                        }
                        tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e2, (LockFreeLinkedListNode.PrepareOp) null);
                    }
                } while (tryResumeReceive == null);
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(tryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN)) {
                        throw new AssertionError();
                    }
                }
                x xVar = x.f47997a;
                lock2.unlock();
                if (takeFirstReceiveOrPeekClosed == null) {
                    k.a();
                }
                takeFirstReceiveOrPeekClosed.completeResumeReceive(e2);
                if (takeFirstReceiveOrPeekClosed == null) {
                    k.a();
                }
                return takeFirstReceiveOrPeekClosed.getOfferResult();
            }
            this.value = e2;
            Object obj = AbstractChannelKt.OFFER_SUCCESS;
            lock2.unlock();
            return obj;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object pollInternal() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (this.value == EMPTY) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object obj = this.value;
            this.value = EMPTY;
            x xVar = x.f47997a;
            lock2.unlock();
            return obj;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelIdempotent(boolean z) {
        if (z) {
            Lock lock2 = this.lock;
            lock2.lock();
            try {
                this.value = EMPTY;
                x xVar = x.f47997a;
            } finally {
                lock2.unlock();
            }
        }
        super.onCancelIdempotent(z);
    }

    /* access modifiers changed from: protected */
    public boolean enqueueReceiveInternal(Receive<? super E> receive) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return super.enqueueReceiveInternal(receive);
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public String getBufferDebugString() {
        return "(value=" + this.value + ')';
    }
}
