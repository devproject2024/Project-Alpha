package kotlinx.coroutines;

import kotlin.d.d;

public interface Deferred<T> extends Job {
    Object await(d<? super T> dVar);
}
