package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<zab> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zab[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i2 = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
            } else if (i3 != 2) {
                com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
            } else {
                stringToIntConverter = (StringToIntConverter) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, StringToIntConverter.CREATOR);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
        return new zab(i2, stringToIntConverter);
    }
}
