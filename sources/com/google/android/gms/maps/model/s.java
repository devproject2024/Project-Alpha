package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class s implements Parcelable.Creator<StreetViewPanoramaLink> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new StreetViewPanoramaLink[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        float f2 = 0.0f;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                str = a.n(parcel, readInt);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                f2 = a.j(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new StreetViewPanoramaLink(str, f2);
    }
}
