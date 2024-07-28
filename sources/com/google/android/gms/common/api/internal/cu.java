package com.google.android.gms.common.api.internal;

final class cu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ cr f8550a;

    cu(cr crVar) {
        this.f8550a = crVar;
    }

    public final void run() {
        this.f8550a.f8546g.lock();
        try {
            cr.a(this.f8550a);
        } finally {
            this.f8550a.f8546g.unlock();
        }
    }
}
