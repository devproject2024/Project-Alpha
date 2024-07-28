package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class h extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ it f10722c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk f10723d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(mk mkVar, it itVar) {
        super(mkVar);
        this.f10723d = mkVar;
        this.f10722c = itVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10723d.r.getGmpAppId(this.f10722c);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f10722c.a((Bundle) null);
    }
}
