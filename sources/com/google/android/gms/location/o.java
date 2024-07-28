package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class o implements Parcelable.Creator<LocationSettingsRequest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationSettingsRequest[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        boolean z = false;
        ArrayList<LocationRequest> arrayList = null;
        zzae zzae = null;
        boolean z2 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                arrayList = a.c(parcel, readInt, LocationRequest.CREATOR);
            } else if (i2 == 2) {
                z = a.c(parcel, readInt);
            } else if (i2 == 3) {
                z2 = a.c(parcel, readInt);
            } else if (i2 != 5) {
                a.b(parcel, readInt);
            } else {
                zzae = (zzae) a.a(parcel, readInt, zzae.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new LocationSettingsRequest(arrayList, z, z2, zzae);
    }
}
