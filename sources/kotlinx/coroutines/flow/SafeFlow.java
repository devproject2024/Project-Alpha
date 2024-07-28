package kotlinx.coroutines.flow;

import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;

final class SafeFlow<T> extends AbstractFlow<T> {
    private final m<FlowCollector<? super T>, d<? super x>, Object> block;

    public SafeFlow(m<? super FlowCollector<? super T>, ? super d<? super x>, ? extends Object> mVar) {
        this.block = mVar;
    }

    public final Object collectSafely(FlowCollector<? super T> flowCollector, d<? super x> dVar) {
        Object invoke = this.block.invoke(flowCollector, dVar);
        return invoke == a.COROUTINE_SUSPENDED ? invoke : x.f47997a;
    }
}
