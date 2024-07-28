package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class i extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ it f10750c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk f10751d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(mk mkVar, it itVar) {
        super(mkVar);
        this.f10751d = mkVar;
        this.f10750c = itVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10751d.r.getCurrentScreenName(this.f10750c);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f10750c.a((Bundle) null);
    }
}
