package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class s<TResult> implements y<TResult> {

    /* renamed from: a  reason: collision with root package name */
    final Object f12511a = new Object();

    /* renamed from: b  reason: collision with root package name */
    OnFailureListener f12512b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12513c;

    public s(Executor executor, OnFailureListener onFailureListener) {
        this.f12513c = executor;
        this.f12512b = onFailureListener;
    }

    public final void a(Task<TResult> task) {
        if (!task.b() && !task.c()) {
            synchronized (this.f12511a) {
                if (this.f12512b != null) {
                    this.f12513c.execute(new t(this, task));
                }
            }
        }
    }

    public final void P_() {
        synchronized (this.f12511a) {
            this.f12512b = null;
        }
    }
}
