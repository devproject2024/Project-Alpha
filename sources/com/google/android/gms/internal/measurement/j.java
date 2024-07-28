package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

final class j extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ it f10783c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk f10784d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j(mk mkVar, it itVar) {
        super(mkVar);
        this.f10784d = mkVar;
        this.f10783c = itVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10784d.r.generateEventId(this.f10783c);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f10783c.a((Bundle) null);
    }
}
