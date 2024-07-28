package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class w implements Parcelable.Creator<Tile> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Tile[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        byte[] bArr = null;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 2) {
                i2 = a.e(parcel, readInt);
            } else if (i4 == 3) {
                i3 = a.e(parcel, readInt);
            } else if (i4 != 4) {
                a.b(parcel, readInt);
            } else {
                bArr = a.q(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new Tile(i2, i3, bArr);
    }
}
