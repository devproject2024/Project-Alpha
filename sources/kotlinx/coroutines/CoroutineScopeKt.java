package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

public final class CoroutineScopeKt {
    public static final <R> Object coroutineScope(m<? super CoroutineScope, ? super d<? super R>, ? extends Object> mVar, d<? super R> dVar) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(dVar.getContext(), dVar);
        Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, mVar);
        if (startUndispatchedOrReturn == a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return startUndispatchedOrReturn;
    }

    public static final CoroutineScope CoroutineScope(f fVar) {
        if (fVar.get(Job.Key) == null) {
            fVar = fVar.plus(JobKt__JobKt.Job$default((Job) null, 1, (Object) null));
        }
        return new ContextScope(fVar);
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        cancel(coroutineScope, cancellationException);
    }

    public static final void cancel(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
            return;
        }
        throw new IllegalStateException("Scope cannot be cancelled because it does not have a job: ".concat(String.valueOf(coroutineScope)).toString());
    }
}
