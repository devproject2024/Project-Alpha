package com.google.firebase.installations;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f38977a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38978b;

    private f(c cVar, boolean z) {
        this.f38977a = cVar;
        this.f38978b = z;
    }

    public static Runnable a(c cVar, boolean z) {
        return new f(cVar, z);
    }

    public final void run() {
        c.a(this.f38977a, this.f38978b);
    }
}
