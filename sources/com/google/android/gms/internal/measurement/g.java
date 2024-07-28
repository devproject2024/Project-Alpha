package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class g extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ it f10675c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk f10676d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(mk mkVar, it itVar) {
        super(mkVar);
        this.f10676d = mkVar;
        this.f10675c = itVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10676d.r.getCachedAppInstanceId(this.f10675c);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f10675c.a((Bundle) null);
    }
}
