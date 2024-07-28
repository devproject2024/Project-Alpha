package com.google.android.play.core.e;

final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f37463a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f37464b;

    j(k kVar, e eVar) {
        this.f37464b = kVar;
        this.f37463a = eVar;
    }

    public final void run() {
        synchronized (this.f37464b.f37465a) {
            if (this.f37464b.f37466b != null) {
                this.f37464b.f37466b.onFailure(this.f37463a.d());
            }
        }
    }
}
