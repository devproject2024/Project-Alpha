package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.ad;
import com.google.android.gms.internal.location.u;

public abstract class ap extends u implements ao {
    public ap() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static ao a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof ao ? (ao) queryLocalInterface : new aq(iBinder);
    }

    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        a((Location) ad.a(parcel, Location.CREATOR));
        return true;
    }
}
