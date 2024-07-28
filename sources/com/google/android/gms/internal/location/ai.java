package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class ai implements Parcelable.Creator<zzo> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzo[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        zzm zzm = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i2 = 1;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i3 == 2) {
                zzm = (zzm) a.a(parcel, readInt, zzm.CREATOR);
            } else if (i3 == 3) {
                iBinder = a.o(parcel, readInt);
            } else if (i3 != 4) {
                a.b(parcel, readInt);
            } else {
                iBinder2 = a.o(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzo(i2, zzm, iBinder, iBinder2);
    }
}
