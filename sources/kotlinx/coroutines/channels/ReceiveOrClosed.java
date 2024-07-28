package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

public interface ReceiveOrClosed<E> {
    void completeResumeReceive(E e2);

    Object getOfferResult();

    Symbol tryResumeReceive(E e2, LockFreeLinkedListNode.PrepareOp prepareOp);
}
