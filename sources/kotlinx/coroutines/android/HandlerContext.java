package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.d.f;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.j.e;
import kotlin.x;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

public final class HandlerContext extends HandlerDispatcher implements Delay {
    private volatile HandlerContext _immediate;
    /* access modifiers changed from: private */
    public final Handler handler;
    private final HandlerContext immediate;
    private final boolean invokeImmediately;
    private final String name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private HandlerContext(Handler handler2, String str, boolean z) {
        super((g) null);
        HandlerContext handlerContext = null;
        this.handler = handler2;
        this.name = str;
        this.invokeImmediately = z;
        this._immediate = this.invokeImmediately ? this : handlerContext;
        HandlerContext handlerContext2 = this._immediate;
        if (handlerContext2 == null) {
            handlerContext2 = new HandlerContext(this.handler, this.name, true);
            this._immediate = handlerContext2;
        }
        this.immediate = handlerContext2;
    }

    public HandlerContext(Handler handler2, String str) {
        this(handler2, str, false);
    }

    public final HandlerContext getImmediate() {
        return this.immediate;
    }

    public final boolean isDispatchNeeded(f fVar) {
        return !this.invokeImmediately || (k.a((Object) Looper.myLooper(), (Object) this.handler.getLooper()) ^ true);
    }

    public final void dispatch(f fVar, Runnable runnable) {
        this.handler.post(runnable);
    }

    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable) {
        this.handler.postDelayed(runnable, e.a(j, 4611686018427387903L));
        return new HandlerContext$invokeOnTimeout$1(this, runnable);
    }

    public final String toString() {
        String str = this.name;
        if (str == null) {
            return this.handler.toString();
        }
        if (!this.invokeImmediately) {
            return str;
        }
        return this.name + " [immediate]";
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).handler == this.handler;
    }

    public final int hashCode() {
        return System.identityHashCode(this.handler);
    }

    public final void scheduleResumeAfterDelay(long j, CancellableContinuation<? super x> cancellableContinuation) {
        Runnable handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 = new HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(this, cancellableContinuation);
        this.handler.postDelayed(handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1, e.a(j, 4611686018427387903L));
        cancellableContinuation.invokeOnCancellation(new HandlerContext$scheduleResumeAfterDelay$1(this, handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1));
    }
}
