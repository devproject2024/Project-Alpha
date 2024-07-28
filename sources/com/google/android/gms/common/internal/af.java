package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.f;
import java.util.concurrent.TimeUnit;

final class af implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ g f8764a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ f f8765b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ r.a f8766c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ r.b f8767d;

    af(g gVar, f fVar, r.a aVar, r.b bVar) {
        this.f8764a = gVar;
        this.f8765b = fVar;
        this.f8766c = aVar;
        this.f8767d = bVar;
    }

    public final void a(Status status) {
        if (status.c()) {
            this.f8765b.a(this.f8766c.a(this.f8764a.a(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.f8765b.a((Exception) this.f8767d.a(status));
    }
}
