package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.internal.ThreadContextKt;

public final class DispatchedContinuation<T> extends DispatchedTask<T> implements e, d<T> {
    private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    public Object _state = DispatchedContinuationKt.UNDEFINED;
    private final e callerFrame;
    public final d<T> continuation;
    public final Object countOrElement;
    public final CoroutineDispatcher dispatcher;

    public final f getContext() {
        return this.continuation.getContext();
    }

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, d<? super T> dVar) {
        super(0);
        this.dispatcher = coroutineDispatcher;
        this.continuation = dVar;
        d<T> dVar2 = this.continuation;
        this.callerFrame = (e) (!(dVar2 instanceof e) ? null : dVar2);
        this.countOrElement = ThreadContextKt.threadContextElements(getContext());
        this._reusableCancellableContinuation = null;
    }

    public final e getCallerFrame() {
        return this.callerFrame;
    }

    public final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof CancellableContinuationImpl)) {
            obj = null;
        }
        return (CancellableContinuationImpl) obj;
    }

    public final boolean isReusable(CancellableContinuationImpl<?> cancellableContinuationImpl) {
        Object obj = this._reusableCancellableContinuation;
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CancellableContinuationImpl) || obj == cancellableContinuationImpl) {
            return true;
        }
        return false;
    }

    public final Object takeState$kotlinx_coroutines_core() {
        Object obj = this._state;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(obj != DispatchedContinuationKt.UNDEFINED)) {
                throw new AssertionError();
            }
        }
        this._state = DispatchedContinuationKt.UNDEFINED;
        return obj;
    }

    public final d<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    public final void resumeWith(Object obj) {
        f context;
        Object updateThreadContext;
        f context2 = this.continuation.getContext();
        Object state = CompletedExceptionallyKt.toState(obj);
        if (this.dispatcher.isDispatchNeeded(context2)) {
            this._state = state;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context2, this);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this._state = state;
            this.resumeMode = 0;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        DispatchedTask dispatchedTask = this;
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            context = getContext();
            updateThreadContext = ThreadContextKt.updateThreadContext(context, this.countOrElement);
            this.continuation.resumeWith(obj);
            x xVar = x.f47997a;
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
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
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation() {
        Object obj;
        do {
            obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = DispatchedContinuationKt.REUSABLE_CLAIMED;
                return null;
            } else if (!(obj instanceof CancellableContinuationImpl)) {
                throw new IllegalStateException("Inconsistent state ".concat(String.valueOf(obj)).toString());
            }
        } while (!_reusableCancellableContinuation$FU.compareAndSet(this, obj, DispatchedContinuationKt.REUSABLE_CLAIMED));
        return (CancellableContinuationImpl) obj;
    }

    public final Throwable checkPostponedCancellation(CancellableContinuation<?> cancellableContinuation) {
        do {
            Object obj = this._reusableCancellableContinuation;
            if (obj != DispatchedContinuationKt.REUSABLE_CLAIMED) {
                if (obj == null) {
                    return null;
                }
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException("Inconsistent state ".concat(String.valueOf(obj)).toString());
                } else if (_reusableCancellableContinuation$FU.compareAndSet(this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!_reusableCancellableContinuation$FU.compareAndSet(this, DispatchedContinuationKt.REUSABLE_CLAIMED, cancellableContinuation));
        return null;
    }

    public final boolean postponeCancellation(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (k.a(obj, (Object) DispatchedContinuationKt.REUSABLE_CLAIMED)) {
                if (_reusableCancellableContinuation$FU.compareAndSet(this, DispatchedContinuationKt.REUSABLE_CLAIMED, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (_reusableCancellableContinuation$FU.compareAndSet(this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }
}
