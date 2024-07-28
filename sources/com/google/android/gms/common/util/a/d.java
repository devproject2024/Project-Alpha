package com.google.android.gms.common.util.a;

import android.os.Process;

final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f8968a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8969b = 0;

    public d(Runnable runnable) {
        this.f8968a = runnable;
    }

    public final void run() {
        Process.setThreadPriority(this.f8969b);
        this.f8968a.run();
    }
}
