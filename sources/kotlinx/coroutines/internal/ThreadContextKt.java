package kotlinx.coroutines.internal;

import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.u;
import kotlinx.coroutines.ThreadContextElement;

public final class ThreadContextKt {
    private static final Symbol ZERO = new Symbol("ZERO");
    private static final m<Object, f.b, Object> countAll = ThreadContextKt$countAll$1.INSTANCE;
    private static final m<ThreadContextElement<?>, f.b, ThreadContextElement<?>> findOne = ThreadContextKt$findOne$1.INSTANCE;
    private static final m<ThreadState, f.b, ThreadState> restoreState = ThreadContextKt$restoreState$1.INSTANCE;
    private static final m<ThreadState, f.b, ThreadState> updateState = ThreadContextKt$updateState$1.INSTANCE;

    public static final Object threadContextElements(f fVar) {
        Object fold = fVar.fold(0, countAll);
        if (fold == null) {
            k.a();
        }
        return fold;
    }

    public static final Object updateThreadContext(f fVar, Object obj) {
        if (obj == null) {
            obj = threadContextElements(fVar);
        }
        if (obj == 0) {
            return ZERO;
        }
        if (obj instanceof Integer) {
            return fVar.fold(new ThreadState(fVar, ((Number) obj).intValue()), updateState);
        }
        if (obj != null) {
            return ((ThreadContextElement) obj).updateThreadContext(fVar);
        }
        throw new u("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }

    public static final void restoreThreadContext(f fVar, Object obj) {
        if (obj != ZERO) {
            if (obj instanceof ThreadState) {
                ((ThreadState) obj).start();
                fVar.fold(obj, restoreState);
                return;
            }
            Object fold = fVar.fold(null, findOne);
            if (fold != null) {
                ((ThreadContextElement) fold).restoreThreadContext(fVar, obj);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }
}
