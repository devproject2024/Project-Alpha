package kotlinx.coroutines.flow;

import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

public final class FlowKt {
    public static final <T> Flow<T> channelFlow(m<? super ProducerScope<? super T>, ? super d<? super x>, ? extends Object> mVar) {
        return FlowKt__BuildersKt.channelFlow(mVar);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, d<? super x> dVar) {
        return FlowKt__ChannelsKt.emitAll(flowCollector, receiveChannel, dVar);
    }

    public static final <T> Flow<T> flow(m<? super FlowCollector<? super T>, ? super d<? super x>, ? extends Object> mVar) {
        return FlowKt__BuildersKt.flow(mVar);
    }
}
