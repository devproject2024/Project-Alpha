package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class g extends u implements f {
    public g() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        a((zzad) ad.a(parcel, zzad.CREATOR));
        return true;
    }
}
