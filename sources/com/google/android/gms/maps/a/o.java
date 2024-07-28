package com.google.android.gms.maps.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.h.a;
import com.google.android.gms.internal.h.f;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public final class o extends a implements a {
    o(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    public final b a(CameraPosition cameraPosition) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (Parcelable) cameraPosition);
        Parcel a2 = a(7, n_);
        b a3 = b.a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final b a(LatLng latLng, float f2) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (Parcelable) latLng);
        n_.writeFloat(f2);
        Parcel a2 = a(9, n_);
        b a3 = b.a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
