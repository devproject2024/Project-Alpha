package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class me extends as implements lw {
    public me() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        a((Bundle) r.a(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
