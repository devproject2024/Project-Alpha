package i;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class j extends w {

    /* renamed from: a  reason: collision with root package name */
    public w f46290a;

    public j(w wVar) {
        if (wVar != null) {
            this.f46290a = wVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final j a(w wVar) {
        if (wVar != null) {
            this.f46290a = wVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final w timeout(long j, TimeUnit timeUnit) {
        return this.f46290a.timeout(j, timeUnit);
    }

    public final long timeoutNanos() {
        return this.f46290a.timeoutNanos();
    }

    public final boolean hasDeadline() {
        return this.f46290a.hasDeadline();
    }

    public final long deadlineNanoTime() {
        return this.f46290a.deadlineNanoTime();
    }

    public final w deadlineNanoTime(long j) {
        return this.f46290a.deadlineNanoTime(j);
    }

    public final w clearTimeout() {
        return this.f46290a.clearTimeout();
    }

    public final w clearDeadline() {
        return this.f46290a.clearDeadline();
    }

    public final void throwIfReached() throws IOException {
        this.f46290a.throwIfReached();
    }
}
