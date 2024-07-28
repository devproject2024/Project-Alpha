package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class n extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f10924c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ it f10925d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ mk f10926e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(mk mkVar, String str, it itVar) {
        super(mkVar);
        this.f10926e = mkVar;
        this.f10924c = str;
        this.f10925d = itVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10926e.r.getMaxUserProperties(this.f10924c, this.f10925d);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f10925d.a((Bundle) null);
    }
}
