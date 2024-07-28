package com.google.android.gms.tasks;

final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Task f12516a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ v f12517b;

    u(v vVar, Task task) {
        this.f12517b = vVar;
        this.f12516a = task;
    }

    public final void run() {
        synchronized (this.f12517b.f12518a) {
            if (this.f12517b.f12519b != null) {
                this.f12517b.f12519b.onSuccess(this.f12516a.d());
            }
        }
    }
}
