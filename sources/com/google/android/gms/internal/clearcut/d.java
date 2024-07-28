package com.google.android.gms.internal.clearcut;

import android.database.ContentObserver;
import android.os.Handler;

final class d extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ c f9265a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    d(c cVar) {
        super((Handler) null);
        this.f9265a = cVar;
    }

    public final void onChange(boolean z) {
        c cVar = this.f9265a;
        synchronized (cVar.f9227a) {
            cVar.f9228b = null;
        }
        c.a(this.f9265a);
    }
}
