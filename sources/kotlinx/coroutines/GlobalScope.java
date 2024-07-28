package kotlinx.coroutines;

import kotlin.d.f;
import kotlin.d.g;

public final class GlobalScope implements CoroutineScope {
    public static final GlobalScope INSTANCE = new GlobalScope();

    private GlobalScope() {
    }

    public final f getCoroutineContext() {
        return g.INSTANCE;
    }
}
