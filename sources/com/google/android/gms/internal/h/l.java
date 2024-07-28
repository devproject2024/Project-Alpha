package com.google.android.gms.internal.h;

import android.os.IBinder;
import android.os.IInterface;

public abstract class l extends e implements k {
    public static k a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (queryLocalInterface instanceof k) {
            return (k) queryLocalInterface;
        }
        return new m(iBinder);
    }
}
