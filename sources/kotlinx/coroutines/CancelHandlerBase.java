package kotlinx.coroutines;

import kotlin.g.a.b;
import kotlin.x;

public abstract class CancelHandlerBase implements b<Throwable, x> {
    public abstract void invoke(Throwable th);
}
