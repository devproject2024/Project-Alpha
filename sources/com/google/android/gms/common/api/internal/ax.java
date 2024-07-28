package com.google.android.gms.common.api.internal;

abstract class ax {

    /* renamed from: a  reason: collision with root package name */
    private final av f8440a;

    protected ax(av avVar) {
        this.f8440a = avVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void a(ay ayVar) {
        ayVar.f8441a.lock();
        try {
            if (ayVar.k == this.f8440a) {
                a();
                ayVar.f8441a.unlock();
            }
        } finally {
            ayVar.f8441a.unlock();
        }
    }
}
