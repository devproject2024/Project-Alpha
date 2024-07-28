package com.google.firebase.installations;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f38975a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38976b = false;

    private e(c cVar) {
        this.f38975a = cVar;
    }

    public static Runnable a(c cVar) {
        return new e(cVar);
    }

    public final void run() {
        this.f38975a.a(this.f38976b);
    }
}
