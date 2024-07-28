package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.mk;

public final class s extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Long f10937c = null;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f10938d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f10939e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ Bundle f10940f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ boolean f10941g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ boolean f10942h;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ mk f10943i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(mk mkVar, String str, String str2, Bundle bundle) {
        super(mkVar);
        this.f10943i = mkVar;
        this.f10938d = str;
        this.f10939e = str2;
        this.f10940f = bundle;
        this.f10941g = true;
        this.f10942h = true;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        Long l = this.f10937c;
        this.f10943i.r.logEvent(this.f10938d, this.f10939e, this.f10940f, this.f10941g, this.f10942h, l == null ? this.f10914a : l.longValue());
    }
}
