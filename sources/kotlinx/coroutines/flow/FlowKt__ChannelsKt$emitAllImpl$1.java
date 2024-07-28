package kotlinx.coroutines.flow;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import kotlinx.coroutines.channels.ReceiveChannel;

@f(b = "Channels.kt", c = {47, 58}, d = "emitAllImpl$FlowKt__ChannelsKt", e = "kotlinx.coroutines.flow.FlowKt__ChannelsKt")
final class FlowKt__ChannelsKt$emitAllImpl$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    FlowKt__ChannelsKt$emitAllImpl$1(kotlin.d.d dVar) {
        super(dVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt((FlowCollector) null, (ReceiveChannel) null, false, this);
    }
}
