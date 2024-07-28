package kotlinx.coroutines;

import kotlin.g.a.b;
import kotlin.x;

final class CompletedWithCancellation {
    public final b<Throwable, x> onCancellation;
    public final Object result;

    public final String toString() {
        return "CompletedWithCancellation[" + this.result + ']';
    }
}
