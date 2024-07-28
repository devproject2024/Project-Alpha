package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class h extends a implements f {
    h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    public final void a(zzad zzad) throws RemoteException {
        Parcel a2 = a();
        ad.a(a2, (Parcelable) zzad);
        b(1, a2);
    }
}
