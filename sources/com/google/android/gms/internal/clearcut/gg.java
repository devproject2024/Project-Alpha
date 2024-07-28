package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class gg extends z implements gf {
    public gg() {
        super("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2, Parcel parcel) throws RemoteException {
        switch (i2) {
            case 1:
                a((Status) ay.a(parcel, Status.CREATOR));
                return true;
            case 2:
                ay.a(parcel, Status.CREATOR);
                a();
                return true;
            case 3:
                ay.a(parcel, Status.CREATOR);
                parcel.readLong();
                b();
                return true;
            case 4:
                ay.a(parcel, Status.CREATOR);
                d();
                return true;
            case 5:
                ay.a(parcel, Status.CREATOR);
                parcel.readLong();
                e();
                return true;
            case 6:
                ay.a(parcel, Status.CREATOR);
                parcel.createTypedArray(zze.CREATOR);
                g();
                return true;
            case 7:
                ay.a(parcel, DataHolder.CREATOR);
                h();
                return true;
            case 8:
                ay.a(parcel, Status.CREATOR);
                ay.a(parcel, zzc.CREATOR);
                c();
                return true;
            case 9:
                ay.a(parcel, Status.CREATOR);
                ay.a(parcel, zzc.CREATOR);
                f();
                return true;
            default:
                return false;
        }
    }
}
