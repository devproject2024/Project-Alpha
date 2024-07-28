package com.travel.bus.a;

public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final e f21517a;

    public h(e eVar) {
        this.f21517a = eVar;
    }

    public final void run() {
        d dVar;
        e eVar = this.f21517a;
        if (eVar != null && (dVar = eVar.f21515a) != null) {
            dVar.a();
        }
    }
}
