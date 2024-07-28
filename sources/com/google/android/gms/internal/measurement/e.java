package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class e extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f10614c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk f10615d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(mk mkVar, String str) {
        super(mkVar);
        this.f10615d = mkVar;
        this.f10614c = str;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10615d.r.beginAdUnitExposure(this.f10614c, this.f10915b);
    }
}
