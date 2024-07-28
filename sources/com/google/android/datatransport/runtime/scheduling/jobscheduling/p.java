package com.google.android.datatransport.runtime.scheduling.jobscheduling;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final o f7950a;

    private p(o oVar) {
        this.f7950a = oVar;
    }

    public static Runnable a(o oVar) {
        return new p(oVar);
    }

    public final void run() {
        o oVar = this.f7950a;
        oVar.f7949d.a(new q(oVar));
    }
}
