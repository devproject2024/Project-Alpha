package com.google.android.gms.internal.h;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public final class d extends a implements b {
    d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public final Tile a(int i2, int i3, int i4) throws RemoteException {
        Parcel n_ = n_();
        n_.writeInt(i2);
        n_.writeInt(i3);
        n_.writeInt(i4);
        Parcel a2 = a(1, n_);
        Tile tile = (Tile) f.a(a2, Tile.CREATOR);
        a2.recycle();
        return tile;
    }
}
