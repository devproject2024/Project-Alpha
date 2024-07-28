package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadContextKt;

public final class DispatchedContinuationKt {
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");
    /* access modifiers changed from: private */
    public static final Symbol UNDEFINED = new Symbol("UNDEFINED");

    public static final <T> void resumeCancellableWith(d<? super T> dVar, Object obj) {
        boolean z;
        f context;
        Object updateThreadContext;
        if (dVar instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) dVar;
            Object state = CompletedExceptionallyKt.toState(obj);
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.getContext())) {
                dispatchedContinuation._state = state;
                dispatchedContinuation.resumeMode = 1;
                dispatchedContinuation.dispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
                return;
            }
            EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
                dispatchedContinuation._state = state;
                dispatchedContinuation.resumeMode = 1;
                eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
                return;
            }
            DispatchedTask dispatchedTask = dispatchedContinuation;
            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
            try {
                Job job = (Job) dispatchedContinuation.getContext().get(Job.Key);
                if (job == null || job.isActive()) {
                    z = false;
                } else {
                    p.a aVar = p.Companion;
                    dispatchedContinuation.resumeWith(p.m530constructorimpl(ResultKt.a((Throwable) job.getCancellationException())));
                    z = true;
                }
                if (!z) {
                    context = dispatchedContinuation.getContext();
                    updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
                    dispatchedContinuation.continuation.resumeWith(obj);
                    x xVar = x.f47997a;
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                }
                do {
                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            } catch (Throwable th) {
                try {
                    dispatchedTask.handleFatalException$kotlinx_coroutines_core(th, (Throwable) null);
                } finally {
                    eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                }
            }
        } else {
            dVar.resumeWith(obj);
        }
    }
}
