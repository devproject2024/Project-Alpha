package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class zzc implements Parcelable.Creator<HarmfulAppsData> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new HarmfulAppsData[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        byte[] bArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 2) {
                str = a.n(parcel, readInt);
            } else if (i3 == 3) {
                bArr = a.q(parcel, readInt);
            } else if (i3 != 4) {
                a.b(parcel, readInt);
            } else {
                i2 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new HarmfulAppsData(str, bArr, i2);
    }
}
