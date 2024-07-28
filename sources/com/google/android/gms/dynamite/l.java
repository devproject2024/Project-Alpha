package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.d.b;
import com.google.android.gms.internal.d.d;

public final class l extends b implements m {
    l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final com.google.android.gms.b.b a(com.google.android.gms.b.b bVar, String str, int i2, com.google.android.gms.b.b bVar2) throws RemoteException {
        Parcel c2 = c();
        d.a(c2, (IInterface) bVar);
        c2.writeString(str);
        c2.writeInt(i2);
        d.a(c2, (IInterface) bVar2);
        Parcel a2 = a(2, c2);
        com.google.android.gms.b.b a3 = b.a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final com.google.android.gms.b.b b(com.google.android.gms.b.b bVar, String str, int i2, com.google.android.gms.b.b bVar2) throws RemoteException {
        Parcel c2 = c();
        d.a(c2, (IInterface) bVar);
        c2.writeString(str);
        c2.writeInt(i2);
        d.a(c2, (IInterface) bVar2);
        Parcel a2 = a(3, c2);
        com.google.android.gms.b.b a3 = b.a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
