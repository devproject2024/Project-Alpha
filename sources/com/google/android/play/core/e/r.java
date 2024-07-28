package com.google.android.play.core.e;

import java.util.concurrent.Executor;

final class r implements Executor {
    r() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
