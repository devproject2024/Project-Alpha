package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.f;

final class ab extends f.a<LocationSettingsResult> {

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ LocationSettingsRequest f10375d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f10376e = null;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ab(e eVar, LocationSettingsRequest locationSettingsRequest) {
        super(eVar);
        this.f10375d = locationSettingsRequest;
    }

    public final /* synthetic */ l a(Status status) {
        return new LocationSettingsResult(status);
    }

    public final /* synthetic */ void a(a.b bVar) throws RemoteException {
        t tVar = (t) bVar;
        LocationSettingsRequest locationSettingsRequest = this.f10375d;
        String str = this.f10376e;
        tVar.q();
        s.b(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        s.b(true, "listener can't be null.");
        ((i) tVar.r()).a(locationSettingsRequest, new v(this), str);
    }
}
