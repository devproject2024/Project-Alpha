package d.a.a;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final i f45915a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final c f45916b;

    a(c cVar) {
        this.f45916b = cVar;
    }

    public final void a(m mVar, Object obj) {
        this.f45915a.a(h.a(mVar, obj));
        this.f45916b.f45946c.execute(this);
    }

    public final void run() {
        h a2 = this.f45915a.a();
        if (a2 != null) {
            this.f45916b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
