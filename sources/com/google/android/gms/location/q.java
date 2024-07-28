package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class q implements Parcelable.Creator<LocationSettingsStates> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationSettingsStates[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z = a.c(parcel, readInt);
                    break;
                case 2:
                    z2 = a.c(parcel, readInt);
                    break;
                case 3:
                    z3 = a.c(parcel, readInt);
                    break;
                case 4:
                    z4 = a.c(parcel, readInt);
                    break;
                case 5:
                    z5 = a.c(parcel, readInt);
                    break;
                case 6:
                    z6 = a.c(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new LocationSettingsStates(z, z2, z3, z4, z5, z6);
    }
}
