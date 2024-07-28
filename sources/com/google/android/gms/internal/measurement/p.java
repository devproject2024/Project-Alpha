package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class p extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ boolean f10929c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk f10930d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(mk mkVar, boolean z) {
        super(mkVar);
        this.f10930d = mkVar;
        this.f10929c = z;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10930d.r.setDataCollectionEnabled(this.f10929c);
    }
}
