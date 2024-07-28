package kotlinx.coroutines.internal;

import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.l;
import kotlinx.coroutines.ThreadContextElement;

final class ThreadContextKt$updateState$1 extends l implements m<ThreadState, f.b, ThreadState> {
    public static final ThreadContextKt$updateState$1 INSTANCE = new ThreadContextKt$updateState$1();

    ThreadContextKt$updateState$1() {
        super(2);
    }

    public final ThreadState invoke(ThreadState threadState, f.b bVar) {
        if (bVar instanceof ThreadContextElement) {
            threadState.append(((ThreadContextElement) bVar).updateThreadContext(threadState.getContext()));
        }
        return threadState;
    }
}
