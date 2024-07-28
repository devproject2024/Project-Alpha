package com.google.android.play.core.splitcompat;

import java.util.concurrent.ThreadFactory;

final class d implements ThreadFactory {
    d() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }
}
