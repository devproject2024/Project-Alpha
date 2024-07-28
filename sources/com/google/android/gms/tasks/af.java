package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ab f12476a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Callable f12477b;

    af(ab abVar, Callable callable) {
        this.f12476a = abVar;
        this.f12477b = callable;
    }

    public final void run() {
        try {
            this.f12476a.a(this.f12477b.call());
        } catch (Exception e2) {
            this.f12476a.a(e2);
        }
    }
}
