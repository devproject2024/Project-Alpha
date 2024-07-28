package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class k extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f10815c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f10816d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f10817e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ it f10818f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ mk f10819g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(mk mkVar, String str, String str2, boolean z, it itVar) {
        super(mkVar);
        this.f10819g = mkVar;
        this.f10815c = str;
        this.f10816d = str2;
        this.f10817e = z;
        this.f10818f = itVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        this.f10819g.r.getUserProperties(this.f10815c, this.f10816d, this.f10817e, this.f10818f);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f10818f.a((Bundle) null);
    }
}
