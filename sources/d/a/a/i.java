package d.a.a;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private h f45978a;

    /* renamed from: b  reason: collision with root package name */
    private h f45979b;

    i() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(h hVar) {
        if (hVar != null) {
            try {
                if (this.f45979b != null) {
                    this.f45979b.f45977c = hVar;
                    this.f45979b = hVar;
                } else if (this.f45978a == null) {
                    this.f45979b = hVar;
                    this.f45978a = hVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized h a() {
        h hVar;
        hVar = this.f45978a;
        if (this.f45978a != null) {
            this.f45978a = this.f45978a.f45977c;
            if (this.f45978a == null) {
                this.f45979b = null;
            }
        }
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized h b() throws InterruptedException {
        if (this.f45978a == null) {
            wait(1000);
        }
        return a();
    }
}
