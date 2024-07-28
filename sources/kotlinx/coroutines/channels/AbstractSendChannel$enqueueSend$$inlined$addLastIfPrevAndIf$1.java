package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

public final class AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 extends LockFreeLinkedListNode.CondAddOp {
    final /* synthetic */ LockFreeLinkedListNode $node;
    final /* synthetic */ AbstractSendChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, AbstractSendChannel abstractSendChannel) {
        super(lockFreeLinkedListNode2);
        this.$node = lockFreeLinkedListNode;
        this.this$0 = abstractSendChannel;
    }

    public final Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode) {
        if (this.this$0.isBufferFull()) {
            return null;
        }
        return LockFreeLinkedListKt.getCONDITION_FALSE();
    }
}
