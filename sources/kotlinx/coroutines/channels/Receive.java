package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

public abstract class Receive<E> extends LockFreeLinkedListNode implements ReceiveOrClosed<E> {
    public abstract void resumeReceiveClosed(Closed<?> closed);

    public Object getOfferResult() {
        return AbstractChannelKt.OFFER_SUCCESS;
    }
}
