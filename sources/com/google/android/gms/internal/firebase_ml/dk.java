package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.tasks.f;
import java.util.concurrent.Callable;

final /* synthetic */ class dk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Callable f9802a;

    /* renamed from: b  reason: collision with root package name */
    private final f f9803b;

    dk(Callable callable, f fVar) {
        this.f9802a = callable;
        this.f9803b = fVar;
    }

    public final void run() {
        dl.a(this.f9802a, this.f9803b);
    }
}
