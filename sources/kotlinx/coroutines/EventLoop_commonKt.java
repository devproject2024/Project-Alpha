package kotlinx.coroutines;

import kotlinx.coroutines.internal.Symbol;

public final class EventLoop_commonKt {
    /* access modifiers changed from: private */
    public static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");
    /* access modifiers changed from: private */
    public static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");

    public static final long delayToNanos(long j) {
        if (j <= 0) {
            return 0;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return j * 1000000;
    }
}
