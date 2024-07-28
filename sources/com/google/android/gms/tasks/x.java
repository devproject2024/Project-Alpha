package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Task f12524a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ w f12525b;

    x(w wVar, Task task) {
        this.f12525b = wVar;
        this.f12524a = task;
    }

    public final void run() {
        try {
            Task a2 = this.f12525b.f12522b.a(this.f12524a.d());
            if (a2 == null) {
                this.f12525b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            a2.a(g.f12480b, this.f12525b);
            a2.a(g.f12480b, (OnFailureListener) this.f12525b);
            a2.a(g.f12480b, (b) this.f12525b);
        } catch (d e2) {
            if (e2.getCause() instanceof Exception) {
                this.f12525b.onFailure((Exception) e2.getCause());
            } else {
                this.f12525b.onFailure(e2);
            }
        } catch (CancellationException unused) {
            this.f12525b.a();
        } catch (Exception e3) {
            this.f12525b.onFailure(e3);
        }
    }
}
