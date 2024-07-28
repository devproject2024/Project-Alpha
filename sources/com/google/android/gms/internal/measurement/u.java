package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.b.d;
import com.google.android.gms.internal.measurement.mk;

final class u extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Activity f10946c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Bundle f10947d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ mk.c f10948e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    u(mk.c cVar, Activity activity, Bundle bundle) {
        super(mk.this);
        this.f10948e = cVar;
        this.f10946c = activity;
        this.f10947d = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        mk.this.r.onActivityCreated(d.a(this.f10946c), this.f10947d, this.f10915b);
    }
}
