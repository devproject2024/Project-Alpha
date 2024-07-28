package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class v implements Parcelable.Creator<ActivityTransition> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ActivityTransition[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i4 != 2) {
                a.b(parcel, readInt);
            } else {
                i3 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new ActivityTransition(i2, i3);
    }
}
