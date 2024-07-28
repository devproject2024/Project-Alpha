package com.google.android.gms.maps.a;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public interface a extends IInterface {
    b a(CameraPosition cameraPosition) throws RemoteException;

    b a(LatLng latLng, float f2) throws RemoteException;
}
