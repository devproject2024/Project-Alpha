package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;

public final class p implements Parcelable.Creator<LocationSettingsResult> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationSettingsResult[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                status = (Status) a.a(parcel, readInt, Status.CREATOR);
            } else if (i2 != 2) {
                a.b(parcel, readInt);
            } else {
                locationSettingsStates = (LocationSettingsStates) a.a(parcel, readInt, LocationSettingsStates.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new LocationSettingsResult(status, locationSettingsStates);
    }
}
