package kotlinx.coroutines.flow;

import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.x;
import kotlinx.coroutines.channels.ProducerScope;

final /* synthetic */ class FlowKt__BuildersKt {
    public static final <T> Flow<T> flow(m<? super FlowCollector<? super T>, ? super d<? super x>, ? extends Object> mVar) {
        return new SafeFlow<>(mVar);
    }

    public static final <T> Flow<T> channelFlow(m<? super ProducerScope<? super T>, ? super d<? super x>, ? extends Object> mVar) {
        return new ChannelFlowBuilder<>(mVar, (f) null, 0, 6, (g) null);
    }
}
