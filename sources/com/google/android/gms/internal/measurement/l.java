package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class l extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ it f10858c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk f10859d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(mk mkVar, it itVar) {
        super(mkVar);
        this.f10859d = mkVar;
        this.f10858c = itVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10859d.r.getCurrentScreenClass(this.f10858c);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f10858c.a((Bundle) null);
    }
}
