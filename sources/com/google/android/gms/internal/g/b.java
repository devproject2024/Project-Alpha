package com.google.android.gms.internal.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class b extends Binder implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private static d f10038a;

    protected b(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean dispatchTransaction$3d31fa39(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        return false;
    }

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
        return dispatchTransaction$3d31fa39(i2, parcel, parcel2);
    }
}
