package kotlinx.coroutines.flow;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;

@f(b = "Flow.kt", c = {210}, d = "collect", e = "kotlinx.coroutines.flow.AbstractFlow")
final class AbstractFlow$collect$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbstractFlow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractFlow$collect$1(AbstractFlow abstractFlow, kotlin.d.d dVar) {
        super(dVar);
        this.this$0 = abstractFlow;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect((FlowCollector) null, this);
    }
}
