package kotlinx.coroutines.flow;

import kotlin.d.d;
import kotlin.x;

public interface Flow<T> {
    Object collect(FlowCollector<? super T> flowCollector, d<? super x> dVar);
}
