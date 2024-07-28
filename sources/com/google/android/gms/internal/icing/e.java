package com.google.android.gms.internal.icing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.firebase.appindexing.internal.zza;

public final class e extends l implements b {
    e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
    }

    public final void a(d dVar, zza[] zzaArr) throws RemoteException {
        Parcel a2 = a();
        bh.a(a2, (IInterface) dVar);
        a2.writeTypedArray(zzaArr, 0);
        Parcel obtain = Parcel.obtain();
        try {
            this.f10262a.transact(7, a2, obtain, 0);
            obtain.readException();
        } finally {
            a2.recycle();
            obtain.recycle();
        }
    }
}
