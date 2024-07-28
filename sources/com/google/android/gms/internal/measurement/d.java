package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class d extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Activity f10543c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f10544d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f10545e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ mk f10546f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(mk mkVar, Activity activity, String str, String str2) {
        super(mkVar);
        this.f10546f = mkVar;
        this.f10543c = activity;
        this.f10544d = str;
        this.f10545e = str2;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10546f.r.setCurrentScreen(com.google.android.gms.b.d.a(this.f10543c), this.f10544d, this.f10545e, this.f10914a);
    }
}
