package kotlinx.coroutines.channels;

public class RendezvousChannel<E> extends AbstractChannel<E> {
    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysEmpty() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysFull() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferEmpty() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferFull() {
        return true;
    }
}
