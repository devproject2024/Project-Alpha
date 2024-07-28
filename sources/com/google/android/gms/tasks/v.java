package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class v<TResult> implements y<TResult> {

    /* renamed from: a  reason: collision with root package name */
    final Object f12518a = new Object();

    /* renamed from: b  reason: collision with root package name */
    OnSuccessListener<? super TResult> f12519b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12520c;

    public v(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f12520c = executor;
        this.f12519b = onSuccessListener;
    }

    public final void a(Task<TResult> task) {
        if (task.b()) {
            synchronized (this.f12518a) {
                if (this.f12519b != null) {
                    this.f12520c.execute(new u(this, task));
                }
            }
        }
    }

    public final void P_() {
        synchronized (this.f12518a) {
            this.f12519b = null;
        }
    }
}
