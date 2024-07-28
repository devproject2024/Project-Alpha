package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.b.d;
import com.google.android.gms.internal.measurement.mk;

final class m extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f10898c = 5;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f10899d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Object f10900e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ Object f10901f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ Object f10902g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ mk f10903h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(mk mkVar, String str, Object obj) {
        super(false);
        this.f10903h = mkVar;
        this.f10899d = str;
        this.f10900e = obj;
        this.f10901f = null;
        this.f10902g = null;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10903h.r.logHealthData(this.f10898c, this.f10899d, d.a(this.f10900e), d.a(this.f10901f), d.a(this.f10902g));
    }
}
