package com.google.android.gms.internal.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class l extends g implements j {
    l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    public final void a(k kVar) throws RemoteException {
        Parcel a2 = a();
        i.a(a2, (IInterface) kVar);
        a(1, a2);
    }

    public final void a(String str, k kVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        i.a(a2, (IInterface) kVar);
        a(2, a2);
    }
}
