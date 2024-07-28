package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.d.b;
import com.google.android.gms.internal.d.d;

public final class au extends b implements n {
    au(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final void a(int i2, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel c2 = c();
        c2.writeInt(i2);
        c2.writeStrongBinder(iBinder);
        d.a(c2, (Parcelable) bundle);
        b(1, c2);
    }

    public final void a(int i2, Bundle bundle) throws RemoteException {
        Parcel c2 = c();
        c2.writeInt(i2);
        d.a(c2, (Parcelable) bundle);
        b(2, c2);
    }

    public final void a(int i2, IBinder iBinder, zzc zzc) throws RemoteException {
        Parcel c2 = c();
        c2.writeInt(i2);
        c2.writeStrongBinder(iBinder);
        d.a(c2, (Parcelable) zzc);
        b(3, c2);
    }
}
