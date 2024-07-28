package com.google.firebase.crashlytics.a.c;

import android.os.Process;

public abstract class d implements Runnable {
    /* access modifiers changed from: protected */
    public abstract void a();

    public final void run() {
        Process.setThreadPriority(10);
        a();
    }
}
