package com.google.android.play.core.e;

final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f37468a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m f37469b;

    l(m mVar, e eVar) {
        this.f37469b = mVar;
        this.f37468a = eVar;
    }

    public final void run() {
        synchronized (this.f37469b.f37470a) {
            if (this.f37469b.f37471b != null) {
                this.f37469b.f37471b.onSuccess(this.f37468a.c());
            }
        }
    }
}
