package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsRequest;

public interface i extends IInterface {
    Location a(String str) throws RemoteException;

    void a(zzbf zzbf) throws RemoteException;

    void a(zzo zzo) throws RemoteException;

    void a(LocationSettingsRequest locationSettingsRequest, k kVar, String str) throws RemoteException;

    void m_() throws RemoteException;
}
