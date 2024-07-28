package kotlinx.coroutines.intrinsics;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ab;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.u;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

public final class UndispatchedKt {
    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> scopeCoroutine, R r, m<? super R, ? super d<? super T>, ? extends Object> mVar) {
        Object obj;
        scopeCoroutine.initParentJob$kotlinx_coroutines_core();
        try {
            d dVar = scopeCoroutine;
            if (mVar != null) {
                obj = ((m) ab.a((Object) mVar, 2)).invoke(r, dVar);
                if (obj == a.COROUTINE_SUSPENDED) {
                    return a.COROUTINE_SUSPENDED;
                }
                Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(obj);
                if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                    return a.COROUTINE_SUSPENDED;
                }
                if (!(makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
                }
                Throwable th = ((CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core).cause;
                d<T> dVar2 = scopeCoroutine.uCont;
                if (DebugKt.getRECOVER_STACK_TRACES() && (dVar2 instanceof e)) {
                    th = StackTraceRecoveryKt.recoverFromStackFrame(th, (e) dVar2);
                }
                throw th;
            }
            throw new u("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th2) {
            obj = new CompletedExceptionally(th2, false, 2, (g) null);
        }
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(ScopeCoroutine<? super T> scopeCoroutine, R r, m<? super R, ? super d<? super T>, ? extends Object> mVar) {
        Object obj;
        scopeCoroutine.initParentJob$kotlinx_coroutines_core();
        boolean z = false;
        try {
            d dVar = scopeCoroutine;
            if (mVar != null) {
                obj = ((m) ab.a((Object) mVar, 2)).invoke(r, dVar);
                if (obj == a.COROUTINE_SUSPENDED) {
                    return a.COROUTINE_SUSPENDED;
                }
                Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(obj);
                if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                    return a.COROUTINE_SUSPENDED;
                }
                if (!(makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
                }
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core;
                Throwable th = completedExceptionally.cause;
                if (!(th instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th).coroutine != scopeCoroutine) {
                    z = true;
                }
                if (z) {
                    Throwable th2 = completedExceptionally.cause;
                    d<T> dVar2 = scopeCoroutine.uCont;
                    if (DebugKt.getRECOVER_STACK_TRACES() && (dVar2 instanceof e)) {
                        th2 = StackTraceRecoveryKt.recoverFromStackFrame(th2, (e) dVar2);
                    }
                    throw th2;
                } else if (!(obj instanceof CompletedExceptionally)) {
                    return obj;
                } else {
                    Throwable th3 = ((CompletedExceptionally) obj).cause;
                    d<T> dVar3 = scopeCoroutine.uCont;
                    if (DebugKt.getRECOVER_STACK_TRACES() && (dVar3 instanceof e)) {
                        th3 = StackTraceRecoveryKt.recoverFromStackFrame(th3, (e) dVar3);
                    }
                    throw th3;
                }
            } else {
                throw new u("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
        } catch (Throwable th4) {
            obj = new CompletedExceptionally(th4, false, 2, (g) null);
        }
    }

    public static final <T> void startCoroutineUndispatched(b<? super d<? super T>, ? extends Object> bVar, d<? super T> dVar) {
        f context;
        Object updateThreadContext;
        k.d(dVar, "completion");
        try {
            context = dVar.getContext();
            updateThreadContext = ThreadContextKt.updateThreadContext(context, (Object) null);
            if (bVar != null) {
                Object invoke = ((b) ab.a((Object) bVar, 1)).invoke(dVar);
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                if (invoke != a.COROUTINE_SUSPENDED) {
                    p.a aVar = p.Companion;
                    dVar.resumeWith(p.m530constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(ResultKt.a(th)));
        }
    }

    public static final <R, T> void startCoroutineUndispatched(m<? super R, ? super d<? super T>, ? extends Object> mVar, R r, d<? super T> dVar) {
        f context;
        Object updateThreadContext;
        k.d(dVar, "completion");
        try {
            context = dVar.getContext();
            updateThreadContext = ThreadContextKt.updateThreadContext(context, (Object) null);
            if (mVar != null) {
                Object invoke = ((m) ab.a((Object) mVar, 2)).invoke(r, dVar);
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                if (invoke != a.COROUTINE_SUSPENDED) {
                    p.a aVar = p.Companion;
                    dVar.resumeWith(p.m530constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(ResultKt.a(th)));
        }
    }
}
