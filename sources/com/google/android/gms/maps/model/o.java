package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class o implements Parcelable.Creator<PointOfInterest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new PointOfInterest[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                latLng = (LatLng) a.a(parcel, readInt, LatLng.CREATOR);
            } else if (i2 == 3) {
                str = a.n(parcel, readInt);
            } else if (i2 != 4) {
                a.b(parcel, readInt);
            } else {
                str2 = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new PointOfInterest(latLng, str, str2);
    }
}
