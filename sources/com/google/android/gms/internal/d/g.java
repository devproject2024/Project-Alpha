package com.google.android.gms.internal.d;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class g implements f {
    private g() {
    }

    public final ScheduledExecutorService a() {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }

    /* synthetic */ g(byte b2) {
        this();
    }
}
