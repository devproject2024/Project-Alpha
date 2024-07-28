package kotlinx.coroutines.channels;

public class LinkedListChannel<E> extends AbstractChannel<E> {
    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysEmpty() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferEmpty() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferFull() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E e2) {
        ReceiveOrClosed<?> sendBuffered;
        do {
            Object offerInternal = super.offerInternal(e2);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
            if (offerInternal == AbstractChannelKt.OFFER_FAILED) {
                sendBuffered = sendBuffered(e2);
                if (sendBuffered == null) {
                    return AbstractChannelKt.OFFER_SUCCESS;
                }
            } else if (offerInternal instanceof Closed) {
                return offerInternal;
            } else {
                throw new IllegalStateException("Invalid offerInternal result ".concat(String.valueOf(offerInternal)).toString());
            }
        } while (!(sendBuffered instanceof Closed));
        return sendBuffered;
    }
}
