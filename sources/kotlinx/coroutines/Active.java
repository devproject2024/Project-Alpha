package kotlinx.coroutines;

final class Active implements NotCompleted {
    public static final Active INSTANCE = new Active();

    public final String toString() {
        return "Active";
    }

    private Active() {
    }
}
