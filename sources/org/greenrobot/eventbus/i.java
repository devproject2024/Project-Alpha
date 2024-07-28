package org.greenrobot.eventbus;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private h f72884a;

    /* renamed from: b  reason: collision with root package name */
    private h f72885b;

    i() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(h hVar) {
        if (hVar != null) {
            try {
                if (this.f72885b != null) {
                    this.f72885b.f72883c = hVar;
                    this.f72885b = hVar;
                } else if (this.f72884a == null) {
                    this.f72885b = hVar;
                    this.f72884a = hVar;
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
        hVar = this.f72884a;
        if (this.f72884a != null) {
            this.f72884a = this.f72884a.f72883c;
            if (this.f72884a == null) {
                this.f72885b = null;
            }
        }
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized h b() throws InterruptedException {
        if (this.f72884a == null) {
            wait(1000);
        }
        return a();
    }
}
