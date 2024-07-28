package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class dr extends a implements bs {
    dr(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle a(Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) bundle);
        Parcel a3 = a(1, a2);
        Bundle bundle2 = (Bundle) r.a(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }
}
