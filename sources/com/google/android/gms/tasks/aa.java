package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class aa implements Executor {
    aa() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
