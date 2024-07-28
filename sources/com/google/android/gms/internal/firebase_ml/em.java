package com.google.android.gms.internal.firebase_ml;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class em implements Parcelable.Creator<zzsb> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzsb[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i6 = 65535 & readInt;
            if (i6 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i6 == 2) {
                i3 = a.e(parcel, readInt);
            } else if (i6 == 3) {
                i4 = a.e(parcel, readInt);
            } else if (i6 == 4) {
                j = a.g(parcel, readInt);
            } else if (i6 != 5) {
                a.b(parcel, readInt);
            } else {
                i5 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzsb(i2, i3, i4, j, i5);
    }
}
