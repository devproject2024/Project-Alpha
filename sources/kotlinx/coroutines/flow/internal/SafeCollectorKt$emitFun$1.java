package kotlinx.coroutines.flow.internal;

import kotlin.d.d;
import kotlin.g.a.q;
import kotlin.g.b.i;
import kotlin.g.b.y;
import kotlin.x;
import kotlinx.coroutines.flow.FlowCollector;

final /* synthetic */ class SafeCollectorKt$emitFun$1 extends i implements q<FlowCollector<? super Object>, Object, d<? super x>, Object> {
    SafeCollectorKt$emitFun$1() {
        super(3);
    }

    public final String getName() {
        return "emit";
    }

    public final kotlin.k.d getOwner() {
        return y.b(FlowCollector.class);
    }

    public final String getSignature() {
        return "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;";
    }

    public final Object invoke(FlowCollector<Object> flowCollector, Object obj, d<? super x> dVar) {
        return flowCollector.emit(obj, dVar);
    }
}
