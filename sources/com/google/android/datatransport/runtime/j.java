package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;

final class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7789a;

    j(Executor executor) {
        this.f7789a = executor;
    }

    public final void execute(Runnable runnable) {
        this.f7789a.execute(new a(runnable));
    }

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f7790a;

        a(Runnable runnable) {
            this.f7790a = runnable;
        }

        public final void run() {
            try {
                this.f7790a.run();
            } catch (Exception unused) {
                com.google.android.datatransport.runtime.a.a.a("Executor");
            }
        }
    }
}
