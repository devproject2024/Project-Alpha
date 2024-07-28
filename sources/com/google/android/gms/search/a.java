package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<GoogleNowAuthState> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new GoogleNowAuthState[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        String str = null;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
            } else if (i2 == 2) {
                str2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
            } else if (i2 != 3) {
                com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
            } else {
                j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, readInt);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
        return new GoogleNowAuthState(str, str2, j);
    }
}
