package kotlinx.coroutines;

import kotlin.g.a.b;
import kotlin.x;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

public abstract class CompletionHandlerBase extends LockFreeLinkedListNode implements b<Throwable, x> {
    public abstract void invoke(Throwable th);
}
