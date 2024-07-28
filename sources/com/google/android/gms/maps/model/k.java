package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class k implements Parcelable.Creator<LatLng> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new LatLng[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                d2 = a.l(parcel, readInt);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                d3 = a.l(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new LatLng(d2, d3);
    }
}
