package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class e implements Parcelable.Creator<SafeParcelResponse> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new SafeParcelResponse[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Parcel parcel2 = null;
        int i2 = 0;
        zaj zaj = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i3 == 2) {
                parcel2 = a.y(parcel, readInt);
            } else if (i3 != 3) {
                a.b(parcel, readInt);
            } else {
                zaj = (zaj) a.a(parcel, readInt, zaj.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new SafeParcelResponse(i2, parcel2, zaj);
    }
}
