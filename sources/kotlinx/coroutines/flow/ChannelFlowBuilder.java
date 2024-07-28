package kotlinx.coroutines.flow;

import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.x;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

class ChannelFlowBuilder<T> extends ChannelFlow<T> {
    private final m<ProducerScope<? super T>, d<? super x>, Object> block;

    public Object collectTo(ProducerScope<? super T> producerScope, d<? super x> dVar) {
        return collectTo$suspendImpl(this, producerScope, dVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelFlowBuilder(m mVar, f fVar, int i2, int i3, g gVar) {
        this(mVar, (i3 & 2) != 0 ? kotlin.d.g.INSTANCE : fVar, (i3 & 4) != 0 ? -2 : i2);
    }

    public ChannelFlowBuilder(m<? super ProducerScope<? super T>, ? super d<? super x>, ? extends Object> mVar, f fVar, int i2) {
        super(fVar, i2);
        this.block = mVar;
    }

    static /* synthetic */ Object collectTo$suspendImpl(ChannelFlowBuilder channelFlowBuilder, ProducerScope producerScope, d dVar) {
        Object invoke = channelFlowBuilder.block.invoke(producerScope, dVar);
        return invoke == a.COROUTINE_SUSPENDED ? invoke : x.f47997a;
    }

    public String toString() {
        return "block[" + this.block + "] -> " + super.toString();
    }
}
