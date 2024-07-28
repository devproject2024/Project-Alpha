package com.google.android.play.core.e;

final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f37458a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i f37459b;

    h(i iVar, e eVar) {
        this.f37459b = iVar;
        this.f37458a = eVar;
    }

    public final void run() {
        synchronized (this.f37459b.f37460a) {
            if (this.f37459b.f37461b != null) {
                this.f37459b.f37461b.onComplete(this.f37458a);
            }
        }
    }
}
