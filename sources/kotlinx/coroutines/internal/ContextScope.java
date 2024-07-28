package kotlinx.coroutines.internal;

import kotlin.d.f;
import kotlinx.coroutines.CoroutineScope;

public final class ContextScope implements CoroutineScope {
    private final f coroutineContext;

    public ContextScope(f fVar) {
        this.coroutineContext = fVar;
    }

    public final f getCoroutineContext() {
        return this.coroutineContext;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
