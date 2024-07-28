package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class q<TResult> implements y<TResult> {

    /* renamed from: a  reason: collision with root package name */
    final Object f12508a = new Object();

    /* renamed from: b  reason: collision with root package name */
    c<TResult> f12509b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12510c;

    public q(Executor executor, c<TResult> cVar) {
        this.f12510c = executor;
        this.f12509b = cVar;
    }

    public final void a(Task<TResult> task) {
        synchronized (this.f12508a) {
            if (this.f12509b != null) {
                this.f12510c.execute(new p(this, task));
            }
        }
    }

    public final void P_() {
        synchronized (this.f12508a) {
            this.f12509b = null;
        }
    }
}
