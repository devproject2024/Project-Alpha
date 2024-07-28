package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class mf extends as implements mg {
    public mf() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 == 1) {
            a(parcel.readString(), parcel.readString(), (Bundle) r.a(parcel, Bundle.CREATOR), parcel.readLong());
            parcel2.writeNoException();
        } else if (i2 != 2) {
            return false;
        } else {
            int s_ = s_();
            parcel2.writeNoException();
            parcel2.writeInt(s_);
        }
        return true;
    }
}
