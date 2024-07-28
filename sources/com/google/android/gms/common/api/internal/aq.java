package com.google.android.gms.common.api.internal;

abstract class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ag f8427a;

    private aq(ag agVar) {
        this.f8427a = agVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public void run() {
        this.f8427a.f8404b.lock();
        try {
            if (!Thread.interrupted()) {
                a();
                this.f8427a.f8404b.unlock();
            }
        } catch (RuntimeException e2) {
            ay ayVar = this.f8427a.f8403a;
            ayVar.f8445e.sendMessage(ayVar.f8445e.obtainMessage(2, e2));
        } finally {
            this.f8427a.f8404b.unlock();
        }
    }

    /* synthetic */ aq(ag agVar, byte b2) {
        this(agVar);
    }
}
