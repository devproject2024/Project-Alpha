package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class mm extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f10920c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f10921d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Bundle f10922e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ mk f10923f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public mm(mk mkVar, String str, String str2, Bundle bundle) {
        super(mkVar);
        this.f10923f = mkVar;
        this.f10920c = str;
        this.f10921d = str2;
        this.f10922e = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10923f.r.clearConditionalUserProperty(this.f10920c, this.f10921d, this.f10922e);
    }
}
