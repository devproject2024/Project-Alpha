package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.g.a.b;
import kotlin.x;

final class InvokeOnCancelling extends JobCancellingNode<Job> {
    private static final AtomicIntegerFieldUpdater _invoked$FU = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked");
    private volatile int _invoked = 0;
    private final b<Throwable, x> handler;

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public InvokeOnCancelling(Job job, b<? super Throwable, x> bVar) {
        super(job);
        this.handler = bVar;
    }

    public final void invoke(Throwable th) {
        if (_invoked$FU.compareAndSet(this, 0, 1)) {
            this.handler.invoke(th);
        }
    }

    public final String toString() {
        return "InvokeOnCancelling[" + DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + ']';
    }
}
