package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.g.b.g;
import kotlin.p;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

public final class CompletedExceptionallyKt {
    public static final <T> Object toState(Object obj) {
        Throwable r0 = p.m533exceptionOrNullimpl(obj);
        return r0 == null ? obj : new CompletedExceptionally(r0, false, 2, (g) null);
    }

    public static final <T> Object toState(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable r0 = p.m533exceptionOrNullimpl(obj);
        if (r0 == null) {
            return obj;
        }
        d dVar = cancellableContinuation;
        if (DebugKt.getRECOVER_STACK_TRACES() && (dVar instanceof e)) {
            r0 = StackTraceRecoveryKt.recoverFromStackFrame(r0, (e) dVar);
        }
        return new CompletedExceptionally(r0, false, 2, (g) null);
    }

    public static final <T> Object recoverResult(Object obj, d<? super T> dVar) {
        if (obj instanceof CompletedExceptionally) {
            p.a aVar = p.Companion;
            Throwable th = ((CompletedExceptionally) obj).cause;
            if (DebugKt.getRECOVER_STACK_TRACES() && (dVar instanceof e)) {
                th = StackTraceRecoveryKt.recoverFromStackFrame(th, (e) dVar);
            }
            return p.m530constructorimpl(ResultKt.a(th));
        }
        p.a aVar2 = p.Companion;
        return p.m530constructorimpl(obj);
    }
}
