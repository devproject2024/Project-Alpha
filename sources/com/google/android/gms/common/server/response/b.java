package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class b implements Parcelable.Creator<zal> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zal[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        int i2 = 0;
        FastJsonResponse.Field field = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i3 == 2) {
                str = a.n(parcel, readInt);
            } else if (i3 != 3) {
                a.b(parcel, readInt);
            } else {
                field = (FastJsonResponse.Field) a.a(parcel, readInt, FastJsonResponse.Field.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new zal(i2, str, field);
    }
}
