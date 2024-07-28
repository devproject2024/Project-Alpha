package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@f(b = "ChannelFlow.kt", c = {101}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2")
final class ChannelFlow$collect$2 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ FlowCollector $collector;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ ChannelFlow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlow$collect$2(ChannelFlow channelFlow, FlowCollector flowCollector, d dVar) {
        super(2, dVar);
        this.this$0 = channelFlow;
        this.$collector = flowCollector;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        ChannelFlow$collect$2 channelFlow$collect$2 = new ChannelFlow$collect$2(this.this$0, this.$collector, dVar);
        channelFlow$collect$2.p$ = (CoroutineScope) obj;
        return channelFlow$collect$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelFlow$collect$2) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            FlowCollector flowCollector = this.$collector;
            ReceiveChannel produceImpl = this.this$0.produceImpl(coroutineScope);
            this.L$0 = coroutineScope;
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, produceImpl, this) == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return x.f47997a;
    }
}
