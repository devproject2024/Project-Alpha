package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.d.b;

public final class at extends b implements as {
    at(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final com.google.android.gms.b.b a() throws RemoteException {
        Parcel a2 = a(1, c());
        com.google.android.gms.b.b a3 = b.a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final int b() throws RemoteException {
        Parcel a2 = a(2, c());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
