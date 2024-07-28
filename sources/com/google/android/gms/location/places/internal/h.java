package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class h implements Parcelable.Creator<zzau> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzau[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                str = a.n(parcel, readInt);
            } else if (i4 == 2) {
                str2 = a.n(parcel, readInt);
            } else if (i4 == 3) {
                str3 = a.n(parcel, readInt);
            } else if (i4 == 4) {
                str4 = a.n(parcel, readInt);
            } else if (i4 == 6) {
                i2 = a.e(parcel, readInt);
            } else if (i4 != 7) {
                a.b(parcel, readInt);
            } else {
                i3 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzau(str, str2, str3, str4, i2, i3);
    }
}
