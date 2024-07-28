package com.google.android.gms.internal.firebase_ml;

import java.util.concurrent.Executor;

enum dn implements Executor {
    INSTANCE;

    public final void execute(Runnable runnable) {
        dl.b().f9806c.post(runnable);
    }
}
