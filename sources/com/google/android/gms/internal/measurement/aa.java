package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.b.d;
import com.google.android.gms.internal.measurement.mk;

final class aa extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Activity f10436c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ it f10437d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ mk.c f10438e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aa(mk.c cVar, Activity activity, it itVar) {
        super(mk.this);
        this.f10438e = cVar;
        this.f10436c = activity;
        this.f10437d = itVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        mk.this.r.onActivitySaveInstanceState(d.a(this.f10436c), this.f10437d, this.f10915b);
    }
}
