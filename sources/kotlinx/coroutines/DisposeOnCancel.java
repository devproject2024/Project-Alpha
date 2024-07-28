package kotlinx.coroutines;

import kotlin.x;

final class DisposeOnCancel extends CancelHandler {
    private final DisposableHandle handle;

    public DisposeOnCancel(DisposableHandle disposableHandle) {
        this.handle = disposableHandle;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public final void invoke(Throwable th) {
        this.handle.dispose();
    }

    public final String toString() {
        return "DisposeOnCancel[" + this.handle + ']';
    }
}
