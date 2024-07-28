package kotlinx.coroutines;

import kotlin.d.f;

public final class Unconfined extends CoroutineDispatcher {
    public static final Unconfined INSTANCE = new Unconfined();

    public final boolean isDispatchNeeded(f fVar) {
        return false;
    }

    public final String toString() {
        return "Unconfined";
    }

    private Unconfined() {
    }

    public final void dispatch(f fVar, Runnable runnable) {
        YieldContext yieldContext = (YieldContext) fVar.get(YieldContext.Key);
        if (yieldContext != null) {
            yieldContext.dispatcherWasUnconfined = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }
}
