package com.google.android.gms.maps.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.h.a;
import com.google.android.gms.internal.h.f;

public final class ac extends a implements d {
    ac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapViewDelegate");
    }

    public final void a(Bundle bundle) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (Parcelable) bundle);
        b(2, n_);
    }

    public final void a() throws RemoteException {
        b(3, n_());
    }

    public final void b() throws RemoteException {
        b(4, n_());
    }

    public final void c() throws RemoteException {
        b(5, n_());
    }

    public final void d() throws RemoteException {
        b(6, n_());
    }

    public final void b(Bundle bundle) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (Parcelable) bundle);
        Parcel a2 = a(7, n_);
        if (a2.readInt() != 0) {
            bundle.readFromParcel(a2);
        }
        a2.recycle();
    }

    public final b e() throws RemoteException {
        Parcel a2 = a(8, n_());
        b a3 = b.a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final void a(k kVar) throws RemoteException {
        Parcel n_ = n_();
        f.a(n_, (IInterface) kVar);
        b(9, n_);
    }

    public final void f() throws RemoteException {
        b(12, n_());
    }

    public final void g() throws RemoteException {
        b(13, n_());
    }
}
