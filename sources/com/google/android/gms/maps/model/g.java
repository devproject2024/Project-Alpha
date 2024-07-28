package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class g implements Parcelable.Creator<Cap> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Cap[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        IBinder iBinder = null;
        int i2 = 0;
        Float f2 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 2) {
                i2 = a.e(parcel, readInt);
            } else if (i3 == 3) {
                iBinder = a.o(parcel, readInt);
            } else if (i3 != 4) {
                a.b(parcel, readInt);
            } else {
                f2 = a.k(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new Cap(i2, iBinder, f2);
    }
}
