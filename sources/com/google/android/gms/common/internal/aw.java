package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.zzj;
import com.google.android.gms.internal.d.b;
import com.google.android.gms.internal.d.d;

public final class aw extends b implements av {
    aw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final boolean a(zzj zzj, com.google.android.gms.b.b bVar) throws RemoteException {
        Parcel c2 = c();
        d.a(c2, (Parcelable) zzj);
        d.a(c2, (IInterface) bVar);
        Parcel a2 = a(5, c2);
        boolean a3 = d.a(a2);
        a2.recycle();
        return a3;
    }
}
