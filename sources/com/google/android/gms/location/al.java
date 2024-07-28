package com.google.android.gms.location;

import android.os.IInterface;
import android.os.RemoteException;

public interface al extends IInterface {
    void a(LocationAvailability locationAvailability) throws RemoteException;

    void a(LocationResult locationResult) throws RemoteException;
}
