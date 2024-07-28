package kotlinx.coroutines;

import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;

public abstract class AbstractCoroutine<T> extends JobSupport implements d<T>, CoroutineScope, Job {
    private final f context = this.parentContext.plus(this);
    protected final f parentContext;

    /* access modifiers changed from: protected */
    public void onCancelled(Throwable th, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onCompleted(T t) {
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public AbstractCoroutine(f fVar, boolean z) {
        super(z);
        this.parentContext = fVar;
    }

    public final f getContext() {
        return this.context;
    }

    public f getCoroutineContext() {
        return this.context;
    }

    public boolean isActive() {
        return super.isActive();
    }

    public final void initParentJob$kotlinx_coroutines_core() {
        initParentJobInternal$kotlinx_coroutines_core((Job) this.parentContext.get(Job.Key));
    }

    public final void onStartInternal$kotlinx_coroutines_core() {
        onStart();
    }

    /* access modifiers changed from: protected */
    public String cancellationExceptionMessage() {
        return DebugStringsKt.getClassSimpleName(this) + " was cancelled";
    }

    /* access modifiers changed from: protected */
    public final void onCompletionInternal(Object obj) {
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            onCancelled(completedExceptionally.cause, completedExceptionally.getHandled());
            return;
        }
        onCompleted(obj);
    }

    public final void resumeWith(Object obj) {
        Object makeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(CompletedExceptionallyKt.toState(obj));
        if (makeCompletingOnce$kotlinx_coroutines_core != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            afterResume(makeCompletingOnce$kotlinx_coroutines_core);
        }
    }

    /* access modifiers changed from: protected */
    public void afterResume(Object obj) {
        afterCompletion(obj);
    }

    public final void handleOnCompletionException$kotlinx_coroutines_core(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, th);
    }

    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.context);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        return "\"" + coroutineName + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    public final <R> void start(CoroutineStart coroutineStart, R r, m<? super R, ? super d<? super T>, ? extends Object> mVar) {
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(mVar, r, this);
    }
}
