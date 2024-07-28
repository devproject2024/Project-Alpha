package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<CountrySpecification> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new CountrySpecification[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        String str = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
            } else {
                str = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
        return new CountrySpecification(str);
    }
}
