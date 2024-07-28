package com.google.android.gms.internal.h;

import android.os.IBinder;
import android.os.IInterface;

public abstract class i extends e implements h {
    public static h a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        if (queryLocalInterface instanceof h) {
            return (h) queryLocalInterface;
        }
        return new j(iBinder);
    }
}
