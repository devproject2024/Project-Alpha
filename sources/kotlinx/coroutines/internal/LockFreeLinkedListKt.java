package kotlinx.coroutines.internal;

import kotlin.u;

public final class LockFreeLinkedListKt {
    private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");
    private static final Object LIST_EMPTY = new Symbol("LIST_EMPTY");

    public static final Object getCONDITION_FALSE() {
        return CONDITION_FALSE;
    }

    public static final LockFreeLinkedListNode unwrap(Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Removed removed = (Removed) (!(obj instanceof Removed) ? null : obj);
        if (removed != null && (lockFreeLinkedListNode = removed.ref) != null) {
            return lockFreeLinkedListNode;
        }
        if (obj != null) {
            return (LockFreeLinkedListNode) obj;
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
}
