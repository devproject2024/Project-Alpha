package kotlinx.coroutines.internal;

import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.l;
import kotlinx.coroutines.ThreadContextElement;

final class ThreadContextKt$restoreState$1 extends l implements m<ThreadState, f.b, ThreadState> {
    public static final ThreadContextKt$restoreState$1 INSTANCE = new ThreadContextKt$restoreState$1();

    ThreadContextKt$restoreState$1() {
        super(2);
    }

    public final ThreadState invoke(ThreadState threadState, f.b bVar) {
        if (bVar instanceof ThreadContextElement) {
            ((ThreadContextElement) bVar).restoreThreadContext(threadState.getContext(), threadState.take());
        }
        return threadState;
    }
}
