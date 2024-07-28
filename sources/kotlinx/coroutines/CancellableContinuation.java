package kotlinx.coroutines;

import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.x;

public interface CancellableContinuation<T> extends d<T> {
    void completeResume(Object obj);

    void invokeOnCancellation(b<? super Throwable, x> bVar);

    void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t);

    Object tryResume(T t, Object obj);
}
