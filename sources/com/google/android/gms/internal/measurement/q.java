package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.b.d;
import com.google.android.gms.internal.measurement.mk;

public final class q extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f10931c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f10932d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Object f10933e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ boolean f10934f = true;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ mk f10935g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(mk mkVar, String str, String str2, Object obj) {
        super(mkVar);
        this.f10935g = mkVar;
        this.f10931c = str;
        this.f10932d = str2;
        this.f10933e = obj;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10935g.r.setUserProperty(this.f10931c, this.f10932d, d.a(this.f10933e), this.f10934f, this.f10914a);
    }
}
