package com.google.android.gms.tasks;

final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ m f12505a;

    o(m mVar) {
        this.f12505a = mVar;
    }

    public final void run() {
        synchronized (this.f12505a.f12500a) {
            if (this.f12505a.f12501b != null) {
                this.f12505a.f12501b.a();
            }
        }
    }
}
