package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class j implements Parcelable.Creator<LatLngBounds> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new LatLngBounds[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                latLng = (LatLng) a.a(parcel, readInt, LatLng.CREATOR);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                latLng2 = (LatLng) a.a(parcel, readInt, LatLng.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new LatLngBounds(latLng, latLng2);
    }
}
