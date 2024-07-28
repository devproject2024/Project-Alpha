package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class f extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f10638c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk f10639d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(mk mkVar, String str) {
        super(mkVar);
        this.f10639d = mkVar;
        this.f10638c = str;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10639d.r.endAdUnitExposure(this.f10638c, this.f10915b);
    }
}
