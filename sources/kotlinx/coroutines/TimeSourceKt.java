package kotlinx.coroutines;

public final class TimeSourceKt {
    private static TimeSource timeSource;

    public static final TimeSource getTimeSource() {
        return timeSource;
    }
}
