package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class t implements Parcelable.Creator<StreetViewPanoramaLocation> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new StreetViewPanoramaLocation[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        LatLng latLng = null;
        String str = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) a.b(parcel, readInt, StreetViewPanoramaLink.CREATOR);
            } else if (i2 == 3) {
                latLng = (LatLng) a.a(parcel, readInt, LatLng.CREATOR);
            } else if (i2 != 4) {
                a.b(parcel, readInt);
            } else {
                str = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new StreetViewPanoramaLocation(streetViewPanoramaLinkArr, latLng, str);
    }
}
