package kotlinx.coroutines;

import kotlin.g.a.b;
import kotlin.x;

final class InvokeOnCompletion extends JobNode<Job> {
    private final b<Throwable, x> handler;

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public InvokeOnCompletion(Job job, b<? super Throwable, x> bVar) {
        super(job);
        this.handler = bVar;
    }

    public final void invoke(Throwable th) {
        this.handler.invoke(th);
    }

    public final String toString() {
        return "InvokeOnCompletion[" + DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + ']';
    }
}
