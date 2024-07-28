package com.google.android.gms.internal.h;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public abstract class c extends e implements b {
    public static b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        if (queryLocalInterface instanceof b) {
            return (b) queryLocalInterface;
        }
        return new d(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        Tile a2 = a(parcel.readInt(), parcel.readInt(), parcel.readInt());
        parcel2.writeNoException();
        f.b(parcel2, a2);
        return true;
    }
}
