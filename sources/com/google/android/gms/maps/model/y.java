package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class y implements Parcelable.Creator<TileOverlayOptions> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new TileOverlayOptions[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        IBinder iBinder = null;
        boolean z = false;
        float f2 = 0.0f;
        boolean z2 = true;
        float f3 = 0.0f;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                iBinder = a.o(parcel, readInt);
            } else if (i2 == 3) {
                z = a.c(parcel, readInt);
            } else if (i2 == 4) {
                f2 = a.j(parcel, readInt);
            } else if (i2 == 5) {
                z2 = a.c(parcel, readInt);
            } else if (i2 != 6) {
                a.b(parcel, readInt);
            } else {
                f3 = a.j(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new TileOverlayOptions(iBinder, z, f2, z2, f3);
    }
}
