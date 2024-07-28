package com.google.firebase.appindexing.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.internal.icing.bh;
import com.google.android.gms.internal.icing.l;

public final class w extends l implements t {
    w(IBinder iBinder) {
        super(iBinder, "com.google.firebase.appindexing.internal.IAppIndexingService");
    }

    public final zzg a(h hVar, zzy zzy) throws RemoteException {
        Parcel a2 = a();
        bh.a(a2, (IInterface) hVar);
        bh.a(a2, (Parcelable) zzy);
        Parcel a3 = a(a2);
        zzg zzg = (zzg) bh.a(a3, zzg.CREATOR);
        a3.recycle();
        return zzg;
    }
}
