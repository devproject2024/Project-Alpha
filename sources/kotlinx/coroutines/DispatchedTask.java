package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public void cancelResult$kotlinx_coroutines_core(Object obj, Throwable th) {
    }

    public abstract d<T> getDelegate$kotlinx_coroutines_core();

    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    public DispatchedTask(int i2) {
        this.resumeMode = i2;
    }

    public final Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    public final void run() {
        Object obj;
        f context;
        Object updateThreadContext;
        Object obj2;
        Throwable th;
        TaskContext taskContext = this.taskContext;
        try {
            d delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            if (delegate$kotlinx_coroutines_core != null) {
                DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
                d<T> dVar = dispatchedContinuation.continuation;
                context = dVar.getContext();
                Object takeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
                Job job = DispatchedTaskKt.isCancellableMode(this.resumeMode) ? (Job) context.get(Job.Key) : null;
                if (exceptionalResult$kotlinx_coroutines_core == null && job != null && !job.isActive()) {
                    CancellationException cancellationException = job.getCancellationException();
                    cancelResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core, cancellationException);
                    p.a aVar = p.Companion;
                    if (DebugKt.getRECOVER_STACK_TRACES()) {
                        if (dVar instanceof e) {
                            th = StackTraceRecoveryKt.recoverFromStackFrame(cancellationException, (e) dVar);
                            dVar.resumeWith(p.m530constructorimpl(ResultKt.a(th)));
                        }
                    }
                    th = cancellationException;
                    dVar.resumeWith(p.m530constructorimpl(ResultKt.a(th)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    p.a aVar2 = p.Companion;
                    dVar.resumeWith(p.m530constructorimpl(ResultKt.a(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    Object successfulResult$kotlinx_coroutines_core = getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
                    p.a aVar3 = p.Companion;
                    dVar.resumeWith(p.m530constructorimpl(successfulResult$kotlinx_coroutines_core));
                }
                x xVar = x.f47997a;
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                try {
                    p.a aVar4 = p.Companion;
                    taskContext.afterTask();
                    obj2 = p.m530constructorimpl(x.f47997a);
                } catch (Throwable th2) {
                    p.a aVar5 = p.Companion;
                    obj2 = p.m530constructorimpl(ResultKt.a(th2));
                }
                handleFatalException$kotlinx_coroutines_core((Throwable) null, p.m533exceptionOrNullimpl(obj2));
                return;
            }
            throw new u("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
        } catch (Throwable th3) {
            try {
                p.a aVar6 = p.Companion;
                taskContext.afterTask();
                obj = p.m530constructorimpl(x.f47997a);
            } catch (Throwable th4) {
                p.a aVar7 = p.Companion;
                obj = p.m530constructorimpl(ResultKt.a(th4));
            }
            handleFatalException$kotlinx_coroutines_core(th3, p.m533exceptionOrNullimpl(obj));
        }
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                a.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            String str = "Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
            if (th == null) {
                k.a();
            }
            CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError(str, th));
        }
    }
}
