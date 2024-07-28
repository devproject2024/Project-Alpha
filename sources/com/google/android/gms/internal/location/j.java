package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsRequest;

public final class j extends a implements i {
    j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    public final Location a(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        Parcel a3 = a(a2);
        Location location = (Location) ad.a(a3, Location.CREATOR);
        a3.recycle();
        return location;
    }

    public final void a(zzbf zzbf) throws RemoteException {
        Parcel a2 = a();
        ad.a(a2, (Parcelable) zzbf);
        a(59, a2);
    }

    public final void a(zzo zzo) throws RemoteException {
        Parcel a2 = a();
        ad.a(a2, (Parcelable) zzo);
        a(75, a2);
    }

    public final void a(LocationSettingsRequest locationSettingsRequest, k kVar, String str) throws RemoteException {
        Parcel a2 = a();
        ad.a(a2, (Parcelable) locationSettingsRequest);
        ad.a(a2, (IInterface) kVar);
        a2.writeString(str);
        a(63, a2);
    }

    public final void m_() throws RemoteException {
        Parcel a2 = a();
        ad.a(a2);
        a(12, a2);
    }
}
