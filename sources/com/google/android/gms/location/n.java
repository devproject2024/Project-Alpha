package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class n implements Parcelable.Creator<zzae> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzae[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = "";
        String str2 = str;
        String str3 = str2;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str2 = a.n(parcel, readInt);
            } else if (i2 == 2) {
                str3 = a.n(parcel, readInt);
            } else if (i2 != 5) {
                a.b(parcel, readInt);
            } else {
                str = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzae(str, str2, str3);
    }
}
