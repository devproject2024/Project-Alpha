package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.location.a;
import com.google.android.gms.internal.location.ad;

public final class an extends a implements al {
    an(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    public final void a(LocationAvailability locationAvailability) throws RemoteException {
        Parcel a2 = a();
        ad.a(a2, (Parcelable) locationAvailability);
        b(2, a2);
    }

    public final void a(LocationResult locationResult) throws RemoteException {
        Parcel a2 = a();
        ad.a(a2, (Parcelable) locationResult);
        b(1, a2);
    }
}
