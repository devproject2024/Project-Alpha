package com.google.android.a;

import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class b extends Binder implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private static d f7624a;

    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        boolean z;
        if (i2 > 16777215) {
            z = super.onTransact(i2, parcel, parcel2, i3);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z = false;
        }
        if (z) {
            return true;
        }
        d dVar = f7624a;
        if (dVar == null) {
            return false;
        }
        return dVar.a();
    }
}
