package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

public final class DispatchedTaskKt {
    public static final boolean isCancellableMode(int i2) {
        return i2 == 1;
    }

    public static final boolean isDispatchedMode(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public static final <T> void dispatch(DispatchedTask<? super T> dispatchedTask, int i2) {
        d<? super T> delegate$kotlinx_coroutines_core = dispatchedTask.getDelegate$kotlinx_coroutines_core();
        if (!isDispatchedMode(i2) || !(delegate$kotlinx_coroutines_core instanceof DispatchedContinuation) || isCancellableMode(i2) != isCancellableMode(dispatchedTask.resumeMode)) {
            resume(dispatchedTask, delegate$kotlinx_coroutines_core, i2);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) delegate$kotlinx_coroutines_core).dispatcher;
        f context = delegate$kotlinx_coroutines_core.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, dispatchedTask);
        } else {
            resumeUnconfined(dispatchedTask);
        }
    }

    public static final <T> void resume(DispatchedTask<? super T> dispatchedTask, d<? super T> dVar, int i2) {
        Object obj;
        Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core == null) {
            exceptionalResult$kotlinx_coroutines_core = null;
        } else if (DebugKt.getRECOVER_STACK_TRACES() && (dVar instanceof e)) {
            exceptionalResult$kotlinx_coroutines_core = StackTraceRecoveryKt.recoverFromStackFrame(exceptionalResult$kotlinx_coroutines_core, (e) dVar);
        }
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            p.a aVar = p.Companion;
            obj = ResultKt.a(exceptionalResult$kotlinx_coroutines_core);
        } else {
            p.a aVar2 = p.Companion;
            obj = dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        Object r3 = p.m530constructorimpl(obj);
        if (i2 == 0) {
            dVar.resumeWith(r3);
        } else if (i2 == 1) {
            DispatchedContinuationKt.resumeCancellableWith(dVar, r3);
        } else if (i2 != 2) {
            throw new IllegalStateException("Invalid mode ".concat(String.valueOf(i2)).toString());
        } else if (dVar != null) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) dVar;
            f context = dispatchedContinuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
            try {
                dispatchedContinuation.continuation.resumeWith(r3);
                x xVar = x.f47997a;
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } else {
            throw new u("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
        }
    }

    private static final void resumeUnconfined(DispatchedTask<?> dispatchedTask) {
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedTask);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            resume(dispatchedTask, dispatchedTask.getDelegate$kotlinx_coroutines_core(), 2);
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } catch (Throwable th) {
            dispatchedTask.handleFatalException$kotlinx_coroutines_core(th, (Throwable) null);
        } finally {
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        }
    }
}
