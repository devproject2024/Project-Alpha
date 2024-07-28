package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.as;
import com.google.android.gms.internal.measurement.r;
import java.util.List;

public abstract class dp extends as implements dq {
    public dp() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final boolean a(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        switch (i2) {
            case 1:
                a((zzan) r.a(parcel, zzan.CREATOR), (zzm) r.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                a((zzkl) r.a(parcel, zzkl.CREATOR), (zzm) r.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                a((zzm) r.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                a((zzan) r.a(parcel, zzan.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                b((zzm) r.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzkl> a2 = a((zzm) r.a(parcel, zzm.CREATOR), r.a(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(a2);
                return true;
            case 9:
                byte[] a3 = a((zzan) r.a(parcel, zzan.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(a3);
                return true;
            case 10:
                a(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String c2 = c((zzm) r.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(c2);
                return true;
            case 12:
                a((zzv) r.a(parcel, zzv.CREATOR), (zzm) r.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                a((zzv) r.a(parcel, zzv.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzkl> a4 = a(parcel.readString(), parcel.readString(), r.a(parcel), (zzm) r.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(a4);
                return true;
            case 15:
                List<zzkl> a5 = a(parcel.readString(), parcel.readString(), parcel.readString(), r.a(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(a5);
                return true;
            case 16:
                List<zzv> a6 = a(parcel.readString(), parcel.readString(), (zzm) r.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(a6);
                return true;
            case 17:
                List<zzv> a7 = a(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(a7);
                return true;
            case 18:
                d((zzm) r.a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
