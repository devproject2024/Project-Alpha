package kotlinx.coroutines;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;

@f(b = "Builders.common.kt", c = {101}, d = "await$suspendImpl", e = "kotlinx.coroutines.DeferredCoroutine")
final class DeferredCoroutine$await$1 extends d {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeferredCoroutine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeferredCoroutine$await$1(DeferredCoroutine deferredCoroutine, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = deferredCoroutine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DeferredCoroutine.await$suspendImpl(this.this$0, this);
    }
}
