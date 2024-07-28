package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.x;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements e, CancellableContinuation<T> {
    private static final AtomicIntegerFieldUpdater _decision$FU;
    private static final AtomicReferenceFieldUpdater _state$FU;
    private volatile int _decision = 0;
    private volatile Object _parentHandle = null;
    private volatile Object _state = Active.INSTANCE;
    private final f context = this.delegate.getContext();
    private final d<T> delegate;

    static {
        Class<CancellableContinuationImpl> cls = CancellableContinuationImpl.class;
        _decision$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_decision");
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_state");
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String nameString() {
        return "CancellableContinuation";
    }

    public final d<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    public CancellableContinuationImpl(d<? super T> dVar, int i2) {
        super(i2);
        this.delegate = dVar;
    }

    public f getContext() {
        return this.context;
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) this._parentHandle;
    }

    private final void setParentHandle(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return this._state;
    }

    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    public void initCancellability() {
        setupCancellation();
    }

    private final boolean isReusable() {
        d<T> dVar = this.delegate;
        return (dVar instanceof DispatchedContinuation) && ((DispatchedContinuation) dVar).isReusable(this);
    }

    public final boolean resetState() {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getParentHandle() != NonDisposableHandle.INSTANCE)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(obj instanceof NotCompleted))) {
            throw new AssertionError();
        } else if (obj instanceof CompletedIdempotentResult) {
            detachChild$kotlinx_coroutines_core();
            return false;
        } else {
            this._decision = 0;
            this._state = Active.INSTANCE;
            return true;
        }
    }

    private final void setupCancellation() {
        Job job;
        if (!checkCompleted() && getParentHandle() == null && (job = (Job) this.delegate.getContext().get(Job.Key)) != null) {
            job.start();
            DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ChildContinuation(job, this), 2, (Object) null);
            setParentHandle(invokeOnCompletion$default);
            if (isCompleted() && !isReusable()) {
                invokeOnCompletion$default.dispose();
                setParentHandle(NonDisposableHandle.INSTANCE);
            }
        }
    }

    private final boolean checkCompleted() {
        Throwable checkPostponedCancellation;
        boolean isCompleted = isCompleted();
        if (this.resumeMode != 0) {
            return isCompleted;
        }
        d<T> dVar = this.delegate;
        if (!(dVar instanceof DispatchedContinuation)) {
            dVar = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) dVar;
        if (dispatchedContinuation == null || (checkPostponedCancellation = dispatchedContinuation.checkPostponedCancellation(this)) == null) {
            return isCompleted;
        }
        if (isCompleted) {
            return true;
        }
        cancel(checkPostponedCancellation);
        return true;
    }

    public e getCallerFrame() {
        d<T> dVar = this.delegate;
        if (!(dVar instanceof e)) {
            dVar = null;
        }
        return (e) dVar;
    }

    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    public void cancelResult$kotlinx_coroutines_core(Object obj, Throwable th) {
        if (obj instanceof CompletedWithCancellation) {
            try {
                ((CompletedWithCancellation) obj).onCancellation.invoke(th);
            } catch (Throwable th2) {
                CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in cancellation handler for ".concat(String.valueOf(this)), th2));
            }
        }
    }

    private final boolean cancelLater(Throwable th) {
        if (this.resumeMode != 0) {
            return false;
        }
        d<T> dVar = this.delegate;
        if (!(dVar instanceof DispatchedContinuation)) {
            dVar = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) dVar;
        if (dispatchedContinuation == null) {
            return false;
        }
        return dispatchedContinuation.postponeCancellation(th);
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable th) {
        if (!cancelLater(th)) {
            cancel(th);
            detachChildIfNonResuable();
        }
    }

    public Throwable getContinuationCancellationCause(Job job) {
        return job.getCancellationException();
    }

    public final Object getResult() {
        Job job;
        setupCancellation();
        if (trySuspend()) {
            return a.COROUTINE_SUSPENDED;
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            Throwable th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            d dVar = this;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                th = StackTraceRecoveryKt.recoverFromStackFrame(th, (e) dVar);
            }
            throw th;
        } else if (this.resumeMode != 1 || (job = (Job) getContext().get(Job.Key)) == null || job.isActive()) {
            return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
        } else {
            Throwable cancellationException = job.getCancellationException();
            cancelResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
            d dVar2 = this;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                cancellationException = StackTraceRecoveryKt.recoverFromStackFrame(cancellationException, (e) dVar2);
            }
            throw cancellationException;
        }
    }

    public void resumeWith(Object obj) {
        resumeImpl(CompletedExceptionallyKt.toState(obj, this), this.resumeMode);
    }

    private final void multipleHandlersError(b<? super Throwable, x> bVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + bVar + ", already has " + obj).toString());
    }

    private final CancelHandler makeHandler(b<? super Throwable, x> bVar) {
        return bVar instanceof CancelHandler ? (CancelHandler) bVar : new InvokeOnCancel(bVar);
    }

    private final void dispatchResume(int i2) {
        if (!tryResume()) {
            DispatchedTaskKt.dispatch(this, i2);
        }
    }

    private final void alreadyResumedError(Object obj) {
        throw new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(obj)).toString());
    }

    private final void detachChildIfNonResuable() {
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle parentHandle = getParentHandle();
        if (parentHandle != null) {
            parentHandle.dispose();
        }
        setParentHandle(NonDisposableHandle.INSTANCE);
    }

    public void completeResume(Object obj) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(obj == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        dispatchResume(this.resumeMode);
    }

    public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t) {
        d<T> dVar = this.delegate;
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (!(dVar instanceof DispatchedContinuation)) {
            dVar = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) dVar;
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        resumeImpl(t, coroutineDispatcher2 == coroutineDispatcher ? 2 : this.resumeMode);
    }

    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        if (obj instanceof CompletedIdempotentResult) {
            return ((CompletedIdempotentResult) obj).result;
        }
        return obj instanceof CompletedWithCancellation ? ((CompletedWithCancellation) obj).result : obj;
    }

    public String toString() {
        return nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + getState$kotlinx_coroutines_core() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    public boolean cancel(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof CancelHandler;
        } while (!_state$FU.compareAndSet(this, obj, new CancelledContinuation(this, th, z)));
        if (z) {
            try {
                ((CancelHandler) obj).invoke(th);
            } catch (Throwable th2) {
                CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in cancellation handler for ".concat(String.valueOf(this)), th2));
            }
        }
        detachChildIfNonResuable();
        dispatchResume(0);
        return true;
    }

    private final boolean trySuspend() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean tryResume() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    public void invokeOnCancellation(b<? super Throwable, x> bVar) {
        Throwable th = null;
        CancelHandler cancelHandler = null;
        while (true) {
            Object obj = this._state;
            if (obj instanceof Active) {
                if (cancelHandler == null) {
                    cancelHandler = makeHandler(bVar);
                }
                if (_state$FU.compareAndSet(this, obj, cancelHandler)) {
                    return;
                }
            } else if (obj instanceof CancelHandler) {
                multipleHandlersError(bVar, obj);
            } else if (obj instanceof CancelledContinuation) {
                if (!((CancelledContinuation) obj).makeHandled()) {
                    multipleHandlersError(bVar, obj);
                }
                try {
                    if (!(obj instanceof CompletedExceptionally)) {
                        obj = null;
                    }
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                    if (completedExceptionally != null) {
                        th = completedExceptionally.cause;
                    }
                    bVar.invoke(th);
                    return;
                } catch (Throwable th2) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in cancellation handler for ".concat(String.valueOf(this)), th2));
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final CancelledContinuation resumeImpl(Object obj, int i2) {
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof NotCompleted)) {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.makeResumed()) {
                        return cancelledContinuation;
                    }
                }
                alreadyResumedError(obj);
            } else if (_state$FU.compareAndSet(this, obj2, obj)) {
                detachChildIfNonResuable();
                dispatchResume(i2);
                return null;
            }
        }
    }

    public Object tryResume(T t, Object obj) {
        Object obj2;
        T t2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof NotCompleted)) {
                if (obj2 instanceof CompletedIdempotentResult) {
                    CompletedIdempotentResult completedIdempotentResult = (CompletedIdempotentResult) obj2;
                    if (completedIdempotentResult.idempotentResume == obj) {
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if (!(completedIdempotentResult.result == t)) {
                                throw new AssertionError();
                            }
                        }
                        return CancellableContinuationImplKt.RESUME_TOKEN;
                    }
                }
                return null;
            } else if (obj == null) {
                t2 = t;
            } else {
                t2 = new CompletedIdempotentResult(obj, t);
            }
        } while (!_state$FU.compareAndSet(this, obj2, t2));
        detachChildIfNonResuable();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }
}
