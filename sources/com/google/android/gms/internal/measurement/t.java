package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class t extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Bundle f10944c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk f10945d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(mk mkVar, Bundle bundle) {
        super(mkVar);
        this.f10945d = mkVar;
        this.f10944c = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10945d.r.setConditionalUserProperty(this.f10944c, this.f10914a);
    }
}
