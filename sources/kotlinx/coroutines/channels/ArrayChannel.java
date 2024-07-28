package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

public class ArrayChannel<E> extends AbstractChannel<E> {
    private Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private volatile int size;

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    public ArrayChannel(int i2) {
        this.capacity = i2;
        if (this.capacity > 0) {
            this.lock = new ReentrantLock();
            this.buffer = new Object[Math.min(this.capacity, 8)];
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + this.capacity + " was specified").toString());
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferFull() {
        return this.size == this.capacity;
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E e2) {
        ReceiveOrClosed takeFirstReceiveOrPeekClosed;
        Symbol tryResumeReceive;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i2 = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i2 < this.capacity) {
                this.size = i2 + 1;
                if (i2 == 0) {
                    do {
                        takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                        if (takeFirstReceiveOrPeekClosed != null) {
                            if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                                this.size = i2;
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
                    this.size = i2;
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
                ensureCapacity(i2);
                this.buffer[(this.head + i2) % this.buffer.length] = e2;
                Object obj = AbstractChannelKt.OFFER_SUCCESS;
                lock2.unlock();
                return obj;
            }
            Object obj2 = AbstractChannelKt.OFFER_FAILED;
            lock2.unlock();
            return obj2;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object enqueueSend(Send send) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return super.enqueueSend(send);
        } finally {
            lock2.unlock();
        }
    }

    private final void ensureCapacity(int i2) {
        Object[] objArr = this.buffer;
        if (i2 >= objArr.length) {
            Object[] objArr2 = new Object[Math.min(objArr.length * 2, this.capacity)];
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr3 = this.buffer;
                objArr2[i3] = objArr3[(this.head + i3) % objArr3.length];
            }
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    /* access modifiers changed from: protected */
    public Object pollInternal() {
        Send send;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object obj = this.buffer[this.head];
            this.buffer[this.head] = null;
            this.size = i2 - 1;
            Object obj2 = AbstractChannelKt.POLL_FAILED;
            boolean z = false;
            if (i2 == this.capacity) {
                send = null;
                while (true) {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        break;
                    }
                    if (takeFirstSendOrPeekClosed == null) {
                        k.a();
                    }
                    Symbol tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend((LockFreeLinkedListNode.PrepareOp) null);
                    if (tryResumeSend != null) {
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if (tryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN) {
                                z = true;
                            }
                            if (!z) {
                                throw new AssertionError();
                            }
                        }
                        if (takeFirstSendOrPeekClosed == null) {
                            k.a();
                        }
                        obj2 = takeFirstSendOrPeekClosed.getPollResult();
                        send = takeFirstSendOrPeekClosed;
                        z = true;
                    } else {
                        send = takeFirstSendOrPeekClosed;
                    }
                }
            } else {
                send = null;
            }
            if (obj2 != AbstractChannelKt.POLL_FAILED && !(obj2 instanceof Closed)) {
                this.size = i2;
                this.buffer[(this.head + i2) % this.buffer.length] = obj2;
            }
            this.head = (this.head + 1) % this.buffer.length;
            x xVar = x.f47997a;
            lock2.unlock();
            if (z) {
                if (send == null) {
                    k.a();
                }
                send.completeResumeSend();
            }
            return obj;
        } finally {
            lock2.unlock();
        }
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
    public void onCancelIdempotent(boolean z) {
        if (z) {
            Lock lock2 = this.lock;
            lock2.lock();
            try {
                int i2 = this.size;
                for (int i3 = 0; i3 < i2; i3++) {
                    this.buffer[this.head] = 0;
                    this.head = (this.head + 1) % this.buffer.length;
                }
                this.size = 0;
                x xVar = x.f47997a;
            } finally {
                lock2.unlock();
            }
        }
        super.onCancelIdempotent(z);
    }

    /* access modifiers changed from: protected */
    public String getBufferDebugString() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }
}
