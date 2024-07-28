package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.ad;
import com.google.android.gms.internal.location.u;

public abstract class am extends u implements al {
    public am() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static al a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof al ? (al) queryLocalInterface : new an(iBinder);
    }

    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        if (i2 == 1) {
            a((LocationResult) ad.a(parcel, LocationResult.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            a((LocationAvailability) ad.a(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
