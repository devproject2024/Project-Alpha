package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zzi implements Parcelable.Creator<zzh> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzh[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 2) {
                i2 = a.e(parcel, readInt);
            } else if (i3 != 3) {
                a.b(parcel, readInt);
            } else {
                z = a.c(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzh(i2, z);
    }
}
