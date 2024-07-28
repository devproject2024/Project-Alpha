package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class s implements Parcelable.Creator<zzaj> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzaj[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        long j = -1;
        long j2 = -1;
        int i2 = 1;
        int i3 = 1;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i4 == 2) {
                i3 = a.e(parcel, readInt);
            } else if (i4 == 3) {
                j = a.g(parcel, readInt);
            } else if (i4 != 4) {
                a.b(parcel, readInt);
            } else {
                j2 = a.g(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzaj(i2, i3, j, j2);
    }
}
