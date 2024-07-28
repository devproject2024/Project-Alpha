package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class md extends a implements lw {
    md(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    public final void a(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) bundle);
        b(1, a2);
    }
}
