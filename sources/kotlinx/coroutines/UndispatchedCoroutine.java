package kotlinx.coroutines;

import kotlin.d.d;
import kotlin.d.f;
import kotlin.x;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    public UndispatchedCoroutine(f fVar, d<? super T> dVar) {
        super(fVar, dVar);
    }

    public final void afterResume(Object obj) {
        Object recoverResult = CompletedExceptionallyKt.recoverResult(obj, this.uCont);
        f context = this.uCont.getContext();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, (Object) null);
        try {
            this.uCont.resumeWith(recoverResult);
            x xVar = x.f47997a;
        } finally {
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
        }
    }
}
