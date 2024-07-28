package kotlinx.coroutines;

import kotlin.g.a.b;
import kotlin.x;

final class InvokeOnCancel extends CancelHandler {
    private final b<Throwable, x> handler;

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public InvokeOnCancel(b<? super Throwable, x> bVar) {
        this.handler = bVar;
    }

    public final void invoke(Throwable th) {
        this.handler.invoke(th);
    }

    public final String toString() {
        return "InvokeOnCancel[" + DebugStringsKt.getClassSimpleName(this.handler) + '@' + DebugStringsKt.getHexAddress(this) + ']';
    }
}
