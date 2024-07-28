package kotlinx.coroutines;

import kotlin.g.b.k;
import kotlin.u;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    public final NodeList getList() {
        return this;
    }

    public final boolean isActive() {
        return true;
    }

    public final String getString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        LockFreeLinkedListHead lockFreeLinkedListHead = this;
        Object next = lockFreeLinkedListHead.getNext();
        if (next != null) {
            boolean z = true;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !k.a((Object) lockFreeLinkedListNode, (Object) lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(jobNode);
                }
            }
            sb.append("]");
            String sb2 = sb.toString();
            k.a((Object) sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public final String toString() {
        return DebugKt.getDEBUG() ? getString("Active") : super.toString();
    }
}
