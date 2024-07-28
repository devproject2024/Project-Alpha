package com.google.android.gms.maps.a;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.h.e;

public abstract class x extends e implements w {
    public x() {
        super("com.google.android.gms.maps.internal.ICancelableCallback");
    }

    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 != 1 && i2 != 2) {
            return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
