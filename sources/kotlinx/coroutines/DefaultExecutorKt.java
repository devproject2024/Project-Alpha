package kotlinx.coroutines;

public final class DefaultExecutorKt {
    private static final Delay DefaultDelay = DefaultExecutor.INSTANCE;

    public static final Delay getDefaultDelay() {
        return DefaultDelay;
    }
}
