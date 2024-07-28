package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.location.a;
import com.google.android.gms.internal.location.ad;

public final class aq extends a implements ao {
    aq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    public final void a(Location location) throws RemoteException {
        Parcel a2 = a();
        ad.a(a2, (Parcelable) location);
        b(1, a2);
    }
}
