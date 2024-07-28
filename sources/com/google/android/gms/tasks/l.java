package com.google.android.gms.tasks;

final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Task f12498a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ j f12499b;

    l(j jVar, Task task) {
        this.f12499b = jVar;
        this.f12498a = task;
    }

    public final void run() {
        if (this.f12498a.c()) {
            this.f12499b.f12493b.f();
            return;
        }
        try {
            this.f12499b.f12493b.a(this.f12499b.f12492a.a(this.f12498a));
        } catch (d e2) {
            if (e2.getCause() instanceof Exception) {
                this.f12499b.f12493b.a((Exception) e2.getCause());
            } else {
                this.f12499b.f12493b.a((Exception) e2);
            }
        } catch (Exception e3) {
            this.f12499b.f12493b.a(e3);
        }
    }
}
