package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class ie implements Parcelable.Creator<zzw> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzw[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i6 = 65535 & readInt;
            if (i6 == 2) {
                i2 = a.e(parcel, readInt);
            } else if (i6 == 3) {
                i3 = a.e(parcel, readInt);
            } else if (i6 == 4) {
                i4 = a.e(parcel, readInt);
            } else if (i6 == 5) {
                i5 = a.e(parcel, readInt);
            } else if (i6 != 6) {
                a.b(parcel, readInt);
            } else {
                f2 = a.j(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzw(i2, i3, i4, i5, f2);
    }
}
