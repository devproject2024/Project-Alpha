package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.b.d;
import com.google.android.gms.internal.measurement.mk;

final class z extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Activity f10957c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk.c f10958d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    z(mk.c cVar, Activity activity) {
        super(mk.this);
        this.f10958d = cVar;
        this.f10957c = activity;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        mk.this.r.onActivityDestroyed(d.a(this.f10957c), this.f10915b);
    }
}
