package com.google.android.gms.tasks;

final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Task f12514a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ s f12515b;

    t(s sVar, Task task) {
        this.f12515b = sVar;
        this.f12514a = task;
    }

    public final void run() {
        synchronized (this.f12515b.f12511a) {
            if (this.f12515b.f12512b != null) {
                this.f12515b.f12512b.onFailure(this.f12514a.e());
            }
        }
    }
}
