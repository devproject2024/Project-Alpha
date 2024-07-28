package kotlinx.coroutines.flow.internal;

import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;

public abstract class ChannelFlow<T> implements FusibleFlow<T> {
    public final int capacity;
    public final f context;

    public String additionalToStringProps() {
        return "";
    }

    public Object collect(FlowCollector<? super T> flowCollector, d<? super x> dVar) {
        return collect$suspendImpl(this, flowCollector, dVar);
    }

    /* access modifiers changed from: protected */
    public abstract Object collectTo(ProducerScope<? super T> producerScope, d<? super x> dVar);

    public ChannelFlow(f fVar, int i2) {
        this.context = fVar;
        this.capacity = i2;
    }

    public final m<ProducerScope<? super T>, d<? super x>, Object> getCollectToFun$kotlinx_coroutines_core() {
        return new ChannelFlow$collectToFun$1(this, (d) null);
    }

    private final int getProduceCapacity() {
        int i2 = this.capacity;
        if (i2 == -3) {
            return -2;
        }
        return i2;
    }

    public ReceiveChannel<T> produceImpl(CoroutineScope coroutineScope) {
        return ProduceKt.produce$default(coroutineScope, this.context, getProduceCapacity(), CoroutineStart.ATOMIC, (b) null, getCollectToFun$kotlinx_coroutines_core(), 8, (Object) null);
    }

    static /* synthetic */ Object collect$suspendImpl(ChannelFlow channelFlow, FlowCollector flowCollector, d dVar) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ChannelFlow$collect$2(channelFlow, flowCollector, (d) null), dVar);
        return coroutineScope == a.COROUTINE_SUSPENDED ? coroutineScope : x.f47997a;
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '[' + additionalToStringProps() + "context=" + this.context + ", capacity=" + this.capacity + ']';
    }
}
