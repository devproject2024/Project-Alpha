package com.google.android.gms.tasks;

final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Task f12503a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ k f12504b;

    n(k kVar, Task task) {
        this.f12504b = kVar;
        this.f12503a = task;
    }

    public final void run() {
        try {
            Task task = (Task) this.f12504b.f12496b.a(this.f12503a);
            if (task == null) {
                this.f12504b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            task.a(g.f12480b, this.f12504b);
            task.a(g.f12480b, (OnFailureListener) this.f12504b);
            task.a(g.f12480b, (b) this.f12504b);
        } catch (d e2) {
            if (e2.getCause() instanceof Exception) {
                this.f12504b.f12497c.a((Exception) e2.getCause());
            } else {
                this.f12504b.f12497c.a((Exception) e2);
            }
        } catch (Exception e3) {
            this.f12504b.f12497c.a(e3);
        }
    }
}
