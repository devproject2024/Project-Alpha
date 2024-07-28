package org.greenrobot.eventbus;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final i f72821a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final c f72822b;

    a(c cVar) {
        this.f72822b = cVar;
    }

    public final void a(n nVar, Object obj) {
        this.f72821a.a(h.a(nVar, obj));
        this.f72822b.f72852c.execute(this);
    }

    public final void run() {
        h a2 = this.f72821a.a();
        if (a2 != null) {
            this.f72822b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
