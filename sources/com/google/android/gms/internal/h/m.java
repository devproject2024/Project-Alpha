package com.google.android.gms.internal.h;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.maps.model.LatLng;

public final class m extends a implements k {
    m(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    public final LatLng a() throws RemoteException {
        Parcel a2 = a(4, n_());
        LatLng latLng = (LatLng) f.a(a2, LatLng.CREATOR);
        a2.recycle();
        return latLng;
    }

    public final void b() throws RemoteException {
        b(11, n_());
    }

    public final void c() throws RemoteException {
        b(12, n_());
    }

    public final boolean a(k kVar) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (IInterface) kVar);
        Parcel a2 = a(16, n_);
        boolean a3 = f.a(a2);
        a2.recycle();
        return a3;
    }

    public final int d() throws RemoteException {
        Parcel a2 = a(17, n_());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    public final void a(b bVar) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (IInterface) bVar);
        b(18, n_);
    }

    public final void a(float f2) throws RemoteException {
        Parcel n_ = n_();
        n_.writeFloat(f2);
        b(27, n_);
    }

    public final void b(b bVar) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (IInterface) bVar);
        b(29, n_);
    }

    public final b e() throws RemoteException {
        Parcel a2 = a(30, n_());
        b a3 = b.a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
