package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class c extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f10514c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f10515d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ it f10516e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ mk f10517f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(mk mkVar, String str, String str2, it itVar) {
        super(mkVar);
        this.f10517f = mkVar;
        this.f10514c = str;
        this.f10515d = str2;
        this.f10516e = itVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10517f.r.getConditionalUserProperties(this.f10514c, this.f10515d, this.f10516e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f10516e.a((Bundle) null);
    }
}
