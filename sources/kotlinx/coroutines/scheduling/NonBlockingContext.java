package kotlinx.coroutines.scheduling;

public final class NonBlockingContext implements TaskContext {
    public static final NonBlockingContext INSTANCE = new NonBlockingContext();
    private static final int taskMode = 0;

    public final void afterTask() {
    }

    private NonBlockingContext() {
    }

    public final int getTaskMode() {
        return taskMode;
    }
}
