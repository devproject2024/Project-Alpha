package com.google.firebase.installations;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f38974a;

    private d(c cVar) {
        this.f38974a = cVar;
    }

    public static Runnable a(c cVar) {
        return new d(cVar);
    }

    public final void run() {
        this.f38974a.a(false);
    }
}
