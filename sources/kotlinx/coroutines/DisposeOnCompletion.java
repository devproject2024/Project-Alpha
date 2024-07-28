package kotlinx.coroutines;

import kotlin.x;

public final class DisposeOnCompletion extends JobNode<Job> {
    private final DisposableHandle handle;

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public DisposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        super(job);
        this.handle = disposableHandle;
    }

    public final void invoke(Throwable th) {
        this.handle.dispose();
    }

    public final String toString() {
        return "DisposeOnCompletion[" + this.handle + ']';
    }
}
