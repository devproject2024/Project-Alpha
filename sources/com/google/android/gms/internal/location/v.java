package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.location.LocationSettingsResult;

final class v extends l {

    /* renamed from: a  reason: collision with root package name */
    private d.b<LocationSettingsResult> f10398a;

    public v(d.b<LocationSettingsResult> bVar) {
        s.b(true, "listener can't be null.");
        this.f10398a = bVar;
    }

    public final void a(LocationSettingsResult locationSettingsResult) throws RemoteException {
        this.f10398a.a(locationSettingsResult);
        this.f10398a = null;
    }
}
