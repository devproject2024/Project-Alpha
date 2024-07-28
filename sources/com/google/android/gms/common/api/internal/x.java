package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.f;

final class x implements c<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ f f8635a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ cz f8636b;

    x(cz czVar, f fVar) {
        this.f8636b = czVar;
        this.f8635a = fVar;
    }

    public final void a(Task<TResult> task) {
        this.f8636b.f8567b.remove(this.f8635a);
    }
}
