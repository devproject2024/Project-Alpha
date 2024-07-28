package kotlinx.coroutines;

import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlin.x;

public final class DelayKt {
    public static final Object delay(long j, d<? super x> dVar) {
        if (j <= 0) {
            return x.f47997a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b.a(dVar), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        getDelay(cancellableContinuation.getContext()).scheduleResumeAfterDelay(j, cancellableContinuation);
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return result;
    }

    public static final Delay getDelay(f fVar) {
        f.b bVar = fVar.get(e.f47904a);
        if (!(bVar instanceof Delay)) {
            bVar = null;
        }
        Delay delay = (Delay) bVar;
        return delay == null ? DefaultExecutorKt.getDefaultDelay() : delay;
    }
}
