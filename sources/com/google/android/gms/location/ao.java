package com.google.android.gms.location;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;

public interface ao extends IInterface {
    void a(Location location) throws RemoteException;
}
