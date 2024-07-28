package com.google.android.gms.internal.a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class g extends a implements e {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String a() throws RemoteException {
        Parcel a2 = a(1, l_());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    public final boolean b() throws RemoteException {
        Parcel l_ = l_();
        c.b(l_);
        Parcel a2 = a(2, l_);
        boolean a3 = c.a(a2);
        a2.recycle();
        return a3;
    }
}
