package kotlinx.coroutines.internal;

import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.l;
import kotlinx.coroutines.ThreadContextElement;

final class ThreadContextKt$findOne$1 extends l implements m<ThreadContextElement<?>, f.b, ThreadContextElement<?>> {
    public static final ThreadContextKt$findOne$1 INSTANCE = new ThreadContextKt$findOne$1();

    ThreadContextKt$findOne$1() {
        super(2);
    }

    public final ThreadContextElement<?> invoke(ThreadContextElement<?> threadContextElement, f.b bVar) {
        if (threadContextElement != null) {
            return threadContextElement;
        }
        if (!(bVar instanceof ThreadContextElement)) {
            bVar = null;
        }
        return (ThreadContextElement) bVar;
    }
}
