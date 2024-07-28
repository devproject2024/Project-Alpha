package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.b.b;

/* renamed from: com.google.android.gms.internal.vision.if  reason: invalid class name */
public final class Cif extends u implements ig {
    Cif(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    public final zzac[] a(b bVar, zzp zzp, zzae zzae) throws RemoteException {
        Parcel a2 = a();
        as.a(a2, (IInterface) bVar);
        as.a(a2, (Parcelable) zzp);
        as.a(a2, (Parcelable) zzae);
        Parcel a3 = a(3, a2);
        zzac[] zzacArr = (zzac[]) a3.createTypedArray(zzac.CREATOR);
        a3.recycle();
        return zzacArr;
    }

    public final void b() throws RemoteException {
        b(2, a());
    }
}
