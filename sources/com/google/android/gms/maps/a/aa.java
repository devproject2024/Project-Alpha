package com.google.android.gms.maps.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.h.a;
import com.google.android.gms.internal.h.f;
import com.google.android.gms.internal.h.k;
import com.google.android.gms.internal.h.l;
import com.google.android.gms.maps.model.MarkerOptions;

public final class aa extends a implements b {
    aa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    public final void a(b bVar) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (IInterface) bVar);
        b(4, n_);
    }

    public final void b(b bVar) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (IInterface) bVar);
        b(5, n_);
    }

    public final void a(b bVar, w wVar) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (IInterface) bVar);
        n_.writeInt(500);
        f.a(n_, (IInterface) wVar);
        b(7, n_);
    }

    public final k a(MarkerOptions markerOptions) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (Parcelable) markerOptions);
        Parcel a2 = a(11, n_);
        k a3 = l.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final void a(m mVar) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (IInterface) mVar);
        b(30, n_);
    }

    public final void a() throws RemoteException {
        Parcel n_ = n_();
        n_.writeFloat(6.0f);
        b(92, n_);
    }

    public final void b() throws RemoteException {
        Parcel n_ = n_();
        n_.writeFloat(18.0f);
        b(93, n_);
    }
}
