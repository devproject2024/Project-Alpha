package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class r implements Parcelable.Creator<StreetViewPanoramaCamera> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new StreetViewPanoramaCamera[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                f2 = a.j(parcel, readInt);
            } else if (i2 == 3) {
                f3 = a.j(parcel, readInt);
            } else if (i2 != 4) {
                a.b(parcel, readInt);
            } else {
                f4 = a.j(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new StreetViewPanoramaCamera(f2, f3, f4);
    }
}
