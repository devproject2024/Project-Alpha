package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.channels.ProducerScope;

@f(b = "ChannelFlow.kt", c = {53}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1")
final class ChannelFlow$collectToFun$1 extends k implements m<ProducerScope<? super T>, d<? super x>, Object> {
    Object L$0;
    int label;
    private ProducerScope p$0;
    final /* synthetic */ ChannelFlow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlow$collectToFun$1(ChannelFlow channelFlow, d dVar) {
        super(2, dVar);
        this.this$0 = channelFlow;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.this$0, dVar);
        channelFlow$collectToFun$1.p$0 = (ProducerScope) obj;
        return channelFlow$collectToFun$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelFlow$collectToFun$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            ProducerScope producerScope = this.p$0;
            ChannelFlow channelFlow = this.this$0;
            this.L$0 = producerScope;
            this.label = 1;
            if (channelFlow.collectTo(producerScope, this) == aVar) {
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
