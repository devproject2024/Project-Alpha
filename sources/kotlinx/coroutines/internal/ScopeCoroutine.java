package kotlinx.coroutines.internal;

import kotlin.d.a.b;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletedExceptionallyKt;
import kotlinx.coroutines.DispatchedContinuationKt;
import kotlinx.coroutines.Job;

public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements e {
    public final d<T> uCont;

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final boolean isScopedCoroutine() {
        return true;
    }

    public ScopeCoroutine(f fVar, d<? super T> dVar) {
        super(fVar, true);
        this.uCont = dVar;
    }

    public final e getCallerFrame() {
        return (e) this.uCont;
    }

    public final Job getParent$kotlinx_coroutines_core() {
        return (Job) this.parentContext.get(Job.Key);
    }

    public void afterCompletion(Object obj) {
        DispatchedContinuationKt.resumeCancellableWith(b.a(this.uCont), CompletedExceptionallyKt.recoverResult(obj, this.uCont));
    }

    public void afterResume(Object obj) {
        d<T> dVar = this.uCont;
        dVar.resumeWith(CompletedExceptionallyKt.recoverResult(obj, dVar));
    }
}
