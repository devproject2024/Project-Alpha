package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.u;

public class aj extends u implements ai {
    public static ai a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return queryLocalInterface instanceof ai ? (ai) queryLocalInterface : new ak(iBinder);
    }

    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        throw new NoSuchMethodError();
    }
}
