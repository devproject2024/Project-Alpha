package com.google.android.gms.tasks;

final class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Task f12506a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ q f12507b;

    p(q qVar, Task task) {
        this.f12507b = qVar;
        this.f12506a = task;
    }

    public final void run() {
        synchronized (this.f12507b.f12508a) {
            if (this.f12507b.f12509b != null) {
                this.f12507b.f12509b.a(this.f12506a);
            }
        }
    }
}
