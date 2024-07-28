package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.internal.base.b;
import com.google.android.gms.internal.base.d;

public final class ac extends b implements p {
    ac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final com.google.android.gms.b.b a(com.google.android.gms.b.b bVar, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel a2 = a();
        d.a(a2, (IInterface) bVar);
        d.a(a2, (Parcelable) signInButtonConfig);
        Parcel a3 = a(a2);
        com.google.android.gms.b.b a4 = b.a.a(a3.readStrongBinder());
        a3.recycle();
        return a4;
    }
}
