package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

public final class a implements Parcelable.Creator<UserAddressRequest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new UserAddressRequest[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        ArrayList<CountrySpecification> arrayList = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
            } else {
                arrayList = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt, CountrySpecification.CREATOR);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
        return new UserAddressRequest(arrayList);
    }
}
