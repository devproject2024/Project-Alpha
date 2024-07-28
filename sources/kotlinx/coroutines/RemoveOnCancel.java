package kotlinx.coroutines;

import kotlin.x;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

final class RemoveOnCancel extends CancelHandler {
    private final LockFreeLinkedListNode node;

    public RemoveOnCancel(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.node = lockFreeLinkedListNode;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public final void invoke(Throwable th) {
        this.node.remove();
    }

    public final String toString() {
        return "RemoveOnCancel[" + this.node + ']';
    }
}
