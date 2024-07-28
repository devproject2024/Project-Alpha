package kotlinx.coroutines.internal;

public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public boolean isRemoved() {
        return false;
    }

    public final boolean remove() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}
