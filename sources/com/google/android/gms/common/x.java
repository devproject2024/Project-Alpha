package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class x implements Parcelable.Creator<zzj> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzj[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = a.n(parcel, readInt);
            } else if (i2 == 2) {
                iBinder = a.o(parcel, readInt);
            } else if (i2 == 3) {
                z = a.c(parcel, readInt);
            } else if (i2 != 4) {
                a.b(parcel, readInt);
            } else {
                z2 = a.c(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzj(str, iBinder, z, z2);
    }
}
