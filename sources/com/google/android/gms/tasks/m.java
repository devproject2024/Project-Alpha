package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class m<TResult> implements y<TResult> {

    /* renamed from: a  reason: collision with root package name */
    final Object f12500a = new Object();

    /* renamed from: b  reason: collision with root package name */
    b f12501b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12502c;

    public m(Executor executor, b bVar) {
        this.f12502c = executor;
        this.f12501b = bVar;
    }

    public final void a(Task<TResult> task) {
        if (task.c()) {
            synchronized (this.f12500a) {
                if (this.f12501b != null) {
                    this.f12502c.execute(new o(this));
                }
            }
        }
    }

    public final void P_() {
        synchronized (this.f12500a) {
            this.f12501b = null;
        }
    }
}
