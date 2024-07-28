package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<FavaDiagnosticsEntity> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new FavaDiagnosticsEntity[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i2 = 0;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
            } else if (i4 == 2) {
                str = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
            } else if (i4 != 3) {
                com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
            } else {
                i3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
        return new FavaDiagnosticsEntity(i2, str, i3);
    }
}
