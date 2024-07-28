package androidx.work.impl.utils.a;

import java.util.concurrent.Executor;

enum b implements Executor {
    INSTANCE;

    public final String toString() {
        return "DirectExecutor";
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
