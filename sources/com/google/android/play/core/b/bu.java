package com.google.android.play.core.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class bu extends br implements bw {
    bu(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    public final void a(String str, Bundle bundle, by byVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (IInterface) byVar);
        a(2, a2);
    }

    public final void b(String str, Bundle bundle, by byVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        bt.a(a2, (Parcelable) bundle);
        bt.a(a2, (IInterface) byVar);
        a(3, a2);
    }
}
