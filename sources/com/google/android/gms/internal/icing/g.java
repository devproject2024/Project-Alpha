package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class g extends a implements d {
    public g() {
        super("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        if (i2 == 1) {
            a((Status) bh.a(parcel, Status.CREATOR));
        } else if (i2 == 2) {
            bh.a(parcel, Status.CREATOR);
            bh.a(parcel, ParcelFileDescriptor.CREATOR);
        } else if (i2 != 4) {
            return false;
        } else {
            bh.a(parcel, zzo.CREATOR);
        }
        return true;
    }
}
