package com.google.android.gms.maps.a;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.h.h;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public interface y extends IInterface {
    a a() throws RemoteException;

    c a(b bVar) throws RemoteException;

    d a(b bVar, GoogleMapOptions googleMapOptions) throws RemoteException;

    g a(b bVar, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    void a(b bVar, int i2) throws RemoteException;

    h b() throws RemoteException;

    f b(b bVar) throws RemoteException;
}
