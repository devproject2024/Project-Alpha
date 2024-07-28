package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;

public final class l implements Parcelable.Creator<LocationResult> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationResult[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        List<Location> list = LocationResult.f11349a;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                a.b(parcel, readInt);
            } else {
                list = a.c(parcel, readInt, Location.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new LocationResult(list);
    }
}
