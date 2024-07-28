package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

public abstract class l extends u implements k {
    public l() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        a((LocationSettingsResult) ad.a(parcel, LocationSettingsResult.CREATOR));
        return true;
    }
}
