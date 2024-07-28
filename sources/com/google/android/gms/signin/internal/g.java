package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.internal.base.b;
import com.google.android.gms.internal.base.d;

public final class g extends b implements e {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void a(int i2) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i2);
        a(7, a2);
    }

    public final void a(l lVar, int i2, boolean z) throws RemoteException {
        Parcel a2 = a();
        d.a(a2, (IInterface) lVar);
        a2.writeInt(i2);
        d.a(a2, z);
        a(9, a2);
    }

    public final void a(zai zai, c cVar) throws RemoteException {
        Parcel a2 = a();
        d.a(a2, (Parcelable) zai);
        d.a(a2, (IInterface) cVar);
        a(12, a2);
    }
}
