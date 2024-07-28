package kotlinx.coroutines;

public final class NonDisposableHandle implements ChildHandle, DisposableHandle {
    public static final NonDisposableHandle INSTANCE = new NonDisposableHandle();

    public final boolean childCancelled(Throwable th) {
        return false;
    }

    public final void dispose() {
    }

    public final String toString() {
        return "NonDisposableHandle";
    }

    private NonDisposableHandle() {
    }
}
