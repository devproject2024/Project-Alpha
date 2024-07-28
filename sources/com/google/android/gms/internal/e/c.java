package com.google.android.gms.internal.e;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

final class c implements b {
    private c() {
    }

    public final ScheduledExecutorService a(ThreadFactory threadFactory) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, threadFactory));
    }

    /* synthetic */ c(byte b2) {
        this();
    }
}
