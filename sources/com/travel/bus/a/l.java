package com.travel.bus.a;

public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f21519a;

    public l(g gVar) {
        this.f21519a = gVar;
    }

    public final void run() {
        d dVar;
        g gVar = this.f21519a;
        if (gVar != null && (dVar = gVar.f21515a) != null) {
            dVar.a(this.f21519a.f21516b);
        }
    }
}
